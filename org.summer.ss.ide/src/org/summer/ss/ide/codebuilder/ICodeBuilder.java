/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.codebuilder;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.core.IType;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.types.JvmVisibility;
import org.summer.dsl.xbase.compiler.IAppendable;
import org.summer.dsl.xbase.compiler.ISourceAppender;

/**
 * Common interface to generate Java or Xtend code into an {@link IAppendable}.
 * Use {@link CodeBuilderFactory} to obtain an instance.
 * 
 * @author Sebastian Benz - Inspiration
 * @author Jan Koehnlein - Initial contribution and API
 */
@NonNullByDefault
public interface ICodeBuilder {

	ISourceAppender build(ISourceAppender appendable);

	String getPreview();
	
	String getImage();
	
	Object getOwnerSource();
	
	JvmDeclaredType getOwner();
	
	JvmVisibility getVisibility();
	
	boolean isValid();
	
	interface Xtend extends ICodeBuilder {
		JvmDeclaredType getXtendType();
		
		int getInsertOffset();
		
		int getIndentationLevel();
	}
	
	interface Java extends ICodeBuilder {
		IType getIType();
	}

}
