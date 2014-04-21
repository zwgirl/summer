/*
 * generated by Xtext
 */
package org.summer.xaml.core;

import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.summer.xaml.core.scoping.SsImportedNamespaceScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
public class XAMLRuntimeModule extends org.summer.xaml.core.AbstractXAMLRuntimeModule {

	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
			.to(SsImportedNamespaceScopeProvider.class);
	}
	
}
