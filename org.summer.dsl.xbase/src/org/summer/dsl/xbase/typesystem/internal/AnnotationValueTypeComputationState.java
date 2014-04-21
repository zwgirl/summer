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
import org.summer.dsl.model.types.JvmAnnotationValue;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API 
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class AnnotationValueTypeComputationState extends AbstractRootTypeComputationState {

	private final JvmAnnotationValue annotationValue;
	private final XExpression expression;

	public AnnotationValueTypeComputationState(ResolvedTypes resolvedTypes, IFeatureScopeSession featureScopeSession,
			JvmAnnotationValue annotationValue, XExpression expression) {
		super(resolvedTypes, featureScopeSession);
		this.annotationValue = annotationValue;
		this.expression = expression;
	}

	@Override
	protected List<AbstractTypeExpectation> getExpectations(AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
		AbstractTypeExpectation result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		return Collections.singletonList(result);
	}

	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		JvmOperation operation = annotationValue.getOperation();
		LightweightTypeReference result = getResolvedTypes().getActualType(operation);
		if (result != null && result.isArray()) {
			return result.getComponentType();
		}
		return result;
	}

	@Override
	protected XExpression getRootExpression() {
		return expression;
	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(annotationValue, resolvedTypes.getReferenceOwner());
	}
}
