/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation

import org.eclipse.xtext.validation.ValidationMessageAcceptor
import org.summer.dsl.model.types.JvmAnnotationReference
import org.summer.dsl.model.xbase.XAbstractFeatureCall
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.model.xbase.XListLiteral
import org.summer.dsl.xbase.validation.ConstantExpressionValidator
import org.summer.dsl.xbase.validation.IssueCodes

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
class AnnotationValueValidator extends ConstantExpressionValidator {
	
	def void validateAnnotationValue(XExpression value, ValidationMessageAcceptor acceptor) {
		if (!isValidAnnotationValue(value)) {
			acceptor.acceptError("The value for an annotation attribute must be a constant expression", value, null,
				ValidationMessageAcceptor.INSIGNIFICANT_INDEX, IssueCodes.ANNOTATIONS_ILLEGAL_ATTRIBUTE);
		}
	}
	
	protected def dispatch boolean isValidAnnotationValue(XExpression expression) {
		return super.isConstant(expression)
	}
	
	protected def dispatch boolean isValidAnnotationValue(Void nullValue) {
		// indicates a syntax error
		// consider the thing to be valid
		return true
	}
	
	protected def dispatch boolean isValidAnnotationValue(XListLiteral expression) { 
		expression.elements.empty || expression.elements.forall[isValidAnnotationValue]
	}
	
	protected def dispatch boolean isValidAnnotationValue(JvmAnnotationReference expression) {
		return true
	}
	
	protected def dispatch boolean isValidAnnotationValue(XAbstractFeatureCall expression) {
		if (expression.typeLiteral)
			return true
		return super.isConstant(expression)
	}
	
}
