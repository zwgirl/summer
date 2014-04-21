/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.shared.internal;

import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.PlatformUI;
import org.summer.dsl.builder.builderState.IBuilderState;
import org.summer.dsl.builder.builderState.IMarkerUpdater;
import org.summer.dsl.builder.builderState.PersistedStateProvider;
import org.summer.dsl.builder.clustering.ClusteringBuilderState;
import org.summer.dsl.builder.clustering.IResourceClusteringPolicy;
import org.summer.dsl.builder.impl.BuildScheduler;
import org.summer.dsl.builder.impl.DirtyStateAwareResourceDescriptions;
import org.summer.dsl.builder.impl.QueuedBuildData;
import org.summer.dsl.builder.impl.RegistryBuilderParticipant;
import org.summer.dsl.builder.impl.ToBeBuiltComputer;
import org.summer.dsl.builder.impl.XtextBuilder;
import org.summer.dsl.builder.resourceloader.IResourceLoader;
import org.summer.dsl.builder.resourceloader.ResourceLoaderProviders;
import org.summer.dsl.builder.trace.StorageAwareTrace;
import org.summer.dsl.builder.trace.TraceForStorageProvider;
import org.summer.dsl.builder.trace.TraceMarkers;
import org.eclipse.xtext.generator.trace.DefaultTraceURIConverter;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.generator.trace.TraceFileNameProvider;
import org.eclipse.xtext.generator.trace.TraceRegionSerializer;
import org.eclipse.xtext.resource.CompilerPhases;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.IResourceServiceProvider;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.ui.containers.WorkspaceProjectsStateHelper;
import org.eclipse.xtext.ui.editor.DirtyStateManager;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchResultContentProvider;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchResultLabelProvider;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchViewPage;
import org.eclipse.xtext.ui.editor.findrefs.ReferenceSearchViewSorter;
import org.eclipse.xtext.ui.generator.trace.ExtensibleTraceURIConverter;
import org.eclipse.xtext.ui.label.GlobalDescriptionLabelProvider;
import org.eclipse.xtext.ui.notification.IStateChangeEventBroker;
import org.eclipse.xtext.ui.notification.StateChangeEventBroker;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.IStorage2UriMapper;
import org.eclipse.xtext.ui.resource.IStorage2UriMapperExtension;
import org.eclipse.xtext.ui.resource.Storage2UriMapperImpl;
import org.eclipse.xtext.ui.resource.UriValidator;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.search.IXtextEObjectSearch;
import org.eclipse.xtext.ui.search.OpenXtextElementHandler;
import org.summer.dsl.ui.shared.JdtHelper;
import org.eclipse.xtext.ui.shared.contribution.ISharedStateContributionRegistry;
import org.eclipse.xtext.ui.util.IJdtHelper;
import org.osgi.framework.BundleContext;

import com.google.inject.AbstractModule;
import com.google.inject.PrivateModule;
import com.google.inject.Provider;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SharedModule extends AbstractModule {

	private BundleContext context;

	public SharedModule(BundleContext context) {
		this.context = context;
	}

	@Override
	protected void configure() {
		// TODO enable for 2.6 - https://bugs.eclipse.org/bugs/show_bug.cgi?id=423184
//		binder().requireExplicitBindings();
		if (context != null)
			bind(BundleContext.class).toInstance(context);
		
		bind(IBuilderState.class).to(ClusteringBuilderState.class).in(Scopes.SINGLETON);
		bind(IResourceDescriptions.class).to(DirtyStateAwareResourceDescriptions.class).in(Scopes.SINGLETON);
		bind(IResourceServiceProvider.Registry.class).toInstance(IResourceServiceProvider.Registry.INSTANCE);
		binder().install(new PrivateModule() {
			@Override
			protected void configure() {
				bind(IResourceSetProvider.class).to(XtextResourceSetProvider.class);
				bind(XtextResourceSet.class);
				expose(IResourceSetProvider.class);
			}
		});
		
		bind(IExtensionRegistry.class).toInstance(Platform.getExtensionRegistry());
		bind(BuildScheduler.class);
		bind(ToBeBuiltComputer.class);

		bind(IExternalContentSupport.IExternalContentProvider.class).to(IDirtyStateManager.class).in(Scopes.SINGLETON);
		bind(IDirtyStateManager.class).to(DirtyStateManager.class).in(Scopes.SINGLETON);
		bind(IStateChangeEventBroker.class).to(StateChangeEventBroker.class).in(Scopes.SINGLETON);

		bind(IncrementalProjectBuilder.class).to(XtextBuilder.class);
		bind(IStorage2UriMapper.class).to(IStorage2UriMapperExtension.class);
		bind(IStorage2UriMapperExtension.class).to(Storage2UriMapperImpl.class).in(Scopes.SINGLETON);
		
		binder().install(new PrivateModule() {
			
			@Override
			protected void configure() {
				bind(ITraceForStorageProvider.class).to(TraceForStorageProvider.class);
				bind(ITraceURIConverter.class).to(DefaultTraceURIConverter.class);
				bind(DefaultTraceURIConverter.class).to(ExtensibleTraceURIConverter.class);
				
				bind(TraceFileNameProvider.class);
				bind(TraceMarkers.class);
				bind(TraceRegionSerializer.class);
				bind(StorageAwareTrace.class);
				
				expose(ITraceURIConverter.class);
				expose(TraceFileNameProvider.class);
				expose(ITraceForStorageProvider.class);
				expose(StorageAwareTrace.class);
			}
		});
		

		bind(IWorkbench.class).toProvider(new Provider<IWorkbench>() {
			public IWorkbench get() {
				if (PlatformUI.isWorkbenchRunning())
					return PlatformUI.getWorkbench();
				return null;
			}
		});

		bind(IWorkspace.class).toProvider(new Provider<IWorkspace>() {
			public IWorkspace get() {
				return ResourcesPlugin.getWorkspace();
			}
		});

		bind(IJdtHelper.class).to(JdtHelper.class).asEagerSingleton();
		bind(WorkspaceProjectsStateHelper.class);
		bind(QueuedBuildData.class);
		bind(UriValidator.class);
		bind(ISharedStateContributionRegistry.class).to(SharedStateContributionRegistryImpl.class);

		boolean parallel = false;
		if (parallel) {
			bind(IResourceLoader.class).toProvider(ResourceLoaderProviders.getParallelLoader());

			bind(IResourceLoader.class).annotatedWith(
					Names.named(ClusteringBuilderState.RESOURCELOADER_GLOBAL_INDEX)).toProvider(
					ResourceLoaderProviders.getParallelLoader());

			bind(IResourceLoader.class).annotatedWith(Names.named(ClusteringBuilderState.RESOURCELOADER_CROSS_LINKING))
					.toProvider(ResourceLoaderProviders.getParallelLoader());
		} else {
			bind(IResourceLoader.class).toProvider(ResourceLoaderProviders.getSerialLoader());

			bind(IResourceLoader.class).annotatedWith(
					Names.named(ClusteringBuilderState.RESOURCELOADER_GLOBAL_INDEX)).toProvider(
					ResourceLoaderProviders.getSerialLoader());

			bind(IResourceLoader.class).annotatedWith(Names.named(ClusteringBuilderState.RESOURCELOADER_CROSS_LINKING))
					.toProvider(ResourceLoaderProviders.getSerialLoader());
		}
		
		bind(IMarkerUpdater.class);
		bind(PersistedStateProvider.class);
		bind(IResourceClusteringPolicy.class);
		bind(CompilerPhases.class);
		bind(RegistryBuilderParticipant.class);
		bind(IResourceLoader.Sorter.class);
		bind(IURIEditorOpener.class);
		bind(OpenXtextElementHandler.class);
		bind(GlobalDescriptionLabelProvider.class);
		bind(IXtextEObjectSearch.class);
		
		binder().install(new PrivateModule() {
			@Override
			protected void configure() {
				bind(ReferenceSearchViewPage.class);
				bind(ReferenceSearchResultLabelProvider.class);
				bind(ReferenceSearchResultContentProvider.class);
				bind(ReferenceSearchViewSorter.class);
				
				expose(ReferenceSearchViewPage.class);
			}
		});
	}

}
