/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.resource.DerivedStateAwareResource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.Issue;
import org.eclipse.xtext.validation.ResourceValidatorImpl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class DerivedStateAwareResourceValidator extends ResourceValidatorImpl {

	@Override
	protected void validate(Resource resource, CheckMode mode, CancelIndicator monitor, IAcceptor<Issue> acceptor) {
		if (monitor.isCanceled())
			return;
		if (resource instanceof DerivedStateAwareResource) {
			List<EObject> contents = resource.getContents();
			if (!contents.isEmpty()) {
				validate(resource, contents.get(0), mode, monitor, acceptor);
			}
		} else {
			super.validate(resource, mode, monitor, acceptor);
		}
	}

}
