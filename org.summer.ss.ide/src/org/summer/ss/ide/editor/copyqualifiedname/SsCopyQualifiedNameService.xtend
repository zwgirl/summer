/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.editor.copyqualifiedname

import org.eclipse.emf.ecore.EObject
import org.summer.dsl.model.types.JvmOperation
import org.summer.dsl.xbase.ui.editor.copyqualifiedname.XbaseCopyQualifiedNameService
import org.summer.dsl.model.types.JvmConstructor

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class SsCopyQualifiedNameService extends XbaseCopyQualifiedNameService {

	def dispatch String getQualifiedName(JvmOperation it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(JvmOperation it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(JvmOperation it) {
		'''�toFullyQualifiedName�(�parameters.toQualifiedNames[parameterType.simpleName]�)'''
	}

	def dispatch String getQualifiedName(JvmConstructor it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(JvmConstructor it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(JvmConstructor it) {
		'''�toFullyQualifiedName�(�parameters.toQualifiedNames[parameterType.simpleName]�)'''
	}

}
