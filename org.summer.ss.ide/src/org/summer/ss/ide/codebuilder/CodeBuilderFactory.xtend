/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import com.google.inject.Provider
import org.eclipse.jdt.annotation.NonNullByDefault
import org.eclipse.jdt.core.IType
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.util.jdt.IJavaElementFinder
import org.summer.dsl.xbase.compiler.IAppendable
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations

/** 
 * Creates {@link ICodeBuilder}s to insert Java or Xtend code snippets into an {@link IAppendable}.
 *  
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial implementation and API 
 */
@NonNullByDefault
class CodeBuilderFactory {
	
	@Inject extension IXtendJvmAssociations
	@Inject extension IJavaElementFinder
	
	@Inject Provider<XtendClassBuilder> xtendClassBuilderProvider
	@Inject Provider<XtendInterfaceBuilder> xtendInterfaceBuilderProvider
	@Inject Provider<XtendAnnotationBuilder> xtendAnnotationBuilderProvider
	@Inject Provider<XtendFieldBuilder> xtendFieldBuilderProvider
	@Inject Provider<XtendConstructorBuilder> xtendConstructorBuilderProvider
	@Inject Provider<XtendMethodBuilder> xtendMethodBuilderProvider
	@Inject Provider<XtendParameterBuilder> xtendParameterBuilderProvider
	
	@Inject Provider<JavaClassBuilder> javaClassBuilderProvider
	@Inject Provider<JavaInterfaceBuilder> javaInterfaceBuilderProvider
	@Inject Provider<JavaAnnotationBuilder> javaAnnotationBuilderProvider
	@Inject Provider<JavaFieldBuilder> javaFieldBuilderProvider
	@Inject Provider<JavaConstructorBuilder> javaConstructorBuilderProvider
	@Inject Provider<JavaMethodBuilder> javaMethodBuilderProvider
	@Inject Provider<JavaParameterBuilder> javaParameterBuilderProvider
	
	def createClassBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendClassBuilderProvider.get
			else
				javaClassBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createInterfaceBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendInterfaceBuilderProvider.get
			else
				javaInterfaceBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createAnnotationBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendAnnotationBuilderProvider.get
			else
				javaAnnotationBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createFieldBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendFieldBuilderProvider.get
			else
				javaFieldBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createConstructorBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendConstructorBuilderProvider.get
			else
				javaConstructorBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createMethodBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendMethodBuilderProvider.get
			else
				javaMethodBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def createParameterBuilder(JvmDeclaredType owner) {
		val ownerSource = owner.source
		val builder = 
			if(ownerSource instanceof JvmDeclaredType) 
				xtendParameterBuilderProvider.get
			else
				javaParameterBuilderProvider.get
		builder.owner = owner
		builder.ownerSource = ownerSource
		builder
	}
	
	def Object getSource(JvmDeclaredType element) {
		val xtendType = element.primarySourceElement
		if(xtendType instanceof JvmDeclaredType)
			return xtendType
		val jvmElement = findExactElementFor(element)
		if(jvmElement instanceof IType)
			jvmElement
		else 
			null
	}
}

