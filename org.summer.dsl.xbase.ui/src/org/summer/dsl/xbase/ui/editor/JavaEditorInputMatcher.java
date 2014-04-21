/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.editor;

import java.util.Iterator;

import org.apache.log4j.Logger;
import org.eclipse.core.resources.IFile;
import org.eclipse.core.resources.IResource;
import org.eclipse.core.resources.IStorage;
import org.eclipse.ui.IEditorInput;
import org.eclipse.ui.IEditorMatchingStrategy;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IEditorReference;
import org.eclipse.ui.ide.ResourceUtil;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.ui.editor.XtextEditorInfo;
import org.summer.dsl.xbase.ui.editor.StacktraceBasedEditorDecider.Decision;

import com.google.inject.Inject;

/**
 * This strategy matches existing Xbase editors to Java editor input.
 * 
 * @author Sebastian Zarnekow - Initial contribution and API
 */
public class JavaEditorInputMatcher implements IEditorMatchingStrategy {

	private static final Logger logger = Logger.getLogger(JavaEditorInputMatcher.class);
	
	@Inject
	private ITraceForStorageProvider traceInformation;
	
	@Inject
	private XtextEditorInfo editorInfo;
	
	@Inject
	private StacktraceBasedEditorDecider decisions;
	
	@Inject
	private XbaseEditorInputRedirector editorInputRedirector;
	
	public boolean matches(IEditorReference editorRef, IEditorInput inputToCheck) {
		try {
			if (!editorInfo.getEditorId().equals(editorRef.getId())) {
				return false;
			}
			IEditorInput newInput = editorInputRedirector.findOriginalSourceForOuputFolderCopy(inputToCheck);
			IEditorInput currentInput = editorRef.getEditorInput();
			if (newInput.equals(currentInput)) {
				return true;
			}
			if (decisions.decideAccordingToCaller() == Decision.FORCE_JAVA)
				return false;
			IFile newResource = ResourceUtil.getFile(newInput);
			if (newResource == null) {
				return false;
			}
			IResource currentResource = ResourceUtil.getResource(currentInput);
			ITrace traceToSource = traceInformation.getTraceToSource(newResource);
			if (traceToSource == null) {
				return false;
			}
			if (isCurrentResource(currentResource, traceToSource)) {
				IEditorPart existingEditor = editorRef.getEditor(true);
				if (existingEditor instanceof XbaseEditor) {
					((XbaseEditor)existingEditor).markNextSelectionAsJavaOffset(newResource);
					return true;
				}
			}
		} catch(Exception e) {
			logger.error(e.getMessage(), e);
		}
		return false;
	}

	protected boolean isCurrentResource(IResource currentResource, ITrace traceToSource) {
		Iterator<ILocationInResource> iterator = traceToSource.getAllAssociatedLocations().iterator();
		if (!iterator.hasNext()) {
			return false;
		}
		IStorage storage = iterator.next().getStorage();
		return currentResource.equals(storage);
	}

}
