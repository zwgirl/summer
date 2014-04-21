/*******************************************************************************
 * Copyright (c) 2008, 2009 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.conversion;

import org.eclipse.xtext.nodemodel.INode;

/**
 * @author Sven Efftinge - Initial contribution and API
 *
 */
public interface IValueConverterService {
	
	/**
	 * @see org.eclipse.xtext.nodemodel.util.NodeModelUtils#getTokenText(INode)
	 */
	Object toValue(String string, String lexerRule, INode node) throws ValueConverterException;

	String toString(Object value, String lexerRule);

}
