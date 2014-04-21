/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xbase.impl;

import org.eclipse.emf.common.util.BasicEList;
import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.xbase.XExpression;


/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XBinaryOperationImplCustom extends XBinaryOperationImpl {
	
	@Override
	public String toString() {
		return getExpressionAsString(getLeftOperand())+" "+getConcreteSyntaxFeatureName()+" "+getExpressionAsString(getRightOperand());
	}
	
	@Override
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		if (getLeftOperand()!=null)
			result.add(getLeftOperand());
		if (getRightOperand()!=null)
			result.add(getRightOperand());
		return result;
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		return getActualArguments(getLeftOperand(), getRightOperand());
	}
	
	@Override
	public XExpression getActualReceiver() {
		return getActualReceiver(getLeftOperand());
	}
	
	@Override
	public boolean isExtension() {
		return isExtension(getLeftOperand());
	}
	
}
