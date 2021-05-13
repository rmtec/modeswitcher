import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ModeSwitcher {
	
	private static Mode currentMode = null;
	private static Mode defaultMode = null;
	private static List<Mode> modes;
	private static HashMap<String, Software> software;
	private static HashMap<String, Vulnerability> vulnerabilities;
	private static String debianRelease;
	private static String releaseDate;
	private static VulnerabilityManager vulnerabilityManager;
	private static SystemConfiguration config; 
	
	private static final boolean LOGGING = true;
	private static final boolean DEBUGGING = true;
	private static final boolean EXECUTING = false;
	
	private static List<String> modelog;

	public static void main(String[] args) {	
		modes = new ArrayList<Mode>();
		software = new HashMap<String, Software>();
		vulnerabilities = new HashMap<String, Vulnerability>();
		modelog = new ArrayList<String>();
		
		log("############################################################################");
		log("Starting ModeSwitcher");
		log("############################################################################");
		
		// LOAD SYSTEM CONFIGURATION
		if(systemConfigurationInstanceExists()) {
			//config = SystemConfigurationCreator.create();		
		}else {
			config = createSystem();
		}
		modes = config.getModes();
		software = config.getSoftware();
		debianRelease = config.getDebianRelease();
		releaseDate = config.getReleaseDate();
		log("Possible modes:" + Arrays.asList(modes));
		//showUsedSoftware();
		
		//INIT
		switch2NextMode();
		vulnerabilityManager = new VulnerabilityManager(software, debianRelease, releaseDate);
		refreshVulnerabilitiesAndPatches();
		//refreshVulnerabilitiesAndPatches();
				
		//startScenario_allModesDisabled();
		//startScenario_allSoftwareDisabled();
		//startScenario_Random();
		//startScenario_withFollowingModes(Arrays.asList(null,apache2, apache2WithModPhp, apache2withPhpFpm, nginx, nginxWithPhpFpm));

		startScenario_VulnerabilityTimeSeries();
		
		//showVulnerabilities();
		//showVulnerabilitiesPerSoftware();
		//showVulnerabilityStatistics();
		//showVulnerabilityStatisticForEachSoftware();
		//showModeHistory();
		
		//manual mode switch
		//switch2Mode(apache2);
	}
	
	private static boolean systemConfigurationInstanceExists() {
		File f = new File("src-gen/SystemConfigurationInstance.java");
	    return f.exists();
	}

	public static SystemConfiguration createSystem() {		
		debianRelease = "buster";
		releaseDate = "2019-07-06";
		List<Mode> modes  = new ArrayList<Mode>();
		HashMap<String, Software> software = new HashMap<String, Software>();

		Software swApache2 	= new Software("apache","http_server","2.4.38", "apache2");
		Software swNginx 	= new Software("nginx","nginx","1.14.2", "nginx");
		Software swPhp 		= new Software("php","php","7.3.5", "php7.3");
		
		software.put("cpe:/:"+swApache2.getVendor()+":"+swApache2.getProduct()+":"+swApache2.getVersion(), swApache2);
		software.put("cpe:/:"+swNginx.getVendor()+":"+swNginx.getProduct()+":"+swNginx.getVersion(), swNginx);
		software.put("cpe:/:"+swPhp.getVendor()+":"+swPhp.getProduct()+":"+swPhp.getVersion(), swPhp);
		
		Action startLinuxService 	= new Action("Start Linux Service", "servicectl start");
		Action stopLinuxService 	= new Action("Stop Linux Service", "servicectl stop");
		Action enableApacheMod 		= new Action("Enable Apache Module", "/sbin/a2enmod --quiet");
		Action disableApacheMod 	= new Action("Disable Apache Module", "/sbin/a2dismod -f --quiet");	
		Action enableApacheConf 	= new Action("Enable Apache Configuration", "/sbin/a2enconf --quiet");
		Action disableApacheConf 	= new Action("Disable Apache Configuration", "/sbin/a2disconf --quiet");
		
		Service apache2Service 				= new Service("Apache2", swApache2, startLinuxService.withParams("apache2"), stopLinuxService.withParams("apache2"));
		//Service apacheModPhpService 		= new Service("Apache2ModPhp", swPhp, enableApacheMod.withParams("php7.3"), disableApacheMod.withParams("php7.3"));
		Service apacheModProxyFcgiService 	= new Service("Apache2ModProxyFcgi", enableApacheMod.withParams("proxy_fcgi"), disableApacheMod.withParams("proxy_fcgi"));
		Service apacheModSetenvifService 	= new Service("Apache2ModSetevif", enableApacheMod.withParams("setenvif"), disableApacheMod.withParams("setenvif"));
		Service apacheConfPhpFpmService 	= new Service("Apache2ConfPhpFpm", enableApacheConf.withParams("php7.3-fpm"), disableApacheConf.withParams("php7.3-fpm"));
		Service nginxService 				= new Service("Nginx", swNginx, startLinuxService.withParams("nginx"), stopLinuxService.withParams("nginx"));
		Service phpFpmService 				= new Service("PhpFpm", swPhp, startLinuxService.withParams("php7.3-fpm"), stopLinuxService.withParams("php7.3-fpm"));
		
		Mode apache2withPhpFpm = new Mode("Apache2 with PHP-FPM", 1,
				Arrays.asList(apacheModProxyFcgiService, apacheModSetenvifService, apacheConfPhpFpmService, phpFpmService, apache2Service),
				Arrays.asList(apache2Service,phpFpmService,apacheConfPhpFpmService, apacheModSetenvifService, apacheModProxyFcgiService)
		);
		Mode nginxWithPhpFpm = new Mode("Nginx with PHP-FPM", 2, Arrays.asList(nginxService,phpFpmService), Arrays.asList(phpFpmService,nginxService));
		//Mode apache2WithModPhp = new Mode("Apache2 with Module PHP", 3, Arrays.asList(apache2Service,apacheModPhpService), Arrays.asList(apacheModPhpService,apache2Service));
		Mode apache2 = new Mode("Apache2", 4, apache2Service, apache2Service);
		Mode nginx = new Mode("Nginx", 5, nginxService, nginxService);
		//modes = Arrays.asList(apache2, apache2WithModPhp, apache2withPhpFpm, nginx, nginxWithPhpFpm);
		modes = Arrays.asList(apache2, apache2withPhpFpm, nginx, nginxWithPhpFpm);
		//modes = Arrays.asList(apache2WithModPhp, apache2withPhpFpm, nginxWithPhpFpm);
		//modes = Arrays.asList(apache2, apache2WithModPhp, apache2withPhpFpm);
		//modes = Arrays.asList(nginx, nginxWithPhpFpm);
		//setDefaultMode(apache2);
		
		return new SystemConfiguration(modes, software, debianRelease, releaseDate);
	}
	
	private static void refreshVulnerabilitiesAndPatches() {
		vulnerabilityManager.refreshVulnerabilities();
		vulnerabilityManager.refreshPatches();
		vulnerabilities = vulnerabilityManager.getVulnerabilities();
		switch2NextMode();
	}

	private static void addSoftware(Software s) {
		software.put("cpe:/:"+s.getVendor()+":"+s.getProduct()+":"+s.getVersion(), s);
	}

	private static void showUsedSoftware() {
		for (String i : software.keySet()) {
			log("key: " + i + " value: " + software.get(i));
		}
	}
	
	private static void startScenario_Random() {
		Collections.shuffle(modes);
		startScenario_withFollowingModes(modes);
	}
	
	private static void startScenario_withFollowingModes(List<Mode> modes) {
		for (Mode m : modes) {
			log("\n############################################################################");
			log("Manual mode switch to " + m);
			log("############################################################################");
			switch2Mode(m);
			pause();
		}
	}
	
	private static void startScenario_allModesDisabled() {
		Collections.shuffle(modes);
		for (Mode m : modes) {
			disableMode(m);
		}
	}
	
	private static void startScenario_allSoftwareDisabled() {
		for (Software s : software.values()) {
			disableSoftware(s);
		}
	}

	private static void switch2NextMode() {
		Mode nextMode = getNextMode();
		switch2Mode(nextMode);
		pause();
	}
	
	private static Mode getNextMode() {
		log("############################################################################");
		log("getNextMode");
		log("----------------------------------------------------------------------------");
		Comparator<Mode> totalScoreComperator	= Comparator.comparing(Mode::getActiveTotalScore);
		Comparator<Mode> avgScoreComperator		= Comparator.comparing(Mode::getActiveAvgScore);
		Comparator<Mode> priorityComperator 	= Comparator.comparing(Mode::getPriority);
		Comparator<Mode> multipleFieldsComparator = totalScoreComperator.thenComparing(avgScoreComperator).thenComparing(priorityComperator);
		modes.sort(multipleFieldsComparator);
		log("Score        Avg      Prio  #CVE Enabled Desc                    #Cnt/Starts");
		String format = "%5.1f/%5.1f %4.1f/%4.1f %4d %2d/%2d %7s %-24s %3d/%2d\n";
		for (Mode m : modes) {
			System.out.format(format, 
				m.getActiveTotalScore(),
				m.getTotalScore(),
				m.getActiveAvgScore(),
				m.getAvgScore(),
				m.getPriority(),
				m.getNoOfActiveVulnerabilities(),
				m.getNoOfVulnerabilities(),
				m.isEnabled(),
				m.getDesc(),
				m.getCounter(),
				m.getStartCounter()
			);
		}
		log("----------------------------------------------------------------------------");
		Mode nextMode = modes.stream().filter(Mode::isEnabled).min(multipleFieldsComparator).orElse(getDefaultMode());
		log("Calculated next mode >> " + nextMode);
		nextMode.increaseCounter();
		return nextMode;
	}
	
	private static void switch2Mode(Mode newMode) {
		log("----------------------------------------------------------------------------");
		if(currentMode == null && newMode == null) {
			log("Nothing to do");
		}else if(currentMode == newMode){ //nothing to do
			log("Mode " + currentMode + " is already running"); 
		}else if(currentMode == null && newMode != null) { //nothing to stop
			log("No current mode running"); 
			log("Complete start new mode " + newMode);
			newMode.start();
		}else if(currentMode != null && newMode == null) { //nothing to start
			log("Stopping current mode " + currentMode);
			currentMode.stop();
		}else { //currentMode != null && newMode != null
			log("Analyzing services of the new mode and the current mode "+ currentMode);
			//Don't stop services which are also used in the new mode
			List<Service> currentModeStopServices = new ArrayList<Service>(currentMode.getStopServices());
			log("> currentMode stopServices:" + Arrays.asList(currentModeStopServices));
			List<Service> newModeStopServices = new ArrayList<Service>(newMode.getStopServices());
			log("> newMode stopServices:" + Arrays.asList(newModeStopServices));
					
			if(currentModeStopServices.removeAll(newModeStopServices)) {
				log("Some services are equal and remain from the current mode in the new mode");
				if (!currentModeStopServices.isEmpty()) {
					log("Partial stop the following services:");
					currentMode.stop(currentModeStopServices);
				}
					
				//Don't start services which are already running in the current mode
				List<Service> startServices = new ArrayList<Service>(newMode.getStartServices());
				startServices.removeAll(currentMode.getStartServices());
				log("Partial start the following services of the new mode " + newMode);
				//some services from the current mode remain and must not be started again
				newMode.start(startServices);
			}else {
				//no services remain from the current mode in the new mode - complete start & stop
				log("Stopping current mode " + currentMode);
				currentMode.stop();
				log("Complete start new mode " + newMode);
				newMode.start();
			}
				
		}
		currentMode = newMode;
		modelog.add(currentMode.getDesc());
	}
	
	private static void setDefaultMode(Mode mode) {
		if(mode != null && mode.isEnabled()) {
			defaultMode = mode;
			switch2NextMode();
		}
	}
	
	private static Mode getDefaultMode() {
		if(defaultMode != null && defaultMode.isEnabled()) {
			return defaultMode;
		}else {
			return null;
		}
	}

	private static void addVulnerability(String date, String cveId, double score, String cpe) {
		if(vulnerabilityManager.addVulnerability(date, cveId, score, cpe)) switch2NextMode();
	}
	
	private static void addPatch(String date, String cveId, String cpe) {
		if(vulnerabilityManager.addPatch(date, cveId, cpe)) switch2NextMode();
	}
	
	private static void disableMode(Mode mode) {
		if(mode != null) {
			log("\n############################################################################");
			log("Mode " + mode + " disabled");
			mode.disable();
			switch2NextMode();
		}
	}
	
	private static void disableSoftware(Software software) {
		if(software != null) {
			log("\n############################################################################");
			log("Software " + software + " disabled");
			software.disable();
			switch2NextMode();
		}
	}
	
	private static void startScenario_VulnerabilityTimeSeries() {
		addVulnerability("2019-04-01","CVE-2019-0196",5.3,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-01","CVE-2019-0197",4.2,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-01","CVE-2019-0211",7.8,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-01","CVE-2019-0215",7.5,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-01","CVE-2019-0217",7.5,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-01","CVE-2019-0220",5.3,"cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0196","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0197","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0211","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0215","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0217","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-04-07","CVE-2019-0220","cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-04-09","CVE-2019-11038",5.3,"cpe:/:php:php:7.3.5");
		addPatch("2019-05-31","CVE-2019-11038","cpe:/:php:php:7.3.5");
		addVulnerability("2019-06-18","CVE-2019-11039",9.1,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-06-18","CVE-2019-11040",9.1,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-08-13","CVE-2019-9511",7.5,"cpe:/:nginx:nginx:1.14.2");
		addPatch("2019-08-13","CVE-2019-9511","cpe:/:nginx:nginx:1.14.2");
		addVulnerability("2019-08-13","CVE-2019-9513",7.5,"cpe:/:nginx:nginx:1.14.2");
		addPatch("2019-08-13","CVE-2019-9513","cpe:/:nginx:nginx:1.14.2");
		addVulnerability("2019-08-13","CVE-2019-9516",6.5,"cpe:/:nginx:nginx:1.14.2");
		addPatch("2019-08-13","CVE-2019-9516","cpe:/:nginx:nginx:1.14.2");
		addVulnerability("2019-08-14","CVE-2019-10081",7.5,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-08-14","CVE-2019-10082",9.1,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-08-14","CVE-2019-10092",6.1,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-08-14","CVE-2019-10097",7.2,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-08-14","CVE-2019-10098",6.1,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-08-14","CVE-2019-9517",7.5,"cpe:/:apache:http_server:2.4.38");
		addPatch("2019-08-18","CVE-2019-10081","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-08-18","CVE-2019-10082","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-08-18","CVE-2019-10097","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-08-18","CVE-2019-10098","cpe:/:apache:http_server:2.4.38");
		addPatch("2019-08-18","CVE-2019-9517","cpe:/:apache:http_server:2.4.38");
		addVulnerability("2019-09-09","CVE-2019-11041",7.1,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-09-09","CVE-2019-11042",7.1,"cpe:/:php:php:7.3.5");
		addPatch("2019-09-18","CVE-2019-11039","cpe:/:php:php:7.3.5");
		addPatch("2019-09-18","CVE-2019-11040","cpe:/:php:php:7.3.5");
		addPatch("2019-09-18","CVE-2019-11041","cpe:/:php:php:7.3.5");
		addPatch("2019-09-18","CVE-2019-11042","cpe:/:php:php:7.3.5");
		addVulnerability("2019-10-24","CVE-2019-11043",9.8,"cpe:/:php:php:7.3.5");
		addPatch("2019-10-26","CVE-2019-11043","cpe:/:php:php:7.3.5");
		addVulnerability("2019-11-25","CVE-2019-19246",7.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11044",5.9,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11045",7.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11046",6.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11047",9.8,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11049",9.8,"cpe:/:php:php:7.3.5");
		addVulnerability("2019-12-22","CVE-2019-11050",7.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-01-09","CVE-2019-20372",5.3,"cpe:/:nginx:nginx:1.14.2");
		addPatch("2020-01-11","CVE-2019-20372","cpe:/:nginx:nginx:1.14.2");
		addVulnerability("2020-02-10","CVE-2020-7059",9.1,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-02-10","CVE-2020-7060",9.1,"cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2019-11045","cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2019-11046","cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2019-11047","cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2019-11050","cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2020-7059","cpe:/:php:php:7.3.5");
		addPatch("2020-02-16","CVE-2020-7060","cpe:/:php:php:7.3.5");
		addVulnerability("2020-02-27","CVE-2020-7061",9.1,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-02-27","CVE-2020-7062",7.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-02-27","CVE-2020-7063",5.3,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-04-01","CVE-2020-1927",6.1,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2020-04-01","CVE-2020-1934",5.3,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2020-04-01","CVE-2020-7064",5.4,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-04-01","CVE-2020-7065",8.8,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-04-01","CVE-2020-7066",4.3,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-04-27","CVE-2020-7067",7.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-05-20","CVE-2019-11048",5.3,"cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2019-11048","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7061","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7062","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7063","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7064","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7065","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7066","cpe:/:php:php:7.3.5");
		addPatch("2020-07-05","CVE-2020-7067","cpe:/:php:php:7.3.5");
		addVulnerability("2020-08-07","CVE-2020-11984",9.8,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2020-08-07","CVE-2020-11993",7.5,"cpe:/:apache:http_server:2.4.38");
		addVulnerability("2020-08-07","CVE-2020-9490",7.5,"cpe:/:apache:http_server:2.4.38");
		addPatch("2020-08-25","CVE-2020-11984","cpe:/:apache:http_server:2.4.38");
		addPatch("2020-08-25","CVE-2020-11993","cpe:/:apache:http_server:2.4.38");
		addPatch("2020-08-25","CVE-2020-1927","cpe:/:apache:http_server:2.4.38");
		addPatch("2020-08-25","CVE-2020-1934","cpe:/:apache:http_server:2.4.38");
		addPatch("2020-08-25","CVE-2020-9490","cpe:/:apache:http_server:2.4.38");
		addVulnerability("2020-09-09","CVE-2020-7068",3.6,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-10-02","CVE-2020-7069",6.5,"cpe:/:php:php:7.3.5");
		addVulnerability("2020-10-02","CVE-2020-7070",5.3,"cpe:/:php:php:7.3.5");
		addPatch("2020-10-15","CVE-2019-10092","cpe:/:apache:http_server:2.4.38");
		addVulnerability("2021-01-08","CVE-2020-7071",5.3,"cpe:/:php:php:7.3.5");
		addPatch("2021-02-13","CVE-2020-7068","cpe:/:php:php:7.3.5");
		addPatch("2021-02-13","CVE-2020-7069","cpe:/:php:php:7.3.5");
		addPatch("2021-02-13","CVE-2020-7070","cpe:/:php:php:7.3.5");
		addPatch("2021-02-13","CVE-2020-7071","cpe:/:php:php:7.3.5");
	}
	
	private static void showActiveVulnerabilities() {
		log("############################################################################");
		log("Active Vulnerabilities");
		showVulnerabilities(vulnerabilities.values().stream().filter(Vulnerability::isActive).collect(Collectors.toList()));
	}
	
	private static void showResolvedVulnerabilities() {
		log("############################################################################");
		log("Resolved Vulnerabilities");
		showVulnerabilities(vulnerabilities.values().stream().filter(Vulnerability::isResolved).collect(Collectors.toList()));
	}
	
	private static void showVulnerabilities() {
		log("############################################################################");
		log("Vulnerabilities");
		showVulnerabilities(vulnerabilities.values());
	}
	
	private static void showVulnerabilitiesPerSoftware() {
		for (Software s : software.values()) {
			log("############################################################################");
			log(s.getCpe() + " Vulnerabilities");
			showVulnerabilities(s.getVulnerabilities().values());
		}	
	}
	
	private static void showVulnerabilities(Collection<Vulnerability> vulns) {
		log("----------------------------------------------------------------------------");
		if(vulns == null || vulns.size() == 0) {
			log("no vulnerabilities");
		}else {
			List<Vulnerability> vList = new ArrayList<Vulnerability>(vulns);
			Comparator<Vulnerability> cveIdComperator = Comparator.comparing(Vulnerability::getCveId);
			Comparator<Vulnerability> dateComperator = Comparator.comparing(Vulnerability::getPublishDate);
			Comparator<Vulnerability> multipleFieldsComparator = dateComperator.thenComparing(cveIdComperator);
			Collections.sort(vList,multipleFieldsComparator);
			
			String format = "%-10s %-14s %5.1f %-10s %8d\n";
			log("Date       CVE            Score Resolved   Duration");
			for (Vulnerability v : vList) {
					System.out.format(format, v.getPublishDate(), v.getCveId(),  v.getScore(), v.getResolvedDate(), v.getDaysForUpdate());
			}
		}
	}
	
	private static void showVulnerabilityStatisticForEachSoftware() {
		for (Software s : software.values()) {
			showVulnerabilityStatistic(s.getCpe(), s.getVulnerabilities().values());
		}
	}
	
	private static void showVulnerabilityStatistics() {
		showVulnerabilityStatistic("Overall", vulnerabilities.values());
	}
	
	private static void showVulnerabilityStatistic(String title, Collection<Vulnerability> vulns) {
		log("############################################################################");
		log(title + " Vulnerabilty Statistic");
		log("----------------------------------------------------------------------------");
		if(vulns == null || vulns.size() == 0) {
			log("No vulnerabilties");
		}else{
			Comparator<Vulnerability> scoreComperator = Comparator.comparing(Vulnerability::getScore);
			Comparator<Vulnerability> durationComperator = Comparator.comparing(Vulnerability::getDaysForUpdate);
			Vulnerability vulnHighestScore = vulns.stream().max(scoreComperator).get();
			Vulnerability vulnLowestScore = vulns.stream().min(scoreComperator).get();
			Vulnerability vulnLongestDuration = vulns.stream().filter(Vulnerability::isResolved).max(durationComperator).get();
			Vulnerability vulnShortestDuration = vulns.stream().filter(Vulnerability::isResolved).min(durationComperator).get();
			
			long resolvedVulns = vulns.stream().filter(Vulnerability::isResolved).count();
			long activeVulns = vulns.size() - resolvedVulns;
			Double avgScore = 0.0;
			Double avgDuration = 0.0;
			Double totalScore = vulns.stream().mapToDouble(Vulnerability::getScore).sum();
			int totalDuration = vulns.stream().filter(Vulnerability::isResolved).mapToInt(Vulnerability::getDaysForUpdate).sum();
			avgScore = totalScore / vulns.size();	
			avgDuration = (double) (totalDuration / vulns.stream().filter(Vulnerability::isResolved).count());	
			
			log(vulns.size() + " Vulnerabilities: " + activeVulns + " active, " + resolvedVulns + " patched");
			log("Type       Total   Avg   Min                 Max");
			System.out.format("%-10s %5.1f %5.1f %5.1f %-14s %5.1f %-14s \n", "Score", totalScore, avgScore,
				vulnLowestScore.getScore(), vulnLowestScore.getCveId(),
				vulnHighestScore.getScore(), vulnHighestScore.getCveId()
			);
			System.out.format("%-10s %3d   %5.1f %3d   %-14s %3d   %-14s \n", "Days4Patch", totalDuration, avgDuration,
				vulnShortestDuration.getDaysForUpdate(), vulnShortestDuration.getCveId(),
				vulnLongestDuration.getDaysForUpdate(), vulnLongestDuration.getCveId()
			);
		}
	}
	
	private static void showModeHistory() {
		log("############################################################################");
		log("Mode switching history");
		log("----------------------------------------------------------------------------");
		if(modelog == null) {
			log("No mode switching history");
		}else{
			for (String string : modelog) {
				log(string);
			}
		}
	}

	@SuppressWarnings("resource")
	private static void pause() {
		if(DEBUGGING) {
			System.out.println("\n----- Press Any Key To Continue...");
	        new java.util.Scanner(System.in).nextLine();
		}
	}
	
	private static void log(String text) {
		if(LOGGING) System.out.println(text);
	}
	
	public static boolean getExecutingFlag() {
		return EXECUTING;
	}

}
