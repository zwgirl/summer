/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.types.impl;

import org.summer.dsl.model.types.JvmPrimitiveType;
import org.summer.dsl.model.types.JvmSpecializedTypeReference;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmVoid;
import org.summer.dsl.model.types.JvmWildcardTypeReference;
import org.summer.dsl.model.types.TypesPackage;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public abstract class JvmTypeConstraintImplCustom extends JvmTypeConstraintImpl {

	@Override
	public String getIdentifier() {
		if (typeReference != null) {
			return getTypeReference().getIdentifier();
		}
		return null;
	}
	
	@Override
	public final String getQualifiedName() {
		return getQualifiedName('$');
	}
	
	@Override
	public String getQualifiedName(char innerClassDelimiter) {
		if (typeReference != null) {
			return getTypeReference().getQualifiedName(innerClassDelimiter);
		}
		return null;
	}
	
	@Override
	public String getSimpleName() {
		if (typeReference != null) {
			return getTypeReference().getSimpleName();
		}
		return null;
	}
	
	@Override
	public void setTypeReference(JvmTypeReference newTypeReference) {
		if (newTypeReference instanceof JvmWildcardTypeReference)
			throw new IllegalArgumentException("wildcard type references are not supported as constraint bounds");
		if (!isLikelyAValidConstraintBound(newTypeReference))
			throw new IllegalArgumentException("primitive type references are not supported as constraint bounds");
		super.setTypeReference(newTypeReference);
	}
	
	public void internalSetTypeReference(JvmTypeReference newTypeReference) {
		super.setTypeReference(newTypeReference);
	}

	/**
	 * Constraint bounds are definitely invalid if they are <code>not null</code> and point to a primitive type.
	 * {@link JvmSpecializedTypeReference} will not be resolved by this check thus they may lead to finally 
	 * invalid constraint bounds.
	 * 
	 * @param constraintBound the reference that shall be come the new constraint.
	 * @return <code>false</code> if the given constraint is definitely invalid. 
	 */
	protected boolean isLikelyAValidConstraintBound(JvmTypeReference constraintBound) {
		if (constraintBound == null)
			return true;
		if (constraintBound instanceof JvmSpecializedTypeReference) {
			JvmTypeReference equivalent = (JvmTypeReference) constraintBound.eGet(TypesPackage.Literals.JVM_SPECIALIZED_TYPE_REFERENCE__EQUIVALENT, false);
			if (equivalent != null) {
				return isLikelyAValidConstraintBound(equivalent);
			}
			return true;
		}
		boolean invalid = (constraintBound.getType() instanceof JvmPrimitiveType 
					|| (constraintBound.getType() instanceof JvmVoid && !constraintBound.getType().eIsProxy()));
		return !invalid;
	}
	
	@Override
	public String toString() {
		if (typeReference != null) {
			return getTypeReference().toString();
		}
		return super.toString();
	}

} 
