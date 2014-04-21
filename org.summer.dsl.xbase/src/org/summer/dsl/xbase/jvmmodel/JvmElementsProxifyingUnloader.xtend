package org.summer.dsl.xbase.jvmmodel

import com.google.common.annotations.Beta
import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.summer.dsl.model.types.JvmMember
import org.eclipse.xtext.parser.antlr.IReferableElementsUnloader
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmIdentifiableElement
import org.summer.dsl.model.types.JvmGenericType

@Beta
class JvmElementsProxifyingUnloader implements IReferableElementsUnloader {
	
	override unloadRoot(EObject root) {
		switch root {
			JvmMember : unloadRecursively(root)	
		}
	}
	
	def protected void unloadRecursively(JvmIdentifiableElement element) {
//		Adapters would have to be removed first, because you end up with a StackOverflow if a content adapted is unloaded
//		However, this is disabled, as we are very selectively proxifying elements here, and it isn't sound to remove only half of the adapters.
//		element.eAdapters.clear;
		switch element {
			JvmDeclaredType : {
				for (child : element.members) {
					unloadRecursively(child)
				}
				switch element {
					JvmGenericType : {
						for (child : element.typeParameters) {
							unloadRecursively(child)
						}
					}
				}
			}
			JvmExecutable : {
				for (child : element.parameters) {
					unloadRecursively(child)
				}
				for (child : element.typeParameters) {
					unloadRecursively(child)
				}
			}
		}
		(element as InternalEObject).eSetProxyURI(EcoreUtil.getURI(element))
	}
	
}