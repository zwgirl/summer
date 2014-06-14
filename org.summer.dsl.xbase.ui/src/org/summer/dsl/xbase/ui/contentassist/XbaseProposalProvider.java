/*
* generated by Xtext
*/
package org.summer.dsl.xbase.ui.contentassist;

import static com.google.common.collect.Lists.newArrayList;
import static com.google.common.collect.Maps.newHashMap;
import static org.eclipse.xtext.util.Strings.isEmpty;
import static org.eclipse.xtext.util.Strings.notNull;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.jdt.core.search.IJavaSearchConstants;
import org.eclipse.jface.text.contentassist.ICompletionProposal;
import org.eclipse.jface.text.contentassist.IContextInformation;
import org.eclipse.jface.viewers.StyledString;
import org.eclipse.xtext.Assignment;
import org.eclipse.xtext.CrossReference;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.RuleCall;
import org.eclipse.xtext.conversion.IValueConverter;
import org.eclipse.xtext.conversion.ValueConverterException;
import org.eclipse.xtext.conversion.impl.QualifiedNameValueConverter;
import org.eclipse.xtext.naming.IQualifiedNameConverter;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.IScopeProvider;
import org.eclipse.xtext.scoping.impl.SimpleScope;
import org.eclipse.xtext.ui.editor.contentassist.ConfigurableCompletionProposal;
import org.eclipse.xtext.ui.editor.contentassist.ContentAssistContext;
import org.eclipse.xtext.ui.editor.contentassist.ICompletionProposalAcceptor;
import org.eclipse.xtext.ui.editor.contentassist.PrefixMatcher;
import org.eclipse.xtext.ui.editor.contentassist.RepeatedContentAssistProcessor;
import org.eclipse.xtext.util.Pair;
import org.eclipse.xtext.util.Triple;
import org.eclipse.xtext.util.Tuples;
import org.summer.dsl.model.types.JvmConstructor;
import org.summer.dsl.model.types.JvmEnumerationLiteral;
import org.summer.dsl.model.types.JvmEnumerationType;
import org.summer.dsl.model.types.JvmExecutable;
import org.summer.dsl.model.types.JvmFeature;
import org.summer.dsl.model.types.JvmField;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmGenericArrayTypeReference;
import org.summer.dsl.model.types.JvmIdentifiableElement;
import org.summer.dsl.model.types.JvmOperation;
import org.summer.dsl.model.types.JvmParameterizedTypeReference;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.JvmTypeReference;
import org.summer.dsl.model.types.TypesPackage;
import org.summer.dsl.model.types.xtext.ui.ITypesProposalProvider;
import org.summer.dsl.model.types.xtext.ui.TypeMatchFilters;
import org.summer.dsl.model.xbase.XAbstractFeatureCall;
import org.summer.dsl.model.xbase.XBinaryOperation;
import org.summer.dsl.model.xbase.XBlockStatment;
import org.summer.dsl.model.xbase.XCasePart;
import org.summer.dsl.model.xbase.XCatchClause;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XForLoopStatment;
import org.summer.dsl.model.xbase.XStatment;
import org.summer.dsl.model.xbase.XSwitchStatment;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.xbase.conversion.XbaseQualifiedNameValueConverter;
import org.summer.dsl.xbase.scoping.XbaseScopeProvider;
import org.summer.dsl.xbase.scoping.featurecalls.IValidatedEObjectDescription;
import org.summer.dsl.xbase.scoping.featurecalls.JvmFeatureDescription;
import org.summer.dsl.xbase.scoping.featurecalls.OperatorMapping;
import org.summer.dsl.xbase.services.XbaseGrammarAccess;
import org.summer.dsl.xbase.typesystem.IBatchTypeResolver;
import org.summer.dsl.xbase.typesystem.legacy.StandardTypeReferenceOwner;
import org.summer.dsl.xbase.typesystem.references.FunctionTypeReference;
import org.summer.dsl.xbase.typesystem.references.LightweightTypeReference;
import org.summer.dsl.xbase.typesystem.references.OwnedConverter;
import org.summer.dsl.xbase.typesystem.util.CommonTypeComputationServices;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.inject.Inject;

/**
 * see http://www.eclipse.org/Xtext/documentation/latest/xtext.html#contentAssist on how to customize content assistant
 */
@SuppressWarnings("deprecation")
public class XbaseProposalProvider extends AbstractXbaseProposalProvider implements RepeatedContentAssistProcessor.ModeAware {
	
	private final static Logger log = Logger.getLogger(XbaseProposalProvider.class);
	
	/**
	 * the user data key used to store the IEObjectDescription in the {@link ConfigurableCompletionProposal#setAdditionalData(String, Object)}
	 */
	public final static String DESCRIPTION_KEY = "xbase.description";
	
	@Inject
	private ITypesProposalProvider typeProposalProvider;
	
	@Inject
	private ValidFeatureDescription featureDescriptionPredicate;
	
	@Inject
	private XbaseGrammarAccess grammarAccess;
	
	@Inject
	private XbaseQualifiedNameValueConverter qualifiedNameValueConverter;
	
	@Inject
	private StaticQualifierPrefixMatcher staticQualifierPrefixMatcher;
	
	@Inject
	private CommonTypeComputationServices services; 
	
	@Inject
	private IBatchTypeResolver typeResolver;

	public String getNextCategory() {
		return getXbaseCrossReferenceProposalCreator().getNextCategory();
	}
	
	public void nextMode() {
		getXbaseCrossReferenceProposalCreator().nextMode();
	}
	
	public void reset() {
		getXbaseCrossReferenceProposalCreator().reset();
	}
	
	public boolean isLastMode() {
		return getXbaseCrossReferenceProposalCreator().isLastMode();
	}
	
	public XbaseReferenceProposalCreator getXbaseCrossReferenceProposalCreator() {
		return (XbaseReferenceProposalCreator) super.getCrossReferenceProposalCreator();
	}
	
	@Override
	public void createProposals(ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		// we install a caching scope provider so scopes won't be computed multiple times.
		IScopeProvider scopeProvider = super.getScopeProvider();
		try {
			this.cachingProvider = new CachingXbaseScopeProvider((XbaseScopeProvider)scopeProvider);
			this.getCrossReferenceProposalCreator().setScopeProvider(cachingProvider);
			super.createProposals(context, acceptor);
		} finally {
			this.cachingProvider = null;
			this.getCrossReferenceProposalCreator().setScopeProvider(scopeProvider);
		}
	}
	
	private CachingXbaseScopeProvider cachingProvider = null;
	
	@Override
	public XbaseScopeProvider getScopeProvider() {
		if (cachingProvider != null)
			return cachingProvider;
		return (XbaseScopeProvider) super.getScopeProvider();
	}
	
	private static class CachingXbaseScopeProvider extends XbaseScopeProvider {
		private XbaseScopeProvider delegate;
		private Map<Pair<EObject,EReference>, IScope> getScopeCache = newHashMap();
		private Map<Triple<XExpression,XExpression,EReference>, IScope> createFeatureCallScopeForReceiverCache = newHashMap();

		public CachingXbaseScopeProvider(XbaseScopeProvider delegate) {
			this.delegate = delegate;
		}
		
		@Override
		public IScope createSimpleFeatureCallScope(EObject context, EReference reference, Resource resource,
				boolean includeCurrentBlock, int idx) {
			// No caching, since this is not called multiples times.
			return delegate.createSimpleFeatureCallScope(context, reference, resource, includeCurrentBlock, idx);
		}
		
		@Override
		public IScope createFeatureCallScopeForReceiver(XExpression context, XExpression receiver, EReference reference) {
			Triple<XExpression,XExpression,EReference> key = Tuples.create(context, receiver, reference);
			if (createFeatureCallScopeForReceiverCache.containsKey(key)) {
				return createFeatureCallScopeForReceiverCache.get(key);
			} else {
				IScope result = delegate.createFeatureCallScopeForReceiver(context, receiver, reference);
				result = new SimpleScope(IScope.NULLSCOPE, newArrayList(result.getAllElements()));
				createFeatureCallScopeForReceiverCache.put(key, result);
				return result;
			}
		}
		
		@Override
		public IScope getScope(EObject context, EReference reference) {
			Pair<EObject,EReference> key = Tuples.create(context, reference);
			if (getScopeCache.containsKey(key)) {
				return getScopeCache.get(key);
			} else {
				IScope result = delegate.getScope(context, reference);
				result = new SimpleScope(IScope.NULLSCOPE, newArrayList(result.getAllElements()));
				getScopeCache.put(key, result);
				return result;
			}
		}

		@Override
		public IScopeProvider getDelegate() {
			return delegate.getDelegate();
		}

		@Override
		public boolean isFeatureCallScope(EReference reference) {
			return delegate.isFeatureCallScope(reference);
		}
		
	}
	
	public static class ValidFeatureDescription implements Predicate<IEObjectDescription> {

		@Inject
		private OperatorMapping operatorMapping;
		
		public boolean apply(IEObjectDescription input) {
			if (input instanceof IValidatedEObjectDescription) {
				final IValidatedEObjectDescription desc = (IValidatedEObjectDescription) input;
				if (!desc.isVisible() || !desc.isValidStaticState() || !desc.isValid())
					return false;
				JvmIdentifiableElement element = desc.getEObjectOrProxy();
				// TODO remove the workaround below
				if (element instanceof JvmOperation) {
					if ("java.lang.Object.finalize()".equals(element.getIdentifier()) ||
						"java.lang.Object.clone()".equals(element.getIdentifier())) {
						return false;
					}
				}
				// filter operator method names from CA
				return operatorMapping.getOperator(input.getName()) == null;
			}
			return true;
		}
		
	}
	
//	@Override
//	public void completeXImportDeclaration_ImportedType(EObject model, Assignment assignment, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		completeJavaTypes(context, XtypePackage.Literals.XIMPORT_DECLARATION__IMPORTED_TYPE, true,
//				getQualifiedNameValueConverter(), createVisibilityFilter(context, IJavaSearchConstants.TYPE), acceptor);
//	}

	@Override
	public void completeJvmParameterizedTypeReference_Type(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals() || getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
			completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
		}
	}
	
	@Override
	public void completeXRelationalExpression_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, acceptor);
	}

	protected void completeJavaTypes(ContentAssistContext context, EReference reference, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, reference, qualifiedNameValueConverter, createVisibilityFilter(context), acceptor);
	}
	
	protected void completeJavaTypes(ContentAssistContext context, EReference reference, ITypesProposalProvider.Filter filter, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, reference, qualifiedNameValueConverter, filter, acceptor);
	}
	
	protected void completeJavaTypes(ContentAssistContext context, EReference reference, IValueConverter<String> valueConverter, ITypesProposalProvider.Filter filter, ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, reference, false, valueConverter, filter, acceptor);
	}

	protected void completeJavaTypes(ContentAssistContext context, EReference reference, boolean forced,
			IValueConverter<String> valueConverter, ITypesProposalProvider.Filter filter,
			ICompletionProposalAcceptor acceptor) {
		String prefix = context.getPrefix();
		if (prefix.length() > 0) {
			if (Character.isJavaIdentifierStart(context.getPrefix().charAt(0))) {
				if (!forced && getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
					if (!prefix.contains(".") && !prefix.contains("::") && !Character.isUpperCase(prefix.charAt(0)))
						return;
				}
				typeProposalProvider.createTypeProposals(this, context, reference, filter, valueConverter, acceptor);
			}
		} else {
			if (forced || !getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
				INode lastCompleteNode = context.getLastCompleteNode();
				if (lastCompleteNode instanceof ILeafNode && !((ILeafNode) lastCompleteNode).isHidden()) {
					if (lastCompleteNode.getLength() > 0 && lastCompleteNode.getTotalEndOffset() == context.getOffset()) {
						String text = lastCompleteNode.getText();
						char lastChar = text.charAt(text.length() - 1);
						if (Character.isJavaIdentifierPart(lastChar)) {
							return;
						}
					}
				}
				typeProposalProvider.createTypeProposals(this, context, reference, filter, valueConverter, acceptor);
			}
		}
	}
	
	@Override
	public void completeXTypeLiteral_Type(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		completeJavaTypes(context, XbasePackage.Literals.XTYPE_LITERAL__TYPE, true, qualifiedNameValueConverter, createVisibilityFilter(context), acceptor);
	}
	
//	@Override
//	public void completeXFeatureCall_DeclaringType(EObject model, Assignment assignment, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		proposeDeclaringTypeForStaticInvocation(model, assignment, context, acceptor);
//	}
	
	
	public void proposeDeclaringTypeForStaticInvocation(EObject model, Assignment assignment, ContentAssistContext context, 
			ICompletionProposalAcceptor acceptor){
		if (getXbaseCrossReferenceProposalCreator().isShowTypeProposals() || getXbaseCrossReferenceProposalCreator().isShowSmartProposals()) {
			ContentAssistContext modifiedContext = context.copy().setMatcher(staticQualifierPrefixMatcher).toContext();
			completeJavaTypes(modifiedContext, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, qualifiedNameValueConverter, createVisibilityFilter(context), acceptor);
		}
	}
	
	protected ITypesProposalProvider.Filter createVisibilityFilter(ContentAssistContext context) {
		return createVisibilityFilter(context, IJavaSearchConstants.TYPE);
	}
	
	protected ITypesProposalProvider.Filter createVisibilityFilter(ContentAssistContext context, int searchFor) {
		return new TypeMatchFilters.All(searchFor);
	}
	
	@Override
	public void completeKeyword(Keyword keyword, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		if (isKeywordWorthyToPropose(keyword)) { 
			super.completeKeyword(keyword, contentAssistContext, acceptor);
		}
	}

	protected boolean isKeywordWorthyToPropose(Keyword keyword) {
		return keyword.getValue().length() > 1 && Character.isLetter(keyword.getValue().charAt(0));
	}
	
	@Override
	protected void lookupCrossReference(CrossReference crossReference, ContentAssistContext contentAssistContext,
			ICompletionProposalAcceptor acceptor) {
		lookupCrossReference(crossReference, contentAssistContext, acceptor, getFeatureDescriptionPredicate(contentAssistContext));
	}
	
//	@Override
//	public void completeXAssignment_Feature(EObject model, Assignment assignment, ContentAssistContext context,
//			ICompletionProposalAcceptor acceptor) {
//		//cym comment
////		if (assignment == getXAssignmentFeatureAssignment())
////			super.completeXAssignment_Feature(model, assignment, context, acceptor);
//	}
	//cym comment
//	protected Assignment getXAssignmentFeatureAssignment() {
//		return grammarAccess.getXAssignmentAccess().getFeatureAssignment_1_0_0_1();
//	}
	
	@Override
	public void completeXFeatureCall_Feature(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		if (model instanceof XBlockStatment) {
			XBlockStatment block = (XBlockStatment) model;
			if (!block.getStatments().isEmpty()) {
				EObject previousModel = context.getPreviousModel();
				if (context.getPreviousModel() == model) {
					for(XStatment expression: block.getStatments()) {
						ICompositeNode node = NodeModelUtils.findActualNodeFor(expression);
						if (node != null && node.getOffset() >= context.getOffset())
							break;
						previousModel = expression;
					}
				} else {
					while(previousModel.eContainer() != block) {
						previousModel = previousModel.eContainer();
					}
				}
				int idx = block.getStatments().indexOf(previousModel);
				createLocalVariableAndImplicitProposals(block, idx + 1, context, acceptor);
				return;
			}
		} 
		if (model instanceof XForLoopStatment) {
			ICompositeNode node = NodeModelUtils.getNode(model);
			if (node != null) {
				boolean eachExpression = false;
				for(INode leaf: node.getLeafNodes()) {
					if (leaf.getOffset() >= context.getOffset())
						break;
					if (leaf.getGrammarElement() == getXForLoopRightParenthesis()) {
						eachExpression = true;
						break;
					}
				}
				if (!eachExpression) {
					createLocalVariableAndImplicitProposals(model, false, -1, context, acceptor);
					return;
				}
			}
		}
		if (model == null || model instanceof XExpression || model instanceof XCatchClause) {
			createLocalVariableAndImplicitProposals(model, context, acceptor);
		}
	}

	protected Keyword getXForLoopRightParenthesis() {
		return grammarAccess.getXForLoopStatmentAccess().getRightParenthesisKeyword_6();
	}
	
	@Override
	public void completeXBlockStatment_Statments(EObject model, Assignment assignment,
			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		super.completeXBlockStatment_Statments(model, assignment, context, acceptor);
		completeWithinBlock(model, context, acceptor);
	}
	
//	@Override
//	public void completeXExpressionInClosure_Expressions(EObject model, Assignment assignment,
//			ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
//		super.completeXExpressionInClosure_Expressions(model, assignment, context, acceptor);
//		completeWithinBlock(model, context, acceptor);
//	}

	protected void completeWithinBlock(EObject model, ContentAssistContext context, ICompletionProposalAcceptor acceptor) {
		if (!(model instanceof XBlockStatment)) {
			EObject local = model;
			while(!(local.eContainer() instanceof XBlockStatment)) {
				local = local.eContainer();
				if (local == null)
					return;
			}
			XBlockStatment block = (XBlockStatment) local.eContainer();
			int idx = block.getStatments().indexOf(local);
			createLocalVariableAndImplicitProposals(block, idx + 1, context, acceptor);
		}
	}
	
	@Override
	public void completeXCasePart_Then(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeXCasePart_Then(model, assignment, context, acceptor);
		if (model instanceof XCasePart) {
			createLocalVariableAndImplicitProposals(model, -1, context, acceptor);
			
		}
	}
	
	@Override
	public void completeXCasePart_Case(EObject model, Assignment assignment, ContentAssistContext context,
			ICompletionProposalAcceptor acceptor) {
		super.completeXCasePart_Case(model, assignment, context, acceptor);
		if (model instanceof XCasePart) {
			createLocalVariableAndImplicitProposals(model, -1, context, acceptor);
		}
		XSwitchStatment switchExpression = EcoreUtil2.getContainerOfType(model, XSwitchStatment.class);
		if (switchExpression != null) {
			LightweightTypeReference switchExpressionType = typeResolver.resolveTypes(switchExpression).getActualType(switchExpression.getSwitch());
			if (switchExpressionType != null) {
				JvmType rawType = switchExpressionType.getType();
				if (rawType instanceof JvmEnumerationType) {
					final Function<IEObjectDescription, ICompletionProposal> proposalFactory = getProposalFactory(getFeatureCallRuleName(), context);
					Function<IEObjectDescription, ICompletionProposal> higherPriority = new Function<IEObjectDescription, ICompletionProposal>() {
						public ICompletionProposal apply(IEObjectDescription input) {
							ICompletionProposal result = proposalFactory.apply(input);
							if (result instanceof ConfigurableCompletionProposal) {
								ConfigurableCompletionProposal casted = (ConfigurableCompletionProposal) result;
								casted.setPriority(2* casted.getPriority());
							}
							return result;
						}
					};
					IScope literals = new SimpleScope(Lists.transform(((JvmEnumerationType) rawType).getLiterals(), new Function<JvmEnumerationLiteral, IEObjectDescription>() {
						public IEObjectDescription apply(JvmEnumerationLiteral literal) {
							return EObjectDescription.create(literal.getSimpleName(), literal);
						}
					}));
					getCrossReferenceProposalCreator().lookupCrossReference(
							literals,
							model,
							XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE,
							acceptor,
							getFeatureDescriptionPredicate(context),
							higherPriority);
				}
			}
		}
	}
	
	/**
	 * Customized to be able to treat binary operations in a special way with respect to scoping.
	 * Since the operator is a cross reference, we have to be careful to choose the right context for
	 * the scope provider. On the other hand it's important to filter "impossible" syntactical situations.
	 */
	@Override
	protected void lookupCrossReference(CrossReference crossReference, EReference reference,
			ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		if (reference == XbasePackage.Literals.XCONSTRUCTOR_CALL__CONSTRUCTOR) {
			completeJavaTypes(contentAssistContext, TypesPackage.Literals.JVM_PARAMETERIZED_TYPE_REFERENCE__TYPE, true,
					qualifiedNameValueConverter, TypeMatchFilters.and(TypeMatchFilters.canInstantiate(), createVisibilityFilter(contentAssistContext)), acceptor);
			return;
		}
		// guard for feature call scopes
		if (!getScopeProvider().isFeatureCallScope(reference)) {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		EObject model = contentAssistContext.getCurrentModel();
		if (model == contentAssistContext.getPreviousModel() || 
				!(contentAssistContext.getPreviousModel() instanceof XExpression)) {
			// check whether we have a binary operation that was already linked
			if (model instanceof XBinaryOperation) {
				XBinaryOperation binaryOperation = (XBinaryOperation) model;
				if (doNotProposeFeatureOfBinaryOperation(contentAssistContext, binaryOperation)) {
					return;
				}
			} else if (model instanceof XAbstractFeatureCall) {
				XAbstractFeatureCall memberFeatureCall = (XAbstractFeatureCall) model;
				List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(memberFeatureCall, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
				if (!nodesForFeature.isEmpty()) {
					INode node = nodesForFeature.get(0);
					if (node.getEndOffset() <= contentAssistContext.getOffset() - contentAssistContext.getPrefix().length()) {
						if (!Iterables.isEmpty(node.getLeafNodes())) {
							createReceiverProposals(memberFeatureCall, crossReference, reference, contentAssistContext,	acceptor, filter);
							return;
						}
					}
				} 
			}
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		if (model instanceof XBinaryOperation) {
			XBinaryOperation binaryOperation = (XBinaryOperation) model;
			if (contentAssistContext.getPreviousModel() == binaryOperation.getRightOperand()) {
				createReceiverProposals(binaryOperation.getRightOperand(), crossReference, reference, contentAssistContext,	acceptor, filter);
				return;
			}
		}
		if (model instanceof XAbstractFeatureCall) {
			ICompositeNode node = NodeModelUtils.findActualNodeFor(model);
			if (node != null) {
				int offset = node.getOffset();
				int length = node.getLength();
				if (offset + length >= contentAssistContext.getOffset()) {
					super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
					return;
				}
			}
		}
		if (model != null && !(model instanceof XExpression)) {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
			return;
		}
		
		if(contentAssistContext.getPreviousModel() instanceof XExpression) {
			createReceiverProposals((XExpression) contentAssistContext.getPreviousModel(), crossReference, reference, contentAssistContext,	acceptor, filter);
		} else {
			super.lookupCrossReference(crossReference, reference, contentAssistContext, acceptor, filter);
		}
	}
	
	protected void createLocalVariableAndImplicitProposals(EObject context, int idx, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(context, true, idx, contentAssistContext, acceptor);
	}
	
	protected void createLocalVariableAndImplicitProposals(EObject context, boolean includeCurrentObject, int idx, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		Function<IEObjectDescription, ICompletionProposal> proposalFactory = getProposalFactory(getFeatureCallRuleName(), contentAssistContext);
		IScope scope = getScopeProvider().createSimpleFeatureCallScope(context, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, contentAssistContext.getResource(), includeCurrentObject, idx);
		getCrossReferenceProposalCreator().lookupCrossReference(scope, context, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE, acceptor, getFeatureDescriptionPredicate(contentAssistContext), proposalFactory);
		
		proposeDeclaringTypeForStaticInvocation(context, null /* ignore */, contentAssistContext, acceptor);
	}

	protected String getFeatureCallRuleName() {
		return "IdOrSuper";
	}
	
	/**
	 * Create proposal for {@link XAbstractFeatureCall#getFeature() simple feature calls} that use an <code>IdOrSuper</code>
	 * as concrete syntax.
	 */
	protected void createLocalVariableAndImplicitProposals(EObject context, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor) {
		createLocalVariableAndImplicitProposals(context, -1, contentAssistContext, acceptor);
	}

	protected void createReceiverProposals(XExpression receiver, CrossReference crossReference,
			EReference reference, ContentAssistContext contentAssistContext, ICompletionProposalAcceptor acceptor,
			Predicate<IEObjectDescription> filter) {
		String ruleName = null;
		if (crossReference.getTerminal() instanceof RuleCall) {
			ruleName = ((RuleCall) crossReference.getTerminal()).getRule().getName();
		}
		Function<IEObjectDescription, ICompletionProposal> proposalFactory = getProposalFactory(ruleName, contentAssistContext);
		IScope scope = getScopeProvider().createFeatureCallScopeForReceiver(receiver, receiver, reference);
		getCrossReferenceProposalCreator().lookupCrossReference(scope, receiver, reference, acceptor, filter, proposalFactory);
	}

	protected boolean doNotProposeFeatureOfBinaryOperation(ContentAssistContext contentAssistContext,
			XBinaryOperation binaryOperation) {
		List<INode> nodesForFeature = NodeModelUtils.findNodesForFeature(binaryOperation, XbasePackage.Literals.XABSTRACT_FEATURE_CALL__FEATURE);
		if (!nodesForFeature.isEmpty()) {
			INode node = nodesForFeature.get(0);
			if (node.getOffset() < contentAssistContext.getOffset() - contentAssistContext.getPrefix().length()) {
				XExpression rightOperand = binaryOperation.getRightOperand();
				if (rightOperand == null)
					return true;
				ICompositeNode rightOperandNode = NodeModelUtils.findActualNodeFor(rightOperand);
				if (rightOperandNode != null) {
					if (rightOperandNode.getOffset() >= contentAssistContext.getOffset())
						return true;
					if (isParentOf(rightOperandNode, contentAssistContext.getLastCompleteNode()))
						return true;
				}
			}
		}
		return false;
	}
	
	protected boolean isParentOf(INode node, INode child) {
		if (node == null)
			return false;
		while(child != null && node.equals(child)) {
			child = child.getParent();
		}
		return node.equals(child);
	}

	@Override
	protected Function<IEObjectDescription, ICompletionProposal> getProposalFactory(final String ruleName,
			final ContentAssistContext contentAssistContext) {
		return new DefaultProposalCreator(contentAssistContext, ruleName, getQualifiedNameConverter()) {
			
			private Map<QualifiedName, ParameterData> simpleNameToParameterList = Maps.newHashMap();
			
			@Override
			public ICompletionProposal apply(final IEObjectDescription candidate) {
				IEObjectDescription myCandidate = candidate;
				ContentAssistContext myContentAssistContext = contentAssistContext;
				if (myCandidate instanceof MultiNameDescription) {
					final MultiNameDescription multiNamed = (MultiNameDescription) candidate;
					myCandidate = multiNamed.getDelegate();
					myContentAssistContext = myContentAssistContext.copy().setMatcher(new PrefixMatcher() {
						@Override
						public boolean isCandidateMatchingPrefix(String name, String prefix) {
							PrefixMatcher delegateMatcher = contentAssistContext.getMatcher();
							if (delegateMatcher.isCandidateMatchingPrefix(name, prefix))
								return true;
							IQualifiedNameConverter converter = getQualifiedNameConverter();
							String unconvertedName = converter.toString(candidate.getName());
							if (!unconvertedName.equals(name) && delegateMatcher.isCandidateMatchingPrefix(unconvertedName, prefix))
								return true;
							for(QualifiedName otherName: multiNamed.getOtherNames()) {
								String alternative = converter.toString(otherName);
								if (delegateMatcher.isCandidateMatchingPrefix(alternative, prefix))
									return true;
								String convertedAlternative = getValueConverter().toString(alternative, ruleName);
								if (!convertedAlternative.equals(alternative) && 
										delegateMatcher.isCandidateMatchingPrefix(convertedAlternative, prefix)) {
									return true;
								}
							}
							return false;
						}
					}).toContext();
				}
				if (myCandidate instanceof IValidatedEObjectDescription && (isIdRule(ruleName))) {
					ICompletionProposal result = null;
					String proposal = getQualifiedNameConverter().toString(myCandidate.getName());
					if (ruleName != null) {
						try {
							proposal = getValueConverter().toString(proposal, ruleName);
						} catch (ValueConverterException e) {
							log.debug(e.getMessage(), e);
							return null;
						}
					}
					ProposalBracketInfo bracketInfo = getProposalBracketInfo(myCandidate, contentAssistContext);
					proposal += bracketInfo.brackets;
					int insignificantParameters = 0;
					if(myCandidate instanceof JvmFeatureDescription) 
						insignificantParameters = ((JvmFeatureDescription) myCandidate).getNumberOfIrrelevantArguments();
					OwnedConverter converter = getTypeConverter(contentAssistContext.getResource());
					EObject objectOrProxy = myCandidate.getEObjectOrProxy();
					StyledString displayString = objectOrProxy instanceof JvmFeature 
							? getStyledDisplayString((JvmFeature)objectOrProxy,
								!isEmpty(bracketInfo.brackets), insignificantParameters,
								getQualifiedNameConverter().toString(myCandidate.getQualifiedName()),
								getQualifiedNameConverter().toString(myCandidate.getName()),
								converter)
							: getStyledDisplayString(objectOrProxy, 
								getQualifiedNameConverter().toString(myCandidate.getQualifiedName()), 
								getQualifiedNameConverter().toString(myCandidate.getName()));
					result = createCompletionProposal(proposal, displayString, null, myContentAssistContext);
					if (result instanceof ConfigurableCompletionProposal) {
						ConfigurableCompletionProposal casted = (ConfigurableCompletionProposal) result;
						casted.setAdditionalData(DESCRIPTION_KEY, myCandidate);
						casted.setAdditionalProposalInfo(objectOrProxy);
						casted.setHover(getHover());
						int offset = casted.getReplacementOffset() + proposal.length();
						casted.setCursorPosition(casted.getCursorPosition() + bracketInfo.caretOffset);
						if (bracketInfo.selectionOffset != 0) {
							offset += bracketInfo.selectionOffset;
							casted.setSelectionStart(offset);
							casted.setSelectionLength(bracketInfo.selectionLength);
							casted.setAutoInsertable(false);
							casted.setSimpleLinkedMode(myContentAssistContext.getViewer(), '\t', '\n', '\r');
						}
						if (objectOrProxy instanceof JvmExecutable) {
							JvmExecutable executable = (JvmExecutable) objectOrProxy;
							StyledString parameterList = new StyledString();
							appendParameters(parameterList, executable, insignificantParameters, converter);
							// TODO how should we display overloaded methods were one variant does not take arguments?
							if (parameterList.length() > 0) {
								ParameterData parameterData = simpleNameToParameterList.get(myCandidate.getName());
								if (parameterData == null) {
									parameterData = new ParameterData();
									simpleNameToParameterList.put(myCandidate.getName(), parameterData);
								}
								parameterData.addOverloaded(parameterList.toString(), executable.isVarArgs());
								IContextInformation contextInformation = new ParameterContextInformation(parameterData, displayString.toString(), offset, offset);
								casted.setContextInformation(contextInformation);
							}
						}
					}
					getPriorityHelper().adjustCrossReferencePriority(result, myContentAssistContext.getPrefix());
					return result;
				}
				return super.apply(candidate);
			}
		};
	}
	
	protected static class ProposalBracketInfo {
		String brackets = "";
		int selectionOffset = 0;
		int selectionLength = 0;
		int caretOffset = 0;
	}
	
	protected ProposalBracketInfo getProposalBracketInfo(IEObjectDescription proposedDescription, ContentAssistContext contentAssistContext) {
		ProposalBracketInfo info = new ProposalBracketInfo();
		if (proposedDescription instanceof JvmFeatureDescription) {
			JvmFeatureDescription jvmFeatureDescription = (JvmFeatureDescription)proposedDescription;
			JvmFeature jvmFeature = jvmFeatureDescription.getJvmFeature();
			if(jvmFeature instanceof JvmExecutable) {
				List<JvmFormalParameter> parameters = ((JvmExecutable) jvmFeature).getParameters();
				if (parameters.size() - jvmFeatureDescription.getNumberOfIrrelevantArguments() == 1) {
					JvmTypeReference parameterType = parameters.get(parameters.size()-1).getParameterType();
					LightweightTypeReference light = getTypeConverter(contentAssistContext.getResource()).apply(parameterType);
					if(light.isFunctionType()) {
						int numParameters = light.getAsFunctionTypeReference().getParameterTypes().size();
						if(numParameters == 1) {
							info.brackets = "[]"; 
							info.caretOffset = -1;
							return info;
						} else if(numParameters == 0) {
					 		info.brackets = "[|]"; 
							info.caretOffset = -1;
							return info;
						} else {
					 		final StringBuilder b = new StringBuilder();
					 		for(int i=0; i<numParameters; ++i) {
					 			if (i!=0) {
					 				b.append(", ");
					 			}
					 			b.append("p"+ (i+1));
					 		}
					 		info.brackets = "[" + b.toString() + "|]";
					 		info.caretOffset = -1;
					 		info.selectionOffset = -b.length() - 2;
					 		info.selectionLength = b.length();
					 		return info;
					 	}
					}
				} 
			}
			if (jvmFeatureDescription.getKey().endsWith(")")) {
				info.brackets = "()";
				info.selectionOffset = -1;
			}		
		}
		return info;
	}
	
	protected StyledString getStyledDisplayString(JvmFeature feature, boolean withParenths, 
			int insignificantParameters, String qualifiedNameAsString, String shortName,
			OwnedConverter converter) {
		StyledString result = new StyledString(shortName);
		if (feature instanceof JvmOperation) {
			JvmOperation operation = (JvmOperation) feature;
			if (withParenths) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature, insignificantParameters, converter);
				result.append(')');
			}
			JvmTypeReference returnType = operation.getReturnType();
			if (returnType != null && returnType.getSimpleName() != null) {
				result.append(" : ");
				result.append(converter.apply(returnType).getSimpleName());
			}
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(converter.toRawLightweightReference(feature.getDeclaringType()).getSimpleName(), StyledString.QUALIFIER_STYLER);
			if (!withParenths) {
				result.append(".", StyledString.QUALIFIER_STYLER);
				result.append(feature.getSimpleName(), StyledString.QUALIFIER_STYLER);
				result.append("()", StyledString.QUALIFIER_STYLER);
			}
		} else if (feature instanceof JvmField) {
			JvmField field = (JvmField) feature;
			result.append(" : ");
			if (field.getType() != null) {
				String fieldType = converter.apply(field.getType()).getSimpleName();
				if (fieldType != null)
					result.append(fieldType);
			}
			result.append(" - ", StyledString.QUALIFIER_STYLER);
			result.append(converter.toRawLightweightReference(feature.getDeclaringType()).getSimpleName(), StyledString.QUALIFIER_STYLER);
		} else if (feature instanceof JvmConstructor) {
			if (withParenths) {
				result.append('(');
				appendParameters(result, (JvmExecutable)feature, insignificantParameters, converter);
				result.append(')');
			}
		}
		return result;
	}

	protected void appendParameters(StyledString result, JvmExecutable executable, int insignificantParameters, OwnedConverter ownedConverter) {
		List<JvmFormalParameter> declaredParameters = executable.getParameters();
		List<JvmFormalParameter> relevantParameters = declaredParameters.subList(Math.min(insignificantParameters, declaredParameters.size()), declaredParameters.size());
		for(int i = 0; i < relevantParameters.size(); i++) {
			JvmFormalParameter parameter = relevantParameters.get(i);
			if (i != 0)
				result.append(", ");
			if (i == relevantParameters.size() - 1 && executable.isVarArgs() && parameter.getParameterType() instanceof JvmGenericArrayTypeReference) {
				JvmGenericArrayTypeReference parameterType = (JvmGenericArrayTypeReference) parameter.getParameterType();
				result.append(ownedConverter.apply(parameterType.getComponentType()).getSimpleName());
				result.append("...");
			} else {
				if (parameter.getParameterType()!= null) {
					String simpleName = ownedConverter.apply(parameter.getParameterType()).getSimpleName();
					if (simpleName != null) // is null if the file is not on the class path
						result.append(simpleName);
				}
			}
			result.append(' ');
			result.append(notNull(parameter.getSimpleName()));
		}
	}

	protected OwnedConverter getTypeConverter(XtextResource context) {
		return new OwnedConverter(new StandardTypeReferenceOwner(services, context)) {
			@Override
			public LightweightTypeReference doVisitParameterizedTypeReference(JvmParameterizedTypeReference reference) {
				LightweightTypeReference result = super.doVisitParameterizedTypeReference(reference);
				if (result.isFunctionType()) {
					FunctionTypeReference functionTypeReference = result.tryConvertToFunctionTypeReference(false);
					return functionTypeReference;
				}
				return result;
			}
		};
	}
	
	protected Predicate<IEObjectDescription> getFeatureDescriptionPredicate(ContentAssistContext contentAssistContext) {
		return featureDescriptionPredicate;
	}
	
	protected QualifiedNameValueConverter getQualifiedNameValueConverter() {
		return qualifiedNameValueConverter;
	}

	protected boolean isIdRule(final String ruleName) {
		return "IdOrSuper".equals(ruleName) || "ValidID".equals(ruleName) || "FeatureCallID".equals(ruleName); 
	}
}
