/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.Collections;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class RawTypeSubstitutor extends TypeParameterSubstitutor<Object> {
	public RawTypeSubstitutor(ITypeReferenceOwner owner) {
		super(Collections.<JvmTypeParameter,LightweightMergedBoundTypeArgument>emptyMap(), owner);
	}

	@Override
	public LightweightTypeReference substitute(LightweightTypeReference original) {
		return original.getRawTypeReference();
	}

	@Override
	protected Object createVisiting() {
		return new Object();
	}
}