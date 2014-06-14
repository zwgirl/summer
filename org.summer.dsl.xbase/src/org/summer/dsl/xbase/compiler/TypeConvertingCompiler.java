/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XCastedExpression;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;
import org.summer.dsl.xbase.scoping.batch.Buildin;
//import org.eclipse.xtext.xbase.lib.Conversions;
//import org.eclipse.xtext.xbase.lib.Functions;
//import org.eclipse.xtext.xbase.lib.Procedures;
import org.summer.dsl.xbase.typesystem.IResolvedTypes;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
public class TypeConvertingCompiler extends AbstractXbaseCompiler {

	private final static String REASSIGNED_THIS_IN_LAMBDA = "!reassigned_this_for_lambda!";
	
	@Override
	protected final void internalToJavaExpression(final XExpression obj, final ITreeAppendable appendable) {
		LightweightTypeReference expectedType = getLightweightExpectedType(obj);
		
		internalToConvertedExpression(obj, appendable, expectedType);
	}

	@Override
	protected final void internalToConvertedExpression(final XExpression obj, ITreeAppendable appendable,
			@Nullable LightweightTypeReference toBeConvertedTo) {
		if (toBeConvertedTo != null) {
			LightweightTypeReference actualType = getLightweightType(obj);
			if (actualType.isPrimitiveVoid()) {
				actualType = toBeConvertedTo;
			}
			if (!toBeConvertedTo.getUniqueIdentifier().equals(actualType.getUniqueIdentifier())) {
				doConversion(toBeConvertedTo, actualType, appendable, obj, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
			if (mustInsertTypeCast(obj, actualType)) {
				doCastConversion(actualType, appendable, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		} else {
			LightweightTypeReference actualType = getLightweightType(obj);
			if (obj instanceof XAbstractFeatureCall && mustInsertTypeCast(obj, actualType)){
				doCastConversion(actualType, appendable, new Later() {
					public void exec(ITreeAppendable appendable) {
						appendable = appendable.trace(obj, true);
						internalToConvertedExpression(obj, appendable);
					}
				});
				return;
			}
		}
		final ITreeAppendable trace = appendable.trace(obj, true);
		internalToConvertedExpression(obj, trace);
	}

	private boolean mustInsertTypeCast(XExpression expression, LightweightTypeReference actualType) {
//		IResolvedTypes resolvedTypes = getResolvedTypes(expression);
//		if (resolvedTypes.isRefinedType(expression) || resolvedTypes.getActualType(expression).isMultiType()) {
//			if (expression instanceof XAbstractFeatureCall) {
//				LightweightTypeReference featureType = resolvedTypes.getActualType(((XAbstractFeatureCall) expression).getFeature());
//				if (featureType != null && !featureType.isMultiType() && actualType.isAssignableFrom(featureType)) {
//					return false;
//				}
//			}
//			if (expression.eContainer() instanceof XCastedExpression) {
//				return false;
//			}
//			return true;
//		}
		return false;
	}

	protected void internalToConvertedExpression(final XExpression obj, final ITreeAppendable appendable) {
		super.internalToJavaExpression(obj, appendable);
	}

	private void doConversion(final LightweightTypeReference left, final LightweightTypeReference right,
			final ITreeAppendable appendable, XExpression context, final Later expression) {
		//cym comment
//		if(left.isPrimitive() && !right.isPrimitive()) {
//			if (right.isAny()) {
//				convertWrapperToPrimitive(left, left, context, appendable, expression);
//			} else {
//				convertWrapperToPrimitive(right, right.getPrimitiveIfWrapperType(), context, appendable, expression);
//			}
//		} else if (right.isPrimitive() && !left.isPrimitive()) {
//			convertPrimitiveToWrapper(right, right.getWrapperTypeIfPrimitive(), appendable, expression);
//		} else if (right.isMultiType()) {
//			convertMultiType(left, (CompoundTypeReference) right, context, appendable, expression);
//		} else if (right.isArray() && !left.isArray() && left.isSubtypeOf(Iterable.class)) {
//			convertArrayToList(left, appendable, context, expression);
//		} else if (isJavaConformant(left, right)) {
//			if (mustInsertTypeCast(context, left)) {
//				doCastConversion(left, appendable, expression);
//			} else {
//				expression.exec(appendable);
//			}
//		} else if (left.isArray() && !right.isArray() && right.isSubtypeOf(Iterable.class)) {
//			convertListToArray(left, appendable, expression);
//		} else if ((isFunction(left) && isFunction(right) || isProcedure(left) && isProcedure(right)) && left.getType() == right.getType()) {
//			doCastConversion(left, appendable, expression);
//		} else if (isFunction(right) || (isFunction(left) && findImplementingOperation(right) != null)) {
//			convertFunctionType(left, right, appendable, expression, context);
//		} else if (isProcedure(right) || (isProcedure(left) && findImplementingOperation(right) != null)) {
//			convertFunctionType(left, right, appendable, expression, context);
//		} else if (mustInsertTypeCast(context, left)) {
//			doCastConversion(left, appendable, expression);
//		} else {
//			expression.exec(appendable);
//		}
	}
	
	@Nullable
	protected JvmOperation findImplementingOperation(LightweightTypeReference closureType) {
		return getTypeComputationServices().getFunctionTypes().findImplementingOperation(closureType);
	}
	
	private void doCastConversion(final LightweightTypeReference castTo, final ITreeAppendable b, final Later expression) {
		b.append("((");
		b.append(castTo);
		b.append(")");
		expression.exec(b);
		b.append(")");
	}
	
//	private boolean isFunction(LightweightTypeReference typeReference) {
//		return identifierStartWith(typeReference, Functions.class.getCanonicalName());
//	}
//	
//	private boolean isProcedure(LightweightTypeReference typeReference) {
//		return identifierStartWith(typeReference, Procedures.class.getCanonicalName());		
//	}
	
	private boolean identifierStartWith(LightweightTypeReference typeReference, String prefix) {
		JvmType type = typeReference.getType();
		if (type == null)
			return false;
		String identifier = type.getIdentifier();
		if (identifier != null)
			return identifier.startsWith(prefix);
		return false;
	}

//	private void convertMultiType(LightweightTypeReference expectation, CompoundTypeReference multiType, XExpression context,
//			ITreeAppendable b, Later expression) {
//		LightweightTypeReference castTo = null;
//		for(LightweightTypeReference candidate: multiType.getMultiTypeComponents()) {
//			if (isJavaConformant(expectation, candidate)) {
//				castTo = candidate;
//				break;
//			}
//		}
//		if (castTo != null && mustInsertTypeCast(context, castTo)) {
//			b.append("((");
//			b.append(castTo);
//			b.append(")");
//			expression.exec(b);
//			b.append(")");
//		} else {
//			expression.exec(b);
//		}
//	}

//	private void convertFunctionType(LightweightTypeReference lightweightExpectedType, final LightweightTypeReference functionType,
//			ITreeAppendable appendable, Later expression, XExpression context) {
//		if (lightweightExpectedType.isSynonym()) {
//			throw new IllegalStateException();
//		}
//		if (lightweightExpectedType.isType(Buildin.Object.JvmType)
//				|| lightweightExpectedType.getUniqueIdentifier().equals(functionType.getUniqueIdentifier())) {
//			// same raw type but different type parameters
//			// at this point we know that we are compatible so we have to convince the Java compiler about that ;-)
//			if (!isJavaConformant(lightweightExpectedType, functionType)) {
//				// insert a cast
//				appendable.append("(");
//				appendable.append(lightweightExpectedType);
//				appendable.append(")");
//			}
//			expression.exec(appendable);
//			return;
//		}
//		JvmOperation operation = findImplementingOperation(lightweightExpectedType);
//		if (operation == null) {
//			throw new IllegalStateException("expected type " + lightweightExpectedType + " not mappable from " + functionType);
//		}
//		appendable.append("new ");
//		FunctionTypeReference functionTypeReference = lightweightExpectedType.tryConvertToFunctionTypeReference(false);
//		if (functionTypeReference == null)
//			throw new IllegalStateException("Expected type does not seem to be a SAM type");
//		JvmTypeReference convertedExpectedType = functionTypeReference.toInstanceTypeReference().toTypeReference();
//		serialize(convertedExpectedType, context, appendable, false, false);
//		appendable.append("() {");
//		appendable.increaseIndentation().increaseIndentation();
//		appendable.newLine().append("public ");
//		LightweightTypeReference returnType = functionTypeReference.getReturnType();
//		if (returnType == null)
//			throw new IllegalStateException("Could not find return type");
//		serialize(returnType.toTypeReference(), context, appendable, false, false);
//		appendable.append(" ").append(operation.getSimpleName()).append("(");
//		List<JvmFormalParameter> params = operation.getParameters();
//		for (int i = 0; i < params.size(); i++) {
//			if (i != 0)
//				appendable.append(",");
//			JvmFormalParameter p = params.get(i);
//			final String name = p.getName();
//			serialize(functionTypeReference.getParameterTypes().get(i).toTypeReference(), context, appendable, false, false);
//			appendable.append(" ").append(name);
//		}
//		appendable.append(") {");
//		appendable.increaseIndentation();
//		try {
//			appendable.openScope();
//			reassignThisInClosure(appendable, operation.getDeclaringType());
//			if (!(operation.getReturnType().getType() instanceof JvmVoid))
//				appendable.newLine().append("return ");
//			else
//				appendable.newLine();
//			expression.exec(appendable);
//			appendable.append(".");
//			JvmOperation actualOperation = findImplementingOperation(functionType);
//			appendable.append(actualOperation.getSimpleName());
//			appendable.append("(");
//			for (Iterator<JvmFormalParameter> iterator = params.iterator(); iterator.hasNext();) {
//				JvmFormalParameter p = iterator.next();
//				final String name = p.getName();
//				appendable.append(name);
//				if (iterator.hasNext())
//					appendable.append(",");
//			}
//			appendable.append(");");
//		} finally {
//			appendable.closeScope();
//		}
//		appendable.decreaseIndentation();
//		appendable.newLine().append("}");
//		appendable.decreaseIndentation().decreaseIndentation();
//		appendable.newLine().append("}");
//	}
	
	protected void reassignThisInClosure(final ITreeAppendable b, JvmType rawClosureType) {
		boolean registerClosureAsThis = rawClosureType instanceof JvmGenericType;
		boolean isAlreadyInALambda = b.hasObject(REASSIGNED_THIS_IN_LAMBDA);
		if (b.hasObject("this") && !isAlreadyInALambda) {
			Object element = b.getObject("this");
			if (element instanceof JvmType) {
				final String proposedName = ((JvmType) element).getSimpleName()+".this";
				if (!b.hasObject(proposedName)) {
					b.declareSyntheticVariable(element, proposedName);
					if (b.hasObject("super")) {
						Object superElement = b.getObject("super");
						if (superElement instanceof JvmType) {
							b.declareSyntheticVariable(superElement, ((JvmType) element).getSimpleName()+".super");
						}
					}
				}
			} else {
				registerClosureAsThis = false;
			}
		}
		if (!isAlreadyInALambda) {
			// add a synthetic marker so we don't reassign this and super more than once.
			b.declareSyntheticVariable(REASSIGNED_THIS_IN_LAMBDA, REASSIGNED_THIS_IN_LAMBDA);
		}
		if (registerClosureAsThis) {
			b.declareVariable(rawClosureType, "this");
		}
	}

	private void convertListToArray(
			final LightweightTypeReference arrayTypeReference, 
			final ITreeAppendable appendable,
			final Later expression) {
		appendable.append("((");
		appendable.append(arrayTypeReference);
		appendable.append(")");
//		appendable.append(Conversions.class);  //cym comment
		appendable.append(".unwrapArray(");
		expression.exec(appendable);
		LightweightTypeReference rawTypeArrayReference = arrayTypeReference.getRawTypeReference();
		appendable.append(", ");
		appendable.append(rawTypeArrayReference.getComponentType());
		appendable.append(".class))");
	}

	private void convertArrayToList(final LightweightTypeReference left, final ITreeAppendable appendable, XExpression context,
			final Later expression) {
		if (!(context.eContainer() instanceof XCastedExpression)) {
			if (context.eContainer() instanceof XAbstractFeatureCall) {
				appendable.append("((");
			} else {
				appendable.append("(");
			}
			appendable.append(left);
			appendable.append(")");
		}
//		appendable.append(Conversions.class); //cym comment
		appendable.append(".doWrapArray(");
		expression.exec(appendable);
		if (!(context.eContainer() instanceof XCastedExpression)) {
			if (context.eContainer() instanceof XAbstractFeatureCall) {
				appendable.append("))");
			} else {
				appendable.append(")");
			}
		} else {
			appendable.append(")");
		}
	}

	/**
	 * @param primitive unused in this context but useful for inheritors 
	 */
	private void convertPrimitiveToWrapper(
			final LightweightTypeReference primitive, 
			final LightweightTypeReference wrapper, 
			final ITreeAppendable appendable,
			final Later expression) {
		appendable.append(wrapper);
		appendable.append(".");
		appendable.append("valueOf(");
		expression.exec(appendable);
		appendable.append(")");
	}
	
//	protected List<XStatment> normalizeBlockExpression(Collection<XStatment> stat) {
//		List<XStatment> result  = Lists.newArrayListWithExpectedSize(stat.size());
//		for(XStatment e:stat)
//			result.add(normalizeBlockExpression(e));
//		return result;
//	}
//
//	protected XStatment normalizeBlockExpression(XStatment expr) {
//		if (expr instanceof XBlockStatment) {
//			XBlockStatment block = ((XBlockStatment) expr);
//			if (block.getStatments().size() == 1)
//				return normalizeBlockExpression(block.getStatments().get(0));
//		}
//		return expr;
//	}


	/**
	 * @param wrapper unused in this context but useful for inheritors 
	 */
	private void convertWrapperToPrimitive(
			final LightweightTypeReference wrapper, 
			final LightweightTypeReference primitive, 
			XExpression context, 
			final ITreeAppendable appendable,
			final Later expression) {
		
		//cym comment
//		XExpression normalized = normalizeBlockExpression(context);
//		if (normalized instanceof XAbstractFeatureCall && !(context.eContainer() instanceof XAbstractFeatureCall)) {
//			// Avoid javac bug
//			// https://bugs.eclipse.org/bugs/show_bug.cgi?id=410797
//			// TODO make that dependent on the compiler version (javac 1.7 fixed that bug)
//			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) normalized;
//			if (featureCall.isStatic()) {
//				JvmIdentifiableElement feature = featureCall.getFeature();
//				if (feature instanceof JvmOperation) {
//					if (!((JvmOperation) feature).getTypeParameters().isEmpty()) {
//						appendable.append("(");
//						appendable.append(primitive);
//						appendable.append(") ");
//						expression.exec(appendable);
//						return;
//					}
//				}
//			}
//		}
		appendable.append("(");
		if (mustInsertTypeCast(context, wrapper)) {
			appendable.append("(");
			appendable.append(wrapper);
			appendable.append(") ");
		} 
		expression.exec(appendable);
		appendable.append(")");
		appendable.append(".");
		appendable.append(primitive);
		appendable.append("Value()");
	}
	
}
