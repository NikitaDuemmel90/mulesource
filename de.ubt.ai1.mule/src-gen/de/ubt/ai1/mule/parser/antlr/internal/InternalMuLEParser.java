package de.ubt.ai1.mule.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import de.ubt.ai1.mule.services.MuLEGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
@SuppressWarnings("all")
public class InternalMuLEParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INTEGER", "RULE_RATIONAL", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'program'", "'library'", "'.'", "'import'", "'main'", "'endmain'", "'<'", "','", "'>'", "'integer'", "'rational'", "'string'", "'boolean'", "'reference'", "'list'", "'operation'", "'('", "')'", "':'", "'private'", "'protected'", "'type'", "'enumeration'", "'endtype'", "'abstract'", "'composition'", "'extends'", "'attribute'", "'parameter'", "'override'", "'endoperation'", "'return'", "'exit'", "'variable'", "':='", "'loop'", "'endloop'", "'if'", "'then'", "'else'", "'endif'", "'elseif'", "'let'", "'be'", "'do'", "'endlet'", "'elselet'", "'or'", "'and'", "'='", "'/='", "'<='", "'>='", "'+'", "'-'", "'&'", "'*'", "'/'", "'div'", "'mod'", "'exp'", "'true'", "'false'", "'null'", "'not'", "'super'", "'['", "']'", "'@'", "'{'", "'}'", "'**'", "'..'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__59=59;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__55=55;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__58=58;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int T__60=60;
    public static final int T__61=61;
    public static final int RULE_ID=4;
    public static final int RULE_RATIONAL=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=8;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int T__66=66;
    public static final int RULE_ML_COMMENT=9;
    public static final int T__23=23;
    public static final int T__67=67;
    public static final int T__24=24;
    public static final int T__68=68;
    public static final int T__25=25;
    public static final int T__69=69;
    public static final int T__62=62;
    public static final int T__63=63;
    public static final int T__20=20;
    public static final int T__64=64;
    public static final int T__21=21;
    public static final int T__65=65;
    public static final int T__70=70;
    public static final int T__71=71;
    public static final int T__72=72;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=10;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__77=77;
    public static final int T__34=34;
    public static final int T__78=78;
    public static final int T__35=35;
    public static final int T__79=79;
    public static final int T__36=36;
    public static final int T__73=73;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__74=74;
    public static final int T__31=31;
    public static final int T__75=75;
    public static final int T__32=32;
    public static final int T__76=76;
    public static final int T__80=80;
    public static final int T__81=81;
    public static final int T__82=82;
    public static final int T__83=83;
    public static final int RULE_WS=11;
    public static final int RULE_ANY_OTHER=12;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__84=84;
    public static final int T__41=41;
    public static final int T__85=85;
    public static final int RULE_INTEGER=6;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMuLEParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMuLEParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMuLEParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMuLE.g"; }



     	private MuLEGrammarAccess grammarAccess;

        public InternalMuLEParser(TokenStream input, MuLEGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "CompilationUnit";
       	}

       	@Override
       	protected MuLEGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleCompilationUnit"
    // InternalMuLE.g:64:1: entryRuleCompilationUnit returns [EObject current=null] : iv_ruleCompilationUnit= ruleCompilationUnit EOF ;
    public final EObject entryRuleCompilationUnit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleCompilationUnit = null;


        try {
            // InternalMuLE.g:64:56: (iv_ruleCompilationUnit= ruleCompilationUnit EOF )
            // InternalMuLE.g:65:2: iv_ruleCompilationUnit= ruleCompilationUnit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompilationUnitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleCompilationUnit=ruleCompilationUnit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleCompilationUnit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleCompilationUnit"


    // $ANTLR start "ruleCompilationUnit"
    // InternalMuLE.g:71:1: ruleCompilationUnit returns [EObject current=null] : ( ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_programElements_4_0= ruleProgramElement ) )* ( (lv_main_5_0= ruleMainProcedure ) )? ) ;
    public final EObject ruleCompilationUnit() throws RecognitionException {
        EObject current = null;

        Token lv_isProgram_0_0=null;
        Token lv_isLibrary_1_0=null;
        Token lv_name_2_0=null;
        EObject lv_imports_3_0 = null;

        EObject lv_programElements_4_0 = null;

        EObject lv_main_5_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:77:2: ( ( ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_programElements_4_0= ruleProgramElement ) )* ( (lv_main_5_0= ruleMainProcedure ) )? ) )
            // InternalMuLE.g:78:2: ( ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_programElements_4_0= ruleProgramElement ) )* ( (lv_main_5_0= ruleMainProcedure ) )? )
            {
            // InternalMuLE.g:78:2: ( ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_programElements_4_0= ruleProgramElement ) )* ( (lv_main_5_0= ruleMainProcedure ) )? )
            // InternalMuLE.g:79:3: ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) ) ( (lv_name_2_0= RULE_ID ) ) ( (lv_imports_3_0= ruleImport ) )* ( (lv_programElements_4_0= ruleProgramElement ) )* ( (lv_main_5_0= ruleMainProcedure ) )?
            {
            // InternalMuLE.g:79:3: ( ( (lv_isProgram_0_0= 'program' ) ) | ( (lv_isLibrary_1_0= 'library' ) ) )
            int alt1=2;
            int LA1_0 = input.LA(1);

            if ( (LA1_0==13) ) {
                alt1=1;
            }
            else if ( (LA1_0==14) ) {
                alt1=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 1, 0, input);

                throw nvae;
            }
            switch (alt1) {
                case 1 :
                    // InternalMuLE.g:80:4: ( (lv_isProgram_0_0= 'program' ) )
                    {
                    // InternalMuLE.g:80:4: ( (lv_isProgram_0_0= 'program' ) )
                    // InternalMuLE.g:81:5: (lv_isProgram_0_0= 'program' )
                    {
                    // InternalMuLE.g:81:5: (lv_isProgram_0_0= 'program' )
                    // InternalMuLE.g:82:6: lv_isProgram_0_0= 'program'
                    {
                    lv_isProgram_0_0=(Token)match(input,13,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isProgram_0_0, grammarAccess.getCompilationUnitAccess().getIsProgramProgramKeyword_0_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCompilationUnitRule());
                      						}
                      						setWithLastConsumed(current, "isProgram", true, "program");
                      					
                    }

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMuLE.g:95:4: ( (lv_isLibrary_1_0= 'library' ) )
                    {
                    // InternalMuLE.g:95:4: ( (lv_isLibrary_1_0= 'library' ) )
                    // InternalMuLE.g:96:5: (lv_isLibrary_1_0= 'library' )
                    {
                    // InternalMuLE.g:96:5: (lv_isLibrary_1_0= 'library' )
                    // InternalMuLE.g:97:6: lv_isLibrary_1_0= 'library'
                    {
                    lv_isLibrary_1_0=(Token)match(input,14,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_isLibrary_1_0, grammarAccess.getCompilationUnitAccess().getIsLibraryLibraryKeyword_0_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCompilationUnitRule());
                      						}
                      						setWithLastConsumed(current, "isLibrary", true, "library");
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalMuLE.g:110:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMuLE.g:111:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMuLE.g:111:4: (lv_name_2_0= RULE_ID )
            // InternalMuLE.g:112:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_4); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getCompilationUnitAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCompilationUnitRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            // InternalMuLE.g:128:3: ( (lv_imports_3_0= ruleImport ) )*
            loop2:
            do {
                int alt2=2;
                int LA2_0 = input.LA(1);

                if ( (LA2_0==16) ) {
                    alt2=1;
                }


                switch (alt2) {
            	case 1 :
            	    // InternalMuLE.g:129:4: (lv_imports_3_0= ruleImport )
            	    {
            	    // InternalMuLE.g:129:4: (lv_imports_3_0= ruleImport )
            	    // InternalMuLE.g:130:5: lv_imports_3_0= ruleImport
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompilationUnitAccess().getImportsImportParserRuleCall_2_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_4);
            	    lv_imports_3_0=ruleImport();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompilationUnitRule());
            	      					}
            	      					add(
            	      						current,
            	      						"imports",
            	      						lv_imports_3_0,
            	      						"de.ubt.ai1.mule.MuLE.Import");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop2;
                }
            } while (true);

            // InternalMuLE.g:147:3: ( (lv_programElements_4_0= ruleProgramElement ) )*
            loop3:
            do {
                int alt3=2;
                int LA3_0 = input.LA(1);

                if ( (LA3_0==RULE_ID||LA3_0==28||(LA3_0>=32 && LA3_0<=34)||LA3_0==37||LA3_0==42) ) {
                    alt3=1;
                }


                switch (alt3) {
            	case 1 :
            	    // InternalMuLE.g:148:4: (lv_programElements_4_0= ruleProgramElement )
            	    {
            	    // InternalMuLE.g:148:4: (lv_programElements_4_0= ruleProgramElement )
            	    // InternalMuLE.g:149:5: lv_programElements_4_0= ruleProgramElement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompilationUnitAccess().getProgramElementsProgramElementParserRuleCall_3_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_5);
            	    lv_programElements_4_0=ruleProgramElement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompilationUnitRule());
            	      					}
            	      					add(
            	      						current,
            	      						"programElements",
            	      						lv_programElements_4_0,
            	      						"de.ubt.ai1.mule.MuLE.ProgramElement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop3;
                }
            } while (true);

            // InternalMuLE.g:166:3: ( (lv_main_5_0= ruleMainProcedure ) )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==17) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMuLE.g:167:4: (lv_main_5_0= ruleMainProcedure )
                    {
                    // InternalMuLE.g:167:4: (lv_main_5_0= ruleMainProcedure )
                    // InternalMuLE.g:168:5: lv_main_5_0= ruleMainProcedure
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCompilationUnitAccess().getMainMainProcedureParserRuleCall_4_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_main_5_0=ruleMainProcedure();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getCompilationUnitRule());
                      					}
                      					set(
                      						current,
                      						"main",
                      						lv_main_5_0,
                      						"de.ubt.ai1.mule.MuLE.MainProcedure");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "ruleCompilationUnit"


    // $ANTLR start "entryRuleQualifiedName"
    // InternalMuLE.g:189:1: entryRuleQualifiedName returns [String current=null] : iv_ruleQualifiedName= ruleQualifiedName EOF ;
    public final String entryRuleQualifiedName() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleQualifiedName = null;


        try {
            // InternalMuLE.g:189:53: (iv_ruleQualifiedName= ruleQualifiedName EOF )
            // InternalMuLE.g:190:2: iv_ruleQualifiedName= ruleQualifiedName EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getQualifiedNameRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleQualifiedName=ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleQualifiedName.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // InternalMuLE.g:196:1: ruleQualifiedName returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) ;
    public final AntlrDatatypeRuleToken ruleQualifiedName() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token this_ID_0=null;
        Token kw=null;
        Token this_ID_2=null;


        	enterRule();

        try {
            // InternalMuLE.g:202:2: ( (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* ) )
            // InternalMuLE.g:203:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            {
            // InternalMuLE.g:203:2: (this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )* )
            // InternalMuLE.g:204:3: this_ID_0= RULE_ID (kw= '.' this_ID_2= RULE_ID )*
            {
            this_ID_0=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current.merge(this_ID_0);
              		
            }
            if ( state.backtracking==0 ) {

              			newLeafNode(this_ID_0, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_0());
              		
            }
            // InternalMuLE.g:211:3: (kw= '.' this_ID_2= RULE_ID )*
            loop5:
            do {
                int alt5=2;
                int LA5_0 = input.LA(1);

                if ( (LA5_0==15) ) {
                    alt5=1;
                }


                switch (alt5) {
            	case 1 :
            	    // InternalMuLE.g:212:4: kw= '.' this_ID_2= RULE_ID
            	    {
            	    kw=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(kw);
            	      				newLeafNode(kw, grammarAccess.getQualifiedNameAccess().getFullStopKeyword_1_0());
            	      			
            	    }
            	    this_ID_2=(Token)match(input,RULE_ID,FOLLOW_6); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				current.merge(this_ID_2);
            	      			
            	    }
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(this_ID_2, grammarAccess.getQualifiedNameAccess().getIDTerminalRuleCall_1_1());
            	      			
            	    }

            	    }
            	    break;

            	default :
            	    break loop5;
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


    // $ANTLR start "entryRuleImport"
    // InternalMuLE.g:229:1: entryRuleImport returns [EObject current=null] : iv_ruleImport= ruleImport EOF ;
    public final EObject entryRuleImport() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleImport = null;


        try {
            // InternalMuLE.g:229:47: (iv_ruleImport= ruleImport EOF )
            // InternalMuLE.g:230:2: iv_ruleImport= ruleImport EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getImportRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleImport=ruleImport();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleImport; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleImport"


    // $ANTLR start "ruleImport"
    // InternalMuLE.g:236:1: ruleImport returns [EObject current=null] : (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) ) ;
    public final EObject ruleImport() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMuLE.g:242:2: ( (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) ) )
            // InternalMuLE.g:243:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) )
            {
            // InternalMuLE.g:243:2: (otherlv_0= 'import' ( (otherlv_1= RULE_ID ) ) )
            // InternalMuLE.g:244:3: otherlv_0= 'import' ( (otherlv_1= RULE_ID ) )
            {
            otherlv_0=(Token)match(input,16,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getImportAccess().getImportKeyword_0());
              		
            }
            // InternalMuLE.g:248:3: ( (otherlv_1= RULE_ID ) )
            // InternalMuLE.g:249:4: (otherlv_1= RULE_ID )
            {
            // InternalMuLE.g:249:4: (otherlv_1= RULE_ID )
            // InternalMuLE.g:250:5: otherlv_1= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getImportRule());
              					}
              				
            }
            otherlv_1=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_1, grammarAccess.getImportAccess().getImportedNamespaceCompilationUnitCrossReference_1_0());
              				
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
    // $ANTLR end "ruleImport"


    // $ANTLR start "entryRuleMainProcedure"
    // InternalMuLE.g:265:1: entryRuleMainProcedure returns [EObject current=null] : iv_ruleMainProcedure= ruleMainProcedure EOF ;
    public final EObject entryRuleMainProcedure() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMainProcedure = null;


        try {
            // InternalMuLE.g:265:54: (iv_ruleMainProcedure= ruleMainProcedure EOF )
            // InternalMuLE.g:266:2: iv_ruleMainProcedure= ruleMainProcedure EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMainProcedureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMainProcedure=ruleMainProcedure();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMainProcedure; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMainProcedure"


    // $ANTLR start "ruleMainProcedure"
    // InternalMuLE.g:272:1: ruleMainProcedure returns [EObject current=null] : ( () otherlv_1= 'main' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endmain' ) ;
    public final EObject ruleMainProcedure() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:278:2: ( ( () otherlv_1= 'main' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endmain' ) )
            // InternalMuLE.g:279:2: ( () otherlv_1= 'main' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endmain' )
            {
            // InternalMuLE.g:279:2: ( () otherlv_1= 'main' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endmain' )
            // InternalMuLE.g:280:3: () otherlv_1= 'main' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endmain'
            {
            // InternalMuLE.g:280:3: ()
            // InternalMuLE.g:281:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getMainProcedureAccess().getMainProcedureAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,17,FOLLOW_7); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getMainProcedureAccess().getMainKeyword_1());
              		
            }
            // InternalMuLE.g:291:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalMuLE.g:292:4: (lv_block_2_0= ruleBlock )
            {
            // InternalMuLE.g:292:4: (lv_block_2_0= ruleBlock )
            // InternalMuLE.g:293:5: lv_block_2_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getMainProcedureAccess().getBlockBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_8);
            lv_block_2_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getMainProcedureRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_2_0,
              						"de.ubt.ai1.mule.MuLE.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,18,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getMainProcedureAccess().getEndmainKeyword_3());
              		
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
    // $ANTLR end "ruleMainProcedure"


    // $ANTLR start "entryRuleProgramElement"
    // InternalMuLE.g:318:1: entryRuleProgramElement returns [EObject current=null] : iv_ruleProgramElement= ruleProgramElement EOF ;
    public final EObject entryRuleProgramElement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleProgramElement = null;


        try {
            // InternalMuLE.g:318:55: (iv_ruleProgramElement= ruleProgramElement EOF )
            // InternalMuLE.g:319:2: iv_ruleProgramElement= ruleProgramElement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getProgramElementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleProgramElement=ruleProgramElement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleProgramElement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleProgramElement"


    // $ANTLR start "ruleProgramElement"
    // InternalMuLE.g:325:1: ruleProgramElement returns [EObject current=null] : (this_TypeDeclaration_0= ruleTypeDeclaration | this_Operation_1= ruleOperation ) ;
    public final EObject ruleProgramElement() throws RecognitionException {
        EObject current = null;

        EObject this_TypeDeclaration_0 = null;

        EObject this_Operation_1 = null;



        	enterRule();

        try {
            // InternalMuLE.g:331:2: ( (this_TypeDeclaration_0= ruleTypeDeclaration | this_Operation_1= ruleOperation ) )
            // InternalMuLE.g:332:2: (this_TypeDeclaration_0= ruleTypeDeclaration | this_Operation_1= ruleOperation )
            {
            // InternalMuLE.g:332:2: (this_TypeDeclaration_0= ruleTypeDeclaration | this_Operation_1= ruleOperation )
            int alt6=2;
            switch ( input.LA(1) ) {
            case 32:
                {
                switch ( input.LA(2) ) {
                case 37:
                    {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==34) ) {
                        alt6=1;
                    }
                    else if ( (LA6_3==28) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 34:
                    {
                    alt6=1;
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 1, input);

                    throw nvae;
                }

                }
                break;
            case 33:
                {
                switch ( input.LA(2) ) {
                case 34:
                    {
                    alt6=1;
                    }
                    break;
                case 37:
                    {
                    int LA6_3 = input.LA(3);

                    if ( (LA6_3==34) ) {
                        alt6=1;
                    }
                    else if ( (LA6_3==28) ) {
                        alt6=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 6, 3, input);

                        throw nvae;
                    }
                    }
                    break;
                case 28:
                    {
                    alt6=2;
                    }
                    break;
                default:
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 2, input);

                    throw nvae;
                }

                }
                break;
            case 37:
                {
                int LA6_3 = input.LA(2);

                if ( (LA6_3==34) ) {
                    alt6=1;
                }
                else if ( (LA6_3==28) ) {
                    alt6=2;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 6, 3, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
            case 34:
                {
                alt6=1;
                }
                break;
            case 28:
            case 42:
                {
                alt6=2;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 6, 0, input);

                throw nvae;
            }

            switch (alt6) {
                case 1 :
                    // InternalMuLE.g:333:3: this_TypeDeclaration_0= ruleTypeDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getProgramElementAccess().getTypeDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeDeclaration_0=ruleTypeDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:342:3: this_Operation_1= ruleOperation
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getProgramElementAccess().getOperationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Operation_1=ruleOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Operation_1;
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
    // $ANTLR end "ruleProgramElement"


    // $ANTLR start "entryRuleDataType"
    // InternalMuLE.g:354:1: entryRuleDataType returns [EObject current=null] : iv_ruleDataType= ruleDataType EOF ;
    public final EObject entryRuleDataType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDataType = null;


        try {
            // InternalMuLE.g:354:49: (iv_ruleDataType= ruleDataType EOF )
            // InternalMuLE.g:355:2: iv_ruleDataType= ruleDataType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDataTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDataType=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDataType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDataType"


    // $ANTLR start "ruleDataType"
    // InternalMuLE.g:361:1: ruleDataType returns [EObject current=null] : (this_BasicType_0= ruleBasicType | this_DeclaredType_1= ruleDeclaredType | this_ReferenceType_2= ruleReferenceType | this_ListType_3= ruleListType | this_OperationType_4= ruleOperationType ) ;
    public final EObject ruleDataType() throws RecognitionException {
        EObject current = null;

        EObject this_BasicType_0 = null;

        EObject this_DeclaredType_1 = null;

        EObject this_ReferenceType_2 = null;

        EObject this_ListType_3 = null;

        EObject this_OperationType_4 = null;



        	enterRule();

        try {
            // InternalMuLE.g:367:2: ( (this_BasicType_0= ruleBasicType | this_DeclaredType_1= ruleDeclaredType | this_ReferenceType_2= ruleReferenceType | this_ListType_3= ruleListType | this_OperationType_4= ruleOperationType ) )
            // InternalMuLE.g:368:2: (this_BasicType_0= ruleBasicType | this_DeclaredType_1= ruleDeclaredType | this_ReferenceType_2= ruleReferenceType | this_ListType_3= ruleListType | this_OperationType_4= ruleOperationType )
            {
            // InternalMuLE.g:368:2: (this_BasicType_0= ruleBasicType | this_DeclaredType_1= ruleDeclaredType | this_ReferenceType_2= ruleReferenceType | this_ListType_3= ruleListType | this_OperationType_4= ruleOperationType )
            int alt7=5;
            switch ( input.LA(1) ) {
            case 22:
            case 23:
            case 24:
            case 25:
                {
                alt7=1;
                }
                break;
            case RULE_ID:
                {
                alt7=2;
                }
                break;
            case 26:
                {
                alt7=3;
                }
                break;
            case 27:
                {
                alt7=4;
                }
                break;
            case 28:
                {
                alt7=5;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 7, 0, input);

                throw nvae;
            }

            switch (alt7) {
                case 1 :
                    // InternalMuLE.g:369:3: this_BasicType_0= ruleBasicType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeAccess().getBasicTypeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_BasicType_0=ruleBasicType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_BasicType_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:378:3: this_DeclaredType_1= ruleDeclaredType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeAccess().getDeclaredTypeParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_DeclaredType_1=ruleDeclaredType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_DeclaredType_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:387:3: this_ReferenceType_2= ruleReferenceType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeAccess().getReferenceTypeParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ReferenceType_2=ruleReferenceType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReferenceType_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMuLE.g:396:3: this_ListType_3= ruleListType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeAccess().getListTypeParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ListType_3=ruleListType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListType_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMuLE.g:405:3: this_OperationType_4= ruleOperationType
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getDataTypeAccess().getOperationTypeParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_OperationType_4=ruleOperationType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_OperationType_4;
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
    // $ANTLR end "ruleDataType"


    // $ANTLR start "entryRuleDeclaredType"
    // InternalMuLE.g:417:1: entryRuleDeclaredType returns [EObject current=null] : iv_ruleDeclaredType= ruleDeclaredType EOF ;
    public final EObject entryRuleDeclaredType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaredType = null;


        try {
            // InternalMuLE.g:417:53: (iv_ruleDeclaredType= ruleDeclaredType EOF )
            // InternalMuLE.g:418:2: iv_ruleDeclaredType= ruleDeclaredType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getDeclaredTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleDeclaredType=ruleDeclaredType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleDeclaredType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleDeclaredType"


    // $ANTLR start "ruleDeclaredType"
    // InternalMuLE.g:424:1: ruleDeclaredType returns [EObject current=null] : ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )? ) ;
    public final EObject ruleDeclaredType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_typeParams_2_0 = null;

        EObject lv_typeParams_4_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:430:2: ( ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )? ) )
            // InternalMuLE.g:431:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )? )
            {
            // InternalMuLE.g:431:2: ( ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )? )
            // InternalMuLE.g:432:3: ( ( ruleQualifiedName ) ) (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )?
            {
            // InternalMuLE.g:432:3: ( ( ruleQualifiedName ) )
            // InternalMuLE.g:433:4: ( ruleQualifiedName )
            {
            // InternalMuLE.g:433:4: ( ruleQualifiedName )
            // InternalMuLE.g:434:5: ruleQualifiedName
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getDeclaredTypeRule());
              					}
              				
            }
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getDeclaredTypeAccess().getTypeTypeDeclarationCrossReference_0_0());
              				
            }
            pushFollow(FOLLOW_9);
            ruleQualifiedName();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMuLE.g:448:3: (otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>' )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==19) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMuLE.g:449:4: otherlv_1= '<' ( (lv_typeParams_2_0= ruleDataType ) ) (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )* otherlv_5= '>'
                    {
                    otherlv_1=(Token)match(input,19,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getDeclaredTypeAccess().getLessThanSignKeyword_1_0());
                      			
                    }
                    // InternalMuLE.g:453:4: ( (lv_typeParams_2_0= ruleDataType ) )
                    // InternalMuLE.g:454:5: (lv_typeParams_2_0= ruleDataType )
                    {
                    // InternalMuLE.g:454:5: (lv_typeParams_2_0= ruleDataType )
                    // InternalMuLE.g:455:6: lv_typeParams_2_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getDeclaredTypeAccess().getTypeParamsDataTypeParserRuleCall_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_typeParams_2_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getDeclaredTypeRule());
                      						}
                      						add(
                      							current,
                      							"typeParams",
                      							lv_typeParams_2_0,
                      							"de.ubt.ai1.mule.MuLE.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:472:4: (otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==20) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMuLE.g:473:5: otherlv_3= ',' ( (lv_typeParams_4_0= ruleDataType ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getDeclaredTypeAccess().getCommaKeyword_1_2_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:477:5: ( (lv_typeParams_4_0= ruleDataType ) )
                    	    // InternalMuLE.g:478:6: (lv_typeParams_4_0= ruleDataType )
                    	    {
                    	    // InternalMuLE.g:478:6: (lv_typeParams_4_0= ruleDataType )
                    	    // InternalMuLE.g:479:7: lv_typeParams_4_0= ruleDataType
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getDeclaredTypeAccess().getTypeParamsDataTypeParserRuleCall_1_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_typeParams_4_0=ruleDataType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getDeclaredTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeParams",
                    	      								lv_typeParams_4_0,
                    	      								"de.ubt.ai1.mule.MuLE.DataType");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);

                    otherlv_5=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getDeclaredTypeAccess().getGreaterThanSignKeyword_1_3());
                      			
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
    // $ANTLR end "ruleDeclaredType"


    // $ANTLR start "entryRuleBasicType"
    // InternalMuLE.g:506:1: entryRuleBasicType returns [EObject current=null] : iv_ruleBasicType= ruleBasicType EOF ;
    public final EObject entryRuleBasicType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBasicType = null;


        try {
            // InternalMuLE.g:506:50: (iv_ruleBasicType= ruleBasicType EOF )
            // InternalMuLE.g:507:2: iv_ruleBasicType= ruleBasicType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBasicTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBasicType=ruleBasicType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBasicType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBasicType"


    // $ANTLR start "ruleBasicType"
    // InternalMuLE.g:513:1: ruleBasicType returns [EObject current=null] : ( ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) ) ) ;
    public final EObject ruleBasicType() throws RecognitionException {
        EObject current = null;

        Token lv_typeName_0_1=null;
        Token lv_typeName_0_2=null;
        Token lv_typeName_0_3=null;
        Token lv_typeName_0_4=null;


        	enterRule();

        try {
            // InternalMuLE.g:519:2: ( ( ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) ) ) )
            // InternalMuLE.g:520:2: ( ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) ) )
            {
            // InternalMuLE.g:520:2: ( ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) ) )
            // InternalMuLE.g:521:3: ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) )
            {
            // InternalMuLE.g:521:3: ( (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' ) )
            // InternalMuLE.g:522:4: (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' )
            {
            // InternalMuLE.g:522:4: (lv_typeName_0_1= 'integer' | lv_typeName_0_2= 'rational' | lv_typeName_0_3= 'string' | lv_typeName_0_4= 'boolean' )
            int alt10=4;
            switch ( input.LA(1) ) {
            case 22:
                {
                alt10=1;
                }
                break;
            case 23:
                {
                alt10=2;
                }
                break;
            case 24:
                {
                alt10=3;
                }
                break;
            case 25:
                {
                alt10=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 10, 0, input);

                throw nvae;
            }

            switch (alt10) {
                case 1 :
                    // InternalMuLE.g:523:5: lv_typeName_0_1= 'integer'
                    {
                    lv_typeName_0_1=(Token)match(input,22,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_typeName_0_1, grammarAccess.getBasicTypeAccess().getTypeNameIntegerKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBasicTypeRule());
                      					}
                      					setWithLastConsumed(current, "typeName", lv_typeName_0_1, null);
                      				
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:534:5: lv_typeName_0_2= 'rational'
                    {
                    lv_typeName_0_2=(Token)match(input,23,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_typeName_0_2, grammarAccess.getBasicTypeAccess().getTypeNameRationalKeyword_0_1());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBasicTypeRule());
                      					}
                      					setWithLastConsumed(current, "typeName", lv_typeName_0_2, null);
                      				
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:545:5: lv_typeName_0_3= 'string'
                    {
                    lv_typeName_0_3=(Token)match(input,24,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_typeName_0_3, grammarAccess.getBasicTypeAccess().getTypeNameStringKeyword_0_2());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBasicTypeRule());
                      					}
                      					setWithLastConsumed(current, "typeName", lv_typeName_0_3, null);
                      				
                    }

                    }
                    break;
                case 4 :
                    // InternalMuLE.g:556:5: lv_typeName_0_4= 'boolean'
                    {
                    lv_typeName_0_4=(Token)match(input,25,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_typeName_0_4, grammarAccess.getBasicTypeAccess().getTypeNameBooleanKeyword_0_3());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getBasicTypeRule());
                      					}
                      					setWithLastConsumed(current, "typeName", lv_typeName_0_4, null);
                      				
                    }

                    }
                    break;

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
    // $ANTLR end "ruleBasicType"


    // $ANTLR start "entryRuleReferenceType"
    // InternalMuLE.g:572:1: entryRuleReferenceType returns [EObject current=null] : iv_ruleReferenceType= ruleReferenceType EOF ;
    public final EObject entryRuleReferenceType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReferenceType = null;


        try {
            // InternalMuLE.g:572:54: (iv_ruleReferenceType= ruleReferenceType EOF )
            // InternalMuLE.g:573:2: iv_ruleReferenceType= ruleReferenceType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReferenceTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReferenceType=ruleReferenceType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReferenceType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReferenceType"


    // $ANTLR start "ruleReferenceType"
    // InternalMuLE.g:579:1: ruleReferenceType returns [EObject current=null] : (otherlv_0= 'reference' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' ) ;
    public final EObject ruleReferenceType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:585:2: ( (otherlv_0= 'reference' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' ) )
            // InternalMuLE.g:586:2: (otherlv_0= 'reference' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' )
            {
            // InternalMuLE.g:586:2: (otherlv_0= 'reference' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' )
            // InternalMuLE.g:587:3: otherlv_0= 'reference' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>'
            {
            otherlv_0=(Token)match(input,26,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getReferenceTypeAccess().getReferenceKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getReferenceTypeAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalMuLE.g:595:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalMuLE.g:596:4: (lv_type_2_0= ruleDataType )
            {
            // InternalMuLE.g:596:4: (lv_type_2_0= ruleDataType )
            // InternalMuLE.g:597:5: lv_type_2_0= ruleDataType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getReferenceTypeAccess().getTypeDataTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_type_2_0=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getReferenceTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"de.ubt.ai1.mule.MuLE.DataType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getReferenceTypeAccess().getGreaterThanSignKeyword_3());
              		
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
    // $ANTLR end "ruleReferenceType"


    // $ANTLR start "entryRuleListType"
    // InternalMuLE.g:622:1: entryRuleListType returns [EObject current=null] : iv_ruleListType= ruleListType EOF ;
    public final EObject entryRuleListType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListType = null;


        try {
            // InternalMuLE.g:622:49: (iv_ruleListType= ruleListType EOF )
            // InternalMuLE.g:623:2: iv_ruleListType= ruleListType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListType=ruleListType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleListType"


    // $ANTLR start "ruleListType"
    // InternalMuLE.g:629:1: ruleListType returns [EObject current=null] : (otherlv_0= 'list' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' ) ;
    public final EObject ruleListType() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_type_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:635:2: ( (otherlv_0= 'list' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' ) )
            // InternalMuLE.g:636:2: (otherlv_0= 'list' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' )
            {
            // InternalMuLE.g:636:2: (otherlv_0= 'list' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>' )
            // InternalMuLE.g:637:3: otherlv_0= 'list' otherlv_1= '<' ( (lv_type_2_0= ruleDataType ) ) otherlv_3= '>'
            {
            otherlv_0=(Token)match(input,27,FOLLOW_12); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getListTypeAccess().getListKeyword_0());
              		
            }
            otherlv_1=(Token)match(input,19,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListTypeAccess().getLessThanSignKeyword_1());
              		
            }
            // InternalMuLE.g:645:3: ( (lv_type_2_0= ruleDataType ) )
            // InternalMuLE.g:646:4: (lv_type_2_0= ruleDataType )
            {
            // InternalMuLE.g:646:4: (lv_type_2_0= ruleDataType )
            // InternalMuLE.g:647:5: lv_type_2_0= ruleDataType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListTypeAccess().getTypeDataTypeParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_13);
            lv_type_2_0=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getListTypeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_2_0,
              						"de.ubt.ai1.mule.MuLE.DataType");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,21,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getListTypeAccess().getGreaterThanSignKeyword_3());
              		
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
    // $ANTLR end "ruleListType"


    // $ANTLR start "entryRuleOperationType"
    // InternalMuLE.g:672:1: entryRuleOperationType returns [EObject current=null] : iv_ruleOperationType= ruleOperationType EOF ;
    public final EObject entryRuleOperationType() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperationType = null;


        try {
            // InternalMuLE.g:672:54: (iv_ruleOperationType= ruleOperationType EOF )
            // InternalMuLE.g:673:2: iv_ruleOperationType= ruleOperationType EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationTypeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperationType=ruleOperationType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperationType; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOperationType"


    // $ANTLR start "ruleOperationType"
    // InternalMuLE.g:679:1: ruleOperationType returns [EObject current=null] : ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ) ;
    public final EObject ruleOperationType() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        EObject lv_paramTypes_3_0 = null;

        EObject lv_paramTypes_5_0 = null;

        EObject lv_type_8_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:685:2: ( ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ) )
            // InternalMuLE.g:686:2: ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? )
            {
            // InternalMuLE.g:686:2: ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? )
            // InternalMuLE.g:687:3: () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )?
            {
            // InternalMuLE.g:687:3: ()
            // InternalMuLE.g:688:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getOperationTypeAccess().getOperationTypeAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getOperationTypeAccess().getOperationKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,29,FOLLOW_15); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getOperationTypeAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalMuLE.g:702:3: ( ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==RULE_ID||(LA12_0>=22 && LA12_0<=28)) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMuLE.g:703:4: ( (lv_paramTypes_3_0= ruleDataType ) ) (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )*
                    {
                    // InternalMuLE.g:703:4: ( (lv_paramTypes_3_0= ruleDataType ) )
                    // InternalMuLE.g:704:5: (lv_paramTypes_3_0= ruleDataType )
                    {
                    // InternalMuLE.g:704:5: (lv_paramTypes_3_0= ruleDataType )
                    // InternalMuLE.g:705:6: lv_paramTypes_3_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationTypeAccess().getParamTypesDataTypeParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_paramTypes_3_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationTypeRule());
                      						}
                      						add(
                      							current,
                      							"paramTypes",
                      							lv_paramTypes_3_0,
                      							"de.ubt.ai1.mule.MuLE.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:722:4: (otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==20) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMuLE.g:723:5: otherlv_4= ',' ( (lv_paramTypes_5_0= ruleDataType ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_10); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getOperationTypeAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:727:5: ( (lv_paramTypes_5_0= ruleDataType ) )
                    	    // InternalMuLE.g:728:6: (lv_paramTypes_5_0= ruleDataType )
                    	    {
                    	    // InternalMuLE.g:728:6: (lv_paramTypes_5_0= ruleDataType )
                    	    // InternalMuLE.g:729:7: lv_paramTypes_5_0= ruleDataType
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationTypeAccess().getParamTypesDataTypeParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_paramTypes_5_0=ruleDataType();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOperationTypeRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"paramTypes",
                    	      								lv_paramTypes_5_0,
                    	      								"de.ubt.ai1.mule.MuLE.DataType");
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


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_17); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getOperationTypeAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalMuLE.g:752:3: (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )?
            int alt13=2;
            int LA13_0 = input.LA(1);

            if ( (LA13_0==31) ) {
                alt13=1;
            }
            switch (alt13) {
                case 1 :
                    // InternalMuLE.g:753:4: otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getOperationTypeAccess().getColonKeyword_5_0());
                      			
                    }
                    // InternalMuLE.g:757:4: ( (lv_type_8_0= ruleDataType ) )
                    // InternalMuLE.g:758:5: (lv_type_8_0= ruleDataType )
                    {
                    // InternalMuLE.g:758:5: (lv_type_8_0= ruleDataType )
                    // InternalMuLE.g:759:6: lv_type_8_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationTypeAccess().getTypeDataTypeParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_type_8_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationTypeRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_8_0,
                      							"de.ubt.ai1.mule.MuLE.DataType");
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
    // $ANTLR end "ruleOperationType"


    // $ANTLR start "entryRuleVisibilityModifier"
    // InternalMuLE.g:781:1: entryRuleVisibilityModifier returns [String current=null] : iv_ruleVisibilityModifier= ruleVisibilityModifier EOF ;
    public final String entryRuleVisibilityModifier() throws RecognitionException {
        String current = null;

        AntlrDatatypeRuleToken iv_ruleVisibilityModifier = null;


        try {
            // InternalMuLE.g:781:58: (iv_ruleVisibilityModifier= ruleVisibilityModifier EOF )
            // InternalMuLE.g:782:2: iv_ruleVisibilityModifier= ruleVisibilityModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVisibilityModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVisibilityModifier=ruleVisibilityModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVisibilityModifier.getText(); 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVisibilityModifier"


    // $ANTLR start "ruleVisibilityModifier"
    // InternalMuLE.g:788:1: ruleVisibilityModifier returns [AntlrDatatypeRuleToken current=new AntlrDatatypeRuleToken()] : (kw= 'private' | kw= 'protected' ) ;
    public final AntlrDatatypeRuleToken ruleVisibilityModifier() throws RecognitionException {
        AntlrDatatypeRuleToken current = new AntlrDatatypeRuleToken();

        Token kw=null;


        	enterRule();

        try {
            // InternalMuLE.g:794:2: ( (kw= 'private' | kw= 'protected' ) )
            // InternalMuLE.g:795:2: (kw= 'private' | kw= 'protected' )
            {
            // InternalMuLE.g:795:2: (kw= 'private' | kw= 'protected' )
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==32) ) {
                alt14=1;
            }
            else if ( (LA14_0==33) ) {
                alt14=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 14, 0, input);

                throw nvae;
            }
            switch (alt14) {
                case 1 :
                    // InternalMuLE.g:796:3: kw= 'private'
                    {
                    kw=(Token)match(input,32,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getVisibilityModifierAccess().getPrivateKeyword_0());
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:802:3: kw= 'protected'
                    {
                    kw=(Token)match(input,33,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current.merge(kw);
                      			newLeafNode(kw, grammarAccess.getVisibilityModifierAccess().getProtectedKeyword_1());
                      		
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
    // $ANTLR end "ruleVisibilityModifier"


    // $ANTLR start "entryRuleTypeDeclaration"
    // InternalMuLE.g:811:1: entryRuleTypeDeclaration returns [EObject current=null] : iv_ruleTypeDeclaration= ruleTypeDeclaration EOF ;
    public final EObject entryRuleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeDeclaration = null;


        try {
            // InternalMuLE.g:811:56: (iv_ruleTypeDeclaration= ruleTypeDeclaration EOF )
            // InternalMuLE.g:812:2: iv_ruleTypeDeclaration= ruleTypeDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeDeclaration=ruleTypeDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeDeclaration"


    // $ANTLR start "ruleTypeDeclaration"
    // InternalMuLE.g:818:1: ruleTypeDeclaration returns [EObject current=null] : (this_Composition_0= ruleComposition | this_Enumeration_1= ruleEnumeration | this_TypeParameter_2= ruleTypeParameter ) ;
    public final EObject ruleTypeDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_Composition_0 = null;

        EObject this_Enumeration_1 = null;

        EObject this_TypeParameter_2 = null;



        	enterRule();

        try {
            // InternalMuLE.g:824:2: ( (this_Composition_0= ruleComposition | this_Enumeration_1= ruleEnumeration | this_TypeParameter_2= ruleTypeParameter ) )
            // InternalMuLE.g:825:2: (this_Composition_0= ruleComposition | this_Enumeration_1= ruleEnumeration | this_TypeParameter_2= ruleTypeParameter )
            {
            // InternalMuLE.g:825:2: (this_Composition_0= ruleComposition | this_Enumeration_1= ruleEnumeration | this_TypeParameter_2= ruleTypeParameter )
            int alt15=3;
            switch ( input.LA(1) ) {
            case 32:
                {
                int LA15_1 = input.LA(2);

                if ( (LA15_1==34) ) {
                    int LA15_4 = input.LA(3);

                    if ( (LA15_4==RULE_ID) ) {
                        int LA15_6 = input.LA(4);

                        if ( (LA15_6==19) ) {
                            alt15=1;
                        }
                        else if ( (LA15_6==31) ) {
                            int LA15_7 = input.LA(5);

                            if ( (LA15_7==35) ) {
                                alt15=2;
                            }
                            else if ( (LA15_7==38) ) {
                                alt15=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 4, input);

                        throw nvae;
                    }
                }
                else if ( (LA15_1==37) ) {
                    alt15=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA15_2 = input.LA(2);

                if ( (LA15_2==37) ) {
                    alt15=1;
                }
                else if ( (LA15_2==34) ) {
                    int LA15_4 = input.LA(3);

                    if ( (LA15_4==RULE_ID) ) {
                        int LA15_6 = input.LA(4);

                        if ( (LA15_6==19) ) {
                            alt15=1;
                        }
                        else if ( (LA15_6==31) ) {
                            int LA15_7 = input.LA(5);

                            if ( (LA15_7==35) ) {
                                alt15=2;
                            }
                            else if ( (LA15_7==38) ) {
                                alt15=1;
                            }
                            else {
                                if (state.backtracking>0) {state.failed=true; return current;}
                                NoViableAltException nvae =
                                    new NoViableAltException("", 15, 7, input);

                                throw nvae;
                            }
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 6, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 4, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 2, input);

                    throw nvae;
                }
                }
                break;
            case 37:
                {
                alt15=1;
                }
                break;
            case 34:
                {
                int LA15_4 = input.LA(2);

                if ( (LA15_4==RULE_ID) ) {
                    int LA15_6 = input.LA(3);

                    if ( (LA15_6==19) ) {
                        alt15=1;
                    }
                    else if ( (LA15_6==31) ) {
                        int LA15_7 = input.LA(4);

                        if ( (LA15_7==35) ) {
                            alt15=2;
                        }
                        else if ( (LA15_7==38) ) {
                            alt15=1;
                        }
                        else {
                            if (state.backtracking>0) {state.failed=true; return current;}
                            NoViableAltException nvae =
                                new NoViableAltException("", 15, 7, input);

                            throw nvae;
                        }
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 15, 6, input);

                        throw nvae;
                    }
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 15, 4, input);

                    throw nvae;
                }
                }
                break;
            case RULE_ID:
                {
                alt15=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 15, 0, input);

                throw nvae;
            }

            switch (alt15) {
                case 1 :
                    // InternalMuLE.g:826:3: this_Composition_0= ruleComposition
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDeclarationAccess().getCompositionParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Composition_0=ruleComposition();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Composition_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:835:3: this_Enumeration_1= ruleEnumeration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDeclarationAccess().getEnumerationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Enumeration_1=ruleEnumeration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Enumeration_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:844:3: this_TypeParameter_2= ruleTypeParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getTypeDeclarationAccess().getTypeParameterParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_TypeParameter_2=ruleTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_TypeParameter_2;
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
    // $ANTLR end "ruleTypeDeclaration"


    // $ANTLR start "entryRuleEnumeration"
    // InternalMuLE.g:856:1: entryRuleEnumeration returns [EObject current=null] : iv_ruleEnumeration= ruleEnumeration EOF ;
    public final EObject entryRuleEnumeration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumeration = null;


        try {
            // InternalMuLE.g:856:52: (iv_ruleEnumeration= ruleEnumeration EOF )
            // InternalMuLE.g:857:2: iv_ruleEnumeration= ruleEnumeration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumeration=ruleEnumeration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumeration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEnumeration"


    // $ANTLR start "ruleEnumeration"
    // InternalMuLE.g:863:1: ruleEnumeration returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' otherlv_4= 'enumeration' ( (lv_values_5_0= ruleEnumerationValue ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )* otherlv_8= 'endtype' ) ;
    public final EObject ruleEnumeration() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        AntlrDatatypeRuleToken lv_visibility_0_0 = null;

        EObject lv_values_5_0 = null;

        EObject lv_values_7_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:869:2: ( ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' otherlv_4= 'enumeration' ( (lv_values_5_0= ruleEnumerationValue ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )* otherlv_8= 'endtype' ) )
            // InternalMuLE.g:870:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' otherlv_4= 'enumeration' ( (lv_values_5_0= ruleEnumerationValue ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )* otherlv_8= 'endtype' )
            {
            // InternalMuLE.g:870:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' otherlv_4= 'enumeration' ( (lv_values_5_0= ruleEnumerationValue ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )* otherlv_8= 'endtype' )
            // InternalMuLE.g:871:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'type' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' otherlv_4= 'enumeration' ( (lv_values_5_0= ruleEnumerationValue ) ) (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )* otherlv_8= 'endtype'
            {
            // InternalMuLE.g:871:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( ((LA16_0>=32 && LA16_0<=33)) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMuLE.g:872:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    {
                    // InternalMuLE.g:872:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    // InternalMuLE.g:873:5: lv_visibility_0_0= ruleVisibilityModifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getEnumerationAccess().getVisibilityVisibilityModifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_18);
                    lv_visibility_0_0=ruleVisibilityModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getEnumerationRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_0_0,
                      						"de.ubt.ai1.mule.MuLE.VisibilityModifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getEnumerationAccess().getTypeKeyword_1());
              		
            }
            // InternalMuLE.g:894:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMuLE.g:895:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMuLE.g:895:4: (lv_name_2_0= RULE_ID )
            // InternalMuLE.g:896:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getEnumerationAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getEnumerationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_20); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getEnumerationAccess().getColonKeyword_3());
              		
            }
            otherlv_4=(Token)match(input,35,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getEnumerationAccess().getEnumerationKeyword_4());
              		
            }
            // InternalMuLE.g:920:3: ( (lv_values_5_0= ruleEnumerationValue ) )
            // InternalMuLE.g:921:4: (lv_values_5_0= ruleEnumerationValue )
            {
            // InternalMuLE.g:921:4: (lv_values_5_0= ruleEnumerationValue )
            // InternalMuLE.g:922:5: lv_values_5_0= ruleEnumerationValue
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getEnumerationAccess().getValuesEnumerationValueParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_21);
            lv_values_5_0=ruleEnumerationValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getEnumerationRule());
              					}
              					add(
              						current,
              						"values",
              						lv_values_5_0,
              						"de.ubt.ai1.mule.MuLE.EnumerationValue");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMuLE.g:939:3: (otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) ) )*
            loop17:
            do {
                int alt17=2;
                int LA17_0 = input.LA(1);

                if ( (LA17_0==20) ) {
                    alt17=1;
                }


                switch (alt17) {
            	case 1 :
            	    // InternalMuLE.g:940:4: otherlv_6= ',' ( (lv_values_7_0= ruleEnumerationValue ) )
            	    {
            	    otherlv_6=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_6, grammarAccess.getEnumerationAccess().getCommaKeyword_6_0());
            	      			
            	    }
            	    // InternalMuLE.g:944:4: ( (lv_values_7_0= ruleEnumerationValue ) )
            	    // InternalMuLE.g:945:5: (lv_values_7_0= ruleEnumerationValue )
            	    {
            	    // InternalMuLE.g:945:5: (lv_values_7_0= ruleEnumerationValue )
            	    // InternalMuLE.g:946:6: lv_values_7_0= ruleEnumerationValue
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEnumerationAccess().getValuesEnumerationValueParserRuleCall_6_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_21);
            	    lv_values_7_0=ruleEnumerationValue();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEnumerationRule());
            	      						}
            	      						add(
            	      							current,
            	      							"values",
            	      							lv_values_7_0,
            	      							"de.ubt.ai1.mule.MuLE.EnumerationValue");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop17;
                }
            } while (true);

            otherlv_8=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_8, grammarAccess.getEnumerationAccess().getEndtypeKeyword_7());
              		
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
    // $ANTLR end "ruleEnumeration"


    // $ANTLR start "entryRuleEnumerationValue"
    // InternalMuLE.g:972:1: entryRuleEnumerationValue returns [EObject current=null] : iv_ruleEnumerationValue= ruleEnumerationValue EOF ;
    public final EObject entryRuleEnumerationValue() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEnumerationValue = null;


        try {
            // InternalMuLE.g:972:57: (iv_ruleEnumerationValue= ruleEnumerationValue EOF )
            // InternalMuLE.g:973:2: iv_ruleEnumerationValue= ruleEnumerationValue EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEnumerationValueRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEnumerationValue=ruleEnumerationValue();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEnumerationValue; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEnumerationValue"


    // $ANTLR start "ruleEnumerationValue"
    // InternalMuLE.g:979:1: ruleEnumerationValue returns [EObject current=null] : ( (lv_name_0_0= RULE_ID ) ) ;
    public final EObject ruleEnumerationValue() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;


        	enterRule();

        try {
            // InternalMuLE.g:985:2: ( ( (lv_name_0_0= RULE_ID ) ) )
            // InternalMuLE.g:986:2: ( (lv_name_0_0= RULE_ID ) )
            {
            // InternalMuLE.g:986:2: ( (lv_name_0_0= RULE_ID ) )
            // InternalMuLE.g:987:3: (lv_name_0_0= RULE_ID )
            {
            // InternalMuLE.g:987:3: (lv_name_0_0= RULE_ID )
            // InternalMuLE.g:988:4: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              				newLeafNode(lv_name_0_0, grammarAccess.getEnumerationValueAccess().getNameIDTerminalRuleCall_0());
              			
            }
            if ( state.backtracking==0 ) {

              				if (current==null) {
              					current = createModelElement(grammarAccess.getEnumerationValueRule());
              				}
              				setWithLastConsumed(
              					current,
              					"name",
              					lv_name_0_0,
              					"de.ubt.ai1.mule.MuLE.ID");
              			
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
    // $ANTLR end "ruleEnumerationValue"


    // $ANTLR start "entryRuleComposition"
    // InternalMuLE.g:1007:1: entryRuleComposition returns [EObject current=null] : iv_ruleComposition= ruleComposition EOF ;
    public final EObject entryRuleComposition() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComposition = null;


        try {
            // InternalMuLE.g:1007:52: (iv_ruleComposition= ruleComposition EOF )
            // InternalMuLE.g:1008:2: iv_ruleComposition= ruleComposition EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getCompositionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComposition=ruleComposition();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComposition; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleComposition"


    // $ANTLR start "ruleComposition"
    // InternalMuLE.g:1014:1: ruleComposition returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )? otherlv_9= ':' otherlv_10= 'composition' (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )? ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )* ( (lv_attributes_19_0= ruleAttribute ) )* ( (lv_operations_20_0= ruleOperation ) )* otherlv_21= 'endtype' ) ;
    public final EObject ruleComposition() throws RecognitionException {
        EObject current = null;

        Token lv_abstract_1_0=null;
        Token otherlv_2=null;
        Token lv_name_3_0=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_13=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_21=null;
        AntlrDatatypeRuleToken lv_visibility_0_0 = null;

        EObject lv_typeParams_5_0 = null;

        EObject lv_typeParams_7_0 = null;

        EObject lv_superTypeParams_14_0 = null;

        EObject lv_superTypeParams_16_0 = null;

        EObject lv_typeDeclarations_18_0 = null;

        EObject lv_attributes_19_0 = null;

        EObject lv_operations_20_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1020:2: ( ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )? otherlv_9= ':' otherlv_10= 'composition' (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )? ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )* ( (lv_attributes_19_0= ruleAttribute ) )* ( (lv_operations_20_0= ruleOperation ) )* otherlv_21= 'endtype' ) )
            // InternalMuLE.g:1021:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )? otherlv_9= ':' otherlv_10= 'composition' (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )? ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )* ( (lv_attributes_19_0= ruleAttribute ) )* ( (lv_operations_20_0= ruleOperation ) )* otherlv_21= 'endtype' )
            {
            // InternalMuLE.g:1021:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )? otherlv_9= ':' otherlv_10= 'composition' (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )? ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )* ( (lv_attributes_19_0= ruleAttribute ) )* ( (lv_operations_20_0= ruleOperation ) )* otherlv_21= 'endtype' )
            // InternalMuLE.g:1022:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )? ( (lv_abstract_1_0= 'abstract' ) )? otherlv_2= 'type' ( (lv_name_3_0= RULE_ID ) ) (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )? otherlv_9= ':' otherlv_10= 'composition' (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )? ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )* ( (lv_attributes_19_0= ruleAttribute ) )* ( (lv_operations_20_0= ruleOperation ) )* otherlv_21= 'endtype'
            {
            // InternalMuLE.g:1022:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( ((LA18_0>=32 && LA18_0<=33)) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMuLE.g:1023:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    {
                    // InternalMuLE.g:1023:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    // InternalMuLE.g:1024:5: lv_visibility_0_0= ruleVisibilityModifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getCompositionAccess().getVisibilityVisibilityModifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_22);
                    lv_visibility_0_0=ruleVisibilityModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getCompositionRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_0_0,
                      						"de.ubt.ai1.mule.MuLE.VisibilityModifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMuLE.g:1041:3: ( (lv_abstract_1_0= 'abstract' ) )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==37) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMuLE.g:1042:4: (lv_abstract_1_0= 'abstract' )
                    {
                    // InternalMuLE.g:1042:4: (lv_abstract_1_0= 'abstract' )
                    // InternalMuLE.g:1043:5: lv_abstract_1_0= 'abstract'
                    {
                    lv_abstract_1_0=(Token)match(input,37,FOLLOW_18); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_abstract_1_0, grammarAccess.getCompositionAccess().getAbstractAbstractKeyword_1_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getCompositionRule());
                      					}
                      					setWithLastConsumed(current, "abstract", true, "abstract");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_2=(Token)match(input,34,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getCompositionAccess().getTypeKeyword_2());
              		
            }
            // InternalMuLE.g:1059:3: ( (lv_name_3_0= RULE_ID ) )
            // InternalMuLE.g:1060:4: (lv_name_3_0= RULE_ID )
            {
            // InternalMuLE.g:1060:4: (lv_name_3_0= RULE_ID )
            // InternalMuLE.g:1061:5: lv_name_3_0= RULE_ID
            {
            lv_name_3_0=(Token)match(input,RULE_ID,FOLLOW_23); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_3_0, grammarAccess.getCompositionAccess().getNameIDTerminalRuleCall_3_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getCompositionRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_3_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            // InternalMuLE.g:1077:3: (otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>' )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==19) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMuLE.g:1078:4: otherlv_4= '<' ( (lv_typeParams_5_0= ruleTypeParameter ) ) (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )* otherlv_8= '>'
                    {
                    otherlv_4=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_4, grammarAccess.getCompositionAccess().getLessThanSignKeyword_4_0());
                      			
                    }
                    // InternalMuLE.g:1082:4: ( (lv_typeParams_5_0= ruleTypeParameter ) )
                    // InternalMuLE.g:1083:5: (lv_typeParams_5_0= ruleTypeParameter )
                    {
                    // InternalMuLE.g:1083:5: (lv_typeParams_5_0= ruleTypeParameter )
                    // InternalMuLE.g:1084:6: lv_typeParams_5_0= ruleTypeParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCompositionAccess().getTypeParamsTypeParameterParserRuleCall_4_1_0());
                      					
                    }
                    pushFollow(FOLLOW_11);
                    lv_typeParams_5_0=ruleTypeParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getCompositionRule());
                      						}
                      						add(
                      							current,
                      							"typeParams",
                      							lv_typeParams_5_0,
                      							"de.ubt.ai1.mule.MuLE.TypeParameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:1101:4: (otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==20) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMuLE.g:1102:5: otherlv_6= ',' ( (lv_typeParams_7_0= ruleTypeParameter ) )
                    	    {
                    	    otherlv_6=(Token)match(input,20,FOLLOW_24); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_6, grammarAccess.getCompositionAccess().getCommaKeyword_4_2_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:1106:5: ( (lv_typeParams_7_0= ruleTypeParameter ) )
                    	    // InternalMuLE.g:1107:6: (lv_typeParams_7_0= ruleTypeParameter )
                    	    {
                    	    // InternalMuLE.g:1107:6: (lv_typeParams_7_0= ruleTypeParameter )
                    	    // InternalMuLE.g:1108:7: lv_typeParams_7_0= ruleTypeParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getCompositionAccess().getTypeParamsTypeParameterParserRuleCall_4_2_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_11);
                    	    lv_typeParams_7_0=ruleTypeParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getCompositionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"typeParams",
                    	      								lv_typeParams_7_0,
                    	      								"de.ubt.ai1.mule.MuLE.TypeParameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);

                    otherlv_8=(Token)match(input,21,FOLLOW_19); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getCompositionAccess().getGreaterThanSignKeyword_4_3());
                      			
                    }

                    }
                    break;

            }

            otherlv_9=(Token)match(input,31,FOLLOW_25); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getCompositionAccess().getColonKeyword_5());
              		
            }
            otherlv_10=(Token)match(input,38,FOLLOW_26); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getCompositionAccess().getCompositionKeyword_6());
              		
            }
            // InternalMuLE.g:1139:3: (otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )? )?
            int alt24=2;
            int LA24_0 = input.LA(1);

            if ( (LA24_0==39) ) {
                alt24=1;
            }
            switch (alt24) {
                case 1 :
                    // InternalMuLE.g:1140:4: otherlv_11= 'extends' ( ( ruleQualifiedName ) ) (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )?
                    {
                    otherlv_11=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getCompositionAccess().getExtendsKeyword_7_0());
                      			
                    }
                    // InternalMuLE.g:1144:4: ( ( ruleQualifiedName ) )
                    // InternalMuLE.g:1145:5: ( ruleQualifiedName )
                    {
                    // InternalMuLE.g:1145:5: ( ruleQualifiedName )
                    // InternalMuLE.g:1146:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getCompositionRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getCompositionAccess().getSuperTypeCompositionCrossReference_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_27);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:1160:4: (otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>' )?
                    int alt23=2;
                    int LA23_0 = input.LA(1);

                    if ( (LA23_0==19) ) {
                        alt23=1;
                    }
                    switch (alt23) {
                        case 1 :
                            // InternalMuLE.g:1161:5: otherlv_13= '<' ( (lv_superTypeParams_14_0= ruleTypeParameter ) ) (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )* otherlv_17= '>'
                            {
                            otherlv_13=(Token)match(input,19,FOLLOW_24); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_13, grammarAccess.getCompositionAccess().getLessThanSignKeyword_7_2_0());
                              				
                            }
                            // InternalMuLE.g:1165:5: ( (lv_superTypeParams_14_0= ruleTypeParameter ) )
                            // InternalMuLE.g:1166:6: (lv_superTypeParams_14_0= ruleTypeParameter )
                            {
                            // InternalMuLE.g:1166:6: (lv_superTypeParams_14_0= ruleTypeParameter )
                            // InternalMuLE.g:1167:7: lv_superTypeParams_14_0= ruleTypeParameter
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getCompositionAccess().getSuperTypeParamsTypeParameterParserRuleCall_7_2_1_0());
                              						
                            }
                            pushFollow(FOLLOW_11);
                            lv_superTypeParams_14_0=ruleTypeParameter();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getCompositionRule());
                              							}
                              							add(
                              								current,
                              								"superTypeParams",
                              								lv_superTypeParams_14_0,
                              								"de.ubt.ai1.mule.MuLE.TypeParameter");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMuLE.g:1184:5: (otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) ) )*
                            loop22:
                            do {
                                int alt22=2;
                                int LA22_0 = input.LA(1);

                                if ( (LA22_0==20) ) {
                                    alt22=1;
                                }


                                switch (alt22) {
                            	case 1 :
                            	    // InternalMuLE.g:1185:6: otherlv_15= ',' ( (lv_superTypeParams_16_0= ruleTypeParameter ) )
                            	    {
                            	    otherlv_15=(Token)match(input,20,FOLLOW_24); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_15, grammarAccess.getCompositionAccess().getCommaKeyword_7_2_2_0());
                            	      					
                            	    }
                            	    // InternalMuLE.g:1189:6: ( (lv_superTypeParams_16_0= ruleTypeParameter ) )
                            	    // InternalMuLE.g:1190:7: (lv_superTypeParams_16_0= ruleTypeParameter )
                            	    {
                            	    // InternalMuLE.g:1190:7: (lv_superTypeParams_16_0= ruleTypeParameter )
                            	    // InternalMuLE.g:1191:8: lv_superTypeParams_16_0= ruleTypeParameter
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getCompositionAccess().getSuperTypeParamsTypeParameterParserRuleCall_7_2_2_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_11);
                            	    lv_superTypeParams_16_0=ruleTypeParameter();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getCompositionRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"superTypeParams",
                            	      									lv_superTypeParams_16_0,
                            	      									"de.ubt.ai1.mule.MuLE.TypeParameter");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop22;
                                }
                            } while (true);

                            otherlv_17=(Token)match(input,21,FOLLOW_28); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              					newLeafNode(otherlv_17, grammarAccess.getCompositionAccess().getGreaterThanSignKeyword_7_2_3());
                              				
                            }

                            }
                            break;

                    }


                    }
                    break;

            }

            // InternalMuLE.g:1215:3: ( (lv_typeDeclarations_18_0= ruleTypeDeclaration ) )*
            loop25:
            do {
                int alt25=2;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    int LA25_1 = input.LA(2);

                    if ( (LA25_1==37) ) {
                        int LA25_4 = input.LA(3);

                        if ( (LA25_4==34) ) {
                            alt25=1;
                        }


                    }
                    else if ( (LA25_1==34) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA25_2 = input.LA(2);

                    if ( (LA25_2==37) ) {
                        int LA25_4 = input.LA(3);

                        if ( (LA25_4==34) ) {
                            alt25=1;
                        }


                    }
                    else if ( (LA25_2==34) ) {
                        alt25=1;
                    }


                    }
                    break;
                case 37:
                    {
                    int LA25_4 = input.LA(2);

                    if ( (LA25_4==34) ) {
                        alt25=1;
                    }


                    }
                    break;
                case RULE_ID:
                case 34:
                    {
                    alt25=1;
                    }
                    break;

                }

                switch (alt25) {
            	case 1 :
            	    // InternalMuLE.g:1216:4: (lv_typeDeclarations_18_0= ruleTypeDeclaration )
            	    {
            	    // InternalMuLE.g:1216:4: (lv_typeDeclarations_18_0= ruleTypeDeclaration )
            	    // InternalMuLE.g:1217:5: lv_typeDeclarations_18_0= ruleTypeDeclaration
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompositionAccess().getTypeDeclarationsTypeDeclarationParserRuleCall_8_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_typeDeclarations_18_0=ruleTypeDeclaration();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompositionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"typeDeclarations",
            	      						lv_typeDeclarations_18_0,
            	      						"de.ubt.ai1.mule.MuLE.TypeDeclaration");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop25;
                }
            } while (true);

            // InternalMuLE.g:1234:3: ( (lv_attributes_19_0= ruleAttribute ) )*
            loop26:
            do {
                int alt26=2;
                switch ( input.LA(1) ) {
                case 32:
                    {
                    int LA26_2 = input.LA(2);

                    if ( (LA26_2==40) ) {
                        alt26=1;
                    }


                    }
                    break;
                case 33:
                    {
                    int LA26_3 = input.LA(2);

                    if ( (LA26_3==40) ) {
                        alt26=1;
                    }


                    }
                    break;
                case 40:
                    {
                    alt26=1;
                    }
                    break;

                }

                switch (alt26) {
            	case 1 :
            	    // InternalMuLE.g:1235:4: (lv_attributes_19_0= ruleAttribute )
            	    {
            	    // InternalMuLE.g:1235:4: (lv_attributes_19_0= ruleAttribute )
            	    // InternalMuLE.g:1236:5: lv_attributes_19_0= ruleAttribute
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompositionAccess().getAttributesAttributeParserRuleCall_9_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_28);
            	    lv_attributes_19_0=ruleAttribute();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompositionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"attributes",
            	      						lv_attributes_19_0,
            	      						"de.ubt.ai1.mule.MuLE.Attribute");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop26;
                }
            } while (true);

            // InternalMuLE.g:1253:3: ( (lv_operations_20_0= ruleOperation ) )*
            loop27:
            do {
                int alt27=2;
                int LA27_0 = input.LA(1);

                if ( (LA27_0==28||(LA27_0>=32 && LA27_0<=33)||LA27_0==37||LA27_0==42) ) {
                    alt27=1;
                }


                switch (alt27) {
            	case 1 :
            	    // InternalMuLE.g:1254:4: (lv_operations_20_0= ruleOperation )
            	    {
            	    // InternalMuLE.g:1254:4: (lv_operations_20_0= ruleOperation )
            	    // InternalMuLE.g:1255:5: lv_operations_20_0= ruleOperation
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getCompositionAccess().getOperationsOperationParserRuleCall_10_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_29);
            	    lv_operations_20_0=ruleOperation();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getCompositionRule());
            	      					}
            	      					add(
            	      						current,
            	      						"operations",
            	      						lv_operations_20_0,
            	      						"de.ubt.ai1.mule.MuLE.Operation");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop27;
                }
            } while (true);

            otherlv_21=(Token)match(input,36,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_21, grammarAccess.getCompositionAccess().getEndtypeKeyword_11());
              		
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
    // $ANTLR end "ruleComposition"


    // $ANTLR start "entryRuleTypeParameter"
    // InternalMuLE.g:1280:1: entryRuleTypeParameter returns [EObject current=null] : iv_ruleTypeParameter= ruleTypeParameter EOF ;
    public final EObject entryRuleTypeParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleTypeParameter = null;


        try {
            // InternalMuLE.g:1280:54: (iv_ruleTypeParameter= ruleTypeParameter EOF )
            // InternalMuLE.g:1281:2: iv_ruleTypeParameter= ruleTypeParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getTypeParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleTypeParameter=ruleTypeParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleTypeParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleTypeParameter"


    // $ANTLR start "ruleTypeParameter"
    // InternalMuLE.g:1287:1: ruleTypeParameter returns [EObject current=null] : ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? ) ;
    public final EObject ruleTypeParameter() throws RecognitionException {
        EObject current = null;

        Token lv_name_0_0=null;
        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMuLE.g:1293:2: ( ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? ) )
            // InternalMuLE.g:1294:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? )
            {
            // InternalMuLE.g:1294:2: ( ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )? )
            // InternalMuLE.g:1295:3: ( (lv_name_0_0= RULE_ID ) ) (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )?
            {
            // InternalMuLE.g:1295:3: ( (lv_name_0_0= RULE_ID ) )
            // InternalMuLE.g:1296:4: (lv_name_0_0= RULE_ID )
            {
            // InternalMuLE.g:1296:4: (lv_name_0_0= RULE_ID )
            // InternalMuLE.g:1297:5: lv_name_0_0= RULE_ID
            {
            lv_name_0_0=(Token)match(input,RULE_ID,FOLLOW_30); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_0_0, grammarAccess.getTypeParameterAccess().getNameIDTerminalRuleCall_0_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getTypeParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_0_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            // InternalMuLE.g:1313:3: (otherlv_1= 'extends' ( ( ruleQualifiedName ) ) )?
            int alt28=2;
            int LA28_0 = input.LA(1);

            if ( (LA28_0==39) ) {
                alt28=1;
            }
            switch (alt28) {
                case 1 :
                    // InternalMuLE.g:1314:4: otherlv_1= 'extends' ( ( ruleQualifiedName ) )
                    {
                    otherlv_1=(Token)match(input,39,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getTypeParameterAccess().getExtendsKeyword_1_0());
                      			
                    }
                    // InternalMuLE.g:1318:4: ( ( ruleQualifiedName ) )
                    // InternalMuLE.g:1319:5: ( ruleQualifiedName )
                    {
                    // InternalMuLE.g:1319:5: ( ruleQualifiedName )
                    // InternalMuLE.g:1320:6: ruleQualifiedName
                    {
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getTypeParameterRule());
                      						}
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getTypeParameterAccess().getSuperTypeCompositionCrossReference_1_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    ruleQualifiedName();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

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
    // $ANTLR end "ruleTypeParameter"


    // $ANTLR start "entryRuleFeature"
    // InternalMuLE.g:1339:1: entryRuleFeature returns [EObject current=null] : iv_ruleFeature= ruleFeature EOF ;
    public final EObject entryRuleFeature() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleFeature = null;


        try {
            // InternalMuLE.g:1339:48: (iv_ruleFeature= ruleFeature EOF )
            // InternalMuLE.g:1340:2: iv_ruleFeature= ruleFeature EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getFeatureRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleFeature=ruleFeature();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleFeature; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleFeature"


    // $ANTLR start "ruleFeature"
    // InternalMuLE.g:1346:1: ruleFeature returns [EObject current=null] : (this_Attribute_0= ruleAttribute | this_VariableDeclaration_1= ruleVariableDeclaration | this_Parameter_2= ruleParameter | this_Operation_3= ruleOperation ) ;
    public final EObject ruleFeature() throws RecognitionException {
        EObject current = null;

        EObject this_Attribute_0 = null;

        EObject this_VariableDeclaration_1 = null;

        EObject this_Parameter_2 = null;

        EObject this_Operation_3 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1352:2: ( (this_Attribute_0= ruleAttribute | this_VariableDeclaration_1= ruleVariableDeclaration | this_Parameter_2= ruleParameter | this_Operation_3= ruleOperation ) )
            // InternalMuLE.g:1353:2: (this_Attribute_0= ruleAttribute | this_VariableDeclaration_1= ruleVariableDeclaration | this_Parameter_2= ruleParameter | this_Operation_3= ruleOperation )
            {
            // InternalMuLE.g:1353:2: (this_Attribute_0= ruleAttribute | this_VariableDeclaration_1= ruleVariableDeclaration | this_Parameter_2= ruleParameter | this_Operation_3= ruleOperation )
            int alt29=4;
            switch ( input.LA(1) ) {
            case 32:
                {
                int LA29_1 = input.LA(2);

                if ( (LA29_1==28||LA29_1==37) ) {
                    alt29=4;
                }
                else if ( (LA29_1==40) ) {
                    alt29=1;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 1, input);

                    throw nvae;
                }
                }
                break;
            case 33:
                {
                int LA29_2 = input.LA(2);

                if ( (LA29_2==40) ) {
                    alt29=1;
                }
                else if ( (LA29_2==28||LA29_2==37) ) {
                    alt29=4;
                }
                else {
                    if (state.backtracking>0) {state.failed=true; return current;}
                    NoViableAltException nvae =
                        new NoViableAltException("", 29, 2, input);

                    throw nvae;
                }
                }
                break;
            case 40:
                {
                alt29=1;
                }
                break;
            case 46:
                {
                alt29=2;
                }
                break;
            case 41:
                {
                alt29=3;
                }
                break;
            case 28:
            case 37:
            case 42:
                {
                alt29=4;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }

            switch (alt29) {
                case 1 :
                    // InternalMuLE.g:1354:3: this_Attribute_0= ruleAttribute
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureAccess().getAttributeParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Attribute_0=ruleAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Attribute_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:1363:3: this_VariableDeclaration_1= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureAccess().getVariableDeclarationParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_1=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:1372:3: this_Parameter_2= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureAccess().getParameterParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Parameter_2=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Parameter_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMuLE.g:1381:3: this_Operation_3= ruleOperation
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getFeatureAccess().getOperationParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_Operation_3=ruleOperation();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_Operation_3;
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
    // $ANTLR end "ruleFeature"


    // $ANTLR start "entryRuleAttribute"
    // InternalMuLE.g:1393:1: entryRuleAttribute returns [EObject current=null] : iv_ruleAttribute= ruleAttribute EOF ;
    public final EObject entryRuleAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAttribute = null;


        try {
            // InternalMuLE.g:1393:50: (iv_ruleAttribute= ruleAttribute EOF )
            // InternalMuLE.g:1394:2: iv_ruleAttribute= ruleAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAttribute=ruleAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAttribute; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAttribute"


    // $ANTLR start "ruleAttribute"
    // InternalMuLE.g:1400:1: ruleAttribute returns [EObject current=null] : ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataType ) ) ) ;
    public final EObject ruleAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token lv_name_2_0=null;
        Token otherlv_3=null;
        AntlrDatatypeRuleToken lv_visibility_0_0 = null;

        EObject lv_type_4_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1406:2: ( ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataType ) ) ) )
            // InternalMuLE.g:1407:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataType ) ) )
            {
            // InternalMuLE.g:1407:2: ( ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataType ) ) )
            // InternalMuLE.g:1408:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )? otherlv_1= 'attribute' ( (lv_name_2_0= RULE_ID ) ) otherlv_3= ':' ( (lv_type_4_0= ruleDataType ) )
            {
            // InternalMuLE.g:1408:3: ( (lv_visibility_0_0= ruleVisibilityModifier ) )?
            int alt30=2;
            int LA30_0 = input.LA(1);

            if ( ((LA30_0>=32 && LA30_0<=33)) ) {
                alt30=1;
            }
            switch (alt30) {
                case 1 :
                    // InternalMuLE.g:1409:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    {
                    // InternalMuLE.g:1409:4: (lv_visibility_0_0= ruleVisibilityModifier )
                    // InternalMuLE.g:1410:5: lv_visibility_0_0= ruleVisibilityModifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getAttributeAccess().getVisibilityVisibilityModifierParserRuleCall_0_0());
                      				
                    }
                    pushFollow(FOLLOW_31);
                    lv_visibility_0_0=ruleVisibilityModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getAttributeRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_0_0,
                      						"de.ubt.ai1.mule.MuLE.VisibilityModifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_1=(Token)match(input,40,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getAttributeAccess().getAttributeKeyword_1());
              		
            }
            // InternalMuLE.g:1431:3: ( (lv_name_2_0= RULE_ID ) )
            // InternalMuLE.g:1432:4: (lv_name_2_0= RULE_ID )
            {
            // InternalMuLE.g:1432:4: (lv_name_2_0= RULE_ID )
            // InternalMuLE.g:1433:5: lv_name_2_0= RULE_ID
            {
            lv_name_2_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_2_0, grammarAccess.getAttributeAccess().getNameIDTerminalRuleCall_2_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getAttributeRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_2_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            otherlv_3=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getAttributeAccess().getColonKeyword_3());
              		
            }
            // InternalMuLE.g:1453:3: ( (lv_type_4_0= ruleDataType ) )
            // InternalMuLE.g:1454:4: (lv_type_4_0= ruleDataType )
            {
            // InternalMuLE.g:1454:4: (lv_type_4_0= ruleDataType )
            // InternalMuLE.g:1455:5: lv_type_4_0= ruleDataType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getAttributeAccess().getTypeDataTypeParserRuleCall_4_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_4_0=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getAttributeRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_4_0,
              						"de.ubt.ai1.mule.MuLE.DataType");
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
    // $ANTLR end "ruleAttribute"


    // $ANTLR start "entryRuleParameter"
    // InternalMuLE.g:1476:1: entryRuleParameter returns [EObject current=null] : iv_ruleParameter= ruleParameter EOF ;
    public final EObject entryRuleParameter() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleParameter = null;


        try {
            // InternalMuLE.g:1476:50: (iv_ruleParameter= ruleParameter EOF )
            // InternalMuLE.g:1477:2: iv_ruleParameter= ruleParameter EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getParameterRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleParameter=ruleParameter();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleParameter; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleParameter"


    // $ANTLR start "ruleParameter"
    // InternalMuLE.g:1483:1: ruleParameter returns [EObject current=null] : (otherlv_0= 'parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) ) ;
    public final EObject ruleParameter() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1489:2: ( (otherlv_0= 'parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) ) )
            // InternalMuLE.g:1490:2: (otherlv_0= 'parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) )
            {
            // InternalMuLE.g:1490:2: (otherlv_0= 'parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) )
            // InternalMuLE.g:1491:3: otherlv_0= 'parameter' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,41,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getParameterAccess().getParameterKeyword_0());
              		
            }
            // InternalMuLE.g:1495:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMuLE.g:1496:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMuLE.g:1496:4: (lv_name_1_0= RULE_ID )
            // InternalMuLE.g:1497:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getParameterAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getParameterRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getParameterAccess().getColonKeyword_2());
              		
            }
            // InternalMuLE.g:1517:3: ( (lv_type_3_0= ruleDataType ) )
            // InternalMuLE.g:1518:4: (lv_type_3_0= ruleDataType )
            {
            // InternalMuLE.g:1518:4: (lv_type_3_0= ruleDataType )
            // InternalMuLE.g:1519:5: lv_type_3_0= ruleDataType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getParameterAccess().getTypeDataTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getParameterRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"de.ubt.ai1.mule.MuLE.DataType");
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
    // $ANTLR end "ruleParameter"


    // $ANTLR start "entryRuleOperation"
    // InternalMuLE.g:1540:1: entryRuleOperation returns [EObject current=null] : iv_ruleOperation= ruleOperation EOF ;
    public final EObject entryRuleOperation() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOperation = null;


        try {
            // InternalMuLE.g:1540:50: (iv_ruleOperation= ruleOperation EOF )
            // InternalMuLE.g:1541:2: iv_ruleOperation= ruleOperation EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOperationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOperation=ruleOperation();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOperation; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOperation"


    // $ANTLR start "ruleOperation"
    // InternalMuLE.g:1547:1: ruleOperation returns [EObject current=null] : ( ( (lv_override_0_0= 'override' ) )? ( (lv_visibility_1_0= ruleVisibilityModifier ) )? ( (lv_abstract_2_0= 'abstract' ) )? otherlv_3= 'operation' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )? otherlv_9= ')' (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )? ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )? ) ;
    public final EObject ruleOperation() throws RecognitionException {
        EObject current = null;

        Token lv_override_0_0=null;
        Token lv_abstract_2_0=null;
        Token otherlv_3=null;
        Token lv_name_4_0=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        AntlrDatatypeRuleToken lv_visibility_1_0 = null;

        EObject lv_params_6_0 = null;

        EObject lv_params_8_0 = null;

        EObject lv_type_11_0 = null;

        EObject lv_block_12_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1553:2: ( ( ( (lv_override_0_0= 'override' ) )? ( (lv_visibility_1_0= ruleVisibilityModifier ) )? ( (lv_abstract_2_0= 'abstract' ) )? otherlv_3= 'operation' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )? otherlv_9= ')' (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )? ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )? ) )
            // InternalMuLE.g:1554:2: ( ( (lv_override_0_0= 'override' ) )? ( (lv_visibility_1_0= ruleVisibilityModifier ) )? ( (lv_abstract_2_0= 'abstract' ) )? otherlv_3= 'operation' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )? otherlv_9= ')' (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )? ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )? )
            {
            // InternalMuLE.g:1554:2: ( ( (lv_override_0_0= 'override' ) )? ( (lv_visibility_1_0= ruleVisibilityModifier ) )? ( (lv_abstract_2_0= 'abstract' ) )? otherlv_3= 'operation' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )? otherlv_9= ')' (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )? ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )? )
            // InternalMuLE.g:1555:3: ( (lv_override_0_0= 'override' ) )? ( (lv_visibility_1_0= ruleVisibilityModifier ) )? ( (lv_abstract_2_0= 'abstract' ) )? otherlv_3= 'operation' ( (lv_name_4_0= RULE_ID ) ) otherlv_5= '(' ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )? otherlv_9= ')' (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )? ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )?
            {
            // InternalMuLE.g:1555:3: ( (lv_override_0_0= 'override' ) )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==42) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMuLE.g:1556:4: (lv_override_0_0= 'override' )
                    {
                    // InternalMuLE.g:1556:4: (lv_override_0_0= 'override' )
                    // InternalMuLE.g:1557:5: lv_override_0_0= 'override'
                    {
                    lv_override_0_0=(Token)match(input,42,FOLLOW_32); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_override_0_0, grammarAccess.getOperationAccess().getOverrideOverrideKeyword_0_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getOperationRule());
                      					}
                      					setWithLastConsumed(current, "override", true, "override");
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMuLE.g:1569:3: ( (lv_visibility_1_0= ruleVisibilityModifier ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( ((LA32_0>=32 && LA32_0<=33)) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMuLE.g:1570:4: (lv_visibility_1_0= ruleVisibilityModifier )
                    {
                    // InternalMuLE.g:1570:4: (lv_visibility_1_0= ruleVisibilityModifier )
                    // InternalMuLE.g:1571:5: lv_visibility_1_0= ruleVisibilityModifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getOperationAccess().getVisibilityVisibilityModifierParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_33);
                    lv_visibility_1_0=ruleVisibilityModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getOperationRule());
                      					}
                      					set(
                      						current,
                      						"visibility",
                      						lv_visibility_1_0,
                      						"de.ubt.ai1.mule.MuLE.VisibilityModifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMuLE.g:1588:3: ( (lv_abstract_2_0= 'abstract' ) )?
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==37) ) {
                alt33=1;
            }
            switch (alt33) {
                case 1 :
                    // InternalMuLE.g:1589:4: (lv_abstract_2_0= 'abstract' )
                    {
                    // InternalMuLE.g:1589:4: (lv_abstract_2_0= 'abstract' )
                    // InternalMuLE.g:1590:5: lv_abstract_2_0= 'abstract'
                    {
                    lv_abstract_2_0=(Token)match(input,37,FOLLOW_34); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(lv_abstract_2_0, grammarAccess.getOperationAccess().getAbstractAbstractKeyword_2_0());
                      				
                    }
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElement(grammarAccess.getOperationRule());
                      					}
                      					setWithLastConsumed(current, "abstract", true, "abstract");
                      				
                    }

                    }


                    }
                    break;

            }

            otherlv_3=(Token)match(input,28,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getOperationAccess().getOperationKeyword_3());
              		
            }
            // InternalMuLE.g:1606:3: ( (lv_name_4_0= RULE_ID ) )
            // InternalMuLE.g:1607:4: (lv_name_4_0= RULE_ID )
            {
            // InternalMuLE.g:1607:4: (lv_name_4_0= RULE_ID )
            // InternalMuLE.g:1608:5: lv_name_4_0= RULE_ID
            {
            lv_name_4_0=(Token)match(input,RULE_ID,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_4_0, grammarAccess.getOperationAccess().getNameIDTerminalRuleCall_4_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getOperationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_4_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            otherlv_5=(Token)match(input,29,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getOperationAccess().getLeftParenthesisKeyword_5());
              		
            }
            // InternalMuLE.g:1628:3: ( ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )* )?
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==41) ) {
                alt35=1;
            }
            switch (alt35) {
                case 1 :
                    // InternalMuLE.g:1629:4: ( (lv_params_6_0= ruleParameter ) ) (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )*
                    {
                    // InternalMuLE.g:1629:4: ( (lv_params_6_0= ruleParameter ) )
                    // InternalMuLE.g:1630:5: (lv_params_6_0= ruleParameter )
                    {
                    // InternalMuLE.g:1630:5: (lv_params_6_0= ruleParameter )
                    // InternalMuLE.g:1631:6: lv_params_6_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_6_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_params_6_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationRule());
                      						}
                      						add(
                      							current,
                      							"params",
                      							lv_params_6_0,
                      							"de.ubt.ai1.mule.MuLE.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:1648:4: (otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) ) )*
                    loop34:
                    do {
                        int alt34=2;
                        int LA34_0 = input.LA(1);

                        if ( (LA34_0==20) ) {
                            alt34=1;
                        }


                        switch (alt34) {
                    	case 1 :
                    	    // InternalMuLE.g:1649:5: otherlv_7= ',' ( (lv_params_8_0= ruleParameter ) )
                    	    {
                    	    otherlv_7=(Token)match(input,20,FOLLOW_36); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_7, grammarAccess.getOperationAccess().getCommaKeyword_6_1_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:1653:5: ( (lv_params_8_0= ruleParameter ) )
                    	    // InternalMuLE.g:1654:6: (lv_params_8_0= ruleParameter )
                    	    {
                    	    // InternalMuLE.g:1654:6: (lv_params_8_0= ruleParameter )
                    	    // InternalMuLE.g:1655:7: lv_params_8_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getOperationAccess().getParamsParameterParserRuleCall_6_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_params_8_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getOperationRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"params",
                    	      								lv_params_8_0,
                    	      								"de.ubt.ai1.mule.MuLE.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop34;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_9=(Token)match(input,30,FOLLOW_37); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getOperationAccess().getRightParenthesisKeyword_7());
              		
            }
            // InternalMuLE.g:1678:3: (otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) ) )?
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==31) ) {
                alt36=1;
            }
            switch (alt36) {
                case 1 :
                    // InternalMuLE.g:1679:4: otherlv_10= ':' ( (lv_type_11_0= ruleDataType ) )
                    {
                    otherlv_10=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getOperationAccess().getColonKeyword_8_0());
                      			
                    }
                    // InternalMuLE.g:1683:4: ( (lv_type_11_0= ruleDataType ) )
                    // InternalMuLE.g:1684:5: (lv_type_11_0= ruleDataType )
                    {
                    // InternalMuLE.g:1684:5: (lv_type_11_0= ruleDataType )
                    // InternalMuLE.g:1685:6: lv_type_11_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationAccess().getTypeDataTypeParserRuleCall_8_1_0());
                      					
                    }
                    pushFollow(FOLLOW_38);
                    lv_type_11_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_11_0,
                      							"de.ubt.ai1.mule.MuLE.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalMuLE.g:1703:3: ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )?
            int alt37=2;
            alt37 = dfa37.predict(input);
            switch (alt37) {
                case 1 :
                    // InternalMuLE.g:1704:4: ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation'
                    {
                    // InternalMuLE.g:1704:4: ( (lv_block_12_0= ruleBlock ) )
                    // InternalMuLE.g:1705:5: (lv_block_12_0= ruleBlock )
                    {
                    // InternalMuLE.g:1705:5: (lv_block_12_0= ruleBlock )
                    // InternalMuLE.g:1706:6: lv_block_12_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getOperationAccess().getBlockBlockParserRuleCall_9_0_0());
                      					
                    }
                    pushFollow(FOLLOW_39);
                    lv_block_12_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getOperationRule());
                      						}
                      						set(
                      							current,
                      							"block",
                      							lv_block_12_0,
                      							"de.ubt.ai1.mule.MuLE.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_13=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getOperationAccess().getEndoperationKeyword_9_1());
                      			
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
    // $ANTLR end "ruleOperation"


    // $ANTLR start "entryRuleBlock"
    // InternalMuLE.g:1732:1: entryRuleBlock returns [EObject current=null] : iv_ruleBlock= ruleBlock EOF ;
    public final EObject entryRuleBlock() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleBlock = null;


        try {
            // InternalMuLE.g:1732:46: (iv_ruleBlock= ruleBlock EOF )
            // InternalMuLE.g:1733:2: iv_ruleBlock= ruleBlock EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getBlockRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleBlock=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleBlock; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleBlock"


    // $ANTLR start "ruleBlock"
    // InternalMuLE.g:1739:1: ruleBlock returns [EObject current=null] : ( () ( (lv_statements_1_0= ruleStatement ) )* ) ;
    public final EObject ruleBlock() throws RecognitionException {
        EObject current = null;

        EObject lv_statements_1_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1745:2: ( ( () ( (lv_statements_1_0= ruleStatement ) )* ) )
            // InternalMuLE.g:1746:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            {
            // InternalMuLE.g:1746:2: ( () ( (lv_statements_1_0= ruleStatement ) )* )
            // InternalMuLE.g:1747:3: () ( (lv_statements_1_0= ruleStatement ) )*
            {
            // InternalMuLE.g:1747:3: ()
            // InternalMuLE.g:1748:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getBlockAccess().getBlockAction_0(),
              					current);
              			
            }

            }

            // InternalMuLE.g:1754:3: ( (lv_statements_1_0= ruleStatement ) )*
            loop38:
            do {
                int alt38=2;
                int LA38_0 = input.LA(1);

                if ( (LA38_0==RULE_ID||(LA38_0>=44 && LA38_0<=46)||LA38_0==48||LA38_0==50||LA38_0==55||LA38_0==78) ) {
                    alt38=1;
                }


                switch (alt38) {
            	case 1 :
            	    // InternalMuLE.g:1755:4: (lv_statements_1_0= ruleStatement )
            	    {
            	    // InternalMuLE.g:1755:4: (lv_statements_1_0= ruleStatement )
            	    // InternalMuLE.g:1756:5: lv_statements_1_0= ruleStatement
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getBlockAccess().getStatementsStatementParserRuleCall_1_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_40);
            	    lv_statements_1_0=ruleStatement();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getBlockRule());
            	      					}
            	      					add(
            	      						current,
            	      						"statements",
            	      						lv_statements_1_0,
            	      						"de.ubt.ai1.mule.MuLE.Statement");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop38;
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
    // $ANTLR end "ruleBlock"


    // $ANTLR start "entryRuleStatement"
    // InternalMuLE.g:1777:1: entryRuleStatement returns [EObject current=null] : iv_ruleStatement= ruleStatement EOF ;
    public final EObject entryRuleStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleStatement = null;


        try {
            // InternalMuLE.g:1777:50: (iv_ruleStatement= ruleStatement EOF )
            // InternalMuLE.g:1778:2: iv_ruleStatement= ruleStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleStatement=ruleStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleStatement"


    // $ANTLR start "ruleStatement"
    // InternalMuLE.g:1784:1: ruleStatement returns [EObject current=null] : (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentOrOperationCall_1= ruleAssignmentOrOperationCall | this_IfStatement_2= ruleIfStatement | this_LoopStatement_3= ruleLoopStatement | this_LetStatement_4= ruleLetStatement | this_ReturnStatement_5= ruleReturnStatement | this_ExitStatement_6= ruleExitStatement ) ;
    public final EObject ruleStatement() throws RecognitionException {
        EObject current = null;

        EObject this_VariableDeclaration_0 = null;

        EObject this_AssignmentOrOperationCall_1 = null;

        EObject this_IfStatement_2 = null;

        EObject this_LoopStatement_3 = null;

        EObject this_LetStatement_4 = null;

        EObject this_ReturnStatement_5 = null;

        EObject this_ExitStatement_6 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1790:2: ( (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentOrOperationCall_1= ruleAssignmentOrOperationCall | this_IfStatement_2= ruleIfStatement | this_LoopStatement_3= ruleLoopStatement | this_LetStatement_4= ruleLetStatement | this_ReturnStatement_5= ruleReturnStatement | this_ExitStatement_6= ruleExitStatement ) )
            // InternalMuLE.g:1791:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentOrOperationCall_1= ruleAssignmentOrOperationCall | this_IfStatement_2= ruleIfStatement | this_LoopStatement_3= ruleLoopStatement | this_LetStatement_4= ruleLetStatement | this_ReturnStatement_5= ruleReturnStatement | this_ExitStatement_6= ruleExitStatement )
            {
            // InternalMuLE.g:1791:2: (this_VariableDeclaration_0= ruleVariableDeclaration | this_AssignmentOrOperationCall_1= ruleAssignmentOrOperationCall | this_IfStatement_2= ruleIfStatement | this_LoopStatement_3= ruleLoopStatement | this_LetStatement_4= ruleLetStatement | this_ReturnStatement_5= ruleReturnStatement | this_ExitStatement_6= ruleExitStatement )
            int alt39=7;
            switch ( input.LA(1) ) {
            case 46:
                {
                alt39=1;
                }
                break;
            case RULE_ID:
            case 78:
                {
                alt39=2;
                }
                break;
            case 50:
                {
                alt39=3;
                }
                break;
            case 48:
                {
                alt39=4;
                }
                break;
            case 55:
                {
                alt39=5;
                }
                break;
            case 44:
                {
                alt39=6;
                }
                break;
            case 45:
                {
                alt39=7;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 39, 0, input);

                throw nvae;
            }

            switch (alt39) {
                case 1 :
                    // InternalMuLE.g:1792:3: this_VariableDeclaration_0= ruleVariableDeclaration
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getVariableDeclarationParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_VariableDeclaration_0=ruleVariableDeclaration();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_VariableDeclaration_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:1801:3: this_AssignmentOrOperationCall_1= ruleAssignmentOrOperationCall
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getAssignmentOrOperationCallParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_AssignmentOrOperationCall_1=ruleAssignmentOrOperationCall();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_AssignmentOrOperationCall_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:1810:3: this_IfStatement_2= ruleIfStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getIfStatementParserRuleCall_2());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_IfStatement_2=ruleIfStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_IfStatement_2;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 4 :
                    // InternalMuLE.g:1819:3: this_LoopStatement_3= ruleLoopStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getLoopStatementParserRuleCall_3());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LoopStatement_3=ruleLoopStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LoopStatement_3;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 5 :
                    // InternalMuLE.g:1828:3: this_LetStatement_4= ruleLetStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getLetStatementParserRuleCall_4());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LetStatement_4=ruleLetStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LetStatement_4;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 6 :
                    // InternalMuLE.g:1837:3: this_ReturnStatement_5= ruleReturnStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getReturnStatementParserRuleCall_5());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ReturnStatement_5=ruleReturnStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ReturnStatement_5;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 7 :
                    // InternalMuLE.g:1846:3: this_ExitStatement_6= ruleExitStatement
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getStatementAccess().getExitStatementParserRuleCall_6());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ExitStatement_6=ruleExitStatement();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ExitStatement_6;
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
    // $ANTLR end "ruleStatement"


    // $ANTLR start "entryRuleReturnStatement"
    // InternalMuLE.g:1858:1: entryRuleReturnStatement returns [EObject current=null] : iv_ruleReturnStatement= ruleReturnStatement EOF ;
    public final EObject entryRuleReturnStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleReturnStatement = null;


        try {
            // InternalMuLE.g:1858:56: (iv_ruleReturnStatement= ruleReturnStatement EOF )
            // InternalMuLE.g:1859:2: iv_ruleReturnStatement= ruleReturnStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getReturnStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleReturnStatement=ruleReturnStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleReturnStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleReturnStatement"


    // $ANTLR start "ruleReturnStatement"
    // InternalMuLE.g:1865:1: ruleReturnStatement returns [EObject current=null] : ( () otherlv_1= 'return' ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )? ) ;
    public final EObject ruleReturnStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1871:2: ( ( () otherlv_1= 'return' ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )? ) )
            // InternalMuLE.g:1872:2: ( () otherlv_1= 'return' ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )? )
            {
            // InternalMuLE.g:1872:2: ( () otherlv_1= 'return' ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )? )
            // InternalMuLE.g:1873:3: () otherlv_1= 'return' ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )?
            {
            // InternalMuLE.g:1873:3: ()
            // InternalMuLE.g:1874:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getReturnStatementAccess().getReturnStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,44,FOLLOW_41); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getReturnStatementAccess().getReturnKeyword_1());
              		
            }
            // InternalMuLE.g:1884:3: ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )?
            int alt40=2;
            alt40 = dfa40.predict(input);
            switch (alt40) {
                case 1 :
                    // InternalMuLE.g:1885:4: ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression )
                    {
                    // InternalMuLE.g:1889:4: (lv_expression_2_0= ruleExpression )
                    // InternalMuLE.g:1890:5: lv_expression_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getReturnStatementAccess().getExpressionExpressionParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getReturnStatementRule());
                      					}
                      					set(
                      						current,
                      						"expression",
                      						lv_expression_2_0,
                      						"de.ubt.ai1.mule.MuLE.Expression");
                      					afterParserOrEnumRuleCall();
                      				
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
    // $ANTLR end "ruleReturnStatement"


    // $ANTLR start "entryRuleExitStatement"
    // InternalMuLE.g:1911:1: entryRuleExitStatement returns [EObject current=null] : iv_ruleExitStatement= ruleExitStatement EOF ;
    public final EObject entryRuleExitStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExitStatement = null;


        try {
            // InternalMuLE.g:1911:54: (iv_ruleExitStatement= ruleExitStatement EOF )
            // InternalMuLE.g:1912:2: iv_ruleExitStatement= ruleExitStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExitStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExitStatement=ruleExitStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExitStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExitStatement"


    // $ANTLR start "ruleExitStatement"
    // InternalMuLE.g:1918:1: ruleExitStatement returns [EObject current=null] : ( () otherlv_1= 'exit' ) ;
    public final EObject ruleExitStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;


        	enterRule();

        try {
            // InternalMuLE.g:1924:2: ( ( () otherlv_1= 'exit' ) )
            // InternalMuLE.g:1925:2: ( () otherlv_1= 'exit' )
            {
            // InternalMuLE.g:1925:2: ( () otherlv_1= 'exit' )
            // InternalMuLE.g:1926:3: () otherlv_1= 'exit'
            {
            // InternalMuLE.g:1926:3: ()
            // InternalMuLE.g:1927:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getExitStatementAccess().getExitStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,45,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getExitStatementAccess().getExitKeyword_1());
              		
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
    // $ANTLR end "ruleExitStatement"


    // $ANTLR start "entryRuleVariableDeclaration"
    // InternalMuLE.g:1941:1: entryRuleVariableDeclaration returns [EObject current=null] : iv_ruleVariableDeclaration= ruleVariableDeclaration EOF ;
    public final EObject entryRuleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleVariableDeclaration = null;


        try {
            // InternalMuLE.g:1941:60: (iv_ruleVariableDeclaration= ruleVariableDeclaration EOF )
            // InternalMuLE.g:1942:2: iv_ruleVariableDeclaration= ruleVariableDeclaration EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getVariableDeclarationRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleVariableDeclaration=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleVariableDeclaration; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleVariableDeclaration"


    // $ANTLR start "ruleVariableDeclaration"
    // InternalMuLE.g:1948:1: ruleVariableDeclaration returns [EObject current=null] : (otherlv_0= 'variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) ) ;
    public final EObject ruleVariableDeclaration() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        EObject lv_type_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:1954:2: ( (otherlv_0= 'variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) ) )
            // InternalMuLE.g:1955:2: (otherlv_0= 'variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) )
            {
            // InternalMuLE.g:1955:2: (otherlv_0= 'variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) ) )
            // InternalMuLE.g:1956:3: otherlv_0= 'variable' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= ':' ( (lv_type_3_0= ruleDataType ) )
            {
            otherlv_0=(Token)match(input,46,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getVariableDeclarationAccess().getVariableKeyword_0());
              		
            }
            // InternalMuLE.g:1960:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMuLE.g:1961:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMuLE.g:1961:4: (lv_name_1_0= RULE_ID )
            // InternalMuLE.g:1962:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_19); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(lv_name_1_0, grammarAccess.getVariableDeclarationAccess().getNameIDTerminalRuleCall_1_0());
              				
            }
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getVariableDeclarationRule());
              					}
              					setWithLastConsumed(
              						current,
              						"name",
              						lv_name_1_0,
              						"de.ubt.ai1.mule.MuLE.ID");
              				
            }

            }


            }

            otherlv_2=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getVariableDeclarationAccess().getColonKeyword_2());
              		
            }
            // InternalMuLE.g:1982:3: ( (lv_type_3_0= ruleDataType ) )
            // InternalMuLE.g:1983:4: (lv_type_3_0= ruleDataType )
            {
            // InternalMuLE.g:1983:4: (lv_type_3_0= ruleDataType )
            // InternalMuLE.g:1984:5: lv_type_3_0= ruleDataType
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getVariableDeclarationAccess().getTypeDataTypeParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_type_3_0=ruleDataType();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getVariableDeclarationRule());
              					}
              					set(
              						current,
              						"type",
              						lv_type_3_0,
              						"de.ubt.ai1.mule.MuLE.DataType");
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
    // $ANTLR end "ruleVariableDeclaration"


    // $ANTLR start "entryRuleAssignmentOrOperationCall"
    // InternalMuLE.g:2005:1: entryRuleAssignmentOrOperationCall returns [EObject current=null] : iv_ruleAssignmentOrOperationCall= ruleAssignmentOrOperationCall EOF ;
    public final EObject entryRuleAssignmentOrOperationCall() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAssignmentOrOperationCall = null;


        try {
            // InternalMuLE.g:2005:66: (iv_ruleAssignmentOrOperationCall= ruleAssignmentOrOperationCall EOF )
            // InternalMuLE.g:2006:2: iv_ruleAssignmentOrOperationCall= ruleAssignmentOrOperationCall EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAssignmentOrOperationCallRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAssignmentOrOperationCall=ruleAssignmentOrOperationCall();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAssignmentOrOperationCall; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAssignmentOrOperationCall"


    // $ANTLR start "ruleAssignmentOrOperationCall"
    // InternalMuLE.g:2012:1: ruleAssignmentOrOperationCall returns [EObject current=null] : ( (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression ) ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )? ) ;
    public final EObject ruleAssignmentOrOperationCall() throws RecognitionException {
        EObject current = null;

        Token otherlv_3=null;
        EObject this_SymbolReference_0 = null;

        EObject this_SuperExpression_1 = null;

        EObject lv_right_4_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2018:2: ( ( (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression ) ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )? ) )
            // InternalMuLE.g:2019:2: ( (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression ) ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )? )
            {
            // InternalMuLE.g:2019:2: ( (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression ) ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )? )
            // InternalMuLE.g:2020:3: (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression ) ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )?
            {
            // InternalMuLE.g:2020:3: (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression )
            int alt41=2;
            int LA41_0 = input.LA(1);

            if ( (LA41_0==RULE_ID) ) {
                alt41=1;
            }
            else if ( (LA41_0==78) ) {
                alt41=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 41, 0, input);

                throw nvae;
            }
            switch (alt41) {
                case 1 :
                    // InternalMuLE.g:2021:4: this_SymbolReference_0= ruleSymbolReference
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignmentOrOperationCallAccess().getSymbolReferenceParserRuleCall_0_0());
                      			
                    }
                    pushFollow(FOLLOW_42);
                    this_SymbolReference_0=ruleSymbolReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_SymbolReference_0;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:2030:4: this_SuperExpression_1= ruleSuperExpression
                    {
                    if ( state.backtracking==0 ) {

                      				newCompositeNode(grammarAccess.getAssignmentOrOperationCallAccess().getSuperExpressionParserRuleCall_0_1());
                      			
                    }
                    pushFollow(FOLLOW_42);
                    this_SuperExpression_1=ruleSuperExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				current = this_SuperExpression_1;
                      				afterParserOrEnumRuleCall();
                      			
                    }

                    }
                    break;

            }

            // InternalMuLE.g:2039:3: ( () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) ) )?
            int alt42=2;
            int LA42_0 = input.LA(1);

            if ( (LA42_0==47) ) {
                alt42=1;
            }
            switch (alt42) {
                case 1 :
                    // InternalMuLE.g:2040:4: () otherlv_3= ':=' ( (lv_right_4_0= ruleExpression ) )
                    {
                    // InternalMuLE.g:2040:4: ()
                    // InternalMuLE.g:2041:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElementAndSet(
                      						grammarAccess.getAssignmentOrOperationCallAccess().getAssignmentOrOperationCallLeftAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_3=(Token)match(input,47,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getAssignmentOrOperationCallAccess().getColonEqualsSignKeyword_1_1());
                      			
                    }
                    // InternalMuLE.g:2051:4: ( (lv_right_4_0= ruleExpression ) )
                    // InternalMuLE.g:2052:5: (lv_right_4_0= ruleExpression )
                    {
                    // InternalMuLE.g:2052:5: (lv_right_4_0= ruleExpression )
                    // InternalMuLE.g:2053:6: lv_right_4_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAssignmentOrOperationCallAccess().getRightExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_right_4_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAssignmentOrOperationCallRule());
                      						}
                      						set(
                      							current,
                      							"right",
                      							lv_right_4_0,
                      							"de.ubt.ai1.mule.MuLE.Expression");
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
    // $ANTLR end "ruleAssignmentOrOperationCall"


    // $ANTLR start "entryRuleLoopStatement"
    // InternalMuLE.g:2075:1: entryRuleLoopStatement returns [EObject current=null] : iv_ruleLoopStatement= ruleLoopStatement EOF ;
    public final EObject entryRuleLoopStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLoopStatement = null;


        try {
            // InternalMuLE.g:2075:54: (iv_ruleLoopStatement= ruleLoopStatement EOF )
            // InternalMuLE.g:2076:2: iv_ruleLoopStatement= ruleLoopStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLoopStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLoopStatement=ruleLoopStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLoopStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLoopStatement"


    // $ANTLR start "ruleLoopStatement"
    // InternalMuLE.g:2082:1: ruleLoopStatement returns [EObject current=null] : ( () otherlv_1= 'loop' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endloop' ) ;
    public final EObject ruleLoopStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        EObject lv_block_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2088:2: ( ( () otherlv_1= 'loop' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endloop' ) )
            // InternalMuLE.g:2089:2: ( () otherlv_1= 'loop' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endloop' )
            {
            // InternalMuLE.g:2089:2: ( () otherlv_1= 'loop' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endloop' )
            // InternalMuLE.g:2090:3: () otherlv_1= 'loop' ( (lv_block_2_0= ruleBlock ) ) otherlv_3= 'endloop'
            {
            // InternalMuLE.g:2090:3: ()
            // InternalMuLE.g:2091:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLoopStatementAccess().getLoopStatementAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,48,FOLLOW_44); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLoopStatementAccess().getLoopKeyword_1());
              		
            }
            // InternalMuLE.g:2101:3: ( (lv_block_2_0= ruleBlock ) )
            // InternalMuLE.g:2102:4: (lv_block_2_0= ruleBlock )
            {
            // InternalMuLE.g:2102:4: (lv_block_2_0= ruleBlock )
            // InternalMuLE.g:2103:5: lv_block_2_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLoopStatementAccess().getBlockBlockParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_45);
            lv_block_2_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLoopStatementRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_2_0,
              						"de.ubt.ai1.mule.MuLE.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_3=(Token)match(input,49,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_3, grammarAccess.getLoopStatementAccess().getEndloopKeyword_3());
              		
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
    // $ANTLR end "ruleLoopStatement"


    // $ANTLR start "entryRuleIfStatement"
    // InternalMuLE.g:2128:1: entryRuleIfStatement returns [EObject current=null] : iv_ruleIfStatement= ruleIfStatement EOF ;
    public final EObject entryRuleIfStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleIfStatement = null;


        try {
            // InternalMuLE.g:2128:52: (iv_ruleIfStatement= ruleIfStatement EOF )
            // InternalMuLE.g:2129:2: iv_ruleIfStatement= ruleIfStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getIfStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleIfStatement=ruleIfStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleIfStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleIfStatement"


    // $ANTLR start "ruleIfStatement"
    // InternalMuLE.g:2135:1: ruleIfStatement returns [EObject current=null] : (otherlv_0= 'if' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ( (lv_elseIfs_4_0= ruleElseIf ) )* ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )? otherlv_7= 'endif' ) ;
    public final EObject ruleIfStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_5=null;
        Token otherlv_7=null;
        EObject lv_expression_1_0 = null;

        EObject lv_block_3_0 = null;

        EObject lv_elseIfs_4_0 = null;

        EObject lv_elseBlock_6_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2141:2: ( (otherlv_0= 'if' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ( (lv_elseIfs_4_0= ruleElseIf ) )* ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )? otherlv_7= 'endif' ) )
            // InternalMuLE.g:2142:2: (otherlv_0= 'if' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ( (lv_elseIfs_4_0= ruleElseIf ) )* ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )? otherlv_7= 'endif' )
            {
            // InternalMuLE.g:2142:2: (otherlv_0= 'if' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ( (lv_elseIfs_4_0= ruleElseIf ) )* ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )? otherlv_7= 'endif' )
            // InternalMuLE.g:2143:3: otherlv_0= 'if' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ( (lv_elseIfs_4_0= ruleElseIf ) )* ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )? otherlv_7= 'endif'
            {
            otherlv_0=(Token)match(input,50,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getIfStatementAccess().getIfKeyword_0());
              		
            }
            // InternalMuLE.g:2147:3: ( (lv_expression_1_0= ruleExpression ) )
            // InternalMuLE.g:2148:4: (lv_expression_1_0= ruleExpression )
            {
            // InternalMuLE.g:2148:4: (lv_expression_1_0= ruleExpression )
            // InternalMuLE.g:2149:5: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getExpressionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_46);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,51,FOLLOW_47); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getIfStatementAccess().getThenKeyword_2());
              		
            }
            // InternalMuLE.g:2170:3: ( (lv_block_3_0= ruleBlock ) )
            // InternalMuLE.g:2171:4: (lv_block_3_0= ruleBlock )
            {
            // InternalMuLE.g:2171:4: (lv_block_3_0= ruleBlock )
            // InternalMuLE.g:2172:5: lv_block_3_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getIfStatementAccess().getBlockBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_48);
            lv_block_3_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getIfStatementRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_3_0,
              						"de.ubt.ai1.mule.MuLE.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMuLE.g:2189:3: ( (lv_elseIfs_4_0= ruleElseIf ) )*
            loop43:
            do {
                int alt43=2;
                int LA43_0 = input.LA(1);

                if ( (LA43_0==54) ) {
                    alt43=1;
                }


                switch (alt43) {
            	case 1 :
            	    // InternalMuLE.g:2190:4: (lv_elseIfs_4_0= ruleElseIf )
            	    {
            	    // InternalMuLE.g:2190:4: (lv_elseIfs_4_0= ruleElseIf )
            	    // InternalMuLE.g:2191:5: lv_elseIfs_4_0= ruleElseIf
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getIfStatementAccess().getElseIfsElseIfParserRuleCall_4_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_48);
            	    lv_elseIfs_4_0=ruleElseIf();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getIfStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elseIfs",
            	      						lv_elseIfs_4_0,
            	      						"de.ubt.ai1.mule.MuLE.ElseIf");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop43;
                }
            } while (true);

            // InternalMuLE.g:2208:3: ( ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) ) )?
            int alt44=2;
            int LA44_0 = input.LA(1);

            if ( (LA44_0==52) && (synpred2_InternalMuLE())) {
                alt44=1;
            }
            switch (alt44) {
                case 1 :
                    // InternalMuLE.g:2209:4: ( ( 'else' )=>otherlv_5= 'else' ) ( (lv_elseBlock_6_0= ruleBlock ) )
                    {
                    // InternalMuLE.g:2209:4: ( ( 'else' )=>otherlv_5= 'else' )
                    // InternalMuLE.g:2210:5: ( 'else' )=>otherlv_5= 'else'
                    {
                    otherlv_5=(Token)match(input,52,FOLLOW_49); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_5, grammarAccess.getIfStatementAccess().getElseKeyword_5_0());
                      				
                    }

                    }

                    // InternalMuLE.g:2216:4: ( (lv_elseBlock_6_0= ruleBlock ) )
                    // InternalMuLE.g:2217:5: (lv_elseBlock_6_0= ruleBlock )
                    {
                    // InternalMuLE.g:2217:5: (lv_elseBlock_6_0= ruleBlock )
                    // InternalMuLE.g:2218:6: lv_elseBlock_6_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getIfStatementAccess().getElseBlockBlockParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_50);
                    lv_elseBlock_6_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getIfStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_6_0,
                      							"de.ubt.ai1.mule.MuLE.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_7=(Token)match(input,53,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_7, grammarAccess.getIfStatementAccess().getEndifKeyword_6());
              		
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
    // $ANTLR end "ruleIfStatement"


    // $ANTLR start "entryRuleElseIf"
    // InternalMuLE.g:2244:1: entryRuleElseIf returns [EObject current=null] : iv_ruleElseIf= ruleElseIf EOF ;
    public final EObject entryRuleElseIf() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseIf = null;


        try {
            // InternalMuLE.g:2244:47: (iv_ruleElseIf= ruleElseIf EOF )
            // InternalMuLE.g:2245:2: iv_ruleElseIf= ruleElseIf EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseIfRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElseIf=ruleElseIf();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseIf; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleElseIf"


    // $ANTLR start "ruleElseIf"
    // InternalMuLE.g:2251:1: ruleElseIf returns [EObject current=null] : (otherlv_0= 'elseif' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ) ;
    public final EObject ruleElseIf() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        EObject lv_expression_1_0 = null;

        EObject lv_block_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2257:2: ( (otherlv_0= 'elseif' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) ) )
            // InternalMuLE.g:2258:2: (otherlv_0= 'elseif' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) )
            {
            // InternalMuLE.g:2258:2: (otherlv_0= 'elseif' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) ) )
            // InternalMuLE.g:2259:3: otherlv_0= 'elseif' ( (lv_expression_1_0= ruleExpression ) ) otherlv_2= 'then' ( (lv_block_3_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,54,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getElseIfAccess().getElseifKeyword_0());
              		
            }
            // InternalMuLE.g:2263:3: ( (lv_expression_1_0= ruleExpression ) )
            // InternalMuLE.g:2264:4: (lv_expression_1_0= ruleExpression )
            {
            // InternalMuLE.g:2264:4: (lv_expression_1_0= ruleExpression )
            // InternalMuLE.g:2265:5: lv_expression_1_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfAccess().getExpressionExpressionParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_46);
            lv_expression_1_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_1_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,51,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getElseIfAccess().getThenKeyword_2());
              		
            }
            // InternalMuLE.g:2286:3: ( (lv_block_3_0= ruleBlock ) )
            // InternalMuLE.g:2287:4: (lv_block_3_0= ruleBlock )
            {
            // InternalMuLE.g:2287:4: (lv_block_3_0= ruleBlock )
            // InternalMuLE.g:2288:5: lv_block_3_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseIfAccess().getBlockBlockParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_3_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseIfRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_3_0,
              						"de.ubt.ai1.mule.MuLE.Block");
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
    // $ANTLR end "ruleElseIf"


    // $ANTLR start "entryRuleLetStatement"
    // InternalMuLE.g:2309:1: entryRuleLetStatement returns [EObject current=null] : iv_ruleLetStatement= ruleLetStatement EOF ;
    public final EObject entryRuleLetStatement() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLetStatement = null;


        try {
            // InternalMuLE.g:2309:53: (iv_ruleLetStatement= ruleLetStatement EOF )
            // InternalMuLE.g:2310:2: iv_ruleLetStatement= ruleLetStatement EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLetStatementRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLetStatement=ruleLetStatement();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLetStatement; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLetStatement"


    // $ANTLR start "ruleLetStatement"
    // InternalMuLE.g:2316:1: ruleLetStatement returns [EObject current=null] : (otherlv_0= 'let' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ( (lv_elseLets_6_0= ruleElseLet ) )* ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )? otherlv_9= 'endlet' ) ;
    public final EObject ruleLetStatement() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_7=null;
        Token otherlv_9=null;
        EObject lv_variable_1_0 = null;

        EObject lv_expression_3_0 = null;

        EObject lv_block_5_0 = null;

        EObject lv_elseLets_6_0 = null;

        EObject lv_elseBlock_8_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2322:2: ( (otherlv_0= 'let' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ( (lv_elseLets_6_0= ruleElseLet ) )* ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )? otherlv_9= 'endlet' ) )
            // InternalMuLE.g:2323:2: (otherlv_0= 'let' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ( (lv_elseLets_6_0= ruleElseLet ) )* ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )? otherlv_9= 'endlet' )
            {
            // InternalMuLE.g:2323:2: (otherlv_0= 'let' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ( (lv_elseLets_6_0= ruleElseLet ) )* ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )? otherlv_9= 'endlet' )
            // InternalMuLE.g:2324:3: otherlv_0= 'let' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ( (lv_elseLets_6_0= ruleElseLet ) )* ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )? otherlv_9= 'endlet'
            {
            otherlv_0=(Token)match(input,55,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getLetStatementAccess().getLetKeyword_0());
              		
            }
            // InternalMuLE.g:2328:3: ( (lv_variable_1_0= ruleVariableDeclaration ) )
            // InternalMuLE.g:2329:4: (lv_variable_1_0= ruleVariableDeclaration )
            {
            // InternalMuLE.g:2329:4: (lv_variable_1_0= ruleVariableDeclaration )
            // InternalMuLE.g:2330:5: lv_variable_1_0= ruleVariableDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetStatementAccess().getVariableVariableDeclarationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_53);
            lv_variable_1_0=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetStatementRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_1_0,
              						"de.ubt.ai1.mule.MuLE.VariableDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,56,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLetStatementAccess().getBeKeyword_2());
              		
            }
            // InternalMuLE.g:2351:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalMuLE.g:2352:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalMuLE.g:2352:4: (lv_expression_3_0= ruleExpression )
            // InternalMuLE.g:2353:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetStatementAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetStatementRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,57,FOLLOW_55); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getLetStatementAccess().getDoKeyword_4());
              		
            }
            // InternalMuLE.g:2374:3: ( (lv_block_5_0= ruleBlock ) )
            // InternalMuLE.g:2375:4: (lv_block_5_0= ruleBlock )
            {
            // InternalMuLE.g:2375:4: (lv_block_5_0= ruleBlock )
            // InternalMuLE.g:2376:5: lv_block_5_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLetStatementAccess().getBlockBlockParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_56);
            lv_block_5_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLetStatementRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_5_0,
              						"de.ubt.ai1.mule.MuLE.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            // InternalMuLE.g:2393:3: ( (lv_elseLets_6_0= ruleElseLet ) )*
            loop45:
            do {
                int alt45=2;
                int LA45_0 = input.LA(1);

                if ( (LA45_0==59) ) {
                    alt45=1;
                }


                switch (alt45) {
            	case 1 :
            	    // InternalMuLE.g:2394:4: (lv_elseLets_6_0= ruleElseLet )
            	    {
            	    // InternalMuLE.g:2394:4: (lv_elseLets_6_0= ruleElseLet )
            	    // InternalMuLE.g:2395:5: lv_elseLets_6_0= ruleElseLet
            	    {
            	    if ( state.backtracking==0 ) {

            	      					newCompositeNode(grammarAccess.getLetStatementAccess().getElseLetsElseLetParserRuleCall_6_0());
            	      				
            	    }
            	    pushFollow(FOLLOW_56);
            	    lv_elseLets_6_0=ruleElseLet();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      					if (current==null) {
            	      						current = createModelElementForParent(grammarAccess.getLetStatementRule());
            	      					}
            	      					add(
            	      						current,
            	      						"elseLets",
            	      						lv_elseLets_6_0,
            	      						"de.ubt.ai1.mule.MuLE.ElseLet");
            	      					afterParserOrEnumRuleCall();
            	      				
            	    }

            	    }


            	    }
            	    break;

            	default :
            	    break loop45;
                }
            } while (true);

            // InternalMuLE.g:2412:3: ( ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) ) )?
            int alt46=2;
            int LA46_0 = input.LA(1);

            if ( (LA46_0==52) && (synpred3_InternalMuLE())) {
                alt46=1;
            }
            switch (alt46) {
                case 1 :
                    // InternalMuLE.g:2413:4: ( ( 'else' )=>otherlv_7= 'else' ) ( (lv_elseBlock_8_0= ruleBlock ) )
                    {
                    // InternalMuLE.g:2413:4: ( ( 'else' )=>otherlv_7= 'else' )
                    // InternalMuLE.g:2414:5: ( 'else' )=>otherlv_7= 'else'
                    {
                    otherlv_7=(Token)match(input,52,FOLLOW_57); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					newLeafNode(otherlv_7, grammarAccess.getLetStatementAccess().getElseKeyword_7_0());
                      				
                    }

                    }

                    // InternalMuLE.g:2420:4: ( (lv_elseBlock_8_0= ruleBlock ) )
                    // InternalMuLE.g:2421:5: (lv_elseBlock_8_0= ruleBlock )
                    {
                    // InternalMuLE.g:2421:5: (lv_elseBlock_8_0= ruleBlock )
                    // InternalMuLE.g:2422:6: lv_elseBlock_8_0= ruleBlock
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLetStatementAccess().getElseBlockBlockParserRuleCall_7_1_0());
                      					
                    }
                    pushFollow(FOLLOW_58);
                    lv_elseBlock_8_0=ruleBlock();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLetStatementRule());
                      						}
                      						set(
                      							current,
                      							"elseBlock",
                      							lv_elseBlock_8_0,
                      							"de.ubt.ai1.mule.MuLE.Block");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            otherlv_9=(Token)match(input,58,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_9, grammarAccess.getLetStatementAccess().getEndletKeyword_8());
              		
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
    // $ANTLR end "ruleLetStatement"


    // $ANTLR start "entryRuleElseLet"
    // InternalMuLE.g:2448:1: entryRuleElseLet returns [EObject current=null] : iv_ruleElseLet= ruleElseLet EOF ;
    public final EObject entryRuleElseLet() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleElseLet = null;


        try {
            // InternalMuLE.g:2448:48: (iv_ruleElseLet= ruleElseLet EOF )
            // InternalMuLE.g:2449:2: iv_ruleElseLet= ruleElseLet EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getElseLetRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleElseLet=ruleElseLet();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleElseLet; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleElseLet"


    // $ANTLR start "ruleElseLet"
    // InternalMuLE.g:2455:1: ruleElseLet returns [EObject current=null] : (otherlv_0= 'elselet' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ) ;
    public final EObject ruleElseLet() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        EObject lv_variable_1_0 = null;

        EObject lv_expression_3_0 = null;

        EObject lv_block_5_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2461:2: ( (otherlv_0= 'elselet' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) ) )
            // InternalMuLE.g:2462:2: (otherlv_0= 'elselet' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) )
            {
            // InternalMuLE.g:2462:2: (otherlv_0= 'elselet' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) ) )
            // InternalMuLE.g:2463:3: otherlv_0= 'elselet' ( (lv_variable_1_0= ruleVariableDeclaration ) ) otherlv_2= 'be' ( (lv_expression_3_0= ruleExpression ) ) otherlv_4= 'do' ( (lv_block_5_0= ruleBlock ) )
            {
            otherlv_0=(Token)match(input,59,FOLLOW_52); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_0, grammarAccess.getElseLetAccess().getElseletKeyword_0());
              		
            }
            // InternalMuLE.g:2467:3: ( (lv_variable_1_0= ruleVariableDeclaration ) )
            // InternalMuLE.g:2468:4: (lv_variable_1_0= ruleVariableDeclaration )
            {
            // InternalMuLE.g:2468:4: (lv_variable_1_0= ruleVariableDeclaration )
            // InternalMuLE.g:2469:5: lv_variable_1_0= ruleVariableDeclaration
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseLetAccess().getVariableVariableDeclarationParserRuleCall_1_0());
              				
            }
            pushFollow(FOLLOW_53);
            lv_variable_1_0=ruleVariableDeclaration();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseLetRule());
              					}
              					set(
              						current,
              						"variable",
              						lv_variable_1_0,
              						"de.ubt.ai1.mule.MuLE.VariableDeclaration");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_2=(Token)match(input,56,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getElseLetAccess().getBeKeyword_2());
              		
            }
            // InternalMuLE.g:2490:3: ( (lv_expression_3_0= ruleExpression ) )
            // InternalMuLE.g:2491:4: (lv_expression_3_0= ruleExpression )
            {
            // InternalMuLE.g:2491:4: (lv_expression_3_0= ruleExpression )
            // InternalMuLE.g:2492:5: lv_expression_3_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseLetAccess().getExpressionExpressionParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_54);
            lv_expression_3_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseLetRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_3_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_4=(Token)match(input,57,FOLLOW_51); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getElseLetAccess().getDoKeyword_4());
              		
            }
            // InternalMuLE.g:2513:3: ( (lv_block_5_0= ruleBlock ) )
            // InternalMuLE.g:2514:4: (lv_block_5_0= ruleBlock )
            {
            // InternalMuLE.g:2514:4: (lv_block_5_0= ruleBlock )
            // InternalMuLE.g:2515:5: lv_block_5_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getElseLetAccess().getBlockBlockParserRuleCall_5_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_block_5_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getElseLetRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_5_0,
              						"de.ubt.ai1.mule.MuLE.Block");
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
    // $ANTLR end "ruleElseLet"


    // $ANTLR start "entryRuleExpression"
    // InternalMuLE.g:2536:1: entryRuleExpression returns [EObject current=null] : iv_ruleExpression= ruleExpression EOF ;
    public final EObject entryRuleExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExpression = null;


        try {
            // InternalMuLE.g:2536:51: (iv_ruleExpression= ruleExpression EOF )
            // InternalMuLE.g:2537:2: iv_ruleExpression= ruleExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExpression=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExpression"


    // $ANTLR start "ruleExpression"
    // InternalMuLE.g:2543:1: ruleExpression returns [EObject current=null] : this_OrExpression_0= ruleOrExpression ;
    public final EObject ruleExpression() throws RecognitionException {
        EObject current = null;

        EObject this_OrExpression_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2549:2: (this_OrExpression_0= ruleOrExpression )
            // InternalMuLE.g:2550:2: this_OrExpression_0= ruleOrExpression
            {
            if ( state.backtracking==0 ) {

              		newCompositeNode(grammarAccess.getExpressionAccess().getOrExpressionParserRuleCall());
              	
            }
            pushFollow(FOLLOW_2);
            this_OrExpression_0=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              		current = this_OrExpression_0;
              		afterParserOrEnumRuleCall();
              	
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
    // $ANTLR end "ruleExpression"


    // $ANTLR start "entryRuleOrExpression"
    // InternalMuLE.g:2561:1: entryRuleOrExpression returns [EObject current=null] : iv_ruleOrExpression= ruleOrExpression EOF ;
    public final EObject entryRuleOrExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleOrExpression = null;


        try {
            // InternalMuLE.g:2561:53: (iv_ruleOrExpression= ruleOrExpression EOF )
            // InternalMuLE.g:2562:2: iv_ruleOrExpression= ruleOrExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getOrExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleOrExpression=ruleOrExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleOrExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleOrExpression"


    // $ANTLR start "ruleOrExpression"
    // InternalMuLE.g:2568:1: ruleOrExpression returns [EObject current=null] : (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) ;
    public final EObject ruleOrExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AndExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2574:2: ( (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* ) )
            // InternalMuLE.g:2575:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            {
            // InternalMuLE.g:2575:2: (this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )* )
            // InternalMuLE.g:2576:3: this_AndExpression_0= ruleAndExpression ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getOrExpressionAccess().getAndExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_59);
            this_AndExpression_0=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AndExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:2584:3: ( () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) ) )*
            loop47:
            do {
                int alt47=2;
                int LA47_0 = input.LA(1);

                if ( (LA47_0==60) ) {
                    alt47=1;
                }


                switch (alt47) {
            	case 1 :
            	    // InternalMuLE.g:2585:4: () ( (lv_op_2_0= 'or' ) ) ( (lv_right_3_0= ruleAndExpression ) )
            	    {
            	    // InternalMuLE.g:2585:4: ()
            	    // InternalMuLE.g:2586:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getOrExpressionAccess().getOrExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:2592:4: ( (lv_op_2_0= 'or' ) )
            	    // InternalMuLE.g:2593:5: (lv_op_2_0= 'or' )
            	    {
            	    // InternalMuLE.g:2593:5: (lv_op_2_0= 'or' )
            	    // InternalMuLE.g:2594:6: lv_op_2_0= 'or'
            	    {
            	    lv_op_2_0=(Token)match(input,60,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getOrExpressionAccess().getOpOrKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getOrExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "or");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMuLE.g:2606:4: ( (lv_right_3_0= ruleAndExpression ) )
            	    // InternalMuLE.g:2607:5: (lv_right_3_0= ruleAndExpression )
            	    {
            	    // InternalMuLE.g:2607:5: (lv_right_3_0= ruleAndExpression )
            	    // InternalMuLE.g:2608:6: lv_right_3_0= ruleAndExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getOrExpressionAccess().getRightAndExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_59);
            	    lv_right_3_0=ruleAndExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getOrExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.AndExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop47;
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
    // $ANTLR end "ruleOrExpression"


    // $ANTLR start "entryRuleAndExpression"
    // InternalMuLE.g:2630:1: entryRuleAndExpression returns [EObject current=null] : iv_ruleAndExpression= ruleAndExpression EOF ;
    public final EObject entryRuleAndExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAndExpression = null;


        try {
            // InternalMuLE.g:2630:54: (iv_ruleAndExpression= ruleAndExpression EOF )
            // InternalMuLE.g:2631:2: iv_ruleAndExpression= ruleAndExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAndExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAndExpression=ruleAndExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAndExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAndExpression"


    // $ANTLR start "ruleAndExpression"
    // InternalMuLE.g:2637:1: ruleAndExpression returns [EObject current=null] : (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) ;
    public final EObject ruleAndExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_EqualityExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2643:2: ( (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* ) )
            // InternalMuLE.g:2644:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            {
            // InternalMuLE.g:2644:2: (this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )* )
            // InternalMuLE.g:2645:3: this_EqualityExpression_0= ruleEqualityExpression ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAndExpressionAccess().getEqualityExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_60);
            this_EqualityExpression_0=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_EqualityExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:2653:3: ( () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) ) )*
            loop48:
            do {
                int alt48=2;
                int LA48_0 = input.LA(1);

                if ( (LA48_0==61) ) {
                    alt48=1;
                }


                switch (alt48) {
            	case 1 :
            	    // InternalMuLE.g:2654:4: () ( (lv_op_2_0= 'and' ) ) ( (lv_right_3_0= ruleEqualityExpression ) )
            	    {
            	    // InternalMuLE.g:2654:4: ()
            	    // InternalMuLE.g:2655:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAndExpressionAccess().getAndExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:2661:4: ( (lv_op_2_0= 'and' ) )
            	    // InternalMuLE.g:2662:5: (lv_op_2_0= 'and' )
            	    {
            	    // InternalMuLE.g:2662:5: (lv_op_2_0= 'and' )
            	    // InternalMuLE.g:2663:6: lv_op_2_0= 'and'
            	    {
            	    lv_op_2_0=(Token)match(input,61,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getAndExpressionAccess().getOpAndKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getAndExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "and");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMuLE.g:2675:4: ( (lv_right_3_0= ruleEqualityExpression ) )
            	    // InternalMuLE.g:2676:5: (lv_right_3_0= ruleEqualityExpression )
            	    {
            	    // InternalMuLE.g:2676:5: (lv_right_3_0= ruleEqualityExpression )
            	    // InternalMuLE.g:2677:6: lv_right_3_0= ruleEqualityExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAndExpressionAccess().getRightEqualityExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_60);
            	    lv_right_3_0=ruleEqualityExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAndExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.EqualityExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop48;
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
    // $ANTLR end "ruleAndExpression"


    // $ANTLR start "entryRuleEqualityExpression"
    // InternalMuLE.g:2699:1: entryRuleEqualityExpression returns [EObject current=null] : iv_ruleEqualityExpression= ruleEqualityExpression EOF ;
    public final EObject entryRuleEqualityExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEqualityExpression = null;


        try {
            // InternalMuLE.g:2699:59: (iv_ruleEqualityExpression= ruleEqualityExpression EOF )
            // InternalMuLE.g:2700:2: iv_ruleEqualityExpression= ruleEqualityExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getEqualityExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleEqualityExpression=ruleEqualityExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleEqualityExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleEqualityExpression"


    // $ANTLR start "ruleEqualityExpression"
    // InternalMuLE.g:2706:1: ruleEqualityExpression returns [EObject current=null] : (this_ComparisonExpression_0= ruleComparisonExpression ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )* ) ;
    public final EObject ruleEqualityExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        EObject this_ComparisonExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2712:2: ( (this_ComparisonExpression_0= ruleComparisonExpression ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )* ) )
            // InternalMuLE.g:2713:2: (this_ComparisonExpression_0= ruleComparisonExpression ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )* )
            {
            // InternalMuLE.g:2713:2: (this_ComparisonExpression_0= ruleComparisonExpression ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )* )
            // InternalMuLE.g:2714:3: this_ComparisonExpression_0= ruleComparisonExpression ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getEqualityExpressionAccess().getComparisonExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_61);
            this_ComparisonExpression_0=ruleComparisonExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ComparisonExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:2722:3: ( () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) ) )*
            loop50:
            do {
                int alt50=2;
                int LA50_0 = input.LA(1);

                if ( ((LA50_0>=62 && LA50_0<=63)) ) {
                    alt50=1;
                }


                switch (alt50) {
            	case 1 :
            	    // InternalMuLE.g:2723:4: () ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) ) ( (lv_right_3_0= ruleComparisonExpression ) )
            	    {
            	    // InternalMuLE.g:2723:4: ()
            	    // InternalMuLE.g:2724:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getEqualityExpressionAccess().getEqualityExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:2730:4: ( ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) ) )
            	    // InternalMuLE.g:2731:5: ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) )
            	    {
            	    // InternalMuLE.g:2731:5: ( (lv_op_2_1= '=' | lv_op_2_2= '/=' ) )
            	    // InternalMuLE.g:2732:6: (lv_op_2_1= '=' | lv_op_2_2= '/=' )
            	    {
            	    // InternalMuLE.g:2732:6: (lv_op_2_1= '=' | lv_op_2_2= '/=' )
            	    int alt49=2;
            	    int LA49_0 = input.LA(1);

            	    if ( (LA49_0==62) ) {
            	        alt49=1;
            	    }
            	    else if ( (LA49_0==63) ) {
            	        alt49=2;
            	    }
            	    else {
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 49, 0, input);

            	        throw nvae;
            	    }
            	    switch (alt49) {
            	        case 1 :
            	            // InternalMuLE.g:2733:7: lv_op_2_1= '='
            	            {
            	            lv_op_2_1=(Token)match(input,62,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getEqualityExpressionAccess().getOpEqualsSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMuLE.g:2744:7: lv_op_2_2= '/='
            	            {
            	            lv_op_2_2=(Token)match(input,63,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getEqualityExpressionAccess().getOpSolidusEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getEqualityExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMuLE.g:2757:4: ( (lv_right_3_0= ruleComparisonExpression ) )
            	    // InternalMuLE.g:2758:5: (lv_right_3_0= ruleComparisonExpression )
            	    {
            	    // InternalMuLE.g:2758:5: (lv_right_3_0= ruleComparisonExpression )
            	    // InternalMuLE.g:2759:6: lv_right_3_0= ruleComparisonExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getEqualityExpressionAccess().getRightComparisonExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_61);
            	    lv_right_3_0=ruleComparisonExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getEqualityExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.ComparisonExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop50;
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
    // $ANTLR end "ruleEqualityExpression"


    // $ANTLR start "entryRuleComparisonExpression"
    // InternalMuLE.g:2781:1: entryRuleComparisonExpression returns [EObject current=null] : iv_ruleComparisonExpression= ruleComparisonExpression EOF ;
    public final EObject entryRuleComparisonExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleComparisonExpression = null;


        try {
            // InternalMuLE.g:2781:61: (iv_ruleComparisonExpression= ruleComparisonExpression EOF )
            // InternalMuLE.g:2782:2: iv_ruleComparisonExpression= ruleComparisonExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getComparisonExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleComparisonExpression=ruleComparisonExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleComparisonExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleComparisonExpression"


    // $ANTLR start "ruleComparisonExpression"
    // InternalMuLE.g:2788:1: ruleComparisonExpression returns [EObject current=null] : (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) ;
    public final EObject ruleComparisonExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_AdditiveExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2794:2: ( (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* ) )
            // InternalMuLE.g:2795:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            {
            // InternalMuLE.g:2795:2: (this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )* )
            // InternalMuLE.g:2796:3: this_AdditiveExpression_0= ruleAdditiveExpression ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getComparisonExpressionAccess().getAdditiveExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_62);
            this_AdditiveExpression_0=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AdditiveExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:2804:3: ( () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) ) )*
            loop52:
            do {
                int alt52=2;
                int LA52_0 = input.LA(1);

                if ( (LA52_0==19||LA52_0==21||(LA52_0>=64 && LA52_0<=65)) ) {
                    alt52=1;
                }


                switch (alt52) {
            	case 1 :
            	    // InternalMuLE.g:2805:4: () ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) ) ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    {
            	    // InternalMuLE.g:2805:4: ()
            	    // InternalMuLE.g:2806:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getComparisonExpressionAccess().getComparisonExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:2812:4: ( ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) ) )
            	    // InternalMuLE.g:2813:5: ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) )
            	    {
            	    // InternalMuLE.g:2813:5: ( (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' ) )
            	    // InternalMuLE.g:2814:6: (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' )
            	    {
            	    // InternalMuLE.g:2814:6: (lv_op_2_1= '<' | lv_op_2_2= '<=' | lv_op_2_3= '>' | lv_op_2_4= '>=' )
            	    int alt51=4;
            	    switch ( input.LA(1) ) {
            	    case 19:
            	        {
            	        alt51=1;
            	        }
            	        break;
            	    case 64:
            	        {
            	        alt51=2;
            	        }
            	        break;
            	    case 21:
            	        {
            	        alt51=3;
            	        }
            	        break;
            	    case 65:
            	        {
            	        alt51=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 51, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt51) {
            	        case 1 :
            	            // InternalMuLE.g:2815:7: lv_op_2_1= '<'
            	            {
            	            lv_op_2_1=(Token)match(input,19,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getComparisonExpressionAccess().getOpLessThanSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMuLE.g:2826:7: lv_op_2_2= '<='
            	            {
            	            lv_op_2_2=(Token)match(input,64,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getComparisonExpressionAccess().getOpLessThanSignEqualsSignKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalMuLE.g:2837:7: lv_op_2_3= '>'
            	            {
            	            lv_op_2_3=(Token)match(input,21,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalMuLE.g:2848:7: lv_op_2_4= '>='
            	            {
            	            lv_op_2_4=(Token)match(input,65,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getComparisonExpressionAccess().getOpGreaterThanSignEqualsSignKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getComparisonExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMuLE.g:2861:4: ( (lv_right_3_0= ruleAdditiveExpression ) )
            	    // InternalMuLE.g:2862:5: (lv_right_3_0= ruleAdditiveExpression )
            	    {
            	    // InternalMuLE.g:2862:5: (lv_right_3_0= ruleAdditiveExpression )
            	    // InternalMuLE.g:2863:6: lv_right_3_0= ruleAdditiveExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getComparisonExpressionAccess().getRightAdditiveExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_62);
            	    lv_right_3_0=ruleAdditiveExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getComparisonExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.AdditiveExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop52;
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
    // $ANTLR end "ruleComparisonExpression"


    // $ANTLR start "entryRuleAdditiveExpression"
    // InternalMuLE.g:2885:1: entryRuleAdditiveExpression returns [EObject current=null] : iv_ruleAdditiveExpression= ruleAdditiveExpression EOF ;
    public final EObject entryRuleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAdditiveExpression = null;


        try {
            // InternalMuLE.g:2885:59: (iv_ruleAdditiveExpression= ruleAdditiveExpression EOF )
            // InternalMuLE.g:2886:2: iv_ruleAdditiveExpression= ruleAdditiveExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAdditiveExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAdditiveExpression=ruleAdditiveExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAdditiveExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAdditiveExpression"


    // $ANTLR start "ruleAdditiveExpression"
    // InternalMuLE.g:2892:1: ruleAdditiveExpression returns [EObject current=null] : (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) ;
    public final EObject ruleAdditiveExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        EObject this_MultiplicativeExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2898:2: ( (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* ) )
            // InternalMuLE.g:2899:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            {
            // InternalMuLE.g:2899:2: (this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )* )
            // InternalMuLE.g:2900:3: this_MultiplicativeExpression_0= ruleMultiplicativeExpression ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getMultiplicativeExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_63);
            this_MultiplicativeExpression_0=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_MultiplicativeExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:2908:3: ( () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) ) )*
            loop54:
            do {
                int alt54=2;
                int LA54_0 = input.LA(1);

                if ( ((LA54_0>=66 && LA54_0<=68)) ) {
                    alt54=1;
                }


                switch (alt54) {
            	case 1 :
            	    // InternalMuLE.g:2909:4: () ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) ) ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    {
            	    // InternalMuLE.g:2909:4: ()
            	    // InternalMuLE.g:2910:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getAdditiveExpressionAccess().getAdditiveExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:2916:4: ( ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) ) )
            	    // InternalMuLE.g:2917:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) )
            	    {
            	    // InternalMuLE.g:2917:5: ( (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' ) )
            	    // InternalMuLE.g:2918:6: (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' )
            	    {
            	    // InternalMuLE.g:2918:6: (lv_op_2_1= '+' | lv_op_2_2= '-' | lv_op_2_3= '&' )
            	    int alt53=3;
            	    switch ( input.LA(1) ) {
            	    case 66:
            	        {
            	        alt53=1;
            	        }
            	        break;
            	    case 67:
            	        {
            	        alt53=2;
            	        }
            	        break;
            	    case 68:
            	        {
            	        alt53=3;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 53, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt53) {
            	        case 1 :
            	            // InternalMuLE.g:2919:7: lv_op_2_1= '+'
            	            {
            	            lv_op_2_1=(Token)match(input,66,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getAdditiveExpressionAccess().getOpPlusSignKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMuLE.g:2930:7: lv_op_2_2= '-'
            	            {
            	            lv_op_2_2=(Token)match(input,67,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getAdditiveExpressionAccess().getOpHyphenMinusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalMuLE.g:2941:7: lv_op_2_3= '&'
            	            {
            	            lv_op_2_3=(Token)match(input,68,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getAdditiveExpressionAccess().getOpAmpersandKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getAdditiveExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMuLE.g:2954:4: ( (lv_right_3_0= ruleMultiplicativeExpression ) )
            	    // InternalMuLE.g:2955:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    {
            	    // InternalMuLE.g:2955:5: (lv_right_3_0= ruleMultiplicativeExpression )
            	    // InternalMuLE.g:2956:6: lv_right_3_0= ruleMultiplicativeExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getAdditiveExpressionAccess().getRightMultiplicativeExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_63);
            	    lv_right_3_0=ruleMultiplicativeExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getAdditiveExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.MultiplicativeExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop54;
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
    // $ANTLR end "ruleAdditiveExpression"


    // $ANTLR start "entryRuleMultiplicativeExpression"
    // InternalMuLE.g:2978:1: entryRuleMultiplicativeExpression returns [EObject current=null] : iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF ;
    public final EObject entryRuleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMultiplicativeExpression = null;


        try {
            // InternalMuLE.g:2978:65: (iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF )
            // InternalMuLE.g:2979:2: iv_ruleMultiplicativeExpression= ruleMultiplicativeExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getMultiplicativeExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleMultiplicativeExpression=ruleMultiplicativeExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleMultiplicativeExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleMultiplicativeExpression"


    // $ANTLR start "ruleMultiplicativeExpression"
    // InternalMuLE.g:2985:1: ruleMultiplicativeExpression returns [EObject current=null] : (this_ExponentExpression_0= ruleExponentExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )* ) ;
    public final EObject ruleMultiplicativeExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_1=null;
        Token lv_op_2_2=null;
        Token lv_op_2_3=null;
        Token lv_op_2_4=null;
        EObject this_ExponentExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:2991:2: ( (this_ExponentExpression_0= ruleExponentExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )* ) )
            // InternalMuLE.g:2992:2: (this_ExponentExpression_0= ruleExponentExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )* )
            {
            // InternalMuLE.g:2992:2: (this_ExponentExpression_0= ruleExponentExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )* )
            // InternalMuLE.g:2993:3: this_ExponentExpression_0= ruleExponentExpression ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getExponentExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_64);
            this_ExponentExpression_0=ruleExponentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_ExponentExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:3001:3: ( () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) ) )*
            loop56:
            do {
                int alt56=2;
                int LA56_0 = input.LA(1);

                if ( ((LA56_0>=69 && LA56_0<=72)) ) {
                    alt56=1;
                }


                switch (alt56) {
            	case 1 :
            	    // InternalMuLE.g:3002:4: () ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) ) ( (lv_right_3_0= ruleExponentExpression ) )
            	    {
            	    // InternalMuLE.g:3002:4: ()
            	    // InternalMuLE.g:3003:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getMultiplicativeExpressionAccess().getMultiplicativeExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:3009:4: ( ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) ) )
            	    // InternalMuLE.g:3010:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) )
            	    {
            	    // InternalMuLE.g:3010:5: ( (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' ) )
            	    // InternalMuLE.g:3011:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' )
            	    {
            	    // InternalMuLE.g:3011:6: (lv_op_2_1= '*' | lv_op_2_2= '/' | lv_op_2_3= 'div' | lv_op_2_4= 'mod' )
            	    int alt55=4;
            	    switch ( input.LA(1) ) {
            	    case 69:
            	        {
            	        alt55=1;
            	        }
            	        break;
            	    case 70:
            	        {
            	        alt55=2;
            	        }
            	        break;
            	    case 71:
            	        {
            	        alt55=3;
            	        }
            	        break;
            	    case 72:
            	        {
            	        alt55=4;
            	        }
            	        break;
            	    default:
            	        if (state.backtracking>0) {state.failed=true; return current;}
            	        NoViableAltException nvae =
            	            new NoViableAltException("", 55, 0, input);

            	        throw nvae;
            	    }

            	    switch (alt55) {
            	        case 1 :
            	            // InternalMuLE.g:3012:7: lv_op_2_1= '*'
            	            {
            	            lv_op_2_1=(Token)match(input,69,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_1, grammarAccess.getMultiplicativeExpressionAccess().getOpAsteriskKeyword_1_1_0_0());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_1, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 2 :
            	            // InternalMuLE.g:3023:7: lv_op_2_2= '/'
            	            {
            	            lv_op_2_2=(Token)match(input,70,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_2, grammarAccess.getMultiplicativeExpressionAccess().getOpSolidusKeyword_1_1_0_1());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_2, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 3 :
            	            // InternalMuLE.g:3034:7: lv_op_2_3= 'div'
            	            {
            	            lv_op_2_3=(Token)match(input,71,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_3, grammarAccess.getMultiplicativeExpressionAccess().getOpDivKeyword_1_1_0_2());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_3, null);
            	              						
            	            }

            	            }
            	            break;
            	        case 4 :
            	            // InternalMuLE.g:3045:7: lv_op_2_4= 'mod'
            	            {
            	            lv_op_2_4=(Token)match(input,72,FOLLOW_43); if (state.failed) return current;
            	            if ( state.backtracking==0 ) {

            	              							newLeafNode(lv_op_2_4, grammarAccess.getMultiplicativeExpressionAccess().getOpModKeyword_1_1_0_3());
            	              						
            	            }
            	            if ( state.backtracking==0 ) {

            	              							if (current==null) {
            	              								current = createModelElement(grammarAccess.getMultiplicativeExpressionRule());
            	              							}
            	              							setWithLastConsumed(current, "op", lv_op_2_4, null);
            	              						
            	            }

            	            }
            	            break;

            	    }


            	    }


            	    }

            	    // InternalMuLE.g:3058:4: ( (lv_right_3_0= ruleExponentExpression ) )
            	    // InternalMuLE.g:3059:5: (lv_right_3_0= ruleExponentExpression )
            	    {
            	    // InternalMuLE.g:3059:5: (lv_right_3_0= ruleExponentExpression )
            	    // InternalMuLE.g:3060:6: lv_right_3_0= ruleExponentExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getMultiplicativeExpressionAccess().getRightExponentExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_64);
            	    lv_right_3_0=ruleExponentExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getMultiplicativeExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.ExponentExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop56;
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
    // $ANTLR end "ruleMultiplicativeExpression"


    // $ANTLR start "entryRuleExponentExpression"
    // InternalMuLE.g:3082:1: entryRuleExponentExpression returns [EObject current=null] : iv_ruleExponentExpression= ruleExponentExpression EOF ;
    public final EObject entryRuleExponentExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleExponentExpression = null;


        try {
            // InternalMuLE.g:3082:59: (iv_ruleExponentExpression= ruleExponentExpression EOF )
            // InternalMuLE.g:3083:2: iv_ruleExponentExpression= ruleExponentExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getExponentExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleExponentExpression=ruleExponentExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleExponentExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleExponentExpression"


    // $ANTLR start "ruleExponentExpression"
    // InternalMuLE.g:3089:1: ruleExponentExpression returns [EObject current=null] : (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )* ) ;
    public final EObject ruleExponentExpression() throws RecognitionException {
        EObject current = null;

        Token lv_op_2_0=null;
        EObject this_AtomicExpression_0 = null;

        EObject lv_right_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3095:2: ( (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )* ) )
            // InternalMuLE.g:3096:2: (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )* )
            {
            // InternalMuLE.g:3096:2: (this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )* )
            // InternalMuLE.g:3097:3: this_AtomicExpression_0= ruleAtomicExpression ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )*
            {
            if ( state.backtracking==0 ) {

              			newCompositeNode(grammarAccess.getExponentExpressionAccess().getAtomicExpressionParserRuleCall_0());
              		
            }
            pushFollow(FOLLOW_65);
            this_AtomicExpression_0=ruleAtomicExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			current = this_AtomicExpression_0;
              			afterParserOrEnumRuleCall();
              		
            }
            // InternalMuLE.g:3105:3: ( () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) ) )*
            loop57:
            do {
                int alt57=2;
                int LA57_0 = input.LA(1);

                if ( (LA57_0==73) ) {
                    alt57=1;
                }


                switch (alt57) {
            	case 1 :
            	    // InternalMuLE.g:3106:4: () ( (lv_op_2_0= 'exp' ) ) ( (lv_right_3_0= ruleAtomicExpression ) )
            	    {
            	    // InternalMuLE.g:3106:4: ()
            	    // InternalMuLE.g:3107:5: 
            	    {
            	    if ( state.backtracking==0 ) {

            	      					current = forceCreateModelElementAndSet(
            	      						grammarAccess.getExponentExpressionAccess().getExponentExpressionLeftAction_1_0(),
            	      						current);
            	      				
            	    }

            	    }

            	    // InternalMuLE.g:3113:4: ( (lv_op_2_0= 'exp' ) )
            	    // InternalMuLE.g:3114:5: (lv_op_2_0= 'exp' )
            	    {
            	    // InternalMuLE.g:3114:5: (lv_op_2_0= 'exp' )
            	    // InternalMuLE.g:3115:6: lv_op_2_0= 'exp'
            	    {
            	    lv_op_2_0=(Token)match(input,73,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						newLeafNode(lv_op_2_0, grammarAccess.getExponentExpressionAccess().getOpExpKeyword_1_1_0());
            	      					
            	    }
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElement(grammarAccess.getExponentExpressionRule());
            	      						}
            	      						setWithLastConsumed(current, "op", lv_op_2_0, "exp");
            	      					
            	    }

            	    }


            	    }

            	    // InternalMuLE.g:3127:4: ( (lv_right_3_0= ruleAtomicExpression ) )
            	    // InternalMuLE.g:3128:5: (lv_right_3_0= ruleAtomicExpression )
            	    {
            	    // InternalMuLE.g:3128:5: (lv_right_3_0= ruleAtomicExpression )
            	    // InternalMuLE.g:3129:6: lv_right_3_0= ruleAtomicExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getExponentExpressionAccess().getRightAtomicExpressionParserRuleCall_1_2_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_65);
            	    lv_right_3_0=ruleAtomicExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getExponentExpressionRule());
            	      						}
            	      						set(
            	      							current,
            	      							"right",
            	      							lv_right_3_0,
            	      							"de.ubt.ai1.mule.MuLE.AtomicExpression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop57;
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
    // $ANTLR end "ruleExponentExpression"


    // $ANTLR start "entryRuleAtomicExpression"
    // InternalMuLE.g:3151:1: entryRuleAtomicExpression returns [EObject current=null] : iv_ruleAtomicExpression= ruleAtomicExpression EOF ;
    public final EObject entryRuleAtomicExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAtomicExpression = null;


        try {
            // InternalMuLE.g:3151:57: (iv_ruleAtomicExpression= ruleAtomicExpression EOF )
            // InternalMuLE.g:3152:2: iv_ruleAtomicExpression= ruleAtomicExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getAtomicExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleAtomicExpression=ruleAtomicExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleAtomicExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleAtomicExpression"


    // $ANTLR start "ruleAtomicExpression"
    // InternalMuLE.g:3158:1: ruleAtomicExpression returns [EObject current=null] : (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_RATIONAL ) ) ) | ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) ) | ( () otherlv_11= 'null' ) | ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) ) | ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) ) | ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' ) | this_ListInit_22= ruleListInit | this_LambdaExpression_23= ruleLambdaExpression ) ;
    public final EObject ruleAtomicExpression() throws RecognitionException {
        EObject current = null;

        Token lv_value_3_0=null;
        Token lv_value_5_0=null;
        Token lv_value_7_0=null;
        Token lv_value_9_1=null;
        Token lv_value_9_2=null;
        Token otherlv_11=null;
        Token lv_op_13_1=null;
        Token lv_op_13_2=null;
        Token lv_op_13_3=null;
        Token otherlv_16=null;
        Token otherlv_19=null;
        Token otherlv_21=null;
        EObject this_SymbolReference_0 = null;

        EObject this_SuperExpression_1 = null;

        EObject lv_expression_14_0 = null;

        EObject lv_expression_17_0 = null;

        EObject lv_expression_20_0 = null;

        EObject this_ListInit_22 = null;

        EObject this_LambdaExpression_23 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3164:2: ( (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_RATIONAL ) ) ) | ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) ) | ( () otherlv_11= 'null' ) | ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) ) | ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) ) | ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' ) | this_ListInit_22= ruleListInit | this_LambdaExpression_23= ruleLambdaExpression ) )
            // InternalMuLE.g:3165:2: (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_RATIONAL ) ) ) | ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) ) | ( () otherlv_11= 'null' ) | ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) ) | ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) ) | ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' ) | this_ListInit_22= ruleListInit | this_LambdaExpression_23= ruleLambdaExpression )
            {
            // InternalMuLE.g:3165:2: (this_SymbolReference_0= ruleSymbolReference | this_SuperExpression_1= ruleSuperExpression | ( () ( (lv_value_3_0= RULE_STRING ) ) ) | ( () ( (lv_value_5_0= RULE_INTEGER ) ) ) | ( () ( (lv_value_7_0= RULE_RATIONAL ) ) ) | ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) ) | ( () otherlv_11= 'null' ) | ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) ) | ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) ) | ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' ) | this_ListInit_22= ruleListInit | this_LambdaExpression_23= ruleLambdaExpression )
            int alt60=12;
            switch ( input.LA(1) ) {
            case RULE_ID:
                {
                alt60=1;
                }
                break;
            case 78:
                {
                alt60=2;
                }
                break;
            case RULE_STRING:
                {
                alt60=3;
                }
                break;
            case RULE_INTEGER:
                {
                alt60=4;
                }
                break;
            case RULE_RATIONAL:
                {
                alt60=5;
                }
                break;
            case 74:
            case 75:
                {
                alt60=6;
                }
                break;
            case 76:
                {
                alt60=7;
                }
                break;
            case 66:
            case 67:
            case 77:
                {
                alt60=8;
                }
                break;
            case 26:
                {
                alt60=9;
                }
                break;
            case 29:
                {
                alt60=10;
                }
                break;
            case 79:
                {
                alt60=11;
                }
                break;
            case 28:
                {
                alt60=12;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 60, 0, input);

                throw nvae;
            }

            switch (alt60) {
                case 1 :
                    // InternalMuLE.g:3166:3: this_SymbolReference_0= ruleSymbolReference
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getSymbolReferenceParserRuleCall_0());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SymbolReference_0=ruleSymbolReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SymbolReference_0;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:3175:3: this_SuperExpression_1= ruleSuperExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getSuperExpressionParserRuleCall_1());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_SuperExpression_1=ruleSuperExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_SuperExpression_1;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 3 :
                    // InternalMuLE.g:3184:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    {
                    // InternalMuLE.g:3184:3: ( () ( (lv_value_3_0= RULE_STRING ) ) )
                    // InternalMuLE.g:3185:4: () ( (lv_value_3_0= RULE_STRING ) )
                    {
                    // InternalMuLE.g:3185:4: ()
                    // InternalMuLE.g:3186:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getStringConstantAction_2_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMuLE.g:3192:4: ( (lv_value_3_0= RULE_STRING ) )
                    // InternalMuLE.g:3193:5: (lv_value_3_0= RULE_STRING )
                    {
                    // InternalMuLE.g:3193:5: (lv_value_3_0= RULE_STRING )
                    // InternalMuLE.g:3194:6: lv_value_3_0= RULE_STRING
                    {
                    lv_value_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_3_0, grammarAccess.getAtomicExpressionAccess().getValueSTRINGTerminalRuleCall_2_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_3_0,
                      							"de.ubt.ai1.mule.MuLE.STRING");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 4 :
                    // InternalMuLE.g:3212:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    {
                    // InternalMuLE.g:3212:3: ( () ( (lv_value_5_0= RULE_INTEGER ) ) )
                    // InternalMuLE.g:3213:4: () ( (lv_value_5_0= RULE_INTEGER ) )
                    {
                    // InternalMuLE.g:3213:4: ()
                    // InternalMuLE.g:3214:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getIntegerConstantAction_3_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMuLE.g:3220:4: ( (lv_value_5_0= RULE_INTEGER ) )
                    // InternalMuLE.g:3221:5: (lv_value_5_0= RULE_INTEGER )
                    {
                    // InternalMuLE.g:3221:5: (lv_value_5_0= RULE_INTEGER )
                    // InternalMuLE.g:3222:6: lv_value_5_0= RULE_INTEGER
                    {
                    lv_value_5_0=(Token)match(input,RULE_INTEGER,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_5_0, grammarAccess.getAtomicExpressionAccess().getValueINTEGERTerminalRuleCall_3_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_5_0,
                      							"de.ubt.ai1.mule.MuLE.INTEGER");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 5 :
                    // InternalMuLE.g:3240:3: ( () ( (lv_value_7_0= RULE_RATIONAL ) ) )
                    {
                    // InternalMuLE.g:3240:3: ( () ( (lv_value_7_0= RULE_RATIONAL ) ) )
                    // InternalMuLE.g:3241:4: () ( (lv_value_7_0= RULE_RATIONAL ) )
                    {
                    // InternalMuLE.g:3241:4: ()
                    // InternalMuLE.g:3242:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getRationalConstantAction_4_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMuLE.g:3248:4: ( (lv_value_7_0= RULE_RATIONAL ) )
                    // InternalMuLE.g:3249:5: (lv_value_7_0= RULE_RATIONAL )
                    {
                    // InternalMuLE.g:3249:5: (lv_value_7_0= RULE_RATIONAL )
                    // InternalMuLE.g:3250:6: lv_value_7_0= RULE_RATIONAL
                    {
                    lv_value_7_0=(Token)match(input,RULE_RATIONAL,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_value_7_0, grammarAccess.getAtomicExpressionAccess().getValueRATIONALTerminalRuleCall_4_1_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getAtomicExpressionRule());
                      						}
                      						setWithLastConsumed(
                      							current,
                      							"value",
                      							lv_value_7_0,
                      							"de.ubt.ai1.mule.MuLE.RATIONAL");
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 6 :
                    // InternalMuLE.g:3268:3: ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) )
                    {
                    // InternalMuLE.g:3268:3: ( () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) ) )
                    // InternalMuLE.g:3269:4: () ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) )
                    {
                    // InternalMuLE.g:3269:4: ()
                    // InternalMuLE.g:3270:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getBooleanConstantAction_5_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMuLE.g:3276:4: ( ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) ) )
                    // InternalMuLE.g:3277:5: ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) )
                    {
                    // InternalMuLE.g:3277:5: ( (lv_value_9_1= 'true' | lv_value_9_2= 'false' ) )
                    // InternalMuLE.g:3278:6: (lv_value_9_1= 'true' | lv_value_9_2= 'false' )
                    {
                    // InternalMuLE.g:3278:6: (lv_value_9_1= 'true' | lv_value_9_2= 'false' )
                    int alt58=2;
                    int LA58_0 = input.LA(1);

                    if ( (LA58_0==74) ) {
                        alt58=1;
                    }
                    else if ( (LA58_0==75) ) {
                        alt58=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 58, 0, input);

                        throw nvae;
                    }
                    switch (alt58) {
                        case 1 :
                            // InternalMuLE.g:3279:7: lv_value_9_1= 'true'
                            {
                            lv_value_9_1=(Token)match(input,74,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_9_1, grammarAccess.getAtomicExpressionAccess().getValueTrueKeyword_5_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_9_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMuLE.g:3290:7: lv_value_9_2= 'false'
                            {
                            lv_value_9_2=(Token)match(input,75,FOLLOW_2); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_value_9_2, grammarAccess.getAtomicExpressionAccess().getValueFalseKeyword_5_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExpressionRule());
                              							}
                              							setWithLastConsumed(current, "value", lv_value_9_2, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }


                    }
                    break;
                case 7 :
                    // InternalMuLE.g:3305:3: ( () otherlv_11= 'null' )
                    {
                    // InternalMuLE.g:3305:3: ( () otherlv_11= 'null' )
                    // InternalMuLE.g:3306:4: () otherlv_11= 'null'
                    {
                    // InternalMuLE.g:3306:4: ()
                    // InternalMuLE.g:3307:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getNullAction_6_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_11=(Token)match(input,76,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_11, grammarAccess.getAtomicExpressionAccess().getNullKeyword_6_1());
                      			
                    }

                    }


                    }
                    break;
                case 8 :
                    // InternalMuLE.g:3319:3: ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) )
                    {
                    // InternalMuLE.g:3319:3: ( () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) ) )
                    // InternalMuLE.g:3320:4: () ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) ) ( (lv_expression_14_0= ruleAtomicExpression ) )
                    {
                    // InternalMuLE.g:3320:4: ()
                    // InternalMuLE.g:3321:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getUnaryAction_7_0(),
                      						current);
                      				
                    }

                    }

                    // InternalMuLE.g:3327:4: ( ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) ) )
                    // InternalMuLE.g:3328:5: ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) )
                    {
                    // InternalMuLE.g:3328:5: ( (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' ) )
                    // InternalMuLE.g:3329:6: (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' )
                    {
                    // InternalMuLE.g:3329:6: (lv_op_13_1= '+' | lv_op_13_2= '-' | lv_op_13_3= 'not' )
                    int alt59=3;
                    switch ( input.LA(1) ) {
                    case 66:
                        {
                        alt59=1;
                        }
                        break;
                    case 67:
                        {
                        alt59=2;
                        }
                        break;
                    case 77:
                        {
                        alt59=3;
                        }
                        break;
                    default:
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 59, 0, input);

                        throw nvae;
                    }

                    switch (alt59) {
                        case 1 :
                            // InternalMuLE.g:3330:7: lv_op_13_1= '+'
                            {
                            lv_op_13_1=(Token)match(input,66,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_13_1, grammarAccess.getAtomicExpressionAccess().getOpPlusSignKeyword_7_1_0_0());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_13_1, null);
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMuLE.g:3341:7: lv_op_13_2= '-'
                            {
                            lv_op_13_2=(Token)match(input,67,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_13_2, grammarAccess.getAtomicExpressionAccess().getOpHyphenMinusKeyword_7_1_0_1());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_13_2, null);
                              						
                            }

                            }
                            break;
                        case 3 :
                            // InternalMuLE.g:3352:7: lv_op_13_3= 'not'
                            {
                            lv_op_13_3=(Token)match(input,77,FOLLOW_43); if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							newLeafNode(lv_op_13_3, grammarAccess.getAtomicExpressionAccess().getOpNotKeyword_7_1_0_2());
                              						
                            }
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElement(grammarAccess.getAtomicExpressionRule());
                              							}
                              							setWithLastConsumed(current, "op", lv_op_13_3, null);
                              						
                            }

                            }
                            break;

                    }


                    }


                    }

                    // InternalMuLE.g:3365:4: ( (lv_expression_14_0= ruleAtomicExpression ) )
                    // InternalMuLE.g:3366:5: (lv_expression_14_0= ruleAtomicExpression )
                    {
                    // InternalMuLE.g:3366:5: (lv_expression_14_0= ruleAtomicExpression )
                    // InternalMuLE.g:3367:6: lv_expression_14_0= ruleAtomicExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getExpressionAtomicExpressionParserRuleCall_7_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_14_0=ruleAtomicExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_14_0,
                      							"de.ubt.ai1.mule.MuLE.AtomicExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 9 :
                    // InternalMuLE.g:3386:3: ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) )
                    {
                    // InternalMuLE.g:3386:3: ( () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) ) )
                    // InternalMuLE.g:3387:4: () otherlv_16= 'reference' ( (lv_expression_17_0= ruleAtomicExpression ) )
                    {
                    // InternalMuLE.g:3387:4: ()
                    // InternalMuLE.g:3388:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getReferenceAction_8_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_16=(Token)match(input,26,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_16, grammarAccess.getAtomicExpressionAccess().getReferenceKeyword_8_1());
                      			
                    }
                    // InternalMuLE.g:3398:4: ( (lv_expression_17_0= ruleAtomicExpression ) )
                    // InternalMuLE.g:3399:5: (lv_expression_17_0= ruleAtomicExpression )
                    {
                    // InternalMuLE.g:3399:5: (lv_expression_17_0= ruleAtomicExpression )
                    // InternalMuLE.g:3400:6: lv_expression_17_0= ruleAtomicExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getExpressionAtomicExpressionParserRuleCall_8_2_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_expression_17_0=ruleAtomicExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_17_0,
                      							"de.ubt.ai1.mule.MuLE.AtomicExpression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }


                    }
                    break;
                case 10 :
                    // InternalMuLE.g:3419:3: ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' )
                    {
                    // InternalMuLE.g:3419:3: ( () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')' )
                    // InternalMuLE.g:3420:4: () otherlv_19= '(' ( (lv_expression_20_0= ruleExpression ) ) otherlv_21= ')'
                    {
                    // InternalMuLE.g:3420:4: ()
                    // InternalMuLE.g:3421:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getAtomicExpressionAccess().getParenthesizedExpressionAction_9_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_19=(Token)match(input,29,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_19, grammarAccess.getAtomicExpressionAccess().getLeftParenthesisKeyword_9_1());
                      			
                    }
                    // InternalMuLE.g:3431:4: ( (lv_expression_20_0= ruleExpression ) )
                    // InternalMuLE.g:3432:5: (lv_expression_20_0= ruleExpression )
                    {
                    // InternalMuLE.g:3432:5: (lv_expression_20_0= ruleExpression )
                    // InternalMuLE.g:3433:6: lv_expression_20_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getAtomicExpressionAccess().getExpressionExpressionParserRuleCall_9_2_0());
                      					
                    }
                    pushFollow(FOLLOW_66);
                    lv_expression_20_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getAtomicExpressionRule());
                      						}
                      						set(
                      							current,
                      							"expression",
                      							lv_expression_20_0,
                      							"de.ubt.ai1.mule.MuLE.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_21=(Token)match(input,30,FOLLOW_2); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_21, grammarAccess.getAtomicExpressionAccess().getRightParenthesisKeyword_9_3());
                      			
                    }

                    }


                    }
                    break;
                case 11 :
                    // InternalMuLE.g:3456:3: this_ListInit_22= ruleListInit
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getListInitParserRuleCall_10());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_ListInit_22=ruleListInit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_ListInit_22;
                      			afterParserOrEnumRuleCall();
                      		
                    }

                    }
                    break;
                case 12 :
                    // InternalMuLE.g:3465:3: this_LambdaExpression_23= ruleLambdaExpression
                    {
                    if ( state.backtracking==0 ) {

                      			newCompositeNode(grammarAccess.getAtomicExpressionAccess().getLambdaExpressionParserRuleCall_11());
                      		
                    }
                    pushFollow(FOLLOW_2);
                    this_LambdaExpression_23=ruleLambdaExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      			current = this_LambdaExpression_23;
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
    // $ANTLR end "ruleAtomicExpression"


    // $ANTLR start "entryRuleLambdaExpression"
    // InternalMuLE.g:3477:1: entryRuleLambdaExpression returns [EObject current=null] : iv_ruleLambdaExpression= ruleLambdaExpression EOF ;
    public final EObject entryRuleLambdaExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleLambdaExpression = null;


        try {
            // InternalMuLE.g:3477:57: (iv_ruleLambdaExpression= ruleLambdaExpression EOF )
            // InternalMuLE.g:3478:2: iv_ruleLambdaExpression= ruleLambdaExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getLambdaExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleLambdaExpression=ruleLambdaExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleLambdaExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleLambdaExpression"


    // $ANTLR start "ruleLambdaExpression"
    // InternalMuLE.g:3484:1: ruleLambdaExpression returns [EObject current=null] : ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ( (lv_block_9_0= ruleBlock ) ) otherlv_10= 'endoperation' ) ;
    public final EObject ruleLambdaExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        Token otherlv_4=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_10=null;
        EObject lv_parameters_3_0 = null;

        EObject lv_parameters_5_0 = null;

        EObject lv_type_8_0 = null;

        EObject lv_block_9_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3490:2: ( ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ( (lv_block_9_0= ruleBlock ) ) otherlv_10= 'endoperation' ) )
            // InternalMuLE.g:3491:2: ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ( (lv_block_9_0= ruleBlock ) ) otherlv_10= 'endoperation' )
            {
            // InternalMuLE.g:3491:2: ( () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ( (lv_block_9_0= ruleBlock ) ) otherlv_10= 'endoperation' )
            // InternalMuLE.g:3492:3: () otherlv_1= 'operation' otherlv_2= '(' ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )? otherlv_6= ')' (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )? ( (lv_block_9_0= ruleBlock ) ) otherlv_10= 'endoperation'
            {
            // InternalMuLE.g:3492:3: ()
            // InternalMuLE.g:3493:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getLambdaExpressionAccess().getLambdaExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,28,FOLLOW_14); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getLambdaExpressionAccess().getOperationKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,29,FOLLOW_35); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getLambdaExpressionAccess().getLeftParenthesisKeyword_2());
              		
            }
            // InternalMuLE.g:3507:3: ( ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )* )?
            int alt62=2;
            int LA62_0 = input.LA(1);

            if ( (LA62_0==41) ) {
                alt62=1;
            }
            switch (alt62) {
                case 1 :
                    // InternalMuLE.g:3508:4: ( (lv_parameters_3_0= ruleParameter ) ) (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    {
                    // InternalMuLE.g:3508:4: ( (lv_parameters_3_0= ruleParameter ) )
                    // InternalMuLE.g:3509:5: (lv_parameters_3_0= ruleParameter )
                    {
                    // InternalMuLE.g:3509:5: (lv_parameters_3_0= ruleParameter )
                    // InternalMuLE.g:3510:6: lv_parameters_3_0= ruleParameter
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLambdaExpressionAccess().getParametersParameterParserRuleCall_3_0_0());
                      					
                    }
                    pushFollow(FOLLOW_16);
                    lv_parameters_3_0=ruleParameter();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLambdaExpressionRule());
                      						}
                      						add(
                      							current,
                      							"parameters",
                      							lv_parameters_3_0,
                      							"de.ubt.ai1.mule.MuLE.Parameter");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:3527:4: (otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) ) )*
                    loop61:
                    do {
                        int alt61=2;
                        int LA61_0 = input.LA(1);

                        if ( (LA61_0==20) ) {
                            alt61=1;
                        }


                        switch (alt61) {
                    	case 1 :
                    	    // InternalMuLE.g:3528:5: otherlv_4= ',' ( (lv_parameters_5_0= ruleParameter ) )
                    	    {
                    	    otherlv_4=(Token)match(input,20,FOLLOW_36); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_4, grammarAccess.getLambdaExpressionAccess().getCommaKeyword_3_1_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:3532:5: ( (lv_parameters_5_0= ruleParameter ) )
                    	    // InternalMuLE.g:3533:6: (lv_parameters_5_0= ruleParameter )
                    	    {
                    	    // InternalMuLE.g:3533:6: (lv_parameters_5_0= ruleParameter )
                    	    // InternalMuLE.g:3534:7: lv_parameters_5_0= ruleParameter
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getLambdaExpressionAccess().getParametersParameterParserRuleCall_3_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_16);
                    	    lv_parameters_5_0=ruleParameter();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getLambdaExpressionRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"parameters",
                    	      								lv_parameters_5_0,
                    	      								"de.ubt.ai1.mule.MuLE.Parameter");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop61;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,30,FOLLOW_67); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_6, grammarAccess.getLambdaExpressionAccess().getRightParenthesisKeyword_4());
              		
            }
            // InternalMuLE.g:3557:3: (otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) ) )?
            int alt63=2;
            int LA63_0 = input.LA(1);

            if ( (LA63_0==31) ) {
                alt63=1;
            }
            switch (alt63) {
                case 1 :
                    // InternalMuLE.g:3558:4: otherlv_7= ':' ( (lv_type_8_0= ruleDataType ) )
                    {
                    otherlv_7=(Token)match(input,31,FOLLOW_10); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_7, grammarAccess.getLambdaExpressionAccess().getColonKeyword_5_0());
                      			
                    }
                    // InternalMuLE.g:3562:4: ( (lv_type_8_0= ruleDataType ) )
                    // InternalMuLE.g:3563:5: (lv_type_8_0= ruleDataType )
                    {
                    // InternalMuLE.g:3563:5: (lv_type_8_0= ruleDataType )
                    // InternalMuLE.g:3564:6: lv_type_8_0= ruleDataType
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getLambdaExpressionAccess().getTypeDataTypeParserRuleCall_5_1_0());
                      					
                    }
                    pushFollow(FOLLOW_68);
                    lv_type_8_0=ruleDataType();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getLambdaExpressionRule());
                      						}
                      						set(
                      							current,
                      							"type",
                      							lv_type_8_0,
                      							"de.ubt.ai1.mule.MuLE.DataType");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }


                    }
                    break;

            }

            // InternalMuLE.g:3582:3: ( (lv_block_9_0= ruleBlock ) )
            // InternalMuLE.g:3583:4: (lv_block_9_0= ruleBlock )
            {
            // InternalMuLE.g:3583:4: (lv_block_9_0= ruleBlock )
            // InternalMuLE.g:3584:5: lv_block_9_0= ruleBlock
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getLambdaExpressionAccess().getBlockBlockParserRuleCall_6_0());
              				
            }
            pushFollow(FOLLOW_39);
            lv_block_9_0=ruleBlock();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getLambdaExpressionRule());
              					}
              					set(
              						current,
              						"block",
              						lv_block_9_0,
              						"de.ubt.ai1.mule.MuLE.Block");
              					afterParserOrEnumRuleCall();
              				
            }

            }


            }

            otherlv_10=(Token)match(input,43,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_10, grammarAccess.getLambdaExpressionAccess().getEndoperationKeyword_7());
              		
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
    // $ANTLR end "ruleLambdaExpression"


    // $ANTLR start "entryRuleSuperExpression"
    // InternalMuLE.g:3609:1: entryRuleSuperExpression returns [EObject current=null] : iv_ruleSuperExpression= ruleSuperExpression EOF ;
    public final EObject entryRuleSuperExpression() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSuperExpression = null;


        try {
            // InternalMuLE.g:3609:56: (iv_ruleSuperExpression= ruleSuperExpression EOF )
            // InternalMuLE.g:3610:2: iv_ruleSuperExpression= ruleSuperExpression EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSuperExpressionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSuperExpression=ruleSuperExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSuperExpression; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSuperExpression"


    // $ANTLR start "ruleSuperExpression"
    // InternalMuLE.g:3616:1: ruleSuperExpression returns [EObject current=null] : ( () otherlv_1= 'super' otherlv_2= '.' ( (lv_memberCall_3_0= ruleSymbolReference ) ) ) ;
    public final EObject ruleSuperExpression() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_2=null;
        EObject lv_memberCall_3_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3622:2: ( ( () otherlv_1= 'super' otherlv_2= '.' ( (lv_memberCall_3_0= ruleSymbolReference ) ) ) )
            // InternalMuLE.g:3623:2: ( () otherlv_1= 'super' otherlv_2= '.' ( (lv_memberCall_3_0= ruleSymbolReference ) ) )
            {
            // InternalMuLE.g:3623:2: ( () otherlv_1= 'super' otherlv_2= '.' ( (lv_memberCall_3_0= ruleSymbolReference ) ) )
            // InternalMuLE.g:3624:3: () otherlv_1= 'super' otherlv_2= '.' ( (lv_memberCall_3_0= ruleSymbolReference ) )
            {
            // InternalMuLE.g:3624:3: ()
            // InternalMuLE.g:3625:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSuperExpressionAccess().getSuperExpressionAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,78,FOLLOW_69); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSuperExpressionAccess().getSuperKeyword_1());
              		
            }
            otherlv_2=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_2, grammarAccess.getSuperExpressionAccess().getFullStopKeyword_2());
              		
            }
            // InternalMuLE.g:3639:3: ( (lv_memberCall_3_0= ruleSymbolReference ) )
            // InternalMuLE.g:3640:4: (lv_memberCall_3_0= ruleSymbolReference )
            {
            // InternalMuLE.g:3640:4: (lv_memberCall_3_0= ruleSymbolReference )
            // InternalMuLE.g:3641:5: lv_memberCall_3_0= ruleSymbolReference
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSuperExpressionAccess().getMemberCallSymbolReferenceParserRuleCall_3_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_memberCall_3_0=ruleSymbolReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSuperExpressionRule());
              					}
              					set(
              						current,
              						"memberCall",
              						lv_memberCall_3_0,
              						"de.ubt.ai1.mule.MuLE.SymbolReference");
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
    // $ANTLR end "ruleSuperExpression"


    // $ANTLR start "entryRuleSymbolReference"
    // InternalMuLE.g:3662:1: entryRuleSymbolReference returns [EObject current=null] : iv_ruleSymbolReference= ruleSymbolReference EOF ;
    public final EObject entryRuleSymbolReference() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolReference = null;


        try {
            // InternalMuLE.g:3662:56: (iv_ruleSymbolReference= ruleSymbolReference EOF )
            // InternalMuLE.g:3663:2: iv_ruleSymbolReference= ruleSymbolReference EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSymbolReferenceRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSymbolReference=ruleSymbolReference();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSymbolReference; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSymbolReference"


    // $ANTLR start "ruleSymbolReference"
    // InternalMuLE.g:3669:1: ruleSymbolReference returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )? ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )? (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )? ) ;
    public final EObject ruleSymbolReference() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_3=null;
        EObject lv_compositionInit_1_0 = null;

        EObject lv_accessModifier_2_0 = null;

        EObject lv_memberCall_4_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3675:2: ( ( ( (otherlv_0= RULE_ID ) ) ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )? ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )? (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )? ) )
            // InternalMuLE.g:3676:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )? ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )? (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )? )
            {
            // InternalMuLE.g:3676:2: ( ( (otherlv_0= RULE_ID ) ) ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )? ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )? (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )? )
            // InternalMuLE.g:3677:3: ( (otherlv_0= RULE_ID ) ) ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )? ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )? (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )?
            {
            // InternalMuLE.g:3677:3: ( (otherlv_0= RULE_ID ) )
            // InternalMuLE.g:3678:4: (otherlv_0= RULE_ID )
            {
            // InternalMuLE.g:3678:4: (otherlv_0= RULE_ID )
            // InternalMuLE.g:3679:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSymbolReferenceRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_70); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getSymbolReferenceAccess().getSymbolNamedElementCrossReference_0_0());
              				
            }

            }


            }

            // InternalMuLE.g:3690:3: ( (lv_compositionInit_1_0= ruleSymbolRefCompositionInit ) )?
            int alt64=2;
            int LA64_0 = input.LA(1);

            if ( (LA64_0==82) ) {
                alt64=1;
            }
            switch (alt64) {
                case 1 :
                    // InternalMuLE.g:3691:4: (lv_compositionInit_1_0= ruleSymbolRefCompositionInit )
                    {
                    // InternalMuLE.g:3691:4: (lv_compositionInit_1_0= ruleSymbolRefCompositionInit )
                    // InternalMuLE.g:3692:5: lv_compositionInit_1_0= ruleSymbolRefCompositionInit
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSymbolReferenceAccess().getCompositionInitSymbolRefCompositionInitParserRuleCall_1_0());
                      				
                    }
                    pushFollow(FOLLOW_71);
                    lv_compositionInit_1_0=ruleSymbolRefCompositionInit();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSymbolReferenceRule());
                      					}
                      					set(
                      						current,
                      						"compositionInit",
                      						lv_compositionInit_1_0,
                      						"de.ubt.ai1.mule.MuLE.SymbolRefCompositionInit");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMuLE.g:3709:3: ( (lv_accessModifier_2_0= ruleSymbolRefAccessModifier ) )?
            int alt65=2;
            int LA65_0 = input.LA(1);

            if ( (LA65_0==29||LA65_0==79||LA65_0==81) ) {
                alt65=1;
            }
            switch (alt65) {
                case 1 :
                    // InternalMuLE.g:3710:4: (lv_accessModifier_2_0= ruleSymbolRefAccessModifier )
                    {
                    // InternalMuLE.g:3710:4: (lv_accessModifier_2_0= ruleSymbolRefAccessModifier )
                    // InternalMuLE.g:3711:5: lv_accessModifier_2_0= ruleSymbolRefAccessModifier
                    {
                    if ( state.backtracking==0 ) {

                      					newCompositeNode(grammarAccess.getSymbolReferenceAccess().getAccessModifierSymbolRefAccessModifierParserRuleCall_2_0());
                      				
                    }
                    pushFollow(FOLLOW_6);
                    lv_accessModifier_2_0=ruleSymbolRefAccessModifier();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      					if (current==null) {
                      						current = createModelElementForParent(grammarAccess.getSymbolReferenceRule());
                      					}
                      					set(
                      						current,
                      						"accessModifier",
                      						lv_accessModifier_2_0,
                      						"de.ubt.ai1.mule.MuLE.SymbolRefAccessModifier");
                      					afterParserOrEnumRuleCall();
                      				
                    }

                    }


                    }
                    break;

            }

            // InternalMuLE.g:3728:3: (otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) ) )?
            int alt66=2;
            int LA66_0 = input.LA(1);

            if ( (LA66_0==15) ) {
                alt66=1;
            }
            switch (alt66) {
                case 1 :
                    // InternalMuLE.g:3729:4: otherlv_3= '.' ( (lv_memberCall_4_0= ruleSymbolReference ) )
                    {
                    otherlv_3=(Token)match(input,15,FOLLOW_3); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_3, grammarAccess.getSymbolReferenceAccess().getFullStopKeyword_3_0());
                      			
                    }
                    // InternalMuLE.g:3733:4: ( (lv_memberCall_4_0= ruleSymbolReference ) )
                    // InternalMuLE.g:3734:5: (lv_memberCall_4_0= ruleSymbolReference )
                    {
                    // InternalMuLE.g:3734:5: (lv_memberCall_4_0= ruleSymbolReference )
                    // InternalMuLE.g:3735:6: lv_memberCall_4_0= ruleSymbolReference
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSymbolReferenceAccess().getMemberCallSymbolReferenceParserRuleCall_3_1_0());
                      					
                    }
                    pushFollow(FOLLOW_2);
                    lv_memberCall_4_0=ruleSymbolReference();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSymbolReferenceRule());
                      						}
                      						set(
                      							current,
                      							"memberCall",
                      							lv_memberCall_4_0,
                      							"de.ubt.ai1.mule.MuLE.SymbolReference");
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
    // $ANTLR end "ruleSymbolReference"


    // $ANTLR start "entryRuleSymbolRefAccessModifier"
    // InternalMuLE.g:3757:1: entryRuleSymbolRefAccessModifier returns [EObject current=null] : iv_ruleSymbolRefAccessModifier= ruleSymbolRefAccessModifier EOF ;
    public final EObject entryRuleSymbolRefAccessModifier() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolRefAccessModifier = null;


        try {
            // InternalMuLE.g:3757:64: (iv_ruleSymbolRefAccessModifier= ruleSymbolRefAccessModifier EOF )
            // InternalMuLE.g:3758:2: iv_ruleSymbolRefAccessModifier= ruleSymbolRefAccessModifier EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSymbolRefAccessModifierRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSymbolRefAccessModifier=ruleSymbolRefAccessModifier();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSymbolRefAccessModifier; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSymbolRefAccessModifier"


    // $ANTLR start "ruleSymbolRefAccessModifier"
    // InternalMuLE.g:3764:1: ruleSymbolRefAccessModifier returns [EObject current=null] : ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? ) ) ;
    public final EObject ruleSymbolRefAccessModifier() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_13=null;
        EObject lv_params_2_0 = null;

        EObject lv_params_4_0 = null;

        EObject lv_accessModifier_6_0 = null;

        EObject lv_index_9_0 = null;

        EObject lv_accessModifier_11_0 = null;

        EObject lv_accessModifier_14_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3770:2: ( ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? ) ) )
            // InternalMuLE.g:3771:2: ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? ) )
            {
            // InternalMuLE.g:3771:2: ( ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? ) | ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? ) )
            int alt72=3;
            switch ( input.LA(1) ) {
            case 29:
                {
                alt72=1;
                }
                break;
            case 79:
                {
                alt72=2;
                }
                break;
            case 81:
                {
                alt72=3;
                }
                break;
            default:
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 72, 0, input);

                throw nvae;
            }

            switch (alt72) {
                case 1 :
                    // InternalMuLE.g:3772:3: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? )
                    {
                    // InternalMuLE.g:3772:3: ( () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )? )
                    // InternalMuLE.g:3773:4: () otherlv_1= '(' ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )? otherlv_5= ')' ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )?
                    {
                    // InternalMuLE.g:3773:4: ()
                    // InternalMuLE.g:3774:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSymbolRefAccessModifierAccess().getOperationInvocationAction_0_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_1=(Token)match(input,29,FOLLOW_72); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_1, grammarAccess.getSymbolRefAccessModifierAccess().getLeftParenthesisKeyword_0_1());
                      			
                    }
                    // InternalMuLE.g:3784:4: ( ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )* )?
                    int alt68=2;
                    int LA68_0 = input.LA(1);

                    if ( ((LA68_0>=RULE_ID && LA68_0<=RULE_RATIONAL)||LA68_0==26||(LA68_0>=28 && LA68_0<=29)||(LA68_0>=66 && LA68_0<=67)||(LA68_0>=74 && LA68_0<=79)) ) {
                        alt68=1;
                    }
                    switch (alt68) {
                        case 1 :
                            // InternalMuLE.g:3785:5: ( (lv_params_2_0= ruleExpression ) ) (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            {
                            // InternalMuLE.g:3785:5: ( (lv_params_2_0= ruleExpression ) )
                            // InternalMuLE.g:3786:6: (lv_params_2_0= ruleExpression )
                            {
                            // InternalMuLE.g:3786:6: (lv_params_2_0= ruleExpression )
                            // InternalMuLE.g:3787:7: lv_params_2_0= ruleExpression
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getParamsExpressionParserRuleCall_0_2_0_0());
                              						
                            }
                            pushFollow(FOLLOW_16);
                            lv_params_2_0=ruleExpression();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                              							}
                              							add(
                              								current,
                              								"params",
                              								lv_params_2_0,
                              								"de.ubt.ai1.mule.MuLE.Expression");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }


                            }

                            // InternalMuLE.g:3804:5: (otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) ) )*
                            loop67:
                            do {
                                int alt67=2;
                                int LA67_0 = input.LA(1);

                                if ( (LA67_0==20) ) {
                                    alt67=1;
                                }


                                switch (alt67) {
                            	case 1 :
                            	    // InternalMuLE.g:3805:6: otherlv_3= ',' ( (lv_params_4_0= ruleExpression ) )
                            	    {
                            	    otherlv_3=(Token)match(input,20,FOLLOW_43); if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      						newLeafNode(otherlv_3, grammarAccess.getSymbolRefAccessModifierAccess().getCommaKeyword_0_2_1_0());
                            	      					
                            	    }
                            	    // InternalMuLE.g:3809:6: ( (lv_params_4_0= ruleExpression ) )
                            	    // InternalMuLE.g:3810:7: (lv_params_4_0= ruleExpression )
                            	    {
                            	    // InternalMuLE.g:3810:7: (lv_params_4_0= ruleExpression )
                            	    // InternalMuLE.g:3811:8: lv_params_4_0= ruleExpression
                            	    {
                            	    if ( state.backtracking==0 ) {

                            	      								newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getParamsExpressionParserRuleCall_0_2_1_1_0());
                            	      							
                            	    }
                            	    pushFollow(FOLLOW_16);
                            	    lv_params_4_0=ruleExpression();

                            	    state._fsp--;
                            	    if (state.failed) return current;
                            	    if ( state.backtracking==0 ) {

                            	      								if (current==null) {
                            	      									current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                            	      								}
                            	      								add(
                            	      									current,
                            	      									"params",
                            	      									lv_params_4_0,
                            	      									"de.ubt.ai1.mule.MuLE.Expression");
                            	      								afterParserOrEnumRuleCall();
                            	      							
                            	    }

                            	    }


                            	    }


                            	    }
                            	    break;

                            	default :
                            	    break loop67;
                                }
                            } while (true);


                            }
                            break;

                    }

                    otherlv_5=(Token)match(input,30,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_5, grammarAccess.getSymbolRefAccessModifierAccess().getRightParenthesisKeyword_0_3());
                      			
                    }
                    // InternalMuLE.g:3834:4: ( (lv_accessModifier_6_0= ruleSymbolRefAccessModifier ) )?
                    int alt69=2;
                    int LA69_0 = input.LA(1);

                    if ( (LA69_0==29||LA69_0==79||LA69_0==81) ) {
                        alt69=1;
                    }
                    switch (alt69) {
                        case 1 :
                            // InternalMuLE.g:3835:5: (lv_accessModifier_6_0= ruleSymbolRefAccessModifier )
                            {
                            // InternalMuLE.g:3835:5: (lv_accessModifier_6_0= ruleSymbolRefAccessModifier )
                            // InternalMuLE.g:3836:6: lv_accessModifier_6_0= ruleSymbolRefAccessModifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierSymbolRefAccessModifierParserRuleCall_0_4_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_accessModifier_6_0=ruleSymbolRefAccessModifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                              						}
                              						set(
                              							current,
                              							"accessModifier",
                              							lv_accessModifier_6_0,
                              							"de.ubt.ai1.mule.MuLE.SymbolRefAccessModifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMuLE.g:3855:3: ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? )
                    {
                    // InternalMuLE.g:3855:3: ( () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )? )
                    // InternalMuLE.g:3856:4: () otherlv_8= '[' ( (lv_index_9_0= ruleExpression ) ) otherlv_10= ']' ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )?
                    {
                    // InternalMuLE.g:3856:4: ()
                    // InternalMuLE.g:3857:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSymbolRefAccessModifierAccess().getListAccessAction_1_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_8=(Token)match(input,79,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_8, grammarAccess.getSymbolRefAccessModifierAccess().getLeftSquareBracketKeyword_1_1());
                      			
                    }
                    // InternalMuLE.g:3867:4: ( (lv_index_9_0= ruleExpression ) )
                    // InternalMuLE.g:3868:5: (lv_index_9_0= ruleExpression )
                    {
                    // InternalMuLE.g:3868:5: (lv_index_9_0= ruleExpression )
                    // InternalMuLE.g:3869:6: lv_index_9_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getIndexExpressionParserRuleCall_1_2_0());
                      					
                    }
                    pushFollow(FOLLOW_74);
                    lv_index_9_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                      						}
                      						set(
                      							current,
                      							"index",
                      							lv_index_9_0,
                      							"de.ubt.ai1.mule.MuLE.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    otherlv_10=(Token)match(input,80,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_10, grammarAccess.getSymbolRefAccessModifierAccess().getRightSquareBracketKeyword_1_3());
                      			
                    }
                    // InternalMuLE.g:3890:4: ( (lv_accessModifier_11_0= ruleSymbolRefAccessModifier ) )?
                    int alt70=2;
                    int LA70_0 = input.LA(1);

                    if ( (LA70_0==29||LA70_0==79||LA70_0==81) ) {
                        alt70=1;
                    }
                    switch (alt70) {
                        case 1 :
                            // InternalMuLE.g:3891:5: (lv_accessModifier_11_0= ruleSymbolRefAccessModifier )
                            {
                            // InternalMuLE.g:3891:5: (lv_accessModifier_11_0= ruleSymbolRefAccessModifier )
                            // InternalMuLE.g:3892:6: lv_accessModifier_11_0= ruleSymbolRefAccessModifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierSymbolRefAccessModifierParserRuleCall_1_4_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_accessModifier_11_0=ruleSymbolRefAccessModifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                              						}
                              						set(
                              							current,
                              							"accessModifier",
                              							lv_accessModifier_11_0,
                              							"de.ubt.ai1.mule.MuLE.SymbolRefAccessModifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


                    }


                    }
                    break;
                case 3 :
                    // InternalMuLE.g:3911:3: ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? )
                    {
                    // InternalMuLE.g:3911:3: ( () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )? )
                    // InternalMuLE.g:3912:4: () otherlv_13= '@' ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )?
                    {
                    // InternalMuLE.g:3912:4: ()
                    // InternalMuLE.g:3913:5: 
                    {
                    if ( state.backtracking==0 ) {

                      					current = forceCreateModelElement(
                      						grammarAccess.getSymbolRefAccessModifierAccess().getDereferenceAction_2_0(),
                      						current);
                      				
                    }

                    }

                    otherlv_13=(Token)match(input,81,FOLLOW_73); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      				newLeafNode(otherlv_13, grammarAccess.getSymbolRefAccessModifierAccess().getCommercialAtKeyword_2_1());
                      			
                    }
                    // InternalMuLE.g:3923:4: ( (lv_accessModifier_14_0= ruleSymbolRefAccessModifier ) )?
                    int alt71=2;
                    int LA71_0 = input.LA(1);

                    if ( (LA71_0==29||LA71_0==79||LA71_0==81) ) {
                        alt71=1;
                    }
                    switch (alt71) {
                        case 1 :
                            // InternalMuLE.g:3924:5: (lv_accessModifier_14_0= ruleSymbolRefAccessModifier )
                            {
                            // InternalMuLE.g:3924:5: (lv_accessModifier_14_0= ruleSymbolRefAccessModifier )
                            // InternalMuLE.g:3925:6: lv_accessModifier_14_0= ruleSymbolRefAccessModifier
                            {
                            if ( state.backtracking==0 ) {

                              						newCompositeNode(grammarAccess.getSymbolRefAccessModifierAccess().getAccessModifierSymbolRefAccessModifierParserRuleCall_2_2_0());
                              					
                            }
                            pushFollow(FOLLOW_2);
                            lv_accessModifier_14_0=ruleSymbolRefAccessModifier();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              						if (current==null) {
                              							current = createModelElementForParent(grammarAccess.getSymbolRefAccessModifierRule());
                              						}
                              						set(
                              							current,
                              							"accessModifier",
                              							lv_accessModifier_14_0,
                              							"de.ubt.ai1.mule.MuLE.SymbolRefAccessModifier");
                              						afterParserOrEnumRuleCall();
                              					
                            }

                            }


                            }
                            break;

                    }


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
    // $ANTLR end "ruleSymbolRefAccessModifier"


    // $ANTLR start "entryRuleSymbolRefCompositionInit"
    // InternalMuLE.g:3947:1: entryRuleSymbolRefCompositionInit returns [EObject current=null] : iv_ruleSymbolRefCompositionInit= ruleSymbolRefCompositionInit EOF ;
    public final EObject entryRuleSymbolRefCompositionInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolRefCompositionInit = null;


        try {
            // InternalMuLE.g:3947:65: (iv_ruleSymbolRefCompositionInit= ruleSymbolRefCompositionInit EOF )
            // InternalMuLE.g:3948:2: iv_ruleSymbolRefCompositionInit= ruleSymbolRefCompositionInit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSymbolRefCompositionInitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSymbolRefCompositionInit=ruleSymbolRefCompositionInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSymbolRefCompositionInit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSymbolRefCompositionInit"


    // $ANTLR start "ruleSymbolRefCompositionInit"
    // InternalMuLE.g:3954:1: ruleSymbolRefCompositionInit returns [EObject current=null] : ( () otherlv_1= '{' ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )? otherlv_5= '}' ) ;
    public final EObject ruleSymbolRefCompositionInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_3=null;
        Token otherlv_5=null;
        EObject lv_attributes_2_0 = null;

        EObject lv_attributes_4_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:3960:2: ( ( () otherlv_1= '{' ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )? otherlv_5= '}' ) )
            // InternalMuLE.g:3961:2: ( () otherlv_1= '{' ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )? otherlv_5= '}' )
            {
            // InternalMuLE.g:3961:2: ( () otherlv_1= '{' ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )? otherlv_5= '}' )
            // InternalMuLE.g:3962:3: () otherlv_1= '{' ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )? otherlv_5= '}'
            {
            // InternalMuLE.g:3962:3: ()
            // InternalMuLE.g:3963:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getSymbolRefCompositionInitAccess().getSymbolRefCompositionInitAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,82,FOLLOW_75); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSymbolRefCompositionInitAccess().getLeftCurlyBracketKeyword_1());
              		
            }
            // InternalMuLE.g:3973:3: ( ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )* )?
            int alt74=2;
            int LA74_0 = input.LA(1);

            if ( (LA74_0==RULE_ID) ) {
                alt74=1;
            }
            switch (alt74) {
                case 1 :
                    // InternalMuLE.g:3974:4: ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) ) (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )*
                    {
                    // InternalMuLE.g:3974:4: ( (lv_attributes_2_0= ruleSymbolRefCompositionAttribute ) )
                    // InternalMuLE.g:3975:5: (lv_attributes_2_0= ruleSymbolRefCompositionAttribute )
                    {
                    // InternalMuLE.g:3975:5: (lv_attributes_2_0= ruleSymbolRefCompositionAttribute )
                    // InternalMuLE.g:3976:6: lv_attributes_2_0= ruleSymbolRefCompositionAttribute
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getSymbolRefCompositionInitAccess().getAttributesSymbolRefCompositionAttributeParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_76);
                    lv_attributes_2_0=ruleSymbolRefCompositionAttribute();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getSymbolRefCompositionInitRule());
                      						}
                      						add(
                      							current,
                      							"attributes",
                      							lv_attributes_2_0,
                      							"de.ubt.ai1.mule.MuLE.SymbolRefCompositionAttribute");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:3993:4: (otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) ) )*
                    loop73:
                    do {
                        int alt73=2;
                        int LA73_0 = input.LA(1);

                        if ( (LA73_0==20) ) {
                            alt73=1;
                        }


                        switch (alt73) {
                    	case 1 :
                    	    // InternalMuLE.g:3994:5: otherlv_3= ',' ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) )
                    	    {
                    	    otherlv_3=(Token)match(input,20,FOLLOW_3); if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      					newLeafNode(otherlv_3, grammarAccess.getSymbolRefCompositionInitAccess().getCommaKeyword_2_1_0());
                    	      				
                    	    }
                    	    // InternalMuLE.g:3998:5: ( (lv_attributes_4_0= ruleSymbolRefCompositionAttribute ) )
                    	    // InternalMuLE.g:3999:6: (lv_attributes_4_0= ruleSymbolRefCompositionAttribute )
                    	    {
                    	    // InternalMuLE.g:3999:6: (lv_attributes_4_0= ruleSymbolRefCompositionAttribute )
                    	    // InternalMuLE.g:4000:7: lv_attributes_4_0= ruleSymbolRefCompositionAttribute
                    	    {
                    	    if ( state.backtracking==0 ) {

                    	      							newCompositeNode(grammarAccess.getSymbolRefCompositionInitAccess().getAttributesSymbolRefCompositionAttributeParserRuleCall_2_1_1_0());
                    	      						
                    	    }
                    	    pushFollow(FOLLOW_76);
                    	    lv_attributes_4_0=ruleSymbolRefCompositionAttribute();

                    	    state._fsp--;
                    	    if (state.failed) return current;
                    	    if ( state.backtracking==0 ) {

                    	      							if (current==null) {
                    	      								current = createModelElementForParent(grammarAccess.getSymbolRefCompositionInitRule());
                    	      							}
                    	      							add(
                    	      								current,
                    	      								"attributes",
                    	      								lv_attributes_4_0,
                    	      								"de.ubt.ai1.mule.MuLE.SymbolRefCompositionAttribute");
                    	      							afterParserOrEnumRuleCall();
                    	      						
                    	    }

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop73;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,83,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_5, grammarAccess.getSymbolRefCompositionInitAccess().getRightCurlyBracketKeyword_3());
              		
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
    // $ANTLR end "ruleSymbolRefCompositionInit"


    // $ANTLR start "entryRuleSymbolRefCompositionAttribute"
    // InternalMuLE.g:4027:1: entryRuleSymbolRefCompositionAttribute returns [EObject current=null] : iv_ruleSymbolRefCompositionAttribute= ruleSymbolRefCompositionAttribute EOF ;
    public final EObject entryRuleSymbolRefCompositionAttribute() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSymbolRefCompositionAttribute = null;


        try {
            // InternalMuLE.g:4027:70: (iv_ruleSymbolRefCompositionAttribute= ruleSymbolRefCompositionAttribute EOF )
            // InternalMuLE.g:4028:2: iv_ruleSymbolRefCompositionAttribute= ruleSymbolRefCompositionAttribute EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getSymbolRefCompositionAttributeRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleSymbolRefCompositionAttribute=ruleSymbolRefCompositionAttribute();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleSymbolRefCompositionAttribute; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleSymbolRefCompositionAttribute"


    // $ANTLR start "ruleSymbolRefCompositionAttribute"
    // InternalMuLE.g:4034:1: ruleSymbolRefCompositionAttribute returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleSymbolRefCompositionAttribute() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:4040:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalMuLE.g:4041:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalMuLE.g:4041:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) ) )
            // InternalMuLE.g:4042:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '=' ( (lv_expression_2_0= ruleExpression ) )
            {
            // InternalMuLE.g:4042:3: ( (otherlv_0= RULE_ID ) )
            // InternalMuLE.g:4043:4: (otherlv_0= RULE_ID )
            {
            // InternalMuLE.g:4043:4: (otherlv_0= RULE_ID )
            // InternalMuLE.g:4044:5: otherlv_0= RULE_ID
            {
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElement(grammarAccess.getSymbolRefCompositionAttributeRule());
              					}
              				
            }
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_77); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					newLeafNode(otherlv_0, grammarAccess.getSymbolRefCompositionAttributeAccess().getAttributeAttributeCrossReference_0_0());
              				
            }

            }


            }

            otherlv_1=(Token)match(input,62,FOLLOW_43); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getSymbolRefCompositionAttributeAccess().getEqualsSignKeyword_1());
              		
            }
            // InternalMuLE.g:4059:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalMuLE.g:4060:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalMuLE.g:4060:4: (lv_expression_2_0= ruleExpression )
            // InternalMuLE.g:4061:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getSymbolRefCompositionAttributeAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getSymbolRefCompositionAttributeRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
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
    // $ANTLR end "ruleSymbolRefCompositionAttribute"


    // $ANTLR start "entryRuleListInit"
    // InternalMuLE.g:4082:1: entryRuleListInit returns [EObject current=null] : iv_ruleListInit= ruleListInit EOF ;
    public final EObject entryRuleListInit() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListInit = null;


        try {
            // InternalMuLE.g:4082:49: (iv_ruleListInit= ruleListInit EOF )
            // InternalMuLE.g:4083:2: iv_ruleListInit= ruleListInit EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListInitRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListInit=ruleListInit();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListInit; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleListInit"


    // $ANTLR start "ruleListInit"
    // InternalMuLE.g:4089:1: ruleListInit returns [EObject current=null] : ( () otherlv_1= '[' ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )? otherlv_4= ']' ) ;
    public final EObject ruleListInit() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        Token otherlv_4=null;
        EObject lv_left_2_0 = null;

        EObject lv_right_3_1 = null;

        EObject lv_right_3_2 = null;



        	enterRule();

        try {
            // InternalMuLE.g:4095:2: ( ( () otherlv_1= '[' ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )? otherlv_4= ']' ) )
            // InternalMuLE.g:4096:2: ( () otherlv_1= '[' ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )? otherlv_4= ']' )
            {
            // InternalMuLE.g:4096:2: ( () otherlv_1= '[' ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )? otherlv_4= ']' )
            // InternalMuLE.g:4097:3: () otherlv_1= '[' ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )? otherlv_4= ']'
            {
            // InternalMuLE.g:4097:3: ()
            // InternalMuLE.g:4098:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListInitAccess().getListInitAction_0(),
              					current);
              			
            }

            }

            otherlv_1=(Token)match(input,79,FOLLOW_78); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_1, grammarAccess.getListInitAccess().getLeftSquareBracketKeyword_1());
              		
            }
            // InternalMuLE.g:4108:3: ( ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) ) )?
            int alt76=2;
            int LA76_0 = input.LA(1);

            if ( ((LA76_0>=RULE_ID && LA76_0<=RULE_RATIONAL)||LA76_0==26||(LA76_0>=28 && LA76_0<=29)||(LA76_0>=66 && LA76_0<=67)||(LA76_0>=74 && LA76_0<=79)) ) {
                alt76=1;
            }
            switch (alt76) {
                case 1 :
                    // InternalMuLE.g:4109:4: ( (lv_left_2_0= ruleExpression ) ) ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) )
                    {
                    // InternalMuLE.g:4109:4: ( (lv_left_2_0= ruleExpression ) )
                    // InternalMuLE.g:4110:5: (lv_left_2_0= ruleExpression )
                    {
                    // InternalMuLE.g:4110:5: (lv_left_2_0= ruleExpression )
                    // InternalMuLE.g:4111:6: lv_left_2_0= ruleExpression
                    {
                    if ( state.backtracking==0 ) {

                      						newCompositeNode(grammarAccess.getListInitAccess().getLeftExpressionParserRuleCall_2_0_0());
                      					
                    }
                    pushFollow(FOLLOW_79);
                    lv_left_2_0=ruleExpression();

                    state._fsp--;
                    if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElementForParent(grammarAccess.getListInitRule());
                      						}
                      						set(
                      							current,
                      							"left",
                      							lv_left_2_0,
                      							"de.ubt.ai1.mule.MuLE.Expression");
                      						afterParserOrEnumRuleCall();
                      					
                    }

                    }


                    }

                    // InternalMuLE.g:4128:4: ( ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) ) )
                    // InternalMuLE.g:4129:5: ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) )
                    {
                    // InternalMuLE.g:4129:5: ( (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements ) )
                    // InternalMuLE.g:4130:6: (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements )
                    {
                    // InternalMuLE.g:4130:6: (lv_right_3_1= ruleListInitFunction | lv_right_3_2= ruleListInitElements )
                    int alt75=2;
                    int LA75_0 = input.LA(1);

                    if ( ((LA75_0>=84 && LA75_0<=85)) ) {
                        alt75=1;
                    }
                    else if ( (LA75_0==EOF||LA75_0==20||LA75_0==80) ) {
                        alt75=2;
                    }
                    else {
                        if (state.backtracking>0) {state.failed=true; return current;}
                        NoViableAltException nvae =
                            new NoViableAltException("", 75, 0, input);

                        throw nvae;
                    }
                    switch (alt75) {
                        case 1 :
                            // InternalMuLE.g:4131:7: lv_right_3_1= ruleListInitFunction
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getListInitAccess().getRightListInitFunctionParserRuleCall_2_1_0_0());
                              						
                            }
                            pushFollow(FOLLOW_74);
                            lv_right_3_1=ruleListInitFunction();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getListInitRule());
                              							}
                              							set(
                              								current,
                              								"right",
                              								lv_right_3_1,
                              								"de.ubt.ai1.mule.MuLE.ListInitFunction");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;
                        case 2 :
                            // InternalMuLE.g:4147:7: lv_right_3_2= ruleListInitElements
                            {
                            if ( state.backtracking==0 ) {

                              							newCompositeNode(grammarAccess.getListInitAccess().getRightListInitElementsParserRuleCall_2_1_0_1());
                              						
                            }
                            pushFollow(FOLLOW_74);
                            lv_right_3_2=ruleListInitElements();

                            state._fsp--;
                            if (state.failed) return current;
                            if ( state.backtracking==0 ) {

                              							if (current==null) {
                              								current = createModelElementForParent(grammarAccess.getListInitRule());
                              							}
                              							set(
                              								current,
                              								"right",
                              								lv_right_3_2,
                              								"de.ubt.ai1.mule.MuLE.ListInitElements");
                              							afterParserOrEnumRuleCall();
                              						
                            }

                            }
                            break;

                    }


                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,80,FOLLOW_2); if (state.failed) return current;
            if ( state.backtracking==0 ) {

              			newLeafNode(otherlv_4, grammarAccess.getListInitAccess().getRightSquareBracketKeyword_3());
              		
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
    // $ANTLR end "ruleListInit"


    // $ANTLR start "entryRuleListInitFunction"
    // InternalMuLE.g:4174:1: entryRuleListInitFunction returns [EObject current=null] : iv_ruleListInitFunction= ruleListInitFunction EOF ;
    public final EObject entryRuleListInitFunction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListInitFunction = null;


        try {
            // InternalMuLE.g:4174:57: (iv_ruleListInitFunction= ruleListInitFunction EOF )
            // InternalMuLE.g:4175:2: iv_ruleListInitFunction= ruleListInitFunction EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListInitFunctionRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListInitFunction=ruleListInitFunction();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListInitFunction; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleListInitFunction"


    // $ANTLR start "ruleListInitFunction"
    // InternalMuLE.g:4181:1: ruleListInitFunction returns [EObject current=null] : ( () ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) ) ( (lv_expression_2_0= ruleExpression ) ) ) ;
    public final EObject ruleListInitFunction() throws RecognitionException {
        EObject current = null;

        Token lv_op_1_1=null;
        Token lv_op_1_2=null;
        EObject lv_expression_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:4187:2: ( ( () ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) ) ( (lv_expression_2_0= ruleExpression ) ) ) )
            // InternalMuLE.g:4188:2: ( () ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) ) ( (lv_expression_2_0= ruleExpression ) ) )
            {
            // InternalMuLE.g:4188:2: ( () ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) ) ( (lv_expression_2_0= ruleExpression ) ) )
            // InternalMuLE.g:4189:3: () ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) ) ( (lv_expression_2_0= ruleExpression ) )
            {
            // InternalMuLE.g:4189:3: ()
            // InternalMuLE.g:4190:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListInitFunctionAccess().getListInitFunctionAction_0(),
              					current);
              			
            }

            }

            // InternalMuLE.g:4196:3: ( ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) ) )
            // InternalMuLE.g:4197:4: ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) )
            {
            // InternalMuLE.g:4197:4: ( (lv_op_1_1= '**' | lv_op_1_2= '..' ) )
            // InternalMuLE.g:4198:5: (lv_op_1_1= '**' | lv_op_1_2= '..' )
            {
            // InternalMuLE.g:4198:5: (lv_op_1_1= '**' | lv_op_1_2= '..' )
            int alt77=2;
            int LA77_0 = input.LA(1);

            if ( (LA77_0==84) ) {
                alt77=1;
            }
            else if ( (LA77_0==85) ) {
                alt77=2;
            }
            else {
                if (state.backtracking>0) {state.failed=true; return current;}
                NoViableAltException nvae =
                    new NoViableAltException("", 77, 0, input);

                throw nvae;
            }
            switch (alt77) {
                case 1 :
                    // InternalMuLE.g:4199:6: lv_op_1_1= '**'
                    {
                    lv_op_1_1=(Token)match(input,84,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_1, grammarAccess.getListInitFunctionAccess().getOpAsteriskAsteriskKeyword_1_0_0());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getListInitFunctionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_1_1, null);
                      					
                    }

                    }
                    break;
                case 2 :
                    // InternalMuLE.g:4210:6: lv_op_1_2= '..'
                    {
                    lv_op_1_2=(Token)match(input,85,FOLLOW_43); if (state.failed) return current;
                    if ( state.backtracking==0 ) {

                      						newLeafNode(lv_op_1_2, grammarAccess.getListInitFunctionAccess().getOpFullStopFullStopKeyword_1_0_1());
                      					
                    }
                    if ( state.backtracking==0 ) {

                      						if (current==null) {
                      							current = createModelElement(grammarAccess.getListInitFunctionRule());
                      						}
                      						setWithLastConsumed(current, "op", lv_op_1_2, null);
                      					
                    }

                    }
                    break;

            }


            }


            }

            // InternalMuLE.g:4223:3: ( (lv_expression_2_0= ruleExpression ) )
            // InternalMuLE.g:4224:4: (lv_expression_2_0= ruleExpression )
            {
            // InternalMuLE.g:4224:4: (lv_expression_2_0= ruleExpression )
            // InternalMuLE.g:4225:5: lv_expression_2_0= ruleExpression
            {
            if ( state.backtracking==0 ) {

              					newCompositeNode(grammarAccess.getListInitFunctionAccess().getExpressionExpressionParserRuleCall_2_0());
              				
            }
            pushFollow(FOLLOW_2);
            lv_expression_2_0=ruleExpression();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {

              					if (current==null) {
              						current = createModelElementForParent(grammarAccess.getListInitFunctionRule());
              					}
              					set(
              						current,
              						"expression",
              						lv_expression_2_0,
              						"de.ubt.ai1.mule.MuLE.Expression");
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
    // $ANTLR end "ruleListInitFunction"


    // $ANTLR start "entryRuleListInitElements"
    // InternalMuLE.g:4246:1: entryRuleListInitElements returns [EObject current=null] : iv_ruleListInitElements= ruleListInitElements EOF ;
    public final EObject entryRuleListInitElements() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleListInitElements = null;


        try {
            // InternalMuLE.g:4246:57: (iv_ruleListInitElements= ruleListInitElements EOF )
            // InternalMuLE.g:4247:2: iv_ruleListInitElements= ruleListInitElements EOF
            {
            if ( state.backtracking==0 ) {
               newCompositeNode(grammarAccess.getListInitElementsRule()); 
            }
            pushFollow(FOLLOW_1);
            iv_ruleListInitElements=ruleListInitElements();

            state._fsp--;
            if (state.failed) return current;
            if ( state.backtracking==0 ) {
               current =iv_ruleListInitElements; 
            }
            match(input,EOF,FOLLOW_2); if (state.failed) return current;

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
    // $ANTLR end "entryRuleListInitElements"


    // $ANTLR start "ruleListInitElements"
    // InternalMuLE.g:4253:1: ruleListInitElements returns [EObject current=null] : ( () (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )* ) ;
    public final EObject ruleListInitElements() throws RecognitionException {
        EObject current = null;

        Token otherlv_1=null;
        EObject lv_elements_2_0 = null;



        	enterRule();

        try {
            // InternalMuLE.g:4259:2: ( ( () (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )* ) )
            // InternalMuLE.g:4260:2: ( () (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )* )
            {
            // InternalMuLE.g:4260:2: ( () (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )* )
            // InternalMuLE.g:4261:3: () (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )*
            {
            // InternalMuLE.g:4261:3: ()
            // InternalMuLE.g:4262:4: 
            {
            if ( state.backtracking==0 ) {

              				current = forceCreateModelElement(
              					grammarAccess.getListInitElementsAccess().getListInitElementsAction_0(),
              					current);
              			
            }

            }

            // InternalMuLE.g:4268:3: (otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) ) )*
            loop78:
            do {
                int alt78=2;
                int LA78_0 = input.LA(1);

                if ( (LA78_0==20) ) {
                    alt78=1;
                }


                switch (alt78) {
            	case 1 :
            	    // InternalMuLE.g:4269:4: otherlv_1= ',' ( (lv_elements_2_0= ruleExpression ) )
            	    {
            	    otherlv_1=(Token)match(input,20,FOLLOW_43); if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      				newLeafNode(otherlv_1, grammarAccess.getListInitElementsAccess().getCommaKeyword_1_0());
            	      			
            	    }
            	    // InternalMuLE.g:4273:4: ( (lv_elements_2_0= ruleExpression ) )
            	    // InternalMuLE.g:4274:5: (lv_elements_2_0= ruleExpression )
            	    {
            	    // InternalMuLE.g:4274:5: (lv_elements_2_0= ruleExpression )
            	    // InternalMuLE.g:4275:6: lv_elements_2_0= ruleExpression
            	    {
            	    if ( state.backtracking==0 ) {

            	      						newCompositeNode(grammarAccess.getListInitElementsAccess().getElementsExpressionParserRuleCall_1_1_0());
            	      					
            	    }
            	    pushFollow(FOLLOW_80);
            	    lv_elements_2_0=ruleExpression();

            	    state._fsp--;
            	    if (state.failed) return current;
            	    if ( state.backtracking==0 ) {

            	      						if (current==null) {
            	      							current = createModelElementForParent(grammarAccess.getListInitElementsRule());
            	      						}
            	      						add(
            	      							current,
            	      							"elements",
            	      							lv_elements_2_0,
            	      							"de.ubt.ai1.mule.MuLE.Expression");
            	      						afterParserOrEnumRuleCall();
            	      					
            	    }

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop78;
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
    // $ANTLR end "ruleListInitElements"

    // $ANTLR start synpred1_InternalMuLE
    public final void synpred1_InternalMuLE_fragment() throws RecognitionException {   
        // InternalMuLE.g:1885:4: ( ( ruleExpression ) )
        // InternalMuLE.g:1885:5: ( ruleExpression )
        {
        // InternalMuLE.g:1885:5: ( ruleExpression )
        // InternalMuLE.g:1886:5: ruleExpression
        {
        pushFollow(FOLLOW_2);
        ruleExpression();

        state._fsp--;
        if (state.failed) return ;

        }


        }
    }
    // $ANTLR end synpred1_InternalMuLE

    // $ANTLR start synpred2_InternalMuLE
    public final void synpred2_InternalMuLE_fragment() throws RecognitionException {   
        // InternalMuLE.g:2210:5: ( 'else' )
        // InternalMuLE.g:2210:6: 'else'
        {
        match(input,52,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred2_InternalMuLE

    // $ANTLR start synpred3_InternalMuLE
    public final void synpred3_InternalMuLE_fragment() throws RecognitionException {   
        // InternalMuLE.g:2414:5: ( 'else' )
        // InternalMuLE.g:2414:6: 'else'
        {
        match(input,52,FOLLOW_2); if (state.failed) return ;

        }
    }
    // $ANTLR end synpred3_InternalMuLE

    // Delegated rules

    public final boolean synpred3_InternalMuLE() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred3_InternalMuLE_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred2_InternalMuLE() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred2_InternalMuLE_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }
    public final boolean synpred1_InternalMuLE() {
        state.backtracking++;
        int start = input.mark();
        try {
            synpred1_InternalMuLE_fragment(); // can never throw exception
        } catch (RecognitionException re) {
            System.err.println("impossible: "+re);
        }
        boolean success = !state.failed;
        input.rewind(start);
        state.backtracking--;
        state.failed=false;
        return success;
    }


    protected DFA37 dfa37 = new DFA37(this);
    protected DFA40 dfa40 = new DFA40(this);
    static final String dfa_1s = "\4\uffff";
    static final String dfa_2s = "\1\3\1\uffff\1\3\1\uffff";
    static final String dfa_3s = "\1\4\1\uffff\1\4\1\uffff";
    static final String dfa_4s = "\1\116\1\uffff\1\122\1\uffff";
    static final String dfa_5s = "\1\uffff\1\1\1\uffff\1\2";
    static final String dfa_6s = "\4\uffff}>";
    static final String[] dfa_7s = {
            "\1\2\14\uffff\1\3\12\uffff\1\3\3\uffff\3\3\1\uffff\2\3\4\uffff\1\3\4\1\1\uffff\1\1\1\uffff\1\1\4\uffff\1\1\26\uffff\1\1",
            "",
            "\1\2\12\uffff\1\1\1\uffff\1\3\12\uffff\1\3\1\1\2\uffff\3\3\2\uffff\1\3\1\uffff\1\3\2\uffff\1\3\6\1\1\uffff\1\1\4\uffff\1\1\26\uffff\2\1\1\uffff\2\1",
            ""
    };

    static final short[] dfa_1 = DFA.unpackEncodedString(dfa_1s);
    static final short[] dfa_2 = DFA.unpackEncodedString(dfa_2s);
    static final char[] dfa_3 = DFA.unpackEncodedStringToUnsignedChars(dfa_3s);
    static final char[] dfa_4 = DFA.unpackEncodedStringToUnsignedChars(dfa_4s);
    static final short[] dfa_5 = DFA.unpackEncodedString(dfa_5s);
    static final short[] dfa_6 = DFA.unpackEncodedString(dfa_6s);
    static final short[][] dfa_7 = unpackEncodedStringArray(dfa_7s);

    class DFA37 extends DFA {

        public DFA37(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 37;
            this.eot = dfa_1;
            this.eof = dfa_2;
            this.min = dfa_3;
            this.max = dfa_4;
            this.accept = dfa_5;
            this.special = dfa_6;
            this.transition = dfa_7;
        }
        public String getDescription() {
            return "1703:3: ( ( (lv_block_12_0= ruleBlock ) ) otherlv_13= 'endoperation' )?";
        }
    }
    static final String dfa_8s = "\23\uffff";
    static final String dfa_9s = "\1\20\22\uffff";
    static final String dfa_10s = "\1\4\1\0\1\17\16\uffff\1\4\1\0";
    static final String dfa_11s = "\1\117\1\0\1\17\16\uffff\1\4\1\0";
    static final String dfa_12s = "\3\uffff\15\1\1\2\2\uffff";
    static final String dfa_13s = "\1\1\1\0\20\uffff\1\2}>";
    static final String[] dfa_14s = {
            "\1\1\1\3\1\4\1\5\12\uffff\1\20\7\uffff\1\14\1\uffff\1\17\1\15\15\uffff\4\20\1\uffff\3\20\1\uffff\4\20\2\uffff\2\20\6\uffff\1\11\1\12\6\uffff\1\6\1\7\1\10\1\13\1\2\1\16",
            "\1\uffff",
            "\1\21",
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
            "",
            "",
            "",
            "\1\22",
            "\1\uffff"
    };

    static final short[] dfa_8 = DFA.unpackEncodedString(dfa_8s);
    static final short[] dfa_9 = DFA.unpackEncodedString(dfa_9s);
    static final char[] dfa_10 = DFA.unpackEncodedStringToUnsignedChars(dfa_10s);
    static final char[] dfa_11 = DFA.unpackEncodedStringToUnsignedChars(dfa_11s);
    static final short[] dfa_12 = DFA.unpackEncodedString(dfa_12s);
    static final short[] dfa_13 = DFA.unpackEncodedString(dfa_13s);
    static final short[][] dfa_14 = unpackEncodedStringArray(dfa_14s);

    class DFA40 extends DFA {

        public DFA40(BaseRecognizer recognizer) {
            this.recognizer = recognizer;
            this.decisionNumber = 40;
            this.eot = dfa_8;
            this.eof = dfa_9;
            this.min = dfa_10;
            this.max = dfa_11;
            this.accept = dfa_12;
            this.special = dfa_13;
            this.transition = dfa_14;
        }
        public String getDescription() {
            return "1884:3: ( ( ( ruleExpression ) )=> (lv_expression_2_0= ruleExpression ) )?";
        }
        public int specialStateTransition(int s, IntStream _input) throws NoViableAltException {
            TokenStream input = (TokenStream)_input;
        	int _s = s;
            switch ( s ) {
                    case 0 : 
                        int LA40_1 = input.LA(1);

                         
                        int index40_1 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalMuLE()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index40_1);
                        if ( s>=0 ) return s;
                        break;
                    case 1 : 
                        int LA40_0 = input.LA(1);

                         
                        int index40_0 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (LA40_0==RULE_ID) ) {s = 1;}

                        else if ( (LA40_0==78) ) {s = 2;}

                        else if ( (LA40_0==RULE_STRING) && (synpred1_InternalMuLE())) {s = 3;}

                        else if ( (LA40_0==RULE_INTEGER) && (synpred1_InternalMuLE())) {s = 4;}

                        else if ( (LA40_0==RULE_RATIONAL) && (synpred1_InternalMuLE())) {s = 5;}

                        else if ( (LA40_0==74) && (synpred1_InternalMuLE())) {s = 6;}

                        else if ( (LA40_0==75) && (synpred1_InternalMuLE())) {s = 7;}

                        else if ( (LA40_0==76) && (synpred1_InternalMuLE())) {s = 8;}

                        else if ( (LA40_0==66) && (synpred1_InternalMuLE())) {s = 9;}

                        else if ( (LA40_0==67) && (synpred1_InternalMuLE())) {s = 10;}

                        else if ( (LA40_0==77) && (synpred1_InternalMuLE())) {s = 11;}

                        else if ( (LA40_0==26) && (synpred1_InternalMuLE())) {s = 12;}

                        else if ( (LA40_0==29) && (synpred1_InternalMuLE())) {s = 13;}

                        else if ( (LA40_0==79) && (synpred1_InternalMuLE())) {s = 14;}

                        else if ( (LA40_0==28) && (synpred1_InternalMuLE())) {s = 15;}

                        else if ( (LA40_0==EOF||LA40_0==18||(LA40_0>=43 && LA40_0<=46)||(LA40_0>=48 && LA40_0<=50)||(LA40_0>=52 && LA40_0<=55)||(LA40_0>=58 && LA40_0<=59)) ) {s = 16;}

                         
                        input.seek(index40_0);
                        if ( s>=0 ) return s;
                        break;
                    case 2 : 
                        int LA40_18 = input.LA(1);

                         
                        int index40_18 = input.index();
                        input.rewind();
                        s = -1;
                        if ( (synpred1_InternalMuLE()) ) {s = 15;}

                        else if ( (true) ) {s = 16;}

                         
                        input.seek(index40_18);
                        if ( s>=0 ) return s;
                        break;
            }
            if (state.backtracking>0) {state.failed=true; return -1;}
            NoViableAltException nvae =
                new NoViableAltException(getDescription(), 40, _s, input);
            error(nvae);
            throw nvae;
        }
    }
 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000042710030012L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000042710020012L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0085700000040010L,0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000080002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000000001FC00010L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000300000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000080000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x000000005FC00010L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000040100000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000080000002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000400000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000001000100000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000002400000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000080080000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000002700000010L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x000005B710000010L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000053710080010L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000053710000010L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000043710000010L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000008000000002L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000002310000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000002010000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000020040000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000020000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0085780080000012L,0x0000000000004000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0085780000000012L,0x0000000000004000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0085700000000012L,0x0000000000004000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x00000000340000F2L,0x000000000000FC0CL});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000800000000002L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x00000000340000F0L,0x000000000000FC0CL});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0087700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0002000000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0008000000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x00F5700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_48 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_49 = new BitSet(new long[]{0x00A5700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_50 = new BitSet(new long[]{0x0020000000000000L});
    public static final BitSet FOLLOW_51 = new BitSet(new long[]{0x0085700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_52 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_53 = new BitSet(new long[]{0x0100000000000000L});
    public static final BitSet FOLLOW_54 = new BitSet(new long[]{0x0200000000000000L});
    public static final BitSet FOLLOW_55 = new BitSet(new long[]{0x0C95700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_56 = new BitSet(new long[]{0x0C10000000000000L});
    public static final BitSet FOLLOW_57 = new BitSet(new long[]{0x0485700000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_58 = new BitSet(new long[]{0x0400000000000000L});
    public static final BitSet FOLLOW_59 = new BitSet(new long[]{0x1000000000000002L});
    public static final BitSet FOLLOW_60 = new BitSet(new long[]{0x2000000000000002L});
    public static final BitSet FOLLOW_61 = new BitSet(new long[]{0xC000000000000002L});
    public static final BitSet FOLLOW_62 = new BitSet(new long[]{0x0000000000280002L,0x0000000000000003L});
    public static final BitSet FOLLOW_63 = new BitSet(new long[]{0x0000000000000002L,0x000000000000001CL});
    public static final BitSet FOLLOW_64 = new BitSet(new long[]{0x0000000000000002L,0x00000000000001E0L});
    public static final BitSet FOLLOW_65 = new BitSet(new long[]{0x0000000000000002L,0x0000000000000200L});
    public static final BitSet FOLLOW_66 = new BitSet(new long[]{0x0000000040000000L});
    public static final BitSet FOLLOW_67 = new BitSet(new long[]{0x0085780080000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_68 = new BitSet(new long[]{0x0085780000000010L,0x0000000000004000L});
    public static final BitSet FOLLOW_69 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_70 = new BitSet(new long[]{0x0000000020008002L,0x0000000000068000L});
    public static final BitSet FOLLOW_71 = new BitSet(new long[]{0x0000000020008002L,0x0000000000028000L});
    public static final BitSet FOLLOW_72 = new BitSet(new long[]{0x00000000740000F0L,0x000000000000FC0CL});
    public static final BitSet FOLLOW_73 = new BitSet(new long[]{0x0000000020000002L,0x0000000000028000L});
    public static final BitSet FOLLOW_74 = new BitSet(new long[]{0x0000000000000000L,0x0000000000010000L});
    public static final BitSet FOLLOW_75 = new BitSet(new long[]{0x0000000000000010L,0x0000000000080000L});
    public static final BitSet FOLLOW_76 = new BitSet(new long[]{0x0000000000100000L,0x0000000000080000L});
    public static final BitSet FOLLOW_77 = new BitSet(new long[]{0x4000000000000000L});
    public static final BitSet FOLLOW_78 = new BitSet(new long[]{0x00000000340000F0L,0x000000000001FC0CL});
    public static final BitSet FOLLOW_79 = new BitSet(new long[]{0x0000000000100000L,0x0000000000310000L});
    public static final BitSet FOLLOW_80 = new BitSet(new long[]{0x0000000000100002L});

}