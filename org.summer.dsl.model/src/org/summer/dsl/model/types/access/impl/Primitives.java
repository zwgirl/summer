/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.impl;

import java.util.Collection;

import com.google.common.collect.ImmutableList;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class Primitives {

	public static Class<?> forName(String name) {
		for(Class<?> candidate: ALL_PRIMITIVE_TYPES) {
			if (name.equals(candidate.getName()))
				return candidate;
		}
		return null;
	}
	
	public static final Collection<Class<?>> ALL_PRIMITIVE_TYPES = ImmutableList.of(
		Boolean.TYPE,
		Integer.TYPE,
		Float.TYPE,
		Byte.TYPE,
		Character.TYPE,
		Double.TYPE,
		Short.TYPE,
		Long.TYPE,
		Void.TYPE
	);
	
}
