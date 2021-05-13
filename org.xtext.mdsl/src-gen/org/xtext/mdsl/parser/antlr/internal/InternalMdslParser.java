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
        "<invalid>", "<EOR>", "<DOWN>", "<UP>", "RULE_ID", "RULE_STRING", "RULE_INT", "RULE_DATE", "RULE_ML_COMMENT", "RULE_SL_COMMENT", "RULE_WS", "RULE_ANY_OTHER", "'System'", "'has'", "'following'", "'modes'", "','", "'distribution'", "'releaseDate'", "'Software'", "'identified'", "'by'", "'cpe:/:'", "':'", "'package'", "'Mode'", "'extends'", "'description'", "'priority'", "'startServices'", "'stopServices'", "'Service'", "'usesSoftware'", "'startActions'", "'stopActions'", "'('", "')'", "'Action'", "'shellCmd'", "'Rule'", "'if'", "'and'", "'current'", "'mode'", "'in'", "'then'", "'else'", "'Event'", "'true'", "'false'"
    };
    public static final int T__19=19;
    public static final int T__15=15;
    public static final int T__16=16;
    public static final int T__17=17;
    public static final int T__18=18;
    public static final int T__12=12;
    public static final int T__13=13;
    public static final int T__14=14;
    public static final int RULE_ID=4;
    public static final int RULE_DATE=7;
    public static final int T__26=26;
    public static final int T__27=27;
    public static final int T__28=28;
    public static final int RULE_INT=6;
    public static final int T__29=29;
    public static final int T__22=22;
    public static final int RULE_ML_COMMENT=8;
    public static final int T__23=23;
    public static final int T__24=24;
    public static final int T__25=25;
    public static final int T__20=20;
    public static final int T__21=21;
    public static final int RULE_STRING=5;
    public static final int RULE_SL_COMMENT=9;
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
    public static final int RULE_WS=10;
    public static final int RULE_ANY_OTHER=11;
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

                if ( (LA1_0==12||LA1_0==19||LA1_0==25||LA1_0==31||LA1_0==37||LA1_0==39||LA1_0==47) ) {
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
            case 12:
                {
                alt2=1;
                }
                break;
            case 19:
                {
                alt2=2;
                }
                break;
            case 25:
                {
                alt2=3;
                }
                break;
            case 31:
                {
                alt2=4;
                }
                break;
            case 37:
                {
                alt2=5;
                }
                break;
            case 39:
                {
                alt2=6;
                }
                break;
            case 47:
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
    // InternalMdsl.g:189:1: ruleSystem returns [EObject current=null] : (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= 'distribution' ( (lv_distribution_9_0= RULE_STRING ) ) otherlv_10= 'releaseDate' ( (lv_releaseDate_11_0= RULE_STRING ) ) ) ;
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
        Token lv_distribution_9_0=null;
        Token otherlv_10=null;
        Token lv_releaseDate_11_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:195:2: ( (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= 'distribution' ( (lv_distribution_9_0= RULE_STRING ) ) otherlv_10= 'releaseDate' ( (lv_releaseDate_11_0= RULE_STRING ) ) ) )
            // InternalMdsl.g:196:2: (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= 'distribution' ( (lv_distribution_9_0= RULE_STRING ) ) otherlv_10= 'releaseDate' ( (lv_releaseDate_11_0= RULE_STRING ) ) )
            {
            // InternalMdsl.g:196:2: (otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= 'distribution' ( (lv_distribution_9_0= RULE_STRING ) ) otherlv_10= 'releaseDate' ( (lv_releaseDate_11_0= RULE_STRING ) ) )
            // InternalMdsl.g:197:3: otherlv_0= 'System' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'has' otherlv_3= 'following' otherlv_4= 'modes' ( ( (otherlv_5= RULE_ID ) ) (otherlv_6= ',' ( (otherlv_7= RULE_ID ) ) )* )? otherlv_8= 'distribution' ( (lv_distribution_9_0= RULE_STRING ) ) otherlv_10= 'releaseDate' ( (lv_releaseDate_11_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,12,FOLLOW_4); 

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

            otherlv_2=(Token)match(input,13,FOLLOW_6); 

            			newLeafNode(otherlv_2, grammarAccess.getSystemAccess().getHasKeyword_2());
            		
            otherlv_3=(Token)match(input,14,FOLLOW_7); 

            			newLeafNode(otherlv_3, grammarAccess.getSystemAccess().getFollowingKeyword_3());
            		
            otherlv_4=(Token)match(input,15,FOLLOW_8); 

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

                        if ( (LA3_0==16) ) {
                            alt3=1;
                        }


                        switch (alt3) {
                    	case 1 :
                    	    // InternalMdsl.g:246:5: otherlv_6= ',' ( (otherlv_7= RULE_ID ) )
                    	    {
                    	    otherlv_6=(Token)match(input,16,FOLLOW_4); 

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

            otherlv_8=(Token)match(input,17,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getSystemAccess().getDistributionKeyword_6());
            		
            // InternalMdsl.g:269:3: ( (lv_distribution_9_0= RULE_STRING ) )
            // InternalMdsl.g:270:4: (lv_distribution_9_0= RULE_STRING )
            {
            // InternalMdsl.g:270:4: (lv_distribution_9_0= RULE_STRING )
            // InternalMdsl.g:271:5: lv_distribution_9_0= RULE_STRING
            {
            lv_distribution_9_0=(Token)match(input,RULE_STRING,FOLLOW_11); 

            					newLeafNode(lv_distribution_9_0, grammarAccess.getSystemAccess().getDistributionSTRINGTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"distribution",
            						lv_distribution_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,18,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getSystemAccess().getReleaseDateKeyword_8());
            		
            // InternalMdsl.g:291:3: ( (lv_releaseDate_11_0= RULE_STRING ) )
            // InternalMdsl.g:292:4: (lv_releaseDate_11_0= RULE_STRING )
            {
            // InternalMdsl.g:292:4: (lv_releaseDate_11_0= RULE_STRING )
            // InternalMdsl.g:293:5: lv_releaseDate_11_0= RULE_STRING
            {
            lv_releaseDate_11_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_releaseDate_11_0, grammarAccess.getSystemAccess().getReleaseDateSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSystemRule());
            					}
            					setWithLastConsumed(
            						current,
            						"releaseDate",
            						lv_releaseDate_11_0,
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
    // $ANTLR end "ruleSystem"


    // $ANTLR start "entryRuleSoftware"
    // InternalMdsl.g:313:1: entryRuleSoftware returns [EObject current=null] : iv_ruleSoftware= ruleSoftware EOF ;
    public final EObject entryRuleSoftware() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleSoftware = null;


        try {
            // InternalMdsl.g:313:49: (iv_ruleSoftware= ruleSoftware EOF )
            // InternalMdsl.g:314:2: iv_ruleSoftware= ruleSoftware EOF
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
    // InternalMdsl.g:320:1: ruleSoftware returns [EObject current=null] : (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'identified' otherlv_3= 'by' otherlv_4= 'cpe:/:' ( (lv_vendor_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_product_7_0= RULE_ID ) ) otherlv_8= ':' ( (lv_version_9_0= RULE_STRING ) ) otherlv_10= 'package' ( (lv_package_11_0= RULE_STRING ) ) ) ;
    public final EObject ruleSoftware() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token otherlv_3=null;
        Token otherlv_4=null;
        Token lv_vendor_5_0=null;
        Token otherlv_6=null;
        Token lv_product_7_0=null;
        Token otherlv_8=null;
        Token lv_version_9_0=null;
        Token otherlv_10=null;
        Token lv_package_11_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:326:2: ( (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'identified' otherlv_3= 'by' otherlv_4= 'cpe:/:' ( (lv_vendor_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_product_7_0= RULE_ID ) ) otherlv_8= ':' ( (lv_version_9_0= RULE_STRING ) ) otherlv_10= 'package' ( (lv_package_11_0= RULE_STRING ) ) ) )
            // InternalMdsl.g:327:2: (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'identified' otherlv_3= 'by' otherlv_4= 'cpe:/:' ( (lv_vendor_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_product_7_0= RULE_ID ) ) otherlv_8= ':' ( (lv_version_9_0= RULE_STRING ) ) otherlv_10= 'package' ( (lv_package_11_0= RULE_STRING ) ) )
            {
            // InternalMdsl.g:327:2: (otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'identified' otherlv_3= 'by' otherlv_4= 'cpe:/:' ( (lv_vendor_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_product_7_0= RULE_ID ) ) otherlv_8= ':' ( (lv_version_9_0= RULE_STRING ) ) otherlv_10= 'package' ( (lv_package_11_0= RULE_STRING ) ) )
            // InternalMdsl.g:328:3: otherlv_0= 'Software' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'identified' otherlv_3= 'by' otherlv_4= 'cpe:/:' ( (lv_vendor_5_0= RULE_ID ) ) otherlv_6= ':' ( (lv_product_7_0= RULE_ID ) ) otherlv_8= ':' ( (lv_version_9_0= RULE_STRING ) ) otherlv_10= 'package' ( (lv_package_11_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,19,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getSoftwareAccess().getSoftwareKeyword_0());
            		
            // InternalMdsl.g:332:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:333:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:333:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:334:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_12); 

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

            otherlv_2=(Token)match(input,20,FOLLOW_13); 

            			newLeafNode(otherlv_2, grammarAccess.getSoftwareAccess().getIdentifiedKeyword_2());
            		
            otherlv_3=(Token)match(input,21,FOLLOW_14); 

            			newLeafNode(otherlv_3, grammarAccess.getSoftwareAccess().getByKeyword_3());
            		
            otherlv_4=(Token)match(input,22,FOLLOW_4); 

            			newLeafNode(otherlv_4, grammarAccess.getSoftwareAccess().getCpeKeyword_4());
            		
            // InternalMdsl.g:362:3: ( (lv_vendor_5_0= RULE_ID ) )
            // InternalMdsl.g:363:4: (lv_vendor_5_0= RULE_ID )
            {
            // InternalMdsl.g:363:4: (lv_vendor_5_0= RULE_ID )
            // InternalMdsl.g:364:5: lv_vendor_5_0= RULE_ID
            {
            lv_vendor_5_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_vendor_5_0, grammarAccess.getSoftwareAccess().getVendorIDTerminalRuleCall_5_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareRule());
            					}
            					setWithLastConsumed(
            						current,
            						"vendor",
            						lv_vendor_5_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_6=(Token)match(input,23,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getSoftwareAccess().getColonKeyword_6());
            		
            // InternalMdsl.g:384:3: ( (lv_product_7_0= RULE_ID ) )
            // InternalMdsl.g:385:4: (lv_product_7_0= RULE_ID )
            {
            // InternalMdsl.g:385:4: (lv_product_7_0= RULE_ID )
            // InternalMdsl.g:386:5: lv_product_7_0= RULE_ID
            {
            lv_product_7_0=(Token)match(input,RULE_ID,FOLLOW_15); 

            					newLeafNode(lv_product_7_0, grammarAccess.getSoftwareAccess().getProductIDTerminalRuleCall_7_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareRule());
            					}
            					setWithLastConsumed(
            						current,
            						"product",
            						lv_product_7_0,
            						"org.eclipse.xtext.common.Terminals.ID");
            				

            }


            }

            otherlv_8=(Token)match(input,23,FOLLOW_10); 

            			newLeafNode(otherlv_8, grammarAccess.getSoftwareAccess().getColonKeyword_8());
            		
            // InternalMdsl.g:406:3: ( (lv_version_9_0= RULE_STRING ) )
            // InternalMdsl.g:407:4: (lv_version_9_0= RULE_STRING )
            {
            // InternalMdsl.g:407:4: (lv_version_9_0= RULE_STRING )
            // InternalMdsl.g:408:5: lv_version_9_0= RULE_STRING
            {
            lv_version_9_0=(Token)match(input,RULE_STRING,FOLLOW_16); 

            					newLeafNode(lv_version_9_0, grammarAccess.getSoftwareAccess().getVersionSTRINGTerminalRuleCall_9_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareRule());
            					}
            					setWithLastConsumed(
            						current,
            						"version",
            						lv_version_9_0,
            						"org.eclipse.xtext.common.Terminals.STRING");
            				

            }


            }

            otherlv_10=(Token)match(input,24,FOLLOW_10); 

            			newLeafNode(otherlv_10, grammarAccess.getSoftwareAccess().getPackageKeyword_10());
            		
            // InternalMdsl.g:428:3: ( (lv_package_11_0= RULE_STRING ) )
            // InternalMdsl.g:429:4: (lv_package_11_0= RULE_STRING )
            {
            // InternalMdsl.g:429:4: (lv_package_11_0= RULE_STRING )
            // InternalMdsl.g:430:5: lv_package_11_0= RULE_STRING
            {
            lv_package_11_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_package_11_0, grammarAccess.getSoftwareAccess().getPackageSTRINGTerminalRuleCall_11_0());
            				

            					if (current==null) {
            						current = createModelElement(grammarAccess.getSoftwareRule());
            					}
            					setWithLastConsumed(
            						current,
            						"package",
            						lv_package_11_0,
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
    // $ANTLR end "ruleSoftware"


    // $ANTLR start "entryRuleMode"
    // InternalMdsl.g:450:1: entryRuleMode returns [EObject current=null] : iv_ruleMode= ruleMode EOF ;
    public final EObject entryRuleMode() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleMode = null;


        try {
            // InternalMdsl.g:450:45: (iv_ruleMode= ruleMode EOF )
            // InternalMdsl.g:451:2: iv_ruleMode= ruleMode EOF
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
    // InternalMdsl.g:457:1: ruleMode returns [EObject current=null] : (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? ) ;
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
        Enumerator lv_enabled_16_0 = null;



        	enterRule();

        try {
            // InternalMdsl.g:463:2: ( (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? ) )
            // InternalMdsl.g:464:2: (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? )
            {
            // InternalMdsl.g:464:2: (otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )? )
            // InternalMdsl.g:465:3: otherlv_0= 'Mode' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) otherlv_6= 'priority' ( (lv_priority_7_0= RULE_INT ) ) otherlv_8= 'startServices' ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )? otherlv_12= 'stopServices' ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )? ( (lv_enabled_16_0= ruleEnabled ) )?
            {
            otherlv_0=(Token)match(input,25,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getModeAccess().getModeKeyword_0());
            		
            // InternalMdsl.g:469:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:470:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:470:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:471:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_17); 

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

            // InternalMdsl.g:487:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt5=2;
            int LA5_0 = input.LA(1);

            if ( (LA5_0==26) ) {
                alt5=1;
            }
            switch (alt5) {
                case 1 :
                    // InternalMdsl.g:488:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getModeAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMdsl.g:492:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:493:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:493:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:494:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_18); 

                    						newLeafNode(otherlv_3, grammarAccess.getModeAccess().getSuperTypeModeCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            otherlv_4=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_4, grammarAccess.getModeAccess().getDescriptionKeyword_3());
            		
            // InternalMdsl.g:510:3: ( (lv_description_5_0= RULE_STRING ) )
            // InternalMdsl.g:511:4: (lv_description_5_0= RULE_STRING )
            {
            // InternalMdsl.g:511:4: (lv_description_5_0= RULE_STRING )
            // InternalMdsl.g:512:5: lv_description_5_0= RULE_STRING
            {
            lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_19); 

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

            otherlv_6=(Token)match(input,28,FOLLOW_20); 

            			newLeafNode(otherlv_6, grammarAccess.getModeAccess().getPriorityKeyword_5());
            		
            // InternalMdsl.g:532:3: ( (lv_priority_7_0= RULE_INT ) )
            // InternalMdsl.g:533:4: (lv_priority_7_0= RULE_INT )
            {
            // InternalMdsl.g:533:4: (lv_priority_7_0= RULE_INT )
            // InternalMdsl.g:534:5: lv_priority_7_0= RULE_INT
            {
            lv_priority_7_0=(Token)match(input,RULE_INT,FOLLOW_21); 

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

            otherlv_8=(Token)match(input,29,FOLLOW_22); 

            			newLeafNode(otherlv_8, grammarAccess.getModeAccess().getStartServicesKeyword_7());
            		
            // InternalMdsl.g:554:3: ( ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* )?
            int alt7=2;
            int LA7_0 = input.LA(1);

            if ( (LA7_0==RULE_ID) ) {
                alt7=1;
            }
            switch (alt7) {
                case 1 :
                    // InternalMdsl.g:555:4: ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    {
                    // InternalMdsl.g:555:4: ( (otherlv_9= RULE_ID ) )
                    // InternalMdsl.g:556:5: (otherlv_9= RULE_ID )
                    {
                    // InternalMdsl.g:556:5: (otherlv_9= RULE_ID )
                    // InternalMdsl.g:557:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_23); 

                    						newLeafNode(otherlv_9, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_0_0());
                    					

                    }


                    }

                    // InternalMdsl.g:568:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop6:
                    do {
                        int alt6=2;
                        int LA6_0 = input.LA(1);

                        if ( (LA6_0==16) ) {
                            alt6=1;
                        }


                        switch (alt6) {
                    	case 1 :
                    	    // InternalMdsl.g:569:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,16,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getModeAccess().getCommaKeyword_8_1_0());
                    	    				
                    	    // InternalMdsl.g:573:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalMdsl.g:574:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:574:6: (otherlv_11= RULE_ID )
                    	    // InternalMdsl.g:575:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModeRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_23); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop6;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_12=(Token)match(input,30,FOLLOW_24); 

            			newLeafNode(otherlv_12, grammarAccess.getModeAccess().getStopServicesKeyword_9());
            		
            // InternalMdsl.g:592:3: ( ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )* )?
            int alt9=2;
            int LA9_0 = input.LA(1);

            if ( (LA9_0==RULE_ID) ) {
                alt9=1;
            }
            switch (alt9) {
                case 1 :
                    // InternalMdsl.g:593:4: ( (otherlv_13= RULE_ID ) ) (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )*
                    {
                    // InternalMdsl.g:593:4: ( (otherlv_13= RULE_ID ) )
                    // InternalMdsl.g:594:5: (otherlv_13= RULE_ID )
                    {
                    // InternalMdsl.g:594:5: (otherlv_13= RULE_ID )
                    // InternalMdsl.g:595:6: otherlv_13= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getModeRule());
                    						}
                    					
                    otherlv_13=(Token)match(input,RULE_ID,FOLLOW_25); 

                    						newLeafNode(otherlv_13, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_0_0());
                    					

                    }


                    }

                    // InternalMdsl.g:606:4: (otherlv_14= ',' ( (otherlv_15= RULE_ID ) ) )*
                    loop8:
                    do {
                        int alt8=2;
                        int LA8_0 = input.LA(1);

                        if ( (LA8_0==16) ) {
                            alt8=1;
                        }


                        switch (alt8) {
                    	case 1 :
                    	    // InternalMdsl.g:607:5: otherlv_14= ',' ( (otherlv_15= RULE_ID ) )
                    	    {
                    	    otherlv_14=(Token)match(input,16,FOLLOW_4); 

                    	    					newLeafNode(otherlv_14, grammarAccess.getModeAccess().getCommaKeyword_10_1_0());
                    	    				
                    	    // InternalMdsl.g:611:5: ( (otherlv_15= RULE_ID ) )
                    	    // InternalMdsl.g:612:6: (otherlv_15= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:612:6: (otherlv_15= RULE_ID )
                    	    // InternalMdsl.g:613:7: otherlv_15= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getModeRule());
                    	    							}
                    	    						
                    	    otherlv_15=(Token)match(input,RULE_ID,FOLLOW_25); 

                    	    							newLeafNode(otherlv_15, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_1_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop8;
                        }
                    } while (true);


                    }
                    break;

            }

            // InternalMdsl.g:626:3: ( (lv_enabled_16_0= ruleEnabled ) )?
            int alt10=2;
            int LA10_0 = input.LA(1);

            if ( ((LA10_0>=48 && LA10_0<=49)) ) {
                alt10=1;
            }
            switch (alt10) {
                case 1 :
                    // InternalMdsl.g:627:4: (lv_enabled_16_0= ruleEnabled )
                    {
                    // InternalMdsl.g:627:4: (lv_enabled_16_0= ruleEnabled )
                    // InternalMdsl.g:628:5: lv_enabled_16_0= ruleEnabled
                    {

                    					newCompositeNode(grammarAccess.getModeAccess().getEnabledEnabledEnumRuleCall_11_0());
                    				
                    pushFollow(FOLLOW_2);
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
    // InternalMdsl.g:649:1: entryRuleService returns [EObject current=null] : iv_ruleService= ruleService EOF ;
    public final EObject entryRuleService() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleService = null;


        try {
            // InternalMdsl.g:649:48: (iv_ruleService= ruleService EOF )
            // InternalMdsl.g:650:2: iv_ruleService= ruleService EOF
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
    // InternalMdsl.g:656:1: ruleService returns [EObject current=null] : (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* ) ;
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
            // InternalMdsl.g:662:2: ( (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* ) )
            // InternalMdsl.g:663:2: (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* )
            {
            // InternalMdsl.g:663:2: (otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )* )
            // InternalMdsl.g:664:3: otherlv_0= 'Service' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )? otherlv_6= 'startActions' ( (lv_startActions_7_0= ruleActionWithParams ) ) (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )* otherlv_10= 'stopActions' ( (lv_stopActions_11_0= ruleActionWithParams ) ) (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )*
            {
            otherlv_0=(Token)match(input,31,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getServiceAccess().getServiceKeyword_0());
            		
            // InternalMdsl.g:668:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:669:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:669:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:670:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_26); 

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

            // InternalMdsl.g:686:3: (otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )* )?
            int alt12=2;
            int LA12_0 = input.LA(1);

            if ( (LA12_0==32) ) {
                alt12=1;
            }
            switch (alt12) {
                case 1 :
                    // InternalMdsl.g:687:4: otherlv_2= 'usesSoftware' ( (otherlv_3= RULE_ID ) ) (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    {
                    otherlv_2=(Token)match(input,32,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getServiceAccess().getUsesSoftwareKeyword_2_0());
                    			
                    // InternalMdsl.g:691:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:692:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:692:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:693:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getServiceRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_27); 

                    						newLeafNode(otherlv_3, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_1_0());
                    					

                    }


                    }

                    // InternalMdsl.g:704:4: (otherlv_4= ',' ( (otherlv_5= RULE_ID ) ) )*
                    loop11:
                    do {
                        int alt11=2;
                        int LA11_0 = input.LA(1);

                        if ( (LA11_0==16) ) {
                            alt11=1;
                        }


                        switch (alt11) {
                    	case 1 :
                    	    // InternalMdsl.g:705:5: otherlv_4= ',' ( (otherlv_5= RULE_ID ) )
                    	    {
                    	    otherlv_4=(Token)match(input,16,FOLLOW_4); 

                    	    					newLeafNode(otherlv_4, grammarAccess.getServiceAccess().getCommaKeyword_2_2_0());
                    	    				
                    	    // InternalMdsl.g:709:5: ( (otherlv_5= RULE_ID ) )
                    	    // InternalMdsl.g:710:6: (otherlv_5= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:710:6: (otherlv_5= RULE_ID )
                    	    // InternalMdsl.g:711:7: otherlv_5= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getServiceRule());
                    	    							}
                    	    						
                    	    otherlv_5=(Token)match(input,RULE_ID,FOLLOW_27); 

                    	    							newLeafNode(otherlv_5, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_2_1_0());
                    	    						

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

            otherlv_6=(Token)match(input,33,FOLLOW_4); 

            			newLeafNode(otherlv_6, grammarAccess.getServiceAccess().getStartActionsKeyword_3());
            		
            // InternalMdsl.g:728:3: ( (lv_startActions_7_0= ruleActionWithParams ) )
            // InternalMdsl.g:729:4: (lv_startActions_7_0= ruleActionWithParams )
            {
            // InternalMdsl.g:729:4: (lv_startActions_7_0= ruleActionWithParams )
            // InternalMdsl.g:730:5: lv_startActions_7_0= ruleActionWithParams
            {

            					newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_4_0());
            				
            pushFollow(FOLLOW_28);
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

            // InternalMdsl.g:747:3: (otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) ) )*
            loop13:
            do {
                int alt13=2;
                int LA13_0 = input.LA(1);

                if ( (LA13_0==16) ) {
                    alt13=1;
                }


                switch (alt13) {
            	case 1 :
            	    // InternalMdsl.g:748:4: otherlv_8= ',' ( (lv_startActions_9_0= ruleActionWithParams ) )
            	    {
            	    otherlv_8=(Token)match(input,16,FOLLOW_4); 

            	    				newLeafNode(otherlv_8, grammarAccess.getServiceAccess().getCommaKeyword_5_0());
            	    			
            	    // InternalMdsl.g:752:4: ( (lv_startActions_9_0= ruleActionWithParams ) )
            	    // InternalMdsl.g:753:5: (lv_startActions_9_0= ruleActionWithParams )
            	    {
            	    // InternalMdsl.g:753:5: (lv_startActions_9_0= ruleActionWithParams )
            	    // InternalMdsl.g:754:6: lv_startActions_9_0= ruleActionWithParams
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_5_1_0());
            	    					
            	    pushFollow(FOLLOW_28);
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
            	    break loop13;
                }
            } while (true);

            otherlv_10=(Token)match(input,34,FOLLOW_4); 

            			newLeafNode(otherlv_10, grammarAccess.getServiceAccess().getStopActionsKeyword_6());
            		
            // InternalMdsl.g:776:3: ( (lv_stopActions_11_0= ruleActionWithParams ) )
            // InternalMdsl.g:777:4: (lv_stopActions_11_0= ruleActionWithParams )
            {
            // InternalMdsl.g:777:4: (lv_stopActions_11_0= ruleActionWithParams )
            // InternalMdsl.g:778:5: lv_stopActions_11_0= ruleActionWithParams
            {

            					newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_7_0());
            				
            pushFollow(FOLLOW_29);
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

            // InternalMdsl.g:795:3: (otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) ) )*
            loop14:
            do {
                int alt14=2;
                int LA14_0 = input.LA(1);

                if ( (LA14_0==16) ) {
                    alt14=1;
                }


                switch (alt14) {
            	case 1 :
            	    // InternalMdsl.g:796:4: otherlv_12= ',' ( (lv_stopActions_13_0= ruleActionWithParams ) )
            	    {
            	    otherlv_12=(Token)match(input,16,FOLLOW_4); 

            	    				newLeafNode(otherlv_12, grammarAccess.getServiceAccess().getCommaKeyword_8_0());
            	    			
            	    // InternalMdsl.g:800:4: ( (lv_stopActions_13_0= ruleActionWithParams ) )
            	    // InternalMdsl.g:801:5: (lv_stopActions_13_0= ruleActionWithParams )
            	    {
            	    // InternalMdsl.g:801:5: (lv_stopActions_13_0= ruleActionWithParams )
            	    // InternalMdsl.g:802:6: lv_stopActions_13_0= ruleActionWithParams
            	    {

            	    						newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_8_1_0());
            	    					
            	    pushFollow(FOLLOW_29);
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
            	    break loop14;
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
    // InternalMdsl.g:824:1: entryRuleActionWithParams returns [EObject current=null] : iv_ruleActionWithParams= ruleActionWithParams EOF ;
    public final EObject entryRuleActionWithParams() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleActionWithParams = null;


        try {
            // InternalMdsl.g:824:57: (iv_ruleActionWithParams= ruleActionWithParams EOF )
            // InternalMdsl.g:825:2: iv_ruleActionWithParams= ruleActionWithParams EOF
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
    // InternalMdsl.g:831:1: ruleActionWithParams returns [EObject current=null] : ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) ;
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
            // InternalMdsl.g:837:2: ( ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' ) )
            // InternalMdsl.g:838:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            {
            // InternalMdsl.g:838:2: ( ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')' )
            // InternalMdsl.g:839:3: ( (otherlv_0= RULE_ID ) ) otherlv_1= '(' ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )? otherlv_5= ')'
            {
            // InternalMdsl.g:839:3: ( (otherlv_0= RULE_ID ) )
            // InternalMdsl.g:840:4: (otherlv_0= RULE_ID )
            {
            // InternalMdsl.g:840:4: (otherlv_0= RULE_ID )
            // InternalMdsl.g:841:5: otherlv_0= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getActionWithParamsRule());
            					}
            				
            otherlv_0=(Token)match(input,RULE_ID,FOLLOW_30); 

            					newLeafNode(otherlv_0, grammarAccess.getActionWithParamsAccess().getActionActionCrossReference_0_0());
            				

            }


            }

            otherlv_1=(Token)match(input,35,FOLLOW_31); 

            			newLeafNode(otherlv_1, grammarAccess.getActionWithParamsAccess().getLeftParenthesisKeyword_1());
            		
            // InternalMdsl.g:856:3: ( ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )* )?
            int alt16=2;
            int LA16_0 = input.LA(1);

            if ( (LA16_0==RULE_STRING) ) {
                alt16=1;
            }
            switch (alt16) {
                case 1 :
                    // InternalMdsl.g:857:4: ( (lv_params_2_0= RULE_STRING ) ) (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )*
                    {
                    // InternalMdsl.g:857:4: ( (lv_params_2_0= RULE_STRING ) )
                    // InternalMdsl.g:858:5: (lv_params_2_0= RULE_STRING )
                    {
                    // InternalMdsl.g:858:5: (lv_params_2_0= RULE_STRING )
                    // InternalMdsl.g:859:6: lv_params_2_0= RULE_STRING
                    {
                    lv_params_2_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

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

                    // InternalMdsl.g:875:4: (otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) ) )*
                    loop15:
                    do {
                        int alt15=2;
                        int LA15_0 = input.LA(1);

                        if ( (LA15_0==16) ) {
                            alt15=1;
                        }


                        switch (alt15) {
                    	case 1 :
                    	    // InternalMdsl.g:876:5: otherlv_3= ',' ( (lv_params_4_0= RULE_STRING ) )
                    	    {
                    	    otherlv_3=(Token)match(input,16,FOLLOW_10); 

                    	    					newLeafNode(otherlv_3, grammarAccess.getActionWithParamsAccess().getCommaKeyword_2_1_0());
                    	    				
                    	    // InternalMdsl.g:880:5: ( (lv_params_4_0= RULE_STRING ) )
                    	    // InternalMdsl.g:881:6: (lv_params_4_0= RULE_STRING )
                    	    {
                    	    // InternalMdsl.g:881:6: (lv_params_4_0= RULE_STRING )
                    	    // InternalMdsl.g:882:7: lv_params_4_0= RULE_STRING
                    	    {
                    	    lv_params_4_0=(Token)match(input,RULE_STRING,FOLLOW_32); 

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
                    	    break loop15;
                        }
                    } while (true);


                    }
                    break;

            }

            otherlv_5=(Token)match(input,36,FOLLOW_2); 

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
    // InternalMdsl.g:908:1: entryRuleAction returns [EObject current=null] : iv_ruleAction= ruleAction EOF ;
    public final EObject entryRuleAction() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleAction = null;


        try {
            // InternalMdsl.g:908:47: (iv_ruleAction= ruleAction EOF )
            // InternalMdsl.g:909:2: iv_ruleAction= ruleAction EOF
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
    // InternalMdsl.g:915:1: ruleAction returns [EObject current=null] : (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) ;
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


        	enterRule();

        try {
            // InternalMdsl.g:921:2: ( (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) ) )
            // InternalMdsl.g:922:2: (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) )
            {
            // InternalMdsl.g:922:2: (otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) ) )
            // InternalMdsl.g:923:3: otherlv_0= 'Action' ( (lv_name_1_0= RULE_ID ) ) (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )? (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )? otherlv_6= 'shellCmd' ( (lv_shellCmd_7_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,37,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
            		
            // InternalMdsl.g:927:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:928:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:928:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:929:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_33); 

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

            // InternalMdsl.g:945:3: (otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) ) )?
            int alt17=2;
            int LA17_0 = input.LA(1);

            if ( (LA17_0==26) ) {
                alt17=1;
            }
            switch (alt17) {
                case 1 :
                    // InternalMdsl.g:946:4: otherlv_2= 'extends' ( (otherlv_3= RULE_ID ) )
                    {
                    otherlv_2=(Token)match(input,26,FOLLOW_4); 

                    				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getExtendsKeyword_2_0());
                    			
                    // InternalMdsl.g:950:4: ( (otherlv_3= RULE_ID ) )
                    // InternalMdsl.g:951:5: (otherlv_3= RULE_ID )
                    {
                    // InternalMdsl.g:951:5: (otherlv_3= RULE_ID )
                    // InternalMdsl.g:952:6: otherlv_3= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getActionRule());
                    						}
                    					
                    otherlv_3=(Token)match(input,RULE_ID,FOLLOW_34); 

                    						newLeafNode(otherlv_3, grammarAccess.getActionAccess().getSuperActionActionCrossReference_2_1_0());
                    					

                    }


                    }


                    }
                    break;

            }

            // InternalMdsl.g:964:3: (otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) ) )?
            int alt18=2;
            int LA18_0 = input.LA(1);

            if ( (LA18_0==27) ) {
                alt18=1;
            }
            switch (alt18) {
                case 1 :
                    // InternalMdsl.g:965:4: otherlv_4= 'description' ( (lv_description_5_0= RULE_STRING ) )
                    {
                    otherlv_4=(Token)match(input,27,FOLLOW_10); 

                    				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getDescriptionKeyword_3_0());
                    			
                    // InternalMdsl.g:969:4: ( (lv_description_5_0= RULE_STRING ) )
                    // InternalMdsl.g:970:5: (lv_description_5_0= RULE_STRING )
                    {
                    // InternalMdsl.g:970:5: (lv_description_5_0= RULE_STRING )
                    // InternalMdsl.g:971:6: lv_description_5_0= RULE_STRING
                    {
                    lv_description_5_0=(Token)match(input,RULE_STRING,FOLLOW_35); 

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

            otherlv_6=(Token)match(input,38,FOLLOW_10); 

            			newLeafNode(otherlv_6, grammarAccess.getActionAccess().getShellCmdKeyword_4());
            		
            // InternalMdsl.g:992:3: ( (lv_shellCmd_7_0= RULE_STRING ) )
            // InternalMdsl.g:993:4: (lv_shellCmd_7_0= RULE_STRING )
            {
            // InternalMdsl.g:993:4: (lv_shellCmd_7_0= RULE_STRING )
            // InternalMdsl.g:994:5: lv_shellCmd_7_0= RULE_STRING
            {
            lv_shellCmd_7_0=(Token)match(input,RULE_STRING,FOLLOW_2); 

            					newLeafNode(lv_shellCmd_7_0, grammarAccess.getActionAccess().getShellCmdSTRINGTerminalRuleCall_5_0());
            				

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
    // InternalMdsl.g:1014:1: entryRuleRule returns [EObject current=null] : iv_ruleRule= ruleRule EOF ;
    public final EObject entryRuleRule() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleRule = null;


        try {
            // InternalMdsl.g:1014:45: (iv_ruleRule= ruleRule EOF )
            // InternalMdsl.g:1015:2: iv_ruleRule= ruleRule EOF
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
    // InternalMdsl.g:1021:1: ruleRule returns [EObject current=null] : (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? ) ;
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
            // InternalMdsl.g:1027:2: ( (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? ) )
            // InternalMdsl.g:1028:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? )
            {
            // InternalMdsl.g:1028:2: (otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )? )
            // InternalMdsl.g:1029:3: otherlv_0= 'Rule' ( (lv_description_1_0= RULE_STRING ) ) otherlv_2= 'if' ( (otherlv_3= RULE_ID ) ) (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )? otherlv_13= 'then' ( (otherlv_14= RULE_ID ) ) (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )?
            {
            otherlv_0=(Token)match(input,39,FOLLOW_10); 

            			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
            		
            // InternalMdsl.g:1033:3: ( (lv_description_1_0= RULE_STRING ) )
            // InternalMdsl.g:1034:4: (lv_description_1_0= RULE_STRING )
            {
            // InternalMdsl.g:1034:4: (lv_description_1_0= RULE_STRING )
            // InternalMdsl.g:1035:5: lv_description_1_0= RULE_STRING
            {
            lv_description_1_0=(Token)match(input,RULE_STRING,FOLLOW_36); 

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

            otherlv_2=(Token)match(input,40,FOLLOW_4); 

            			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getIfKeyword_2());
            		
            // InternalMdsl.g:1055:3: ( (otherlv_3= RULE_ID ) )
            // InternalMdsl.g:1056:4: (otherlv_3= RULE_ID )
            {
            // InternalMdsl.g:1056:4: (otherlv_3= RULE_ID )
            // InternalMdsl.g:1057:5: otherlv_3= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				
            otherlv_3=(Token)match(input,RULE_ID,FOLLOW_37); 

            					newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getIfEventCrossReference_3_0());
            				

            }


            }

            // InternalMdsl.g:1068:3: (otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')' )?
            int alt20=2;
            int LA20_0 = input.LA(1);

            if ( (LA20_0==41) ) {
                alt20=1;
            }
            switch (alt20) {
                case 1 :
                    // InternalMdsl.g:1069:4: otherlv_4= 'and' otherlv_5= 'current' otherlv_6= 'mode' otherlv_7= 'in' otherlv_8= '(' ( (otherlv_9= RULE_ID ) ) (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )* otherlv_12= ')'
                    {
                    otherlv_4=(Token)match(input,41,FOLLOW_38); 

                    				newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getAndKeyword_4_0());
                    			
                    otherlv_5=(Token)match(input,42,FOLLOW_39); 

                    				newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getCurrentKeyword_4_1());
                    			
                    otherlv_6=(Token)match(input,43,FOLLOW_40); 

                    				newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getModeKeyword_4_2());
                    			
                    otherlv_7=(Token)match(input,44,FOLLOW_30); 

                    				newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getInKeyword_4_3());
                    			
                    otherlv_8=(Token)match(input,35,FOLLOW_4); 

                    				newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_4_4());
                    			
                    // InternalMdsl.g:1089:4: ( (otherlv_9= RULE_ID ) )
                    // InternalMdsl.g:1090:5: (otherlv_9= RULE_ID )
                    {
                    // InternalMdsl.g:1090:5: (otherlv_9= RULE_ID )
                    // InternalMdsl.g:1091:6: otherlv_9= RULE_ID
                    {

                    						if (current==null) {
                    							current = createModelElement(grammarAccess.getRuleRule());
                    						}
                    					
                    otherlv_9=(Token)match(input,RULE_ID,FOLLOW_32); 

                    						newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getCurrentModeModeCrossReference_4_5_0());
                    					

                    }


                    }

                    // InternalMdsl.g:1102:4: (otherlv_10= ',' ( (otherlv_11= RULE_ID ) ) )*
                    loop19:
                    do {
                        int alt19=2;
                        int LA19_0 = input.LA(1);

                        if ( (LA19_0==16) ) {
                            alt19=1;
                        }


                        switch (alt19) {
                    	case 1 :
                    	    // InternalMdsl.g:1103:5: otherlv_10= ',' ( (otherlv_11= RULE_ID ) )
                    	    {
                    	    otherlv_10=(Token)match(input,16,FOLLOW_4); 

                    	    					newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getCommaKeyword_4_6_0());
                    	    				
                    	    // InternalMdsl.g:1107:5: ( (otherlv_11= RULE_ID ) )
                    	    // InternalMdsl.g:1108:6: (otherlv_11= RULE_ID )
                    	    {
                    	    // InternalMdsl.g:1108:6: (otherlv_11= RULE_ID )
                    	    // InternalMdsl.g:1109:7: otherlv_11= RULE_ID
                    	    {

                    	    							if (current==null) {
                    	    								current = createModelElement(grammarAccess.getRuleRule());
                    	    							}
                    	    						
                    	    otherlv_11=(Token)match(input,RULE_ID,FOLLOW_32); 

                    	    							newLeafNode(otherlv_11, grammarAccess.getRuleAccess().getModesModeCrossReference_4_6_1_0());
                    	    						

                    	    }


                    	    }


                    	    }
                    	    break;

                    	default :
                    	    break loop19;
                        }
                    } while (true);

                    otherlv_12=(Token)match(input,36,FOLLOW_41); 

                    				newLeafNode(otherlv_12, grammarAccess.getRuleAccess().getRightParenthesisKeyword_4_7());
                    			

                    }
                    break;

            }

            otherlv_13=(Token)match(input,45,FOLLOW_4); 

            			newLeafNode(otherlv_13, grammarAccess.getRuleAccess().getThenKeyword_5());
            		
            // InternalMdsl.g:1130:3: ( (otherlv_14= RULE_ID ) )
            // InternalMdsl.g:1131:4: (otherlv_14= RULE_ID )
            {
            // InternalMdsl.g:1131:4: (otherlv_14= RULE_ID )
            // InternalMdsl.g:1132:5: otherlv_14= RULE_ID
            {

            					if (current==null) {
            						current = createModelElement(grammarAccess.getRuleRule());
            					}
            				
            otherlv_14=(Token)match(input,RULE_ID,FOLLOW_42); 

            					newLeafNode(otherlv_14, grammarAccess.getRuleAccess().getThenModeCrossReference_6_0());
            				

            }


            }

            // InternalMdsl.g:1143:3: (otherlv_15= 'else' ( (otherlv_16= RULE_ID ) ) )?
            int alt21=2;
            int LA21_0 = input.LA(1);

            if ( (LA21_0==46) ) {
                alt21=1;
            }
            switch (alt21) {
                case 1 :
                    // InternalMdsl.g:1144:4: otherlv_15= 'else' ( (otherlv_16= RULE_ID ) )
                    {
                    otherlv_15=(Token)match(input,46,FOLLOW_4); 

                    				newLeafNode(otherlv_15, grammarAccess.getRuleAccess().getElseKeyword_7_0());
                    			
                    // InternalMdsl.g:1148:4: ( (otherlv_16= RULE_ID ) )
                    // InternalMdsl.g:1149:5: (otherlv_16= RULE_ID )
                    {
                    // InternalMdsl.g:1149:5: (otherlv_16= RULE_ID )
                    // InternalMdsl.g:1150:6: otherlv_16= RULE_ID
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
    // InternalMdsl.g:1166:1: entryRuleEvent returns [EObject current=null] : iv_ruleEvent= ruleEvent EOF ;
    public final EObject entryRuleEvent() throws RecognitionException {
        EObject current = null;

        EObject iv_ruleEvent = null;


        try {
            // InternalMdsl.g:1166:46: (iv_ruleEvent= ruleEvent EOF )
            // InternalMdsl.g:1167:2: iv_ruleEvent= ruleEvent EOF
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
    // InternalMdsl.g:1173:1: ruleEvent returns [EObject current=null] : (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) ;
    public final EObject ruleEvent() throws RecognitionException {
        EObject current = null;

        Token otherlv_0=null;
        Token lv_name_1_0=null;
        Token otherlv_2=null;
        Token lv_description_3_0=null;


        	enterRule();

        try {
            // InternalMdsl.g:1179:2: ( (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) ) )
            // InternalMdsl.g:1180:2: (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            {
            // InternalMdsl.g:1180:2: (otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) ) )
            // InternalMdsl.g:1181:3: otherlv_0= 'Event' ( (lv_name_1_0= RULE_ID ) ) otherlv_2= 'description' ( (lv_description_3_0= RULE_STRING ) )
            {
            otherlv_0=(Token)match(input,47,FOLLOW_4); 

            			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
            		
            // InternalMdsl.g:1185:3: ( (lv_name_1_0= RULE_ID ) )
            // InternalMdsl.g:1186:4: (lv_name_1_0= RULE_ID )
            {
            // InternalMdsl.g:1186:4: (lv_name_1_0= RULE_ID )
            // InternalMdsl.g:1187:5: lv_name_1_0= RULE_ID
            {
            lv_name_1_0=(Token)match(input,RULE_ID,FOLLOW_18); 

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

            otherlv_2=(Token)match(input,27,FOLLOW_10); 

            			newLeafNode(otherlv_2, grammarAccess.getEventAccess().getDescriptionKeyword_2());
            		
            // InternalMdsl.g:1207:3: ( (lv_description_3_0= RULE_STRING ) )
            // InternalMdsl.g:1208:4: (lv_description_3_0= RULE_STRING )
            {
            // InternalMdsl.g:1208:4: (lv_description_3_0= RULE_STRING )
            // InternalMdsl.g:1209:5: lv_description_3_0= RULE_STRING
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


    // $ANTLR start "ruleEnabled"
    // InternalMdsl.g:1229:1: ruleEnabled returns [Enumerator current=null] : ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) ;
    public final Enumerator ruleEnabled() throws RecognitionException {
        Enumerator current = null;

        Token enumLiteral_0=null;
        Token enumLiteral_1=null;


        	enterRule();

        try {
            // InternalMdsl.g:1235:2: ( ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) ) )
            // InternalMdsl.g:1236:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            {
            // InternalMdsl.g:1236:2: ( (enumLiteral_0= 'true' ) | (enumLiteral_1= 'false' ) )
            int alt22=2;
            int LA22_0 = input.LA(1);

            if ( (LA22_0==48) ) {
                alt22=1;
            }
            else if ( (LA22_0==49) ) {
                alt22=2;
            }
            else {
                NoViableAltException nvae =
                    new NoViableAltException("", 22, 0, input);

                throw nvae;
            }
            switch (alt22) {
                case 1 :
                    // InternalMdsl.g:1237:3: (enumLiteral_0= 'true' )
                    {
                    // InternalMdsl.g:1237:3: (enumLiteral_0= 'true' )
                    // InternalMdsl.g:1238:4: enumLiteral_0= 'true'
                    {
                    enumLiteral_0=(Token)match(input,48,FOLLOW_2); 

                    				current = grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
                    				newLeafNode(enumLiteral_0, grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0());
                    			

                    }


                    }
                    break;
                case 2 :
                    // InternalMdsl.g:1245:3: (enumLiteral_1= 'false' )
                    {
                    // InternalMdsl.g:1245:3: (enumLiteral_1= 'false' )
                    // InternalMdsl.g:1246:4: enumLiteral_1= 'false'
                    {
                    enumLiteral_1=(Token)match(input,49,FOLLOW_2); 

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
    public static final BitSet FOLLOW_3 = new BitSet(new long[]{0x000080A082081002L});
    public static final BitSet FOLLOW_4 = new BitSet(new long[]{0x0000000000000010L});
    public static final BitSet FOLLOW_5 = new BitSet(new long[]{0x0000000000002000L});
    public static final BitSet FOLLOW_6 = new BitSet(new long[]{0x0000000000004000L});
    public static final BitSet FOLLOW_7 = new BitSet(new long[]{0x0000000000008000L});
    public static final BitSet FOLLOW_8 = new BitSet(new long[]{0x0000000000020010L});
    public static final BitSet FOLLOW_9 = new BitSet(new long[]{0x0000000000030000L});
    public static final BitSet FOLLOW_10 = new BitSet(new long[]{0x0000000000000020L});
    public static final BitSet FOLLOW_11 = new BitSet(new long[]{0x0000000000040000L});
    public static final BitSet FOLLOW_12 = new BitSet(new long[]{0x0000000000100000L});
    public static final BitSet FOLLOW_13 = new BitSet(new long[]{0x0000000000200000L});
    public static final BitSet FOLLOW_14 = new BitSet(new long[]{0x0000000000400000L});
    public static final BitSet FOLLOW_15 = new BitSet(new long[]{0x0000000000800000L});
    public static final BitSet FOLLOW_16 = new BitSet(new long[]{0x0000000001000000L});
    public static final BitSet FOLLOW_17 = new BitSet(new long[]{0x000000000C000000L});
    public static final BitSet FOLLOW_18 = new BitSet(new long[]{0x0000000008000000L});
    public static final BitSet FOLLOW_19 = new BitSet(new long[]{0x0000000010000000L});
    public static final BitSet FOLLOW_20 = new BitSet(new long[]{0x0000000000000040L});
    public static final BitSet FOLLOW_21 = new BitSet(new long[]{0x0000000020000000L});
    public static final BitSet FOLLOW_22 = new BitSet(new long[]{0x0000000040000010L});
    public static final BitSet FOLLOW_23 = new BitSet(new long[]{0x0000000040010000L});
    public static final BitSet FOLLOW_24 = new BitSet(new long[]{0x0003000000000012L});
    public static final BitSet FOLLOW_25 = new BitSet(new long[]{0x0003000000010002L});
    public static final BitSet FOLLOW_26 = new BitSet(new long[]{0x0000000300000000L});
    public static final BitSet FOLLOW_27 = new BitSet(new long[]{0x0000000200010000L});
    public static final BitSet FOLLOW_28 = new BitSet(new long[]{0x0000000400010000L});
    public static final BitSet FOLLOW_29 = new BitSet(new long[]{0x0000000000010002L});
    public static final BitSet FOLLOW_30 = new BitSet(new long[]{0x0000000800000000L});
    public static final BitSet FOLLOW_31 = new BitSet(new long[]{0x0000001000000020L});
    public static final BitSet FOLLOW_32 = new BitSet(new long[]{0x0000001000010000L});
    public static final BitSet FOLLOW_33 = new BitSet(new long[]{0x000000400C000000L});
    public static final BitSet FOLLOW_34 = new BitSet(new long[]{0x0000004008000000L});
    public static final BitSet FOLLOW_35 = new BitSet(new long[]{0x0000004000000000L});
    public static final BitSet FOLLOW_36 = new BitSet(new long[]{0x0000010000000000L});
    public static final BitSet FOLLOW_37 = new BitSet(new long[]{0x0000220000000000L});
    public static final BitSet FOLLOW_38 = new BitSet(new long[]{0x0000040000000000L});
    public static final BitSet FOLLOW_39 = new BitSet(new long[]{0x0000080000000000L});
    public static final BitSet FOLLOW_40 = new BitSet(new long[]{0x0000100000000000L});
    public static final BitSet FOLLOW_41 = new BitSet(new long[]{0x0000200000000000L});
    public static final BitSet FOLLOW_42 = new BitSet(new long[]{0x0000400000000002L});

}