/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import java.util.Collections;
import java.util.List;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.summer.dsl.model.types.access.TypeResource;
import org.summer.dsl.model.types.access.impl.ClassURIHelper;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Singleton
@SuppressWarnings("deprecation")
public class TypeReferences {

	private final static Logger log = Logger.getLogger(TypeReferences.class);

	@Inject
	private TypesFactory factory = TypesFactory.eINSTANCE;

	@Inject
	private IJvmTypeProvider.Factory typeProviderFactory;

	@Inject
	private ClassURIHelper uriHelper;

	@Inject
	private SuperTypeCollector superTypeCollector;

	/**
	 * @return a fresh {@link JvmAnyTypeReference} or null if {@link Object} is not on the context's classpath
	 */
	public JvmAnyTypeReference createAnyTypeReference(Notifier context) {
		if (context == null)
			throw new NullPointerException("context");
		JvmAnyTypeReference result = factory.createJvmAnyTypeReference();
		//cym comment
//		final JvmType objectType = findDeclaredType(Object.class, context);
//		if (objectType == null)
//			return null;
		final JvmType objectType = Buildin.Object.JvmType;
		
		result.setType(objectType);
		return result;
	}

	/**
	 * @return a fresh {@link JvmMultiTypeReference} pointing to the given references or null if {@link Object} is not
	 *         on the context's class path
	 */
	public JvmMultiTypeReference createMultiTypeReference(Notifier context, JvmTypeReference... references) {
		if (context == null)
			throw new NullPointerException("context");
		JvmMultiTypeReference result = factory.createJvmMultiTypeReference();
		if (references != null && references.length != 0) {
			for (JvmTypeReference reference : references) {
				result.getReferences().add(createDelegateTypeReference(reference));
			}
		}
		//cym comment
//		final JvmType findDeclaredType = findDeclaredType(Object.class, context);
		final JvmType findDeclaredType = Buildin.Object.JvmType;
		if (findDeclaredType == null)
			return null;
		result.setType(findDeclaredType);
		return result;
	}

	/**
	 * @return a fresh {@link JvmParameterizedTypeReference} for the given {@link JvmType} parameterized with the given
	 *         typeArgs. This method does not check whether the given type can handle the given type arguments.
	 */
	public JvmParameterizedTypeReference createTypeRef(JvmType type, JvmTypeReference... typeArgs) {
		if (type == null)
			throw new NullPointerException("type");
		List<JvmTypeReference> typeReferences = Collections.emptyList();
		if (typeArgs != null && typeArgs.length > 0) {
			typeReferences = Lists.newArrayListWithCapacity(typeArgs.length);
			for (int i = 0; i < typeArgs.length; i++) {
				JvmTypeReference jvmTypeReference = typeArgs[i];
				typeReferences.add(EcoreUtil2.cloneIfContained(jvmTypeReference));
			}
		}
		if (type instanceof JvmGenericType) {
			List<JvmTypeParameter> list = ((JvmGenericType) type).getTypeParameters();
			if (!typeReferences.isEmpty() && list.size() != typeReferences.size()) {
				throw new IllegalArgumentException("The type " + type.getIdentifier() + " expects " + list.size()
						+ " type arguments, but was " + typeReferences.size()
						+ ". Either pass zero arguments (raw type) or the correct number.");
			}
			// Raw type -> create type references to type param
			if (typeReferences.isEmpty() && !list.isEmpty()) {
				typeReferences = Lists.newArrayListWithCapacity(list.size());
				for (JvmTypeParameter typeParameter : list) {
					typeReferences.add(createTypeRef(typeParameter));
				}
			}
		}
		JvmParameterizedTypeReference reference = factory.createJvmParameterizedTypeReference();
		reference.setType(type);
		if (!typeReferences.isEmpty())
			reference.getArguments().addAll(typeReferences);
		return reference;
	}

	public JvmDelegateTypeReference createDelegateTypeReference(JvmTypeReference typeRef) {
		JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
		delegate.setDelegate(typeRef);
		return delegate;
	}

	public JvmTypeReference getArgument(JvmTypeReference left, int index) {
		if (left.getType() instanceof JvmGenericType) {
			List<JvmTypeParameter> typeParameters = ((JvmGenericType) left.getType()).getTypeParameters();
			if (typeParameters.size() <= index) {
				throw new IllegalArgumentException("The type " + left.getType().getIdentifier()
						+ " cannot be parameterized with more than " + typeParameters.size() + " type arguments.");
			}
			if (left instanceof JvmParameterizedTypeReference) {
				List<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) left).getArguments();
				if (arguments.size() == typeParameters.size()) {
					return arguments.get(index);
				}
			}
			final JvmTypeParameter jvmTypeParameter = typeParameters.get(index);
			return createTypeRef(jvmTypeParameter);
		}
		throw new IllegalArgumentException(left.getType().getIdentifier() + " is not generic.");
	}

	public JvmWildcardTypeReference wildCard() {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		return result;
	}

	public JvmWildcardTypeReference wildCardExtends(JvmTypeReference clone) {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		upperBound.setTypeReference(clone);
		result.getConstraints().add(upperBound);
		return result;
	}

	public JvmWildcardTypeReference wildCardSuper(JvmTypeReference clone) {
		JvmWildcardTypeReference result = factory.createJvmWildcardTypeReference();
		JvmLowerBound lowerBound = factory.createJvmLowerBound();
		lowerBound.setTypeReference(clone);
		JvmUpperBound upperBound = factory.createJvmUpperBound();
		//cym comment
//		upperBound.setTypeReference(getTypeForName(Object.class, clone.getType()));
		final JvmType findDeclaredType = Buildin.Object.JvmType;
		upperBound.setTypeReference(getTypeForName(findDeclaredType, clone.getType()));
		result.getConstraints().add(lowerBound);
		result.getConstraints().add(upperBound);
		return result;
	}

	protected URI toCommonTypesUri(Class<?> clazz) {
		URI result = uriHelper.getFullURI(clazz);
		return result;
	}
	
	//cym add
	public JvmTypeReference getTypeForName(JvmType declaredType, Notifier context, JvmTypeReference... params) {
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}

	public JvmTypeReference getTypeForName(Class<?> clazz, Notifier context, JvmTypeReference... params) {
		if (clazz == null)
			throw new NullPointerException("clazz");
		JvmType declaredType = findDeclaredType(clazz, context);
		if (declaredType == null)
			return getUnknownTypeReference(clazz.getName());
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}
	
	protected JvmUnknownTypeReference getUnknownTypeReference(String qualifiedName) {
		JvmUnknownTypeReference reference = TypesFactory.eINSTANCE.createJvmUnknownTypeReference();
		reference.setQualifiedName(qualifiedName);
		return reference;
	}

	public JvmTypeReference getTypeForName(String typeName, Notifier context, JvmTypeReference... params) {
		if (typeName == null)
			throw new NullPointerException("typeName");
		JvmType declaredType = findDeclaredType(typeName, context);
		if (declaredType == null)
			return getUnknownTypeReference(typeName);
		JvmParameterizedTypeReference result = createTypeRef(declaredType, params);
		return result;
	}

	public JvmGenericArrayTypeReference createArrayType(JvmTypeReference componentType) {
		JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
		result.setComponentType(EcoreUtil2.cloneIfContained(componentType));
		return result;
	}

	/**
	 * looks up a JVMType corresponding to the given {@link Class}. This method ignores any Jvm types created in non-
	 * {@link TypeResource} in the given EObject's resourceSet, but goes straight to the Java-layer, using a
	 * {@link IJvmTypeProvider}.
	 * 
	 * @return the JvmType with the same qualified name as the given {@link Class} object, or null if no such JvmType
	 *         could be found using the context's resourceSet.
	 */
	public JvmType findDeclaredType(Class<?> clazz, Notifier context) {
		if (clazz == null)
			throw new NullPointerException("clazz");
		JvmType declaredType = findDeclaredType(clazz.getName(), context);
		return declaredType;
	}

	/**
	 * looks up a JVMType corresponding to the given {@link Class}. This method ignores any Jvm types created in non-
	 * {@link TypeResource} in the given context's resourceSet, but goes straight to the Java-layer, using a
	 * {@link IJvmTypeProvider}.
	 * 
	 * @return the JvmType with the same qualified name as the given {@link Class} object, or null if no such JvmType
	 *         could be found using the context's resourceSet.
	 */
	public JvmType findDeclaredType(String typeName, Notifier context) {
		if (typeName == null)
			throw new NullPointerException("typeName");
		if (context == null)
			throw new NullPointerException("context");
		ResourceSet resourceSet = EcoreUtil2.getResourceSet(context);
		if (resourceSet == null)
			return null;
		// make sure a type provider is configured in the resource set. 
		IJvmTypeProvider typeProvider = typeProviderFactory.findOrCreateTypeProvider(resourceSet);
		try {
			final JvmType result = typeProvider.findTypeByName(typeName);
			return result;
		} catch (RuntimeException e) {
			log.info("Couldn't find JvmType for name '" + typeName + "' in context " + context, e);
			return null;
		}
	}
	//cym add
	public boolean is(final JvmTypeReference reference, JvmType clazz) {
		if (isNullOrProxy(reference))
			return false;
		boolean result = reference.getType() == clazz;
		return result;
	}

	public boolean is(final JvmTypeReference reference, final Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		boolean result = is(reference.getType(), clazz);
		return result;
	}
	
	public boolean is(final JvmType type, final Class<?> clazz) {
		if (type == null)
			return false;
		String className = clazz.getName();
		if (className.charAt(0) == '[') {
			className = clazz.getCanonicalName();
		}
		boolean result = className.equals(type.getIdentifier());
		return result;
	}
	
	
	//cym added
	public boolean is(final JvmType type, JvmType type1) {
		if (type == null)
			return false;
		return type1.getIdentifier().equals(type.getIdentifier());
	}

	public boolean isNullOrProxy(final JvmTypeReference reference) {
		return reference == null || reference.getType() == null || reference.getType().eIsProxy();
	}

	public boolean isInstanceOf(JvmTypeReference reference, Class<?> clazz) {
		if (isNullOrProxy(reference))
			return false;
		if (is(reference, clazz)) {
			return true;
		}
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(reference);
		for (JvmTypeReference jvmTypeReference : types) {
			if (is(jvmTypeReference, clazz))
				return true;
		}
		return false;
	}
	
	//cym add
	public boolean isInstanceOf(JvmTypeReference reference, JvmType type) {
		if (isNullOrProxy(reference))
			return false;
		if (is(reference, type)) {
			return true;
		}
		Set<JvmTypeReference> types = superTypeCollector.collectSuperTypes(reference);
		for (JvmTypeReference jvmTypeReference : types) {
			if (is(jvmTypeReference, type))
				return true;
		}
		return false;
	}

	public boolean isArray(JvmTypeReference type) {
		if (isNullOrProxy(type))
			return false;
		return type instanceof JvmGenericArrayTypeReference || type.getType() instanceof JvmArrayType;
	}
}
