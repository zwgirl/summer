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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.diagnostics.AbstractDiagnostic;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.validation.EObjectDiagnosticImpl;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAbstractWhileExpression;
import org.summer.dsl.model.xbase.XArrayLiteral;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBlockExpression;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XBreakExpression;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XContinueExpression;
import org.summer.dsl.model.xbase.XDoWhileExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XForEachExpression;
import org.summer.dsl.model.xbase.XForLoopExpression;
import org.summer.dsl.model.xbase.XIfExpression;
import org.summer.dsl.model.xbase.XIndexOperation;
import org.summer.dsl.model.xbase.XInstanceOfExpression;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XObjectLiteral;
import org.summer.dsl.model.xbase.XObjectLiteralPart;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XPrefixOperation;
import org.summer.dsl.model.xbase.XReturnExpression;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XStructLiteral;
import org.summer.dsl.model.xbase.XSwitchExpression;
import org.summer.dsl.model.xbase.XTernaryOperation;
import org.summer.dsl.model.xbase.XThrowExpression;
import org.summer.dsl.model.xbase.XTryCatchFinallyExpression;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.model.xbase.XVariableDeclaration;
import org.summer.dsl.model.xbase.XVariableDeclarationList;
import org.summer.dsl.model.xbase.XWhileExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceResult;
import org.summer.dsl.xbase.typesystem.internal.ITypeLiteralLinkingCandidate;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
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
import org.summer.dsl.xbase.typesystem.util.ExtendedEarlyExitComputer;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;
import org.summer.dsl.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;
import org.summer.dsl.xbase.validation.IssueCodes;

import com.google.common.collect.Lists;
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
		if (expression instanceof XAssignment) {
			_computeTypes((XAssignment)expression, state);
		} else if (expression instanceof XAbstractFeatureCall) {
			_computeTypes((XAbstractFeatureCall)expression, state);
		} else if (expression instanceof XDoWhileExpression) {
			_computeTypes((XDoWhileExpression)expression, state);
		} else if (expression instanceof XWhileExpression) {
			_computeTypes((XWhileExpression)expression, state);
		} else if (expression instanceof XBlockExpression) {
			_computeTypes((XBlockExpression)expression, state);
		} else if (expression instanceof XBooleanLiteral) {
			_computeTypes((XBooleanLiteral)expression, state);
		} else if (expression instanceof XCastedExpression) {
			_computeTypes((XCastedExpression)expression, state);
		} else if (expression instanceof XClosure) {
			_computeTypes((XClosure)expression, state);
		} else if (expression instanceof XConstructorCall) {
			_computeTypes((XConstructorCall)expression, state);
		} else if (expression instanceof XForLoopExpression) {
			_computeTypes((XForLoopExpression)expression, state);
		} else if (expression instanceof XForEachExpression) {
			_computeTypes((XForEachExpression)expression, state);
		} else if (expression instanceof XIfExpression) {
			_computeTypes((XIfExpression)expression, state);
		} else if (expression instanceof XInstanceOfExpression) {
			_computeTypes((XInstanceOfExpression)expression, state);
		} else if (expression instanceof XNumberLiteral) {
			_computeTypes((XNumberLiteral)expression, state);
		} else if (expression instanceof XNullLiteral) {
			_computeTypes((XNullLiteral)expression, state);
		} else if (expression instanceof XReturnExpression) {
			_computeTypes((XReturnExpression)expression, state);
		} else if (expression instanceof XStringLiteral) {
			_computeTypes((XStringLiteral)expression, state);
		} else if (expression instanceof XSwitchExpression) {
			_computeTypes((XSwitchExpression)expression, state);
		} else if (expression instanceof XThrowExpression) {
			_computeTypes((XThrowExpression)expression, state);
		} else if (expression instanceof XTryCatchFinallyExpression) {
			_computeTypes((XTryCatchFinallyExpression)expression, state);
		} else if (expression instanceof XTypeLiteral) {
			_computeTypes((XTypeLiteral)expression, state);
		} else if (expression instanceof XVariableDeclarationList) {
			_computeTypes((XVariableDeclarationList)expression, state);
		} else if (expression instanceof XVariableDeclaration) {
			_computeTypes((XVariableDeclaration)expression, state);
		} 
//		else if (expression instanceof XListLiteral) {
//			_computeTypes((XListLiteral)expression, state);
//		} else if (expression instanceof XSetLiteral) {
//			_computeTypes((XSetLiteral)expression, state);
//		} 
		else if (expression instanceof XPrefixOperation) {
			_computeTypes((XPrefixOperation)expression, state);
		} else if (expression instanceof XPostfixOperation) {
			_computeTypes((XPostfixOperation)expression, state);
		}  else if (expression instanceof XIndexOperation) {
			_computeTypes((XIndexOperation)expression, state);
		}  else if (expression instanceof XBreakExpression) {
			_computeTypes((XBreakExpression)expression, state);
		} else if (expression instanceof XContinueExpression) {
			_computeTypes((XContinueExpression)expression, state);
		} else if (expression instanceof XTernaryOperation) {
			_computeTypes((XTernaryOperation)expression, state);
		} else if (expression instanceof XObjectLiteral) {
			_computeTypes((XObjectLiteral)expression, state);
		} else if (expression instanceof XStructLiteral) {
			_computeTypes((XStructLiteral)expression, state);
		} else if (expression instanceof XArrayLiteral) {
			_computeTypes((XArrayLiteral)expression, state);
		} else { 
			throw new UnsupportedOperationException("Missing type computation for expression type: " + expression.eClass().getName() + " / " + state);
		}
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
	
	protected ParameterizedTypeReference getRawTypeForName(Class<?> clazz, ITypeReferenceOwner owner) {
		JvmType clazzType = services.getTypeReferences().findDeclaredType(clazz, owner.getContextResourceSet());
		ParameterizedTypeReference result = new ParameterizedTypeReference(owner, clazzType);
		return result;
	}
	
	protected LightweightTypeReference getPrimitiveVoid(ITypeComputationState state) {
		return getTypeForName(Void.TYPE, state);
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
	
	protected void _computeTypes(XIfExpression object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		XExpression condition = object.getIf();
		conditionExpectation.computeTypes(condition);
		
		// TODO then expression may influence the expected type of else and vice versa
		XExpression thenExpression = getThen(object);
		ITypeComputationState thenState = reassignCheckedType(condition, thenExpression, state);
		ITypeComputationResult thenResult = thenState.computeTypes(thenExpression);
		XExpression elseExpression = getElse(object);
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

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	protected XExpression getElse(XIfExpression ifExpression) {
		return ifExpression.getElse();
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	@Nullable
	protected XExpression getThen(XIfExpression ifExpression) {
		return ifExpression.getThen();
	}
	
	protected void _computeTypes(XSwitchExpression object, ITypeComputationState state) {
		ITypeComputationState switchExpressionState = state.withNonVoidExpectation();
		ITypeComputationResult computedType = switchExpressionState.computeTypes(object.getSwitch());
		ITypeComputationState allCasePartsState = state;
		LightweightTypeReference expressionType = computedType.getActualExpressionType();
		if (object.getLocalVarName() != null) {
			allCasePartsState = allCasePartsState.assignType(object, expressionType);
		}
		JvmType potentialEnumType = expressionType != null ? expressionType.getType() : null;
		boolean isEnum = potentialEnumType instanceof JvmEnumerationType;
		BranchExpressionProcessor branchExpressionProcessor = object.getDefault() == null ? new BranchExpressionProcessor(state, object) {
				@Override
				protected String getMessage() {
					return "Missing default branch for switch expression with primitive type";
				}
		}: null;
		// TODO case expressions may influence the expected type of other cases
		for(XCasePart casePart: getCases(object)) {
			// assign the type for the switch expression if possible and use that one for the remaining things
			ITypeComputationState casePartState = allCasePartsState.withTypeCheckpoint(casePart);
			boolean localIsEnum = isEnum;
			JvmType localPotentialEnumType = potentialEnumType;
			if (casePart.getTypeGuard() != null) {
				JvmIdentifiableElement refinable = null;
				if (object.getLocalVarName() != null) {
					refinable = getRefinableCandidate(object, casePartState);
				} else {
					refinable = getRefinableCandidate(object.getSwitch(), casePartState);
				}
				if (refinable != null) {
					casePartState.reassignType(refinable, casePartState.getConverter().toLightweightReference(casePart.getTypeGuard()));
				}
				if (!localIsEnum) {
					JvmType typeGuard = casePart.getTypeGuard().getType();
					if (typeGuard instanceof JvmEnumerationType) {
						localIsEnum = true; 
						localPotentialEnumType = typeGuard;
					}
					if (typeGuard instanceof JvmTypeParameter) {
						state.addDiagnostic(new EObjectDiagnosticImpl(
								Severity.ERROR,
								IssueCodes.INVALID_USE_OF_TYPE_PARAMETER,
								"Cannot perform type switch against type parameter "+typeGuard.getSimpleName()+". Use its erasure Object instead since further generic type information will be erased at runtime.",
								casePart.getTypeGuard(),
								null,
								-1,
								new String[] { 
								}));
					}
				}
			}
			if (casePart.getCase() != null) {
				// boolean or object / primitive
				ITypeComputationState caseState = casePartState.withNonVoidExpectation();
				if (localIsEnum) {
					assert potentialEnumType != null;
					caseState.addTypeToStaticImportScope((JvmDeclaredType) localPotentialEnumType);
				}
				caseState.computeTypes(casePart.getCase());
			}
			ITypeComputationResult thenResult = casePartState.computeTypes(casePart.getThen());
			if (branchExpressionProcessor != null) {
				branchExpressionProcessor.process(thenResult);
			}
		}
		XExpression defaultCase = object.getDefault();
		if (defaultCase != null) {
			allCasePartsState.computeTypes(object.getDefault());
		} else if (branchExpressionProcessor != null) {
			branchExpressionProcessor.commit();
		}
	}

	/**
	 * Only for testing purpose.
	 * @nooverride This method is not intended to be re-implemented or extended by clients.
	 * @noreference This method is not intended to be referenced by clients.
	 */
	protected List<XCasePart> getCases(XSwitchExpression switchExpression) {
		return switchExpression.getCases();
	}
	
	protected void _computeTypes(XBlockExpression object, ITypeComputationState state) {
		List<XExpression> children = object.getExpressions();
		if (children.isEmpty()) {
			for (ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null && expectedType.isPrimitiveVoid()) {
					expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
				} else {
					expectation.acceptActualType(new AnyTypeReference(expectation.getReferenceOwner()), ConformanceHint.UNCHECKED);
				}
			}
		} else {
			for(int i = 0; i < children.size() - 1; i++) {
				XExpression expression = children.get(i);
				ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
				expressionState.computeTypes(expression);
				//cym comment
//				if (expression instanceof XVariableDeclaration) {
//					addLocalToCurrentScope((XVariableDeclaration)expression, state);
//				}
				
				if (expression instanceof XVariableDeclarationList) {
					XVariableDeclarationList declList = (XVariableDeclarationList) expression;
					for(XExpression exp : declList.getDeclarations()){
						addLocalToCurrentScope((XVariableDeclaration)exp, state);
					}
				}
			}
			XExpression lastExpression = children.get(children.size() - 1);
			for (ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null && expectedType.isPrimitiveVoid()) {
					ITypeComputationState expressionState = state.withoutExpectation(); // no expectation
					expressionState.computeTypes(lastExpression);
					//cym comment
//					if (lastExpression instanceof XVariableDeclaration) {
//						addLocalToCurrentScope((XVariableDeclaration)lastExpression, state);
//					}
					if (lastExpression instanceof XVariableDeclarationList) {
						XVariableDeclarationList declList = (XVariableDeclarationList) lastExpression;
						for(XExpression exp : declList.getDeclarations()){
							addLocalToCurrentScope((XVariableDeclaration)exp, state);
						}
					}
					expectation.acceptActualType(getPrimitiveVoid(state), ConformanceHint.CHECKED, ConformanceHint.SUCCESS);
				} else {
					state.computeTypes(lastExpression);
					// add the last expression to the scope, too in order validate for duplicate names, even
					// though the variable declaration could be removed automatically to keep only the side effect
					// of the initializer
					//cym comment
//					if (lastExpression instanceof XVariableDeclaration) {
//						addLocalToCurrentScope((XVariableDeclaration)lastExpression, state);
//					}
					if (lastExpression instanceof XVariableDeclarationList) {
						XVariableDeclarationList declList = (XVariableDeclarationList) lastExpression;
						for(XExpression exp : declList.getDeclarations()){
							addLocalToCurrentScope((XVariableDeclaration)exp, state);
						}
					}
				}
			}
		}
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
				variableType = lightweightTypeReference;
				ExtendedEarlyExitComputer earlyExitComputer = state.getReferenceOwner().getServices().getEarlyExitComputer();
				if (earlyExitComputer.isDefiniteEarlyExit(computedType.getExpression())) {
					AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
							Severity.ERROR,
							IssueCodes.UNREACHABLE_CODE, 
							"Dead code: The variable " + object.getSimpleName() + " will never be assigned.",
							object,
							XbasePackage.Literals.XVARIABLE_DECLARATION__NAME,
							-1,
							null);
					state.addDiagnostic(diagnostic);
				}
			} else {
				variableType = computedType.getActualExpressionType();
			}
			if (variableType != null && variableType.isPrimitiveVoid()) {
				variableType = new UnknownTypeReference(variableType.getOwner());
			}
			state.assignType(object, variableType, false);
			state.addExtensionToCurrentScope(object);
		}
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected void _computeTypes(final XConstructorCall constructorCall, ITypeComputationState state) {
		List<? extends IConstructorLinkingCandidate> candidates = state.getLinkingCandidates(constructorCall);
		ILinkingCandidate best = getBestCandidate(candidates);
		best.applyToComputationState();
	}
	
	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XBooleanLiteral object, ITypeComputationState state) {
//		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);  //cym comment
		LightweightTypeReference bool = getTypeForName(Buildin.Boolean.Type, state);
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
		// cym comment
		LightweightTypeReference result = getTypeForName(numberLiterals.getType(object), state);
//		LightweightTypeReference result = getTypeForName(BuildInTypes.getInstance().getNumberType(object.eResource()), state);
		state.acceptActualType(result);
	}

	/**
	 * @param object used for dispatching
	 */
	protected void _computeTypes(XStringLiteral object, ITypeComputationState state) {
		if (object.getValue().length() != 1) {
			//LightweightTypeReference result = getTypeForName(String.class, state);
			LightweightTypeReference result = getTypeForName(Buildin.String.Type, state);
			
			state.acceptActualType(result);
		} else {
			for(ITypeExpectation expectation: state.getExpectations()) {
				LightweightTypeReference expectedType = expectation.getExpectedType();
				if (expectedType != null) {
					if (expectedType.isType(Character.TYPE) || expectedType.isType(Character.class)) {
						expectation.acceptActualType(expectedType, ConformanceHint.CHECKED, ConformanceHint.SUCCESS, ConformanceHint.DEMAND_CONVERSION, ConformanceHint.SEALED);
					} else {
						LightweightTypeReference type = getTypeForName(String.class, state);
						expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
					}
				} else {
//					LightweightTypeReference type = getTypeForName(String.class, state);
					LightweightTypeReference type = getTypeForName(Buildin.String.Type, state);
					expectation.acceptActualType(type, ConformanceHint.UNCHECKED);
				}
			}
		}
	}
	
	protected void _computeTypes(XStructLiteral object, ITypeComputationState state) {

//		for(JvmMember part : object.getMembers()){
//			JvmField field = (JvmField) part;
//			ITypeComputationResult partResult = state.withNonVoidExpectation().computeTypes(field.getDefaultValue());
//			
//			JvmTypeReference typeRef = services.getTypeReferences().createTypeRef(partResult.getActualExpressionType().getType());
//			field.setType(typeRef);
//		}
		
		JvmTypeReference typeRef = services.getTypeReferences().createTypeRef(object.getType());
		
		
		OwnedConverter converter = state.getConverter();
		LightweightTypeReference lType = converter.toLightweightReference(typeRef);
		
		for(ITypeExpectation expectation: state.getExpectations()) {
			expectation.acceptActualType(lType, ConformanceHint.UNCHECKED);
		}
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
		JvmGenericType listType = (JvmGenericType) Buildin.Array.Type;
		
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
			List<LightweightTypeReference> listTypeCandidates = computeCollectionTypeCandidates(literal, listType, elementTypeExpectation, state);
			if(!listTypeCandidates.isEmpty()) {
				LightweightTypeReference commonListType = services.getTypeConformanceComputer().getCommonSuperType(listTypeCandidates, state.getReferenceOwner());
				if (commonListType != null) {
					expectation.acceptActualType(commonListType, ConformanceHint.UNCHECKED);
				} else {
//					expectation.acceptActualType(getTypeForName(Object.class, state), ConformanceHint.UNCHECKED);  //cym comment
					expectation.acceptActualType(getTypeForName(Buildin.Object.Type, state), ConformanceHint.UNCHECKED);
				}
			} else {
				ParameterizedTypeReference unboundCollectionType = new ParameterizedTypeReference(state.getReferenceOwner(), listType);
				if (elementTypeExpectation != null) {
					unboundCollectionType.addTypeArgument(elementTypeExpectation);
				} else {
					UnboundTypeReference unbound = expectation.createUnboundTypeReference(literal, listType.getTypeParameters().get(0));
					unboundCollectionType.addTypeArgument(unbound);
				}
				expectation.acceptActualType(unboundCollectionType, ConformanceHint.UNCHECKED);
			}
		}
	}
	
//	protected void _computeTypes(XListLiteral literal, ITypeComputationState state) {
//		JvmGenericType listType = (JvmGenericType) services.getTypeReferences().findDeclaredType(List.class, literal);
//		for(ITypeExpectation expectation: state.getExpectations()) {
//			LightweightTypeReference elementTypeExpectation = null;
//			LightweightTypeReference expectedType = expectation.getExpectedType();
//			if(expectedType != null) {
//				if(expectedType.isArray()) {
//					elementTypeExpectation = expectedType.getComponentType();
//					EnumSet<ConformanceHint> allHints = EnumSet.noneOf(ConformanceHint.class);
//					for(XExpression element: literal.getElements()) {
//						ITypeComputationResult elementTypeResult = elementTypeExpectation != null
//								? state.withExpectation(elementTypeExpectation).computeTypes(element)
//								: state.withNonVoidExpectation().computeTypes(element);
//						EnumSet<ConformanceHint> hints = elementTypeResult.getCheckedConformanceHints();
//						allHints.addAll(hints);
//					}
//					if (allHints.contains(ConformanceHint.INCOMPATIBLE)) {
//						allHints.remove(ConformanceHint.SUCCESS);
//						allHints.add(ConformanceHint.SEALED);
//						allHints.add(ConformanceHint.CHECKED);
//						allHints.add(ConformanceHint.PROPAGATED_TYPE);
//						expectation.acceptActualType(expectedType, allHints.toArray(new ConformanceHint[allHints.size()]));
//					} else if (allHints.contains(ConformanceHint.SUCCESS)) {
//						allHints.add(ConformanceHint.SEALED);
//						allHints.add(ConformanceHint.CHECKED);
//						expectation.acceptActualType(expectedType, allHints.toArray(new ConformanceHint[allHints.size()]));
//					} else {
//						expectation.acceptActualType(expectedType, ConformanceHint.SUCCESS, ConformanceHint.CHECKED, ConformanceHint.SEALED);
//					}
//					return; 
//				} else {
//					elementTypeExpectation = getElementOrComponentType(expectedType, state);
//				}
//			}
//			List<LightweightTypeReference> listTypeCandidates = computeCollectionTypeCandidates(literal, listType, elementTypeExpectation, state);
//			if(!listTypeCandidates.isEmpty()) {
//				LightweightTypeReference commonListType = services.getTypeConformanceComputer().getCommonSuperType(listTypeCandidates, state.getReferenceOwner());
//				if (commonListType != null) {
//					expectation.acceptActualType(commonListType, ConformanceHint.UNCHECKED);
//				} else {
//					expectation.acceptActualType(getTypeForName(Object.class, state), ConformanceHint.UNCHECKED);
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
//		}
//
//	}
	
//	protected void _computeTypes(XSetLiteral literal, ITypeComputationState state) {
//		JvmGenericType setType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Set.class, literal);
//		JvmGenericType mapType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Map.class, literal);
//		for(ITypeExpectation expectation: state.getExpectations()) {
//			LightweightTypeReference elementTypeExpectation = null;
//			LightweightTypeReference expectedType = expectation.getExpectedType();
//			if(expectedType != null) {
//				elementTypeExpectation = getElementOrComponentType(expectedType, state);
//			}
//			List<LightweightTypeReference> setTypeCandidates = computeCollectionTypeCandidates(literal, setType, elementTypeExpectation, state);
//			LightweightTypeReference commonSetType = !setTypeCandidates.isEmpty() 
//					? services.getTypeConformanceComputer().getCommonSuperType(setTypeCandidates, state.getReferenceOwner())
//					: null;
//			if(commonSetType != null) {
//				LightweightTypeReference commonElementType = commonSetType.getTypeArguments().get(0).getInvariantBoundSubstitute();
//				JvmGenericType pairType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Pair.class, literal);
//				if(!(expectedType != null && expectedType.isType(Set.class)) && commonElementType.getType() == pairType) {
//					Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping = new DeclaratorTypeArgumentCollector().getTypeParameterMapping(commonElementType);
//					ParameterizedTypeReference boundMapType = new ParameterizedTypeReference(state.getReferenceOwner(), mapType);
//					boundMapType.addTypeArgument(typeParameterMapping.get(pairType.getTypeParameters().get(0)).getTypeReference().getInvariantBoundSubstitute());
//					boundMapType.addTypeArgument(typeParameterMapping.get(pairType.getTypeParameters().get(1)).getTypeReference().getInvariantBoundSubstitute());
//					expectation.acceptActualType(boundMapType, ConformanceHint.UNCHECKED);
//				} else {
//					expectation.acceptActualType(commonSetType, ConformanceHint.UNCHECKED);
//				}
//			} else {
//				if(expectedType != null && expectedType.isType(Map.class)) {
//					ParameterizedTypeReference unboundCollectionType = new ParameterizedTypeReference(state.getReferenceOwner(), mapType);
//					unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, mapType.getTypeParameters().get(0)));
//					unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, mapType.getTypeParameters().get(1)));
//					expectation.acceptActualType(unboundCollectionType, ConformanceHint.UNCHECKED);
//				} else {
//					ParameterizedTypeReference unboundCollectionType = new ParameterizedTypeReference(state.getReferenceOwner(), setType);
//					if (elementTypeExpectation != null) {
//						unboundCollectionType.addTypeArgument(elementTypeExpectation);
//					} else {
//						unboundCollectionType.addTypeArgument(expectation.createUnboundTypeReference(literal, setType.getTypeParameters().get(0)));
//					}
//					expectation.acceptActualType(unboundCollectionType, ConformanceHint.UNCHECKED);
//				}
//			}
//		}
//	}
	
	protected void _computeTypes(final XForLoopExpression object, final ITypeComputationState state) {
		ITypeComputationState initExpectation = state.withoutExpectation();
		XExpression init = object.getInit();
		initExpectation.computeTypes(init);
		
		if (init instanceof XVariableDeclarationList) {
			XVariableDeclarationList declList = (XVariableDeclarationList) init;
			for(XExpression exp : declList.getDeclarations()){
				addLocalToCurrentScope((XVariableDeclaration)exp, initExpectation);
			}
		}
		
		XExpression condition = object.getCondition();
		initExpectation.computeTypes(condition);
		
		XExpression forExp = object.getLoop();
		initExpectation.computeTypes(forExp);
		
		initExpectation.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
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
	
	protected void _computeTypes(XClosure object, ITypeComputationState state) {
		for(ITypeExpectation expectation: state.getExpectations()) {
			new ClosureTypeComputer(object, expectation, state).computeTypes();
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

	protected void _computeTypes(final XForEachExpression object, final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		ITypeComputationState eachState = state.withoutExpectation();
		if (declaredParam != null) {
			LightweightTypeReference parameterType = computeForLoopParameterType(object, state);
			eachState = assignType(declaredParam, parameterType, eachState);
		}
		eachState.computeTypes(object.getEachExpression());
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}
	
	protected ITypeComputationState assignType(JvmFormalParameter param, @Nullable LightweightTypeReference type, ITypeComputationState state) {
		return state.assignType(param, type);
	}

	@Nullable
	protected LightweightTypeReference computeForLoopParameterType(final XForEachExpression object,
			final ITypeComputationState state) {
		JvmFormalParameter declaredParam = object.getDeclaredParam();
		LightweightTypeReference parameterType = getDeclaredParameterType(declaredParam, state);
//		final JvmGenericType iterableType = (JvmGenericType) services.getTypeReferences().findDeclaredType(Iterable.class, object); //cym comment
		final JvmGenericType iterableType = (JvmGenericType) Buildin.Iterable.Type;
		
		if (parameterType != null && !parameterType.isPrimitiveVoid()) {
			final CompoundTypeReference withSynonyms = new CompoundTypeReference(state.getReferenceOwner(), true);
			LightweightTypeReference iterableOrArray = getAndEnhanceIterableOrArrayFromComponent(parameterType, iterableType, withSynonyms);
			
			ITypeComputationState iterableState = state.withExpectation(withSynonyms);
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType!= null) {
				if (forExpressionType.isAny() || forExpressionType.isUnknown()) {
					iterableState.refineExpectedType(object.getForExpression(), iterableOrArray);
				} else if (forExpressionType.isResolved()) {
					TypeConformanceResult assignability = iterableOrArray.internalIsAssignableFrom(forExpressionType, new TypeConformanceComputationArgument());
					if (assignability.isConformant() && !assignability.getConformanceHints().contains(ConformanceHint.RAWTYPE_CONVERSION))
						iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
					else {
						ArrayTypeReference array = forExpressionType.tryConvertToArray();
						if (array != null) {
							LightweightTypeReference arrayComponentType = array.getComponentType();
							if (parameterType.isAssignableFrom(arrayComponentType)) {
								iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
							} else {
								LightweightTypeReference rawArrayComponentType = arrayComponentType.getRawTypeReference();
								AbstractDiagnostic diagnostic = new EObjectDiagnosticImpl(
										Severity.ERROR, 
										IssueCodes.INCOMPATIBLE_TYPES, 
										String.format("Type mismatch: cannot convert from element type %s to %s", rawArrayComponentType.getSimpleName(), parameterType.getSimpleName()), 
										object, 
										XbasePackage.Literals.XFOR_EACH_EXPRESSION__FOR_EXPRESSION, -1, null);
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
				WildcardTypeReference wildcard = new WildcardTypeReference(owner);
				ParameterizedTypeReference iterableTypeRef = new ParameterizedTypeReference(owner, iterableType);
				UnboundTypeReference unbound = state.createUnboundTypeReference(object, iterableType.getTypeParameters().get(0));
				wildcard.addUpperBound(unbound);
				iterableTypeRef.addTypeArgument(wildcard);
				iterable = iterableTypeRef;
				// TODO do we have to add synonyms, too?
			}
			ITypeComputationState iterableState = state.withExpectation(iterable); 
			ITypeComputationResult forExpressionResult = iterableState.computeTypes(object.getForExpression());
			LightweightTypeReference forExpressionType = forExpressionResult.getActualExpressionType();
			if (forExpressionType != null) {
				if (!forExpressionType.isAny() && (iterable.isAssignableFrom(forExpressionType) || forExpressionType.isArray())) {
					iterableState.refineExpectedType(object.getForExpression(), forExpressionType);
				}
				parameterType = getElementOrComponentType(forExpressionType, state);
			}
		}
		return parameterType;
	}

	protected LightweightTypeReference getAndEnhanceIterableOrArrayFromComponent(LightweightTypeReference parameterType, JvmGenericType iterableType,
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
			addAsArrayComponentAndIterable = getRawTypeForName(Object.class, parameterType.getOwner());
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
				JvmGenericType iterable = (JvmGenericType) Buildin.Iterable.Type;
				
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

	protected void _computeTypes(XWhileExpression object, ITypeComputationState state) {
		computeWhileLoopBody(object, state, true);
		
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		state.acceptActualType(primitiveVoid);
	}

	protected ITypeComputationResult computeWhileLoopBody(XAbstractWhileExpression object, ITypeComputationState state, boolean autocast) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		XExpression predicate = object.getPredicate();
		conditionExpectation.computeTypes(predicate);
		XExpression body = object.getBody();
		ITypeComputationState bodyState = autocast ? reassignCheckedType(predicate, body, state) : state;
		return bodyState.withoutExpectation().computeTypes(body);
	}

	/**
	 * Since we are sure that the loop body is executed at least once, the early exit information
	 * of the loop body expression can be used for the outer expression.
	 */
	protected void _computeTypes(XDoWhileExpression object, ITypeComputationState state) {
		ITypeComputationResult loopBodyResult = computeWhileLoopBody(object, state, false);
		boolean noImplicitReturn = loopBodyResult.getConformanceHints().contains(ConformanceHint.NO_IMPLICIT_RETURN);
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		if (noImplicitReturn)
			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN, ConformanceHint.UNCHECKED);
		else
			state.acceptActualType(primitiveVoid);
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
				JvmType voidType = services.getTypeReferences().findDeclaredType(Void.class, object);
				if (voidType == null) {
					clazz = new UnknownTypeReference(owner, Void.class.getName());
				} else {
					clazz = new ParameterizedTypeReference(owner, voidType);
				}
			} else {
				clazz = clazz.getWrapperTypeIfPrimitive();
			}
		}
		ParameterizedTypeReference result = getRawTypeForName(Class.class, owner);
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
		ITypeComputationState expressionState = state.withExpectation(getRawTypeForName(Object.class, state.getReferenceOwner()));
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
		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}

	protected void _computeTypes(XThrowExpression object, ITypeComputationState state) {
		LightweightTypeReference throwable = getTypeForName(Throwable.class, state);
		ITypeComputationState expressionState = state.withExpectation(throwable);
		ITypeComputationResult types = expressionState.computeTypes(object.getExpression());
		LightweightTypeReference thrownException = types.getActualExpressionType();
		state.acceptActualType(getPrimitiveVoid(state), ConformanceHint.NO_IMPLICIT_RETURN);
		
		if (thrownException != null && !thrownException.isUnknown()) {
			if (!state.isIgnored(IssueCodes.UNHANDLED_EXCEPTION) && thrownException.isSubtypeOf(Throwable.class)
					&& !thrownException.isSubtypeOf(RuntimeException.class)) {
				boolean declarationFound = false;
				for (LightweightTypeReference declaredException : state.getExpectedExceptions())
					if (declaredException.isAssignableFrom(thrownException)) {
						declarationFound = true;
						break;
					}
				if (!declarationFound)
					state.addDiagnostic(new EObjectDiagnosticImpl(
							expressionState.getSeverity(IssueCodes.UNHANDLED_EXCEPTION),
							IssueCodes.UNHANDLED_EXCEPTION,
							"Unhandled exception type " + thrownException.getSimpleName(),
							object,
							XbasePackage.Literals.XTHROW_EXPRESSION__EXPRESSION,
							-1,
							new String[] { 
								EcoreUtil.getURI(thrownException.getType()).toString(),
								EcoreUtil.getURI(object).toString()
							}));
			}
		}
	}

	protected void _computeTypes(XReturnExpression object, ITypeComputationState state) {
		XExpression returnValue = object.getExpression();
		ITypeComputationState expressionState = state.withReturnExpectation();
		LightweightTypeReference primitiveVoid = getPrimitiveVoid(state);
		if (returnValue != null) {
			expressionState.computeTypes(returnValue);
			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
		} else {
			state.acceptActualType(primitiveVoid, ConformanceHint.EXPLICIT_VOID_RETURN);
			state.acceptActualType(primitiveVoid, ConformanceHint.NO_IMPLICIT_RETURN);
		}
	}
	
	protected void _computeTypes(XPostfixOperation object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Integer.TYPE, state);
		state.acceptActualType(bool);
	}
	
	protected void _computeTypes(XBreakExpression object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}
	
	protected void _computeTypes(XTernaryOperation object, ITypeComputationState state) {
		ITypeComputationState conditionExpectation = state.withExpectation(getTypeForName(Boolean.TYPE, state));
		XExpression condition = object.getCondition();
		conditionExpectation.computeTypes(condition);
		
		// TODO then expression may influence the expected type of else and vice versa
		XExpression thenExpression = object.getTrueOperand();
		ITypeComputationState thenState = reassignCheckedType(condition, thenExpression, state);
		ITypeComputationResult thenResult = thenState.computeTypes(thenExpression);
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
	
	
	
	protected void _computeTypes(XContinueExpression object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Boolean.TYPE, state);
		state.acceptActualType(bool);
	}
	
	protected void _computeTypes(XIndexOperation object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Integer.TYPE, state);
		state.acceptActualType(bool);
	}
	
	protected void _computeTypes(XPrefixOperation object, ITypeComputationState state) {
		LightweightTypeReference bool = getTypeForName(Integer.TYPE, state);
		state.acceptActualType(bool);
	}
	
	protected void _computeTypes(XTryCatchFinallyExpression object, ITypeComputationState state) {
		List<LightweightTypeReference> caughtExceptions = Lists.newArrayList();
		OwnedConverter converter = state.getConverter();
		for (XCatchClause catchClause : object.getCatchClauses())
			if (catchClause.getDeclaredParam() != null && catchClause.getDeclaredParam().getParameterType() != null)
				caughtExceptions.add(converter.toLightweightReference(catchClause.getDeclaredParam().getParameterType()));
		state.withExpectedExceptions(caughtExceptions).computeTypes(object.getExpression());
		for (XCatchClause catchClause : object.getCatchClauses()) {
			JvmFormalParameter catchClauseParam = catchClause.getDeclaredParam();
			JvmTypeReference parameterType = catchClauseParam.getParameterType();
			LightweightTypeReference lightweightReference = parameterType != null 
					? state.getConverter().toLightweightReference(parameterType)
					: new AnyTypeReference(state.getReferenceOwner());
			ITypeComputationState catchClauseState = assignType(catchClauseParam, lightweightReference, state);
			catchClauseState.computeTypes(catchClause.getExpression());
		}
		// TODO validate / handle return / throw in finally block
		state.withoutExpectation().computeTypes(object.getFinallyExpression());
	}
	
	protected void _computeTypes(final XAssignment assignment, ITypeComputationState state) {
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
		if (object instanceof XSwitchExpression) {
			return (XSwitchExpression) object;
		}
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
				|| feature instanceof XSwitchExpression
				|| feature instanceof JvmFormalParameter 
				|| feature instanceof JvmField;
	}
	
	protected boolean mustDiscardRefinement(JvmIdentifiableElement feature) {
		if (feature instanceof XVariableDeclaration) {
			return ((XVariableDeclaration) feature).isWriteable();
		}
		if (feature instanceof JvmField) {
			return !((JvmField) feature).isFinal();
		}
		return false;
	}
	
}
