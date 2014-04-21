/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.references;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.xbase.typesystem.util.AbstractReentrantTypeReferenceProvider;
import org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class UnboundTypeReferenceResolver extends AbstractReentrantTypeReferenceProvider {
	private UnboundTypeReference unboundTypeReference;

	public UnboundTypeReferenceResolver(UnboundTypeReference unboundTypeReference) {
		this.unboundTypeReference = unboundTypeReference;
	}

	@Override
	protected JvmTypeReference doGetTypeReference(XComputedTypeReferenceImplCustom context) {
		LightweightTypeReference resolvedTo = unboundTypeReference.resolve();
		return resolvedTo.toTypeReference();
	}
	
	public UnboundTypeReference getUnboundTypeReference() {
		return unboundTypeReference;
	}
}