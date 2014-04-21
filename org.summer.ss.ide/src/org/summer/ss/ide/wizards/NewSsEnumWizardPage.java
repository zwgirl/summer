/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Holger Schill - Initial contribution and API
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 */
public class NewSsEnumWizardPage extends AbstractNewSsElementWizardPage {

	public NewSsEnumWizardPage() {
		super(ENUM_TYPE, NewSsEnumWizard.TITLE);
		this.setTitle(NewSsEnumWizard.TITLE);
		this.setDescription(Messages.XTEND_ENUM_WIZARD_DESCRIPTION);
	}

	public void createControl(Composite parent) {
		setControl(createCommonControls(parent));
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status = new IStatus[] { fContainerStatus, fPackageStatus, fTypeNameStatus};
		updateStatus(status);
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_ENUM;
	}

	@Override
	protected String getPackageDeclaration(String lineSeparator) {
		return SsTypeCreatorUtil.createPackageDeclaration(getTypeName(), getPackageFragment(), lineSeparator);
	}

	@Override
	protected String getTypeContent(String indentation, String lineSeparator) {
		return SsTypeCreatorUtil.createEnumContent(getTypeName(), indentation, lineSeparator);
	}

}
