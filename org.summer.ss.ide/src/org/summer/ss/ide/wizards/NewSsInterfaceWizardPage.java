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
public class NewSsInterfaceWizardPage extends AbstractNewSsElementWizardPage {

	public NewSsInterfaceWizardPage() {
		super(INTERFACE_TYPE, NewSsInterfaceWizard.TITLE);
		this.setTitle(NewSsInterfaceWizard.TITLE);
		this.setDescription(Messages.XTEND_INTERFACE_WIZARD_DESCRIPTION);
	}

	public void createControl(Composite parent) {
		Composite composite = createCommonControls(parent);
		createSuperInterfacesControls(composite, COLS);
		setControl(composite);
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status = new IStatus[] { fContainerStatus, fPackageStatus, fTypeNameStatus, fSuperInterfacesStatus };
		updateStatus(status);
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_INTERFACE;
	}

	@Override
	protected String getPackageDeclaration(String lineSeparator) {
		return SsTypeCreatorUtil.createPackageDeclaration(getTypeName(), getPackageFragment(), getSuperInterfaces(), lineSeparator);
	}

	@Override
	protected String getTypeContent(String indentation, String lineSeparator) {
		return SsTypeCreatorUtil.createInterfaceContent(getTypeName(), getSuperInterfaces(), indentation, lineSeparator);
	}

}
