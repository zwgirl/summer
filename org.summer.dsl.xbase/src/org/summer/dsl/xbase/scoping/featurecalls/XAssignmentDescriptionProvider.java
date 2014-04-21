/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.scoping.featurecalls;

import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.util.ITypeArgumentContext;
import org.eclipse.xtext.util.IAcceptor;

/**
 * Creates assignment feature descriptions for fields.
 * 
 * @author Sven Efftinge - Initial contribution and API
 */
@Deprecated
public class XAssignmentDescriptionProvider extends DefaultJvmFeatureDescriptionProvider {
	
	@Override
	public void addFeatureDescriptions(JvmFeature feature, ITypeArgumentContext context,
			IAcceptor<JvmFeatureDescription> acceptor) {
		if (feature instanceof JvmField) {
			super.addFeatureDescriptions(feature, context, acceptor);
		}
	}

}
