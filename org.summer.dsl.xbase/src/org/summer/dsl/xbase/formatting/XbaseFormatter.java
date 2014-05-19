/*******************************************************************************
 * Copyright (c) 2010 itemis AG (http://www.itemis.eu) and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 *******************************************************************************/
package org.summer.dsl.xbase.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.summer.dsl.xbase.services.XbaseGrammarAccess;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XCasePartElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XCatchClauseElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XClosureElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XConstructorCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XFeatureCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XMemberFeatureCallElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XParenthesizedExpressionElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XTypeLiteralElements;
import org.summer.dsl.xbase.services.XbaseGrammarAccess.XUnaryOperationElements;

/**
 * This class is deprecated since it uses Xtext's old formatter architecture.
 * 
 * use XbaseFormatter2.xtend
 */
@Deprecated()
public class XbaseFormatter extends AbstractDeclarativeFormatter {

	@Override
	protected void configureFormatting(FormattingConfig c) {
		configure(c, (XbaseGrammarAccess) getGrammarAccess());
	}

	public void configure(FormattingConfig c, XbaseGrammarAccess ga) {
		configureXUnaryOperation(c, ga.getXUnaryOperationAccess());
		configureXMemberFeatureCall(c, ga.getXMemberFeatureCallAccess());
		configureXClosure(c, ga.getXClosureAccess());
//		configureXShortClosure(c, ga.getXShortClosureAccess());
		configureXParenthesizedExpression(c, ga.getXParenthesizedExpressionAccess());
//		configureXIfExpression(c, ga.getXIfStatmentAccess());
//		configureXSwitchExpression(c, ga.getXSwitchStatmentAccess());
		configureXCasePart(c, ga.getXCasePartAccess());
//		configureXForLoopExpression(c, ga.getXForLoopStatmentAccess());
//		configureXWhileExpression(c, ga.getXWhileStatmentAccess());
//		configureXDoWhileExpression(c, ga.getXDoWhileStatmentAccess());
//		configureXBlockExpression(c, ga.getXBlockStatmentAccess());
		configureXFeatureCall(c, ga.getXFeatureCallAccess());
		configureXConstructorCall(c, ga.getXConstructorCallAccess());
		configureXTypeLiteral(c, ga.getXTypeLiteralAccess());
//		configureXTryCatchFinallyExpression(c, ga.getXTryCatchFinallyStatmentAccess());
//		configureXCatchClause(c, ga.getXCatchClauseAccess());
	}

//	public void configure(FormattingConfig c, XbaseWithAnnotationsGrammarAccess ga) {
//		configure(c, ga.getXbaseGrammarAccess());
//	}

	public void configureXUnaryOperation(FormattingConfig c, XUnaryOperationElements ele) {
		c.setNoSpace().after(ele.getFeatureAssignment_0_1());
	}

	public void configureXMemberFeatureCall(FormattingConfig c, XMemberFeatureCallElements ele) {
		c.setNoSpace().around(ele.getFullStopKeyword_1_2_0_0_1());
//		c.setNoSpace().around(ele.getExplicitStaticColonColonKeyword_1_1_0_0_1_1_0());
		c.setNoSpace().around(ele.getFullStopKeyword_1_2_0_0_1());
//		c.setNoSpace().around(ele.getExplicitStaticAssignment_1_1_0_0_1_1());
//		c.setNoSpace().around(ele.getExplicitStaticColonColonKeyword_1_1_0_0_1_1_0());
		c.setNoSpace().around(ele.getLessThanSignKeyword_1_3_1_0());
		c.setNoSpace().before(ele.getCommaKeyword_1_0_1_1_0());
		c.setNoSpace().around(ele.getGreaterThanSignKeyword_1_3_1_3());
		c.setNoSpace().around(ele.getExplicitOperationCallAssignment_1_0_0_0_1());
		c.setNoSpace().before(ele.getCommaKeyword_1_0_1_1_0());
		c.setNoSpace().before(ele.getRightParenthesisKeyword_1_0_2());
	}

	public void configureXClosure(FormattingConfig c, XClosureElements ele) {
//		c.setNoSpace().after(ele.getLeftSquareBracketKeyword_0_0_1());
//		c.setNoSpace().before(ele.getCommaKeyword_1_0_0_1_0());
//		c.setNoSpace().before(ele.getRightSquareBracketKeyword_3());
	}

//	public void configureXShortClosure(FormattingConfig c, XShortClosureElements ele) {
//		c.setNoSpace().before(ele.getCommaKeyword_0_0_1_1_0());
//	}

	public void configureXParenthesizedExpression(FormattingConfig c, XParenthesizedExpressionElements ele) {
		c.setNoSpace().after(ele.getLeftParenthesisKeyword_0());
		c.setNoSpace().before(ele.getRightParenthesisKeyword_2());
	}

//	public void configureXIfExpression(FormattingConfig c, XIfExpressionElements ele) {
//		c.setNoSpace().around(ele.getLeftParenthesisKeyword_2());
//		c.setNoSpace().before(ele.getRightParenthesisKeyword_4());
//		c.setLinewrap().around(ele.getThenAssignment_5());
//		c.setIndentationIncrement().before(ele.getThenAssignment_5());
//		c.setIndentationDecrement().after(ele.getThenAssignment_5());
//		c.setLinewrap().around(ele.getElseAssignment_6_1());
//		c.setIndentationIncrement().before(ele.getElseAssignment_6_1());
//		c.setIndentationDecrement().after(ele.getElseAssignment_6_1());
//	}

//	public void configureXSwitchExpression(FormattingConfig c, XSwitchExpressionElements ele) {
//		c.setNoSpace().around(ele.getColonKeyword_2_0_0_0_1());
//		c.setNoSpace().around(ele.getColonKeyword_2_1_0_0_2());
//		c.setNoLinewrap().before(ele.getLeftCurlyBracketKeyword_3());
//		c.setLinewrap().after(ele.getLeftCurlyBracketKeyword_3());
//		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_3());
//		c.setNoSpace().before(ele.getColonKeyword_5_1());
//		c.setIndentationIncrement().before(ele.getDefaultAssignment_5_2());
//		c.setLinewrap().around(ele.getDefaultAssignment_5_2());
//		c.setIndentationDecrement().after(ele.getDefaultAssignment_5_2());
//		c.setLinewrap().before(ele.getRightCurlyBracketKeyword_6());
//		c.setIndentationDecrement().before(ele.getRightCurlyBracketKeyword_6());
//	}

	public void configureXCasePart(FormattingConfig c, XCasePartElements ele) {
//		c.setNoSpace().before(ele.getColonKeyword_2());
//		c.setIndentationIncrement().before(ele.getThenAssignment_3());
//		c.setLinewrap().around(ele.getThenAssignment_3());
//		c.setIndentationDecrement().after(ele.getThenAssignment_3());
	}

//	public void configureXForLoopExpression(FormattingConfig c, XForLoopExpressionElements ele) {
////		c.setNoSpace().around(ele.getLeftParenthesisKeyword_2());
////		c.setNoSpace().around(ele.getColonKeyword_4());
////		c.setNoSpace().around(ele.getRightParenthesisKeyword_6());
////		c.setIndentationIncrement().before(ele.getEachExpressionAssignment_7());
////		c.setLinewrap().around(ele.getEachExpressionAssignment_7());
////		c.setIndentationDecrement().after(ele.getEachExpressionAssignment_7());
//	}

//	public void configureXWhileExpression(FormattingConfig c, XWhileExpressionElements ele) {
//		c.setNoSpace().around(ele.getLeftParenthesisKeyword_2());
//		c.setNoSpace().before(ele.getRightParenthesisKeyword_4());
//		c.setIndentationIncrement().before(ele.getBodyAssignment_5());
//		c.setLinewrap().around(ele.getBodyAssignment_5());
//		c.setIndentationDecrement().after(ele.getBodyAssignment_5());
//	}

//	public void configureXBlockExpression(FormattingConfig c, XBlockExpressionElements ele) {
//		c.setLinewrap().after(ele.getLeftCurlyBracketKeyword_1());
//		c.setIndentationIncrement().after(ele.getLeftCurlyBracketKeyword_1());
//		c.setLinewrap().after(ele.getExpressionsAssignment_2_0());
//		c.setNoSpace().before(ele.getSemicolonKeyword_2_1());
//		c.setLinewrap().after(ele.getSemicolonKeyword_2_1());
//		c.setLinewrap().before(ele.getRightCurlyBracketKeyword_3());
//		c.setIndentationDecrement().before(ele.getRightCurlyBracketKeyword_3());
//	}
//
//	public void configureXDoWhileExpression(FormattingConfig c, XDoWhileExpressionElements ele) {
//		c.setLinewrap().after(ele.getDoKeyword_1());
//		c.setIndentationIncrement().after(ele.getDoKeyword_1());
//		c.setLinewrap().before(ele.getDoKeyword_1());
//		c.setIndentationDecrement().before(ele.getWhileKeyword_3());
//		c.setNoSpace().around(ele.getLeftParenthesisKeyword_4());
//		c.setNoSpace().before(ele.getRightParenthesisKeyword_6());
//	}

	public void configureXFeatureCall(FormattingConfig c, XFeatureCallElements ele) {
		c.setNoSpace().around(ele.getLessThanSignKeyword_1_0());
		c.setNoSpace().before(ele.getCommaKeyword_1_2_0());
		c.setNoSpace().around(ele.getGreaterThanSignKeyword_1_3());
		c.setNoSpace().around(ele.getExplicitOperationCallAssignment_3_0());
		c.setNoSpace().before(ele.getCommaKeyword_1_2_0());
		c.setNoSpace().before(ele.getRightParenthesisKeyword_3_2());
	}

	public void configureXConstructorCall(FormattingConfig c, XConstructorCallElements ele) {
		c.setNoSpace().around(ele.getLessThanSignKeyword_3_0());
		c.setNoSpace().before(ele.getCommaKeyword_3_2_0());
		c.setNoSpace().around(ele.getGreaterThanSignKeyword_3_3());
		c.setNoSpace().around(ele.getLeftParenthesisKeyword_4_0());
		c.setNoSpace().before(ele.getCommaKeyword_3_2_0());
		c.setNoSpace().before(ele.getRightParenthesisKeyword_4_2());
	}

	public void configureXTypeLiteral(FormattingConfig c, XTypeLiteralElements ele) {
		c.setNoSpace().around(ele.getLeftParenthesisKeyword_2());
		c.setNoSpace().around(ele.getArrayDimensionsArrayBracketsParserRuleCall_4_0());
		c.setNoSpace().around(ele.getRightParenthesisKeyword_5());
	}

//	public void configureXTryCatchFinallyExpression(FormattingConfig c, XTryCatchFinallyExpressionElements ele) {
//		c.setIndentationIncrement().before(ele.getExpressionAssignment_2());
//		c.setLinewrap().around(ele.getExpressionAssignment_2());
//		c.setIndentationDecrement().after(ele.getExpressionAssignment_2());
//		c.setIndentationIncrement().before(ele.getFinallyExpressionAssignment_3_0_1_1());
//		c.setLinewrap().around(ele.getFinallyExpressionAssignment_3_0_1_1());
//		c.setIndentationDecrement().after(ele.getFinallyExpressionAssignment_3_0_1_1());
//		c.setIndentationIncrement().before(ele.getFinallyExpressionAssignment_3_1_1());
//		c.setLinewrap().around(ele.getFinallyExpressionAssignment_3_1_1());
//		c.setIndentationDecrement().after(ele.getFinallyExpressionAssignment_3_1_1());
//	}
//
//	public void configureXCatchClause(FormattingConfig c, XCatchClauseElements ele) {
//		c.setNoSpace().around(ele.getLeftParenthesisKeyword_1());
//		c.setNoSpace().before(ele.getRightParenthesisKeyword_3());
//		c.setIndentationIncrement().before(ele.getExpressionAssignment_4());
//		c.setLinewrap().around(ele.getExpressionAssignment_4());
//		c.setIndentationDecrement().after(ele.getExpressionAssignment_4());
//	}

}
