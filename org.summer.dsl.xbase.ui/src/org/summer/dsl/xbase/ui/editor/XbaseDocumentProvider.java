/*******************************************************************************
 * Copyright (c) 2013 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.ui.editor;

import java.io.IOException;
import java.io.InputStream;

import org.eclipse.core.resources.IResource;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.emf.common.util.URI;
import org.eclipse.jdt.core.IClassFile;
import org.eclipse.jdt.internal.ui.javaeditor.IClassFileEditorInput;
import org.eclipse.jface.text.IDocument;
import org.eclipse.jface.text.source.IAnnotationModel;
import org.eclipse.ui.IEditorInput;
import org.summer.dsl.builder.smap.XbaseBreakpointUtil;
import org.summer.dsl.builder.trace.ITraceForTypeRootProvider;
import org.eclipse.xtext.generator.trace.ILocationInResource;
import org.eclipse.xtext.generator.trace.ITrace;
import org.eclipse.xtext.ui.editor.model.JarFileMarkerAnnotationModel;
import org.eclipse.xtext.ui.editor.model.XtextDocument;
import org.eclipse.xtext.ui.editor.model.XtextDocumentProvider;

import com.google.inject.Inject;

/**
 * @author Moritz Eysholdt - Initial contribution and API
 */
public class XbaseDocumentProvider extends XtextDocumentProvider {

	protected class ClassFileInfo extends ElementInfo {
		public ClassFileInfo(IDocument document, IAnnotationModel model) {
			super(document, model);
		}
	}

	@Inject
	private ITraceForTypeRootProvider traceForTypeRootProvider;

	@Inject
	private XbaseBreakpointUtil breakpointUtil;

	protected ILocationInResource getClassFileSourceStorage(IClassFile classFile) {
		ITrace traceToSource = traceForTypeRootProvider.getTraceToSource(classFile);
		for (ILocationInResource loc : traceToSource.getAllAssociatedLocations())
			return loc;
		return null;
	}

	@Override
	protected boolean setDocumentContent(IDocument document, IEditorInput input, String encoding) throws CoreException {
		if (input instanceof IClassFileEditorInput) {
			IClassFile classFile = ((IClassFileEditorInput) input).getClassFile();
			ILocationInResource source = getClassFileSourceStorage(classFile);
			InputStream contents = null;
			try {
				contents = source.getContents();
				if (contents != null)
					setDocumentContent(document, contents, encoding);
			} finally {
				try {
					if (contents != null)
						contents.close();
				} catch (IOException e1) {
				}
			}
			setDocumentResource((XtextDocument) document, input, encoding);
			return true;
		}
		return super.setDocumentContent(document, input, encoding);
	}

	@Override
	protected ElementInfo createElementInfo(Object element) throws CoreException {
		if (element instanceof IClassFileEditorInput) {
			IDocument document = null;
			IStatus status = null;
			try {
				document = createDocument(element);
			} catch (CoreException x) {
				status = x.getStatus();
				document = createEmptyDocument();
			}
			ClassFileInfo info = new ClassFileInfo(document, createAnnotationModel(element));
			info.fStatus = status;
			registerAnnotationInfoProcessor(info);
			return info;
		}
		return super.createElementInfo(element);
	}

	@Override
	protected IAnnotationModel createAnnotationModel(Object element) throws CoreException {
		if (element instanceof IEditorInput) {
			IEditorInput editorInput = (IEditorInput) element;
			URI breakpointURI = breakpointUtil.getBreakpointURI(editorInput);
			if (breakpointURI != null) { // we only get a URI here if the EditorInput points into a JAR
				IResource breakpointResource = breakpointUtil.getBreakpointResource(editorInput);
				return new JarFileMarkerAnnotationModel(breakpointResource, breakpointURI);
			}
		}
		return super.createAnnotationModel(element);
	}
}
