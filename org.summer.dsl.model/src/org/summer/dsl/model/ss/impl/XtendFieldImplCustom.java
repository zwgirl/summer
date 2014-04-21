/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ss.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.summer.dsl.model.ss.XtendAnnotationType;
import org.summer.dsl.model.ss.XtendInterface;
import org.summer.dsl.model.types.JvmVisibility;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendFieldImplCustom extends XtendFieldImpl {

	@Override
	public boolean isExtension() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "extension")) 
				return true;
		}
		return false;
	}

	@Override
	protected JvmVisibility getDefaultVisibility() {
		if(getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType)
			return JvmVisibility.PUBLIC;
		else 
			return JvmVisibility.PRIVATE;
	}
	
	@Override
	public boolean isFinal() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "var")) 
				return false;
			if(equal(modifier, "val") || equal(modifier, "final")) 
				return true;
		}
		return getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType;
	}
	
	@Override
	public boolean isStatic() {
		return super.isStatic() ? true 
				: getDeclaringType() instanceof XtendInterface || getDeclaringType() instanceof XtendAnnotationType;
	}
}
