/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.nodemodel.util;

import java.util.NoSuchElementException;

import org.eclipse.xtext.nodemodel.BidiIterator;

import com.google.common.collect.UnmodifiableIterator;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class EmptyBidiIterator<T> extends UnmodifiableIterator<T> implements BidiIterator<T> {

	private static EmptyBidiIterator<?> INSTANCE = new EmptyBidiIterator<Object>();
	
	@SuppressWarnings("unchecked")
	public static <T> BidiIterator<T> instance() {
		return (BidiIterator<T>) INSTANCE;
	}
	
	public boolean hasNext() {
		return false;
	}

	public T next() {
		throw new NoSuchElementException();
	}

	public boolean hasPrevious() {
		return false;
	}

	public T previous() {
		throw new NoSuchElementException();
	}

}
