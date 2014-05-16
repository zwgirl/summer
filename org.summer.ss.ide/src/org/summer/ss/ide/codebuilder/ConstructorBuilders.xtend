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

import static org.summer.dsl.model.types.JvmVisibility.*

/**
 * @author Jan Koehnlein
 */
abstract class AbstractConstructorBuilder extends AbstractExecutableBuilder {
}
 
class XtendConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets

	override build(ISourceAppender appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append('new')
			.appendParameters()
			.appendThrowsClause()
			.appendBody('')
	}

	override getInsertOffset() {
		getNewConstructorInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		1
	}
	
	override getXtendType() {
		ownerSource as JvmDeclaredType
	}
}

class JavaConstructorBuilder extends AbstractConstructorBuilder implements ICodeBuilder.Java {
	
	override build(ISourceAppender appendable) {
		appendable
			.appendVisibility(visibility, PUBLIC)
			.append(owner.simpleName)
			.appendParameters()
			.appendThrowsClause()
			.appendBody(';')
	}

	override getIType() {
		ownerSource as IType
	}
}