/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.imports;

import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmMember;
import org.eclipse.xtext.util.ITextRegion;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class TypeUsage {
	private JvmDeclaredType usedType;
	private String usedTypeName;
	private String suffix;
	private ITextRegion textRegion;
	private JvmMember context;

	public TypeUsage(JvmDeclaredType usedType, String suffix, ITextRegion textRegion, JvmMember context) {
		this.usedType = usedType;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = suffix;
	}
	
	public TypeUsage(JvmDeclaredType usedType, ITextRegion textRegion, JvmMember context) {
		this.usedType = usedType;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = "";
	}
	
	public TypeUsage(String usedTypeName, String suffix, ITextRegion textRegion, JvmMember context) {
		this.usedTypeName = usedTypeName;
		this.textRegion = textRegion;
		this.context = context;
		this.suffix = suffix;
	}
	
	public JvmDeclaredType getUsedType() {
		return usedType;
	}
	
	public String getUsedTypeName() {
		return usedTypeName;
	}
	
	public String getSuffix() {
		return suffix;
	}
	
	public ITextRegion getTextRegion() {
		return textRegion;
	}
	
	public JvmMember getContext() {
		return context;
	}

	public String getContextPackageName() {
		return getPackageName(context);
	}
	
	protected String getPackageName(JvmMember context) {
		if(context.getDeclaringType() != null)
			return getPackageName(context.getDeclaringType());
		if(context instanceof JvmDeclaredType) 
			return ((JvmDeclaredType)context).getPackageName();
		else  
			return null;
	}


}