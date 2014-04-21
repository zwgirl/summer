/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.override;

import java.util.EnumSet;

import org.summer.dsl.model.types.JvmOperation;

import com.google.common.collect.Sets;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LazyOverrideCheckResult implements IOverrideCheckResult {

	private AbstractResolvedOperation thisOperation;
	private JvmOperation givenOperation;
	private OverrideCheckDetails primaryDetail;
	private EnumSet<OverrideCheckDetails> details;
	
	protected static EnumSet<OverrideCheckDetails> overridingIfAnyOf = EnumSet.of(
			OverrideCheckDetails.OVERRIDE,
			OverrideCheckDetails.IMPLEMENTATION,
			OverrideCheckDetails.REDECLARATION,
			OverrideCheckDetails.REPEATED,
			OverrideCheckDetails.SHADOWED);
	
	protected static EnumSet<OverrideCheckDetails> problemIfAnyOf = EnumSet.of(
			OverrideCheckDetails.ARITY_MISMATCH,
			OverrideCheckDetails.EXCEPTION_MISMATCH,
			OverrideCheckDetails.IS_FINAL,
			OverrideCheckDetails.NAME_MISMATCH,
			OverrideCheckDetails.NO_INHERITANCE,
			OverrideCheckDetails.NOT_VISIBLE,
			OverrideCheckDetails.PARAMETER_TYPE_MISMATCH,
			OverrideCheckDetails.REDUCED_VISIBILITY,
			OverrideCheckDetails.RETURN_MISMATCH,
			OverrideCheckDetails.SAME_ERASURE,
			OverrideCheckDetails.STATIC_MISMATCH,
			OverrideCheckDetails.TYPE_PARAMETER_MISMATCH,
			OverrideCheckDetails.UNCHECKED_CONVERSION_REQUIRED,
			OverrideCheckDetails.VAR_ARG_MISMATCH);
	
	public LazyOverrideCheckResult(AbstractResolvedOperation thisOperation, JvmOperation givenOperation, OverrideCheckDetails detail) {
		this.thisOperation = thisOperation;
		this.givenOperation = givenOperation;
		this.primaryDetail = detail;
	}

	public boolean isOverridingOrImplementing() {
		return overridingIfAnyOf.contains(primaryDetail);
	}

	public boolean hasProblems() {
		if (!isOverridingOrImplementing()) {
			return true;
		}
		EnumSet<OverrideCheckDetails> details = getDetails();
		return !Sets.intersection(problemIfAnyOf, details).isEmpty();
	}

	public EnumSet<OverrideCheckDetails> getDetails() {
		if (details != null) {
			return details;
		}
		return details = getComputedDetails();
	}

	protected EnumSet<OverrideCheckDetails> getComputedDetails() {
		return thisOperation.getOverrideTester().getAllDetails(thisOperation, givenOperation, primaryDetail);
	}
	
	public IResolvedOperation getThisOperation() {
		return thisOperation;
	}

	public JvmOperation getGivenOperation() {
		return givenOperation;
	}
	
}
