/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.util.IAcceptor;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.computation.ILinkingCandidate;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public abstract class AbstractUnresolvableReference implements ILinkingCandidate {
	private final XExpression expression;
	private final ExpressionTypeComputationState state;

	public AbstractUnresolvableReference(XExpression expression, ExpressionTypeComputationState state) {
		this.expression = expression;
		this.state = state;
	}

	public XExpression getExpression() {
		return expression;
	}

	public void applyToComputationState() {
		StackedResolvedTypes resolvedTypes = getResolvedTypes();
		resolvedTypes.acceptLinkingInformation(expression, this);
		computeArgumentTypes();
		applyType();
		resolvedTypes.mergeIntoParent();
	}

	protected void applyType() {
		for (ITypeExpectation expectation : state.getExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null) {
				expectation.acceptActualType(expectedType, ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
			} else {
				expectation.acceptActualType(new UnknownTypeReference(expectation.getReferenceOwner()),
						ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
			}
		}
	}
	
	protected ExpressionTypeComputationState getState() {
		return state;
	}

	protected StackedResolvedTypes getResolvedTypes() {
		return state.getStackedResolvedTypes();
	}
	
	public boolean validate(IAcceptor<? super AbstractDiagnostic> result) {
		// nothing to do
		return true;
	}

	protected void computeArgumentTypes() {
		List<XExpression> arguments = getArguments();
		for (XExpression argument : arguments) {
			if (getResolvedTypes().doGetTypeData(argument) == null) {
				AbstractTypeComputationState argumentState = state.withNonVoidExpectation();
				argumentState.computeTypes(argument);
			}
		}
	}

	protected abstract List<XExpression> getArguments();

	public ILinkingCandidate getPreferredCandidate(ILinkingCandidate other) {
		return other;
	}

	@Nullable
	public JvmIdentifiableElement getFeature() {
		return null;
	}
	
	public EObject getContext() {
		return expression;
	}
	
	protected OwnedConverter getConverter() {
		return state.getConverter();
	}

}
