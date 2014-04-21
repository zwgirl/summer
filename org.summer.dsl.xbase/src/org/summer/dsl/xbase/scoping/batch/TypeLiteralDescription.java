/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class TypeLiteralDescription extends SimpleIdentifiableElementDescription {

	private final boolean visible;
	private final LightweightTypeReference enclosingType;

	public TypeLiteralDescription(IEObjectDescription delegate, boolean visible) {
		super(delegate);
		this.visible = visible;
		this.enclosingType = null;
	}
	
	public TypeLiteralDescription(IEObjectDescription delegate, LightweightTypeReference enclosingType, boolean visible) {
		super(delegate);
		this.visible = visible;
		this.enclosingType = enclosingType;
	}
	
	@Override
	public boolean isVisible() {
		return visible;
	}
	
	@Override
	public boolean isTypeLiteral() {
		return true;
	}
	
	@Override
	@Nullable
	public LightweightTypeReference getSyntacticReceiverType() {
		return enclosingType;
	}
	
}
