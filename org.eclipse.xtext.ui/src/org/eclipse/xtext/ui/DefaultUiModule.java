/*******************************************************************************
 * Copyright (c) 2008 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.eclipse.xtext.ui;

import org.eclipse.emf.common.notify.AdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.ui.provider.AdapterFactoryLabelProvider;
import org.eclipse.jface.dialogs.IDialogSettings;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.text.IDocumentPartitioner;
import org.eclipse.jface.text.contentassist.IContentAssistProcessor;
import org.eclipse.jface.text.hyperlink.IHyperlinkDetector;
import org.eclipse.jface.text.presentation.IPresentationDamager;
import org.eclipse.jface.text.presentation.IPresentationRepairer;
import org.eclipse.jface.text.reconciler.IReconciler;
import org.eclipse.jface.text.rules.IPartitionTokenScanner;
import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.text.templates.ContextTypeRegistry;
import org.eclipse.jface.text.templates.persistence.TemplateStore;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.PlatformUI;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.eclipse.xtext.formatting.IIndentationInformation;
import org.eclipse.xtext.formatting.IWhitespaceInformationProvider;
import org.eclipse.xtext.generator.trace.ITraceURIConverter;
import org.eclipse.xtext.parser.IEncodingProvider;
import org.eclipse.xtext.preferences.IPreferenceValuesProvider;
import org.eclipse.xtext.resource.IExternalContentSupport;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.containers.IAllContainersState;
import org.eclipse.xtext.resource.impl.LiveShadowedResourceDescriptions;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.AbstractGenericModule;
import org.eclipse.xtext.service.DispatchingProvider;
import org.eclipse.xtext.ui.IImageHelper.IImageDescriptorHelper;
import org.eclipse.xtext.ui.containers.ContainerStateProvider;
import org.eclipse.xtext.ui.editor.IDirtyStateManager;
import org.eclipse.xtext.ui.editor.IURIEditorOpener;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.LanguageSpecificURIEditorOpener;
import org.eclipse.xtext.ui.editor.PresentationDamager;
import org.eclipse.xtext.ui.editor.SmartCaretPreferenceInitializer;
import org.eclipse.xtext.ui.editor.WorkspaceEncodingProvider;
import org.eclipse.xtext.ui.editor.XtextEditorErrorTickUpdater;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.autoedit.DefaultAutoEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.DefaultCompletionProposalPostProcessor;
import org.eclipse.xtext.ui.editor.contentassist.DefaultContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalPostProcessor;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.XtextContentAssistProcessor;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.copyqualifiedname.DefaultCopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.formatting.ContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.formatting.PreferenceStoreIndentationInformation;
import org.eclipse.xtext.ui.editor.formatting.PreferenceStoreWhitespaceInformationProvider;
import org.eclipse.xtext.ui.editor.hover.DefaultCompositeHover;
import org.eclipse.xtext.ui.editor.hover.DispatchingEObjectTextHover;
import org.eclipse.xtext.ui.editor.hover.IEObjectHover;
import org.eclipse.xtext.ui.editor.hover.ProblemAnnotationHover;
import org.eclipse.xtext.ui.editor.hyperlinking.DefaultHyperlinkDetector;
import org.eclipse.xtext.ui.editor.model.DocumentPartitioner;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.JavaClassPathResourceForIEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.PartitionTokenScanner;
import org.eclipse.xtext.ui.editor.occurrences.MarkOccurrenceActionContributor;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.actions.LinkWithEditorOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.actions.SortOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.impl.OutlinePage;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.quickfix.DefaultQuickfixProvider;
import org.eclipse.xtext.ui.editor.quickfix.IssueResolutionProvider;
import org.eclipse.xtext.ui.editor.reconciler.XtextReconciler;
import org.eclipse.xtext.ui.editor.syntaxcoloring.HighlightingHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingHelper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.PresentationRepairer;
import org.eclipse.xtext.ui.editor.syntaxcoloring.TokenScanner;
import org.eclipse.xtext.ui.editor.templates.DefaultTemplateProposalProvider;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateContextTypeRegistry;
import org.eclipse.xtext.ui.editor.templates.XtextTemplateStore;
import org.eclipse.xtext.ui.editor.toggleComments.DefaultSingleLineCommentHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;
import org.eclipse.xtext.ui.generator.trace.ExtensibleTraceURIConverter;
import org.eclipse.xtext.ui.label.DefaultDescriptionLabelProvider;
import org.eclipse.xtext.ui.label.DefaultEObjectLabelProvider;
import org.eclipse.xtext.ui.label.InjectableAdapterFactoryLabelProvider;
import org.eclipse.xtext.ui.preferences.EclipsePreferencesProvider;
import org.eclipse.xtext.ui.resource.IResourceSetProvider;
import org.eclipse.xtext.ui.resource.XtextResourceSetProvider;
import org.eclipse.xtext.ui.validation.LanguageAwareMarkerTypeProvider;
import org.eclipse.xtext.ui.validation.MarkerTypeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * @author Sebastian Zarnekow
 * @author Sven Efftinge
 * @author Jan Koehnlein
 */
public class DefaultUiModule extends AbstractGenericModule {

	private final AbstractUIPlugin plugin;

	public DefaultUiModule(AbstractUIPlugin plugin) {
		this.plugin = plugin;
	}

	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(AbstractUIPlugin.class).toInstance(plugin);
		binder.bind(IDialogSettings.class).toInstance(plugin.getDialogSettings());
	}

	public void configureBracketMatchingAction(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("foldingActionGroup")).to( //$NON-NLS-1$
				org.eclipse.xtext.ui.editor.folding.FoldingActionContributor.class);
		binder.bind(IActionContributor.class).annotatedWith(Names.named("bracketMatcherAction")).to( //$NON-NLS-1$
				org.eclipse.xtext.ui.editor.bracketmatching.GoToMatchingBracketAction.class);
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("bracketMatcherPrefernceInitializer")) //$NON-NLS-1$
				.to(org.eclipse.xtext.ui.editor.bracketmatching.BracketMatchingPreferencesInitializer.class);
		binder.bind(IActionContributor.class).annotatedWith(Names.named("selectionActionGroup")).to( //$NON-NLS-1$
				org.eclipse.xtext.ui.editor.selection.AstSelectionActionContributor.class);
	}

	public Class<? extends IImageHelper> bindIImageHelper() {
		return PluginImageHelper.class;
	}
	
	/**
	 * @since 2.4
	 */
	public Class<? extends IImageDescriptorHelper> bindIImageDescriptorHelper() {
		return PluginImageHelper.class;
	}

	public Class<? extends IIndentationInformation> bindIIndentationInformation() {
		return PreferenceStoreIndentationInformation.class;
	}

	/**
	 * @since 2.3
	 */
	public Class<? extends IWhitespaceInformationProvider> bindIWhitespaceInformationProvider() {
		return PreferenceStoreWhitespaceInformationProvider.class;
	}

	public IPreferenceStore bindIPreferenceStore() {
		return plugin.getPreferenceStore();
	}

	public Class<? extends IReconciler> bindIReconciler() {
		return XtextReconciler.class;
	}

	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return DefaultSingleLineCommentHelper.class;
	}

	public Class<? extends IHyperlinkDetector> bindIHyperlinkDetector() {
		return DefaultHyperlinkDetector.class;
	}

	public Class<? extends IPresentationDamager> bindIPresentationDamager() {
		return PresentationDamager.class;
	}

	public Class<? extends IPresentationRepairer> bindIPresentationRepairer() {
		return PresentationRepairer.class;
	}

	public ICharacterPairMatcher bindICharacterPairMatcher() {
		return new DefaultCharacterPairMatcher(new char[] { '(', ')', '{', '}', '[', ']' });
	}

	public Class<? extends ITokenScanner> bindITokenScanner() {
		return TokenScanner.class;
	}

	public Class<? extends IPartitionTokenScanner> bindIPartitionTokenScanner() {
		return PartitionTokenScanner.class;
	}

	public Class<? extends IDocumentPartitioner> bindIDocumentPartitioner() {
		return DocumentPartitioner.class;
	}

	public Class<? extends IHighlightingHelper> bindIHighlightingHelper() {
		return HighlightingHelper.class;
	}

	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return DefaultAutoEditStrategyProvider.class;
	}

	public Class<? extends AdapterFactory> bindAdapterFactory() {
		return InjectableAdapterFactory.class;
	}

	public Class<? extends AdapterFactoryLabelProvider> bindAdapterFactoryLabelProvider() {
		return InjectableAdapterFactoryLabelProvider.class;
	}

	public ComposedAdapterFactory.Descriptor.Registry bindComposedAdapterFactory$Descriptor$RegistryToInstance() {
		return ComposedAdapterFactory.Descriptor.Registry.INSTANCE;
	}

	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return DefaultContentAssistantFactory.class;
	}

	public Class<? extends IContentAssistProcessor> bindIContentAssistProcessor() {
		return XtextContentAssistProcessor.class;
	}

	public Class<? extends ICompletionProposalPostProcessor> bindICompletionProposalPostProcessor() {
		return DefaultCompletionProposalPostProcessor.class;
	}

	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return DefaultTemplateProposalProvider.class;
	}

	public Class<? extends TemplateStore> bindTemplateStore() {
		return XtextTemplateStore.class;
	}

	public Class<? extends ContextTypeRegistry> bindContextTypeRegistry() {
		return XtextTemplateContextTypeRegistry.class;
	}

	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		return ContentFormatterFactory.class;
	}

	public void configureXtextEditorErrorTickUpdater(com.google.inject.Binder binder) {
		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("IXtextEditorCallBack")).to( //$NON-NLS-1$
				XtextEditorErrorTickUpdater.class);
	}

	public Class<? extends IExternalContentSupport.IExternalContentProvider> bindIExternalContentSupport$IExternalContentProvider() {
		return IDirtyStateManager.class;
	}

	public void configureHyperlinkLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
				.annotatedWith(org.eclipse.xtext.ui.editor.hyperlinking.HyperlinkLabelProvider.class)
				.to(org.eclipse.jface.viewers.ILabelProvider.class);
	}

	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return OutlinePage.class;
	}

	public void configureIOutlineContribution$Composite(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(IOutlineContribution.All.class)
				.to(IOutlineContribution.Composite.class);
	}

	public void configureToggleSortingOutlineContribution(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(IOutlineContribution.Sort.class)
				.to(SortOutlineContribution.class);
	}

	public void configureToggleLinkWithEditorOutlineContribution(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(IOutlineContribution.LinkWithEditor.class)
				.to(LinkWithEditorOutlineContribution.class);
	}

	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
		return SortOutlineContribution.DefaultComparator.class;
	}

	public void configureContentProposalLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
				.annotatedWith(org.eclipse.xtext.ui.editor.contentassist.ContentProposalLabelProvider.class)
				.to(org.eclipse.jface.viewers.ILabelProvider.class);
	}

	public void configureResourceUIServiceLabelProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.jface.viewers.ILabelProvider.class)
				.annotatedWith(org.eclipse.xtext.ui.resource.ResourceServiceDescriptionLabelProvider.class)
				.to(DefaultDescriptionLabelProvider.class);
	}

	public Class<? extends ILabelProvider> bindILabelProvider() {
		return DefaultEObjectLabelProvider.class;
	}

	public Class<? extends IssueResolutionProvider> bindIssueResolutionProvider() {
		return DefaultQuickfixProvider.class;
	}

	public void configureLanguageSpecificURIEditorOpener(com.google.inject.Binder binder) {
		if (PlatformUI.isWorkbenchRunning())
			binder.bind(IURIEditorOpener.class).annotatedWith(LanguageSpecific.class)
					.to(LanguageSpecificURIEditorOpener.class);
	}

	public void configureUiEncodingProvider(Binder binder) {
		binder.bind(IEncodingProvider.class).annotatedWith(DispatchingProvider.Ui.class)
				.to(WorkspaceEncodingProvider.class);
	}	
	
	public Class<? extends IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return ContainerStateProvider.class;
	}

	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return JavaClassPathResourceForIEditorInputFactory.class;
	}

	public Class<? extends IResourceSetProvider> bindIResourceSetProvider() {
		return XtextResourceSetProvider.class;
	}

	public Class<? extends IAnnotationHover> bindIAnnotationHover () {
		return ProblemAnnotationHover.class;		
	}
		 
	public Class<? extends org.eclipse.jface.text.ITextHover> bindITextHover() {
		return DefaultCompositeHover.class;
	}

	public Class<? extends IEObjectHover> bindIEObjectHover() {
		return DispatchingEObjectTextHover.class;
	}

	public void configureMarkOccurrencesAction(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("markOccurrences"))
			.to(MarkOccurrenceActionContributor.class);
	}

	/**
	 * @since 2.1
	 */
	public void configureIResourceDescriptionsLiveScope(Binder binder) {
		binder.bind(IResourceDescriptions.class).annotatedWith(Names.named(ResourceDescriptionsProvider.LIVE_SCOPE)).to(LiveShadowedResourceDescriptions.class);
	}
	
	/**
	 * @since 2.3
	 */
	public Class<? extends MarkerTypeProvider> bindMarkerTypeProvider() {
		return LanguageAwareMarkerTypeProvider.class;
	}

	/**
	 * @since 2.4
	 */
	public void configureSmartCaretPreferenceInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("smartCaretPreferenceInitializer")) //$NON-NLS-1$
				.to(SmartCaretPreferenceInitializer.class);
	}
	
	/**
	 * @since 2.4
	 */
	public Class<? extends IPreferenceValuesProvider> bindIPreferenceValuesProvider() {
		return EclipsePreferencesProvider.class;
	}
	
	/**
	 * @since 2.4
	 */
	public Class<? extends ITraceURIConverter> bindITraceURIConverter() {
		return ExtensibleTraceURIConverter.class;
	}
	
	/**
	 * @since 2.4
	 */
	public Class<? extends CopyQualifiedNameService> bindCopyQualifiedNameService() {
		return DefaultCopyQualifiedNameService.class;
	}
	
}


