/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.typesystem.util;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * TODO JavaDoc
 */
public enum BoundTypeArgumentSource {
	/**
	 * <pre>
	 *  public &lt;T&gt; void method(List&lt;? extends T&gt; list) {
	 *    List&lt;String&gt; someList = ..
	 *    this.&lt;CharSequence&gt;method(someList);
	 *  }
	 * </pre>
	 */
	EXPLICIT,
	
	/**
	 * <pre>
	 *  public &lt;T extends CharSequence&gt; void method() {
	 *    this.method();
	 *  }
	 * </pre>
	 */
	CONSTRAINT,
	
	/**
	 * <pre>
	 *  CharIterable&lt;E extends CharSequence&gt; extends Iterable&lt;E&gt; {}
	 *  public &lt;T&gt; void method(CharIterable&lt;T&gt;) {
	 *    this.method();
	 *  }
	 * </pre>
	 */
	INFERRED_CONSTRAINT,
	
	/**
	 * <pre>
	 *    public &lt;T&gt; List&lt;T&gt; createList(T... elements) {}
	 *    
	 *    val list = createList() // list&lt;unbound/T&gt;
	 *    list.add('string') // bind T to String
	 * </pre>
	 */
	INFERRED_LATER,
	
	/**
	 * <pre>
	 *  public &lt;T extends CharSequence&gt; T method() {
	 *    String s = method();
	 *  }
	 * </pre>
	 */
	EXPECTATION,
	
	/**
	 * <pre>
	 *  public &lt;T&gt; void method(List&lt;T&gt; list) {
	 *    List&lt;String&gt; someList = ..
	 *    this.method(someList);
	 *  }
	 * </pre>
	 */
	INFERRED,
	
	/**
	 * <pre>
	 *  Used to indicate that a type argument was resolved
	 * </pre>
	 */
	RESOLVED
}
