/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.xtext;

import java.util.List;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.access.IJvmTypeProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IGlobalScopeProvider;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;

/**
 * Abstract super class of all local scope providers that allow references to Java types.
 *  
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Jan Koehnlein - introduced QualifiedName
 */
public abstract class AbstractTypeScopeProvider implements IGlobalScopeProvider {

	public IScope getScope(Resource resource, EReference reference) {
		return getScope(resource, reference, null);
	}
	
	public IScope getScope(Resource resource, EReference reference, Predicate<IEObjectDescription> filter) {
		if (resource == null)
			throw new IllegalStateException("context must be contained in a resource");
		ResourceSet resourceSet = resource.getResourceSet();
		if (resourceSet == null)
			throw new IllegalStateException("context must be contained in a resource set");
		EClass referenceType = reference.getEReferenceType();
		if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_TYPE, referenceType)) {
			IJvmTypeProvider typeProvider = getTypeProvider(resourceSet);
			return createTypeScope(typeProvider, filter);
		} else if (EcoreUtil2.isAssignableFrom(TypesPackage.Literals.JVM_CONSTRUCTOR, referenceType)) {
			IJvmTypeProvider typeProvider = getTypeProvider(resourceSet);
			return createConstructorScope(typeProvider, filter);
		} else {
			return IScope.NULLSCOPE;
		}
	}

	public IJvmTypeProvider getTypeProvider(ResourceSet resourceSet) {
		IJvmTypeProvider typeProvider = getTypeProviderFactory().findOrCreateTypeProvider(resourceSet);
		return typeProvider;
	}

	public abstract AbstractTypeScope createTypeScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter);

	public abstract AbstractConstructorScope createConstructorScope(IJvmTypeProvider typeProvider, Predicate<IEObjectDescription> filter);
	
	public abstract IJvmTypeProvider.Factory getTypeProviderFactory();
	
	public IScope createMemberScope(JvmType containerType, Predicate<JvmMember> filter, Function<JvmMember, QualifiedName> names, IScope outer) {
		if (containerType == null || containerType.eIsProxy())
			return outer;		
		if (containerType instanceof JvmDeclaredType) {
			IScope result = outer;
			List<JvmTypeReference> superTypes = ((JvmDeclaredType) containerType).getSuperTypes();
			for(JvmTypeReference superType: superTypes) {
				if (superType.getType() != null)
					result = createMemberScope(superType.getType(), filter, names, result);
			}
			List<JvmMember> members = ((JvmDeclaredType) containerType).getMembers();
			return Scopes.scopeFor(Iterables.filter(members, filter), names, result);
		}
		return outer;
	}

}
