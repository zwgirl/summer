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
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.xbase.scoping.batch.IFeatureScopeSession;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationResult;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class FunctionComputationState extends AbstractLogicalContainerAwareRootComputationState {

	public FunctionComputationState(ResolvedTypes resolvedTypes,
			IFeatureScopeSession featureScopeSession,
			XFunctionDeclaration operation) {
		super(resolvedTypes, featureScopeSession, operation);
		for(JvmFormalParameter parameter: operation.getDeclaredFormalParameters()) {
			addLocalToCurrentScope(parameter);
		}

	}
	
	@Override
	protected ITypeComputationResult createNoTypeResult() {
		return new NoTypeResult(getContainer(), getReferenceOwner());
	}
	
	@Override
	protected List<AbstractTypeExpectation> getExpectations(
			AbstractTypeComputationState actualState, boolean returnType) {
		LightweightTypeReference type = getExpectedType();
//		AbstractTypeExpectation result = returnType ? new TypeExpectation(type, actualState, returnType) : new RootTypeExpectation(type, actualState);
		AbstractTypeExpectation result = new TypeExpectation(type, actualState, true);
		return Collections.singletonList(result);
	}
	
	protected LightweightTypeReference getResolvedReference(@Nullable JvmTypeReference typeRef) {
		LightweightTypeReference result = getConverter().toLightweightReference(typeRef);
		if (result.isPrimitive() || result.isPrimitiveVoid())
			return result;
//		TypeParameterSubstitutor<?> substitutor = getSubstitutor();
//		LightweightTypeReference result = substitutor.substitute(result);
		return result;
	}
	
//	protected TypeParameterSubstitutor<?> getSubstitutor() {
//		if (getContextType().getType() != getDeclaration().getDeclaringType()) {
//			if (isRawTypeInheritance()) {
//				return new RawTypeSubstitutor(getContextType().getOwner());
//			}
//		}
//		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = getContextTypeParameterMapping();
//		TypeParameterSubstitutor<?> result = new TypeParameterByConstraintSubstitutor(mapping, getContextType().getOwner()) {
//			@Override
//			protected boolean isDeclaredTypeParameter(JvmTypeParameter typeParameter) {
//				if (super.isDeclaredTypeParameter(typeParameter) 
//						|| isResolvedTypeParameter(typeParameter)
//						|| getTypeParameterMapping().containsKey(typeParameter))
//					return true;
//				return false;
//			}
//			@Override
//			@Nullable
//			protected LightweightMergedBoundTypeArgument getBoundTypeArgument(JvmTypeParameter type,
//					ConstraintVisitingInfo info) {
//				LightweightMergedBoundTypeArgument result = super.getBoundTypeArgument(type, info);
//				if (result != null && result.getTypeReference().getType() == type) {
//					return null;
//				}
//				return result; 
//			}
//		};
//		return result;
//	}
	
	@Override
	@Nullable
	protected LightweightTypeReference getExpectedType() {
		return getResolvedReference(getContainer().getReturnType());
	}
	
	@Override
	protected XFunctionDeclaration getContainer() {
		return (XFunctionDeclaration) super.getContainer();
	}

	@Override
	public void computeTypes() {
		
		 getResolver().getTypeComputer().computeTypes(getContainer().getBody(), this);
	}
	

	@Override
	protected LightweightTypeReference acceptType(XExpression alreadyHandled,
			ResolvedTypes types, AbstractTypeExpectation expectation,
			LightweightTypeReference type, boolean returnType,
			ConformanceHint... conformanceHint) {
		if (alreadyHandled != (XBlockStatment)getContainer().getBody())
			return types.acceptType((XBlockStatment)getContainer().getBody(), expectation, type, returnType, conformanceHint);
		return type;
	}
	
	@Override
	protected LightweightTypeReference acceptType(ResolvedTypes types, AbstractTypeExpectation expectation, LightweightTypeReference type, boolean returnType, ConformanceHint... hints) {
		return types.acceptType((XBlockStatment)getContainer().getBody(), expectation, type, returnType, hints);
	}

}
