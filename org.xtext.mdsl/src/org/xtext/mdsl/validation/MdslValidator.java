/*
 * generated by Xtext 2.25.0
 */
package org.xtext.mdsl.validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import javax.inject.Inject;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.Check;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xtext.mdsl.mdsl.MdslPackage;
import org.xtext.mdsl.mdsl.Mode;
import org.xtext.mdsl.mdsl.Software;

/**
 * This class contains custom validation rules.
 *
 * See
 * https://www.eclipse.org/Xtext/documentation/303_runtime_concepts.html#validation
 */
public class MdslValidator extends AbstractMdslValidator {
	public static final String INVALID_NAME = "invalidName";
	public static final String DUPLICATE_PRIORITY = "duplicatePriority";
	public static final String DUPLICATE_START_SERVICES = "duplicateStartServices";
	public static final String DUPLICATE_STOP_SERVICES = "duplicateStopServices";
	public static final String DUPLICATE_MODE_NAMES = "duplicateModeNames";
	public static final String DUPLICATE_ALTERNATIVE_MODE_NAMES = "duplicateAlternativeModeNames";
	public static final String MODE_INHERIT_ITSELF = "modeInheritItself";

	private HashMap<String, String> packageList;
	
	private String getPackageListUrl(String operatingSystem, String distribution) {
		String url = "";
		switch(operatingSystem) {
		case "Linux":
			switch(distribution) {
			case "Debian":
				url = "https://salsa.debian.org/security-tracker-team/security-tracker/-/raw/master/data/CPE/list";
				break;
			}		
			break;
		/*case "Windows":
			url = "";
			break;*/
		}
		return url;
	}

	private void initPackageList(String operatingSystem, String distribution) {
		String url = "";
		String filename = "package-cpe-list.csv";
		packageList = new HashMap<String, String>();
		
		System.out.println("initPackageList");
		
		url = getPackageListUrl(operatingSystem, distribution);
		if(url == "") {
			System.out.println("Unkown operating system. No package list available.");
			return;
		}
		
		File f = new File(filename);
		if (!f.exists()) {
			loadFileFromUrl(url, filename);
		}
		
		//String currentPath = new File("").getAbsolutePath().toString();
		//System.out.println("currentPath: " + currentPath);
		if (f.exists()) {
			System.out.println(filename + " found: " + f.getAbsolutePath().toString());
			
			String line = "";
			String splitBy = ";";
			try {
				// parsing a CSV file into BufferedReader class constructor
				BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
				while ((line = br.readLine()) != null) // returns a Boolean value
				{
					String[] currentLine = line.split(splitBy); // use separator
					// System.out.println("[package=" + currentLine[0] + ", cpe=" + currentLine[1]);
					packageList.put(currentLine[0], currentLine[1]);
				}
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			System.out.println(filename + " not available.");
		}
	}

	public String getCpeForPackage(String packageName) {
		System.out.println("getCpeForPackage " + packageName);
		if (packageList == null || packageList.isEmpty()) {
			System.out.println("packageList is empty");
		}
		return packageList.get(packageName); //returns null if not found
	}

	@Check
	public void checkMode(org.xtext.mdsl.mdsl.Mode mode) {
		System.out.println("checkMode: " + mode.getName());
		
		/**
		 * Check superType
		 */
		if (mode.getSuperMode() != null) {
			System.out.println("	checkSuperMode: " + mode.getSuperMode().getName());
			if (mode.getName() == mode.getSuperMode().getName()) {
				System.out.println("Mode " + mode.getName() +" cannot inherit from itself");
				error("Mode cannot inherit from itself", mode, MdslPackage.Literals.MODE__SUPER_MODE);
			}
		}
		
		/**
		 * Check alternative modes (moveable target defense)
		 */
		if (mode.getAlternativeModes() != null) {
			
			System.out.println("	checkAlternativeModes");
			
			/**
			 * Duplicate alternative mode names
			 */
			List<Mode> duplicateAltModeNames = mode.getAlternativeModes().stream().collect(Collectors.groupingBy(Mode::getName)).entrySet()
					.stream().filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream())
					.collect(Collectors.toList());
			
			System.out.print("Alternative modes: ");
			mode.getAlternativeModes().stream().forEach(m -> System.out.print(m.getName()+","));
			System.out.println("");
			
			if (!duplicateAltModeNames.isEmpty()) {
				System.out.println("Duplicate alternative mode names found!");
				duplicateAltModeNames.forEach(i -> System.out.println (i.getName()));
				warning("Modes with a duplicate name found", MdslPackage.Literals.SYSTEM__MODES, DUPLICATE_ALTERNATIVE_MODE_NAMES);
				duplicateAltModeNames.forEach(i -> warning("Alternative modes with the same name found", i, MdslPackage.Literals.MODE__NAME, -1));
			}
			
			/**
			 * Mode == Alternative mode
			 */
			List<Mode> modeNameEqualAlternativeModeNames = mode.getAlternativeModes().stream().filter(str -> str.getName().equals(mode.getName()))
					.collect(Collectors.toList());
			if (!modeNameEqualAlternativeModeNames.isEmpty()) {
				System.out.println("Mode " + mode.getName() +" cannot have itself as moveable target defense alternative");
				error("Mode cannot have itself as moveable target defense alternative", mode, MdslPackage.Literals.MODE__ALTERNATIVE_MODES);
			}
		}
	}
	
	@Check
	public void checkAction(org.xtext.mdsl.mdsl.Action action) {
		System.out.println("checkAction: " + action.getName());
		
		/**
		 * Check superType
		 */
		if (action.getSuperAction() != null) {
			System.out.println("	checkSuperAction: " + action.getSuperAction().getName());
			if (action.getName() == action.getSuperAction().getName()) {
				System.out.println("Action " + action.getName() +" cannot inherit from itself");
				error("Action cannot inherit from itself", action, MdslPackage.Literals.ACTION__SUPER_ACTION);
			}
		}
	}
	
    @Inject IResourceValidator resourceValidator;
    public void checkResource(Resource resource) {
        List<Issue> issues = resourceValidator.validate(resource,
                CheckMode.ALL, CancelIndicator.NullImpl);
        for (Issue issue: issues) {
            switch (issue.getSeverity()) {
                case ERROR:
                    System.out.println("ERROR: " + issue.getMessage());
                    break;
                case WARNING:
                    System.out.println("WARNING: " + issue.getMessage());
                    break;
                default: // do nothing
            }
        }
    }

	@Check
	public void checkSystem(org.xtext.mdsl.mdsl.System sys) {
		/**
		 * Duplicate priority
		 */
		List<Mode> duplicateModePriority = sys.getModes().stream().collect(Collectors.groupingBy(Mode::getPriority))
				.entrySet().stream().filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream())
				.collect(Collectors.toList());
		if (!duplicateModePriority.isEmpty()) {
			System.out.println("Duplicate priorities found!");
			duplicateModePriority.forEach(i -> System.out.println (i.getName() + " " + i.getPriority()));
			duplicateModePriority.forEach(i -> warning("Modes with the same priority found", i, MdslPackage.Literals.MODE__PRIORITY, -1));
		}

		/**
		 * Duplicate mode names
		 */
		List<Mode> duplicateModeNames = sys.getModes().stream().collect(Collectors.groupingBy(Mode::getName)).entrySet()
				.stream().filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream())
				.collect(Collectors.toList());
		if (!duplicateModeNames.isEmpty()) {
			System.out.println("Duplicate mode names found!");
			duplicateModeNames.forEach(i -> System.out.println (i.getName()));
			warning("Modes with a duplicate name found", MdslPackage.Literals.SYSTEM__MODES, DUPLICATE_MODE_NAMES);
			duplicateModeNames.forEach(i -> warning("Modes with the same start services found", i, MdslPackage.Literals.MODE__NAME, -1));
		}
		
		/**
		 * Duplicate startServices
		 */
		List<Mode> duplicateStartServices = sys.getModes().stream()
				.collect(Collectors.groupingBy(Mode::getStartServices)).entrySet().stream()
				.filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
		if (!duplicateStartServices.isEmpty()) {
			System.out.println("Duplicate start services found!");
			duplicateStartServices.forEach(i -> System.out.println (i.getName())); 
			duplicateStartServices.forEach(i -> warning("Modes with the same start services found", i, MdslPackage.Literals.MODE__START_SERVICES, -1));
			
		}
		
		/**
		 * Duplicate stopServices
		 */
		List<Mode> duplicateStopServices = sys.getModes().stream()
				.collect(Collectors.groupingBy(Mode::getStopServices)).entrySet().stream()
				.filter(e -> e.getValue().size() > 1).flatMap(e -> e.getValue().stream()).collect(Collectors.toList());
		if (!duplicateStopServices.isEmpty()) {
			System.out.println("Duplicate start services found!");
			duplicateStopServices.forEach(i -> warning("Modes with the same start services found", i, MdslPackage.Literals.MODE__STOP_SERVICES, -1));
		}
		
		/**
		 * Init package list if operating system is defined
		 */
		if(sys.getOperatingSystem().getLiteral() != "") {
			System.out.println("operating system " + sys.getOperatingSystem().getLiteral());
			initPackageList(sys.getOperatingSystem().getLiteral(), sys.getDistribution().getLiteral());
		}
		
		//Resource.getAllContents().
		/*this.getEPackages().forEach(p ->{
			System.out.println("name: " + p.getName() + ", class: " + p.getClass());
			p.getESubpackages().forEach(sp ->{
				System.out.println("   name: " + sp.getName() + ", class: " + sp.getClass());
			});
			p.eAllContents().forEachRemaining(ec ->{
				System.out.println("   name: " + ec.toString());
			});
		});*/
	}

	@Check
	public void checkSoftware(Software sw) {
		System.out.println("   checkSoftware: " + sw.getName() + " package " + sw.getPackage());
		String cpe = getCpeForPackage(sw.getName());
		if (cpe == null && (cpe = getCpeForPackage(sw.getPackage())) == null) {
				warning("Package was not found", sw, MdslPackage.Literals.SOFTWARE__NAME, -1);
				System.out.println("Package for name=" +sw.getName()+ ", package=" +sw.getPackage()+ " not found");
		}else {
			System.out.println("Package " + cpe + " found");			
		}
	}
	
	static void loadFileFromUrl(String urlString, String filename) {
		InputStream input = null;
		OutputStream output = null;
		URL url = null;
		try {
			url = new URL(urlString);
			System.out.println("downloading file: " + url);
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
			
			int responseCode = httpConn.getResponseCode();

			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
				//input = url.openStream();
				input = httpConn.getInputStream();
			    output = new FileOutputStream(filename);
			    byte[] buffer = new byte[1024];
			    for (int length = 0; (length = input.read(buffer)) > 0;) {
			        output.write(buffer, 0, length);
			    }
			}else {
				System.out.println("Failure! ResponseCode " + responseCode);
			}
		} catch (UnknownHostException e) {
			System.out.println("Failure! Unkown host");
			//e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
		    if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
		}
	}

}
