/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource.containers;

import java.util.Collection;

import org.eclipse.emf.common.util.URI;

class ContainerState implements IContainerState {
	private final String root;
	private final IAllContainersState globalState;

	protected ContainerState(String root, IAllContainersState globalState) {
		this.root = root;
		this.globalState = globalState;
	}

	public Collection<URI> getContents() {
		return globalState.getContainedURIs(root);
	}

	public boolean contains(URI uri) {
		return getContents().contains(uri);
	}
	
	public boolean isEmpty() {
		return globalState.isEmpty(root);
	}
	
	@Override
	public String toString() {
		return "container '" + root +"' from "+globalState;
	}
}