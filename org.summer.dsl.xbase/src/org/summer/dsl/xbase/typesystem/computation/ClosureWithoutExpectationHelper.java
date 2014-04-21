/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypes;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.util.BoundTypeArgumentSource;
import org.summer.dsl.xbase.typesystem.util.DeferredTypeParameterHintCollector;
import org.summer.dsl.xbase.typesystem.util.TypeParameterByUnboundSubstitutor;

/**
 * Strategy to compute types for lambda expression that do not have an expected type
 * or that have an expected type which is not a SAM type.
 * 
 * The type of the lamdba's body expression is computed without any constraints. After
 * the fact it is used to determine whether the lambda is a procedure or a function. 
 * 
 * @see ClosureWithExpectationHelper
 * @noinstantiate This class is not intended to be instantiated by clients.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ClosureWithoutExpectationHelper extends AbstractClosureTypeHelper {

	private final FunctionTypes functionTypes;
	
	protected ClosureWithoutExpectationHelper(XClosure closure, ITypeExpectation expectation, ITypeComputationState state) {
		super(closure, expectation, state);
		this.functionTypes = getServices().getFunctionTypes();
	}
	
	@Override
	protected void computeTypes() {
		FunctionTypeReference incompleteClosureType = getFunctionTypeReference(true);
		
		ITypeAssigner typeAssigner = getState().withoutRootExpectation().assignTypes();
		ITypeComputationState closureBodyTypeComputationState = getClosureBodyTypeComputationState(typeAssigner, incompleteClosureType);
		ITypeComputationResult expressionResult = closureBodyTypeComputationState.computeTypes(getClosure().getExpression());
		
		FunctionTypeReference resultClosureType = processExpressionType(incompleteClosureType, expressionResult);
		getExpectation().acceptActualType(resultClosureType, ConformanceHint.UNCHECKED);
	}
	
	@Override
	public FunctionTypeReference getExpectedClosureType() {
		return getFunctionTypeReference(true);
	}
	
	@Override
	public JvmOperation getOperation() {
		JvmOperation result = functionTypes.findImplementingOperation(getExpectedClosureType());
		if (result == null) {
			throw new IllegalStateException();
		}
		return result;
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected FunctionTypeReference getFunctionTypeReference(boolean isProcedure) {
		FunctionTypeReference result = functionTypes.createRawFunctionTypeRef(
				getExpectation().getReferenceOwner(), getClosure(), getClosure().getFormalParameters().size(), isProcedure);
		initClosureType(result, isProcedure);
		return result;
	}
	
	protected void initClosureType(FunctionTypeReference result, boolean isProcedure) {
		ITypeReferenceOwner owner = result.getOwner();
		TypeParameterByUnboundSubstitutor substitutor = new TypeParameterByUnboundSubstitutor(Collections.<JvmTypeParameter, LightweightMergedBoundTypeArgument>emptyMap(), owner) {
			@Override
			protected UnboundTypeReference createUnboundTypeReference(JvmTypeParameter type) {
				UnboundTypeReference result = getExpectation().createUnboundTypeReference(getClosure(), type);
				return result;
			}
		};
		JvmGenericType type = (JvmGenericType) result.getType();
		List<JvmTypeParameter> parameters = type.getTypeParameters();
		int max = type.getTypeParameters().size();
		if (!isProcedure)
			max--;
		for(int i = 0; i < max; i++) {
			JvmTypeParameter parameter = parameters.get(i);
			LightweightTypeReference parameterType = new ParameterizedTypeReference(owner, parameter);
			LightweightTypeReference substituted = substitutor.substitute(parameterType);
			result.addTypeArgument(substituted);
		}
		if (!isProcedure) {
			JvmTypeParameter parameter = parameters.get(max);
			LightweightTypeReference parameterType = new ParameterizedTypeReference(owner, parameter);
			LightweightTypeReference substituted = substitutor.substitute(parameterType);
			result.addTypeArgument(substituted);
		}
	}

	protected ITypeComputationState getClosureBodyTypeComputationState(ITypeAssigner typeAssigner, FunctionTypeReference incompleteClosureType) {
		List<LightweightTypeReference> operationParameterTypes = incompleteClosureType.getTypeArguments();
		List<JvmFormalParameter> closureParameters = getClosure().getFormalParameters();
		
		// just in case we have more than 6 closure parameters
		int paramCount = Math.min(closureParameters.size(), operationParameterTypes.size());
		// TODO validate parameter count - check against operation if available
		for(int i = 0; i < paramCount; i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			final LightweightTypeReference operationParameterType = operationParameterTypes.get(i);
			if (closureParameter.eContainingFeature() != XbasePackage.Literals.XCLOSURE__IMPLICIT_PARAMETER && closureParameter.getParameterType() != null) {
				final LightweightTypeReference closureParameterType = typeAssigner.toLightweightTypeReference(closureParameter.getParameterType());
				new DeferredTypeParameterHintCollector(getExpectation().getReferenceOwner()) {
					@Override
					protected void addHint(UnboundTypeReference typeParameter, LightweightTypeReference reference) {
						LightweightTypeReference wrapped = reference.getWrapperTypeIfPrimitive();
						typeParameter.acceptHint(wrapped, BoundTypeArgumentSource.RESOLVED, getOrigin(), getExpectedVariance(), getActualVariance());
					}
				}.processPairedReferences(operationParameterType, closureParameterType);
				typeAssigner.assignType(closureParameter, closureParameterType);
				incompleteClosureType.addParameterType(closureParameterType);
			} else {
				typeAssigner.assignType(closureParameter, operationParameterType);
				incompleteClosureType.addParameterType(operationParameterType);
			}
		}
		for(int i = paramCount; i < closureParameters.size(); i++) {
			JvmFormalParameter closureParameter = closureParameters.get(i);
			JvmTypeReference parameterType = closureParameter.getParameterType();
			if (parameterType != null) {
				LightweightTypeReference lightweight = typeAssigner.toLightweightTypeReference(parameterType);
				typeAssigner.assignType(closureParameter, lightweight);
			} else {
				LightweightTypeReference objectType = typeAssigner.toLightweightTypeReference(getServices().getTypeReferences().getTypeForName(Object.class, closureParameter));
				typeAssigner.assignType(closureParameter, objectType);
			}
		}
		ITypeComputationState result = typeAssigner.getForkedState();
//		JvmType knownType = incompleteClosureType.getType();
//		if (knownType != null && knownType instanceof JvmGenericType) {
//			result.assignType(IFeatureNames.SELF, knownType, incompleteClosureType);
//		}
		return result;
	}

	protected FunctionTypeReference processExpressionType(FunctionTypeReference incompleteClosureType, ITypeComputationResult expressionResult) {
		LightweightTypeReference expressionResultType = expressionResult.getReturnType();
		if (expressionResultType == null || !expressionResultType.isPrimitiveVoid()) {
			FunctionTypeReference result = getFunctionTypeReference(false);
			LightweightTypeReference expectedReturnType = result.getTypeArguments().get(result.getTypeArguments().size() - 1);
			if (expressionResultType != null && !expressionResultType.isAny()) {
				result.setReturnType(expressionResultType);
				deferredBindTypeArgument(expectedReturnType, expressionResultType, BoundTypeArgumentSource.INFERRED);
			} else {
				JvmType objectType = getServices().getTypeReferences().findDeclaredType(Object.class, incompleteClosureType.getType());
				ParameterizedTypeReference objectTypeReference = new ParameterizedTypeReference(incompleteClosureType.getOwner(), objectType);
				result.setReturnType(objectTypeReference);
				deferredBindTypeArgument(expectedReturnType, objectTypeReference, BoundTypeArgumentSource.INFERRED);
			}
			List<LightweightTypeReference> incompleteParameterTypes = incompleteClosureType.getParameterTypes();
			for(int i = 0; i < incompleteParameterTypes.size(); i++) {
				result.addParameterType(incompleteParameterTypes.get(i));
			}
			List<LightweightTypeReference> incompleteTypeArguments = incompleteClosureType.getTypeArguments();
			List<LightweightTypeReference> resultTypeArguments = result.getTypeArguments();
			for(int i = 0; i < incompleteTypeArguments.size(); i++) {
				deferredBindTypeArgument(resultTypeArguments.get(i), incompleteTypeArguments.get(i), BoundTypeArgumentSource.INFERRED);
			}
			return result;
		} else {
			incompleteClosureType.setReturnType(expressionResultType);
			return incompleteClosureType;
		}
	}
	
}
