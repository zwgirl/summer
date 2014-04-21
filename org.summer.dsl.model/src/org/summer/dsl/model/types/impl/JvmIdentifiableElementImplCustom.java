/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmIdentifiableElementImplCustom extends JvmIdentifiableElementImpl {
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (eIsProxy()) {
			result.append(" (eProxyURI: ");
			result.append(eProxyURI());
			result.append(')');
		} else {
			result.append(getIdentifier());
		}
		return result.toString();
	}
	
}
