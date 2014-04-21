/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.batch;

import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class SuperConstructorDescription extends ConstructorDescription {

	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;

	public SuperConstructorDescription(
			QualifiedName qualifiedName, 
			JvmConstructor constructor,
			Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping,
			int bucketId, 
			boolean visible) {
		super(qualifiedName, constructor, bucketId, visible);
		this.typeParameterMapping = typeParameterMapping;
	}
	
	@Override
	public Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getImplicitReceiverTypeParameterMapping() {
		return typeParameterMapping;
	}

}
