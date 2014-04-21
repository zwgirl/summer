/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.documentation

import org.eclipse.emf.ecore.EObject
import org.summer.dsl.model.ss.XtendAnnotationTarget
import org.summer.dsl.model.ss.SsPackage
import org.eclipse.xtext.documentation.impl.MultiLineCommentDocumentationProvider

/**
 * @author Sven Efftinge - Initial contribution and API
 */
class XtendDocumentationProvider extends MultiLineCommentDocumentationProvider {
	
	override getDocumentation(EObject o) {
		if (!shouldBeHandeled(o)) {
			return null;
		}
		super.getDocumentation(o)
	}
	
	override getDocumentationNodes(EObject o) {
		if (!shouldBeHandeled(o)) {
			return emptyList;
		}
		super.getDocumentationNodes(o)
	}
	
	/**
	 * The Xtend parser constructs a synthetic nested AST element to hold annotations which should be ignored as a documentation provider
	 */
	def boolean shouldBeHandeled(EObject o) {
		!(o instanceof XtendAnnotationTarget && o.eContainingFeature == SsPackage.Literals.XTEND_MEMBER__ANNOTATION_INFO)
	}
	
}