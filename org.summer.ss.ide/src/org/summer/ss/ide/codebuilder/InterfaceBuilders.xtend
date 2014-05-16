package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import org.eclipse.jdt.core.IType
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.xbase.compiler.ISourceAppender

abstract class AbstractInterfaceBuilder extends AbstractCodeBuilder {
	
	@Property String interfaceName
	
	override getImage() {
		'newint_wiz.gif'
	}
	
}

class XtendInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Xtend {
	
	@Inject extension InsertionOffsets
	
	override isValid() {
		super.valid && interfaceName != null && visibility == JvmVisibility.PUBLIC  
	}	

	override build(ISourceAppender appendable) {
		appendable.append('interface ').append(interfaceName).append(' {')
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

class JavaInterfaceBuilder extends AbstractInterfaceBuilder implements ICodeBuilder.Java {
	
	override isValid() {
		super.valid && interfaceName != null  
	}	

	override build(ISourceAppender appendable) {
//		appendable.appendVisibility(visibility, JvmVisibility.DEFAULT) // cym comment
		appendable.appendVisibility(visibility, JvmVisibility.PUBLIC)
			.append('interface ').append(interfaceName).append(' {')
			.newLine.append('}')
	}

	override getIType() {
		ownerSource as IType
	}
}