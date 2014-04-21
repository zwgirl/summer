/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr.impl;

import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.IHiddenTokenHelper;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class AbstractHiddenTokenHelper implements IHiddenTokenHelper {

	@SuppressWarnings("deprecation")
	public AbstractRule getWhitespaceRuleFor(ParserRule context, String whitespace) {
		return getWhitespaceRuleFor(whitespace);
	}

}
