/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.macro.declaration

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EStructuralFeature
import org.summer.dsl.model.ss.XtendField
import org.summer.dsl.model.ss.XtendFunction
import org.summer.dsl.model.ss.SsPackage
import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.ss.lib.macro.declaration.Element
import org.summer.ss.lib.macro.services.Problem
import org.summer.ss.lib.macro.services.ProblemSupport
import org.summer.dsl.model.types.JvmFormalParameter
import org.summer.dsl.model.types.TypesPackage
import org.eclipse.xtext.diagnostics.Severity
import org.eclipse.xtext.validation.EObjectDiagnosticImpl
import org.eclipse.emf.ecore.resource.Resource

class ProblemSupportImpl implements ProblemSupport {
	
	CompilationUnitImpl compilationUnit
	new (CompilationUnitImpl compilationUnit) {
		this.compilationUnit = compilationUnit
	}
	
	private def checkCanceled() {
		compilationUnit.checkCanceled
	}
	
	override addError(Element element, String message) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.errors.add(new EObjectDiagnosticImpl(Severity.ERROR, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override addWarning(Element element, String message) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		resAndObj.key.warnings.add(new EObjectDiagnosticImpl(Severity.WARNING, 'user.issue', message, resAndObj.value, getSignificantFeature(resAndObj.value), -1, null))
	}
	
	override getProblems(Element element) {
		checkCanceled
		val resAndObj = getResourceAndEObject(element)
		val resource = resAndObj.key
		val issues = (resource.errors + resource.warnings).filter(EObjectDiagnosticImpl)
		
		val result = issues.filter[diag | diag.problematicObject == resAndObj.value ].map[ diag |
			new ProblemImpl(diag.code, diag.message, translateSeverity(diag.severity)) as Problem
		]
		return result.toList
	}
	
	def EStructuralFeature getSignificantFeature(EObject obj) {
		return switch obj {
			XtendTypeDeclaration : SsPackage.eINSTANCE.xtendTypeDeclaration_Name
			XtendField : SsPackage.eINSTANCE.xtendField_Name
			XtendFunction : SsPackage.eINSTANCE.xtendFunction_Name
			// FIXME: find something appropriate for constructors
			//XtendConstructor : XtendPackage.eINSTANCE.xtendConstructor_Name
			JvmFormalParameter : TypesPackage.eINSTANCE.jvmFormalParameter_Name
		}
	}
	
	def private Pair<Resource,EObject> getResourceAndEObject(Element element) {
		checkCanceled
		switch element {
			AbstractElementImpl<? extends EObject>: {
				val resource = element.delegate.eResource
				if (resource == compilationUnit.xtendFile.eResource) {
					val eobject = compilationUnit.jvmAssociations.getPrimarySourceElement(element.delegate)
					if (eobject == null) {
						return resource -> element.delegate
					}
					return resource -> eobject
				}
			} 
		}
		throw new IllegalArgumentException("You can only add issues on locally declared elements.")
	}
	
	def private Problem.Severity translateSeverity(Severity severity) {
		switch (severity) {
			case Severity.ERROR : Problem.Severity.ERROR
			case Severity.WARNING : Problem.Severity.WARNING
			case Severity.INFO : Problem.Severity.INFO
			case Severity.IGNORE : Problem.Severity.IGNORE
		}
	}
}


class ProblemImpl implements Problem {
	
	String id
	String message
	Problem.Severity severity	
	
	new(String id,
	String message,
	Problem.Severity severity) {
		this.id = id
		this.message = message
		this.severity = severity
	}

	override getId() {
		return id
	}
	
	override getMessage() {
		return message
	}
	
	override getSeverity() {
		return severity
	}
	
}