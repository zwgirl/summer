/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.resource;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;

import com.google.common.annotations.Beta;

/**
 * Implementations of {@link ISynchronizable} expose a lock object
 * that allows to guard against concurrent modifications. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 * @since 2.4
 */
@Beta
@NonNullByDefault
public interface ISynchronizable<Synchronizable> {

	/**
	 * Exposes the coarse grained lock for this {@link ISynchronizable}.
	 * @return the lock instance.
	 */
	Object getLock();
	
	/**
	 * Execute the unit of work in a context that allows for modification.
	 * @param unit the action to perform. May not be <code>null</code>
	 * @exception Exception the exception that was thrown by the unit.
	 */
	@Nullable
	<Result> Result execute(IUnitOfWork<Result, ? super Synchronizable> unit) throws Exception;
	
}
