/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.featurecalls;

import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XVariableDeclaration;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class IdentifiableSimpleNameProvider {
	
	public @Nullable String getSimpleName(JvmIdentifiableElement element) {
		if (element == null || element.eIsProxy()) {
			return null;
		}
		if (element instanceof JvmFeature) {
			return ((JvmFeature) element).getSimpleName();
		}
		if (element instanceof JvmFormalParameter) {
			return ((JvmFormalParameter) element).getName();
		}
		if (element instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) element).getName();
		}
		if (element instanceof XSwitchExpression) {
			final XSwitchExpression xSwitchExpression = (XSwitchExpression) element;
			String varName = xSwitchExpression.getLocalVarName();
			if (varName!=null)
				return varName;
			XExpression expression = xSwitchExpression.getSwitch();
			if (expression instanceof XFeatureCall) {
				return getSimpleName(((XFeatureCall) expression).getFeature());
			} else {
				return null;
			}
		}
		return element.getSimpleName();
	}
}
