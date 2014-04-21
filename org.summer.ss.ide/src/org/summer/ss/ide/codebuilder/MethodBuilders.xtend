/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference

import static org.summer.dsl.model.types.JvmVisibility.*

/**
 * @author Jan Koehnlein
 */
abstract class AbstractMethodBuilder extends AbstractExecutableBuilder {
	
	@Property String methodName
	@Property LightweightTypeReference returnType
	@Property boolean staticFlag
	@Property boolean abstractFlag
	@Property boolean overrideFlag
}

class XtendMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets

	override isValid() {
		super.isValid() && methodName != null
	}
	
	override build(ISourceAppender appendable) {
		appendable.append(if(overrideFlag) 'override ' else 'def ')
			.appendVisibility(visibility, PUBLIC)
		if(staticFlag)
			appendable.append('static ')
		appendable.appendTypeParameters(typeParameters)
		if(abstractFlag)
			appendable.appendType(returnType, "void").append(' ')
		appendable.append(methodName)
			.appendParameters()
			.appendThrowsClause()
		if(!abstractFlag)
			appendable.appendBody('')
		appendable
	}

	override getInsertOffset() {
		getNewMethodInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

class JavaMethodBuilder extends AbstractMethodBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.isValid() && methodName != null
	}
	
	override build(ISourceAppender appendable) {
		if(overrideFlag)
			appendable.append("@Override").newLine 
//		appendable
//			.appendVisibility(visibility, DEFAULT)  // cym comment
		appendable
			.appendVisibility(visibility, PUBLIC)
		if(abstractFlag)
			appendable.append('abstract ')
		if(staticFlag)
			appendable.append('static ')
		appendable
			.appendTypeParameters(typeParameters)
			.appendType(returnType, "void").append(' ')
			.append(methodName)
			.appendParameters()
			.appendThrowsClause()
		if(abstractFlag)
			appendable.append(';')
		else
			appendable.appendBody(';')
		appendable
	}

	override getIType() {
		ownerSource as IType
	}
}

