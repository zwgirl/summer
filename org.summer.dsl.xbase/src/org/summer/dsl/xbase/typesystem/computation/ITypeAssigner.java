/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * Allows to bulk-assign types for {@link JvmIdentifiableElement identifiable elements},
 * e.g. assign the types for the parametes of an inferred {@link JvmOperation operation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface ITypeAssigner {

	/**
	 * The given element is tagged with the given type. If this type is <code>null</code>,
	 * it is treated like an error type.
	 */
	void assignType(JvmIdentifiableElement element, @Nullable LightweightTypeReference actualType);
	
	/**
	 * Returns the forked state that knows about the newly assigned types.
	 */
	ITypeComputationState getForkedState();
	
	/**
	 * Returns the current owner.
	 */
	ITypeReferenceOwner getReferenceOwner();
	
	/**
	 * Can be used to convert {@link JvmTypeReference JvmTypeReferences} in the context of
	 * the newly forked state.
	 * 
	 * @param reference the reference to convert.
	 * @return the converted reference.
	 */
	LightweightTypeReference toLightweightTypeReference(JvmTypeReference reference);
	
}
