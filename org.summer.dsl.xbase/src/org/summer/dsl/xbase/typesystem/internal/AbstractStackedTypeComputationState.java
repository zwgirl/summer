/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractStackedTypeComputationState extends AbstractTypeComputationState {

	private final AbstractTypeComputationState parent;

	protected AbstractStackedTypeComputationState(
			ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			AbstractTypeComputationState parent) {
		super(resolvedTypes, featureScopeSession);
		this.parent = parent;
	}
	
	protected AbstractTypeComputationState getParent() {
		return parent;
	}
	
	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState) {
		return parent.getExpectations(actualState);
	}
	
	@Override
	protected List<AbstractTypeExpectation> getReturnExpectations(AbstractTypeComputationState actualState, boolean asActualExpectation) {
		return parent.getReturnExpectations(actualState, asActualExpectation);
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return type;
	}
	
	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return type;
	}
	
}
