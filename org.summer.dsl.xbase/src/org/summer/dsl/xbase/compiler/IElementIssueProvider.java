/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.validation.Issue;

import com.google.inject.ImplementedBy;

/**
 * Allows to obtain all issues for a given element including its children.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IElementIssueProvider {
	
	Iterable<Issue> getIssues(EObject element);
	
	@ImplementedBy(ElementIssueProvider.Factory.class)
	interface Factory {
		IElementIssueProvider get(Resource reosurce);
	}
	
}
