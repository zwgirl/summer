/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/

package org.summer.ss.lib.macro.declaration;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface ClassDeclaration extends TypeDeclaration,
		TypeParameterDeclarator {

	/**
	 * @return whether this class is marked <code>final</code>
	 */
	boolean isFinal();

	/**
	 * @return whether this class is marked <code>abstract</code>
	 */
	boolean isAbstract();

	/**
	 * @return whether this class is marked <code>static</code>
	 */
	boolean isStatic();

	/**
	 * @return whether this class is marked <code>strictfp</code>
	 */
	boolean isStrictFloatingPoint();

	/**
	 * @return the super class of this class. If this class declaration
	 *         represents the source AST this method returns <code>null</code>
	 *         if no explicit super class is specified.
	 */
	TypeReference getExtendedClass();

	/**
	 * @return the interfaces directly implemented by the class declaration
	 */
	Iterable<? extends TypeReference> getImplementedInterfaces();

}
