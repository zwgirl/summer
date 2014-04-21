/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.generator;

import java.util.List;

import org.eclipse.core.resources.IContainer;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IMarker;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Sven Efftinge
 * @since 2.3
 * 
 */
public interface IDerivedResourceMarkers {

	boolean installMarker(IFile file, String source) throws CoreException;

	/**
	 * @return the 'source' attribute of the given marker
	 */
	String getSource(IMarker marker);

	/**
	 * finds a single derived resource marker for the given file, corresponding to the given source.
	 * @return the first found marker in the given file with the given source attribute or <code>null</code> if no such marker could be found.
	 */
	IMarker findDerivedResourceMarker(IFile file, String source) throws CoreException;

	/**
	 * Find all derived resource marker for the given resource and its children (if existent).
	 * @return the generator markers or an empty array if none.
	 */
	IMarker[] findDerivedResourceMarkers(IResource file) throws CoreException;
	
	/**
	 * Find all derived resource marker for the given resource and its children (if existent), which were installed for the given generatorId.
	 * @return the generator markers or an empty {@link Iterable} if none.
	 */
	Iterable<IMarker> findDerivedResourceMarkers(IResource file, String generatorId) throws CoreException;

	List<IFile> findDerivedResources(IContainer container, String source) throws CoreException;
	
}
