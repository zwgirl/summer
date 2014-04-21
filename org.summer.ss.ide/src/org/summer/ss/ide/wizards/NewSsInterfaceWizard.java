/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.wizards;

import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;

import com.google.inject.Inject;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class NewSsInterfaceWizard extends AbstractNewSsElementWizard {

	public static final String TITLE = "Xtend Interface"; //$NON-NLS-1$

	@Inject
	public NewSsInterfaceWizard(IImageDescriptorHelper imgHelper, NewSsInterfaceWizardPage page) {
		super(imgHelper, page, TITLE);
	}



}
