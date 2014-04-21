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
public interface Type extends NamedElement {
	
	/**
	 * @return the qualified name of this type declaration.
	 */
	String getQualifiedName();
	
	/**
     * Determines if the type represented by this
     * <code>Type</code> object is either the same as, or is a supertype of, 
     * the type represented by the specified <code>Type</code> parameter. 
     * It returns <code>true</code> if so;
     * otherwise it returns <code>false</code>. If this <code>Type</code>
     * object represents a primitive type, this method returns
     * <code>true</code> if the specified <code>Type</code> parameter is
     * exactly this <code>Type</code> object; otherwise it returns
     * <code>false</code>.
     *
     * @param otherType the <code>Type</code> object to be checked
     * @return the <code>boolean</code> value indicating whether objects of the
     * type <code>cls</code> can be assigned to objects of this type. The method returns false if
     * the given parameter is <code>null</code>.
     */
	boolean isAssignableFrom(Type otherType);
}