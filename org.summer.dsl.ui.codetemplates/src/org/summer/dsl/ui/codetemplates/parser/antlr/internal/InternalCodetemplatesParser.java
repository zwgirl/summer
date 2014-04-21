package org.summer.dsl.ui.codetemplates.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;



import org.summer.dsl.ui.codetemplates.services.CodetemplatesGrammarAccess;
import org.antlr.runtime.*;

import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalCodetemplatesParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "KEYWORD_14", "KEYWORD_12", "KEYWORD_13", "KEYWORD_8", "KEYWORD_9", "KEYWORD_10", "KEYWORD_11", "KEYWORD_1", "KEYWORD_2", "KEYWORD_3", "KEYWORD_4", "KEYWORD_5", "KEYWORD_6", "KEYWORD_7", "RULE_ID", "RULE_STRING", "RULE_WS", "RULE_ANY_OTHER"
    };
    public static final int RULE_ID=18;
    public static final int RULE_ANY_OTHER=21;
    public static final int KEYWORD_1=11;
    public static final int KEYWORD_5=15;
    public static final int KEYWORD_4=14;
    public static final int KEYWORD_13=6;
    public static final int KEYWORD_3=13;
    public static final int KEYWORD_14=4;
    public static final int KEYWORD_2=12;
    public static final int KEYWORD_11=10;
    public static final int EOF=-1;
    public static final int KEYWORD_12=5;
    public static final int KEYWORD_10=9;
    public static final int RULE_STRING=19;
    public static final int KEYWORD_6=16;
    public static final int KEYWORD_7=17;
    public static final int KEYWORD_8=7;
    public static final int KEYWORD_9=8;
    public static final int RULE_WS=20;

    // delegates
    // delegators


        public InternalCodetemplatesParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalCodetemplatesParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalCodetemplatesParser.tokenNames; }
    public String getGrammarFileName() { return "../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g"; }




    	private CodetemplatesGrammarAccess grammarAccess;
    	 	
    	public InternalCodetemplatesParser(TokenStream input, CodetemplatesGrammarAccess grammarAccess) {
    		this(input);
    		this.grammarAccess = grammarAccess;
    		registerRules(grammarAccess.getGrammar());
    	}
    	
    	@Override
    	protected String getFirstRuleName() {
    		return "Codetemplates";	
    	} 
    	   	   	
    	@Override
    	protected CodetemplatesGrammarAccess getGrammarAccess() {
    		return grammarAccess;
    	}



    // $ANTLR start "entryRuleCodetemplates"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:61:1: entryRuleCodetemplates returns [EObject current=null] : iv_ruleCodetemplates= ruleCodetemplates EOF ;
    public final EObject entryRuleCodetemplates() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplates = null;


        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:62:2: (iv_ruleCodetemplates= ruleCodetemplates EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:63:2: iv_ruleCodetemplates= ruleCodetemplates EOF
            {
             newCompositeNode(grammarAccess.getCodetemplatesRule()); 
            pushFollow(FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates67);
            iv_ruleCodetemplates=ruleCodetemplates();

            state._fsp--;

             current =iv_ruleCodetemplates; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplates77); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCodetemplates"


    // $ANTLR start "ruleCodetemplates"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:70:1: ruleCodetemplates returns [EObject current=null] : (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* ) ;
    public final EObject ruleCodetemplates() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_templates_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:73:28: ( (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:74:1: (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:74:1: (otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )* )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:75:2: otherlv_0= KEYWORD_14 otherlv_1= KEYWORD_13 ( ( ruleFQN ) ) otherlv_3= KEYWORD_6 ( (lv_templates_4_0= ruleCodetemplate ) )*
            {
            otherlv_0=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleCodetemplates115); 

                	newLeafNode(otherlv_0, grammarAccess.getCodetemplatesAccess().getTemplatesKeyword_0());
                
            otherlv_1=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCodetemplates127); 

                	newLeafNode(otherlv_1, grammarAccess.getCodetemplatesAccess().getForKeyword_1());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:84:1: ( ( ruleFQN ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:85:1: ( ruleFQN )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:85:1: ( ruleFQN )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:86:3: ruleFQN
            {

            			if (current==null) {
            	            current = createModelElement(grammarAccess.getCodetemplatesRule());
            	        }
                    
             
            	        newCompositeNode(grammarAccess.getCodetemplatesAccess().getLanguageGrammarCrossReference_2_0()); 
            	    
            pushFollow(FOLLOW_ruleFQN_in_ruleCodetemplates149);
            ruleFQN();

            state._fsp--;

             
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleCodetemplates162); 

                	newLeafNode(otherlv_3, grammarAccess.getCodetemplatesAccess().getColonKeyword_3());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:104:1: ( (lv_templates_4_0= ruleCodetemplate ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==KEYWORD_14||LA1_0==KEYWORD_13||LA1_0==RULE_ID) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:105:1: (lv_templates_4_0= ruleCodetemplate )
            	    {
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:105:1: (lv_templates_4_0= ruleCodetemplate )
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:106:3: lv_templates_4_0= ruleCodetemplate
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getCodetemplatesAccess().getTemplatesCodetemplateParserRuleCall_4_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleCodetemplate_in_ruleCodetemplates182);
            	    lv_templates_4_0=ruleCodetemplate();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getCodetemplatesRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"templates",
            	            		lv_templates_4_0, 
            	            		"Codetemplate");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodetemplates"


    // $ANTLR start "entryRuleCodetemplate"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:130:1: entryRuleCodetemplate returns [EObject current=null] : iv_ruleCodetemplate= ruleCodetemplate EOF ;
    public final EObject entryRuleCodetemplate() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCodetemplate = null;


        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:131:2: (iv_ruleCodetemplate= ruleCodetemplate EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:132:2: iv_ruleCodetemplate= ruleCodetemplate EOF
            {
             newCompositeNode(grammarAccess.getCodetemplateRule()); 
            pushFollow(FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate218);
            iv_ruleCodetemplate=ruleCodetemplate();

            state._fsp--;

             current =iv_ruleCodetemplate; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleCodetemplate228); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "entryRuleCodetemplate"


    // $ANTLR start "ruleCodetemplate"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:139:1: ruleCodetemplate returns [EObject current=null] : ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) ;
    public final EObject ruleCodetemplate() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_id_2_0=null;
        Token otherlv_3=null;
        Token lv_description_4_0=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_keywordContext_8_0=null;
        AntlrDatatypeRuleToken lv_name_0_0 = null;

        EObject lv_body_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:142:28: ( ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:143:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:143:1: ( ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:143:2: ( (lv_name_0_0= ruleValidID ) ) otherlv_1= KEYWORD_2 ( (lv_id_2_0= RULE_ID ) ) otherlv_3= KEYWORD_4 ( (lv_description_4_0= RULE_STRING ) ) otherlv_5= KEYWORD_3 otherlv_6= KEYWORD_13 ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) ) ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:143:2: ( (lv_name_0_0= ruleValidID ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:144:1: (lv_name_0_0= ruleValidID )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:144:1: (lv_name_0_0= ruleValidID )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:145:3: lv_name_0_0= ruleValidID
            {
             
            	        newCompositeNode(grammarAccess.getCodetemplateAccess().getNameValidIDParserRuleCall_0_0()); 
            	    
            pushFollow(FOLLOW_ruleValidID_in_ruleCodetemplate274);
            lv_name_0_0=ruleValidID();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCodetemplateRule());
            	        }
                   		set(
                   			current, 
                   			"name",
                    		lv_name_0_0, 
                    		"ValidID");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }

            otherlv_1=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleCodetemplate287); 

                	newLeafNode(otherlv_1, grammarAccess.getCodetemplateAccess().getLeftParenthesisKeyword_1());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:166:1: ( (lv_id_2_0= RULE_ID ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:167:1: (lv_id_2_0= RULE_ID )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:167:1: (lv_id_2_0= RULE_ID )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:168:3: lv_id_2_0= RULE_ID
            {
            lv_id_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleCodetemplate303); 

            			newLeafNode(lv_id_2_0, grammarAccess.getCodetemplateAccess().getIdIDTerminalRuleCall_2_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCodetemplateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"id",
                    		lv_id_2_0, 
                    		"ID");
            	    

            }


            }

            otherlv_3=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleCodetemplate321); 

                	newLeafNode(otherlv_3, grammarAccess.getCodetemplateAccess().getCommaKeyword_3());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:189:1: ( (lv_description_4_0= RULE_STRING ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:190:1: (lv_description_4_0= RULE_STRING )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:190:1: (lv_description_4_0= RULE_STRING )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:191:3: lv_description_4_0= RULE_STRING
            {
            lv_description_4_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate337); 

            			newLeafNode(lv_description_4_0, grammarAccess.getCodetemplateAccess().getDescriptionSTRINGTerminalRuleCall_4_0()); 
            		

            	        if (current==null) {
            	            current = createModelElement(grammarAccess.getCodetemplateRule());
            	        }
                   		setWithLastConsumed(
                   			current, 
                   			"description",
                    		lv_description_4_0, 
                    		"STRING");
            	    

            }


            }

            otherlv_5=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleCodetemplate355); 

                	newLeafNode(otherlv_5, grammarAccess.getCodetemplateAccess().getRightParenthesisKeyword_5());
                
            otherlv_6=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleCodetemplate367); 

                	newLeafNode(otherlv_6, grammarAccess.getCodetemplateAccess().getForKeyword_6());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:217:1: ( ( ( ruleValidID ) ) | ( (lv_keywordContext_8_0= RULE_STRING ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==KEYWORD_14||LA2_0==KEYWORD_13||LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==RULE_STRING) ) {
                alt2=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:217:2: ( ( ruleValidID ) )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:217:2: ( ( ruleValidID ) )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:218:1: ( ruleValidID )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:218:1: ( ruleValidID )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:219:3: ruleValidID
                    {

                    			if (current==null) {
                    	            current = createModelElement(grammarAccess.getCodetemplateRule());
                    	        }
                            
                     
                    	        newCompositeNode(grammarAccess.getCodetemplateAccess().getContextAbstractRuleCrossReference_7_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleCodetemplate390);
                    ruleValidID();

                    state._fsp--;

                     
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:233:6: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:233:6: ( (lv_keywordContext_8_0= RULE_STRING ) )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:234:1: (lv_keywordContext_8_0= RULE_STRING )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:234:1: (lv_keywordContext_8_0= RULE_STRING )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:235:3: lv_keywordContext_8_0= RULE_STRING
                    {
                    lv_keywordContext_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleCodetemplate413); 

                    			newLeafNode(lv_keywordContext_8_0, grammarAccess.getCodetemplateAccess().getKeywordContextSTRINGTerminalRuleCall_7_1_0()); 
                    		

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getCodetemplateRule());
                    	        }
                           		setWithLastConsumed(
                           			current, 
                           			"keywordContext",
                            		lv_keywordContext_8_0, 
                            		"STRING");
                    	    

                    }


                    }


                    }
                    break;

            }

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:251:3: ( (lv_body_9_0= ruleTemplateBodyWithQuotes ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:252:1: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:252:1: (lv_body_9_0= ruleTemplateBodyWithQuotes )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:253:3: lv_body_9_0= ruleTemplateBodyWithQuotes
            {
             
            	        newCompositeNode(grammarAccess.getCodetemplateAccess().getBodyTemplateBodyWithQuotesParserRuleCall_8_0()); 
            	    
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate440);
            lv_body_9_0=ruleTemplateBodyWithQuotes();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getCodetemplateRule());
            	        }
                   		set(
                   			current, 
                   			"body",
                    		lv_body_9_0, 
                    		"TemplateBodyWithQuotes");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {
        }
        return current;
    }
    // $ANTLR end "ruleCodetemplate"


    // $ANTLR start "entryRuleTemplateBodyWithQuotes"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:277:1: entryRuleTemplateBodyWithQuotes returns [EObject current=null] : iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF ;
    public final EObject entryRuleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBodyWithQuotes = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:281:2: (iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:282:2: iv_ruleTemplateBodyWithQuotes= ruleTemplateBodyWithQuotes EOF
            {
             newCompositeNode(grammarAccess.getTemplateBodyWithQuotesRule()); 
            pushFollow(FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes481);
            iv_ruleTemplateBodyWithQuotes=ruleTemplateBodyWithQuotes();

            state._fsp--;

             current =iv_ruleTemplateBodyWithQuotes; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes491); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBodyWithQuotes"


    // $ANTLR start "ruleTemplateBodyWithQuotes"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:292:1: ruleTemplateBodyWithQuotes returns [EObject current=null] : ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 ) ;
    public final EObject ruleTemplateBodyWithQuotes() throws RecognitionException {
        EObject current = null;

        Token this_WS_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject this_TemplateBody_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:296:28: ( ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:297:1: ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:297:1: ( (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10 )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:297:2: (this_WS_0= RULE_WS )? otherlv_1= KEYWORD_11 this_TemplateBody_2= ruleTemplateBody otherlv_3= KEYWORD_10
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:297:2: (this_WS_0= RULE_WS )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_WS) ) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:297:3: this_WS_0= RULE_WS
                    {
                    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleTemplateBodyWithQuotes532); 
                     
                        newLeafNode(this_WS_0, grammarAccess.getTemplateBodyWithQuotesAccess().getWSTerminalRuleCall_0()); 
                        

                    }
                    break;

            }

            otherlv_1=(Token)match(input,KEYWORD_11,FOLLOW_KEYWORD_11_in_ruleTemplateBodyWithQuotes546); 

                	newLeafNode(otherlv_1, grammarAccess.getTemplateBodyWithQuotesAccess().getGreaterThanSignGreaterThanSignKeyword_1());
                
             
                    newCompositeNode(grammarAccess.getTemplateBodyWithQuotesAccess().getTemplateBodyParserRuleCall_2()); 
                
            pushFollow(FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes567);
            this_TemplateBody_2=ruleTemplateBody();

            state._fsp--;


                    current = this_TemplateBody_2;
                    afterParserOrEnumRuleCall();
                
            otherlv_3=(Token)match(input,KEYWORD_10,FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes579); 

                	newLeafNode(otherlv_3, grammarAccess.getTemplateBodyWithQuotesAccess().getLessThanSignLessThanSignKeyword_3());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTemplateBodyWithQuotes"


    // $ANTLR start "entryRuleTemplateBody"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:331:1: entryRuleTemplateBody returns [EObject current=null] : iv_ruleTemplateBody= ruleTemplateBody EOF ;
    public final EObject entryRuleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTemplateBody = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:335:2: (iv_ruleTemplateBody= ruleTemplateBody EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:336:2: iv_ruleTemplateBody= ruleTemplateBody EOF
            {
             newCompositeNode(grammarAccess.getTemplateBodyRule()); 
            pushFollow(FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody623);
            iv_ruleTemplateBody=ruleTemplateBody();

            state._fsp--;

             current =iv_ruleTemplateBody; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleTemplateBody633); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleTemplateBody"


    // $ANTLR start "ruleTemplateBody"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:346:1: ruleTemplateBody returns [EObject current=null] : ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) ;
    public final EObject ruleTemplateBody() throws RecognitionException {
        EObject current = null;

        EObject lv_parts_1_0 = null;

        EObject lv_parts_2_0 = null;

        EObject lv_parts_3_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:350:28: ( ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:351:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:351:1: ( () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )* )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:351:2: () ( (lv_parts_1_0= ruleLiteral ) )? ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:351:2: ()
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:352:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getTemplateBodyAccess().getTemplateBodyAction_0(),
                        current);
                

            }

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:357:2: ( (lv_parts_1_0= ruleLiteral ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==KEYWORD_12||LA4_0==RULE_ID||(LA4_0>=RULE_WS && LA4_0<=RULE_ANY_OTHER)) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:358:1: (lv_parts_1_0= ruleLiteral )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:358:1: (lv_parts_1_0= ruleLiteral )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:359:3: lv_parts_1_0= ruleLiteral
                    {
                     
                    	        newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_1_0()); 
                    	    
                    pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody692);
                    lv_parts_1_0=ruleLiteral();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
                    	        }
                           		add(
                           			current, 
                           			"parts",
                            		lv_parts_1_0, 
                            		"Literal");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }
                    break;

            }

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:375:3: ( ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )? )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( ((LA6_0>=KEYWORD_8 && LA6_0<=KEYWORD_9)||LA6_0==KEYWORD_1) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:375:4: ( (lv_parts_2_0= ruleVariableOrDollar ) ) ( (lv_parts_3_0= ruleLiteral ) )?
            	    {
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:375:4: ( (lv_parts_2_0= ruleVariableOrDollar ) )
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:376:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    {
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:376:1: (lv_parts_2_0= ruleVariableOrDollar )
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:377:3: lv_parts_2_0= ruleVariableOrDollar
            	    {
            	     
            	    	        newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsVariableOrDollarParserRuleCall_2_0_0()); 
            	    	    
            	    pushFollow(FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody715);
            	    lv_parts_2_0=ruleVariableOrDollar();

            	    state._fsp--;


            	    	        if (current==null) {
            	    	            current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
            	    	        }
            	           		add(
            	           			current, 
            	           			"parts",
            	            		lv_parts_2_0, 
            	            		"VariableOrDollar");
            	    	        afterParserOrEnumRuleCall();
            	    	    

            	    }


            	    }

            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:393:2: ( (lv_parts_3_0= ruleLiteral ) )?
            	    int alt5=2;
            	    int LA5_0 = input.LA(1);

            	    if ( (LA5_0==KEYWORD_12||LA5_0==RULE_ID||(LA5_0>=RULE_WS && LA5_0<=RULE_ANY_OTHER)) ) {
            	        alt5=1;
            	    }
            	    switch (alt5) {
            	        case 1 :
            	            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:394:1: (lv_parts_3_0= ruleLiteral )
            	            {
            	            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:394:1: (lv_parts_3_0= ruleLiteral )
            	            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:395:3: lv_parts_3_0= ruleLiteral
            	            {
            	             
            	            	        newCompositeNode(grammarAccess.getTemplateBodyAccess().getPartsLiteralParserRuleCall_2_1_0()); 
            	            	    
            	            pushFollow(FOLLOW_ruleLiteral_in_ruleTemplateBody736);
            	            lv_parts_3_0=ruleLiteral();

            	            state._fsp--;


            	            	        if (current==null) {
            	            	            current = createModelElementForParent(grammarAccess.getTemplateBodyRule());
            	            	        }
            	                   		add(
            	                   			current, 
            	                   			"parts",
            	                    		lv_parts_3_0, 
            	                    		"Literal");
            	            	        afterParserOrEnumRuleCall();
            	            	    

            	            }


            	            }
            	            break;

            	    }


            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleTemplateBody"


    // $ANTLR start "entryRuleVariableOrDollar"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:424:1: entryRuleVariableOrDollar returns [EObject current=null] : iv_ruleVariableOrDollar= ruleVariableOrDollar EOF ;
    public final EObject entryRuleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableOrDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:428:2: (iv_ruleVariableOrDollar= ruleVariableOrDollar EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:429:2: iv_ruleVariableOrDollar= ruleVariableOrDollar EOF
            {
             newCompositeNode(grammarAccess.getVariableOrDollarRule()); 
            pushFollow(FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar786);
            iv_ruleVariableOrDollar=ruleVariableOrDollar();

            state._fsp--;

             current =iv_ruleVariableOrDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariableOrDollar796); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVariableOrDollar"


    // $ANTLR start "ruleVariableOrDollar"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:439:1: ruleVariableOrDollar returns [EObject current=null] : (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) ;
    public final EObject ruleVariableOrDollar() throws RecognitionException {
        EObject current = null;

        EObject this_Variable_0 = null;

        EObject this_Dollar_1 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:443:28: ( (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:444:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:444:1: (this_Variable_0= ruleVariable | this_Dollar_1= ruleDollar )
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==KEYWORD_9) ) {
                alt7=1;
            }
            else if ( (LA7_0==KEYWORD_8||LA7_0==KEYWORD_1) ) {
                alt7=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }
            switch (alt7) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:445:5: this_Variable_0= ruleVariable
                    {
                     
                            newCompositeNode(grammarAccess.getVariableOrDollarAccess().getVariableParserRuleCall_0()); 
                        
                    pushFollow(FOLLOW_ruleVariable_in_ruleVariableOrDollar847);
                    this_Variable_0=ruleVariable();

                    state._fsp--;


                            current = this_Variable_0;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:455:5: this_Dollar_1= ruleDollar
                    {
                     
                            newCompositeNode(grammarAccess.getVariableOrDollarAccess().getDollarParserRuleCall_1()); 
                        
                    pushFollow(FOLLOW_ruleDollar_in_ruleVariableOrDollar874);
                    this_Dollar_1=ruleDollar();

                    state._fsp--;


                            current = this_Dollar_1;
                            afterParserOrEnumRuleCall();
                        

                    }
                    break;

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVariableOrDollar"


    // $ANTLR start "entryRuleVariable"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:474:1: entryRuleVariable returns [EObject current=null] : iv_ruleVariable= ruleVariable EOF ;
    public final EObject entryRuleVariable() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariable = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:478:2: (iv_ruleVariable= ruleVariable EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:479:2: iv_ruleVariable= ruleVariable EOF
            {
             newCompositeNode(grammarAccess.getVariableRule()); 
            pushFollow(FOLLOW_ruleVariable_in_entryRuleVariable918);
            iv_ruleVariable=ruleVariable();

            state._fsp--;

             current =iv_ruleVariable; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleVariable928); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleVariable"


    // $ANTLR start "ruleVariable"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:489:1: ruleVariable returns [EObject current=null] : (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) ;
    public final EObject ruleVariable() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token this_WS_1=null;
        Token this_WS_4=null;
        Token otherlv_5=null;
        Token this_WS_6=null;
        Token this_WS_8=null;
        Token lv_expectingParameters_9_0=null;
        Token this_WS_10=null;
        Token lv_parameters_11_1=null;
        Token this_WS_12=null;
        Token otherlv_13=null;
        Token this_WS_14=null;
        Token lv_parameters_15_1=null;
        Token this_WS_16=null;
        Token otherlv_17=null;
        Token this_WS_18=null;
        Token otherlv_19=null;
        AntlrDatatypeRuleToken lv_name_2_0 = null;

        AntlrDatatypeRuleToken lv_name_3_0 = null;

        AntlrDatatypeRuleToken lv_type_7_0 = null;

        AntlrDatatypeRuleToken lv_parameters_11_2 = null;

        AntlrDatatypeRuleToken lv_parameters_15_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:493:28: ( (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:494:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:494:1: (otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7 )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:495:2: otherlv_0= KEYWORD_9 (this_WS_1= RULE_WS )* ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) ) (this_WS_18= RULE_WS )* otherlv_19= KEYWORD_7
            {
            otherlv_0=(Token)match(input,KEYWORD_9,FOLLOW_KEYWORD_9_in_ruleVariable970); 

                	newLeafNode(otherlv_0, grammarAccess.getVariableAccess().getDollarSignLeftCurlyBracketKeyword_0());
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:499:1: (this_WS_1= RULE_WS )*
            loop8:
            do {
                int alt8=2;
                int LA8_0 = input.LA(1);

                if ( (LA8_0==RULE_WS) ) {
                    alt8=1;
                }


                switch (alt8) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:499:2: this_WS_1= RULE_WS
            	    {
            	    this_WS_1=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable981); 
            	     
            	        newLeafNode(this_WS_1, grammarAccess.getVariableAccess().getWSTerminalRuleCall_1()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop8;
                }
            } while (true);

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:503:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) )
            int alt22=2;
            alt22 = dfa22.predict(input);
            switch (alt22) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:503:4: ( (lv_name_2_0= ruleValidID ) )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:503:4: ( (lv_name_2_0= ruleValidID ) )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:504:1: (lv_name_2_0= ruleValidID )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:504:1: (lv_name_2_0= ruleValidID )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:505:3: lv_name_2_0= ruleValidID
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_0_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1004);
                    lv_name_2_0=ruleValidID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableRule());
                    	        }
                           		set(
                           			current, 
                           			"name",
                            		lv_name_2_0, 
                            		"ValidID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:6: ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )?
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:7: ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )?
                    int alt10=2;
                    int LA10_0 = input.LA(1);

                    if ( (LA10_0==KEYWORD_14||LA10_0==KEYWORD_13||LA10_0==RULE_ID) ) {
                        alt10=1;
                    }
                    switch (alt10) {
                        case 1 :
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:8: ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )*
                            {
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:522:8: ( (lv_name_3_0= ruleValidID ) )
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:523:1: (lv_name_3_0= ruleValidID )
                            {
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:523:1: (lv_name_3_0= ruleValidID )
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:524:3: lv_name_3_0= ruleValidID
                            {
                             
                            	        newCompositeNode(grammarAccess.getVariableAccess().getNameValidIDParserRuleCall_2_1_0_0_0()); 
                            	    
                            pushFollow(FOLLOW_ruleValidID_in_ruleVariable1033);
                            lv_name_3_0=ruleValidID();

                            state._fsp--;


                            	        if (current==null) {
                            	            current = createModelElementForParent(grammarAccess.getVariableRule());
                            	        }
                                   		set(
                                   			current, 
                                   			"name",
                                    		lv_name_3_0, 
                                    		"ValidID");
                            	        afterParserOrEnumRuleCall();
                            	    

                            }


                            }

                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:540:2: (this_WS_4= RULE_WS )*
                            loop9:
                            do {
                                int alt9=2;
                                int LA9_0 = input.LA(1);

                                if ( (LA9_0==RULE_WS) ) {
                                    alt9=1;
                                }


                                switch (alt9) {
                            	case 1 :
                            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:540:3: this_WS_4= RULE_WS
                            	    {
                            	    this_WS_4=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1045); 
                            	     
                            	        newLeafNode(this_WS_4, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_0_1()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop9;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,KEYWORD_6,FOLLOW_KEYWORD_6_in_ruleVariable1061); 

                        	newLeafNode(otherlv_5, grammarAccess.getVariableAccess().getColonKeyword_2_1_1());
                        
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:549:1: (this_WS_6= RULE_WS )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==RULE_WS) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:549:2: this_WS_6= RULE_WS
                    	    {
                    	    this_WS_6=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1072); 
                    	     
                    	        newLeafNode(this_WS_6, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_2()); 
                    	        

                    	    }
                    	    break;

                    	default :
                    	    break loop11;
                        }
                    } while (true);

                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:553:3: ( (lv_type_7_0= ruleValidID ) )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:554:1: (lv_type_7_0= ruleValidID )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:554:1: (lv_type_7_0= ruleValidID )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:555:3: lv_type_7_0= ruleValidID
                    {
                     
                    	        newCompositeNode(grammarAccess.getVariableAccess().getTypeValidIDParserRuleCall_2_1_3_0()); 
                    	    
                    pushFollow(FOLLOW_ruleValidID_in_ruleVariable1094);
                    lv_type_7_0=ruleValidID();

                    state._fsp--;


                    	        if (current==null) {
                    	            current = createModelElementForParent(grammarAccess.getVariableRule());
                    	        }
                           		set(
                           			current, 
                           			"type",
                            		lv_type_7_0, 
                            		"ValidID");
                    	        afterParserOrEnumRuleCall();
                    	    

                    }


                    }

                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:2: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )?
                    int alt21=2;
                    alt21 = dfa21.predict(input);
                    switch (alt21) {
                        case 1 :
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:3: (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3
                            {
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:3: (this_WS_8= RULE_WS )*
                            loop12:
                            do {
                                int alt12=2;
                                int LA12_0 = input.LA(1);

                                if ( (LA12_0==RULE_WS) ) {
                                    alt12=1;
                                }


                                switch (alt12) {
                            	case 1 :
                            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:571:4: this_WS_8= RULE_WS
                            	    {
                            	    this_WS_8=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1107); 
                            	     
                            	        newLeafNode(this_WS_8, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_0()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop12;
                                }
                            } while (true);

                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:575:3: ( (lv_expectingParameters_9_0= KEYWORD_2 ) )
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:576:1: (lv_expectingParameters_9_0= KEYWORD_2 )
                            {
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:576:1: (lv_expectingParameters_9_0= KEYWORD_2 )
                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:577:3: lv_expectingParameters_9_0= KEYWORD_2
                            {
                            lv_expectingParameters_9_0=(Token)match(input,KEYWORD_2,FOLLOW_KEYWORD_2_in_ruleVariable1127); 

                                    newLeafNode(lv_expectingParameters_9_0, grammarAccess.getVariableAccess().getExpectingParametersLeftParenthesisKeyword_2_1_4_1_0());
                                

                            	        if (current==null) {
                            	            current = createModelElement(grammarAccess.getVariableRule());
                            	        }
                                   		setWithLastConsumed(current, "expectingParameters", true, "(");
                            	    

                            }


                            }

                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:591:2: (this_WS_10= RULE_WS )*
                            loop13:
                            do {
                                int alt13=2;
                                int LA13_0 = input.LA(1);

                                if ( (LA13_0==RULE_WS) ) {
                                    alt13=1;
                                }


                                switch (alt13) {
                            	case 1 :
                            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:591:3: this_WS_10= RULE_WS
                            	    {
                            	    this_WS_10=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1150); 
                            	     
                            	        newLeafNode(this_WS_10, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_2()); 
                            	        

                            	    }
                            	    break;

                            	default :
                            	    break loop13;
                                }
                            } while (true);

                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:595:3: ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )?
                            int alt20=2;
                            int LA20_0 = input.LA(1);

                            if ( (LA20_0==KEYWORD_14||LA20_0==KEYWORD_13||(LA20_0>=RULE_ID && LA20_0<=RULE_STRING)) ) {
                                alt20=1;
                            }
                            switch (alt20) {
                                case 1 :
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:595:4: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )*
                                    {
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:595:4: ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) )
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:596:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    {
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:596:1: ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) )
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:597:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    {
                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:597:1: (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN )
                                    int alt14=2;
                                    int LA14_0 = input.LA(1);

                                    if ( (LA14_0==RULE_STRING) ) {
                                        alt14=1;
                                    }
                                    else if ( (LA14_0==KEYWORD_14||LA14_0==KEYWORD_13||LA14_0==RULE_ID) ) {
                                        alt14=2;
                                    }
                                    else {
                                        NoViableAltException nvae =
                                            new NoViableAltException("", 14, 0, input);

                                        throw nvae;
                                    }
                                    switch (alt14) {
                                        case 1 :
                                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:598:3: lv_parameters_11_1= RULE_STRING
                                            {
                                            lv_parameters_11_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1171); 

                                            			newLeafNode(lv_parameters_11_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_0_0_0()); 
                                            		

                                            	        if (current==null) {
                                            	            current = createModelElement(grammarAccess.getVariableRule());
                                            	        }
                                                   		addWithLastConsumed(
                                                   			current, 
                                                   			"parameters",
                                                    		lv_parameters_11_1, 
                                                    		"STRING");
                                            	    

                                            }
                                            break;
                                        case 2 :
                                            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:613:8: lv_parameters_11_2= ruleFQN
                                            {
                                             
                                            	        newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_0_0_1()); 
                                            	    
                                            pushFollow(FOLLOW_ruleFQN_in_ruleVariable1195);
                                            lv_parameters_11_2=ruleFQN();

                                            state._fsp--;


                                            	        if (current==null) {
                                            	            current = createModelElementForParent(grammarAccess.getVariableRule());
                                            	        }
                                                   		add(
                                                   			current, 
                                                   			"parameters",
                                                    		lv_parameters_11_2, 
                                                    		"FQN");
                                            	        afterParserOrEnumRuleCall();
                                            	    

                                            }
                                            break;

                                    }


                                    }


                                    }

                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:631:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*
                                    loop18:
                                    do {
                                        int alt18=2;
                                        alt18 = dfa18.predict(input);
                                        switch (alt18) {
                                    	case 1 :
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:631:3: (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    {
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:631:3: (this_WS_12= RULE_WS )*
                                    	    loop15:
                                    	    do {
                                    	        int alt15=2;
                                    	        int LA15_0 = input.LA(1);

                                    	        if ( (LA15_0==RULE_WS) ) {
                                    	            alt15=1;
                                    	        }


                                    	        switch (alt15) {
                                    	    	case 1 :
                                    	    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:631:4: this_WS_12= RULE_WS
                                    	    	    {
                                    	    	    this_WS_12=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1211); 
                                    	    	     
                                    	    	        newLeafNode(this_WS_12, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_0()); 
                                    	    	        

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop15;
                                    	        }
                                    	    } while (true);

                                    	    otherlv_13=(Token)match(input,KEYWORD_4,FOLLOW_KEYWORD_4_in_ruleVariable1225); 

                                    	        	newLeafNode(otherlv_13, grammarAccess.getVariableAccess().getCommaKeyword_2_1_4_3_1_1());
                                    	        
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:640:1: (this_WS_14= RULE_WS )*
                                    	    loop16:
                                    	    do {
                                    	        int alt16=2;
                                    	        int LA16_0 = input.LA(1);

                                    	        if ( (LA16_0==RULE_WS) ) {
                                    	            alt16=1;
                                    	        }


                                    	        switch (alt16) {
                                    	    	case 1 :
                                    	    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:640:2: this_WS_14= RULE_WS
                                    	    	    {
                                    	    	    this_WS_14=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1236); 
                                    	    	     
                                    	    	        newLeafNode(this_WS_14, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_1_2()); 
                                    	    	        

                                    	    	    }
                                    	    	    break;

                                    	    	default :
                                    	    	    break loop16;
                                    	        }
                                    	    } while (true);

                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:644:3: ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) )
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:645:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    {
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:645:1: ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) )
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:646:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    {
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:646:1: (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN )
                                    	    int alt17=2;
                                    	    int LA17_0 = input.LA(1);

                                    	    if ( (LA17_0==RULE_STRING) ) {
                                    	        alt17=1;
                                    	    }
                                    	    else if ( (LA17_0==KEYWORD_14||LA17_0==KEYWORD_13||LA17_0==RULE_ID) ) {
                                    	        alt17=2;
                                    	    }
                                    	    else {
                                    	        NoViableAltException nvae =
                                    	            new NoViableAltException("", 17, 0, input);

                                    	        throw nvae;
                                    	    }
                                    	    switch (alt17) {
                                    	        case 1 :
                                    	            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:647:3: lv_parameters_15_1= RULE_STRING
                                    	            {
                                    	            lv_parameters_15_1=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleVariable1256); 

                                    	            			newLeafNode(lv_parameters_15_1, grammarAccess.getVariableAccess().getParametersSTRINGTerminalRuleCall_2_1_4_3_1_3_0_0()); 
                                    	            		

                                    	            	        if (current==null) {
                                    	            	            current = createModelElement(grammarAccess.getVariableRule());
                                    	            	        }
                                    	                   		addWithLastConsumed(
                                    	                   			current, 
                                    	                   			"parameters",
                                    	                    		lv_parameters_15_1, 
                                    	                    		"STRING");
                                    	            	    

                                    	            }
                                    	            break;
                                    	        case 2 :
                                    	            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:662:8: lv_parameters_15_2= ruleFQN
                                    	            {
                                    	             
                                    	            	        newCompositeNode(grammarAccess.getVariableAccess().getParametersFQNParserRuleCall_2_1_4_3_1_3_0_1()); 
                                    	            	    
                                    	            pushFollow(FOLLOW_ruleFQN_in_ruleVariable1280);
                                    	            lv_parameters_15_2=ruleFQN();

                                    	            state._fsp--;


                                    	            	        if (current==null) {
                                    	            	            current = createModelElementForParent(grammarAccess.getVariableRule());
                                    	            	        }
                                    	                   		add(
                                    	                   			current, 
                                    	                   			"parameters",
                                    	                    		lv_parameters_15_2, 
                                    	                    		"FQN");
                                    	            	        afterParserOrEnumRuleCall();
                                    	            	    

                                    	            }
                                    	            break;

                                    	    }


                                    	    }


                                    	    }


                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop18;
                                        }
                                    } while (true);

                                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:680:4: (this_WS_16= RULE_WS )*
                                    loop19:
                                    do {
                                        int alt19=2;
                                        int LA19_0 = input.LA(1);

                                        if ( (LA19_0==RULE_WS) ) {
                                            alt19=1;
                                        }


                                        switch (alt19) {
                                    	case 1 :
                                    	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:680:5: this_WS_16= RULE_WS
                                    	    {
                                    	    this_WS_16=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1297); 
                                    	     
                                    	        newLeafNode(this_WS_16, grammarAccess.getVariableAccess().getWSTerminalRuleCall_2_1_4_3_2()); 
                                    	        

                                    	    }
                                    	    break;

                                    	default :
                                    	    break loop19;
                                        }
                                    } while (true);


                                    }
                                    break;

                            }

                            otherlv_17=(Token)match(input,KEYWORD_3,FOLLOW_KEYWORD_3_in_ruleVariable1313); 

                                	newLeafNode(otherlv_17, grammarAccess.getVariableAccess().getRightParenthesisKeyword_2_1_4_4());
                                

                            }
                            break;

                    }


                    }


                    }
                    break;

            }

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:689:5: (this_WS_18= RULE_WS )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==RULE_WS) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:689:6: this_WS_18= RULE_WS
            	    {
            	    this_WS_18=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleVariable1328); 
            	     
            	        newLeafNode(this_WS_18, grammarAccess.getVariableAccess().getWSTerminalRuleCall_3()); 
            	        

            	    }
            	    break;

            	default :
            	    break loop23;
                }
            } while (true);

            otherlv_19=(Token)match(input,KEYWORD_7,FOLLOW_KEYWORD_7_in_ruleVariable1342); 

                	newLeafNode(otherlv_19, grammarAccess.getVariableAccess().getRightCurlyBracketKeyword_4());
                

            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleVariable"


    // $ANTLR start "entryRuleValidID"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:709:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:713:1: (iv_ruleValidID= ruleValidID EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:714:2: iv_ruleValidID= ruleValidID EOF
            {
             newCompositeNode(grammarAccess.getValidIDRule()); 
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1387);
            iv_ruleValidID=ruleValidID();

            state._fsp--;

             current =iv_ruleValidID.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1398); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:724:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 ) ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:729:6: ( (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:730:1: (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:730:1: (this_ID_0= RULE_ID | kw= KEYWORD_13 | kw= KEYWORD_14 )
            int alt24=3;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt24=1;
                }
                break;
            case KEYWORD_13:
                {
                alt24=2;
                }
                break;
            case KEYWORD_14:
                {
                alt24=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 24, 0, input);

                throw nvae;
            }

            switch (alt24) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:730:6: this_ID_0= RULE_ID
                    {
                    this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1442); 

                    		current.merge(this_ID_0);
                        
                     
                        newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall_0()); 
                        

                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:739:2: kw= KEYWORD_13
                    {
                    kw=(Token)match(input,KEYWORD_13,FOLLOW_KEYWORD_13_in_ruleValidID1466); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getValidIDAccess().getForKeyword_1()); 
                        

                    }
                    break;
                case 3 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:746:2: kw= KEYWORD_14
                    {
                    kw=(Token)match(input,KEYWORD_14,FOLLOW_KEYWORD_14_in_ruleValidID1485); 

                            current.merge(kw);
                            newLeafNode(kw, grammarAccess.getValidIDAccess().getTemplatesKeyword_2()); 
                        

                    }
                    break;

            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleFQN"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:762:1: entryRuleFQN returns [String current=null] : iv_ruleFQN= ruleFQN EOF ;
    public final String entryRuleFQN() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleFQN = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:766:1: (iv_ruleFQN= ruleFQN EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:767:2: iv_ruleFQN= ruleFQN EOF
            {
             newCompositeNode(grammarAccess.getFQNRule()); 
            pushFollow(FOLLOW_ruleFQN_in_entryRuleFQN1535);
            iv_ruleFQN=ruleFQN();

            state._fsp--;

             current =iv_ruleFQN.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleFQN1546); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleFQN"


    // $ANTLR start "ruleFQN"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:777:1: ruleFQN returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleFQN() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:782:6: ( (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:783:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:783:1: (this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )* )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:784:5: this_ValidID_0= ruleValidID (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            {
             
                    newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_0()); 
                
            pushFollow(FOLLOW_ruleValidID_in_ruleFQN1597);
            this_ValidID_0=ruleValidID();

            state._fsp--;


            		current.merge(this_ValidID_0);
                
             
                    afterParserOrEnumRuleCall();
                
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:794:1: (kw= KEYWORD_5 this_ValidID_2= ruleValidID )*
            loop25:
            do {
                int alt25=2;
                int LA25_0 = input.LA(1);

                if ( (LA25_0==KEYWORD_5) ) {
                    alt25=1;
                }


                switch (alt25) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:795:2: kw= KEYWORD_5 this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,KEYWORD_5,FOLLOW_KEYWORD_5_in_ruleFQN1616); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getFQNAccess().getFullStopKeyword_1_0()); 
            	        
            	     
            	            newCompositeNode(grammarAccess.getFQNAccess().getValidIDParserRuleCall_1_1()); 
            	        
            	    pushFollow(FOLLOW_ruleValidID_in_ruleFQN1638);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;


            	    		current.merge(this_ValidID_2);
            	        
            	     
            	            afterParserOrEnumRuleCall();
            	        

            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);


            }


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleFQN"


    // $ANTLR start "entryRuleLiteral"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:822:1: entryRuleLiteral returns [EObject current=null] : iv_ruleLiteral= ruleLiteral EOF ;
    public final EObject entryRuleLiteral() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLiteral = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:826:2: (iv_ruleLiteral= ruleLiteral EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:827:2: iv_ruleLiteral= ruleLiteral EOF
            {
             newCompositeNode(grammarAccess.getLiteralRule()); 
            pushFollow(FOLLOW_ruleLiteral_in_entryRuleLiteral1694);
            iv_ruleLiteral=ruleLiteral();

            state._fsp--;

             current =iv_ruleLiteral; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteral1704); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLiteral"


    // $ANTLR start "ruleLiteral"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:837:1: ruleLiteral returns [EObject current=null] : ( (lv_value_0_0= ruleLiteralValue ) ) ;
    public final EObject ruleLiteral() throws RecognitionException {
        EObject current = null;

        AntlrDatatypeRuleToken lv_value_0_0 = null;


         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:841:28: ( ( (lv_value_0_0= ruleLiteralValue ) ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:842:1: ( (lv_value_0_0= ruleLiteralValue ) )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:842:1: ( (lv_value_0_0= ruleLiteralValue ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:843:1: (lv_value_0_0= ruleLiteralValue )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:843:1: (lv_value_0_0= ruleLiteralValue )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:844:3: lv_value_0_0= ruleLiteralValue
            {
             
            	        newCompositeNode(grammarAccess.getLiteralAccess().getValueLiteralValueParserRuleCall_0()); 
            	    
            pushFollow(FOLLOW_ruleLiteralValue_in_ruleLiteral1753);
            lv_value_0_0=ruleLiteralValue();

            state._fsp--;


            	        if (current==null) {
            	            current = createModelElementForParent(grammarAccess.getLiteralRule());
            	        }
                   		set(
                   			current, 
                   			"value",
                    		lv_value_0_0, 
                    		"LiteralValue");
            	        afterParserOrEnumRuleCall();
            	    

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLiteral"


    // $ANTLR start "entryRuleLiteralValue"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:871:1: entryRuleLiteralValue returns [String current=null] : iv_ruleLiteralValue= ruleLiteralValue EOF ;
    public final String entryRuleLiteralValue() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleLiteralValue = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:875:1: (iv_ruleLiteralValue= ruleLiteralValue EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:876:2: iv_ruleLiteralValue= ruleLiteralValue EOF
            {
             newCompositeNode(grammarAccess.getLiteralValueRule()); 
            pushFollow(FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue1798);
            iv_ruleLiteralValue=ruleLiteralValue();

            state._fsp--;

             current =iv_ruleLiteralValue.getText(); 
            match(input,EOF,FOLLOW_EOF_in_entryRuleLiteralValue1809); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleLiteralValue"


    // $ANTLR start "ruleLiteralValue"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:886:1: ruleLiteralValue returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+ ;
    public final AntlrDatatypeRuleToken ruleLiteralValue() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_WS_0=null;
        Token this_ANY_OTHER_1=null;
        Token this_ID_2=null;
        Token kw=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:891:6: ( (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+ )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:892:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:892:1: (this_WS_0= RULE_WS | this_ANY_OTHER_1= RULE_ANY_OTHER | this_ID_2= RULE_ID | kw= KEYWORD_12 )+
            int cnt26=0;
            loop26:
            do {
                int alt26=5;
                switch ( input.LA(1) ) {
                case RULE_WS:
                    {
                    alt26=1;
                    }
                    break;
                case RULE_ANY_OTHER:
                    {
                    alt26=2;
                    }
                    break;
                case RULE_ID:
                    {
                    alt26=3;
                    }
                    break;
                case KEYWORD_12:
                    {
                    alt26=4;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:892:6: this_WS_0= RULE_WS
            	    {
            	    this_WS_0=(Token)match(input,RULE_WS,FOLLOW_RULE_WS_in_ruleLiteralValue1853); 

            	    		current.merge(this_WS_0);
            	        
            	     
            	        newLeafNode(this_WS_0, grammarAccess.getLiteralValueAccess().getWSTerminalRuleCall_0()); 
            	        

            	    }
            	    break;
            	case 2 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:900:10: this_ANY_OTHER_1= RULE_ANY_OTHER
            	    {
            	    this_ANY_OTHER_1=(Token)match(input,RULE_ANY_OTHER,FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue1879); 

            	    		current.merge(this_ANY_OTHER_1);
            	        
            	     
            	        newLeafNode(this_ANY_OTHER_1, grammarAccess.getLiteralValueAccess().getANY_OTHERTerminalRuleCall_1()); 
            	        

            	    }
            	    break;
            	case 3 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:908:10: this_ID_2= RULE_ID
            	    {
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleLiteralValue1905); 

            	    		current.merge(this_ID_2);
            	        
            	     
            	        newLeafNode(this_ID_2, grammarAccess.getLiteralValueAccess().getIDTerminalRuleCall_2()); 
            	        

            	    }
            	    break;
            	case 4 :
            	    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:917:2: kw= KEYWORD_12
            	    {
            	    kw=(Token)match(input,KEYWORD_12,FOLLOW_KEYWORD_12_in_ruleLiteralValue1929); 

            	            current.merge(kw);
            	            newLeafNode(kw, grammarAccess.getLiteralValueAccess().getReverseSolidusLessThanSignLessThanSignKeyword_3()); 
            	        

            	    }
            	    break;

            	default :
            	    if ( cnt26 >= 1 ) break loop26;
                        EarlyExitException eee =
                            new EarlyExitException(26, input);
                        throw eee;
                }
                cnt26++;
            } while (true);


            }

             leaveRule();
                
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleLiteralValue"


    // $ANTLR start "entryRuleDollar"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:933:1: entryRuleDollar returns [EObject current=null] : iv_ruleDollar= ruleDollar EOF ;
    public final EObject entryRuleDollar() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDollar = null;


         
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
        	
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:937:2: (iv_ruleDollar= ruleDollar EOF )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:938:2: iv_ruleDollar= ruleDollar EOF
            {
             newCompositeNode(grammarAccess.getDollarRule()); 
            pushFollow(FOLLOW_ruleDollar_in_entryRuleDollar1979);
            iv_ruleDollar=ruleDollar();

            state._fsp--;

             current =iv_ruleDollar; 
            match(input,EOF,FOLLOW_EOF_in_entryRuleDollar1989); 

            }

        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "entryRuleDollar"


    // $ANTLR start "ruleDollar"
    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:948:1: ruleDollar returns [EObject current=null] : ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) ;
    public final EObject ruleDollar() throws RecognitionException {
        EObject current = null;

        Token lv_escaped_1_0=null;
        Token otherlv_2=null;

         enterRule(); 
        		HiddenTokens myHiddenTokenState = ((XtextTokenStream)input).setHiddenTokens();
            
        try {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:952:28: ( ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:953:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:953:1: ( () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 ) )
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:953:2: () ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            {
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:953:2: ()
            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:954:5: 
            {

                    current = forceCreateModelElement(
                        grammarAccess.getDollarAccess().getDollarAction_0(),
                        current);
                

            }

            // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:959:2: ( ( (lv_escaped_1_0= KEYWORD_8 ) ) | otherlv_2= KEYWORD_1 )
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==KEYWORD_8) ) {
                alt27=1;
            }
            else if ( (LA27_0==KEYWORD_1) ) {
                alt27=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 27, 0, input);

                throw nvae;
            }
            switch (alt27) {
                case 1 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:959:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:959:3: ( (lv_escaped_1_0= KEYWORD_8 ) )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:960:1: (lv_escaped_1_0= KEYWORD_8 )
                    {
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:960:1: (lv_escaped_1_0= KEYWORD_8 )
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:961:3: lv_escaped_1_0= KEYWORD_8
                    {
                    lv_escaped_1_0=(Token)match(input,KEYWORD_8,FOLLOW_KEYWORD_8_in_ruleDollar2047); 

                            newLeafNode(lv_escaped_1_0, grammarAccess.getDollarAccess().getEscapedDollarSignDollarSignKeyword_1_0_0());
                        

                    	        if (current==null) {
                    	            current = createModelElement(grammarAccess.getDollarRule());
                    	        }
                           		setWithLastConsumed(current, "escaped", true, "$$");
                    	    

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.ui.codetemplates/src-gen/org/eclipse/xtext/ui/codetemplates/parser/antlr/internal/InternalCodetemplatesParser.g:977:2: otherlv_2= KEYWORD_1
                    {
                    otherlv_2=(Token)match(input,KEYWORD_1,FOLLOW_KEYWORD_1_in_ruleDollar2077); 

                        	newLeafNode(otherlv_2, grammarAccess.getDollarAccess().getDollarSignKeyword_1_1());
                        

                    }
                    break;

            }


            }


            }

             leaveRule(); 
        }
         
        	catch (RecognitionException re) { 
        	    recover(input,re); 
        	    appendSkippedTokens();
        	}
        finally {

            	myHiddenTokenState.restore();

        }
        return current;
    }
    // $ANTLR end "ruleDollar"

    // Delegated rules


    protected DFA22 dfa22 = new DFA22(this);
    protected DFA21 dfa21 = new DFA21(this);
    protected DFA18 dfa18 = new DFA18(this);
    static final String DFA22_eotS =
        "\7\uffff";
    static final String DFA22_eofS =
        "\7\uffff";
    static final String DFA22_minS =
        "\1\4\3\20\1\uffff\1\20\1\uffff";
    static final String DFA22_maxS =
        "\1\22\3\24\1\uffff\1\24\1\uffff";
    static final String DFA22_acceptS =
        "\4\uffff\1\2\1\uffff\1\1";
    static final String DFA22_specialS =
        "\7\uffff}>";
    static final String[] DFA22_transitionS = {
            "\1\3\1\uffff\1\2\11\uffff\1\4\1\uffff\1\1",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "\1\4\1\6\2\uffff\1\5",
            "",
            "\1\4\1\6\2\uffff\1\5",
            ""
    };

    static final short[] DFA22_eot = DFA.unpackEncodedString(DFA22_eotS);
    static final short[] DFA22_eof = DFA.unpackEncodedString(DFA22_eofS);
    static final char[] DFA22_min = DFA.unpackEncodedStringToUnsignedChars(DFA22_minS);
    static final char[] DFA22_max = DFA.unpackEncodedStringToUnsignedChars(DFA22_maxS);
    static final short[] DFA22_accept = DFA.unpackEncodedString(DFA22_acceptS);
    static final short[] DFA22_special = DFA.unpackEncodedString(DFA22_specialS);
    static final short[][] DFA22_transition;

    static {
        int numStates = DFA22_transitionS.length;
        DFA22_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA22_transition[i] = DFA.unpackEncodedString(DFA22_transitionS[i]);
        }
    }

    class DFA22 extends DFA {

        public DFA22(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 22;
            this.eot = DFA22_eot;
            this.eof = DFA22_eof;
            this.min = DFA22_min;
            this.max = DFA22_max;
            this.accept = DFA22_accept;
            this.special = DFA22_special;
            this.transition = DFA22_transition;
        }
        public String getDescription() {
            return "503:3: ( ( (lv_name_2_0= ruleValidID ) ) | ( ( ( (lv_name_3_0= ruleValidID ) ) (this_WS_4= RULE_WS )* )? otherlv_5= KEYWORD_6 (this_WS_6= RULE_WS )* ( (lv_type_7_0= ruleValidID ) ) ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )? ) )";
        }
    }
    static final String DFA21_eotS =
        "\4\uffff";
    static final String DFA21_eofS =
        "\4\uffff";
    static final String DFA21_minS =
        "\2\14\2\uffff";
    static final String DFA21_maxS =
        "\2\24\2\uffff";
    static final String DFA21_acceptS =
        "\2\uffff\1\1\1\2";
    static final String DFA21_specialS =
        "\4\uffff}>";
    static final String[] DFA21_transitionS = {
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "\1\2\4\uffff\1\3\2\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA21_eot = DFA.unpackEncodedString(DFA21_eotS);
    static final short[] DFA21_eof = DFA.unpackEncodedString(DFA21_eofS);
    static final char[] DFA21_min = DFA.unpackEncodedStringToUnsignedChars(DFA21_minS);
    static final char[] DFA21_max = DFA.unpackEncodedStringToUnsignedChars(DFA21_maxS);
    static final short[] DFA21_accept = DFA.unpackEncodedString(DFA21_acceptS);
    static final short[] DFA21_special = DFA.unpackEncodedString(DFA21_specialS);
    static final short[][] DFA21_transition;

    static {
        int numStates = DFA21_transitionS.length;
        DFA21_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA21_transition[i] = DFA.unpackEncodedString(DFA21_transitionS[i]);
        }
    }

    class DFA21 extends DFA {

        public DFA21(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 21;
            this.eot = DFA21_eot;
            this.eof = DFA21_eof;
            this.min = DFA21_min;
            this.max = DFA21_max;
            this.accept = DFA21_accept;
            this.special = DFA21_special;
            this.transition = DFA21_transition;
        }
        public String getDescription() {
            return "571:2: ( (this_WS_8= RULE_WS )* ( (lv_expectingParameters_9_0= KEYWORD_2 ) ) (this_WS_10= RULE_WS )* ( ( ( (lv_parameters_11_1= RULE_STRING | lv_parameters_11_2= ruleFQN ) ) ) ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )* (this_WS_16= RULE_WS )* )? otherlv_17= KEYWORD_3 )?";
        }
    }
    static final String DFA18_eotS =
        "\4\uffff";
    static final String DFA18_eofS =
        "\4\uffff";
    static final String DFA18_minS =
        "\2\15\2\uffff";
    static final String DFA18_maxS =
        "\2\24\2\uffff";
    static final String DFA18_acceptS =
        "\2\uffff\1\2\1\1";
    static final String DFA18_specialS =
        "\4\uffff}>";
    static final String[] DFA18_transitionS = {
            "\1\2\1\3\5\uffff\1\1",
            "\1\2\1\3\5\uffff\1\1",
            "",
            ""
    };

    static final short[] DFA18_eot = DFA.unpackEncodedString(DFA18_eotS);
    static final short[] DFA18_eof = DFA.unpackEncodedString(DFA18_eofS);
    static final char[] DFA18_min = DFA.unpackEncodedStringToUnsignedChars(DFA18_minS);
    static final char[] DFA18_max = DFA.unpackEncodedStringToUnsignedChars(DFA18_maxS);
    static final short[] DFA18_accept = DFA.unpackEncodedString(DFA18_acceptS);
    static final short[] DFA18_special = DFA.unpackEncodedString(DFA18_specialS);
    static final short[][] DFA18_transition;

    static {
        int numStates = DFA18_transitionS.length;
        DFA18_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA18_transition[i] = DFA.unpackEncodedString(DFA18_transitionS[i]);
        }
    }

    class DFA18 extends DFA {

        public DFA18(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 18;
            this.eot = DFA18_eot;
            this.eof = DFA18_eof;
            this.min = DFA18_min;
            this.max = DFA18_max;
            this.accept = DFA18_accept;
            this.special = DFA18_special;
            this.transition = DFA18_transition;
        }
        public String getDescription() {
            return "()* loopback of 631:2: ( (this_WS_12= RULE_WS )* otherlv_13= KEYWORD_4 (this_WS_14= RULE_WS )* ( ( (lv_parameters_15_1= RULE_STRING | lv_parameters_15_2= ruleFQN ) ) ) )*";
        }
    }
 

    public static final BitSet FOLLOW_ruleCodetemplates_in_entryRuleCodetemplates67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplates77 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleCodetemplates115 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCodetemplates127 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleCodetemplates149 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleCodetemplates162 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_ruleCodetemplates182 = new BitSet(new long[]{0x0000000000040052L});
    public static final BitSet FOLLOW_ruleCodetemplate_in_entryRuleCodetemplate218 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleCodetemplate228 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCodetemplate274 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleCodetemplate287 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleCodetemplate303 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleCodetemplate321 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate337 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleCodetemplate355 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleCodetemplate367 = new BitSet(new long[]{0x00000000000C0050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleCodetemplate390 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleCodetemplate413 = new BitSet(new long[]{0x0000000000100400L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_ruleCodetemplate440 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBodyWithQuotes_in_entryRuleTemplateBodyWithQuotes481 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBodyWithQuotes491 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleTemplateBodyWithQuotes532 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_KEYWORD_11_in_ruleTemplateBodyWithQuotes546 = new BitSet(new long[]{0x0000000000340BA0L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_ruleTemplateBodyWithQuotes567 = new BitSet(new long[]{0x0000000000000200L});
    public static final BitSet FOLLOW_KEYWORD_10_in_ruleTemplateBodyWithQuotes579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleTemplateBody_in_entryRuleTemplateBody623 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleTemplateBody633 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody692 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_ruleTemplateBody715 = new BitSet(new long[]{0x00000000003409A2L});
    public static final BitSet FOLLOW_ruleLiteral_in_ruleTemplateBody736 = new BitSet(new long[]{0x0000000000000982L});
    public static final BitSet FOLLOW_ruleVariableOrDollar_in_entryRuleVariableOrDollar786 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariableOrDollar796 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_ruleVariableOrDollar847 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleDollar_in_ruleVariableOrDollar874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleVariable_in_entryRuleVariable918 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleVariable928 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_9_in_ruleVariable970 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable981 = new BitSet(new long[]{0x0000000000150050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1004 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1033 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1045 = new BitSet(new long[]{0x0000000000110000L});
    public static final BitSet FOLLOW_KEYWORD_6_in_ruleVariable1061 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1072 = new BitSet(new long[]{0x0000000000140050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleVariable1094 = new BitSet(new long[]{0x0000000000121000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1107 = new BitSet(new long[]{0x0000000000101000L});
    public static final BitSet FOLLOW_KEYWORD_2_in_ruleVariable1127 = new BitSet(new long[]{0x00000000001C2050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1150 = new BitSet(new long[]{0x00000000001C2050L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1171 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1195 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1211 = new BitSet(new long[]{0x0000000000104000L});
    public static final BitSet FOLLOW_KEYWORD_4_in_ruleVariable1225 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1236 = new BitSet(new long[]{0x00000000001C0050L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleVariable1256 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_ruleFQN_in_ruleVariable1280 = new BitSet(new long[]{0x0000000000106000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1297 = new BitSet(new long[]{0x0000000000102000L});
    public static final BitSet FOLLOW_KEYWORD_3_in_ruleVariable1313 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleVariable1328 = new BitSet(new long[]{0x0000000000120000L});
    public static final BitSet FOLLOW_KEYWORD_7_in_ruleVariable1342 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1387 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1398 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1442 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_13_in_ruleValidID1466 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_14_in_ruleValidID1485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleFQN_in_entryRuleFQN1535 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleFQN1546 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1597 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_KEYWORD_5_in_ruleFQN1616 = new BitSet(new long[]{0x0000000000040050L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleFQN1638 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_ruleLiteral_in_entryRuleLiteral1694 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteral1704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_ruleLiteral1753 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleLiteralValue_in_entryRuleLiteralValue1798 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleLiteralValue1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_WS_in_ruleLiteralValue1853 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_RULE_ANY_OTHER_in_ruleLiteralValue1879 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleLiteralValue1905 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_KEYWORD_12_in_ruleLiteralValue1929 = new BitSet(new long[]{0x0000000000340022L});
    public static final BitSet FOLLOW_ruleDollar_in_entryRuleDollar1979 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleDollar1989 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_8_in_ruleDollar2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_KEYWORD_1_in_ruleDollar2077 = new BitSet(new long[]{0x0000000000000002L});

}