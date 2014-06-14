/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import static com.google.common.collect.Lists.newArrayList;

import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmIndexer;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xbase.RichStringLiteral;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAbstractWhileStatment;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakStatment;
import org.summer.dsl.model.xbase.XCaller;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueStatment;
import org.summer.dsl.model.xbase.XDoWhileStatment;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XExpressionStatment;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XFieldLiteralPart;
import org.summer.dsl.model.xbase.XForEachStatment;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XFunctionDeclaration;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.model.xbase.XIndexer;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XParenthesizedExpression;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XReturnStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XTemplate;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowStatment;
import org.summer.dsl.model.xbase.XTryCatchFinallyStatment;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileStatment;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xbase.impl.XAbstractFeatureCallImpl;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceResult;
import org.summer.dsl.xbase.typesystem.internal.AbstractTypeComputationState;
import org.summer.dsl.xbase.typesystem.internal.FunctionComputationState;
import org.summer.dsl.xbase.typesystem.internal.ITypeLiteralLinkingCandidate;
import org.summer.dsl.xbase.typesystem.internal.ResolvedTypes;
import org.summer.dsl.xbase.typesystem.internal.StackedResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.TypeReferenceVisitorWithResult;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.typesystem.util.ConstraintAwareTypeArgumentCollector;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;
import org.summer.dsl.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.inject.Inject;

/**
 * Base implementation for the {@link ITypeComputer}. The interface contract 
 * fully applies to this class.
 * 
 * This implementation handles all expression that are defined in Xbase.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Moritz Eysholdt - Support for checked exceptions
 */
@NonNullByDefault
public class XbaseTypeComputer implements ITypeComputer {

	@Inject
	private NumberLiterals numberLiterals;
	
	@Inject 
	private CommonTypeComputationServices services;
	
	public void computeTypes(XExpression expression, ITypeComputationState state) {
		if(expression == null){
			return;
		}
		if (expression instanceof XAssignment) {
			_computeTypes((XAssignment)expression, state);
		} else if (expression instanceof XAbstractFeatureCall) {
			_computeTypes((XAbstractFeatureCall)expression, state);
		} else if (expression instanceof XTemplate) {
			_computeTypes((XTemplate)expression, state);
		} else if (expression instanceof XBooleanLiteral) {
			_computeTypes((XBooleanLiteral)expression, state);
		} else if (expression instanceof XCastedExpression) {
			_computeTypes((XCastedExpression)expression, state);
		} else if (expression instanceof XClosure) {
			_computeTypes((XClosure)expression, state);
		} else if (expression instanceof XConstructorCall) {
			_computeTypes((XConstructorCall)expression, state);
		} else if (expression instanceof XInstanceOfExpression) {
			_computeTypes((XInstanceOfExpression)expression, state);
		} else if (expression instanceof XNumberLiteral) {
			_computeTypes((XNumberLiteral)expression, state);
		} else if (expression instanceof XNullLiteral) {
			_computeTypes((XNullLiteral)expression, state);
		} else if (expression instanceof RichStringLiteral) {
			_computeTypes((RichStringLiteral)expression, state);
		} else if (expression instanceof XStringLiteral) {
			_computeTypes((XStringLiteral)expression, state);
		} else if (expression instanceof XTypeLiteral) {
			_computeTypes((XTypeLiteral)expression, state);
		} else if (expression instanceof XVariableDeclaration) {
			_computeTypes((XVariableDeclaration)expression, state);
		} else if (expression instanceof XPostfixOperation) {
			_computeTypes((XPostfixOperation)expression, state);
		} else if (expression instanceof XIndexer) {
			_computeTypes((XIndexer)expression, state);
		} else if (expression instanceof XTernaryOperation) {
			_computeTypes((XTernaryOperation)expression, state);
		} else if (expression instanceof XObjectLiteral) {
			_computeTypes((XObjectLiteral)expression, state);
		} else if (expression instanceof XStructLiteral) {
			_computeTypes((XStructLiteral)expression, state);
		} else if (expression instanceof XArrayLiteral) {
			_computeTypes((XArrayLiteral)expression, state);
		} else if (expression instanceof XCaller) {
			_computeTypes((XCaller)expression, state);
		} else if (expression instanceof XParenthesizedExpression) {
			_computeTypes((XParenthesizedExpression)expression, state);
		} else { 
			throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
		}
	}
	
	public void computeTypes(XStatment statment, ITypeComputationState state) {
		if(statment == null){
			return;
		}
		
		if (statment instanceof XDoWhileStatment) {
			_computeTypes((XDoWhileStatment)statment, state);
		} else if (statment instanceof XWhileStatment) {
			_computeTypes((XWhileStatment)statment, state);
		} else if (statment instanceof XBlockStatment) {
			_computeTypes((XBlockStatment)statment, state);
		} else if (statment instanceof XForLoopStatment) {
			_computeTypes((XForLoopStatment)statment, state);
		} else if (statment instanceof XForEachStatment) {
			_computeTypes((XForEachStatment)statment, state);
		} else if (statment instanceof XIfStatment) {
			_computeTypes((XIfStatment)statment, state);
		} else if (statment instanceof XReturnStatment) {
			_computeTypes((XReturnStatment)statment, state);
		} else if (statment instanceof XSwitchStatment) {
			_computeTypes((XSwitchStatment)statment, state);
		} else if (statment instanceof XThrowStatment) {
			_computeTypes((XThrowStatment)statment, state);
		} else if (statment instanceof XTryCatchFinallyStatment) {
			_computeTypes((XTryCatchFinallyStatment)statment, state);
		} else if (statment instanceof XVariableDeclarationList) {
			_computeTypes((XVariableDeclarationList)statment, state);
		} else if (statment instanceof XBreakStatment) {
			_computeTypes((XBreakStatment)statment, state);
		} else if (statment instanceof XContinueStatment) {
			_computeTypes((XContinueStatment)statment, state);
//		} else if (statment instanceof XFunctionDeclaration) {
//			_computeTypes((XFunctionDeclaration)statment, state);
		} else if (statment instanceof XExpressionStatment) {
			_computeTypes((XExpressionStatment)statment, state);
		} else { 
			throw new UnsupportedOperationException("Missing type computation for expression type: " + statment.eClass().getName() + " / " + state);
		}
	}

	protected void _computeTypes(XTemplate object, ITypeComputationState state) {
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
		
		//cym comment
//		for(ITypeExpectation expectation: state.getExpectations()) {
//			LightweightTypeReference expectedType = expectation.getExpectedType();
//			if (expectedType != null && expectedType.isType(StringConcatenation.class)) {
//				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
//			} else if (expectedType != null && expectedType.isType(StringConcatenationClient.class)) {
//				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
//			} else if (expectedType != null && expectedType.isType(String.class)) {
//				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
//				// TODO this special treatment here should become obsolete as soon as the expectations are properly propagated
//			} else if (!(object.eContainer() instanceof XCastedExpression) && 
//					object.eContainingFeature() != XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET && 
//					(expectedType != null && !expectedType.isResolved() || expectedType == null && !expectation.isVoidTypeAllowed())) {
//				LightweightTypeReference type = getTypeForName(String.class, state);
//				expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.DEMAND_CONVERSION);
//			} else {
//				LightweightTypeReference type = getTypeForName(CharSequence.class, state);
//				expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
//			}
//		}
		
		for(ITypeExpectation expectation: state.getExpectations()) {
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if (expectedType != null && expectedType.isType(Buildin.String.JvmType)) {
				expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.DEMAND_CONVERSION);
				// TODO this special treatment here should become obsolete as soon as the expectations are properly propagated
			} else if (!(object.eContainer() instanceof XCastedExpression) && 
					object.eContainingFeature() != XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET && 
					(expectedType != null && !expectedType.isResolved() || expectedType == null && !expectation.isVoidTypeAllowed())) {
//				LightweightTypeReference type = getTypeForName(String.class, state);  //cym comment
				LightweightTypeReference type = getTypeForName(Buildin.String.JvmType, state);
				expectation.acceptActualType(type, ConformanceHint.UNCHECKED, ConformanceHint.DEMAND_CONVERSION);
			}
//			else {  //cym comment
//				LightweightTypeReference type = getTypeForName(CharSequence.class, state);
//				expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
//			}
		}
	}
	
//	protected void _computeTypes(RichStringForLoop object, ITypeComputationState state) {
//		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
//		ITypeComputationState eachState = state.withExpectation(charSequence);
//		JvmFormalParameter parameter = object.getDeclaredParam();
//		if (parameter != null) {
//			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
//			eachState = eachState.assignType(parameter, parameterType);
//		}
//		eachState.computeTypes(object.getEachExpression());
//		
//		state.withNonVoidExpectation().computeTypes(object.getBefore());
//		state.withNonVoidExpectation().computeTypes(object.getSeparator());
//		state.withNonVoidExpectation().computeTypes(object.getAfter());
//		
//		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//		state.acceptActualType(primitiveVoid);
//		
//		state.acceptActualType(charSequence);
//	}
//	
//	protected void _computeTypes(RichStringIf object, ITypeComputationState state) {
//		LightweightTypeReference charSequence = getTypeForName(CharSequence.class, state);
//		LightweightTypeReference booleanType = getTypeForName(Boolean.TYPE, state);
//		
//		ITypeComputationState conditionExpectation = state.withExpectation(booleanType);
//		XExpression condition = object.getIf();
//		conditionExpectation.computeTypes(condition);
//		XExpression thenExpression = object.getThen();
//		ITypeComputationState thenState = reassignCheckedType(condition, thenExpression, state);
//		thenState.withExpectation(charSequence).computeTypes(thenExpression);
//		for(RichStringElseIf elseIf: object.getElseIfs()) {
//			state.withExpectation(booleanType).computeTypes(elseIf.getIf());
//			state.withExpectation(charSequence).computeTypes(elseIf.getThen());
//		}
//		state.withExpectation(charSequence).computeTypes(object.getElse());
//		state.acceptActualType(charSequence);
//	}
	
	protected void _computeTypes(RichStringLiteral object, ITypeComputationState state) {
		LightweightTypeReference type = getTypeForName(Buildin.String.JvmType, state);
		state.acceptActualType(type);
	}

	protected LightweightTypeReference getTypeForName(Class<?> clazz, ITypeComputationState state) {
		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(clazz, resourceSet);
		if (typeReference == null) {
			return new UnknownTypeReference(state.getReferenceOwner(), clazz.getName());
		}
		return state.getConverter().toLightweightReference(typeReference);
	}
	
	//cym add
	protected LightweightTypeReference getTypeForName(JvmType type, ITypeComputationState state) {

		ResourceSet resourceSet = state.getReferenceOwner().getContextResourceSet();
		//cym comment
//		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(clazz, resourceSet);
//		if (typeReference == null) {
//			return new UnknownTypeReference(state.getReferenceOwner(), clazz.getName());
//		}
		
		JvmTypeReference typeReference = services.getTypeReferences().getTypeForName(type, resourceSet);
		if (typeReference == null) {
			return new UnknownTypeReference(state.getReferenceOwner(), type.getSimpleName());
		}
		return state.getConverter().toLightweightReference(typeReference);
	}
	
	//cym comment
//	protected ParameterizedTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
//		JvmType clazzType = services.getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
//		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, clazzType);
//		return result;
//	}
	
	protected ParameterizedTypeReference getRawTypeForName(JvmType type, ITypeReferenceOwner owner) {
//		JvmType clazzType = services.getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, type);
		return result;
	}
	
//	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
//		return getTypeForName(Void.TYPE, state);
//	}
	
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return getTypeForName(Buildin.Void.JvmType, state);
	}
	
	
	
	protected static abstract class BranchExpressionProcessor {
		protected boolean earlyExit = true;
		protected boolean allVoid = true;
		protected boolean allPrimitive = true;
		protected boolean resultProcessed = false;
		protected boolean nonNullResultProcessed = false;
		private final ITypeComputationState state;
		private final XExpression expression;
		
		public BranchExpressionProcessor(ITypeComputationState state, XExpression expression) {
			this.state = state;
			this.expression = expression;
		}
		
		public void process(ITypeComputationResult result) {
			resultProcessed = true;
			if (!result.getConformanceHints().isEmpty() /* equivalent to getActualExpressionType != null */) {
				nonNullResultProcessed = true;
			}
			LightweightTypeReference expressionReturnType = result.getReturnType();
			if (expressionReturnType != null) {
				boolean isExit = result.getCheckedConformanceHints().contains(ConformanceHint.NO_IMPLICIT_RETURN);
				if (earlyExit && isExit && !expressionReturnType.isPrimitiveVoid()) {
					earlyExit = false;
				}
				if (allPrimitive && isExit && !expressionReturnType.isPrimitive()) {
					allPrimitive = false;
				}
				if (allVoid || allPrimitive) {
					LightweightTypeReference expressionType = result.getActualExpressionType();
					if (allVoid && !(expressionType != null && expressionType.isPrimitiveVoid())) {
						allVoid = false;
					}
					if (allPrimitive && !(expressionType != null && expressionType.isPrimitive() || expressionReturnType.isPrimitive())) {
						allPrimitive = false;
					}
				}
			}
		}
		
		public void commit() {
			if (!nonNullResultProcessed) {
				AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
				state.acceptActualType(anyType);
			}
			if (!resultProcessed) {
				return;
			}
			if (earlyExit || allVoid || allPrimitive) {
				for(ITypeExpectation expectation: state.getExpectations()) {
					if (earlyExit && allVoid) {
						if (!expectation.isVoidTypeAllowed()) {
							AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
							expectation.acceptActualType(anyType, ConformanceHint.UNCHECKED);
							allPrimitive = false;
						}
					} else if (!expectation.isVoidTypeAllowed() && expectation.getExpectedType() == null) {
						if (!allPrimitive || allVoid) {
							AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
							expectation.acceptActualType(anyType, ConformanceHint.UNCHECKED);
						}
						allPrimitive = false;
					}
					if (expectation.isVoidTypeAllowed() && (earlyExit || allVoid)) {
						allPrimitive = false;
					}
				}
				
				if (!state.isIgnored(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE) && allPrimitive) {
					AbstractDiagnostic diagnostic = new DiagnosticOnFirstKeyword(
							state.getSeverity(IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE),
							IssueCodes.NULL_SAFE_FEATURE_CALL_OF_PRIMITIVE_VALUED_FEATURE, 
							getMessage(),
							expression,
							null);
					state.addDiagnostic(diagnostic);
				}
				return;
			} else {
				AnyTypeReference anyType = new AnyTypeReference(state.getReferenceOwner());
				state.acceptActualType(anyType);
			}
		}

		protected abstract String getMessage();
	}
	
	protected void _computeTypes(XIfStatment object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		XExpression condition = object.getIf();
		conditionExpectation.computeTypes(condition);
		
		computeTypes(object.getThen(), state);
		XStatment elseStatment = object.getElse();
		if (elseStatment != null) {
			computeTypes(elseStatment, state);
		} 
	}

	/**
	 * If the condition is a {@link XInstanceOfExpression type check}, the checked expression
	 * will be automatically casted in the returned state.
	 */
	protected ITypeComputationState reassignCheckedType(XExpression condition, @Nullable XExpression guardedExpression, ITypeComputationState state) {
		if (condition instanceof XInstanceOfExpression) {
			XInstanceOfExpression instanceOfExpression = (XInstanceOfExpression) condition;
			JvmTypeReference castedType = instanceOfExpression.getType();
			if (castedType != null) {
				state = state.withTypeCheckpoint(guardedExpression);
				JvmIdentifiableElement refinable = getRefinableCandidate(instanceOfExpression.getExpression(), state);
				if (refinable != null) {
					state.reassignType(refinable, state.getConverter().toLightweightReference(castedType));
				}
			}
		}
		return state;
	}
	
	protected void _computeTypes(XSwitchStatment object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = state.withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		LightweightTypeReference expressionType = computedType.getActualExpressionType();
		// TODO case expressions may influence the expected type of other cases
		for(XCasePart casePart: getCases(object)) {
			ITypeComputationState caseExpressionState = state.withExpectation(expressionType);
			caseExpressionState.computeTypes(casePart.getCase());
			
			ITypeComputationState caseState = state.withoutRootExpectation();
			computeTypes(casePart.getThen(), caseState);
		}
		ITypeComputationState defaultState = state.withoutRootExpectation();
		computeTypes(object.getDefault(), defaultState);
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected List<XCasePart> getCases(XSwitchStatment switchExpression) {
		return switchExpression.getCases();
	}
	
	protected void _computeTypes(final XForEachStatment object, final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		ITypeComputationState eachState = state.withoutExpectation();
		if (declaredParam != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = assignType(declaredParam, parameterType, eachState);
		}
		computeTypes(object.getStatment(), eachState);
		
//		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//		state.acceptActualType(primitiveVoid);
	}
	
	protected ITypeComputationState assignType(JvmFormalParameter param, @Nullable LightweightTypeReference type, ITypeComputationState state) {
		return state.assignType(param, type);
	}

	@Nullable
	protected LightweightTypeReference computeForLoopParameterType(final XForEachStatment object,
			final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = getDeclaredParameterType(declaredParam, state);
//		final JvmGenericType iterableType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, object); //cym comment
		final JvmInterfaceType iterableType = (JvmInterfaceType) Buildin.Iterable.JvmType;
		
		if (parameterType != null && !parameterType.isPrimitiveVoid()) {
			final CompoundTypeReference withSynonyms = new CompoundTypeReference(state.getReferenceOwner(), true);
			LightweightTypeReference iterableOrArray = getAndEnhanceIterableOrArrayFromComponent(parameterType, iterableType, withSynonyms);
			
			ITypeComputationState iterableState = state.withExpectation(withSynonyms);
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType!= null) {
				if (forExpressionType.isAny() || forExpressionType.isUnknown()) {
					iterableState.refineExpectedType(object.getExpression(), iterableOrArray);
				} else if (forExpressionType.isResolved()) {
					TypeConformanceResult assignability = iterableOrArray.internalIsAssignableFrom(forExpressionType, new TypeConformanceComputationArgument());
					if (assignability.isConformant() && !assignability.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION))
						iterableState.refineExpectedType(object.getExpression(), forExpressionType);
					else {
						ArrayTypeReference array = forExpressionType.tryConvertToArray();
						if (array != null) {
							LightweightTypeReference arrayComponentType = array.getComponentType();
							if (parameterType.isAssignableFrom(arrayComponentType)) {
								iterableState.refineExpectedType(object.getExpression(), forExpressionType);
							} else {
								LightweightTypeReference rawArrayComponentType = arrayComponentType.getRawTypeReference();
								AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
										Severity.ERROR, 
										IssueCodes.INCOMPATIBLE_TYPES, 
										String.format("Type mismatch: cannot convert from element type %s to %s", rawArrayComponentType.getSimpleName(), parameterType.getSimpleName()), 
										object, 
										XbasePackage.Literals.XFOR_EACH_STATMENT__EXPRESSION, -1, null);
								state.addDiagnostic(diagnostic);
							}
						}
					}
				}
			}
		} else {
			ITypeReferenceOwner owner = state.getReferenceOwner();
			LightweightTypeReference iterable = null;
			if (iterableType == null) {
//				iterable = new UnknownTypeReference(owner, Iterable.class.getName());  //cym comment
				iterable = new UnknownTypeReference(owner, "Iterable");
			} else {
//				WildcardTypeReference wildcard = new WildcardTypeReference(owner);
//				ParameterizedTypeReference iterableTypeRef = new ParameterizedTypeReference(owner, iterableType);
//				UnboundTypeReference unbound = state.createUnboundTypeReference(object, iterableType.getTypeParameters().get(0));
//				wildcard.addUpperBound(unbound);
//				iterableTypeRef.addTypeArgument(wildcard);
//				iterable = iterableTypeRef;
//				// TODO do we have to add synonyms, too?
			}
			ITypeComputationState iterableState = state.withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType != null) {
				if (!forExpressionType.isAny() && (iterable.isAssignableFrom(forExpressionType) || forExpressionType.isArray())) {
					iterableState.refineExpectedType(object.getExpression(), forExpressionType);
				}
				parameterType = getElementOrComponentType(forExpressionType, state);
			}
		}
		return parameterType;
	}
	
	protected void _computeTypes(XReturnStatment object, ITypeComputationState state) {
		XExpression returnValue = object.getExpression();
		ITypeComputationState expressionState = state.withReturnExpectation();
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//		if (returnValue != null) {
//			expressionState.computeTypes(returnValue);
//			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
//		} else {
//			state.acceptActualType(primitiveVoid, ConformanceHint.EXPLICIT_VOID_RETURN);
//			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
//		}
		
		if (returnValue != null) {
			expressionState.computeTypes(returnValue);
			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
		} else {
			state.acceptActualType(primitiveVoid, ConformanceHint.EXPLICIT_VOID_RETURN);
			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
		}
	}
	
//	protected void _computeTypes(XFunctionDeclaration function, ITypeComputationState state) {
//		AbstractTypeComputationState typeState = (AbstractTypeComputationState) state;
//		StackedResolvedTypes childResolvedTypes = declareTypeParameters(typeState.getResolvedTypes(), function);
//		FunctionComputationState state1 = new FunctionComputationState(childResolvedTypes, typeState.getFeatureScopeSession(), function);
//		state1.computeTypes();
////		computeAnnotationTypes(childResolvedTypes, featureScopeSession, field);
//		
////		if (childResolvedTypes instanceof StackedResolvedTypes)
////			((StackedResolvedTypes) childResolvedTypes).mergeIntoParent();
//		
////		computeTypes(function.getBody(), state);
//	}
	
	protected StackedResolvedTypes declareTypeParameters(ResolvedTypes resolvedTypes, JvmIdentifiableElement declarator) {
		StackedResolvedTypes childResolvedTypes = resolvedTypes.pushTypes();
		if (declarator instanceof JvmTypeParameterDeclarator) {
			JvmTypeParameterDeclarator casted = (JvmTypeParameterDeclarator) declarator;
			if (isStatic(declarator) && !(declarator instanceof JvmConstructor)) {
				childResolvedTypes.replaceDeclaredTypeParameters(casted.getTypeParameters());
			} else {
				childResolvedTypes.addDeclaredTypeParameters(casted.getTypeParameters());
			}
		}
		return childResolvedTypes;
	}
	
	protected boolean isStatic(JvmIdentifiableElement declarator) {
		if (declarator instanceof JvmFeature) {
			return ((JvmFeature) declarator).isStatic();
		}
//		if (declarator instanceof JvmDeclaredType) {
//			return ((JvmDeclaredType) declarator).isStatic();
//		}
		return false;
	}
	
	protected void _computeTypes(XExpressionStatment exprStatment, ITypeComputationState state) {
		computeTypes(exprStatment.getExpression(), state);
	}
	
	protected void _computeTypes(XBreakStatment object, ITypeComputationState state) {
		
	}
	
	protected void _computeTypes(XContinueStatment object, ITypeComputationState state) {

	}
	
	protected void _computeTypes(XThrowStatment object, ITypeComputationState state) {
		ITypeComputationState expressionState = state.withoutExpectation();
		expressionState.computeTypes(object.getExpression());
	}

	protected void _computeTypes(XWhileStatment object, ITypeComputationState state) {
		computeWhileLoopBody(object, state, true);
		
//		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//		state.acceptActualType(primitiveVoid);
	}

	protected void computeWhileLoopBody(XAbstractWhileStatment object, ITypeComputationState state, boolean autocast) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Buildin.Boolean.JvmType, state));
		XExpression predicate = object.getPredicate();
		conditionExpectation.computeTypes(predicate);
		
		XStatment body = object.getBody();
		ITypeComputationState bodyState = state.withoutExpectation();
		computeTypes(body, bodyState);
	}

	/**
	 * Since we are sure that the loop body is executed at least once, the early exit information
	 * of the loop body expression can be used for the outer expression.
	 */
	protected void _computeTypes(XDoWhileStatment object, ITypeComputationState state) {
		computeWhileLoopBody(object, state, false);
//		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
//		state.acceptActualType(primitiveVoid);
	}
	
	protected void _computeTypes(XBlockStatment object, ITypeComputationState state) {
		AbstractTypeComputationState aState = (AbstractTypeComputationState) state;
		List<XStatment> children = object.getStatments();
//		if (children.isEmpty()) {
//			for (ITypeExpectation expectation: state.getExpectations()) {
//				LightweightTypeReference expectedType = expectation.getExpectedType();
//				if (expectedType != null && expectedType.isPrimitiveVoid()) {
//					expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
//				} else {
//					expectation.acceptActualType(new AnyTypeReference(expectation.getReferenceOwner()), ConformanceHint.UNCHECKED);
//				}
//			}
//		} else {
		for(XStatment statment : children) {
			if (statment instanceof XFunctionDeclaration) {
				state.addLocalToCurrentScope((JvmIdentifiableElement) statment);
			}
		}
//			state.withinScope(object);  //cym comment
		for(XStatment statment : children) {
				if(statment instanceof XFunctionDeclaration){
					XFunctionDeclaration function = (XFunctionDeclaration) statment;
					
					StackedResolvedTypes functionResolvedTypes = declareTypeParameters(aState.getResolvedTypes(), function);
					
					LightweightTypeReference lightweightReference = aState.getConverter().toLightweightReference(function.getReturnType());
					functionResolvedTypes.setType(function, lightweightReference);
					
					FunctionComputationState functionState = new FunctionComputationState(functionResolvedTypes, aState.getFeatureScopeSession(), function);
					functionState.computeTypes();
					functionResolvedTypes.mergeIntoParent();
				}  else {
					computeTypes(statment, state);
					
					if(statment instanceof XVariableDeclarationList){
						if (statment instanceof XVariableDeclarationList) {
							XVariableDeclarationList declList = (XVariableDeclarationList) statment;
							for(XExpression exp : declList.getDeclarations()){
								state.addLocalToCurrentScope((XVariableDeclaration)exp);
							}
						}
					}
				}
//				computeTypes(statment, state);
//				if (statment instanceof XVariableDeclarationList) {
//					XVariableDeclarationList declList = (XVariableDeclarationList) statment;
//					for(XExpression exp : declList.getDeclarations()){
//						addLocalToCurrentScope((XVariableDeclaration)exp, state);
//					}
//				}
			}
//			XStatment lastStatment = children.get(children.size() - 1);
//			for (ITypeExpectation expectation: state.getExpectations()) {
//				LightweightTypeReference expectedType = expectation.getExpectedType();
//				if (expectedType != null && expectedType.isPrimitiveVoid()) {
//					ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
////					expressionState.computeTypes(lastExpression);
//					computeTypes(lastStatment, expressionState);
//					if (lastStatment instanceof XVariableDeclaration) {
//						addLocalToCurrentScope((XVariableDeclaration)lastStatment, state);
//					}
//					expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
//				} else {
////					state.computeTypes(lastStatment);
//					computeTypes(lastStatment, state);
//					// add the last expression to the scope, too in order validate for duplicate names, even
//					// though the variable declaration could be removed automatically to keep only the side effect
//					// of the initializer
//					if (lastStatment instanceof XVariableDeclarationList) {
//						XVariableDeclarationList declList = (XVariableDeclarationList) lastStatment;
//						for(XExpression exp : declList.getDeclarations()){
//							addLocalToCurrentScope((XVariableDeclaration)exp, state);
//						}
//					}
//				}
//			}
//		}
	}

	protected void addLocalToCurrentScope(XVariableDeclaration localVariable, ITypeComputationState state) {
		state.addLocalToCurrentScope(localVariable);
	}
	
	protected void _computeTypes(XVariableDeclarationList declList, ITypeComputationState state) {
		List<XExpression> expressions = declList.getDeclarations();
		for(XExpression exp : expressions){
			XVariableDeclaration decl = (XVariableDeclaration) exp;
			_computeTypes(decl, state);
		}
	}
	
	protected void _computeTypes(XVariableDeclaration object, ITypeComputationState state) {
		JvmTypeReference declaredType = object.getType();
		LightweightTypeReference lightweightTypeReference = declaredType != null ? state.getConverter().toLightweightReference(declaredType) : null;
		/*
		 * Allow recursive closure bodies, e.g.
		 * 
		 * val (Integer)=>BigInteger fib = [ idx |
		 * 		if (idx < 2) {
		 * 			BigInteger::ONE
		 * 		} else {
		 * 			fib.apply(idx - 1) + fib.apply(idx - 2)
		 * 		}
		 * 	]
		 * 
		 * Actually this should be even smarter, but it's not possible to decide whether 'apply' is called on the closure
		 * before it is produced if the closure is not assigned to the local variable directly.
		 * 
		 * TODO Do we need an annotation to mark functions as not eagerly called, e.g. @Lazy
		 * 
		 * This would allow 
		 * 
		 * val (Integer)=>BigInteger fib = [ idx |
		 * 		if (idx < 2) {
		 * 			BigInteger::ONE
		 * 		} else {
		 * 			fib.apply(idx - 1) + fib.apply(idx - 2)
		 * 		}
		 * 	].memoize()
		 * 
		 * where memoize() is an extension method like in
		 * http://pragprog.com/magazines/2013-01/using-memoization-in-groovy
		 */
		if (lightweightTypeReference != null && object.getRight() instanceof XClosure) {
			ITypeComputationState initializerState = state.assignType(object, lightweightTypeReference).withExpectation(lightweightTypeReference);
			initializerState.computeTypes(object.getRight());
		} else {
			ITypeComputationState initializerState = lightweightTypeReference != null ? state.withExpectation(lightweightTypeReference) : state.withNonVoidExpectation();
			ITypeComputationResult computedType = initializerState.computeTypes(object.getRight());
			/* 
			 * TODO keep information about the actual type, e.g. automatic cast insertion should be possible for
			 * 
			 * val Object o = ""
			 * o.substring(1)
			 */
			LightweightTypeReference variableType = null;
			if (lightweightTypeReference != null) {
				
				//cym comment
				variableType = lightweightTypeReference;
//				ExtendedEarlyExitComputer earlyExitComputer = state.getReferenceOwner().getServices().getEarlyExitComputer();
//				if (earlyExitComputer.isDefiniteEarlyExit(computedType.getExpression())) {
//					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
//							Severity.ERROR,
//							IssueCodes.UNREACHABLE_CODE, 
//							"Dead code: The variable " + object.getSimpleName() + " will never be assigned.",
//							object,
//							XbasePackage.Literals.XVARIABLE_DECLARATION__NAME,
//							-1,
//							null);
//					state.addDiagnostic(diagnostic);
//				}
			} else {
				variableType = computedType.getActualExpressionType();
			}
			if (variableType != null && variableType.isPrimitiveVoid()) {
				variableType = new UnknownTypeReference(variableType.getOwner());
			}
			state.assignType(object, variableType, false);  
//			state.addExtensionToCurrentScope(object);
		}
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<? extends IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		ILinkingCandidate best = getBestCandidate(candidates);
		best.applyToComputationState();
	}
	
	protected void _computeTypes(final XCaller caller, ITypeComputationState state) {
		LightweightTypeReference functionType = new FunctionTypeReference(state.getReferenceOwner(), Buildin.Function.JvmType);
		ITypeComputationState functionState = state.withExpectation(functionType);
		XExpression function = caller.getExecutable();
		functionState.computeTypes(function);
//		for(XExpression argument : caller.getArguments()){
//			computeTypes(argument, state);
//		}
	}
	
	protected void _computeTypes(final XParenthesizedExpression exp, ITypeComputationState state) {
		computeTypes(exp.getExpression(), state);
	}
	
	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XBooleanLiteral object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Buildin.Boolean.JvmType, state);
		state.acceptActualType(bool);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XNullLiteral object, ITypeComputationState state) {
		state.acceptActualType(new AnyTypeReference(state.getReferenceOwner()));
	}

	protected void _computeTypes(XNumberLiteral object, ITypeComputationState state) {
		// TODO evaluate expectation if no specific suffix is given
		LightweightTypeReference result = getTypeForName(numberLiterals.getType(object), state);
		state.acceptActualType(result);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XStringLiteral object, ITypeComputationState state) {
		LightweightTypeReference result = getTypeForName(Buildin.String.JvmType, state);
		state.acceptActualType(result);
	}
	
	protected void _computeTypes(XStructLiteral object, ITypeComputationState state) {
		OwnedConverter converter = state.getConverter();
		JvmTypeReference typeRef = services.getTypeReferences().createTypeRef(object.getType());
		
		List<XFieldLiteralPart> fieldLiterals = object.getProperties();
		for(XFieldLiteralPart fieldLiteral : fieldLiterals){
			LightweightTypeReference lType = converter.toLightweightReference(fieldLiteral.getField().getType());
			ITypeComputationState fieldState = state.withExpectation(lType);
			fieldState.computeTypes(fieldLiteral.getValue());
		}
		
		LightweightTypeReference lType = converter.toLightweightReference(typeRef);
		state.acceptActualType(lType);
	}
	
	protected void _computeTypes(XObjectLiteral object, ITypeComputationState state) {

//		List<JvmMember> parts = object.getProperties();
		
		//创建一个匿名类型，让这个对象拥有这个匿名类型
//		JvmDeclaredType jvmType = TypesFactory.eINSTANCE.createJvmGenericType();
//		object.setType(jvmType);
//		jvmType.setSimpleName("_sasas");
		for(JvmMember part : object.getMembers()){
			JvmField field = (JvmField) part;
			ITypeComputationResult partResult = state.withNonVoidExpectation().computeTypes(field.getDefaultValue());
			
			JvmTypeReference typeRef = services.getTypeReferences().createTypeRef(partResult.getActualExpressionType().getType());
			field.setType(typeRef);
		}
//		
//		object.setType(jvmType);
		
		JvmTypeReference typeRef = services.getTypeReferences().createTypeRef(object);
		
		
		OwnedConverter converter = state.getConverter();
		LightweightTypeReference lType = converter.toLightweightReference(typeRef);
		
		for(ITypeExpectation expectation: state.getExpectations()) {
			expectation.acceptActualType(lType, ConformanceHint.UNCHECKED);
		}
	}
	
	protected void _computeTypes(XArrayLiteral literal, ITypeComputationState state) {
		JvmGenericType listType = (JvmGenericType) Buildin.Array.JvmType;
		
		for(ITypeExpectation expectation: state.getExpectations()) {
			LightweightTypeReference elementTypeExpectation = null;
			LightweightTypeReference expectedType = expectation.getExpectedType();
			if(expectedType != null) {
				if(expectedType.isArray()) {
					elementTypeExpectation = expectedType.getComponentType();
					EnumSet<ConformanceHint> allHints = EnumSet.noneOf(ConformanceHint.class);
					for(XExpression element: literal.getElements()) {
						ITypeComputationResult elementTypeResult = elementTypeExpectation != null
								? state.withExpectation(elementTypeExpectation).computeTypes(element)
								: state.withNonVoidExpectation().computeTypes(element);
						EnumSet<ConformanceHint> hints = elementTypeResult.getCheckedConformanceHints();
						allHints.addAll(hints);
					}
					if (allHints.contains(ConformanceHint.INCOMPATIBLE)) {
						allHints.remove(ConformanceHint.SUCCESS);
						allHints.add(ConformanceHint.SEALED);
						allHints.add(ConformanceHint.CHECKED);
						allHints.add(ConformanceHint.PROPAGATED_TYPE);
						expectation.acceptActualType(expectedType, allHints.toArray(new ConformanceHint[allHints.size()]));
					} else if (allHints.contains(ConformanceHint.SUCCESS)) {
						allHints.add(ConformanceHint.SEALED);
						allHints.add(ConformanceHint.CHECKED);
						expectation.acceptActualType(expectedType, allHints.toArray(new ConformanceHint[allHints.size()]));
					} else {
						expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.SEALED);
					}
					return; 
				} else {
					elementTypeExpectation = getElementOrComponentType(expectedType, state);
				}
			}
//			List<LightweightTypeReference> listTypeCandidates = computeCollectionTypeCandidates(literal, listType, elementTypeExpectation, state);
//			if(!listTypeCandidates.isEmpty()) {
//				LightweightTypeReference commonListType = services.getTypeConformanceComputer().getCommonSuperType(listTypeCandidates, state.getReferenceOwner());
//				if (commonListType != null) {
//					expectation.acceptActualType(commonListType, ConformanceHint.UNCHECKED);
//				} else {
////					expectation.acceptActualType(getTypeForName(Object.class, state), ConformanceHint.UNCHECKED);  //cym comment
//					expectation.acceptActualType(getTypeForName(Buildin.Object.JvmType, state), ConformanceHint.UNCHECKED);
//				}
//			} else {
//				ParameterizedTypeReference unboundCollectionType = new ParameterizedTypeReference(state.getReferenceOwner(), listType);
//				if (elementTypeExpectation != null) {
//					unboundCollectionType.addTypeArgument(elementTypeExpectation);
//				} else {
//					UnboundTypeReference unbound = expectation.createUnboundTypeReference(literal, listType.getTypeParameters().get(0));
//					unboundCollectionType.addTypeArgument(unbound);
//				}
//				expectation.acceptActualType(unboundCollectionType, ConformanceHint.UNCHECKED);
//			}
		}
	}
	
	protected void _computeTypes(final XForLoopStatment object, final ITypeComputationState state) {
		ITypeComputationState initExpectation = state.withoutExpectation();
		XExpression init = object.getInitial();
		if(init!=null){
			initExpectation.computeTypes(init);
		}
		
		List<XExpression> varDeclList = object.getVariableDeclarations();
		if (varDeclList !=null && !varDeclList.isEmpty()) {
			for(XExpression expr : varDeclList){
				XVariableDeclaration decl = (XVariableDeclaration) expr;
				state.withoutExpectation().computeTypes(decl);
				addLocalToCurrentScope(decl, state);
			}
		}
		
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Buildin.Boolean.JvmType, state));
		XExpression condition = object.getCondition();
		conditionExpectation.computeTypes(condition);
		
		ITypeComputationState incrementExpectation = state.withoutExpectation();
		XExpression increment = object.getIncrement();
		if(increment!=null){
			incrementExpectation.computeTypes(increment);
		}

		ITypeComputationState statmentState = state.withoutExpectation();
		computeTypes(object.getStatment(), statmentState);
		
	}

	private List<LightweightTypeReference> computeCollectionTypeCandidates(XArrayLiteral literal, JvmGenericType collectionType,
			@Nullable LightweightTypeReference elementTypeExpectation, ITypeComputationState state) {
		if(!literal.getElements().isEmpty()) {
			List<LightweightTypeReference> elementTypes = newArrayList();
			for(XExpression element: literal.getElements()) {
				ITypeComputationResult elementType = elementTypeExpectation != null 
						? state.withExpectation(elementTypeExpectation).computeTypes(element)
						: state.withNonVoidExpectation().computeTypes(element);
				LightweightTypeReference actualType = elementType.getActualExpressionType();
				if(actualType != null && !actualType.isAny()) {
					ParameterizedTypeReference collectionTypeCandidate = new ParameterizedTypeReference(state.getReferenceOwner(), collectionType);
					collectionTypeCandidate.addTypeArgument(actualType.getWrapperTypeIfPrimitive());
					elementTypes.add(collectionTypeCandidate);
				}
			}
			return elementTypes;
		}
		return Collections.emptyList();
	}
	
	protected void _computeTypes(XClosure closure, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			new ClosureTypeComputer(closure, expectation, state, this).computeTypes();
		}
	}

	protected void _computeTypes(XCastedExpression object, ITypeComputationState state) {
		// TODO: should we hold on the previously known expression?
		/* 
		 * ('foo' as CharSequence) as NullPointerException
		 * In this case, we know - even though it's CharSequence on the Java side - 
		 * that the type of ('foo' as CharSequence) is still a String
		 * which is not conformant to NPE. The subsequent cast will always fail at
		 * runtime. This could be detected.
		 * 
		 * It could be interesting to have a subtype of MultiTypeReference, e.g. CastedTypeReference
		 * that still knows about the original type. This would be similar to a nested switch
		 * with the difference, that we want to know which type to use on the Java side in order
		 * to disambiguate overloaded methods:
		 * 
		 * m(Object o) {} // 1
		 * m(String s) {}
		 * 
		 * {
		 *   val o = '' as Object
		 *   m(o) // calls 1
		 *   o.substring(1) // valid, too - compiler could insert the cast back to String
		 * }
		 */
		JvmTypeReference type = object.getType();
		if (type != null) {
			state.withNonVoidExpectation().computeTypes(object.getTarget());
			state.acceptActualType(state.getConverter().toLightweightReference(type));
		} else {
			state.computeTypes(object.getTarget());
		}
	}



	protected LightweightTypeReference getAndEnhanceIterableOrArrayFromComponent(LightweightTypeReference parameterType, JvmInterfaceType iterableType,
			final CompoundTypeReference compoundResult) {
		if (parameterType.isUnknown()) {
			compoundResult.addComponent(parameterType);
			return parameterType;
		}
		ITypeReferenceOwner owner = compoundResult.getOwner();
		LightweightTypeReference iterableOrArray = null;
		LightweightTypeReference addAsArrayComponentAndIterable = null;
		if (parameterType.isPrimitive()) {
			iterableOrArray = new ArrayTypeReference(owner, parameterType);
			compoundResult.addComponent(iterableOrArray);
			addAsArrayComponentAndIterable = parameterType.getWrapperTypeIfPrimitive();
		} else if (parameterType.isAny()) {
//			addAsArrayComponentAndIterable = getRawTypeForName(Object.class, parameterType.getOwner());  //cym comment
			addAsArrayComponentAndIterable = getRawTypeForName(Buildin.Object.JvmType, parameterType.getOwner());
		} else {
			addAsArrayComponentAndIterable = parameterType;
		}
		ParameterizedTypeReference reference = new ParameterizedTypeReference(owner, iterableType);
		WildcardTypeReference wildcard = new WildcardTypeReference(owner);
		wildcard.addUpperBound(addAsArrayComponentAndIterable);
		reference.addTypeArgument(wildcard);
		compoundResult.addComponent(reference);
		if (iterableOrArray == null) {
			iterableOrArray = reference;
			LightweightTypeReference potentialPrimitive = addAsArrayComponentAndIterable.getPrimitiveIfWrapperType();
			if (potentialPrimitive != addAsArrayComponentAndIterable) {
				compoundResult.addComponent(new ArrayTypeReference(owner, potentialPrimitive));
			}
		}
		compoundResult.addComponent(new ArrayTypeReference(owner, addAsArrayComponentAndIterable));
		return iterableOrArray;
	}

	@Nullable
	private LightweightTypeReference getElementOrComponentType(final LightweightTypeReference iterableOrArray,
			final ITypeComputationState state) {
		LightweightTypeReference parameterType;
		parameterType = iterableOrArray.accept(new TypeReferenceVisitorWithResult<LightweightTypeReference>() {
			@Override
			public LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference) {
				DeclaratorTypeArgumentCollector typeArgumentCollector = new ConstraintAwareTypeArgumentCollector(state.getReferenceOwner());
				Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = typeArgumentCollector.getTypeParameterMapping(reference);
				TypeParameterSubstitutor<?> substitutor = new UnboundTypeParameterPreservingSubstitutor(typeParameterMapping, state.getReferenceOwner());
//				JvmGenericType iterable = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, iterableOrArray.getOwner().getContextResourceSet());  //cym comment
				JvmGenericType iterable = (JvmGenericType) Buildin.Iterable.JvmType;
				
				ParameterizedTypeReference substituteMe = new ParameterizedTypeReference(state.getReferenceOwner(), iterable.getTypeParameters().get(0));
				LightweightTypeReference substitutedArgument = substitutor.substitute(substituteMe).getUpperBoundSubstitute();
				if (substitutedArgument.getType() instanceof JvmTypeParameter && 
						!(state.getReferenceOwner().getDeclaredTypeParameters().contains(substitutedArgument.getType()))) {
					return substitutedArgument.getRawTypeReference();
				}
				return substitutedArgument;
			}
			@Override
			protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference) {
				return reference;
			}
			@Override
			protected LightweightTypeReference doVisitUnknownTypeReference(UnknownTypeReference reference) {
				return reference;
			}
			@Override
			public LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference) {
				return reference.getComponentType();
			}
			@Override
			@Nullable
			protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference) {
				return null;
			}
		});
		return parameterType;
	}

	@Nullable
	protected LightweightTypeReference getDeclaredParameterType(JvmFormalParameter declaredParam, final ITypeComputationState state) {
		JvmTypeReference parameterType = declaredParam.getParameterType();
		if (parameterType == null)
			return null;
		return state.getConverter().toLightweightReference(parameterType);
	}


	protected void _computeTypes(XTypeLiteral object, ITypeComputationState state) {
		JvmType type = object.getType();
		if (type == null) {
			return;
		}
		checkTypeParameterNotAllowedAsLiteral(object, type, state);
		ITypeReferenceOwner owner = state.getReferenceOwner();
		LightweightTypeReference clazz = new ParameterizedTypeReference(owner, object.getType());
		for (int i = 0; i < object.getArrayDimensions().size(); i++) {
			clazz = new ArrayTypeReference(clazz.getOwner(), clazz);
		}
		if (object.getArrayDimensions().isEmpty()) {
			if (clazz.isPrimitiveVoid()) {
//				JvmType voidType = services.getTypeReferences().findDeclaredType(Void.class, object); //cym comment
				JvmType voidType = Buildin.Void.JvmType; //services.getTypeReferences().findDeclaredType(Void.class, object);
//				if (voidType == null) {
//					clazz = new UnknownTypeReference(owner, Void.class.getName());
//				} else {
					clazz = new ParameterizedTypeReference(owner, voidType);
//				}
			} else {
				clazz = clazz.getWrapperTypeIfPrimitive();
			}
		}
//		ParameterizedTypeReference result = getRawTypeForName(Class.class, owner);  //cym comment
		ParameterizedTypeReference result = getRawTypeForName(Buildin.Type.JvmType, owner);
		result.addTypeArgument(clazz);
		state.acceptActualType(result);
	}
	
	private void checkTypeParameterNotAllowedAsLiteral(EObject ctx, JvmType type, ITypeComputationState state) {
		if (type instanceof JvmTypeParameter) {
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
					"Illegal class literal for the type parameter " + type.getSimpleName()+".",
					ctx,
					null,
					-1,
					new String[] { 
					}));
		}
	}

	protected void _computeTypes(XInstanceOfExpression object, ITypeComputationState state) {
//		ITypeComputationState expressionState = state.withExpectation(getRawTypeForName(Object.class, state.getReferenceOwner()));  //cym comment
		ITypeComputationState expressionState = state.withExpectation(getRawTypeForName(Buildin.Object.JvmType, state.getReferenceOwner()));
		expressionState.computeTypes(object.getExpression());
		JvmTypeReference type = object.getType();
		if (type != null && type.getType() instanceof JvmTypeParameter) {
			LightweightTypeReference lightweightReference = state.getConverter().toLightweightReference(type);
			LightweightTypeReference rawTypeRef = lightweightReference.getRawTypeReference();
			state.addDiagnostic(new EObjectDiagnosticImpl(
					Severity.ERROR,
					IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
					"Cannot perform instanceof check against type parameter "+lightweightReference.getSimpleName()+". Use its erasure "+rawTypeRef.getSimpleName()+" instead since further generic type information will be erased at runtime.",
					object.getType(),
					null,
					-1,
					new String[] { 
					}));
		}
//		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state); //cym comment
		LightweightTypeReference bool = getTypeForName(Buildin.Boolean.JvmType, state);  
		state.acceptActualType(bool);
	}


	protected void _computeTypes(XPostfixOperation object, ITypeComputationState state) {
		ITypeComputationState numberState = state.withExpectation(getTypeForName(Buildin.Number.JvmType, state));
		numberState.computeTypes(object.getOperand());
				
		LightweightTypeReference numberType = getTypeForName(Buildin.Number.JvmType, state);
		state.acceptActualType(numberType);
	}
	
	protected void _computeTypes(XTernaryOperation object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Buildin.Boolean.JvmType, state));
		XExpression condition = object.getCondition();
		conditionExpectation.computeTypes(condition);
		
		// TODO then expression may influence the expected type of else and vice versa
		XExpression trueOperand = object.getTrueOperand();
		ITypeComputationState thenState = reassignCheckedType(condition, trueOperand, state);
		ITypeComputationResult thenResult = thenState.computeTypes(trueOperand);
		XExpression elseExpression = object.getFalseOperand();
		if (elseExpression != null) {
			state.computeTypes(elseExpression);
		} else {
			BranchExpressionProcessor processor = new BranchExpressionProcessor(state, object) {
				@Override
				protected String getMessage() {
					return "Missing else branch for conditional expression with primitive type";
				}
			};
			processor.process(thenResult);
			processor.commit();
		}
	}

	protected void _computeTypes(XIndexer object, ITypeComputationState state) {
		//计算source，找对source的类型
		//找出这个类型的indexer
		//计算参数类型，按照方法的形式来计算
		//找出这个indexer返回类型
		
//		for(XExpression argument : object.getArguments()){
//			state.withoutExpectation().computeTypes(argument);
//		}
//		
//		ITypeComputationResult result = state.computeTypes(object.getSource());
//		LightweightTypeReference actualType = result.getActualExpressionType();
//		JvmType jvmType = actualType.getType();
//		if(!(jvmType instanceof JvmGenericType)){
//			throw new IllegalStateException();
//		}
//		JvmGenericType type = (JvmGenericType) jvmType;
//		JvmField indexer = null;
//		for(JvmMember member : type.getMembers()){
//			if(member instanceof JvmField && ((JvmField)member).isIndexer()){
//				indexer = (JvmIndexer) member;
//				break;
//			}
//		}
		
//		if(indexer == null){
//			throw new IllegalStateException();
//		}
//		
//		object.setFeature(indexer);
//		LightweightTypeReference typeRef = state.getConverter().toLightweightReference(indexer.getType());
//		state.acceptActualType(typeRef);
		

	}
	
//	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
//		List<LightweightTypeReference> caughtExceptions = Lists.newArrayList();
//		OwnedConverter converter = state.getConverter();
//		for (XCatchClause catchClause : object.getCatchClauses())
//			if (catchClause.getDeclaredParam() != null && catchClause.getDeclaredParam().getParameterType() != null)
//				caughtExceptions.add(converter.toLightweightReference(catchClause.getDeclaredParam().getParameterType()));
//		state.withExpectedExceptions(caughtExceptions).computeTypes(object.getExpression());
//		for (XCatchClause catchClause : object.getCatchClauses()) {
//			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
//			JvmTypeReference parameterType = catchClauseParam.getParameterType();
//			LightweightTypeReference lightweightReference = parameterType != null 
//					? state.getConverter().toLightweightReference(parameterType)
//					: new AnyTypeReference(state.getReferenceOwner());
//			ITypeComputationState catchClauseState = assignType(catchClauseParam, lightweightReference, state);
//			catchClauseState.computeTypes(catchClause.getExpression());
//		}
//		// TODO validate / handle return / throw in finally block
//		state.withoutExpectation().computeTypes(object.getFinallyExpression());
//	}
	
	protected void _computeTypes(XTryCatchFinallyStatment object, ITypeComputationState state) {
		XCatchClause catchClause = object.getCatchClause();
		if(catchClause != null){
			computeTypes(catchClause.getStatment(), state);
		}

//		}
		// TODO validate / handle return / throw in finally block
		computeTypes(object.getFinallyStatment(), state);
	}
	
	protected void _computeTypes(final XAssignment assignment, ITypeComputationState state) {
		//TODO 需要处理期望类型和实际类型
		if(((XAbstractFeatureCallImpl)assignment).basicGetFeature() == null){
			computeTypes(assignment.getAssignable(), state);
			if(assignment.getAssignable() instanceof XFeatureCall){
				XFeatureCall featureCall = (XFeatureCall) assignment.getAssignable();
				List<IFeatureLinkingCandidate> candidates = ((AbstractTypeComputationState)state).getLinkingCandidates(featureCall);
				
				if(candidates.size()>0 && candidates.get(0).getFeature() instanceof JvmField){
					JvmField field = (JvmField) candidates.get(0).getFeature();
					ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(field.getType().getType(), state));
					conditionExpectation.computeTypes(assignment.getValue());
				}
			}
//			computeTypes(assignment.getAssignable(), state);
//			computeTypes(assignment.getValue(), state);
			return;
		}
		
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(assignment);
		ILinkingCandidate best = getBestCandidate(candidates);
		JvmIdentifiableElement feature = best.getFeature();
		if (feature != null && mustDiscardRefinement(feature)) {
			state.discardReassignedTypes(feature);
		}
		best.applyToComputationState();
	}
	
	protected void _computeTypes(final XAbstractFeatureCall featureCall, ITypeComputationState state) {
		List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates(featureCall);
		ILinkingCandidate best = getBestCandidate(candidates);
		if (best instanceof ITypeLiteralLinkingCandidate) {
			ITypeLiteralLinkingCandidate candidate = (ITypeLiteralLinkingCandidate) best;
			checkTypeParameterNotAllowedAsLiteral(featureCall, candidate.getType(), state);
		}
		best.applyToComputationState();
	}
	
	protected ILinkingCandidate getBestCandidate(List<? extends ILinkingCandidate> candidates) {
		ILinkingCandidate result = candidates.get(0);
		for(int i = 1; i < candidates.size(); i++) {
			ILinkingCandidate candidate = candidates.get(i);
			result = result.getPreferredCandidate(candidate);
		}
		return result;
	}

	@Nullable
	protected JvmIdentifiableElement getRefinableCandidate(XExpression object, ITypeComputationState state) {
		if (object instanceof XFeatureCall) {
			List<? extends IFeatureLinkingCandidate> candidates = state.getLinkingCandidates((XFeatureCall)object);
			if (candidates.size() == 1) {
				JvmIdentifiableElement linkedFeature = candidates.get(0).getFeature();
				if (isRefinableFeature(linkedFeature)) {
					return linkedFeature;
				}
			}
		}
		return null;
	}

	protected boolean isRefinableFeature(@Nullable JvmIdentifiableElement feature) {
		return feature instanceof XVariableDeclaration
				|| feature instanceof JvmFormalParameter 
				|| feature instanceof JvmField;
	}
	
	protected boolean mustDiscardRefinement(JvmIdentifiableElement feature) {
		if (feature instanceof XVariableDeclaration) {
			return ((XVariableDeclarationList) feature.eContainer()).isReadonly();  //cym modified
		}
		if (feature instanceof JvmField) {
			return !((JvmField) feature).isConst();
		}
		return false;
	}
	
}
