/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.builder.builderState;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.resource.IResourceDescription.Delta;

import com.google.inject.ImplementedBy;

/**
 * Strategy that creates, updates or deletes markers for {@link IResource resources} that were
 * processed during a build.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@ImplementedBy(MarkerUpdaterImpl.class)
public interface IMarkerUpdater {
	/**
	 * Deletes or updates the {@link org.eclipse.core.resources.IMarker markers} for the given resource delta.
	 * 
	 * @param delta information about the changed resource. Never <code>null</code>.
	 * @param resourceSet context resource set from which the updated resource may be obtained; may be {@code null}
	 *        if the delta represents a resource deletion.
	 * @param monitor the progress monitor to use for reporting progress to the user. It is the caller's responsibility
	 *        to call done() on the given monitor. Accepts null, indicating that no progress should be
	 *        reported and that the operation cannot be cancelled.
	 */
	public void updateMarkers(Delta delta, @Nullable ResourceSet resourceSet, IProgressMonitor monitor);
}
