package org.summer.dsl.xtype.parser.antlr.internal; 

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.summer.dsl.xtype.services.XtypeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtypeParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'('", "','", "')'", "'=>'", "'<'", "'>'", "'?'", "'extends'", "'&'", "'super'", "'.'", "'import'", "'{'", "'}'", "'from'", "'as'", "'export'"
    };
    public static final int RULE_ID=4;
    public static final int T__28=28;
    public static final int T__27=27;
    public static final int T__26=26;
    public static final int T__25=25;
    public static final int T__24=24;
    public static final int T__23=23;
    public static final int T__22=22;
    public static final int RULE_ANY_OTHER=9;
    public static final int T__21=21;
    public static final int T__20=20;
    public static final int RULE_SL_COMMENT=7;
    public static final int EOF=-1;
    public static final int RULE_ML_COMMENT=6;
    public static final int T__19=19;
    public static final int RULE_STRING=5;
    public static final int T__16=16;
    public static final int T__15=15;
    public static final int T__18=18;
    public static final int T__17=17;
    public static final int T__12=12;
    public static final int T__11=11;
    public static final int T__14=14;
    public static final int T__13=13;
    public static final int T__10=10;
    public static final int RULE_WS=8;

    // delegates
    // delegators


        public InternalXtypeParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalXtypeParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalXtypeParser.tokenNames; }
    public String getGrammarFileName() { return "../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g"; }



     	private XtypeGrammarAccess grammarAccess;
     	
        public InternalXtypeParser(TokenStream input, XtypeGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }
        
        @Override
        protected String getFirstRuleName() {
        	return "JvmTypeReference";	
       	}
       	
       	@Override
       	protected XtypeGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}



    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:67:1: entryRuleJvmTypeReference returns [EObject current=null] : iv_ruleJvmTypeReference= ruleJvmTypeReference EOF ;
    public final EObject entryRuleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:68:2: (iv_ruleJvmTypeReference= ruleJvmTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:69:2: iv_ruleJvmTypeReference= ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference75);
            iv_ruleJvmTypeReference=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference85); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:76:1: ruleJvmTypeReference returns [EObject current=null] : ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;

        EObject this_XFunctionTypeRef_3 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:79:28: ( ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:1: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) | this_XFunctionTypeRef_3= ruleXFunctionTypeRef )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID) ) {
                alt2=1;
            }
            else if ( (LA2_0==12||LA2_0==15) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:2: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:81:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference133);
                    this_JvmParameterizedTypeReference_0=ruleJvmParameterizedTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmParameterizedTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:1: ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
                    loop1:
                    do {
                        int alt1=2;
                        int LA1_0 = input.LA(1);

                        if ( (LA1_0==10) && (synpred1_InternalXtype())) {
                            alt1=1;
                        }


                        switch (alt1) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:2: ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:90:24: ( () ruleArrayBrackets )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:90:25: () ruleArrayBrackets
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:90:25: ()
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:91:5: 
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	              current = forceCreateModelElementAndSet(
                    	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0(),
                    	                  current);
                    	          
                    	    }

                    	    }

                    	    if ( state.backtracking==0 ) {
                    	       
                    	              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
                    	          
                    	    }
                    	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference169);
                    	    ruleArrayBrackets();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {
                    	       
                    	              afterParserOrEnumRuleCall();
                    	          
                    	    }

                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop1;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:106:5: this_XFunctionTypeRef_3= ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference200);
                    this_XFunctionTypeRef_3=ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_XFunctionTypeRef_3; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:122:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:123:2: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:124:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets236);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets247); if (state.failed) return current;

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
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:131:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:134:28: ( (kw= '[' kw= ']' ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:135:1: (kw= '[' kw= ']' )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:135:1: (kw= '[' kw= ']' )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:136:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets285); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets298); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
                  
            }

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:155:1: entryRuleXFunctionTypeRef returns [EObject current=null] : iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF ;
    public final EObject entryRuleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXFunctionTypeRef = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:156:2: (iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:157:2: iv_ruleXFunctionTypeRef= ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef338);
            iv_ruleXFunctionTypeRef=ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXFunctionTypeRef; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef348); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:164:1: ruleXFunctionTypeRef returns [EObject current=null] : ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleXFunctionTypeRef() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        EObject lv_paramTypes_1_0 = null;

        EObject lv_paramTypes_3_0 = null;

        EObject lv_returnType_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:167:28: ( ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:168:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:168:1: ( (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:168:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )? otherlv_5= '=>' ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:168:2: (otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')' )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==12) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:168:4: otherlv_0= '(' ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )? otherlv_4= ')'
                    {
                    otherlv_0=(Token)match(input,12,FOLLOW_12_in_ruleXFunctionTypeRef386); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_0, grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:172:1: ( ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )* )?
                    int alt4=2;
                    int LA4_0 = input.LA(1);

                    if ( (LA4_0==RULE_ID||LA4_0==12||LA4_0==15) ) {
                        alt4=1;
                    }
                    switch (alt4) {
                        case 1 :
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:172:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) ) (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:172:2: ( (lv_paramTypes_1_0= ruleJvmTypeReference ) )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:1: (lv_paramTypes_1_0= ruleJvmTypeReference )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:174:3: lv_paramTypes_1_0= ruleJvmTypeReference
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef408);
                            lv_paramTypes_1_0=ruleJvmTypeReference();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                              	        }
                                     		add(
                                     			current, 
                                     			"paramTypes",
                                      		lv_paramTypes_1_0, 
                                      		"JvmTypeReference");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:190:2: (otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) ) )*
                            loop3:
                            do {
                                int alt3=2;
                                int LA3_0 = input.LA(1);

                                if ( (LA3_0==13) ) {
                                    alt3=1;
                                }


                                switch (alt3) {
                            	case 1 :
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:190:4: otherlv_2= ',' ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    {
                            	    otherlv_2=(Token)match(input,13,FOLLOW_13_in_ruleXFunctionTypeRef421); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_2, grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0());
                            	          
                            	    }
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:194:1: ( (lv_paramTypes_3_0= ruleJvmTypeReference ) )
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:195:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    {
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:195:1: (lv_paramTypes_3_0= ruleJvmTypeReference )
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:196:3: lv_paramTypes_3_0= ruleJvmTypeReference
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442);
                            	    lv_paramTypes_3_0=ruleJvmTypeReference();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"paramTypes",
                            	              		lv_paramTypes_3_0, 
                            	              		"JvmTypeReference");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop3;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_4=(Token)match(input,14,FOLLOW_14_in_ruleXFunctionTypeRef458); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_4, grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2());
                          
                    }

                    }
                    break;

            }

            otherlv_5=(Token)match(input,15,FOLLOW_15_in_ruleXFunctionTypeRef472); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_5, grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:220:1: ( (lv_returnType_6_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:221:1: (lv_returnType_6_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:221:1: (lv_returnType_6_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:222:3: lv_returnType_6_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef493);
            lv_returnType_6_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXFunctionTypeRefRule());
              	        }
                     		set(
                     			current, 
                     			"returnType",
                      		lv_returnType_6_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:246:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:247:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:248:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference529);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference539); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:255:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:258:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:259:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:259:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:259:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:259:2: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:260:1: ( ruleQualifiedName )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:260:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:261:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference587);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==16) && (synpred2_InternalXtype())) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,16,FOLLOW_16_in_ruleJvmParameterizedTypeReference608); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:279:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:280:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:280:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:281:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference630);
                    lv_arguments_2_0=ruleJvmArgumentTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"arguments",
                              		lv_arguments_2_0, 
                              		"JvmArgumentTypeReference");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:297:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==13) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:297:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference643); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:301:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:302:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:302:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:303:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference664);
                    	    lv_arguments_4_0=ruleJvmArgumentTypeReference();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getJvmParameterizedTypeReferenceRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"arguments",
                    	              		lv_arguments_4_0, 
                    	              		"JvmArgumentTypeReference");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,17,FOLLOW_17_in_ruleJvmParameterizedTypeReference678); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3());
                          
                    }

                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:331:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:332:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:333:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference716);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference726); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:340:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:343:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:344:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:344:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||LA8_0==12||LA8_0==15) ) {
                alt8=1;
            }
            else if ( (LA8_0==18) ) {
                alt8=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 8, 0, input);

                throw nvae;
            }
            switch (alt8) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:345:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference773);
                    this_JvmTypeReference_0=ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmTypeReference_0; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:355:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference800);
                    this_JvmWildcardTypeReference_1=ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {
                       
                              current = this_JvmWildcardTypeReference_1; 
                              afterParserOrEnumRuleCall();
                          
                    }

                    }
                    break;

            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:371:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:372:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:373:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference835);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference845); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:380:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:383:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:384:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:384:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:384:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:384:2: ()
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:385:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,18,FOLLOW_18_in_ruleJvmWildcardTypeReference891); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt9=3;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            else if ( (LA9_0==21) ) {
                alt9=2;
            }
            switch (alt9) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:395:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:395:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:396:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference913);
                    lv_constraints_2_0=ruleJvmUpperBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_2_0, 
                              		"JvmUpperBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:413:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:413:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:414:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:414:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:415:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference940);
                    lv_constraints_3_0=ruleJvmLowerBound();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getJvmWildcardTypeReferenceRule());
                      	        }
                             		add(
                             			current, 
                             			"constraints",
                              		lv_constraints_3_0, 
                              		"JvmLowerBound");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:439:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:440:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:441:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound978);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound988); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:448:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:451:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:452:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:452:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:452:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_19_in_ruleJvmUpperBound1025); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:456:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:457:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:457:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:458:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1046);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:482:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:483:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:484:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1082);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1092); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:491:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:494:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:495:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:495:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:495:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,20,FOLLOW_20_in_ruleJvmUpperBoundAnded1129); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:499:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:500:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:500:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:501:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1150);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmUpperBoundAndedRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:525:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:526:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:527:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1186);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound1196); if (state.failed) return current;

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
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:534:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:537:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:538:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:538:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:538:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,21,FOLLOW_21_in_ruleJvmLowerBound1233); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:542:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:543:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:543:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:544:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1254);
            lv_typeReference_1_0=ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getJvmLowerBoundRule());
              	        }
                     		set(
                     			current, 
                     			"typeReference",
                      		lv_typeReference_1_0, 
                      		"JvmTypeReference");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:570:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:571:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:572:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1293);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1304); if (state.failed) return current;

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
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:579:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:582:28: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:583:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:583:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:584:5: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1351);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:594:1: (kw= '.' this_ValidID_2= ruleValidID )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==22) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:595:2: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,22,FOLLOW_22_in_ruleQualifiedName1370); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1392);
            	    this_ValidID_2=ruleValidID();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      		current.merge(this_ValidID_2);
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              afterParserOrEnumRuleCall();
            	          
            	    }

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleValidID"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:621:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:622:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:623:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1442);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1453); if (state.failed) return current;

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
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:630:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:633:28: (this_ID_0= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:634:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1492); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                  newLeafNode(this_ID_0, grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
                  
            }

            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportDeclaration1"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:651:1: entryRuleXImportDeclaration1 returns [EObject current=null] : iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF ;
    public final EObject entryRuleXImportDeclaration1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration1 = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:652:2: (iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:653:2: iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclaration1Rule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration11538);
            iv_ruleXImportDeclaration1=ruleXImportDeclaration1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration1; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration11548); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportDeclaration1"


    // $ANTLR start "ruleXImportDeclaration1"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:660:1: ruleXImportDeclaration1 returns [EObject current=null] : (otherlv_0= 'import' ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleXImportDeclaration1() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token lv_importURI_8_0=null;
        Token otherlv_9=null;
        Token lv_importURI_10_0=null;
        Token otherlv_11=null;
        Token lv_alias_12_0=null;
        EObject lv_importItems_2_0 = null;

        EObject lv_importItems_4_0 = null;

        EObject lv_importItems_6_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:663:28: ( (otherlv_0= 'import' ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:664:1: (otherlv_0= 'import' ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:664:1: (otherlv_0= 'import' ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:664:3: otherlv_0= 'import' ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration11585); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXImportDeclaration1Access().getImportKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:1: ( ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) ) | (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) ) )
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==RULE_ID||LA13_0==24) ) {
                alt13=1;
            }
            else if ( (LA13_0==26) ) {
                alt13=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 13, 0, input);

                throw nvae;
            }
            switch (alt13) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:2: ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:2: ( ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:3: ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) ) otherlv_7= 'from' ( (lv_importURI_8_0= RULE_STRING ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:3: ( (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' ) | ( (lv_importItems_6_0= ruleXImportItem ) ) )
                    int alt12=2;
                    int LA12_0 = input.LA(1);

                    if ( (LA12_0==24) ) {
                        alt12=1;
                    }
                    else if ( (LA12_0==RULE_ID) ) {
                        alt12=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 12, 0, input);

                        throw nvae;
                    }
                    switch (alt12) {
                        case 1 :
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:4: (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:4: (otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}' )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:668:6: otherlv_1= '{' ( (lv_importItems_2_0= ruleXImportItem ) ) (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )* otherlv_5= '}'
                            {
                            otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration11601); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_1, grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_1_0_0_0_0());
                                  
                            }
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:672:1: ( (lv_importItems_2_0= ruleXImportItem ) )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:673:1: (lv_importItems_2_0= ruleXImportItem )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:673:1: (lv_importItems_2_0= ruleXImportItem )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:674:3: lv_importItems_2_0= ruleXImportItem
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11622);
                            lv_importItems_2_0=ruleXImportItem();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
                              	        }
                                     		add(
                                     			current, 
                                     			"importItems",
                                      		lv_importItems_2_0, 
                                      		"XImportItem");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }

                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:690:2: (otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) ) )*
                            loop11:
                            do {
                                int alt11=2;
                                int LA11_0 = input.LA(1);

                                if ( (LA11_0==13) ) {
                                    alt11=1;
                                }


                                switch (alt11) {
                            	case 1 :
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:690:4: otherlv_3= ',' ( (lv_importItems_4_0= ruleXImportItem ) )
                            	    {
                            	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXImportDeclaration11635); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	          	newLeafNode(otherlv_3, grammarAccess.getXImportDeclaration1Access().getCommaKeyword_1_0_0_0_2_0());
                            	          
                            	    }
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:694:1: ( (lv_importItems_4_0= ruleXImportItem ) )
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:695:1: (lv_importItems_4_0= ruleXImportItem )
                            	    {
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:695:1: (lv_importItems_4_0= ruleXImportItem )
                            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:696:3: lv_importItems_4_0= ruleXImportItem
                            	    {
                            	    if ( state.backtracking==0 ) {
                            	       
                            	      	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_2_1_0()); 
                            	      	    
                            	    }
                            	    pushFollow(FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11656);
                            	    lv_importItems_4_0=ruleXImportItem();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      	        if (current==null) {
                            	      	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
                            	      	        }
                            	             		add(
                            	             			current, 
                            	             			"importItems",
                            	              		lv_importItems_4_0, 
                            	              		"XImportItem");
                            	      	        afterParserOrEnumRuleCall();
                            	      	    
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop11;
                                }
                            } while (true);

                            otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration11670); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_5, grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_1_0_0_0_3());
                                  
                            }

                            }


                            }
                            break;
                        case 2 :
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:717:6: ( (lv_importItems_6_0= ruleXImportItem ) )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:717:6: ( (lv_importItems_6_0= ruleXImportItem ) )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:718:1: (lv_importItems_6_0= ruleXImportItem )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:718:1: (lv_importItems_6_0= ruleXImportItem )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:719:3: lv_importItems_6_0= ruleXImportItem
                            {
                            if ( state.backtracking==0 ) {
                               
                              	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_1_0()); 
                              	    
                            }
                            pushFollow(FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11698);
                            lv_importItems_6_0=ruleXImportItem();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
                              	        }
                                     		add(
                                     			current, 
                                     			"importItems",
                                      		lv_importItems_6_0, 
                                      		"XImportItem");
                              	        afterParserOrEnumRuleCall();
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }

                    otherlv_7=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration11711); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_7, grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_0_1());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:739:1: ( (lv_importURI_8_0= RULE_STRING ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:740:1: (lv_importURI_8_0= RULE_STRING )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:740:1: (lv_importURI_8_0= RULE_STRING )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:741:3: lv_importURI_8_0= RULE_STRING
                    {
                    lv_importURI_8_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXImportDeclaration11728); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_importURI_8_0, grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_0_2_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclaration1Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"importURI",
                              		lv_importURI_8_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:758:6: (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:758:6: (otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:758:8: otherlv_9= 'from' ( (lv_importURI_10_0= RULE_STRING ) ) otherlv_11= 'as' ( (lv_alias_12_0= RULE_ID ) )
                    {
                    otherlv_9=(Token)match(input,26,FOLLOW_26_in_ruleXImportDeclaration11753); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_9, grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_1_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:762:1: ( (lv_importURI_10_0= RULE_STRING ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:763:1: (lv_importURI_10_0= RULE_STRING )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:763:1: (lv_importURI_10_0= RULE_STRING )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:764:3: lv_importURI_10_0= RULE_STRING
                    {
                    lv_importURI_10_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXImportDeclaration11770); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_importURI_10_0, grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclaration1Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"importURI",
                              		lv_importURI_10_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_11=(Token)match(input,27,FOLLOW_27_in_ruleXImportDeclaration11787); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_11, grammarAccess.getXImportDeclaration1Access().getAsKeyword_1_1_2());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:784:1: ( (lv_alias_12_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:785:1: (lv_alias_12_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:785:1: (lv_alias_12_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:786:3: lv_alias_12_0= RULE_ID
                    {
                    lv_alias_12_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXImportDeclaration11804); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alias_12_0, grammarAccess.getXImportDeclaration1Access().getAliasIDTerminalRuleCall_1_1_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclaration1Rule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"alias",
                              		lv_alias_12_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXImportDeclaration1"


    // $ANTLR start "entryRuleXImportItem"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:810:1: entryRuleXImportItem returns [EObject current=null] : iv_ruleXImportItem= ruleXImportItem EOF ;
    public final EObject entryRuleXImportItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportItem = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:811:2: (iv_ruleXImportItem= ruleXImportItem EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:812:2: iv_ruleXImportItem= ruleXImportItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_entryRuleXImportItem1847);
            iv_ruleXImportItem=ruleXImportItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportItem1857); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXImportItem"


    // $ANTLR start "ruleXImportItem"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:819:1: ruleXImportItem returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleXImportItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:822:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:2: ()
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:824:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXImportItemAccess().getXImportItemAction_0(),
                          current);
                  
            }

            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:829:2: ( (otherlv_1= RULE_ID ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:830:1: (otherlv_1= RULE_ID )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:830:1: (otherlv_1= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:831:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXImportItemRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXImportItem1911); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:842:2: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==27) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:842:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,27,FOLLOW_27_in_ruleXImportItem1924); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXImportItemAccess().getAsKeyword_2_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:846:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:847:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:847:1: (lv_alias_3_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:848:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXImportItem1941); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alias_3_0, grammarAccess.getXImportItemAccess().getAliasIDTerminalRuleCall_2_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportItemRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"alias",
                              		lv_alias_3_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXImportItem"


    // $ANTLR start "entryRuleXExportDeclaration"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:874:1: entryRuleXExportDeclaration returns [EObject current=null] : iv_ruleXExportDeclaration= ruleXExportDeclaration EOF ;
    public final EObject entryRuleXExportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExportDeclaration = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:875:2: (iv_ruleXExportDeclaration= ruleXExportDeclaration EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:876:2: iv_ruleXExportDeclaration= ruleXExportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration1986);
            iv_ruleXExportDeclaration=ruleXExportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportDeclaration1996); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExportDeclaration"


    // $ANTLR start "ruleXExportDeclaration"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:883:1: ruleXExportDeclaration returns [EObject current=null] : (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) ) ;
    public final EObject ruleXExportDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token lv_importURI_7_0=null;
        Token otherlv_8=null;
        Token lv_importURI_9_0=null;
        Token otherlv_10=null;
        Token lv_alias_11_0=null;
        EObject lv_exportItems_2_0 = null;

        EObject lv_exportItems_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:886:28: ( (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:887:1: (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:887:1: (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:887:3: otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,28,FOLLOW_28_in_ruleXExportDeclaration2033); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXExportDeclarationAccess().getExportKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:891:1: ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) )
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==24) ) {
                alt17=1;
            }
            else if ( (LA17_0==26) ) {
                alt17=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 17, 0, input);

                throw nvae;
            }
            switch (alt17) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:891:2: (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:891:2: (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:891:4: otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )?
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleXExportDeclaration2047); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:895:1: ( (lv_exportItems_2_0= ruleXExportItem ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:896:1: (lv_exportItems_2_0= ruleXExportItem )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:896:1: (lv_exportItems_2_0= ruleXExportItem )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:897:3: lv_exportItems_2_0= ruleXExportItem
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExportItem_in_ruleXExportDeclaration2068);
                    lv_exportItems_2_0=ruleXExportItem();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXExportDeclarationRule());
                      	        }
                             		add(
                             			current, 
                             			"exportItems",
                              		lv_exportItems_2_0, 
                              		"XExportItem");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:913:2: (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==13) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:913:4: otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXExportDeclaration2081); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:917:1: ( (lv_exportItems_4_0= ruleXExportItem ) )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:918:1: (lv_exportItems_4_0= ruleXExportItem )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:918:1: (lv_exportItems_4_0= ruleXExportItem )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:919:3: lv_exportItems_4_0= ruleXExportItem
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExportItem_in_ruleXExportDeclaration2102);
                    	    lv_exportItems_4_0=ruleXExportItem();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXExportDeclarationRule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"exportItems",
                    	              		lv_exportItems_4_0, 
                    	              		"XExportItem");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,25,FOLLOW_25_in_ruleXExportDeclaration2116); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:939:1: (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )?
                    int alt16=2;
                    int LA16_0 = input.LA(1);

                    if ( (LA16_0==26) ) {
                        alt16=1;
                    }
                    switch (alt16) {
                        case 1 :
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:939:3: otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,26,FOLLOW_26_in_ruleXExportDeclaration2129); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0());
                                  
                            }
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:943:1: ( (lv_importURI_7_0= RULE_STRING ) )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:944:1: (lv_importURI_7_0= RULE_STRING )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:944:1: (lv_importURI_7_0= RULE_STRING )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:945:3: lv_importURI_7_0= RULE_STRING
                            {
                            lv_importURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXExportDeclaration2146); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              			newLeafNode(lv_importURI_7_0, grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0_4_1_0()); 
                              		
                            }
                            if ( state.backtracking==0 ) {

                              	        if (current==null) {
                              	            current = createModelElement(grammarAccess.getXExportDeclarationRule());
                              	        }
                                     		setWithLastConsumed(
                                     			current, 
                                     			"importURI",
                                      		lv_importURI_7_0, 
                                      		"STRING");
                              	    
                            }

                            }


                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:962:6: (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:962:6: (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:962:8: otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,26,FOLLOW_26_in_ruleXExportDeclaration2173); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:966:1: ( (lv_importURI_9_0= RULE_STRING ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:967:1: (lv_importURI_9_0= RULE_STRING )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:967:1: (lv_importURI_9_0= RULE_STRING )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:968:3: lv_importURI_9_0= RULE_STRING
                    {
                    lv_importURI_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXExportDeclaration2190); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_importURI_9_0, grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXExportDeclarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"importURI",
                              		lv_importURI_9_0, 
                              		"STRING");
                      	    
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,27,FOLLOW_27_in_ruleXExportDeclaration2207); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:988:1: ( (lv_alias_11_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:989:1: (lv_alias_11_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:989:1: (lv_alias_11_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:990:3: lv_alias_11_0= RULE_ID
                    {
                    lv_alias_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportDeclaration2224); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alias_11_0, grammarAccess.getXExportDeclarationAccess().getAliasIDTerminalRuleCall_1_1_3_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXExportDeclarationRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"alias",
                              		lv_alias_11_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExportDeclaration"


    // $ANTLR start "entryRuleXExportItem"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1014:1: entryRuleXExportItem returns [EObject current=null] : iv_ruleXExportItem= ruleXExportItem EOF ;
    public final EObject entryRuleXExportItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExportItem = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1015:2: (iv_ruleXExportItem= ruleXExportItem EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1016:2: iv_ruleXExportItem= ruleXExportItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_entryRuleXExportItem2267);
            iv_ruleXExportItem=ruleXExportItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExportItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportItem2277); if (state.failed) return current;

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
    // $ANTLR end "entryRuleXExportItem"


    // $ANTLR start "ruleXExportItem"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1023:1: ruleXExportItem returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleXExportItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_alias_2_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1026:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1027:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1027:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1027:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1027:2: ( (otherlv_0= RULE_ID ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1028:1: (otherlv_0= RULE_ID )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1028:1: (otherlv_0= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1029:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXExportItemRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportItem2322); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1040:2: (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1040:4: otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,27,FOLLOW_27_in_ruleXExportItem2335); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXExportItemAccess().getAsKeyword_1_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1044:1: ( (lv_alias_2_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1045:1: (lv_alias_2_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1045:1: (lv_alias_2_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:1046:3: lv_alias_2_0= RULE_ID
                    {
                    lv_alias_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportItem2352); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			newLeafNode(lv_alias_2_0, grammarAccess.getXExportItemAccess().getAliasIDTerminalRuleCall_1_1_0()); 
                      		
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXExportItemRule());
                      	        }
                             		setWithLastConsumed(
                             			current, 
                             			"alias",
                              		lv_alias_2_0, 
                              		"ID");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }


            }


            }

            if ( state.backtracking==0 ) {
               leaveRule(); 
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
    // $ANTLR end "ruleXExportItem"

    // $ANTLR start synpred1_InternalXtype
    public final void synpred1_InternalXtype_fragment() throws RecognitionException {   
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:2: ( ( () ruleArrayBrackets ) )
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:3: ( () ruleArrayBrackets )
        {
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:3: ( () ruleArrayBrackets )
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:4: () ruleArrayBrackets
        {
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:89:4: ()
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:90:1: 
        {
        }

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype148);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalXtype

    // $ANTLR start synpred2_InternalXtype
    public final void synpred2_InternalXtype_fragment() throws RecognitionException {   
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:4: ( '<' )
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:274:6: '<'
        {
        match(input,16,FOLLOW_16_in_synpred2_InternalXtype600); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalXtype

    // Delegated rules

    public final boolean synpred2_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalXtype() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalXtype_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference75 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference85 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference133 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference169 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_ruleJvmTypeReference200 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets236 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets247 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets285 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets298 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef338 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_ruleXFunctionTypeRef386 = new BitSet(new long[]{0x000000000000D010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef408 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleXFunctionTypeRef421 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef442 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleXFunctionTypeRef458 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_15_in_ruleXFunctionTypeRef472 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleXFunctionTypeRef493 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference529 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference539 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference587 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_16_in_ruleJvmParameterizedTypeReference608 = new BitSet(new long[]{0x0000000000049010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference630 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference643 = new BitSet(new long[]{0x0000000000049010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference664 = new BitSet(new long[]{0x0000000000022000L});
    public static final BitSet FOLLOW_17_in_ruleJvmParameterizedTypeReference678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference716 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference726 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference773 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference800 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference835 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference845 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJvmWildcardTypeReference891 = new BitSet(new long[]{0x0000000000280002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound978 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_ruleJvmUpperBound1025 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound1046 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded1082 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded1092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleJvmUpperBoundAnded1129 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded1150 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound1186 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound1196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_ruleJvmLowerBound1233 = new BitSet(new long[]{0x0000000000009010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1293 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1304 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1351 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_22_in_ruleQualifiedName1370 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1392 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1442 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1492 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration11538 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration11548 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration11585 = new BitSet(new long[]{0x0000000005000010L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration11601 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11622 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_13_in_ruleXImportDeclaration11635 = new BitSet(new long[]{0x0000000001000010L});
    public static final BitSet FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11656 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration11670 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11698 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration11711 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXImportDeclaration11728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXImportDeclaration11753 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXImportDeclaration11770 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleXImportDeclaration11787 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXImportDeclaration11804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_entryRuleXImportItem1847 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportItem1857 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXImportItem1911 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXImportItem1924 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXImportItem1941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration1986 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportDeclaration1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_ruleXExportDeclaration2033 = new BitSet(new long[]{0x0000000005000000L});
    public static final BitSet FOLLOW_24_in_ruleXExportDeclaration2047 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXExportItem_in_ruleXExportDeclaration2068 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_13_in_ruleXExportDeclaration2081 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXExportItem_in_ruleXExportDeclaration2102 = new BitSet(new long[]{0x0000000002002000L});
    public static final BitSet FOLLOW_25_in_ruleXExportDeclaration2116 = new BitSet(new long[]{0x0000000004000002L});
    public static final BitSet FOLLOW_26_in_ruleXExportDeclaration2129 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXExportDeclaration2146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXExportDeclaration2173 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXExportDeclaration2190 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_27_in_ruleXExportDeclaration2207 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportDeclaration2224 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_entryRuleXExportItem2267 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportItem2277 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportItem2322 = new BitSet(new long[]{0x0000000008000002L});
    public static final BitSet FOLLOW_27_in_ruleXExportItem2335 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportItem2352 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_synpred2_InternalXtype600 = new BitSet(new long[]{0x0000000000000002L});

}