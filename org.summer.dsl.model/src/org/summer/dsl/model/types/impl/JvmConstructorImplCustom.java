/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.summer.dsl.model.types.JvmDeclaredType;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmConstructorImplCustom extends JvmConstructorImpl {

	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		JvmDeclaredType declaringType = getDeclaringType();
		if (declaringType != null)
			return declaringType.getQualifiedName(innerClassDelimiter);
		return getSimpleName();
	}
	
	@Override
	public boolean isStatic() {
		return true;
	}
}
