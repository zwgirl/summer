/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.jvmmodel.refactoring;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.eclipse.xtext.ui.refactoring.impl.DefaultDependentElementsCalculator;
import org.summer.dsl.xbase.jvmmodel.IJvmModelAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JvmModelDependentElementsCalculator extends DefaultDependentElementsCalculator {

	@Inject
	private IJvmModelAssociations jvmModelAssociations;

	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		List<URI> dependentElementURIs = super.getDependentElementURIs(baseElement, monitor);
		addURIsIfNotNull(dependentElementURIs, jvmModelAssociations.getJvmElements(baseElement));
		addJvmConstructorURIs(dependentElementURIs, baseElement);
		return dependentElementURIs;
	}

	protected void addURIsIfNotNull(List<URI> dependentElementURIs, Iterable<? extends EObject> dependentElements) {
		for (EObject dependentElement : dependentElements) {
			addJvmConstructorURIs(dependentElementURIs, dependentElement);
			URI elementURI = EcoreUtil.getURI(dependentElement);
			if (elementURI != null && !dependentElementURIs.contains(elementURI))
				dependentElementURIs.add(elementURI);
		}
	}
	
	protected void addJvmConstructorURIs(List<URI> dependentElementURIs, EObject baseElement) {
		if(baseElement instanceof JvmDeclaredType) {
			addURIsIfNotNull(dependentElementURIs, filter(((JvmDeclaredType) baseElement).getMembers(), JvmConstructor.class));
		}
	}
	
	protected IJvmModelAssociations getJvmModelAssociations() {
		return jvmModelAssociations;
	}
}
