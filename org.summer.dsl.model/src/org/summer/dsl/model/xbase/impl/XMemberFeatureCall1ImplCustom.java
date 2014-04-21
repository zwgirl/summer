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
public class XMemberFeatureCall1ImplCustom extends XMemberFeatureCall1Impl {
	
	@Override
	public String toString() {
		return getExpressionAsString(getMemberCallTarget())+"."+getConcreteSyntaxFeatureName()+getExpressionsAsString(getMemberCallArguments(),isExplicitOperationCall());
	}
	
	@Override
	public EList<XExpression> getExplicitArguments() {
		BasicEList<XExpression> result = new BasicEList<XExpression>();
		if (getMemberCallTarget()!=null)
			result.add(getMemberCallTarget());
		result.addAll(getMemberCallArguments());
		return result;
	}
	
	@Override
	public boolean isExplicitOperationCallOrBuilderSyntax() {
		return super.isExplicitOperationCall() || !getMemberCallArguments().isEmpty();
	}
	
	@Override
	public EList<XExpression> getActualArguments() {
		if (isStaticWithDeclaringType()) {
			return getMemberCallArguments();
		}
		return getActualArguments(getMemberCallTarget(), getMemberCallArguments());
	}
	
	@Override
	public XExpression getActualReceiver() {
		if (isStaticWithDeclaringType())
			return null;
		return getActualReceiver(getMemberCallTarget());
	}
	
	@Override
	public boolean isExtension() {
		if (isStaticWithDeclaringType()) {
			return false;
		}
		return isExtension(getMemberCallTarget());
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
	
	@Override
	public boolean isStaticWithDeclaringType() {
		ensureFeatureLinked();
		return super.isStaticWithDeclaringType();
	}
}
