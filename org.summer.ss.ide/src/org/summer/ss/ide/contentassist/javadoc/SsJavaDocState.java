/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.contentassist.javadoc;

import org.summer.dsl.model.types.xtext.ui.ITypesProposalProvider;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;

/**
 * @author Holger Schill - Initial contribution and API
 */
public interface SsJavaDocState {

	public IScopeProvider getScopeProvider();

	public ContentAssistContext.Factory getContextFactory();

	public ITypesProposalProvider getTypesProposalProvider();

	public SsJavaDocProposalFactory getProposalFactory();

}
