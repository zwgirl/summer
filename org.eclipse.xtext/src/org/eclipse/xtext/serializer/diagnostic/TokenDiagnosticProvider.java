/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.diagnostic;

import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EnumLiteralDeclaration;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.util.EmfFormatter;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class TokenDiagnosticProvider implements ITokenDiagnosticProvider {

	protected String getFullReferenceName(EObject semanticObject, CrossReference reference) {
		EReference ref = GrammarUtil.getReference(reference);
		String clazz = semanticObject.eClass().getName();
		if (ref.getEContainingClass() != semanticObject.eClass())
			clazz = ref.getEContainingClass().getName() + "(" + clazz + ")";
		return clazz + "." + ref.getName();
	}

	public ISerializationDiagnostic getInvalidEnumValueDiagnostic(EObject semanticObject, RuleCall rc, Object value) {
		List<String> valid = Lists.newArrayList();
		for (EnumLiteralDeclaration eld : org.eclipse.xtext.EcoreUtil2.getAllContentsOfType(rc.getRule(),
				EnumLiteralDeclaration.class))
			valid.add(eld.getEnumLiteral().getInstance().getName());
		StringBuilder msg = new StringBuilder();
		msg.append("The value '" + value + "' is invalid for enum " + rc.getRule().getName() + "\n");
		msg.append("Valid values are: " + Joiner.on(", ").join(valid));
		return new SerializationDiagnostic(INVALID_ENUM_VALUE, semanticObject, rc, msg.toString());
	}

	public ISerializationDiagnostic getNoEObjectDescriptionFoundDiagnostic(EObject semanticObject,
			CrossReference element, EObject target, IScope scope) {
		String msg = "No EObjectDescription could be found in Scope " + getFullReferenceName(semanticObject, element)
				+ " for " + EmfFormatter.objPath(target);
		return new SerializationDiagnostic(NO_EOBJECT_DESCRIPTION_FOUND, semanticObject, element, msg);
	}

	public ISerializationDiagnostic getNoScopeFoundDiagnostic(EObject semanticObject, CrossReference element,
			EObject target) {
		String msg = "Could not create Scope for EReference " + getFullReferenceName(semanticObject, element);
		return new SerializationDiagnostic(NO_SCOPE_FOUND, semanticObject, element, msg);
	}

	public ISerializationDiagnostic getNullNotAllowedDiagnostic(EObject semanticObject, AbstractElement ele) {
		return new SerializationDiagnostic(NULL_NOT_ALLOWED, semanticObject, ele, "Must not be null");
	}

	public ISerializationDiagnostic getValueConversionExceptionDiagnostic(EObject semanticObject,
			AbstractElement element, Object value, Throwable exception) {
		return new SerializationDiagnostic(VALUE_CONVERSION_EXCEPTION, semanticObject, element, exception.getMessage());
	}

}
