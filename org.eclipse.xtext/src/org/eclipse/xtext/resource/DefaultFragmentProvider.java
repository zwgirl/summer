/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;

/**
 * TODO: think about an efficient way to compute fragments.
 * @author Sven Efftinge - Initial contribution and API
 * @author Peter Friese
 * @author Sebastian Zarnekow
 */
public class DefaultFragmentProvider implements IFragmentProvider {
	
	public String getFragment(EObject obj, IFragmentProvider.Fallback fallback) {
		return fallback.getFragment(obj);
	}

	public EObject getEObject(Resource resource, String fragment, IFragmentProvider.Fallback fallback) {
		return fallback.getEObject(fragment);
	}

}
