/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.lib;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;

/**
 * Whether the constructor or method causes any side-effects to
 * non-local state.
 * 
 * On {@link Inline}d methods this is means the compiler cannot 
 * use the resulting Java expression as a statement. 
 *  
 * @author Sven Efftinge - Initial contribution and API
 * 
 * @since 2.3
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({
    ElementType.CONSTRUCTOR,
    ElementType.METHOD})
@Documented
@Beta
@GwtCompatible public @interface Pure {

}
