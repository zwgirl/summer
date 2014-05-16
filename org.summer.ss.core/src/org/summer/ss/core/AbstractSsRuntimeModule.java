/*
 * generated by Xtext
 */
package org.summer.ss.core;

import java.util.Properties;

import org.eclipse.ui.editors.text.templates.ContributionContextTypeRegistry;
import org.eclipse.xtext.Constants;
import org.eclipse.xtext.service.DefaultRuntimeModule;
import org.summer.ss.core.scoping.XSsBatchScopeProvider;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Manual modifications go to {org.summer.ss.core.SsRuntimeModule}
 */
 @SuppressWarnings("all")
public abstract class AbstractSsRuntimeModule extends DefaultRuntimeModule {

	 protected Properties properties = null;
	 ContributionContextTypeRegistry a;  // class not load

	@Override
	public void configure(Binder binder) {
		properties = tryBindProperties(binder, "org/summer/ss/core/Xtend.properties");
		super.configure(binder);
	}
	
	public void configureLanguageName(Binder binder) {
		binder.bind(String.class).annotatedWith(Names.named(Constants.LANGUAGE_NAME)).toInstance("org.summer.ss.core.Ss");
	}
	
	public void configureFileExtensions(Binder binder) {
		if (properties == null || properties.getProperty(Constants.FILE_EXTENSIONS) == null)
			binder.bind(String.class).annotatedWith(Names.named(Constants.FILE_EXTENSIONS)).toInstance("ss");
	}
	
	// contributed by org.eclipse.xtext.generator.grammarAccess.GrammarAccessFragment
	public Class<? extends org.eclipse.xtext.IGrammarAccess> bindIGrammarAccess() {
		return org.summer.ss.core.services.SsGrammarAccess.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	public Class<? extends org.eclipse.xtext.serializer.sequencer.ISemanticSequencer> bindISemanticSequencer() {
		return org.summer.ss.core.serializer.SsSemanticSequencer.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	public Class<? extends org.eclipse.xtext.serializer.sequencer.ISyntacticSequencer> bindISyntacticSequencer() {
		return org.summer.ss.core.serializer.SsSyntacticSequencer.class;
	}

	// contributed by org.eclipse.xtext.generator.serializer.SerializerFragment
	public Class<? extends org.eclipse.xtext.serializer.ISerializer> bindISerializer() {
		return org.eclipse.xtext.serializer.impl.Serializer.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.IParser> bindIParser() {
		return org.summer.ss.core.parser.antlr.SsParser.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.ITokenToStringConverter> bindITokenToStringConverter() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenToStringConverter.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.IAntlrTokenFileProvider> bindIAntlrTokenFileProvider() {
		return org.summer.ss.core.parser.antlr.SsAntlrTokenFileProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.Lexer> bindLexer() {
		return org.summer.ss.core.parser.antlr.internal.InternalSsLexer.class;
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public com.google.inject.Provider<org.summer.ss.core.parser.antlr.internal.InternalSsLexer> provideInternalXtendLexer() {
		return org.eclipse.xtext.parser.antlr.LexerProvider.create(org.summer.ss.core.parser.antlr.internal.InternalSsLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public void configureRuntimeLexer(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.parser.antlr.Lexer.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.parser.antlr.LexerBindings.RUNTIME)).to(org.summer.ss.core.parser.antlr.internal.InternalSsLexer.class);
	}

	// contributed by org.eclipse.xtext.generator.parser.antlr.XtextAntlrGeneratorFragment
	public Class<? extends org.eclipse.xtext.parser.antlr.ITokenDefProvider> bindITokenDefProvider() {
		return org.eclipse.xtext.parser.antlr.AntlrTokenDefProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.validation.JavaValidatorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.summer.ss.core.validation.SsJavaValidator> bindXtendJavaValidator() {
		return org.summer.ss.core.validation.SsJavaValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.scoping.AbstractScopingFragment
	public void configureIgnoreCaseLinking(com.google.inject.Binder binder) {
		binder.bindConstant().annotatedWith(org.eclipse.xtext.scoping.IgnoreCaseLinking.class).to(false);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.resource.IContainer.Manager> bindIContainer$Manager() {
		return org.eclipse.xtext.resource.containers.StateBasedContainerManager.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public Class<? extends org.eclipse.xtext.resource.containers.IAllContainersState.Provider> bindIAllContainersState$Provider() {
		return org.eclipse.xtext.resource.containers.ResourceSetBasedAllContainersStateProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by org.eclipse.xtext.generator.builder.BuilderIntegrationFragment
	public void configureIResourceDescriptionsBuilderScope(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.resource.IResourceDescriptions.class).annotatedWith(com.google.inject.name.Names.named(org.eclipse.xtext.resource.impl.ResourceDescriptionsProvider.NAMED_BUILDER_SCOPE)).to(org.eclipse.xtext.resource.impl.ResourceSetBasedResourceDescriptions.class);
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public java.lang.ClassLoader bindClassLoaderToInstance() {
		return getClass().getClassLoader();
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public org.summer.dsl.model.types.TypesFactory bindTypesFactoryToInstance() {
		return org.summer.dsl.model.types.TypesFactory.eINSTANCE;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.access.IJvmTypeProvider.Factory> bindIJvmTypeProvider$Factory() {
		return org.summer.dsl.model.types.access.ClasspathTypeProviderFactory.class;
	}

	// contributed by org.eclipse.xtext.generator.types.TypesGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.xtext.AbstractTypeScopeProvider> bindAbstractTypeScopeProvider() {
		return org.summer.dsl.model.types.xtext.ClasspathBasedTypeScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.interpreter.IEvaluationContext> bindIEvaluationContext() {
		return org.summer.dsl.xbase.interpreter.impl.DefaultEvaluationContext.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.interpreter.IExpressionInterpreter> bindIExpressionInterpreter() {
		return org.summer.dsl.xbase.interpreter.impl.XbaseInterpreter.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameConverter> bindIQualifiedNameConverter() {
		return org.summer.dsl.xbase.XbaseQualifiedNameConverter.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.naming.IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return org.summer.dsl.xbase.scoping.XbaseQualifiedNameProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.conversion.IValueConverterService> bindIValueConverterService() {
		return org.summer.dsl.xbase.conversion.XbaseValueConverterService.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public void configureLinkingIScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(org.eclipse.xtext.linking.LinkingScopeProviderBinding.class).to(org.summer.dsl.xbase.scoping.batch.IBatchScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public void configureSerializerIScopeProvider(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(org.eclipse.xtext.serializer.tokens.SerializerScopeProviderBinding.class).to(org.summer.dsl.xbase.serializer.SerializerScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.typing.ITypeProvider> bindITypeProvider() {
		return org.summer.dsl.xbase.typesystem.legacy.XbaseBatchTypeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public void configureIScopeProviderDelegate(com.google.inject.Binder binder) {
		binder.bind(org.eclipse.xtext.scoping.IScopeProvider.class).annotatedWith(Names.named(org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider.NAMED_DELEGATE)).to(org.summer.dsl.xbase.scoping.XImportSectionNamespaceScopeProvider.class);
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.linking.ILinker> bindILinker() {
		return org.summer.dsl.xbase.linking.XbaseLazyLinker.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.util.TypeConformanceComputer> bindTypeConformanceComputer() {
		return org.summer.dsl.xbase.typesystem.legacy.LegacyTypeConformanceComputer.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.XtextResource> bindXtextResource() {
		return org.summer.dsl.xbase.resource.BatchLinkableResource.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	@org.eclipse.xtext.service.SingletonBinding(eager=true)	public Class<? extends org.summer.dsl.xbase.validation.JvmTypeReferencesValidator> bindJvmTypeReferencesValidator() {
		return org.summer.dsl.xbase.validation.JvmTypeReferencesValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.featurecalls.IdentifiableSimpleNameProvider> bindIdentifiableSimpleNameProvider() {
		return org.summer.dsl.xbase.featurecalls.IdentifiableSimpleNameProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.IDerivedStateComputer> bindIDerivedStateComputer() {
		return org.summer.dsl.xbase.jvmmodel.JvmModelAssociator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.IResourceDescription.Manager> bindIResourceDescription$Manager() {
		return org.eclipse.xtext.resource.DerivedStateAwareResourceDescriptionManager.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.generator.IGenerator> bindIGenerator() {
		return org.summer.dsl.xbase.compiler.JvmModelGenerator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public org.summer.dsl.model.xtype.XtypeFactory bindXtypeFactoryToInstance() {
		return org.summer.dsl.model.xtype.XtypeFactory.eINSTANCE;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.util.TypeArgumentContextProvider> bindTypeArgumentContextProvider() {
		return org.summer.dsl.xbase.typesystem.legacy.LegacyTypeArgumentContextProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.debug.IStratumBreakpointSupport> bindIStratumBreakpointSupport() {
		return org.summer.dsl.xbase.debug.XbaseStratumBreakpointSupport.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.generator.LineSeparatorHarmonizer> bindLineSeparatorHarmonizer() {
		return org.summer.dsl.xbase.compiler.output.TraceAwarePostProcessor.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return org.summer.dsl.xbase.resource.XbaseResourceDescriptionStrategy.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.validation.SeverityConverter> bindSeverityConverter() {
		return org.summer.dsl.xbase.validation.XbaseSeverityConverter.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.validation.ConfigurableIssueCodesProvider> bindConfigurableIssueCodesProvider() {
		return org.summer.dsl.xbase.validation.XbaseConfigurableIssueCodes.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.util.VisibilityService> bindVisibilityService() {
		return org.summer.dsl.xbase.typesystem.legacy.LegacyVisibilityService.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.model.types.util.FeatureOverridesService> bindFeatureOverridesService() {
		return org.summer.dsl.xbase.typesystem.legacy.LegacyFeatureOverridesService.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.EObjectAtOffsetHelper> bindEObjectAtOffsetHelper() {
		return org.summer.dsl.xbase.linking.BrokenConstructorCallAwareEObjectAtOffsetHelper.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.validation.CancelableDiagnostician> bindCancelableDiagnostician() {
		return org.summer.dsl.xbase.validation.XbaseDiagnostician.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.scoping.featurecalls.StaticImplicitMethodsFeatureForTypeProvider.ExtensionClassNameProvider> bindStaticImplicitMethodsFeatureForTypeProvider$ExtensionClassNameProvider() {
		return org.summer.dsl.xbase.scoping.batch.ImplicitlyImportedTypesAdapter.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.typesystem.computation.ITypeComputer> bindITypeComputer() {
		return org.summer.dsl.xbase.typesystem.computation.XbaseTypeComputer.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.scoping.IScopeProvider> bindIScopeProvider() {
		return org.summer.dsl.xbase.scoping.XbaseScopeProvider.class;
	}

//	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
//	public Class<? extends org.summer.dsl.xbase.scoping.batch.XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
//		return org.summer.dsl.xannotation.typesystem.XbaseWithAnnotationsBatchScopeProvider.class;
//	}
	
	public Class<? extends org.summer.dsl.xbase.scoping.batch.XbaseBatchScopeProvider> bindXbaseBatchScopeProvider() {
//		return org.summer.dsl.xannotation.typesystem.XbaseWithAnnotationsBatchScopeProvider.class;
		return XSsBatchScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return org.summer.ss.core.validation.UnresolvedAnnotationTypeAwareMessageProducer.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.resource.ILocationInFileProvider> bindILocationInFileProvider() {
		return org.summer.dsl.xbase.jvmmodel.JvmLocationInFileProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.scoping.IGlobalScopeProvider> bindIGlobalScopeProvider() {
		return org.summer.dsl.model.types.xtext.TypesAwareDefaultGlobalScopeProvider.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.validation.FeatureNameValidator> bindFeatureNameValidator() {
		return org.summer.dsl.xbase.validation.LogicalContainerAwareFeatureNameValidator.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.typesystem.internal.DefaultBatchTypeResolver> bindDefaultBatchTypeResolver() {
		return org.summer.dsl.xbase.typesystem.internal.LogicalContainerAwareBatchTypeResolver.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.summer.dsl.xbase.typesystem.internal.DefaultReentrantTypeResolver> bindDefaultReentrantTypeResolver() {
		return org.summer.dsl.xbase.typesystem.internal.LogicalContainerAwareReentrantTypeResolver.class;
	}

	// contributed by org.eclipse.xtext.generator.xbase.XbaseGeneratorFragment
	public Class<? extends org.eclipse.xtext.validation.IResourceValidator> bindIResourceValidator() {
		return org.summer.ss.core.validation.DerivedStateAwareResourceValidator.class;
	}

}
