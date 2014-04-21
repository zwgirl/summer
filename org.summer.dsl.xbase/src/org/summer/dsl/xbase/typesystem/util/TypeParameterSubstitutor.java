/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse protected License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typesystem.references.AnyTypeReference;
import org.summer.dsl.xbase.typesystem.references.ArrayTypeReference;
import org.summer.dsl.xbase.typesystem.references.CompoundTypeReference;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.references.TypeReferenceVisitorWithParameterAndNonNullResult;
import org.summer.dsl.xbase.typesystem.references.UnknownTypeReference;
import org.summer.dsl.xbase.typesystem.references.WildcardTypeReference;

import com.google.common.collect.Maps;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc, toString
 * TODO implement as member function on LightweightTypeReference
 */
@NonNullByDefault
public abstract class TypeParameterSubstitutor<Visiting> extends TypeReferenceVisitorWithParameterAndNonNullResult<Visiting, LightweightTypeReference> {
		
	private final Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private final ITypeReferenceOwner owner;

	public TypeParameterSubstitutor(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping, ITypeReferenceOwner owner) {
		this.owner = owner;
		this.typeParameterMapping = Maps.newLinkedHashMap(typeParameterMapping);
	}
	
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getTypeParameterMapping() {
		return typeParameterMapping;
	}
	
	public void enhanceMapping(Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping) {
		this.typeParameterMapping.putAll(typeParameterMapping);
	}
	
	protected ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	@Override
	protected LightweightTypeReference doVisitFunctionTypeReference(FunctionTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		FunctionTypeReference result = new FunctionTypeReference(getOwner(), reference.getType());
		for(LightweightTypeReference parameterType: reference.getParameterTypes()) {
			result.addParameterType(visitTypeArgument(parameterType, visiting));
		}
		for(LightweightTypeReference typeArgument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(typeArgument, visiting));
		}
		LightweightTypeReference returnType = reference.getReturnType();
		if (returnType != null) {
			result.setReturnType(visitTypeArgument(returnType, visiting));
		}
		return result;
	}

	/**
	 * This is equivalent to {@code visitTypeArgument(reference, visiting, false)}.
	 * 
	 * @see #visitTypeArgument(LightweightTypeReference, Object, boolean)
	 */
	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Visiting visiting) {
		return visitTypeArgument(reference, visiting, false);
	}
	
	/**
	 * @param lowerBound if the given reference was used as the lower bound of a wildcard
	 */
	protected LightweightTypeReference visitTypeArgument(LightweightTypeReference reference, Visiting visiting, boolean lowerBound) {
		return reference.accept(this, visiting);
	}
	
	@Override
	protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		JvmType type = reference.getType();
		if (type instanceof JvmTypeParameter) {
			LightweightTypeReference boundTypeArgument = getBoundTypeArgument(reference, (JvmTypeParameter) type, visiting);
			if (boundTypeArgument != null)
				return boundTypeArgument;
		}
		return doVisitParameterizedTypeReference(reference, type, visiting);
	}
	
	protected LightweightTypeReference doVisitParameterizedTypeReference(ParameterizedTypeReference reference, JvmType type, Visiting visiting) {
		ParameterizedTypeReference result = new ParameterizedTypeReference(getOwner(), type);
		for(LightweightTypeReference argument: reference.getTypeArguments()) {
			result.addTypeArgument(visitTypeArgument(argument, visiting));
		}
		return result;
	}

	@Nullable
	protected LightweightTypeReference getBoundTypeArgument(ParameterizedTypeReference reference, JvmTypeParameter type,
			Visiting visiting) {
		LightweightMergedBoundTypeArgument boundTypeArgument = typeParameterMapping.get(type);
		if (boundTypeArgument != null) {
			LightweightTypeReference boundReference = boundTypeArgument.getTypeReference();
			if (boundReference != null && reference != boundReference && boundReference.getType() != type) {
				return boundReference.accept(this, visiting);
			}
		}
		return null;
	}
	
	@Override
	protected LightweightTypeReference doVisitWildcardTypeReference(WildcardTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		WildcardTypeReference result = new WildcardTypeReference(getOwner());
		LightweightTypeReference lowerBound = reference.getLowerBound();
		if (lowerBound != null) {
			LightweightTypeReference visited = visitTypeArgument(lowerBound, visiting, true);
			if (visited.isWildcard()) {
				LightweightTypeReference lowerBoundSubstitute = visited.getLowerBoundSubstitute();
				if (lowerBoundSubstitute.isAny()) {
					JvmType objectType = getOwner().getServices().getTypeReferences().findDeclaredType(Object.class, getOwner().getContextResourceSet());
					result.addUpperBound(new ParameterizedTypeReference(getOwner(), objectType));
					return result;
				} else {
					result.setLowerBound(lowerBoundSubstitute);
				}
			} else {
				result.setLowerBound(visited);
			}
		} 
		for(LightweightTypeReference upperBound: reference.getUpperBounds()) {
			LightweightTypeReference visitedArgument = visitTypeArgument(upperBound, visiting);
			LightweightTypeReference upperBoundSubstitute = visitedArgument.getUpperBoundSubstitute();
			result.addUpperBound(upperBoundSubstitute);
		}
		if (result.getUpperBounds().isEmpty()) {
			throw new IllegalStateException("UpperBounds may not be empty");
		}
		return result;
	}
	
	@Override
	protected LightweightTypeReference doVisitArrayTypeReference(ArrayTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		LightweightTypeReference component = visitTypeArgument(reference.getComponentType(), visiting);
		component = component.getUpperBoundSubstitute();
		return new ArrayTypeReference(getOwner(), component);
	}
	
	@Override
	protected LightweightTypeReference doVisitAnyTypeReference(AnyTypeReference reference, Visiting visiting) {
		return reference;
	}
	
	@Override
	protected LightweightTypeReference doVisitUnknownTypeReference(UnknownTypeReference reference, Visiting param) {
		return reference;
	}
	
	@Override
	protected LightweightTypeReference doVisitCompoundTypeReference(CompoundTypeReference reference, Visiting visiting) {
		if (reference.isResolved() && reference.isOwnedBy(getOwner()))
			return reference;
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), reference.isSynonym());
		for(LightweightTypeReference component: reference.getMultiTypeComponents()) {
			result.addComponent(visitTypeArgument(component, visiting));
		}
		return result;
	}

	public LightweightTypeReference substitute(LightweightTypeReference original) {
		if (typeParameterMapping.isEmpty())
			return original;
		return original.accept(this, createVisiting());
	}
	
	public LightweightTypeReference substitute(JvmTypeReference original) {
		LightweightTypeReference lightweightReference = new OwnedConverter(getOwner()).toLightweightReference(original);
		return substitute(lightweightReference);
	}
	
	protected abstract Visiting createVisiting();
	
	protected LightweightTypeReference copy(LightweightTypeReference reference) {
		return reference.copyInto(getOwner());
	}
	
	@Override
	public String toString() {
		return String.format("%s with mapping: %s", getClass().getSimpleName(), getTypeParameterMapping());
	}
}