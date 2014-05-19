/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.override;

import java.util.EnumSet;
import java.util.List;
import java.util.Set;

import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmVisibility;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.summer.dsl.xbase.typesystem.references.ITypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.util.ContextualVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;

import com.google.common.collect.Sets;
import com.google.inject.Inject;

/**
 * Utility to compute information about the inheritance relationship of two operations.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class OverrideTester {

	private IVisibilityHelper visibilityHelper;
	
	@Inject
	public OverrideTester(IVisibilityHelper visibilityHelper) {
		this.visibilityHelper = visibilityHelper;
	}
	
	public OverrideTester() {
		this(IVisibilityHelper.ALL);
	}
	
	/**
	 * Checks if the overriding method and the given overridden candidate have compatible subsignatures
	 * according to JLS 8.4.2. Uses information about static-ness and visibility for early exits.
	 * 
	 * The implemented algorithm pretty much mirrors the one from
     * class <code>org.eclipse.jdt.internal.corext.util.MethodOverrideTester</code>.
	 * 
	 * @param checkInheritance <code>true</code> if it is unknown whether the given operations are declared in a valid type hierarchy.
	 */
	public IOverrideCheckResult isSubsignature(AbstractResolvedOperation overriding, JvmOperation overridden, boolean checkInheritance) {
		JvmOperation declaration = overriding.getDeclaration();
		if (declaration == overridden) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.CURRENT);
		}
		if (overridden.getDeclaringType() == declaration.getDeclaringType()) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.SAME_DECLARATOR);
		}
		if (checkInheritance) {
			// here we use the raw types intentionally since there is no need to resolve
			// declarators to concrete bounds to determine the override relationship of types
			ParameterizedTypeReference currentDeclarator = new ParameterizedTypeReference(overriding.getContextType().getOwner(), declaration.getDeclaringType());
			if (!currentDeclarator.isSubtypeOf(overridden.getDeclaringType())) {
				return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NO_INHERITANCE);	
			}
		}
		if (!Strings.equal(overridden.getSimpleName(), declaration.getSimpleName())) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NAME_MISMATCH);
		}
		int parameterCount = overridden.getParameters().size();
		if (parameterCount != declaration.getParameters().size()) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.ARITY_MISMATCH);
		}
		if (!(new ContextualVisibilityHelper(visibilityHelper, new ParameterizedTypeReference(overriding.getContextType().getOwner(), declaration.getDeclaringType())).isVisible(overridden))) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.NOT_VISIBLE);
		}
		if (declaration.isStatic() != overridden.isStatic()) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.STATIC_MISMATCH);
		}
		AbstractResolvedOperation overriddenInHierarchy = new ResolvedOperationInHierarchy(overridden, overriding.getBottom());
		if (parameterCount != 0 && !isMatchingParameterList(overriding, overriddenInHierarchy)) {
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
		}			
		if (!isMatchingTypeParameters(overriding, overriddenInHierarchy))
			return new LazyOverrideCheckResult(overriding, overridden, OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
		return new LazyOverrideCheckResult(overriding, overridden, getPrimaryValidDetail(overriding, overridden));
	}
	
	protected EnumSet<OverrideCheckDetails> getAllDetails(AbstractResolvedOperation overriding, JvmOperation overridden, OverrideCheckDetails primary) {
		EnumSet<OverrideCheckDetails> result = EnumSet.of(primary);
		AbstractResolvedOperation overriddenInHierarchy = new ResolvedOperationInHierarchy(overridden, overriding.getBottom());
		switch(primary) {
			case CURRENT:
			case NO_INHERITANCE:
			case NAME_MISMATCH:
			case ARITY_MISMATCH: return result;
			case SAME_DECLARATOR:
			case TYPE_PARAMETER_MISMATCH:
			case PARAMETER_TYPE_MISMATCH: {
				if (isSameErasure(overriding, overriddenInHierarchy)) {
					result.add(OverrideCheckDetails.SAME_ERASURE);
				}
				return result;
			}
			case NOT_VISIBLE:
			case STATIC_MISMATCH: 
				if (!overriding.getResolvedParameterTypes().isEmpty() && !isMatchingParameterList(overriding, overriddenInHierarchy)) {
					result.add(OverrideCheckDetails.PARAMETER_TYPE_MISMATCH);
					return result;
				}
				if (!isMatchingTypeParameters(overriding, overriddenInHierarchy)) {
					result.add(OverrideCheckDetails.TYPE_PARAMETER_MISMATCH);
					return result;
				}
			case REPEATED:
			case SHADOWED:
			case IMPLEMENTATION:
			case REDECLARATION:
			case OVERRIDE: {
				addAdditionalDetails(overriding, overriddenInHierarchy, result);
				return result;
			}
			default:
				throw new IllegalArgumentException("Unexpected primary detail: " + primary);
		}
	}
	
	protected boolean isSameErasure(AbstractResolvedOperation overriding, AbstractResolvedOperation overridden) {
		List<LightweightTypeReference> overridingParameterTypes = overriding.getResolvedParameterTypes();
		List<LightweightTypeReference> overriddenParameterTypes = overridden.getResolvedParameterTypes();
		if (overridingParameterTypes.size() != overriddenParameterTypes.size()) {
			return false;
		}
		for(int i = 0; i < overridingParameterTypes.size(); i++) {
			LightweightTypeReference overridingParameterType = overridingParameterTypes.get(i);
			LightweightTypeReference overriddenParameterType = overriddenParameterTypes.get(i);
			String erasedOverridingParameterTypeIdentifier = overridingParameterType.getRawTypeReference().getJavaIdentifier();
			String erasedOverriddenParameterTypeIdentifier = overriddenParameterType.getRawTypeReference().getJavaIdentifier();
			if (!erasedOverridingParameterTypeIdentifier.equals(erasedOverriddenParameterTypeIdentifier)) {
				return false;
			}
		}
		return true;
	}

	protected void addAdditionalDetails(AbstractResolvedOperation overriding,
			AbstractResolvedOperation overridden, EnumSet<OverrideCheckDetails> result) {
		addReturnTypeDetails(overriding, overridden, result);
		addExceptionDetails(overriding, overridden, result);
		addAdditionalDetails(overriding.getDeclaration(), overridden.getDeclaration(), result);
	}

	protected void addExceptionDetails(AbstractResolvedOperation overriding, AbstractResolvedOperation overridden,
			EnumSet<OverrideCheckDetails> result) {
		List<LightweightTypeReference> exceptions = overriding.getResolvedExceptions();
		if (exceptions.isEmpty()) {
			return;
		}
		JvmType runtimeException = overriding.getThrowableType(RuntimeException.class);
		JvmType error = overriding.getThrowableType(Error.class);
		List<LightweightTypeReference> inheritedExceptions = overridden.getResolvedExceptions();
		for(LightweightTypeReference exception: exceptions) {
			if (!exception.isSubtypeOf(runtimeException) && !exception.isSubtypeOf(error)) {
				boolean isDeclared = false;
				for(LightweightTypeReference inheritedException: inheritedExceptions) {
					if (inheritedException.isAssignableFrom(exception)) {
						isDeclared = true;
						break;
					}
				}
				if (!isDeclared) {
					result.add(OverrideCheckDetails.EXCEPTION_MISMATCH);
					return;
				}
			}
		}
	}

	protected void addReturnTypeDetails(AbstractResolvedOperation overriding, AbstractResolvedOperation overridden,
			EnumSet<OverrideCheckDetails> result) {
		LightweightTypeReference overridingReturnType = overriding.getResolvedReturnType();
		LightweightTypeReference overriddenReturnType = overridden.getResolvedReturnType();
		TypeConformanceComputationArgument conformanceArgument = new TypeConformanceComputationArgument(false, false, false, false, false, false);
		if (!overriddenReturnType.isAssignableFrom(overridingReturnType, conformanceArgument)) {
			if (overriding.getTypeParameters().isEmpty() && !overridden.getTypeParameters().isEmpty()) {
				TypeConformanceComputationArgument rawConformanceArgument = new TypeConformanceComputationArgument(true, false, false, false, false, false);
				if (!overriddenReturnType.isAssignableFrom(overridingReturnType, rawConformanceArgument)) {
					result.add(OverrideCheckDetails.RETURN_MISMATCH);		
				} else {
					result.add(OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
					if (overridingReturnType.getRawTypeReference().getType() != overriddenReturnType.getRawTypeReference().getType()) {
						result.add(OverrideCheckDetails.COVARIANT_RETURN);
					}
				}
			} else {
				result.add(OverrideCheckDetails.RETURN_MISMATCH);
			}
		} else if (!overriddenReturnType.getJavaIdentifier().equals(overridingReturnType.getJavaIdentifier())) {
			if (!overridden.isRawTypeInheritance() && overriding.getTypeParameters().isEmpty() && !overridden.getTypeParameters().isEmpty()) {
				if (overridden.getTypeParameters().contains(overridden.getDeclaration().getReturnType().getType())) {
					result.add(OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED);
				}
			}
			result.add(OverrideCheckDetails.COVARIANT_RETURN);
		}
	}

	protected void addAdditionalDetails(JvmOperation overriding, JvmOperation overridden,
			EnumSet<OverrideCheckDetails> result) {
		if (isMorePrivateThan(overriding.getVisibility(), overridden.getVisibility())) {
			result.add(OverrideCheckDetails.REDUCED_VISIBILITY);
		}
//		if (overridden.isFinal()) {
//			result.add(OverrideCheckDetails.IS_FINAL);
//		}
		if (overriding.isVarArgs() != overridden.isVarArgs()) {
			result.add(OverrideCheckDetails.VAR_ARG_MISMATCH);
		}
	}

	protected boolean isMorePrivateThan(JvmVisibility o1, JvmVisibility o2) {
		if (o1 == o2) {
			return false;
		} else {
			switch (o1) {
//				case DEFAULT:  // cym comment
//					return o2 != JvmVisibility.PRIVATE;
				case PRIVATE:
					return true;
//				case PROTECTED: // cym comment
//					return o2 == JvmVisibility.PUBLIC;
				case PUBLIC:
					return false;
				default:
					throw new IllegalArgumentException("Unknown JvmVisibility " + o1);
			}
		}
	}
	
	protected boolean isMatchingParameterList(AbstractResolvedOperation overriding,
			AbstractResolvedOperation overridden) {
		List<LightweightTypeReference> overridingParameterTypes = overriding.getResolvedParameterTypes();
		List<LightweightTypeReference> overriddenParameterTypes = overridden.getResolvedParameterTypes();
		boolean testErasure = false;
		for(int i = 0; i < overridingParameterTypes.size(); i++) {
			LightweightTypeReference overridingParameterType = overridingParameterTypes.get(i);
			LightweightTypeReference overriddenParameterType = overriddenParameterTypes.get(i);
			String overridingParameterTypeIdentifier = overridingParameterType.getJavaIdentifier();
			if (!overridingParameterTypeIdentifier.equals(overriddenParameterType.getJavaIdentifier())) {
				if (!overriding.getTypeParameters().isEmpty()) {
					return false;
				}
				testErasure = true;
				break;
			}
		}
		if (testErasure) {
			for(int i = 0; i < overridingParameterTypes.size(); i++) {
				LightweightTypeReference overridingParameterType = overridingParameterTypes.get(i);
				LightweightTypeReference overriddenParameterType = overriddenParameterTypes.get(i);
				LightweightTypeReference erasureType = overriddenParameterType.getRawTypeReference();
				String overridingParameterTypeIdentifier = overridingParameterType.getJavaIdentifier();
				if (!overridingParameterTypeIdentifier.equals(erasureType.getJavaIdentifier())) {
					return false;
				}
			}
		}
		return true;
	}
	
	protected boolean isMatchingTypeParameters(AbstractResolvedOperation overriding, AbstractResolvedOperation overridden) {
		int overridingTypeParameterCount = overriding.getTypeParameters().size();
		if (overridingTypeParameterCount != overridden.getTypeParameters().size()) {
			for(LightweightTypeReference overridingParameterType: overriding.getResolvedParameterTypes()) {
				if (!overridingParameterType.getTypeArguments().isEmpty())
					return false;
			}
			return overridingTypeParameterCount == 0;
		}
		TypeParameterSubstitutor<?> substitutor = overridden.getSubstitutor();
		ITypeReferenceOwner owner = overriding.getContextType().getOwner();
		for(int i = 0; i < overridingTypeParameterCount; i++) {
			JvmTypeParameter overridingTypeParameter = overriding.getTypeParameters().get(i);
			JvmTypeParameter overriddenTypeParameter = overridden.getTypeParameters().get(i);
			List<LightweightTypeReference> overridingSuperTypes = new ParameterizedTypeReference(owner, overridingTypeParameter).getSuperTypes();
			List<LightweightTypeReference> overriddenSuperTypes = new ParameterizedTypeReference(owner, overriddenTypeParameter).getSuperTypes();
			if (overridingSuperTypes.size() != overriddenSuperTypes.size()) {
				return false;
			}
			if (overridingSuperTypes.size() == 1) {
				LightweightTypeReference resolved = substitutor.substitute(overriddenSuperTypes.get(0));
				if (!overridingSuperTypes.get(0).getJavaIdentifier().equals(resolved.getJavaIdentifier())) {
					return false;
				}
			} else {
				Set<String> overridingSuperTypeNames = Sets.newHashSetWithExpectedSize(overriddenSuperTypes.size());
				for(LightweightTypeReference overridingSuperType: overridingSuperTypes) {
					overridingSuperTypeNames.add(overridingSuperType.getJavaIdentifier());
				}
				for(LightweightTypeReference overriddenSuperType: overriddenSuperTypes) {
					LightweightTypeReference resolved = substitutor.substitute(overriddenSuperType);
					if (!overridingSuperTypeNames.contains(resolved.getJavaIdentifier())) {
						return false;
					}
				}
			}
		}
		return true;
	}

	protected OverrideCheckDetails getPrimaryValidDetail(IResolvedOperation overriding, JvmOperation overridden) {
		OverrideCheckDetails result = OverrideCheckDetails.IMPLEMENTATION;
		JvmOperation declaration = overriding.getDeclaration();
		if (declaration.isStatic()) {
			result = OverrideCheckDetails.SHADOWED;
		} else if (declaration.isAbstract()) {
			if (overridden.isAbstract()) {
				result = OverrideCheckDetails.REPEATED;
			} else {
				result = OverrideCheckDetails.REDECLARATION;
			}
		} else if (!overridden.isAbstract()) {
			result = OverrideCheckDetails.OVERRIDE;
		}
		return result;
	}

}
