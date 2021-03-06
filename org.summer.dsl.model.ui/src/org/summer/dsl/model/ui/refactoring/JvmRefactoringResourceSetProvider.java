/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ui.refactoring;

import org.eclipse.emf.ecore.resource.ResourceSet;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.eclipse.xtext.ui.refactoring.impl.RefactoringResourceSetProvider;

import com.google.inject.Inject;

/**
 * Configures the resource set used during refactoring for JVM type awareness.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmRefactoringResourceSetProvider extends RefactoringResourceSetProvider {

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Override
	protected void configure(ResourceSet resourceSet) {
		super.configure(resourceSet);
		typeProviderFactory.findOrCreateTypeProvider(resourceSet);
	}
}
