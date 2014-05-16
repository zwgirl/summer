/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Sets.newHashSet;

import java.util.List;
import java.util.Set;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.JvmModelDependentElementsCalculator;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsDependentElementsCalculator extends JvmModelDependentElementsCalculator {

	@Inject
	private IXtendJvmAssociations associations;
	
	@Inject
	private DispatchRenameSupport dispatchRenameSupport;
	
	@Override
	public List<URI> getDependentElementURIs(EObject baseElement, IProgressMonitor monitor) {
		if (baseElement instanceof JvmOperation /*&& ((JvmOperation) baseElement).isDispatch()*/) {
			Set<URI> result = newHashSet();
			for(JvmOperation dispatchOperation: dispatchRenameSupport.getAllDispatchOperations((JvmOperation) baseElement)) {
				result.add(EcoreUtil2.getPlatformResourceOrNormalizedURI(dispatchOperation));
				JvmOperation xtendFunction = associations.getXtendFunction(dispatchOperation);
				if(xtendFunction != null) {
					result.add(EcoreUtil2.getPlatformResourceOrNormalizedURI(xtendFunction));
				}
			}
			return newArrayList(result);
		}
		return super.getDependentElementURIs(baseElement, monitor);
	}

}
