/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.arguments

import java.util.List
import org.eclipse.jdt.annotation.NonNullByDefault
import org.summer.dsl.model.xbase.XExpression
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference
import org.eclipse.jdt.annotation.Nullable

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
@NonNullByDefault
interface IFeatureCallArguments {
	
	def boolean hasUnprocessedArguments()
	
	def org.summer.dsl.xbase.typesystem.arguments.IFeatureCallArgumentSlot getNextUnprocessedArgumentSlot()
	
	@Nullable
	def XExpression getArgument(int idx)
	
	def int getArgumentCount()
	
	def boolean isProcessed(int argumentIndex)
	
}

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @noextend This interface is not intended to be extended by clients.
 * @noimplement This interface is not intended to be implemented by clients.
 */
@NonNullByDefault
interface IFeatureCallArgumentSlot {
	
	def boolean isVarArg()
	
	def boolean isSuperfluous()
	
	/**
	 * The list of expressions. The list is never <code>null</code> but may contain
	 * <code>null</code> entries.
	 */
	def List<XExpression> getArgumentExpressions()

	/**
	 * @throws IllegalStateException iff {@link #isVarArg} and the number of arguments is not equal to '1'.
	 */
	@Nullable
	def XExpression getArgumentExpression()
	
	/**
	 * @throws IllegalStateException iff {@link #isSuperfluous}
	 */
	@Nullable
	def LightweightTypeReference getDeclaredType()
	
	def void markProcessed()
	
}