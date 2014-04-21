/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation;

import static com.google.common.collect.Maps.*;

import java.util.Map;

import org.eclipse.emf.ecore.EReference;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.xbase.validation.EarlyExitValidator;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class SsEarlyExitValidator extends EarlyExitValidator {
		
	@Override
	protected Map<EReference,EarlyExitKind> getDisallowedEarlyExitReferences() {
		Map<EReference, EarlyExitKind> result = newHashMap();
		result.put(SsPackage.Literals.CREATE_EXTENSION_INFO__CREATE_EXPRESSION, EarlyExitKind.RETURN);
		result.putAll(super.getDisallowedEarlyExitReferences());
		return result;
	}
}
