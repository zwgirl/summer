/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typesystem;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.InferredTypeIndicator;
import org.summer.dsl.xbase.typesystem.internal.OperationBodyComputationState;
import org.summer.dsl.xbase.typesystem.internal.ResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class DispatchOperationBodyComputationState extends OperationBodyComputationState {

	private JvmOperation dispatcher;

	public DispatchOperationBodyComputationState(
			ResolvedTypes resolvedTypes, 
			IFeatureScopeSession featureScopeSession,
			JvmOperation operation,
			JvmOperation dispatcher) {
		super(resolvedTypes, featureScopeSession, operation);
		this.dispatcher = dispatcher;
	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		LightweightTypeReference expectedType = super.getExpectedType();
		if (expectedType != null) {
			return expectedType;
		}
		if (dispatcher != null) {
			JvmOperation operation = (JvmOperation) getContainer();
			if (!InferredTypeIndicator.isInferred(dispatcher.getReturnType())) {
				LightweightTypeReference result = getResolvedTypes().getActualType(dispatcher);
				if (result != null)
					InferredTypeIndicator.resolveTo(operation.getReturnType(), result.toJavaCompliantTypeReference());
				return result;
			}
		}
		return null;
	}

}
