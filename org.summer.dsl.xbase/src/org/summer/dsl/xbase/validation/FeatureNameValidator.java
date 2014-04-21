/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation;

import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;

/**
 * Validator utility to answer questions about feature names.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class FeatureNameValidator implements IFeatureNames {

	/**
	 * Returns <code>true</code> if it is legal to shadow a
	 * local with the given name.
	 * @param name the name that is-to-be-defined.
	 * @return <code>true</code> if shadowing is legal. 
	 */
	public boolean isShadowingAllowed(QualifiedName name) {
		return IT.equals(name);
	}
	
	/**
	 * Returns <code>true</code> if it is illegal to define the given name.
	 * @param name the name that is to-be-defined.
	 * @return <code>true</code> if the name may not be used.
	 */
	public boolean isDisallowedName(QualifiedName name) {
		return false;
	}
	
	/**
	 * Returns <code>true</code> if it is discouraged to define the given name.
	 * @param name the name that is to-be-defined.
	 * @return <code>true</code> if the name may not be used.
	 */
	public boolean isDiscouragedName(QualifiedName name) {
		return SELF.equals(name);
	}
	
}
