/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.shared.internal;

import org.summer.dsl.builder.impl.IQueuedBuildDataContribution;
import org.summer.dsl.builder.impl.IToBeBuiltComputerContribution;
import org.summer.dsl.builder.impl.javasupport.JdtQueuedBuildData;
import org.summer.dsl.builder.impl.javasupport.JdtToBeBuiltComputer;
import org.summer.dsl.builder.impl.javasupport.JdtToBeBuiltComputer.ModificationStampCache;
import org.summer.dsl.builder.impl.javasupport.ProjectClasspathChangeListener;
import org.summer.dsl.builder.trace.IStorageAwareTraceContribution;
import org.summer.dsl.builder.trace.JarEntryAwareTrace;
import org.summer.dsl.model.types.access.jdt.TypeURIHelper;
import org.eclipse.xtext.generator.trace.TraceURIHelper;
import org.eclipse.xtext.ui.containers.JavaProjectsState;
import org.eclipse.xtext.ui.containers.JavaProjectsStateHelper;
import org.eclipse.xtext.ui.containers.StrictJavaProjectsState;
import org.eclipse.xtext.ui.generator.trace.ITraceURIConverterContribution;
import org.eclipse.xtext.ui.generator.trace.JavaProjectAwareTraceContribution;
import org.eclipse.xtext.ui.resource.IResourceSetInitializer;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperContribution;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperJdtExtensions;
import org.eclipse.xtext.ui.resource.JarEntryLocator;
import org.eclipse.xtext.ui.resource.JavaProjectResourceSetInitializer;
import org.eclipse.xtext.ui.resource.Storage2UriMapperJavaImpl;
import org.eclipse.xtext.ui.shared.contribution.IEagerContribution;

import com.google.inject.Binder;
import com.google.inject.Module;
import com.google.inject.Scopes;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class SharedContributionWithJDT implements Module {

	public void configure(Binder binder) {
		if (Activator.isJavaEnabled()) {
			binder.install(new Delegate());
		}
	}
	
	private static class Delegate implements Module {

		public void configure(Binder binder) {
			binder.bind(JarEntryLocator.class);
			
			binder.bind(ProjectClasspathChangeListener.class);
			
			binder.bind(JavaProjectsStateHelper.class);
			binder.bind(JavaProjectsState.class);
			binder.bind(StrictJavaProjectsState.class);
			
			binder.bind(IEagerContribution.class).to(JavaCoreListenerRegistrar.class);
			
			binder.bind(IStorage2UriMapperJdtExtensions.class).to(Storage2UriMapperJavaImpl.class);
			binder.bind(IStorage2UriMapperContribution.class).to(Storage2UriMapperJavaImpl.class);
			binder.bind(Storage2UriMapperJavaImpl.class).in(Scopes.SINGLETON);
			
			binder.bind(IStorageAwareTraceContribution.class).to(JarEntryAwareTrace.class);
			
			binder.bind(IResourceSetInitializer.class).to(JavaProjectResourceSetInitializer.class);
			
			binder.bind(IToBeBuiltComputerContribution.class).to(JdtToBeBuiltComputer.class);
			binder.bind(IQueuedBuildDataContribution.class).to(JdtQueuedBuildData.class);
			binder.bind(TypeURIHelper.class);
			binder.bind(ModificationStampCache.class);
			
			binder.bind(TraceURIHelper.class);
			binder.bind(ITraceURIConverterContribution.class).to(JavaProjectAwareTraceContribution.class);
		}
		
	}

}