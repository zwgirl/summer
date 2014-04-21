/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JvmWildcardTypeReferenceImplCustom extends JvmWildcardTypeReferenceImpl {
	
	@Override
	public String getIdentifier() {
		return NameConcatHelper.computeFor(this, '$', NameConcatHelper.NameType.ID);
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		return NameConcatHelper.computeFor(this, innerClassDelimiter, NameConcatHelper.NameType.QUALIFIED);
	}
	
	@Override
	public String getSimpleName() {
		return NameConcatHelper.computeFor(this, '$', NameConcatHelper.NameType.SIMPLE);
	}
	
	/**
	 * {@inheritDoc}
	 * 
	 * Returns always <code>null</code>.
	 */
	@Override
	public JvmType getType() {
		return null;
	}
	
	@Override
	public String toString() {
		StringBuilder result = new StringBuilder(eClass().getName());
		result.append(": ");
		result.append(NameConcatHelper.computeFor(this, '$', NameConcatHelper.NameType.TO_STRING));
		return result.toString();
	}
	
	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		Result result = visitor.doVisitWildcardTypeReference(this);
		return result;
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter,Result> visitor, Parameter parameter) {
		Result result = visitor.doVisitWildcardTypeReference(this, parameter);
		return result;
	}

}
