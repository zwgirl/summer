/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.arguments;

import java.util.Collections;
import java.util.List;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class StandardFeatureCallArgumentSlot implements IFeatureCallArgumentSlot {

	protected final StandardFeatureCallArguments parent;
	protected final int idx;

	protected StandardFeatureCallArgumentSlot(StandardFeatureCallArguments parent, int idx) {
		this.parent = parent;
		this.idx = idx;
	}
	
	public boolean isVarArg() {
		return false;
	}

	public boolean isSuperfluous() {
		return false;
	}

	public List<XExpression> getArgumentExpressions() {
		return Collections.singletonList(getArgumentExpression());
	}

	@Nullable
	public XExpression getArgumentExpression() {
		return parent.internalGetArgument(idx);
	}

	@Nullable
	public LightweightTypeReference getDeclaredType() {
		return parent.internalGetParameterType(idx);
	}

	public void markProcessed() {
		parent.markProcessed(idx);
	}
	
	@Override
	public String toString() {
		return String.format("%s @ %d for %s", getClass().getSimpleName(), idx, getArgumentExpressions());
	}

}
