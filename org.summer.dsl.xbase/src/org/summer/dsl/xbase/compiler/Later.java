/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.compiler;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.summer.dsl.xbase.compiler.output.ITreeAppendable;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
@NonNullByDefault
public interface Later {
	void exec(ITreeAppendable appendable);
}
