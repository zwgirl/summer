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
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class OperationBodyComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public OperationBodyComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			JvmOperation operation) {
		super(resolvedTypes.pushExpectedExceptions(operation), featureScopeSession, operation);
		for(JvmFormalParameter parameter: operation.getParameters()) {
			addLocalToCurrentScope(parameter);
		}
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result;
		if (type != null) {
			result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		JvmOperation operation = (JvmOperation) getMember();
		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(operation, resolvedTypes, getFeatureScopeSession());
		if (expectedType != null) {
			InferredTypeIndicator.resolveTo(operation.getReturnType(), expectedType.toJavaCompliantTypeReference());
			return expectedType;
		}
		return getResolvedTypes().getExpectedTypeForAssociatedExpression(getMember(), getNonNullRootExpression());
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		JvmOperation operation = (JvmOperation) getMember();
		LightweightTypeReference expectedType = ((LogicalContainerAwareReentrantTypeResolver)getResolver()).getReturnTypeOfOverriddenOperation(operation, resolvedTypes, getFeatureScopeSession());
		if (expectedType != null) {
			InferredTypeIndicator.resolveTo(operation.getReturnType(), expectedType.toJavaCompliantTypeReference());
		}
		return new NoTypeResult(getMember(), resolvedTypes.getReferenceOwner());
	}
	
	//cym added
	@Override
	protected XExpression getRootExpression() {
		JvmOperation operation = (JvmOperation) getMember();
		XClosure closure = (XClosure) operation.getFunction();
		return closure.getExpression();
	}
}
