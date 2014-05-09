/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public abstract class AbstractTypeExpectation implements ITypeExpectation {

	private final AbstractTypeComputationState state;

	protected AbstractTypeExpectation(AbstractTypeComputationState state) {
		this.state = state;
	}
	
	public OwnedConverter getConverter() {
		return state.getConverter();
	}
	
	public ITypeReferenceOwner getReferenceOwner() {
		return state.getReferenceOwner();
	}

	public boolean isVoidTypeAllowed() {
		LightweightTypeReference expectedType = getExpectedType();
//		if (expectedType != null && expectedType.isType(Void.TYPE)) {
		if (expectedType != null && expectedType.isType(Buildin.Void.JvmType)) {
			return true;
		}
		return false;
	}
	
	public boolean isOwnedBy(ITypeReferenceOwner referenceOwner) {
		LightweightTypeReference expectedType = getExpectedType();
		return expectedType == null || expectedType.isOwnedBy(referenceOwner);
	}
	
	protected AbstractTypeComputationState getState() {
		return state;
	}
	
	protected ResolvedTypes getResolvedTypes() {
		return state.getResolvedTypes();
	}
	
	public UnboundTypeReference createUnboundTypeReference(XExpression expression, JvmTypeParameter typeParameter) {
		return getResolvedTypes().createUnboundTypeReference(expression, typeParameter);
	}
	
	@Override
	public String toString() {
		LightweightTypeReference expectedType = getExpectedType();
		String expectedTypeString = "";
		if (expectedType != null) {
			expectedTypeString = expectedType.toString();
		} else if (isNoTypeExpectation()) {
			expectedTypeString = "<no expectation>";
		} else if (isVoidTypeAllowed()) {
			expectedTypeString = "<void allowed>";
		} else {
			expectedTypeString = "<void not allowed>";
		}
		return getClass().getSimpleName() + " [expectation=" + expectedTypeString + "]";
	}
	
}
