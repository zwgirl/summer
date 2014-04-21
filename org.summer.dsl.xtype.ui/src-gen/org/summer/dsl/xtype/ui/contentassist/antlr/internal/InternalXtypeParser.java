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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'=>'", "'('", "')'", "','", "'<'", "'>'", "'?'", "'extends'", "'&'", "'super'", "'.'", "'import'", "'from'", "'{'", "'}'", "'as'", "'export'"
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:70:1: ruleJvmTypeReference : ( ( rule__JvmTypeReference__Alternatives ) ) ;
    public final void ruleJvmTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:74:2: ( ( ( rule__JvmTypeReference__Alternatives ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:75:1: ( ( rule__JvmTypeReference__Alternatives ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:75:1: ( ( rule__JvmTypeReference__Alternatives ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:76:1: ( rule__JvmTypeReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:77:1: ( rule__JvmTypeReference__Alternatives )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:77:2: rule__JvmTypeReference__Alternatives
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Alternatives_in_ruleJvmTypeReference100);
            rule__JvmTypeReference__Alternatives();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getAlternatives()); 
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


    // $ANTLR start "entryRuleXFunctionTypeRef"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:117:1: entryRuleXFunctionTypeRef : ruleXFunctionTypeRef EOF ;
    public final void entryRuleXFunctionTypeRef() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:118:1: ( ruleXFunctionTypeRef EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:119:1: ruleXFunctionTypeRef EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefRule()); 
            }
            pushFollow(FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef187);
            ruleXFunctionTypeRef();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXFunctionTypeRef194); if (state.failed) return ;

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
    // $ANTLR end "entryRuleXFunctionTypeRef"


    // $ANTLR start "ruleXFunctionTypeRef"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:126:1: ruleXFunctionTypeRef : ( ( rule__XFunctionTypeRef__Group__0 ) ) ;
    public final void ruleXFunctionTypeRef() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:130:2: ( ( ( rule__XFunctionTypeRef__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:131:1: ( ( rule__XFunctionTypeRef__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:131:1: ( ( rule__XFunctionTypeRef__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:132:1: ( rule__XFunctionTypeRef__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:133:1: ( rule__XFunctionTypeRef__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:133:2: rule__XFunctionTypeRef__Group__0
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__0_in_ruleXFunctionTypeRef220);
            rule__XFunctionTypeRef__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup()); 
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
    // $ANTLR end "ruleXFunctionTypeRef"


    // $ANTLR start "entryRuleJvmParameterizedTypeReference"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:145:1: entryRuleJvmParameterizedTypeReference : ruleJvmParameterizedTypeReference EOF ;
    public final void entryRuleJvmParameterizedTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:146:1: ( ruleJvmParameterizedTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:147:1: ruleJvmParameterizedTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference247);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmParameterizedTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference254); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:154:1: ruleJvmParameterizedTypeReference : ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) ;
    public final void ruleJvmParameterizedTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:158:2: ( ( ( rule__JvmParameterizedTypeReference__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:159:1: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:159:1: ( ( rule__JvmParameterizedTypeReference__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:160:1: ( rule__JvmParameterizedTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:161:1: ( rule__JvmParameterizedTypeReference__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:161:2: rule__JvmParameterizedTypeReference__Group__0
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__0_in_ruleJvmParameterizedTypeReference280);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:173:1: entryRuleJvmArgumentTypeReference : ruleJvmArgumentTypeReference EOF ;
    public final void entryRuleJvmArgumentTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:174:1: ( ruleJvmArgumentTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:175:1: ruleJvmArgumentTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference307);
            ruleJvmArgumentTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmArgumentTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference314); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:182:1: ruleJvmArgumentTypeReference : ( ( rule__JvmArgumentTypeReference__Alternatives ) ) ;
    public final void ruleJvmArgumentTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:186:2: ( ( ( rule__JvmArgumentTypeReference__Alternatives ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:187:1: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:187:1: ( ( rule__JvmArgumentTypeReference__Alternatives ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:188:1: ( rule__JvmArgumentTypeReference__Alternatives )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmArgumentTypeReferenceAccess().getAlternatives()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:189:1: ( rule__JvmArgumentTypeReference__Alternatives )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:189:2: rule__JvmArgumentTypeReference__Alternatives
            {
            pushFollow(FOLLOW_rule__JvmArgumentTypeReference__Alternatives_in_ruleJvmArgumentTypeReference340);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:201:1: entryRuleJvmWildcardTypeReference : ruleJvmWildcardTypeReference EOF ;
    public final void entryRuleJvmWildcardTypeReference() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:202:1: ( ruleJvmWildcardTypeReference EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:203:1: ruleJvmWildcardTypeReference EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference367);
            ruleJvmWildcardTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmWildcardTypeReferenceRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference374); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:210:1: ruleJvmWildcardTypeReference : ( ( rule__JvmWildcardTypeReference__Group__0 ) ) ;
    public final void ruleJvmWildcardTypeReference() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:214:2: ( ( ( rule__JvmWildcardTypeReference__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:215:1: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:215:1: ( ( rule__JvmWildcardTypeReference__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:216:1: ( rule__JvmWildcardTypeReference__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:217:1: ( rule__JvmWildcardTypeReference__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:217:2: rule__JvmWildcardTypeReference__Group__0
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__0_in_ruleJvmWildcardTypeReference400);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:229:1: entryRuleJvmUpperBound : ruleJvmUpperBound EOF ;
    public final void entryRuleJvmUpperBound() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:230:1: ( ruleJvmUpperBound EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:231:1: ruleJvmUpperBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound427);
            ruleJvmUpperBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBound434); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:238:1: ruleJvmUpperBound : ( ( rule__JvmUpperBound__Group__0 ) ) ;
    public final void ruleJvmUpperBound() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:242:2: ( ( ( rule__JvmUpperBound__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:243:1: ( ( rule__JvmUpperBound__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:243:1: ( ( rule__JvmUpperBound__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:244:1: ( rule__JvmUpperBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:245:1: ( rule__JvmUpperBound__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:245:2: rule__JvmUpperBound__Group__0
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__0_in_ruleJvmUpperBound460);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:257:1: entryRuleJvmUpperBoundAnded : ruleJvmUpperBoundAnded EOF ;
    public final void entryRuleJvmUpperBoundAnded() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:258:1: ( ruleJvmUpperBoundAnded EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:259:1: ruleJvmUpperBoundAnded EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded487);
            ruleJvmUpperBoundAnded();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmUpperBoundAndedRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded494); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:266:1: ruleJvmUpperBoundAnded : ( ( rule__JvmUpperBoundAnded__Group__0 ) ) ;
    public final void ruleJvmUpperBoundAnded() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:270:2: ( ( ( rule__JvmUpperBoundAnded__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:271:1: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:271:1: ( ( rule__JvmUpperBoundAnded__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:272:1: ( rule__JvmUpperBoundAnded__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:273:1: ( rule__JvmUpperBoundAnded__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:273:2: rule__JvmUpperBoundAnded__Group__0
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__0_in_ruleJvmUpperBoundAnded520);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:285:1: entryRuleJvmLowerBound : ruleJvmLowerBound EOF ;
    public final void entryRuleJvmLowerBound() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:286:1: ( ruleJvmLowerBound EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:287:1: ruleJvmLowerBound EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundRule()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound547);
            ruleJvmLowerBound();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmLowerBoundRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleJvmLowerBound554); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:294:1: ruleJvmLowerBound : ( ( rule__JvmLowerBound__Group__0 ) ) ;
    public final void ruleJvmLowerBound() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:298:2: ( ( ( rule__JvmLowerBound__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:299:1: ( ( rule__JvmLowerBound__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:299:1: ( ( rule__JvmLowerBound__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:300:1: ( rule__JvmLowerBound__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:301:1: ( rule__JvmLowerBound__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:301:2: rule__JvmLowerBound__Group__0
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__0_in_ruleJvmLowerBound580);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:315:1: entryRuleQualifiedName : ruleQualifiedName EOF ;
    public final void entryRuleQualifiedName() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:316:1: ( ruleQualifiedName EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:317:1: ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName609);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getQualifiedNameRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleQualifiedName616); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:324:1: ruleQualifiedName : ( ( rule__QualifiedName__Group__0 ) ) ;
    public final void ruleQualifiedName() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:328:2: ( ( ( rule__QualifiedName__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:329:1: ( ( rule__QualifiedName__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:329:1: ( ( rule__QualifiedName__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:330:1: ( rule__QualifiedName__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:331:1: ( rule__QualifiedName__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:331:2: rule__QualifiedName__Group__0
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName642);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:345:1: entryRuleValidID : ruleValidID EOF ;
    public final void entryRuleValidID() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:346:1: ( ruleValidID EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:347:1: ruleValidID EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDRule()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_entryRuleValidID671);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getValidIDRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleValidID678); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:354:1: ruleValidID : ( RULE_ID ) ;
    public final void ruleValidID() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:358:2: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:359:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:359:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:360:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getValidIDAccess().getIDTerminalRuleCall()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_ruleValidID704); if (state.failed) return ;
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


    // $ANTLR start "entryRuleXImportDeclaration1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:375:1: entryRuleXImportDeclaration1 : ruleXImportDeclaration1 EOF ;
    public final void entryRuleXImportDeclaration1() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:376:1: ( ruleXImportDeclaration1 EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:377:1: ruleXImportDeclaration1 EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Rule()); 
            }
            pushFollow(FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration1732);
            ruleXImportDeclaration1();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Rule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportDeclaration1739); if (state.failed) return ;

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
    // $ANTLR end "entryRuleXImportDeclaration1"


    // $ANTLR start "ruleXImportDeclaration1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:384:1: ruleXImportDeclaration1 : ( ( rule__XImportDeclaration1__Group__0 ) ) ;
    public final void ruleXImportDeclaration1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:388:2: ( ( ( rule__XImportDeclaration1__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:389:1: ( ( rule__XImportDeclaration1__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:389:1: ( ( rule__XImportDeclaration1__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:390:1: ( rule__XImportDeclaration1__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:391:1: ( rule__XImportDeclaration1__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:391:2: rule__XImportDeclaration1__Group__0
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__0_in_ruleXImportDeclaration1765);
            rule__XImportDeclaration1__Group__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getGroup()); 
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
    // $ANTLR end "ruleXImportDeclaration1"


    // $ANTLR start "entryRuleXImportItem"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:403:1: entryRuleXImportItem : ruleXImportItem EOF ;
    public final void entryRuleXImportItem() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:404:1: ( ruleXImportItem EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:405:1: ruleXImportItem EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_entryRuleXImportItem792);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportItemRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXImportItem799); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:412:1: ruleXImportItem : ( ( rule__XImportItem__Group__0 ) ) ;
    public final void ruleXImportItem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:416:2: ( ( ( rule__XImportItem__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:417:1: ( ( rule__XImportItem__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:417:1: ( ( rule__XImportItem__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:418:1: ( rule__XImportItem__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:419:1: ( rule__XImportItem__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:419:2: rule__XImportItem__Group__0
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__0_in_ruleXImportItem825);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:433:1: entryRuleXExportDeclaration : ruleXExportDeclaration EOF ;
    public final void entryRuleXExportDeclaration() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:434:1: ( ruleXExportDeclaration EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:435:1: ruleXExportDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationRule()); 
            }
            pushFollow(FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration854);
            ruleXExportDeclaration();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportDeclarationRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportDeclaration861); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:442:1: ruleXExportDeclaration : ( ( rule__XExportDeclaration__Group__0 ) ) ;
    public final void ruleXExportDeclaration() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:446:2: ( ( ( rule__XExportDeclaration__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:447:1: ( ( rule__XExportDeclaration__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:447:1: ( ( rule__XExportDeclaration__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:448:1: ( rule__XExportDeclaration__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:449:1: ( rule__XExportDeclaration__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:449:2: rule__XExportDeclaration__Group__0
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__0_in_ruleXExportDeclaration887);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:461:1: entryRuleXExportItem : ruleXExportItem EOF ;
    public final void entryRuleXExportItem() throws RecognitionException {
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:462:1: ( ruleXExportItem EOF )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:463:1: ruleXExportItem EOF
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemRule()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_entryRuleXExportItem914);
            ruleXExportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXExportItemRule()); 
            }
            match(input,EOF,FOLLOW_EOF_in_entryRuleXExportItem921); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:470:1: ruleXExportItem : ( ( rule__XExportItem__Group__0 ) ) ;
    public final void ruleXExportItem() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:474:2: ( ( ( rule__XExportItem__Group__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:475:1: ( ( rule__XExportItem__Group__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:475:1: ( ( rule__XExportItem__Group__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:476:1: ( rule__XExportItem__Group__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getGroup()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:477:1: ( rule__XExportItem__Group__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:477:2: rule__XExportItem__Group__0
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__0_in_ruleXExportItem947);
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


    // $ANTLR start "rule__JvmTypeReference__Alternatives"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:489:1: rule__JvmTypeReference__Alternatives : ( ( ( rule__JvmTypeReference__Group_0__0 ) ) | ( ruleXFunctionTypeRef ) );
    public final void rule__JvmTypeReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:493:1: ( ( ( rule__JvmTypeReference__Group_0__0 ) ) | ( ruleXFunctionTypeRef ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==RULE_ID) ) {
                alt1=1;
            }
            else if ( ((LA1_0>=12 && LA1_0<=13)) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:494:1: ( ( rule__JvmTypeReference__Group_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:494:1: ( ( rule__JvmTypeReference__Group_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:495:1: ( rule__JvmTypeReference__Group_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:496:1: ( rule__JvmTypeReference__Group_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:496:2: rule__JvmTypeReference__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__0_in_rule__JvmTypeReference__Alternatives983);
                    rule__JvmTypeReference__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:500:6: ( ruleXFunctionTypeRef )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:500:6: ( ruleXFunctionTypeRef )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:501:1: ruleXFunctionTypeRef
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleXFunctionTypeRef_in_rule__JvmTypeReference__Alternatives1001);
                    ruleXFunctionTypeRef();

                    state._fsp--;
                    if (state.failed) return ;
                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getJvmTypeReferenceAccess().getXFunctionTypeRefParserRuleCall_1()); 
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
    // $ANTLR end "rule__JvmTypeReference__Alternatives"


    // $ANTLR start "rule__JvmArgumentTypeReference__Alternatives"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:511:1: rule__JvmArgumentTypeReference__Alternatives : ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) );
    public final void rule__JvmArgumentTypeReference__Alternatives() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:515:1: ( ( ruleJvmTypeReference ) | ( ruleJvmWildcardTypeReference ) )
            int alt2=2;
            int LA2_0 = input.LA(1);

            if ( (LA2_0==RULE_ID||(LA2_0>=12 && LA2_0<=13)) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:516:1: ( ruleJvmTypeReference )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:516:1: ( ruleJvmTypeReference )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:517:1: ruleJvmTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmTypeReferenceParserRuleCall_0()); 
                    }
                    pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmArgumentTypeReference__Alternatives1033);
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:522:6: ( ruleJvmWildcardTypeReference )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:522:6: ( ruleJvmWildcardTypeReference )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:523:1: ruleJvmWildcardTypeReference
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmArgumentTypeReferenceAccess().getJvmWildcardTypeReferenceParserRuleCall_1()); 
                    }
                    pushFollow(FOLLOW_ruleJvmWildcardTypeReference_in_rule__JvmArgumentTypeReference__Alternatives1050);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:533:1: rule__JvmWildcardTypeReference__Alternatives_2 : ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) ) | ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) ) );
    public final void rule__JvmWildcardTypeReference__Alternatives_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:537:1: ( ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) ) | ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) ) )
            int alt3=2;
            int LA3_0 = input.LA(1);

            if ( (LA3_0==19) ) {
                alt3=1;
            }
            else if ( (LA3_0==21) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:538:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:538:1: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:539:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:540:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:540:2: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_in_rule__JvmWildcardTypeReference__Alternatives_21082);
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:544:6: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:544:6: ( ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:545:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsAssignment_2_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:546:1: ( rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:546:2: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_in_rule__JvmWildcardTypeReference__Alternatives_21100);
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


    // $ANTLR start "rule__XImportDeclaration1__Alternatives_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:555:1: rule__XImportDeclaration1__Alternatives_1 : ( ( ( rule__XImportDeclaration1__Group_1_0__0 ) ) | ( ( rule__XImportDeclaration1__Group_1_1__0 ) ) );
    public final void rule__XImportDeclaration1__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:559:1: ( ( ( rule__XImportDeclaration1__Group_1_0__0 ) ) | ( ( rule__XImportDeclaration1__Group_1_1__0 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID||LA4_0==25) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:560:1: ( ( rule__XImportDeclaration1__Group_1_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:560:1: ( ( rule__XImportDeclaration1__Group_1_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:561:1: ( rule__XImportDeclaration1__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getGroup_1_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:562:1: ( rule__XImportDeclaration1__Group_1_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:562:2: rule__XImportDeclaration1__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__0_in_rule__XImportDeclaration1__Alternatives_11133);
                    rule__XImportDeclaration1__Group_1_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getGroup_1_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:566:6: ( ( rule__XImportDeclaration1__Group_1_1__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:566:6: ( ( rule__XImportDeclaration1__Group_1_1__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:567:1: ( rule__XImportDeclaration1__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getGroup_1_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:1: ( rule__XImportDeclaration1__Group_1_1__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:2: rule__XImportDeclaration1__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__0_in_rule__XImportDeclaration1__Alternatives_11151);
                    rule__XImportDeclaration1__Group_1_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getGroup_1_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Alternatives_1"


    // $ANTLR start "rule__XImportDeclaration1__Alternatives_1_0_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:577:1: rule__XImportDeclaration1__Alternatives_1_0_0 : ( ( ( rule__XImportDeclaration1__Group_1_0_0_0__0 ) ) | ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 ) ) );
    public final void rule__XImportDeclaration1__Alternatives_1_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:581:1: ( ( ( rule__XImportDeclaration1__Group_1_0_0_0__0 ) ) | ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==25) ) {
                alt5=1;
            }
            else if ( (LA5_0==RULE_ID) ) {
                alt5=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:582:1: ( ( rule__XImportDeclaration1__Group_1_0_0_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:582:1: ( ( rule__XImportDeclaration1__Group_1_0_0_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:583:1: ( rule__XImportDeclaration1__Group_1_0_0_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getGroup_1_0_0_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:584:1: ( rule__XImportDeclaration1__Group_1_0_0_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:584:2: rule__XImportDeclaration1__Group_1_0_0_0__0
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__0_in_rule__XImportDeclaration1__Alternatives_1_0_01184);
                    rule__XImportDeclaration1__Group_1_0_0_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getGroup_1_0_0_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:588:6: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:588:6: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:589:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:590:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:590:2: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1_in_rule__XImportDeclaration1__Alternatives_1_0_01202);
                    rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Alternatives_1_0_0"


    // $ANTLR start "rule__XExportDeclaration__Alternatives_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:599:1: rule__XExportDeclaration__Alternatives_1 : ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) );
    public final void rule__XExportDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:603:1: ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) )
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==25) ) {
                alt6=1;
            }
            else if ( (LA6_0==24) ) {
                alt6=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return ;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }
            switch (alt6) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:604:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:604:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:605:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:606:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:606:2: rule__XExportDeclaration__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11235);
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:610:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:610:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:611:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:612:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:612:2: rule__XExportDeclaration__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11253);
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


    // $ANTLR start "rule__JvmTypeReference__Group_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:623:1: rule__JvmTypeReference__Group_0__0 : rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 ;
    public final void rule__JvmTypeReference__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:627:1: ( rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:628:2: rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__0__Impl_in_rule__JvmTypeReference__Group_0__01284);
            rule__JvmTypeReference__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__1_in_rule__JvmTypeReference__Group_0__01287);
            rule__JvmTypeReference__Group_0__1();

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
    // $ANTLR end "rule__JvmTypeReference__Group_0__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:635:1: rule__JvmTypeReference__Group_0__0__Impl : ( ruleJvmParameterizedTypeReference ) ;
    public final void rule__JvmTypeReference__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:639:1: ( ( ruleJvmParameterizedTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:640:1: ( ruleJvmParameterizedTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:640:1: ( ruleJvmParameterizedTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:641:1: ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group_0__0__Impl1314);
            ruleJvmParameterizedTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:652:1: rule__JvmTypeReference__Group_0__1 : rule__JvmTypeReference__Group_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:656:1: ( rule__JvmTypeReference__Group_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:657:2: rule__JvmTypeReference__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__1__Impl_in_rule__JvmTypeReference__Group_0__11343);
            rule__JvmTypeReference__Group_0__1__Impl();

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
    // $ANTLR end "rule__JvmTypeReference__Group_0__1"


    // $ANTLR start "rule__JvmTypeReference__Group_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:663:1: rule__JvmTypeReference__Group_0__1__Impl : ( ( rule__JvmTypeReference__Group_0_1__0 )* ) ;
    public final void rule__JvmTypeReference__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:667:1: ( ( ( rule__JvmTypeReference__Group_0_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:668:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:668:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:669:1: ( rule__JvmTypeReference__Group_0_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:670:1: ( rule__JvmTypeReference__Group_0_1__0 )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( (LA7_0==10) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:670:2: rule__JvmTypeReference__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1__0_in_rule__JvmTypeReference__Group_0__1__Impl1370);
            	    rule__JvmTypeReference__Group_0_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0__1__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:684:1: rule__JvmTypeReference__Group_0_1__0 : rule__JvmTypeReference__Group_0_1__0__Impl ;
    public final void rule__JvmTypeReference__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:688:1: ( rule__JvmTypeReference__Group_0_1__0__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:689:2: rule__JvmTypeReference__Group_0_1__0__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1__0__Impl_in_rule__JvmTypeReference__Group_0_1__01405);
            rule__JvmTypeReference__Group_0_1__0__Impl();

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:695:1: rule__JvmTypeReference__Group_0_1__0__Impl : ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) ;
    public final void rule__JvmTypeReference__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:699:1: ( ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:700:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:700:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:701:1: ( rule__JvmTypeReference__Group_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:702:1: ( rule__JvmTypeReference__Group_0_1_0__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:702:2: rule__JvmTypeReference__Group_0_1_0__0
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__0_in_rule__JvmTypeReference__Group_0_1__0__Impl1432);
            rule__JvmTypeReference__Group_0_1_0__0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:714:1: rule__JvmTypeReference__Group_0_1_0__0 : rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 ;
    public final void rule__JvmTypeReference__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:718:1: ( rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:719:2: rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__0__Impl_in_rule__JvmTypeReference__Group_0_1_0__01464);
            rule__JvmTypeReference__Group_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__1_in_rule__JvmTypeReference__Group_0_1_0__01467);
            rule__JvmTypeReference__Group_0_1_0__1();

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__0"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:726:1: rule__JvmTypeReference__Group_0_1_0__0__Impl : ( () ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:730:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:731:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:731:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:732:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:733:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:735:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__0__Impl"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:745:1: rule__JvmTypeReference__Group_0_1_0__1 : rule__JvmTypeReference__Group_0_1_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:749:1: ( rule__JvmTypeReference__Group_0_1_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:750:2: rule__JvmTypeReference__Group_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__1__Impl_in_rule__JvmTypeReference__Group_0_1_0__11525);
            rule__JvmTypeReference__Group_0_1_0__1__Impl();

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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__1"


    // $ANTLR start "rule__JvmTypeReference__Group_0_1_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:756:1: rule__JvmTypeReference__Group_0_1_0__1__Impl : ( ruleArrayBrackets ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:760:1: ( ( ruleArrayBrackets ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:761:1: ( ruleArrayBrackets )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:761:1: ( ruleArrayBrackets )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:762:1: ruleArrayBrackets
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_0_1_0__1__Impl1552);
            ruleArrayBrackets();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
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
    // $ANTLR end "rule__JvmTypeReference__Group_0_1_0__1__Impl"


    // $ANTLR start "rule__ArrayBrackets__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:777:1: rule__ArrayBrackets__Group__0 : rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 ;
    public final void rule__ArrayBrackets__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:781:1: ( rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:782:2: rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01585);
            rule__ArrayBrackets__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01588);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:789:1: rule__ArrayBrackets__Group__0__Impl : ( '[' ) ;
    public final void rule__ArrayBrackets__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:793:1: ( ( '[' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:794:1: ( '[' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:794:1: ( '[' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:795:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,10,FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1616); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:808:1: rule__ArrayBrackets__Group__1 : rule__ArrayBrackets__Group__1__Impl ;
    public final void rule__ArrayBrackets__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:812:1: ( rule__ArrayBrackets__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:813:2: rule__ArrayBrackets__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11647);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:819:1: rule__ArrayBrackets__Group__1__Impl : ( ']' ) ;
    public final void rule__ArrayBrackets__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:823:1: ( ( ']' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:824:1: ( ']' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:824:1: ( ']' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:825:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
            }
            match(input,11,FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1675); if (state.failed) return ;
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


    // $ANTLR start "rule__XFunctionTypeRef__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:842:1: rule__XFunctionTypeRef__Group__0 : rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 ;
    public final void rule__XFunctionTypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:846:1: ( rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:847:2: rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__0__Impl_in_rule__XFunctionTypeRef__Group__01710);
            rule__XFunctionTypeRef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__1_in_rule__XFunctionTypeRef__Group__01713);
            rule__XFunctionTypeRef__Group__1();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:854:1: rule__XFunctionTypeRef__Group__0__Impl : ( ( rule__XFunctionTypeRef__Group_0__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:858:1: ( ( ( rule__XFunctionTypeRef__Group_0__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:859:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:859:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:860:1: ( rule__XFunctionTypeRef__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:861:1: ( rule__XFunctionTypeRef__Group_0__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==13) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:861:2: rule__XFunctionTypeRef__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__0_in_rule__XFunctionTypeRef__Group__0__Impl1740);
                    rule__XFunctionTypeRef__Group_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:871:1: rule__XFunctionTypeRef__Group__1 : rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 ;
    public final void rule__XFunctionTypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:875:1: ( rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:876:2: rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__1__Impl_in_rule__XFunctionTypeRef__Group__11771);
            rule__XFunctionTypeRef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__2_in_rule__XFunctionTypeRef__Group__11774);
            rule__XFunctionTypeRef__Group__2();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:883:1: rule__XFunctionTypeRef__Group__1__Impl : ( '=>' ) ;
    public final void rule__XFunctionTypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:887:1: ( ( '=>' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:888:1: ( '=>' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:888:1: ( '=>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:889:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            }
            match(input,12,FOLLOW_12_in_rule__XFunctionTypeRef__Group__1__Impl1802); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:902:1: rule__XFunctionTypeRef__Group__2 : rule__XFunctionTypeRef__Group__2__Impl ;
    public final void rule__XFunctionTypeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:906:1: ( rule__XFunctionTypeRef__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:907:2: rule__XFunctionTypeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__2__Impl_in_rule__XFunctionTypeRef__Group__21833);
            rule__XFunctionTypeRef__Group__2__Impl();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group__2"


    // $ANTLR start "rule__XFunctionTypeRef__Group__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:913:1: rule__XFunctionTypeRef__Group__2__Impl : ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) ;
    public final void rule__XFunctionTypeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:917:1: ( ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:918:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:918:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:919:1: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:920:1: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:920:2: rule__XFunctionTypeRef__ReturnTypeAssignment_2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ReturnTypeAssignment_2_in_rule__XFunctionTypeRef__Group__2__Impl1860);
            rule__XFunctionTypeRef__ReturnTypeAssignment_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group__2__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:936:1: rule__XFunctionTypeRef__Group_0__0 : rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 ;
    public final void rule__XFunctionTypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:940:1: ( rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:941:2: rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__0__Impl_in_rule__XFunctionTypeRef__Group_0__01896);
            rule__XFunctionTypeRef__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__1_in_rule__XFunctionTypeRef__Group_0__01899);
            rule__XFunctionTypeRef__Group_0__1();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:948:1: rule__XFunctionTypeRef__Group_0__0__Impl : ( '(' ) ;
    public final void rule__XFunctionTypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:952:1: ( ( '(' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:953:1: ( '(' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:953:1: ( '(' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:954:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,13,FOLLOW_13_in_rule__XFunctionTypeRef__Group_0__0__Impl1927); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:967:1: rule__XFunctionTypeRef__Group_0__1 : rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 ;
    public final void rule__XFunctionTypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:971:1: ( rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:972:2: rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__1__Impl_in_rule__XFunctionTypeRef__Group_0__11958);
            rule__XFunctionTypeRef__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__2_in_rule__XFunctionTypeRef__Group_0__11961);
            rule__XFunctionTypeRef__Group_0__2();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:979:1: rule__XFunctionTypeRef__Group_0__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:983:1: ( ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:984:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:984:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:985:1: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:986:1: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID||(LA9_0>=12 && LA9_0<=13)) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:986:2: rule__XFunctionTypeRef__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__0_in_rule__XFunctionTypeRef__Group_0__1__Impl1988);
                    rule__XFunctionTypeRef__Group_0_1__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }
                    break;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:996:1: rule__XFunctionTypeRef__Group_0__2 : rule__XFunctionTypeRef__Group_0__2__Impl ;
    public final void rule__XFunctionTypeRef__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1000:1: ( rule__XFunctionTypeRef__Group_0__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1001:2: rule__XFunctionTypeRef__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__2__Impl_in_rule__XFunctionTypeRef__Group_0__22019);
            rule__XFunctionTypeRef__Group_0__2__Impl();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__2"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1007:1: rule__XFunctionTypeRef__Group_0__2__Impl : ( ')' ) ;
    public final void rule__XFunctionTypeRef__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1011:1: ( ( ')' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1012:1: ( ')' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1012:1: ( ')' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1013:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,14,FOLLOW_14_in_rule__XFunctionTypeRef__Group_0__2__Impl2047); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0__2__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1032:1: rule__XFunctionTypeRef__Group_0_1__0 : rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1036:1: ( rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1037:2: rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1__02084);
            rule__XFunctionTypeRef__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__1_in_rule__XFunctionTypeRef__Group_0_1__02087);
            rule__XFunctionTypeRef__Group_0_1__1();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1044:1: rule__XFunctionTypeRef__Group_0_1__0__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1048:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1049:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1049:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1050:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1051:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1051:2: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0_in_rule__XFunctionTypeRef__Group_0_1__0__Impl2114);
            rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1061:1: rule__XFunctionTypeRef__Group_0_1__1 : rule__XFunctionTypeRef__Group_0_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1065:1: ( rule__XFunctionTypeRef__Group_0_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1066:2: rule__XFunctionTypeRef__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1__12144);
            rule__XFunctionTypeRef__Group_0_1__1__Impl();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1072:1: rule__XFunctionTypeRef__Group_0_1__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1076:1: ( ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1077:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1077:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1078:1: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1079:1: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( (LA10_0==15) ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1079:2: rule__XFunctionTypeRef__Group_0_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0_in_rule__XFunctionTypeRef__Group_0_1__1__Impl2171);
            	    rule__XFunctionTypeRef__Group_0_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop10;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1__1__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1093:1: rule__XFunctionTypeRef__Group_0_1_1__0 : rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1097:1: ( rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1098:2: rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__02206);
            rule__XFunctionTypeRef__Group_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1_in_rule__XFunctionTypeRef__Group_0_1_1__02209);
            rule__XFunctionTypeRef__Group_0_1_1__1();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__0"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1105:1: rule__XFunctionTypeRef__Group_0_1_1__0__Impl : ( ',' ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1109:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1110:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1110:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1111:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XFunctionTypeRef__Group_0_1_1__0__Impl2237); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__0__Impl"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1124:1: rule__XFunctionTypeRef__Group_0_1_1__1 : rule__XFunctionTypeRef__Group_0_1_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1128:1: ( rule__XFunctionTypeRef__Group_0_1_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1129:2: rule__XFunctionTypeRef__Group_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__12268);
            rule__XFunctionTypeRef__Group_0_1_1__1__Impl();

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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__1"


    // $ANTLR start "rule__XFunctionTypeRef__Group_0_1_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1135:1: rule__XFunctionTypeRef__Group_0_1_1__1__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1139:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1140:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1140:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1141:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1142:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1142:2: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1_in_rule__XFunctionTypeRef__Group_0_1_1__1__Impl2295);
            rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__Group_0_1_1__1__Impl"


    // $ANTLR start "rule__JvmParameterizedTypeReference__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1156:1: rule__JvmParameterizedTypeReference__Group__0 : rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 ;
    public final void rule__JvmParameterizedTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1160:1: ( rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1161:2: rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__02329);
            rule__JvmParameterizedTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__02332);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1168:1: rule__JvmParameterizedTypeReference__Group__0__Impl : ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1172:1: ( ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1173:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1173:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1174:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1175:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1175:2: rule__JvmParameterizedTypeReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl2359);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1185:1: rule__JvmParameterizedTypeReference__Group__1 : rule__JvmParameterizedTypeReference__Group__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1189:1: ( rule__JvmParameterizedTypeReference__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1190:2: rule__JvmParameterizedTypeReference__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__12389);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1196:1: rule__JvmParameterizedTypeReference__Group__1__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) ;
    public final void rule__JvmParameterizedTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1200:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1201:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1201:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1202:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1203:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==16) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1203:2: rule__JvmParameterizedTypeReference__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl2416);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1217:1: rule__JvmParameterizedTypeReference__Group_1__0 : rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1221:1: ( rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1222:2: rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__02451);
            rule__JvmParameterizedTypeReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__02454);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1229:1: rule__JvmParameterizedTypeReference__Group_1__0__Impl : ( ( '<' ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1233:1: ( ( ( '<' ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1234:1: ( ( '<' ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1234:1: ( ( '<' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1235:1: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1236:1: ( '<' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1237:2: '<'
            {
            match(input,16,FOLLOW_16_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl2483); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1248:1: rule__JvmParameterizedTypeReference__Group_1__1 : rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1252:1: ( rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1253:2: rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__12515);
            rule__JvmParameterizedTypeReference__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__12518);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1260:1: rule__JvmParameterizedTypeReference__Group_1__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1264:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1265:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1265:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1266:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1267:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1267:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl2545);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1277:1: rule__JvmParameterizedTypeReference__Group_1__2 : rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1281:1: ( rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1282:2: rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__22575);
            rule__JvmParameterizedTypeReference__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__22578);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1289:1: rule__JvmParameterizedTypeReference__Group_1__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1293:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1294:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1294:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1295:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1296:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            loop12:
            do {
                int alt12=2;
                int LA12_0 = input.LA(1);

                if ( (LA12_0==15) ) {
                    alt12=1;
                }


                switch (alt12) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1296:2: rule__JvmParameterizedTypeReference__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl2605);
            	    rule__JvmParameterizedTypeReference__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop12;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1306:1: rule__JvmParameterizedTypeReference__Group_1__3 : rule__JvmParameterizedTypeReference__Group_1__3__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1310:1: ( rule__JvmParameterizedTypeReference__Group_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1311:2: rule__JvmParameterizedTypeReference__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__32636);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1317:1: rule__JvmParameterizedTypeReference__Group_1__3__Impl : ( '>' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1321:1: ( ( '>' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1322:1: ( '>' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1322:1: ( '>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1323:1: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,17,FOLLOW_17_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl2664); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1344:1: rule__JvmParameterizedTypeReference__Group_1_2__0 : rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1348:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1349:2: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__02703);
            rule__JvmParameterizedTypeReference__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__02706);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1356:1: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1360:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1361:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1361:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1362:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl2734); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1375:1: rule__JvmParameterizedTypeReference__Group_1_2__1 : rule__JvmParameterizedTypeReference__Group_1_2__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1379:1: ( rule__JvmParameterizedTypeReference__Group_1_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1380:2: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__12765);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1386:1: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1390:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1391:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1391:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1392:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1393:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1393:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2792);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1407:1: rule__JvmWildcardTypeReference__Group__0 : rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 ;
    public final void rule__JvmWildcardTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1411:1: ( rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1412:2: rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02826);
            rule__JvmWildcardTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02829);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1419:1: rule__JvmWildcardTypeReference__Group__0__Impl : ( () ) ;
    public final void rule__JvmWildcardTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1423:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1424:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1424:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1425:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1426:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1428:1: 
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1438:1: rule__JvmWildcardTypeReference__Group__1 : rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 ;
    public final void rule__JvmWildcardTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1442:1: ( rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1443:2: rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12887);
            rule__JvmWildcardTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12890);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1450:1: rule__JvmWildcardTypeReference__Group__1__Impl : ( '?' ) ;
    public final void rule__JvmWildcardTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1454:1: ( ( '?' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1455:1: ( '?' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1455:1: ( '?' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1456:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__JvmWildcardTypeReference__Group__1__Impl2918); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1469:1: rule__JvmWildcardTypeReference__Group__2 : rule__JvmWildcardTypeReference__Group__2__Impl ;
    public final void rule__JvmWildcardTypeReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1473:1: ( rule__JvmWildcardTypeReference__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1474:2: rule__JvmWildcardTypeReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22949);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1480:1: rule__JvmWildcardTypeReference__Group__2__Impl : ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) ;
    public final void rule__JvmWildcardTypeReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1484:1: ( ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1485:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1485:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1486:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1487:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==19||LA13_0==21) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1487:2: rule__JvmWildcardTypeReference__Alternatives_2
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2976);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1503:1: rule__JvmUpperBound__Group__0 : rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 ;
    public final void rule__JvmUpperBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1507:1: ( rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1508:2: rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__03013);
            rule__JvmUpperBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__03016);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1515:1: rule__JvmUpperBound__Group__0__Impl : ( 'extends' ) ;
    public final void rule__JvmUpperBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1519:1: ( ( 'extends' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1520:1: ( 'extends' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1520:1: ( 'extends' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1521:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__JvmUpperBound__Group__0__Impl3044); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1534:1: rule__JvmUpperBound__Group__1 : rule__JvmUpperBound__Group__1__Impl ;
    public final void rule__JvmUpperBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1538:1: ( rule__JvmUpperBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1539:2: rule__JvmUpperBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__13075);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1545:1: rule__JvmUpperBound__Group__1__Impl : ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1549:1: ( ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1550:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1550:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1551:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1552:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1552:2: rule__JvmUpperBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl3102);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1566:1: rule__JvmUpperBoundAnded__Group__0 : rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 ;
    public final void rule__JvmUpperBoundAnded__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1570:1: ( rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1571:2: rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__03136);
            rule__JvmUpperBoundAnded__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__03139);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1578:1: rule__JvmUpperBoundAnded__Group__0__Impl : ( '&' ) ;
    public final void rule__JvmUpperBoundAnded__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1582:1: ( ( '&' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1583:1: ( '&' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1583:1: ( '&' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1584:1: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__JvmUpperBoundAnded__Group__0__Impl3167); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1597:1: rule__JvmUpperBoundAnded__Group__1 : rule__JvmUpperBoundAnded__Group__1__Impl ;
    public final void rule__JvmUpperBoundAnded__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1601:1: ( rule__JvmUpperBoundAnded__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1602:2: rule__JvmUpperBoundAnded__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__13198);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1608:1: rule__JvmUpperBoundAnded__Group__1__Impl : ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBoundAnded__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1612:1: ( ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1613:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1613:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1614:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1615:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1615:2: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl3225);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1629:1: rule__JvmLowerBound__Group__0 : rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 ;
    public final void rule__JvmLowerBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1633:1: ( rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1634:2: rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__03259);
            rule__JvmLowerBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__03262);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1641:1: rule__JvmLowerBound__Group__0__Impl : ( 'super' ) ;
    public final void rule__JvmLowerBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1645:1: ( ( 'super' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1646:1: ( 'super' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1646:1: ( 'super' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1647:1: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__JvmLowerBound__Group__0__Impl3290); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1660:1: rule__JvmLowerBound__Group__1 : rule__JvmLowerBound__Group__1__Impl ;
    public final void rule__JvmLowerBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1664:1: ( rule__JvmLowerBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1665:2: rule__JvmLowerBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__13321);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1671:1: rule__JvmLowerBound__Group__1__Impl : ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmLowerBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1675:1: ( ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1676:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1676:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1677:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1678:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1678:2: rule__JvmLowerBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl3348);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1694:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1698:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1699:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03384);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03387);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1706:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1710:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1711:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1711:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1712:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl3414);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1723:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1727:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1728:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13443);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1734:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1738:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1739:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1739:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1740:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1741:1: ( rule__QualifiedName__Group_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==22) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1741:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3470);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1755:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1759:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1760:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03505);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03508);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1767:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1771:1: ( ( '.' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1772:1: ( '.' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1772:1: ( '.' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1773:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl3536); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1786:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1790:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1791:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13567);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1797:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1801:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1802:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1802:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1803:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3594);
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


    // $ANTLR start "rule__XImportDeclaration1__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1820:1: rule__XImportDeclaration1__Group__0 : rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1 ;
    public final void rule__XImportDeclaration1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1824:1: ( rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1825:2: rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__0__Impl_in_rule__XImportDeclaration1__Group__03629);
            rule__XImportDeclaration1__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__1_in_rule__XImportDeclaration1__Group__03632);
            rule__XImportDeclaration1__Group__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__0"


    // $ANTLR start "rule__XImportDeclaration1__Group__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1832:1: rule__XImportDeclaration1__Group__0__Impl : ( 'import' ) ;
    public final void rule__XImportDeclaration1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1836:1: ( ( 'import' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1837:1: ( 'import' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1837:1: ( 'import' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1838:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportKeyword_0()); 
            }
            match(input,23,FOLLOW_23_in_rule__XImportDeclaration1__Group__0__Impl3660); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportKeyword_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1851:1: rule__XImportDeclaration1__Group__1 : rule__XImportDeclaration1__Group__1__Impl ;
    public final void rule__XImportDeclaration1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1855:1: ( rule__XImportDeclaration1__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1856:2: rule__XImportDeclaration1__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__1__Impl_in_rule__XImportDeclaration1__Group__13691);
            rule__XImportDeclaration1__Group__1__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__1"


    // $ANTLR start "rule__XImportDeclaration1__Group__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1862:1: rule__XImportDeclaration1__Group__1__Impl : ( ( rule__XImportDeclaration1__Alternatives_1 ) ) ;
    public final void rule__XImportDeclaration1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1866:1: ( ( ( rule__XImportDeclaration1__Alternatives_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1867:1: ( ( rule__XImportDeclaration1__Alternatives_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1867:1: ( ( rule__XImportDeclaration1__Alternatives_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1868:1: ( rule__XImportDeclaration1__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAlternatives_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1869:1: ( rule__XImportDeclaration1__Alternatives_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1869:2: rule__XImportDeclaration1__Alternatives_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Alternatives_1_in_rule__XImportDeclaration1__Group__1__Impl3718);
            rule__XImportDeclaration1__Alternatives_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAlternatives_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1883:1: rule__XImportDeclaration1__Group_1_0__0 : rule__XImportDeclaration1__Group_1_0__0__Impl rule__XImportDeclaration1__Group_1_0__1 ;
    public final void rule__XImportDeclaration1__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1887:1: ( rule__XImportDeclaration1__Group_1_0__0__Impl rule__XImportDeclaration1__Group_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1888:2: rule__XImportDeclaration1__Group_1_0__0__Impl rule__XImportDeclaration1__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__0__Impl_in_rule__XImportDeclaration1__Group_1_0__03752);
            rule__XImportDeclaration1__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__1_in_rule__XImportDeclaration1__Group_1_0__03755);
            rule__XImportDeclaration1__Group_1_0__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1895:1: rule__XImportDeclaration1__Group_1_0__0__Impl : ( ( rule__XImportDeclaration1__Alternatives_1_0_0 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1899:1: ( ( ( rule__XImportDeclaration1__Alternatives_1_0_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1900:1: ( ( rule__XImportDeclaration1__Alternatives_1_0_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1900:1: ( ( rule__XImportDeclaration1__Alternatives_1_0_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1901:1: ( rule__XImportDeclaration1__Alternatives_1_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAlternatives_1_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1902:1: ( rule__XImportDeclaration1__Alternatives_1_0_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1902:2: rule__XImportDeclaration1__Alternatives_1_0_0
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Alternatives_1_0_0_in_rule__XImportDeclaration1__Group_1_0__0__Impl3782);
            rule__XImportDeclaration1__Alternatives_1_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAlternatives_1_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1912:1: rule__XImportDeclaration1__Group_1_0__1 : rule__XImportDeclaration1__Group_1_0__1__Impl rule__XImportDeclaration1__Group_1_0__2 ;
    public final void rule__XImportDeclaration1__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1916:1: ( rule__XImportDeclaration1__Group_1_0__1__Impl rule__XImportDeclaration1__Group_1_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1917:2: rule__XImportDeclaration1__Group_1_0__1__Impl rule__XImportDeclaration1__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__1__Impl_in_rule__XImportDeclaration1__Group_1_0__13812);
            rule__XImportDeclaration1__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__2_in_rule__XImportDeclaration1__Group_1_0__13815);
            rule__XImportDeclaration1__Group_1_0__2();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1924:1: rule__XImportDeclaration1__Group_1_0__1__Impl : ( 'from' ) ;
    public final void rule__XImportDeclaration1__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1928:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1929:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1929:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1930:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_0_1()); 
            }
            match(input,24,FOLLOW_24_in_rule__XImportDeclaration1__Group_1_0__1__Impl3843); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_0_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1943:1: rule__XImportDeclaration1__Group_1_0__2 : rule__XImportDeclaration1__Group_1_0__2__Impl ;
    public final void rule__XImportDeclaration1__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1947:1: ( rule__XImportDeclaration1__Group_1_0__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1948:2: rule__XImportDeclaration1__Group_1_0__2__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0__2__Impl_in_rule__XImportDeclaration1__Group_1_0__23874);
            rule__XImportDeclaration1__Group_1_0__2__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__2"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1954:1: rule__XImportDeclaration1__Group_1_0__2__Impl : ( ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1958:1: ( ( ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1959:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1959:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1960:1: ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_1_0_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1961:1: ( rule__XImportDeclaration1__ImportURIAssignment_1_0_2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1961:2: rule__XImportDeclaration1__ImportURIAssignment_1_0_2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_1_0_2_in_rule__XImportDeclaration1__Group_1_0__2__Impl3901);
            rule__XImportDeclaration1__ImportURIAssignment_1_0_2();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_1_0_2()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0__2__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1977:1: rule__XImportDeclaration1__Group_1_0_0_0__0 : rule__XImportDeclaration1__Group_1_0_0_0__0__Impl rule__XImportDeclaration1__Group_1_0_0_0__1 ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1981:1: ( rule__XImportDeclaration1__Group_1_0_0_0__0__Impl rule__XImportDeclaration1__Group_1_0_0_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1982:2: rule__XImportDeclaration1__Group_1_0_0_0__0__Impl rule__XImportDeclaration1__Group_1_0_0_0__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__0__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__03937);
            rule__XImportDeclaration1__Group_1_0_0_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__1_in_rule__XImportDeclaration1__Group_1_0_0_0__03940);
            rule__XImportDeclaration1__Group_1_0_0_0__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1989:1: rule__XImportDeclaration1__Group_1_0_0_0__0__Impl : ( '{' ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1993:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1994:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1994:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1995:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_1_0_0_0_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__XImportDeclaration1__Group_1_0_0_0__0__Impl3968); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_1_0_0_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2008:1: rule__XImportDeclaration1__Group_1_0_0_0__1 : rule__XImportDeclaration1__Group_1_0_0_0__1__Impl rule__XImportDeclaration1__Group_1_0_0_0__2 ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2012:1: ( rule__XImportDeclaration1__Group_1_0_0_0__1__Impl rule__XImportDeclaration1__Group_1_0_0_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2013:2: rule__XImportDeclaration1__Group_1_0_0_0__1__Impl rule__XImportDeclaration1__Group_1_0_0_0__2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__1__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__13999);
            rule__XImportDeclaration1__Group_1_0_0_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__2_in_rule__XImportDeclaration1__Group_1_0_0_0__14002);
            rule__XImportDeclaration1__Group_1_0_0_0__2();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2020:1: rule__XImportDeclaration1__Group_1_0_0_0__1__Impl : ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2024:1: ( ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2025:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2025:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2026:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2027:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2027:2: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1_in_rule__XImportDeclaration1__Group_1_0_0_0__1__Impl4029);
            rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_0_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2037:1: rule__XImportDeclaration1__Group_1_0_0_0__2 : rule__XImportDeclaration1__Group_1_0_0_0__2__Impl rule__XImportDeclaration1__Group_1_0_0_0__3 ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2041:1: ( rule__XImportDeclaration1__Group_1_0_0_0__2__Impl rule__XImportDeclaration1__Group_1_0_0_0__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2042:2: rule__XImportDeclaration1__Group_1_0_0_0__2__Impl rule__XImportDeclaration1__Group_1_0_0_0__3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__2__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__24059);
            rule__XImportDeclaration1__Group_1_0_0_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__3_in_rule__XImportDeclaration1__Group_1_0_0_0__24062);
            rule__XImportDeclaration1__Group_1_0_0_0__3();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__2"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2049:1: rule__XImportDeclaration1__Group_1_0_0_0__2__Impl : ( ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )* ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2053:1: ( ( ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2054:1: ( ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2054:1: ( ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2055:1: ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getGroup_1_0_0_0_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2056:1: ( rule__XImportDeclaration1__Group_1_0_0_0_2__0 )*
            loop15:
            do {
                int alt15=2;
                int LA15_0 = input.LA(1);

                if ( (LA15_0==15) ) {
                    alt15=1;
                }


                switch (alt15) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2056:2: rule__XImportDeclaration1__Group_1_0_0_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__0_in_rule__XImportDeclaration1__Group_1_0_0_0__2__Impl4089);
            	    rule__XImportDeclaration1__Group_1_0_0_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop15;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getGroup_1_0_0_0_2()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__2__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2066:1: rule__XImportDeclaration1__Group_1_0_0_0__3 : rule__XImportDeclaration1__Group_1_0_0_0__3__Impl ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2070:1: ( rule__XImportDeclaration1__Group_1_0_0_0__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2071:2: rule__XImportDeclaration1__Group_1_0_0_0__3__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__3__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__34120);
            rule__XImportDeclaration1__Group_1_0_0_0__3__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__3"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2077:1: rule__XImportDeclaration1__Group_1_0_0_0__3__Impl : ( '}' ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2081:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2082:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2082:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2083:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_1_0_0_0_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__XImportDeclaration1__Group_1_0_0_0__3__Impl4148); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_1_0_0_0_3()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0__3__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0_2__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2104:1: rule__XImportDeclaration1__Group_1_0_0_0_2__0 : rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl rule__XImportDeclaration1__Group_1_0_0_0_2__1 ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2108:1: ( rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl rule__XImportDeclaration1__Group_1_0_0_0_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2109:2: rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl rule__XImportDeclaration1__Group_1_0_0_0_2__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0_2__04187);
            rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__1_in_rule__XImportDeclaration1__Group_1_0_0_0_2__04190);
            rule__XImportDeclaration1__Group_1_0_0_0_2__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0_2__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2116:1: rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl : ( ',' ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2120:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2121:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2121:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2122:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getCommaKeyword_1_0_0_0_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl4218); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getCommaKeyword_1_0_0_0_2_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0_2__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2135:1: rule__XImportDeclaration1__Group_1_0_0_0_2__1 : rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2139:1: ( rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2140:2: rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0_2__14249);
            rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0_2__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2146:1: rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl : ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2150:1: ( ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2151:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2151:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2152:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_0_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2153:1: ( rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2153:2: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1_in_rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl4276);
            rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_1_0_0_0_2_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2167:1: rule__XImportDeclaration1__Group_1_1__0 : rule__XImportDeclaration1__Group_1_1__0__Impl rule__XImportDeclaration1__Group_1_1__1 ;
    public final void rule__XImportDeclaration1__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2171:1: ( rule__XImportDeclaration1__Group_1_1__0__Impl rule__XImportDeclaration1__Group_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2172:2: rule__XImportDeclaration1__Group_1_1__0__Impl rule__XImportDeclaration1__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__0__Impl_in_rule__XImportDeclaration1__Group_1_1__04310);
            rule__XImportDeclaration1__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__1_in_rule__XImportDeclaration1__Group_1_1__04313);
            rule__XImportDeclaration1__Group_1_1__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2179:1: rule__XImportDeclaration1__Group_1_1__0__Impl : ( 'from' ) ;
    public final void rule__XImportDeclaration1__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2183:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2184:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2184:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2185:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_1_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XImportDeclaration1__Group_1_1__0__Impl4341); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getFromKeyword_1_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2198:1: rule__XImportDeclaration1__Group_1_1__1 : rule__XImportDeclaration1__Group_1_1__1__Impl rule__XImportDeclaration1__Group_1_1__2 ;
    public final void rule__XImportDeclaration1__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2202:1: ( rule__XImportDeclaration1__Group_1_1__1__Impl rule__XImportDeclaration1__Group_1_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2203:2: rule__XImportDeclaration1__Group_1_1__1__Impl rule__XImportDeclaration1__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__1__Impl_in_rule__XImportDeclaration1__Group_1_1__14372);
            rule__XImportDeclaration1__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__2_in_rule__XImportDeclaration1__Group_1_1__14375);
            rule__XImportDeclaration1__Group_1_1__2();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2210:1: rule__XImportDeclaration1__Group_1_1__1__Impl : ( ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2214:1: ( ( ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2215:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2215:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2216:1: ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2217:1: ( rule__XImportDeclaration1__ImportURIAssignment_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2217:2: rule__XImportDeclaration1__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_1_1_1_in_rule__XImportDeclaration1__Group_1_1__1__Impl4402);
            rule__XImportDeclaration1__ImportURIAssignment_1_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_1_1_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2227:1: rule__XImportDeclaration1__Group_1_1__2 : rule__XImportDeclaration1__Group_1_1__2__Impl rule__XImportDeclaration1__Group_1_1__3 ;
    public final void rule__XImportDeclaration1__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2231:1: ( rule__XImportDeclaration1__Group_1_1__2__Impl rule__XImportDeclaration1__Group_1_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2232:2: rule__XImportDeclaration1__Group_1_1__2__Impl rule__XImportDeclaration1__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__2__Impl_in_rule__XImportDeclaration1__Group_1_1__24432);
            rule__XImportDeclaration1__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__3_in_rule__XImportDeclaration1__Group_1_1__24435);
            rule__XImportDeclaration1__Group_1_1__3();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__2"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2239:1: rule__XImportDeclaration1__Group_1_1__2__Impl : ( 'as' ) ;
    public final void rule__XImportDeclaration1__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2243:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2244:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2244:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2245:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAsKeyword_1_1_2()); 
            }
            match(input,27,FOLLOW_27_in_rule__XImportDeclaration1__Group_1_1__2__Impl4463); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAsKeyword_1_1_2()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__2__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2258:1: rule__XImportDeclaration1__Group_1_1__3 : rule__XImportDeclaration1__Group_1_1__3__Impl ;
    public final void rule__XImportDeclaration1__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2262:1: ( rule__XImportDeclaration1__Group_1_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2263:2: rule__XImportDeclaration1__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_1_1__3__Impl_in_rule__XImportDeclaration1__Group_1_1__34494);
            rule__XImportDeclaration1__Group_1_1__3__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__3"


    // $ANTLR start "rule__XImportDeclaration1__Group_1_1__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2269:1: rule__XImportDeclaration1__Group_1_1__3__Impl : ( ( rule__XImportDeclaration1__AliasAssignment_1_1_3 ) ) ;
    public final void rule__XImportDeclaration1__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2273:1: ( ( ( rule__XImportDeclaration1__AliasAssignment_1_1_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2274:1: ( ( rule__XImportDeclaration1__AliasAssignment_1_1_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2274:1: ( ( rule__XImportDeclaration1__AliasAssignment_1_1_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2275:1: ( rule__XImportDeclaration1__AliasAssignment_1_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAliasAssignment_1_1_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2276:1: ( rule__XImportDeclaration1__AliasAssignment_1_1_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2276:2: rule__XImportDeclaration1__AliasAssignment_1_1_3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__AliasAssignment_1_1_3_in_rule__XImportDeclaration1__Group_1_1__3__Impl4521);
            rule__XImportDeclaration1__AliasAssignment_1_1_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAliasAssignment_1_1_3()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_1_1__3__Impl"


    // $ANTLR start "rule__XImportItem__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2294:1: rule__XImportItem__Group__0 : rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 ;
    public final void rule__XImportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2298:1: ( rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2299:2: rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__04559);
            rule__XImportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__04562);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2306:1: rule__XImportItem__Group__0__Impl : ( () ) ;
    public final void rule__XImportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2310:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2311:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2311:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2312:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getXImportItemAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2313:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2315:1: 
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2325:1: rule__XImportItem__Group__1 : rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 ;
    public final void rule__XImportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2329:1: ( rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2330:2: rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__14620);
            rule__XImportItem__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__14623);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2337:1: rule__XImportItem__Group__1__Impl : ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) ;
    public final void rule__XImportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2341:1: ( ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2342:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2342:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2343:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2344:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2344:2: rule__XImportItem__ImportedIdAssignment_1
            {
            pushFollow(FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl4650);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2354:1: rule__XImportItem__Group__2 : rule__XImportItem__Group__2__Impl ;
    public final void rule__XImportItem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2358:1: ( rule__XImportItem__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2359:2: rule__XImportItem__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__24680);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2365:1: rule__XImportItem__Group__2__Impl : ( ( rule__XImportItem__Group_2__0 )? ) ;
    public final void rule__XImportItem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2369:1: ( ( ( rule__XImportItem__Group_2__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2370:1: ( ( rule__XImportItem__Group_2__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2370:1: ( ( rule__XImportItem__Group_2__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2371:1: ( rule__XImportItem__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getGroup_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2372:1: ( rule__XImportItem__Group_2__0 )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==27) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2372:2: rule__XImportItem__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl4707);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2388:1: rule__XImportItem__Group_2__0 : rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 ;
    public final void rule__XImportItem__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2392:1: ( rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2393:2: rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__04744);
            rule__XImportItem__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__04747);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2400:1: rule__XImportItem__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__XImportItem__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2404:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2405:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2405:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2406:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAsKeyword_2_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__XImportItem__Group_2__0__Impl4775); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2419:1: rule__XImportItem__Group_2__1 : rule__XImportItem__Group_2__1__Impl ;
    public final void rule__XImportItem__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2423:1: ( rule__XImportItem__Group_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2424:2: rule__XImportItem__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__14806);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2430:1: rule__XImportItem__Group_2__1__Impl : ( ( rule__XImportItem__AliasAssignment_2_1 ) ) ;
    public final void rule__XImportItem__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2434:1: ( ( ( rule__XImportItem__AliasAssignment_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2435:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2435:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2436:1: ( rule__XImportItem__AliasAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasAssignment_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2437:1: ( rule__XImportItem__AliasAssignment_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2437:2: rule__XImportItem__AliasAssignment_2_1
            {
            pushFollow(FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl4833);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2452:1: rule__XExportDeclaration__Group__0 : rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 ;
    public final void rule__XExportDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2456:1: ( rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2457:2: rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__04868);
            rule__XExportDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__04871);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2464:1: rule__XExportDeclaration__Group__0__Impl : ( 'export' ) ;
    public final void rule__XExportDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2468:1: ( ( 'export' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2469:1: ( 'export' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2469:1: ( 'export' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2470:1: 'export'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__XExportDeclaration__Group__0__Impl4899); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2483:1: rule__XExportDeclaration__Group__1 : rule__XExportDeclaration__Group__1__Impl ;
    public final void rule__XExportDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2487:1: ( rule__XExportDeclaration__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2488:2: rule__XExportDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14930);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2494:1: rule__XExportDeclaration__Group__1__Impl : ( ( rule__XExportDeclaration__Alternatives_1 ) ) ;
    public final void rule__XExportDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2498:1: ( ( ( rule__XExportDeclaration__Alternatives_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2499:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2499:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2500:1: ( rule__XExportDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAlternatives_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2501:1: ( rule__XExportDeclaration__Alternatives_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2501:2: rule__XExportDeclaration__Alternatives_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4957);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2515:1: rule__XExportDeclaration__Group_1_0__0 : rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 ;
    public final void rule__XExportDeclaration__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2519:1: ( rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2520:2: rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04991);
            rule__XExportDeclaration__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04994);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2527:1: rule__XExportDeclaration__Group_1_0__0__Impl : ( '{' ) ;
    public final void rule__XExportDeclaration__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2531:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2532:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2532:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2533:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0()); 
            }
            match(input,25,FOLLOW_25_in_rule__XExportDeclaration__Group_1_0__0__Impl5022); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2546:1: rule__XExportDeclaration__Group_1_0__1 : rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 ;
    public final void rule__XExportDeclaration__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2550:1: ( rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2551:2: rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__15053);
            rule__XExportDeclaration__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__15056);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2558:1: rule__XExportDeclaration__Group_1_0__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2562:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2563:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2563:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2564:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2565:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2565:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl5083);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2575:1: rule__XExportDeclaration__Group_1_0__2 : rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 ;
    public final void rule__XExportDeclaration__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2579:1: ( rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2580:2: rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__25113);
            rule__XExportDeclaration__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__25116);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2587:1: rule__XExportDeclaration__Group_1_0__2__Impl : ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) ;
    public final void rule__XExportDeclaration__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2591:1: ( ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2592:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2592:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2593:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2594:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==15) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2594:2: rule__XExportDeclaration__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl5143);
            	    rule__XExportDeclaration__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop17;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2604:1: rule__XExportDeclaration__Group_1_0__3 : rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 ;
    public final void rule__XExportDeclaration__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2608:1: ( rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2609:2: rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__35174);
            rule__XExportDeclaration__Group_1_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__35177);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2616:1: rule__XExportDeclaration__Group_1_0__3__Impl : ( '}' ) ;
    public final void rule__XExportDeclaration__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2620:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2621:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2621:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2622:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3()); 
            }
            match(input,26,FOLLOW_26_in_rule__XExportDeclaration__Group_1_0__3__Impl5205); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2635:1: rule__XExportDeclaration__Group_1_0__4 : rule__XExportDeclaration__Group_1_0__4__Impl ;
    public final void rule__XExportDeclaration__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2639:1: ( rule__XExportDeclaration__Group_1_0__4__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2640:2: rule__XExportDeclaration__Group_1_0__4__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__45236);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2646:1: rule__XExportDeclaration__Group_1_0__4__Impl : ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) ;
    public final void rule__XExportDeclaration__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2650:1: ( ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2651:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2651:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2652:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_4()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2653:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==24) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2653:2: rule__XExportDeclaration__Group_1_0_4__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl5263);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2673:1: rule__XExportDeclaration__Group_1_0_2__0 : rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 ;
    public final void rule__XExportDeclaration__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2677:1: ( rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2678:2: rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__05304);
            rule__XExportDeclaration__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__05307);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2685:1: rule__XExportDeclaration__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2689:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2690:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2690:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2691:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XExportDeclaration__Group_1_0_2__0__Impl5335); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2704:1: rule__XExportDeclaration__Group_1_0_2__1 : rule__XExportDeclaration__Group_1_0_2__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2708:1: ( rule__XExportDeclaration__Group_1_0_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2709:2: rule__XExportDeclaration__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__15366);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2715:1: rule__XExportDeclaration__Group_1_0_2__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2719:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2720:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2720:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2721:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2722:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2722:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl5393);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2736:1: rule__XExportDeclaration__Group_1_0_4__0 : rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 ;
    public final void rule__XExportDeclaration__Group_1_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2740:1: ( rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2741:2: rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__05427);
            rule__XExportDeclaration__Group_1_0_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__05430);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2748:1: rule__XExportDeclaration__Group_1_0_4__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2752:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2753:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2753:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2754:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XExportDeclaration__Group_1_0_4__0__Impl5458); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2767:1: rule__XExportDeclaration__Group_1_0_4__1 : rule__XExportDeclaration__Group_1_0_4__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2771:1: ( rule__XExportDeclaration__Group_1_0_4__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2772:2: rule__XExportDeclaration__Group_1_0_4__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__15489);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2778:1: rule__XExportDeclaration__Group_1_0_4__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2782:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2783:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2783:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2784:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_0_4_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2785:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2785:2: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl5516);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2799:1: rule__XExportDeclaration__Group_1_1__0 : rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 ;
    public final void rule__XExportDeclaration__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2803:1: ( rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2804:2: rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__05550);
            rule__XExportDeclaration__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__05553);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2811:1: rule__XExportDeclaration__Group_1_1__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2815:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2816:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2816:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2817:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XExportDeclaration__Group_1_1__0__Impl5581); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2830:1: rule__XExportDeclaration__Group_1_1__1 : rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 ;
    public final void rule__XExportDeclaration__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2834:1: ( rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2835:2: rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__15612);
            rule__XExportDeclaration__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__15615);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2842:1: rule__XExportDeclaration__Group_1_1__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2846:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2847:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2847:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2848:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2849:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2849:2: rule__XExportDeclaration__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl5642);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2859:1: rule__XExportDeclaration__Group_1_1__2 : rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 ;
    public final void rule__XExportDeclaration__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2863:1: ( rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2864:2: rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__25672);
            rule__XExportDeclaration__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__25675);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2871:1: rule__XExportDeclaration__Group_1_1__2__Impl : ( 'as' ) ;
    public final void rule__XExportDeclaration__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2875:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2876:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2876:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2877:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2()); 
            }
            match(input,27,FOLLOW_27_in_rule__XExportDeclaration__Group_1_1__2__Impl5703); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2890:1: rule__XExportDeclaration__Group_1_1__3 : rule__XExportDeclaration__Group_1_1__3__Impl ;
    public final void rule__XExportDeclaration__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2894:1: ( rule__XExportDeclaration__Group_1_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2895:2: rule__XExportDeclaration__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__35734);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2901:1: rule__XExportDeclaration__Group_1_1__3__Impl : ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2905:1: ( ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2906:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2906:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2907:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasAssignment_1_1_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2908:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2908:2: rule__XExportDeclaration__AliasAssignment_1_1_3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl5761);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2926:1: rule__XExportItem__Group__0 : rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 ;
    public final void rule__XExportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2930:1: ( rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2931:2: rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__05799);
            rule__XExportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__05802);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2938:1: rule__XExportItem__Group__0__Impl : ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) ;
    public final void rule__XExportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2942:1: ( ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2943:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2943:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2944:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2945:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2945:2: rule__XExportItem__ExportedIdAssignment_0
            {
            pushFollow(FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl5829);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2955:1: rule__XExportItem__Group__1 : rule__XExportItem__Group__1__Impl ;
    public final void rule__XExportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2959:1: ( rule__XExportItem__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2960:2: rule__XExportItem__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__15859);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2966:1: rule__XExportItem__Group__1__Impl : ( ( rule__XExportItem__Group_1__0 )? ) ;
    public final void rule__XExportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2970:1: ( ( ( rule__XExportItem__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2971:1: ( ( rule__XExportItem__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2971:1: ( ( rule__XExportItem__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2972:1: ( rule__XExportItem__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2973:1: ( rule__XExportItem__Group_1__0 )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==27) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2973:2: rule__XExportItem__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl5886);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2987:1: rule__XExportItem__Group_1__0 : rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 ;
    public final void rule__XExportItem__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2991:1: ( rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2992:2: rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05921);
            rule__XExportItem__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05924);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2999:1: rule__XExportItem__Group_1__0__Impl : ( 'as' ) ;
    public final void rule__XExportItem__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3003:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3004:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3004:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3005:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAsKeyword_1_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__XExportItem__Group_1__0__Impl5952); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3018:1: rule__XExportItem__Group_1__1 : rule__XExportItem__Group_1__1__Impl ;
    public final void rule__XExportItem__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3022:1: ( rule__XExportItem__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3023:2: rule__XExportItem__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15983);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3029:1: rule__XExportItem__Group_1__1__Impl : ( ( rule__XExportItem__AliasAssignment_1_1 ) ) ;
    public final void rule__XExportItem__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3033:1: ( ( ( rule__XExportItem__AliasAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3034:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3034:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3035:1: ( rule__XExportItem__AliasAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3036:1: ( rule__XExportItem__AliasAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3036:2: rule__XExportItem__AliasAssignment_1_1
            {
            pushFollow(FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl6010);
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


    // $ANTLR start "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3051:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3055:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3056:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3056:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3057:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_06049);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0"


    // $ANTLR start "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3066:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3070:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3071:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3071:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3072:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_16080);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1"


    // $ANTLR start "rule__XFunctionTypeRef__ReturnTypeAssignment_2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3081:1: rule__XFunctionTypeRef__ReturnTypeAssignment_2 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ReturnTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3085:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3086:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3086:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3087:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ReturnTypeAssignment_26111);
            ruleJvmTypeReference();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
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
    // $ANTLR end "rule__XFunctionTypeRef__ReturnTypeAssignment_2"


    // $ANTLR start "rule__JvmParameterizedTypeReference__TypeAssignment_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3096:1: rule__JvmParameterizedTypeReference__TypeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JvmParameterizedTypeReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3100:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3101:1: ( ( ruleQualifiedName ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3101:1: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3102:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3103:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3104:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_06146);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3115:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3119:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3120:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3120:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3121:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_16181);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3130:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3134:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3135:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3135:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3136:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_16212);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3145:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 : ( ruleJvmUpperBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3149:1: ( ( ruleJvmUpperBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3150:1: ( ruleJvmUpperBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3150:1: ( ruleJvmUpperBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3151:1: ruleJvmUpperBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_06243);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3160:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 : ( ruleJvmLowerBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3164:1: ( ( ruleJvmLowerBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3165:1: ( ruleJvmLowerBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3165:1: ( ruleJvmLowerBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3166:1: ruleJvmLowerBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_16274);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3175:1: rule__JvmUpperBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3179:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3180:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3180:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3181:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_16305);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3190:1: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBoundAnded__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3194:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3195:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3195:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3196:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_16336);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3205:1: rule__JvmLowerBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmLowerBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3209:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3210:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3210:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3211:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_16367);
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


    // $ANTLR start "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3224:1: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3228:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3229:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3229:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3230:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_16402);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1"


    // $ANTLR start "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3239:1: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3243:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3244:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3244:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3245:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_16433);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_0_2_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1"


    // $ANTLR start "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3254:1: rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3258:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3259:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3259:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3260:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_16464);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_1_0_0_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1"


    // $ANTLR start "rule__XImportDeclaration1__ImportURIAssignment_1_0_2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3269:1: rule__XImportDeclaration1__ImportURIAssignment_1_0_2 : ( RULE_STRING ) ;
    public final void rule__XImportDeclaration1__ImportURIAssignment_1_0_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3273:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3274:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3274:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3275:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_0_2_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_1_0_26495); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_0_2_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportURIAssignment_1_0_2"


    // $ANTLR start "rule__XImportDeclaration1__ImportURIAssignment_1_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3284:1: rule__XImportDeclaration1__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__XImportDeclaration1__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3288:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3289:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3289:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3290:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_1_1_16526); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportURIAssignment_1_1_1"


    // $ANTLR start "rule__XImportDeclaration1__AliasAssignment_1_1_3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3299:1: rule__XImportDeclaration1__AliasAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__XImportDeclaration1__AliasAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3303:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3304:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3304:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3305:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAliasIDTerminalRuleCall_1_1_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportDeclaration1__AliasAssignment_1_1_36557); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAliasIDTerminalRuleCall_1_1_3_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__AliasAssignment_1_1_3"


    // $ANTLR start "rule__XImportItem__ImportedIdAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3314:1: rule__XImportItem__ImportedIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__XImportItem__ImportedIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3318:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3319:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3319:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3320:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3321:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3322:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_16592); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3333:1: rule__XImportItem__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__XImportItem__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3337:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3338:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3338:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3339:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_16627); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3349:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3353:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3354:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3354:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3355:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_16659);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3364:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3368:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3369:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3369:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3370:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_16690);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3379:1: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3383:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3384:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3384:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3385:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0_4_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_16721); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3394:1: rule__XExportDeclaration__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3398:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3399:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3399:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3400:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_16752); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3409:1: rule__XExportDeclaration__AliasAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__XExportDeclaration__AliasAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3413:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3414:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3414:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3415:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasIDTerminalRuleCall_1_1_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_36783); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3424:1: rule__XExportItem__ExportedIdAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__XExportItem__ExportedIdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3428:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3429:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3429:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3430:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3431:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3432:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_06818); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3443:1: rule__XExportItem__AliasAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__XExportItem__AliasAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3447:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3448:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3448:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3449:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_16853); if (state.failed) return ;
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
    public static final BitSet FOLLOW_rule__JvmTypeReference__Alternatives_in_ruleJvmTypeReference100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_entryRuleArrayBrackets127 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleArrayBrackets134 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__0_in_ruleArrayBrackets160 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_entryRuleXFunctionTypeRef187 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXFunctionTypeRef194 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__0_in_ruleXFunctionTypeRef220 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_entryRuleJvmParameterizedTypeReference247 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmParameterizedTypeReference254 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__0_in_ruleJvmParameterizedTypeReference280 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_entryRuleJvmArgumentTypeReference307 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmArgumentTypeReference314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmArgumentTypeReference__Alternatives_in_ruleJvmArgumentTypeReference340 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_entryRuleJvmWildcardTypeReference367 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmWildcardTypeReference374 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__0_in_ruleJvmWildcardTypeReference400 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_entryRuleJvmUpperBound427 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBound434 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__0_in_ruleJvmUpperBound460 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBoundAnded_in_entryRuleJvmUpperBoundAnded487 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmUpperBoundAnded494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__0_in_ruleJvmUpperBoundAnded520 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_entryRuleJvmLowerBound547 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleJvmLowerBound554 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__0_in_ruleJvmLowerBound580 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_entryRuleQualifiedName609 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleQualifiedName616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0_in_ruleQualifiedName642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_entryRuleValidID671 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleValidID678 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_ruleValidID704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportDeclaration1_in_entryRuleXImportDeclaration1732 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportDeclaration1739 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__0_in_ruleXImportDeclaration1765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_entryRuleXImportItem792 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXImportItem799 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__0_in_ruleXImportItem825 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportDeclaration_in_entryRuleXExportDeclaration854 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportDeclaration861 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__0_in_ruleXExportDeclaration887 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_entryRuleXExportItem914 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_EOF_in_entryRuleXExportItem921 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__0_in_ruleXExportItem947 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__0_in_rule__JvmTypeReference__Alternatives983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXFunctionTypeRef_in_rule__JvmTypeReference__Alternatives1001 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmArgumentTypeReference__Alternatives1033 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmWildcardTypeReference_in_rule__JvmArgumentTypeReference__Alternatives1050 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0_in_rule__JvmWildcardTypeReference__Alternatives_21082 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1_in_rule__JvmWildcardTypeReference__Alternatives_21100 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__0_in_rule__XImportDeclaration1__Alternatives_11133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__0_in_rule__XImportDeclaration1__Alternatives_11151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__0_in_rule__XImportDeclaration1__Alternatives_1_0_01184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_1_in_rule__XImportDeclaration1__Alternatives_1_0_01202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11235 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11253 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__0__Impl_in_rule__JvmTypeReference__Group_0__01284 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__1_in_rule__JvmTypeReference__Group_0__01287 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group_0__0__Impl1314 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__1__Impl_in_rule__JvmTypeReference__Group_0__11343 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1__0_in_rule__JvmTypeReference__Group_0__1__Impl1370 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1__0__Impl_in_rule__JvmTypeReference__Group_0_1__01405 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__0_in_rule__JvmTypeReference__Group_0_1__0__Impl1432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__0__Impl_in_rule__JvmTypeReference__Group_0_1_0__01464 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__1_in_rule__JvmTypeReference__Group_0_1_0__01467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__1__Impl_in_rule__JvmTypeReference__Group_0_1_0__11525 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_0_1_0__1__Impl1552 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01585 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01588 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1616 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11647 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__0__Impl_in_rule__XFunctionTypeRef__Group__01710 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__1_in_rule__XFunctionTypeRef__Group__01713 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__0_in_rule__XFunctionTypeRef__Group__0__Impl1740 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__1__Impl_in_rule__XFunctionTypeRef__Group__11771 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__2_in_rule__XFunctionTypeRef__Group__11774 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__XFunctionTypeRef__Group__1__Impl1802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__2__Impl_in_rule__XFunctionTypeRef__Group__21833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ReturnTypeAssignment_2_in_rule__XFunctionTypeRef__Group__2__Impl1860 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__0__Impl_in_rule__XFunctionTypeRef__Group_0__01896 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__1_in_rule__XFunctionTypeRef__Group_0__01899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__XFunctionTypeRef__Group_0__0__Impl1927 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__1__Impl_in_rule__XFunctionTypeRef__Group_0__11958 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__2_in_rule__XFunctionTypeRef__Group_0__11961 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__0_in_rule__XFunctionTypeRef__Group_0__1__Impl1988 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__2__Impl_in_rule__XFunctionTypeRef__Group_0__22019 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__XFunctionTypeRef__Group_0__2__Impl2047 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1__02084 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__1_in_rule__XFunctionTypeRef__Group_0_1__02087 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0_in_rule__XFunctionTypeRef__Group_0_1__0__Impl2114 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1__12144 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0_in_rule__XFunctionTypeRef__Group_0_1__1__Impl2171 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__02206 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1_in_rule__XFunctionTypeRef__Group_0_1_1__02209 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XFunctionTypeRef__Group_0_1_1__0__Impl2237 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__12268 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1_in_rule__XFunctionTypeRef__Group_0_1_1__1__Impl2295 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__02329 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__02332 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl2359 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__12389 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl2416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__02451 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__02454 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl2483 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__12515 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__12518 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl2545 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__22575 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__22578 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl2605 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__32636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl2664 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__02703 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__02706 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl2734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__12765 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2792 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02826 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12887 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12890 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JvmWildcardTypeReference__Group__1__Impl2918 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22949 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__03013 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__03016 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JvmUpperBound__Group__0__Impl3044 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__13075 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl3102 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__03136 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__03139 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__JvmUpperBoundAnded__Group__0__Impl3167 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__13198 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl3225 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__03259 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__03262 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__JvmLowerBound__Group__0__Impl3290 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__13321 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl3348 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03384 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03387 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl3414 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13443 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3470 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03505 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03508 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl3536 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13567 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3594 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__0__Impl_in_rule__XImportDeclaration1__Group__03629 = new BitSet(new long[]{0x0000000003000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__1_in_rule__XImportDeclaration1__Group__03632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XImportDeclaration1__Group__0__Impl3660 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__1__Impl_in_rule__XImportDeclaration1__Group__13691 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Alternatives_1_in_rule__XImportDeclaration1__Group__1__Impl3718 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__0__Impl_in_rule__XImportDeclaration1__Group_1_0__03752 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__1_in_rule__XImportDeclaration1__Group_1_0__03755 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Alternatives_1_0_0_in_rule__XImportDeclaration1__Group_1_0__0__Impl3782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__1__Impl_in_rule__XImportDeclaration1__Group_1_0__13812 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__2_in_rule__XImportDeclaration1__Group_1_0__13815 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XImportDeclaration1__Group_1_0__1__Impl3843 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0__2__Impl_in_rule__XImportDeclaration1__Group_1_0__23874 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_1_0_2_in_rule__XImportDeclaration1__Group_1_0__2__Impl3901 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__0__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__03937 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__1_in_rule__XImportDeclaration1__Group_1_0_0_0__03940 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__XImportDeclaration1__Group_1_0_0_0__0__Impl3968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__1__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__13999 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__2_in_rule__XImportDeclaration1__Group_1_0_0_0__14002 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_1_in_rule__XImportDeclaration1__Group_1_0_0_0__1__Impl4029 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__2__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__24059 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__3_in_rule__XImportDeclaration1__Group_1_0_0_0__24062 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__0_in_rule__XImportDeclaration1__Group_1_0_0_0__2__Impl4089 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0__3__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0__34120 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XImportDeclaration1__Group_1_0_0_0__3__Impl4148 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0_2__04187 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__1_in_rule__XImportDeclaration1__Group_1_0_0_0_2__04190 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XImportDeclaration1__Group_1_0_0_0_2__0__Impl4218 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl_in_rule__XImportDeclaration1__Group_1_0_0_0_2__14249 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_1_in_rule__XImportDeclaration1__Group_1_0_0_0_2__1__Impl4276 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__0__Impl_in_rule__XImportDeclaration1__Group_1_1__04310 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__1_in_rule__XImportDeclaration1__Group_1_1__04313 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XImportDeclaration1__Group_1_1__0__Impl4341 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__1__Impl_in_rule__XImportDeclaration1__Group_1_1__14372 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__2_in_rule__XImportDeclaration1__Group_1_1__14375 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_1_1_1_in_rule__XImportDeclaration1__Group_1_1__1__Impl4402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__2__Impl_in_rule__XImportDeclaration1__Group_1_1__24432 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__3_in_rule__XImportDeclaration1__Group_1_1__24435 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XImportDeclaration1__Group_1_1__2__Impl4463 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_1_1__3__Impl_in_rule__XImportDeclaration1__Group_1_1__34494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__AliasAssignment_1_1_3_in_rule__XImportDeclaration1__Group_1_1__3__Impl4521 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__04559 = new BitSet(new long[]{0x0000000002000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__04562 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__14620 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__14623 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl4650 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__24680 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl4707 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__04744 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__04747 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XImportItem__Group_2__0__Impl4775 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__14806 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl4833 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__04868 = new BitSet(new long[]{0x0000000003000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__04871 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__XExportDeclaration__Group__0__Impl4899 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14930 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4957 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04991 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04994 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__XExportDeclaration__Group_1_0__0__Impl5022 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__15053 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__15056 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl5083 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__25113 = new BitSet(new long[]{0x0000000004008000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__25116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl5143 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__35174 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__35177 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XExportDeclaration__Group_1_0__3__Impl5205 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__45236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl5263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__05304 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__05307 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XExportDeclaration__Group_1_0_2__0__Impl5335 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__15366 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl5393 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__05427 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__05430 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XExportDeclaration__Group_1_0_4__0__Impl5458 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__15489 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl5516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__05550 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__05553 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XExportDeclaration__Group_1_1__0__Impl5581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__15612 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__15615 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl5642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__25672 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__25675 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XExportDeclaration__Group_1_1__2__Impl5703 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__35734 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl5761 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__05799 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__05802 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl5829 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__15859 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl5886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05921 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05924 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XExportItem__Group_1__0__Impl5952 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15983 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl6010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_06049 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_16080 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ReturnTypeAssignment_26111 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_06146 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_16181 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_16212 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_06243 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_16274 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_16305 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_16336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_16367 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_16402 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_0_2_16433 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_1_0_0_16464 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_1_0_26495 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_1_1_16526 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportDeclaration1__AliasAssignment_1_1_36557 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_16592 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_16627 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_16659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_16690 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_16721 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_16752 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_36783 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_06818 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_16853 = new BitSet(new long[]{0x0000000000000002L});

}