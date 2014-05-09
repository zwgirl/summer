/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.references;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.impl.URIHelperConstants;
import org.summer.dsl.model.types.util.Primitives;
import org.summer.dsl.xbase.lib.Functions;
import org.summer.dsl.xbase.lib.Procedures;
import org.summer.dsl.xbase.typesystem.conformance.SuperTypeAcceptor;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputationArgument;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceComputer;
import org.summer.dsl.xbase.typesystem.conformance.TypeConformanceResult;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.TypeParameterSubstitutor;
import org.summer.dsl.xbase.typesystem.util.UnboundTypeParameterPreservingSubstitutor;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multiset;
import com.google.common.collect.Sets;
import com.google.common.primitives.Ints;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO document the purpose of this class
 *  - get rid of containment constraints
 *  - easier copying
 *  - isResolved
 *  - getSynonyms
 *  - getSuperTypes (resolved)
 *  - isAssignableFrom
 *  - collectSuperTypes
 *  - getAllSuperTypes
 * ?? - getFeatures (returns feature handles?)
 *  - getFeatureByName
 */
@NonNullByDefault
public abstract class LightweightTypeReference {
	
	public static final int KIND_LIGHTWEIGHT_TYPE_REFERENCE = 1;
	public static final int KIND_ANY_TYPE_REFERENCE = 2;
	public static final int KIND_ARRAY_TYPE_REFERENCE = 3;
	public static final int KIND_COMPOUND_TYPE_REFERENCE = 4;
	public static final int KIND_PARAMETERIZED_TYPE_REFERENCE = 5;
	public static final int KIND_UNBOUND_TYPE_REFERENCE = 6;
	public static final int KIND_UNKNOWN_TYPE_REFERENCE = 7;
	public static final int KIND_WILDCARD_TYPE_REFERENCE = 8;
	public static final int KIND_FUNCTION_TYPE_REFERENCE = 9;
	
	/**
	 * Subclasses <em>must</em> override this method.
	 */
	public int getKind() {
		return KIND_LIGHTWEIGHT_TYPE_REFERENCE;
	}
	
	public static class IdentifierFunction implements Function<LightweightTypeReference, String> {
		
		public static final IdentifierFunction INSTANCE = new IdentifierFunction();
		
		private IdentifierFunction() {
		}
		
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getIdentifier();
		}
	}
	
	public static class UniqueIdentifierFunction implements Function<LightweightTypeReference, String> {
		
		public static final UniqueIdentifierFunction INSTANCE = new UniqueIdentifierFunction();
		
		private UniqueIdentifierFunction() {
		}
		
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getUniqueIdentifier();
		}
	}
	
	public static class JavaIdentifierFunction implements Function<LightweightTypeReference, String> {
		
		public static final JavaIdentifierFunction INSTANCE = new JavaIdentifierFunction();
		
		private JavaIdentifierFunction() {
		}
		
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getJavaIdentifier();
		}
	}
	
	public static class SimpleNameFunction implements Function<LightweightTypeReference, String> {
		
		public static final SimpleNameFunction INSTANCE = new SimpleNameFunction();
		
		private SimpleNameFunction() {
		}
		
		public String apply(@Nullable LightweightTypeReference reference) {
			if (reference == null)
				throw new NullPointerException("reference");
			return reference.getSimpleName();
		}
	}
	
	private ITypeReferenceOwner owner;
	
	protected LightweightTypeReference(ITypeReferenceOwner owner) {
		this.owner = Preconditions.checkNotNull(owner, "owner");
	}
	
	/**
	 * Returns the type arguments of this reference if it has any.
	 * The type argument of <code>List&lt;String&gt;</code> is <code>String</code>.
	 * <String> is also the type argument of a wildcard reference with upper bound 
	 * <code>? extends List&lt;String&gt;</code>. 
	 * 
	 * Raw types don't carry type arguments. Wildcards with more than one upper bound
	 * don't carry type arguments.
	 */
	public List<LightweightTypeReference> getTypeArguments() {
		return Collections.emptyList();
	}
	
	public boolean isResolved() {
		return true;
	}
	
	public ITypeReferenceOwner getOwner() {
		return owner;
	}
	
	protected TypesFactory getTypesFactory() {
		return getOwner().getServices().getTypesFactory();
	}
	
	protected CommonTypeComputationServices getServices() {
		return getOwner().getServices();
	}
	
	public boolean isOwnedBy(ITypeReferenceOwner owner) {
		if (isResolved()) {
			return true;
		}
		return owner == getOwner();
	}
	
	protected <T> List<T> expose(@Nullable List<T> list) {
		if (list == null) {
			return Collections.emptyList();
		}
		return Collections.unmodifiableList(list);
	}
	
	public abstract JvmTypeReference toTypeReference();
	
	/**
	 * Converts this type reference to a {@link JvmTypeReference} that can
	 * be used in Java source code.
	 */
	public final JvmTypeReference toJavaCompliantTypeReference() {
		return toJavaCompliantTypeReference(IVisibilityHelper.ALL);
	}
	
	/**
	 * Returns <code>true</code> if this type is fully visible according to the given {@code visibilityHelper}. 
	 * All components and bounds are taken into account, e.g.
	 * {@link ArrayTypeReference arrays} use their {@link ArrayTypeReference#getComponentType() component type}
	 * and {@link ParameterizedTypeReference generified types} check their type arguments, too.
	 */
	public abstract boolean isVisible(IVisibilityHelper visibilityHelper);
	
	/**
	 * Converts this type reference to a {@link JvmTypeReference} that can
	 * be used in Java source code.
	 */
	public abstract JvmTypeReference toJavaCompliantTypeReference(IVisibilityHelper visibilityHelper);
	
	protected JvmTypeReference toJavaCompliantTypeReference(List<LightweightTypeReference> types, IVisibilityHelper visibilityHelper) {
		LightweightTypeReference type = getServices().getTypeConformanceComputer().getCommonSuperType(types, getOwner());
		if (type == null) {
			return getOwner().getServices().getTypeReferences().getTypeForName(Object.class, getOwner().getContextResourceSet());
		}
		return type.toJavaCompliantTypeReference(visibilityHelper);
	}
	
	@Nullable
	protected List<LightweightTypeReference> getNonInterfaceTypes(List<LightweightTypeReference> components) {
		List<LightweightTypeReference> nonInterfaceTypes = null;
		for(LightweightTypeReference component: components) {
			if (!component.isInterfaceType()) {
				if (nonInterfaceTypes == null) {
					nonInterfaceTypes = Collections.singletonList(component);
				} else if (nonInterfaceTypes.size() == 1) {
					nonInterfaceTypes = Lists.newArrayList(nonInterfaceTypes);
					nonInterfaceTypes.add(component);
				} else {
					nonInterfaceTypes.add(component);
				}
			}
		}
		return nonInterfaceTypes;
	}
	
	@Nullable
	public abstract JvmType getType();
	
	public LightweightTypeReference getWrapperTypeIfPrimitive() {
		return this;
	}
	
	public LightweightTypeReference getPrimitiveIfWrapperType() {
		return this;
	}
	
	@Nullable
	public Primitives.Primitive getPrimitiveKind() {
		return null;
	}
	
	@Nullable
	public Primitives.Primitive getPrimitiveKindIfWrapperType() {
		return null;
	}
	
	public List<JvmType> getRawTypes() {
		return getServices().getRawTypeHelper().getAllRawTypes(this, getOwner().getContextResourceSet());
	}
	
	/**
	 * @return the erasure type of this type reference
	 */
	public LightweightTypeReference getRawTypeReference() {
		return getServices().getRawTypeHelper().getRawTypeReference(this, getOwner().getContextResourceSet());
	}
	
	public LightweightTypeReference getUpperBoundSubstitute() {
		return this;
	}
	
	public LightweightTypeReference getLowerBoundSubstitute() {
		return this;
	}
	
	public LightweightTypeReference getInvariantBoundSubstitute() {
		return this;
	}
	
	/**
	 * Returns <code>true</code> is this type points to a raw type. 
	 * That is, it points to a parameterized type but does not define type arguments or
	 * it points to an external type parameter that has a raw type constraint.
	 * Type parameters that are declared by the current owner are not considered to be raw types.
	 * 
	 * A type is also a raw type if it inherits from a raw type.
	 */
	public boolean isRawType() {
		return false;
	}
	
	public boolean isArray() {
		return false;
	}
	
	public boolean isAny() {
		return false;
	}
	
	public boolean isUnknown() {
		return false;
	}
	
	/**
	 * Primitive {@code void}, {@link AnyTypeReference any} and {@link UnknownTypeReference unknown}
	 * types are not valid hints for {@link UnboundTypeReference#acceptHint(LightweightBoundTypeArgument) unbound references}.
	 */
	public boolean isValidHint() {
		return !isAny() && !isPrimitiveVoid();
	}
	
	/**
	 * Returns the list representation of this reference if it represents an array or is
	 * already a subtype of {@link List}.
	 * If the array's type is a primitive, the list's element type is the wrapper.
	 * May return <code>null</code> if the conversion is not possible.
	 * 
	 * @return an equivalent list type or <code>null</code>.
	 */
	@Nullable
	public LightweightTypeReference tryConvertToListType() {
		return null;
	}
	
	/**
	 * Returns the component type of the current array type. Does <em>not</em> attempt to
	 * convert this reference from iterable to array, first.
	 * 
	 * @see #isArray()
	 * @return the compoent type of the current array or <code>null</code>.
	 */
	@Nullable
	public LightweightTypeReference getComponentType() {
		return null;
	}
	
	/**
	 * Returns the list of immediate super types which includes the super class and the 
	 * implemented interfaces. The type parameters of the provided super types are resolved.
	 * That means, the super type of <code>List&lt;String&gt;</code> is <code>Collection&lt;String&gt;</code> 
	 * rather than <code>Collection&lt;E&gt;</code>.
	 * 
	 * @return the list of super types, can be empty.
	 */
	public List<LightweightTypeReference> getSuperTypes() {
		TypeParameterSubstitutor<?> substitutor = createSubstitutor();
		return getSuperTypes(substitutor);
	}
	
	/**
	 * Returns the resolved super type for the given raw type or <code>null</code> if the raw type
	 * is not a valid super type of this type. 
	 * 
	 * @param rawType the raw type that should be resolved.
	 * @return the resolved super type.
	 */
	
	//cym comment
//	@Nullable
//	public LightweightTypeReference getSuperType(Class<?> rawType) {
//		return null;
//	}
	
	/**
	 * Returns the resolved super type for the given raw type or null if the raw type
	 * is not a valid super type of this type. 
	 * 
	 * @param rawType the raw type that should be resolved.
	 * @return the resolved super type.
	 */
	@Nullable
	public LightweightTypeReference getSuperType(JvmType rawType) {
		return null;
	}
	
	/**
	 * Returns the list of all super types which includes the super class and the 
	 * implemented interfaces. The type parameters of the provided super types are resolved.
	 * That means, the super types of <code>ArrayList&lt;String&gt;</code> includes
	 * <code>List&lt;String&gt;</code> and <code>Collection&lt;String&gt;</code> 
	 * rather than <code>Collection&lt;E&gt;</code>.
	 * 
	 * @return the list of all super types, can be empty.
	 */
	public List<LightweightTypeReference> getAllSuperTypes() {
		final List<LightweightTypeReference> result = Lists.newArrayList();
		final Multiset<JvmType> distances = HashMultiset.create(7);
		final Multiset<JvmType> counterPerType = HashMultiset.create(7);
		collectSuperTypes(new SuperTypeAcceptor() {

			int counter = 0;
			
			public boolean accept(LightweightTypeReference superType, int distance) {
				JvmType type = superType.getType();
				counterPerType.add(type, counter++);
				if (distances.contains(type)) {
					int currentCount = distances.count(type);
					if (currentCount < distance + 1) {
						distances.setCount(type, distance + 1);
					} else {
						return false;
					}
				} else {
					result.add(superType);
					distances.add(type, distance + 1);
				}
				return true;
			}
			
		});
		Collections.sort(result, new Comparator<LightweightTypeReference>() {
			public int compare(@Nullable LightweightTypeReference o1, @Nullable LightweightTypeReference o2) {
				if (o1 == null || o2 == null) {
					throw new IllegalArgumentException();
				}
				JvmType type1 = o1.getType();
				JvmType type2 = o2.getType();
				if (type1 == null)
					return 1;
				if (type2 == null)
					return -1;
				int distanceCompare = Ints.compare(distances.count(type1), distances.count(type2));
				if (distanceCompare != 0)
					return distanceCompare;
				return Ints.compare(counterPerType.count(type1), counterPerType.count(type2));
			}
		});
		return result;
	}

	protected TypeParameterSubstitutor<?> createSubstitutor() {
		DeclaratorTypeArgumentCollector collector = new DeclaratorTypeArgumentCollector();
		Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> mapping = collector.getTypeParameterMapping(this);
		UnboundTypeParameterPreservingSubstitutor substitutor = new UnboundTypeParameterPreservingSubstitutor(mapping, getOwner());
		return substitutor;
	}
	
	protected abstract List<LightweightTypeReference> getSuperTypes(TypeParameterSubstitutor<?> substitutor);
	
	public void collectSuperTypes(SuperTypeAcceptor acceptor) {
		TypeParameterSubstitutor<?> substitutor = createSubstitutor();
		List<LightweightTypeReference> superTypes = getSuperTypes(substitutor);
		collectSuperTypes(1, superTypes, substitutor, acceptor, Sets.<JvmType>newHashSet(getType()));
	}
	
	protected void collectSuperTypes(int level, List<LightweightTypeReference> references, TypeParameterSubstitutor<?> substitutor, SuperTypeAcceptor acceptor, Set<JvmType> seenTypes) {
		for(LightweightTypeReference reference: references) {
			if (acceptor.accept(reference, level)) {
				if (seenTypes.add(reference.getType()))
					collectSuperTypes(level + 1, reference.getSuperTypes(substitutor), substitutor, acceptor, seenTypes);
			}
		}
	}
	
	public boolean isPrimitive() {
		return false;
	}
	
	public boolean isWrapper() {
		return false;
	}
	
	public boolean isPrimitiveVoid() {
		return false;
	}
	
	/**
     * Determines if this type reference denotes the same or a supertype of 
     * the given {@code reference}.
     */
	public boolean isAssignableFrom(LightweightTypeReference reference) {
		TypeConformanceComputationArgument argument = new TypeConformanceComputationArgument();
		return isAssignableFrom(reference, argument);
	}
	
	public boolean isAssignableFrom(LightweightTypeReference reference, TypeConformanceComputationArgument argument) {
		TypeConformanceResult result = internalIsAssignableFrom(reference, argument);
		return result.isConformant();
	}
	
	public TypeConformanceResult internalIsAssignableFrom(LightweightTypeReference reference, TypeConformanceComputationArgument argument) {
		TypeConformanceComputer conformanceCompouter = getOwner().getServices().getTypeConformanceComputer();
		TypeConformanceResult result = conformanceCompouter.isConformant(this, reference, argument);
		return result;
	}
	
	/**
     * Determines if this type reference denotes the same type or a supertype of 
     * the given {@code clazz}.
     */
	//cym comment
//	public boolean isAssignableFrom(Class<?> clazz) {
//		if (isType(clazz)) {
//			return true;
//		}
//		JvmType type = findType(clazz);
//		if (type == null) {
//			return false;
//		}
//		return isAssignableFrom(type);
//	}
	
	/**
     * Determines if this type reference denotes the same type or a supertype of 
     * the given {@code type}.
     */
	public boolean isAssignableFrom(JvmType type) {
		if (type == null) {
			throw new IllegalArgumentException("type may not be null");
		}
		ParameterizedTypeReference other = new ParameterizedTypeReference(getOwner(), type);
		boolean result = isAssignableFrom(other);
		return result;
	}
	
	/**
     * Determines if this type reference denotes the same type or a subtype of 
     * the given {@code clazz}.
     */
	//cym comment
//	public boolean isSubtypeOf(Class<?> clazz) {
//		if (isType(clazz)) {
//			return true;
//		}
//		// TODO interfaces don't inherit from non-interfaces, primitives, arrays, object
//		// A final type does not have any subtypes
//		JvmType type = findType(clazz);
//		if (type == null) {
//			return false;
//		}
//		return isSubtypeOf(type);
//	}
	
	/**
     * Determines if this type reference denotes the same type or a subtype of 
     * the given {@code type}.
     */
	public boolean isSubtypeOf(JvmType type) {
		if (type == null) {
			throw new IllegalArgumentException("type may not be null");
		}
		// TODO interfaces don't inherit from non-interfaces, primitives, arrays, object
		// A final type does not have any subtypes
		// check for type == this.type
		OwnedConverter converter = new OwnedConverter(getOwner());
		LightweightTypeReference other = converter.toRawLightweightReference(type);
		boolean result = other.isAssignableFrom(this);
		return result;
	}
	
	public LightweightTypeReference copyInto(ITypeReferenceOwner owner) {
		if (isOwnedBy(owner)) {
			return this;
		}
		return doCopyInto(owner);
	}

	protected abstract LightweightTypeReference doCopyInto(ITypeReferenceOwner owner);
	
	@Override
	public final String toString() {
		return getSimpleName();
	}
	
	public abstract String getSimpleName();
	
	public abstract String getIdentifier();
	
	/**
	 * Returns an identifier that allows to disambiguate type parameter names that have
	 * different origins. Rather than just giving the name of the type parameter, it also
	 * prints the declarator.
	 */
	public abstract String getUniqueIdentifier();
	
	// consider using a compact, not human-readable form, e.g. using the hashCode of the type
	protected String getUniqueIdentifier(JvmType type) {
		String typeIdentifier = type.getIdentifier();
		if (type instanceof JvmTypeParameter) {
			JvmIdentifiableElement declarator = (JvmIdentifiableElement) ((JvmTypeParameter) type).getDeclarator();
			// may happen in unit tests
			if (declarator != null) {
				typeIdentifier = typeIdentifier + ":" + declarator.getQualifiedName();
			} else {
				typeIdentifier = typeIdentifier + ":";
			}
		}
		return typeIdentifier;
	}
	
	public abstract String getJavaIdentifier();
	
	@Nullable
	protected JvmType findType(Class<?> type) {
		return getServices().getTypeReferences().findDeclaredType(type, getOwner().getContextResourceSet());
	}
	
	/**
	 * @noreference This method is not intended to be referenced by clients.
	 */
	//cym comment
//	@Nullable
//	protected LightweightTypeReference internalFindTopLevelType(Class<?> rawType) {
//		ResourceSet resourceSet = getOwner().getContextResourceSet();
//		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(rawType.getName()), true);
//		List<EObject> resourceContents = typeResource.getContents();
//		if (resourceContents.isEmpty())
//			return null;
//		JvmType type = (JvmType) resourceContents.get(0);
//		return new ParameterizedTypeReference(getOwner(), type);
//	}
	
	@Nullable
	protected LightweightTypeReference internalFindTopLevelType(JvmType rawType) {
//		ResourceSet resourceSet = getOwner().getContextResourceSet();
//		Resource typeResource = resourceSet.getResource(URIHelperConstants.OBJECTS_URI.appendSegment(rawType.getName()), true);
//		List<EObject> resourceContents = typeResource.getContents();
//		if (resourceContents.isEmpty())
//			return null;
//		JvmType type = (JvmType) resourceContents.get(0);
		return new ParameterizedTypeReference(getOwner(), rawType);
	}
	
	protected JvmType findNonNullType(Class<?> type) {
		JvmType result = findType(type);
		if (result == null) {
			throw new IllegalStateException("Cannot find type " + type);
		}
		return result;
	}

	/**
	 * Returns true if this type reference represents an type with the given
	 * raw type <code>clazz</code>.
	 * Returns false if this is not exactly the given type, but a sub type, a
	 * super type or a completely unrelated type.
	 */
//	public abstract boolean isType(Class<?> clazz);  //cym comment
	public abstract boolean isType(JvmType type);
	
	public void accept(TypeReferenceVisitor visitor) {
		visitor.doVisitTypeReference(this);
	}
	
	public <Param> void accept(TypeReferenceVisitorWithParameter<Param> visitor, Param param) {
		visitor.doVisitTypeReference(this, param);
	}
	
	@Nullable
	public <Result> Result accept(TypeReferenceVisitorWithResult<Result> visitor) {
		return visitor.doVisitTypeReference(this);
	}
	
	@Nullable
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndResult<Param, Result> visitor, Param param) {
		return visitor.doVisitTypeReference(this, param);
	}
	
	public <Result> Result accept(TypeReferenceVisitorWithNonNullResult<Result> visitor) {
		Result result = accept((TypeReferenceVisitorWithResult<Result>)visitor);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}
	
	public <Param, Result> Result accept(TypeReferenceVisitorWithParameterAndNonNullResult<Param, Result> visitor, Param param) {
		Result result = accept((TypeReferenceVisitorWithParameterAndResult<Param, Result>)visitor, param);
		if (result == null)
			throw new IllegalStateException("result may not be null");
		return result;
	}

	// TODO move to utility / factory
	public CompoundTypeReference toMultiType(LightweightTypeReference reference) {
		if (reference == null) {
			throw new NullPointerException("reference may not be null");
		}
		CompoundTypeReference result = new CompoundTypeReference(reference.getOwner(), false);
		result.addComponent(copyInto(result.getOwner()));
		result.addComponent(reference);
		return result;
	}

	public boolean isFunctionType() {
		return getFunctionTypeKind() != FunctionTypeKind.NONE;
	}
	
	public boolean isInterfaceType() {
		return false;
	}
	
	public FunctionTypeKind getFunctionTypeKind() {
		return FunctionTypeKind.NONE;
	}

	/**
	 * Returns the equivalent {@link FunctionTypeReference} if this reference
	 * points to a {@link Functions function} or {@link Procedures procedure}
	 * or if it is already a function type reference.
	 * Otherwise returns <code>null</code>.
	 * 
	 * @see #tryConvertToFunctionTypeReference(boolean)
	 */
	@Nullable
	public FunctionTypeReference getAsFunctionTypeReference() {
		return null;
	}
	
	/**
	 * Converts this reference to a {@link FunctionTypeReference} if the referenced type is a SAM type.
	 * Returns <code>null</code> if this reference does not point to a valid function type.
	 * @param rawType if a raw view on the function type is sufficient.
	 * @see #getAsFunctionTypeReference()
	 */
	@Nullable
	public FunctionTypeReference tryConvertToFunctionTypeReference(boolean rawType) {
		return null;
	}

	/**
	 * Returns the array representation of this reference if its represents a subtype of {@link Iterable}
	 * or already an array itself.
	 * If the iterable's type is a primitive wrapper, the array is <em>not</em> the primitive array but
	 * the wrapper array. May return <code>null</code> if the conversion is not possible.
	 * 
	 * @return an equivalent {@link ArrayTypeReference} or <code>null</code>.
	 */
	@Nullable
	public ArrayTypeReference tryConvertToArray() {
		return null;
	}

	public boolean isWildcard() {
		return false;
	}

	public boolean isMultiType() {
		return false;
	}
	
	public boolean isSynonym() {
		return false;
	}
	
	/**
	 * Converts types to references that can be expressed as Java type references
	 * in source code.
	 * Any types will be expressed as Object whereas multi types will be expressed as their common super type.
	 * Unknown types are considered to be ok thus returned as is.
	 */
	public LightweightTypeReference toJavaType() {
		// TODO this needs more refinement, e.g. arrays, parameter types et al
		return this;
	}
	
	public List<LightweightTypeReference> getMultiTypeComponents() {
		return Collections.emptyList();
	}
}
