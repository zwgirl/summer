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
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class ExpressionBasedRootTypeComputationState extends AbstractRootTypeComputationState {

	private final XExpression expression;
	private final LightweightTypeReference expectedType;

	public ExpressionBasedRootTypeComputationState(ResolvedTypes resolvedTypes, 
			IFeatureScopeSession featureScopeSession, XExpression expression) {
		this(resolvedTypes, featureScopeSession, expression, null);
	}
	
	public ExpressionBasedRootTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, XExpression expression, 
			@Nullable LightweightTypeReference expectedType) {
		super(resolvedTypes, featureScopeSession);
		this.expression = expression;
		this.expectedType = expectedType;
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		AbstractTypeExpectation result = null;
		if (expectedType != null) {
			result = returnType ? new TypeExpectation(expectedType, actualState, returnType) : new RootTypeExpectation(expectedType, actualState);
		} else {
			result = returnType ? new NoExpectation(actualState, returnType) : new RootNoExpectation(actualState, true);
		}
		return Collections.singletonList(result);
	}
	
	@Override
	protected XExpression getRootExpression() {
		return expression;
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return expectedType;
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(null, resolvedTypes.getReferenceOwner());
	}

}
