/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.hover;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.ui.JavaElementLabels;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmInterfaceType;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typing.ITypeProvider;
import org.summer.dsl.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("deprecation")
public class SsHoverSignatureProvider extends XbaseDeclarativeHoverSignatureProvider {

	@Inject
	protected IXtendJvmAssociations associations;

	@Inject
	protected ITypeProvider typeProvider;

	protected String _signature(JvmGenericType clazz, boolean typeAtEnd) {
		return clazz.getSimpleName() + hoverUiStrings.typeParameters(clazz.getTypeParameters());
	}

	protected String _signature(JvmOperation function, boolean typeAtEnd) {
		String returnTypeString = "void";
		JvmTypeReference returnType = typeProvider.getTypeForIdentifiable(function);
		if (returnType != null) {
			if (returnType instanceof JvmAnyTypeReference) {
				returnTypeString = "Object";
			} else {
				returnTypeString = returnType.getSimpleName();
			}
		}
		String signature = function.getSimpleName() + hoverUiStrings.parameters(function)
				+ getThrowsDeclaration(function);
		String typeParameter = uiStrings.typeParameters(function.getTypeParameters());
		if(typeParameter != null && typeParameter.length() > 0){
			return typeParameter + " " + returnTypeString + " " + signature;
		}
		return returnTypeString + " " + signature;
	}

	protected String _signature(JvmField field, boolean typeAtEnd) {
		if (field != null) {
			JvmTypeReference type = typeProvider.getTypeForIdentifiable(field);
			if (type != null) {
				if (field.getSimpleName() == null)
					return type.getSimpleName();
				return type.getSimpleName() + " " + field.getSimpleName();
			}
		}
		if (field.getSimpleName() == null)
			return "";
		return field.getSimpleName();
	}

	protected String _signature(JvmFormalParameter parameter, boolean typeAtEnd) {
		EObject container = parameter.eContainer();
		JvmTypeReference type = parameter.getParameterType();
		if (type != null) {
			String signature = parameter.getSimpleName();
			String signatureOfFather = getSimpleSignature(container);
			if(signatureOfFather != null){
				signature += JavaElementLabels.CONCAT_STRING + signatureOfFather;
			}
			if (typeAtEnd)
				return signature + " : " + type.getSimpleName();
			return type.getSimpleName() + " " + signature;
		}
		return parameter.getSimpleName();
	}

	protected String _signature(JvmConstructor constructor, boolean typeAtEnd) {
		JvmDeclaredType xtendClazz = EcoreUtil2.getContainerOfType(constructor, JvmDeclaredType.class);
		return xtendClazz.getSimpleName() + hoverUiStrings.parameters(constructor)
				+ getThrowsDeclaration(constructor);
	}

	protected String _signature(JvmInterfaceType interfaze , boolean typeAtEnd){
		return interfaze.getSimpleName();
	}

	protected String _signature(JvmEnumerationType enu , boolean typeAtEnd){
		return enu.getSimpleName();
	}

	protected String _signature(JvmAnnotationType anno , boolean typeAtEnd){
		return anno.getSimpleName();
	}

	@Override
	protected String getSimpleSignature(EObject container) {
		if(container instanceof JvmOperation){
			JvmOperation function = (JvmOperation) container;
			return function.getSimpleName() + uiStrings.parameters(function);
		}
		else if (container instanceof JvmConstructor){
			JvmConstructor constructor = (JvmConstructor) container;
			JvmDeclaredType xtendClazz = EcoreUtil2.getContainerOfType(constructor, JvmDeclaredType.class);
			return xtendClazz.getSimpleName() + " " + uiStrings.parameters(constructor);
		}
		return super.getSimpleSignature(container);
	}
	
	@Override
	public String getImageTag(EObject object) {
		if(object instanceof JvmFormalParameter)
			return super.getImageTag(getFormalParameter(object));
		return super.getImageTag(object);
	}
	
	private JvmFormalParameter getFormalParameter(EObject parameter) {
		Set<EObject> jvmElements = associations.getJvmElements(parameter);
		if (jvmElements.size() > 0) {
			return (JvmFormalParameter) Lists.newArrayList(jvmElements).get(0);
		} else
			return null;
	}

}
