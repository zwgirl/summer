/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.refactoring;

import org.apache.log4j.Logger;
import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.jface.text.ITextSelection;
import org.eclipse.swt.widgets.Display;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.model.IXtextDocument;
import org.eclipse.xtext.ui.editor.utils.EditorUtils;
import org.eclipse.xtext.ui.refactoring.ui.DefaultRenameElementHandler;
import org.eclipse.xtext.ui.refactoring.ui.RefactoringWizardOpenOperation_NonForking;
import org.eclipse.xtext.ui.refactoring.ui.SyncUtil;
import org.eclipse.xtext.util.ITextRegion;
import org.eclipse.xtext.util.concurrent.IUnitOfWork;
import org.summer.dsl.model.xbase.XExpression;

import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Jan Koehnlein - Initial contribution and API
 */
public class ExtractVariableHandler extends AbstractHandler {

	@Inject
	private SyncUtil syncUtil;

	@Inject ExpressionUtil expressionUtil;
	
	@Inject
	private Provider<ExtractVariableRefactoring> refactoringProvider;
	
	@Inject
	private ILocationInFileProvider locationInFileProvider;
	
	protected static final Logger LOG = Logger.getLogger(DefaultRenameElementHandler.class);

	public Object execute(ExecutionEvent event) throws ExecutionException {
		try {
			syncUtil.totalSync(false);
			final XtextEditor editor = EditorUtils.getActiveXtextEditor(event);
			if (editor != null) {
				final ITextSelection selection = (ITextSelection) editor.getSelectionProvider().getSelection();
				final IXtextDocument document = editor.getDocument();
				document.readOnly(new IUnitOfWork.Void<XtextResource>() {
					@Override
					public void process(XtextResource resource) throws Exception {
						// cym comment
//						XExpression expression = expressionUtil.findSelectedExpression(resource, selection);
//						if(expression != null) {
//							ExtractVariableRefactoring introduceVariableRefactoring = refactoringProvider.get();
//							if(introduceVariableRefactoring.initialize(editor, expression)) {
//								ITextRegion region = locationInFileProvider.getFullTextRegion(expression);
//								editor.selectAndReveal(region.getOffset(), region.getLength());
//								ExtractVariableWizard wizard = new ExtractVariableWizard(introduceVariableRefactoring);
//								RefactoringWizardOpenOperation_NonForking openOperation = new RefactoringWizardOpenOperation_NonForking(
//										wizard);
//								openOperation.run(editor.getSite().getShell(), "Extract Local Variable");
//							}
//						}
					}
				});
			}
		} catch (Exception exc) {
			LOG.error("Error during refactoring", exc);
			MessageDialog.openError(Display.getCurrent().getActiveShell(), "Error during refactoring", exc.getMessage()
					+ "\nSee log for details");
		}
		return null;
	}
}
