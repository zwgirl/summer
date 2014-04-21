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
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class TypeComputationStateWithRootExpectation extends TypeComputationStateWithExpectation {

	protected TypeComputationStateWithRootExpectation(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent,
			@Nullable LightweightTypeReference typeReference) {
		super(resolvedTypes.discardExpectedExceptions(), featureScopeSession, parent, typeReference);
	}
	
	@Override
	public List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
		AbstractTypeExpectation result = createTypeExpectation(getExpectedType(), actualState, !asActualExpectation);
		return Collections.singletonList(result);
	}
	
	@Override
	protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
			StackedResolvedTypes typeResolution) {
		return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
	}
	
	@Override
	public TypeAssigner assignTypes() {
		TypeCheckpointComputationState state = new TypeCheckpointComputationState(getResolvedTypes(), getFeatureScopeSession(), this) {
			@Override
			protected ExpressionTypeComputationState createExpressionComputationState(XExpression expression,
					StackedResolvedTypes typeResolution) {
				return new RootExpressionTypeComputationState(typeResolution, getFeatureScopeSession(), this, expression, getExpectedType());
			}
		};
		return createTypeAssigner(state);
	}
	
}
