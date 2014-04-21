/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.imports;

import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.resource.XtextResource;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.summer.dsl.model.xtype.XImportDeclaration;
import org.summer.dsl.model.xtype.XImportSection1;

import com.google.inject.ImplementedBy;

/**
 * Language dependent configuration for the 'import' related things.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
@ImplementedBy(DefaultImportsConfiguration.class)
public interface IImportsConfiguration {

	XImportSection1 getImportSection(XtextResource resource);

	int getImportSectionOffset(XtextResource resource);

	Set<String> getImplicitlyImportedPackages(XtextResource resource);

	Iterable<JvmDeclaredType> getLocallyDefinedTypes(XtextResource resource);
	
	JvmDeclaredType getContextJvmDeclaredType(EObject model);
	
	/**
	 * Returns the syntax that was used in the import declaration if (and only if) it uses
	 * the legacy notation with a '$' as the delimiter for nested types. Otherwise the result 
	 * is null. Also returns null, if no node model is attached. 
	 */
	String getLegacyImportSyntax(XImportDeclaration importDeclaration);
}
