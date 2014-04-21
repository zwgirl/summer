/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.util.IPropertyChangeListener;
import org.eclipse.jface.util.PropertyChangeEvent;
import org.eclipse.xtext.preferences.PreferenceKey;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.preferences.PreferenceConstants;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Michael Clay - Initial contribution and API
 * @author Dennis Huebner - IssueCodes
 */
@Singleton
public class SsPreferenceStoreInitializer implements IPreferenceStoreInitializer, IPropertyChangeListener {
	private IPreferenceStoreAccess preferenceStoreAccess;
	private @Inject ConfigurableIssueCodesProvider issueCodes;
	
	public void initialize(IPreferenceStoreAccess preferenceStoreAccess) {
		this.preferenceStoreAccess = preferenceStoreAccess;
		setupIssueCodesDefaults(preferenceStoreAccess);

		IPreferenceStore preferenceStore = org.eclipse.jdt.ui.PreferenceConstants.getPreferenceStore();
		preferenceStore.addPropertyChangeListener(this);
		preferenceStoreAccess.getWritablePreferenceStore().setDefault(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION,
				preferenceStore.getBoolean(org.eclipse.jdt.ui.PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION));
		
	}

	private void setupIssueCodesDefaults(IPreferenceStoreAccess preferenceStoreAccess) {
		for (PreferenceKey prefKey : issueCodes.getConfigurableIssueCodes().values()) {
			preferenceStoreAccess.getWritablePreferenceStore().setDefault(prefKey.getId(), prefKey.getDefaultValue());
		}
	}

	public void propertyChange(PropertyChangeEvent event) {
		if (preferenceStoreAccess == null) {
			return;
		}
		if (org.eclipse.jdt.ui.PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION.equalsIgnoreCase(event.getProperty())) {
			preferenceStoreAccess.getWritablePreferenceStore().setValue(PreferenceConstants.EDITOR_SUB_WORD_NAVIGATION,
					Boolean.valueOf(event.getNewValue().toString()));
		}

	}

}
