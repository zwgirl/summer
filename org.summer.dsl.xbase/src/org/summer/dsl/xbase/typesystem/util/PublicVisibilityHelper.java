/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

import org.eclipse.jdt.annotation.NonNull;
import org.summer.dsl.model.types.JvmMember;
import org.summer.dsl.model.types.JvmVisibility;

/**
 * Context independent treatment of visibility computation. 
 * A feature is considered to be visible if it is public
 * 
 * TODO: consider the declarator
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class PublicVisibilityHelper implements IVisibilityHelper {

	public boolean isVisible(@NonNull JvmMember member) {
		return member.getVisibility() == JvmVisibility.PUBLIC;
	}
	
}
