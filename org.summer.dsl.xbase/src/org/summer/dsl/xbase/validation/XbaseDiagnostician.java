/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EValidator;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.eclipse.xtext.validation.CancelableDiagnostician;
import org.summer.dsl.model.xbase.XClosure;

import com.google.common.annotations.Beta;
import com.google.inject.Inject;

/**
 * A customized diagnostician that explicitly traverses derived contained elements
 * if they are not contained in the contents of an EObject. This is for EMF 2.5 compatibility. 
 * 
 * @since 2.4
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Beta
public class XbaseDiagnostician extends CancelableDiagnostician {

	@Inject
	public XbaseDiagnostician(EValidator.Registry registry) {
		super(registry);
	}

	@Override
	protected boolean doValidateContents(EObject eObject, DiagnosticChain diagnostics, Map<Object, Object> context) {
		if (isCanceled(context))
			return true;
		if (eObject instanceof XClosure) {
			return doValidateLambdaContents((XClosure) eObject, diagnostics, context);
		}
		return super.doValidateContents(eObject, diagnostics, context);
	}

	/**
	 * Validates the implicit first parameter explicitly if it was not contained in {@link EObject#eContents()}.
	 */
	protected boolean doValidateLambdaContents(XClosure closure, DiagnosticChain diagnostics, Map<Object, Object> context) {
		JvmFormalParameter implicitParameter = closure.getImplicitParameter();
		boolean parameterVisited = implicitParameter == null;
		List<EObject> eContents = closure.eContents();
		if (!eContents.isEmpty()) {
			Iterator<EObject> i = eContents.iterator();
			EObject child = i.next();
			if (child != null && child == implicitParameter) {
				parameterVisited = true;
			}
			boolean result = validate(child, diagnostics, context);
			while (i.hasNext() && (result || diagnostics != null)) {
				child = i.next();
				if (child != null && child == implicitParameter) {
					parameterVisited = true;
				}
				result &= validate(child, diagnostics, context);
			}
			if (!parameterVisited) {
				result &= validate(implicitParameter, diagnostics, context);
			}
			return result;
		} else {
			if (!parameterVisited) {
				return validate(implicitParameter, diagnostics, context);
			}
			return true;
		}
	}

}
