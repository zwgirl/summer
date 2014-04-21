/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.summer.dsl.model.types.access.impl.IndexedJvmTypeAccess;
import org.summer.dsl.model.types.access.impl.URIHelperConstants;

import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeProviderFactory implements IJvmTypeProvider.Factory {

	@Inject(optional = true)
	private IndexedJvmTypeAccess indexedJvmTypeAccess;
	
	public IJvmTypeProvider findTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		return (IJvmTypeProvider) resourceSet.getResourceFactoryRegistry().getProtocolToFactoryMap().get(URIHelperConstants.PROTOCOL);
	}

	public IJvmTypeProvider createTypeProvider() {
		return createTypeProvider(new ResourceSetImpl());
	}
	
	public IJvmTypeProvider findOrCreateTypeProvider(ResourceSet resourceSet) {
		if (resourceSet == null)
			throw new IllegalArgumentException("resourceSet may not be null.");
		IJvmTypeProvider result = findTypeProvider(resourceSet);
		if (result != null)
			return result;
		return createTypeProvider(resourceSet);
	}
	
	protected IndexedJvmTypeAccess getIndexedJvmTypeAccess() {
		return indexedJvmTypeAccess;
	}

}
