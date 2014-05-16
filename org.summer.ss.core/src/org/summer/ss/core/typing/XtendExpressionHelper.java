/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.typing;

import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.xbase.util.XExpressionHelper;

/**
 * @author Sven Efftinge - Initial contribution and API
 */
public class XtendExpressionHelper extends XExpressionHelper {
	
	@Override
	public boolean hasSideEffects(XExpression expr) {
//		if (expr instanceof RichString) {
//			return false;
//		}
		return super.hasSideEffects(expr);
	}
}
