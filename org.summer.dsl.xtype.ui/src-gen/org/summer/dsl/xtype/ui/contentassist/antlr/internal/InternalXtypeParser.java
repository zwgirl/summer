package org.summer.dsl.xtype.ui.contentassist.antlr.internal; 

import java.io.InputStream;
import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.AbstractInternalContentAssistParser;
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.DFA;
import org.summer.dsl.xtype.services.XtypeGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalXtypeParser extends AbstractInternalContentAssistParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'<'", "'>'", "','", "'?'", "'extends'", "'&'", "'super'", "'.'", "'import'", "'{'", "'}'", "'as'", "'from'", "'export'", "'*'"
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
    public String getGrammarFileName() { return "../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g"; }


     
     	private XtypeGrammarAccess grammarAccess;
     	
        public void setGrammarAccess(XtypeGrammarAccess grammarAccess) {
        	this.grammarAccess = grammarAccess;
        }
        
        @Override
        protected Grammar getGrammar() {
        	return grammarAccess.getGrammar();
        }
        
        @Override
        protected String getValueForTokenName(String tokenName) {
        	return tokenName;
        }




    // $ANTLR start "entryRuleJvmTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:61:1: entryRuleJvmTypeReference : ruleJvmTypeReference EOF ;
    public final void entryRuleJvmTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:62:1: ( ruleJvmTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:63:1: ruleJvmTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference67);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmTypeReference74); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmTypeReference"


    // $ANTLR start "ruleJvmTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:70:1: ruleJvmTypeReference : ( ( rule__JvmTypeReference__Group__0 ) ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:74:2: ( ( ( rule__JvmTypeReference__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:75:1: ( ( rule__JvmTypeReference__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:75:1: ( ( rule__JvmTypeReference__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:76:1: ( rule__JvmTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:77:1: ( rule__JvmTypeReference__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:77:2: rule__JvmTypeReference__Group__0
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group__0_in_ruleJvmTypeReference100);
            rule__JvmTypeReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmTypeReference"


    // $ANTLR start "entryRuleArrayBrackets"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:89:1: entryRuleArrayBrackets : ruleArrayBrackets EOF ;
    public final void entryRuleArrayBrackets() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:90:1: ( ruleArrayBrackets EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:91:1: ruleArrayBrackets EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsRule()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets127);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleArrayBrackets134); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleArrayBrackets"


    // $ANTLR start "ruleArrayBrackets"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:98:1: ruleArrayBrackets : ( ( rule__ArrayBrackets__Group__0 ) ) ;
    public final void ruleArrayBrackets() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:102:2: ( ( ( rule__ArrayBrackets__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:103:1: ( ( rule__ArrayBrackets__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:103:1: ( ( rule__ArrayBrackets__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:104:1: ( rule__ArrayBrackets__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:105:1: ( rule__ArrayBrackets__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:105:2: rule__ArrayBrackets__Group__0
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__0_in_ruleArrayBrackets160);
            rule__ArrayBrackets__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleArrayBrackets"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:117:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:118:1: ( ruleJvmParameterizedTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:119:1: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference187);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference194); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmParameterizedTypeReference"


    // $ANTLR start "ruleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:126:1: ruleJvmParameterizedTypeReference : ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:130:2: ( ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:131:1: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:131:1: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:132:1: ( rule__JvmParameterizedTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:133:1: ( rule__JvmParameterizedTypeReference__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:133:2: rule__JvmParameterizedTypeReference__Group__0
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__0_in_ruleJvmParameterizedTypeReference220);
            rule__JvmParameterizedTypeReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmParameterizedTypeReference"


    // $ANTLR start "entryRuleJvmArgumentTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:145:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:146:1: ( ruleJvmArgumentTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:147:1: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference247);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference254); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmArgumentTypeReference"


    // $ANTLR start "ruleJvmArgumentTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:154:1: ruleJvmArgumentTypeReference : ( ( rule__JvmArgumentTypeReference__Alternatives ) ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:158:2: ( ( ( rule__JvmArgumentTypeReference__Alternatives ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:159:1: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:159:1: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:160:1: ( rule__JvmArgumentTypeReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:161:1: ( rule__JvmArgumentTypeReference__Alternatives )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:161:2: rule__JvmArgumentTypeReference__Alternatives
            {
            pushFollow(FOLLOW_rule__JvmArgumentTypeReference__Alternatives_in_ruleJvmArgumentTypeReference280);
            rule__JvmArgumentTypeReference__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmArgumentTypeReference"


    // $ANTLR start "entryRuleJvmWildcardTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:173:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:174:1: ( ruleJvmWildcardTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:175:1: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference307);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference314); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmWildcardTypeReference"


    // $ANTLR start "ruleJvmWildcardTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:182:1: ruleJvmWildcardTypeReference : ( ( rule__JvmWildcardTypeReference__Group__0 ) ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:186:2: ( ( ( rule__JvmWildcardTypeReference__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:187:1: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:187:1: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:188:1: ( rule__JvmWildcardTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:189:1: ( rule__JvmWildcardTypeReference__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:189:2: rule__JvmWildcardTypeReference__Group__0
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__0_in_ruleJvmWildcardTypeReference340);
            rule__JvmWildcardTypeReference__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmWildcardTypeReference"


    // $ANTLR start "entryRuleJvmUpperBound"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:201:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:202:1: ( ruleJvmUpperBound EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:203:1: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound367);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound374); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmUpperBound"


    // $ANTLR start "ruleJvmUpperBound"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:210:1: ruleJvmUpperBound : ( ( rule__JvmUpperBound__Group__0 ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:214:2: ( ( ( rule__JvmUpperBound__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:215:1: ( ( rule__JvmUpperBound__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:215:1: ( ( rule__JvmUpperBound__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:216:1: ( rule__JvmUpperBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:217:1: ( rule__JvmUpperBound__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:217:2: rule__JvmUpperBound__Group__0
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__0_in_ruleJvmUpperBound400);
            rule__JvmUpperBound__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmUpperBound"


    // $ANTLR start "entryRuleJvmUpperBoundAnded"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:229:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:230:1: ( ruleJvmUpperBoundAnded EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:231:1: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded427);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded434); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmUpperBoundAnded"


    // $ANTLR start "ruleJvmUpperBoundAnded"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:238:1: ruleJvmUpperBoundAnded : ( ( rule__JvmUpperBoundAnded__Group__0 ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:242:2: ( ( ( rule__JvmUpperBoundAnded__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:243:1: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:243:1: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:244:1: ( rule__JvmUpperBoundAnded__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:245:1: ( rule__JvmUpperBoundAnded__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:245:2: rule__JvmUpperBoundAnded__Group__0
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__0_in_ruleJvmUpperBoundAnded460);
            rule__JvmUpperBoundAnded__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmUpperBoundAnded"


    // $ANTLR start "entryRuleJvmLowerBound"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:257:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:258:1: ( ruleJvmLowerBound EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:259:1: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound487);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound494); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleJvmLowerBound"


    // $ANTLR start "ruleJvmLowerBound"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:266:1: ruleJvmLowerBound : ( ( rule__JvmLowerBound__Group__0 ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:270:2: ( ( ( rule__JvmLowerBound__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:271:1: ( ( rule__JvmLowerBound__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:271:1: ( ( rule__JvmLowerBound__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:272:1: ( rule__JvmLowerBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:273:1: ( rule__JvmLowerBound__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:273:2: rule__JvmLowerBound__Group__0
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__0_in_ruleJvmLowerBound520);
            rule__JvmLowerBound__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleJvmLowerBound"


    // $ANTLR start "entryRuleQualifiedName"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:287:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:288:1: ( ruleQualifiedName EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:289:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName549);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName556); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleQualifiedName"


    // $ANTLR start "ruleQualifiedName"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:296:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:300:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:301:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:301:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:302:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:303:1: ( rule__QualifiedName__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:303:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName582);
            rule__QualifiedName__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleQualifiedName"


    // $ANTLR start "entryRuleValidID"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:317:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:318:1: ( ruleValidID EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:319:1: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID611);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID618); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleValidID"


    // $ANTLR start "ruleValidID"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:326:1: ruleValidID : ( RULE_ID ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:330:2: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:331:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:331:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:332:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID644); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleValidID"


    // $ANTLR start "entryRuleXImportDeclaration"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:347:1: entryRuleXImportDeclaration : ruleXImportDeclaration EOF ;
    public final void entryRuleXImportDeclaration() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:348:1: ( ruleXImportDeclaration EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:349:1: ruleXImportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration672);
            ruleXImportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration679); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXImportDeclaration"


    // $ANTLR start "ruleXImportDeclaration"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:356:1: ruleXImportDeclaration : ( ( rule__XImportDeclaration__Group__0 ) ) ;
    public final void ruleXImportDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:360:2: ( ( ( rule__XImportDeclaration__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:361:1: ( ( rule__XImportDeclaration__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:361:1: ( ( rule__XImportDeclaration__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:362:1: ( rule__XImportDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:363:1: ( rule__XImportDeclaration__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:363:2: rule__XImportDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__0_in_ruleXImportDeclaration705);
            rule__XImportDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXImportDeclaration"


    // $ANTLR start "entryRuleXImportItem"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:375:1: entryRuleXImportItem : ruleXImportItem EOF ;
    public final void entryRuleXImportItem() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:376:1: ( ruleXImportItem EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:377:1: ruleXImportItem EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_entryRuleXImportItem732);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportItem739); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXImportItem"


    // $ANTLR start "ruleXImportItem"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:384:1: ruleXImportItem : ( ( rule__XImportItem__Group__0 ) ) ;
    public final void ruleXImportItem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:388:2: ( ( ( rule__XImportItem__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:389:1: ( ( rule__XImportItem__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:389:1: ( ( rule__XImportItem__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:390:1: ( rule__XImportItem__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:391:1: ( rule__XImportItem__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:391:2: rule__XImportItem__Group__0
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__0_in_ruleXImportItem765);
            rule__XImportItem__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXImportItem"


    // $ANTLR start "entryRuleXExportDeclaration"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:405:1: entryRuleXExportDeclaration : ruleXExportDeclaration EOF ;
    public final void entryRuleXExportDeclaration() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:406:1: ( ruleXExportDeclaration EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:407:1: ruleXExportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration794);
            ruleXExportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportDeclaration801); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXExportDeclaration"


    // $ANTLR start "ruleXExportDeclaration"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:414:1: ruleXExportDeclaration : ( ( rule__XExportDeclaration__Group__0 ) ) ;
    public final void ruleXExportDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:418:2: ( ( ( rule__XExportDeclaration__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:419:1: ( ( rule__XExportDeclaration__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:419:1: ( ( rule__XExportDeclaration__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:420:1: ( rule__XExportDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:421:1: ( rule__XExportDeclaration__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:421:2: rule__XExportDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__0_in_ruleXExportDeclaration827);
            rule__XExportDeclaration__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXExportDeclaration"


    // $ANTLR start "entryRuleXExportItem"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:433:1: entryRuleXExportItem : ruleXExportItem EOF ;
    public final void entryRuleXExportItem() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:434:1: ( ruleXExportItem EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:435:1: ruleXExportItem EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_entryRuleXExportItem854);
            ruleXExportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportItem861); if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {
        }
        return ;
    }
    // $ANTLR end "entryRuleXExportItem"


    // $ANTLR start "ruleXExportItem"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:442:1: ruleXExportItem : ( ( rule__XExportItem__Group__0 ) ) ;
    public final void ruleXExportItem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:446:2: ( ( ( rule__XExportItem__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:447:1: ( ( rule__XExportItem__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:447:1: ( ( rule__XExportItem__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:448:1: ( rule__XExportItem__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:449:1: ( rule__XExportItem__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:449:2: rule__XExportItem__Group__0
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__0_in_ruleXExportItem887);
            rule__XExportItem__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getGroup()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "ruleXExportItem"


    // $ANTLR start "rule__JvmArgumentTypeReference__Alternatives"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:461:1: rule__JvmArgumentTypeReference__Alternatives : ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) );
    public final void rule__JvmArgumentTypeReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:465:1: ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( (LA1_0==15) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:466:1: ( ruleJvmTypeReference )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:466:1: ( ruleJvmTypeReference )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:467:1: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmArgumentTypeReference__Alternatives923);
                    ruleJvmTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:472:6: ( ruleJvmWildcardTypeReference )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:472:6: ( ruleJvmWildcardTypeReference )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:473:1: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_rule__JvmArgumentTypeReference__Alternatives940);
                    ruleJvmWildcardTypeReference();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmArgumentTypeReference__Alternatives"


    // $ANTLR start "rule__JvmWildcardTypeReference__Alternatives_2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:483:1: rule__JvmWildcardTypeReference__Alternatives_2 : ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) ) | ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) ) );
    public final void rule__JvmWildcardTypeReference__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:487:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) ) | ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==16) ) {
                alt2=1;
            }
            else if ( (LA2_0==18) ) {
                alt2=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }
            switch (alt2) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:488:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:488:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:489:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:490:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:490:2: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_in_rule__JvmWildcardTypeReference__Alternatives_2972);
                    rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:494:6: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:494:6: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:495:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:496:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:496:2: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_in_rule__JvmWildcardTypeReference__Alternatives_2990);
                    rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Alternatives_2"


    // $ANTLR start "rule__XImportDeclaration__Alternatives_3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:505:1: rule__XImportDeclaration__Alternatives_3 : ( ( ( rule__XImportDeclaration__Group_3_0__0 ) ) | ( ( rule__XImportDeclaration__WildcardAssignment_3_1 ) ) );
    public final void rule__XImportDeclaration__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:509:1: ( ( ( rule__XImportDeclaration__Group_3_0__0 ) ) | ( ( rule__XImportDeclaration__WildcardAssignment_3_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==RULE_ID) ) {
                alt3=1;
            }
            else if ( (LA3_0==26) ) {
                alt3=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 3, 0, input);

                throw nvae;
            }
            switch (alt3) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:510:1: ( ( rule__XImportDeclaration__Group_3_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:510:1: ( ( rule__XImportDeclaration__Group_3_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:511:1: ( rule__XImportDeclaration__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getGroup_3_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:512:1: ( rule__XImportDeclaration__Group_3_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:512:2: rule__XImportDeclaration__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0__0_in_rule__XImportDeclaration__Alternatives_31023);
                    rule__XImportDeclaration__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getGroup_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:516:6: ( ( rule__XImportDeclaration__WildcardAssignment_3_1 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:516:6: ( ( rule__XImportDeclaration__WildcardAssignment_3_1 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:517:1: ( rule__XImportDeclaration__WildcardAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_3_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:518:1: ( rule__XImportDeclaration__WildcardAssignment_3_1 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:518:2: rule__XImportDeclaration__WildcardAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration__WildcardAssignment_3_1_in_rule__XImportDeclaration__Alternatives_31041);
                    rule__XImportDeclaration__WildcardAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclarationAccess().getWildcardAssignment_3_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Alternatives_3"


    // $ANTLR start "rule__XExportDeclaration__Alternatives_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:527:1: rule__XExportDeclaration__Alternatives_1 : ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) );
    public final void rule__XExportDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:531:1: ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==21) ) {
                alt4=1;
            }
            else if ( (LA4_0==24) ) {
                alt4=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 4, 0, input);

                throw nvae;
            }
            switch (alt4) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:532:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:532:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:533:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:534:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:534:2: rule__XExportDeclaration__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11074);
                    rule__XExportDeclaration__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXExportDeclarationAccess().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:538:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:538:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:539:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:540:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:540:2: rule__XExportDeclaration__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11092);
                    rule__XExportDeclaration__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXExportDeclarationAccess().getGroup_1_1()); 
                    }

                    }


                    }
                    break;

            }
        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Alternatives_1"


    // $ANTLR start "rule__JvmTypeReference__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:551:1: rule__JvmTypeReference__Group__0 : rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1 ;
    public final void rule__JvmTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:555:1: ( rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:556:2: rule__JvmTypeReference__Group__0__Impl rule__JvmTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group__0__Impl_in_rule__JvmTypeReference__Group__01123);
            rule__JvmTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group__1_in_rule__JvmTypeReference__Group__01126);
            rule__JvmTypeReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__0"


    // $ANTLR start "rule__JvmTypeReference__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:563:1: rule__JvmTypeReference__Group__0__Impl : ( ruleJvmParameterizedTypeReference ) ;
    public final void rule__JvmTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:567:1: ( ( ruleJvmParameterizedTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:1: ( ruleJvmParameterizedTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:1: ( ruleJvmParameterizedTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:569:1: ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group__0__Impl1153);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:580:1: rule__JvmTypeReference__Group__1 : rule__JvmTypeReference__Group__1__Impl ;
    public final void rule__JvmTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:584:1: ( rule__JvmTypeReference__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:585:2: rule__JvmTypeReference__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group__1__Impl_in_rule__JvmTypeReference__Group__11182);
            rule__JvmTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__1"


    // $ANTLR start "rule__JvmTypeReference__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:591:1: rule__JvmTypeReference__Group__1__Impl : ( ( rule__JvmTypeReference__Group_1__0 )* ) ;
    public final void rule__JvmTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:595:1: ( ( ( rule__JvmTypeReference__Group_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:596:1: ( ( rule__JvmTypeReference__Group_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:596:1: ( ( rule__JvmTypeReference__Group_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:597:1: ( rule__JvmTypeReference__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:598:1: ( rule__JvmTypeReference__Group_1__0 )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==10) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:598:2: rule__JvmTypeReference__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmTypeReference__Group_1__0_in_rule__JvmTypeReference__Group__1__Impl1209);
            	    rule__JvmTypeReference__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop5;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group__1__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:612:1: rule__JvmTypeReference__Group_1__0 : rule__JvmTypeReference__Group_1__0__Impl ;
    public final void rule__JvmTypeReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:616:1: ( rule__JvmTypeReference__Group_1__0__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:617:2: rule__JvmTypeReference__Group_1__0__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_1__0__Impl_in_rule__JvmTypeReference__Group_1__01244);
            rule__JvmTypeReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1__0"


    // $ANTLR start "rule__JvmTypeReference__Group_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:623:1: rule__JvmTypeReference__Group_1__0__Impl : ( ( rule__JvmTypeReference__Group_1_0__0 ) ) ;
    public final void rule__JvmTypeReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:627:1: ( ( ( rule__JvmTypeReference__Group_1_0__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:628:1: ( ( rule__JvmTypeReference__Group_1_0__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:628:1: ( ( rule__JvmTypeReference__Group_1_0__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:629:1: ( rule__JvmTypeReference__Group_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:630:1: ( rule__JvmTypeReference__Group_1_0__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:630:2: rule__JvmTypeReference__Group_1_0__0
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_1_0__0_in_rule__JvmTypeReference__Group_1__0__Impl1271);
            rule__JvmTypeReference__Group_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_1_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:642:1: rule__JvmTypeReference__Group_1_0__0 : rule__JvmTypeReference__Group_1_0__0__Impl rule__JvmTypeReference__Group_1_0__1 ;
    public final void rule__JvmTypeReference__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:646:1: ( rule__JvmTypeReference__Group_1_0__0__Impl rule__JvmTypeReference__Group_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:647:2: rule__JvmTypeReference__Group_1_0__0__Impl rule__JvmTypeReference__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_1_0__0__Impl_in_rule__JvmTypeReference__Group_1_0__01303);
            rule__JvmTypeReference__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_1_0__1_in_rule__JvmTypeReference__Group_1_0__01306);
            rule__JvmTypeReference__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1_0__0"


    // $ANTLR start "rule__JvmTypeReference__Group_1_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:654:1: rule__JvmTypeReference__Group_1_0__0__Impl : ( () ) ;
    public final void rule__JvmTypeReference__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:658:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:659:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:659:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:660:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:661:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:663:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1_0__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_1_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:673:1: rule__JvmTypeReference__Group_1_0__1 : rule__JvmTypeReference__Group_1_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:677:1: ( rule__JvmTypeReference__Group_1_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:678:2: rule__JvmTypeReference__Group_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_1_0__1__Impl_in_rule__JvmTypeReference__Group_1_0__11364);
            rule__JvmTypeReference__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1_0__1"


    // $ANTLR start "rule__JvmTypeReference__Group_1_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:684:1: rule__JvmTypeReference__Group_1_0__1__Impl : ( ruleArrayBrackets ) ;
    public final void rule__JvmTypeReference__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:688:1: ( ( ruleArrayBrackets ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:689:1: ( ruleArrayBrackets )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:689:1: ( ruleArrayBrackets )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:690:1: ruleArrayBrackets
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_1_0__1__Impl1391);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_1_0__1__Impl"


    // $ANTLR start "rule__ArrayBrackets__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:705:1: rule__ArrayBrackets__Group__0 : rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 ;
    public final void rule__ArrayBrackets__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:709:1: ( rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:710:2: rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01424);
            rule__ArrayBrackets__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01427);
            rule__ArrayBrackets__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayBrackets__Group__0"


    // $ANTLR start "rule__ArrayBrackets__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:717:1: rule__ArrayBrackets__Group__0__Impl : ( '[' ) ;
    public final void rule__ArrayBrackets__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:721:1: ( ( '[' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:722:1: ( '[' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:722:1: ( '[' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:723:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,10,FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1455); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayBrackets__Group__0__Impl"


    // $ANTLR start "rule__ArrayBrackets__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:736:1: rule__ArrayBrackets__Group__1 : rule__ArrayBrackets__Group__1__Impl ;
    public final void rule__ArrayBrackets__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:740:1: ( rule__ArrayBrackets__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:741:2: rule__ArrayBrackets__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11486);
            rule__ArrayBrackets__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayBrackets__Group__1"


    // $ANTLR start "rule__ArrayBrackets__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:747:1: rule__ArrayBrackets__Group__1__Impl : ( ']' ) ;
    public final void rule__ArrayBrackets__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:751:1: ( ( ']' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:752:1: ( ']' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:752:1: ( ']' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:753:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
            }
            match(input,11,FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1514); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__ArrayBrackets__Group__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:770:1: rule__JvmParameterizedTypeReference__Group__0 : rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 ;
    public final void rule__JvmParameterizedTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:774:1: ( rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:775:2: rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__01549);
            rule__JvmParameterizedTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__01552);
            rule__JvmParameterizedTypeReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:782:1: rule__JvmParameterizedTypeReference__Group__0__Impl : ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:786:1: ( ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:787:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:787:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:788:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:789:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:789:2: rule__JvmParameterizedTypeReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl1579);
            rule__JvmParameterizedTypeReference__TypeAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:799:1: rule__JvmParameterizedTypeReference__Group__1 : rule__JvmParameterizedTypeReference__Group__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:803:1: ( rule__JvmParameterizedTypeReference__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:804:2: rule__JvmParameterizedTypeReference__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__11609);
            rule__JvmParameterizedTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:810:1: rule__JvmParameterizedTypeReference__Group__1__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) ;
    public final void rule__JvmParameterizedTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:814:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:815:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:815:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:816:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:817:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==12) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:817:2: rule__JvmParameterizedTypeReference__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl1636);
                    rule__JvmParameterizedTypeReference__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:831:1: rule__JvmParameterizedTypeReference__Group_1__0 : rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:835:1: ( rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:836:2: rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__01671);
            rule__JvmParameterizedTypeReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__01674);
            rule__JvmParameterizedTypeReference__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:843:1: rule__JvmParameterizedTypeReference__Group_1__0__Impl : ( ( '<' ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:847:1: ( ( ( '<' ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:848:1: ( ( '<' ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:848:1: ( ( '<' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:849:1: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:850:1: ( '<' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:851:2: '<'
            {
            match(input,12,FOLLOW_12_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl1703); if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:862:1: rule__JvmParameterizedTypeReference__Group_1__1 : rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:866:1: ( rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:867:2: rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__11735);
            rule__JvmParameterizedTypeReference__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__11738);
            rule__JvmParameterizedTypeReference__Group_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:874:1: rule__JvmParameterizedTypeReference__Group_1__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:878:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:879:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:879:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:880:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:881:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:881:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl1765);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:891:1: rule__JvmParameterizedTypeReference__Group_1__2 : rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:895:1: ( rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:896:2: rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__21795);
            rule__JvmParameterizedTypeReference__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__21798);
            rule__JvmParameterizedTypeReference__Group_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:903:1: rule__JvmParameterizedTypeReference__Group_1__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:907:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:908:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:908:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:909:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:910:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==14) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:910:2: rule__JvmParameterizedTypeReference__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl1825);
            	    rule__JvmParameterizedTypeReference__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__2__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:920:1: rule__JvmParameterizedTypeReference__Group_1__3 : rule__JvmParameterizedTypeReference__Group_1__3__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:924:1: ( rule__JvmParameterizedTypeReference__Group_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:925:2: rule__JvmParameterizedTypeReference__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__31856);
            rule__JvmParameterizedTypeReference__Group_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__3"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:931:1: rule__JvmParameterizedTypeReference__Group_1__3__Impl : ( '>' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:935:1: ( ( '>' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:936:1: ( '>' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:936:1: ( '>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:937:1: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,13,FOLLOW_13_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl1884); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1__3__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:958:1: rule__JvmParameterizedTypeReference__Group_1_2__0 : rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:962:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:963:2: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__01923);
            rule__JvmParameterizedTypeReference__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__01926);
            rule__JvmParameterizedTypeReference__Group_1_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:970:1: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:974:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:975:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:975:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:976:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl1954); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__0__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:989:1: rule__JvmParameterizedTypeReference__Group_1_2__1 : rule__JvmParameterizedTypeReference__Group_1_2__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:993:1: ( rule__JvmParameterizedTypeReference__Group_1_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:994:2: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__11985);
            rule__JvmParameterizedTypeReference__Group_1_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group_1_2__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1000:1: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1004:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1005:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1005:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1006:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1007:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1007:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2012);
            rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__Group_1_2__1__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1021:1: rule__JvmWildcardTypeReference__Group__0 : rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 ;
    public final void rule__JvmWildcardTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1025:1: ( rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1026:2: rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02046);
            rule__JvmWildcardTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02049);
            rule__JvmWildcardTypeReference__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__0"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1033:1: rule__JvmWildcardTypeReference__Group__0__Impl : ( () ) ;
    public final void rule__JvmWildcardTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1037:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1038:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1038:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1039:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1040:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1042:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__0__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1052:1: rule__JvmWildcardTypeReference__Group__1 : rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 ;
    public final void rule__JvmWildcardTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1056:1: ( rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1057:2: rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12107);
            rule__JvmWildcardTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12110);
            rule__JvmWildcardTypeReference__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__1"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1064:1: rule__JvmWildcardTypeReference__Group__1__Impl : ( '?' ) ;
    public final void rule__JvmWildcardTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1068:1: ( ( '?' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1069:1: ( '?' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1069:1: ( '?' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1070:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,15,FOLLOW_15_in_rule__JvmWildcardTypeReference__Group__1__Impl2138); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__1__Impl"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1083:1: rule__JvmWildcardTypeReference__Group__2 : rule__JvmWildcardTypeReference__Group__2__Impl ;
    public final void rule__JvmWildcardTypeReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1087:1: ( rule__JvmWildcardTypeReference__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1088:2: rule__JvmWildcardTypeReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22169);
            rule__JvmWildcardTypeReference__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__2"


    // $ANTLR start "rule__JvmWildcardTypeReference__Group__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1094:1: rule__JvmWildcardTypeReference__Group__2__Impl : ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) ;
    public final void rule__JvmWildcardTypeReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1098:1: ( ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1099:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1099:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1100:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1101:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==16||LA8_0==18) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1101:2: rule__JvmWildcardTypeReference__Alternatives_2
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2196);
                    rule__JvmWildcardTypeReference__Alternatives_2();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__Group__2__Impl"


    // $ANTLR start "rule__JvmUpperBound__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1117:1: rule__JvmUpperBound__Group__0 : rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 ;
    public final void rule__JvmUpperBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1121:1: ( rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1122:2: rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__02233);
            rule__JvmUpperBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__02236);
            rule__JvmUpperBound__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBound__Group__0"


    // $ANTLR start "rule__JvmUpperBound__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1129:1: rule__JvmUpperBound__Group__0__Impl : ( 'extends' ) ;
    public final void rule__JvmUpperBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1133:1: ( ( 'extends' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1134:1: ( 'extends' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1134:1: ( 'extends' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1135:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
            }
            match(input,16,FOLLOW_16_in_rule__JvmUpperBound__Group__0__Impl2264); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBound__Group__0__Impl"


    // $ANTLR start "rule__JvmUpperBound__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1148:1: rule__JvmUpperBound__Group__1 : rule__JvmUpperBound__Group__1__Impl ;
    public final void rule__JvmUpperBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1152:1: ( rule__JvmUpperBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1153:2: rule__JvmUpperBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__12295);
            rule__JvmUpperBound__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBound__Group__1"


    // $ANTLR start "rule__JvmUpperBound__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1159:1: rule__JvmUpperBound__Group__1__Impl : ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1163:1: ( ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1164:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1164:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1165:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1166:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1166:2: rule__JvmUpperBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl2322);
            rule__JvmUpperBound__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBound__Group__1__Impl"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1180:1: rule__JvmUpperBoundAnded__Group__0 : rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 ;
    public final void rule__JvmUpperBoundAnded__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1184:1: ( rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1185:2: rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__02356);
            rule__JvmUpperBoundAnded__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__02359);
            rule__JvmUpperBoundAnded__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__0"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1192:1: rule__JvmUpperBoundAnded__Group__0__Impl : ( '&' ) ;
    public final void rule__JvmUpperBoundAnded__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1196:1: ( ( '&' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1197:1: ( '&' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1197:1: ( '&' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1198:1: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
            }
            match(input,17,FOLLOW_17_in_rule__JvmUpperBoundAnded__Group__0__Impl2387); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__0__Impl"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1211:1: rule__JvmUpperBoundAnded__Group__1 : rule__JvmUpperBoundAnded__Group__1__Impl ;
    public final void rule__JvmUpperBoundAnded__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1215:1: ( rule__JvmUpperBoundAnded__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1216:2: rule__JvmUpperBoundAnded__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__12418);
            rule__JvmUpperBoundAnded__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__1"


    // $ANTLR start "rule__JvmUpperBoundAnded__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1222:1: rule__JvmUpperBoundAnded__Group__1__Impl : ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBoundAnded__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1226:1: ( ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1227:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1227:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1228:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1229:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1229:2: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl2445);
            rule__JvmUpperBoundAnded__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBoundAnded__Group__1__Impl"


    // $ANTLR start "rule__JvmLowerBound__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1243:1: rule__JvmLowerBound__Group__0 : rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 ;
    public final void rule__JvmLowerBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1247:1: ( rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1248:2: rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__02479);
            rule__JvmLowerBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__02482);
            rule__JvmLowerBound__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmLowerBound__Group__0"


    // $ANTLR start "rule__JvmLowerBound__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1255:1: rule__JvmLowerBound__Group__0__Impl : ( 'super' ) ;
    public final void rule__JvmLowerBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1259:1: ( ( 'super' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1260:1: ( 'super' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1260:1: ( 'super' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1261:1: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
            }
            match(input,18,FOLLOW_18_in_rule__JvmLowerBound__Group__0__Impl2510); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmLowerBound__Group__0__Impl"


    // $ANTLR start "rule__JvmLowerBound__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1274:1: rule__JvmLowerBound__Group__1 : rule__JvmLowerBound__Group__1__Impl ;
    public final void rule__JvmLowerBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1278:1: ( rule__JvmLowerBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1279:2: rule__JvmLowerBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__12541);
            rule__JvmLowerBound__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmLowerBound__Group__1"


    // $ANTLR start "rule__JvmLowerBound__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1285:1: rule__JvmLowerBound__Group__1__Impl : ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmLowerBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1289:1: ( ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1290:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1290:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1291:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1292:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1292:2: rule__JvmLowerBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl2568);
            rule__JvmLowerBound__TypeReferenceAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmLowerBound__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1308:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1312:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1313:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02604);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02607);
            rule__QualifiedName__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0"


    // $ANTLR start "rule__QualifiedName__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1320:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1324:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1325:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1325:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1326:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2634);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1337:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1341:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1342:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12663);
            rule__QualifiedName__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1"


    // $ANTLR start "rule__QualifiedName__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1348:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1352:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1353:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1353:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1354:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1355:1: ( rule__QualifiedName__Group_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==19) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1355:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2690);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group__1__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1369:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1373:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1374:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02725);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02728);
            rule__QualifiedName__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0"


    // $ANTLR start "rule__QualifiedName__Group_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1381:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1385:1: ( ( '.' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1386:1: ( '.' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1386:1: ( '.' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1387:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl2756); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__0__Impl"


    // $ANTLR start "rule__QualifiedName__Group_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1400:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1404:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1405:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12787);
            rule__QualifiedName__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1"


    // $ANTLR start "rule__QualifiedName__Group_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1411:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1415:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1416:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1416:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1417:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2814);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__QualifiedName__Group_1__1__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1434:1: rule__XImportDeclaration__Group__0 : rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1 ;
    public final void rule__XImportDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1438:1: ( rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1439:2: rule__XImportDeclaration__Group__0__Impl rule__XImportDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__0__Impl_in_rule__XImportDeclaration__Group__02849);
            rule__XImportDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__1_in_rule__XImportDeclaration__Group__02852);
            rule__XImportDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__0"


    // $ANTLR start "rule__XImportDeclaration__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1446:1: rule__XImportDeclaration__Group__0__Impl : ( () ) ;
    public final void rule__XImportDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1450:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1451:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1451:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1452:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getXImportDeclarationAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1453:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1455:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getXImportDeclarationAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__0__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1465:1: rule__XImportDeclaration__Group__1 : rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2 ;
    public final void rule__XImportDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1469:1: ( rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1470:2: rule__XImportDeclaration__Group__1__Impl rule__XImportDeclaration__Group__2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__1__Impl_in_rule__XImportDeclaration__Group__12910);
            rule__XImportDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__2_in_rule__XImportDeclaration__Group__12913);
            rule__XImportDeclaration__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__1"


    // $ANTLR start "rule__XImportDeclaration__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1477:1: rule__XImportDeclaration__Group__1__Impl : ( 'import' ) ;
    public final void rule__XImportDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1481:1: ( ( 'import' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1482:1: ( 'import' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1482:1: ( 'import' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1483:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportKeyword_1()); 
            }
            match(input,20,FOLLOW_20_in_rule__XImportDeclaration__Group__1__Impl2941); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportKeyword_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__1__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1496:1: rule__XImportDeclaration__Group__2 : rule__XImportDeclaration__Group__2__Impl rule__XImportDeclaration__Group__3 ;
    public final void rule__XImportDeclaration__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1500:1: ( rule__XImportDeclaration__Group__2__Impl rule__XImportDeclaration__Group__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1501:2: rule__XImportDeclaration__Group__2__Impl rule__XImportDeclaration__Group__3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__2__Impl_in_rule__XImportDeclaration__Group__22972);
            rule__XImportDeclaration__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__3_in_rule__XImportDeclaration__Group__22975);
            rule__XImportDeclaration__Group__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__2"


    // $ANTLR start "rule__XImportDeclaration__Group__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1508:1: rule__XImportDeclaration__Group__2__Impl : ( '{' ) ;
    public final void rule__XImportDeclaration__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1512:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1513:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1513:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1514:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,21,FOLLOW_21_in_rule__XImportDeclaration__Group__2__Impl3003); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getLeftCurlyBracketKeyword_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__2__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1527:1: rule__XImportDeclaration__Group__3 : rule__XImportDeclaration__Group__3__Impl rule__XImportDeclaration__Group__4 ;
    public final void rule__XImportDeclaration__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1531:1: ( rule__XImportDeclaration__Group__3__Impl rule__XImportDeclaration__Group__4 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1532:2: rule__XImportDeclaration__Group__3__Impl rule__XImportDeclaration__Group__4
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__3__Impl_in_rule__XImportDeclaration__Group__33034);
            rule__XImportDeclaration__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__4_in_rule__XImportDeclaration__Group__33037);
            rule__XImportDeclaration__Group__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__3"


    // $ANTLR start "rule__XImportDeclaration__Group__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1539:1: rule__XImportDeclaration__Group__3__Impl : ( ( rule__XImportDeclaration__Alternatives_3 ) ) ;
    public final void rule__XImportDeclaration__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1543:1: ( ( ( rule__XImportDeclaration__Alternatives_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1544:1: ( ( rule__XImportDeclaration__Alternatives_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1544:1: ( ( rule__XImportDeclaration__Alternatives_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1545:1: ( rule__XImportDeclaration__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAlternatives_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1546:1: ( rule__XImportDeclaration__Alternatives_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1546:2: rule__XImportDeclaration__Alternatives_3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Alternatives_3_in_rule__XImportDeclaration__Group__3__Impl3064);
            rule__XImportDeclaration__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAlternatives_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__3__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__4"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1556:1: rule__XImportDeclaration__Group__4 : rule__XImportDeclaration__Group__4__Impl rule__XImportDeclaration__Group__5 ;
    public final void rule__XImportDeclaration__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1560:1: ( rule__XImportDeclaration__Group__4__Impl rule__XImportDeclaration__Group__5 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1561:2: rule__XImportDeclaration__Group__4__Impl rule__XImportDeclaration__Group__5
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__4__Impl_in_rule__XImportDeclaration__Group__43094);
            rule__XImportDeclaration__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__5_in_rule__XImportDeclaration__Group__43097);
            rule__XImportDeclaration__Group__5();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__4"


    // $ANTLR start "rule__XImportDeclaration__Group__4__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1568:1: rule__XImportDeclaration__Group__4__Impl : ( '}' ) ;
    public final void rule__XImportDeclaration__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1572:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1573:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1573:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1574:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            }
            match(input,22,FOLLOW_22_in_rule__XImportDeclaration__Group__4__Impl3125); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getRightCurlyBracketKeyword_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__4__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__5"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1587:1: rule__XImportDeclaration__Group__5 : rule__XImportDeclaration__Group__5__Impl rule__XImportDeclaration__Group__6 ;
    public final void rule__XImportDeclaration__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1591:1: ( rule__XImportDeclaration__Group__5__Impl rule__XImportDeclaration__Group__6 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1592:2: rule__XImportDeclaration__Group__5__Impl rule__XImportDeclaration__Group__6
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__5__Impl_in_rule__XImportDeclaration__Group__53156);
            rule__XImportDeclaration__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__6_in_rule__XImportDeclaration__Group__53159);
            rule__XImportDeclaration__Group__6();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__5"


    // $ANTLR start "rule__XImportDeclaration__Group__5__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1599:1: rule__XImportDeclaration__Group__5__Impl : ( 'as' ) ;
    public final void rule__XImportDeclaration__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1603:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1604:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1604:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1605:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAsKeyword_5()); 
            }
            match(input,23,FOLLOW_23_in_rule__XImportDeclaration__Group__5__Impl3187); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAsKeyword_5()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__5__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__6"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1618:1: rule__XImportDeclaration__Group__6 : rule__XImportDeclaration__Group__6__Impl rule__XImportDeclaration__Group__7 ;
    public final void rule__XImportDeclaration__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1622:1: ( rule__XImportDeclaration__Group__6__Impl rule__XImportDeclaration__Group__7 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1623:2: rule__XImportDeclaration__Group__6__Impl rule__XImportDeclaration__Group__7
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__6__Impl_in_rule__XImportDeclaration__Group__63218);
            rule__XImportDeclaration__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__7_in_rule__XImportDeclaration__Group__63221);
            rule__XImportDeclaration__Group__7();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__6"


    // $ANTLR start "rule__XImportDeclaration__Group__6__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1630:1: rule__XImportDeclaration__Group__6__Impl : ( ( rule__XImportDeclaration__AliasAssignment_6 ) ) ;
    public final void rule__XImportDeclaration__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1634:1: ( ( ( rule__XImportDeclaration__AliasAssignment_6 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1635:1: ( ( rule__XImportDeclaration__AliasAssignment_6 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1635:1: ( ( rule__XImportDeclaration__AliasAssignment_6 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1636:1: ( rule__XImportDeclaration__AliasAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAliasAssignment_6()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1637:1: ( rule__XImportDeclaration__AliasAssignment_6 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1637:2: rule__XImportDeclaration__AliasAssignment_6
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__AliasAssignment_6_in_rule__XImportDeclaration__Group__6__Impl3248);
            rule__XImportDeclaration__AliasAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAliasAssignment_6()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__6__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__7"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1647:1: rule__XImportDeclaration__Group__7 : rule__XImportDeclaration__Group__7__Impl rule__XImportDeclaration__Group__8 ;
    public final void rule__XImportDeclaration__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1651:1: ( rule__XImportDeclaration__Group__7__Impl rule__XImportDeclaration__Group__8 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1652:2: rule__XImportDeclaration__Group__7__Impl rule__XImportDeclaration__Group__8
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__7__Impl_in_rule__XImportDeclaration__Group__73278);
            rule__XImportDeclaration__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__8_in_rule__XImportDeclaration__Group__73281);
            rule__XImportDeclaration__Group__8();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__7"


    // $ANTLR start "rule__XImportDeclaration__Group__7__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1659:1: rule__XImportDeclaration__Group__7__Impl : ( 'from' ) ;
    public final void rule__XImportDeclaration__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1663:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1664:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1664:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1665:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getFromKeyword_7()); 
            }
            match(input,24,FOLLOW_24_in_rule__XImportDeclaration__Group__7__Impl3309); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getFromKeyword_7()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__7__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group__8"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1678:1: rule__XImportDeclaration__Group__8 : rule__XImportDeclaration__Group__8__Impl ;
    public final void rule__XImportDeclaration__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1682:1: ( rule__XImportDeclaration__Group__8__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1683:2: rule__XImportDeclaration__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group__8__Impl_in_rule__XImportDeclaration__Group__83340);
            rule__XImportDeclaration__Group__8__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__8"


    // $ANTLR start "rule__XImportDeclaration__Group__8__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1689:1: rule__XImportDeclaration__Group__8__Impl : ( ( rule__XImportDeclaration__ModuleAssignment_8 ) ) ;
    public final void rule__XImportDeclaration__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1693:1: ( ( ( rule__XImportDeclaration__ModuleAssignment_8 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1694:1: ( ( rule__XImportDeclaration__ModuleAssignment_8 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1694:1: ( ( rule__XImportDeclaration__ModuleAssignment_8 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1695:1: ( rule__XImportDeclaration__ModuleAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getModuleAssignment_8()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1696:1: ( rule__XImportDeclaration__ModuleAssignment_8 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1696:2: rule__XImportDeclaration__ModuleAssignment_8
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__ModuleAssignment_8_in_rule__XImportDeclaration__Group__8__Impl3367);
            rule__XImportDeclaration__ModuleAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getModuleAssignment_8()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group__8__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1724:1: rule__XImportDeclaration__Group_3_0__0 : rule__XImportDeclaration__Group_3_0__0__Impl rule__XImportDeclaration__Group_3_0__1 ;
    public final void rule__XImportDeclaration__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1728:1: ( rule__XImportDeclaration__Group_3_0__0__Impl rule__XImportDeclaration__Group_3_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1729:2: rule__XImportDeclaration__Group_3_0__0__Impl rule__XImportDeclaration__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0__0__Impl_in_rule__XImportDeclaration__Group_3_0__03415);
            rule__XImportDeclaration__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0__1_in_rule__XImportDeclaration__Group_3_0__03418);
            rule__XImportDeclaration__Group_3_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0__0"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1736:1: rule__XImportDeclaration__Group_3_0__0__Impl : ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 ) ) ;
    public final void rule__XImportDeclaration__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1740:1: ( ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1741:1: ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1741:1: ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1742:1: ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportItemsAssignment_3_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1743:1: ( rule__XImportDeclaration__ImportItemsAssignment_3_0_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1743:2: rule__XImportDeclaration__ImportItemsAssignment_3_0_0
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__ImportItemsAssignment_3_0_0_in_rule__XImportDeclaration__Group_3_0__0__Impl3445);
            rule__XImportDeclaration__ImportItemsAssignment_3_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportItemsAssignment_3_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0__0__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1753:1: rule__XImportDeclaration__Group_3_0__1 : rule__XImportDeclaration__Group_3_0__1__Impl ;
    public final void rule__XImportDeclaration__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1757:1: ( rule__XImportDeclaration__Group_3_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1758:2: rule__XImportDeclaration__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0__1__Impl_in_rule__XImportDeclaration__Group_3_0__13475);
            rule__XImportDeclaration__Group_3_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0__1"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1764:1: rule__XImportDeclaration__Group_3_0__1__Impl : ( ( rule__XImportDeclaration__Group_3_0_1__0 )* ) ;
    public final void rule__XImportDeclaration__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1768:1: ( ( ( rule__XImportDeclaration__Group_3_0_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1769:1: ( ( rule__XImportDeclaration__Group_3_0_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1769:1: ( ( rule__XImportDeclaration__Group_3_0_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1770:1: ( rule__XImportDeclaration__Group_3_0_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getGroup_3_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1771:1: ( rule__XImportDeclaration__Group_3_0_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==14) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1771:2: rule__XImportDeclaration__Group_3_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0_1__0_in_rule__XImportDeclaration__Group_3_0__1__Impl3502);
            	    rule__XImportDeclaration__Group_3_0_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getGroup_3_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0__1__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1785:1: rule__XImportDeclaration__Group_3_0_1__0 : rule__XImportDeclaration__Group_3_0_1__0__Impl rule__XImportDeclaration__Group_3_0_1__1 ;
    public final void rule__XImportDeclaration__Group_3_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1789:1: ( rule__XImportDeclaration__Group_3_0_1__0__Impl rule__XImportDeclaration__Group_3_0_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1790:2: rule__XImportDeclaration__Group_3_0_1__0__Impl rule__XImportDeclaration__Group_3_0_1__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0_1__0__Impl_in_rule__XImportDeclaration__Group_3_0_1__03537);
            rule__XImportDeclaration__Group_3_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0_1__1_in_rule__XImportDeclaration__Group_3_0_1__03540);
            rule__XImportDeclaration__Group_3_0_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0_1__0"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1797:1: rule__XImportDeclaration__Group_3_0_1__0__Impl : ( ',' ) ;
    public final void rule__XImportDeclaration__Group_3_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1801:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1802:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1802:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1803:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getCommaKeyword_3_0_1_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__XImportDeclaration__Group_3_0_1__0__Impl3568); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getCommaKeyword_3_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0_1__0__Impl"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1816:1: rule__XImportDeclaration__Group_3_0_1__1 : rule__XImportDeclaration__Group_3_0_1__1__Impl ;
    public final void rule__XImportDeclaration__Group_3_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1820:1: ( rule__XImportDeclaration__Group_3_0_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1821:2: rule__XImportDeclaration__Group_3_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__Group_3_0_1__1__Impl_in_rule__XImportDeclaration__Group_3_0_1__13599);
            rule__XImportDeclaration__Group_3_0_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0_1__1"


    // $ANTLR start "rule__XImportDeclaration__Group_3_0_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1827:1: rule__XImportDeclaration__Group_3_0_1__1__Impl : ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 ) ) ;
    public final void rule__XImportDeclaration__Group_3_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1831:1: ( ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1832:1: ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1832:1: ( ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1833:1: ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportItemsAssignment_3_0_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1834:1: ( rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1834:2: rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1_in_rule__XImportDeclaration__Group_3_0_1__1__Impl3626);
            rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportItemsAssignment_3_0_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__Group_3_0_1__1__Impl"


    // $ANTLR start "rule__XImportItem__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1848:1: rule__XImportItem__Group__0 : rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 ;
    public final void rule__XImportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1852:1: ( rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1853:2: rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__03660);
            rule__XImportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__03663);
            rule__XImportItem__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__0"


    // $ANTLR start "rule__XImportItem__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1860:1: rule__XImportItem__Group__0__Impl : ( () ) ;
    public final void rule__XImportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1864:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1865:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1865:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1866:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getXImportItemAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1867:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1869:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getXImportItemAction_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__0__Impl"


    // $ANTLR start "rule__XImportItem__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1879:1: rule__XImportItem__Group__1 : rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 ;
    public final void rule__XImportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1883:1: ( rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1884:2: rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__13721);
            rule__XImportItem__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__13724);
            rule__XImportItem__Group__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__1"


    // $ANTLR start "rule__XImportItem__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1891:1: rule__XImportItem__Group__1__Impl : ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) ;
    public final void rule__XImportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1895:1: ( ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1896:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1896:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1897:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1898:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1898:2: rule__XImportItem__ImportedIdAssignment_1
            {
            pushFollow(FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl3751);
            rule__XImportItem__ImportedIdAssignment_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getImportedIdAssignment_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__1__Impl"


    // $ANTLR start "rule__XImportItem__Group__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1908:1: rule__XImportItem__Group__2 : rule__XImportItem__Group__2__Impl ;
    public final void rule__XImportItem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1912:1: ( rule__XImportItem__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1913:2: rule__XImportItem__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__23781);
            rule__XImportItem__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__2"


    // $ANTLR start "rule__XImportItem__Group__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1919:1: rule__XImportItem__Group__2__Impl : ( ( rule__XImportItem__Group_2__0 )? ) ;
    public final void rule__XImportItem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1923:1: ( ( ( rule__XImportItem__Group_2__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1924:1: ( ( rule__XImportItem__Group_2__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1924:1: ( ( rule__XImportItem__Group_2__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1925:1: ( rule__XImportItem__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getGroup_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1926:1: ( rule__XImportItem__Group_2__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1926:2: rule__XImportItem__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl3808);
                    rule__XImportItem__Group_2__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getGroup_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group__2__Impl"


    // $ANTLR start "rule__XImportItem__Group_2__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1942:1: rule__XImportItem__Group_2__0 : rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 ;
    public final void rule__XImportItem__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1946:1: ( rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1947:2: rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__03845);
            rule__XImportItem__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__03848);
            rule__XImportItem__Group_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group_2__0"


    // $ANTLR start "rule__XImportItem__Group_2__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1954:1: rule__XImportItem__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__XImportItem__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1958:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1959:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1959:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1960:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAsKeyword_2_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__XImportItem__Group_2__0__Impl3876); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getAsKeyword_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group_2__0__Impl"


    // $ANTLR start "rule__XImportItem__Group_2__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1973:1: rule__XImportItem__Group_2__1 : rule__XImportItem__Group_2__1__Impl ;
    public final void rule__XImportItem__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1977:1: ( rule__XImportItem__Group_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1978:2: rule__XImportItem__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__13907);
            rule__XImportItem__Group_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group_2__1"


    // $ANTLR start "rule__XImportItem__Group_2__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1984:1: rule__XImportItem__Group_2__1__Impl : ( ( rule__XImportItem__AliasAssignment_2_1 ) ) ;
    public final void rule__XImportItem__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1988:1: ( ( ( rule__XImportItem__AliasAssignment_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1989:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1989:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1990:1: ( rule__XImportItem__AliasAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasAssignment_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1991:1: ( rule__XImportItem__AliasAssignment_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1991:2: rule__XImportItem__AliasAssignment_2_1
            {
            pushFollow(FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl3934);
            rule__XImportItem__AliasAssignment_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getAliasAssignment_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__Group_2__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2006:1: rule__XExportDeclaration__Group__0 : rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 ;
    public final void rule__XExportDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2010:1: ( rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2011:2: rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__03969);
            rule__XExportDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__03972);
            rule__XExportDeclaration__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group__0"


    // $ANTLR start "rule__XExportDeclaration__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2018:1: rule__XExportDeclaration__Group__0__Impl : ( 'export' ) ;
    public final void rule__XExportDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2022:1: ( ( 'export' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2023:1: ( 'export' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2023:1: ( 'export' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2024:1: 'export'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportKeyword_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__XExportDeclaration__Group__0__Impl4000); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getExportKeyword_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group__0__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2037:1: rule__XExportDeclaration__Group__1 : rule__XExportDeclaration__Group__1__Impl ;
    public final void rule__XExportDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2041:1: ( rule__XExportDeclaration__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2042:2: rule__XExportDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14031);
            rule__XExportDeclaration__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group__1"


    // $ANTLR start "rule__XExportDeclaration__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2048:1: rule__XExportDeclaration__Group__1__Impl : ( ( rule__XExportDeclaration__Alternatives_1 ) ) ;
    public final void rule__XExportDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2052:1: ( ( ( rule__XExportDeclaration__Alternatives_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2053:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2053:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2054:1: ( rule__XExportDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAlternatives_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2055:1: ( rule__XExportDeclaration__Alternatives_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2055:2: rule__XExportDeclaration__Alternatives_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4058);
            rule__XExportDeclaration__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getAlternatives_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2069:1: rule__XExportDeclaration__Group_1_0__0 : rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 ;
    public final void rule__XExportDeclaration__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2073:1: ( rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2074:2: rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04092);
            rule__XExportDeclaration__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04095);
            rule__XExportDeclaration__Group_1_0__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__0"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2081:1: rule__XExportDeclaration__Group_1_0__0__Impl : ( '{' ) ;
    public final void rule__XExportDeclaration__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2085:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2086:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2086:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2087:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__XExportDeclaration__Group_1_0__0__Impl4123); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__0__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2100:1: rule__XExportDeclaration__Group_1_0__1 : rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 ;
    public final void rule__XExportDeclaration__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2104:1: ( rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2105:2: rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__14154);
            rule__XExportDeclaration__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__14157);
            rule__XExportDeclaration__Group_1_0__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__1"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2112:1: rule__XExportDeclaration__Group_1_0__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2116:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2117:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2117:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2118:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2119:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2119:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl4184);
            rule__XExportDeclaration__ExportItemsAssignment_1_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2129:1: rule__XExportDeclaration__Group_1_0__2 : rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 ;
    public final void rule__XExportDeclaration__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2133:1: ( rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2134:2: rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__24214);
            rule__XExportDeclaration__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__24217);
            rule__XExportDeclaration__Group_1_0__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__2"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2141:1: rule__XExportDeclaration__Group_1_0__2__Impl : ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) ;
    public final void rule__XExportDeclaration__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2145:1: ( ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2146:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2146:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2147:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2148:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==14) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2148:2: rule__XExportDeclaration__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl4244);
            	    rule__XExportDeclaration__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__2__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2158:1: rule__XExportDeclaration__Group_1_0__3 : rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 ;
    public final void rule__XExportDeclaration__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2162:1: ( rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2163:2: rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__34275);
            rule__XExportDeclaration__Group_1_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__34278);
            rule__XExportDeclaration__Group_1_0__4();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__3"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2170:1: rule__XExportDeclaration__Group_1_0__3__Impl : ( '}' ) ;
    public final void rule__XExportDeclaration__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2174:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2175:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2175:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2176:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3()); 
            }
            match(input,22,FOLLOW_22_in_rule__XExportDeclaration__Group_1_0__3__Impl4306); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__3__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__4"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2189:1: rule__XExportDeclaration__Group_1_0__4 : rule__XExportDeclaration__Group_1_0__4__Impl ;
    public final void rule__XExportDeclaration__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2193:1: ( rule__XExportDeclaration__Group_1_0__4__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2194:2: rule__XExportDeclaration__Group_1_0__4__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__44337);
            rule__XExportDeclaration__Group_1_0__4__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__4"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0__4__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2200:1: rule__XExportDeclaration__Group_1_0__4__Impl : ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) ;
    public final void rule__XExportDeclaration__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2204:1: ( ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2205:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2205:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2206:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_4()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2207:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==24) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2207:2: rule__XExportDeclaration__Group_1_0_4__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl4364);
                    rule__XExportDeclaration__Group_1_0_4__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_4()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0__4__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_2__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2227:1: rule__XExportDeclaration__Group_1_0_2__0 : rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 ;
    public final void rule__XExportDeclaration__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2231:1: ( rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2232:2: rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__04405);
            rule__XExportDeclaration__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__04408);
            rule__XExportDeclaration__Group_1_0_2__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_2__0"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_2__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2239:1: rule__XExportDeclaration__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2243:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2244:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2244:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2245:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,14,FOLLOW_14_in_rule__XExportDeclaration__Group_1_0_2__0__Impl4436); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_2__0__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_2__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2258:1: rule__XExportDeclaration__Group_1_0_2__1 : rule__XExportDeclaration__Group_1_0_2__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2262:1: ( rule__XExportDeclaration__Group_1_0_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2263:2: rule__XExportDeclaration__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__14467);
            rule__XExportDeclaration__Group_1_0_2__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_2__1"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_2__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2269:1: rule__XExportDeclaration__Group_1_0_2__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2273:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2274:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2274:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2275:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2276:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2276:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl4494);
            rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_2_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_2__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_4__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2290:1: rule__XExportDeclaration__Group_1_0_4__0 : rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 ;
    public final void rule__XExportDeclaration__Group_1_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2294:1: ( rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2295:2: rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__04528);
            rule__XExportDeclaration__Group_1_0_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__04531);
            rule__XExportDeclaration__Group_1_0_4__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_4__0"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_4__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2302:1: rule__XExportDeclaration__Group_1_0_4__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2306:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2307:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2307:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2308:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XExportDeclaration__Group_1_0_4__0__Impl4559); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_4__0__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_4__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2321:1: rule__XExportDeclaration__Group_1_0_4__1 : rule__XExportDeclaration__Group_1_0_4__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2325:1: ( rule__XExportDeclaration__Group_1_0_4__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2326:2: rule__XExportDeclaration__Group_1_0_4__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__14590);
            rule__XExportDeclaration__Group_1_0_4__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_4__1"


    // $ANTLR start "rule__XExportDeclaration__Group_1_0_4__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2332:1: rule__XExportDeclaration__Group_1_0_4__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2336:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2337:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2337:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2338:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_0_4_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2339:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2339:2: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl4617);
            rule__XExportDeclaration__ImportURIAssignment_1_0_4_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_0_4_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_0_4__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2353:1: rule__XExportDeclaration__Group_1_1__0 : rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 ;
    public final void rule__XExportDeclaration__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2357:1: ( rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2358:2: rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__04651);
            rule__XExportDeclaration__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__04654);
            rule__XExportDeclaration__Group_1_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__0"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2365:1: rule__XExportDeclaration__Group_1_1__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2369:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2370:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2370:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2371:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XExportDeclaration__Group_1_1__0__Impl4682); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__0__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2384:1: rule__XExportDeclaration__Group_1_1__1 : rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 ;
    public final void rule__XExportDeclaration__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2388:1: ( rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2389:2: rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__14713);
            rule__XExportDeclaration__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__14716);
            rule__XExportDeclaration__Group_1_1__2();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__1"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2396:1: rule__XExportDeclaration__Group_1_1__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2400:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2401:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2401:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2402:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2403:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2403:2: rule__XExportDeclaration__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl4743);
            rule__XExportDeclaration__ImportURIAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__1__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2413:1: rule__XExportDeclaration__Group_1_1__2 : rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 ;
    public final void rule__XExportDeclaration__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2417:1: ( rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2418:2: rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__24773);
            rule__XExportDeclaration__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__24776);
            rule__XExportDeclaration__Group_1_1__3();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__2"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2425:1: rule__XExportDeclaration__Group_1_1__2__Impl : ( 'as' ) ;
    public final void rule__XExportDeclaration__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2429:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2430:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2430:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2431:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2()); 
            }
            match(input,23,FOLLOW_23_in_rule__XExportDeclaration__Group_1_1__2__Impl4804); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__2__Impl"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2444:1: rule__XExportDeclaration__Group_1_1__3 : rule__XExportDeclaration__Group_1_1__3__Impl ;
    public final void rule__XExportDeclaration__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2448:1: ( rule__XExportDeclaration__Group_1_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2449:2: rule__XExportDeclaration__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__34835);
            rule__XExportDeclaration__Group_1_1__3__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__3"


    // $ANTLR start "rule__XExportDeclaration__Group_1_1__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2455:1: rule__XExportDeclaration__Group_1_1__3__Impl : ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2459:1: ( ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2460:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2460:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2461:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasAssignment_1_1_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2462:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2462:2: rule__XExportDeclaration__AliasAssignment_1_1_3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl4862);
            rule__XExportDeclaration__AliasAssignment_1_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getAliasAssignment_1_1_3()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__Group_1_1__3__Impl"


    // $ANTLR start "rule__XExportItem__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2480:1: rule__XExportItem__Group__0 : rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 ;
    public final void rule__XExportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2484:1: ( rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2485:2: rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__04900);
            rule__XExportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__04903);
            rule__XExportItem__Group__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group__0"


    // $ANTLR start "rule__XExportItem__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2492:1: rule__XExportItem__Group__0__Impl : ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) ;
    public final void rule__XExportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2496:1: ( ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2497:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2497:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2498:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2499:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2499:2: rule__XExportItem__ExportedIdAssignment_0
            {
            pushFollow(FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl4930);
            rule__XExportItem__ExportedIdAssignment_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getExportedIdAssignment_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group__0__Impl"


    // $ANTLR start "rule__XExportItem__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2509:1: rule__XExportItem__Group__1 : rule__XExportItem__Group__1__Impl ;
    public final void rule__XExportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2513:1: ( rule__XExportItem__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2514:2: rule__XExportItem__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__14960);
            rule__XExportItem__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group__1"


    // $ANTLR start "rule__XExportItem__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2520:1: rule__XExportItem__Group__1__Impl : ( ( rule__XExportItem__Group_1__0 )? ) ;
    public final void rule__XExportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2524:1: ( ( ( rule__XExportItem__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2525:1: ( ( rule__XExportItem__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2525:1: ( ( rule__XExportItem__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2526:1: ( rule__XExportItem__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2527:1: ( rule__XExportItem__Group_1__0 )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==23) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2527:2: rule__XExportItem__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl4987);
                    rule__XExportItem__Group_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getGroup_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group__1__Impl"


    // $ANTLR start "rule__XExportItem__Group_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2541:1: rule__XExportItem__Group_1__0 : rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 ;
    public final void rule__XExportItem__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2545:1: ( rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2546:2: rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05022);
            rule__XExportItem__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05025);
            rule__XExportItem__Group_1__1();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group_1__0"


    // $ANTLR start "rule__XExportItem__Group_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2553:1: rule__XExportItem__Group_1__0__Impl : ( 'as' ) ;
    public final void rule__XExportItem__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2557:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2558:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2558:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2559:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAsKeyword_1_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__XExportItem__Group_1__0__Impl5053); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getAsKeyword_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group_1__0__Impl"


    // $ANTLR start "rule__XExportItem__Group_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2572:1: rule__XExportItem__Group_1__1 : rule__XExportItem__Group_1__1__Impl ;
    public final void rule__XExportItem__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2576:1: ( rule__XExportItem__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2577:2: rule__XExportItem__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15084);
            rule__XExportItem__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;

            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group_1__1"


    // $ANTLR start "rule__XExportItem__Group_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2583:1: rule__XExportItem__Group_1__1__Impl : ( ( rule__XExportItem__AliasAssignment_1_1 ) ) ;
    public final void rule__XExportItem__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2587:1: ( ( ( rule__XExportItem__AliasAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2588:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2588:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2589:1: ( rule__XExportItem__AliasAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2590:1: ( rule__XExportItem__AliasAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2590:2: rule__XExportItem__AliasAssignment_1_1
            {
            pushFollow(FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl5111);
            rule__XExportItem__AliasAssignment_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getAliasAssignment_1_1()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__Group_1__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__TypeAssignment_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2605:1: rule__JvmParameterizedTypeReference__TypeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JvmParameterizedTypeReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2609:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2610:1: ( ( ruleQualifiedName ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2610:1: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2611:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2612:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2613:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_05154);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__TypeAssignment_0"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2624:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2628:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2629:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2629:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2630:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_15189);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1"


    // $ANTLR start "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2639:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2643:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2644:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2644:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2645:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_15220);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2654:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 : ( ruleJvmUpperBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2658:1: ( ( ruleJvmUpperBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2659:1: ( ruleJvmUpperBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2659:1: ( ruleJvmUpperBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2660:1: ruleJvmUpperBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_05251);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0"


    // $ANTLR start "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2669:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 : ( ruleJvmLowerBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2673:1: ( ( ruleJvmLowerBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2674:1: ( ruleJvmLowerBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2674:1: ( ruleJvmLowerBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2675:1: ruleJvmLowerBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_15282);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1"


    // $ANTLR start "rule__JvmUpperBound__TypeReferenceAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2684:1: rule__JvmUpperBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2688:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2689:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2689:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2690:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_15313);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBound__TypeReferenceAssignment_1"


    // $ANTLR start "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2699:1: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBoundAnded__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2703:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2704:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2704:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2705:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_15344);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmUpperBoundAnded__TypeReferenceAssignment_1"


    // $ANTLR start "rule__JvmLowerBound__TypeReferenceAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2714:1: rule__JvmLowerBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmLowerBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2718:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2719:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2719:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2720:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_15375);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmLowerBound__TypeReferenceAssignment_1"


    // $ANTLR start "rule__XImportDeclaration__ImportItemsAssignment_3_0_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2733:1: rule__XImportDeclaration__ImportItemsAssignment_3_0_0 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration__ImportItemsAssignment_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2737:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2738:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2738:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2739:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportItemsXImportItemParserRuleCall_3_0_0_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration__ImportItemsAssignment_3_0_05410);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportItemsXImportItemParserRuleCall_3_0_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__ImportItemsAssignment_3_0_0"


    // $ANTLR start "rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2748:1: rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2752:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2753:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2753:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2754:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getImportItemsXImportItemParserRuleCall_3_0_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration__ImportItemsAssignment_3_0_1_15441);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getImportItemsXImportItemParserRuleCall_3_0_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1"


    // $ANTLR start "rule__XImportDeclaration__WildcardAssignment_3_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2763:1: rule__XImportDeclaration__WildcardAssignment_3_1 : ( ( '*' ) ) ;
    public final void rule__XImportDeclaration__WildcardAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2767:1: ( ( ( '*' ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2768:1: ( ( '*' ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2768:1: ( ( '*' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2769:1: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_3_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2770:1: ( '*' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2771:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_3_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__XImportDeclaration__WildcardAssignment_3_15477); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getWildcardAsteriskKeyword_3_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__WildcardAssignment_3_1"


    // $ANTLR start "rule__XImportDeclaration__AliasAssignment_6"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2786:1: rule__XImportDeclaration__AliasAssignment_6 : ( ruleValidID ) ;
    public final void rule__XImportDeclaration__AliasAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2790:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2791:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2791:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2792:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getAliasValidIDParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__XImportDeclaration__AliasAssignment_65516);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getAliasValidIDParserRuleCall_6_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__AliasAssignment_6"


    // $ANTLR start "rule__XImportDeclaration__ModuleAssignment_8"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2801:1: rule__XImportDeclaration__ModuleAssignment_8 : ( ( ruleQualifiedName ) ) ;
    public final void rule__XImportDeclaration__ModuleAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2805:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2806:1: ( ( ruleQualifiedName ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2806:1: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2807:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getModuleJvmModuleCrossReference_8_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2808:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2809:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclarationAccess().getModuleJvmModuleQualifiedNameParserRuleCall_8_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__XImportDeclaration__ModuleAssignment_85551);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getModuleJvmModuleQualifiedNameParserRuleCall_8_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclarationAccess().getModuleJvmModuleCrossReference_8_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration__ModuleAssignment_8"


    // $ANTLR start "rule__XImportItem__ImportedIdAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2820:1: rule__XImportItem__ImportedIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__XImportItem__ImportedIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2824:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2825:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2825:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2826:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2827:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2828:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_15590); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementIDTerminalRuleCall_1_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__ImportedIdAssignment_1"


    // $ANTLR start "rule__XImportItem__AliasAssignment_2_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2839:1: rule__XImportItem__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__XImportItem__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2843:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2844:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2844:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2845:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_15625); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportItem__AliasAssignment_2_1"


    // $ANTLR start "rule__XExportDeclaration__ExportItemsAssignment_1_0_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2855:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2859:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2860:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2860:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2861:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_15657);
            ruleXExportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__ExportItemsAssignment_1_0_1"


    // $ANTLR start "rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2870:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2874:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2875:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2875:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2876:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_15688);
            ruleXExportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1"


    // $ANTLR start "rule__XExportDeclaration__ImportURIAssignment_1_0_4_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2885:1: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2889:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2890:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2890:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2891:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0_4_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_15719); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0_4_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__ImportURIAssignment_1_0_4_1"


    // $ANTLR start "rule__XExportDeclaration__ImportURIAssignment_1_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2900:1: rule__XExportDeclaration__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2904:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2905:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2905:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2906:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_15750); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__ImportURIAssignment_1_1_1"


    // $ANTLR start "rule__XExportDeclaration__AliasAssignment_1_1_3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2915:1: rule__XExportDeclaration__AliasAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__XExportDeclaration__AliasAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2919:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2920:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2920:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2921:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasIDTerminalRuleCall_1_1_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_35781); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationAccess().getAliasIDTerminalRuleCall_1_1_3_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportDeclaration__AliasAssignment_1_1_3"


    // $ANTLR start "rule__XExportItem__ExportedIdAssignment_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2930:1: rule__XExportItem__ExportedIdAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__XExportItem__ExportedIdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2934:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2935:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2935:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2936:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2937:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2938:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_05816); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementIDTerminalRuleCall_0_0_1()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__ExportedIdAssignment_0"


    // $ANTLR start "rule__XExportItem__AliasAssignment_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2949:1: rule__XExportItem__AliasAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__XExportItem__AliasAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2953:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2954:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2954:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2955:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_15851); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemAccess().getAliasIDTerminalRuleCall_1_1_0()); 
            }

            }


            }

        }
        catch (RecognitionException re) {
            reportError(re);
            recover(input,re);
        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XExportItem__AliasAssignment_1_1"

    // Delegated rules


 

    public static final BitSet FOLLOW_ruleJvmTypeReference_in_entryRuleJvmTypeReference67 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmTypeReference74 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group__0_in_ruleJvmTypeReference100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__0_in_ruleArrayBrackets160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__0_in_ruleJvmParameterizedTypeReference220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmArgumentTypeReference__Alternatives_in_ruleJvmArgumentTypeReference280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__0_in_ruleJvmWildcardTypeReference340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__0_in_ruleJvmUpperBound400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__0_in_ruleJvmUpperBoundAnded460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__0_in_ruleJvmLowerBound520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName549 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName556 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName582 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID611 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID618 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID644 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration_in_entryRuleXImportDeclaration672 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration679 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__0_in_ruleXImportDeclaration705 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_entryRuleXImportItem732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportItem739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__0_in_ruleXImportItem765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration794 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportDeclaration801 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__0_in_ruleXExportDeclaration827 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_entryRuleXExportItem854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportItem861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__0_in_ruleXExportItem887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmArgumentTypeReference__Alternatives923 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_rule__JvmArgumentTypeReference__Alternatives940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_in_rule__JvmWildcardTypeReference__Alternatives_2972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_in_rule__JvmWildcardTypeReference__Alternatives_2990 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0__0_in_rule__XImportDeclaration__Alternatives_31023 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__WildcardAssignment_3_1_in_rule__XImportDeclaration__Alternatives_31041 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11074 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11092 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group__0__Impl_in_rule__JvmTypeReference__Group__01123 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group__1_in_rule__JvmTypeReference__Group__01126 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group__0__Impl1153 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group__1__Impl_in_rule__JvmTypeReference__Group__11182 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1__0_in_rule__JvmTypeReference__Group__1__Impl1209 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1__0__Impl_in_rule__JvmTypeReference__Group_1__01244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1_0__0_in_rule__JvmTypeReference__Group_1__0__Impl1271 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1_0__0__Impl_in_rule__JvmTypeReference__Group_1_0__01303 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1_0__1_in_rule__JvmTypeReference__Group_1_0__01306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_1_0__1__Impl_in_rule__JvmTypeReference__Group_1_0__11364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_1_0__1__Impl1391 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01424 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01427 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1455 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11486 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1514 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__01549 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__01552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl1579 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__11609 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl1636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__01671 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__01674 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl1703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__11735 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__11738 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__21795 = new BitSet(new long[]{0x0000000000006000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__21798 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl1825 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__31856 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl1884 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__01923 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__01926 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl1954 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__11985 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2012 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02046 = new BitSet(new long[]{0x0000000000008010L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12107 = new BitSet(new long[]{0x0000000000050000L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12110 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JvmWildcardTypeReference__Group__1__Impl2138 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22169 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__02233 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__02236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JvmUpperBound__Group__0__Impl2264 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__12295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl2322 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__02356 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__02359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__JvmUpperBoundAnded__Group__0__Impl2387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__12418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl2445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__02479 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__02482 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JvmLowerBound__Group__0__Impl2510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__12541 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl2568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__02604 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__02607 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl2634 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__12663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl2690 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__02725 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__02728 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__QualifiedName__Group_1__0__Impl2756 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__12787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl2814 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__0__Impl_in_rule__XImportDeclaration__Group__02849 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__1_in_rule__XImportDeclaration__Group__02852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__1__Impl_in_rule__XImportDeclaration__Group__12910 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__2_in_rule__XImportDeclaration__Group__12913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__XImportDeclaration__Group__1__Impl2941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__2__Impl_in_rule__XImportDeclaration__Group__22972 = new BitSet(new long[]{0x0000000004000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__3_in_rule__XImportDeclaration__Group__22975 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__XImportDeclaration__Group__2__Impl3003 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__3__Impl_in_rule__XImportDeclaration__Group__33034 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__4_in_rule__XImportDeclaration__Group__33037 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Alternatives_3_in_rule__XImportDeclaration__Group__3__Impl3064 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__4__Impl_in_rule__XImportDeclaration__Group__43094 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__5_in_rule__XImportDeclaration__Group__43097 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__XImportDeclaration__Group__4__Impl3125 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__5__Impl_in_rule__XImportDeclaration__Group__53156 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__6_in_rule__XImportDeclaration__Group__53159 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XImportDeclaration__Group__5__Impl3187 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__6__Impl_in_rule__XImportDeclaration__Group__63218 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__7_in_rule__XImportDeclaration__Group__63221 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__AliasAssignment_6_in_rule__XImportDeclaration__Group__6__Impl3248 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__7__Impl_in_rule__XImportDeclaration__Group__73278 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__8_in_rule__XImportDeclaration__Group__73281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XImportDeclaration__Group__7__Impl3309 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group__8__Impl_in_rule__XImportDeclaration__Group__83340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__ModuleAssignment_8_in_rule__XImportDeclaration__Group__8__Impl3367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0__0__Impl_in_rule__XImportDeclaration__Group_3_0__03415 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0__1_in_rule__XImportDeclaration__Group_3_0__03418 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__ImportItemsAssignment_3_0_0_in_rule__XImportDeclaration__Group_3_0__0__Impl3445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0__1__Impl_in_rule__XImportDeclaration__Group_3_0__13475 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0_1__0_in_rule__XImportDeclaration__Group_3_0__1__Impl3502 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0_1__0__Impl_in_rule__XImportDeclaration__Group_3_0_1__03537 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0_1__1_in_rule__XImportDeclaration__Group_3_0_1__03540 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__XImportDeclaration__Group_3_0_1__0__Impl3568 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__Group_3_0_1__1__Impl_in_rule__XImportDeclaration__Group_3_0_1__13599 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration__ImportItemsAssignment_3_0_1_1_in_rule__XImportDeclaration__Group_3_0_1__1__Impl3626 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__03660 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__03663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__13721 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__13724 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl3751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__23781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl3808 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__03845 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__03848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XImportItem__Group_2__0__Impl3876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__13907 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl3934 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__03969 = new BitSet(new long[]{0x0000000001200000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__03972 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__XExportDeclaration__Group__0__Impl4000 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14031 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4058 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04092 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04095 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__XExportDeclaration__Group_1_0__0__Impl4123 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__14154 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__14157 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl4184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__24214 = new BitSet(new long[]{0x0000000000404000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__24217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl4244 = new BitSet(new long[]{0x0000000000004002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__34275 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__34278 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__XExportDeclaration__Group_1_0__3__Impl4306 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__44337 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl4364 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__04405 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__04408 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__XExportDeclaration__Group_1_0_2__0__Impl4436 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__14467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl4494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__04528 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__04531 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XExportDeclaration__Group_1_0_4__0__Impl4559 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__14590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl4617 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__04651 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__04654 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XExportDeclaration__Group_1_1__0__Impl4682 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__14713 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__14716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl4743 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__24773 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__24776 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XExportDeclaration__Group_1_1__2__Impl4804 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__34835 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl4862 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__04900 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__04903 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl4930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__14960 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl4987 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05022 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05025 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XExportItem__Group_1__0__Impl5053 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15084 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl5111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_05154 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_15189 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_15220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_05251 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_15282 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_15313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_15344 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_15375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration__ImportItemsAssignment_3_0_05410 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration__ImportItemsAssignment_3_0_1_15441 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XImportDeclaration__WildcardAssignment_3_15477 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__XImportDeclaration__AliasAssignment_65516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__XImportDeclaration__ModuleAssignment_85551 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_15590 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_15625 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_15657 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_15688 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_15719 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_15750 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_35781 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_05816 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_15851 = new BitSet(new long[]{0x0000000000000002L});

}