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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'['", "']'", "'=>'", "'('", "')'", "','", "'<'", "'>'", "'?'", "'extends'", "'&'", "'super'", "'.'", "'import'", "'{'", "'}'", "'as'", "'from'", "'export'", "'*'"
    };
    public static final int RULE_ID=4;
    public static final int T__29=29;
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


    // $ANTLR start "rule__XImportDeclaration1__Alternatives_3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:555:1: rule__XImportDeclaration1__Alternatives_3 : ( ( ( rule__XImportDeclaration1__Group_3_0__0 ) ) | ( ( rule__XImportDeclaration1__WildcardAssignment_3_1 ) ) );
    public final void rule__XImportDeclaration1__Alternatives_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:559:1: ( ( ( rule__XImportDeclaration1__Group_3_0__0 ) ) | ( ( rule__XImportDeclaration1__WildcardAssignment_3_1 ) ) )
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            else if ( (LA4_0==29) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:560:1: ( ( rule__XImportDeclaration1__Group_3_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:560:1: ( ( rule__XImportDeclaration1__Group_3_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:561:1: ( rule__XImportDeclaration1__Group_3_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getGroup_3_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:562:1: ( rule__XImportDeclaration1__Group_3_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:562:2: rule__XImportDeclaration1__Group_3_0__0
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0__0_in_rule__XImportDeclaration1__Alternatives_31133);
                    rule__XImportDeclaration1__Group_3_0__0();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getGroup_3_0()); 
                    }

                    }


                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:566:6: ( ( rule__XImportDeclaration1__WildcardAssignment_3_1 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:566:6: ( ( rule__XImportDeclaration1__WildcardAssignment_3_1 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:567:1: ( rule__XImportDeclaration1__WildcardAssignment_3_1 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXImportDeclaration1Access().getWildcardAssignment_3_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:1: ( rule__XImportDeclaration1__WildcardAssignment_3_1 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:568:2: rule__XImportDeclaration1__WildcardAssignment_3_1
                    {
                    pushFollow(FOLLOW_rule__XImportDeclaration1__WildcardAssignment_3_1_in_rule__XImportDeclaration1__Alternatives_31151);
                    rule__XImportDeclaration1__WildcardAssignment_3_1();

                    state._fsp--;
                    if (state.failed) return ;

                    }

                    if ( state.backtracking==0 ) {
                       after(grammarAccess.getXImportDeclaration1Access().getWildcardAssignment_3_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Alternatives_3"


    // $ANTLR start "rule__XExportDeclaration__Alternatives_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:577:1: rule__XExportDeclaration__Alternatives_1 : ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) );
    public final void rule__XExportDeclaration__Alternatives_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:581:1: ( ( ( rule__XExportDeclaration__Group_1_0__0 ) ) | ( ( rule__XExportDeclaration__Group_1_1__0 ) ) )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==24) ) {
                alt5=1;
            }
            else if ( (LA5_0==27) ) {
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:582:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:582:1: ( ( rule__XExportDeclaration__Group_1_0__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:583:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:584:1: ( rule__XExportDeclaration__Group_1_0__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:584:2: rule__XExportDeclaration__Group_1_0__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11184);
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
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:588:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:588:6: ( ( rule__XExportDeclaration__Group_1_1__0 ) )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:589:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    {
                    if ( state.backtracking==0 ) {
                       before(grammarAccess.getXExportDeclarationAccess().getGroup_1_1()); 
                    }
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:590:1: ( rule__XExportDeclaration__Group_1_1__0 )
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:590:2: rule__XExportDeclaration__Group_1_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11202);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:601:1: rule__JvmTypeReference__Group_0__0 : rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 ;
    public final void rule__JvmTypeReference__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:605:1: ( rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:606:2: rule__JvmTypeReference__Group_0__0__Impl rule__JvmTypeReference__Group_0__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__0__Impl_in_rule__JvmTypeReference__Group_0__01233);
            rule__JvmTypeReference__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__1_in_rule__JvmTypeReference__Group_0__01236);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:613:1: rule__JvmTypeReference__Group_0__0__Impl : ( ruleJvmParameterizedTypeReference ) ;
    public final void rule__JvmTypeReference__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:617:1: ( ( ruleJvmParameterizedTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:618:1: ( ruleJvmParameterizedTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:618:1: ( ruleJvmParameterizedTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:619:1: ruleJvmParameterizedTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmParameterizedTypeReferenceParserRuleCall_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group_0__0__Impl1263);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:630:1: rule__JvmTypeReference__Group_0__1 : rule__JvmTypeReference__Group_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:634:1: ( rule__JvmTypeReference__Group_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:635:2: rule__JvmTypeReference__Group_0__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0__1__Impl_in_rule__JvmTypeReference__Group_0__11292);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:641:1: rule__JvmTypeReference__Group_0__1__Impl : ( ( rule__JvmTypeReference__Group_0_1__0 )* ) ;
    public final void rule__JvmTypeReference__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:645:1: ( ( ( rule__JvmTypeReference__Group_0_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:646:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:646:1: ( ( rule__JvmTypeReference__Group_0_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:647:1: ( rule__JvmTypeReference__Group_0_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:648:1: ( rule__JvmTypeReference__Group_0_1__0 )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0==10) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:648:2: rule__JvmTypeReference__Group_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1__0_in_rule__JvmTypeReference__Group_0__1__Impl1319);
            	    rule__JvmTypeReference__Group_0_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop6;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:662:1: rule__JvmTypeReference__Group_0_1__0 : rule__JvmTypeReference__Group_0_1__0__Impl ;
    public final void rule__JvmTypeReference__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:666:1: ( rule__JvmTypeReference__Group_0_1__0__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:667:2: rule__JvmTypeReference__Group_0_1__0__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1__0__Impl_in_rule__JvmTypeReference__Group_0_1__01354);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:673:1: rule__JvmTypeReference__Group_0_1__0__Impl : ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) ;
    public final void rule__JvmTypeReference__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:677:1: ( ( ( rule__JvmTypeReference__Group_0_1_0__0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:678:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:678:1: ( ( rule__JvmTypeReference__Group_0_1_0__0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:679:1: ( rule__JvmTypeReference__Group_0_1_0__0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getGroup_0_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:680:1: ( rule__JvmTypeReference__Group_0_1_0__0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:680:2: rule__JvmTypeReference__Group_0_1_0__0
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__0_in_rule__JvmTypeReference__Group_0_1__0__Impl1381);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:692:1: rule__JvmTypeReference__Group_0_1_0__0 : rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 ;
    public final void rule__JvmTypeReference__Group_0_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:696:1: ( rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:697:2: rule__JvmTypeReference__Group_0_1_0__0__Impl rule__JvmTypeReference__Group_0_1_0__1
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__0__Impl_in_rule__JvmTypeReference__Group_0_1_0__01413);
            rule__JvmTypeReference__Group_0_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__1_in_rule__JvmTypeReference__Group_0_1_0__01416);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:704:1: rule__JvmTypeReference__Group_0_1_0__0__Impl : ( () ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:708:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:709:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:709:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:710:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getJvmGenericArrayTypeReferenceComponentTypeAction_0_1_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:711:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:713:1: 
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:723:1: rule__JvmTypeReference__Group_0_1_0__1 : rule__JvmTypeReference__Group_0_1_0__1__Impl ;
    public final void rule__JvmTypeReference__Group_0_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:727:1: ( rule__JvmTypeReference__Group_0_1_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:728:2: rule__JvmTypeReference__Group_0_1_0__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmTypeReference__Group_0_1_0__1__Impl_in_rule__JvmTypeReference__Group_0_1_0__11474);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:734:1: rule__JvmTypeReference__Group_0_1_0__1__Impl : ( ruleArrayBrackets ) ;
    public final void rule__JvmTypeReference__Group_0_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:738:1: ( ( ruleArrayBrackets ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:739:1: ( ruleArrayBrackets )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:739:1: ( ruleArrayBrackets )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:740:1: ruleArrayBrackets
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmTypeReferenceAccess().getArrayBracketsParserRuleCall_0_1_0_1()); 
            }
            pushFollow(FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_0_1_0__1__Impl1501);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:755:1: rule__ArrayBrackets__Group__0 : rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 ;
    public final void rule__ArrayBrackets__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:759:1: ( rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:760:2: rule__ArrayBrackets__Group__0__Impl rule__ArrayBrackets__Group__1
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01534);
            rule__ArrayBrackets__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01537);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:767:1: rule__ArrayBrackets__Group__0__Impl : ( '[' ) ;
    public final void rule__ArrayBrackets__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:771:1: ( ( '[' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:772:1: ( '[' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:772:1: ( '[' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:773:1: '['
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getLeftSquareBracketKeyword_0()); 
            }
            match(input,10,FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1565); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:786:1: rule__ArrayBrackets__Group__1 : rule__ArrayBrackets__Group__1__Impl ;
    public final void rule__ArrayBrackets__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:790:1: ( rule__ArrayBrackets__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:791:2: rule__ArrayBrackets__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11596);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:797:1: rule__ArrayBrackets__Group__1__Impl : ( ']' ) ;
    public final void rule__ArrayBrackets__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:801:1: ( ( ']' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:802:1: ( ']' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:802:1: ( ']' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:803:1: ']'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getArrayBracketsAccess().getRightSquareBracketKeyword_1()); 
            }
            match(input,11,FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1624); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:820:1: rule__XFunctionTypeRef__Group__0 : rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 ;
    public final void rule__XFunctionTypeRef__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:824:1: ( rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:825:2: rule__XFunctionTypeRef__Group__0__Impl rule__XFunctionTypeRef__Group__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__0__Impl_in_rule__XFunctionTypeRef__Group__01659);
            rule__XFunctionTypeRef__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__1_in_rule__XFunctionTypeRef__Group__01662);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:832:1: rule__XFunctionTypeRef__Group__0__Impl : ( ( rule__XFunctionTypeRef__Group_0__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:836:1: ( ( ( rule__XFunctionTypeRef__Group_0__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:837:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:837:1: ( ( rule__XFunctionTypeRef__Group_0__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:838:1: ( rule__XFunctionTypeRef__Group_0__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:839:1: ( rule__XFunctionTypeRef__Group_0__0 )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==13) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:839:2: rule__XFunctionTypeRef__Group_0__0
                    {
                    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__0_in_rule__XFunctionTypeRef__Group__0__Impl1689);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:849:1: rule__XFunctionTypeRef__Group__1 : rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 ;
    public final void rule__XFunctionTypeRef__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:853:1: ( rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:854:2: rule__XFunctionTypeRef__Group__1__Impl rule__XFunctionTypeRef__Group__2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__1__Impl_in_rule__XFunctionTypeRef__Group__11720);
            rule__XFunctionTypeRef__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__2_in_rule__XFunctionTypeRef__Group__11723);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:861:1: rule__XFunctionTypeRef__Group__1__Impl : ( '=>' ) ;
    public final void rule__XFunctionTypeRef__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:865:1: ( ( '=>' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:866:1: ( '=>' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:866:1: ( '=>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:867:1: '=>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getEqualsSignGreaterThanSignKeyword_1()); 
            }
            match(input,12,FOLLOW_12_in_rule__XFunctionTypeRef__Group__1__Impl1751); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:880:1: rule__XFunctionTypeRef__Group__2 : rule__XFunctionTypeRef__Group__2__Impl ;
    public final void rule__XFunctionTypeRef__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:884:1: ( rule__XFunctionTypeRef__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:885:2: rule__XFunctionTypeRef__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group__2__Impl_in_rule__XFunctionTypeRef__Group__21782);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:891:1: rule__XFunctionTypeRef__Group__2__Impl : ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) ;
    public final void rule__XFunctionTypeRef__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:895:1: ( ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:896:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:896:1: ( ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:897:1: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeAssignment_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:898:1: ( rule__XFunctionTypeRef__ReturnTypeAssignment_2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:898:2: rule__XFunctionTypeRef__ReturnTypeAssignment_2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ReturnTypeAssignment_2_in_rule__XFunctionTypeRef__Group__2__Impl1809);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:914:1: rule__XFunctionTypeRef__Group_0__0 : rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 ;
    public final void rule__XFunctionTypeRef__Group_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:918:1: ( rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:919:2: rule__XFunctionTypeRef__Group_0__0__Impl rule__XFunctionTypeRef__Group_0__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__0__Impl_in_rule__XFunctionTypeRef__Group_0__01845);
            rule__XFunctionTypeRef__Group_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__1_in_rule__XFunctionTypeRef__Group_0__01848);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:926:1: rule__XFunctionTypeRef__Group_0__0__Impl : ( '(' ) ;
    public final void rule__XFunctionTypeRef__Group_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:930:1: ( ( '(' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:931:1: ( '(' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:931:1: ( '(' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:932:1: '('
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getLeftParenthesisKeyword_0_0()); 
            }
            match(input,13,FOLLOW_13_in_rule__XFunctionTypeRef__Group_0__0__Impl1876); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:945:1: rule__XFunctionTypeRef__Group_0__1 : rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 ;
    public final void rule__XFunctionTypeRef__Group_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:949:1: ( rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:950:2: rule__XFunctionTypeRef__Group_0__1__Impl rule__XFunctionTypeRef__Group_0__2
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__1__Impl_in_rule__XFunctionTypeRef__Group_0__11907);
            rule__XFunctionTypeRef__Group_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__2_in_rule__XFunctionTypeRef__Group_0__11910);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:957:1: rule__XFunctionTypeRef__Group_0__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) ;
    public final void rule__XFunctionTypeRef__Group_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:961:1: ( ( ( rule__XFunctionTypeRef__Group_0_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:962:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:962:1: ( ( rule__XFunctionTypeRef__Group_0_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:963:1: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:964:1: ( rule__XFunctionTypeRef__Group_0_1__0 )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==RULE_ID||(LA8_0>=12 && LA8_0<=13)) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:964:2: rule__XFunctionTypeRef__Group_0_1__0
                    {
                    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__0_in_rule__XFunctionTypeRef__Group_0__1__Impl1937);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:974:1: rule__XFunctionTypeRef__Group_0__2 : rule__XFunctionTypeRef__Group_0__2__Impl ;
    public final void rule__XFunctionTypeRef__Group_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:978:1: ( rule__XFunctionTypeRef__Group_0__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:979:2: rule__XFunctionTypeRef__Group_0__2__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0__2__Impl_in_rule__XFunctionTypeRef__Group_0__21968);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:985:1: rule__XFunctionTypeRef__Group_0__2__Impl : ( ')' ) ;
    public final void rule__XFunctionTypeRef__Group_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:989:1: ( ( ')' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:990:1: ( ')' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:990:1: ( ')' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:991:1: ')'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getRightParenthesisKeyword_0_2()); 
            }
            match(input,14,FOLLOW_14_in_rule__XFunctionTypeRef__Group_0__2__Impl1996); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1010:1: rule__XFunctionTypeRef__Group_0_1__0 : rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1014:1: ( rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1015:2: rule__XFunctionTypeRef__Group_0_1__0__Impl rule__XFunctionTypeRef__Group_0_1__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1__02033);
            rule__XFunctionTypeRef__Group_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__1_in_rule__XFunctionTypeRef__Group_0_1__02036);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1022:1: rule__XFunctionTypeRef__Group_0_1__0__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1026:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1027:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1027:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1028:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1029:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1029:2: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0_in_rule__XFunctionTypeRef__Group_0_1__0__Impl2063);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1039:1: rule__XFunctionTypeRef__Group_0_1__1 : rule__XFunctionTypeRef__Group_0_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1043:1: ( rule__XFunctionTypeRef__Group_0_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1044:2: rule__XFunctionTypeRef__Group_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1__12093);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1050:1: rule__XFunctionTypeRef__Group_0_1__1__Impl : ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) ;
    public final void rule__XFunctionTypeRef__Group_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1054:1: ( ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1055:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1055:1: ( ( rule__XFunctionTypeRef__Group_0_1_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1056:1: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getGroup_0_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1057:1: ( rule__XFunctionTypeRef__Group_0_1_1__0 )*
            loop9:
            do {
                int alt9=2;
                int LA9_0 = input.LA(1);

                if ( (LA9_0==15) ) {
                    alt9=1;
                }


                switch (alt9) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1057:2: rule__XFunctionTypeRef__Group_0_1_1__0
            	    {
            	    pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0_in_rule__XFunctionTypeRef__Group_0_1__1__Impl2120);
            	    rule__XFunctionTypeRef__Group_0_1_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop9;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1071:1: rule__XFunctionTypeRef__Group_0_1_1__0 : rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1075:1: ( rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1076:2: rule__XFunctionTypeRef__Group_0_1_1__0__Impl rule__XFunctionTypeRef__Group_0_1_1__1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__02155);
            rule__XFunctionTypeRef__Group_0_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1_in_rule__XFunctionTypeRef__Group_0_1_1__02158);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1083:1: rule__XFunctionTypeRef__Group_0_1_1__0__Impl : ( ',' ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1087:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1088:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1088:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1089:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getCommaKeyword_0_1_1_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XFunctionTypeRef__Group_0_1_1__0__Impl2186); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1102:1: rule__XFunctionTypeRef__Group_0_1_1__1 : rule__XFunctionTypeRef__Group_0_1_1__1__Impl ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1106:1: ( rule__XFunctionTypeRef__Group_0_1_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1107:2: rule__XFunctionTypeRef__Group_0_1_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__12217);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1113:1: rule__XFunctionTypeRef__Group_0_1_1__1__Impl : ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) ;
    public final void rule__XFunctionTypeRef__Group_0_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1117:1: ( ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1118:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1118:1: ( ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1119:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesAssignment_0_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1120:1: ( rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1120:2: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1
            {
            pushFollow(FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1_in_rule__XFunctionTypeRef__Group_0_1_1__1__Impl2244);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1134:1: rule__JvmParameterizedTypeReference__Group__0 : rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 ;
    public final void rule__JvmParameterizedTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1138:1: ( rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1139:2: rule__JvmParameterizedTypeReference__Group__0__Impl rule__JvmParameterizedTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__02278);
            rule__JvmParameterizedTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__02281);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1146:1: rule__JvmParameterizedTypeReference__Group__0__Impl : ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1150:1: ( ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1151:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1151:1: ( ( rule__JvmParameterizedTypeReference__TypeAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1152:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1153:1: ( rule__JvmParameterizedTypeReference__TypeAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1153:2: rule__JvmParameterizedTypeReference__TypeAssignment_0
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl2308);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1163:1: rule__JvmParameterizedTypeReference__Group__1 : rule__JvmParameterizedTypeReference__Group__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1167:1: ( rule__JvmParameterizedTypeReference__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1168:2: rule__JvmParameterizedTypeReference__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__12338);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1174:1: rule__JvmParameterizedTypeReference__Group__1__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) ;
    public final void rule__JvmParameterizedTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1178:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1179:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1179:1: ( ( rule__JvmParameterizedTypeReference__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1180:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1181:1: ( rule__JvmParameterizedTypeReference__Group_1__0 )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==16) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1181:2: rule__JvmParameterizedTypeReference__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl2365);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1195:1: rule__JvmParameterizedTypeReference__Group_1__0 : rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1199:1: ( rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1200:2: rule__JvmParameterizedTypeReference__Group_1__0__Impl rule__JvmParameterizedTypeReference__Group_1__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__02400);
            rule__JvmParameterizedTypeReference__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__02403);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1207:1: rule__JvmParameterizedTypeReference__Group_1__0__Impl : ( ( '<' ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1211:1: ( ( ( '<' ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1212:1: ( ( '<' ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1212:1: ( ( '<' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1213:1: ( '<' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getLessThanSignKeyword_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1214:1: ( '<' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1215:2: '<'
            {
            match(input,16,FOLLOW_16_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl2432); if (state.failed) return ;

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1226:1: rule__JvmParameterizedTypeReference__Group_1__1 : rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1230:1: ( rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1231:2: rule__JvmParameterizedTypeReference__Group_1__1__Impl rule__JvmParameterizedTypeReference__Group_1__2
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__12464);
            rule__JvmParameterizedTypeReference__Group_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__12467);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1238:1: rule__JvmParameterizedTypeReference__Group_1__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1242:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1243:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1243:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1244:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1245:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1245:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl2494);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1255:1: rule__JvmParameterizedTypeReference__Group_1__2 : rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1259:1: ( rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1260:2: rule__JvmParameterizedTypeReference__Group_1__2__Impl rule__JvmParameterizedTypeReference__Group_1__3
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__22524);
            rule__JvmParameterizedTypeReference__Group_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__22527);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1267:1: rule__JvmParameterizedTypeReference__Group_1__2__Impl : ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1271:1: ( ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1272:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1272:1: ( ( rule__JvmParameterizedTypeReference__Group_1_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1273:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGroup_1_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1274:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0 )*
            loop11:
            do {
                int alt11=2;
                int LA11_0 = input.LA(1);

                if ( (LA11_0==15) ) {
                    alt11=1;
                }


                switch (alt11) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1274:2: rule__JvmParameterizedTypeReference__Group_1_2__0
            	    {
            	    pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl2554);
            	    rule__JvmParameterizedTypeReference__Group_1_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop11;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1284:1: rule__JvmParameterizedTypeReference__Group_1__3 : rule__JvmParameterizedTypeReference__Group_1__3__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1288:1: ( rule__JvmParameterizedTypeReference__Group_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1289:2: rule__JvmParameterizedTypeReference__Group_1__3__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__32585);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1295:1: rule__JvmParameterizedTypeReference__Group_1__3__Impl : ( '>' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1299:1: ( ( '>' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1300:1: ( '>' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1300:1: ( '>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1301:1: '>'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getGreaterThanSignKeyword_1_3()); 
            }
            match(input,17,FOLLOW_17_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl2613); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1322:1: rule__JvmParameterizedTypeReference__Group_1_2__0 : rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1326:1: ( rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1327:2: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl rule__JvmParameterizedTypeReference__Group_1_2__1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__02652);
            rule__JvmParameterizedTypeReference__Group_1_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__02655);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1334:1: rule__JvmParameterizedTypeReference__Group_1_2__0__Impl : ( ',' ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1338:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1339:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1339:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1340:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getCommaKeyword_1_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl2683); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1353:1: rule__JvmParameterizedTypeReference__Group_1_2__1 : rule__JvmParameterizedTypeReference__Group_1_2__1__Impl ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1357:1: ( rule__JvmParameterizedTypeReference__Group_1_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1358:2: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__12714);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1364:1: rule__JvmParameterizedTypeReference__Group_1_2__1__Impl : ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) ;
    public final void rule__JvmParameterizedTypeReference__Group_1_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1368:1: ( ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1369:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1369:1: ( ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1370:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsAssignment_1_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1371:1: ( rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1371:2: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1
            {
            pushFollow(FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2741);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1385:1: rule__JvmWildcardTypeReference__Group__0 : rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 ;
    public final void rule__JvmWildcardTypeReference__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1389:1: ( rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1390:2: rule__JvmWildcardTypeReference__Group__0__Impl rule__JvmWildcardTypeReference__Group__1
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02775);
            rule__JvmWildcardTypeReference__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02778);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1397:1: rule__JvmWildcardTypeReference__Group__0__Impl : ( () ) ;
    public final void rule__JvmWildcardTypeReference__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1401:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1402:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1402:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1403:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getJvmWildcardTypeReferenceAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1404:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1406:1: 
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1416:1: rule__JvmWildcardTypeReference__Group__1 : rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 ;
    public final void rule__JvmWildcardTypeReference__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1420:1: ( rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1421:2: rule__JvmWildcardTypeReference__Group__1__Impl rule__JvmWildcardTypeReference__Group__2
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12836);
            rule__JvmWildcardTypeReference__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12839);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1428:1: rule__JvmWildcardTypeReference__Group__1__Impl : ( '?' ) ;
    public final void rule__JvmWildcardTypeReference__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1432:1: ( ( '?' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1433:1: ( '?' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1433:1: ( '?' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1434:1: '?'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getQuestionMarkKeyword_1()); 
            }
            match(input,18,FOLLOW_18_in_rule__JvmWildcardTypeReference__Group__1__Impl2867); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1447:1: rule__JvmWildcardTypeReference__Group__2 : rule__JvmWildcardTypeReference__Group__2__Impl ;
    public final void rule__JvmWildcardTypeReference__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1451:1: ( rule__JvmWildcardTypeReference__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1452:2: rule__JvmWildcardTypeReference__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22898);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1458:1: rule__JvmWildcardTypeReference__Group__2__Impl : ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) ;
    public final void rule__JvmWildcardTypeReference__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1462:1: ( ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1463:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1463:1: ( ( rule__JvmWildcardTypeReference__Alternatives_2 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1464:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getAlternatives_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1465:1: ( rule__JvmWildcardTypeReference__Alternatives_2 )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==19||LA12_0==21) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1465:2: rule__JvmWildcardTypeReference__Alternatives_2
                    {
                    pushFollow(FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2925);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1481:1: rule__JvmUpperBound__Group__0 : rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 ;
    public final void rule__JvmUpperBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1485:1: ( rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1486:2: rule__JvmUpperBound__Group__0__Impl rule__JvmUpperBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__02962);
            rule__JvmUpperBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__02965);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1493:1: rule__JvmUpperBound__Group__0__Impl : ( 'extends' ) ;
    public final void rule__JvmUpperBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1497:1: ( ( 'extends' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1498:1: ( 'extends' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1498:1: ( 'extends' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1499:1: 'extends'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getExtendsKeyword_0()); 
            }
            match(input,19,FOLLOW_19_in_rule__JvmUpperBound__Group__0__Impl2993); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1512:1: rule__JvmUpperBound__Group__1 : rule__JvmUpperBound__Group__1__Impl ;
    public final void rule__JvmUpperBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1516:1: ( rule__JvmUpperBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1517:2: rule__JvmUpperBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__13024);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1523:1: rule__JvmUpperBound__Group__1__Impl : ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1527:1: ( ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1528:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1528:1: ( ( rule__JvmUpperBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1529:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1530:1: ( rule__JvmUpperBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1530:2: rule__JvmUpperBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl3051);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1544:1: rule__JvmUpperBoundAnded__Group__0 : rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 ;
    public final void rule__JvmUpperBoundAnded__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1548:1: ( rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1549:2: rule__JvmUpperBoundAnded__Group__0__Impl rule__JvmUpperBoundAnded__Group__1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__03085);
            rule__JvmUpperBoundAnded__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__03088);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1556:1: rule__JvmUpperBoundAnded__Group__0__Impl : ( '&' ) ;
    public final void rule__JvmUpperBoundAnded__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1560:1: ( ( '&' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1561:1: ( '&' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1561:1: ( '&' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1562:1: '&'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getAmpersandKeyword_0()); 
            }
            match(input,20,FOLLOW_20_in_rule__JvmUpperBoundAnded__Group__0__Impl3116); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1575:1: rule__JvmUpperBoundAnded__Group__1 : rule__JvmUpperBoundAnded__Group__1__Impl ;
    public final void rule__JvmUpperBoundAnded__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1579:1: ( rule__JvmUpperBoundAnded__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1580:2: rule__JvmUpperBoundAnded__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__13147);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1586:1: rule__JvmUpperBoundAnded__Group__1__Impl : ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmUpperBoundAnded__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1590:1: ( ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1591:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1591:1: ( ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1592:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1593:1: ( rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1593:2: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl3174);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1607:1: rule__JvmLowerBound__Group__0 : rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 ;
    public final void rule__JvmLowerBound__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1611:1: ( rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1612:2: rule__JvmLowerBound__Group__0__Impl rule__JvmLowerBound__Group__1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__03208);
            rule__JvmLowerBound__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__03211);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1619:1: rule__JvmLowerBound__Group__0__Impl : ( 'super' ) ;
    public final void rule__JvmLowerBound__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1623:1: ( ( 'super' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1624:1: ( 'super' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1624:1: ( 'super' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1625:1: 'super'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getSuperKeyword_0()); 
            }
            match(input,21,FOLLOW_21_in_rule__JvmLowerBound__Group__0__Impl3239); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1638:1: rule__JvmLowerBound__Group__1 : rule__JvmLowerBound__Group__1__Impl ;
    public final void rule__JvmLowerBound__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1642:1: ( rule__JvmLowerBound__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1643:2: rule__JvmLowerBound__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__13270);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1649:1: rule__JvmLowerBound__Group__1__Impl : ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) ;
    public final void rule__JvmLowerBound__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1653:1: ( ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1654:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1654:1: ( ( rule__JvmLowerBound__TypeReferenceAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1655:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1656:1: ( rule__JvmLowerBound__TypeReferenceAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1656:2: rule__JvmLowerBound__TypeReferenceAssignment_1
            {
            pushFollow(FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl3297);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1672:1: rule__QualifiedName__Group__0 : rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 ;
    public final void rule__QualifiedName__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1676:1: ( rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1677:2: rule__QualifiedName__Group__0__Impl rule__QualifiedName__Group__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03333);
            rule__QualifiedName__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03336);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1684:1: rule__QualifiedName__Group__0__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1688:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1689:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1689:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1690:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl3363);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1701:1: rule__QualifiedName__Group__1 : rule__QualifiedName__Group__1__Impl ;
    public final void rule__QualifiedName__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1705:1: ( rule__QualifiedName__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1706:2: rule__QualifiedName__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13392);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1712:1: rule__QualifiedName__Group__1__Impl : ( ( rule__QualifiedName__Group_1__0 )* ) ;
    public final void rule__QualifiedName__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1716:1: ( ( ( rule__QualifiedName__Group_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1717:1: ( ( rule__QualifiedName__Group_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1717:1: ( ( rule__QualifiedName__Group_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1718:1: ( rule__QualifiedName__Group_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1719:1: ( rule__QualifiedName__Group_1__0 )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==22) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1719:2: rule__QualifiedName__Group_1__0
            	    {
            	    pushFollow(FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3419);
            	    rule__QualifiedName__Group_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop13;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1733:1: rule__QualifiedName__Group_1__0 : rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 ;
    public final void rule__QualifiedName__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1737:1: ( rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1738:2: rule__QualifiedName__Group_1__0__Impl rule__QualifiedName__Group_1__1
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03454);
            rule__QualifiedName__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03457);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1745:1: rule__QualifiedName__Group_1__0__Impl : ( '.' ) ;
    public final void rule__QualifiedName__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1749:1: ( ( '.' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1750:1: ( '.' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1750:1: ( '.' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1751:1: '.'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0()); 
            }
            match(input,22,FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl3485); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1764:1: rule__QualifiedName__Group_1__1 : rule__QualifiedName__Group_1__1__Impl ;
    public final void rule__QualifiedName__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1768:1: ( rule__QualifiedName__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1769:2: rule__QualifiedName__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13516);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1775:1: rule__QualifiedName__Group_1__1__Impl : ( ruleValidID ) ;
    public final void rule__QualifiedName__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1779:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1780:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1780:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1781:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getQualifiedNameAccess().getValidIDParserRuleCall_1_1()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3543);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1798:1: rule__XImportDeclaration1__Group__0 : rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1 ;
    public final void rule__XImportDeclaration1__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1802:1: ( rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1803:2: rule__XImportDeclaration1__Group__0__Impl rule__XImportDeclaration1__Group__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__0__Impl_in_rule__XImportDeclaration1__Group__03578);
            rule__XImportDeclaration1__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__1_in_rule__XImportDeclaration1__Group__03581);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1810:1: rule__XImportDeclaration1__Group__0__Impl : ( () ) ;
    public final void rule__XImportDeclaration1__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1814:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1815:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1815:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1816:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getXImportDeclaration1Action_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1817:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1819:1: 
            {
            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getXImportDeclaration1Action_0()); 
            }

            }


            }

        }
        finally {

            	restoreStackSize(stackSize);

        }
        return ;
    }
    // $ANTLR end "rule__XImportDeclaration1__Group__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1829:1: rule__XImportDeclaration1__Group__1 : rule__XImportDeclaration1__Group__1__Impl rule__XImportDeclaration1__Group__2 ;
    public final void rule__XImportDeclaration1__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1833:1: ( rule__XImportDeclaration1__Group__1__Impl rule__XImportDeclaration1__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1834:2: rule__XImportDeclaration1__Group__1__Impl rule__XImportDeclaration1__Group__2
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__1__Impl_in_rule__XImportDeclaration1__Group__13639);
            rule__XImportDeclaration1__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__2_in_rule__XImportDeclaration1__Group__13642);
            rule__XImportDeclaration1__Group__2();

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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1841:1: rule__XImportDeclaration1__Group__1__Impl : ( 'import' ) ;
    public final void rule__XImportDeclaration1__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1845:1: ( ( 'import' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1846:1: ( 'import' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1846:1: ( 'import' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1847:1: 'import'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportKeyword_1()); 
            }
            match(input,23,FOLLOW_23_in_rule__XImportDeclaration1__Group__1__Impl3670); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportKeyword_1()); 
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


    // $ANTLR start "rule__XImportDeclaration1__Group__2"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1860:1: rule__XImportDeclaration1__Group__2 : rule__XImportDeclaration1__Group__2__Impl rule__XImportDeclaration1__Group__3 ;
    public final void rule__XImportDeclaration1__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1864:1: ( rule__XImportDeclaration1__Group__2__Impl rule__XImportDeclaration1__Group__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1865:2: rule__XImportDeclaration1__Group__2__Impl rule__XImportDeclaration1__Group__3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__2__Impl_in_rule__XImportDeclaration1__Group__23701);
            rule__XImportDeclaration1__Group__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__3_in_rule__XImportDeclaration1__Group__23704);
            rule__XImportDeclaration1__Group__3();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__2"


    // $ANTLR start "rule__XImportDeclaration1__Group__2__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1872:1: rule__XImportDeclaration1__Group__2__Impl : ( '{' ) ;
    public final void rule__XImportDeclaration1__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1876:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1877:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1877:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1878:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_2()); 
            }
            match(input,24,FOLLOW_24_in_rule__XImportDeclaration1__Group__2__Impl3732); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getLeftCurlyBracketKeyword_2()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__2__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__3"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1891:1: rule__XImportDeclaration1__Group__3 : rule__XImportDeclaration1__Group__3__Impl rule__XImportDeclaration1__Group__4 ;
    public final void rule__XImportDeclaration1__Group__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1895:1: ( rule__XImportDeclaration1__Group__3__Impl rule__XImportDeclaration1__Group__4 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1896:2: rule__XImportDeclaration1__Group__3__Impl rule__XImportDeclaration1__Group__4
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__3__Impl_in_rule__XImportDeclaration1__Group__33763);
            rule__XImportDeclaration1__Group__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__4_in_rule__XImportDeclaration1__Group__33766);
            rule__XImportDeclaration1__Group__4();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__3"


    // $ANTLR start "rule__XImportDeclaration1__Group__3__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1903:1: rule__XImportDeclaration1__Group__3__Impl : ( ( rule__XImportDeclaration1__Alternatives_3 ) ) ;
    public final void rule__XImportDeclaration1__Group__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1907:1: ( ( ( rule__XImportDeclaration1__Alternatives_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1908:1: ( ( rule__XImportDeclaration1__Alternatives_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1908:1: ( ( rule__XImportDeclaration1__Alternatives_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1909:1: ( rule__XImportDeclaration1__Alternatives_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAlternatives_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1910:1: ( rule__XImportDeclaration1__Alternatives_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1910:2: rule__XImportDeclaration1__Alternatives_3
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Alternatives_3_in_rule__XImportDeclaration1__Group__3__Impl3793);
            rule__XImportDeclaration1__Alternatives_3();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAlternatives_3()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__3__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__4"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1920:1: rule__XImportDeclaration1__Group__4 : rule__XImportDeclaration1__Group__4__Impl rule__XImportDeclaration1__Group__5 ;
    public final void rule__XImportDeclaration1__Group__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1924:1: ( rule__XImportDeclaration1__Group__4__Impl rule__XImportDeclaration1__Group__5 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1925:2: rule__XImportDeclaration1__Group__4__Impl rule__XImportDeclaration1__Group__5
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__4__Impl_in_rule__XImportDeclaration1__Group__43823);
            rule__XImportDeclaration1__Group__4__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__5_in_rule__XImportDeclaration1__Group__43826);
            rule__XImportDeclaration1__Group__5();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__4"


    // $ANTLR start "rule__XImportDeclaration1__Group__4__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1932:1: rule__XImportDeclaration1__Group__4__Impl : ( '}' ) ;
    public final void rule__XImportDeclaration1__Group__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1936:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1937:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1937:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1938:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_4()); 
            }
            match(input,25,FOLLOW_25_in_rule__XImportDeclaration1__Group__4__Impl3854); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getRightCurlyBracketKeyword_4()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__4__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__5"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1951:1: rule__XImportDeclaration1__Group__5 : rule__XImportDeclaration1__Group__5__Impl rule__XImportDeclaration1__Group__6 ;
    public final void rule__XImportDeclaration1__Group__5() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1955:1: ( rule__XImportDeclaration1__Group__5__Impl rule__XImportDeclaration1__Group__6 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1956:2: rule__XImportDeclaration1__Group__5__Impl rule__XImportDeclaration1__Group__6
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__5__Impl_in_rule__XImportDeclaration1__Group__53885);
            rule__XImportDeclaration1__Group__5__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__6_in_rule__XImportDeclaration1__Group__53888);
            rule__XImportDeclaration1__Group__6();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__5"


    // $ANTLR start "rule__XImportDeclaration1__Group__5__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1963:1: rule__XImportDeclaration1__Group__5__Impl : ( 'as' ) ;
    public final void rule__XImportDeclaration1__Group__5__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1967:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1968:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1968:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1969:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getAsKeyword_5()); 
            }
            match(input,26,FOLLOW_26_in_rule__XImportDeclaration1__Group__5__Impl3916); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getAsKeyword_5()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__5__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__6"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1982:1: rule__XImportDeclaration1__Group__6 : rule__XImportDeclaration1__Group__6__Impl rule__XImportDeclaration1__Group__7 ;
    public final void rule__XImportDeclaration1__Group__6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1986:1: ( rule__XImportDeclaration1__Group__6__Impl rule__XImportDeclaration1__Group__7 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1987:2: rule__XImportDeclaration1__Group__6__Impl rule__XImportDeclaration1__Group__7
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__6__Impl_in_rule__XImportDeclaration1__Group__63947);
            rule__XImportDeclaration1__Group__6__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__7_in_rule__XImportDeclaration1__Group__63950);
            rule__XImportDeclaration1__Group__7();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__6"


    // $ANTLR start "rule__XImportDeclaration1__Group__6__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1994:1: rule__XImportDeclaration1__Group__6__Impl : ( ( rule__XImportDeclaration1__NameAssignment_6 ) ) ;
    public final void rule__XImportDeclaration1__Group__6__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1998:1: ( ( ( rule__XImportDeclaration1__NameAssignment_6 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1999:1: ( ( rule__XImportDeclaration1__NameAssignment_6 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1999:1: ( ( rule__XImportDeclaration1__NameAssignment_6 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2000:1: ( rule__XImportDeclaration1__NameAssignment_6 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getNameAssignment_6()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2001:1: ( rule__XImportDeclaration1__NameAssignment_6 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2001:2: rule__XImportDeclaration1__NameAssignment_6
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__NameAssignment_6_in_rule__XImportDeclaration1__Group__6__Impl3977);
            rule__XImportDeclaration1__NameAssignment_6();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getNameAssignment_6()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__6__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__7"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2011:1: rule__XImportDeclaration1__Group__7 : rule__XImportDeclaration1__Group__7__Impl rule__XImportDeclaration1__Group__8 ;
    public final void rule__XImportDeclaration1__Group__7() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2015:1: ( rule__XImportDeclaration1__Group__7__Impl rule__XImportDeclaration1__Group__8 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2016:2: rule__XImportDeclaration1__Group__7__Impl rule__XImportDeclaration1__Group__8
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__7__Impl_in_rule__XImportDeclaration1__Group__74007);
            rule__XImportDeclaration1__Group__7__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__8_in_rule__XImportDeclaration1__Group__74010);
            rule__XImportDeclaration1__Group__8();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__7"


    // $ANTLR start "rule__XImportDeclaration1__Group__7__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2023:1: rule__XImportDeclaration1__Group__7__Impl : ( 'from' ) ;
    public final void rule__XImportDeclaration1__Group__7__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2027:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2028:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2028:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2029:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getFromKeyword_7()); 
            }
            match(input,27,FOLLOW_27_in_rule__XImportDeclaration1__Group__7__Impl4038); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getFromKeyword_7()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__7__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group__8"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2042:1: rule__XImportDeclaration1__Group__8 : rule__XImportDeclaration1__Group__8__Impl ;
    public final void rule__XImportDeclaration1__Group__8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2046:1: ( rule__XImportDeclaration1__Group__8__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2047:2: rule__XImportDeclaration1__Group__8__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group__8__Impl_in_rule__XImportDeclaration1__Group__84069);
            rule__XImportDeclaration1__Group__8__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group__8"


    // $ANTLR start "rule__XImportDeclaration1__Group__8__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2053:1: rule__XImportDeclaration1__Group__8__Impl : ( ( rule__XImportDeclaration1__ImportURIAssignment_8 ) ) ;
    public final void rule__XImportDeclaration1__Group__8__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2057:1: ( ( ( rule__XImportDeclaration1__ImportURIAssignment_8 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2058:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_8 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2058:1: ( ( rule__XImportDeclaration1__ImportURIAssignment_8 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2059:1: ( rule__XImportDeclaration1__ImportURIAssignment_8 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_8()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2060:1: ( rule__XImportDeclaration1__ImportURIAssignment_8 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2060:2: rule__XImportDeclaration1__ImportURIAssignment_8
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_8_in_rule__XImportDeclaration1__Group__8__Impl4096);
            rule__XImportDeclaration1__ImportURIAssignment_8();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURIAssignment_8()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group__8__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2088:1: rule__XImportDeclaration1__Group_3_0__0 : rule__XImportDeclaration1__Group_3_0__0__Impl rule__XImportDeclaration1__Group_3_0__1 ;
    public final void rule__XImportDeclaration1__Group_3_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2092:1: ( rule__XImportDeclaration1__Group_3_0__0__Impl rule__XImportDeclaration1__Group_3_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2093:2: rule__XImportDeclaration1__Group_3_0__0__Impl rule__XImportDeclaration1__Group_3_0__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0__0__Impl_in_rule__XImportDeclaration1__Group_3_0__04144);
            rule__XImportDeclaration1__Group_3_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0__1_in_rule__XImportDeclaration1__Group_3_0__04147);
            rule__XImportDeclaration1__Group_3_0__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2100:1: rule__XImportDeclaration1__Group_3_0__0__Impl : ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 ) ) ;
    public final void rule__XImportDeclaration1__Group_3_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2104:1: ( ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2105:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2105:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2106:1: ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2107:1: ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2107:2: rule__XImportDeclaration1__ImportItemsAssignment_3_0_0
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_3_0_0_in_rule__XImportDeclaration1__Group_3_0__0__Impl4174);
            rule__XImportDeclaration1__ImportItemsAssignment_3_0_0();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2117:1: rule__XImportDeclaration1__Group_3_0__1 : rule__XImportDeclaration1__Group_3_0__1__Impl ;
    public final void rule__XImportDeclaration1__Group_3_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2121:1: ( rule__XImportDeclaration1__Group_3_0__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2122:2: rule__XImportDeclaration1__Group_3_0__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0__1__Impl_in_rule__XImportDeclaration1__Group_3_0__14204);
            rule__XImportDeclaration1__Group_3_0__1__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2128:1: rule__XImportDeclaration1__Group_3_0__1__Impl : ( ( rule__XImportDeclaration1__Group_3_0_1__0 )* ) ;
    public final void rule__XImportDeclaration1__Group_3_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2132:1: ( ( ( rule__XImportDeclaration1__Group_3_0_1__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2133:1: ( ( rule__XImportDeclaration1__Group_3_0_1__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2133:1: ( ( rule__XImportDeclaration1__Group_3_0_1__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2134:1: ( rule__XImportDeclaration1__Group_3_0_1__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getGroup_3_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2135:1: ( rule__XImportDeclaration1__Group_3_0_1__0 )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==15) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2135:2: rule__XImportDeclaration1__Group_3_0_1__0
            	    {
            	    pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0_1__0_in_rule__XImportDeclaration1__Group_3_0__1__Impl4231);
            	    rule__XImportDeclaration1__Group_3_0_1__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop14;
                }
            } while (true);

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getGroup_3_0_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0__1__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0_1__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2149:1: rule__XImportDeclaration1__Group_3_0_1__0 : rule__XImportDeclaration1__Group_3_0_1__0__Impl rule__XImportDeclaration1__Group_3_0_1__1 ;
    public final void rule__XImportDeclaration1__Group_3_0_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2153:1: ( rule__XImportDeclaration1__Group_3_0_1__0__Impl rule__XImportDeclaration1__Group_3_0_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2154:2: rule__XImportDeclaration1__Group_3_0_1__0__Impl rule__XImportDeclaration1__Group_3_0_1__1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0_1__0__Impl_in_rule__XImportDeclaration1__Group_3_0_1__04266);
            rule__XImportDeclaration1__Group_3_0_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0_1__1_in_rule__XImportDeclaration1__Group_3_0_1__04269);
            rule__XImportDeclaration1__Group_3_0_1__1();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0_1__0"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0_1__0__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2161:1: rule__XImportDeclaration1__Group_3_0_1__0__Impl : ( ',' ) ;
    public final void rule__XImportDeclaration1__Group_3_0_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2165:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2166:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2166:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2167:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getCommaKeyword_3_0_1_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XImportDeclaration1__Group_3_0_1__0__Impl4297); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getCommaKeyword_3_0_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0_1__0__Impl"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0_1__1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2180:1: rule__XImportDeclaration1__Group_3_0_1__1 : rule__XImportDeclaration1__Group_3_0_1__1__Impl ;
    public final void rule__XImportDeclaration1__Group_3_0_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2184:1: ( rule__XImportDeclaration1__Group_3_0_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2185:2: rule__XImportDeclaration1__Group_3_0_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__Group_3_0_1__1__Impl_in_rule__XImportDeclaration1__Group_3_0_1__14328);
            rule__XImportDeclaration1__Group_3_0_1__1__Impl();

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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0_1__1"


    // $ANTLR start "rule__XImportDeclaration1__Group_3_0_1__1__Impl"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2191:1: rule__XImportDeclaration1__Group_3_0_1__1__Impl : ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 ) ) ;
    public final void rule__XImportDeclaration1__Group_3_0_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2195:1: ( ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2196:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2196:1: ( ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2197:1: ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2198:1: ( rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2198:2: rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1
            {
            pushFollow(FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1_in_rule__XImportDeclaration1__Group_3_0_1__1__Impl4355);
            rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1();

            state._fsp--;
            if (state.failed) return ;

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsAssignment_3_0_1_1()); 
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
    // $ANTLR end "rule__XImportDeclaration1__Group_3_0_1__1__Impl"


    // $ANTLR start "rule__XImportItem__Group__0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2212:1: rule__XImportItem__Group__0 : rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 ;
    public final void rule__XImportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2216:1: ( rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2217:2: rule__XImportItem__Group__0__Impl rule__XImportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__04389);
            rule__XImportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__04392);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2224:1: rule__XImportItem__Group__0__Impl : ( () ) ;
    public final void rule__XImportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2228:1: ( ( () ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2229:1: ( () )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2229:1: ( () )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2230:1: ()
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getXImportItemAction_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2231:1: ()
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2233:1: 
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2243:1: rule__XImportItem__Group__1 : rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 ;
    public final void rule__XImportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2247:1: ( rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2248:2: rule__XImportItem__Group__1__Impl rule__XImportItem__Group__2
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__14450);
            rule__XImportItem__Group__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__14453);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2255:1: rule__XImportItem__Group__1__Impl : ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) ;
    public final void rule__XImportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2259:1: ( ( ( rule__XImportItem__ImportedIdAssignment_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2260:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2260:1: ( ( rule__XImportItem__ImportedIdAssignment_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2261:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdAssignment_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2262:1: ( rule__XImportItem__ImportedIdAssignment_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2262:2: rule__XImportItem__ImportedIdAssignment_1
            {
            pushFollow(FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl4480);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2272:1: rule__XImportItem__Group__2 : rule__XImportItem__Group__2__Impl ;
    public final void rule__XImportItem__Group__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2276:1: ( rule__XImportItem__Group__2__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2277:2: rule__XImportItem__Group__2__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__24510);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2283:1: rule__XImportItem__Group__2__Impl : ( ( rule__XImportItem__Group_2__0 )? ) ;
    public final void rule__XImportItem__Group__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2287:1: ( ( ( rule__XImportItem__Group_2__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2288:1: ( ( rule__XImportItem__Group_2__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2288:1: ( ( rule__XImportItem__Group_2__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2289:1: ( rule__XImportItem__Group_2__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getGroup_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2290:1: ( rule__XImportItem__Group_2__0 )?
            int alt15=2;
            int LA15_0 = input.LA(1);

            if ( (LA15_0==26) ) {
                alt15=1;
            }
            switch (alt15) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2290:2: rule__XImportItem__Group_2__0
                    {
                    pushFollow(FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl4537);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2306:1: rule__XImportItem__Group_2__0 : rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 ;
    public final void rule__XImportItem__Group_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2310:1: ( rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2311:2: rule__XImportItem__Group_2__0__Impl rule__XImportItem__Group_2__1
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__04574);
            rule__XImportItem__Group_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__04577);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2318:1: rule__XImportItem__Group_2__0__Impl : ( 'as' ) ;
    public final void rule__XImportItem__Group_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2322:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2323:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2323:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2324:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAsKeyword_2_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__XImportItem__Group_2__0__Impl4605); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2337:1: rule__XImportItem__Group_2__1 : rule__XImportItem__Group_2__1__Impl ;
    public final void rule__XImportItem__Group_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2341:1: ( rule__XImportItem__Group_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2342:2: rule__XImportItem__Group_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__14636);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2348:1: rule__XImportItem__Group_2__1__Impl : ( ( rule__XImportItem__AliasAssignment_2_1 ) ) ;
    public final void rule__XImportItem__Group_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2352:1: ( ( ( rule__XImportItem__AliasAssignment_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2353:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2353:1: ( ( rule__XImportItem__AliasAssignment_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2354:1: ( rule__XImportItem__AliasAssignment_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasAssignment_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2355:1: ( rule__XImportItem__AliasAssignment_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2355:2: rule__XImportItem__AliasAssignment_2_1
            {
            pushFollow(FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl4663);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2370:1: rule__XExportDeclaration__Group__0 : rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 ;
    public final void rule__XExportDeclaration__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2374:1: ( rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2375:2: rule__XExportDeclaration__Group__0__Impl rule__XExportDeclaration__Group__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__04698);
            rule__XExportDeclaration__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__04701);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2382:1: rule__XExportDeclaration__Group__0__Impl : ( 'export' ) ;
    public final void rule__XExportDeclaration__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2386:1: ( ( 'export' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2387:1: ( 'export' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2387:1: ( 'export' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2388:1: 'export'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportKeyword_0()); 
            }
            match(input,28,FOLLOW_28_in_rule__XExportDeclaration__Group__0__Impl4729); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2401:1: rule__XExportDeclaration__Group__1 : rule__XExportDeclaration__Group__1__Impl ;
    public final void rule__XExportDeclaration__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2405:1: ( rule__XExportDeclaration__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2406:2: rule__XExportDeclaration__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14760);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2412:1: rule__XExportDeclaration__Group__1__Impl : ( ( rule__XExportDeclaration__Alternatives_1 ) ) ;
    public final void rule__XExportDeclaration__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2416:1: ( ( ( rule__XExportDeclaration__Alternatives_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2417:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2417:1: ( ( rule__XExportDeclaration__Alternatives_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2418:1: ( rule__XExportDeclaration__Alternatives_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAlternatives_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2419:1: ( rule__XExportDeclaration__Alternatives_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2419:2: rule__XExportDeclaration__Alternatives_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4787);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2433:1: rule__XExportDeclaration__Group_1_0__0 : rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 ;
    public final void rule__XExportDeclaration__Group_1_0__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2437:1: ( rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2438:2: rule__XExportDeclaration__Group_1_0__0__Impl rule__XExportDeclaration__Group_1_0__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04821);
            rule__XExportDeclaration__Group_1_0__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04824);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2445:1: rule__XExportDeclaration__Group_1_0__0__Impl : ( '{' ) ;
    public final void rule__XExportDeclaration__Group_1_0__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2449:1: ( ( '{' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2450:1: ( '{' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2450:1: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2451:1: '{'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getLeftCurlyBracketKeyword_1_0_0()); 
            }
            match(input,24,FOLLOW_24_in_rule__XExportDeclaration__Group_1_0__0__Impl4852); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2464:1: rule__XExportDeclaration__Group_1_0__1 : rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 ;
    public final void rule__XExportDeclaration__Group_1_0__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2468:1: ( rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2469:2: rule__XExportDeclaration__Group_1_0__1__Impl rule__XExportDeclaration__Group_1_0__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__14883);
            rule__XExportDeclaration__Group_1_0__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__14886);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2476:1: rule__XExportDeclaration__Group_1_0__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2480:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2481:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2481:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2482:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2483:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2483:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl4913);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2493:1: rule__XExportDeclaration__Group_1_0__2 : rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 ;
    public final void rule__XExportDeclaration__Group_1_0__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2497:1: ( rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2498:2: rule__XExportDeclaration__Group_1_0__2__Impl rule__XExportDeclaration__Group_1_0__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__24943);
            rule__XExportDeclaration__Group_1_0__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__24946);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2505:1: rule__XExportDeclaration__Group_1_0__2__Impl : ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) ;
    public final void rule__XExportDeclaration__Group_1_0__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2509:1: ( ( ( rule__XExportDeclaration__Group_1_0_2__0 )* ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2510:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2510:1: ( ( rule__XExportDeclaration__Group_1_0_2__0 )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2511:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_2()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2512:1: ( rule__XExportDeclaration__Group_1_0_2__0 )*
            loop16:
            do {
                int alt16=2;
                int LA16_0 = input.LA(1);

                if ( (LA16_0==15) ) {
                    alt16=1;
                }


                switch (alt16) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2512:2: rule__XExportDeclaration__Group_1_0_2__0
            	    {
            	    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl4973);
            	    rule__XExportDeclaration__Group_1_0_2__0();

            	    state._fsp--;
            	    if (state.failed) return ;

            	    }
            	    break;

            	default :
            	    break loop16;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2522:1: rule__XExportDeclaration__Group_1_0__3 : rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 ;
    public final void rule__XExportDeclaration__Group_1_0__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2526:1: ( rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2527:2: rule__XExportDeclaration__Group_1_0__3__Impl rule__XExportDeclaration__Group_1_0__4
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__35004);
            rule__XExportDeclaration__Group_1_0__3__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__35007);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2534:1: rule__XExportDeclaration__Group_1_0__3__Impl : ( '}' ) ;
    public final void rule__XExportDeclaration__Group_1_0__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2538:1: ( ( '}' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2539:1: ( '}' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2539:1: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2540:1: '}'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getRightCurlyBracketKeyword_1_0_3()); 
            }
            match(input,25,FOLLOW_25_in_rule__XExportDeclaration__Group_1_0__3__Impl5035); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2553:1: rule__XExportDeclaration__Group_1_0__4 : rule__XExportDeclaration__Group_1_0__4__Impl ;
    public final void rule__XExportDeclaration__Group_1_0__4() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2557:1: ( rule__XExportDeclaration__Group_1_0__4__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2558:2: rule__XExportDeclaration__Group_1_0__4__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__45066);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2564:1: rule__XExportDeclaration__Group_1_0__4__Impl : ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) ;
    public final void rule__XExportDeclaration__Group_1_0__4__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2568:1: ( ( ( rule__XExportDeclaration__Group_1_0_4__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2569:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2569:1: ( ( rule__XExportDeclaration__Group_1_0_4__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2570:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getGroup_1_0_4()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2571:1: ( rule__XExportDeclaration__Group_1_0_4__0 )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==27) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2571:2: rule__XExportDeclaration__Group_1_0_4__0
                    {
                    pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl5093);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2591:1: rule__XExportDeclaration__Group_1_0_2__0 : rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 ;
    public final void rule__XExportDeclaration__Group_1_0_2__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2595:1: ( rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2596:2: rule__XExportDeclaration__Group_1_0_2__0__Impl rule__XExportDeclaration__Group_1_0_2__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__05134);
            rule__XExportDeclaration__Group_1_0_2__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__05137);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2603:1: rule__XExportDeclaration__Group_1_0_2__0__Impl : ( ',' ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2607:1: ( ( ',' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2608:1: ( ',' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2608:1: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2609:1: ','
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getCommaKeyword_1_0_2_0()); 
            }
            match(input,15,FOLLOW_15_in_rule__XExportDeclaration__Group_1_0_2__0__Impl5165); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2622:1: rule__XExportDeclaration__Group_1_0_2__1 : rule__XExportDeclaration__Group_1_0_2__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_2__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2626:1: ( rule__XExportDeclaration__Group_1_0_2__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2627:2: rule__XExportDeclaration__Group_1_0_2__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__15196);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2633:1: rule__XExportDeclaration__Group_1_0_2__1__Impl : ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_2__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2637:1: ( ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2638:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2638:1: ( ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2639:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsAssignment_1_0_2_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2640:1: ( rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2640:2: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl5223);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2654:1: rule__XExportDeclaration__Group_1_0_4__0 : rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 ;
    public final void rule__XExportDeclaration__Group_1_0_4__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2658:1: ( rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2659:2: rule__XExportDeclaration__Group_1_0_4__0__Impl rule__XExportDeclaration__Group_1_0_4__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__05257);
            rule__XExportDeclaration__Group_1_0_4__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__05260);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2666:1: rule__XExportDeclaration__Group_1_0_4__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2670:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2671:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2671:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2672:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_0_4_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__XExportDeclaration__Group_1_0_4__0__Impl5288); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2685:1: rule__XExportDeclaration__Group_1_0_4__1 : rule__XExportDeclaration__Group_1_0_4__1__Impl ;
    public final void rule__XExportDeclaration__Group_1_0_4__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2689:1: ( rule__XExportDeclaration__Group_1_0_4__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2690:2: rule__XExportDeclaration__Group_1_0_4__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__15319);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2696:1: rule__XExportDeclaration__Group_1_0_4__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_0_4__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2700:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2701:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2701:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2702:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_0_4_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2703:1: ( rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2703:2: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl5346);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2717:1: rule__XExportDeclaration__Group_1_1__0 : rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 ;
    public final void rule__XExportDeclaration__Group_1_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2721:1: ( rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2722:2: rule__XExportDeclaration__Group_1_1__0__Impl rule__XExportDeclaration__Group_1_1__1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__05380);
            rule__XExportDeclaration__Group_1_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__05383);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2729:1: rule__XExportDeclaration__Group_1_1__0__Impl : ( 'from' ) ;
    public final void rule__XExportDeclaration__Group_1_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2733:1: ( ( 'from' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2734:1: ( 'from' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2734:1: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2735:1: 'from'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getFromKeyword_1_1_0()); 
            }
            match(input,27,FOLLOW_27_in_rule__XExportDeclaration__Group_1_1__0__Impl5411); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2748:1: rule__XExportDeclaration__Group_1_1__1 : rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 ;
    public final void rule__XExportDeclaration__Group_1_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2752:1: ( rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2753:2: rule__XExportDeclaration__Group_1_1__1__Impl rule__XExportDeclaration__Group_1_1__2
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__15442);
            rule__XExportDeclaration__Group_1_1__1__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__15445);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2760:1: rule__XExportDeclaration__Group_1_1__1__Impl : ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2764:1: ( ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2765:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2765:1: ( ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2766:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURIAssignment_1_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2767:1: ( rule__XExportDeclaration__ImportURIAssignment_1_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2767:2: rule__XExportDeclaration__ImportURIAssignment_1_1_1
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl5472);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2777:1: rule__XExportDeclaration__Group_1_1__2 : rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 ;
    public final void rule__XExportDeclaration__Group_1_1__2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2781:1: ( rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2782:2: rule__XExportDeclaration__Group_1_1__2__Impl rule__XExportDeclaration__Group_1_1__3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__25502);
            rule__XExportDeclaration__Group_1_1__2__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__25505);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2789:1: rule__XExportDeclaration__Group_1_1__2__Impl : ( 'as' ) ;
    public final void rule__XExportDeclaration__Group_1_1__2__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2793:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2794:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2794:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2795:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAsKeyword_1_1_2()); 
            }
            match(input,26,FOLLOW_26_in_rule__XExportDeclaration__Group_1_1__2__Impl5533); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2808:1: rule__XExportDeclaration__Group_1_1__3 : rule__XExportDeclaration__Group_1_1__3__Impl ;
    public final void rule__XExportDeclaration__Group_1_1__3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2812:1: ( rule__XExportDeclaration__Group_1_1__3__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2813:2: rule__XExportDeclaration__Group_1_1__3__Impl
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__35564);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2819:1: rule__XExportDeclaration__Group_1_1__3__Impl : ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) ;
    public final void rule__XExportDeclaration__Group_1_1__3__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2823:1: ( ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2824:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2824:1: ( ( rule__XExportDeclaration__AliasAssignment_1_1_3 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2825:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasAssignment_1_1_3()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2826:1: ( rule__XExportDeclaration__AliasAssignment_1_1_3 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2826:2: rule__XExportDeclaration__AliasAssignment_1_1_3
            {
            pushFollow(FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl5591);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2844:1: rule__XExportItem__Group__0 : rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 ;
    public final void rule__XExportItem__Group__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2848:1: ( rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2849:2: rule__XExportItem__Group__0__Impl rule__XExportItem__Group__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__05629);
            rule__XExportItem__Group__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__05632);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2856:1: rule__XExportItem__Group__0__Impl : ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) ;
    public final void rule__XExportItem__Group__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2860:1: ( ( ( rule__XExportItem__ExportedIdAssignment_0 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2861:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2861:1: ( ( rule__XExportItem__ExportedIdAssignment_0 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2862:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdAssignment_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2863:1: ( rule__XExportItem__ExportedIdAssignment_0 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2863:2: rule__XExportItem__ExportedIdAssignment_0
            {
            pushFollow(FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl5659);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2873:1: rule__XExportItem__Group__1 : rule__XExportItem__Group__1__Impl ;
    public final void rule__XExportItem__Group__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2877:1: ( rule__XExportItem__Group__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2878:2: rule__XExportItem__Group__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__15689);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2884:1: rule__XExportItem__Group__1__Impl : ( ( rule__XExportItem__Group_1__0 )? ) ;
    public final void rule__XExportItem__Group__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2888:1: ( ( ( rule__XExportItem__Group_1__0 )? ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2889:1: ( ( rule__XExportItem__Group_1__0 )? )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2889:1: ( ( rule__XExportItem__Group_1__0 )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2890:1: ( rule__XExportItem__Group_1__0 )?
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getGroup_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2891:1: ( rule__XExportItem__Group_1__0 )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==26) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2891:2: rule__XExportItem__Group_1__0
                    {
                    pushFollow(FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl5716);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2905:1: rule__XExportItem__Group_1__0 : rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 ;
    public final void rule__XExportItem__Group_1__0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2909:1: ( rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2910:2: rule__XExportItem__Group_1__0__Impl rule__XExportItem__Group_1__1
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05751);
            rule__XExportItem__Group_1__0__Impl();

            state._fsp--;
            if (state.failed) return ;
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05754);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2917:1: rule__XExportItem__Group_1__0__Impl : ( 'as' ) ;
    public final void rule__XExportItem__Group_1__0__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2921:1: ( ( 'as' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2922:1: ( 'as' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2922:1: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2923:1: 'as'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAsKeyword_1_0()); 
            }
            match(input,26,FOLLOW_26_in_rule__XExportItem__Group_1__0__Impl5782); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2936:1: rule__XExportItem__Group_1__1 : rule__XExportItem__Group_1__1__Impl ;
    public final void rule__XExportItem__Group_1__1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2940:1: ( rule__XExportItem__Group_1__1__Impl )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2941:2: rule__XExportItem__Group_1__1__Impl
            {
            pushFollow(FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15813);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2947:1: rule__XExportItem__Group_1__1__Impl : ( ( rule__XExportItem__AliasAssignment_1_1 ) ) ;
    public final void rule__XExportItem__Group_1__1__Impl() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2951:1: ( ( ( rule__XExportItem__AliasAssignment_1_1 ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2952:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2952:1: ( ( rule__XExportItem__AliasAssignment_1_1 ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2953:1: ( rule__XExportItem__AliasAssignment_1_1 )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasAssignment_1_1()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2954:1: ( rule__XExportItem__AliasAssignment_1_1 )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2954:2: rule__XExportItem__AliasAssignment_1_1
            {
            pushFollow(FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl5840);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2969:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2973:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2974:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2974:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2975:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_05879);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2984:1: rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2988:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2989:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2989:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2990:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getParamTypesJvmTypeReferenceParserRuleCall_0_1_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_15910);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:2999:1: rule__XFunctionTypeRef__ReturnTypeAssignment_2 : ( ruleJvmTypeReference ) ;
    public final void rule__XFunctionTypeRef__ReturnTypeAssignment_2() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3003:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3004:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3004:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3005:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXFunctionTypeRefAccess().getReturnTypeJvmTypeReferenceParserRuleCall_2_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ReturnTypeAssignment_25941);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3014:1: rule__JvmParameterizedTypeReference__TypeAssignment_0 : ( ( ruleQualifiedName ) ) ;
    public final void rule__JvmParameterizedTypeReference__TypeAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3018:1: ( ( ( ruleQualifiedName ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3019:1: ( ( ruleQualifiedName ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3019:1: ( ( ruleQualifiedName ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3020:1: ( ruleQualifiedName )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3021:1: ( ruleQualifiedName )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3022:1: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getTypeJvmTypeQualifiedNameParserRuleCall_0_0_1()); 
            }
            pushFollow(FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_05976);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3033:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3037:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3038:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3038:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3039:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_16011);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3048:1: rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1 : ( ruleJvmArgumentTypeReference ) ;
    public final void rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3052:1: ( ( ruleJvmArgumentTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3053:1: ( ruleJvmArgumentTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3053:1: ( ruleJvmArgumentTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3054:1: ruleJvmArgumentTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmParameterizedTypeReferenceAccess().getArgumentsJvmArgumentTypeReferenceParserRuleCall_1_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_16042);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3063:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0 : ( ruleJvmUpperBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3067:1: ( ( ruleJvmUpperBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3068:1: ( ruleJvmUpperBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3068:1: ( ruleJvmUpperBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3069:1: ruleJvmUpperBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmUpperBoundParserRuleCall_2_0_0()); 
            }
            pushFollow(FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_06073);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3078:1: rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1 : ( ruleJvmLowerBound ) ;
    public final void rule__JvmWildcardTypeReference__ConstraintsAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3082:1: ( ( ruleJvmLowerBound ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3083:1: ( ruleJvmLowerBound )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3083:1: ( ruleJvmLowerBound )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3084:1: ruleJvmLowerBound
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmWildcardTypeReferenceAccess().getConstraintsJvmLowerBoundParserRuleCall_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_16104);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3093:1: rule__JvmUpperBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3097:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3098:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3098:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3099:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_16135);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3108:1: rule__JvmUpperBoundAnded__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmUpperBoundAnded__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3112:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3113:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3113:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3114:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmUpperBoundAndedAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_16166);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3123:1: rule__JvmLowerBound__TypeReferenceAssignment_1 : ( ruleJvmTypeReference ) ;
    public final void rule__JvmLowerBound__TypeReferenceAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3127:1: ( ( ruleJvmTypeReference ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3128:1: ( ruleJvmTypeReference )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3128:1: ( ruleJvmTypeReference )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3129:1: ruleJvmTypeReference
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getJvmLowerBoundAccess().getTypeReferenceJvmTypeReferenceParserRuleCall_1_0()); 
            }
            pushFollow(FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_16197);
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


    // $ANTLR start "rule__XImportDeclaration1__ImportItemsAssignment_3_0_0"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3142:1: rule__XImportDeclaration1__ImportItemsAssignment_3_0_0 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration1__ImportItemsAssignment_3_0_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3146:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3147:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3147:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3148:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_0_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_3_0_06232);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_0_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportItemsAssignment_3_0_0"


    // $ANTLR start "rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3157:1: rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1 : ( ruleXImportItem ) ;
    public final void rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3161:1: ( ( ruleXImportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3162:1: ( ruleXImportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3162:1: ( ruleXImportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3163:1: ruleXImportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_1_1_0()); 
            }
            pushFollow(FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_16263);
            ruleXImportItem();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportItemsXImportItemParserRuleCall_3_0_1_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1"


    // $ANTLR start "rule__XImportDeclaration1__WildcardAssignment_3_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3172:1: rule__XImportDeclaration1__WildcardAssignment_3_1 : ( ( '*' ) ) ;
    public final void rule__XImportDeclaration1__WildcardAssignment_3_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3176:1: ( ( ( '*' ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3177:1: ( ( '*' ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3177:1: ( ( '*' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3178:1: ( '*' )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getWildcardAsteriskKeyword_3_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3179:1: ( '*' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3180:1: '*'
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getWildcardAsteriskKeyword_3_1_0()); 
            }
            match(input,29,FOLLOW_29_in_rule__XImportDeclaration1__WildcardAssignment_3_16299); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getWildcardAsteriskKeyword_3_1_0()); 
            }

            }

            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getWildcardAsteriskKeyword_3_1_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__WildcardAssignment_3_1"


    // $ANTLR start "rule__XImportDeclaration1__NameAssignment_6"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3195:1: rule__XImportDeclaration1__NameAssignment_6 : ( ruleValidID ) ;
    public final void rule__XImportDeclaration1__NameAssignment_6() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3199:1: ( ( ruleValidID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3200:1: ( ruleValidID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3200:1: ( ruleValidID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3201:1: ruleValidID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getNameValidIDParserRuleCall_6_0()); 
            }
            pushFollow(FOLLOW_ruleValidID_in_rule__XImportDeclaration1__NameAssignment_66338);
            ruleValidID();

            state._fsp--;
            if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getNameValidIDParserRuleCall_6_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__NameAssignment_6"


    // $ANTLR start "rule__XImportDeclaration1__ImportURIAssignment_8"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3210:1: rule__XImportDeclaration1__ImportURIAssignment_8 : ( RULE_STRING ) ;
    public final void rule__XImportDeclaration1__ImportURIAssignment_8() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3214:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3215:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3215:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3216:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_8_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_86369); if (state.failed) return ;
            if ( state.backtracking==0 ) {
               after(grammarAccess.getXImportDeclaration1Access().getImportURISTRINGTerminalRuleCall_8_0()); 
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
    // $ANTLR end "rule__XImportDeclaration1__ImportURIAssignment_8"


    // $ANTLR start "rule__XImportItem__ImportedIdAssignment_1"
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3225:1: rule__XImportItem__ImportedIdAssignment_1 : ( ( RULE_ID ) ) ;
    public final void rule__XImportItem__ImportedIdAssignment_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3229:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3230:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3230:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3231:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementCrossReference_1_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3232:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3233:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getImportedIdJvmIdentifiableElementIDTerminalRuleCall_1_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_16404); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3244:1: rule__XImportItem__AliasAssignment_2_1 : ( RULE_ID ) ;
    public final void rule__XImportItem__AliasAssignment_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3248:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3249:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3249:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3250:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXImportItemAccess().getAliasIDTerminalRuleCall_2_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_16439); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3260:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3264:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3265:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3265:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3266:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_16471);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3275:1: rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1 : ( ruleXExportItem ) ;
    public final void rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3279:1: ( ( ruleXExportItem ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3280:1: ( ruleXExportItem )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3280:1: ( ruleXExportItem )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3281:1: ruleXExportItem
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getExportItemsXExportItemParserRuleCall_1_0_2_1_0()); 
            }
            pushFollow(FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_16502);
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3290:1: rule__XExportDeclaration__ImportURIAssignment_1_0_4_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_0_4_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3294:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3295:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3295:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3296:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_0_4_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_16533); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3305:1: rule__XExportDeclaration__ImportURIAssignment_1_1_1 : ( RULE_STRING ) ;
    public final void rule__XExportDeclaration__ImportURIAssignment_1_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3309:1: ( ( RULE_STRING ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3310:1: ( RULE_STRING )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3310:1: ( RULE_STRING )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3311:1: RULE_STRING
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getImportURISTRINGTerminalRuleCall_1_1_1_0()); 
            }
            match(input,RULE_STRING,FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_16564); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3320:1: rule__XExportDeclaration__AliasAssignment_1_1_3 : ( RULE_ID ) ;
    public final void rule__XExportDeclaration__AliasAssignment_1_1_3() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3324:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3325:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3325:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3326:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportDeclarationAccess().getAliasIDTerminalRuleCall_1_1_3_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_36595); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3335:1: rule__XExportItem__ExportedIdAssignment_0 : ( ( RULE_ID ) ) ;
    public final void rule__XExportItem__ExportedIdAssignment_0() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3339:1: ( ( ( RULE_ID ) ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3340:1: ( ( RULE_ID ) )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3340:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3341:1: ( RULE_ID )
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementCrossReference_0_0()); 
            }
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3342:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3343:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getExportedIdJvmIdentifiableElementIDTerminalRuleCall_0_0_1()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_06630); if (state.failed) return ;
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
    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3354:1: rule__XExportItem__AliasAssignment_1_1 : ( RULE_ID ) ;
    public final void rule__XExportItem__AliasAssignment_1_1() throws RecognitionException {

        		int stackSize = keepStackSize();
            
        try {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3358:1: ( ( RULE_ID ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3359:1: ( RULE_ID )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3359:1: ( RULE_ID )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3360:1: RULE_ID
            {
            if ( state.backtracking==0 ) {
               before(grammarAccess.getXExportItemAccess().getAliasIDTerminalRuleCall_1_1_0()); 
            }
            match(input,RULE_ID,FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_16665); if (state.failed) return ;
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
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0__0_in_rule__XImportDeclaration1__Alternatives_31133 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__WildcardAssignment_3_1_in_rule__XImportDeclaration1__Alternatives_31151 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0_in_rule__XExportDeclaration__Alternatives_11184 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0_in_rule__XExportDeclaration__Alternatives_11202 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__0__Impl_in_rule__JvmTypeReference__Group_0__01233 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__1_in_rule__JvmTypeReference__Group_0__01236 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmParameterizedTypeReference_in_rule__JvmTypeReference__Group_0__0__Impl1263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0__1__Impl_in_rule__JvmTypeReference__Group_0__11292 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1__0_in_rule__JvmTypeReference__Group_0__1__Impl1319 = new BitSet(new long[]{0x0000000000000402L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1__0__Impl_in_rule__JvmTypeReference__Group_0_1__01354 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__0_in_rule__JvmTypeReference__Group_0_1__0__Impl1381 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__0__Impl_in_rule__JvmTypeReference__Group_0_1_0__01413 = new BitSet(new long[]{0x0000000000000400L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__1_in_rule__JvmTypeReference__Group_0_1_0__01416 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmTypeReference__Group_0_1_0__1__Impl_in_rule__JvmTypeReference__Group_0_1_0__11474 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleArrayBrackets_in_rule__JvmTypeReference__Group_0_1_0__1__Impl1501 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__0__Impl_in_rule__ArrayBrackets__Group__01534 = new BitSet(new long[]{0x0000000000000800L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1_in_rule__ArrayBrackets__Group__01537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_10_in_rule__ArrayBrackets__Group__0__Impl1565 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__ArrayBrackets__Group__1__Impl_in_rule__ArrayBrackets__Group__11596 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_11_in_rule__ArrayBrackets__Group__1__Impl1624 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__0__Impl_in_rule__XFunctionTypeRef__Group__01659 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__1_in_rule__XFunctionTypeRef__Group__01662 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__0_in_rule__XFunctionTypeRef__Group__0__Impl1689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__1__Impl_in_rule__XFunctionTypeRef__Group__11720 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__2_in_rule__XFunctionTypeRef__Group__11723 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_12_in_rule__XFunctionTypeRef__Group__1__Impl1751 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group__2__Impl_in_rule__XFunctionTypeRef__Group__21782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ReturnTypeAssignment_2_in_rule__XFunctionTypeRef__Group__2__Impl1809 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__0__Impl_in_rule__XFunctionTypeRef__Group_0__01845 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__1_in_rule__XFunctionTypeRef__Group_0__01848 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_13_in_rule__XFunctionTypeRef__Group_0__0__Impl1876 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__1__Impl_in_rule__XFunctionTypeRef__Group_0__11907 = new BitSet(new long[]{0x0000000000007010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__2_in_rule__XFunctionTypeRef__Group_0__11910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__0_in_rule__XFunctionTypeRef__Group_0__1__Impl1937 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0__2__Impl_in_rule__XFunctionTypeRef__Group_0__21968 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_14_in_rule__XFunctionTypeRef__Group_0__2__Impl1996 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1__02033 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__1_in_rule__XFunctionTypeRef__Group_0_1__02036 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_0_in_rule__XFunctionTypeRef__Group_0_1__0__Impl2063 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1__12093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0_in_rule__XFunctionTypeRef__Group_0_1__1__Impl2120 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__0__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__02155 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1_in_rule__XFunctionTypeRef__Group_0_1_1__02158 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XFunctionTypeRef__Group_0_1_1__0__Impl2186 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__Group_0_1_1__1__Impl_in_rule__XFunctionTypeRef__Group_0_1_1__12217 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_1_in_rule__XFunctionTypeRef__Group_0_1_1__1__Impl2244 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__0__Impl_in_rule__JvmParameterizedTypeReference__Group__02278 = new BitSet(new long[]{0x0000000000010000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1_in_rule__JvmParameterizedTypeReference__Group__02281 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__TypeAssignment_0_in_rule__JvmParameterizedTypeReference__Group__0__Impl2308 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group__1__Impl_in_rule__JvmParameterizedTypeReference__Group__12338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0_in_rule__JvmParameterizedTypeReference__Group__1__Impl2365 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1__02400 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1_in_rule__JvmParameterizedTypeReference__Group_1__02403 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_16_in_rule__JvmParameterizedTypeReference__Group_1__0__Impl2432 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1__12464 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2_in_rule__JvmParameterizedTypeReference__Group_1__12467 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_1_in_rule__JvmParameterizedTypeReference__Group_1__1__Impl2494 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__2__Impl_in_rule__JvmParameterizedTypeReference__Group_1__22524 = new BitSet(new long[]{0x0000000000028000L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3_in_rule__JvmParameterizedTypeReference__Group_1__22527 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0_in_rule__JvmParameterizedTypeReference__Group_1__2__Impl2554 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1__3__Impl_in_rule__JvmParameterizedTypeReference__Group_1__32585 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_17_in_rule__JvmParameterizedTypeReference__Group_1__3__Impl2613 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__02652 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1_in_rule__JvmParameterizedTypeReference__Group_1_2__02655 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__JvmParameterizedTypeReference__Group_1_2__0__Impl2683 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl_in_rule__JvmParameterizedTypeReference__Group_1_2__12714 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_1_in_rule__JvmParameterizedTypeReference__Group_1_2__1__Impl2741 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__0__Impl_in_rule__JvmWildcardTypeReference__Group__02775 = new BitSet(new long[]{0x0000000000043010L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1_in_rule__JvmWildcardTypeReference__Group__02778 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__1__Impl_in_rule__JvmWildcardTypeReference__Group__12836 = new BitSet(new long[]{0x0000000000280000L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2_in_rule__JvmWildcardTypeReference__Group__12839 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_18_in_rule__JvmWildcardTypeReference__Group__1__Impl2867 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Group__2__Impl_in_rule__JvmWildcardTypeReference__Group__22898 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmWildcardTypeReference__Alternatives_2_in_rule__JvmWildcardTypeReference__Group__2__Impl2925 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__0__Impl_in_rule__JvmUpperBound__Group__02962 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1_in_rule__JvmUpperBound__Group__02965 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_19_in_rule__JvmUpperBound__Group__0__Impl2993 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__Group__1__Impl_in_rule__JvmUpperBound__Group__13024 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBound__TypeReferenceAssignment_1_in_rule__JvmUpperBound__Group__1__Impl3051 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__0__Impl_in_rule__JvmUpperBoundAnded__Group__03085 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1_in_rule__JvmUpperBoundAnded__Group__03088 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_20_in_rule__JvmUpperBoundAnded__Group__0__Impl3116 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__Group__1__Impl_in_rule__JvmUpperBoundAnded__Group__13147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmUpperBoundAnded__TypeReferenceAssignment_1_in_rule__JvmUpperBoundAnded__Group__1__Impl3174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__0__Impl_in_rule__JvmLowerBound__Group__03208 = new BitSet(new long[]{0x0000000000003010L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1_in_rule__JvmLowerBound__Group__03211 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_21_in_rule__JvmLowerBound__Group__0__Impl3239 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__Group__1__Impl_in_rule__JvmLowerBound__Group__13270 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__JvmLowerBound__TypeReferenceAssignment_1_in_rule__JvmLowerBound__Group__1__Impl3297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__0__Impl_in_rule__QualifiedName__Group__03333 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1_in_rule__QualifiedName__Group__03336 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group__0__Impl3363 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group__1__Impl_in_rule__QualifiedName__Group__13392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0_in_rule__QualifiedName__Group__1__Impl3419 = new BitSet(new long[]{0x0000000000400002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__0__Impl_in_rule__QualifiedName__Group_1__03454 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1_in_rule__QualifiedName__Group_1__03457 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_22_in_rule__QualifiedName__Group_1__0__Impl3485 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__QualifiedName__Group_1__1__Impl_in_rule__QualifiedName__Group_1__13516 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__QualifiedName__Group_1__1__Impl3543 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__0__Impl_in_rule__XImportDeclaration1__Group__03578 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__1_in_rule__XImportDeclaration1__Group__03581 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__1__Impl_in_rule__XImportDeclaration1__Group__13639 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__2_in_rule__XImportDeclaration1__Group__13642 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_23_in_rule__XImportDeclaration1__Group__1__Impl3670 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__2__Impl_in_rule__XImportDeclaration1__Group__23701 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__3_in_rule__XImportDeclaration1__Group__23704 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XImportDeclaration1__Group__2__Impl3732 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__3__Impl_in_rule__XImportDeclaration1__Group__33763 = new BitSet(new long[]{0x0000000002000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__4_in_rule__XImportDeclaration1__Group__33766 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Alternatives_3_in_rule__XImportDeclaration1__Group__3__Impl3793 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__4__Impl_in_rule__XImportDeclaration1__Group__43823 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__5_in_rule__XImportDeclaration1__Group__43826 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__XImportDeclaration1__Group__4__Impl3854 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__5__Impl_in_rule__XImportDeclaration1__Group__53885 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__6_in_rule__XImportDeclaration1__Group__53888 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XImportDeclaration1__Group__5__Impl3916 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__6__Impl_in_rule__XImportDeclaration1__Group__63947 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__7_in_rule__XImportDeclaration1__Group__63950 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__NameAssignment_6_in_rule__XImportDeclaration1__Group__6__Impl3977 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__7__Impl_in_rule__XImportDeclaration1__Group__74007 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__8_in_rule__XImportDeclaration1__Group__74010 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XImportDeclaration1__Group__7__Impl4038 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group__8__Impl_in_rule__XImportDeclaration1__Group__84069 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportURIAssignment_8_in_rule__XImportDeclaration1__Group__8__Impl4096 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0__0__Impl_in_rule__XImportDeclaration1__Group_3_0__04144 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0__1_in_rule__XImportDeclaration1__Group_3_0__04147 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_3_0_0_in_rule__XImportDeclaration1__Group_3_0__0__Impl4174 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0__1__Impl_in_rule__XImportDeclaration1__Group_3_0__14204 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0_1__0_in_rule__XImportDeclaration1__Group_3_0__1__Impl4231 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0_1__0__Impl_in_rule__XImportDeclaration1__Group_3_0_1__04266 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0_1__1_in_rule__XImportDeclaration1__Group_3_0_1__04269 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XImportDeclaration1__Group_3_0_1__0__Impl4297 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__Group_3_0_1__1__Impl_in_rule__XImportDeclaration1__Group_3_0_1__14328 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_1_in_rule__XImportDeclaration1__Group_3_0_1__1__Impl4355 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__0__Impl_in_rule__XImportItem__Group__04389 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1_in_rule__XImportItem__Group__04392 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__1__Impl_in_rule__XImportItem__Group__14450 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2_in_rule__XImportItem__Group__14453 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__ImportedIdAssignment_1_in_rule__XImportItem__Group__1__Impl4480 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group__2__Impl_in_rule__XImportItem__Group__24510 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0_in_rule__XImportItem__Group__2__Impl4537 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__0__Impl_in_rule__XImportItem__Group_2__04574 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1_in_rule__XImportItem__Group_2__04577 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XImportItem__Group_2__0__Impl4605 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__Group_2__1__Impl_in_rule__XImportItem__Group_2__14636 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XImportItem__AliasAssignment_2_1_in_rule__XImportItem__Group_2__1__Impl4663 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__0__Impl_in_rule__XExportDeclaration__Group__04698 = new BitSet(new long[]{0x0000000009000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1_in_rule__XExportDeclaration__Group__04701 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_28_in_rule__XExportDeclaration__Group__0__Impl4729 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group__1__Impl_in_rule__XExportDeclaration__Group__14760 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Alternatives_1_in_rule__XExportDeclaration__Group__1__Impl4787 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__0__Impl_in_rule__XExportDeclaration__Group_1_0__04821 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1_in_rule__XExportDeclaration__Group_1_0__04824 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_24_in_rule__XExportDeclaration__Group_1_0__0__Impl4852 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__1__Impl_in_rule__XExportDeclaration__Group_1_0__14883 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2_in_rule__XExportDeclaration__Group_1_0__14886 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_1_in_rule__XExportDeclaration__Group_1_0__1__Impl4913 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__2__Impl_in_rule__XExportDeclaration__Group_1_0__24943 = new BitSet(new long[]{0x0000000002008000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3_in_rule__XExportDeclaration__Group_1_0__24946 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0_in_rule__XExportDeclaration__Group_1_0__2__Impl4973 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__3__Impl_in_rule__XExportDeclaration__Group_1_0__35004 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4_in_rule__XExportDeclaration__Group_1_0__35007 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_25_in_rule__XExportDeclaration__Group_1_0__3__Impl5035 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0__4__Impl_in_rule__XExportDeclaration__Group_1_0__45066 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0_in_rule__XExportDeclaration__Group_1_0__4__Impl5093 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__0__Impl_in_rule__XExportDeclaration__Group_1_0_2__05134 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1_in_rule__XExportDeclaration__Group_1_0_2__05137 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_15_in_rule__XExportDeclaration__Group_1_0_2__0__Impl5165 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_2__1__Impl_in_rule__XExportDeclaration__Group_1_0_2__15196 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_1_in_rule__XExportDeclaration__Group_1_0_2__1__Impl5223 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__0__Impl_in_rule__XExportDeclaration__Group_1_0_4__05257 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1_in_rule__XExportDeclaration__Group_1_0_4__05260 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XExportDeclaration__Group_1_0_4__0__Impl5288 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_0_4__1__Impl_in_rule__XExportDeclaration__Group_1_0_4__15319 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_0_4_1_in_rule__XExportDeclaration__Group_1_0_4__1__Impl5346 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__0__Impl_in_rule__XExportDeclaration__Group_1_1__05380 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1_in_rule__XExportDeclaration__Group_1_1__05383 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_27_in_rule__XExportDeclaration__Group_1_1__0__Impl5411 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__1__Impl_in_rule__XExportDeclaration__Group_1_1__15442 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2_in_rule__XExportDeclaration__Group_1_1__15445 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__ImportURIAssignment_1_1_1_in_rule__XExportDeclaration__Group_1_1__1__Impl5472 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__2__Impl_in_rule__XExportDeclaration__Group_1_1__25502 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3_in_rule__XExportDeclaration__Group_1_1__25505 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XExportDeclaration__Group_1_1__2__Impl5533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__Group_1_1__3__Impl_in_rule__XExportDeclaration__Group_1_1__35564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportDeclaration__AliasAssignment_1_1_3_in_rule__XExportDeclaration__Group_1_1__3__Impl5591 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__0__Impl_in_rule__XExportItem__Group__05629 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1_in_rule__XExportItem__Group__05632 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__ExportedIdAssignment_0_in_rule__XExportItem__Group__0__Impl5659 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group__1__Impl_in_rule__XExportItem__Group__15689 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0_in_rule__XExportItem__Group__1__Impl5716 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__0__Impl_in_rule__XExportItem__Group_1__05751 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1_in_rule__XExportItem__Group_1__05754 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_26_in_rule__XExportItem__Group_1__0__Impl5782 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__Group_1__1__Impl_in_rule__XExportItem__Group_1__15813 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_rule__XExportItem__AliasAssignment_1_1_in_rule__XExportItem__Group_1__1__Impl5840 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_05879 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ParamTypesAssignment_0_1_1_15910 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__XFunctionTypeRef__ReturnTypeAssignment_25941 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleQualifiedName_in_rule__JvmParameterizedTypeReference__TypeAssignment_05976 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_16011 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmArgumentTypeReference_in_rule__JvmParameterizedTypeReference__ArgumentsAssignment_1_2_16042 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmUpperBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_06073 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmLowerBound_in_rule__JvmWildcardTypeReference__ConstraintsAssignment_2_16104 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBound__TypeReferenceAssignment_16135 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmUpperBoundAnded__TypeReferenceAssignment_16166 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleJvmTypeReference_in_rule__JvmLowerBound__TypeReferenceAssignment_16197 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_3_0_06232 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXImportItem_in_rule__XImportDeclaration1__ImportItemsAssignment_3_0_1_16263 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_29_in_rule__XImportDeclaration1__WildcardAssignment_3_16299 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleValidID_in_rule__XImportDeclaration1__NameAssignment_66338 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XImportDeclaration1__ImportURIAssignment_86369 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__ImportedIdAssignment_16404 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XImportItem__AliasAssignment_2_16439 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_16471 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_ruleXExportItem_in_rule__XExportDeclaration__ExportItemsAssignment_1_0_2_16502 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_0_4_16533 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_STRING_in_rule__XExportDeclaration__ImportURIAssignment_1_1_16564 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportDeclaration__AliasAssignment_1_1_36595 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__ExportedIdAssignment_06630 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_RULE_ID_in_rule__XExportItem__AliasAssignment_1_16665 = new BitSet(new long[]{0x0000000000000002L});

}