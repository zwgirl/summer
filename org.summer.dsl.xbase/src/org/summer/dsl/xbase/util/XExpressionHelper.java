/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.util;

import static com.google.common.collect.Iterables.contains;
import static org.eclipse.xtext.util.Strings.equal;

import java.util.List;

import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBooleanLiteral;
import org.summer.dsl.model.xbase.XClosure;
import org.summer.dsl.model.xbase.XCollectionLiteral;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XNullLiteral;
import org.summer.dsl.model.xbase.XNumberLiteral;
import org.summer.dsl.model.xbase.XPostfixOperation;
import org.summer.dsl.model.xbase.XStringLiteral;
import org.summer.dsl.model.xbase.XTypeLiteral;
import org.summer.dsl.xbase.lib.BooleanExtensions;
import org.summer.dsl.xbase.lib.ByteExtensions;
import org.summer.dsl.xbase.lib.CharacterExtensions;
import org.summer.dsl.xbase.lib.DoubleExtensions;
import org.summer.dsl.xbase.lib.FloatExtensions;
import org.summer.dsl.xbase.lib.Inline;
import org.summer.dsl.xbase.lib.IntegerExtensions;
import org.summer.dsl.xbase.lib.LongExtensions;
import org.summer.dsl.xbase.lib.ObjectExtensions;
import org.summer.dsl.xbase.lib.Pure;
import org.summer.dsl.xbase.lib.ShortExtensions;
import org.summer.dsl.xbase.scoping.featurecalls.OperatorMapping;

import com.google.inject.Inject;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XExpressionHelper {

	@Inject
	private TypeReferences typeReferences;
	
	@Inject 
	private OperatorMapping operatorMapping; 

	/**
	 * @return whether the expression itself (not its children) possibly causes a side-effect
	 */
	public boolean hasSideEffects(XExpression expr) {
		if (expr instanceof XClosure
			|| expr instanceof XStringLiteral
			|| expr instanceof XTypeLiteral
			|| expr instanceof XBooleanLiteral
			|| expr instanceof XNumberLiteral
			|| expr instanceof XNullLiteral
			|| expr instanceof JvmAnnotationReference
			)
			return false;
		if(expr instanceof XCollectionLiteral) {
			for(XExpression element: ((XCollectionLiteral)expr).getElements()) {
				if(hasSideEffects(element))
					return true;
			}
			return false;
		}
		if (expr instanceof XAbstractFeatureCall) {
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall) expr;
			return hasSideEffects(featureCall, true);
		}
		if (expr instanceof XConstructorCall) {
			XConstructorCall constrCall = (XConstructorCall) expr;
			return findPureAnnotation(constrCall.getConstructor()) == null;
		}
		return true;
	}

	public boolean hasSideEffects(XAbstractFeatureCall featureCall, boolean inspectContents) {
		if (featureCall instanceof XAssignment) {
			return true;
		}
		if (featureCall.isPackageFragment() || featureCall.isTypeLiteral()) {
			return false;
		}
		final JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature == null || feature.eIsProxy())
			return true; // linking problems ... could be anything
		if (feature instanceof JvmConstructor) { //super() and this()
			return true;
		}
		if (feature instanceof JvmOperation) {
			JvmOperation jvmOperation = (JvmOperation) feature;
			if (findPureAnnotation(jvmOperation) == null) {
				return true;
			} else {
				if(inspectContents) {
					for (XExpression param : featureCall.getActualArguments()) {
						if (hasSideEffects(param))
							return true;
					}
				}
			}
		}
		return false;
	}
	
	public JvmAnnotationReference findInlineAnnotation(XAbstractFeatureCall featureCall) {
		final JvmIdentifiableElement feature = featureCall.getFeature();
		if (feature instanceof JvmAnnotationTarget) {
			return findAnnotation((JvmAnnotationTarget)feature, Inline.class.getName());
		}
		return null;
	}
	
	public JvmAnnotationReference findPureAnnotation(JvmExecutable featureCall) {
		return findAnnotation(featureCall, Pure.class.getName());
	}
	
	protected JvmAnnotationReference findAnnotation(JvmAnnotationTarget feature, String annotationType) {
		if (annotationType == null)
			throw new NullPointerException();
		List<JvmAnnotationReference> annotations = feature.getAnnotations();
		for (JvmAnnotationReference annotation : annotations) {
			if (annotationType.equals(annotation.getAnnotation().getQualifiedName())) {
				return annotation;
			}
		}
		return null;
	}

	public String getAndOperator() {
		return "&&";
	}

	public String getOrOperator() {
		return "||";
	}

	public String getElvisOperator() {
		return "?:";
	}

	public boolean isShortCircuitOperation(XAbstractFeatureCall featureCall) {
		if (featureCall instanceof XBinaryOperation) {
			if(isOperatorFromExtension(featureCall, OperatorMapping.ELVIS, ObjectExtensions.class))
				return true;
			else 
				return (isOperatorFromExtension(featureCall, OperatorMapping.AND, BooleanExtensions.class) 
					|| isOperatorFromExtension(featureCall, OperatorMapping.OR, BooleanExtensions.class));
		}
		return false;
	}

	public boolean isOperatorFromExtension(XExpression expression, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		return expression instanceof XAbstractFeatureCall && isOperatorFromExtension((XAbstractFeatureCall) expression, operatorSymbol, definingExtensionClass);
	}

	public boolean isOperatorFromExtension(XAbstractFeatureCall featureCall, QualifiedName operatorSymbol, Class<?> definingExtensionClass) {
		if(!equal(featureCall.getConcreteSyntaxFeatureName(), operatorSymbol.getLastSegment()))
			return false;
		QualifiedName methodName = operatorMapping.getMethodName(operatorSymbol);
		JvmDeclaredType definingJvmType = (JvmDeclaredType) typeReferences.findDeclaredType(definingExtensionClass, featureCall);
		Iterable<JvmFeature> operatorImplementations = definingJvmType.findAllFeaturesByName(methodName.getLastSegment());
		return contains(operatorImplementations, featureCall.getFeature());
	}

	public boolean isInlined(XAbstractFeatureCall call) {
		return findInlineAnnotation(call) != null;
	}
	
	public boolean isGetAndAssign(XAbstractFeatureCall featureCall) {
		if (!(featureCall instanceof XPostfixOperation)) {
			return false;
		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, DoubleExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, DoubleExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, FloatExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, FloatExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, LongExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, LongExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, IntegerExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, IntegerExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, ShortExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, ShortExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, CharacterExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, CharacterExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.MINUS_MINUS, ByteExtensions.class)) {
//			return true;
//		}
//		if (isOperatorFromExtension(featureCall, OperatorMapping.PLUS_PLUS, ByteExtensions.class)) {
//			return true;
//		}
		return false;
	}
}
