/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xannotation.validation;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmType;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.linking.impl.LinkingDiagnosticMessageProvider;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.model.xannotation.XAnnotationElementValuePair;
import org.summer.dsl.model.xannotation.XannotationPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class UnresolvedAnnotationTypeAwareMessageProducer extends LinkingDiagnosticMessageProvider {

	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if (isPropertyOfUnresolvedAnnotation(context))
			return null;
		return super.getUnresolvedProxyMessage(context);
	}
	
	protected boolean isPropertyOfUnresolvedAnnotation(ILinkingDiagnosticContext context) {
		EObject object = context.getContext();
		if (object instanceof XAnnotationElementValuePair && context.getReference() == XannotationPackage.Literals.XANNOTATION_ELEMENT_VALUE_PAIR__ELEMENT) {
			XAnnotation annotation = EcoreUtil2.getContainerOfType(object, XAnnotation.class);
			if (annotation != null) {
				JvmType annotationType = annotation.getAnnotationType();
				if (annotationType == null || annotationType.eIsProxy() || !(annotationType instanceof JvmAnnotationType)) {
					return true;
				}
			}
		}
		return false;
	}

}
