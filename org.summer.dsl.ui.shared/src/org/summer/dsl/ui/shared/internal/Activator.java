/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.shared.internal;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IWorkspace;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.Platform;
import org.eclipse.core.runtime.Plugin;
import org.eclipse.jdt.core.JavaCore;
import org.eclipse.jdt.ui.JavaUI;
import org.summer.dsl.model.ui.notification.TypeResourceUnloader;
import org.osgi.framework.BundleContext;

import com.google.inject.Binder;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.google.inject.util.Modules;

public class Activator extends Plugin {

	private static final Logger log = Logger.getLogger(Activator.class);

	private static Activator plugin;

	public static final String PLUGIN_ID = "org.summer.dsl.ui.shared"; //$NON-NLS-1$

	public static Activator getDefault() {
		return plugin;
	}

	private Injector injector;

	@Inject
	private IWorkspace workspace;

	@Inject
	private EagerContributionInitializer initializer;

	public Injector getInjector() {
		return injector;
	}

	protected void initializeInjector(BundleContext context) {
		IExtensionPoint point = Platform.getExtensionRegistry().getExtensionPoint(PLUGIN_ID + ".overridingGuiceModule");
		IExtension[] extensions = point.getExtensions();
		Module module = new SharedModule(context);
		if (extensions.length != 0) {
			int numberOfMixedInModules = 0;
			for (IExtension iExtension : extensions) {
				IConfigurationElement[] elements = iExtension.getConfigurationElements();
				for (IConfigurationElement e : elements) {
					try {
						Module m = (Module) e.createExecutableExtension("class");
						module = Modules.override(module).with(m);
						numberOfMixedInModules++;
						if (numberOfMixedInModules == 2) {
							log.warn("Multiple overriding guice modules. Will use them in unspecified order.");
						}
					} catch (CoreException e1) {
						log.error(e1.getMessage(), e1);
					}
				}
			}
		}

		injector = Guice.createInjector(module);
		injector.createChildInjector(new Module() {
			public void configure(Binder binder) {
				binder.bind(EagerContributionInitializer.class);
			}
		}).injectMembers(this);
	}

	public static boolean isJavaEnabled() {
		try {
			JavaCore.class.getName();
			JavaUI.class.getName();
			TypeResourceUnloader.class.getName();
			return true;
		} catch (Throwable e) {
			log.warn("Disabling JDT use. : " + e.getMessage());
			log.debug(e.getMessage(), e);
		}
		return false;
	}

	@Override
	public void start(BundleContext context) throws Exception {
		try {
			super.start(context);
			plugin = this;
			initializeInjector(context);
			initializer.initialize();
		} catch (Exception e) {
			log.error("Error initializing " + PLUGIN_ID + ":" + e.getMessage(), e);
		}
	}

	@Override
	public void stop(BundleContext context) throws Exception {
		plugin = null;
		injector = null;
		initializer.discard();
		initializer = null;
		workspace = null;
		super.stop(context);
	}

}
