/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.override;

import java.util.List;

import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmTypeParameter;

/**
 * Resolved representation of a {@link JvmConstructor}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IResolvedConstructor extends IResolvedExecutable {

	/**
	 * Returns the declared constructor that is resolved.
	 * 
	 * @return the declaration.
	 */
	JvmConstructor getDeclaration();
	
	/**
	 * Returns the list of declared type parameters of the {@link #getDeclaration() constructor}.
	 * This is not the list of type parameters on the type that declares
	 * this constructor.
	 * 
	 * @return the list of declared type parameters.
	 */
	List<JvmTypeParameter> getTypeParameters();
	
}
