/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.validation

import com.google.inject.Inject
import org.summer.dsl.model.ss.XtendAnnotationType
import org.summer.dsl.model.ss.XtendField
import org.summer.dsl.model.ss.SsPackage
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmGenericArrayTypeReference
import org.summer.dsl.model.types.JvmPrimitiveType
import org.summer.dsl.model.types.JvmTypeReference
import org.eclipse.xtext.validation.AbstractDeclarativeValidator
import org.eclipse.xtext.validation.Check
import org.summer.dsl.model.xbase.XbasePackage
import org.summer.dsl.xannotation.validation.AnnotationValueValidator
import org.summer.dsl.model.xannotation.XannotationPackage

import static org.summer.dsl.model.ss.SsPackage.Literals.*

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class AnnotationValidation extends AbstractDeclarativeValidator {
	
	@Inject
	AnnotationValueValidator annotationValueValidator;
	
	override protected getEPackages() {
		newArrayList(SsPackage.eINSTANCE, XbasePackage.eINSTANCE, XannotationPackage.eINSTANCE)
	}
	
	@Check 
	def checkAnnotation(XtendAnnotationType it) {
		for (it : members.filter(XtendField)) {
			if (!isValidAnnotationValueType(type)) {
				error('''Invalid type �type.simpleName� for the annotation attribute �name�; only primitive type, String, Class, annotation, enumeration are permitted or 1-dimensional arrays thereof''',
					it,
					XTEND_FIELD__TYPE,
					IssueCodes.INVALID_ANNOTATION_VALUE_TYPE
				)
			}
			if(initialValue != null) {
				annotationValueValidator.validateAnnotationValue(initialValue, this)
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
		if (toCheck.type.qualifiedName == 'java.lang.String' 
			|| toCheck.type.qualifiedName == 'java.lang.Class') 
			return true
		return false
	}

}