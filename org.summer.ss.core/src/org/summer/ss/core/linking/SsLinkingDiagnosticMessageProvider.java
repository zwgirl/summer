/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.linking;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.ss.core.validation.IssueCodes;
import org.summer.dsl.model.ss.XtendTypeDeclaration;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.TypesPackage;
import org.eclipse.xtext.diagnostics.Diagnostic;
import org.eclipse.xtext.diagnostics.DiagnosticMessage;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.linking.impl.IllegalNodeException;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XAssignment;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XFeatureCall;
import org.summer.dsl.model.xbase.XMemberFeatureCall;
import org.summer.dsl.model.xbase.XUnaryOperation;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xannotation.XannotationPackage;
import org.summer.dsl.xannotation.validation.UnresolvedAnnotationTypeAwareMessageProducer;
import org.summer.dsl.xbase.util.FeatureCallAsTypeLiteralHelper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class SsLinkingDiagnosticMessageProvider extends UnresolvedAnnotationTypeAwareMessageProducer {

	/**
	 * A user data entry that indicates a broken feature link which could also be
	 * a type literal, e.g. 'String::CASE_INSENSITIVE'.
	 */
	public static final String TYPE_LITERAL = "key:TypeLiteral";
	
	@Inject
	private FeatureCallAsTypeLiteralHelper typeLiteralHelper;
	
	@Override
	public DiagnosticMessage getUnresolvedProxyMessage(ILinkingDiagnosticContext context) {
		if (isPropertyOfUnresolvedAnnotation(context))
			return null;
		String linkText = "";
		try {
			linkText = context.getLinkText();
		} catch (IllegalNodeException e){
			linkText = e.getNode().getText();
		}
		if (linkText == null) {
			return null;
		}
		EObject contextObject = context.getContext();
		if (isStaticMemberCallTarget(contextObject)) {
			String message = String.format("%s cannot be resolved to a type.", linkText);
			return new DiagnosticMessage(message, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, TYPE_LITERAL);
		}
		if(contextObject instanceof XAbstractFeatureCall && !(contextObject instanceof XBinaryOperation || contextObject instanceof XUnaryOperation)){
			XAbstractFeatureCall featureCall = (XAbstractFeatureCall)contextObject;
			XtendTypeDeclaration xtendType = EcoreUtil2.getContainerOfType(featureCall, XtendTypeDeclaration.class);
			if(xtendType != null){
				String clazzName = xtendType.getName();
				@SuppressWarnings("deprecation")
				List<XExpression> explicitArguments = featureCall.getExplicitArguments();
				String firstPartOfMessage = "The method ";
				if(explicitArguments.size() == 0 || featureCall instanceof XAssignment)
					firstPartOfMessage += "or field ";
				if (featureCall instanceof XFeatureCall && typeLiteralHelper.isPotentialTypeLiteral(featureCall, null)) {
					return new DiagnosticMessage(firstPartOfMessage + linkText + " is undefined for the type " + clazzName, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText, TYPE_LITERAL);	
				}
				return new DiagnosticMessage(firstPartOfMessage + linkText + " is undefined for the type " + clazzName, Severity.ERROR, IssueCodes.FEATURECALL_LINKING_DIAGNOSTIC, linkText);
			}
		}
		EClass referenceType = context.getReference().getEReferenceType();
		String msg = String.format("%s cannot be resolved%s.", linkText, getTypeName(referenceType, context.getReference()));
		return new DiagnosticMessage(msg, Severity.ERROR, Diagnostic.LINKING_DIAGNOSTIC, linkText);
	}

	protected boolean isStaticMemberCallTarget(EObject contextObject) {
		boolean candidate = contextObject instanceof XFeatureCall && contextObject.eContainingFeature() == XbasePackage.Literals.XMEMBER_FEATURE_CALL__MEMBER_CALL_TARGET;
		if (candidate) {
			XMemberFeatureCall memberFeatureCall = (XMemberFeatureCall) contextObject.eContainer();
			if (memberFeatureCall.isExplicitStatic()) {
				return true;
			}
		}
		return false;
	}
	
	@Nullable
	protected String getTypeName(EClass c, EStructuralFeature referingFeature) {
		if (referingFeature == XannotationPackage.Literals.XANNOTATION__ANNOTATION_TYPE)
			return " to an annotation type";
		if (c == TypesPackage.Literals.JVM_ENUMERATION_TYPE)
			return " to an enum type";
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, c))
			return " to a type";
		if (c == TypesPackage.Literals.JVM_OPERATION) {
			return " to an operation";
		}
		return "";
	}

}
