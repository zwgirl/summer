/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.ui.codetemplates.ui.preferences;

import org.eclipse.osgi.util.NLS;

public class TemplateDialogMessages extends NLS {

	private static final String BUNDLE_NAME= "org.summer.dsl.ui.codetemplates.ui.preferences.TemplateDialogMessages";//$NON-NLS-1$

	private TemplateDialogMessages() {
		// Do not instantiate
	}
	
	static {
		NLS.initializeMessages(BUNDLE_NAME, TemplateDialogMessages.class);
	}
	
	public static String EditTemplateDialog_title_new;
	public static String EditTemplateDialog_title_edit;
	public static String EditTemplateDialog_name;
	public static String EditTemplateDialog_description;
	public static String EditTemplateDialog_context;
	public static String EditTemplateDialog_pattern;
	public static String EditTemplateDialog_insert_variable;
	public static String EditTemplateDialog_autoinsert;
}
