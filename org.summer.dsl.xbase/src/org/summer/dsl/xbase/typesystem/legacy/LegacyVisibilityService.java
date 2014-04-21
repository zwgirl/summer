/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.legacy;

import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.util.VisibilityService;
import org.summer.dsl.xbase.typesystem.references.ParameterizedTypeReference;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;
import org.summer.dsl.xbase.typesystem.util.ContextualVisibilityHelper;
import org.summer.dsl.xbase.typesystem.util.IVisibilityHelper;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@SuppressWarnings("deprecation")
@Singleton
@Deprecated
public class LegacyVisibilityService extends VisibilityService {

	@Inject 
	private CommonTypeComputationServices services;
	
	@Inject
	private IVisibilityHelper helper;
	
	@Override
	public boolean isVisible(JvmMember member, JvmDeclaredType contextType) {
		if(member.eIsProxy())
			return true;
		if (contextType == null || member.eResource() == null || member.eResource().getResourceSet() == null) {
			return helper.isVisible(member);
		}
		StandardTypeReferenceOwner owner = new StandardTypeReferenceOwner(services, member.eResource().getResourceSet());
		ParameterizedTypeReference contextTypeReference = new ParameterizedTypeReference(owner, contextType);
		ContextualVisibilityHelper contextualVisibilityHelper = new ContextualVisibilityHelper(helper, contextTypeReference);
		return contextualVisibilityHelper.isVisible(member);
	}
	
}
