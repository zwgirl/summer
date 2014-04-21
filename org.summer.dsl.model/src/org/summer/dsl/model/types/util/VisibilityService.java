/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.util;

import static org.eclipse.xtext.util.Strings.*;

import java.util.Set;

import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.types.TypesFactory;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * @author Sven Efftinge - Initial contribution and API
 * @author Jan Koehnlein
 */
@Singleton
@Deprecated
public class VisibilityService {

	@Inject
	private SuperTypeCollector superTypeCollector;

	@Inject
	private TypesFactory typesFactory;

	public void setSuperTypeCollector(SuperTypeCollector superTypeCollector) {
		this.superTypeCollector = superTypeCollector;
	}

	public void setTypesFactory(TypesFactory typesFactory) {
		this.typesFactory = typesFactory;
	}

	//cym comment
//	public boolean isVisible(final JvmMember jvmMember, JvmDeclaredType contextType) {
//		if (jvmMember.getVisibility() == JvmVisibility.PUBLIC)
//			return true;
//		if (contextType == null) {
//			return false;
//		} else if (jvmMember.getVisibility() == JvmVisibility.DEFAULT) {
//			if (jvmMember instanceof JvmDeclaredType) {
//				return equal(((JvmDeclaredType) jvmMember).getPackageName(), contextType.getPackageName());
//			} else {
//				JvmDeclaredType declaringType = jvmMember.getDeclaringType();
//				if (declaringType != null)
//					return equal(declaringType.getPackageName(), contextType.getPackageName());
//				return true;
//			}
//		} else if (contextType.equals(jvmMember.getDeclaringType())) {
//			return true;
//		} else {
//			JvmParameterizedTypeReference typeReference = typesFactory.createJvmParameterizedTypeReference();
//			typeReference.setType(contextType);
//			Set<JvmType> rawTypes = superTypeCollector.collectSuperTypesAsRawTypes(typeReference);
//			if (rawTypes.contains(jvmMember.getDeclaringType())) {
//				return jvmMember.getVisibility() == JvmVisibility.PROTECTED;
//			}
//			return false;
//		}
//	}
	
	public boolean isVisible(final JvmMember jvmMember, JvmDeclaredType contextType) {
		if (jvmMember.getVisibility() == JvmVisibility.PUBLIC)
			return true;
		
		return false;
	}
}
