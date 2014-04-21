/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
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
 * @author Moritz Eysholdt - Initial contribution and API
 */
@NonNullByDefault
public class ExpectedExceptionTypeComputationState extends AbstractStackedTypeComputationState {

	protected ExpectedExceptionTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession, AbstractTypeComputationState parent,
			List<LightweightTypeReference> exceptions) {
		super(resolvedTypes.pushExpectedExceptions(exceptions), featureScopeSession, parent);
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType,
			ConformanceHint... hints) {
		return getParent().acceptType(types, expectation, type, returnType, hints);
	}

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled, ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return getParent().acceptType(alreadyHandled, types, expectation, type, returnType, hints);
	}

}
