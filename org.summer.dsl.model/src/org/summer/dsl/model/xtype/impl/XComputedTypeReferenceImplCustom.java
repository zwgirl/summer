/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xtype.impl;

import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesFactory;
import org.summer.dsl.model.types.util.ITypeReferenceVisitor;
import org.summer.dsl.model.types.util.ITypeReferenceVisitorWithParameter;
import org.summer.dsl.model.xbase.typing.IJvmTypeReferenceProvider;
import org.summer.dsl.model.xtype.util.XtypeReferenceVisitor;
import org.summer.dsl.model.xtype.util.XtypeReferenceVisitorWithParameter;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class XComputedTypeReferenceImplCustom extends XComputedTypeReferenceImpl {

	@Override
	public <Result> Result accept(ITypeReferenceVisitor<Result> visitor) {
		if (visitor instanceof XtypeReferenceVisitor) {
			return ((XtypeReferenceVisitor<Result>) visitor).doVisitComputedTypeReference(this);
		}
		return super.accept(visitor);
	}
	
	@Override
	public <Parameter, Result> Result accept(ITypeReferenceVisitorWithParameter<Parameter, Result> visitor,
			Parameter parameter) {
		if (visitor instanceof XtypeReferenceVisitorWithParameter) {
			return ((XtypeReferenceVisitorWithParameter<Parameter, Result>) visitor).doVisitComputedTypeReference(this, parameter);
		}
		return super.accept(visitor, parameter);
	}
	
	@Override
	public JvmTypeReference getEquivalent() {
		if (equivalent == null) {
			IJvmTypeReferenceProvider provider = getTypeProvider();
			if (provider != null) {
				JvmTypeReference result = provider.getTypeReference(this);
				if (equivalent == null || equivalent != result) {
					if (result != null && (result.eResource() != null || result.eContainer() != null)) {
						JvmDelegateTypeReference delegate = TypesFactory.eINSTANCE.createJvmDelegateTypeReference();
						delegate.setDelegate(result);
						result = delegate;
					}
					if (result != null) {
						boolean wasDeliver = eDeliver();
						try {
							eSetDeliver(false);
							setEquivalent(result);
						} finally {
							eSetDeliver(wasDeliver);
						}
					}
				}
			} else {
				equivalent = null;
			}
		}
		return equivalent;
	}
	
}
