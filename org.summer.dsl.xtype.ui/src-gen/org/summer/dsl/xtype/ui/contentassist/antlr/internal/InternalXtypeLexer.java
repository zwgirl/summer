package org.summer.dsl.xtype.ui.contentassist.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.ui.editor.contentassist.antlr.internal.Lexer;


import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalXtypeLexer extends Lexer {
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
    public static final int EOF=-1;
    public static final int RULE_SL_COMMENT=7;
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

    public InternalXtypeLexer() {;} 
    public InternalXtypeLexer(CharStream input) {
        this(input, new RecognizerSharedState());
    }
    public InternalXtypeLexer(CharStream input, RecognizerSharedState state) {
        super(input,state);

    }
    public String getGrammarFileName() { return "../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g"; }

    // $ANTLR start "T__10"
    public final void mT__10() throws RecognitionException {
        try {
            int _type = T__10;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:11:7: ( '[' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:11:9: '['
            {
            match('['); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__10"

    // $ANTLR start "T__11"
    public final void mT__11() throws RecognitionException {
        try {
            int _type = T__11;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:12:7: ( ']' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:12:9: ']'
            {
            match(']'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__11"

    // $ANTLR start "T__12"
    public final void mT__12() throws RecognitionException {
        try {
            int _type = T__12;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:13:7: ( '=>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:13:9: '=>'
            {
            match("=>"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__12"

    // $ANTLR start "T__13"
    public final void mT__13() throws RecognitionException {
        try {
            int _type = T__13;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:14:7: ( '(' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:14:9: '('
            {
            match('('); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__13"

    // $ANTLR start "T__14"
    public final void mT__14() throws RecognitionException {
        try {
            int _type = T__14;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:15:7: ( ')' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:15:9: ')'
            {
            match(')'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__14"

    // $ANTLR start "T__15"
    public final void mT__15() throws RecognitionException {
        try {
            int _type = T__15;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:16:7: ( ',' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:16:9: ','
            {
            match(','); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__15"

    // $ANTLR start "T__16"
    public final void mT__16() throws RecognitionException {
        try {
            int _type = T__16;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:17:7: ( '<' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:17:9: '<'
            {
            match('<'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__16"

    // $ANTLR start "T__17"
    public final void mT__17() throws RecognitionException {
        try {
            int _type = T__17;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:18:7: ( '>' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:18:9: '>'
            {
            match('>'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__17"

    // $ANTLR start "T__18"
    public final void mT__18() throws RecognitionException {
        try {
            int _type = T__18;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:19:7: ( '?' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:19:9: '?'
            {
            match('?'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__18"

    // $ANTLR start "T__19"
    public final void mT__19() throws RecognitionException {
        try {
            int _type = T__19;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:20:7: ( 'extends' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:20:9: 'extends'
            {
            match("extends"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__19"

    // $ANTLR start "T__20"
    public final void mT__20() throws RecognitionException {
        try {
            int _type = T__20;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:21:7: ( '&' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:21:9: '&'
            {
            match('&'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__20"

    // $ANTLR start "T__21"
    public final void mT__21() throws RecognitionException {
        try {
            int _type = T__21;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:22:7: ( 'super' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:22:9: 'super'
            {
            match("super"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__21"

    // $ANTLR start "T__22"
    public final void mT__22() throws RecognitionException {
        try {
            int _type = T__22;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:23:7: ( '.' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:23:9: '.'
            {
            match('.'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__22"

    // $ANTLR start "T__23"
    public final void mT__23() throws RecognitionException {
        try {
            int _type = T__23;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:24:7: ( 'import' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:24:9: 'import'
            {
            match("import"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__23"

    // $ANTLR start "T__24"
    public final void mT__24() throws RecognitionException {
        try {
            int _type = T__24;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:25:7: ( 'from' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:25:9: 'from'
            {
            match("from"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__24"

    // $ANTLR start "T__25"
    public final void mT__25() throws RecognitionException {
        try {
            int _type = T__25;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:26:7: ( '{' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:26:9: '{'
            {
            match('{'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__25"

    // $ANTLR start "T__26"
    public final void mT__26() throws RecognitionException {
        try {
            int _type = T__26;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:27:7: ( '}' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:27:9: '}'
            {
            match('}'); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__26"

    // $ANTLR start "T__27"
    public final void mT__27() throws RecognitionException {
        try {
            int _type = T__27;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:28:7: ( 'as' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:28:9: 'as'
            {
            match("as"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__27"

    // $ANTLR start "T__28"
    public final void mT__28() throws RecognitionException {
        try {
            int _type = T__28;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:29:7: ( 'export' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:29:9: 'export'
            {
            match("export"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "T__28"

    // $ANTLR start "RULE_ID"
    public final void mRULE_ID() throws RecognitionException {
        try {
            int _type = RULE_ID;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3459:9: ( ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )* )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3459:11: ( '^' )? ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' ) ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3459:11: ( '^' )?
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0=='^') ) {
                alt1=1;
            }
            switch (alt1) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3459:11: '^'
                    {
                    match('^'); 

                    }
                    break;

            }

            if ( input.LA(1)=='$'||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
                input.consume();

            }
            else {
                MismatchedSetException mse = new MismatchedSetException(null,input);
                recover(mse);
                throw mse;}

            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3459:44: ( 'a' .. 'z' | 'A' .. 'Z' | '$' | '_' | '0' .. '9' )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0=='$'||(LA2_0>='0' && LA2_0<='9')||(LA2_0>='A' && LA2_0<='Z')||LA2_0=='_'||(LA2_0>='a' && LA2_0<='z')) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:
            	    {
            	    if ( input.LA(1)=='$'||(input.LA(1)>='0' && input.LA(1)<='9')||(input.LA(1)>='A' && input.LA(1)<='Z')||input.LA(1)=='_'||(input.LA(1)>='a' && input.LA(1)<='z') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ID"

    // $ANTLR start "RULE_STRING"
    public final void mRULE_STRING() throws RecognitionException {
        try {
            int _type = RULE_STRING;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:13: ( ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' ) )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:15: ( '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"' | '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\'' )
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0=='\"') ) {
                alt5=1;
            }
            else if ( (LA5_0=='\'') ) {
                alt5=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 5, 0, input);

                throw nvae;
            }
            switch (alt5) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:16: '\"' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )* '\"'
                    {
                    match('\"'); 
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:20: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\"' ) ) )*
                    loop3:
                    do {
                        int alt3=3;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0=='\\') ) {
                            alt3=1;
                        }
                        else if ( ((LA3_0>='\u0000' && LA3_0<='!')||(LA3_0>='#' && LA3_0<='[')||(LA3_0>=']' && LA3_0<='\uFFFF')) ) {
                            alt3=2;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:21: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:66: ~ ( ( '\\\\' | '\"' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='!')||(input.LA(1)>='#' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop3;
                        }
                    } while (true);

                    match('\"'); 

                    }
                    break;
                case 2 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:86: '\\'' ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )* '\\''
                    {
                    match('\''); 
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:91: ( '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' ) | ~ ( ( '\\\\' | '\\'' ) ) )*
                    loop4:
                    do {
                        int alt4=3;
                        int LA4_0 = input.LA(1);

                        if ( (LA4_0=='\\') ) {
                            alt4=1;
                        }
                        else if ( ((LA4_0>='\u0000' && LA4_0<='&')||(LA4_0>='(' && LA4_0<='[')||(LA4_0>=']' && LA4_0<='\uFFFF')) ) {
                            alt4=2;
                        }


                        switch (alt4) {
                    	case 1 :
                    	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:92: '\\\\' ( 'b' | 't' | 'n' | 'f' | 'r' | 'u' | '\"' | '\\'' | '\\\\' )
                    	    {
                    	    match('\\'); 
                    	    if ( input.LA(1)=='\"'||input.LA(1)=='\''||input.LA(1)=='\\'||input.LA(1)=='b'||input.LA(1)=='f'||input.LA(1)=='n'||input.LA(1)=='r'||(input.LA(1)>='t' && input.LA(1)<='u') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;
                    	case 2 :
                    	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3461:137: ~ ( ( '\\\\' | '\\'' ) )
                    	    {
                    	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='&')||(input.LA(1)>='(' && input.LA(1)<='[')||(input.LA(1)>=']' && input.LA(1)<='\uFFFF') ) {
                    	        input.consume();

                    	    }
                    	    else {
                    	        MismatchedSetException mse = new MismatchedSetException(null,input);
                    	        recover(mse);
                    	        throw mse;}


                    	    }
                    	    break;

                    	default :
                    	    break loop4;
                        }
                    } while (true);

                    match('\''); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_STRING"

    // $ANTLR start "RULE_ML_COMMENT"
    public final void mRULE_ML_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_ML_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3463:17: ( '/*' ( options {greedy=false; } : . )* '*/' )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3463:19: '/*' ( options {greedy=false; } : . )* '*/'
            {
            match("/*"); 

            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3463:24: ( options {greedy=false; } : . )*
            loop6:
            do {
                int alt6=2;
                int LA6_0 = input.LA(1);

                if ( (LA6_0=='*') ) {
                    int LA6_1 = input.LA(2);

                    if ( (LA6_1=='/') ) {
                        alt6=2;
                    }
                    else if ( ((LA6_1>='\u0000' && LA6_1<='.')||(LA6_1>='0' && LA6_1<='\uFFFF')) ) {
                        alt6=1;
                    }


                }
                else if ( ((LA6_0>='\u0000' && LA6_0<=')')||(LA6_0>='+' && LA6_0<='\uFFFF')) ) {
                    alt6=1;
                }


                switch (alt6) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3463:52: .
            	    {
            	    matchAny(); 

            	    }
            	    break;

            	default :
            	    break loop6;
                }
            } while (true);

            match("*/"); 


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ML_COMMENT"

    // $ANTLR start "RULE_SL_COMMENT"
    public final void mRULE_SL_COMMENT() throws RecognitionException {
        try {
            int _type = RULE_SL_COMMENT;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:17: ( '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )? )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:19: '//' (~ ( ( '\\n' | '\\r' ) ) )* ( ( '\\r' )? '\\n' )?
            {
            match("//"); 

            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:24: (~ ( ( '\\n' | '\\r' ) ) )*
            loop7:
            do {
                int alt7=2;
                int LA7_0 = input.LA(1);

                if ( ((LA7_0>='\u0000' && LA7_0<='\t')||(LA7_0>='\u000B' && LA7_0<='\f')||(LA7_0>='\u000E' && LA7_0<='\uFFFF')) ) {
                    alt7=1;
                }


                switch (alt7) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:24: ~ ( ( '\\n' | '\\r' ) )
            	    {
            	    if ( (input.LA(1)>='\u0000' && input.LA(1)<='\t')||(input.LA(1)>='\u000B' && input.LA(1)<='\f')||(input.LA(1)>='\u000E' && input.LA(1)<='\uFFFF') ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    break loop7;
                }
            } while (true);

            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:40: ( ( '\\r' )? '\\n' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0=='\n'||LA9_0=='\r') ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:41: ( '\\r' )? '\\n'
                    {
                    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:41: ( '\\r' )?
                    int alt8=2;
                    int LA8_0 = input.LA(1);

                    if ( (LA8_0=='\r') ) {
                        alt8=1;
                    }
                    switch (alt8) {
                        case 1 :
                            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3465:41: '\\r'
                            {
                            match('\r'); 

                            }
                            break;

                    }

                    match('\n'); 

                    }
                    break;

            }


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_SL_COMMENT"

    // $ANTLR start "RULE_WS"
    public final void mRULE_WS() throws RecognitionException {
        try {
            int _type = RULE_WS;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3467:9: ( ( ' ' | '\\t' | '\\r' | '\\n' )+ )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3467:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            {
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3467:11: ( ' ' | '\\t' | '\\r' | '\\n' )+
            int cnt10=0;
            loop10:
            do {
                int alt10=2;
                int LA10_0 = input.LA(1);

                if ( ((LA10_0>='\t' && LA10_0<='\n')||LA10_0=='\r'||LA10_0==' ') ) {
                    alt10=1;
                }


                switch (alt10) {
            	case 1 :
            	    // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:
            	    {
            	    if ( (input.LA(1)>='\t' && input.LA(1)<='\n')||input.LA(1)=='\r'||input.LA(1)==' ' ) {
            	        input.consume();

            	    }
            	    else {
            	        MismatchedSetException mse = new MismatchedSetException(null,input);
            	        recover(mse);
            	        throw mse;}


            	    }
            	    break;

            	default :
            	    if ( cnt10 >= 1 ) break loop10;
                        EarlyExitException eee =
                            new EarlyExitException(10, input);
                        throw eee;
                }
                cnt10++;
            } while (true);


            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_WS"

    // $ANTLR start "RULE_ANY_OTHER"
    public final void mRULE_ANY_OTHER() throws RecognitionException {
        try {
            int _type = RULE_ANY_OTHER;
            int _channel = DEFAULT_TOKEN_CHANNEL;
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3469:16: ( . )
            // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:3469:18: .
            {
            matchAny(); 

            }

            state.type = _type;
            state.channel = _channel;
        }
        finally {
        }
    }
    // $ANTLR end "RULE_ANY_OTHER"

    public void mTokens() throws RecognitionException {
        // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:8: ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER )
        int alt11=25;
        alt11 = dfa11.predict(input);
        switch (alt11) {
            case 1 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:10: T__10
                {
                mT__10(); 

                }
                break;
            case 2 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:16: T__11
                {
                mT__11(); 

                }
                break;
            case 3 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:22: T__12
                {
                mT__12(); 

                }
                break;
            case 4 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:28: T__13
                {
                mT__13(); 

                }
                break;
            case 5 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:34: T__14
                {
                mT__14(); 

                }
                break;
            case 6 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:40: T__15
                {
                mT__15(); 

                }
                break;
            case 7 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:46: T__16
                {
                mT__16(); 

                }
                break;
            case 8 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:52: T__17
                {
                mT__17(); 

                }
                break;
            case 9 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:58: T__18
                {
                mT__18(); 

                }
                break;
            case 10 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:64: T__19
                {
                mT__19(); 

                }
                break;
            case 11 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:70: T__20
                {
                mT__20(); 

                }
                break;
            case 12 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:76: T__21
                {
                mT__21(); 

                }
                break;
            case 13 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:82: T__22
                {
                mT__22(); 

                }
                break;
            case 14 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:88: T__23
                {
                mT__23(); 

                }
                break;
            case 15 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:94: T__24
                {
                mT__24(); 

                }
                break;
            case 16 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:100: T__25
                {
                mT__25(); 

                }
                break;
            case 17 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:106: T__26
                {
                mT__26(); 

                }
                break;
            case 18 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:112: T__27
                {
                mT__27(); 

                }
                break;
            case 19 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:118: T__28
                {
                mT__28(); 

                }
                break;
            case 20 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:124: RULE_ID
                {
                mRULE_ID(); 

                }
                break;
            case 21 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:132: RULE_STRING
                {
                mRULE_STRING(); 

                }
                break;
            case 22 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:144: RULE_ML_COMMENT
                {
                mRULE_ML_COMMENT(); 

                }
                break;
            case 23 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:160: RULE_SL_COMMENT
                {
                mRULE_SL_COMMENT(); 

                }
                break;
            case 24 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:176: RULE_WS
                {
                mRULE_WS(); 

                }
                break;
            case 25 :
                // ../org.summer.dsl.xtype.ui/src-gen/org/summer/dsl/xtype/ui/contentassist/antlr/internal/InternalXtype.g:1:184: RULE_ANY_OTHER
                {
                mRULE_ANY_OTHER(); 

                }
                break;

        }

    }


    protected DFA11 dfa11 = new DFA11(this);
    static final String DFA11_eotS =
        "\3\uffff\1\31\6\uffff\1\44\1\uffff\1\44\1\uffff\2\44\2\uffff\1"+
        "\44\1\31\1\uffff\3\31\13\uffff\1\44\2\uffff\1\44\1\uffff\2\44\2"+
        "\uffff\1\66\4\uffff\5\44\1\uffff\4\44\1\100\2\44\1\103\1\44\1\uffff"+
        "\1\44\1\106\1\uffff\1\107\1\110\3\uffff";
    static final String DFA11_eofS =
        "\111\uffff";
    static final String DFA11_minS =
        "\1\0\2\uffff\1\76\6\uffff\1\170\1\uffff\1\165\1\uffff\1\155\1\162"+
        "\2\uffff\1\163\1\44\1\uffff\2\0\1\52\13\uffff\1\160\2\uffff\1\160"+
        "\1\uffff\1\160\1\157\2\uffff\1\44\4\uffff\1\145\1\157\1\145\1\157"+
        "\1\155\1\uffff\1\156\3\162\1\44\1\144\1\164\1\44\1\164\1\uffff\1"+
        "\163\1\44\1\uffff\2\44\3\uffff";
    static final String DFA11_maxS =
        "\1\uffff\2\uffff\1\76\6\uffff\1\170\1\uffff\1\165\1\uffff\1\155"+
        "\1\162\2\uffff\1\163\1\172\1\uffff\2\uffff\1\57\13\uffff\1\164\2"+
        "\uffff\1\160\1\uffff\1\160\1\157\2\uffff\1\172\4\uffff\1\145\1\157"+
        "\1\145\1\157\1\155\1\uffff\1\156\3\162\1\172\1\144\1\164\1\172\1"+
        "\164\1\uffff\1\163\1\172\1\uffff\2\172\3\uffff";
    static final String DFA11_acceptS =
        "\1\uffff\1\1\1\2\1\uffff\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\13"+
        "\1\uffff\1\15\2\uffff\1\20\1\21\2\uffff\1\24\3\uffff\1\30\1\31\1"+
        "\1\1\2\1\3\1\4\1\5\1\6\1\7\1\10\1\11\1\uffff\1\24\1\13\1\uffff\1"+
        "\15\2\uffff\1\20\1\21\1\uffff\1\25\1\26\1\27\1\30\5\uffff\1\22\11"+
        "\uffff\1\17\2\uffff\1\14\2\uffff\1\23\1\16\1\12";
    static final String DFA11_specialS =
        "\1\1\24\uffff\1\0\1\2\62\uffff}>";
    static final String[] DFA11_transitionS = {
            "\11\31\2\30\2\31\1\30\22\31\1\30\1\31\1\25\1\31\1\24\1\31\1"+
            "\13\1\26\1\4\1\5\2\31\1\6\1\31\1\15\1\27\14\31\1\7\1\3\1\10"+
            "\1\11\1\31\32\24\1\1\1\31\1\2\1\23\1\24\1\31\1\22\3\24\1\12"+
            "\1\17\2\24\1\16\11\24\1\14\7\24\1\20\1\31\1\21\uff82\31",
            "",
            "",
            "\1\34",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\43",
            "",
            "\1\46",
            "",
            "\1\50",
            "\1\51",
            "",
            "",
            "\1\54",
            "\1\44\34\uffff\32\44\4\uffff\1\44\1\uffff\32\44",
            "",
            "\0\55",
            "\0\55",
            "\1\56\4\uffff\1\57",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "",
            "\1\62\3\uffff\1\61",
            "",
            "",
            "\1\63",
            "",
            "\1\64",
            "\1\65",
            "",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "",
            "",
            "",
            "",
            "\1\67",
            "\1\70",
            "\1\71",
            "\1\72",
            "\1\73",
            "",
            "\1\74",
            "\1\75",
            "\1\76",
            "\1\77",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "\1\101",
            "\1\102",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "\1\104",
            "",
            "\1\105",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "\1\44\13\uffff\12\44\7\uffff\32\44\4\uffff\1\44\1\uffff\32"+
            "\44",
            "",
            "",
            ""
    };

    static final short[] DFA11_eot = DFA.unpackEncodedString(DFA11_eotS);
    static final short[] DFA11_eof = DFA.unpackEncodedString(DFA11_eofS);
    static final char[] DFA11_min = DFA.unpackEncodedStringToUnsignedChars(DFA11_minS);
    static final char[] DFA11_max = DFA.unpackEncodedStringToUnsignedChars(DFA11_maxS);
    static final short[] DFA11_accept = DFA.unpackEncodedString(DFA11_acceptS);
    static final short[] DFA11_special = DFA.unpackEncodedString(DFA11_specialS);
    static final short[][] DFA11_transition;

    static {
        int numStates = DFA11_transitionS.length;
        DFA11_transition = new short[numStates][];
        for (int i=0; i<numStates; i++) {
            DFA11_transition[i] = DFA.unpackEncodedString(DFA11_transitionS[i]);
        }
    }

    class DFA11 extends DFA {

        public DFA11(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 11;
            this.eot = DFA11_eot;
            this.eof = DFA11_eof;
            this.min = DFA11_min;
            this.max = DFA11_max;
            this.accept = DFA11_accept;
            this.special = DFA11_special;
            this.transition = DFA11_transition;
        }
        public String getDescription() {
            return "1:1: Tokens : ( T__10 | T__11 | T__12 | T__13 | T__14 | T__15 | T__16 | T__17 | T__18 | T__19 | T__20 | T__21 | T__22 | T__23 | T__24 | T__25 | T__26 | T__27 | T__28 | RULE_ID | RULE_STRING | RULE_ML_COMMENT | RULE_SL_COMMENT | RULE_WS | RULE_ANY_OTHER );";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            IntStream input = _input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA11_21 = input.LA(1);

                        s = -1;
                        if ( ((LA11_21>='\u0000' && LA11_21<='\uFFFF')) ) {s = 45;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA11_0 = input.LA(1);

                        s = -1;
                        if ( (LA11_0=='[') ) {s = 1;}

                        else if ( (LA11_0==']') ) {s = 2;}

                        else if ( (LA11_0=='=') ) {s = 3;}

                        else if ( (LA11_0=='(') ) {s = 4;}

                        else if ( (LA11_0==')') ) {s = 5;}

                        else if ( (LA11_0==',') ) {s = 6;}

                        else if ( (LA11_0=='<') ) {s = 7;}

                        else if ( (LA11_0=='>') ) {s = 8;}

                        else if ( (LA11_0=='?') ) {s = 9;}

                        else if ( (LA11_0=='e') ) {s = 10;}

                        else if ( (LA11_0=='&') ) {s = 11;}

                        else if ( (LA11_0=='s') ) {s = 12;}

                        else if ( (LA11_0=='.') ) {s = 13;}

                        else if ( (LA11_0=='i') ) {s = 14;}

                        else if ( (LA11_0=='f') ) {s = 15;}

                        else if ( (LA11_0=='{') ) {s = 16;}

                        else if ( (LA11_0=='}') ) {s = 17;}

                        else if ( (LA11_0=='a') ) {s = 18;}

                        else if ( (LA11_0=='^') ) {s = 19;}

                        else if ( (LA11_0=='$'||(LA11_0>='A' && LA11_0<='Z')||LA11_0=='_'||(LA11_0>='b' && LA11_0<='d')||(LA11_0>='g' && LA11_0<='h')||(LA11_0>='j' && LA11_0<='r')||(LA11_0>='t' && LA11_0<='z')) ) {s = 20;}

                        else if ( (LA11_0=='\"') ) {s = 21;}

                        else if ( (LA11_0=='\'') ) {s = 22;}

                        else if ( (LA11_0=='/') ) {s = 23;}

                        else if ( ((LA11_0>='\t' && LA11_0<='\n')||LA11_0=='\r'||LA11_0==' ') ) {s = 24;}

                        else if ( ((LA11_0>='\u0000' && LA11_0<='\b')||(LA11_0>='\u000B' && LA11_0<='\f')||(LA11_0>='\u000E' && LA11_0<='\u001F')||LA11_0=='!'||LA11_0=='#'||LA11_0=='%'||(LA11_0>='*' && LA11_0<='+')||LA11_0=='-'||(LA11_0>='0' && LA11_0<=';')||LA11_0=='@'||LA11_0=='\\'||LA11_0=='`'||LA11_0=='|'||(LA11_0>='~' && LA11_0<='\uFFFF')) ) {s = 25;}

                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA11_22 = input.LA(1);

                        s = -1;
                        if ( ((LA11_22>='\u0000' && LA11_22<='\uFFFF')) ) {s = 45;}

                        else s = 25;

                        if ( s>=0 ) return s;
                        break;
            }
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 11, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

}