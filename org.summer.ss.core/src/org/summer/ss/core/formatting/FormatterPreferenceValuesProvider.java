/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.formatting;

import static org.summer.dsl.xbase.formatting.BasicFormatterPreferenceKeys.*;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.preferences.IPreferenceValues;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.summer.dsl.xbase.formatting.IFormattingPreferenceValuesProvider;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
//TODO Move me to xtext core
public class FormatterPreferenceValuesProvider implements IFormattingPreferenceValuesProvider {
	
	private @Inject IWhitespaceInformationProvider whitespaceInfo;
	private @Inject IPreferenceValuesProvider valuesProvider;

	public IPreferenceValues getPreferenceValues(final Resource resource) {
		final IPreferenceValues preferenceValues = internalGetRawPreferenceValues(resource);
		final String indent = whitespaceInfo.getIndentationInformation(resource.getURI()).getIndentString();
		final String lineSep = whitespaceInfo.getLineSeparatorInformation(resource.getURI()).getLineSeparator();
		
		return new IPreferenceValues() {
			
			public String getPreference(PreferenceKey key) {
				if (key == indentation) {
					return indent;
				}
				if (key == lineSeparator) {
					return lineSep;
				}
				return preferenceValues.getPreference(key);
			}
			
		};
	}

	protected IPreferenceValues internalGetRawPreferenceValues(final Resource resource) {
		return valuesProvider.getPreferenceValues(resource);
	}

}
