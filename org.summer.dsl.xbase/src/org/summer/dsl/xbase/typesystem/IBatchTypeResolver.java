/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.eclipse.xtext.scoping.IScope;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.typesystem.internal.CachingBatchTypeResolver;

import com.google.inject.ImplementedBy;

/**
 * The {@link IBatchTypeResolver batch type resolver} is the entry point for clients
 * to obtain the expression types within a given context {@link EObject object}.
 * 
 * The context is most likely an {@link XExpression expression} or a 
 * {@link JvmIdentifiableElement logical container} but the interface does not impose
 * any restriction on this one.
 * 
 * The obtained instance of {@link IResolvedTypes resolved types} does not make any promises
 * with respect to eager resolution or laziness, but answers all queries for types
 * that are related to the context that was used to get the resolved types itself.
 * 
 * Generally speaking, all expressions within the very same resource can be used
 * to query the {@link IResolvedTypes types}.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@ImplementedBy(CachingBatchTypeResolver.class)
public interface IBatchTypeResolver {

	/**
	 * Return a handle to resolved types of expressions that are related
	 * to the given {@code object}.
	 * 
	 * @param object the context that describes the expressions that will be used
	 * to query the resolved types.
	 * @return a handle to resolved types of expressions and identifiables.
	 */
	@NonNull
	IResolvedTypes resolveTypes(@Nullable EObject object);
	
	/**
	 * Returns an intermitted instance of resolved types that carries the
	 * potentially specialized type information in the context of the given
	 * instance. This may be an instance of resolved types that yields
	 * the type {@link CharSequence} for the {@link JvmIdentifiableElement identifiable}
	 * {@code o} at the cursor position {@code |} when queried with the {@link XCasePart}:
	 * 
	 * <pre>
	 * switch o: getObject() {
	 *   CharSequence: |
	 * }
	 * </pre>
	 * @param context the expression or {@link XCasePart case part} that specified the current context. 
	 */
	@NonNull
	IResolvedTypes getResolvedTypesInContextOf(@Nullable EObject context);
	
	/**
	 * Returns the currently visible features in the given context.
	 */
	@NonNull
	IScope getFeatureScope(@Nullable XAbstractFeatureCall featureCall);
	
}
