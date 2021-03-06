/*
 * generated by Xtext
 */
package org.summer.ss.ide;

import org.eclipse.jface.text.rules.ITokenScanner;
import org.eclipse.jface.text.source.DefaultCharacterPairMatcher;
import org.eclipse.jface.text.source.IAnnotationHover;
import org.eclipse.jface.text.source.ICharacterPairMatcher;
import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.ui.plugin.AbstractUIPlugin;
import org.eclipse.ui.views.contentoutline.IContentOutlinePage;
import org.summer.ss.core.formatting.FormatterPreferenceValuesProvider;
import org.summer.ss.core.macro.ProcessorInstanceForJvmTypeProvider;
import org.summer.ss.ide.autoedit.AutoEditStrategyProvider;
import org.summer.ss.ide.autoedit.TokenTypeToPartitionMapper;
import org.summer.ss.ide.builder.JavaProjectPreferencesInitializer;
import org.summer.ss.ide.builder.SourceRelativeFileSystemAccess;
import org.summer.ss.ide.builder.SsBuilderParticipant;
import org.summer.ss.ide.builder.SsResourceDescriptionsProvider;
import org.summer.ss.ide.contentassist.EscapeSequenceAwarePrefixMatcher;
import org.summer.ss.ide.contentassist.OperatorAwareComparator;
import org.summer.ss.ide.contentassist.TemplateProposalProvider;
import org.summer.ss.ide.contentassist.SsContentAssistFactory;
import org.summer.ss.ide.editor.InitiallyCollapsableAwareFoldingStructureProvider;
import org.summer.ss.ide.editor.OccurrenceComputer;
import org.summer.ss.ide.editor.OverrideIndicatorModelListener;
import org.summer.ss.ide.editor.OverrideIndicatorRulerAction;
import org.summer.ss.ide.editor.RichStringAwareSourceViewer;
import org.summer.ss.ide.editor.RichStringAwareToggleCommentAction;
import org.summer.ss.ide.editor.SingleLineCommentHelper;
import org.summer.ss.ide.editor.SsDoubleClickStrategyProvider;
import org.summer.ss.ide.editor.SsFoldingRegionProvider;
import org.summer.ss.ide.editor.SsNatureAddingEditorCallback;
import org.summer.ss.ide.editor.SsSourceViewerConfiguration;
import org.summer.ss.ide.editor.copyqualifiedname.SsCopyQualifiedNameService;
import org.summer.ss.ide.editor.model.SsDocumentTokenSource;
import org.summer.ss.ide.findrefs.SsReferenceFinder;
import org.summer.ss.ide.formatting.FormatterFactory;
import org.summer.ss.ide.formatting.preferences.FormatterResourceProvider;
import org.summer.ss.ide.highlighting.RichStringAwareTokenScanner;
import org.summer.ss.ide.highlighting.ShowWhitespaceCharactersActionContributor;
import org.summer.ss.ide.highlighting.TokenToAttributeIdMapper;
import org.summer.ss.ide.highlighting.SsHighlightingCalculator;
import org.summer.ss.ide.highlighting.SsHighlightingConfiguration;
import org.summer.ss.ide.hover.SsAnnotationHover;
import org.summer.ss.ide.hover.SsHoverDocumentationProvider;
import org.summer.ss.ide.hover.SsHoverProvider;
import org.summer.ss.ide.hover.SsHoverSignatureProvider;
import org.summer.ss.ide.hyperlinking.SsHyperlinkHelper;
import org.summer.ss.ide.labeling.SsLabelProvider;
import org.summer.ss.ide.macro.JdtBasedProcessorProvider;
import org.summer.ss.ide.outline.ShowSyntheticMembersContribution;
import org.summer.ss.ide.outline.SsOutlineNodeComparator;
import org.summer.ss.ide.outline.SsOutlinePage;
import org.summer.ss.ide.outline.SsQuickOutlineFilterAndSorter;
import org.summer.ss.ide.quickfix.TypeLiteralAwareJavaTypeQuickfixes;
import org.summer.ss.ide.refactoring.SsDependentElementsCalculator;
import org.summer.ss.ide.refactoring.SsJdtRenameParticipantProcessor;
import org.summer.ss.ide.refactoring.SsRefactoringPreferences;
import org.summer.ss.ide.refactoring.SsRenameContextFactory;
import org.summer.ss.ide.refactoring.SsRenameElementProcessor;
import org.summer.ss.ide.refactoring.SsRenameStrategy;
import org.summer.ss.ide.refactoring.SsRenameStrategyProvider;
import org.summer.ss.ide.validator.preferences.XtendValidatorConfigurationBlock;
import org.summer.ss.lib.macro.file.MutableFileSystemSupport;
import org.summer.dsl.builder.EclipseResourceFileSystemAccess2;
import org.summer.dsl.builder.IXtextBuilderParticipant;
import org.summer.dsl.builder.builderState.IBuilderState;
import org.summer.dsl.builder.clustering.ClusteringBuilderState;
import org.summer.dsl.builder.resourceloader.IResourceLoader;
import org.summer.dsl.builder.resourceloader.ResourceLoaderProviders;
import org.summer.dsl.builder.trace.TraceForStorageProvider;
import org.summer.dsl.model.ui.refactoring.participant.JvmMemberRenameStrategy;
import org.eclipse.xtext.generator.trace.ITraceForStorageProvider;
import org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider;
import org.eclipse.xtext.service.SingletonBinding;
import org.eclipse.xtext.ui.editor.IXtextEditorCallback;
import org.eclipse.xtext.ui.editor.XtextEditor;
import org.eclipse.xtext.ui.editor.XtextSourceViewer;
import org.eclipse.xtext.ui.editor.XtextSourceViewerConfiguration;
import org.eclipse.xtext.ui.editor.actions.IActionContributor;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategy;
import org.eclipse.xtext.ui.editor.autoedit.AbstractEditStrategyProvider;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalComparator;
import org.eclipse.xtext.ui.editor.contentassist.IContentAssistantFactory;
import org.eclipse.xtext.ui.editor.contentassist.IContentProposalPriorities;
import org.eclipse.xtext.ui.editor.contentassist.IContextInformationProvider;
import org.eclipse.xtext.ui.editor.contentassist.ITemplateProposalProvider;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.copyqualifiedname.CopyQualifiedNameService;
import org.eclipse.xtext.ui.editor.doubleClicking.DoubleClickStrategyProvider;
import org.eclipse.xtext.ui.editor.embedded.IEditedResourceProvider;
import org.eclipse.xtext.ui.editor.findrefs.IReferenceFinder;
import org.eclipse.xtext.ui.editor.folding.IFoldingRegionProvider;
import org.eclipse.xtext.ui.editor.folding.IFoldingStructureProvider;
import org.eclipse.xtext.ui.editor.formatting.IContentFormatterFactory;
import org.eclipse.xtext.ui.editor.hover.IEObjectHoverProvider;
import org.eclipse.xtext.ui.editor.hover.html.IEObjectHoverDocumentationProvider;
import org.eclipse.xtext.ui.editor.hyperlinking.IHyperlinkHelper;
import org.eclipse.xtext.ui.editor.model.DocumentTokenSource;
import org.eclipse.xtext.ui.editor.model.IResourceForEditorInputFactory;
import org.eclipse.xtext.ui.editor.model.TerminalsTokenTypeToPartitionMapper;
import org.eclipse.xtext.ui.editor.occurrences.IOccurrenceComputer;
import org.eclipse.xtext.ui.editor.outline.actions.IOutlineContribution;
import org.eclipse.xtext.ui.editor.outline.impl.OutlineFilterAndSorter.IComparator;
import org.eclipse.xtext.ui.editor.outline.quickoutline.QuickOutlineFilterAndSorter;
import org.eclipse.xtext.ui.editor.preferences.IPreferenceStoreInitializer;
import org.eclipse.xtext.ui.editor.syntaxcoloring.AbstractAntlrTokenToAttributeIdMapper;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.eclipse.xtext.ui.editor.toggleComments.ISingleLineCommentHelper;
import org.eclipse.xtext.ui.editor.toggleComments.ToggleSLCommentAction;
import org.eclipse.xtext.ui.refactoring.IDependentElementsCalculator;
import org.eclipse.xtext.ui.refactoring.IRenameStrategy;
import org.eclipse.xtext.ui.refactoring.impl.RenameElementProcessor;
import org.eclipse.xtext.ui.refactoring.ui.IRenameContextFactory;
import org.eclipse.xtext.ui.resource.IResourceUIServiceProvider;
import org.eclipse.xtext.ui.validation.AbstractValidatorConfigurationBlock;
import org.eclipse.xtext.validation.IssueSeveritiesProvider;
import org.summer.dsl.xbase.file.AbstractFileSystemSupport;
import org.summer.dsl.xbase.file.JavaIOFileSystemSupport;
import org.summer.dsl.xbase.file.WorkspaceConfig;
import org.summer.dsl.xbase.formatting.IFormattingPreferenceValuesProvider;
import org.summer.dsl.xbase.ui.contentassist.ParameterContextInformationProvider;
import org.summer.dsl.xbase.ui.contentassist.XbaseContentProposalPriorities;
import org.summer.dsl.xbase.ui.editor.XbaseEditor;
import org.summer.dsl.xbase.ui.editor.XbaseResourceForEditorInputFactory;
import org.summer.dsl.xbase.ui.file.EclipseFileSystemSupportImpl;
import org.summer.dsl.xbase.ui.file.EclipseWorkspaceConfigProvider;
import org.summer.dsl.xbase.ui.hover.XbaseDeclarativeHoverSignatureProvider;
import org.summer.dsl.xbase.ui.jvmmodel.refactoring.jdt.JdtRenameRefactoringParticipantProcessor;
import org.summer.dsl.xbase.ui.quickfix.JavaTypeQuickfixes;
import org.summer.dsl.xbase.ui.validation.XbaseIssueSeveritiesProvider;

import com.google.inject.Binder;
import com.google.inject.Scopes;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used within the IDE.
 */
public class SsUiModule extends org.summer.ss.ide.AbstractSsUiModule {
	public SsUiModule(AbstractUIPlugin plugin) {
		super(plugin);
	}

	public void configureDebugMode(Binder binder) {
		if (Boolean.getBoolean("org.eclipse.xtext.xtend.debug")) {
			binder.bindConstant().annotatedWith(Names.named(AbstractEditStrategy.DEBUG)).to(true);
		}
		// matches ID of org.eclipse.ui.contexts extension registered in plugin.xml
		binder.bindConstant().annotatedWith(Names.named(XtextEditor.KEY_BINDING_SCOPE))
				.to("org.summer.ss.ide.SsEditorScope");
		
		binder.bind(IResourceLoader.class).annotatedWith(Names.named(ClusteringBuilderState.RESOURCELOADER_CROSS_LINKING))
				.toProvider(ResourceLoaderProviders.getSerialLoader());
	}

	public void configureOverrideIndicatorSupport(Binder binder) {
		binder.bind(IXtextEditorCallback.class).annotatedWith(Names.named("OverrideIndicatorModelListener")) //$NON-NLS-1$
				.to(OverrideIndicatorModelListener.class);
		binder.bind(IActionContributor.class).annotatedWith(Names.named("OverrideIndicatorRulerAction")).to( //$NON-NLS-1$
				OverrideIndicatorRulerAction.class);
	}
	
	public Class<? extends IFormattingPreferenceValuesProvider> bindIFormattingPreferenceValuesProvider() {
		return FormatterPreferenceValuesProvider.class;
	}

	@Override
	public Class<? extends IAnnotationHover> bindIAnnotationHover() {
		return SsAnnotationHover.class;
	}

	@Override
	public Class<? extends IHighlightingConfiguration> bindIHighlightingConfiguration() {
		return SsHighlightingConfiguration.class;
	}

	@Override
	public Class<? extends AbstractAntlrTokenToAttributeIdMapper> bindAbstractAntlrTokenToAttributeIdMapper() {
		return TokenToAttributeIdMapper.class;
	}

	@Override
	public Class<? extends ITokenScanner> bindITokenScanner() {
		return RichStringAwareTokenScanner.class;
	}

	@Override
	public Class<? extends ISemanticHighlightingCalculator> bindISemanticHighlightingCalculator() {
		return SsHighlightingCalculator.class;
	}

	public Class<? extends TerminalsTokenTypeToPartitionMapper> bindTerminalsTokenTypeToPartitionMapper() {
		return TokenTypeToPartitionMapper.class;
	}

	@Override
	public Class<? extends AbstractEditStrategyProvider> bindAbstractEditStrategyProvider() {
		return AutoEditStrategyProvider.class;
	}

	public void configureIShowWhitespaceCharactersActionContributor(Binder binder) {
		binder.bind(IActionContributor.class).annotatedWith(Names.named("Show Whitespace"))
				.to(ShowWhitespaceCharactersActionContributor.class);
	}

	public Class<? extends DoubleClickStrategyProvider> bindDoubleClickStrategyProvider() {
		return SsDoubleClickStrategyProvider.class;
	}

	@Override
	public Class<? extends IComparator> bindOutlineFilterAndSorter$IComparator() {
		return SsOutlineNodeComparator.class;
	}

	public Class<? extends QuickOutlineFilterAndSorter> bindQuickOutlineFilterAndSorter() {
		return SsQuickOutlineFilterAndSorter.class;
	}

	public Class<? extends IFoldingRegionProvider> bindIFoldingRegionProvider() {
		return SsFoldingRegionProvider.class;
	}

	@Override
	public Class<? extends IContentOutlinePage> bindIContentOutlinePage() {
		return SsOutlinePage.class;
	}

	@Override
	public Class<? extends IHyperlinkHelper> bindIHyperlinkHelper() {
		return SsHyperlinkHelper.class;
	}

	@Override
	public Class<? extends IEObjectHoverProvider> bindIEObjectHoverProvider() {
		return SsHoverProvider.class;
	}

	public Class<? extends EclipseResourceFileSystemAccess2> bindEclipseResourceFileSystemAccess2() {
		return SourceRelativeFileSystemAccess.class;
	}

	@Override
	public Class<? extends IXtextBuilderParticipant> bindIXtextBuilderParticipant() {
		return SsBuilderParticipant.class;
	}

	@Override
	public Class<? extends ISingleLineCommentHelper> bindISingleLineCommentHelper() {
		return SingleLineCommentHelper.class;
	}

	public Class<? extends XtextSourceViewer.Factory> bindSourceViewerFactory() {
		return RichStringAwareSourceViewer.Factory.class;
	}

	public Class<? extends ToggleSLCommentAction.Factory> bindToggleCommentFactory() {
		return RichStringAwareToggleCommentAction.Factory.class;
	}

	public Class<? extends IFoldingStructureProvider> bindIFoldingStructureProvider() {
		return InitiallyCollapsableAwareFoldingStructureProvider.class;
	}

	@Override
	public Class<? extends IContentFormatterFactory> bindIContentFormatterFactory() {
		// see https://bugs.eclipse.org/bugs/show_bug.cgi?id=361385
		return FormatterFactory.class;
	}

	@Override
	public Class<? extends IOccurrenceComputer> bindIOccurrenceComputer() {
		return OccurrenceComputer.class;
	}

	@Override
	public Class<? extends IXtextEditorCallback> bindIXtextEditorCallback() {
		return SsNatureAddingEditorCallback.class;
	}

	public Class<? extends IResourceUIServiceProvider> bindIResourceUIServiceProvider() {
		return SsResourceUiServiceProvider.class;
	}

	@Override
	public ICharacterPairMatcher bindICharacterPairMatcher() {
		return new DefaultCharacterPairMatcher(new char[] { '(', ')', '{', '}', '[', ']', '�', '�' });
	}

	@Override
	public void configureIPreferenceStoreInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class)
			.annotatedWith(Names.named("RefactoringPreferences"))
			.to(SsRefactoringPreferences.Initializer.class);
	}

	@Override
	public Class<? extends IRenameContextFactory> bindIRenameContextFactory() {
		return SsRenameContextFactory.class;
	}

	public Class<? extends RenameElementProcessor> bindRenameElementProcessor() {
		return SsRenameElementProcessor.class;
	}

	@Override
	public Class<? extends IRenameStrategy> bindIRenameStrategy() {
		return SsRenameStrategy.class;
	}

	@Override
	public java.lang.Class<? extends IDependentElementsCalculator> bindIDependentElementsCalculator() {
		return SsDependentElementsCalculator.class;
	}
	
	@Override
	public void configureJvmMemberRenameStrategy$Provider$Delegate(Binder binder) {
		binder.bind(IRenameStrategy.Provider.class)
			.annotatedWith(JvmMemberRenameStrategy.Provider.Delegate.class)
			.to(SsRenameStrategyProvider.class);
	}
		
	public Class<? extends JdtRenameRefactoringParticipantProcessor> bindJdtRenameRefactoringParticipantProcessor() {
		return SsJdtRenameParticipantProcessor.class;
	}
	
	public Class<? extends XbaseDeclarativeHoverSignatureProvider> bindXbaseDeclarativeHoverSignatureProvider() {
		return SsHoverSignatureProvider.class;
	}

	@Override
	public Class<? extends IEObjectHoverDocumentationProvider> bindIEObjectHoverDocumentationProvider() {
		return SsHoverDocumentationProvider.class;
	}

	@Override
	public Class<? extends org.eclipse.xtext.ui.editor.XtextEditor> bindXtextEditor() {
		return XbaseEditor.class;
	}

	@Override
	public Class<? extends ITemplateProposalProvider> bindITemplateProposalProvider() {
		return TemplateProposalProvider.class;
	}

	public Class<? extends ITraceForStorageProvider> bindTraceInformation() {
		return TraceForStorageProvider.class;
	}

	public Class<? extends IEditedResourceProvider> bindIEditedResourceProvider() {
		return FormatterResourceProvider.class;
	}

	public void configureFilterSyntheticMembersContribution(Binder binder) {
		binder.bind(IOutlineContribution.class).annotatedWith(Names.named("FilterSyntheticsContribution"))
				.to(ShowSyntheticMembersContribution.class);
	}

	@Override
	@org.eclipse.xtext.service.SingletonBinding(eager = true)
	public Class<? extends org.summer.dsl.xbase.ui.validation.XbaseUIValidator> bindXbaseUIValidator() {
		return org.summer.ss.ide.validator.SsUIValidator.class;
	}
	
	@SingletonBinding(eager = true)
	public Class<? extends JavaProjectPreferencesInitializer> bindJavaProjectPreferencesInitializer() {
		return JavaProjectPreferencesInitializer.class;
	}

	@Override
	public void configureSmartCaretPreferenceInitializer(Binder binder) {
		binder.bind(IPreferenceStoreInitializer.class).annotatedWith(Names.named("smartCaretPreferenceInitializer")) //$NON-NLS-1$
				.to(SsPreferenceStoreInitializer.class);
	}
	
	public Class<? extends IssueSeveritiesProvider> bindIssueSeverityServiceProvider() {
		return XbaseIssueSeveritiesProvider.class;
	}
	
	public Class<? extends XtextSourceViewerConfiguration> bindSourceViewerConfiguration(){
		return SsSourceViewerConfiguration.class;
	}

	public Class<? extends DocumentTokenSource> bindDocumentTokenSource(){
		return SsDocumentTokenSource.class;
	}
	
	public Class<? extends AbstractValidatorConfigurationBlock> bindAbstractValidatorConfigurationBlock() {
		return XtendValidatorConfigurationBlock.class;
	}
	
	public Class<? extends ProcessorInstanceForJvmTypeProvider> bindProcessorInstanceForJvmTypeProvider() {
		return JdtBasedProcessorProvider.class;
	}

	@Override
	public Class<? extends IContentAssistantFactory> bindIContentAssistantFactory() {
		return SsContentAssistFactory.class;
	}
	
	@Override
	public Class<? extends IResourceForEditorInputFactory> bindIResourceForEditorInputFactory() {
		return XbaseResourceForEditorInputFactory.class;
	}
	
	public Class<? extends IContextInformationProvider> bindIContextInformationProvider() {
		return ParameterContextInformationProvider.class;
	}
	
	public Class<? extends PrefixMatcher.CamelCase> bindCamelCasePrefixMatcher() {
		return EscapeSequenceAwarePrefixMatcher.class;
	}
	
	@Override
	public Class<? extends ILabelProvider> bindILabelProvider() {
		return SsLabelProvider.class;
	}
	
	public Class<? extends ResourceDescriptionsProvider> bindResourceDescriptionsProvider() {
		return SsResourceDescriptionsProvider.class;
	}
	
	public Class<? extends IReferenceFinder> bindIReferenceFinder() {
		return SsReferenceFinder.class;
	}
	
	public Class<? extends JavaTypeQuickfixes> bindJavaTypeQuickfixes() {
		return TypeLiteralAwareJavaTypeQuickfixes.class;
	}
	
	public Class<? extends ICompletionProposalComparator> bindICompletionProposalComparator() {
		return OperatorAwareComparator.class;
	}
	
	public Class<? extends MutableFileSystemSupport> bindFileSystemSupport() {
		return AbstractFileSystemSupport.class;
	}
	
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return EclipseFileSystemSupportImpl.class;
	}
	
	public void configureWorkspaceConfigContribution(Binder binder) {
		binder.bind(WorkspaceConfig.class).toProvider(EclipseWorkspaceConfigProvider.class);
	}
	
	@Override
	public Class<? extends CopyQualifiedNameService> bindCopyQualifiedNameService() {
		return SsCopyQualifiedNameService.class;
	}
	
	public Class<? extends IContentProposalPriorities> bindIContentProposalPriorities() {
		return XbaseContentProposalPriorities.class;
	}

}
