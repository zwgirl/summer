/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.macro

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.linking.lazy.LazyURIEncoder
import org.summer.dsl.model.types.JvmAnnotationReference
import org.summer.dsl.model.types.JvmAnnotationTarget
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmCustomAnnotationValue
import org.summer.dsl.model.types.JvmEnumerationLiteral
import org.summer.dsl.model.types.JvmField
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmInterfaceType
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeAnnotationValue
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.xbase.XExpression
import org.summer.ss.lib.macro.Active
import org.summer.dsl.model.types.TypesPackage
import org.summer.dsl.model.types.JvmEnumerationType
import org.summer.dsl.model.types.JvmFormalParameter

class XAnnotationExtensions {
	
	@Inject LazyURIEncoder encoder
	@Inject ILinkingService linkingService
	@Inject ConstantExpressionsInterpreter constantExpressionsInterpreter
	
	def JvmAnnotationTarget getAnnotatedTarget(JvmAnnotationReference annotation) {
		// ignore synthetic containers
		switch container : annotation.eContainer {
			JvmAnnotationType : container
			JvmGenericType : container
			JvmInterfaceType : container
			JvmEnumerationType : container
			JvmField : container
			JvmOperation : container
			JvmConstructor : container
			JvmEnumerationLiteral : container
			JvmFormalParameter : container
			JvmAnnotationTarget 	: container.eContainer as JvmAnnotationTarget
			JvmAnnotationReference 			: getAnnotatedTarget(container)
			default 				: null
		}
	}
	
	/**
	 * Checks whether this annotation is pointing to a processed annotation, without resolving the proxy
	 */
	def isProcessed(JvmAnnotationReference it) {
		switch proxy : it.eGet(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__ANNOTATION, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				if (encoder.isCrossLinkFragment(eResource, uri.fragment)) {
					val triple = encoder.decode(eResource, uri.fragment)
					val candidates = linkingService.getLinkedObjects(triple.first, triple.second, triple.third)
					if (!candidates.isEmpty) {
						val head = candidates.head
						if (head instanceof JvmAnnotationType)
							return head.isActiveAnnotation
					}
				}
			}
			JvmAnnotationType : {
				return proxy.isActiveAnnotation
			}
		}
		return false
	}
	
	def JvmType getProcessorType(JvmAnnotationType it) {
		val activeAnnotation = it.annotations.findFirst [ 
			annotation?.identifier == Active.name
		]
		val annoVal = activeAnnotation.values.findFirst [
			// identifier 'value' is optional
			field == null || field.simpleName == 'value'
		]
		switch annoVal {
			JvmTypeAnnotationValue : {
				return annoVal.values.head?.type
			}
			JvmCustomAnnotationValue : {
				val type = constantExpressionsInterpreter.evaluate(annoVal.values.head as XExpression, annoVal.field?.type)
				if (type instanceof JvmTypeReference) {
					return type.type
				}
			}
		}
		return null				
	}
	
	def getProcessorType(JvmAnnotationReference it) {
		return tryFindAnnotationType.processorType
	}
	
	def tryFindAnnotationType(JvmAnnotationReference it) {
		switch proxy : it.eGet(TypesPackage.Literals.JVM_ANNOTATION_REFERENCE__ANNOTATION, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return eResource.resourceSet.getEObject(uri, true) as JvmAnnotationType
			}
			JvmAnnotationType : {
				return proxy
			}
		}
	}
	
	def protected boolean isActiveAnnotation(JvmAnnotationType annotationType) {
		for (anno : annotationType.annotations) {
			if (anno.annotation.identifier == Active.name)
				return true
		}
		return false
	}
}
