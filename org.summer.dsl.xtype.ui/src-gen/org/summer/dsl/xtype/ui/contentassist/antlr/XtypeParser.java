/*
* generated by Xtext
*/
package org.summer.dsl.xtype.ui.contentassist.antlr;

import java.util.Collection;
import java.util.Map;
import java.util.HashMap;

import org.antlr.runtime.RecognitionException;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.AbstractContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.FollowElement;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;

import com.google.inject.Inject;

import org.summer.dsl.xtype.services.XtypeGrammarAccess;

public class XtypeParser extends AbstractContentAssistParser {
	
	@Inject
	private XtypeGrammarAccess grammarAccess;
	
	private Map<AbstractElement, String> nameMappings;
	
	@Override
	protected org.summer.dsl.xtype.ui.contentassist.antlr.internal.InternalXtypeParser createParser() {
		org.summer.dsl.xtype.ui.contentassist.antlr.internal.InternalXtypeParser result = new org.summer.dsl.xtype.ui.contentassist.antlr.internal.InternalXtypeParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}
	
	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives(), "rule__JvmArgumentTypeReference__Alternatives");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2(), "rule__JvmWildcardTypeReference__Alternatives_2");
					put(grammarAccess.getXImportDeclaration1Access().getAlternatives_3(), "rule__XImportDeclaration1__Alternatives_3");
					put(grammarAccess.getXExportDeclarationAccess().getAlternatives_1(), "rule__XExportDeclaration__Alternatives_1");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup(), "rule__JvmTypeReference__Group__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_1(), "rule__JvmTypeReference__Group_1__0");
					put(grammarAccess.getJvmTypeReferenceAccess().getGroup_1_0(), "rule__JvmTypeReference__Group_1_0__0");
					put(grammarAccess.getArrayBracketsAccess().getGroup(), "rule__ArrayBrackets__Group__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup(), "rule__JvmParameterizedTypeReference__Group__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1(), "rule__JvmParameterizedTypeReference__Group_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2(), "rule__JvmParameterizedTypeReference__Group_1_2__0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup(), "rule__JvmWildcardTypeReference__Group__0");
					put(grammarAccess.getJvmUpperBoundAccess().getGroup(), "rule__JvmUpperBound__Group__0");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getGroup(), "rule__JvmUpperBoundAnded__Group__0");
					put(grammarAccess.getJvmLowerBoundAccess().getGroup(), "rule__JvmLowerBound__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup(), "rule__JvmTypeParameter__Group__0");
					put(grammarAccess.getJvmTypeParameterAccess().getGroup_1(), "rule__JvmTypeParameter__Group_1__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup(), "rule__QualifiedName__Group__0");
					put(grammarAccess.getQualifiedNameAccess().getGroup_1(), "rule__QualifiedName__Group_1__0");
					put(grammarAccess.getQualifiedNameWithWildcardAccess().getGroup(), "rule__QualifiedNameWithWildcard__Group__0");
					put(grammarAccess.getXImportSection1Access().getGroup(), "rule__XImportSection1__Group__0");
					put(grammarAccess.getXImportDeclaration1Access().getGroup(), "rule__XImportDeclaration1__Group__0");
					put(grammarAccess.getXImportDeclaration1Access().getGroup_3_0(), "rule__XImportDeclaration1__Group_3_0__0");
					put(grammarAccess.getXImportDeclaration1Access().getGroup_3_0_1(), "rule__XImportDeclaration1__Group_3_0_1__0");
					put(grammarAccess.getXImportItemAccess().getGroup(), "rule__XImportItem__Group__0");
					put(grammarAccess.getXImportItemAccess().getGroup_2(), "rule__XImportItem__Group_2__0");
					put(grammarAccess.getXExportSectionAccess().getGroup(), "rule__XExportSection__Group__0");
					put(grammarAccess.getXExportDeclarationAccess().getGroup(), "rule__XExportDeclaration__Group__0");
					put(grammarAccess.getXExportDeclarationAccess().getGroup_1_0(), "rule__XExportDeclaration__Group_1_0__0");
					put(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_2(), "rule__XExportDeclaration__Group_1_0_2__0");
					put(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_4(), "rule__XExportDeclaration__Group_1_0_4__0");
					put(grammarAccess.getXExportDeclarationAccess().getGroup_1_1(), "rule__XExportDeclaration__Group_1_1__0");
					put(grammarAccess.getXExportItemAccess().getGroup(), "rule__XExportItem__Group__0");
					put(grammarAccess.getXExportItemAccess().getGroup_1(), "rule__XExportItem__Group_1__0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0(), "rule__JvmParameterizedTypeReference__TypeAssignment_0");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1");
					put(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1(), "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0");
					put(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1(), "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1");
					put(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1(), "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1(), "rule__JvmLowerBound__TypeReferenceAssignment_1");
					put(grammarAccess.getJvmTypeParameterAccess().getNameAssignment_0(), "rule__JvmTypeParameter__NameAssignment_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_0(), "rule__JvmTypeParameter__ConstraintsAssignment_1_0");
					put(grammarAccess.getJvmTypeParameterAccess().getConstraintsAssignment_1_1(), "rule__JvmTypeParameter__ConstraintsAssignment_1_1");
					put(grammarAccess.getXImportSection1Access().getImportDeclarationsAssignment_0(), "rule__XImportSection1__ImportDeclarationsAssignment_0");
					put(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_0(), "rule__XImportDeclaration1__ImportItemsAssignment_3_0_0");
					put(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_1_1(), "rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1");
					put(grammarAccess.getXImportDeclaration1Access().getWildcardAssignment_3_1(), "rule__XImportDeclaration1__WildcardAssignment_3_1");
					put(grammarAccess.getXImportDeclaration1Access().getNameAssignment_6(), "rule__XImportDeclaration1__NameAssignment_6");
					put(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_8(), "rule__XImportDeclaration1__ImportURIAssignment_8");
					put(grammarAccess.getXImportItemAccess().getImportedIdAssignment_1(), "rule__XImportItem__ImportedIdAssignment_1");
					put(grammarAccess.getXImportItemAccess().getAliasAssignment_2_1(), "rule__XImportItem__AliasAssignment_2_1");
					put(grammarAccess.getXExportSectionAccess().getExportDeclarationsAssignment_0(), "rule__XExportSection__ExportDeclarationsAssignment_0");
					put(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_1(), "rule__XExportDeclaration__ExportItemsAssignment_1_0_1");
					put(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_2_1(), "rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1");
					put(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_0_4_1(), "rule__XExportDeclaration__ImportURIAssignment_1_0_4_1");
					put(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_1_1(), "rule__XExportDeclaration__ImportURIAssignment_1_1_1");
					put(grammarAccess.getXExportDeclarationAccess().getAliasAssignment_1_1_3(), "rule__XExportDeclaration__AliasAssignment_1_1_3");
					put(grammarAccess.getXExportItemAccess().getExportedIdAssignment_0(), "rule__XExportItem__ExportedIdAssignment_0");
					put(grammarAccess.getXExportItemAccess().getAliasAssignment_1_1(), "rule__XExportItem__AliasAssignment_1_1");
				}
			};
		}
		return nameMappings.get(element);
	}
	
	@Override
	protected Collection<FollowElement> getFollowElements(AbstractInternalContentAssistParser parser) {
		try {
			org.summer.dsl.xtype.ui.contentassist.antlr.internal.InternalXtypeParser typedParser = (org.summer.dsl.xtype.ui.contentassist.antlr.internal.InternalXtypeParser) parser;
			typedParser.entryRuleJvmTypeReference();
			return typedParser.getFollowElements();
		} catch(RecognitionException ex) {
			throw new RuntimeException(ex);
		}		
	}
	
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}
	
	public XtypeGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}
	
	public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}
