/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.editor.copyqualifiedname

import com.google.inject.Inject
import java.util.List
import org.eclipse.emf.ecore.EObject
import org.summer.dsl.model.types.JvmConstructor
import org.summer.dsl.model.types.JvmExecutable
import org.summer.dsl.model.types.JvmOperation
import org.eclipse.xtext.ui.editor.copyqualifiedname.DefaultCopyQualifiedNameService
import org.summer.dsl.model.xbase.XAbstractFeatureCall
import org.summer.dsl.model.xbase.XConstructorCall
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver
import org.summer.dsl.xbase.typesystem.IResolvedTypes
import org.summer.dsl.xbase.typesystem.^override.IResolvedExecutable
import org.summer.dsl.xbase.typesystem.^override.OverrideHelper

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class XbaseCopyQualifiedNameService extends DefaultCopyQualifiedNameService {

	@Inject
	extension OverrideHelper overrideHelper;

	@Inject
	extension IBatchTypeResolver typeResolver

	def dispatch String getQualifiedName(JvmExecutable it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(JvmExecutable it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(JvmExecutable it) {
		'''�toFullyQualifiedName�(�parameters.toQualifiedNames[parameterType.simpleName]�)'''
	}

	protected def dispatch String getQualifiedName(JvmExecutable executable, XAbstractFeatureCall featureCall) {
		val resolvedTypes = featureCall.resolveTypes
		val resolvedExecutable = executable.resolveExecutable(featureCall, resolvedTypes)
		'''�executable.toFullyQualifiedName�(�featureCall.actualArguments.toQualifiedNames [
			toQualifiedName(resolvedExecutable, executable, resolvedTypes, featureCall.actualArguments)
		]�)'''
	}

	protected def dispatch String getQualifiedName(JvmConstructor constructor, XConstructorCall constructorCall) {
		val resolvedTypes = constructorCall.resolveTypes
		val resolvedExecutable = constructor.resolveExecutable(constructorCall, resolvedTypes)
		'''�constructor.toFullyQualifiedName�(�constructorCall.arguments.toQualifiedNames [
			toQualifiedName(resolvedExecutable, constructor, resolvedTypes, constructorCall.arguments)
		]�)'''
	}

	protected def toQualifiedName(XExpression it, IResolvedExecutable resolvedExecutable, JvmExecutable executable,
		extension IResolvedTypes resolvedTypes, List<XExpression> arguments) {
		val actualType = actualType
		if (actualType != null && !actualType.any && !actualType.unknown) {
			return actualType.simpleName
		}
		val index = arguments.indexOf(it)
		if (resolvedExecutable == null) {
			return executable.parameters.get(index).parameterType.simpleName
		}
		return resolvedExecutable.resolvedParameterTypes.get(index).simpleName
	}

	protected def dispatch IResolvedExecutable resolveExecutable(JvmConstructor constructor, XConstructorCall it,
		extension IResolvedTypes resolvedTypes) {
		actualType?.resolvedOperations?.declaredConstructors?.filter[declaration.equals(constructor)]?.head
	}

	protected def dispatch IResolvedExecutable resolveExecutable(JvmOperation operation, XAbstractFeatureCall it,
		extension IResolvedTypes resolvedTypes) {
		actualReceiver?.actualType?.resolvedOperations?.allOperations?.filter[declaration.equals(operation)]?.head
	}

	protected def dispatch IResolvedExecutable resolveExecutable(JvmConstructor consturctor, XAbstractFeatureCall it,
		extension IResolvedTypes resolvedTypes) {
		actualReceiver?.actualType?.resolvedOperations?.declaredConstructors?.filter[declaration.equals(consturctor)]?.
			head
	}

}
