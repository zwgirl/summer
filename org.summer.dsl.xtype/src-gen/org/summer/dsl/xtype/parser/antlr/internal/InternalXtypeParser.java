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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'<'", "','", "'>'", "'?'", "'extends'", "'&'", "'super'", "'.'", "'import'", "'{'", "'*'", "'}'", "'as'", "'from'", "'export'"
    };
    public static final int RULE_ID=4;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:76:1: ruleJvmTypeReference returns [EObject current=null] : (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) ;
    public final EObject ruleJvmTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmParameterizedTypeReference_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:79:28: ( (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:80:1: (this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )* )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:81:5: this_JvmParameterizedTypeReference_0= ruleJvmParameterizedTypeReference ( ( ( () ruleArrayBrackets ) )=> ( () ruleArrayBrackets ) )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference132);
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
            	                  grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_0_0(),
            	                  current);
            	          
            	    }

            	    }

            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_1_0_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference168);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:112:1: entryRuleArrayBrackets returns [String current=null] : iv_ruleArrayBrackets= ruleArrayBrackets EOF ;
    public final String entryRuleArrayBrackets() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleArrayBrackets = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:113:2: (iv_ruleArrayBrackets= ruleArrayBrackets EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:114:2: iv_ruleArrayBrackets= ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets207);
            iv_ruleArrayBrackets=ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleArrayBrackets.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets218); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:121:1: ruleArrayBrackets returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= '[' kw= ']' ) ;
    public final AntlrDatatypeRuleToken ruleArrayBrackets() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:124:28: ( (kw= '[' kw= ']' ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:125:1: (kw= '[' kw= ']' )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:125:1: (kw= '[' kw= ']' )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:126:2: kw= '[' kw= ']'
            {
            kw=(Token)match(input,10,FOLLOW_10_in_ruleArrayBrackets256); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                      current.merge(kw);
                      newLeafNode(kw, grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
                  
            }
            kw=(Token)match(input,11,FOLLOW_11_in_ruleArrayBrackets269); if (state.failed) return current;
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


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:145:1: entryRuleJvmParameterizedTypeReference returns [EObject current=null] : iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF ;
    public final EObject entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmParameterizedTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:146:2: (iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:147:2: iv_ruleJvmParameterizedTypeReference= ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference309);
            iv_ruleJvmParameterizedTypeReference=ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmParameterizedTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference319); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:154:1: ruleJvmParameterizedTypeReference returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleJvmParameterizedTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_arguments_2_0 = null;

        EObject lv_arguments_4_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:157:28: ( ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:158:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:158:1: ( ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:158:2: ( ( ruleQualifiedName ) ) ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:158:2: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:159:1: ( ruleQualifiedName )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:159:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:160:3: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getJvmParameterizedTypeReferenceRule());
              	        }
                      
            }
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference367);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:2: ( ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>' )?
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==12) && (synpred2_InternalXtype())) {
                alt3=1;
            }
            switch (alt3) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:3: ( ( '<' )=>otherlv_1= '<' ) ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) ) (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )* otherlv_5= '>'
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:3: ( ( '<' )=>otherlv_1= '<' )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:4: ( '<' )=>otherlv_1= '<'
                    {
                    otherlv_1=(Token)match(input,12,FOLLOW_12_in_ruleJvmParameterizedTypeReference388); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0());
                          
                    }

                    }

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:178:2: ( (lv_arguments_2_0= ruleJvmArgumentTypeReference ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:179:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:179:1: (lv_arguments_2_0= ruleJvmArgumentTypeReference )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:180:3: lv_arguments_2_0= ruleJvmArgumentTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference410);
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

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:196:2: (otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) ) )*
                    loop2:
                    do {
                        int alt2=2;
                        int LA2_0 = input.LA(1);

                        if ( (LA2_0==13) ) {
                            alt2=1;
                        }


                        switch (alt2) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:196:4: otherlv_3= ',' ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleJvmParameterizedTypeReference423); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0());
                    	          
                    	    }
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:200:1: ( (lv_arguments_4_0= ruleJvmArgumentTypeReference ) )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:201:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:201:1: (lv_arguments_4_0= ruleJvmArgumentTypeReference )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:202:3: lv_arguments_4_0= ruleJvmArgumentTypeReference
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference444);
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
                    	    break loop2;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,14,FOLLOW_14_in_ruleJvmParameterizedTypeReference458); if (state.failed) return current;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:230:1: entryRuleJvmArgumentTypeReference returns [EObject current=null] : iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF ;
    public final EObject entryRuleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmArgumentTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:231:2: (iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:232:2: iv_ruleJvmArgumentTypeReference= ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference496);
            iv_ruleJvmArgumentTypeReference=ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmArgumentTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference506); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:239:1: ruleJvmArgumentTypeReference returns [EObject current=null] : (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) ;
    public final EObject ruleJvmArgumentTypeReference() throws RecognitionException {
        EObject current = null;

        EObject this_JvmTypeReference_0 = null;

        EObject this_JvmWildcardTypeReference_1 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:242:28: ( (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:243:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:243:1: (this_JvmTypeReference_0= ruleJvmTypeReference | this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==15) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:244:5: this_JvmTypeReference_0= ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference553);
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
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:254:5: this_JvmWildcardTypeReference_1= ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       
                              newCompositeNode(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                          
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference580);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:270:1: entryRuleJvmWildcardTypeReference returns [EObject current=null] : iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF ;
    public final EObject entryRuleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmWildcardTypeReference = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:271:2: (iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:272:2: iv_ruleJvmWildcardTypeReference= ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference615);
            iv_ruleJvmWildcardTypeReference=ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmWildcardTypeReference; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference625); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:279:1: ruleJvmWildcardTypeReference returns [EObject current=null] : ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) ;
    public final EObject ruleJvmWildcardTypeReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_constraints_2_0 = null;

        EObject lv_constraints_3_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:282:28: ( ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:283:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:283:1: ( () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:283:2: () otherlv_1= '?' ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:283:2: ()
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:284:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,15,FOLLOW_15_in_ruleJvmWildcardTypeReference671); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:293:1: ( ( (lv_constraints_2_0= ruleJvmUpperBound ) ) | ( (lv_constraints_3_0= ruleJvmLowerBound ) ) )?
            int alt5=3;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            else if ( (LA5_0==18) ) {
                alt5=2;
            }
            switch (alt5) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:293:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:293:2: ( (lv_constraints_2_0= ruleJvmUpperBound ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:294:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:294:1: (lv_constraints_2_0= ruleJvmUpperBound )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:295:3: lv_constraints_2_0= ruleJvmUpperBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference693);
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
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:312:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:312:6: ( (lv_constraints_3_0= ruleJvmLowerBound ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:313:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:313:1: (lv_constraints_3_0= ruleJvmLowerBound )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:314:3: lv_constraints_3_0= ruleJvmLowerBound
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference720);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:338:1: entryRuleJvmUpperBound returns [EObject current=null] : iv_ruleJvmUpperBound= ruleJvmUpperBound EOF ;
    public final EObject entryRuleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBound = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:339:2: (iv_ruleJvmUpperBound= ruleJvmUpperBound EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:340:2: iv_ruleJvmUpperBound= ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound758);
            iv_ruleJvmUpperBound=ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound768); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:347:1: ruleJvmUpperBound returns [EObject current=null] : (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:350:28: ( (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:351:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:351:1: (otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:351:3: otherlv_0= 'extends' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_16_in_ruleJvmUpperBound805); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:355:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:356:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:356:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:357:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound826);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:381:1: entryRuleJvmUpperBoundAnded returns [EObject current=null] : iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF ;
    public final EObject entryRuleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmUpperBoundAnded = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:382:2: (iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:383:2: iv_ruleJvmUpperBoundAnded= ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded862);
            iv_ruleJvmUpperBoundAnded=ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmUpperBoundAnded; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded872); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:390:1: ruleJvmUpperBoundAnded returns [EObject current=null] : (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmUpperBoundAnded() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:393:28: ( (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:1: (otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:394:3: otherlv_0= '&' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,17,FOLLOW_17_in_ruleJvmUpperBoundAnded909); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:398:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:399:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:399:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:400:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded930);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:424:1: entryRuleJvmLowerBound returns [EObject current=null] : iv_ruleJvmLowerBound= ruleJvmLowerBound EOF ;
    public final EObject entryRuleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleJvmLowerBound = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:425:2: (iv_ruleJvmLowerBound= ruleJvmLowerBound EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:426:2: iv_ruleJvmLowerBound= ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound966);
            iv_ruleJvmLowerBound=ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleJvmLowerBound; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound976); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:433:1: ruleJvmLowerBound returns [EObject current=null] : (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) ;
    public final EObject ruleJvmLowerBound() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        EObject lv_typeReference_1_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:436:28: ( (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:437:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:437:1: (otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:437:3: otherlv_0= 'super' ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            {
            otherlv_0=(Token)match(input,18,FOLLOW_18_in_ruleJvmLowerBound1013); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:441:1: ( (lv_typeReference_1_0= ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:442:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:442:1: (lv_typeReference_1_0= ruleJvmTypeReference )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:443:3: lv_typeReference_1_0= ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1034);
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:469:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:470:2: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:471:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1073);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName1084); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:478:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;
        AntlrDatatypeRuleToken this_ValidID_0 = null;

        AntlrDatatypeRuleToken this_ValidID_2 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:481:28: ( (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:482:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:482:1: (this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )* )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:483:5: this_ValidID_0= ruleValidID (kw= '.' this_ValidID_2= ruleValidID )*
            {
            if ( state.backtracking==0 ) {
               
                      newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
                  
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1131);
            this_ValidID_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current.merge(this_ValidID_0);
                  
            }
            if ( state.backtracking==0 ) {
               
                      afterParserOrEnumRuleCall();
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:493:1: (kw= '.' this_ValidID_2= ruleValidID )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==19) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:494:2: kw= '.' this_ValidID_2= ruleValidID
            	    {
            	    kw=(Token)match(input,19,FOLLOW_19_in_ruleQualifiedName1150); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	              current.merge(kw);
            	              newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            	          
            	    }
            	    if ( state.backtracking==0 ) {
            	       
            	              newCompositeNode(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            	          
            	    }
            	    pushFollow(FOLLOW_ruleValidID_in_ruleQualifiedName1172);
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
            	    break loop6;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:520:1: entryRuleValidID returns [String current=null] : iv_ruleValidID= ruleValidID EOF ;
    public final String entryRuleValidID() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleValidID = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:521:2: (iv_ruleValidID= ruleValidID EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:522:2: iv_ruleValidID= ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID1222);
            iv_ruleValidID=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleValidID.getText(); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID1233); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:529:1: ruleValidID returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : this_ID_0= RULE_ID ;
    public final AntlrDatatypeRuleToken ruleValidID() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:532:28: (this_ID_0= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:533:5: this_ID_0= RULE_ID
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID1272); if (state.failed) return current;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:550:1: entryRuleXImportDeclaration1 returns [EObject current=null] : iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF ;
    public final EObject entryRuleXImportDeclaration1() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportDeclaration1 = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:551:2: (iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:552:2: iv_ruleXImportDeclaration1= ruleXImportDeclaration1 EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportDeclaration1Rule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration11318);
            iv_ruleXImportDeclaration1=ruleXImportDeclaration1();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportDeclaration1; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration11328); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:559:1: ruleXImportDeclaration1 returns [EObject current=null] : ( () otherlv_1= 'import' otherlv_2= '{' ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) ) otherlv_7= '}' otherlv_8= 'as' ( (lv_name_9_0= ruleValidID ) ) otherlv_10= 'from' ( (lv_importURI_11_0= RULE_STRING ) ) ) ;
    public final EObject ruleXImportDeclaration1() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token lv_wildcard_6_0=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token lv_importURI_11_0=null;
        EObject lv_importItems_3_0 = null;

        EObject lv_importItems_5_0 = null;

        AntlrDatatypeRuleToken lv_name_9_0 = null;


         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:562:28: ( ( () otherlv_1= 'import' otherlv_2= '{' ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) ) otherlv_7= '}' otherlv_8= 'as' ( (lv_name_9_0= ruleValidID ) ) otherlv_10= 'from' ( (lv_importURI_11_0= RULE_STRING ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:563:1: ( () otherlv_1= 'import' otherlv_2= '{' ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) ) otherlv_7= '}' otherlv_8= 'as' ( (lv_name_9_0= ruleValidID ) ) otherlv_10= 'from' ( (lv_importURI_11_0= RULE_STRING ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:563:1: ( () otherlv_1= 'import' otherlv_2= '{' ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) ) otherlv_7= '}' otherlv_8= 'as' ( (lv_name_9_0= ruleValidID ) ) otherlv_10= 'from' ( (lv_importURI_11_0= RULE_STRING ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:563:2: () otherlv_1= 'import' otherlv_2= '{' ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) ) otherlv_7= '}' otherlv_8= 'as' ( (lv_name_9_0= ruleValidID ) ) otherlv_10= 'from' ( (lv_importURI_11_0= RULE_STRING ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:563:2: ()
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:564:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXImportDeclaration1Access().getXImportDeclaration1Action_0(),
                          current);
                  
            }

            }

            otherlv_1=(Token)match(input,20,FOLLOW_20_in_ruleXImportDeclaration11374); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_1, grammarAccess.getXImportDeclaration1Access().getImportKeyword_1());
                  
            }
            otherlv_2=(Token)match(input,21,FOLLOW_21_in_ruleXImportDeclaration11386); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_2, grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_2());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:577:1: ( ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* ) | ( (lv_wildcard_6_0= '*' ) ) )
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID) ) {
                alt8=1;
            }
            else if ( (LA8_0==22) ) {
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
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:577:2: ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:577:2: ( ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )* )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:577:3: ( (lv_importItems_3_0= ruleXImportItem ) ) (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )*
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:577:3: ( (lv_importItems_3_0= ruleXImportItem ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:578:1: (lv_importItems_3_0= ruleXImportItem )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:578:1: (lv_importItems_3_0= ruleXImportItem )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:579:3: lv_importItems_3_0= ruleXImportItem
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_0_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11409);
                    lv_importItems_3_0=ruleXImportItem();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
                      	        }
                             		add(
                             			current, 
                             			"importItems",
                              		lv_importItems_3_0, 
                              		"XImportItem");
                      	        afterParserOrEnumRuleCall();
                      	    
                    }

                    }


                    }

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:595:2: (otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) ) )*
                    loop7:
                    do {
                        int alt7=2;
                        int LA7_0 = input.LA(1);

                        if ( (LA7_0==13) ) {
                            alt7=1;
                        }


                        switch (alt7) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:595:4: otherlv_4= ',' ( (lv_importItems_5_0= ruleXImportItem ) )
                    	    {
                    	    otherlv_4=(Token)match(input,13,FOLLOW_13_in_ruleXImportDeclaration11422); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_4, grammarAccess.getXImportDeclaration1Access().getCommaKeyword_3_0_1_0());
                    	          
                    	    }
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:599:1: ( (lv_importItems_5_0= ruleXImportItem ) )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:600:1: (lv_importItems_5_0= ruleXImportItem )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:600:1: (lv_importItems_5_0= ruleXImportItem )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:601:3: lv_importItems_5_0= ruleXImportItem
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_1_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11443);
                    	    lv_importItems_5_0=ruleXImportItem();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      	        if (current==null) {
                    	      	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
                    	      	        }
                    	             		add(
                    	             			current, 
                    	             			"importItems",
                    	              		lv_importItems_5_0, 
                    	              		"XImportItem");
                    	      	        afterParserOrEnumRuleCall();
                    	      	    
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop7;
                        }
                    } while (true);


                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:618:6: ( (lv_wildcard_6_0= '*' ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:618:6: ( (lv_wildcard_6_0= '*' ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:619:1: (lv_wildcard_6_0= '*' )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:619:1: (lv_wildcard_6_0= '*' )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:620:3: lv_wildcard_6_0= '*'
                    {
                    lv_wildcard_6_0=(Token)match(input,22,FOLLOW_22_in_ruleXImportDeclaration11470); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                              newLeafNode(lv_wildcard_6_0, grammarAccess.getXImportDeclaration1Access().getWildcardAsteriskKeyword_3_1_0());
                          
                    }
                    if ( state.backtracking==0 ) {

                      	        if (current==null) {
                      	            current = createModelElement(grammarAccess.getXImportDeclaration1Rule());
                      	        }
                             		setWithLastConsumed(current, "wildcard", true, "*");
                      	    
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,23,FOLLOW_23_in_ruleXImportDeclaration11496); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_7, grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_4());
                  
            }
            otherlv_8=(Token)match(input,24,FOLLOW_24_in_ruleXImportDeclaration11508); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_8, grammarAccess.getXImportDeclaration1Access().getAsKeyword_5());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:641:1: ( (lv_name_9_0= ruleValidID ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:642:1: (lv_name_9_0= ruleValidID )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:642:1: (lv_name_9_0= ruleValidID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:643:3: lv_name_9_0= ruleValidID
            {
            if ( state.backtracking==0 ) {
               
              	        newCompositeNode(grammarAccess.getXImportDeclaration1Access().getNameValidIDParserRuleCall_6_0()); 
              	    
            }
            pushFollow(FOLLOW_ruleValidID_in_ruleXImportDeclaration11529);
            lv_name_9_0=ruleValidID();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElementForParent(grammarAccess.getXImportDeclaration1Rule());
              	        }
                     		set(
                     			current, 
                     			"name",
                      		lv_name_9_0, 
                      		"ValidID");
              	        afterParserOrEnumRuleCall();
              	    
            }

            }


            }

            otherlv_10=(Token)match(input,25,FOLLOW_25_in_ruleXImportDeclaration11541); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_10, grammarAccess.getXImportDeclaration1Access().getFromKeyword_7());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:663:1: ( (lv_importURI_11_0= RULE_STRING ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:664:1: (lv_importURI_11_0= RULE_STRING )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:664:1: (lv_importURI_11_0= RULE_STRING )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:665:3: lv_importURI_11_0= RULE_STRING
            {
            lv_importURI_11_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXImportDeclaration11558); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(lv_importURI_11_0, grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_8_0()); 
              		
            }
            if ( state.backtracking==0 ) {

              	        if (current==null) {
              	            current = createModelElement(grammarAccess.getXImportDeclaration1Rule());
              	        }
                     		setWithLastConsumed(
                     			current, 
                     			"importURI",
                      		lv_importURI_11_0, 
                      		"STRING");
              	    
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
    // $ANTLR end "ruleXImportDeclaration1"


    // $ANTLR start "entryRuleXImportItem"
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:689:1: entryRuleXImportItem returns [EObject current=null] : iv_ruleXImportItem= ruleXImportItem EOF ;
    public final EObject entryRuleXImportItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXImportItem = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:690:2: (iv_ruleXImportItem= ruleXImportItem EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:691:2: iv_ruleXImportItem= ruleXImportItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXImportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_entryRuleXImportItem1599);
            iv_ruleXImportItem=ruleXImportItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXImportItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportItem1609); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:698:1: ruleXImportItem returns [EObject current=null] : ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) ;
    public final EObject ruleXImportItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token lv_alias_3_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:701:28: ( ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:702:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:702:1: ( () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:702:2: () ( (otherlv_1= RULE_ID ) ) (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:702:2: ()
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:703:5: 
            {
            if ( state.backtracking==0 ) {

                      current = forceCreateModelElement(
                          grammarAccess.getXImportItemAccess().getXImportItemAction_0(),
                          current);
                  
            }

            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:708:2: ( (otherlv_1= RULE_ID ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:709:1: (otherlv_1= RULE_ID )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:709:1: (otherlv_1= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:710:3: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXImportItemRule());
              	        }
                      
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXImportItem1663); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_1, grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
              	
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:721:2: (otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==24) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:721:4: otherlv_2= 'as' ( (lv_alias_3_0= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,24,FOLLOW_24_in_ruleXImportItem1676); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_2, grammarAccess.getXImportItemAccess().getAsKeyword_2_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:725:1: ( (lv_alias_3_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:726:1: (lv_alias_3_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:726:1: (lv_alias_3_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:727:3: lv_alias_3_0= RULE_ID
                    {
                    lv_alias_3_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXImportItem1693); if (state.failed) return current;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:753:1: entryRuleXExportDeclaration returns [EObject current=null] : iv_ruleXExportDeclaration= ruleXExportDeclaration EOF ;
    public final EObject entryRuleXExportDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExportDeclaration = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:754:2: (iv_ruleXExportDeclaration= ruleXExportDeclaration EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:755:2: iv_ruleXExportDeclaration= ruleXExportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration1738);
            iv_ruleXExportDeclaration=ruleXExportDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExportDeclaration; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportDeclaration1748); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:762:1: ruleXExportDeclaration returns [EObject current=null] : (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) ) ;
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
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:765:28: ( (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:766:1: (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:766:1: (otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:766:3: otherlv_0= 'export' ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) )
            {
            otherlv_0=(Token)match(input,26,FOLLOW_26_in_ruleXExportDeclaration1785); if (state.failed) return current;
            if ( state.backtracking==0 ) {

                  	newLeafNode(otherlv_0, grammarAccess.getXExportDeclarationAccess().getExportKeyword_0());
                  
            }
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:770:1: ( (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? ) | (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) ) )
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==21) ) {
                alt12=1;
            }
            else if ( (LA12_0==25) ) {
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
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:770:2: (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:770:2: (otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )? )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:770:4: otherlv_1= '{' ( (lv_exportItems_2_0= ruleXExportItem ) ) (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )* otherlv_5= '}' (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )?
                    {
                    otherlv_1=(Token)match(input,21,FOLLOW_21_in_ruleXExportDeclaration1799); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:774:1: ( (lv_exportItems_2_0= ruleXExportItem ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:775:1: (lv_exportItems_2_0= ruleXExportItem )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:775:1: (lv_exportItems_2_0= ruleXExportItem )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:776:3: lv_exportItems_2_0= ruleXExportItem
                    {
                    if ( state.backtracking==0 ) {
                       
                      	        newCompositeNode(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
                      	    
                    }
                    pushFollow(FOLLOW_ruleXExportItem_in_ruleXExportDeclaration1820);
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

                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:792:2: (otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) ) )*
                    loop10:
                    do {
                        int alt10=2;
                        int LA10_0 = input.LA(1);

                        if ( (LA10_0==13) ) {
                            alt10=1;
                        }


                        switch (alt10) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:792:4: otherlv_3= ',' ( (lv_exportItems_4_0= ruleXExportItem ) )
                    	    {
                    	    otherlv_3=(Token)match(input,13,FOLLOW_13_in_ruleXExportDeclaration1833); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	          	newLeafNode(otherlv_3, grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0());
                    	          
                    	    }
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:796:1: ( (lv_exportItems_4_0= ruleXExportItem ) )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:797:1: (lv_exportItems_4_0= ruleXExportItem )
                    	    {
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:797:1: (lv_exportItems_4_0= ruleXExportItem )
                    	    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:798:3: lv_exportItems_4_0= ruleXExportItem
                    	    {
                    	    if ( state.backtracking==0 ) {
                    	       
                    	      	        newCompositeNode(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
                    	      	    
                    	    }
                    	    pushFollow(FOLLOW_ruleXExportItem_in_ruleXExportDeclaration1854);
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
                    	    break loop10;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,23,FOLLOW_23_in_ruleXExportDeclaration1868); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_5, grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:818:1: (otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) ) )?
                    int alt11=2;
                    int LA11_0 = input.LA(1);

                    if ( (LA11_0==25) ) {
                        alt11=1;
                    }
                    switch (alt11) {
                        case 1 :
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:818:3: otherlv_6= 'from' ( (lv_importURI_7_0= RULE_STRING ) )
                            {
                            otherlv_6=(Token)match(input,25,FOLLOW_25_in_ruleXExportDeclaration1881); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                                  	newLeafNode(otherlv_6, grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0());
                                  
                            }
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:822:1: ( (lv_importURI_7_0= RULE_STRING ) )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:1: (lv_importURI_7_0= RULE_STRING )
                            {
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:823:1: (lv_importURI_7_0= RULE_STRING )
                            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:824:3: lv_importURI_7_0= RULE_STRING
                            {
                            lv_importURI_7_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXExportDeclaration1898); if (state.failed) return current;
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
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:841:6: (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:841:6: (otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:841:8: otherlv_8= 'from' ( (lv_importURI_9_0= RULE_STRING ) ) otherlv_10= 'as' ( (lv_alias_11_0= RULE_ID ) )
                    {
                    otherlv_8=(Token)match(input,25,FOLLOW_25_in_ruleXExportDeclaration1925); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_8, grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:845:1: ( (lv_importURI_9_0= RULE_STRING ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:846:1: (lv_importURI_9_0= RULE_STRING )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:846:1: (lv_importURI_9_0= RULE_STRING )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:847:3: lv_importURI_9_0= RULE_STRING
                    {
                    lv_importURI_9_0=(Token)match(input,RULE_STRING,FOLLOW_RULE_STRING_in_ruleXExportDeclaration1942); if (state.failed) return current;
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

                    otherlv_10=(Token)match(input,24,FOLLOW_24_in_ruleXExportDeclaration1959); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_10, grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:867:1: ( (lv_alias_11_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:868:1: (lv_alias_11_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:868:1: (lv_alias_11_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:869:3: lv_alias_11_0= RULE_ID
                    {
                    lv_alias_11_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportDeclaration1976); if (state.failed) return current;
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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:893:1: entryRuleXExportItem returns [EObject current=null] : iv_ruleXExportItem= ruleXExportItem EOF ;
    public final EObject entryRuleXExportItem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleXExportItem = null;


        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:894:2: (iv_ruleXExportItem= ruleXExportItem EOF )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:895:2: iv_ruleXExportItem= ruleXExportItem EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getXExportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_entryRuleXExportItem2019);
            iv_ruleXExportItem=ruleXExportItem();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleXExportItem; 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportItem2029); if (state.failed) return current;

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
    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:902:1: ruleXExportItem returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? ) ;
    public final EObject ruleXExportItem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_alias_2_0=null;

         enterRule(); 
            
        try {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:905:28: ( ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:906:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:906:1: ( ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )? )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:906:2: ( (otherlv_0= RULE_ID ) ) (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )?
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:906:2: ( (otherlv_0= RULE_ID ) )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:907:1: (otherlv_0= RULE_ID )
            {
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:907:1: (otherlv_0= RULE_ID )
            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:908:3: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              			if (current==null) {
              	            current = createModelElement(grammarAccess.getXExportItemRule());
              	        }
                      
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportItem2074); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		newLeafNode(otherlv_0, grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
              	
            }

            }


            }

            // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:919:2: (otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:919:4: otherlv_1= 'as' ( (lv_alias_2_0= RULE_ID ) )
                    {
                    otherlv_1=(Token)match(input,24,FOLLOW_24_in_ruleXExportItem2087); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                          	newLeafNode(otherlv_1, grammarAccess.getXExportItemAccess().getAsKeyword_1_0());
                          
                    }
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:923:1: ( (lv_alias_2_0= RULE_ID ) )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:924:1: (lv_alias_2_0= RULE_ID )
                    {
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:924:1: (lv_alias_2_0= RULE_ID )
                    // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:925:3: lv_alias_2_0= RULE_ID
                    {
                    lv_alias_2_0=(Token)match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleXExportItem2104); if (state.failed) return current;
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

        pushFollow(FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype147);
        ruleArrayBrackets();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalXtype

    // $ANTLR start synpred2_InternalXtype
    public final void synpred2_InternalXtype_fragment() throws RecognitionException {   
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:4: ( '<' )
        // ../org.summer.dsl.xtype/src-gen/org/summer/dsl/xtype/parser/antlr/internal/InternalXtype.g:173:6: '<'
        {
        match(input,12,FOLLOW_12_in_synpred2_InternalXtype380); if (state.failed) return ;

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
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_ruleJvmTypeReference132 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_ruleJvmTypeReference168 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets207 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_ruleArrayBrackets256 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_11_in_ruleArrayBrackets269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference309 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_ruleJvmParameterizedTypeReference367 = new BitSet(new long[]{0x0000000000001002L});
    public static final BitSet FOLLOW_12_in_ruleJvmParameterizedTypeReference388 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference410 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_13_in_ruleJvmParameterizedTypeReference423 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_ruleJvmParameterizedTypeReference444 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_14_in_ruleJvmParameterizedTypeReference458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference496 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference506 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmArgumentTypeReference553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_ruleJvmArgumentTypeReference580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference615 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_ruleJvmWildcardTypeReference671 = new BitSet(new long[]{0x0000000000050002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_ruleJvmWildcardTypeReference693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_ruleJvmWildcardTypeReference720 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound758 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound768 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_ruleJvmUpperBound805 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBound826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded862 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded872 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_ruleJvmUpperBoundAnded909 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmUpperBoundAnded930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound966 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_ruleJvmLowerBound1013 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_ruleJvmLowerBound1034 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName1073 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName1084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1131 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_19_in_ruleQualifiedName1150 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleQualifiedName1172 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID1222 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID1233 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID1272 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration11318 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration11328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_ruleXImportDeclaration11374 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_21_in_ruleXImportDeclaration11386 = new BitSet(new long[]{0x0000000000400010L});
    public static final BitSet FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11409 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleXImportDeclaration11422 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXImportItem_in_ruleXImportDeclaration11443 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_22_in_ruleXImportDeclaration11470 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_23_in_ruleXImportDeclaration11496 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXImportDeclaration11508 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleValidID_in_ruleXImportDeclaration11529 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_25_in_ruleXImportDeclaration11541 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXImportDeclaration11558 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_entryRuleXImportItem1599 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportItem1609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXImportItem1663 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleXImportItem1676 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXImportItem1693 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration1738 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportDeclaration1748 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_ruleXExportDeclaration1785 = new BitSet(new long[]{0x0000000002200000L});
    public static final BitSet FOLLOW_21_in_ruleXExportDeclaration1799 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXExportItem_in_ruleXExportDeclaration1820 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_13_in_ruleXExportDeclaration1833 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_ruleXExportItem_in_ruleXExportDeclaration1854 = new BitSet(new long[]{0x0000000000802000L});
    public static final BitSet FOLLOW_23_in_ruleXExportDeclaration1868 = new BitSet(new long[]{0x0000000002000002L});
    public static final BitSet FOLLOW_25_in_ruleXExportDeclaration1881 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXExportDeclaration1898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_ruleXExportDeclaration1925 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_RULE_STRING_in_ruleXExportDeclaration1942 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_24_in_ruleXExportDeclaration1959 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportDeclaration1976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_entryRuleXExportItem2019 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportItem2029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportItem2074 = new BitSet(new long[]{0x0000000001000002L});
    public static final BitSet FOLLOW_24_in_ruleXExportItem2087 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleXExportItem2104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_synpred1_InternalXtype147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_synpred2_InternalXtype380 = new BitSet(new long[]{0x0000000000000002L});

}