/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.codetemplates.ui.validation;

import java.util.Iterator;

import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.TemplateContextType;
import org.eclipse.jface.text.templates.TemplateVariableResolver;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Grammar;
import org.eclipse.xtext.ParserRule;
import org.summer.dsl.ui.codetemplates.templates.Codetemplate;
import org.summer.dsl.ui.codetemplates.templates.Codetemplates;
import org.summer.dsl.ui.codetemplates.templates.TemplatesPackage;
import org.summer.dsl.ui.codetemplates.templates.Variable;
import org.summer.dsl.ui.codetemplates.validation.CodetemplatesJavaValidator;
import org.eclipse.xtext.ui.editor.templates.ContextTypeIdHelper;
import org.eclipse.xtext.util.Strings;
import org.eclipse.xtext.validation.Check;
import org.summer.dsl.ui.codetemplates.ui.registry.LanguageRegistry;
import org.summer.dsl.ui.codetemplates.ui.resolvers.IInspectableTemplateVariableResolver;
import org.summer.dsl.ui.codetemplates.ui.resolvers.InspectableTemplateVariableResolverRegistry;

import com.google.common.collect.Iterators;
import com.google.inject.Inject;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TemplateValidator extends CodetemplatesJavaValidator {

	@Inject
	private InspectableTemplateVariableResolverRegistry registry;
	
	@Inject
	private LanguageRegistry languageRegistry;
	
	@Check
	public void checkParameters(Variable variable) {
		Codetemplate template = EcoreUtil2.getContainerOfType(variable, Codetemplate.class);
		Codetemplates templates = EcoreUtil2.getContainerOfType(template, Codetemplates.class);
		if (templates != null && template != null) {
			Grammar language = templates.getLanguage();
			AbstractRule rule = template.getContext();
			ContextTypeIdHelper helper = languageRegistry.getContextTypeIdHelper(language); 
			if (helper != null && rule != null && !rule.eIsProxy() && rule instanceof ParserRule) {
				String contextTypeId = helper.getId(rule);
				ContextTypeRegistry contextTypeRegistry = languageRegistry.getContextTypeRegistry(language);
				TemplateContextType contextType = contextTypeRegistry.getContextType(contextTypeId);
				if (contextType != null) {
					Iterator<TemplateVariableResolver> resolvers = Iterators.filter(contextType.resolvers(), TemplateVariableResolver.class);
					String type = variable.getType();
					if (type == null)
						type = variable.getName();
					while(resolvers.hasNext()) {
						final TemplateVariableResolver resolver = resolvers.next();
						if (resolver.getType().equals(type)) {
							IInspectableTemplateVariableResolver inspectableResolver = registry.toInspectableResolver(resolver);
							if (inspectableResolver != null) {
								inspectableResolver.validateParameters(variable, this);
							}
						}
					}
				}
			}
		}
	}
	
	@Check
	public void checkNameIsNotEmpty(Codetemplate template) {
		if (Strings.isEmpty(template.getName())) {
			error("Template name cannot be empty.", TemplatesPackage.Literals.CODETEMPLATE__NAME);
		}
	}
	
}
