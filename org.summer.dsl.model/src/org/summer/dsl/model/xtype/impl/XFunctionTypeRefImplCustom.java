/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xtype.impl;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.InternalEObject;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.xtext.EcoreUtil2;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmLowerBound;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;
import org.summer.dsl.model.xtype.util.XFunctionTypeRefs;
import org.summer.dsl.model.xtype.util.XtypeReferenceVisitor;
import org.summer.dsl.model.xtype.util.XtypeReferenceVisitorWithParameter;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;

import com.google.common.collect.Lists;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Sebastian Zarnekow - Refactored type references, introduced 
 * 	{@link org.summer.dsl.model.types.JvmSpecializedTypeReference}
 */
public class XFunctionTypeRefImplCustom extends XFunctionTypeRefImpl {
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		if (visitor instanceof XtypeReferenceVisitor) {
			return ((XtypeReferenceVisitor<Result>) visitor).doVisitFunctionTypeReference(this);
		}
		return super.accept(visitor);
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter, Result> visitor,
			Parameter parameter) {
		if (visitor instanceof XtypeReferenceVisitorWithParameter) {
			return ((XtypeReferenceVisitorWithParameter<Parameter, Result>) visitor).doVisitFunctionTypeReference(this, parameter);
		}
		return super.accept(visitor, parameter);
	}
	
	
	//cym comment
//	// TODO should we update the type as soon as the number of argument types changes?  
//	@Override
//	public JvmType getType() {
//		if (this.type == null) {
////			// make sure scoping has taken place and installed an IJvmTypeProvider
////			if (returnType != null)
////				returnType.getType();
//			JvmType newType = TypesFactory.eINSTANCE.createJvmVoid();
//			((InternalEObject)newType).eSetProxyURI(computeTypeUri(isProcedure()));
//			type = (JvmType) eResolveProxy((InternalEObject) newType);
//		}
//		return super.getType();
//	}
	
	// TODO should we update the type as soon as the number of argument types changes?  
	@Override
	public JvmType getType() {
		if (this.type == null) {
//			// make sure scoping has taken place and installed an IJvmTypeProvider
//			if (returnType != null)
//				returnType.getType();
//			JvmType newType = TypesFactory.eINSTANCE.createJvmVoid();
//			((InternalEObject)newType).eSetProxyURI(computeTypeUri(isProcedure()));
//			type = (JvmType) eResolveProxy((InternalEObject) newType);
			type = BuildInTypes.getInstance().getFunctionType(eResource());
		}
		return super.getType();
	}
	
	private boolean isProcedure() {
		JvmTypeReference returnType = getReturnType();
		if (returnType == null)
			return true;
		JvmType type = returnType.getType();
		if (type == null)
			return false;
		if (type.eIsProxy())
			return false;
		if (type instanceof JvmVoid)
			return true;
		return false;
	}

	@Override
	public JvmTypeReference getEquivalent() {
		if (equivalent == null) {
			JvmType rawType = getType();
			if (rawType != null && rawType instanceof JvmDeclaredType) {
				JvmParameterizedTypeReference result = !isInstanceContext() ? 
					createEquivalentWithWildcards(rawType, isProcedure()) :
					createEquivalentWithoutWildcards(rawType, isProcedure());
				boolean wasDeliver = eDeliver();
				try {
					eSetDeliver(false);
					setEquivalent(result);
				} finally {
					eSetDeliver(wasDeliver);
				}
			} else {
				equivalent = null;
			}
		}
		return equivalent;
	}

	protected JvmParameterizedTypeReference createEquivalentWithoutWildcards(JvmType rawType, boolean procedure) {
		TypesFactory typesFactory = TypesFactory.eINSTANCE;
		JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
		result.setType(rawType);
		for(JvmTypeReference paramType: Lists.newArrayList(getParamTypes())) {
			JvmTypeReference wrapped = wrapIfNecessary(paramType);
			if (wrapped == null || wrapped.eContainer() != null) {
				JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
				delegate.setDelegate(wrapped);
				result.getArguments().add(delegate);
			} else {
				result.getArguments().add(wrapped);
			}
		}
		{
			if (!procedure) {
				JvmTypeReference wrapped = procedure ? getReturnType() : wrapIfNecessary(getReturnType());
				if (wrapped == null || wrapped.eContainer() != null) {
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(wrapped);
					result.getArguments().add(delegate);
				} else {
					result.getArguments().add(wrapped);
				}
			}
		}
		return result;
	}

	protected JvmParameterizedTypeReference createEquivalentWithWildcards(JvmType rawType, boolean procedure) {
		TypesFactory typesFactory = TypesFactory.eINSTANCE;
		JvmParameterizedTypeReference result = typesFactory.createJvmParameterizedTypeReference();
		result.setType(rawType);
		for(JvmTypeReference paramType: Lists.newArrayList(getParamTypes())) {
			if (!(paramType instanceof JvmWildcardTypeReference)) {
				JvmWildcardTypeReference paramWildcard = typesFactory.createJvmWildcardTypeReference();
				JvmLowerBound lowerBound = typesFactory.createJvmLowerBound();
				JvmTypeReference wrapped = wrapIfNecessary(paramType);
				if (wrapped == null || wrapped.eContainer() != null) {
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(wrapped);
					lowerBound.setTypeReference(delegate);
				} else {
					lowerBound.setTypeReference(wrapped);
				}
				JvmUpperBound upperBound = typesFactory.createJvmUpperBound();
				JvmTypeReference objectReference = getJavaLangObjectTypeRef(rawType, typesFactory);
				upperBound.setTypeReference(objectReference);
			
				paramWildcard.getConstraints().add(upperBound);
				paramWildcard.getConstraints().add(lowerBound);
				result.getArguments().add(paramWildcard);
			} else {
				JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
				delegate.setDelegate(paramType);
				result.getArguments().add(delegate);
			}
		}
		{
			if (!procedure) {
				if (!(returnType instanceof JvmWildcardTypeReference)) {
					JvmWildcardTypeReference returnType = typesFactory.createJvmWildcardTypeReference();
					JvmUpperBound returnTypeBound = typesFactory.createJvmUpperBound();
					JvmTypeReference wrapped = procedure ? getReturnType() : wrapIfNecessary(getReturnType());
					if (wrapped == null || wrapped.eContainer() != null) {
						JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
						delegate.setDelegate(wrapped);
						returnTypeBound.setTypeReference(delegate);
					} else {
						returnTypeBound.setTypeReference(wrapped);
					}
					returnType.getConstraints().add(returnTypeBound);
					result.getArguments().add(returnType);
				} else {
					JvmDelegateTypeReference delegate = typesFactory.createJvmDelegateTypeReference();
					delegate.setDelegate(returnType);
					result.getArguments().add(delegate);
				}
			}
		}
		return result;
	}

	private final static URI javaLangObjectURI = URI.createURI("java:/Objects/java.lang.Object#java.lang.Object");
	
	protected JvmTypeReference getJavaLangObjectTypeRef(JvmType rawType, TypesFactory typesFactory) {
		ResourceSet rs = EcoreUtil2.getResourceSet(rawType);
		JvmParameterizedTypeReference refToObject = typesFactory.createJvmParameterizedTypeReference();
		if (rs != null) {
			EObject javaLangObject = rs.getEObject(javaLangObjectURI, true);
			if (javaLangObject instanceof JvmType) {
				JvmType objectDeclaration = (JvmType) javaLangObject;
				refToObject.setType(objectDeclaration);
				return refToObject;
			}
		}
		JvmGenericType proxy = typesFactory.createJvmGenericType();
		((InternalEObject)proxy).eSetProxyURI(javaLangObjectURI);
		refToObject.setType(proxy);
		return refToObject;
	}
	
	public JvmTypeReference wrapIfNecessary(JvmTypeReference reference) {
		if (reference == null) {
			return null;
		}
		JvmType type = reference.getType();
		return XFunctionTypeRefs.wrapIfNecessary(reference, type);
	}
	
	protected JvmType getType(Class<?> clazz, EObject context) {
		return XFunctionTypeRefs.getType(clazz, context);
	}
	
	protected URI computeTypeUri(boolean procedure) {
		return XFunctionTypeRefs.computeTypeUri(procedure, getParamTypes().size());
	}
	
	@Override
	public String getIdentifier() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getIdentifier());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(")=>");
		if (getReturnType()!=null)
			result.append(getReturnType().getIdentifier());
		return result.toString();
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getQualifiedName(innerClassDelimiter));
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(")=>");
		if (getReturnType()!=null)
			result.append(getReturnType().getQualifiedName(innerClassDelimiter));
		return result.toString();
	}
	
	@Override
	public String getSimpleName() {
		StringBuilder result = new StringBuilder("(");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.getSimpleName());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(")=>");
		if (getReturnType()!=null)
			result.append(getReturnType().getSimpleName());
		return result.toString();
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": (");
		for (int i = 0;i< getParamTypes().size();i++) {
			JvmTypeReference reference = getParamTypes().get(i);
			result.append(reference.toString());
			if (i<getParamTypes().size()-1)
				result.append(", ");
		}
		result.append(")=>");
		if (getReturnType()!=null)
			result.append(getReturnType().toString());
		return result.toString();
	}
}
