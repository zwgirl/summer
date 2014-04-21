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
public class JvmUpperBoundImplCustom extends JvmUpperBoundImpl {

	private static final String EXTENDS = "extends ";

	@Override
	public String getIdentifier() {
		if (typeReference != null)
			return EXTENDS + super.getIdentifier();
		return null;
	}
	
	@Override
	public String getSimpleName() {
		if (typeReference != null)
			return EXTENDS + super.getSimpleName();
		return null;
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (typeReference != null)
			return EXTENDS + super.getQualifiedName(innerClassDelimiter);
		return null;
	}
	
	@Override
	public String toString() {
		if (typeReference != null)
			return EXTENDS + super.toString();
		return eClass().getName();
	}
}
