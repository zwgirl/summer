package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.summer.dsl.model.ss.XtendTypeDeclaration
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.xbase.compiler.ISourceAppender

abstract class AbstractClassBuilder extends AbstractCodeBuilder {
	
	@Property String className
	
	override getImage() {
		'newclass_wiz.gif'
	}
	
}

class XtendClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && className != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('class ').append(className).append(' {')
			.newLine.append('}')
	}

	override getInsertOffset() {
		getNewTypeInsertOffset(context, xtendType)
	}
	
	override getIndentationLevel() {
		0
	}
	
	override getXtendType() {
		ownerSource as XtendTypeDeclaration
	}
}

class JavaClassBuilder extends AbstractClassBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && className != null  
	}	

	override build(ISourceAppender appendable) {
//		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT)  // cym comment
		appendable.appendVisibility(visibility, JvmVisibility.PUBLIC)
			.append('class ').append(className).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}