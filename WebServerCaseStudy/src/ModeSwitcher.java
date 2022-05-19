import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import javax.tools.JavaCompiler;
import javax.tools.StandardJavaFileManager;
import javax.tools.StandardLocation;
import javax.tools.ToolProvider;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.xtext.diagnostics.Severity;
import org.eclipse.xtext.generator.GeneratorContext;
import org.eclipse.xtext.generator.GeneratorDelegate;
import org.eclipse.xtext.generator.JavaIoFileSystemAccess;
import org.eclipse.xtext.resource.XtextResourceSet;
import org.eclipse.xtext.util.CancelIndicator;
import org.eclipse.xtext.validation.CheckMode;
import org.eclipse.xtext.validation.IResourceValidator;
import org.eclipse.xtext.validation.Issue;
import org.xtext.mdsl.MdslStandaloneSetupGenerated;

import com.google.inject.Injector;

public class ModeSwitcher {

	private static Mode currentMode = null;
	private static Mode defaultMode = null;
	private static List<Mode> modes;
	private static VulnerabilityManager vulnerabilityManager;
	private static SystemConfiguration config = null;

	private static OperatingSystem os;

	private static boolean simulation = false;
	private static final boolean LOGGING = true;
	private static boolean debugging = false;
	private static boolean executing = true;
	private static boolean shuffling = true;

	static String CPESDIR = "cpes";
	static String CVESDIR = "cves";
	static String PATCHESDIR = "patches";
	static String MODESLOG = "modes.log";

	public static void main(String[] args) {
		modes = new ArrayList<Mode>();
		HashMap<String, Software> software;

		log("############################################################################");
		log("Welcome to the Mode Switching System!");
		log("############################################################################");

		createFileDirectories();
		initOperatingSystem();
		initConfig();

		if (config == null) {
			log("No SystemConfiguration found");
			System.exit(0);
		}

		modes = config.getModes();
		log("Possible modes:" + Arrays.asList(modes));

		software = config.getSoftware();
		if (software.isEmpty()) {
			log("No defined software found!!");
		}
		vulnerabilityManager = new VulnerabilityManager(software);

		// check for command line arguments
		if (args.length > 0) {
			processCommandLineArguments(args);
		} else {
			// no command line arguments
			showOptionChooser();
		}
	}

	private static void createFileDirectories() {
		FileUtils.createDirectoryIfNotExits(CPESDIR);
		FileUtils.createDirectoryIfNotExits(CVESDIR);
		FileUtils.createDirectoryIfNotExits(PATCHESDIR);
	}

	private static void initOperatingSystem() {
		os = detectOS();
		if (os == null) {
			log("Your operating system is currently not supported!!");
			log("You can only simulate the mode switching");
			//simulation = true;
			executing = false;

			try {
				os = new Debian("buster");
			} catch (Exception e) {
				e.printStackTrace();
				return;
			}
		}
	}

	private static void initConfig() {
		File systemConfigurationCreatorFile = new File("SystemConfigurationCreator.class");
		File mdslFile = new File("modes.mdsl");

		if (systemConfigurationCreatorFile.exists() && mdslFile.exists()
				&& systemConfigurationCreatorFile.lastModified() > mdslFile.lastModified()) {
			log("Regenerate system configuration from MDSL-Defintion not neccessary");
		} else {
			if (mdslFile.exists()) {
				log("Regenerate system configuration from MDSL-Defintion");
				generateSystemConfigurationCreatorFileFromMdsl();
				
			} else {
				log("No .mdsl-File found!");
				simulation = true;
			}
		}
		if (simulation) {
			loadExampleSystemConfiguration();
		}else {
			loadGeneratedSystemConfiguration();
		}
	}

	static void generateSystemConfigurationCreatorFileFromMdsl() {
		log("Validate MDSL file and generate system config");
		log("############################################################################");
		
		Instant startSystemConfiguration = Instant.now();
		Instant finishedSystemConfiguration = null;

		Injector injector = new MdslStandaloneSetupGenerated().createInjectorAndDoEMFRegistration();
		XtextResourceSet resourceSet = injector.getInstance(XtextResourceSet.class);
		Resource resource = resourceSet.getResource(URI.createFileURI("./modes.mdsl"), true);

		// Validate the resource
		Instant startValidation = Instant.now();
		Instant finishedValidation = null;
		IResourceValidator validator = injector.getInstance(IResourceValidator.class);
		List<Issue> list = validator.validate(resource, CheckMode.ALL, CancelIndicator.NullImpl);
		finishedValidation = Instant.now();
		long timeValidation = Duration.between(startValidation, finishedValidation).toNanos(); // in millis
		addModeLogEntry("time validation;" + timeValidation);
		if (!list.isEmpty()) {
			for (Issue issue : list) {
				System.err.println(issue);
			}
			// Exit on error
			List<Issue> errors = list.stream().filter(it -> it.getSeverity() == Severity.ERROR)
					.collect(Collectors.toList());
			if (!errors.isEmpty()) {
				System.exit(0);
			}
		}
		//

		// Configure and start the generator
		Instant startGeneration = Instant.now();
		Instant finishedGeneration = null;
		JavaIoFileSystemAccess fileAccess = injector.getInstance(JavaIoFileSystemAccess.class);
		fileAccess.setOutputPath("./");
		GeneratorContext context = new GeneratorContext();
		context.setCancelIndicator(CancelIndicator.NullImpl);
		GeneratorDelegate generator = injector.getInstance(GeneratorDelegate.class);
		generator.generate(resource, fileAccess, context);
		finishedGeneration = Instant.now();
		long timeGeneration = Duration.between(startGeneration, finishedGeneration).toNanos(); // in millis
		addModeLogEntry("time generation;" + timeGeneration);
		log("- Code generation finished.");
		//
		
		// Compile the java file to class
		Instant startCompilation = Instant.now();
		Instant finishedCompilation = null;
		File javaFile = new File("SystemConfigurationCreator.java");
		boolean success = false;
		JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
		StandardJavaFileManager fileManager = compiler.getStandardFileManager(null, null, null);
		try {
			fileManager.setLocation(StandardLocation.CLASS_OUTPUT, Arrays.asList(new File("./")));
			// Compile the file
			success = compiler.getTask(null, fileManager, null, null, null,
					fileManager.getJavaFileObjectsFromFiles(Arrays.asList(javaFile))).call();
			if (success) {
				log("- Compile finished.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finishedCompilation = Instant.now();
		long timeCompilation = Duration.between(startCompilation, finishedCompilation).toNanos(); // in millis
		addModeLogEntry("time compilation;" + timeCompilation);
		//
		
		finishedSystemConfiguration = Instant.now();
		long timeSystemConfiguration = Duration.between(startSystemConfiguration, finishedSystemConfiguration).toNanos(); // in millis
		addModeLogEntry("time system configuration;" + timeSystemConfiguration);
		
		log("----------------------------------------------------------------------------");
	}

	private static void loadExampleSystemConfiguration() {
		log("Load system configuration EXAMPLE");
		config = SystemConfigurationCreatorExample.create();
	}

	private static void loadGeneratedSystemConfiguration() {
		// log("loadGeneratedSystemConfiguration");
		try {
			Class<?> params[] = {};
			Object paramsObj[] = {};

			// ClassLoader classLoader = ModeSwitcher.class.getClassLoader(;
			Class<?> thisClass = null;
			File f = new File("./");
			URLClassLoader classLoader = new URLClassLoader(new URL[] { f.toURI().toURL() });

			try {
				thisClass = classLoader.loadClass("SystemConfigurationCreator");
				// System.out.println("aClass.getName() = " + thisClass.getName());
				Object iClass = thisClass.getDeclaredConstructor().newInstance();
				Method thisMethod = thisClass.getDeclaredMethod("create", params);
				config = (SystemConfiguration) thisMethod.invoke(iClass, paramsObj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} finally {
				classLoader.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void processCommandLineArguments(String[] args) {
		/* Consider command line arguments */
		if (args.length > 0) {
			switch (args[0]) {
			case "init":
				initialize();
				break;
			case "update":
				if (args.length > 1) {
					switch (args[1]) {
					case "cves":
						refreshVulnerabilities(false); //force
						break;
					case "patches":
						refreshPatches(false); //force
						break;
					default:
						log("Wrong parameter! Only cves or patches are allowed!");
						break;
					}
				} else {
					refreshVulnerabilitiesAndPatches(false);
				}
				break;
			case "to":
				if (args.length > 1) {
					Mode m = getMode(args[1]);
					if (m != null) {
						switch2Mode(m);
					} else {
						log("Wrong MODE parameter!");
					}
				} else {
					log("Missing MODE parameter!");
				}
				break;
			case "scenario":
				if (args.length > 1) {
					switch (args[1]) {
						case "s1":
							Scenarios.startVulnerabilityTimeSeries();
							break;
						case "s2":
							Scenarios.startAllModesDisabled();
							break;
						case "s3":
							Scenarios.startAllSoftwareDisabled();
							break;
						case "s4":
							Scenarios.startRandomModeOrder();
							break;
						case "s5":
							Scenarios.startModeSwitchingDuration(getModes(), 500);
							break;
						case "s6":
							Scenarios.startGenerateSystemConfiguration(500);
							break;
						case "s7":
							Scenarios.startUpdateVulnerabilitiesAndPatches(5);
							break;
					}
				}else {
					log("Missing Senario [s1-s5] parameter!");
				}
				break;
			default:
				showCommandLineArguments();
				break;
			}
		}
	}

	private static void showCommandLineArguments() {
		log("");
		log("USAGE");
		log("modeswitcher init					initalize the system (default mode)");
		log("modeswitcher update				updates vulns and patches (auto mode switch)");
		log("modeswitcher update [cves|patches] updates vulns or patches (auto mode switch)");
		log("modeswitcher to MODE				manual mode switch to MODE");
		log("modeswitcher scenario [s1-s6]		start screnario S1-S6");
	}

	private static void showOptions() {
		log("What do you want to do? Choose an option:");
		log("----------------------------------------------------------------------------");
		log("[i]    Initialize");
		log("[m]    Show modes");
		log("[u]    Update CVEs, Patches and switch mode");
		log("[uv]   Update CVEs");
		log("[up]   Update Patches");
		log("[ams]  Automatic mode switch");
		log("[mms]  Manual mode switch");
		log("[s]    Show used software");
		log("[v]    Show all vulnerabilities");
		log("[vo]   Show open vulnerabilities");
		log("[vps]  Show vulnerabilities per software");
		log("[vs]   Show vulnerabilities statistics");
		log("[vsps] Show vulnerabilities statistics per software");
		log("[h]    Show mode history");
		log("[e]    Toggle mode (enabled/disabled)");
		log("[si]   Toggle simulation (on/off)");
		log("[ex]   Toggle execution (on/off)");
		log("[d]    Toggle debugging (on/off)");
		log("");
		log("Start scenario:");
		log("[s1]   Start scenario vulnerability time series");
		log("[s2]   Start scenario all modes are disabled");
		log("[s3]   Start scenario all software is disabled");
		log("[s4]   Start scenario random mode order");
		log("[s5]   Start scenario mode switch duration");
		log("[s6]   Start scenario to generate the system configuration");
		log("[s7]   Start scenario update vulnerabilities and patches");
		log("");
		log("[q]    Quit");
	}

	private static void showOptionChooser() {
		Scanner scanner = new Scanner(System.in);
		String input = "";
		boolean first = true;
		while (!"q".equalsIgnoreCase(input)) {
			if (first) {
				log("############################################################################");
				showOptions();
				log("############################################################################");
				first = false;
			}
			System.out.print("[? for menu]> ");
			input = scanner.nextLine();

			log("############################################################################");
			switch (input) {
			case "i":
				initialize();
				break;
			case "m":
				showModeInformation();
				break;
			case "u":
				refreshVulnerabilitiesAndPatches(false);
				break;
			case "uv":
				refreshVulnerabilities(false); //force
				break;
			case "up":
				refreshPatches(false); //force
				break;
			case "ams":
				automaticModeSwitch();
				break;
			case "mms":
				manualModeSwitchDialog(scanner);
				break;
			case "s":
				showUsedSoftware();
				break;
			case "v":
				showVulnerabilities();
				break;
			case "vo":
				showOpenVulnerabilities();
				break;
			case "vps":
				showVulnerabilitiesPerSoftware();
				break;
			case "vops":
				showOpenVulnerabilitiesPerSoftware();
				break;
			case "vs":
				showVulnerabilityStatistics();
				break;
			case "vsps":
				showVulnerabilityStatisticPerSoftware();
				break;
			case "h":
				showModeHistory();
				break;
			case "s1":
				Scenarios.startVulnerabilityTimeSeries();
				break;
			case "s2":
				Scenarios.startAllModesDisabled();
				break;
			case "s3":
				Scenarios.startAllSoftwareDisabled();
				break;
			case "s4":
				Scenarios.startRandomModeOrder();
				break;
			case "s5":
				Scenarios.startModeSwitchingDuration(getModes(), 500);
				break;
			case "s6":
				Scenarios.startGenerateSystemConfiguration(500);
				break;
			case "s7":
				Scenarios.startUpdateVulnerabilitiesAndPatches(500);
				break;
			case "si":
				toggleSimulation();
				break;
			case "ex":
				toggleExecution();
				break;
			case "e":
				enableDisableModeDialog(scanner);
				break;
			case "d":
				toggleDebugging();
				break;
			case "q": // exit
				break;
			case "?":
			default:
				log("Wrong input! Please try again.");
				showOptions();
				break;
			}
			log("############################################################################");
		}
		log("Bye bye!");
		scanner.close();
		System.exit(1);
	}

	private static void toggleDebugging() {
		if (debugging) {
			log("Debugging disabled");
			debugging = false;
		} else {
			log("Debugging enabled");
			debugging = true;
		}
	}

	private static void toggleExecution() {
		if (executing) {
			log("Executing disabled");
			executing = false;
		} else {
			log("Executing enabled");
			executing = true;
		}
	}

	private static void toggleSimulation() {
		if (simulation) {
			log("Simulation disabled");
			simulation = false;
		} else {
			log("Simulation enabled");
			simulation = true;
		}
	}

	private static void initialize() {
		log("Initialize");
		log("----------------------------------------------------------------------------");
		readInformationsFromDisk();
		// log("############################################################################");
		// showModeInformation();
		log("############################################################################");
		automaticModeSwitch();
	}

	private static void manualModeSwitchDialog(Scanner scanner) {

		String input = null;
		while (!"c".equalsIgnoreCase(input)) {
			showModeInformation();

			log("############################################################################");
			log("Choose the mode you want to switch? Enter c to cancel.");
			input = scanner.nextLine();

			if (input != null && !"c".equalsIgnoreCase(input))
				switch2Mode(input);
		}
	}

	private static void enableDisableModeDialog(Scanner scanner) {

		String input = "";
		boolean inputValid = false;
		while (!inputValid && !"c".equalsIgnoreCase(input)) {
			showModeInformation();

			log("############################################################################");
			log("Choose the mode you want to enable/disable? Enter c to cancel.");
			input = scanner.nextLine();

			Mode m = getMode(input);
			if (m != null) {
				m.setEnabled(m.isEnabled() ? false : true);
				log("Mode " + m.getName() + " " + (m.isEnabled() ? "enabled" : "disabled"));
				inputValid = true;
			} else if (!"c".equalsIgnoreCase(input)) {
				log("Mode " + input + " does not exists");
			}
		}
	}

	private static Mode getMode(String modename) {
		final String inputForStream = modename;
		Optional<Mode> nextMode = modes.stream().filter(m -> m.getName().equals(inputForStream)).findFirst();
		if (nextMode.isPresent()) {
			return nextMode.get();
		}
		return null;
	}

	private static OperatingSystem detectOS() {
		String OS;
		String distribution = "";
		OperatingSystem os = null;

		// https://docs.oracle.com/javase/tutorial/essential/environment/sysprop.html
		OS = System.getProperty("os.name").toLowerCase();
		log("Your operating system is " + OS);
		if ((OS.contains("nix") || OS.contains("nux") || OS.contains("aix"))) {
			// log("This is Unix or Linux");
			// lsb_release --id ==> Distributor ID: Debian
			// lsb_release --id | cut -d ':' -f 2 | xargs => Debian

			distribution = ShellCommand.executeAndGetResults("lsb_release -si"); // Debian
			log("Distribution " + distribution + " detected");
			switch (distribution) {
			case "Debian":
				try {
					os = new Debian();
				} catch (Exception e) {
					e.printStackTrace();
				}
				break;
			/*
			 * case "Ubuntu": os = new Ubuntu(); break;
			 */
			}

			/*
			 * } else if (OS.contains("mac")) { log("This is Mac"); } else if
			 * (OS.contains("sunos")) { log("This is Solaris"); }else if
			 * (OS.contains("win")) { log("This is Windows");
			 */
		}
		return os;
	}

	static void refreshVulnerabilitiesAndPatches(boolean force) {
		log("refreshVulnerabilitiesAndPatches");
		log("----------------------------------------------------------------------------");

		// Object object = FileUtils.loadObjectFromFile("vulnerabilities.ser");
		// log("object class " + object.getClass());
		/*
		 * if (object != null && object instanceof HashMap) {
		 * log("importing vulnerabilities from file"); HashMap<String, Vulnerability>
		 * vulnerabilities = (HashMap<String, Vulnerability>) object;
		 * vulnerabilityManager.setVulnerabilities(vulnerabilities); }else {
		 */
		boolean forceRefresh = (force == true) ? true : false; 
		refreshVulnerabilities(forceRefresh);
		refreshPatches(forceRefresh);
		// }
		automaticModeSwitch();
	}

	private static void saveDataToDisk() {
		if (vulnerabilityManager != null) {
			FileUtils.saveObjectToFile(vulnerabilityManager.getVulnerabilities(), "vulnerabilities.ser");
			FileUtils.saveObjectToFile(vulnerabilityManager.getSoftware(), "software.ser");
		}
		FileUtils.saveObjectToFile(modes, "modes.ser");
		FileUtils.saveObjectToFile(currentMode, "currentMode.ser");
		log("Data serialized and saved to disk");
	}

	@SuppressWarnings("unchecked")
	private static void readInformationsFromDisk() {
		Object swObject = FileUtils.loadObjectFromFile("software.ser");
		if (swObject != null) {
			vulnerabilityManager.setSoftware((HashMap<String, Software>) swObject);
		}

		Object vulnObject = FileUtils.loadObjectFromFile("vulnerabilities.ser");
		if (vulnObject != null) {
			vulnerabilityManager.setVulnerabilities((HashMap<String, Vulnerability>) vulnObject);
		}

		Object modesObject = FileUtils.loadObjectFromFile("modes.ser");
		if (modesObject != null) {
			modes = (List<Mode>) modesObject;
		}

		Object currentModeObject = FileUtils.loadObjectFromFile("currentMode.ser");
		if (modesObject != null) {
			currentMode = (Mode) currentModeObject;
		}
	}

	private static void refreshVulnerabilities(boolean force) {
		log("refreshVulnerabilities");
		log("----------------------------------------------------------------------------");
		Instant start = Instant.now();
		vulnerabilityManager.refreshVulnerabilities(force);
		saveDataToDisk();
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toNanos(); // in nanos
		addModeLogEntry("refreshVulnerabilities" + ";" + timeElapsed);
		
	}

	private static void refreshPatches(boolean force) {
		log("refreshPatches");
		log("----------------------------------------------------------------------------");
		Instant start = Instant.now();
		HashMap<String, Vulnerability> vulnerabilities = vulnerabilityManager.getVulnerabilities();
		if (vulnerabilities.isEmpty()) {
			log("No vulnerabilities found! You need to update vulnerabilites before you refresh the patches!");
		} else {
			// vulnerabilityManager.refreshPatches();
			os.refreshPatches(vulnerabilityManager);
			saveDataToDisk();
		}
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toNanos(); // in nanos
		addModeLogEntry("refreshPatches" + ";" + timeElapsed);
	}

	private static void showUsedSoftware() {
		log("Used Software");
		log("----------------------------------------------------------------------------");
		HashMap<String, Software> software = vulnerabilityManager.getSoftware();
		for (String i : software.keySet()) {
			log("key: " + i + " value: " + software.get(i));
		}
	}

	private static void automaticModeSwitch() {
		log("Automatic Mode Switch");
		log("----------------------------------------------------------------------------");
		log("############################################################################");
		showModeInformation();
		Mode nextMode = sortModesAndGetNextMode();
		if (shuffling && currentMode != null && nextMode == currentMode) {
			log("----------------------------------------------------------------------------");
			// Moving target defense shuffling modes is activated
			log("Shuffling is enabled => looking for alternative mode");
			List<Mode> alternativeModes = currentMode.getAlternativeModes();
			
			Mode alternativeMode = currentMode.getAlternativeModes().stream().filter(
					e -> e.getActiveTotalScore() <= currentMode.getActiveTotalScore()
				).filter(Mode::isEnabled).collect(Collectors.toList()).get(0);
			//System.out.println(alternativeMode);
			
			if (alternativeMode != null && alternativeMode.isEnabled()) {
				log("Alternative enabled mode found: " + alternativeMode.getName());
				if (alternativeMode.getActiveTotalScore() <= currentMode.getActiveTotalScore()) {
					log("Alternative mode has the same risk as the current mode => shuffling");
					nextMode = alternativeMode;
				} else {
					log("No shuffling because the risk of the alternative mode is higher than the current mode!");
				}
			} else {
				log("No alternative enabled mode found!");
			}
		}
		switch2Mode(nextMode);
	}

	private static Mode sortModesAndGetNextMode() {
		Comparator<Mode> totalScoreComperator = Comparator.comparing(Mode::getActiveTotalScore);
		Comparator<Mode> avgScoreComperator = Comparator.comparing(Mode::getActiveAvgScore);
		Comparator<Mode> priorityComperator = Comparator.comparing(Mode::getPriority);
		Comparator<Mode> multipleFieldsComparator = totalScoreComperator.thenComparing(avgScoreComperator)
				.thenComparing(priorityComperator);
		modes.sort(multipleFieldsComparator);
		return modes.stream().filter(Mode::isEnabled).min(multipleFieldsComparator).orElse(getDefaultMode());
	}

	private static void showModeInformation() {
		Mode nextMode = sortModesAndGetNextMode();
		log("Current mode >> " + currentMode);
		log("----------------------------------------------------------------------------");
		log("Score        Avg      Prio  #CVE Enabled Name                    #Cnt/Starts");
		String format = "%5.1f/%5.1f %4.1f/%4.1f %4d %2d/%2d %7s %-24s %3d/%2d\n";
		for (Mode m : modes) {
			System.out.format(format, m.getActiveTotalScore(), m.getTotalScore(), m.getActiveAvgScore(),
					m.getAvgScore(), m.getPriority(), m.getNoOfActiveVulnerabilities(), m.getNoOfVulnerabilities(),
					m.isEnabled(), m.getName(), m.getCounter(), m.getStartCounter());
		}
		if (nextMode != currentMode) {
			log("----------------------------------------------------------------------------");
			log("Suggested next mode >> " + nextMode);
		}
	}

	public static void switch2Mode(String newMode) {
		Mode mode = getMode(newMode);
		if (mode != null) {
			switch2Mode(mode);
		} else {
			log("Mode " + newMode + " does not exists");
		}
	}

	static void switch2Mode(Mode newMode) {
		log("----------------------------------------------------------------------------");

		Instant start = Instant.now();
		Instant finishedAnalyzing = null;

		if (currentMode == null) {
			log("No current mode running");
			if (newMode == null) {
				// currentMode == null && newMode == null
				finishedAnalyzing = Instant.now();
				log("Nothing to do. Mode null remains");
			} else {
				// currentMode == null && newMode != null
				finishedAnalyzing = Instant.now();
				log("Complete start new mode " + newMode);
				newMode.increaseCounter();
				newMode.start();
			}
		} else if (currentMode.equals(newMode)) {
			// currentMode != newMode
			finishedAnalyzing = Instant.now();
			log("Mode " + currentMode + " is already running! Nothing to do.");
			newMode.increaseCounter();
		} else { // currentMode != null && currentMode != newMode
			if (newMode == null) {
				finishedAnalyzing = Instant.now();
				log("Stopping current mode " + currentMode);
				currentMode.stop();
			} else {
				// currentMode != null && currentMode != newMode && newMode != null
				log("Analyzing services of the new mode " + newMode + " and the current mode " + currentMode);
				// Don't stop services which are also used in the new mode
				List<Service> stopServices = new ArrayList<Service>(currentMode.getStopServices());
				List<Service> remainingServices = new ArrayList<Service>(currentMode.getStopServices());
				List<Service> newModeStopServices = new ArrayList<Service>(newMode.getStopServices());
				log("- currentMode stopServices:" + Arrays.asList(stopServices));
				log("- newMode stopServices:" + Arrays.asList(newModeStopServices));

				if (stopServices.removeAll(newModeStopServices)) {
					finishedAnalyzing = Instant.now();
					log("Some services are equal and remain");
					remainingServices.removeAll(stopServices);
					if (!remainingServices.isEmpty()) {
						log("- Following services remain:" + Arrays.asList(remainingServices));
					}

					if (!stopServices.isEmpty()) {
						log("- Following services are stopped:" + Arrays.asList(stopServices));
						currentMode.stop(stopServices);
					}

					// Don't start services which are already running in the current mode
					List<Service> startServices = new ArrayList<Service>(newMode.getStartServices());
					if (startServices.removeAll(currentMode.getStartServices()) && !startServices.isEmpty()) {
						log("- Following services are started:" + Arrays.asList(startServices));
						// some services from the current mode remain and must not be started again
						newMode.start(startServices);
					}
				} else {
					// no services remain from the current mode in the new mode - complete start &
					// stop
					finishedAnalyzing = Instant.now();
					log("Stopping current mode " + currentMode);
					currentMode.stop();
					log("Complete start new mode " + newMode);
					newMode.start();
				}
			}
		}

		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toNanos(); // in millis
		long timeAnalyzed = Duration.between(start, finishedAnalyzing).toNanos(); // in millis
		// log("time elapsed: " + timeElapsed + " ns");

		String currentModeName = "null";
		double currentModeActiveTotalScore = 0;
		String newModeName = "null";
		double newModeActiveTotalScore = 0;
		if (currentMode != null) {
			currentModeName = currentMode.getName();
			currentModeActiveTotalScore = currentMode.getActiveTotalScore();
		}
		if (newMode != null) {
			newModeName = newMode.getName();
			newModeActiveTotalScore = newMode.getActiveTotalScore();
		}

		addModeLogEntry(currentModeName + ";" + currentModeActiveTotalScore + ";" + newModeName + ";"
				+ newModeActiveTotalScore + ";" + timeElapsed + ";" + timeAnalyzed);

		currentMode = newMode;
		saveDataToDisk();
	}

	private static void addModeLogEntry(String text) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = new Date(System.currentTimeMillis());
		FileUtils.appendTextToFile(formatter.format(date) + ";" + text, MODESLOG);
	}

	private static void setDefaultMode(Mode mode) {
		if (mode != null && mode.isEnabled()) {
			defaultMode = mode;
			automaticModeSwitch();
		}
	}

	private static Mode getDefaultMode() {
		if (defaultMode != null && defaultMode.isEnabled()) {
			return defaultMode;
		} else {
			return null;
		}
	}

	static void addVulnerability(String date, String cveId, double score, String cpe) {
		if (vulnerabilityManager.addVulnerability(date, cveId, score, cpe)) {
			automaticModeSwitch();
			pause();
		}
	}

	static void addPatch(String date, String cveId, String cpe) {
		if (vulnerabilityManager.addPatch(date, cveId, cpe)) {
			automaticModeSwitch();
			pause();
		}
	}

	static void disableMode(Mode mode) {
		if (mode != null) {
			log("\n############################################################################");
			log("Mode " + mode + " disabled");
			mode.disable();
			automaticModeSwitch();
		}
	}

	static void disableSoftware(Software software) {
		if (software != null) {
			log("\n############################################################################");
			log("Software " + software + " disabled");
			software.disable();
			automaticModeSwitch();
		}
	}

	private static void showOpenVulnerabilities() {
		log("Open Vulnerabilities");
		showVulnerabilities(vulnerabilityManager.getVulnerabilities().values().stream().filter(Vulnerability::isActive)
				.collect(Collectors.toList()));
	}

	private static void showResolvedVulnerabilities() {
		log("Resolved Vulnerabilities");
		showVulnerabilities(vulnerabilityManager.getVulnerabilities().values().stream()
				.filter(Vulnerability::isResolved).collect(Collectors.toList()));
	}

	private static void showVulnerabilities() {
		log("Vulnerabilities");
		showVulnerabilities(vulnerabilityManager.getVulnerabilities().values());
	}

	private static void showVulnerabilitiesPerSoftware() {
		log("Vulnerabilities per software");
		HashMap<String, Software> software = vulnerabilityManager.getSoftware();
		for (Software s : software.values()) {
			log("############################################################################");
			log(s.getCpe() + " Vulnerabilities");
			showVulnerabilities(s.getVulnerabilities().values());
		}
	}

	private static void showOpenVulnerabilitiesPerSoftware() {
		log("Open vulnerabilities per software");
		HashMap<String, Software> software = vulnerabilityManager.getSoftware();
		for (Software s : software.values()) {
			log("############################################################################");
			log(s.getCpe() + " Vulnerabilities");
			showVulnerabilities(s.getVulnerabilities().values().stream().filter(Vulnerability::isActive)
					.collect(Collectors.toList()));
		}
	}

	private static void showVulnerabilities(Collection<Vulnerability> vulns) {
		log("----------------------------------------------------------------------------");
		if (vulns == null || vulns.size() == 0) {
			log("no vulnerabilities found");
		} else {
			List<Vulnerability> vList = new ArrayList<Vulnerability>(vulns);
			Comparator<Vulnerability> cveIdComperator = Comparator.comparing(Vulnerability::getCveId);
			Comparator<Vulnerability> dateComperator = Comparator.comparing(Vulnerability::getPublishDate);
			Comparator<Vulnerability> multipleFieldsComparator = dateComperator.thenComparing(cveIdComperator);
			Collections.sort(vList, multipleFieldsComparator);

			String format = "%-10s %-14s %5.1f %-10s %8d\n";
			log("Date       CVE            Score Resolved   Duration");
			for (Vulnerability v : vList) {
				System.out.format(format, v.getPublishDate(), v.getCveId(), v.getScore(), v.getResolvedDate(),
						v.getDaysForUpdate());
			}
		}
	}

	private static void showVulnerabilityStatisticPerSoftware() {
		log("Vulnerabilities statistics per software");
		log("----------------------------------------------------------------------------");
		HashMap<String, Software> software = vulnerabilityManager.getSoftware();
		for (Software s : software.values()) {
			showVulnerabilityStatistic(s.getCpe(), s.getVulnerabilities().values());
		}
	}

	private static void showVulnerabilityStatistics() {
		log("Vulnerabilities statistics");
		log("----------------------------------------------------------------------------");
		showVulnerabilityStatistic("Overall", vulnerabilityManager.getVulnerabilities().values());
	}

	private static void showVulnerabilityStatistic(String title, Collection<Vulnerability> vulns) {
		log(title + " Vulnerabilty Statistic");
		log("----------------------------------------------------------------------------");
		if (vulns == null || vulns.size() == 0) {
			log("No vulnerabilties");
		} else {
			Comparator<Vulnerability> scoreComperator = Comparator.comparing(Vulnerability::getScore);
			Comparator<Vulnerability> durationComperator = Comparator.comparing(Vulnerability::getDaysForUpdate);
			Vulnerability vulnHighestScore = vulns.stream().max(scoreComperator).get();
			Vulnerability vulnLowestScore = vulns.stream().min(scoreComperator).get();
			Vulnerability vulnLongestDuration = vulns.stream().filter(Vulnerability::isResolved).max(durationComperator)
					.get();
			Vulnerability vulnShortestDuration = vulns.stream().filter(Vulnerability::isResolved)
					.min(durationComperator).get();

			long resolvedVulns = vulns.stream().filter(Vulnerability::isResolved).count();
			long activeVulns = vulns.size() - resolvedVulns;
			Double avgScore = 0.0;
			Double avgDuration = 0.0;
			Double totalScore = vulns.stream().mapToDouble(Vulnerability::getScore).sum();
			int totalDuration = vulns.stream().filter(Vulnerability::isResolved)
					.mapToInt(Vulnerability::getDaysForUpdate).sum();
			avgScore = totalScore / vulns.size();
			avgDuration = (double) (totalDuration / vulns.stream().filter(Vulnerability::isResolved).count());

			log(vulns.size() + " Vulnerabilities: " + activeVulns + " active, " + resolvedVulns + " patched");
			log("Type       Total   Avg   Min                 Max");
			System.out.format("%-10s %5.1f %5.1f %5.1f %-14s %5.1f %-14s \n", "Score", totalScore, avgScore,
					vulnLowestScore.getScore(), vulnLowestScore.getCveId(), vulnHighestScore.getScore(),
					vulnHighestScore.getCveId());
			System.out.format("%-10s %3d   %5.1f %3d   %-14s %3d   %-14s \n", "Days4Patch", totalDuration, avgDuration,
					vulnShortestDuration.getDaysForUpdate(), vulnShortestDuration.getCveId(),
					vulnLongestDuration.getDaysForUpdate(), vulnLongestDuration.getCveId());
		}
	}

	private static void showModeHistory() {
		log("Mode switching history");
		log("----------------------------------------------------------------------------");

		String modelog = FileUtils.readTextFromFile(MODESLOG);

		if (modelog == null) {
			log("No mode switching history");
		} else {
			log(modelog);
		}
	}

	@SuppressWarnings("resource")
	static void pause() {
		if (debugging) {
			log("\n----- Press Enter To Continue -----");
			new java.util.Scanner(System.in).nextLine();
		}
	}

	public static void log(String text) {
		if (LOGGING)
			System.out.println(text);
	}

	public static boolean getExecutingFlag() {
		return executing;
	}

	public static OperatingSystem getOS() {
		return os;
	}

	public static HashMap<String, Software> getSoftware() {
		return vulnerabilityManager.getSoftware();
	}

	public static List<Mode> getModes() {
		return modes;
	}

}
