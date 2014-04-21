/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;

/**
 * Exposes additional information about the linked feature if the to-be-linked
 * instance is an {@link XAbstractFeatureCall}.
 * A feature call an be linked to a {@link #isStatic() static} {@link JvmFeature feature},
 * it can be an {@link #isExtension() extension}, or a {@link #isTypeLiteral() type literal}. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public interface IFeatureLinkingCandidate extends ILinkingCandidate {

	/**
	 * Returns the feature call that is linked.
	 * @return the feature call.
	 */
	XAbstractFeatureCall getFeatureCall();

	/**
	 * Returns <code>true</code> if the the linked feature is static.
	 * @return whether the feature is static.
	 */
	boolean isStatic();
	
	/**
	 * Returns <code>true</code> if the the linked feature is contributed
	 * by an extension.
	 * @return whether the feature is extension.
	 */
	boolean isExtension();
	
	/**
	 * Returns <code>true</code> if the the feature call is linked as a type literal.
	 * @return whether the feature call is a type literal rather than a <em>real</em> feature call.
	 */
	boolean isTypeLiteral();
	
}
