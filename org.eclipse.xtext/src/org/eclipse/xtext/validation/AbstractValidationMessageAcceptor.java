/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

/**
 * Abstract base class for partial message acceptor implementations. Implements all methods as no-op.
 */
public abstract class AbstractValidationMessageAcceptor implements ValidationMessageAcceptor {
	
	public void acceptError(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
	}
	public void acceptError(String message, EObject object, int offset, int length, String code, String... issueData) {
	}
	public void acceptWarning(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
	}
	public void acceptWarning(String message, EObject object, int offset, int length, String code, String... issueData) {
	}
	public void acceptInfo(String message, EObject object, EStructuralFeature feature, int index, String code, String... issueData) {
	}
	public void acceptInfo(String message, EObject object, int offset, int length, String code, String... issueData) {
	}

}