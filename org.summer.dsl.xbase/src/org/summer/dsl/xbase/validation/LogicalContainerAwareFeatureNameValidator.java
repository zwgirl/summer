/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.validation;

import org.eclipse.xtext.naming.QualifiedName;
import org.summer.dsl.xbase.scoping.batch.IFeatureNames;

/**
 * Logical container aware feature name validation.
 * {@link IFeatureNames#THIS this} and {@link IFeatureNames#SUPER super}
 * are disallowed. 
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class LogicalContainerAwareFeatureNameValidator extends FeatureNameValidator {

	@Override
	public boolean isDisallowedName(QualifiedName name) {
		return SUPER.equals(name) || THIS.equals(name);
	}
	
}
