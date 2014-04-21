/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.smap;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.core.compiler.BuildContext;
import org.eclipse.jdt.core.compiler.CompilationParticipant;
import org.eclipse.jdt.internal.core.Region;
import org.summer.dsl.builder.EclipseOutputConfigurationProvider;
import org.summer.dsl.builder.trace.AbstractTrace;
import org.eclipse.xtext.generator.OutputConfiguration;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.ITraceToBytecodeInstaller;
import org.eclipse.xtext.generator.trace.TraceAsPrimarySourceInstaller;
import org.eclipse.xtext.generator.trace.TraceAsSmapInstaller;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.util.ResourceUtil;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.common.collect.Lists;
import com.google.common.io.ByteStreams;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Moritz Eysholdt
 */
public class DebugSourceInstallingCompilationParticipant extends CompilationParticipant {

	private static final Logger log = Logger.getLogger(DebugSourceInstallingCompilationParticipant.class);

	private List<BuildContext> files;

	@Inject
	private IResourceServiceProvider.Registry serviceProviderRegistry;

	@Inject
	private Provider<TraceAsSmapInstaller> traceAsSmapInstaller;

	@Inject
	private Provider<TraceAsPrimarySourceInstaller> traceAsPrimarySourceInstallerProvider;

	@Inject
	private ITraceForStorageProvider traceInformation;

	protected OutputConfiguration findOutputConfiguration(URI dslSourceFile, IFile generatedJavaFile) {
		IResourceServiceProvider serviceProvider = serviceProviderRegistry.getResourceServiceProvider(dslSourceFile);
		if (serviceProvider == null)
			return null;
		EclipseOutputConfigurationProvider cfgProvider = serviceProvider.get(EclipseOutputConfigurationProvider.class);
		IProject project = generatedJavaFile.getProject();
		Set<OutputConfiguration> configurations = cfgProvider.getOutputConfigurations(project);
		if (!configurations.isEmpty()) {
			if (configurations.size() == 1)
				return configurations.iterator().next();
			for (OutputConfiguration out : configurations) {
				IContainer container = ResourceUtil.getContainer(project, out.getOutputDirectory());
				if (container != null && container.getFullPath().isPrefixOf(generatedJavaFile.getFullPath()))
					return out;
			}
		}
		log.error("Could not find output configuration for file " + generatedJavaFile.getFullPath());
		return null;
	}

	protected ITraceToBytecodeInstaller getInstaller(OutputConfiguration config) {
		if (config.isInstallDslAsPrimarySource()) {
			TraceAsPrimarySourceInstaller installer = traceAsPrimarySourceInstallerProvider.get();
			installer.setHideSyntheticVariables(config.isHideSyntheticLocalVariables());
			return installer;
		} else {
			TraceAsSmapInstaller installer = traceAsSmapInstaller.get();
			return installer;
		}
	}

	@Override
	public void buildFinished(IJavaProject project) {
		StoppedTask task = Stopwatches.forTask("DebugSourceInstallingCompilationParticipant.install");
		try {
			task.start();
			super.buildFinished(project);
			if (files == null)
				return;
			for (BuildContext ctx : files) {
				try {
					IFile generatedJavaFile = ctx.getFile();

					// This may fail if there is no trace file.
					AbstractTraceRegion traceToSource = findRootTraceRegion(generatedJavaFile);
					if (traceToSource == null)
						continue;
					URI dslSourceFile = traceToSource.getAssociatedPath();

					// OutputConfigurations are only available for folders targeted by Xtext's code generation.
					OutputConfiguration outputConfiguration = findOutputConfiguration(dslSourceFile, generatedJavaFile);
					if (outputConfiguration == null)
						continue;

					IJavaElement element = JavaCore.create(generatedJavaFile);
					if (element == null)
						continue;

					ITraceToBytecodeInstaller installer = getInstaller(outputConfiguration);
					installer.setTrace(generatedJavaFile.getName(), traceToSource);
					for (IFile javaClassFile : findGeneratedJavaClassFiles(element)) {
						InputStream contents = javaClassFile.getContents();
						try {
							byte[] byteCode = installer.installTrace(ByteStreams.toByteArray(contents));
							javaClassFile.setContents(new ByteArrayInputStream(byteCode), 0, null);
						} finally {
							contents.close();
						}
					}
				} catch (Exception e) {
					String msg = "Could not process %s to install source information: %s";
					log.error(String.format(msg, ctx.getFile().getFullPath().toString(), e.getMessage()), e);
				}
			}
		} finally {
			files = null;
			task.stop();
		}
	}

	@Override
	public void buildStarting(BuildContext[] files, boolean isBatch) {
		super.buildStarting(files, isBatch);
		if (this.files != null)
			this.files.addAll(Arrays.asList(files));
		else
			this.files = Lists.newArrayList(files);
	}

	protected List<IFile> findGeneratedJavaClassFiles(IJavaElement element) {
		Region region = new Region();
		region.add(element);
		List<IFile> result = Lists.newLinkedList();
		for (IResource res : JavaCore.getGeneratedResources(region, false))
			if (res instanceof IFile)
				result.add((IFile) res);
		return result;
	}

	@SuppressWarnings("null")
	protected AbstractTraceRegion findRootTraceRegion(IFile javaFile) {
		ITrace traceToSource = traceInformation.getTraceToSource(javaFile);
		if (!(traceToSource instanceof AbstractTrace))
			return null;
		return ((AbstractTrace) traceToSource).getRootTraceRegion();
	}

	@Override
	public boolean isActive(IJavaProject project) {
		return XtextProjectHelper.hasNature(project.getProject());
	}

}
