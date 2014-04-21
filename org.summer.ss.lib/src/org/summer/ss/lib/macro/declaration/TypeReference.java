/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.lib.macro.declaration;

import java.util.List;

import com.google.common.annotations.Beta;

/**
 * @author Sven Efftinge
 */
@Beta
public interface TypeReference extends Element {
	
	/**
	 * Returns a text representation using the simple names of the involved types.
	 * 
	 * I.e. for 
	 * 
	 *   'java.util.List<? extends java.math.BigDecimal>' this method returns
	 *   'List<? extends BigDecimal>'
	 * 
	 * @return the simple name of this type reference
	 */
	String getSimpleName();
	
	/**
	 * returns the text representation using the qualified names of the involved types.
	 * 
	 * @return the qualified name of this type reference
	 */
	String getName();

	/**
	 * @return the referenced type.
	 */
	Type getType();

	/**
	 * @return the type arguments
	 */
	List<TypeReference> getActualTypeArguments();

	/**
	 * @return whether this is a wildcard reference
	 */
	boolean isWildCard();

	/**
	 * @return the upper bounds
	 */
	TypeReference getUpperBound();

	/**
	 * @return the lower bounds
	 */
	TypeReference getLowerBound();

	/**
	 * @return whether this is an array
	 */
	boolean isArray();

	/**
	 * @return the component type if this tye reference is an array type reference, <code>null</code> otherwise.
	 */
	TypeReference getArrayComponentType();

	/**
	 * @return whether this is the any type, The any type is the subtype of every reference type and its only instance is <code>null</code>.
	 */
	boolean isAnyType();

	/**
	 * @return whether this is a primitive type (i.e. one of boolean, char, byte, short, int, long, float, double).
	 */
	boolean isPrimitive();

	/**
	 * @return the corresponding wrapper <code>TypeReference</code> if this type references is a primitive type. Returns <code>this</code> otherwise.
	 */
	TypeReference getWrapperIfPrimitive();

	/**
	 * Checks whether this type is one of the wrapper types for the primitive value types.
	 * 
	 * @return wither this is one of the wrapper types for the primitive value types.
	 */
	boolean isWrapper();

	/**
	 * @return the corresponding primitive <code>TypeReference</code> if this type references is a wrapper type. Returns <code>this</code> otherwise.
	 */
	TypeReference getPrimitiveIfWrapper();

	/**
	 * @return whether this type is 'void' (doesn't include 'java.lang.Void')
	 */
	boolean isVoid();

	/**
	 * Determines if the specified <code>TypeReference</code> parameter can be assigned to this 
	 * <code>TypeReference</code>. It returns <code>true</code> if so;
	 * otherwise it returns <code>false</code>.
	 * 
	 * @param typeReference
	 * @return returns <code>true</code> is the specified type reference parameter can be assigned to this type reference.
	 */
	boolean isAssignableFrom(TypeReference typeReference);
	
	// TODO super types, features
}
