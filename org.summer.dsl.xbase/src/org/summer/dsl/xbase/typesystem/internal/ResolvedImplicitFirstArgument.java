/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ResolvedImplicitFirstArgument extends ImplicitFirstArgument {
	
	public ResolvedImplicitFirstArgument(XAbstractFeatureCall featureCall, XAbstractFeatureCall implicitReceiver,
			ExpressionTypeComputationState state) {
		super(featureCall, implicitReceiver, state);
	}

	@Override
	public void applyToComputationState() {
		ResolvedTypes resolvedTypes = getState().getResolvedTypes();
		TypeExpectation expectation = new TypeExpectation(null, getState(), false);
		LightweightTypeReference actualType = resolvedTypes.getActualType(getFeature());
		if (actualType == null)
			throw new IllegalStateException("Cannot determine actual type of already resolved implicit first argument");
		resolvedTypes.acceptType(getFeatureCall(), expectation, actualType.copyInto(resolvedTypes.getReferenceOwner()), false, ConformanceHint.UNCHECKED);
		super.applyToComputationState();
	}
	
	@Override
	public void applyToModel() {
		// nothing to do
	}

}
