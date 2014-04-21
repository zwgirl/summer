/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.formatting.impl;

import java.io.IOException;

import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.parsetree.reconstr.ITokenStream;
import org.eclipse.xtext.parsetree.reconstr.ITokenStreamExtension;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public abstract class BaseTokenStream extends AbstractTokenStream {
	protected ITokenStream out;

	protected BaseTokenStream(ITokenStream out) {
		super();
		this.out = out;
	}

	@Override
	public void flush() throws IOException {
		out.flush();
	}

	@Override
	public void init(ParserRule startRule) {
		if (out instanceof ITokenStreamExtension)
			((ITokenStreamExtension) out).init(startRule);
	}
}