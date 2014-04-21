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
public interface ITypeReferenceVisitorWithParameter<Parameter, Result> {

	Result visit(JvmTypeReference reference, Parameter param);
	
	Result doVisitTypeReference(JvmTypeReference reference, Parameter param);
	Result doVisitAnyTypeReference(JvmAnyTypeReference reference, Parameter param);
	Result doVisitCompoundTypeReference(JvmCompoundTypeReference reference, Parameter param);
	Result doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference, Parameter param);
	Result doVisitGenericArrayTypeReference(JvmGenericArrayTypeReference reference, Parameter param);
	Result doVisitWildcardTypeReference(JvmWildcardTypeReference reference, Parameter param);
	Result doVisitMultiTypeReference(JvmMultiTypeReference reference, Parameter param);
	Result doVisitSynonymTypeReference(JvmSynonymTypeReference reference, Parameter param);
	Result doVisitDelegateTypeReference(JvmDelegateTypeReference reference, Parameter param);
	Result doVisitUnknownTypeReference(JvmUnknownTypeReference reference, Parameter param);
	Result doVisitSpecializedTypeReference(JvmSpecializedTypeReference reference, Parameter param);
	
}
