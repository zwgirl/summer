/*******************************************************************************
 * Copyright (c) 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.parsetree.reconstr;

import java.io.IOException;

import org.eclipse.emf.ecore.EObject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public interface ITokenStream {

	void flush() throws IOException;

	void writeHidden(EObject grammarElement, String value) throws IOException;

	void writeSemantic(EObject grammarElement, String value) throws IOException;
}