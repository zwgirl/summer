/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xtype.util

import org.eclipse.emf.ecore.EObject
import org.eclipse.emf.ecore.InternalEObject
import org.eclipse.emf.ecore.util.EcoreUtil
import org.summer.dsl.model.types.JvmPrimitiveType
import org.summer.dsl.model.types.JvmType
import org.summer.dsl.model.types.JvmTypeReference
import org.summer.dsl.model.types.JvmVoid
import org.summer.dsl.model.types.TypesFactory
import org.summer.dsl.model.types.access.impl.ClassURIHelper
import org.summer.dsl.xbase.lib.Functions
import org.summer.dsl.xbase.lib.Procedures

import static extension org.eclipse.emf.common.util.URI.*

/**
 * @author Anton Kosyakov - Initial contribution and API
 */
class XFunctionTypeRefs {

	def static computeTypeUri(boolean procedure, int functionParamCount) {
		buildUri(procedure, functionParamCount).createURI
	}

	def static String buildUri(boolean procedure, int functionParamCount) {
		val paramCount = Math.min(6, functionParamCount);
		if (procedure) {
			return '''java:/Objects/«Procedures.canonicalName»#«Procedures.canonicalName»$Procedure«paramCount»'''
		}
		return '''java:/Objects/«Functions.canonicalName»#«Functions.canonicalName»$Function«paramCount»'''
	}

	def static computeTypeUri(Class<?> topLevelClass) {
		new ClassURIHelper().getFullURI(topLevelClass)
	}

	def static JvmTypeReference wrapIfNecessary(JvmTypeReference reference, JvmType type) {
		switch type {
			JvmPrimitiveType: {
				val wrappedType = type.getWrappedType
				if (wrappedType == null) {
					reference
				} else {
					TypesFactory.eINSTANCE.createJvmParameterizedTypeReference => [
						setType(wrappedType)
					]
				}
			}
			JvmVoid case !type.eIsProxy:
				TypesFactory.eINSTANCE.createJvmParameterizedTypeReference => [
					setType(Void.getType(type))
				]
			default:
				reference
		}
	}

	def static getWrappedType(JvmType type) {
		val name = type.identifier
		switch name {
			case "int".equals(name): Integer.getType(type)
			case "boolean".equals(name): Boolean.getType(type)
			case "char".equals(name): Character.getType(type)
			case "long".equals(name): Long.getType(type)
			case "double".equals(name): Double.getType(type)
			case "byte".equals(name): Byte.getType(type)
			case "float".equals(name): Float.getType(type)
			case "short".equals(name): Short.getType(type)
			default: null
		}
	}

	def static getType(Class<?> clazz, EObject context) {
		val proxy = TypesFactory.eINSTANCE.createJvmVoid() as InternalEObject
		proxy.eSetProxyURI(computeTypeUri(clazz))
		EcoreUtil.resolve(proxy, context) as JvmType
	}

}
