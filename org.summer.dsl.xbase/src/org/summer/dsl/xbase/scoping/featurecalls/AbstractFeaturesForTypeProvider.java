/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.featurecalls;

import org.summer.dsl.model.types.JvmTypeConstraint;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.JvmUpperBound;
import org.summer.dsl.model.types.util.IRawTypeHelper;
import org.summer.dsl.model.types.util.TypeConformanceComputer;
import org.summer.dsl.model.types.util.TypeReferences;

import com.google.inject.Inject;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public abstract class AbstractFeaturesForTypeProvider implements IFeaturesForTypeProvider {

	@Inject
	private TypeConformanceComputer typeConformanceComputer;

	@Inject
	private TypeReferences typeReferences;
	
	@Inject
	private IRawTypeHelper rawTypeHelper;
	
	/**
	 * Returns <code>true</code> if the the first reference points to the same rawtype as the second
	 * reference's erasure. In other words, the method returns <code>true</code> for the following cases:
	 * <pre>
	 * isSameTypeOrAssignableToUpperBound(String, String)
	 * isSameTypeOrAssignableToUpperBound(String, T extends String)
	 * </pre>
	 * and <code>false</code> for
	 * <pre>
	 * isSameTypeOrAssignableToUpperBound(CharSequence, String)
	 * isSameTypeOrAssignableToUpperBound(Object, String)
	 * </pre>
	 * 
	 */
	protected boolean isSameTypeOrAssignableToUpperBound(JvmTypeReference first, JvmTypeReference second) {
		if (second == null)
			return false;
		if (second.getType() == first.getType()) { // TODO: use #getRawType, handle multi types
			return true;
		}
		if (second.getType() instanceof JvmTypeParameter) {
			boolean upperBoundSeen = false;
			for (JvmTypeConstraint constraint : ((JvmTypeParameter) second.getType()).getConstraints()) {
				if (constraint instanceof JvmUpperBound) {
					upperBoundSeen = true;
					if (isSameTypeOrAssignableToUpperBound(first, constraint.getTypeReference()))
						return true;
				}
			}
			if (!upperBoundSeen) {
				if (typeReferences.is(first, Object.class)) {
					return true;
				}
			}
		}
		return false;
	}
	
	protected TypeConformanceComputer getTypeConformanceComputer() {
		return typeConformanceComputer;
	}
	
	protected TypeReferences getTypeReferences() {
		return typeReferences;
	}
	
	protected IRawTypeHelper getRawTypeHelper() {
		return rawTypeHelper;
	}
	
	@Override
	public String toString() {
		return getClass().getSimpleName();
	}
}

