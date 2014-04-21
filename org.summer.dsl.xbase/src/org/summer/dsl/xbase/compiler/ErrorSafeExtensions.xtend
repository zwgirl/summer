/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
 package org.summer.dsl.xbase.compiler

import com.google.inject.Inject
import org.eclipse.emf.ecore.EObject
import org.summer.dsl.model.types.JvmAnnotationReference
import org.summer.dsl.model.types.JvmCompoundTypeReference
import org.summer.dsl.model.types.JvmParameterizedTypeReference
import org.summer.dsl.model.types.JvmSpecializedTypeReference
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.types.JvmUnknownTypeReference
import org.summer.dsl.model.types.JvmWildcardTypeReference
import org.summer.dsl.model.types.util.AbstractTypeReferenceVisitor
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.Issue
import org.summer.dsl.xbase.compiler.output.ErrorTreeAppendable
import org.summer.dsl.xbase.compiler.output.ITreeAppendable

/** 
 * @author Jan Koehnlein
 */
class ErrorSafeExtensions {
	
	@Inject extension TypeReferenceSerializer 

	@Inject IElementIssueProvider.Factory issueProviderFactory

	def Iterable<Issue> getErrors(EObject element) {
		val issueProvider = issueProviderFactory.get(element.eResource)
		issueProvider.getIssues(element).filter[severity == Severity.ERROR]
	}

	def boolean hasErrors(EObject element) {
		val issueProvider = issueProviderFactory.get(element.eResource)
		issueProvider.getIssues(element).exists[it.severity == Severity.ERROR]
	}
	
	def <T extends EObject> void forEachSafely(ITreeAppendable appendable, Iterable<T> elements, 
			(LoopParams)=>void loopInitializer, 
			(T, ITreeAppendable)=>void body) {
		if(elements.empty)
			return
		val loopParams = new LoopParams => loopInitializer
		val allElementsBroken = elements.filter[it.hasErrors()].size == elements.size
		var currentAppendable = if(allElementsBroken) 
				appendable.openErrorAppendable(null, elements.head)
			else 
				appendable
		loopParams.appendPrefix(currentAppendable)
		var isFirst = true
		var isFirstBroken = true
		for(element: elements) {
			if(!element.hasErrors()) {
				currentAppendable = appendable.closeErrorAppendable(currentAppendable)
				if(!isFirst)
					loopParams.appendSeparator(appendable)
				isFirst = false
				body.apply(element, appendable)
			} else {
				if(!allElementsBroken)
					currentAppendable = openErrorAppendable(appendable, currentAppendable, element)
				if(!isFirst || !isFirstBroken)
					loopParams.appendSeparator(currentAppendable)
				isFirstBroken = false
				try {
					body.apply(element, currentAppendable)
				} catch(Exception ignoreMe) {} 
			}
		}
		currentAppendable = if(allElementsBroken) 
				currentAppendable
			else 
				appendable.closeErrorAppendable(currentAppendable)
		loopParams.appendSuffix(currentAppendable)
		appendable.closeErrorAppendable(currentAppendable)
	}	
	
	def protected openErrorAppendable(ITreeAppendable parent, ITreeAppendable child, EObject context) {
		if(!(child instanceof ErrorTreeAppendable))
			parent.errorChild(context).append("/* ")
		else 
			child
	}

	def protected closeErrorAppendable(ITreeAppendable parent, ITreeAppendable child) {
		if(child instanceof ErrorTreeAppendable && child != parent)
			child.append(" */")
		parent
	}

	def void serializeSafely(JvmTypeReference typeRef, ITreeAppendable appendable) {
		serializeSafely(typeRef, null, appendable)
	}
	
	def void serializeSafely(JvmTypeReference typeRef, String surrogateType, ITreeAppendable appendable) {
		if(typeRef == null || typeRef.type == null) {
			switch(typeRef) {
				JvmSpecializedTypeReference: typeRef.equivalent.serializeSafely(surrogateType, appendable)
				JvmUnknownTypeReference: appendable.append(typeRef.qualifiedName)
				default: {
					val errorChild = appendable.openErrorAppendable(appendable, typeRef)
					errorChild.append("type is 'null'")
					appendable.closeErrorAppendable(errorChild)
				}
			}
		} else {
			if(typeRef.accept(new BrokenTypeRefDetector)) {
				val errorChild = appendable.openErrorAppendable(appendable, typeRef.eContainer)
				try {
					serialize(typeRef, typeRef.eContainer, errorChild)
				} catch(Exception ignoreMe) {}
				appendable.closeErrorAppendable(errorChild)
				if(surrogateType != null) 
					appendable.append(surrogateType)
			} else {
				serialize(typeRef, typeRef.eContainer, appendable)
			}
		}
	}
	
	def void serializeSafely(JvmAnnotationReference annotationRef, ITreeAppendable appendable, (ITreeAppendable)=>void onSuccess) {
		if(annotationRef == null || annotationRef.annotation == null) {
			val errorChild = appendable.openErrorAppendable(appendable, annotationRef)
			errorChild.append("annotation is 'null'")
			appendable.closeErrorAppendable(errorChild)
		} else {
			if(annotationRef.annotation.eIsProxy) {
				val errorChild = appendable.openErrorAppendable(appendable, annotationRef.eContainer)
				appendable.append("@")
				appendable.append(annotationRef.annotation)
				appendable.closeErrorAppendable(errorChild)
			} else {
				appendable.append("@")
				appendable.append(annotationRef.annotation)
				onSuccess.apply(appendable)
			}
		}
	}
}

class BrokenTypeRefDetector extends AbstractTypeReferenceVisitor.InheritanceAware<Boolean> {
	
	override protected handleNullReference() {
		true
	}
	
	override doVisitTypeReference(JvmTypeReference it) {
		type==null || type.eIsProxy
	}
	
	override doVisitCompoundTypeReference(JvmCompoundTypeReference it) {
		doVisitTypeReference || references.exists[visit]
	}
	
	override doVisitParameterizedTypeReference(JvmParameterizedTypeReference it) {
		doVisitTypeReference || arguments.exists[visit]
	}
	
	override doVisitWildcardTypeReference(JvmWildcardTypeReference it) {
		constraints.exists[typeReference.visit]
	}
	
}