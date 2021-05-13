/*
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.serializer;

import com.google.inject.Inject;
import java.util.Set;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.xtext.Action;
import org.eclipse.xtext.Parameter;
import org.eclipse.xtext.ParserRule;
import org.eclipse.xtext.serializer.ISerializationContext;
import org.eclipse.xtext.serializer.acceptor.SequenceFeeder;
import org.eclipse.xtext.serializer.sequencer.AbstractDelegatingSemanticSequencer;
import org.eclipse.xtext.serializer.sequencer.ITransientValueService.ValueTransient;
import org.xtext.mdsl.mdsl.ActionWithParams;
import org.xtext.mdsl.mdsl.Event;
import org.xtext.mdsl.mdsl.MdslPackage;
import org.xtext.mdsl.mdsl.Mode;
import org.xtext.mdsl.mdsl.Model;
import org.xtext.mdsl.mdsl.Rule;
import org.xtext.mdsl.mdsl.Service;
import org.xtext.mdsl.mdsl.Software;
import org.xtext.mdsl.services.MdslGrammarAccess;

@SuppressWarnings("all")
public class MdslSemanticSequencer extends AbstractDelegatingSemanticSequencer {

	@Inject
	private MdslGrammarAccess grammarAccess;
	
	@Override
	public void sequence(ISerializationContext context, EObject semanticObject) {
		EPackage epackage = semanticObject.eClass().getEPackage();
		ParserRule rule = context.getParserRule();
		Action action = context.getAssignedAction();
		Set<Parameter> parameters = context.getEnabledBooleanParameters();
		if (epackage == MdslPackage.eINSTANCE)
			switch (semanticObject.eClass().getClassifierID()) {
			case MdslPackage.ACTION:
				sequence_Action(context, (org.xtext.mdsl.mdsl.Action) semanticObject); 
				return; 
			case MdslPackage.ACTION_WITH_PARAMS:
				sequence_ActionWithParams(context, (ActionWithParams) semanticObject); 
				return; 
			case MdslPackage.EVENT:
				sequence_Event(context, (Event) semanticObject); 
				return; 
			case MdslPackage.MODE:
				sequence_Mode(context, (Mode) semanticObject); 
				return; 
			case MdslPackage.MODEL:
				sequence_Model(context, (Model) semanticObject); 
				return; 
			case MdslPackage.RULE:
				sequence_Rule(context, (Rule) semanticObject); 
				return; 
			case MdslPackage.SERVICE:
				sequence_Service(context, (Service) semanticObject); 
				return; 
			case MdslPackage.SOFTWARE:
				sequence_Software(context, (Software) semanticObject); 
				return; 
			case MdslPackage.SYSTEM:
				sequence_System(context, (org.xtext.mdsl.mdsl.System) semanticObject); 
				return; 
			}
		if (errorAcceptor != null)
			errorAcceptor.accept(diagnosticProvider.createInvalidContextOrTypeDiagnostic(semanticObject, context));
	}
	
	/**
	 * Contexts:
	 *     ActionWithParams returns ActionWithParams
	 *
	 * Constraint:
	 *     (action=[Action|ID] (params+=STRING params+=STRING*)?)
	 */
	protected void sequence_ActionWithParams(ISerializationContext context, ActionWithParams semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Action
	 *     Action returns Action
	 *
	 * Constraint:
	 *     (name=ID superAction=[Action|ID]? description=STRING? shellCmd=STRING)
	 */
	protected void sequence_Action(ISerializationContext context, org.xtext.mdsl.mdsl.Action semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Event
	 *     Event returns Event
	 *
	 * Constraint:
	 *     (name=ID description=STRING)
	 */
	protected void sequence_Event(ISerializationContext context, Event semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.EVENT__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.EVENT__NAME));
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.EVENT__DESCRIPTION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.EVENT__DESCRIPTION));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getEventAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getEventAccess().getDescriptionSTRINGTerminalRuleCall_3_0(), semanticObject.getDescription());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Mode
	 *     Mode returns Mode
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         superType=[Mode|ID]? 
	 *         description=STRING 
	 *         priority=INT 
	 *         (startServices+=[Service|ID] startServices+=[Service|ID]*)? 
	 *         (stopServices+=[Service|ID] stopServices+=[Service|ID]*)? 
	 *         enabled=Enabled?
	 *     )
	 */
	protected void sequence_Mode(ISerializationContext context, Mode semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Model returns Model
	 *
	 * Constraint:
	 *     declarations+=Declaration+
	 */
	protected void sequence_Model(ISerializationContext context, Model semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Rule
	 *     Rule returns Rule
	 *
	 * Constraint:
	 *     (description=STRING if+=[Event|ID] (currentMode+=[Mode|ID] modes+=[Mode|ID]*)? then=[Mode|ID] else=[Mode|ID]?)
	 */
	protected void sequence_Rule(ISerializationContext context, Rule semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Service
	 *     Service returns Service
	 *
	 * Constraint:
	 *     (
	 *         name=ID 
	 *         (usesSoftware+=[Software|ID] usesSoftware+=[Software|ID]*)? 
	 *         startActions+=ActionWithParams 
	 *         startActions+=ActionWithParams* 
	 *         stopActions+=ActionWithParams 
	 *         stopActions+=ActionWithParams*
	 *     )
	 */
	protected void sequence_Service(ISerializationContext context, Service semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns Software
	 *     Software returns Software
	 *
	 * Constraint:
	 *     (name=ID vendor=ID product=ID version=STRING package=STRING)
	 */
	protected void sequence_Software(ISerializationContext context, Software semanticObject) {
		if (errorAcceptor != null) {
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.SOFTWARE__NAME) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.SOFTWARE__NAME));
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.SOFTWARE__VENDOR) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.SOFTWARE__VENDOR));
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.SOFTWARE__PRODUCT) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.SOFTWARE__PRODUCT));
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.SOFTWARE__VERSION) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.SOFTWARE__VERSION));
			if (transientValues.isValueTransient(semanticObject, MdslPackage.Literals.SOFTWARE__PACKAGE) == ValueTransient.YES)
				errorAcceptor.accept(diagnosticProvider.createFeatureValueMissing(semanticObject, MdslPackage.Literals.SOFTWARE__PACKAGE));
		}
		SequenceFeeder feeder = createSequencerFeeder(context, semanticObject);
		feeder.accept(grammarAccess.getSoftwareAccess().getNameIDTerminalRuleCall_1_0(), semanticObject.getName());
		feeder.accept(grammarAccess.getSoftwareAccess().getVendorIDTerminalRuleCall_5_0(), semanticObject.getVendor());
		feeder.accept(grammarAccess.getSoftwareAccess().getProductIDTerminalRuleCall_7_0(), semanticObject.getProduct());
		feeder.accept(grammarAccess.getSoftwareAccess().getVersionSTRINGTerminalRuleCall_9_0(), semanticObject.getVersion());
		feeder.accept(grammarAccess.getSoftwareAccess().getPackageSTRINGTerminalRuleCall_11_0(), semanticObject.getPackage());
		feeder.finish();
	}
	
	
	/**
	 * Contexts:
	 *     Declaration returns System
	 *     System returns System
	 *
	 * Constraint:
	 *     (name=ID (modes+=[Mode|ID] modes+=[Mode|ID]*)? distribution=STRING releaseDate=STRING)
	 */
	protected void sequence_System(ISerializationContext context, org.xtext.mdsl.mdsl.System semanticObject) {
		genericSequencer.createSequence(context, semanticObject);
	}
	
	
}
