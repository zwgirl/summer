/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.impl;

import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IStorage;
import org.eclipse.core.resources.IncrementalProjectBuilder;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.core.runtime.ProgressMonitorWrapper;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.summer.dsl.builder.IXtextBuilderParticipant.BuildType;
import org.summer.dsl.builder.builderState.IBuilderState;
import org.summer.dsl.builder.nature.XtextProjectHelper;
import org.eclipse.xtext.resource.IResourceDescription.Delta;
import org.eclipse.xtext.resource.ResourceSetFactory;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.util.internal.Stopwatches;
import org.eclipse.xtext.util.internal.Stopwatches.StoppedTask;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 * @author Knut Wannheden
 * @author Sebastian Zarnekow - BuildData as blackboard for scheduled data
 */
public class XtextBuilder extends IncrementalProjectBuilder {

	private static final Logger log = Logger.getLogger(XtextBuilder.class);

	public static final String BUILDER_ID = XtextProjectHelper.BUILDER_ID;

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject
	private RegistryBuilderParticipant participant;

	@Inject
	private QueuedBuildData queuedBuildData;

	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	@SuppressWarnings("rawtypes")
	@Override
	protected IProject[] build(int kind, Map args, IProgressMonitor monitor) throws CoreException {
		long startTime = System.currentTimeMillis();
		StoppedTask task = Stopwatches.forTask(String.format("XtextBuilder.build[%s]", getKindAsString(kind)));
		try {
			task.start();
			if (monitor != null) {
				final String taskName = Messages.XtextBuilder_Building + getProject().getName() + ": "; //$NON-NLS-1$
				monitor = new ProgressMonitorWrapper(monitor) {
					@Override
					public void subTask(String name) {
						super.subTask(taskName + name);
					}
				};
			}
			SubMonitor progress = SubMonitor.convert(monitor, 1);
			if (kind == FULL_BUILD) {
				fullBuild(progress.newChild(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
			} else {
				IResourceDelta delta = getDelta(getProject());
				if (delta == null || isOpened(delta)) {
					fullBuild(progress.newChild(1), IBuildFlag.RECOVERY_BUILD.isSet(args));
				} else {
					incrementalBuild(delta, progress.newChild(1));
				}
			}
		} catch (CoreException e) {
			log.error(e.getMessage(), e);
			throw e;
		} catch (OperationCanceledException e) {
			forgetLastBuiltState();
			throw e;
		} catch (Exception e) {
			log.error(e.getMessage(), e);
		} finally {
			if (monitor != null)
				monitor.done();
			log.info("Build " + getProject().getName() + " in " + (System.currentTimeMillis() - startTime) + " ms");
			task.stop();
		}
		return getProject().getReferencedProjects();
	}

	private String getKindAsString(int kind) {
		if (kind == FULL_BUILD) {
			return "FULL";
		}
		if (kind == CLEAN_BUILD) {
			return "CLEAN";
		}
		if (kind == INCREMENTAL_BUILD) {
			return "INCREMENTAL";
		}
		if (kind == AUTO_BUILD) {
			return "AUTO";
		}
		return "UNKOWN:" + kind;
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void incrementalBuild(IResourceDelta delta, final IProgressMonitor monitor) throws CoreException {
		final SubMonitor progress = SubMonitor.convert(monitor, Messages.XtextBuilder_CollectingResources, 10);
		progress.subTask(Messages.XtextBuilder_CollectingResources);
		
		if (queuedBuildData.needRebuild(getProject())) {
			needRebuild();
		}

		final ToBeBuilt toBeBuilt = new ToBeBuilt();
		IResourceDeltaVisitor visitor = new IResourceDeltaVisitor() {
			public boolean visit(IResourceDelta delta) throws CoreException {
				if (progress.isCanceled())
					throw new OperationCanceledException();
				if (delta.getResource() instanceof IProject) {
					return delta.getResource() == getProject();
				}
				if (delta.getResource() instanceof IStorage) {
					if (delta.getKind() == IResourceDelta.REMOVED) {
						return toBeBuiltComputer.removeStorage(null, toBeBuilt, (IStorage) delta.getResource());
					} else if (delta.getKind() == IResourceDelta.ADDED || delta.getKind() == IResourceDelta.CHANGED) {
						return toBeBuiltComputer.updateStorage(null, toBeBuilt, (IStorage) delta.getResource());
					}
				}
				return true;
			}
		};
		delta.accept(visitor);
		if (progress.isCanceled())
			throw new OperationCanceledException();
		progress.worked(2);
		doBuild(toBeBuilt, progress.newChild(8), BuildType.INCREMENTAL);
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void doBuild(ToBeBuilt toBeBuilt, IProgressMonitor monitor, BuildType type) throws CoreException {
		// return early if there's nothing to do.
		// we reuse the isEmpty() impl from BuildData assuming that it doesnT access the ResourceSet which is still null 
		// and would be expensive to create.
		if (new BuildData(getProject().getName(), null, toBeBuilt, queuedBuildData).isEmpty())
			return;
		
		SubMonitor progress = SubMonitor.convert(monitor, 2);
//		ResourceSet resourceSet = getResourceSetProvider().get(getProject());
//		resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
		//cym comment
//		if (resourceSet instanceof ResourceSetImpl) {
//			((ResourceSetImpl) resourceSet).setURIResourceMap(Maps.<URI, Resource> newHashMap());
//		}
		
//		BuildData buildData = new BuildData(getProject().getName(), resourceSet, toBeBuilt, queuedBuildData);
//		ImmutableList<Delta> deltas = builderState.update(buildData, progress.newChild(1));
//		if (participant != null) {
//			participant.build(new BuildContext(this, resourceSet, deltas, type),
//					progress.newChild(1));
//			getProject().getWorkspace().checkpoint(false);
//		} else {
//			progress.worked(1);
//		}
		
		ResourceSet resourceSet = ResourceSetFactory.getInstance().getResourceSet();
		BuildData buildData = new BuildData(getProject().getName(),resourceSet , toBeBuilt, queuedBuildData);
//		ImmutableList<Delta> deltas = builderState.update(buildData, progress.newChild(1));
		if (participant != null ) {
//			participant.build(new BuildContext(this,  toBeBuilt.getToBeUpdated(), type),
//					progress.newChild(1));
//			getProject().getWorkspace().checkpoint(false);
		} else {
			progress.worked(1);
		}
//		resourceSet.eSetDeliver(false);
//		resourceSet.getResources().clear();
//		resourceSet.eAdapters().clear();
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void fullBuild(final IProgressMonitor monitor, boolean isRecoveryBuild) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 10);

		IProject project = getProject();
		ToBeBuilt toBeBuilt = 
			isRecoveryBuild
				? toBeBuiltComputer.updateProjectNewResourcesOnly(project, progress.newChild(2)) 
				: toBeBuiltComputer.updateProject(project, progress.newChild(2));
		doBuild(toBeBuilt, progress.newChild(8), 
			isRecoveryBuild 
				? BuildType.RECOVERY 
				: BuildType.FULL);
	}

	protected boolean isOpened(IResourceDelta delta) {
		return delta.getResource() instanceof IProject 
				&& (delta.getFlags() & IResourceDelta.OPEN) != 0
				&& ((IProject) delta.getResource()).isOpen();
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the <em>implementors</em> responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	@Override
	protected void clean(IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 10);
		try {
			ToBeBuilt toBeBuilt = toBeBuiltComputer.removeProject(getProject(), progress.newChild(2));
			doClean(toBeBuilt, progress.newChild(8));
		} finally {
			if (monitor != null)
				monitor.done();
		}
	}

	/**
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	protected void doClean(ToBeBuilt toBeBuilt, IProgressMonitor monitor) throws CoreException {
		SubMonitor progress = SubMonitor.convert(monitor, 2);
		ImmutableList<Delta> deltas = builderState.clean(toBeBuilt.getToBeDeleted(), progress.newChild(1));
		if (participant != null) {
			participant.build(new BuildContext(this, 
					/*getResourceSetProvider().get(getProject()), */
					toBeBuilt.getToBeUpdated(),
					BuildType.CLEAN), 
					progress.newChild(1));
		} else {
			progress.worked(1);
		}
	}
	
}
