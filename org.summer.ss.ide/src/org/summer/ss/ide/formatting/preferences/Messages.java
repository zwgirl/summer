/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.formatting.preferences;

import org.eclipse.osgi.util.NLS;

/**
 * @author Dennis Huebner - Initial contribution and API
 */
public class Messages extends NLS {
	private static final String BUNDLE_NAME = "org.summer.ss.ide.formatting.preferences.messages"; //$NON-NLS-1$
	public static String AbstractProfileManager_unmanaged_profile_with_name;
	public static String AbstractProfileManager_unmanaged_profile;
	public static String FormatterConfigurationBlock_DefaultProfileLabel;
	public static String FormatterConfigurationBlock_XtendCodePreview;
	static {
		// initialize resource bundle
		NLS.initializeMessages(BUNDLE_NAME, Messages.class);
	}

	private Messages() {
	}
}
