/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.quickfix;

import org.eclipse.jdt.core.JavaModelException;
import org.eclipse.jdt.core.search.IJavaSearchScope;
import org.summer.dsl.model.types.JvmDeclaredType;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionAcceptor;
import org.eclipse.xtext.util.IAcceptor;
import org.eclipse.xtext.validation.Issue;
import org.summer.dsl.model.xtype.XImportSection;
import org.summer.dsl.model.xtype.XImportSection1;

/**
 * Quickfixes for misspelled Java types. For languages that don't use an {@link org.eclipse.xtext.xtype.XImportSection}.
 * All others should use {@link JavaTypeQuickfixes} to get quickfixes for imports.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class JavaTypeQuickfixesNoImportSection extends JavaTypeQuickfixes {
	
	@Override
	protected void createImportProposals(JvmDeclaredType contextType, Issue issue, String typeSimpleName,
			IJavaSearchScope searchScope, IssueResolutionAcceptor acceptor) throws JavaModelException {
	}

	@Override
	protected void parseImportSection(XImportSection1 importSection, IAcceptor<String> visiblePackages,
			IAcceptor<String> importedTypes) {
	}
}
