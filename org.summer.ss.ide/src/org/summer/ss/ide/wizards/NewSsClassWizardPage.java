/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.wizards;

import org.eclipse.core.runtime.IStatus;
import org.eclipse.swt.widgets.Composite;

/**
 * @author Robert von Massow - Initial contribution and API
 * @author Holger Schill
 * @author Anton Kosyakov - https://bugs.eclipse.org/bugs/show_bug.cgi?id=379220
 */
public class NewSsClassWizardPage extends AbstractNewSsElementWizardPage {

	public NewSsClassWizardPage() {
		super(CLASS_TYPE, NewSsClassWizard.TITLE);
		this.setTitle(NewSsClassWizard.TITLE);
		this.setDescription(Messages.XTEND_CLASS_WIZARD_DESCRIPTION);
	}

	public void createControl(Composite parent) {
		Composite composite = createCommonControls(parent);
		createSuperClassControls(composite, COLS);
		createSuperInterfacesControls(composite, COLS);
		setControl(composite);
	}

	@Override
	protected void doStatusUpdate() {
		IStatus[] status= new IStatus[] {
			fContainerStatus,
			fPackageStatus,
			fTypeNameStatus,
			fSuperClassStatus,
			fSuperInterfacesStatus
		};
		updateStatus(status);
	}

	@Override
	protected String getPackageDeclaration(String lineSperator) {
		return SsTypeCreatorUtil.createPackageDeclaration(getTypeName(), getPackageFragment(), getSuperClass(), getSuperInterfaces(), lineSperator);
	}

	@Override
	protected String getTypeContent(String indentation, String lineSperator) {
		return SsTypeCreatorUtil.createClassContent(getTypeName(), getSuperClass(), getSuperInterfaces(), indentation, lineSperator);
	}

	@Override
	protected String getElementCreationErrorMessage() {
		return Messages.ERROR_CREATING_CLASS;
	}
	
	
	
}
