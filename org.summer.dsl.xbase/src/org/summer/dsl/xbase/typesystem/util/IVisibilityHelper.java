/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import org.eclipse.jdt.annotation.NonNull;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmVisibility;

import com.google.inject.ImplementedBy;

/**
 * Determines whether a given {@link JvmFeature} is accessible according to the Java VM's 
 * visibility rules.
 * 
 * @see ContextualVisibilityHelper
 * @see PublicVisibilityHelper
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(PublicVisibilityHelper.class)
public interface IVisibilityHelper {

	/**
	 * Returns <code>true</code> if the member is visible according to the {@link JvmVisibility} and the local context.
	 * @param member the member that shall be accessed.
	 * @return <code>true</code> if the feature can be accessed.
	 */
	boolean isVisible(@NonNull JvmMember member);
	
	/**
	 * Treats all members as visible members independently from their own visibility or 
	 * the visibility of their containers. 
	 */
	IVisibilityHelper ALL = new IVisibilityHelper() {
		
		/**
		 * @return always <code>true</code>.
		 */
		public boolean isVisible(@NonNull JvmMember member) {
			return true;
		}
		
	};
	
}
