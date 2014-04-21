/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreAccess;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringPreferences;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsRefactoringPreferences extends RefactoringPreferences {
	
	public static class Initializer implements IPreferenceStoreInitializer {
		public void initialize(IPreferenceStoreAccess access) {
			access.getWritablePreferenceStore().setDefault(SAVE_ALL_BEFORE_REFACTORING, true);
			access.getWritablePreferenceStore().setDefault(USE_INLINE_REFACTORING, true);
		}
	}
}
