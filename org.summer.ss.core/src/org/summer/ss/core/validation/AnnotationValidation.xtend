/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation

import com.google.inject.Inject
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmGenericArrayTypeReference
import org.summer.dsl.model.types.JvmPrimitiveType
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.xbase.XbasePackage

import static org.summer.dsl.model.types.TypesPackage.Literals.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AnnotationValidation extends AbstractDeclarativeValidator {
	
	@Inject
	AnnotationValueValidator annotationValueValidator;
	
	override protected getEPackages() {
		newArrayList(XbasePackage.eINSTANCE)
	}
	
	@Check 
	def checkAnnotation(JvmAnnotationType it) {
		for (it : members.filter(JvmField)) {
			if (!isValidAnnotationValueType(type)) {
				error('''Invalid type «type.simpleName» for the annotation attribute «simpleName»; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof''',
					it,
					JVM_FIELD__TYPE,
					IssueCodes.INVALID_ANNOTATION_VALUE_TYPE
				)
			}
			if(defaultValue != null) {
				annotationValueValidator.validateAnnotationValue(defaultValue, this)
			}
		}
	}
	
	def boolean isValidAnnotationValueType(JvmTypeReference reference) {
		val toCheck = switch reference {
			JvmGenericArrayTypeReference : 
				reference.componentType
			default : reference
		}
		if (toCheck == null)
			return true;
		if (toCheck.type instanceof JvmPrimitiveType) 
			return true
		if (toCheck.type instanceof JvmEnumerationType)
			return true
		if (toCheck.type instanceof JvmAnnotationType)
			return true
		if (toCheck.type.qualifiedName == 'String' 
			|| toCheck.type.qualifiedName == 'Class') 
			return true
		return false
	}

}