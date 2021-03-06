/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui.refactoring;

import org.eclipse.core.runtime.IPath;

/**
 * Implementations of this interface allow to redirect changes to files that have been moved by another
 * processor/participant within the same refactoring operation. This is extremely useful for participants of rename
 * resource and move resource refactorings, e.g. renaming package declarations after a file move.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public interface IChangeRedirector {

	IPath getRedirectedPath(IPath source);

	IChangeRedirector NULL = new IChangeRedirector() {

		public IPath getRedirectedPath(IPath source) {
			return source;
		}
	};

	/**
	 * Extension interface to hand an {@link IChangeRedirector} through to an
	 * {@link org.eclipse.xtext.ui.refactoring.impl.IRefactoringDocument.Provider}.
	 */
	interface Aware {
		IChangeRedirector getChangeRedirector();

		void setChangeRedirector(IChangeRedirector changeRedirector);
	}
}
