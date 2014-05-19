/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.computation;

import java.util.EnumSet;

import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XIfStatment;
import org.summer.dsl.xbase.typesystem.conformance.ConformanceHint;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;

/**
 * The result of the type computation for a given expression.
 * 
 * This result may be a lazy result, thus the real type is determined 
 * when {@link #getActualExpressionType()} or other properties are
 * queried.
 * 
 * A type computation result distinguishes between return types and actual
 * types for expressions.
 * 
 * Consider the following scenario:
 * <pre>
 *   val x = if (guard) return 'dummy' else 1
 * <pre>
 * 
 * The return type of the {@link XIfStatment if expression} is the 
 * type <code>Comparable&lt;?&gt; & Serializable</code> while the actual type
 * of the conditional expression is type <code>int</code>. The first branch 
 * of the condition will never complete normally thus its type is not 
 * considered for the local expression type computation.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public interface ITypeComputationResult {

	/**
	 * Returns the type of the expression (if known).
	 * May return <code>null</code>.
	 */
	@Nullable
	LightweightTypeReference getActualExpressionType();

	/**
	 * Returns the type of the expectation (if any).
	 * 
	 * TODO expose the {@link ITypeExpectation} instead which carries more information.
	 */
	@Nullable
	LightweightTypeReference getExpectedExpressionType();
	
	/**
	 * Returns the return type of the expression (if known).
	 * May return <code>null</code>. The return type is different 
	 * from the {@link #getActualExpressionType() actual type} since
	 * its value escapes the current context.
	 */
	@Nullable
	LightweightTypeReference getReturnType();
	
	/**
	 * Returns the type of the return expectation (if any).
	 * 
	 * TODO expose the {@link ITypeExpectation} instead which carries more information.
	 */
	@Nullable
	LightweightTypeReference getExpectedReturnType();
	
	/**
	 * The expression that is associated with this result.
	 */
	@Nullable
	XExpression getExpression();
	
	/**
	 * Conformance information about the actual expression type and
	 * the expectation.
	 */
	@NonNull
	EnumSet<ConformanceHint> getConformanceHints();
	
	/**
	 * Conformance information about the actual expression type and
	 * the expectation.
	 */
	@NonNull
	EnumSet<ConformanceHint> getCheckedConformanceHints();
	
}
