/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.validation;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @since 2.4
 */
public class IssueSeveritiesProvider {
	
	@Inject private IPreferenceValuesProvider valuesProvider;
	@Inject private ConfigurableIssueCodesProvider issueCodesProvider;
	@Inject private SeverityConverter severityConverter;
	
	protected IPreferenceValuesProvider getValuesProvider() {
		return valuesProvider;
	}
	
	public IssueSeverities getIssueSeverities(Resource context) {
		IPreferenceValues preferenceValues = valuesProvider.getPreferenceValues(context);
		return new IssueSeverities(preferenceValues, issueCodesProvider.getConfigurableIssueCodes(), severityConverter);
	}
}
