/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.resource;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.descriptions.JvmTypesResourceDescriptionStrategy;
import org.eclipse.xtext.resource.IReferenceDescription;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;

import com.google.inject.Singleton;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
@Singleton
public class XbaseResourceDescriptionStrategy extends JvmTypesResourceDescriptionStrategy {
	
	@Override
	public boolean createReferenceDescriptions(EObject from, URI exportedContainerURI, IAcceptor<IReferenceDescription> acceptor) {
		if (from instanceof XAbstractFeatureCall && ((XAbstractFeatureCall) from).isPackageFragment())
			return false;
		return super.createReferenceDescriptions(from, exportedContainerURI, acceptor);
	}
}
