/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.codetemplates.ui;

import org.osgi.framework.BundleContext;
import org.summer.dsl.ui.codetemplates.ui.internal.CodetemplatesActivator;
import org.summer.dsl.ui.codetemplates.ui.preferences.TemplatesLanguageConfiguration;
import org.summer.dsl.ui.codetemplates.ui.registry.LanguageRegistry;

import com.google.inject.Injector;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class AccessibleCodetemplatesActivator extends CodetemplatesActivator {

	private TemplatesLanguageConfiguration configuration;

	private LanguageRegistry languageRegistry = createLanguageRegistry();

	@Override
	public void stop(BundleContext context) throws Exception {
		configuration = null;
		super.stop(context);
	}

	protected TemplatesLanguageConfiguration getTemplatesLanguageConfigurationInstance() {
		if (configuration == null) {
			Injector singleTemplateInjector = getInjector("org.eclipse.xtext.ui.codetemplates.SingleCodetemplate");
			configuration = singleTemplateInjector.getInstance(TemplatesLanguageConfiguration.class);
		}
		return configuration;
	}

	public static Provider<TemplatesLanguageConfiguration> getTemplatesLanguageConfigurationProvider() {
		return new Provider<TemplatesLanguageConfiguration>() {
			public TemplatesLanguageConfiguration get() {
				return ((AccessibleCodetemplatesActivator) getInstance()).getTemplatesLanguageConfigurationInstance();
			}
		};
	}

	protected LanguageRegistry createLanguageRegistry() {
		return new LanguageRegistry();
	}

	public static Provider<LanguageRegistry> getLanguageRegistry() {
		return new Provider<LanguageRegistry>() {
			public LanguageRegistry get() {
				return ((AccessibleCodetemplatesActivator) getInstance()).languageRegistry;
			}
		};
	}

}
