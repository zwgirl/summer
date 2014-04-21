package org.summer.xaml.core.ui.highlighting;

import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.COMMENT;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.GROUP;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.GROUP_NAME;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.PARAM;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.PARAM_VAL;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.PFT;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.STRING;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.VARIABLE;
import static org.summer.xaml.core.ui.highlighting.GuessHighlightingConfiguration.VARIABLE_VAL;

import org.eclipse.xtext.Group;
import org.eclipse.xtext.impl.TerminalRuleImpl;
import org.eclipse.xtext.nodemodel.BidiIterator;
import org.eclipse.xtext.nodemodel.BidiTreeIterator;
import org.eclipse.xtext.nodemodel.INode;
import org.eclipse.xtext.nodemodel.impl.CompositeNode;
import org.eclipse.xtext.nodemodel.impl.CompositeNodeWithSemanticElement;
import org.eclipse.xtext.nodemodel.impl.HiddenLeafNode;
import org.eclipse.xtext.resource.XtextResource;
import org.eclipse.xtext.ui.editor.syntaxcoloring.IHighlightedPositionAcceptor;
import org.eclipse.xtext.ui.editor.syntaxcoloring.ISemanticHighlightingCalculator;
import org.summer.dsl.ui.codetemplates.templates.Variable;

public class GuessHighlightingCalculator implements ISemanticHighlightingCalculator {

	@Override
	public void provideHighlightingFor(XtextResource resource,
			IHighlightedPositionAcceptor acceptor) {
//		if (resource == null || resource.getParseResult() == null)
//			return;
//		INode root = resource.getParseResult().getRootNode();
//		for (INode node : root.getAsTreeIterable()) {
//			if (node.getGrammarElement() instanceof CrossReference) {
//				acceptor.addPosition(node.getOffset(), node.getLength(),
//						HighlightingConfiguration.CROSS_REF);
//			}
//		}

		if (resource == null || resource.getParseResult() == null)
			return;

		INode root = resource.getParseResult().getRootNode();
		BidiTreeIterator<INode> it = root.getAsTreeIterable().iterator();
		while (it.hasNext()) {
			INode node = it.next();
			if (node instanceof CompositeNodeWithSemanticElement
					&& node.getSemanticElement() instanceof Group) {
				setStyles(acceptor, it, GROUP, GROUP_NAME, GROUP);
				setStyles(acceptor, node.getAsTreeIterable().reverse()
						.iterator(), null, GROUP);
			} else if (node instanceof CompositeNodeWithSemanticElement
					&& node.getSemanticElement() instanceof PFT) {
				setStyles(acceptor, it, PFT, GROUP_NAME, PFT);
				setStyles(acceptor, node.getAsTreeIterable().reverse()
						.iterator(), null, PFT);
			} else if (node.getSemanticElement() instanceof Include) {
				setStyles(acceptor, it, GROUP_NAME);
			} else if (node.getSemanticElement() instanceof Param
					&& node instanceof CompositeNode) {
				setStyles(acceptor, it, PARAM, STRING, null, PARAM_VAL, STRING,
						PARAM_VAL);
			} else if (node.getSemanticElement() instanceof Variable
					&& node instanceof CompositeNode) {
				setStyles(acceptor, it, VARIABLE, VARIABLE_VAL);
			} else if (node instanceof HiddenLeafNode
					&& node.getGrammarElement() instanceof TerminalRuleImpl) {
				TerminalRuleImpl ge = (TerminalRuleImpl) node
						.getGrammarElement();
				if (ge.getName().equalsIgnoreCase("GUESS_COMMENT"))
					acceptor.addPosition(node.getOffset(), node.getLength(),
							COMMENT);
			}
			// else
			// System.err.println( "Node: " + node.getClass().getSimpleName() +
			// " " + node.getGrammarElement().getClass().getSimpleName() );
		}
	}

	void setStyles(IHighlightedPositionAcceptor acceptor,
			BidiIterator<INode> it, String... styles) {
		for (String s : styles) {
			if (!it.hasNext())
				return;
			INode n = skipWhiteSpace(acceptor, it);
			if (n != null && s != null)
				acceptor.addPosition(n.getOffset(), n.getLength(), s);
		}
	}

	INode skipWhiteSpace(IHighlightedPositionAcceptor acceptor,
			BidiIterator<INode> it) {
		INode n = null;
		while (it.hasNext()
				&& (n = it.next()).getClass() == HiddenLeafNode.class)
			processHiddenNode(acceptor, (HiddenLeafNode) n);
		return n;
	}

	INode skipWhiteSpaceBackwards(IHighlightedPositionAcceptor acceptor,
			BidiIterator<INode> it) {
		INode n = null;
		while (it.hasPrevious()
				&& (n = it.previous()).getClass() == HiddenLeafNode.class)
			processHiddenNode(acceptor, (HiddenLeafNode) n);
		return n;
	}

	void processHiddenNode(IHighlightedPositionAcceptor acceptor,
			HiddenLeafNode node) {
		if (node.getGrammarElement() instanceof TerminalRuleImpl) {
			TerminalRuleImpl ge = (TerminalRuleImpl) node.getGrammarElement();
			if (ge.getName().equalsIgnoreCase("GUESS_COMMENT"))
				acceptor.addPosition(node.getOffset(), node.getLength(),
						COMMENT);
		}

	}

}
