/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FunctionBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public FunctionBodyComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			XFunctionDeclaration operation) {
		super(resolvedTypes, featureScopeSession, operation);
		for(JvmFormalParameter parameter: operation.getDeclaredFormalParameters()) {
			addLocalToCurrentScope(parameter);
		}

	}
	
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
//		return getResolvedTypes().getExpectedTypeForAssociatedExpression(getContainer(), getNonNullRootExpression());
//		return getResolvedTypes().getConverter().toLightweightReference(getContainer().getReturnType());
		return getResolvedTypes().getActualType(getContainer());
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
//		XFunction function = (XFunction) getContainer();
//		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(function, resolvedTypes, getFeatureScopeSession());
//		if (expectedType != null) {
//			InferredTypeIndicator.resolveTo(function.getReturnType(), expectedType.toJavaCompliantTypeReference());
//		}
		
		return new NoTypeResult(getContainer(), resolvedTypes.getReferenceOwner());
	}
	
	@Override
	protected XFunctionDeclaration getContainer() {
		return (XFunctionDeclaration) super.getContainer();
	}

	@Override
	public void computeTypes() {
		
		 getResolver().getTypeComputer().computeTypes(getContainer().getBody(), this);
	}

	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types,
			AbstractTypeExpectation expectation, LightweightTypeReference type,
			boolean returnType, ConformanceHint... conformanceHint) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled,
			ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType,
			ConformanceHint... conformanceHint) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	protected List<AbstractTypeExpectation> getExpectations(
			AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = new TypeExpectation(type, actualState, returnType);
		return Collections.singletonList(result);
	}

}
