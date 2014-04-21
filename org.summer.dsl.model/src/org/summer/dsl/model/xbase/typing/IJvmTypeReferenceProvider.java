/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.xbase.typing;

import org.eclipse.jdt.annotation.NonNull;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.xtype.impl.XComputedTypeReferenceImplCustom;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface IJvmTypeReferenceProvider {

	JvmTypeReference getTypeReference(@NonNull XComputedTypeReferenceImplCustom context);
	
}
