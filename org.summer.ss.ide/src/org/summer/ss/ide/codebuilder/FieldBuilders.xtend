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
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference

import static org.summer.dsl.model.types.JvmVisibility.*

/**
 * @author Jan Koehnlein
 */
abstract class AbstractFieldBuilder extends AbstractCodeBuilder {
	
	@Property String fieldName
	@Property LightweightTypeReference fieldType
	@Property boolean staticFlag
	
	override getImage() {
		switch visibility {
			case PRIVATE: 'field_private_obj.gif'
//			case PROTECTED: 'field_protected_obj.gif'   //cym comment
			case PUBLIC: 'field_public_obj.gif'
			default: 'field_default_obj.gif'
		}
	}
} 

class XtendFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.isValid() && fieldName != null
	}
	
	override build(ISourceAppender appendable) {
		appendable.appendVisibility(visibility, PRIVATE)
		if(staticFlag)
			appendable.append('static ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName)
	}

	override getInsertOffset() {
		getNewFieldInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as JvmDeclaredType
	}
}

class JavaFieldBuilder extends AbstractFieldBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.isValid() && fieldName != null && fieldType != null
	}
	
	override build(ISourceAppender appendable) {
//		appendable.appendVisibility(visibility, DEFAULT)
		appendable.appendVisibility(visibility, PUBLIC) //cym comment
		if(staticFlag)
			appendable.append('static ')
		appendable.appendType(fieldType, "Object").append(' ').append(fieldName).append(';')
	}

	override getIType() {
		ownerSource as IType
	}
}