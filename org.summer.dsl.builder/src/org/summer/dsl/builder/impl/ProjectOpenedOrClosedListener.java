/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IProject;
import org.eclipse.core.resources.IResourceChangeEvent;
import org.eclipse.core.resources.IResourceChangeListener;
import org.eclipse.core.resources.IResourceDelta;
import org.eclipse.core.resources.IResourceDeltaVisitor;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.resources.IWorkspaceRoot;
import org.eclipse.core.resources.ResourcesPlugin;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.NullProgressMonitor;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.SubMonitor;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.ui.actions.WorkspaceModifyOperation;
import org.summer.dsl.builder.builderState.IBuilderState;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.ui.XtextProjectHelper;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Holger Schill
 */
public class ProjectOpenedOrClosedListener implements IResourceChangeListener {

	private final static Logger log = Logger.getLogger(ProjectOpenedOrClosedListener.class);

	@Inject
	private ToBeBuiltComputer toBeBuiltComputer;

	@Inject
	private IBuilderState builderState;

	@Inject
	private IResourceSetProvider resourceSetProvider;

	@Inject 
	private BuildScheduler buildScheduler;
	
	@Inject
	private QueuedBuildData queuedBuildData;
	
	public IResourceSetProvider getResourceSetProvider() {
		return resourceSetProvider;
	}

	public ToBeBuiltComputer getToBeBuiltComputer() {
		return toBeBuiltComputer;
	}

	public IBuilderState getBuilderState() {
		return builderState;
	}

	@Inject
	private IWorkspace workspace;

	public void resourceChanged(final IResourceChangeEvent event) {
		if (workspace != null && workspace.isAutoBuilding()) {
			if (event.getType() == IResourceChangeEvent.POST_CHANGE) {
				try {
					final Set<IProject> toUpdate = Sets.newLinkedHashSet();
					event.getDelta().accept(new IResourceDeltaVisitor() {
						public boolean visit(IResourceDelta delta) throws CoreException {
							if (delta.getResource() instanceof IWorkspaceRoot)
								return true;
							if (delta.getResource() instanceof IProject) {
								IProject project = (IProject) delta.getResource();
								if ((delta.getFlags() & IResourceDelta.OPEN) != 0 && project.isOpen()) {
									toUpdate.add(project);
								}
								if ((delta.getKind() & IResourceDelta.CHANGED) != 0 && project.isOpen()) {
									if ((delta.getFlags() & IResourceDelta.DESCRIPTION) != 0) {	
										if ((delta.findMember(new Path(".project")) != null)  
												&& XtextProjectHelper.hasNature(project) && XtextProjectHelper.hasBuilder(project))
											toUpdate.add(project);
										else if(!XtextProjectHelper.hasNature(project)){
											scheduleRemoveProjectJob(project);
										}
									}
								}
							}
							return false;
						}
					});
					buildScheduler.scheduleBuildIfNecessary(toUpdate);
				} catch (CoreException e) {
					log.error(e.getMessage(), e);
				}
			} else if ((event.getType() == IResourceChangeEvent.PRE_CLOSE || event.getType() == IResourceChangeEvent.PRE_DELETE)) {
				if (event.getResource() instanceof IProject && 
						(XtextProjectHelper.hasNature((IProject) event.getResource()) || 
								event.getResource().isAccessible() && event.getResource().isHidden())) {
					scheduleRemoveProjectJob((IProject) event.getResource());
				}
			}
		}
	}

	protected void scheduleRemoveProjectJob(final IProject project) {
		final ToBeBuilt toBeBuilt = getToBeBuiltComputer().removeProject(project, new NullProgressMonitor());
		if (toBeBuilt.getToBeDeleted().isEmpty() && toBeBuilt.getToBeUpdated().isEmpty())
			return;
		new Job(Messages.ProjectOpenedOrClosedListener_RemovingProject + project.getName() + Messages.ProjectOpenedOrClosedListener_FromIndex) {
			{
				setRule(workspace.getRoot());
			}

			@Override
			public boolean belongsTo(Object family) {
				return family == ResourcesPlugin.FAMILY_AUTO_BUILD;
			}

			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					new WorkspaceModifyOperation(getRule()) {
						@Override
						protected void execute(IProgressMonitor monitor) throws CoreException,
								InvocationTargetException, InterruptedException {
							SubMonitor progress = SubMonitor.convert(monitor, 1);
							try {
								ResourceSet resourceSet = getResourceSetProvider().get(project);
								resourceSet.getLoadOptions().put(ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE, Boolean.TRUE);
								if (resourceSet instanceof ResourceSetImpl) {
									((ResourceSetImpl) resourceSet).setURIResourceMap(Maps.<URI, Resource> newHashMap());
								}
								BuildData buildData = new BuildData(project.getName(), resourceSet, toBeBuilt, queuedBuildData);
								getBuilderState().update(buildData,	progress.newChild(1));
								
								resourceSet.getResources().clear();
								resourceSet.eAdapters().clear();
							} finally {
								if (monitor != null)
									monitor.done();
							}
						}
					}.run(monitor);
				} catch (InvocationTargetException e) {
					log.error(e.getMessage(), e);
				} catch (InterruptedException e) {
					log.error(e.getMessage(), e);
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

}
