/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.override;

import java.util.Collections;
import java.util.EnumSet;
import java.util.Map;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmTypeParameter;
import org.summer.dsl.xbase.typesystem.override.IOverrideCheckResult.OverrideCheckDetails;
import org.summer.dsl.xbase.typesystem.references.LightweightMergedBoundTypeArgument;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.util.DeclaratorTypeArgumentCollector;

/**
 * Resolved bottom representation of a {@link JvmOperation}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@NonNullByDefault
public class BottomResolvedOperation extends AbstractResolvedOperation {
	
	private Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> typeParameterMapping;
	private OverrideTester overrideTester;
	
	public BottomResolvedOperation(JvmOperation declaration, LightweightTypeReference contextType, OverrideTester overrideTester) {
		super(declaration, contextType);
		this.overrideTester = overrideTester;
	}
	
	public boolean isBottomInContext() {
		return true;
	}

	public IResolvedOperation getAsBottom() {
		return this;
	}

	@Override
	protected BottomResolvedOperation getBottom() {
		return this;
	}

	@Override
	protected Map<JvmTypeParameter, LightweightMergedBoundTypeArgument> getContextTypeParameterMapping() {
		if (typeParameterMapping != null)
			return typeParameterMapping;
		return typeParameterMapping = Collections.unmodifiableMap(new DeclaratorTypeArgumentCollector().getTypeParameterMapping(getContextType()));
	}
	
	@Override
	protected OverrideTester getOverrideTester() {
		return overrideTester;
	}
	
	public IOverrideCheckResult getOverrideCheckResult() {
		return new LazyOverrideCheckResult(this, getDeclaration(), OverrideCheckDetails.CURRENT) {
			@Override
			public boolean hasProblems() {
				return false;
			}
			@Override
			public EnumSet<OverrideCheckDetails> getDetails() {
				return EnumSet.of(OverrideCheckDetails.CURRENT);
			}
		};
	}
}
