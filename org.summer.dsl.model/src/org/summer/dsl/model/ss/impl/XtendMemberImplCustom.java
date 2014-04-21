/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.model.ss.impl;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.emf.common.util.EList;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.model.xannotation.XAnnotation;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class XtendMemberImplCustom extends XtendMemberImpl {

	@Override
	public EList<XAnnotation> getAnnotations() {
		if (getAnnotationInfo()!=null) {
			return getAnnotationInfo().getAnnotations();
		}
		return super.getAnnotations();
	}
	
	@Override
	public boolean isFinal() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "abstract")) 
				return false;
			if(equal(modifier, "final")) 
				return true;
		}
		return false;
	}

	@Override
	public boolean isStatic() {
		for(String modifier: getModifiers()) { 
			if(equal(modifier, "static")) 
				return true;
		}
		return false;
	}
	
	protected JvmVisibility getDefaultVisibility() {
		return JvmVisibility.PUBLIC;
	}
	
	@Override
	public JvmVisibility getDeclaredVisibility() {
		for(String modifier: getModifiers()) {
			if(equal(modifier, "public")) 
				return JvmVisibility.PUBLIC;
//			if(equal(modifier, "package"))   //cym comment
//				return JvmVisibility.DEFAULT;
//			if(equal(modifier, "protected")) 
//				return JvmVisibility.PROTECTED;
			if(equal(modifier, "private")) 
				return JvmVisibility.PRIVATE;
		}
		return null;
	}
	
	@Override
	public JvmVisibility getVisibility() {
		JvmVisibility declaredVisibility = getDeclaredVisibility();
		return declaredVisibility == null ? getDefaultVisibility() : declaredVisibility;
	}
}
