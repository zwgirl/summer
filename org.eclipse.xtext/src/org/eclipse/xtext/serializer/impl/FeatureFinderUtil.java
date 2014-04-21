/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.serializer.impl;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.GrammarUtil;

/**
 * @author Sebastian Zarnekow - Moved from GrammarUtil
 */
public class FeatureFinderUtil {

	/**
	 * @since 2.0
	 */
	public static EStructuralFeature getFeature(AbstractElement grammarElement, EClass owner) {
		if (grammarElement == null)
			return null;
		String featureName = null;
		if (grammarElement instanceof Action)
			featureName = ((Action) grammarElement).getFeature();
		else {
			Assignment ass = GrammarUtil.containingAssignment(grammarElement);
			if (ass != null)
				featureName = ass.getFeature();
		}
		if (featureName != null)
			return owner.getEStructuralFeature(featureName);
		return null;
	}

}
