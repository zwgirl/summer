/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.TypesPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmComponentTypeImplCustom extends JvmComponentTypeImpl {

	@Override
	public JvmArrayType getArrayType() {
		JvmArrayType result = super.getArrayType();
		if (result == null) {
			result = TypesFactory.eINSTANCE.createJvmArrayType();
			boolean wasDeliver = eDeliver();
			eSetDeliver(false);
			try {
				setArrayType(result);
			} finally {
				eSetDeliver(wasDeliver);
			}
		}
		return result;
	}
	
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType)
	{
		switch (featureID)
		{
			case TypesPackage.JVM_COMPONENT_TYPE__ARRAY_TYPE:
				// don't demand-create the array if queried reflectively
				return arrayType;
		}
		return super.eGet(featureID, resolve, coreType);
	}
	
}
