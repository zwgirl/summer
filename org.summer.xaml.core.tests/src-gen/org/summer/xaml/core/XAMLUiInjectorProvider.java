/*
* generated by Xtext
*/
package org.summer.xaml.core;

import org.eclipse.xtext.junit4.IInjectorProvider;

import com.google.inject.Injector;

public class XAMLUiInjectorProvider implements IInjectorProvider {
	
	public Injector getInjector() {
		return org.summer.xaml.core.ui.internal.XAMLActivator.getInstance().getInjector("org.summer.xaml.core.XAML");
	}
	
}
