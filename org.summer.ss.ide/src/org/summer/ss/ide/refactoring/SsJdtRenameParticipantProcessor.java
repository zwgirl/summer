/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.refactoring;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.ltk.core.refactoring.RefactoringStatus;
import org.eclipse.ltk.core.refactoring.participants.RefactoringProcessor;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.SsPackage;
import org.summer.dsl.model.ui.refactoring.participant.JdtRenameParticipant;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.JvmModelJdtRenameParticipantContext;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.jdt.JdtRenameRefactoringParticipantProcessor;

/**
 * Allow refactoring of dispatch methods, even though they have more than one associated JVM element.
 * 
 * @author Jan Koehnlein - Initial contribution and API
 */
public class SsJdtRenameParticipantProcessor extends JdtRenameRefactoringParticipantProcessor {

	@Override
	protected RefactoringStatus preCheckInitialConditions(IProgressMonitor pm) throws CoreException {
		if (getTargetElement() instanceof XtendFunction 
				&& ((XtendFunction) getTargetElement()).isDispatch()
				&& isXtendRename()) {
			return new RefactoringStatus();
		}
		return super.preCheckInitialConditions(pm);
	}

	/**
	 * @return true, if the triggering refactoring targets an Xtend element. 
	 */
	protected boolean isXtendRename() {
		JdtRenameParticipant jdtRenameParticipant = ((JvmModelJdtRenameParticipantContext) getRenameElementContext())
				.getJdtRenameParticipant();
		RefactoringProcessor triggeringProcessor = jdtRenameParticipant.getProcessor().getRefactoring().getProcessor();
		if(triggeringProcessor instanceof RenameElementProcessor) {
			EClass targetElementEClass = ((RenameElementProcessor) triggeringProcessor).getRenameElementContext().getTargetElementEClass();
			return targetElementEClass.getEPackage() == SsPackage.eINSTANCE;
		}
		return false;
	}
}
