/*
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.generator

import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.generator.AbstractGenerator
import org.eclipse.xtext.generator.IFileSystemAccess2
import org.eclipse.xtext.generator.IGeneratorContext
import org.xtext.mdsl.mdsl.Action
import org.xtext.mdsl.mdsl.Mode
import org.xtext.mdsl.mdsl.Model
import org.xtext.mdsl.mdsl.Service
import org.xtext.mdsl.mdsl.Software
import org.xtext.mdsl.mdsl.System

/**
 * Generates code from your model files on save.
 * 
 * See https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#code-generation
 */
class MdslGenerator extends AbstractGenerator {
	
	override void doGenerate(Resource resource, IFileSystemAccess2 fsa, IGeneratorContext context) {
		val model = resource.contents.head as Model;
		val targetLanguage = "java"; //default
		switch targetLanguage{
			//case 'sh' : fsa.generateFile('modeswitcher.sh', generateShellscriptSystemConfiguration(model))
			//case 'ansible' : fsa.generateFile('modeswitcher.yml', generateAnsibleSystemConfiguration(model))
			//case 'java' : 
			default : fsa.generateFile('SystemConfigurationCreator.java', generateJavaSystemConfigurationCreator(model))
		}
	}
	
	/*def generateShellscriptSystemConfiguration(Model model) {'''
	shellscript
	'''
	}
	
	def generateAnsibleSystemConfiguration(Model model) {'''
	ansible
	'''
	}*/
		
	
	def generateJavaSystemConfigurationCreator(Model model) {'''
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class SystemConfigurationCreator{
		public static SystemConfiguration create() {
			List<Mode> modes  = new ArrayList<Mode>();
			List<Software> software = new ArrayList<Software>();
			String debianRelease;
			String releaseDate;
			�FOR sys : model.declarations.filter(System)�
			debianRelease = "�sys.distribution.toString�";
			�ENDFOR�
			
			�FOR s : model.declarations.filter(Software)�
			�IF s.package !== null�
			Software �s.name.toFirstLower� = new Software("�s.package�");
			�ELSE�
			Software �s.name.toFirstLower� = new Software("�s.name�");
			�ENDIF�
			software.add(�s.name.toFirstLower�);
			�ENDFOR�
			
			�FOR a : model.declarations.filter(Action)�
			�IF a.superAction !== null��a.shellCmd = a.superAction.shellCmd��ENDIF�
			�a.params.forEach[param, index| a.shellCmd = a.shellCmd.replace("$" + index, param)]�
			Action �a.name.toFirstLower� = new Action("", "�a.shellCmd�");
			�ENDFOR�
			
			�FOR s : model.declarations.filter(Service)�
			Service �s.name.toFirstLower� = new Service("�s.name�",
				Arrays.asList(�s.usesSoftware.map[name.toFirstLower].join(', ')�),
				Arrays.asList(�s.startActions.map[action.name.concat(".withParams(\"").concat(params.join('", "')).concat("\")")].join(', ')�),
				Arrays.asList(�s.stopActions.map[action.name.concat(".withParams(\"").concat(params.join('", "')).concat("\")")].join(', ')�)
			);
			�ENDFOR�
			
			�FOR m : model.declarations.filter(Mode)�
			Mode �m.name.toFirstLower� = new Mode("�m.name.toFirstLower�","�m.description�", �m.priority�,
				Arrays.asList(�IF m.superMode !== null��m.superMode.startServices.map[name.toFirstLower].join(', ')��IF m.startServices !== null�,�ENDIF��ENDIF�
				�m.startServices.map[name.toFirstLower].join(', ')�),
				Arrays.asList(�IF m.superMode !== null��m.superMode.stopServices.map[name.toFirstLower].join(', ')��IF m.stopServices !== null�,�ENDIF��ENDIF�
				�m.stopServices.map[name.toFirstLower].join(', ')�)
			);
			�IF m.enabled !==null && m.enabled == false�
			�m.name.toFirstLower�.setEnabled(false);
			�ENDIF�
			modes.add(�m.name.toFirstLower�);
			�ENDFOR�
			
			�FOR m : model.declarations.filter(Mode)�
			�IF m.alternativeModes !==null�
				�m.name.toFirstLower�.setAlternativeModes(Arrays.asList(�m.alternativeModes.map[name.toFirstLower].join(', ')�));
			�ENDIF�			
			�ENDFOR�
			
			return new SystemConfiguration(modes, software);
		}
}
	'''
	}
	
	
	
	def getReleaseDate(System s) { s.releaseDate }
	def getDistribution(System s) { s.distribution }
}
