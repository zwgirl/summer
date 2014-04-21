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

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.summer.dsl.model.types.JvmArrayType;
import org.summer.dsl.model.types.JvmComponentType;
import org.summer.dsl.model.types.JvmCompoundTypeReference;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeParameterDeclarator;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.impl.ClassURIHelper;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;

/*
 * This class should not rely on field injection since it is intended to be used
 * by JvmDeclaredTypeImplCustom#getAll* 
 */
/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class RawTypeHelper implements IRawTypeHelper {

	private final RawTypeImplementation typeImplementation;
	private final RawTypeReferenceImplementation typeReferenceImplementation;

	@Inject
	public RawTypeHelper(RawTypeImplementation typeImplementation, RawTypeReferenceImplementation typeReferenceImplementation) {
		this.typeImplementation = typeImplementation;
		this.typeReferenceImplementation = typeReferenceImplementation;
	}
	
	public static class RawTypeImplementation extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Resource, List<JvmType>> {

		private final TypesFactory factory;

		@Inject
		public RawTypeImplementation(TypesFactory factory) {
			this.factory = factory;
		}
		
		public List<JvmType> getAllRawTypes(JvmTypeReference reference, Resource resource) {
			List<JvmType> result = visit(reference, resource);
			return result;
		}
		
		@Override
		public List<JvmType> doVisitTypeReference(JvmTypeReference reference, Resource resource) {
			return Collections.emptyList();
		}
		
		@Override
		protected List<JvmType> handleNullReference(Resource parameter) {
			return Collections.emptyList();
		}
		
		@Override
		public List<JvmType> doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Resource resource) {
			List<JvmTypeReference> references = reference.getReferences();
			if (references.isEmpty())
				return Collections.emptyList();
			List<JvmType> result = Lists.newArrayList();
			for(JvmTypeReference contained: references) {
				result.addAll(visit(contained, resource));
			}
			return result;
		}
		
		@Override
		public List<JvmType> doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Resource resource) {
			JvmTypeReference componentType = reference.getComponentType();
			List<JvmType> rawComponentTypes = visit(componentType, resource);
			List<JvmType> result = Lists.newArrayListWithCapacity(rawComponentTypes.size());
			for(JvmType rawComponentType: rawComponentTypes) {
				if (!rawComponentType.eIsProxy() && rawComponentType instanceof JvmComponentType) {
					JvmArrayType arrayType = ((JvmComponentType) rawComponentType).getArrayType();
					result.add(arrayType);
				}
			}
			return result;
		}
		
		@Override
		public List<JvmType> doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Resource resource) {
			JvmType type = reference.getType();
			if (type != null && !type.eIsProxy()) {
				if (type instanceof JvmTypeParameter) {
					return getRawTypesFromConstraints(((JvmTypeParameter) type).getConstraints(), resource);
				}
				return Collections.singletonList(type);
			}
			return Collections.emptyList();
		}
		
		@Override
		public List<JvmType> doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Resource resource) {
			return getRawTypesFromConstraints(reference.getConstraints(), resource);
		}

		protected List<JvmType> getRawTypesFromConstraints(List<JvmTypeConstraint> constraints, Resource resource) {
			if (!constraints.isEmpty()) {
				List<JvmType> result = Lists.newArrayList();
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						result.addAll(visit(constraint.getTypeReference(), resource));
					}
				}
				if (!result.isEmpty())
					return result;
			}
			return createObjectReference(resource);
		}

		protected List<JvmType> createObjectReference(Resource resource) {
			if (resource != null) {
				// no upper bound found - seems to be an invalid - assume object as upper bound
				//cym comment
//				URI objectURI = new ClassURIHelper().getFullURI(Object.class);
//				JvmType objectType = factory.createJvmGenericType();
//				((InternalEObject)objectType).eSetProxyURI(objectURI);
//				objectType = (JvmType) EcoreUtil.resolve(objectType, resource);
				JvmType objectType = BuildInTypes.getInstance().getObjectType(resource);
				return Collections.singletonList(objectType);
			}
			return Collections.emptyList();
		}
	}
	
	public static class RawTypeReferenceImplementation extends AbstractTypeReferenceVisitorWithParameter.InheritanceAware<Resource, JvmTypeReference> {

		private final TypesFactory factory;

		@Inject
		public RawTypeReferenceImplementation(TypesFactory factory) {
			this.factory = factory;
		}
		
		public JvmTypeReference getRawTypeReference(JvmTypeReference reference, Resource resource) {
			JvmTypeReference result = visit(reference, resource);
			return result;
		}
		
		@Override
		public JvmTypeReference doVisitTypeReference(JvmTypeReference reference, Resource resource) {
			return reference;
		}
		
		@Override
		protected JvmTypeReference handleNullReference(Resource parameter) {
			return null;
		}
		
		@Override
		public JvmTypeReference doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Resource resource) {
			JvmCompoundTypeReference result = null;
			List<JvmTypeReference> components = reference.getReferences();
			int recent = -1;
			for(int i = 0; i < components.size(); i++) {
				JvmTypeReference component = components.get(i);
				JvmTypeReference rawType = visit(component, resource);
				if (rawType != null && component != rawType) {
					if (result == null) {
						result = (JvmCompoundTypeReference) EcoreUtil.create(reference.eClass());
					}
					for(int j = recent + 1; j < i; j++) {
						result.getReferences().add(components.get(j));
					}
					result.getReferences().add(rawType);
					recent = i;
				}
			}
			if (result != null)
				return result;
			return reference;
		}
		
		@Override
		public JvmTypeReference doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Resource parameter) {
			JvmTypeReference result = super.doVisitDelegateTypeReference(reference, parameter);
			if (result == reference.getDelegate())
				return reference;
			return result;
		}
		
		@Override
		public JvmTypeReference doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Resource resource) {
			JvmTypeReference componentType = reference.getComponentType();
			JvmTypeReference rawComponentType = visit(componentType, resource);
			if (componentType != rawComponentType) {
				JvmGenericArrayTypeReference result = factory.createJvmGenericArrayTypeReference();
				result.setComponentType(rawComponentType);
				return result;
			}
			return reference;
		}
		
		@Override
		public JvmTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Resource resource) {
			JvmType type = reference.getType();
			if (type != null && !type.eIsProxy()) {
				if (type instanceof JvmTypeParameterDeclarator) {
					if (!((JvmTypeParameterDeclarator) type).getTypeParameters().isEmpty()) {
						JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
						result.setType(type);
						return result;
					}
				} else if (type instanceof JvmTypeParameter) {
					return getRawTypeFromConstraints(((JvmTypeParameter) type).getConstraints(), resource);
				}
			}
			return reference;
		}
		
		@Override
		public JvmTypeReference doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Resource resource) {
			return getRawTypeFromConstraints(reference.getConstraints(), resource);
		}

		protected JvmTypeReference getRawTypeFromConstraints(List<JvmTypeConstraint> constraints, Resource resource) {
			if (!constraints.isEmpty()) {
				JvmTypeReference result = null;
				for(JvmTypeConstraint constraint: constraints) {
					if (constraint instanceof JvmUpperBound) {
						JvmTypeReference rawType = visit(constraint.getTypeReference(), resource);
						if (result == null) {
							if (rawType != null && rawType.eContainer() != null) {
								JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
								delegate.setDelegate(rawType);
								rawType = delegate;
							}
							result = rawType;
						} else if (!(result instanceof JvmSynonymTypeReference)){
							JvmSynonymTypeReference synonym = factory.createJvmSynonymTypeReference();
							synonym.getReferences().add(result);
							if (rawType.eContainer() != null) {
								JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
								delegate.setDelegate(rawType);
								rawType = delegate;
							}
							synonym.getReferences().add(rawType);
							result = synonym;
						} else {
							JvmSynonymTypeReference synonym = (JvmSynonymTypeReference) result;
							if (rawType.eContainer() != null) {
								JvmDelegateTypeReference delegate = factory.createJvmDelegateTypeReference();
								delegate.setDelegate(rawType);
								rawType = delegate;
							}
							synonym.getReferences().add(rawType);
						}
					}
				}
				if (result != null)
					return result;
			}
			return createObjectReference(resource);
		}

		protected JvmTypeReference createObjectReference(Resource resource) {
			// no upper bound found - seems to be an invalid - assume object as upper bound
			//cym  comment
//			URI objectURI = new ClassURIHelper().getFullURI(Object.class);
//			JvmType objectType = factory.createJvmGenericType();
//			((InternalEObject)objectType).eSetProxyURI(objectURI);
			
			JvmType objectType= BuildInTypes.getInstance().getObjectType(resource);
//			if (resource != null) {
//				objectType = (JvmType) EcoreUtil.resolve(objectType, resource);
//			}
			JvmParameterizedTypeReference result = factory.createJvmParameterizedTypeReference();
			result.setType(objectType);
			return result;
		}
	}
	
	public List<JvmType> getAllRawTypes(JvmTypeReference reference, Resource resource) {
		List<JvmType> result = typeImplementation.getAllRawTypes(reference, resource);
		return result;
	}

	public JvmTypeReference getRawTypeReference(JvmTypeReference reference, Resource resource) {
		JvmTypeReference result = typeReferenceImplementation.getRawTypeReference(reference, resource);
		return result;
	}
}
