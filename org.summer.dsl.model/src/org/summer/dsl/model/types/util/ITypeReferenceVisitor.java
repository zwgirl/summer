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
public interface ITypeReferenceVisitor<Result> {

	Result visit(JvmTypeReference reference);
	
	Result doVisitTypeReference(JvmTypeReference reference);
	Result doVisitAnyTypeReference(JvmAnyTypeReference reference);
	Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference);
	Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference);
	Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference);
	Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference);
	Result doVisitMultiTypeReference(JvmMultiTypeReference reference);
	Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference);
	Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference);
	Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference);
	Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference);
	
}
