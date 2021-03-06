/*******************************************************************************
 * Copyright (c) 2011 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.ss.ide.highlighting;

import static com.google.common.collect.Iterables.*;

import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.jdt.annotation.NonNullByDefault;
import org.eclipse.jdt.annotation.Nullable;
import org.eclipse.jface.text.IRegion;
import org.eclipse.jface.text.Region;
import org.summer.ss.core.richstring.AbstractRichStringPartAcceptor;
import org.summer.ss.core.richstring.DefaultIndentationHandler;
import org.summer.ss.core.richstring.RichStringProcessor;
import org.summer.ss.core.services.SsGrammarAccess;
import org.summer.dsl.model.ss.CreateExtensionInfo;
import org.summer.dsl.model.ss.RichString;
import org.summer.dsl.model.ss.RichStringLiteral;
import org.summer.dsl.model.ss.XtendAnnotationTarget;
import org.summer.dsl.model.ss.XtendField;
import org.summer.dsl.model.ss.XtendFile;
import org.summer.dsl.model.ss.XtendFunction;
import org.summer.dsl.model.ss.XtendMember;
import org.summer.dsl.model.ss.SsPackage;
import org.eclipse.xtext.AbstractRule;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.GrammarUtil;
import org.eclipse.xtext.IGrammarAccess;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.TerminalRule;
import org.summer.dsl.model.types.JvmAnnotationTarget;
import org.summer.dsl.model.types.JvmAnnotationType;
import org.summer.dsl.model.types.JvmFormalParameter;
import org.summer.dsl.model.types.JvmType;
import org.summer.dsl.model.types.util.DeprecationUtil;
import org.eclipse.xtext.nodemodel.ICompositeNode;
import org.eclipse.xtext.nodemodel.ILeafNode;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.util.NodeModelUtils;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.DefaultHighlightingConfiguration;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.util.ITextRegion;
import org.summer.dsl.model.xbase.XExpression;
import org.summer.dsl.model.xbase.XbasePackage;
import org.summer.dsl.model.xannotation.XAnnotation;
import org.summer.dsl.xbase.ui.highlighting.XbaseHighlightingCalculator;
import org.summer.dsl.xbase.ui.highlighting.XbaseHighlightingConfiguration;

import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Provider;

/**
 * @author Sebastian Zarnekow - Initial contribution and API
 * @author Holger Schill
 */
public class SsHighlightingCalculator extends XbaseHighlightingCalculator {

	@Inject
	private RichStringProcessor processor;

	@Inject
	private Provider<DefaultIndentationHandler> indentationHandlerProvider;

	private Set<Keyword> contextualKeywords;
	
	@Inject
	private SsGrammarAccess xtendGrammarAccess;

	@Inject
	protected void setXtendGrammarAccess(IGrammarAccess grammarAccess) {
		ImmutableSet.Builder<Keyword> builder = ImmutableSet.builder();
		collectKeywordsFromRule(grammarAccess, "ValidID", builder);
		collectKeywordsFromRule(grammarAccess, "FeatureCallID", builder);
		contextualKeywords = builder.build();
	}

	@Override
	protected TerminalRule getIDRule() {
		return xtendGrammarAccess.getIDRule();
	}
	
	protected void collectKeywordsFromRule(IGrammarAccess grammarAccess, String ruleName, ImmutableSet.Builder<Keyword> builder) {
		AbstractRule rule = GrammarUtil.findRuleForName(grammarAccess.getGrammar(), ruleName);
		if (!(rule instanceof TerminalRule)) { // if someone decides to override ValidID with a terminal rule
			Iterator<EObject> i = rule.eAllContents();
			while (i.hasNext()) {
				EObject o = i.next();
				if (o instanceof Keyword) {
					builder.add((Keyword) o);
				}
			}
		}
	}

	@Override
	protected void doProvideHighlightingFor(XtextResource resource, IHighlightedPositionAcceptor acceptor) {
		XtendFile file = (XtendFile) resource.getContents().get(0);
		for (XtendAnnotationTarget xtendType : file.getXtendTypes()) {
			highlightDeprecatedXtendAnnotationTarget(acceptor, xtendType);
			highlightRichStringsInAnnotations(acceptor, xtendType);
			for (XtendMember member : filter(xtendType.eContents(), XtendMember.class)) {
				if (member.eClass() == SsPackage.Literals.XTEND_FUNCTION) {
					XtendFunction function = (XtendFunction) member;
					XExpression rootExpression = function.getExpression();
					highlightRichStrings(rootExpression, acceptor);
					CreateExtensionInfo createExtensionInfo = function.getCreateExtensionInfo();
					if (createExtensionInfo != null) {
						highlightRichStrings(createExtensionInfo.getCreateExpression(), acceptor);
					}
				}
				if(member.eClass() == SsPackage.Literals.XTEND_FIELD){
					XtendField field = (XtendField) member;
					highlightXtendField(field,acceptor);
					XExpression initializer = field.getInitialValue();
					highlightRichStrings(initializer, acceptor);
				}
				highlightDeprecatedXtendAnnotationTarget(acceptor, member);
				highlightRichStringsInAnnotations(acceptor, member);
			}
		}
		super.doProvideHighlightingFor(resource, acceptor);
	}

	protected void highlightRichStringsInAnnotations(IHighlightedPositionAcceptor acceptor, XtendAnnotationTarget target) {
		if (target != null) {
			for(XAnnotation annotation: target.getAnnotations()) {
				highlightRichStrings(annotation, acceptor);
			}
		}
	}

	protected void highlightDeprecatedXtendAnnotationTarget(IHighlightedPositionAcceptor acceptor, XtendAnnotationTarget target){
		if(target != null)
			for(XAnnotation annotation : target.getAnnotations()){
				JvmType annotationType = annotation.getAnnotationType();
				if(annotationType != null && !annotationType.eIsProxy() && annotationType instanceof JvmAnnotationType && DeprecationUtil.isDeprecated((JvmAnnotationType) annotationType)){
					EStructuralFeature nameFeature = target.eClass().getEStructuralFeature("name");
					highlightObjectAtFeature(acceptor, target, nameFeature, XbaseHighlightingConfiguration.DEPRECATED_MEMBERS);
				}
			}
	}

	protected void highlightRichStrings(XExpression expression, IHighlightedPositionAcceptor acceptor) {
		if (expression != null) {
			TreeIterator<EObject> iterator = EcoreUtil2.eAll(expression);
			while (iterator.hasNext()) {
				EObject object = iterator.next();
				if (object instanceof RichString) {
					RichStringHighlighter highlighter = createRichStringHighlighter(acceptor);
					processor.process((RichString) object, highlighter, indentationHandlerProvider.get());
					iterator.prune();
				}
			}
		}
	}

	protected RichStringHighlighter createRichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
		return new RichStringHighlighter(acceptor);
	}

	@Override
	protected void highlightSpecialIdentifiers(ILeafNode leafNode, IHighlightedPositionAcceptor acceptor,
			TerminalRule idRule) {
		super.highlightSpecialIdentifiers(leafNode, acceptor, idRule);
		if (contextualKeywords != null && contextualKeywords.contains(leafNode.getGrammarElement())) {
			ITextRegion leafRegion = leafNode.getTextRegion();
			acceptor.addPosition(leafRegion.getOffset(), leafRegion.getLength(),
					DefaultHighlightingConfiguration.DEFAULT_ID);
		}
	}
	

	protected void highlightXtendField(XtendField field, IHighlightedPositionAcceptor acceptor) {
		if(field.getName() != null && field.getName().length() > 0){
			List<INode> nodes = NodeModelUtils.findNodesForFeature(field, SsPackage.Literals.XTEND_FIELD__NAME);
			if(nodes.size() > 0){
				INode node = nodes.get(0);
				if(field.isStatic())
					highlightNode(node, XbaseHighlightingConfiguration.STATIC_FIELD, acceptor);
				else
					highlightNode(node, XbaseHighlightingConfiguration.FIELD, acceptor);
			}
		}
	}

	@NonNullByDefault
	protected class RichStringHighlighter extends AbstractRichStringPartAcceptor.ForLoopOnce {

		private int currentOffset = -1;
		private RichStringLiteral recent = null;
		private final IHighlightedPositionAcceptor acceptor;
		private Queue<IRegion> pendingRegions = Lists.newLinkedList();

		public RichStringHighlighter(IHighlightedPositionAcceptor acceptor) {
			this.acceptor = acceptor;
		}

		@Override
		public void announceNextLiteral(RichStringLiteral object) {
			resetCurrentOffset(object);
		}

		@Override
		public void acceptSemanticText(CharSequence text, @Nullable RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += text.length();
		}

		protected void resetCurrentOffset(@Nullable RichStringLiteral origin) {
			if (origin != null && origin != recent) {
				INode recentNode = null;
				if (recent != null && currentOffset != -1) {
					List<INode> featureNodes = NodeModelUtils.findNodesForFeature(recent,
							XbasePackage.Literals.XSTRING_LITERAL__VALUE);
					if (featureNodes.size() == 1) {
						recentNode = featureNodes.get(0);
						int closingQuoteLength = 0;
						if (recentNode.getText().endsWith("'''")) {
							closingQuoteLength = 3;
						} else if (recentNode.getText().endsWith("''")) {
							closingQuoteLength = 2;
						} else if (recentNode.getText().endsWith("'") || recentNode.getText().endsWith("\u00AB")) {
							closingQuoteLength = 1;
						}
						int expectedOffset = recentNode.getTotalEndOffset() - closingQuoteLength;
						if (expectedOffset != currentOffset) {
							pendingRegions.add(new Region(currentOffset, expectedOffset - currentOffset));
						}
					}
				}
				List<INode> featureNodes = NodeModelUtils.findNodesForFeature(origin,
						XbasePackage.Literals.XSTRING_LITERAL__VALUE);
				if (featureNodes.size() == 1) {
					INode node = featureNodes.get(0);
					currentOffset = node.getOffset();
					if (node.getText().charAt(0) == '\'') {
						acceptor.addPosition(currentOffset, 3, SsHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
						highlightClosingQuotes(node);
						currentOffset += 3;
					} else if (node.getText().startsWith("\u00AB\u00AB")) {
						String nodeText = node.getText();
						int lineFeed = nodeText.indexOf('\n');
						int length = lineFeed; 
						int carriageReturn = nodeText.indexOf('\r');
						if (carriageReturn != -1) {
							if (length == -1) {
								length = carriageReturn;
							} else {
								length = Math.min(carriageReturn, length);
							}
						}
						int start = node.getTotalOffset();
						if (length == -1) {
							length = node.getTotalLength();
						}
						if (recentNode != null && recentNode.getTotalEndOffset() == start) {
							start = start - 1;
							length = length + 1;
						}
						acceptor.addPosition(start, length, DefaultHighlightingConfiguration.COMMENT_ID);
						highlightClosingQuotes(node);
						currentOffset = start + length + 1;
						if (lineFeed == carriageReturn + 1)
							currentOffset++;
					} else {
						highlightClosingQuotes(node);
						currentOffset += 1;
					}
				}
				recent = origin;
			}
		}

		protected void highlightClosingQuotes(INode node) {
			int length = 0;
			if (node.getText().endsWith("'''")) {
				length = 3;
			} else if (node.getText().endsWith("''")) {
				length = 2;
			} else if (node.getText().endsWith("'")) {
				length = 1;
			}
			if (length != 0) {
				acceptor.addPosition(currentOffset + node.getLength() - length, length,
						SsHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
			}
		}

		@Override
		public void acceptTemplateText(CharSequence text, @Nullable RichStringLiteral origin) {
			resetCurrentOffset(origin);
			if (text.length() > 0) {
				int length = text.length();
				while (!pendingRegions.isEmpty()) {
					IRegion pending = pendingRegions.poll();
					length -= pending.getLength();
					acceptor.addPosition(pending.getOffset(), pending.getLength(),
							SsHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
				}
				if (length != 0) {
					acceptor.addPosition(currentOffset, length, SsHighlightingConfiguration.INSIGNIFICANT_TEMPLATE_TEXT);
					currentOffset += length;
				}
			}
		}

		@Override
		public void acceptSemanticLineBreak(int charCount, RichStringLiteral origin, boolean controlStructureSeen) {
			resetCurrentOffset(origin);
			if (controlStructureSeen)
				acceptor.addPosition(currentOffset, charCount, SsHighlightingConfiguration.POTENTIAL_LINE_BREAK);
			else
				acceptor.addPosition(currentOffset, charCount, SsHighlightingConfiguration.TEMPLATE_LINE_BREAK);
			currentOffset += charCount;
		}

		@Override
		public void acceptTemplateLineBreak(int charCount, RichStringLiteral origin) {
			resetCurrentOffset(origin);
			currentOffset += charCount;
		}

		@Override
		public void acceptIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptElseIfCondition(XExpression condition) {
			highlightRichStrings(condition, acceptor);
		}

		@Override
		public void acceptForLoop(JvmFormalParameter parameter, @Nullable XExpression expression) {
			highlightRichStrings(expression, acceptor);
			super.acceptForLoop(parameter, expression);
		}

		@Override
		public void acceptExpression(XExpression expression, CharSequence indentation) {
			highlightRichStrings(expression, acceptor);
		}
	}

}
