package org.summer.ss.core.macro.declaration

import org.summer.ss.lib.macro.declaration.Type
import org.summer.ss.lib.macro.declaration.CompilationUnit

@Data
class UnknownType implements Type {
	
	CompilationUnit compilationUnit
	String qualifiedName
	
	override isAssignableFrom(Type otherType) {
		return false;
	}
	
	override getSimpleName() {
		val idx = qualifiedName.lastIndexOf('.')
		if (idx >0 ) {
			qualifiedName.substring(idx)
		} else {
			qualifiedName
		}
	}
	
}