/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.eclipse.emf.ecore.InternalEObject;
import org.summer.dsl.model.types.JvmGenericType;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.impl.ClassURIHelper;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmAnyTypeReferenceImplCustom extends JvmAnyTypeReferenceImpl {

	/**
	 * {@inheritDoc}
	 * 
	 * Returns the value of the 'Type' reference. If there is no type set, 
	 * a reference to <code>java.lang.Object</code> is assumed.
	 */
	@Override
	public JvmType getType() {
		if (type == null) {
			//cym comment
//			JvmGenericType objectType = TypesFactory.eINSTANCE.createJvmGenericType();
//			((InternalEObject) objectType).eSetProxyURI(new ClassURIHelper().getFullURI(Object.class));
//			setType(objectType);
			setType(Buildin.Object.Type); //Types.getInstance().getObjectType(eResource()));
		}
		return super.getType();
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitAnyTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitAnyTypeReference(this, parameter);
		return result;
	}
	
	/**
	 * The identifier of a {@link org.summer.dsl.model.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		return "null";
	}
	
	/**
	 * The simple name of a {@link org.summer.dsl.model.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 */
	@Override
	public String getSimpleName() {
		return "null";
	}
	
	/**
	 * The qualified name of a {@link org.summer.dsl.model.types.JvmAnyTypeReference JvmAnyTypeReference} 
	 * is always "<code>null</code>".
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return "null";
	}
	
	@Override
	public String toString() {
		return eClass().getName();
	}
	
}
