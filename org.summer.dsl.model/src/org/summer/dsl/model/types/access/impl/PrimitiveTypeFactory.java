/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.access.impl;

import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.TypesFactory;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PrimitiveTypeFactory implements ITypeFactory<Class<?>> {

	public JvmType createType(Class<?> clazz) {
		if (Void.TYPE.equals(clazz))
			return TypesFactory.eINSTANCE.createJvmVoid();
		JvmPrimitiveType result = TypesFactory.eINSTANCE.createJvmPrimitiveType();
		result.setSimpleName(clazz.getName());
		return result;
	}

}
