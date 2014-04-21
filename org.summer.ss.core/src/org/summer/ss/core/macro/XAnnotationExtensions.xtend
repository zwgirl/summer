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
import org.summer.dsl.model.ss.XtendAnnotationTarget
import org.summer.dsl.model.ss.XtendAnnotationType
import org.summer.dsl.model.ss.XtendClass
import org.summer.dsl.model.ss.XtendConstructor
import org.summer.dsl.model.ss.XtendEnum
import org.summer.dsl.model.ss.XtendEnumLiteral
import org.summer.dsl.model.ss.XtendField
import org.summer.dsl.model.ss.XtendFunction
import org.summer.dsl.model.ss.XtendInterface
import org.summer.dsl.model.ss.XtendParameter
import org.summer.ss.lib.macro.Active
import org.summer.dsl.model.types.JvmAnnotationType
import org.summer.dsl.model.types.JvmCustomAnnotationValue
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeAnnotationValue
import org.summer.dsl.model.types.JvmTypeReference
import org.eclipse.xtext.linking.ILinkingService
import org.eclipse.xtext.linking.lazy.LazyURIEncoder
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.model.xannotation.XAnnotation

import static org.summer.dsl.model.xannotation.XannotationPackage.Literals.*

class XAnnotationExtensions {
	
	@Inject LazyURIEncoder encoder
	@Inject ILinkingService linkingService
	@Inject ConstantExpressionsInterpreter constantExpressionsInterpreter
	
	def XtendAnnotationTarget getAnnotatedTarget(XAnnotation annotation) {
		// ignore synthetic containers
		switch container : annotation.eContainer {
			XtendAnnotationType : container
			XtendClass : container
			XtendInterface : container
			XtendEnum : container
			XtendField : container
			XtendFunction : container
			XtendConstructor : container
			XtendEnumLiteral : container
			XtendParameter : container
			XtendAnnotationTarget 	: container.eContainer as XtendAnnotationTarget
			XAnnotation 			: getAnnotatedTarget(container)
			default 				: null
		}
	}
	
	/**
	 * Checks whether this annotation is pointing to a processed annotation, without resolving the proxy
	 */
	def isProcessed(XAnnotation it) {
		switch proxy : it.eGet(XANNOTATION__ANNOTATION_TYPE, false) {
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
			operation == null || operation.simpleName == 'value'
		]
		switch annoVal {
			JvmTypeAnnotationValue : {
				return annoVal.values.head?.type
			}
			JvmCustomAnnotationValue : {
				val type = constantExpressionsInterpreter.evaluate(annoVal.values.head as XExpression, annoVal.operation?.returnType)
				if (type instanceof JvmTypeReference) {
					return type.type
				}
			}
		}
		return null				
	}
	
	def getProcessorType(XAnnotation it) {
		return tryFindAnnotationType.processorType
	}
	
	def tryFindAnnotationType(XAnnotation it) {
		switch proxy : it.eGet(XANNOTATION__ANNOTATION_TYPE, false) {
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
