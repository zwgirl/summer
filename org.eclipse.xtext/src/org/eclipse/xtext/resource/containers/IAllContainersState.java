/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.resource.IResourceDescriptions;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IAllContainersState {

	boolean isEmpty(String containerHandle);
	
	List<String> getVisibleContainerHandles(String handle);

	Collection<URI> getContainedURIs(String containerHandle);

	String getContainerHandle(URI uri);
	
	interface Provider {
		IAllContainersState get(IResourceDescriptions context);
	}

}
