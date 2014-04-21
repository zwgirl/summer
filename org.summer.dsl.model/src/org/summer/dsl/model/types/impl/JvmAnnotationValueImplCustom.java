/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.summer.dsl.model.types.JvmOperation;

public class JvmAnnotationValueImplCustom extends JvmAnnotationValueImpl {
	
	@Override
	public String getValueName() {
		JvmOperation operation = getOperation();
		if (operation == null || operation.eIsProxy())
			return null;
		return operation.getSimpleName();
	}

}
