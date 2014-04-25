/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typing;

import static java.util.Collections.*;

import java.util.List;
import java.util.Set;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EObject;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.util.Primitives;
import org.summer.dsl.model.types.util.TypeReferences;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;

import com.google.common.collect.ImmutableSet;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
@Singleton
public class SynonymTypesProvider {
	
	@Inject
	private Primitives primitives;
	
	@Inject
	private TypeReferences typeRefs;
	
	public Set<JvmTypeReference> getSynonymTypes(JvmTypeReference type, boolean ignoreBoxing) {
		if (type == null || typeRefs.is(type, Void.class) || typeRefs.is(type,Void.TYPE)) {
			return emptySet();
		} else if (!ignoreBoxing && primitives.isPrimitive(type)) {
			return singletonOrEmpty(primitives.asWrapperTypeIfPrimitive(type));
		} else if (!ignoreBoxing && primitives.isWrapperType(type)) {
			return singletonOrEmpty(primitives.asPrimitiveIfWrapperType(type));
		} else if (typeRefs.isArray(type)) {
			if (type instanceof JvmGenericArrayTypeReference) {
				JvmTypeReference componentType = ((JvmGenericArrayTypeReference) type).getComponentType();
				JvmTypeReference typeArg = primitives.asWrapperTypeIfPrimitive(componentType);
//				JvmTypeReference iterable = typeRefs.getTypeForName(List.class, findContext(type.getType()), typeArg);  //cym comment
				JvmTypeReference iterable = typeRefs.getTypeForName(Buildin.List.Type, findContext(type.getType()), typeArg);
				return singletonOrEmpty(iterable);
			} else {
				JvmArrayType array = (JvmArrayType) type.getType();
				JvmTypeReference typeArg = primitives.asWrapperTypeIfPrimitive(typeRefs.createTypeRef(array.getComponentType()));
//				JvmTypeReference iterable = typeRefs.getTypeForName(List.class, findContext(array), typeArg);  //cym comment
				JvmTypeReference iterable = typeRefs.getTypeForName(Buildin.List.Type, findContext(type.getType()), typeArg);
				return singletonOrEmpty(iterable);
			}
		} else if (isList(type)) {
			JvmTypeReference componentType = null;
			if (type instanceof JvmParameterizedTypeReference) {
				EList<JvmTypeReference> arguments = ((JvmParameterizedTypeReference) type).getArguments();
				if (arguments.size()==1) {
					final JvmTypeReference jvmTypeReference = arguments.get(0);
					componentType = jvmTypeReference;
					if (componentType instanceof JvmWildcardTypeReference) {
						EList<JvmTypeConstraint> list = ((JvmWildcardTypeReference) componentType).getConstraints();
//						componentType = typeRefs.getTypeForName(Object.class, findContext(type.getType()));  // cym comment
						componentType = typeRefs.getTypeForName(Buildin.Object.Type, 
								findContext(type.getType()));
						for (JvmTypeConstraint constraint : list) {
							if (constraint instanceof JvmUpperBound) {
								componentType = constraint.getTypeReference();
							}
						}
					}
				}
			}
			if (componentType == null)
//				componentType = typeRefs.getTypeForName(Object.class, type.getType());  //cym comment
				componentType = typeRefs.getTypeForName(Buildin.Object.Type, type.getType());
			if (componentType != null) {
				if (primitives.isPrimitive(componentType)) {
					JvmTypeReference primitive = typeRefs.createArrayType(componentType);
					JvmTypeReference wrapper = typeRefs.createArrayType(primitives.asWrapperTypeIfPrimitive(componentType));
					return ImmutableSet.of(primitive, wrapper);
				} else if (primitives.isWrapperType(componentType)) {
					JvmTypeReference wrapper = typeRefs.createArrayType(componentType);
					JvmTypeReference primitive = typeRefs.createArrayType(primitives.asPrimitiveIfWrapperType(componentType));
					return ImmutableSet.of(wrapper, primitive);
				} else {
					JvmTypeReference result = typeRefs.createArrayType(componentType);
					return singletonOrEmpty(result);
				}
			}
		}
		return emptySet();
	}
	
	private Set<JvmTypeReference> singletonOrEmpty(JvmTypeReference reference) {
		if (reference == null)
			return emptySet();
		return singleton(reference);
	}

	
	//cym comment
//	protected boolean isList(JvmTypeReference type) {
//		return typeRefs.isInstanceOf(type, Iterable.class);
//	}
	
	protected boolean isList(JvmTypeReference type) {
		return typeRefs.isInstanceOf(type, Buildin.Iterable.Type);
	}

	protected EObject findContext(JvmType type) {
		return type;
	}

	public boolean hasSynonymTypes(JvmTypeReference toBeConverted) {
		final Set<JvmTypeReference> synonymTypes = getSynonymTypes(toBeConverted, false);
		return !synonymTypes.isEmpty();
	}
	
}
