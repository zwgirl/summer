/*
 * generated by Xtext
 */
package org.summer.dsl.xbase.ui;

import org.eclipse.xtext.ui.guice.AbstractGuiceAwareExecutableExtensionFactory;
import org.osgi.framework.Bundle;

import com.google.inject.Injector;

import org.summer.dsl.xbase.ui.internal.XbaseActivator;

/**
 * This class was generated. Customizations should only happen in a newly
 * introduced subclass. 
 */
public class XbaseExecutableExtensionFactory extends AbstractGuiceAwareExecutableExtensionFactory {

	@Override
	protected Bundle getBundle() {
		return XbaseActivator.getInstance().getBundle();
	}
	
	@Override
	protected Injector getInjector() {
		return XbaseActivator.getInstance().getInjector(XbaseActivator.ORG_SUMMER_DSL_XBASE_XBASE);
	}
	
}
