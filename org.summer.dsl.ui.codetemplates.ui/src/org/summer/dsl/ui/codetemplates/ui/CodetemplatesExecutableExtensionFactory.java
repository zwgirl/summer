/*
 * generated by Xtext
 */
package org.summer.dsl.ui.codetemplates.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;
import org.summer.dsl.ui.codetemplates.ui.internal.CodetemplatesActivator;

import com.google.inject.Injector;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class CodetemplatesExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return CodetemplatesActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return CodetemplatesActivator.getInstance().getInjector(CodetemplatesActivator.ORG_ECLIPSE_XTEXT_UI_CODETEMPLATES_CODETEMPLATES);
	}
	
}
