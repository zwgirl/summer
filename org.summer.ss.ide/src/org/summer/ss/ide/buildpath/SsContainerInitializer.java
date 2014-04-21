/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.buildpath;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IPath;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.eclipse.jdt.core.ClasspathContainerInitializer;
import org.eclipse.jdt.core.IClasspathContainer;
import org.eclipse.jdt.core.IJavaProject;
import org.eclipse.jdt.core.JavaCore;
import org.summer.ss.ide.internal.SsActivator;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class SsContainerInitializer extends ClasspathContainerInitializer {

	public static final Path XTEND_LIBRARY_PATH = new Path("org.eclipse.xtend.XTEND_CONTAINER"); //$NON-NLS-1$

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void initialize(final IPath containerPath, final IJavaProject project) throws CoreException {
		if (isXtendPath(containerPath)) {
			IClasspathContainer container = new SsClasspathContainer(containerPath);
			JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
					new IClasspathContainer[] { container }, null);
		}
	}

	/**
	 * Allows users to manually add source bundles
	 */
	@Override
	public boolean canUpdateClasspathContainer(IPath containerPath, IJavaProject project) {
		return true;
	}

	@Override
	public void requestClasspathContainerUpdate(final IPath containerPath, final IJavaProject project,
			final IClasspathContainer containerSuggestion) throws CoreException {
		super.requestClasspathContainerUpdate(containerPath, project, containerSuggestion);
		new Job("Classpath container update") { //$NON-NLS-1$
			@Override
			protected IStatus run(IProgressMonitor monitor) {
				try {
					JavaCore.setClasspathContainer(containerPath, new IJavaProject[] { project },
							new IClasspathContainer[] { containerSuggestion }, null);
				} catch (CoreException ex) {
					return new Status(IStatus.ERROR, SsActivator.getInstance().getBundle().getSymbolicName(), 0,
							"Classpath container update failed", ex); //$NON-NLS-1$
				}
				return Status.OK_STATUS;
			}
		}.schedule();
	}

	private boolean isXtendPath(final IPath containerPath) {
		return XTEND_LIBRARY_PATH.equals(containerPath);
	}

}
