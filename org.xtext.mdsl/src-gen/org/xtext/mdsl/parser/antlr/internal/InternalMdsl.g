/*
 * generated by Xtext 2.25.0
 */
grammar InternalMdsl;

options {
	superClass=AbstractInternalAntlrParser;
}

@lexer::header {
package org.xtext.mdsl.parser.antlr.internal;

// Hack: Use our own Lexer superclass by means of import. 
// Currently there is no other way to specify the superclass for the lexer.
import org.eclipse.xtext.parser.antlr.Lexer;
}

@parser::header {
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

}

@parser::members {

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

}

@rulecatch {
    catch (RecognitionException re) {
        recover(input,re);
        appendSkippedTokens();
    }
}

// Entry rule entryRuleModel
entryRuleModel returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModelRule()); }
	iv_ruleModel=ruleModel
	{ $current=$iv_ruleModel.current; }
	EOF;

// Rule Model
ruleModel returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			{
				newCompositeNode(grammarAccess.getModelAccess().getDeclarationsDeclarationParserRuleCall_0());
			}
			lv_declarations_0_0=ruleDeclaration
			{
				if ($current==null) {
					$current = createModelElementForParent(grammarAccess.getModelRule());
				}
				add(
					$current,
					"declarations",
					lv_declarations_0_0,
					"org.xtext.mdsl.Mdsl.Declaration");
				afterParserOrEnumRuleCall();
			}
		)
	)*
;

// Entry rule entryRuleDeclaration
entryRuleDeclaration returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getDeclarationRule()); }
	iv_ruleDeclaration=ruleDeclaration
	{ $current=$iv_ruleDeclaration.current; }
	EOF;

// Rule Declaration
ruleDeclaration returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getSystemParserRuleCall_0());
		}
		this_System_0=ruleSystem
		{
			$current = $this_System_0.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getSoftwareParserRuleCall_1());
		}
		this_Software_1=ruleSoftware
		{
			$current = $this_Software_1.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getModeParserRuleCall_2());
		}
		this_Mode_2=ruleMode
		{
			$current = $this_Mode_2.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getServiceParserRuleCall_3());
		}
		this_Service_3=ruleService
		{
			$current = $this_Service_3.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getActionParserRuleCall_4());
		}
		this_Action_4=ruleAction
		{
			$current = $this_Action_4.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getRuleParserRuleCall_5());
		}
		this_Rule_5=ruleRule
		{
			$current = $this_Rule_5.current;
			afterParserOrEnumRuleCall();
		}
		    |
		{
			newCompositeNode(grammarAccess.getDeclarationAccess().getEventParserRuleCall_6());
		}
		this_Event_6=ruleEvent
		{
			$current = $this_Event_6.current;
			afterParserOrEnumRuleCall();
		}
	)
;

// Entry rule entryRuleSystem
entryRuleSystem returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSystemRule()); }
	iv_ruleSystem=ruleSystem
	{ $current=$iv_ruleSystem.current; }
	EOF;

// Rule System
ruleSystem returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='System'
		{
			newLeafNode(otherlv_0, grammarAccess.getSystemAccess().getSystemKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSystemAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSystemRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='has'
		{
			newLeafNode(otherlv_2, grammarAccess.getSystemAccess().getHasKeyword_2());
		}
		otherlv_3='following'
		{
			newLeafNode(otherlv_3, grammarAccess.getSystemAccess().getFollowingKeyword_3());
		}
		otherlv_4='modes'
		{
			newLeafNode(otherlv_4, grammarAccess.getSystemAccess().getModesKeyword_4());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSystemRule());
						}
					}
					otherlv_5=RULE_ID
					{
						newLeafNode(otherlv_5, grammarAccess.getSystemAccess().getModesModeCrossReference_5_0_0());
					}
				)
			)
			(
				otherlv_6=','
				{
					newLeafNode(otherlv_6, grammarAccess.getSystemAccess().getCommaKeyword_5_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getSystemRule());
							}
						}
						otherlv_7=RULE_ID
						{
							newLeafNode(otherlv_7, grammarAccess.getSystemAccess().getModesModeCrossReference_5_1_1_0());
						}
					)
				)
			)*
		)?
		(
			otherlv_8='operatingSystem'
			{
				newLeafNode(otherlv_8, grammarAccess.getSystemAccess().getOperatingSystemKeyword_6_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getOperatingSystemSUPPORTED_OPERATING_SYSTEMSEnumRuleCall_6_1_0());
					}
					lv_operatingSystem_9_0=ruleSUPPORTED_OPERATING_SYSTEMS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						set(
							$current,
							"operatingSystem",
							lv_operatingSystem_9_0,
							"org.xtext.mdsl.Mdsl.SUPPORTED_OPERATING_SYSTEMS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_10='distribution'
			{
				newLeafNode(otherlv_10, grammarAccess.getSystemAccess().getDistributionKeyword_7_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getDistributionSUPPORTED_DISTRIBUTIONSEnumRuleCall_7_1_0());
					}
					lv_distribution_11_0=ruleSUPPORTED_DISTRIBUTIONS
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						set(
							$current,
							"distribution",
							lv_distribution_11_0,
							"org.xtext.mdsl.Mdsl.SUPPORTED_DISTRIBUTIONS");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
		(
			otherlv_12='release'
			{
				newLeafNode(otherlv_12, grammarAccess.getSystemAccess().getReleaseKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getSystemAccess().getReleaseSUPPORTED_RELEASESEnumRuleCall_8_1_0());
					}
					lv_release_13_0=ruleSUPPORTED_RELEASES
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getSystemRule());
						}
						set(
							$current,
							"release",
							lv_release_13_0,
							"org.xtext.mdsl.Mdsl.SUPPORTED_RELEASES");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleSoftware
entryRuleSoftware returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getSoftwareRule()); }
	iv_ruleSoftware=ruleSoftware
	{ $current=$iv_ruleSoftware.current; }
	EOF;

// Rule Software
ruleSoftware returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Software'
		{
			newLeafNode(otherlv_0, grammarAccess.getSoftwareAccess().getSoftwareKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getSoftwareAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getSoftwareRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='vendor'
			{
				newLeafNode(otherlv_2, grammarAccess.getSoftwareAccess().getVendorKeyword_2_0());
			}
			(
				(
					lv_vendor_3_0=RULE_STRING
					{
						newLeafNode(lv_vendor_3_0, grammarAccess.getSoftwareAccess().getVendorSTRINGTerminalRuleCall_2_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSoftwareRule());
						}
						setWithLastConsumed(
							$current,
							"vendor",
							lv_vendor_3_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
		(
			otherlv_4='product'
			{
				newLeafNode(otherlv_4, grammarAccess.getSoftwareAccess().getProductKeyword_3_0());
			}
			(
				(
					lv_product_5_0=RULE_STRING
					{
						newLeafNode(lv_product_5_0, grammarAccess.getSoftwareAccess().getProductSTRINGTerminalRuleCall_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSoftwareRule());
						}
						setWithLastConsumed(
							$current,
							"product",
							lv_product_5_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
		(
			otherlv_6='version'
			{
				newLeafNode(otherlv_6, grammarAccess.getSoftwareAccess().getVersionKeyword_4_0());
			}
			(
				(
					lv_version_7_0=RULE_STRING
					{
						newLeafNode(lv_version_7_0, grammarAccess.getSoftwareAccess().getVersionSTRINGTerminalRuleCall_4_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSoftwareRule());
						}
						setWithLastConsumed(
							$current,
							"version",
							lv_version_7_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
		(
			otherlv_8='package'
			{
				newLeafNode(otherlv_8, grammarAccess.getSoftwareAccess().getPackageKeyword_5_0());
			}
			(
				(
					lv_package_9_0=RULE_STRING
					{
						newLeafNode(lv_package_9_0, grammarAccess.getSoftwareAccess().getPackageSTRINGTerminalRuleCall_5_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getSoftwareRule());
						}
						setWithLastConsumed(
							$current,
							"package",
							lv_package_9_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleMode
entryRuleMode returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getModeRule()); }
	iv_ruleMode=ruleMode
	{ $current=$iv_ruleMode.current; }
	EOF;

// Rule Mode
ruleMode returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Mode'
		{
			newLeafNode(otherlv_0, grammarAccess.getModeAccess().getModeKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getModeAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModeRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='extends'
			{
				newLeafNode(otherlv_2, grammarAccess.getModeAccess().getExtendsKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getModeRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getModeAccess().getSuperModeModeCrossReference_2_1_0());
					}
				)
			)
		)?
		otherlv_4='description'
		{
			newLeafNode(otherlv_4, grammarAccess.getModeAccess().getDescriptionKeyword_3());
		}
		(
			(
				lv_description_5_0=RULE_STRING
				{
					newLeafNode(lv_description_5_0, grammarAccess.getModeAccess().getDescriptionSTRINGTerminalRuleCall_4_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModeRule());
					}
					setWithLastConsumed(
						$current,
						"description",
						lv_description_5_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_6='priority'
		{
			newLeafNode(otherlv_6, grammarAccess.getModeAccess().getPriorityKeyword_5());
		}
		(
			(
				lv_priority_7_0=RULE_INT
				{
					newLeafNode(lv_priority_7_0, grammarAccess.getModeAccess().getPriorityINTTerminalRuleCall_6_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getModeRule());
					}
					setWithLastConsumed(
						$current,
						"priority",
						lv_priority_7_0,
						"org.eclipse.xtext.common.Terminals.INT");
				}
			)
		)
		otherlv_8='startServices'
		{
			newLeafNode(otherlv_8, grammarAccess.getModeAccess().getStartServicesKeyword_7());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getModeRule());
						}
					}
					otherlv_9=RULE_ID
					{
						newLeafNode(otherlv_9, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_0_0());
					}
				)
			)
			(
				otherlv_10=','
				{
					newLeafNode(otherlv_10, grammarAccess.getModeAccess().getCommaKeyword_8_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getModeRule());
							}
						}
						otherlv_11=RULE_ID
						{
							newLeafNode(otherlv_11, grammarAccess.getModeAccess().getStartServicesServiceCrossReference_8_1_1_0());
						}
					)
				)
			)*
		)?
		otherlv_12='stopServices'
		{
			newLeafNode(otherlv_12, grammarAccess.getModeAccess().getStopServicesKeyword_9());
		}
		(
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getModeRule());
						}
					}
					otherlv_13=RULE_ID
					{
						newLeafNode(otherlv_13, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_0_0());
					}
				)
			)
			(
				otherlv_14=','
				{
					newLeafNode(otherlv_14, grammarAccess.getModeAccess().getCommaKeyword_10_1_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getModeRule());
							}
						}
						otherlv_15=RULE_ID
						{
							newLeafNode(otherlv_15, grammarAccess.getModeAccess().getStopServicesServiceCrossReference_10_1_1_0());
						}
					)
				)
			)*
		)?
		(
			(
				{
					newCompositeNode(grammarAccess.getModeAccess().getEnabledEnabledEnumRuleCall_11_0());
				}
				lv_enabled_16_0=ruleEnabled
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getModeRule());
					}
					set(
						$current,
						"enabled",
						lv_enabled_16_0,
						"org.xtext.mdsl.Mdsl.Enabled");
					afterParserOrEnumRuleCall();
				}
			)
		)?
		(
			otherlv_17='exchangeable'
			{
				newLeafNode(otherlv_17, grammarAccess.getModeAccess().getExchangeableKeyword_12_0());
			}
			otherlv_18='with'
			{
				newLeafNode(otherlv_18, grammarAccess.getModeAccess().getWithKeyword_12_1());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getModeRule());
						}
					}
					otherlv_19=RULE_ID
					{
						newLeafNode(otherlv_19, grammarAccess.getModeAccess().getAlternativeModeModeCrossReference_12_2_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleService
entryRuleService returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getServiceRule()); }
	iv_ruleService=ruleService
	{ $current=$iv_ruleService.current; }
	EOF;

// Rule Service
ruleService returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Service'
		{
			newLeafNode(otherlv_0, grammarAccess.getServiceAccess().getServiceKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getServiceAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getServiceRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='usesSoftware'
			{
				newLeafNode(otherlv_2, grammarAccess.getServiceAccess().getUsesSoftwareKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getServiceRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_1_0());
					}
				)
			)
			(
				otherlv_4=','
				{
					newLeafNode(otherlv_4, grammarAccess.getServiceAccess().getCommaKeyword_2_2_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getServiceRule());
							}
						}
						otherlv_5=RULE_ID
						{
							newLeafNode(otherlv_5, grammarAccess.getServiceAccess().getUsesSoftwareSoftwareCrossReference_2_2_1_0());
						}
					)
				)
			)*
		)?
		otherlv_6='startActions'
		{
			newLeafNode(otherlv_6, grammarAccess.getServiceAccess().getStartActionsKeyword_3());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_4_0());
				}
				lv_startActions_7_0=ruleActionWithParams
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getServiceRule());
					}
					add(
						$current,
						"startActions",
						lv_startActions_7_0,
						"org.xtext.mdsl.Mdsl.ActionWithParams");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_8=','
			{
				newLeafNode(otherlv_8, grammarAccess.getServiceAccess().getCommaKeyword_5_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getServiceAccess().getStartActionsActionWithParamsParserRuleCall_5_1_0());
					}
					lv_startActions_9_0=ruleActionWithParams
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getServiceRule());
						}
						add(
							$current,
							"startActions",
							lv_startActions_9_0,
							"org.xtext.mdsl.Mdsl.ActionWithParams");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
		otherlv_10='stopActions'
		{
			newLeafNode(otherlv_10, grammarAccess.getServiceAccess().getStopActionsKeyword_6());
		}
		(
			(
				{
					newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_7_0());
				}
				lv_stopActions_11_0=ruleActionWithParams
				{
					if ($current==null) {
						$current = createModelElementForParent(grammarAccess.getServiceRule());
					}
					add(
						$current,
						"stopActions",
						lv_stopActions_11_0,
						"org.xtext.mdsl.Mdsl.ActionWithParams");
					afterParserOrEnumRuleCall();
				}
			)
		)
		(
			otherlv_12=','
			{
				newLeafNode(otherlv_12, grammarAccess.getServiceAccess().getCommaKeyword_8_0());
			}
			(
				(
					{
						newCompositeNode(grammarAccess.getServiceAccess().getStopActionsActionWithParamsParserRuleCall_8_1_0());
					}
					lv_stopActions_13_0=ruleActionWithParams
					{
						if ($current==null) {
							$current = createModelElementForParent(grammarAccess.getServiceRule());
						}
						add(
							$current,
							"stopActions",
							lv_stopActions_13_0,
							"org.xtext.mdsl.Mdsl.ActionWithParams");
						afterParserOrEnumRuleCall();
					}
				)
			)
		)*
	)
;

// Entry rule entryRuleActionWithParams
entryRuleActionWithParams returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActionWithParamsRule()); }
	iv_ruleActionWithParams=ruleActionWithParams
	{ $current=$iv_ruleActionWithParams.current; }
	EOF;

// Rule ActionWithParams
ruleActionWithParams returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActionWithParamsRule());
					}
				}
				otherlv_0=RULE_ID
				{
					newLeafNode(otherlv_0, grammarAccess.getActionWithParamsAccess().getActionActionCrossReference_0_0());
				}
			)
		)
		otherlv_1='('
		{
			newLeafNode(otherlv_1, grammarAccess.getActionWithParamsAccess().getLeftParenthesisKeyword_1());
		}
		(
			(
				(
					lv_params_2_0=RULE_STRING
					{
						newLeafNode(lv_params_2_0, grammarAccess.getActionWithParamsAccess().getParamsSTRINGTerminalRuleCall_2_0_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getActionWithParamsRule());
						}
						addWithLastConsumed(
							$current,
							"params",
							lv_params_2_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
			(
				otherlv_3=','
				{
					newLeafNode(otherlv_3, grammarAccess.getActionWithParamsAccess().getCommaKeyword_2_1_0());
				}
				(
					(
						lv_params_4_0=RULE_STRING
						{
							newLeafNode(lv_params_4_0, grammarAccess.getActionWithParamsAccess().getParamsSTRINGTerminalRuleCall_2_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getActionWithParamsRule());
							}
							addWithLastConsumed(
								$current,
								"params",
								lv_params_4_0,
								"org.eclipse.xtext.common.Terminals.STRING");
						}
					)
				)
			)*
		)?
		otherlv_5=')'
		{
			newLeafNode(otherlv_5, grammarAccess.getActionWithParamsAccess().getRightParenthesisKeyword_3());
		}
	)
;

// Entry rule entryRuleAction
entryRuleAction returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getActionRule()); }
	iv_ruleAction=ruleAction
	{ $current=$iv_ruleAction.current; }
	EOF;

// Rule Action
ruleAction returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Action'
		{
			newLeafNode(otherlv_0, grammarAccess.getActionAccess().getActionKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getActionAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getActionRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		(
			otherlv_2='extends'
			{
				newLeafNode(otherlv_2, grammarAccess.getActionAccess().getExtendsKeyword_2_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getActionRule());
						}
					}
					otherlv_3=RULE_ID
					{
						newLeafNode(otherlv_3, grammarAccess.getActionAccess().getSuperActionActionCrossReference_2_1_0());
					}
				)
			)
		)?
		(
			otherlv_4='description'
			{
				newLeafNode(otherlv_4, grammarAccess.getActionAccess().getDescriptionKeyword_3_0());
			}
			(
				(
					lv_description_5_0=RULE_STRING
					{
						newLeafNode(lv_description_5_0, grammarAccess.getActionAccess().getDescriptionSTRINGTerminalRuleCall_3_1_0());
					}
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getActionRule());
						}
						setWithLastConsumed(
							$current,
							"description",
							lv_description_5_0,
							"org.eclipse.xtext.common.Terminals.STRING");
					}
				)
			)
		)?
		(
			(
				otherlv_6='shellCmd'
				{
					newLeafNode(otherlv_6, grammarAccess.getActionAccess().getShellCmdKeyword_4_0_0());
				}
				(
					(
						lv_shellCmd_7_0=RULE_STRING
						{
							newLeafNode(lv_shellCmd_7_0, grammarAccess.getActionAccess().getShellCmdSTRINGTerminalRuleCall_4_0_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getActionRule());
							}
							setWithLastConsumed(
								$current,
								"shellCmd",
								lv_shellCmd_7_0,
								"org.eclipse.xtext.common.Terminals.STRING");
						}
					)
				)
			)
			    |
			(
				otherlv_8='params'
				{
					newLeafNode(otherlv_8, grammarAccess.getActionAccess().getParamsKeyword_4_1_0());
				}
				(
					(
						lv_params_9_0=RULE_STRING
						{
							newLeafNode(lv_params_9_0, grammarAccess.getActionAccess().getParamsSTRINGTerminalRuleCall_4_1_1_0());
						}
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getActionRule());
							}
							addWithLastConsumed(
								$current,
								"params",
								lv_params_9_0,
								"org.eclipse.xtext.common.Terminals.STRING");
						}
					)
				)
				(
					otherlv_10=','
					{
						newLeafNode(otherlv_10, grammarAccess.getActionAccess().getCommaKeyword_4_1_2_0());
					}
					(
						(
							lv_params_11_0=RULE_STRING
							{
								newLeafNode(lv_params_11_0, grammarAccess.getActionAccess().getParamsSTRINGTerminalRuleCall_4_1_2_1_0());
							}
							{
								if ($current==null) {
									$current = createModelElement(grammarAccess.getActionRule());
								}
								addWithLastConsumed(
									$current,
									"params",
									lv_params_11_0,
									"org.eclipse.xtext.common.Terminals.STRING");
							}
						)
					)
				)*
			)
		)
	)
;

// Entry rule entryRuleRule
entryRuleRule returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getRuleRule()); }
	iv_ruleRule=ruleRule
	{ $current=$iv_ruleRule.current; }
	EOF;

// Rule Rule
ruleRule returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Rule'
		{
			newLeafNode(otherlv_0, grammarAccess.getRuleAccess().getRuleKeyword_0());
		}
		(
			(
				lv_description_1_0=RULE_STRING
				{
					newLeafNode(lv_description_1_0, grammarAccess.getRuleAccess().getDescriptionSTRINGTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRuleRule());
					}
					setWithLastConsumed(
						$current,
						"description",
						lv_description_1_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
		otherlv_2='if'
		{
			newLeafNode(otherlv_2, grammarAccess.getRuleAccess().getIfKeyword_2());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRuleRule());
					}
				}
				otherlv_3=RULE_ID
				{
					newLeafNode(otherlv_3, grammarAccess.getRuleAccess().getIfEventCrossReference_3_0());
				}
			)
		)
		(
			otherlv_4='and'
			{
				newLeafNode(otherlv_4, grammarAccess.getRuleAccess().getAndKeyword_4_0());
			}
			otherlv_5='current'
			{
				newLeafNode(otherlv_5, grammarAccess.getRuleAccess().getCurrentKeyword_4_1());
			}
			otherlv_6='mode'
			{
				newLeafNode(otherlv_6, grammarAccess.getRuleAccess().getModeKeyword_4_2());
			}
			otherlv_7='in'
			{
				newLeafNode(otherlv_7, grammarAccess.getRuleAccess().getInKeyword_4_3());
			}
			otherlv_8='('
			{
				newLeafNode(otherlv_8, grammarAccess.getRuleAccess().getLeftParenthesisKeyword_4_4());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRuleRule());
						}
					}
					otherlv_9=RULE_ID
					{
						newLeafNode(otherlv_9, grammarAccess.getRuleAccess().getCurrentModeModeCrossReference_4_5_0());
					}
				)
			)
			(
				otherlv_10=','
				{
					newLeafNode(otherlv_10, grammarAccess.getRuleAccess().getCommaKeyword_4_6_0());
				}
				(
					(
						{
							if ($current==null) {
								$current = createModelElement(grammarAccess.getRuleRule());
							}
						}
						otherlv_11=RULE_ID
						{
							newLeafNode(otherlv_11, grammarAccess.getRuleAccess().getModesModeCrossReference_4_6_1_0());
						}
					)
				)
			)*
			otherlv_12=')'
			{
				newLeafNode(otherlv_12, grammarAccess.getRuleAccess().getRightParenthesisKeyword_4_7());
			}
		)?
		otherlv_13='then'
		{
			newLeafNode(otherlv_13, grammarAccess.getRuleAccess().getThenKeyword_5());
		}
		(
			(
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getRuleRule());
					}
				}
				otherlv_14=RULE_ID
				{
					newLeafNode(otherlv_14, grammarAccess.getRuleAccess().getThenModeCrossReference_6_0());
				}
			)
		)
		(
			otherlv_15='else'
			{
				newLeafNode(otherlv_15, grammarAccess.getRuleAccess().getElseKeyword_7_0());
			}
			(
				(
					{
						if ($current==null) {
							$current = createModelElement(grammarAccess.getRuleRule());
						}
					}
					otherlv_16=RULE_ID
					{
						newLeafNode(otherlv_16, grammarAccess.getRuleAccess().getElseModeCrossReference_7_1_0());
					}
				)
			)
		)?
	)
;

// Entry rule entryRuleEvent
entryRuleEvent returns [EObject current=null]:
	{ newCompositeNode(grammarAccess.getEventRule()); }
	iv_ruleEvent=ruleEvent
	{ $current=$iv_ruleEvent.current; }
	EOF;

// Rule Event
ruleEvent returns [EObject current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		otherlv_0='Event'
		{
			newLeafNode(otherlv_0, grammarAccess.getEventAccess().getEventKeyword_0());
		}
		(
			(
				lv_name_1_0=RULE_ID
				{
					newLeafNode(lv_name_1_0, grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventRule());
					}
					setWithLastConsumed(
						$current,
						"name",
						lv_name_1_0,
						"org.eclipse.xtext.common.Terminals.ID");
				}
			)
		)
		otherlv_2='description'
		{
			newLeafNode(otherlv_2, grammarAccess.getEventAccess().getDescriptionKeyword_2());
		}
		(
			(
				lv_description_3_0=RULE_STRING
				{
					newLeafNode(lv_description_3_0, grammarAccess.getEventAccess().getDescriptionSTRINGTerminalRuleCall_3_0());
				}
				{
					if ($current==null) {
						$current = createModelElement(grammarAccess.getEventRule());
					}
					setWithLastConsumed(
						$current,
						"description",
						lv_description_3_0,
						"org.eclipse.xtext.common.Terminals.STRING");
				}
			)
		)
	)
;

// Rule SUPPORTED_OPERATING_SYSTEMS
ruleSUPPORTED_OPERATING_SYSTEMS returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='Windows'
			{
				$current = grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getWindowsEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getWindowsEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='Linux'
			{
				$current = grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getLinuxEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_OPERATING_SYSTEMSAccess().getLinuxEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule SUPPORTED_DISTRIBUTIONS
ruleSUPPORTED_DISTRIBUTIONS returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='Debian'
			{
				$current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getDebianEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getDebianEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='Ubuntu'
			{
				$current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getUbuntuEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getUbuntuEnumLiteralDeclaration_1());
			}
		)
		    |
		(
			enumLiteral_2='Other'
			{
				$current = grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getOtherEnumLiteralDeclaration_2().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_2, grammarAccess.getSUPPORTED_DISTRIBUTIONSAccess().getOtherEnumLiteralDeclaration_2());
			}
		)
	)
;

// Rule SUPPORTED_RELEASES
ruleSUPPORTED_RELEASES returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='Buster'
			{
				$current = grammarAccess.getSUPPORTED_RELEASESAccess().getBusterEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getSUPPORTED_RELEASESAccess().getBusterEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='Other'
			{
				$current = grammarAccess.getSUPPORTED_RELEASESAccess().getOtherEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getSUPPORTED_RELEASESAccess().getOtherEnumLiteralDeclaration_1());
			}
		)
	)
;

// Rule Enabled
ruleEnabled returns [Enumerator current=null]
@init {
	enterRule();
}
@after {
	leaveRule();
}:
	(
		(
			enumLiteral_0='true'
			{
				$current = grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_0, grammarAccess.getEnabledAccess().getTrueEnumLiteralDeclaration_0());
			}
		)
		    |
		(
			enumLiteral_1='false'
			{
				$current = grammarAccess.getEnabledAccess().getFalseEnumLiteralDeclaration_1().getEnumLiteral().getInstance();
				newLeafNode(enumLiteral_1, grammarAccess.getEnabledAccess().getFalseEnumLiteralDeclaration_1());
			}
		)
	)
;

RULE_ID : '^'? ('a'..'z'|'A'..'Z'|'_') ('a'..'z'|'A'..'Z'|'_'|'0'..'9')*;

RULE_INT : ('0'..'9')+;

RULE_STRING : ('"' ('\\' .|~(('\\'|'"')))* '"'|'\'' ('\\' .|~(('\\'|'\'')))* '\'');

RULE_ML_COMMENT : '/*' ( options {greedy=false;} : . )*'*/';

RULE_SL_COMMENT : '//' ~(('\n'|'\r'))* ('\r'? '\n')?;

RULE_WS : (' '|'\t'|'\r'|'\n')+;

RULE_ANY_OTHER : .;
