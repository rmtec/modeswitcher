package org.xtext.mdsl.parser.antlr.internal;

import org.eclipse.xtext.*;
import org.eclipse.xtext.parser.*;
import org.eclipse.xtext.parser.impl.*;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.common.util.Enumerator;
import org.eclipse.xtext.parser.antlr.AbstractInternalAntlrParser;
import org.eclipse.xtext.parser.antlr.XtextTokenStream;
import org.eclipse.xtext.parser.antlr.XtextTokenStream.HiddenTokens;
import org.eclipse.xtext.parser.antlr.AntlrDatatypeRuleToken;
import org.xtext.mdsl.services.MdslGrammarAccess;



import org.antlr.runtime.*;
import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

@SuppressWarnings("all")
public class InternalMdslParser extends AbstractInternalAntlrParser {
    public static final String[] tokenNames = new String[] {
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'System'", "'has'", "'following'", "'modes'", "','", "'operatingSystem'", "'distribution'", "'release'", "'Software'", "'vendor'", "'product'", "'version'", "'package'", "'Mode'", "'extends'", "'description'", "'priority'", "'startServices'", "'stopServices'", "'exchangeable'", "'with'", "'Service'", "'usesSoftware'", "'startActions'", "'stopActions'", "'('", "')'", "'Action'", "'shellCmd'", "'params'", "'Rule'", "'if'", "'and'", "'current'", "'mode'", "'in'", "'then'", "'else'", "'Event'", "'Windows'", "'Linux'", "'Debian'", "'Ubuntu'", "'Other'", "'Buster'", "'true'", "'false'"
    };
    public static final int T__50=50;
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__11=11;
    public static final int T__55=55;
    public static final int T__12=12;
    public static final int T__56=56;
    public static final int T__13=13;
    public static final int T__57=57;
    public static final int T__14=14;
    public static final int T__51=51;
    public static final int T__52=52;
    public static final int T__53=53;
    public static final int T__54=54;
    public static final int RULE_ID=4;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=7;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=8;
    public static final int T__37=37;
    public static final int T__38=38;
    public static final int T__39=39;
    public static final int T__33=33;
    public static final int T__34=34;
    public static final int T__35=35;
    public static final int T__36=36;
    public static final int EOF=-1;
    public static final int T__30=30;
    public static final int T__31=31;
    public static final int T__32=32;
    public static final int RULE_WS=9;
    public static final int RULE_ANY_OTHER=10;
    public static final int T__48=48;
    public static final int T__49=49;
    public static final int T__44=44;
    public static final int T__45=45;
    public static final int T__46=46;
    public static final int T__47=47;
    public static final int T__40=40;
    public static final int T__41=41;
    public static final int T__42=42;
    public static final int T__43=43;

    // delegates
    // delegators


        public InternalMdslParser(TokenStream input) {
            this(input, new RecognizerSharedState());
        }
        public InternalMdslParser(TokenStream input, RecognizerSharedState state) {
            super(input, state);
             
        }
        

    public String[] getTokenNames() { return InternalMdslParser.tokenNames; }
    public String getGrammarFileName() { return "InternalMdsl.g"; }



     	private MdslGrammarAccess grammarAccess;

        public InternalMdslParser(TokenStream input, MdslGrammarAccess grammarAccess) {
            this(input);
            this.grammarAccess = grammarAccess;
            registerRules(grammarAccess.getGrammar());
        }

        @Override
        protected String getFirstRuleName() {
        	return "Model";
       	}

       	@Override
       	protected MdslGrammarAccess getGrammarAccess() {
       		return grammarAccess;
       	}




    // $ANTLR start "entryRuleModel"
    // InternalMdsl.g:65:1: entryRuleModel returns [EObject current=null] : iv_ruleModel= ruleModel EOF ;
    public final EObject entryRuleModel() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleModel = null;


        try {
            // InternalMdsl.g:65:46: (iv_ruleModel= ruleModel EOF )
            // InternalMdsl.g:66:2: iv_ruleModel= ruleModel EOF
            {
             newCompositeNode(grammarAccess.getModelRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleModel=ruleModel();

            state._fsp--;

             current =iv_ruleModel; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleModel"


    // $ANTLR start "ruleModel"
    // InternalMdsl.g:72:1: ruleModel returns [EObject current=null] : ( (lv_declarations_0_0= ruleDeclaration ) )* ;
    public final EObject ruleModel() throws RecognitionException {
        EObject current = null;

        EObject lv_declarations_0_0 = null;



        	enterRule();

        try {
            // InternalMdsl.g:78:2: ( ( (lv_declarations_0_0= ruleDeclaration ) )* )
            // InternalMdsl.g:79:2: ( (lv_declarations_0_0= ruleDeclaration ) )*
            {
            // InternalMdsl.g:79:2: ( (lv_declarations_0_0= ruleDeclaration ) )*
            loop1:
            do {
                int alt1=2;
                int LA1_0 = input.LA(1);

                if ( (LA1_0==11||LA1_0==19||LA1_0==24||LA1_0==32||LA1_0==38||LA1_0==41||LA1_0==49) ) {
                    alt1=1;
                }


                switch (alt1) {
            	case 1 :
            	    // InternalMdsl.g:80:3: (lv_declarations_0_0= ruleDeclaration )
            	    {
            	    // InternalMdsl.g:80:3: (lv_declarations_0_0= ruleDeclaration )
            	    // InternalMdsl.g:81:4: lv_declarations_0_0= ruleDeclaration
            	    {

            	    				newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0());
            	    			
            	    pushFollow(FOLLOW_3);
            	    lv_declarations_0_0=ruleDeclaration();

            	    state._fsp--;


            	    				if (current==null) {
            	    					current = createModelElementForParent(grammarAccess.getModelRule());
            	    				}
            	    				add(
            	    					current,
            	    					"declarations",
            	    					lv_declarations_0_0,
            	    					"org.xtext.mdsl.Mdsl.Declaration");
            	    				afterParserOrEnumRuleCall();
            	    			

            	    }


            	    }
            	    break;

            	default :
            	    break loop1;
                }
            } while (true);


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
    // $ANTLR end "ruleModel"


    // $ANTLR start "entryRuleDeclaration"
    // InternalMdsl.g:101:1: entryRuleDeclaration returns [EObject current=null] : iv_ruleDeclaration= ruleDeclaration EOF ;
    public final EObject entryRuleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleDeclaration = null;


        try {
            // InternalMdsl.g:101:52: (iv_ruleDeclaration= ruleDeclaration EOF )
            // InternalMdsl.g:102:2: iv_ruleDeclaration= ruleDeclaration EOF
            {
             newCompositeNode(grammarAccess.getDeclarationRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleDeclaration=ruleDeclaration();

            state._fsp--;

             current =iv_ruleDeclaration; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleDeclaration"


    // $ANTLR start "ruleDeclaration"
    // InternalMdsl.g:108:1: ruleDeclaration returns [EObject current=null] : (this_System_0= ruleSystem | this_Software_1= ruleSoftware | this_Mode_2= ruleMode | this_Service_3= ruleService | this_Action_4= ruleAction | this_Rule_5= ruleRule | this_Event_6= ruleEvent ) ;
    public final EObject ruleDeclaration() throws RecognitionException {
        EObject current = null;

        EObject this_System_0 = null;

        EObject this_Software_1 = null;

        EObject this_Mode_2 = null;

        EObject this_Service_3 = null;

        EObject this_Action_4 = null;

        EObject this_Rule_5 = null;

        EObject this_Event_6 = null;



        	enterRule();

        try {
            // InternalMdsl.g:114:2: ( (this_System_0= ruleSystem | this_Software_1= ruleSoftware | this_Mode_2= ruleMode | this_Service_3= ruleService | this_Action_4= ruleAction | this_Rule_5= ruleRule | this_Event_6= ruleEvent ) )
            // InternalMdsl.g:115:2: (this_System_0= ruleSystem | this_Software_1= ruleSoftware | this_Mode_2= ruleMode | this_Service_3= ruleService | this_Action_4= ruleAction | this_Rule_5= ruleRule | this_Event_6= ruleEvent )
            {
            // InternalMdsl.g:115:2: (this_System_0= ruleSystem | this_Software_1= ruleSoftware | this_Mode_2= ruleMode | this_Service_3= ruleService | this_Action_4= ruleAction | this_Rule_5= ruleRule | this_Event_6= ruleEvent )
            int alt2=7;
            switch ( input.LA(1) ) {
            case 11:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 24:
                {
                alt2=3;
                }
                break;
            case 32:
                {
                alt2=4;
                }
                break;
            case 38:
                {
                alt2=5;
                }
                break;
            case 41:
                {
                alt2=6;
                }
                break;
            case 49:
                {
                alt2=7;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 2, 0, input);

                throw nvae;
            }

            switch (alt2) {
                case 1 :
                    // InternalMdsl.g:116:3: this_System_0= ruleSystem
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getSystemParserRuleCall_0());
                    		
                    pushFollow(FOLLOW_2);
                    this_System_0=ruleSystem();

                    state._fsp--;


                    			current = this_System_0;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 2 :
                    // InternalMdsl.g:125:3: this_Software_1= ruleSoftware
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getSoftwareParserRuleCall_1());
                    		
                    pushFollow(FOLLOW_2);
                    this_Software_1=ruleSoftware();

                    state._fsp--;


                    			current = this_Software_1;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 3 :
                    // InternalMdsl.g:134:3: this_Mode_2= ruleMode
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getModeParserRuleCall_2());
                    		
                    pushFollow(FOLLOW_2);
                    this_Mode_2=ruleMode();

                    state._fsp--;


                    			current = this_Mode_2;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 4 :
                    // InternalMdsl.g:143:3: this_Service_3= ruleService
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getServiceParserRuleCall_3());
                    		
                    pushFollow(FOLLOW_2);
                    this_Service_3=ruleService();

                    state._fsp--;


                    			current = this_Service_3;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 5 :
                    // InternalMdsl.g:152:3: this_Action_4= ruleAction
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getActionParserRuleCall_4());
                    		
                    pushFollow(FOLLOW_2);
                    this_Action_4=ruleAction();

                    state._fsp--;


                    			current = this_Action_4;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 6 :
                    // InternalMdsl.g:161:3: this_Rule_5= ruleRule
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_5());
                    		
                    pushFollow(FOLLOW_2);
                    this_Rule_5=ruleRule();

                    state._fsp--;


                    			current = this_Rule_5;
                    			afterParserOrEnumRuleCall();
                    		

                    }
                    break;
                case 7 :
                    // InternalMdsl.g:170:3: this_Event_6= ruleEvent
                    {

                    			newCompositeNode(grammarAccess.getDeclarationAccess().getEventParserRuleCall_6());
                    		
                    pushFollow(FOLLOW_2);
                    this_Event_6=ruleEvent();

                    state._fsp--;


                    			current = this_Event_6;
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
        }
        return current;
    }
    // $ANTLR end "ruleDeclaration"


    // $ANTLR start "entryRuleSystem"
    // InternalMdsl.g:182:1: entryRuleSystem returns [EObject current=null] : iv_ruleSystem= ruleSystem EOF ;
    public final EObject entryRuleSystem() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSystem = null;


        try {
            // InternalMdsl.g:182:47: (iv_ruleSystem= ruleSystem EOF )
            // InternalMdsl.g:183:2: iv_ruleSystem= ruleSystem EOF
            {
             newCompositeNode(grammarAccess.getSystemRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSystem=ruleSystem();

            state._fsp--;

             current =iv_ruleSystem; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSystem"


    // $ANTLR start "ruleSystem"
    // InternalMdsl.g:189:1: ruleSystem returns [EObject current=null] : (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )? (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )? (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )? ) ;
    public final EObject ruleSystem() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        Enumerator lv_operatingSystem_9_0 = null;

        Enumerator lv_distribution_11_0 = null;

        Enumerator lv_release_13_0 = null;



        	enterRule();

        try {
            // InternalMdsl.g:195:2: ( (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )? (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )? (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )? ) )
            // InternalMdsl.g:196:2: (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )? (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )? (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )? )
            {
            // InternalMdsl.g:196:2: (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )? (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )? (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )? )
            // InternalMdsl.g:197:3: otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )? (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )? (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )?
            {
            otherlv_0=(Token)match(input,11,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSystemAccess().getSystemKeyword_0());
            		
            // InternalMdsl.g:201:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:202:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:202:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:203:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_5); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSystemAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,12,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSystemAccess().getHasKeyword_2());
            		
            otherlv_3=(Token)match(input,13,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getSystemAccess().getFollowingKeyword_3());
            		
            otherlv_4=(Token)match(input,14,FOLLOW_8); 

            			newLeafNode(otherlv_4, grammarAccess.getSystemAccess().getModesKeyword_4());
            		
            // InternalMdsl.g:231:3: ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )?
            int alt4=2;
            int LA4_0 = input.LA(1);

            if ( (LA4_0==RULE_ID) ) {
                alt4=1;
            }
            switch (alt4) {
                case 1 :
                    // InternalMdsl.g:232:4: ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    {
                    // InternalMdsl.g:232:4: ( (otherlv_5= RULE_ID ) )
                    // InternalMdsl.g:233:5: (otherlv_5= RULE_ID )
                    {
                    // InternalMdsl.g:233:5: (otherlv_5= RULE_ID )
                    // InternalMdsl.g:234:6: otherlv_5= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSystemRule());
                    						}
                    					
                    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_9); 

                    						newLeafNode(otherlv_5, grammarAccess.getSystemAccess().getModesModeCrossReference_5_0_0());
                    					

                    }


                    }

                    // InternalMdsl.g:245:4: (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )*
                    loop3:
                    do {
                        int alt3=2;
                        int LA3_0 = input.LA(1);

                        if ( (LA3_0==15) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMdsl.g:246:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_6, grammarAccess.getSystemAccess().getCommaKeyword_5_1_0());
                    	    				
                    	    // InternalMdsl.g:250:5: ( (otherlv_7= RULE_ID ) )
                    	    // InternalMdsl.g:251:6: (otherlv_7= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:251:6: (otherlv_7= RULE_ID )
                    	    // InternalMdsl.g:252:7: otherlv_7= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getSystemRule());
                    	    							}
                    	    						
                    	    otherlv_7=(Token)match(input,RULE_ID,FOLLOW_9); 

                    	    							newLeafNode(otherlv_7, grammarAccess.getSystemAccess().getModesModeCrossReference_5_1_1_0());
                    	    						

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

            // InternalMdsl.g:265:3: (otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==16) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMdsl.g:266:4: otherlv_8= 'operatingSystem' ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) )
                    {
                    otherlv_8=(Token)match(input,16,FOLLOW_10); 

                    				newLeafNode(otherlv_8, grammarAccess.getSystemAccess().getOperatingSystemKeyword_6_0());
                    			
                    // InternalMdsl.g:270:4: ( (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS ) )
                    // InternalMdsl.g:271:5: (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS )
                    {
                    // InternalMdsl.g:271:5: (lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS )
                    // InternalMdsl.g:272:6: lv_operatingSystem_9_0= ruleSUPPORTED_OPERATING_SYSTEMS
                    {

                    						newCompositeNode(grammarAccess.getSystemAccess().getOperatingSystemSUPPORTED_OPERATING_SYSTEMSEnumRuleCall_6_1_0());
                    					
                    pushFollow(FOLLOW_11);
                    lv_operatingSystem_9_0=ruleSUPPORTED_OPERATING_SYSTEMS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    						}
                    						set(
                    							current,
                    							"operatingSystem",
                    							lv_operatingSystem_9_0,
                    							"org.xtext.mdsl.Mdsl.SUPPORTED_OPERATING_SYSTEMS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:290:3: (otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) ) )?
            int alt6=2;
            int LA6_0 = input.LA(1);

            if ( (LA6_0==17) ) {
                alt6=1;
            }
            switch (alt6) {
                case 1 :
                    // InternalMdsl.g:291:4: otherlv_10= 'distribution' ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) )
                    {
                    otherlv_10=(Token)match(input,17,FOLLOW_12); 

                    				newLeafNode(otherlv_10, grammarAccess.getSystemAccess().getDistributionKeyword_7_0());
                    			
                    // InternalMdsl.g:295:4: ( (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS ) )
                    // InternalMdsl.g:296:5: (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS )
                    {
                    // InternalMdsl.g:296:5: (lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS )
                    // InternalMdsl.g:297:6: lv_distribution_11_0= ruleSUPPORTED_DISTRIBUTIONS
                    {

                    						newCompositeNode(grammarAccess.getSystemAccess().getDistributionSUPPORTED_DISTRIBUTIONSEnumRuleCall_7_1_0());
                    					
                    pushFollow(FOLLOW_13);
                    lv_distribution_11_0=ruleSUPPORTED_DISTRIBUTIONS();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    						}
                    						set(
                    							current,
                    							"distribution",
                    							lv_distribution_11_0,
                    							"org.xtext.mdsl.Mdsl.SUPPORTED_DISTRIBUTIONS");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:315:3: (otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) ) )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==18) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMdsl.g:316:4: otherlv_12= 'release' ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) )
                    {
                    otherlv_12=(Token)match(input,18,FOLLOW_14); 

                    				newLeafNode(otherlv_12, grammarAccess.getSystemAccess().getReleaseKeyword_8_0());
                    			
                    // InternalMdsl.g:320:4: ( (lv_release_13_0= ruleSUPPORTED_RELEASES ) )
                    // InternalMdsl.g:321:5: (lv_release_13_0= ruleSUPPORTED_RELEASES )
                    {
                    // InternalMdsl.g:321:5: (lv_release_13_0= ruleSUPPORTED_RELEASES )
                    // InternalMdsl.g:322:6: lv_release_13_0= ruleSUPPORTED_RELEASES
                    {

                    						newCompositeNode(grammarAccess.getSystemAccess().getReleaseSUPPORTED_RELEASESEnumRuleCall_8_1_0());
                    					
                    pushFollow(FOLLOW_2);
                    lv_release_13_0=ruleSUPPORTED_RELEASES();

                    state._fsp--;


                    						if (current==null) {
                    							current = createModelElementForParent(grammarAccess.getSystemRule());
                    						}
                    						set(
                    							current,
                    							"release",
                    							lv_release_13_0,
                    							"org.xtext.mdsl.Mdsl.SUPPORTED_RELEASES");
                    						afterParserOrEnumRuleCall();
                    					

                    }


                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleSoftware"
    // InternalMdsl.g:344:1: entryRuleSoftware returns [EObject current=null] : iv_ruleSoftware= ruleSoftware EOF ;
    public final EObject entryRuleSoftware() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftware = null;


        try {
            // InternalMdsl.g:344:49: (iv_ruleSoftware= ruleSoftware EOF )
            // InternalMdsl.g:345:2: iv_ruleSoftware= ruleSoftware EOF
            {
             newCompositeNode(grammarAccess.getSoftwareRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleSoftware=ruleSoftware();

            state._fsp--;

             current =iv_ruleSoftware; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleSoftware"


    // $ANTLR start "ruleSoftware"
    // InternalMdsl.g:351:1: ruleSoftware returns [EObject current=null] : (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )? (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )? (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )? (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )? ) ;
    public final EObject ruleSoftware() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_vendor_3_0=null;
        Token otherlv_4=null;
        Token lv_product_5_0=null;
        Token otherlv_6=null;
        Token lv_version_7_0=null;
        Token otherlv_8=null;
        Token lv_package_9_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:357:2: ( (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )? (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )? (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )? (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )? ) )
            // InternalMdsl.g:358:2: (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )? (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )? (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )? (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )? )
            {
            // InternalMdsl.g:358:2: (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )? (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )? (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )? (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )? )
            // InternalMdsl.g:359:3: otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )? (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )? (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )? (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )?
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSoftwareAccess().getSoftwareKeyword_0());
            		
            // InternalMdsl.g:363:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:364:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:364:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:365:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_name_1_0, grammarAccess.getSoftwareAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMdsl.g:381:3: (otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) ) )?
            int alt8=2;
            int LA8_0 = input.LA(1);

            if ( (LA8_0==20) ) {
                alt8=1;
            }
            switch (alt8) {
                case 1 :
                    // InternalMdsl.g:382:4: otherlv_2= 'vendor' ( (lv_vendor_3_0= RULE_STRING ) )
                    {
                    otherlv_2=(Token)match(input,20,FOLLOW_16); 

                    				newLeafNode(otherlv_2, grammarAccess.getSoftwareAccess().getVendorKeyword_2_0());
                    			
                    // InternalMdsl.g:386:4: ( (lv_vendor_3_0= RULE_STRING ) )
                    // InternalMdsl.g:387:5: (lv_vendor_3_0= RULE_STRING )
                    {
                    // InternalMdsl.g:387:5: (lv_vendor_3_0= RULE_STRING )
                    // InternalMdsl.g:388:6: lv_vendor_3_0= RULE_STRING
                    {
                    lv_vendor_3_0=(Token)match(input,RULE_STRING,FOLLOW_17); 

                    						newLeafNode(lv_vendor_3_0, grammarAccess.getSoftwareAccess().getVendorSTRINGTerminalRuleCall_2_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSoftwareRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"vendor",
                    							lv_vendor_3_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:405:3: (otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) ) )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==21) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMdsl.g:406:4: otherlv_4= 'product' ( (lv_product_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,21,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getSoftwareAccess().getProductKeyword_3_0());
                    			
                    // InternalMdsl.g:410:4: ( (lv_product_5_0= RULE_STRING ) )
                    // InternalMdsl.g:411:5: (lv_product_5_0= RULE_STRING )
                    {
                    // InternalMdsl.g:411:5: (lv_product_5_0= RULE_STRING )
                    // InternalMdsl.g:412:6: lv_product_5_0= RULE_STRING
                    {
                    lv_product_5_0=(Token)match(input,RULE_STRING,FOLLOW_18); 

                    						newLeafNode(lv_product_5_0, grammarAccess.getSoftwareAccess().getProductSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSoftwareRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"product",
                    							lv_product_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:429:3: (otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( (LA10_0==22) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMdsl.g:430:4: otherlv_6= 'version' ( (lv_version_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,22,FOLLOW_16); 

                    				newLeafNode(otherlv_6, grammarAccess.getSoftwareAccess().getVersionKeyword_4_0());
                    			
                    // InternalMdsl.g:434:4: ( (lv_version_7_0= RULE_STRING ) )
                    // InternalMdsl.g:435:5: (lv_version_7_0= RULE_STRING )
                    {
                    // InternalMdsl.g:435:5: (lv_version_7_0= RULE_STRING )
                    // InternalMdsl.g:436:6: lv_version_7_0= RULE_STRING
                    {
                    lv_version_7_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

                    						newLeafNode(lv_version_7_0, grammarAccess.getSoftwareAccess().getVersionSTRINGTerminalRuleCall_4_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSoftwareRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"version",
                    							lv_version_7_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:453:3: (otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) ) )?
            int alt11=2;
            int LA11_0 = input.LA(1);

            if ( (LA11_0==23) ) {
                alt11=1;
            }
            switch (alt11) {
                case 1 :
                    // InternalMdsl.g:454:4: otherlv_8= 'package' ( (lv_package_9_0= RULE_STRING ) )
                    {
                    otherlv_8=(Token)match(input,23,FOLLOW_16); 

                    				newLeafNode(otherlv_8, grammarAccess.getSoftwareAccess().getPackageKeyword_5_0());
                    			
                    // InternalMdsl.g:458:4: ( (lv_package_9_0= RULE_STRING ) )
                    // InternalMdsl.g:459:5: (lv_package_9_0= RULE_STRING )
                    {
                    // InternalMdsl.g:459:5: (lv_package_9_0= RULE_STRING )
                    // InternalMdsl.g:460:6: lv_package_9_0= RULE_STRING
                    {
                    lv_package_9_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    						newLeafNode(lv_package_9_0, grammarAccess.getSoftwareAccess().getPackageSTRINGTerminalRuleCall_5_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getSoftwareRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"package",
                    							lv_package_9_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleSoftware"


    // $ANTLR start "entryRuleMode"
    // InternalMdsl.g:481:1: entryRuleMode returns [EObject current=null] : iv_ruleMode= ruleMode EOF ;
    public final EObject entryRuleMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMode = null;


        try {
            // InternalMdsl.g:481:45: (iv_ruleMode= ruleMode EOF )
            // InternalMdsl.g:482:2: iv_ruleMode= ruleMode EOF
            {
             newCompositeNode(grammarAccess.getModeRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleMode=ruleMode();

            state._fsp--;

             current =iv_ruleMode; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleMode"


    // $ANTLR start "ruleMode"
    // InternalMdsl.g:488:1: ruleMode returns [EObject current=null] : (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? ) ;
    public final EObject ruleMode() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token otherlv_6=null;
        Token lv_priority_7_0=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_17=null;
        Token otherlv_18=null;
        Token otherlv_19=null;
        Token otherlv_20=null;
        Token otherlv_21=null;
        Enumerator lv_enabled_16_0 = null;



        	enterRule();

        try {
            // InternalMdsl.g:494:2: ( (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? ) )
            // InternalMdsl.g:495:2: (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? )
            {
            // InternalMdsl.g:495:2: (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )? )
            // InternalMdsl.g:496:3: otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )?
            {
            otherlv_0=(Token)match(input,24,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getModeAccess().getModeKeyword_0());
            		
            // InternalMdsl.g:500:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:501:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:501:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:502:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_20); 

            					newLeafNode(lv_name_1_0, grammarAccess.getModeAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMdsl.g:518:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==25) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMdsl.g:519:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModeAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMdsl.g:523:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:524:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:524:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:525:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_21); 

                    						newLeafNode(otherlv_3, grammarAccess.getModeAccess().getSuperModeModeCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,26,FOLLOW_16); 

            			newLeafNode(otherlv_4, grammarAccess.getModeAccess().getDescriptionKeyword_3());
            		
            // InternalMdsl.g:541:3: ( (lv_description_5_0= RULE_STRING ) )
            // InternalMdsl.g:542:4: (lv_description_5_0= RULE_STRING )
            {
            // InternalMdsl.g:542:4: (lv_description_5_0= RULE_STRING )
            // InternalMdsl.g:543:5: lv_description_5_0= RULE_STRING
            {
            lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_22); 

            					newLeafNode(lv_description_5_0, grammarAccess.getModeAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_5_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_6=(Token)match(input,27,FOLLOW_23); 

            			newLeafNode(otherlv_6, grammarAccess.getModeAccess().getPriorityKeyword_5());
            		
            // InternalMdsl.g:563:3: ( (lv_priority_7_0= RULE_INT ) )
            // InternalMdsl.g:564:4: (lv_priority_7_0= RULE_INT )
            {
            // InternalMdsl.g:564:4: (lv_priority_7_0= RULE_INT )
            // InternalMdsl.g:565:5: lv_priority_7_0= RULE_INT
            {
            lv_priority_7_0=(Token)match(input,RULE_INT,FOLLOW_24); 

            					newLeafNode(lv_priority_7_0, grammarAccess.getModeAccess().getPriorityINTTerminalRuleCall_6_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getModeRule());
            					}
            					setWithLastConsumed(
            						current,
            						"priority",
            						lv_priority_7_0,
            						"org.eclipse.xtext.common.Terminals.INT");
            				

            }


            }

            otherlv_8=(Token)match(input,28,FOLLOW_25); 

            			newLeafNode(otherlv_8, grammarAccess.getModeAccess().getStartServicesKeyword_7());
            		
            // InternalMdsl.g:585:3: ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt14=2;
            int LA14_0 = input.LA(1);

            if ( (LA14_0==RULE_ID) ) {
                alt14=1;
            }
            switch (alt14) {
                case 1 :
                    // InternalMdsl.g:586:4: ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    // InternalMdsl.g:586:4: ( (otherlv_9= RULE_ID ) )
                    // InternalMdsl.g:587:5: (otherlv_9= RULE_ID )
                    {
                    // InternalMdsl.g:587:5: (otherlv_9= RULE_ID )
                    // InternalMdsl.g:588:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_26); 

                    						newLeafNode(otherlv_9, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_0_0());
                    					

                    }


                    }

                    // InternalMdsl.g:599:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop13:
                    do {
                        int alt13=2;
                        int LA13_0 = input.LA(1);

                        if ( (LA13_0==15) ) {
                            alt13=1;
                        }


                        switch (alt13) {
                    	case 1 :
                    	    // InternalMdsl.g:600:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getModeAccess().getCommaKeyword_8_1_0());
                    	    				
                    	    // InternalMdsl.g:604:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalMdsl.g:605:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:605:6: (otherlv_11= RULE_ID )
                    	    // InternalMdsl.g:606:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModeRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_26); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop13;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,29,FOLLOW_27); 

            			newLeafNode(otherlv_12, grammarAccess.getModeAccess().getStopServicesKeyword_9());
            		
            // InternalMdsl.g:623:3: ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_ID) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMdsl.g:624:4: ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )*
                    {
                    // InternalMdsl.g:624:4: ( (otherlv_13= RULE_ID ) )
                    // InternalMdsl.g:625:5: (otherlv_13= RULE_ID )
                    {
                    // InternalMdsl.g:625:5: (otherlv_13= RULE_ID )
                    // InternalMdsl.g:626:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_28); 

                    						newLeafNode(otherlv_13, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_0_0());
                    					

                    }


                    }

                    // InternalMdsl.g:637:4: (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==15) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMdsl.g:638:5: otherlv_14= ',' ( (otherlv_15= RULE_ID ) )
                    	    {
                    	    otherlv_14=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getModeAccess().getCommaKeyword_10_1_0());
                    	    				
                    	    // InternalMdsl.g:642:5: ( (otherlv_15= RULE_ID ) )
                    	    // InternalMdsl.g:643:6: (otherlv_15= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:643:6: (otherlv_15= RULE_ID )
                    	    // InternalMdsl.g:644:7: otherlv_15= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModeRule());
                    	    							}
                    	    						
                    	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_28); 

                    	    							newLeafNode(otherlv_15, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMdsl.g:657:3: ( (lv_enabled_16_0= ruleEnabled ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( ((LA17_0>=56 && LA17_0<=57)) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMdsl.g:658:4: (lv_enabled_16_0= ruleEnabled )
                    {
                    // InternalMdsl.g:658:4: (lv_enabled_16_0= ruleEnabled )
                    // InternalMdsl.g:659:5: lv_enabled_16_0= ruleEnabled
                    {

                    					newCompositeNode(grammarAccess.getModeAccess().getEnabledEnabledEnumRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_29);
                    lv_enabled_16_0=ruleEnabled();

                    state._fsp--;


                    					if (current==null) {
                    						current = createModelElementForParent(grammarAccess.getModeRule());
                    					}
                    					set(
                    						current,
                    						"enabled",
                    						lv_enabled_16_0,
                    						"org.xtext.mdsl.Mdsl.Enabled");
                    					afterParserOrEnumRuleCall();
                    				

                    }


                    }
                    break;

            }

            // InternalMdsl.g:676:3: (otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )* )?
            int alt19=2;
            int LA19_0 = input.LA(1);

            if ( (LA19_0==30) ) {
                alt19=1;
            }
            switch (alt19) {
                case 1 :
                    // InternalMdsl.g:677:4: otherlv_17= 'exchangeable' otherlv_18= 'with' ( (otherlv_19= RULE_ID ) ) (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )*
                    {
                    otherlv_17=(Token)match(input,30,FOLLOW_30); 

                    				newLeafNode(otherlv_17, grammarAccess.getModeAccess().getExchangeableKeyword_12_0());
                    			
                    otherlv_18=(Token)match(input,31,FOLLOW_4); 

                    				newLeafNode(otherlv_18, grammarAccess.getModeAccess().getWithKeyword_12_1());
                    			
                    // InternalMdsl.g:685:4: ( (otherlv_19= RULE_ID ) )
                    // InternalMdsl.g:686:5: (otherlv_19= RULE_ID )
                    {
                    // InternalMdsl.g:686:5: (otherlv_19= RULE_ID )
                    // InternalMdsl.g:687:6: otherlv_19= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_19=(Token)match(input,RULE_ID,FOLLOW_31); 

                    						newLeafNode(otherlv_19, grammarAccess.getModeAccess().getAlternativeModesModeCrossReference_12_2_0());
                    					

                    }


                    }

                    // InternalMdsl.g:698:4: (otherlv_20= ',' ( (otherlv_21= RULE_ID ) ) )*
                    loop18:
                    do {
                        int alt18=2;
                        int LA18_0 = input.LA(1);

                        if ( (LA18_0==15) ) {
                            alt18=1;
                        }


                        switch (alt18) {
                    	case 1 :
                    	    // InternalMdsl.g:699:5: otherlv_20= ',' ( (otherlv_21= RULE_ID ) )
                    	    {
                    	    otherlv_20=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_20, grammarAccess.getModeAccess().getCommaKeyword_12_3_0());
                    	    				
                    	    // InternalMdsl.g:703:5: ( (otherlv_21= RULE_ID ) )
                    	    // InternalMdsl.g:704:6: (otherlv_21= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:704:6: (otherlv_21= RULE_ID )
                    	    // InternalMdsl.g:705:7: otherlv_21= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModeRule());
                    	    							}
                    	    						
                    	    otherlv_21=(Token)match(input,RULE_ID,FOLLOW_31); 

                    	    							newLeafNode(otherlv_21, grammarAccess.getModeAccess().getAlternativeModesModeCrossReference_12_3_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop18;
                        }
                    } while (true);


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
        }
        return current;
    }
    // $ANTLR end "ruleMode"


    // $ANTLR start "entryRuleService"
    // InternalMdsl.g:722:1: entryRuleService returns [EObject current=null] : iv_ruleService= ruleService EOF ;
    public final EObject entryRuleService() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleService = null;


        try {
            // InternalMdsl.g:722:48: (iv_ruleService= ruleService EOF )
            // InternalMdsl.g:723:2: iv_ruleService= ruleService EOF
            {
             newCompositeNode(grammarAccess.getServiceRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleService=ruleService();

            state._fsp--;

             current =iv_ruleService; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleService"


    // $ANTLR start "ruleService"
    // InternalMdsl.g:729:1: ruleService returns [EObject current=null] : (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* ) ;
    public final EObject ruleService() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_8=null;
        Token otherlv_10=null;
        Token otherlv_12=null;
        EObject lv_startActions_7_0 = null;

        EObject lv_startActions_9_0 = null;

        EObject lv_stopActions_11_0 = null;

        EObject lv_stopActions_13_0 = null;



        	enterRule();

        try {
            // InternalMdsl.g:735:2: ( (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* ) )
            // InternalMdsl.g:736:2: (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* )
            {
            // InternalMdsl.g:736:2: (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* )
            // InternalMdsl.g:737:3: otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )*
            {
            otherlv_0=(Token)match(input,32,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAccess().getServiceKeyword_0());
            		
            // InternalMdsl.g:741:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:742:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:742:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:743:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_32); 

            					newLeafNode(lv_name_1_0, grammarAccess.getServiceAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getServiceRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMdsl.g:759:3: (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==33) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMdsl.g:760:4: otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,33,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAccess().getUsesSoftwareKeyword_2_0());
                    			
                    // InternalMdsl.g:764:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:765:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:765:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:766:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_33); 

                    						newLeafNode(otherlv_3, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalMdsl.g:777:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop20:
                    do {
                        int alt20=2;
                        int LA20_0 = input.LA(1);

                        if ( (LA20_0==15) ) {
                            alt20=1;
                        }


                        switch (alt20) {
                    	case 1 :
                    	    // InternalMdsl.g:778:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalMdsl.g:782:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalMdsl.g:783:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:783:6: (otherlv_5= RULE_ID )
                    	    // InternalMdsl.g:784:7: otherlv_5= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getServiceRule());
                    	    							}
                    	    						
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_33); 

                    	    							newLeafNode(otherlv_5, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_2_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop20;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_6=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getServiceAccess().getStartActionsKeyword_3());
            		
            // InternalMdsl.g:801:3: ( (lv_startActions_7_0= ruleActionWithParams ) )
            // InternalMdsl.g:802:4: (lv_startActions_7_0= ruleActionWithParams )
            {
            // InternalMdsl.g:802:4: (lv_startActions_7_0= ruleActionWithParams )
            // InternalMdsl.g:803:5: lv_startActions_7_0= ruleActionWithParams
            {

            					newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_34);
            lv_startActions_7_0=ruleActionWithParams();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceRule());
            					}
            					add(
            						current,
            						"startActions",
            						lv_startActions_7_0,
            						"org.xtext.mdsl.Mdsl.ActionWithParams");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMdsl.g:820:3: (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )*
            loop22:
            do {
                int alt22=2;
                int LA22_0 = input.LA(1);

                if ( (LA22_0==15) ) {
                    alt22=1;
                }


                switch (alt22) {
            	case 1 :
            	    // InternalMdsl.g:821:4: otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) )
            	    {
            	    otherlv_8=(Token)match(input,15,FOLLOW_4); 

            	    				newLeafNode(otherlv_8, grammarAccess.getServiceAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMdsl.g:825:4: ( (lv_startActions_9_0= ruleActionWithParams ) )
            	    // InternalMdsl.g:826:5: (lv_startActions_9_0= ruleActionWithParams )
            	    {
            	    // InternalMdsl.g:826:5: (lv_startActions_9_0= ruleActionWithParams )
            	    // InternalMdsl.g:827:6: lv_startActions_9_0= ruleActionWithParams
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_34);
            	    lv_startActions_9_0=ruleActionWithParams();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"startActions",
            	    							lv_startActions_9_0,
            	    							"org.xtext.mdsl.Mdsl.ActionWithParams");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop22;
                }
            } while (true);

            otherlv_10=(Token)match(input,35,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getServiceAccess().getStopActionsKeyword_6());
            		
            // InternalMdsl.g:849:3: ( (lv_stopActions_11_0= ruleActionWithParams ) )
            // InternalMdsl.g:850:4: (lv_stopActions_11_0= ruleActionWithParams )
            {
            // InternalMdsl.g:850:4: (lv_stopActions_11_0= ruleActionWithParams )
            // InternalMdsl.g:851:5: lv_stopActions_11_0= ruleActionWithParams
            {

            					newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_31);
            lv_stopActions_11_0=ruleActionWithParams();

            state._fsp--;


            					if (current==null) {
            						current = createModelElementForParent(grammarAccess.getServiceRule());
            					}
            					add(
            						current,
            						"stopActions",
            						lv_stopActions_11_0,
            						"org.xtext.mdsl.Mdsl.ActionWithParams");
            					afterParserOrEnumRuleCall();
            				

            }


            }

            // InternalMdsl.g:868:3: (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )*
            loop23:
            do {
                int alt23=2;
                int LA23_0 = input.LA(1);

                if ( (LA23_0==15) ) {
                    alt23=1;
                }


                switch (alt23) {
            	case 1 :
            	    // InternalMdsl.g:869:4: otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) )
            	    {
            	    otherlv_12=(Token)match(input,15,FOLLOW_4); 

            	    				newLeafNode(otherlv_12, grammarAccess.getServiceAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMdsl.g:873:4: ( (lv_stopActions_13_0= ruleActionWithParams ) )
            	    // InternalMdsl.g:874:5: (lv_stopActions_13_0= ruleActionWithParams )
            	    {
            	    // InternalMdsl.g:874:5: (lv_stopActions_13_0= ruleActionWithParams )
            	    // InternalMdsl.g:875:6: lv_stopActions_13_0= ruleActionWithParams
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_31);
            	    lv_stopActions_13_0=ruleActionWithParams();

            	    state._fsp--;


            	    						if (current==null) {
            	    							current = createModelElementForParent(grammarAccess.getServiceRule());
            	    						}
            	    						add(
            	    							current,
            	    							"stopActions",
            	    							lv_stopActions_13_0,
            	    							"org.xtext.mdsl.Mdsl.ActionWithParams");
            	    						afterParserOrEnumRuleCall();
            	    					

            	    }


            	    }


            	    }
            	    break;

            	default :
            	    break loop23;
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
    // $ANTLR end "ruleService"


    // $ANTLR start "entryRuleActionWithParams"
    // InternalMdsl.g:897:1: entryRuleActionWithParams returns [EObject current=null] : iv_ruleActionWithParams= ruleActionWithParams EOF ;
    public final EObject entryRuleActionWithParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionWithParams = null;


        try {
            // InternalMdsl.g:897:57: (iv_ruleActionWithParams= ruleActionWithParams EOF )
            // InternalMdsl.g:898:2: iv_ruleActionWithParams= ruleActionWithParams EOF
            {
             newCompositeNode(grammarAccess.getActionWithParamsRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleActionWithParams=ruleActionWithParams();

            state._fsp--;

             current =iv_ruleActionWithParams; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleActionWithParams"


    // $ANTLR start "ruleActionWithParams"
    // InternalMdsl.g:904:1: ruleActionWithParams returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) ;
    public final EObject ruleActionWithParams() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token otherlv_1=null;
        Token lv_params_2_0=null;
        Token otherlv_3=null;
        Token lv_params_4_0=null;
        Token otherlv_5=null;


        	enterRule();

        try {
            // InternalMdsl.g:910:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) )
            // InternalMdsl.g:911:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            {
            // InternalMdsl.g:911:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            // InternalMdsl.g:912:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')'
            {
            // InternalMdsl.g:912:3: ( (otherlv_0= RULE_ID ) )
            // InternalMdsl.g:913:4: (otherlv_0= RULE_ID )
            {
            // InternalMdsl.g:913:4: (otherlv_0= RULE_ID )
            // InternalMdsl.g:914:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionWithParamsRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_35); 

            					newLeafNode(otherlv_0, grammarAccess.getActionWithParamsAccess().getActionActionCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,36,FOLLOW_36); 

            			newLeafNode(otherlv_1, grammarAccess.getActionWithParamsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMdsl.g:929:3: ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )?
            int alt25=2;
            int LA25_0 = input.LA(1);

            if ( (LA25_0==RULE_STRING) ) {
                alt25=1;
            }
            switch (alt25) {
                case 1 :
                    // InternalMdsl.g:930:4: ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )*
                    {
                    // InternalMdsl.g:930:4: ( (lv_params_2_0= RULE_STRING ) )
                    // InternalMdsl.g:931:5: (lv_params_2_0= RULE_STRING )
                    {
                    // InternalMdsl.g:931:5: (lv_params_2_0= RULE_STRING )
                    // InternalMdsl.g:932:6: lv_params_2_0= RULE_STRING
                    {
                    lv_params_2_0=(Token)match(input,RULE_STRING,FOLLOW_37); 

                    						newLeafNode(lv_params_2_0, grammarAccess.getActionWithParamsAccess().getParamsSTRINGTerminalRuleCall_2_0_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionWithParamsRule());
                    						}
                    						addWithLastConsumed(
                    							current,
                    							"params",
                    							lv_params_2_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }

                    // InternalMdsl.g:948:4: (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )*
                    loop24:
                    do {
                        int alt24=2;
                        int LA24_0 = input.LA(1);

                        if ( (LA24_0==15) ) {
                            alt24=1;
                        }


                        switch (alt24) {
                    	case 1 :
                    	    // InternalMdsl.g:949:5: otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,15,FOLLOW_16); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getActionWithParamsAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMdsl.g:953:5: ( (lv_params_4_0= RULE_STRING ) )
                    	    // InternalMdsl.g:954:6: (lv_params_4_0= RULE_STRING )
                    	    {
                    	    // InternalMdsl.g:954:6: (lv_params_4_0= RULE_STRING )
                    	    // InternalMdsl.g:955:7: lv_params_4_0= RULE_STRING
                    	    {
                    	    lv_params_4_0=(Token)match(input,RULE_STRING,FOLLOW_37); 

                    	    							newLeafNode(lv_params_4_0, grammarAccess.getActionWithParamsAccess().getParamsSTRINGTerminalRuleCall_2_1_1_0());
                    	    						

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getActionWithParamsRule());
                    	    							}
                    	    							addWithLastConsumed(
                    	    								current,
                    	    								"params",
                    	    								lv_params_4_0,
                    	    								"org.eclipse.xtext.common.Terminals.STRING");
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop24;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,37,FOLLOW_2); 

            			newLeafNode(otherlv_5, grammarAccess.getActionWithParamsAccess().getRightParenthesisKeyword_3());
            		

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
    // $ANTLR end "ruleActionWithParams"


    // $ANTLR start "entryRuleAction"
    // InternalMdsl.g:981:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalMdsl.g:981:47: (iv_ruleAction= ruleAction EOF )
            // InternalMdsl.g:982:2: iv_ruleAction= ruleAction EOF
            {
             newCompositeNode(grammarAccess.getActionRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleAction=ruleAction();

            state._fsp--;

             current =iv_ruleAction; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleAction"


    // $ANTLR start "ruleAction"
    // InternalMdsl.g:988:1: ruleAction returns [EObject current=null] : (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) ) ) ;
    public final EObject ruleAction() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_description_5_0=null;
        Token otherlv_6=null;
        Token lv_shellCmd_7_0=null;
        Token otherlv_8=null;
        Token lv_params_9_0=null;
        Token otherlv_10=null;
        Token lv_params_11_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:994:2: ( (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) ) ) )
            // InternalMdsl.g:995:2: (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) ) )
            {
            // InternalMdsl.g:995:2: (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) ) )
            // InternalMdsl.g:996:3: otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) )
            {
            otherlv_0=(Token)match(input,38,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            // InternalMdsl.g:1000:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:1001:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:1001:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:1002:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_38); 

            					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            // InternalMdsl.g:1018:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt26=2;
            int LA26_0 = input.LA(1);

            if ( (LA26_0==25) ) {
                alt26=1;
            }
            switch (alt26) {
                case 1 :
                    // InternalMdsl.g:1019:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,25,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMdsl.g:1023:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:1024:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:1024:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:1025:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_39); 

                    						newLeafNode(otherlv_3, grammarAccess.getActionAccess().getSuperActionActionCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:1037:3: (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )?
            int alt27=2;
            int LA27_0 = input.LA(1);

            if ( (LA27_0==26) ) {
                alt27=1;
            }
            switch (alt27) {
                case 1 :
                    // InternalMdsl.g:1038:4: otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,26,FOLLOW_16); 

                    				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMdsl.g:1042:4: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalMdsl.g:1043:5: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalMdsl.g:1043:5: (lv_description_5_0= RULE_STRING )
                    // InternalMdsl.g:1044:6: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_40); 

                    						newLeafNode(lv_description_5_0, grammarAccess.getActionAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0());
                    					

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    						setWithLastConsumed(
                    							current,
                    							"description",
                    							lv_description_5_0,
                    							"org.eclipse.xtext.common.Terminals.STRING");
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:1061:3: ( (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) | (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* ) )
            int alt29=2;
            int LA29_0 = input.LA(1);

            if ( (LA29_0==39) ) {
                alt29=1;
            }
            else if ( (LA29_0==40) ) {
                alt29=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 29, 0, input);

                throw nvae;
            }
            switch (alt29) {
                case 1 :
                    // InternalMdsl.g:1062:4: (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) )
                    {
                    // InternalMdsl.g:1062:4: (otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) )
                    // InternalMdsl.g:1063:5: otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) )
                    {
                    otherlv_6=(Token)match(input,39,FOLLOW_16); 

                    					newLeafNode(otherlv_6, grammarAccess.getActionAccess().getShellCmdKeyword_4_0_0());
                    				
                    // InternalMdsl.g:1067:5: ( (lv_shellCmd_7_0= RULE_STRING ) )
                    // InternalMdsl.g:1068:6: (lv_shellCmd_7_0= RULE_STRING )
                    {
                    // InternalMdsl.g:1068:6: (lv_shellCmd_7_0= RULE_STRING )
                    // InternalMdsl.g:1069:7: lv_shellCmd_7_0= RULE_STRING
                    {
                    lv_shellCmd_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

                    							newLeafNode(lv_shellCmd_7_0, grammarAccess.getActionAccess().getShellCmdSTRINGTerminalRuleCall_4_0_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getActionRule());
                    							}
                    							setWithLastConsumed(
                    								current,
                    								"shellCmd",
                    								lv_shellCmd_7_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

                    }


                    }


                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1087:4: (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* )
                    {
                    // InternalMdsl.g:1087:4: (otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )* )
                    // InternalMdsl.g:1088:5: otherlv_8= 'params' ( (lv_params_9_0= RULE_STRING ) ) (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )*
                    {
                    otherlv_8=(Token)match(input,40,FOLLOW_16); 

                    					newLeafNode(otherlv_8, grammarAccess.getActionAccess().getParamsKeyword_4_1_0());
                    				
                    // InternalMdsl.g:1092:5: ( (lv_params_9_0= RULE_STRING ) )
                    // InternalMdsl.g:1093:6: (lv_params_9_0= RULE_STRING )
                    {
                    // InternalMdsl.g:1093:6: (lv_params_9_0= RULE_STRING )
                    // InternalMdsl.g:1094:7: lv_params_9_0= RULE_STRING
                    {
                    lv_params_9_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

                    							newLeafNode(lv_params_9_0, grammarAccess.getActionAccess().getParamsSTRINGTerminalRuleCall_4_1_1_0());
                    						

                    							if (current==null) {
                    								current = createModelElement(grammarAccess.getActionRule());
                    							}
                    							addWithLastConsumed(
                    								current,
                    								"params",
                    								lv_params_9_0,
                    								"org.eclipse.xtext.common.Terminals.STRING");
                    						

                    }


                    }

                    // InternalMdsl.g:1110:5: (otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) ) )*
                    loop28:
                    do {
                        int alt28=2;
                        int LA28_0 = input.LA(1);

                        if ( (LA28_0==15) ) {
                            alt28=1;
                        }


                        switch (alt28) {
                    	case 1 :
                    	    // InternalMdsl.g:1111:6: otherlv_10= ',' ( (lv_params_11_0= RULE_STRING ) )
                    	    {
                    	    otherlv_10=(Token)match(input,15,FOLLOW_16); 

                    	    						newLeafNode(otherlv_10, grammarAccess.getActionAccess().getCommaKeyword_4_1_2_0());
                    	    					
                    	    // InternalMdsl.g:1115:6: ( (lv_params_11_0= RULE_STRING ) )
                    	    // InternalMdsl.g:1116:7: (lv_params_11_0= RULE_STRING )
                    	    {
                    	    // InternalMdsl.g:1116:7: (lv_params_11_0= RULE_STRING )
                    	    // InternalMdsl.g:1117:8: lv_params_11_0= RULE_STRING
                    	    {
                    	    lv_params_11_0=(Token)match(input,RULE_STRING,FOLLOW_31); 

                    	    								newLeafNode(lv_params_11_0, grammarAccess.getActionAccess().getParamsSTRINGTerminalRuleCall_4_1_2_1_0());
                    	    							

                    	    								if (current==null) {
                    	    									current = createModelElement(grammarAccess.getActionRule());
                    	    								}
                    	    								addWithLastConsumed(
                    	    									current,
                    	    									"params",
                    	    									lv_params_11_0,
                    	    									"org.eclipse.xtext.common.Terminals.STRING");
                    	    							

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop28;
                        }
                    } while (true);


                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleAction"


    // $ANTLR start "entryRuleRule"
    // InternalMdsl.g:1140:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalMdsl.g:1140:45: (iv_ruleRule= ruleRule EOF )
            // InternalMdsl.g:1141:2: iv_ruleRule= ruleRule EOF
            {
             newCompositeNode(grammarAccess.getRuleRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleRule=ruleRule();

            state._fsp--;

             current =iv_ruleRule; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleRule"


    // $ANTLR start "ruleRule"
    // InternalMdsl.g:1147:1: ruleRule returns [EObject current=null] : (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? ) ;
    public final EObject ruleRule() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_description_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token otherlv_5=null;
        Token otherlv_6=null;
        Token otherlv_7=null;
        Token otherlv_8=null;
        Token otherlv_9=null;
        Token otherlv_10=null;
        Token otherlv_11=null;
        Token otherlv_12=null;
        Token otherlv_13=null;
        Token otherlv_14=null;
        Token otherlv_15=null;
        Token otherlv_16=null;


        	enterRule();

        try {
            // InternalMdsl.g:1153:2: ( (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? ) )
            // InternalMdsl.g:1154:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? )
            {
            // InternalMdsl.g:1154:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? )
            // InternalMdsl.g:1155:3: otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,41,FOLLOW_16); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
            		
            // InternalMdsl.g:1159:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalMdsl.g:1160:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalMdsl.g:1160:4: (lv_description_1_0= RULE_STRING )
            // InternalMdsl.g:1161:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_41); 

            					newLeafNode(lv_description_1_0, grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_1_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_2=(Token)match(input,42,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getIfKeyword_2());
            		
            // InternalMdsl.g:1181:3: ( (otherlv_3= RULE_ID ) )
            // InternalMdsl.g:1182:4: (otherlv_3= RULE_ID )
            {
            // InternalMdsl.g:1182:4: (otherlv_3= RULE_ID )
            // InternalMdsl.g:1183:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getIfEventCrossReference_3_0());
            				

            }


            }

            // InternalMdsl.g:1194:3: (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )?
            int alt31=2;
            int LA31_0 = input.LA(1);

            if ( (LA31_0==43) ) {
                alt31=1;
            }
            switch (alt31) {
                case 1 :
                    // InternalMdsl.g:1195:4: otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')'
                    {
                    otherlv_4=(Token)match(input,43,FOLLOW_43); 

                    				newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getAndKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,44,FOLLOW_44); 

                    				newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getCurrentKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,45,FOLLOW_45); 

                    				newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getModeKeyword_4_2());
                    			
                    otherlv_7=(Token)match(input,46,FOLLOW_35); 

                    				newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getInKeyword_4_3());
                    			
                    otherlv_8=(Token)match(input,36,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_4_4());
                    			
                    // InternalMdsl.g:1215:4: ( (otherlv_9= RULE_ID ) )
                    // InternalMdsl.g:1216:5: (otherlv_9= RULE_ID )
                    {
                    // InternalMdsl.g:1216:5: (otherlv_9= RULE_ID )
                    // InternalMdsl.g:1217:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_37); 

                    						newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getCurrentModeModeCrossReference_4_5_0());
                    					

                    }


                    }

                    // InternalMdsl.g:1228:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop30:
                    do {
                        int alt30=2;
                        int LA30_0 = input.LA(1);

                        if ( (LA30_0==15) ) {
                            alt30=1;
                        }


                        switch (alt30) {
                    	case 1 :
                    	    // InternalMdsl.g:1229:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,15,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getCommaKeyword_4_6_0());
                    	    				
                    	    // InternalMdsl.g:1233:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalMdsl.g:1234:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:1234:6: (otherlv_11= RULE_ID )
                    	    // InternalMdsl.g:1235:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getRuleRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_37); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getRuleAccess().getModesModeCrossReference_4_6_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop30;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,37,FOLLOW_46); 

                    				newLeafNode(otherlv_12, grammarAccess.getRuleAccess().getRightParenthesisKeyword_4_7());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getRuleAccess().getThenKeyword_5());
            		
            // InternalMdsl.g:1256:3: ( (otherlv_14= RULE_ID ) )
            // InternalMdsl.g:1257:4: (otherlv_14= RULE_ID )
            {
            // InternalMdsl.g:1257:4: (otherlv_14= RULE_ID )
            // InternalMdsl.g:1258:5: otherlv_14= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				
            otherlv_14=(Token)match(input,RULE_ID,FOLLOW_47); 

            					newLeafNode(otherlv_14, grammarAccess.getRuleAccess().getThenModeCrossReference_6_0());
            				

            }


            }

            // InternalMdsl.g:1269:3: (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )?
            int alt32=2;
            int LA32_0 = input.LA(1);

            if ( (LA32_0==48) ) {
                alt32=1;
            }
            switch (alt32) {
                case 1 :
                    // InternalMdsl.g:1270:4: otherlv_15= 'else' ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,48,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getRuleAccess().getElseKeyword_7_0());
                    			
                    // InternalMdsl.g:1274:4: ( (otherlv_16= RULE_ID ) )
                    // InternalMdsl.g:1275:5: (otherlv_16= RULE_ID )
                    {
                    // InternalMdsl.g:1275:5: (otherlv_16= RULE_ID )
                    // InternalMdsl.g:1276:6: otherlv_16= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    					
                    otherlv_16=(Token)match(input,RULE_ID,FOLLOW_2); 

                    						newLeafNode(otherlv_16, grammarAccess.getRuleAccess().getElseModeCrossReference_7_1_0());
                    					

                    }


                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleRule"


    // $ANTLR start "entryRuleEvent"
    // InternalMdsl.g:1292:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalMdsl.g:1292:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalMdsl.g:1293:2: iv_ruleEvent= ruleEvent EOF
            {
             newCompositeNode(grammarAccess.getEventRule()); 
            pushFollow(FOLLOW_1);
            iv_ruleEvent=ruleEvent();

            state._fsp--;

             current =iv_ruleEvent; 
            match(input,EOF,FOLLOW_2); 

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
    // $ANTLR end "entryRuleEvent"


    // $ANTLR start "ruleEvent"
    // InternalMdsl.g:1299:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:1305:2: ( (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) )
            // InternalMdsl.g:1306:2: (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            {
            // InternalMdsl.g:1306:2: (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            // InternalMdsl.g:1307:3: otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,49,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
            		
            // InternalMdsl.g:1311:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:1312:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:1312:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:1313:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_21); 

            					newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"name",
            						lv_name_1_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_2=(Token)match(input,26,FOLLOW_16); 

            			newLeafNode(otherlv_2, grammarAccess.getEventAccess().getDescriptionKeyword_2());
            		
            // InternalMdsl.g:1333:3: ( (lv_description_3_0= RULE_STRING ) )
            // InternalMdsl.g:1334:4: (lv_description_3_0= RULE_STRING )
            {
            // InternalMdsl.g:1334:4: (lv_description_3_0= RULE_STRING )
            // InternalMdsl.g:1335:5: lv_description_3_0= RULE_STRING
            {
            lv_description_3_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_description_3_0, grammarAccess.getEventAccess().getDescriptionSTRINGTerminalRuleCall_3_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getEventRule());
            					}
            					setWithLastConsumed(
            						current,
            						"description",
            						lv_description_3_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

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
    // $ANTLR end "ruleEvent"


    // $ANTLR start "ruleSUPPORTED_OPERATING_SYSTEMS"
    // InternalMdsl.g:1355:1: ruleSUPPORTED_OPERATING_SYSTEMS returns [Enumerator current=null] : ( (enumLiteral_0= 'Windows' ) | (enumLiteral_1= 'Linux' ) ) ;
    public final Enumerator ruleSUPPORTED_OPERATING_SYSTEMS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMdsl.g:1361:2: ( ( (enumLiteral_0= 'Windows' ) | (enumLiteral_1= 'Linux' ) ) )
            // InternalMdsl.g:1362:2: ( (enumLiteral_0= 'Windows' ) | (enumLiteral_1= 'Linux' ) )
            {
            // InternalMdsl.g:1362:2: ( (enumLiteral_0= 'Windows' ) | (enumLiteral_1= 'Linux' ) )
            int alt33=2;
            int LA33_0 = input.LA(1);

            if ( (LA33_0==50) ) {
                alt33=1;
            }
            else if ( (LA33_0==51) ) {
                alt33=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 33, 0, input);

                throw nvae;
            }
            switch (alt33) {
                case 1 :
                    // InternalMdsl.g:1363:3: (enumLiteral_0= 'Windows' )
                    {
                    // InternalMdsl.g:1363:3: (enumLiteral_0= 'Windows' )
                    // InternalMdsl.g:1364:4: enumLiteral_0= 'Windows'
                    {
                    enumLiteral_0=(Token)match(input,50,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getWindowsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getWindowsEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1371:3: (enumLiteral_1= 'Linux' )
                    {
                    // InternalMdsl.g:1371:3: (enumLiteral_1= 'Linux' )
                    // InternalMdsl.g:1372:4: enumLiteral_1= 'Linux'
                    {
                    enumLiteral_1=(Token)match(input,51,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getLinuxEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getLinuxEnumLiteralDeclaration_1());
                    			

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleSUPPORTED_OPERATING_SYSTEMS"


    // $ANTLR start "ruleSUPPORTED_DISTRIBUTIONS"
    // InternalMdsl.g:1382:1: ruleSUPPORTED_DISTRIBUTIONS returns [Enumerator current=null] : ( (enumLiteral_0= 'Debian' ) | (enumLiteral_1= 'Ubuntu' ) | (enumLiteral_2= 'Other' ) ) ;
    public final Enumerator ruleSUPPORTED_DISTRIBUTIONS() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;
        Token enumLiteral_2=null;


        	enterRule();

        try {
            // InternalMdsl.g:1388:2: ( ( (enumLiteral_0= 'Debian' ) | (enumLiteral_1= 'Ubuntu' ) | (enumLiteral_2= 'Other' ) ) )
            // InternalMdsl.g:1389:2: ( (enumLiteral_0= 'Debian' ) | (enumLiteral_1= 'Ubuntu' ) | (enumLiteral_2= 'Other' ) )
            {
            // InternalMdsl.g:1389:2: ( (enumLiteral_0= 'Debian' ) | (enumLiteral_1= 'Ubuntu' ) | (enumLiteral_2= 'Other' ) )
            int alt34=3;
            switch ( input.LA(1) ) {
            case 52:
                {
                alt34=1;
                }
                break;
            case 53:
                {
                alt34=2;
                }
                break;
            case 54:
                {
                alt34=3;
                }
                break;
            default:
                NoViableAltException nvae =
                    new NoViableAltException("", 34, 0, input);

                throw nvae;
            }

            switch (alt34) {
                case 1 :
                    // InternalMdsl.g:1390:3: (enumLiteral_0= 'Debian' )
                    {
                    // InternalMdsl.g:1390:3: (enumLiteral_0= 'Debian' )
                    // InternalMdsl.g:1391:4: enumLiteral_0= 'Debian'
                    {
                    enumLiteral_0=(Token)match(input,52,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getDebianEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getDebianEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1398:3: (enumLiteral_1= 'Ubuntu' )
                    {
                    // InternalMdsl.g:1398:3: (enumLiteral_1= 'Ubuntu' )
                    // InternalMdsl.g:1399:4: enumLiteral_1= 'Ubuntu'
                    {
                    enumLiteral_1=(Token)match(input,53,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getUbuntuEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getUbuntuEnumLiteralDeclaration_1());
                    			

                    }


                    }
                    break;
                case 3 :
                    // InternalMdsl.g:1406:3: (enumLiteral_2= 'Other' )
                    {
                    // InternalMdsl.g:1406:3: (enumLiteral_2= 'Other' )
                    // InternalMdsl.g:1407:4: enumLiteral_2= 'Other'
                    {
                    enumLiteral_2=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getOtherEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_2, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getOtherEnumLiteralDeclaration_2());
                    			

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleSUPPORTED_DISTRIBUTIONS"


    // $ANTLR start "ruleSUPPORTED_RELEASES"
    // InternalMdsl.g:1417:1: ruleSUPPORTED_RELEASES returns [Enumerator current=null] : ( (enumLiteral_0= 'Buster' ) | (enumLiteral_1= 'Other' ) ) ;
    public final Enumerator ruleSUPPORTED_RELEASES() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMdsl.g:1423:2: ( ( (enumLiteral_0= 'Buster' ) | (enumLiteral_1= 'Other' ) ) )
            // InternalMdsl.g:1424:2: ( (enumLiteral_0= 'Buster' ) | (enumLiteral_1= 'Other' ) )
            {
            // InternalMdsl.g:1424:2: ( (enumLiteral_0= 'Buster' ) | (enumLiteral_1= 'Other' ) )
            int alt35=2;
            int LA35_0 = input.LA(1);

            if ( (LA35_0==55) ) {
                alt35=1;
            }
            else if ( (LA35_0==54) ) {
                alt35=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 35, 0, input);

                throw nvae;
            }
            switch (alt35) {
                case 1 :
                    // InternalMdsl.g:1425:3: (enumLiteral_0= 'Buster' )
                    {
                    // InternalMdsl.g:1425:3: (enumLiteral_0= 'Buster' )
                    // InternalMdsl.g:1426:4: enumLiteral_0= 'Buster'
                    {
                    enumLiteral_0=(Token)match(input,55,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_RELEASESAccess().getBusterEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_RELEASESAccess().getBusterEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1433:3: (enumLiteral_1= 'Other' )
                    {
                    // InternalMdsl.g:1433:3: (enumLiteral_1= 'Other' )
                    // InternalMdsl.g:1434:4: enumLiteral_1= 'Other'
                    {
                    enumLiteral_1=(Token)match(input,54,FOLLOW_2); 

                    				current = grammarAccess.getSUPPORTED_RELEASESAccess().getOtherEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_RELEASESAccess().getOtherEnumLiteralDeclaration_1());
                    			

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleSUPPORTED_RELEASES"


    // $ANTLR start "ruleEnabled"
    // InternalMdsl.g:1444:1: ruleEnabled returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleEnabled() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMdsl.g:1450:2: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // InternalMdsl.g:1451:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // InternalMdsl.g:1451:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            int alt36=2;
            int LA36_0 = input.LA(1);

            if ( (LA36_0==56) ) {
                alt36=1;
            }
            else if ( (LA36_0==57) ) {
                alt36=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 36, 0, input);

                throw nvae;
            }
            switch (alt36) {
                case 1 :
                    // InternalMdsl.g:1452:3: (enumLiteral_0= 'true' )
                    {
                    // InternalMdsl.g:1452:3: (enumLiteral_0= 'true' )
                    // InternalMdsl.g:1453:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,56,FOLLOW_2); 

                    				current = grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1460:3: (enumLiteral_1= 'false' )
                    {
                    // InternalMdsl.g:1460:3: (enumLiteral_1= 'false' )
                    // InternalMdsl.g:1461:4: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,57,FOLLOW_2); 

                    				current = grammarAccess.getEnabledAccess().getFalseEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_1, grammarAccess.getEnabledAccess().getFalseEnumLiteralDeclaration_1());
                    			

                    }


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
        }
        return current;
    }
    // $ANTLR end "ruleEnabled"

    // Delegated rules


 

    public static final BitSet FOLLOW_1 = new BitSet(new long[]{0x0000000000000000L});
    public static final BitSet FOLLOW_2 = new BitSet(new long[]{0x0000000000000002L});
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x0002024101080802L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000001000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000070012L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000078002L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x000C000000000000L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000060002L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0070000000000000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000040002L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x00C0000000000000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000F00002L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x0000000000E00002L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000000C00002L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000000800002L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000006000000L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000004000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0000000020000010L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000020008000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0300000040000012L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0300000040008002L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000040000002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000080000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000000000008002L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000000600000000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x0000000400008000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000000800008000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000001000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000002000000020L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000002000008000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000018006000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000018004000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000018000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000880000000000L});
    public static final BitSet FOLLOW_43 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_44 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_45 = new BitSet(new long[]{0x0000400000000000L});
    public static final BitSet FOLLOW_46 = new BitSet(new long[]{0x0000800000000000L});
    public static final BitSet FOLLOW_47 = new BitSet(new long[]{0x0001000000000002L});

}