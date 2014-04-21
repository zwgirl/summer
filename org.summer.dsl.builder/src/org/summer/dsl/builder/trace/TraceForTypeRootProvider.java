/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.trace;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.core.ICompilationUnit;
import org.eclipse.jdt.core.IJavaElement;
import org.eclipse.jdt.core.IPackageFragmentRoot;
import org.eclipse.jdt.core.IType;
import org.eclipse.jdt.core.ITypeRoot;
import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.internal.core.BinaryType;
import org.eclipse.jdt.internal.core.JarPackageFragmentRoot;
import org.eclipse.xtext.generator.trace.AbstractTraceRegion;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.ITraceRegionProvider;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.Singleton;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 * @noextend This class is not intended to be subclassed by clients.
 * @noinstantiate This class is not intended to be instantiated by clients.
 */
@Singleton
@NonNullByDefault
public class TraceForTypeRootProvider implements ITraceForTypeRootProvider {

	private static final Logger log = Logger.getLogger(TraceForTypeRootProvider.class);

	@Inject
	private TraceRegionSerializer traceRegionSerializer;

	@Inject
	private Provider<ZipFileAwareTrace> zipFileAwareTraceProvider;

	@Inject
	private Provider<FolderAwareTrace> folderAwareTraceProvider;

	@Inject
	private TraceFileNameProvider traceFileNameProvider;

	@Inject
	private ITraceForStorageProvider traceForStorageProvider;

	private Pair<ITypeRoot, ITrace> lruCache = null;

	protected String getPathInFragmentRoot(final ITypeRoot derivedResource) {
		return derivedResource.getParent().getElementName().replace('.', '/') + "/";
	}

	protected String getTraceSimpleFileName(final ITypeRoot derivedResource) {
		IType type = derivedResource.findPrimaryType();
		if (type == null)
			return null;
		String sourceName = ((BinaryType) type).getSourceFileName(null);
		if (sourceName == null)
			return null;

		// the primary source in the .class file is .java (JSR-45 aka SMAP scenario)
		if (sourceName.endsWith(".java")) {
			return traceFileNameProvider.getTraceFromJava(sourceName);
		}

		// xtend-as-primary-source-scenario.
		if (sourceName.endsWith(".xtend")) {
			String name = type.getElementName();
			int index = name.indexOf("$");
			if (index > 0)
				name = name.substring(0, index);
			return traceFileNameProvider.getTraceFromJava(name + ".java");
		}
		return null;
	}

	protected IPath getSourcePath(final ITypeRoot derivedJavaType) {
		IJavaElement current = derivedJavaType.getParent();
		while (current != null) {
			if (current instanceof IPackageFragmentRoot) {
				IPackageFragmentRoot fragmentRoot = (IPackageFragmentRoot) current;
				try {
					IPath attachmentPath = fragmentRoot.getSourceAttachmentPath();
					if (attachmentPath != null)
						return attachmentPath;
				} catch (JavaModelException e) {
				}
				if (current instanceof JarPackageFragmentRoot)
					return fragmentRoot.getPath();

			}
			current = current.getParent();
		}
		return null;
	}

	protected boolean isZipFile(IPath path) {
		if (path.getFileExtension() == null)
			return false;
		String ext = path.getFileExtension().toLowerCase();
		return "jar".equalsIgnoreCase(ext) || "zip".equalsIgnoreCase(ext);
	}

	@Nullable
	public ITrace getTraceToSource(final ITypeRoot derivedJavaType) {
		if (lruCache != null && lruCache.getFirst().equals(derivedJavaType))
			return lruCache.getSecond();
		ITrace trace = createTraceToSource(derivedJavaType);
		lruCache = Tuples.<ITypeRoot, ITrace> create(derivedJavaType, trace);
		return trace;
	}

	private ITrace createTraceToSource(final ITypeRoot derivedJavaType) {
		if (derivedJavaType instanceof IClassFile)
			return getTraceToSource((IClassFile) derivedJavaType);
		if (derivedJavaType instanceof ICompilationUnit)
			return getTraceToSource((ICompilationUnit) derivedJavaType);
		throw new IllegalStateException("Unknown type " + derivedJavaType);
	}

	@Nullable
	public ITrace getTraceToSource(final ICompilationUnit javaFile) {
		try {
			IResource resource = javaFile.getUnderlyingResource();
			if (resource instanceof IStorage)
				return traceForStorageProvider.getTraceToSource((IStorage) resource);
		} catch (JavaModelException e) {
			log.error(e);
		}
		return null;
	}

	@Nullable
	public ITrace getTraceToSource(final IClassFile classFile) {
		IPath sourcePath = getSourcePath(classFile);
		if (sourcePath == null)
			return null;
		IProject project = classFile.getJavaProject().getProject();
		AbstractTrace trace1;
		if (isZipFile(sourcePath)) {
			ZipFileAwareTrace zipFileAwareTrace = zipFileAwareTraceProvider.get();
			zipFileAwareTrace.setProject(project);
			zipFileAwareTrace.setZipFilePath(sourcePath);
			trace1 = zipFileAwareTrace;
		} else {
			FolderAwareTrace folderAwareTrace = folderAwareTraceProvider.get();
			folderAwareTrace.setProject(project);
			folderAwareTrace.setRootFolder(sourcePath.toString());
			trace1 = folderAwareTrace;
		}
		final AbstractTrace result = trace1;
		result.setTraceRegionProvider(new ITraceRegionProvider() {
			public AbstractTraceRegion getTraceRegion() {
				String traceSimpleFileName = getTraceSimpleFileName(classFile);
				if (traceSimpleFileName == null)
					return null;
				String pathInFragmentRoot = getPathInFragmentRoot(classFile);
				URI traceURI = URI.createURI(pathInFragmentRoot + traceSimpleFileName);
				try {
					InputStream contents = result.getContents(traceURI, result.getLocalProject());
					if (contents != null)
						try {
							return traceRegionSerializer.readTraceRegionFrom(contents);
						} finally {
							contents.close();
						}
				} catch (CoreException e) {
					log.error(e);
				} catch (IOException e) {
					log.error(e);
				}
				return null;
			}
		});
		return result;
	}
}
