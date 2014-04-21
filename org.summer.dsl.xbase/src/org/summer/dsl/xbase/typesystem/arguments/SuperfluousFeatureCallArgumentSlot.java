/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.arguments;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class SuperfluousFeatureCallArgumentSlot extends StandardFeatureCallArgumentSlot {

	protected SuperfluousFeatureCallArgumentSlot(StandardFeatureCallArguments arguments, int idx) {
		super(arguments, idx);
	}
	
	@Override
	public boolean isSuperfluous() {
		return true;
	}

	@Override
	public LightweightTypeReference getDeclaredType() {
		throw new IllegalStateException();
	}

}
