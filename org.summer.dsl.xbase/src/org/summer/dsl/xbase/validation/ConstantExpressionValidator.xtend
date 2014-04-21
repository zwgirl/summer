/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation

import com.google.inject.Inject
import org.summer.dsl.model.types.JvmBooleanAnnotationValue
import org.summer.dsl.model.types.JvmEnumerationLiteral
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.util.Primitives
import org.summer.dsl.model.types.util.TypeReferences
import org.summer.dsl.model.xbase.XAbstractFeatureCall
import org.summer.dsl.model.xbase.XBooleanLiteral
import org.summer.dsl.model.xbase.XCastedExpression
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.model.xbase.XNumberLiteral
import org.summer.dsl.model.xbase.XStringLiteral
import org.summer.dsl.model.xbase.XTypeLiteral
import org.summer.dsl.xbase.util.XExpressionHelper

/**
 * Checks whether a given XExpression is a a constant expression.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
class ConstantExpressionValidator {
	
	@Inject extension TypeReferences
	@Inject extension Primitives
	@Inject extension XExpressionHelper
	
	def dispatch boolean isConstant(XExpression expression) {
		return false
	}
	
	def dispatch boolean isConstant(XStringLiteral expression) { true }
	def dispatch boolean isConstant(XTypeLiteral expression) { true }
	def dispatch boolean isConstant(XNumberLiteral expression) { true }
	def dispatch boolean isConstant(XBooleanLiteral expression) { true }
	
	def dispatch boolean isConstant(XCastedExpression expression) {
		expression.type.primitive || expression.type.is(String)
	}
	
	def dispatch boolean isConstant(XAbstractFeatureCall expression) {
		switch feature : expression.feature {
			JvmField : {
				// assume that static final fields are constants for now.
				return feature.static && feature.final
			}
			JvmEnumerationLiteral : {
				return true
			}
			JvmOperation : {
				val annotationReference = expression.findInlineAnnotation
				if (annotationReference == null) {
					return false
				}
				if (annotationReference.values.filter(JvmBooleanAnnotationValue).exists [
					valueName=='constantExpression' && values.head.booleanValue
				]) {
					val receiverConstant =if (expression.actualReceiver == null) {
						true
					} else {
						expression.actualReceiver.isConstant
					}
					return receiverConstant && expression.actualArguments.forall[isConstant]
				}
			}
		}
		return false;
	}
}