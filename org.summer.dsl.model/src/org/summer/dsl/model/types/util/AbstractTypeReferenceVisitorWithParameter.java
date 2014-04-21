/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import org.summer.dsl.model.types.JvmMultiTypeReference;
import org.summer.dsl.model.types.JvmAnyTypeReference;
import org.summer.dsl.model.types.JvmCompoundTypeReference;
import org.summer.dsl.model.types.JvmDelegateTypeReference;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmSynonymTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUnknownTypeReference;
import org.summer.dsl.model.types.JvmWildcardTypeReference;



/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class AbstractTypeReferenceVisitorWithParameter<Parameter, Result> implements ITypeReferenceVisitorWithParameter<Parameter, Result> {

	public Result visit(JvmTypeReference reference, Parameter parameter) {
		if (reference == null) {
			Result result = handleNullReference(parameter);
			return result;
		}
		Result result = reference.accept(this, parameter);
		return result;
	}
	
	protected Result handleNullReference(Parameter parameter) {
		throw new NullPointerException("Given type reference was null");
	}
	
	public Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Parameter parameter) {
		Result result = visit(reference.getDelegate(), parameter);
		return result;
	}
	
	public Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, Parameter parameter) {
		Result result = visit(reference.getEquivalent(), parameter);
		return result;
	}
	
	public static class InheritanceAware<Parameter, Result> extends AbstractTypeReferenceVisitorWithParameter<Parameter, Result> {

		public Result doVisitTypeReference(JvmTypeReference reference, Parameter param) {
			throw new IllegalStateException("doVisitTypeReference was invoked but not implemented for: " + reference + " / " + param);
		}

		public Result doVisitAnyTypeReference(JvmAnyTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}

		public Result doVisitMultiTypeReference(JvmMultiTypeReference reference, Parameter param) {
			return doVisitCompoundTypeReference(reference, param);
		}

		public Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference, Parameter param) {
			return doVisitCompoundTypeReference(reference, param);
		}

		public Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference, Parameter param) {
			return doVisitTypeReference(reference, param);
		}
		
	}
}
