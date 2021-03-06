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
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.access.impl.ClassURIHelper;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;
import org.summer.dsl.xbase.scoping.batch.BuildInTypes;
import org.summer.dsl.xbase.scoping.batch.Buildin;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmCompoundTypeReferenceImplCustom extends JvmCompoundTypeReferenceImpl {

	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitCompoundTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitCompoundTypeReference(this, parameter);
		return result;
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Returns the value of the 'Type' reference. If there is no type set, 
	 * a reference to <code>java.lang.Object</code> is assumed as soon as there is more 
	 * than one contained reference.
	 * If there is only one contained reference, its type is returned.
	 */
	@Override
	public JvmType getType() {
		if (references != null && !references.isEmpty()) {
			if (references.size() == 1) {
				return references.get(0).getType();
			}
			if (type == null) {
//				JvmGenericType objectType = TypesFactory.eINSTANCE.createJvmGenericType();
//				((InternalEObject) objectType).eSetProxyURI(new ClassURIHelper().getFullURI(Object.class));
//				type = objectType;
				setType(Buildin.Object.Type);
			}
		}
		return super.getType();
	}
	
	/**
	 * The identifier of a {@link org.summer.dsl.model.types.JvmCompoundTypeReference JvmCompoundTypeReference} 
	 * is the concatenated identifier of its {@link #getReferences() components}. The {@link #getDelimiter() delimiter} 
	 * is specified in concrete sub-types.
	 * 
	 * {@inheritDoc}
	 */
	@Override
	public String getIdentifier() {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getIdentifier());
			}
			return result.toString();
		}
		return super.getIdentifier();
	}

	protected String getDelimiter() {
		throw new UnsupportedOperationException("Subclasses of JvmCompoundTypeReferenceImplCustom must override #getDelimiter");
	}
	
	/**
	 * The simple name of a {@link org.summer.dsl.model.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated simple name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getSimpleName() {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getSimpleName());
			}
			return result.toString();
		}
		return super.getIdentifier();
	}
	
	/**
	 * The qualified name of a {@link org.summer.dsl.model.types.JvmMultiTypeReference JvmMultiTypeReference} 
	 * is the concatenated qualified name of its {@link #getReferences() components}. The delimiter is the <code>&</code>.
	 */
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (references != null && !references.isEmpty()) {
			StringBuilder result = new StringBuilder();
			for(JvmTypeReference reference: references) {
				if (result.length() > 0) {
					result.append(getDelimiter());
				}
				result.append(reference.getQualifiedName(innerClassDelimiter));
			}
			return result.toString();
		}
		return super.getIdentifier();
	}

	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		if (references != null && !references.isEmpty()) {
			boolean first = true;
			for(JvmTypeReference reference: references) {
				if (!first)
					result.append(getDelimiter());
				first = false;
				result.append(reference.toString());
			}
		} else {
			result.append(" ./. ");
		}
		return result.toString();
	}
	
}
