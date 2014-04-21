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
public class XFeatureCallImplCustom extends XFeatureCallImpl {
	
	@Override
	public String toString() {
		return getConcreteSyntaxFeatureName()+getExpressionsAsString(getFeatureCallArguments(),isExplicitOperationCall());
	}
	
	@Override
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		result.addAll(getFeatureCallArguments());
		return result;
	}
	
	@Override
	public boolean isExplicitOperationCallOrBuilderSyntax() {
		return super.isExplicitOperationCall() || !getFeatureCallArguments().isEmpty();
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		return getActualArguments(null, getFeatureCallArguments());
	}
	
	@Override
	public XExpression getActualReceiver() {
		return getActualReceiver(null);
	}

	@Override
	public boolean isExtension() {
		return isExtension(null);
	}
	
	@Override
	public boolean isPackageFragment() {
		ensureFeatureLinked();
		return super.isPackageFragment();
	}
	
	@Override
	public boolean isTypeLiteral() {
		ensureFeatureLinked();
		return super.isTypeLiteral();
	}
}
