/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.formatting.preferences;

import org.eclipse.jdt.internal.ui.preferences.formatter.IProfileVersioner;
import org.eclipse.jdt.internal.ui.preferences.formatter.ProfileManager.CustomProfile;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class FormatterProfileVersioner implements IProfileVersioner {
	public static String PREFIX = "org.eclipse.xtend.formatter";

	public static String VERSION_KEY = ".version";

	public int getFirstVersion() {
		return 1;
	}

	public int getCurrentVersion() {
		return 1;
	}

	public String getProfileKind() {
		return FormatterProfileStore.XTEND_PROFILES_KEY;
	}

	public void update(CustomProfile profile) {
		//Nothing to do
	}

}
