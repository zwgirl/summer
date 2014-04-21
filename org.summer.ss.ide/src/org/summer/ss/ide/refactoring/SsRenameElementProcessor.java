/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import static org.eclipse.xtext.util.Strings.*;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.OperationCanceledException;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.util.DisplayRunnableWithResult;

import com.google.inject.Inject;
import com.google.inject.name.Named;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsRenameElementProcessor extends RenameElementProcessor {

	@Inject
	@Named(Constants.LANGUAGE_NAME)
	private String languageName;
	
	@Inject(optional=true)
	private IWorkbench workbench;

	public boolean hasUnsavedEditors() {
		return new DisplayRunnableWithResult<Boolean>() {
			@Override
			protected Boolean run() throws Exception {
				IWorkbenchPage workbenchPage = workbench.getActiveWorkbenchWindow().getActivePage();
				for (IEditorPart editorPart : workbenchPage.getDirtyEditors())
					if (equal(editorPart.getSite().getId(), languageName))
						return true;
				return false;
				
			}
		}.syncExec();
	}

	@Override
	public RefactoringStatus checkInitialConditions(IProgressMonitor pm) throws CoreException,
			OperationCanceledException {
		RefactoringStatus status = super.checkInitialConditions(pm);
		if(hasUnsavedEditors()) {
			status.addWarning("Unsaved changes in Ss editors could collide with this refactoring.");
		}
		return status;
	}
}
