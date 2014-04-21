/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.quickfix;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Tuples;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeNameGuesser {

	public Pair<String, String> guessPackageAndTypeName(EObject context, String featureCallOrType) {
		String[] simpleNames = featureCallOrType.split("(\\.|::|\\$)");
		StringBuilder pack = new StringBuilder();
		boolean isFirst = true;
		for(String simpleName: simpleNames) {
			if(simpleName.length() > 1 && Character.isUpperCase(simpleName.charAt(0))) {
				return Tuples.create(pack.toString(), simpleName);
			}
			if(!isFirst)
				pack.append(".");
			isFirst = false;
			pack.append(simpleName);
		}
		return Tuples.create(pack.toString(), "");
	}
}
