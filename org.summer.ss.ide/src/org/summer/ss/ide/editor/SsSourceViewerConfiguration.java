/*******************************************************************************
 * Copyright (c) 2012 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.editor;

import org.eclipse.jdt.internal.ui.JavaPlugin;
import org.eclipse.jdt.internal.ui.text.javadoc.JavaDocScanner;
import org.eclipse.jdt.ui.text.IColorManager;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.presentation.IPresentationReconciler;
import org.eclipse.jface.text.rules.DefaultDamagerRepairer;
import org.eclipse.jface.text.source.ISourceViewer;
import org.summer.ss.ide.autoedit.TokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.XtextPresentationReconciler;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;

/**
 * @author Holger Schill - Initial contribution and API
 */
public class SsSourceViewerConfiguration extends XtextSourceViewerConfiguration {
	@Override
	public IPresentationReconciler getPresentationReconciler(ISourceViewer sourceViewer) {
		XtextPresentationReconciler reconciler = (XtextPresentationReconciler) super
				.getPresentationReconciler(sourceViewer);
		IPreferenceStore store = JavaPlugin.getDefault().getCombinedPreferenceStore();
		IColorManager colorManager = JavaPlugin.getDefault().getJavaTextTools().getColorManager();
		JavaDocScanner javaDocScanner = new JavaDocScanner(colorManager, store, null);
		DefaultDamagerRepairer dr = new DefaultDamagerRepairer(javaDocScanner);
		reconciler.setRepairer(dr, TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		reconciler.setDamager(dr, TokenTypeToPartitionMapper.JAVA_DOC_PARTITION);
		return reconciler;
	}
}
