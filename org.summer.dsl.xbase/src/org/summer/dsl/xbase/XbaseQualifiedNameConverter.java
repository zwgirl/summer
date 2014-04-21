/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase;

import java.util.Set;

import org.eclipse.xtext.naming.QualifiedName;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
public class XbaseQualifiedNameConverter extends org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl {
	
	private static final Set<String> criticalOperatorNames = ImmutableSet.<String>builder().add("..", "..<", ">..").build();
	
	/**
	 * the '..' operator would be rejected by {@link org.eclipse.xtext.naming.IQualifiedNameConverter.DefaultImpl}
	 * so we have to enable it here.
	 */
	@Override
	public QualifiedName toQualifiedName(String qualifiedNameAsString) {
		if (criticalOperatorNames.contains(qualifiedNameAsString))
			return QualifiedName.create(qualifiedNameAsString);
		return super.toQualifiedName(qualifiedNameAsString);
	}
}
