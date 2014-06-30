/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.core.resource;

import org.eclipse.emf.ecore.EObject;
import org.summer.ss.core.services.SsGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.summer.dsl.xbase.jvmmodel.JvmLocationInFileProvider;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Specialization of the {@link JvmLocationInFileProvider} that configures Xtend specific 
 * location nodes, e.g. the significant region of a constructor declaration is the
 * keyword 'new'.
 * @author Sebastian Zarnekow - Initial contribution and API
 */
@Singleton
public class SsLocationInFileProvider extends JvmLocationInFileProvider {

	@Inject
	private SsGrammarAccess grammarAccess;
	
	/**
	 * Considers the keyword 'new' of a constructor declaration to be the significant part.
	 */
	@Override
	protected boolean useKeyword(Keyword keyword, EObject context) {
		if (keyword == grammarAccess.getMemberAccess().getConstructorKeyword_2_2_2())
			return true;
		return super.useKeyword(keyword, context);
	}
	
}
