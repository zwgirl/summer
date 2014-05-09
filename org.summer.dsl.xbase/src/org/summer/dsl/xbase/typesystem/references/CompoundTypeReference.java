/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.references;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmCompoundTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Joiner;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class CompoundTypeReference extends LightweightTypeReference {

	private boolean synonym;
	private List<LightweightTypeReference> components;
	private boolean resolved;

	public CompoundTypeReference(ITypeReferenceOwner owner, boolean synonym) {
		super(owner);
		this.synonym = synonym;
		this.resolved = true;
	}
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	@Override
	public int getKind() {
		return KIND_COMPOUND_TYPE_REFERENCE;
	}
	
	@Override
	public JvmTypeReference toTypeReference() {
		JvmCompoundTypeReference result = synonym ? getTypesFactory().createJvmSynonymTypeReference() : getTypesFactory().createJvmMultiTypeReference();
		if (components != null) {
			for(LightweightTypeReference component: components) {
				result.getReferences().add(component.toTypeReference());
			}
		}
		return result;
	}
	
	@Override
	public boolean isVisible(IVisibilityHelper visibilityHelper) {
		if (components != null && !components.isEmpty()) {
			for(LightweightTypeReference component: components) {
				if (!component.isVisible(visibilityHelper)) {
					return false;
				}
			}
		}
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * If this is a multi-type rather than a {@link #isSynonym() synonym}, the Java compliant
	 * type reference is determined from the common super type of all participating, non-interface types.
	 * If there is no such type or this is a synonym, all the component types are used to compute
	 * the common super type and use that one as the type.
	 */
	@Override
	public JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper) {
		if (!isSynonym()) {
			List<LightweightTypeReference> nonInterfaceTypes = getNonInterfaceTypes(components);
			if (nonInterfaceTypes != null) {
				return toJavaCompliantTypeReference(nonInterfaceTypes, visibilityHelper);
			}
		}
		return toJavaCompliantTypeReference(components, visibilityHelper);
	}

	@Override
	public List<LightweightTypeReference> getTypeArguments() {
		if (components != null && components.size() == 1)
			return components.get(0).getTypeArguments();
		// TODO common type?
		return super.getTypeArguments();
	}

	@Override
	public boolean isRawType() {
		for(LightweightTypeReference component: expose(components)) {
			if (component.isRawType())
				return true;
		}
		return false;
	}
	
	@Override
	public LightweightTypeReference getRawTypeReference() {
		if (isAllRawType()) {
			return this;
		}
		CompoundTypeReference result = new CompoundTypeReference(getOwner(), isSynonym());
		for(LightweightTypeReference component: expose(components)) {
			result.addComponent(component.getRawTypeReference());
		}
		return result;
	}
	
	private boolean isAllRawType() {
		for(LightweightTypeReference component: expose(components)) {
			if (!component.isRawType())
				return false;
		}
		return true;
	}
	
	@Override
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (super.isOwnedBy(owner)) {
			for (LightweightTypeReference parameterType : expose(components)) {
				if (!parameterType.isOwnedBy(owner)) {
					return false;
				}
			}
			return true;
		}
		return false;
	}
	
	@Override
	@Nullable
	public JvmType getType() {
		if (components != null && components.size() == 1)
			return components.get(0).getType();
		// TODO common type?
		return null;
	}
	
	@Override
	protected List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor) {
		if (!isSynonym()) {
			if (components == null || components.isEmpty())
				return Collections.emptyList();
			List<LightweightTypeReference> result = Lists.newArrayListWithCapacity(components.size());
			for(LightweightTypeReference component: components) {
				result.add(substitutor.substitute(component));
			}
			return result;
		}
		return Collections.emptyList();
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSuperType(JvmType rawType) {
		if (components == null || components.isEmpty())
			return null;
		for(LightweightTypeReference component: components) {
			LightweightTypeReference result = component.getSuperType(rawType);
			if (result != null)
				return result;
		}
		return null;
	}
	
	//cym comment
//	@Override
//	@Nullable
//	public LightweightTypeReference getSuperType(Class<?> rawType) {
//		if (components == null || components.isEmpty())
//			return null;
//		for(LightweightTypeReference component: components) {
//			LightweightTypeReference result = component.getSuperType(rawType);
//			if (result != null)
//				return result;
//		}
//		return null;
//	}
	
	//cym comment
//	@Override
//	public boolean isType(Class<?> clazz) {
//		if (components == null)
//			return false;
//		if (isSynonym()) {
//			for(LightweightTypeReference component: components) {
//				if (component.isType(clazz))
//					return true;
//			}
//			return false;
//		} else {
//			for(LightweightTypeReference component: components) {
//				if (!component.isType(clazz))
//					return false;
//			}
//			return true;
//		}
//	}
	
	@Override
	public boolean isType(JvmType clazz) {
		if (components == null)
			return false;
		if (isSynonym()) {
			for(LightweightTypeReference component: components) {
				if (component.isType(clazz))
					return true;
			}
			return false;
		} else {
			for(LightweightTypeReference component: components) {
				if (!component.isType(clazz))
					return false;
			}
			return true;
		}
	}
	
	@Override
	protected LightweightTypeReference doCopyInto(ITypeReferenceOwner owner) {
		CompoundTypeReference result = new CompoundTypeReference(owner, synonym);
		if (components != null && !components.isEmpty()) {
			for(LightweightTypeReference typeArgument: components) {
				result.addComponent(typeArgument.copyInto(owner));
			}
		}
		return result;
	}

	@Override
	public boolean isResolved() {
		return resolved;
	}
	
	@Override
	public boolean isSynonym() {
		return synonym;
	}

	public void addComponent(LightweightTypeReference component) {
		if (component == null) {
			throw new NullPointerException("component may not be null");
		}
		if (!component.isOwnedBy(getOwner())) {
			throw new NullPointerException("component is not valid in current context");
		}
		if (components == null)
			components = Lists.newArrayListWithCapacity(2);
		components.add(component);
		resolved = resolved && component.isResolved();
	}
	
	@Override
	public String getSimpleName() {
		return getAsString(SimpleNameFunction.INSTANCE);
	}
	
	@Override
	public String getIdentifier() {
		return getAsString(IdentifierFunction.INSTANCE);
	}

	@Override
	public String getUniqueIdentifier() {
		return getAsString(UniqueIdentifierFunction.INSTANCE);
	}
	
	@Override
	public String getJavaIdentifier() {
		return toJavaType().getJavaIdentifier();
	}
	
	private String getAsString(Function<? super LightweightTypeReference, ? extends String> format) {
		return Joiner.on(synonym ? " | " : " & ").join(Iterables.transform(expose(components), format));
	}
	
	@Override
	public void accept(TypeReferenceVisitor visitor) {
		if (isSynonym())
			visitor.doVisitSynonymTypeReference(this);
		else
			visitor.doVisitMultiTypeReference(this);
	}
	
	@Override
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		if (isSynonym())
			visitor.doVisitSynonymTypeReference(this, param);
		else
			visitor.doVisitMultiTypeReference(this, param);
	}
	
	@Override
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		if (isSynonym())
			return visitor.doVisitSynonymTypeReference(this);
		else
			return visitor.doVisitMultiTypeReference(this);
	}
	
	@Override
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		if (isSynonym())
			return visitor.doVisitSynonymTypeReference(this, param);
		else
			return visitor.doVisitMultiTypeReference(this, param);
	}
	
	@Override
	public CompoundTypeReference toMultiType(LightweightTypeReference reference) {
		if (!isSynonym()) {
			if (reference == null) {
				throw new NullPointerException("reference may not be null");
			}
			CompoundTypeReference result = new CompoundTypeReference(getOwner(), false);
			for(LightweightTypeReference component: getMultiTypeComponents()) {
				result.addComponent(component);
			}
			result.addComponent(reference);
			return result;
		}
		return super.toMultiType(reference);
	}
	
	@Override
	public boolean isMultiType() {
		return !synonym;
	}
	
	@Override
	public LightweightTypeReference toJavaType() {
		LightweightTypeReference result = getServices().getTypeConformanceComputer().getCommonSuperType(getMultiTypeComponents(), getOwner());
		if (result == null) {
			throw new IllegalStateException("Cannot expression " + this + " as Java type reference");
		}
		return result.toJavaType();
	}
	
	@Override
	public List<LightweightTypeReference> getMultiTypeComponents() {
		return expose(components);
	}
}
