/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.references

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.EReference
import org.eclipse.emf.ecore.InternalEObject
import org.summer.dsl.model.types.JvmComponentType
import org.summer.dsl.model.types.JvmParameterizedTypeReference
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.types.JvmVoid
import org.summer.dsl.model.types.impl.JvmGenericArrayTypeReferenceImplCustom
import org.summer.dsl.model.xtype.XFunctionTypeRef
import org.summer.dsl.model.xtype.impl.XFunctionTypeRefImplCustom

import static org.summer.dsl.model.types.TypesPackage.Literals.*
import static org.summer.dsl.model.xtype.XtypePackage.Literals.*

import static extension org.summer.dsl.model.xtype.util.XFunctionTypeRefs.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class IndexingOwnedConverter extends OwnedConverter {

	new(ITypeReferenceOwner owner) {
		super(owner)
	}

	new(ITypeReferenceOwner owner, boolean keepUnboundWildcards) {
		super(owner, keepUnboundWildcards)
	}

	def dispatch JvmType getType(JvmTypeReference it) {
		throw new UnsupportedOperationException(
			'''It is not possible to get a type for the given jvm type reference: �it.class.name�''')
	}

	def dispatch JvmType getType(JvmGenericArrayTypeReferenceImplCustom it) {
		val componentTypeReference = componentType
		if (componentTypeReference == null) {
			return null
		}
		switch componentType : getType(componentTypeReference) {
			JvmComponentType: componentType.arrayType
			default: null
		}
	}

	def dispatch JvmType getType(JvmParameterizedTypeReference it) {
		getType(JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE)
	}

	def dispatch JvmType getType(XFunctionTypeRef it) {
		getType(XFUNCTION_TYPE_REF__TYPE)
	}

	def dispatch JvmType getType(XFunctionTypeRefImplCustom it) {
		val uri = computeTypeUri(procedure, paramTypes.size)
		eResource.resourceSet.getEObject(uri, true) as JvmType
	}

	def isProcedure(XFunctionTypeRefImplCustom it) {
		val returnType = returnType
		if (returnType == null)
			return true;
		val type = getType(returnType);
		if (type == null)
			return false;
		if (type.eIsProxy)
			return false;
		if (type instanceof JvmVoid)
			return true;
		return false;
	}

	def JvmType getType(EObject it, EReference reference) {
		switch proxy : eGet(reference, false) {
			EObject case proxy.eIsProxy: {
				val uri = (proxy as InternalEObject).eProxyURI
				return eResource.resourceSet.getEObject(uri, true) as JvmType
			}
			JvmType: {
				proxy
			}
		}
	}

	override doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		val result = new FunctionTypeReference(owner, getType(reference));
		for (JvmTypeReference parameter : reference.getParamTypes()) {
			val parameterType = visit(wrapIfNecessary(parameter))
			result.addParameterType(parameterType);

			val typeArgument = new WildcardTypeReference(owner)
			typeArgument.setLowerBound(parameterType)
			typeArgument.addUpperBound(reference.javaLangObjectTypeReference)
			result.addTypeArgument(typeArgument);
		}
		if (reference.getReturnType() != null) {
			val returnType = visit(wrapIfNecessary(reference.getReturnType()))
			result.setReturnType(returnType);

			val typeArgument = new WildcardTypeReference(owner)
			typeArgument.addUpperBound(returnType)
			result.addTypeArgument(typeArgument);
		}
		return result;
	}

	def JvmTypeReference wrapIfNecessary(JvmTypeReference reference) {
		if (reference == null) {
			return null
		}
		val type = getType(reference)
		reference.wrapIfNecessary(type)
	}

	def getJavaLangObjectTypeReference(XFunctionTypeRef reference) {
		new ParameterizedTypeReference(owner, owner.services.typeReferences.findDeclaredType(Object, reference))
	}

}
