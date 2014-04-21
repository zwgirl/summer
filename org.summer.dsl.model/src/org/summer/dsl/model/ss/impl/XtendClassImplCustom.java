/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ss.impl;

import static org.eclipse.xtext.util.Strings.*;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendClassImplCustom extends XtendClassImpl {
	
	@Override
	public boolean isAbstract() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "abstract")) 
				return true;
			if(equal(modifier, "final")) 
				return false;
		}
		return false;
	}

}
