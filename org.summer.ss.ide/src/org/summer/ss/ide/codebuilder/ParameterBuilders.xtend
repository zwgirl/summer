package org.summer.ss.ide.codebuilder

import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference

abstract class AbstractParameterBuilder extends AbstractCodeBuilder {
	@Property String name
	@Property LightweightTypeReference type
	@Property boolean varArgsFlag
	@Property boolean extensionFlag
	@Property boolean finalFlag
	
	override build(ISourceAppender appendable) {
		appendable.appendModifiers
		if(varArgsFlag) 
			appendable.appendType((type as ArrayTypeReference).componentType, "Object").append('...')	
		else 
			appendable.appendType(type, "Object")
		appendable.append(" ").append(name)
	}
	
	protected def ISourceAppender appendModifiers(ISourceAppender appendable)

	override isValid() {
		type != null 
		&& (!varArgsFlag || type instanceof ArrayTypeReference)
		&& super.isValid()
	}
	
	override getImage() {
		'parameter.gif'
	}
}

class XtendParameterBuilder extends AbstractParameterBuilder {
	
	protected override appendModifiers(ISourceAppender appendable) {
		if(extensionFlag) 
			appendable.append("extension ")
		appendable
	}
}

class JavaParameterBuilder extends AbstractParameterBuilder {
	
	protected override appendModifiers(ISourceAppender appendable) {
		if(finalFlag) 
			appendable.append("final ")
		appendable
	}
	
	override isValid() {
		!extensionFlag && super.isValid()
	}
	
}
