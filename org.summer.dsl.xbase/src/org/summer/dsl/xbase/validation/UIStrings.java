/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation;

import static com.google.common.collect.Iterables.*;

import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.Triple;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XConstructorCall;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.impl.FeatureCallToJavaMapping;
import org.summer.dsl.xbase.typing.ITypeProvider;

import com.google.common.base.Function;
import com.google.inject.Inject;

/**
 * UI presentable string representation of Xbase elements.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@SuppressWarnings("deprecation")
public class UIStrings {

	@Inject
	private ITypeProvider typeProvider;
	
	@Inject
	private FeatureCallToJavaMapping featureCallToJavaMapping;
	
	@Inject
	private LazyURIEncoder lazyURIEncoder;
	
	public String signature(JvmExecutable executable) {
		StringBuilder b = new StringBuilder(executable.getSimpleName());
		b.append(parameters(executable));
		if(executable instanceof JvmOperation) 
			b.append(" : ").append(((JvmOperation) executable).getReturnType().getSimpleName());
		return b.toString();
	}
	
	public String parameters(JvmIdentifiableElement element) {
		if (element instanceof JvmExecutable) {
			return "(" + parameterTypes(((JvmExecutable)element).getParameters(), ((JvmExecutable)element).isVarArgs()) + ")";
		}
		return "";
	}

	public String arguments(XAbstractFeatureCall featureCall) {
		List<XExpression> arguments = featureCallToJavaMapping.getActualArguments(featureCall);
		return "(" + expressionTypes(arguments) + ")";
	}

	public String arguments(XConstructorCall constructorCall) {
		return "(" + expressionTypes(constructorCall.getArguments()) + ")";
	}

	public String typeParameters(Iterable<? extends JvmTypeParameter> typeParams) {
		if (!isEmpty(typeParams)) {
			return "<" + toString(typeParams) + ">";
		}
		return "";
	}
	
	public String typeParameters(JvmIdentifiableElement element) {
		if (element instanceof JvmTypeParameterDeclarator) {
			return "<" + toString(((JvmTypeParameterDeclarator) element).getTypeParameters()) + ">";
		}
		return "";
	}
	
	public String typeArguments(XAbstractFeatureCall featureCall) {
		return "<" + referencesToString(featureCall.getTypeArguments()) + ">";
	}

	public String typeArguments(XConstructorCall constructorCall) {
		return "<" + referencesToString(constructorCall.getTypeArguments()) + ">";
	}

	protected String toString(Iterable<? extends JvmIdentifiableElement> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmIdentifiableElement type : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			if(type != null) {
				buffer.append(type.getSimpleName());
			} else 
				buffer.append("[null]");
		}
		return buffer.toString();
	}
	
	protected String referencesToString(Iterable<? extends JvmTypeReference> elements) {
		StringBuilder buffer = new StringBuilder();
		boolean needsSeparator = false;
		for (JvmTypeReference typeRef : elements) {
			if (needsSeparator)
				buffer.append(", ");
			needsSeparator = true;
			buffer.append(referenceToString(typeRef, "[null]"));
		}
		return buffer.toString();
	}
	
	/**
	 * @since 2.4
	 */
	public String referenceToString(JvmTypeReference typeRef, String defaultLabel) {
		if(typeRef != null) {
			if (typeRef instanceof JvmAnyTypeReference)
				return "Object";
			else {
				JvmType type = typeRef.getType();
				if (type != null && type.eIsProxy() && typeRef.eResource() != null) {
					URI proxyURI = EcoreUtil.getURI(type);
					String fragment = proxyURI.fragment();
					if (lazyURIEncoder.isCrossLinkFragment(typeRef.eResource(), fragment)) {
						Triple<EObject, EReference, INode> decoded = lazyURIEncoder.decode(typeRef.eResource(), fragment);
						INode node = decoded.getThird();
						if (node != null) {
							String text = node.getRootNode().getText();
							ITextRegion textRegion = node.getTextRegion();
							String result = text.substring(textRegion.getOffset(), textRegion.getLength() + textRegion.getOffset());
							return result;
						} else {
							return defaultLabel;
						}
					}
				} else {
					return typeRef.getSimpleName();
				}
			}
		}
		return defaultLabel;
	}

	protected String expressionTypes(Iterable<XExpression> expressions) {
		return referencesToString(transform(expressions, new Function<XExpression, JvmTypeReference>() {
			public JvmTypeReference apply(XExpression from) {
				return typeProvider.getType(from);
			}
		}));
	}

	protected String parameterTypes(Iterable<JvmFormalParameter> parameters, @SuppressWarnings("unused") boolean isVarArgs) {
		return referencesToString(transform(parameters, new Function<JvmFormalParameter, JvmTypeReference>() {
			public JvmTypeReference apply(JvmFormalParameter from) {
				return from.getParameterType();
			}
		}));
	}
	
}
