/*
 * generated by Xtext
 */
package org.summer.ss.core;

import org.summer.ss.core.compiler.UnicodeAwarePostProcessor;
import org.summer.ss.core.compiler.SsCompiler;
import org.summer.ss.core.compiler.XtendGenerator;
import org.summer.ss.core.compiler.SsOutputConfigurationProvider;
import org.summer.ss.core.conversion.JavaIDValueConverter;
import org.summer.ss.core.conversion.SsValueConverterService;
import org.summer.ss.core.documentation.XtendDocumentationProvider;
import org.summer.ss.core.formatting.SsFormatter;
import org.summer.ss.core.imports.SsImportsConfiguration;
import org.summer.ss.core.jvmmodel.IXtendJvmAssociations;
import org.summer.ss.core.jvmmodel.SsJvmModelInferrer;
import org.summer.ss.core.linking.Linker;
import org.summer.ss.core.linking.LinkingProxyAwareResource;
import org.summer.ss.core.linking.URIEncoder;
import org.summer.ss.core.linking.SsLinkingDiagnosticMessageProvider;
import org.summer.ss.core.naming.SsQualifiedNameProvider;
import org.summer.ss.core.resource.SsLocationInFileProvider;
import org.summer.ss.core.resource.SsResourceDescriptionManager;
import org.summer.ss.core.resource.SsResourceDescriptionStrategy;
import org.summer.ss.core.scoping.SsImportedNamespaceScopeProvider;
import org.summer.ss.core.scoping.SsScopeProvider;
import org.summer.ss.core.typesystem.DispatchAndExtensionAwareReentrantTypeResolver;
import org.summer.ss.core.typesystem.TypeDeclarationAwareBatchTypeResolver;
import org.summer.ss.core.typesystem.XtendTypeComputer;
import org.summer.ss.core.typing.XtendExpressionHelper;
import org.summer.ss.core.validation.SsConfigurableIssueCodes;
import org.summer.ss.core.validation.SsEarlyExitValidator;
import org.summer.dsl.model.ss.SsFactory;
import org.summer.ss.lib.macro.file.FileLocations;
import org.summer.ss.lib.macro.file.MutableFileSystemSupport;
import org.eclipse.xtext.conversion.IValueConverterService;
import org.eclipse.xtext.conversion.impl.IDValueConverter;
import org.eclipse.xtext.documentation.IEObjectDocumentationProvider;
import org.eclipse.xtext.generator.IGenerator;
import org.eclipse.xtext.generator.IOutputConfigurationProvider;
import org.eclipse.xtext.linking.ILinker;
import org.eclipse.xtext.linking.ILinkingDiagnosticMessageProvider;
import org.eclipse.xtext.linking.lazy.LazyURIEncoder;
import org.eclipse.xtext.naming.IQualifiedNameProvider;
import org.eclipse.xtext.parser.IParser;
import org.eclipse.xtext.resource.IDefaultResourceDescriptionStrategy;
import org.eclipse.xtext.resource.ILocationInFileProvider;
import org.eclipse.xtext.resource.IResourceDescription.Manager;
import org.eclipse.xtext.resource.IResourceDescriptions;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.resource.impl.EagerResourceSetBasedResourceDescriptions;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.AbstractDeclarativeScopeProvider;
import org.eclipse.xtext.validation.CompositeEValidator;
import org.eclipse.xtext.validation.ConfigurableIssueCodesProvider;
import org.eclipse.xtext.validation.IResourceValidator;
import org.summer.dsl.model.xbase.XbaseFactory;
import org.summer.dsl.xbase.compiler.XbaseCompiler;
import org.summer.dsl.xbase.compiler.output.TraceAwarePostProcessor;
import org.summer.dsl.xbase.file.AbstractFileSystemSupport;
import org.summer.dsl.xbase.file.FileLocationsImpl;
import org.summer.dsl.xbase.file.JavaIOFileSystemSupport;
import org.summer.dsl.xbase.file.RuntimeWorkspaceConfigProvider;
import org.summer.dsl.xbase.file.WorkspaceConfig;
import org.summer.dsl.xbase.formatting.IBasicFormatter;
import org.summer.dsl.xbase.imports.IImportsConfiguration;
import org.summer.dsl.xbase.jvmmodel.IJvmModelInferrer;
import org.summer.dsl.xbase.jvmmodel.JvmModelAssociator;
import org.summer.dsl.xbase.typesystem.computation.ITypeComputer;
import org.summer.dsl.xbase.typesystem.internal.DefaultBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.internal.DefaultReentrantTypeResolver;
import org.summer.dsl.xbase.util.XExpressionHelper;
import org.summer.dsl.xbase.validation.EarlyExitValidator;

import com.google.inject.Binder;
import com.google.inject.name.Names;

/**
 * Use this class to register components to be used at runtime / without the Equinox extension registry.
 */
@SuppressWarnings("deprecation")
public class SsRuntimeModule extends org.summer.ss.core.AbstractSsRuntimeModule {
	
	public XbaseFactory bindXbaseFactory() {
		return XbaseFactory.eINSTANCE;
	}
	
	public Class<? extends XExpressionHelper> bindXExpressionHelper() {
		return XtendExpressionHelper.class;
	}
	
	@Override
	public Class<? extends IValueConverterService> bindIValueConverterService() {
		return SsValueConverterService.class;
	}
	
	@Override
	public void configureIScopeProviderDelegate(Binder binder) {
		binder.bind(IScopeProvider.class).annotatedWith(Names.named(AbstractDeclarativeScopeProvider.NAMED_DELEGATE))
			.to(SsImportedNamespaceScopeProvider.class);
	}

	@Override
	public Class<? extends IQualifiedNameProvider> bindIQualifiedNameProvider() {
		return SsQualifiedNameProvider.class;
	}
	
	@Override
	public Class <? extends IDefaultResourceDescriptionStrategy> bindIDefaultResourceDescriptionStrategy() {
		return SsResourceDescriptionStrategy.class;
	}

	public Class<? extends JvmModelAssociator> bindJvmModelAssociator() {
		return IXtendJvmAssociations.Impl.class;
	}

	public Class<? extends EarlyExitValidator> bindEarlyExitValidator() {
		return SsEarlyExitValidator.class;
	}
	
	public Class<? extends IOutputConfigurationProvider> bindIOutputConfigurationProvider() {
		return SsOutputConfigurationProvider.class;
	}
	
	@Override
	public Class<? extends IScopeProvider> bindIScopeProvider() {
		return SsScopeProvider.class;
	}

	@Override
	public Class<? extends ILocationInFileProvider> bindILocationInFileProvider() {
		return SsLocationInFileProvider.class;
	}

	@Override
	public Class<? extends ILinkingDiagnosticMessageProvider> bindILinkingDiagnosticMessageProvider() {
		return SsLinkingDiagnosticMessageProvider.class;
	}
	
	public Class<? extends IBasicFormatter> bindIBasicFormatter() {
		return SsFormatter.class;
	}

	public Class<? extends IImportsConfiguration> bindIImportsConfiguration() {
		return SsImportsConfiguration.class;
	}

	@Override
	public Class<? extends ConfigurableIssueCodesProvider> bindConfigurableIssueCodesProvider() {
		return SsConfigurableIssueCodes.class;
	}
	
	public SsFactory bindXtendFactory() {
		return SsFactory.eINSTANCE;
	}

	@Override
	public Class<? extends DefaultBatchTypeResolver> bindDefaultBatchTypeResolver() {
		return TypeDeclarationAwareBatchTypeResolver.class;
	}

	@Override
	public Class<? extends DefaultReentrantTypeResolver> bindDefaultReentrantTypeResolver() {
		return DispatchAndExtensionAwareReentrantTypeResolver.class;
	}
	
	public Class<? extends XbaseCompiler> bindXbaseCompiler() {
		return SsCompiler.class;
	}
	
	public Class<? extends TraceAwarePostProcessor> bindTraceAwarePostProcessor() {
		return UnicodeAwarePostProcessor.class;
	}

	@Override
	public Class<? extends ITypeComputer> bindITypeComputer() {
		return XtendTypeComputer.class;
	}

	public Class<? extends IJvmModelInferrer> bindIJvmModelInferrer() {
		return SsJvmModelInferrer.class;
	}
	
	@Override
	public Class<? extends Manager> bindIResourceDescription$Manager() {
		return SsResourceDescriptionManager.class;
	}
	
	@Override
	public void configure(Binder binder) {
		super.configure(binder);
		binder.bind(boolean.class).annotatedWith(
				Names.named(CompositeEValidator.USE_EOBJECT_VALIDATOR)).toInstance(false);
	}
	
	@Override
	public Class<? extends IResourceValidator> bindIResourceValidator() {
		return org.summer.ss.core.validation.CachingResourceValidatorImpl.class;
	}
	
	@Override
	public Class<? extends ILinker> bindILinker() {
		return Linker.class;
	}
	
	@Override
	public Class<? extends XtextResource> bindXtextResource() {
		return LinkingProxyAwareResource.class;
	}
	
	public Class<? extends LazyURIEncoder> bindLazyURIEncoder() {
		return URIEncoder.class;
	}
	
	/**
	 * @since 2.4.2
	 */
	@Override
	public void configureIResourceDescriptions(com.google.inject.Binder binder) {
		binder.bind(IResourceDescriptions.class).to(EagerResourceSetBasedResourceDescriptions.class);
	}
	
	public Class<? extends MutableFileSystemSupport> bindFileHandleFactory() {
		return AbstractFileSystemSupport.class;
	}
	
	public Class<? extends AbstractFileSystemSupport> bindAbstractFileSystemSupport() {
		return JavaIOFileSystemSupport.class;
	}
	
	@Override
	public Class<? extends IGenerator> bindIGenerator() {
		return XtendGenerator.class;
	}
	
	public void configureWorkspaceConfigContribution(Binder binder) {
		binder.bind(WorkspaceConfig.class).toProvider(RuntimeWorkspaceConfigProvider.class);
	}
	
	public Class<? extends FileLocations> bindFileLocations() {
		return FileLocationsImpl.class;
	}
	
	public Class<? extends IDValueConverter> bindIDValueConverter() {
		return JavaIDValueConverter.class;
	}
	
	public Class<? extends IEObjectDocumentationProvider> bindIEObjectDocumentationProvider() {
		return XtendDocumentationProvider.class;
	}
	
	@Override
	public Class<? extends IParser> bindIParser() {
		return ParserWithoutPartialParsing.class;
	}
}
