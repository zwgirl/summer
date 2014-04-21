/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.Map;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.UnboundTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 */
@NonNullByDefault
public class UnboundTypeParameterPreservingSubstitutor extends TypeParameterSubstitutor<Set<JvmTypeParameter>> {
	
	public UnboundTypeParameterPreservingSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			ITypeReferenceOwner owner) {
		super(typeParameterMapping, owner);
	}

	@Override
	protected LightweightTypeReference doVisitUnboundTypeReference(UnboundTypeReference reference,
			Set<JvmTypeParameter> visiting) {
		return reference.copyInto(getOwner());
	}

	@Override
	@Nullable
	protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type, Set<JvmTypeParameter> visiting) {
		LightweightMergedBoundTypeArgument boundTypeArgument = getTypeParameterMapping().get(type);
		if (boundTypeArgument != null) {
			LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
			if (boundReference != null && reference != boundReference) {
				if (boundReference instanceof UnboundTypeReference)
					return boundReference.copyInto(getOwner());
				JvmType boundType = boundReference.getType();
				if (boundType != type) {
					if (visiting.add(type)) {
						try {
							LightweightTypeReference result = boundReference.accept(this, visiting);
							return result;
						} finally {
							visiting.remove(type);
						}
					} else {
						return reference;
					}
				} 
			}
		}
		return null;
	}

	@Override
	protected Set<JvmTypeParameter> createVisiting() {
		return Sets.newHashSetWithExpectedSize(3);
	}
	
}