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
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FieldGetTypeComputationState extends AbstractRootTypeComputationState2 {
	private final XBlockStatment statment;
	private final JvmTypeReference fieldType;
	public FieldGetTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			XBlockStatment statment, JvmTypeReference fieldType) {
		super(resolvedTypes, featureScopeSession);
		this.statment = statment;
		this.fieldType = fieldType;
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = returnType 
				? new TypeExpectation(type, actualState, returnType)
				: new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}

	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return getResolvedTypes().getConverter().toLightweightReference(fieldType);
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		final LightweightTypeReference result = resolvedTypes.getConverter().toLightweightReference(fieldType);
		return new NoTypeResult(statment, result.getOwner()) {
			@Override
			public LightweightTypeReference getActualExpressionType() {
				return result;
			}
		};
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression, StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationStateWithNonVoidExpectation(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
		
	}

	@Override
	public void computeTypes() {
		getResolver().getTypeComputer().computeTypes((XStatment)statment, this);
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
}
