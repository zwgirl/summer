/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xtype.util;

import org.summer.dsl.model.types.util.AbstractTypeReferenceVisitor;
import org.summer.dsl.model.xtype.XComputedTypeReference;
import org.summer.dsl.model.xtype.XFunctionTypeRef;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractXtypeReferenceVisitor<Result> extends AbstractTypeReferenceVisitor.InheritanceAware<Result> implements XtypeReferenceVisitor<Result> {

	public Result doVisitFunctionTypeReference(XFunctionTypeRef reference) {
		return doVisitSpecializedTypeReference(reference);
	}

	public Result doVisitComputedTypeReference(XComputedTypeReference reference) {
		return doVisitSpecializedTypeReference(reference);
	}
	
}
