/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.hover;

import static org.summer.dsl.xbase.ui.hover.HoverLinkHelper.createLinkWithLabel;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.xtext.ui.editor.hover.html.XtextElementLinks;
import org.summer.dsl.model.types.JvmAnnotationReference;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.compiler.DocumentationAdapter;
import org.summer.dsl.xbase.ui.hover.XbaseHoverDocumentationProvider;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.typing.XtendOverridesService;

import com.google.common.collect.Lists;
import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 * @since 2.3
 */
@SuppressWarnings("deprecation")
public class SsHoverDocumentationProvider extends XbaseHoverDocumentationProvider {

	@Inject
	private IXtendJvmAssociations associations;

	@Inject
	private XtendOverridesService overridesService;

	@Override
	protected void addAnnotations(EObject object) {
		if (object instanceof JvmAnnotationTarget) {
			for (JvmAnnotationReference annotation : ((JvmAnnotationTarget) object).getAnnotations()) {
				JvmType annotationType = annotation.getAnnotation();
				if (annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType) {
					buffer.append("@");
					buffer.append(createLinkWithLabel(XtextElementLinks.XTEXTDOC_SCHEME,
							EcoreUtil.getURI(annotationType), annotation.getAnnotation().getSimpleName()));
//					EList<XAnnotationElementValuePair> elementValuePairs = annotation.getElementValuePairs();
//					if (elementValuePairs.size() > 0) {
//						buffer.append("(");
//						List<INode> findNodesForFeature = NodeModelUtils.findNodesForFeature(annotation,
//								XannotationPackage.eINSTANCE.getXAnnotation_ElementValuePairs());
//						if (findNodesForFeature.size() > 0)
//							buffer.append(findNodesForFeature.get(0).getText());
//						buffer.append(")");
//					}
					buffer.append("<br>");
				}
			}
		} else {
			super.addAnnotations(object);
		}
	}

	@Override
	protected void handleSuperMethodReferences(EObject context) {
		if (context instanceof JvmOperation) {
			JvmOperation function = (JvmOperation) context;
			if (function.isOverride()) {
				JvmOperation overwritten = overridesService.findOverriddenOperation(function);
				buffer.append("<div>"); //$NON-NLS-1$
				buffer.append("<b>"); //$NON-NLS-1$
				buffer.append("Overrides:"); //$NON-NLS-1$
				buffer.append("</b> "); //$NON-NLS-1$
				buffer.append(createMethodInTypeLinks(overwritten));
				buffer.append("</div>"); //$NON-NLS-1$
			}
		}
	}

	@Override
	protected List<String> initParameterNames() {
		List<String> result = super.initParameterNames();
		if (context instanceof JvmOperation) {
			for (JvmFormalParameter param : ((JvmOperation) context).getParameters()) {
				result.add(param.getSimpleName());
			}
		}
		if (context instanceof JvmConstructor) {
			for (JvmFormalParameter param : ((JvmConstructor) context).getParameters()) {
				result.add(param.getSimpleName());
			}
		}
		return result;
	}

	@Override
	protected Map<String, URI> initExceptionNamesToURI() {
		Map<String, URI> result = super.initExceptionNamesToURI();
		if (context instanceof JvmOperation) {
			for (JvmTypeReference exception : ((JvmOperation) context).getExceptions()) {
				result.put(exception.getSimpleName(), EcoreUtil.getURI(exception.getType()));
			}
		}
		if (context instanceof JvmConstructor) {
			for (JvmTypeReference exception : ((JvmConstructor) context).getExceptions()) {
				result.put(exception.getSimpleName(), EcoreUtil.getURI(exception.getType()));
			}
		}
		return result;
	}

	@Override
	protected List<EObject> getFilteredDerivedElements(EObject o, EClass type) {
		List<EObject> filteredDerivedElements = super.getFilteredDerivedElements(o, type);
		if (filteredDerivedElements.size() > 1)
			return filteredDerivedElements;
		return Lists.newArrayList();
	}

	@Override
	protected List<EObject> getFilteredSourceElements(EObject o, EClass type) {
		List<EObject> filteredSourceElements = super.getFilteredSourceElements(o, type);
		if (filteredSourceElements.size() > 1)
			return filteredSourceElements;
		return Lists.newArrayList();
	}

	protected String resolveDocumentationForJvmElement(EObject jvmElement) {
		String documentation = documentationProvider.getDocumentation(jvmElement);
		if (documentation != null) {
			return documentation;
		}
		DocumentationAdapter adapter = getDocumentationAdapter(jvmElement);
		return adapter == null ? null : adapter.getDocumentation();
	}

}
