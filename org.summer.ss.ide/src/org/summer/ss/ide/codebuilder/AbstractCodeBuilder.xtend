/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.codebuilder

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.eclipse.jdt.annotation.NonNullByDefault
import org.summer.dsl.model.types.JvmDeclaredType
import org.summer.dsl.model.types.JvmGenericType
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeParameter
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.types.JvmUnknownTypeReference
import org.summer.dsl.model.types.JvmVisibility
import org.summer.dsl.model.types.util.jdt.IJavaElementFinder
import org.summer.dsl.xbase.compiler.ISourceAppender
import org.summer.dsl.xbase.compiler.StringBuilderBasedAppendable
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference
import org.summer.dsl.model.types.JvmUpperBound
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices
import org.summer.dsl.xbase.typesystem.references.OwnedConverter

/** 
 * @author Jan Koehnlein
 */
@NonNullByDefault
abstract class AbstractCodeBuilder implements ICodeBuilder {

	@Property Object ownerSource
	@Property JvmDeclaredType owner
	@Property JvmVisibility visibility
	@Property EObject context
	
	@Inject extension IJavaElementFinder
	
	@Inject CommonTypeComputationServices services
	
	override isValid() {
		val javaElement = owner.findElementFor
		return (javaElement == null || !javaElement.readOnly) 
			&& ownerSource != null && owner != null && context != null
	}
	
	override getPreview() {
		val appendable = new StringBuilderBasedAppendable
		appendable.append('...').newLine.build.newLine.append('...')
		appendable.toString
	}
	
	def protected appendVisibility(ISourceAppender appendable, JvmVisibility visibility, JvmVisibility skippableDefault) {
		appendable.append(
			switch visibility {
				case skippableDefault: ''
				case JvmVisibility.PRIVATE: 'private '
//				case JvmVisibility.PROTECTED: 'protected ' //cym comment
				case JvmVisibility.PUBLIC: 'public '
				default: ''
			})
	}

	def protected appendType(ISourceAppender appendable, LightweightTypeReference typeRef, String surrogate) {
		if (typeRef == null) {
			appendable.append(surrogate)
		} else {
			appendable.append(typeRef)
		}
		appendable
	}
	
	def protected appendTypeParameters(ISourceAppender appendable, List<JvmTypeParameter> typeParameters) {
		val iterator = typeParameters.iterator
		if(iterator.hasNext()) {
			appendable.append("<")
			do {
				val typeParameter = iterator.next()
				appendable.append(typeParameter.name)
				val upperBounds = typeParameter.constraints.filter(JvmUpperBound).filter[typeReference.identifier != 'java.lang.Object']
				if(!upperBounds.empty) {
					appendable.append(" extends ");
					var isFirst = true
					val owner = new StandardTypeReferenceOwner(services, context)
					val converter = new OwnedConverter(owner) 
					for(upperBound: upperBounds) {
						if(!isFirst)
							appendable.append(" & ")
						isFirst = false
						appendable.appendType(converter.apply(upperBound.typeReference), "Object")
					}
				}
				if (iterator.hasNext())
					appendable.append(",")
			} while (iterator.hasNext())
			appendable.append("> ")
		}
		appendable
	}
	
	def protected getIdentifierOrObject(JvmTypeReference typeReference) {
		switch(typeReference) {
			JvmUnknownTypeReference: "java.lang.Object"
			default: typeReference.identifier
		}
	}

	def protected isInterface(JvmType t) {
		switch t {
			JvmGenericType: t.interface
			default: false
		}
	}
}

