/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.IJavaProject;
import org.summer.dsl.model.types.access.jdt.IJavaProjectProvider;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IssueSeverities;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.summer.dsl.xbase.validation.XbaseSeverityConverter;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XbaseIssueSeveritiesProvider extends IssueSeveritiesProvider {

	@Inject
	private IJavaProjectProvider projectProvider;
	@Inject
	private ConfigurableIssueCodesProvider configurableIssueCodes;

	@Override
	public IssueSeverities getIssueSeverities(final Resource context) {
		IPreferenceValues preferenceValues = getValuesProvider().getPreferenceValues(context);
		return new IssueSeverities(preferenceValues, configurableIssueCodes.getConfigurableIssueCodes(),
				new XbaseSeverityConverter() {

					final IJavaProject project = projectProvider.getJavaProject(context.getResourceSet());

					@Override
					protected String delegatedValue(Pair<String, String> pair) {
						String jdtSeverity = jdtSeverity(project, pair.getFirst());
						if (jdtSeverity == null || "".equals(jdtSeverity)) {
							return super.delegatedValue(pair);
						}
						return jdtSeverity;
					}

					private String jdtSeverity(final IJavaProject project, String severityAsString) {
						if (project == null) {
							return null;
						}
						return project.getOption(severityAsString, true);
					}
				});
	}
}
