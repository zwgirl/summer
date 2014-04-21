/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typesystem;

import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.ss.RichString;
import org.summer.dsl.model.ss.RichStringElseIf;
import org.summer.dsl.model.ss.RichStringForLoop;
import org.summer.dsl.model.ss.RichStringIf;
import org.summer.dsl.model.ss.RichStringLiteral;
import org.summer.dsl.model.ss.XtendFormalParameter;
import org.summer.dsl.model.ss.XtendVariableDeclaration;
import org.summer.ss2.lib.StringConcatenation;
import org.summer.ss2.lib.StringConcatenationClient;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xannotation.typesystem.XbaseWithAnnotationsTypeComputer;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputationState;
import org.summer.dsl.xbase.typesystem.computation.ITypeExpectation;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * Customized type computer for Xtend specific expressions.
 * 
 * The template expression and its dedicated child expressions are handled.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class XtendTypeComputer extends XbaseWithAnnotationsTypeComputer {

	@Override
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if (expression instanceof RichString) {
			_computeTypes((RichString)expression, state);
		} else if (expression instanceof RichStringForLoop) {
			_computeTypes((RichStringForLoop)expression, state);
		} else if (expression instanceof RichStringIf) {
			_computeTypes((RichStringIf)expression, state);
		} else if (expression instanceof RichStringLiteral) {
			_computeTypes((RichStringLiteral)expression, state);
		} else {
			super.computeTypes(expression, state);
		}
	}
	
	protected void _computeTypes(RichString object, ITypeComputationState state) {
		List<XExpression> expressions = object.getExpressions();
		if (!expressions.isEmpty()) {
			for(XExpression expression: expressions) {
				ITypeComputationState expressionState = state.withoutExpectation();
				expressionState.computeTypes(expression);
				if (expression instanceof XVariableDeclaration) {
					addLocalToCurrentScope((XVariableDeclaration)expression, state);
				}
			}
		}
		for(ITypeExpectation expectation: state.getExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isType(StringConcatenation.class)) {
				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
			} else if (expectedType != null && expectedType.isType(StringConcatenationClient.class)) {
				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
			} else if (expectedType != null && expectedType.isType(String.class)) {
				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
				// TODO this special treatment here should become obsolete as soon as the expectations are properly propagated
			} else if (!(object.eContainer() instanceof XCastedExpression) && 
					object.eContainingFeature() != XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET && 
					(expectedType != null && !expectedType.isResolved() || expectedType == null && !expectation.isVoidTypeAllowed())) {
				LightweightTypeReference type = getTypeForName(String.class, state);
				expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.DEMAND_CONVERSION);
			} else {
				LightweightTypeReference type = getTypeForName(CharSequence.class, state);
				expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
			}
		}
	}
	
	protected void _computeTypes(RichStringForLoop object, ITypeComputationState state) {
		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
		ITypeComputationState eachState = state.withExpectation(charSequence);
		JvmFormalParameter parameter = object.getDeclaredParam();
		if (parameter != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = eachState.assignType(parameter, parameterType);
		}
		eachState.computeTypes(object.getEachExpression());
		
		state.withNonVoidExpectation().computeTypes(object.getBefore());
		state.withNonVoidExpectation().computeTypes(object.getSeparator());
		state.withNonVoidExpectation().computeTypes(object.getAfter());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
		
		state.acceptActualType(charSequence);
	}
	
	protected void _computeTypes(RichStringIf object, ITypeComputationState state) {
		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
		LightweightTypeReference booleanType = getTypeForName(Boolean.TYPE, state);
		
		ITypeComputationState conditionExpectation = state.withExpectation(booleanType);
		XExpression condition = object.getIf();
		conditionExpectation.computeTypes(condition);
		XExpression thenExpression = object.getThen();
		ITypeComputationState thenState = reassignCheckedType(condition, thenExpression, state);
		thenState.withExpectation(charSequence).computeTypes(thenExpression);
		for(RichStringElseIf elseIf: object.getElseIfs()) {
			state.withExpectation(booleanType).computeTypes(elseIf.getIf());
			state.withExpectation(charSequence).computeTypes(elseIf.getThen());
		}
		state.withExpectation(charSequence).computeTypes(object.getElse());
		state.acceptActualType(charSequence);
	}
	
	protected void _computeTypes(RichStringLiteral object, ITypeComputationState state) {
		LightweightTypeReference type = getTypeForName(CharSequence.class, state);
		state.acceptActualType(type);
	}
	
//	protected void _computeTypes(XtendVariableDeclaration object, ITypeComputationState state) {
//		if (object.isExtension()) {
//			// basically the same as in the super implementation but we want to use
//			// an object expectation
//			JvmTypeReference declaredType = object.getType();
//			LightweightTypeReference lightweightTypeReference = declaredType != null ? state.getConverter().toLightweightReference(declaredType) : null;
//			if (lightweightTypeReference != null) {
//				// primitives may not be extensions
//				lightweightTypeReference = lightweightTypeReference.getWrapperTypeIfPrimitive();
//			}
//			if (lightweightTypeReference != null && object.getRight() instanceof XClosure) {
//				ITypeComputationState initializerState = state.assignType(object, lightweightTypeReference).withExpectation(lightweightTypeReference);
//				initializerState.computeTypes(object.getRight());
//			} else {
//				ITypeComputationState initializerState = lightweightTypeReference != null ? state.withExpectation(lightweightTypeReference) : state.withExpectation(getTypeForName(Object.class, state));
//				ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
//				/* 
//				 * TODO keep information about the actual type, e.g. automatic cast insertion should be possible for
//				 * 
//				 * val Object o = ""
//				 * o.substring(1)
//				 */
//				state.assignType(object, lightweightTypeReference != null ? lightweightTypeReference : computedType.getActualExpressionType(), false);
//			}
//			LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//			state.acceptActualType(primitiveVoid);
//		} else {
//			super._computeTypes(object, state);
//		}
//	}
	
	@Override
	protected void addLocalToCurrentScope(XVariableDeclaration localVariable, ITypeComputationState state) {
		super.addLocalToCurrentScope(localVariable, state);
		if (localVariable instanceof XtendVariableDeclaration && ((XtendVariableDeclaration) localVariable).isExtension()) {
			state.addExtensionToCurrentScope(localVariable);
		}
	}
	
	@Override
	protected ITypeComputationState assignType(JvmFormalParameter param, @Nullable LightweightTypeReference type,
			ITypeComputationState state) {
		ITypeComputationState result = super.assignType(param, type, state);
		if (param instanceof XtendFormalParameter && ((XtendFormalParameter) param).isExtension()) {
			result.addExtensionToCurrentScope(param);
		}
		return result;
	}

	@Override
	protected void _computeTypes(XClosure object, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			new ExtensionAwareClosureTypeComputer(object, expectation, state).computeTypes();
		}
	}
}
