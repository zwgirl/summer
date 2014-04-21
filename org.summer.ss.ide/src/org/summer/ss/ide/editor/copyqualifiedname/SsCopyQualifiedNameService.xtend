/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.editor.copyqualifiedname

import org.eclipse.emf.ecore.EObject
import org.summer.dsl.model.ss.XtendConstructor
import org.summer.dsl.model.ss.XtendFunction
import org.summer.dsl.xbase.ui.editor.copyqualifiedname.XbaseCopyQualifiedNameService

/**
 * @author Anton Kosyakov - Initial contribution and API
 * @since 2.4
 */
class SsCopyQualifiedNameService extends XbaseCopyQualifiedNameService {

	def dispatch String getQualifiedName(XtendFunction it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(XtendFunction it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(XtendFunction it) {
		'''�toFullyQualifiedName�(�parameters.toQualifiedNames[parameterType.simpleName]�)'''
	}

	def dispatch String getQualifiedName(XtendConstructor it, EObject context) {
		toQualifiedName
	}

	def dispatch String getQualifiedName(XtendConstructor it, Void context) {
		toQualifiedName
	}

	protected def String toQualifiedName(XtendConstructor it) {
		'''�toFullyQualifiedName�(�parameters.toQualifiedNames[parameterType.simpleName]�)'''
	}

}
