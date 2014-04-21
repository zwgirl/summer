/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.jvmmodel.refactoring;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;
import org.summer.dsl.xbase.ui.refactoring.XbaseRenameStrategy;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class DefaultJvmModelRenameStrategy extends XbaseRenameStrategy {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	public void applyDeclarationChange(String newName, ResourceSet resourceSet) {
		super.applyDeclarationChange(newName, resourceSet);
		setInferredJvmElementName(newName, resourceSet);
	}

	@Override
	public void revertDeclarationChange(ResourceSet resourceSet) {
		super.revertDeclarationChange(resourceSet);
		setInferredJvmElementName(getOriginalName(), resourceSet);
	}

	protected void setInferredJvmElementName(String newName, ResourceSet resourceSet) {
		EObject renamedElement = resourceSet.getEObject(getTargetElementNewURI(), false);
		setInferredJvmElementName(newName, renamedElement);
	}

	protected void setInferredJvmElementName(String name, EObject renamedElement) {
		// This only works if the elements keep their EObject fragment on rename.
		// 
		// In case you modified the IFragmentProvider or if you did something bad in 
		// createDeclarationChange, you must implement this method without discarding 
		// the inferred model.
		if (renamedElement.eResource() instanceof DerivedStateAwareResource) {
			DerivedStateAwareResource resource = (DerivedStateAwareResource) renamedElement.eResource();
			resource.discardDerivedState();
			resource.installDerivedState(false);
		}
	}
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
	
}
