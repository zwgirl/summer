package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.xbase.compiler.ISourceAppender

abstract class AbstractAnnotationBuilder extends AbstractCodeBuilder {
	
	@Property String annotationName
	
	override getImage() {
		'newannotation_wiz.gif'
	}
	
}

class XtendAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && annotationName != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('annotation ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getInsertOffset() {
		getNewTypeInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendType() {
		ownerSource as JvmDeclaredType
	}
}

class JavaAnnotationBuilder extends AbstractAnnotationBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && annotationName != null  
	}	

	override build(ISourceAppender appendable) {
//		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)
		appendable.appendVisibility(visibility, JvmVisibility.PUBLIC)
			.append('@interface ').append(annotationName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}