/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import java.util.List;
import java.util.Set;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmVisibility;
import org.eclipse.xtext.util.Strings;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class ContextualVisibilityHelper implements IVisibilityHelper {

	private LightweightTypeReference contextType;
	private JvmType rawContextType;
	private Set<String> superTypeNames;
	private IVisibilityHelper parent;
	private String packageName;

	public ContextualVisibilityHelper(IVisibilityHelper parent, LightweightTypeReference contextType) {
		this.parent = parent;
		this.contextType = contextType;
		this.rawContextType = contextType.getType();
		if (rawContextType instanceof JvmDeclaredType) {
			this.packageName = ((JvmDeclaredType) rawContextType).getPackageName();
		}
	}
	
	public ContextualVisibilityHelper(IVisibilityHelper parent, LightweightTypeReference contextType, String packageName) {
		this.parent = parent;
		this.contextType = contextType;
		this.rawContextType = contextType.getType();
		this.packageName = packageName;
	}
	
	public ContextualVisibilityHelper(LightweightTypeReference contextType) {
		this(new PublicVisibilityHelper(), contextType);
	}
	
	public LightweightTypeReference getContextType() {
		return contextType;
	}
	
	public JvmType getRawContextType() {
		return rawContextType;
	}
	
	public boolean isVisible(JvmMember member) {
		JvmVisibility visibility = member.getVisibility();
		if (visibility == JvmVisibility.PUBLIC) {
			return true;
		}
//		JvmDeclaredType type = member instanceof JvmDeclaredType ? (JvmDeclaredType) member : member.getDeclaringType();
//		if (type == rawContextType) {
//			return true;
//		}
//		if (type != null && visibility == JvmVisibility.PROTECTED) {
//			if (superTypeNames == null) {
//				List<LightweightTypeReference> superTypes = contextType.getRawTypeReference().getAllSuperTypes();
//				Set<String> superTypeNames = Sets.newHashSetWithExpectedSize(superTypes.size());
//				for(LightweightTypeReference superType: superTypes) {
//					superTypeNames.add(superType.getRawTypeReference().getIdentifier());
//				}
//				this.superTypeNames = superTypeNames;
//			}
//			if (superTypeNames.contains(type.getIdentifier())) {
//				return true;
//			}
//			if (type == member) {
//				JvmDeclaredType declaringType = member.getDeclaringType();
//				if (declaringType != null && superTypeNames.contains(declaringType.getIdentifier())) {
//					return true;
//				}
//			}
//		}
//		if (type != null && rawContextType instanceof JvmDeclaredType && (visibility == JvmVisibility.DEFAULT || visibility == JvmVisibility.PROTECTED)) {
//			if (Strings.isEmpty(packageName) && Strings.isEmpty(type.getPackageName())
//					|| (packageName != null && packageName.equals(type.getPackageName()))) {
//				return true;
//			}
//		}
		return parent.isVisible(member);
	}
	
}
