/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.TypesFactory;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;

import com.google.common.base.Joiner;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XClosureImplCustom extends XClosureImpl {

	@Override
	public String toString() {
		String expressionAsString = Strings.emptyIfNull(expression == null ? null : expression.toString());
		if (isExplicitSyntax()) {
			return String.format("[%s | %s ]", Joiner.on(", ").join(getFormalParameters()), expressionAsString);
		} else {
			return String.format("[ %s ]", expressionAsString);
		}
	}
	
	@Override
	public EList<JvmFormalParameter> getFormalParameters() {
		EList<JvmFormalParameter> parameters = getDeclaredFormalParameters();
		if (expression != null && parameters.isEmpty() && !isExplicitSyntax()) {
			BasicEList<JvmFormalParameter> result = new BasicEList<JvmFormalParameter>(1);
			result.add(getImplicitParameter());
			return result;
		}
		return parameters;
	}

	/**
	 * Sets the closure's expression.
	 * ATTENTION! Also sets an implicit receiver if {@link #isExplicitSyntax()} wasn't set to true.
	 * This is based on the assumption that a closure is constructed by the xbase parser and that the syntax is such that
	 * the explicit parameter list is set before the expression is set.
	 * 
	 * Doing it like this is much simpler and also ensures proper notifications.
	 */
	@Override
	public void setExpression(XExpression newExpression) {
		super.setExpression(newExpression);
		/**
		 * Add the implicit parameter for the short cut syntax [ my-expression-using-it ]
		 */
		if (!isExplicitSyntax()) {
			JvmFormalParameter implicitParameter = TypesFactory.eINSTANCE.createJvmFormalParameter();
			implicitParameter.setName(IFeatureNames.IT.toString());
			super.setImplicitParameter(implicitParameter);
		}
	}
	
}
