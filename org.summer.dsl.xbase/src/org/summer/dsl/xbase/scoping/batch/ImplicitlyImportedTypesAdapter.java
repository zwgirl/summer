/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.List;

import org.summer.dsl.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider;
import org.summer.dsl.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Adapts the {@link ImplicitlyImportedTypes} to the deprecated {@link ExtensionClassNameProvider}
 * which is still used by the content assist infrastructure.
 * 
 * @author Ed Merks - Initial implementation and API
 */
@SuppressWarnings("deprecation")
@Singleton
public class ImplicitlyImportedTypesAdapter extends StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider {

	@Inject
	private ImplicitlyImportedTypes implicitlyImportedTypes;

	@Override
	protected Multimap<Class<?>, Class<?>> simpleComputeExtensionClasses() {
		List<Class<?>> extensionClasses = implicitlyImportedTypes.getExtensionClasses();
		Multimap<Class<?>, Class<?>> result = ArrayListMultimap.create();
		for (Class<?> clazz : extensionClasses) {
			Method[] declaredMethods = clazz.getMethods();
			for (Method method : declaredMethods) {
				if (Modifier.isStatic(method.getModifiers())) {
					Class<?>[] parameterTypes = method.getParameterTypes();
					if (parameterTypes.length > 0) {
						result.put(parameterTypes[0], clazz);
					}
				}
			}
		}
		return result;
	}

	@Override
	protected Collection<String> computeLiteralClassNames() {
		List<Class<?>> staticImportClasses = implicitlyImportedTypes.getStaticImportClasses();
		List<String> result = Lists.newArrayListWithExpectedSize(staticImportClasses.size());
		for (Class<?> clazz : staticImportClasses) {
			result.add(clazz.getName());
		}
		return result;
	}
}