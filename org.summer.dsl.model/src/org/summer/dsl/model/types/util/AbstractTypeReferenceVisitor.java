/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmCompoundTypeReference;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmWildcardTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeReferenceVisitor<Result> implements ITypeReferenceVisitor<Result> {

	public Result visit(JvmTypeReference reference) {
		if (reference == null) {
			Result result = handleNullReference();
			return result;
		}
		Result result = reference.accept(this);
		return result;
	}
	
	protected Result handleNullReference() {
		throw new NullPointerException("Given type reference was null");
	}
	
	public Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference) {
		Result result = visit(reference.getDelegate());
		return result;
	}
	
	public Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference) {
		Result result = visit(reference.getEquivalent());
		return result;
	}
	
	public static class InheritanceAware<Result> extends AbstractTypeReferenceVisitor<Result> {

		public Result doVisitTypeReference(JvmTypeReference reference) {
			throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + reference);
		}

		public Result doVisitAnyTypeReference(JvmAnyTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference) {
			return doVisitTypeReference(reference);
		}

		public Result doVisitMultiTypeReference(JvmMultiTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		public Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference) {
			return doVisitCompoundTypeReference(reference);
		}

		public Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference) {
			return doVisitTypeReference(reference);
		}
		
	}
	
}
