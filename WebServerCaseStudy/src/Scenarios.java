import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Scenarios {

	static void startVulnerabilityTimeSeries() {
		ModeSwitcher.log("Starting scenario vulnerability time series");
		ModeSwitcher.log("############################################################################");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0196",5.3,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0197",4.2,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0211",7.8,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0215",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0217",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-01","CVE-2019-0220",5.3,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0196","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0197","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0211","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0215","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0217","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-04-07","CVE-2019-0220","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-04-09","CVE-2019-11038",5.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-05-31","CVE-2019-11038","cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-06-18","CVE-2019-11039",9.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-06-18","CVE-2019-11040",9.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-08-13","CVE-2019-9511",7.5,"cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addPatch("2019-08-13","CVE-2019-9511","cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addVulnerability("2019-08-13","CVE-2019-9513",7.5,"cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addPatch("2019-08-13","CVE-2019-9513","cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addVulnerability("2019-08-13","CVE-2019-9516",6.5,"cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addPatch("2019-08-13","CVE-2019-9516","cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-10081",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-10082",9.1,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-10092",6.1,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-10097",7.2,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-10098",6.1,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-08-14","CVE-2019-9517",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-08-18","CVE-2019-10081","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-08-18","CVE-2019-10082","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-08-18","CVE-2019-10097","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-08-18","CVE-2019-10098","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2019-08-18","CVE-2019-9517","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2019-09-09","CVE-2019-11041",7.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-09-09","CVE-2019-11042",7.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-09-18","CVE-2019-11039","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-09-18","CVE-2019-11040","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-09-18","CVE-2019-11041","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-09-18","CVE-2019-11042","cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-10-24","CVE-2019-11043",9.8,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2019-10-26","CVE-2019-11043","cpe:/:php:php:7.3.5");
		//ModeSwitcher.addVulnerability("2019-11-25","CVE-2019-19246",7.5,"cpe:/:php:php:7.3.5");//no php vuln
		//ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11044",5.9,"cpe:/:php:php:7.3.5");//windows specific
		ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11045",7.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11046",6.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11047",9.8,"cpe:/:php:php:7.3.5");
		//ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11049",9.8,"cpe:/:php:php:7.3.5");//windows specific
		ModeSwitcher.addVulnerability("2019-12-22","CVE-2019-11050",7.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-01-09","CVE-2019-20372",5.3,"cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addPatch("2020-01-11","CVE-2019-20372","cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addVulnerability("2020-02-10","CVE-2020-7059",9.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-02-10","CVE-2020-7060",9.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2019-11045","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2019-11046","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2019-11047","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2019-11050","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2020-7059","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-02-16","CVE-2020-7060","cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-02-27","CVE-2020-7061",9.1,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-02-27","CVE-2020-7062",7.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-02-27","CVE-2020-7063",5.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-04-01","CVE-2020-1927",6.1,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2020-04-01","CVE-2020-1934",5.3,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2020-04-01","CVE-2020-7064",5.4,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-04-01","CVE-2020-7065",8.8,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-04-01","CVE-2020-7066",4.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-04-27","CVE-2020-7067",7.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-05-20","CVE-2019-11048",5.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2019-11048","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7061","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7062","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7063","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7064","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7065","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7066","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-07-05","CVE-2020-7067","cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-08-07","CVE-2020-11984",9.8,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2020-08-07","CVE-2020-11993",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2020-08-07","CVE-2020-9490",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2020-08-25","CVE-2020-11984","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2020-08-25","CVE-2020-11993","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2020-08-25","CVE-2020-1927","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2020-08-25","CVE-2020-1934","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2020-08-25","CVE-2020-9490","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2020-09-09","CVE-2020-7068",3.6,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-10-02","CVE-2020-7069",6.5,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2020-10-02","CVE-2020-7070",5.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2020-10-15","CVE-2019-10092","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2021-01-08","CVE-2020-7071",5.3,"cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2021-02-13","CVE-2020-7068","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2021-02-13","CVE-2020-7069","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2021-02-13","CVE-2020-7070","cpe:/:php:php:7.3.5");
		ModeSwitcher.addPatch("2021-02-13","CVE-2020-7071","cpe:/:php:php:7.3.5");
		ModeSwitcher.addVulnerability("2021-06-01","CVE-2021-23017",9.5,"cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addPatch("2021-05-28","CVE-2021-23017","cpe:/:nginx:nginx:1.14.2");
		ModeSwitcher.addVulnerability("2021-06-10","CVE-2019-17567",5.3,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2021-06-10","CVE-2020-35452",7.3,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2021-06-10","CVE-2021-26690",7.5,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addVulnerability("2021-06-10","CVE-2021-26691",9.8,"cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2021-06-10","CVE-2019-17567","cpe:/:apache:http_server:2.4.38");//ignored by debian: Intrusive and risky backport
		ModeSwitcher.addPatch("2021-06-10","CVE-2020-35452","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2021-06-10","CVE-2021-26690","cpe:/:apache:http_server:2.4.38");
		ModeSwitcher.addPatch("2021-06-10","CVE-2021-26691","cpe:/:apache:http_server:2.4.38");		
	}

	static void startAllModesDisabled() {
		ModeSwitcher.log("Starting scenario all modes disabled");
		ModeSwitcher.log("############################################################################");
		Collections.shuffle(ModeSwitcher.getModes());
		for (Mode m : ModeSwitcher.getModes()) {
			ModeSwitcher.disableMode(m);
			ModeSwitcher.pause();
		}
	}
	
	static void startAllSoftwareDisabled() {
		ModeSwitcher.log("Starting scenario all software disabled");
		ModeSwitcher.log("############################################################################");
		for (Software s : ModeSwitcher.getSoftware().values()) {
			ModeSwitcher.disableSoftware(s);
			ModeSwitcher.pause();
		}
	}
	
	static void startRandomModeOrder() {
		Collections.shuffle(ModeSwitcher.getModes());
		ModeSwitcher.log("Starting scenario random modes with following order: " + Arrays.asList(ModeSwitcher.getModes()));
		ModeSwitcher.log("############################################################################");
		startScenario_withFollowingModes(ModeSwitcher.getModes());
	}
	
	static void startScenario_withFollowingModes(List<Mode> modes) {
		for (Mode m : modes) {
			ModeSwitcher.log("Manual mode switch to " + m);
			ModeSwitcher.log("----------------------------------------------------------------------------");
			ModeSwitcher.switch2Mode(m);
			ModeSwitcher.pause();
		}
	}

	public static void startModeSwitchingDuration(List<Mode> modes, int times) {
		ModeSwitcher.log("Starting scenario mode switching duration "+times+" times");
		ModeSwitcher.log("############################################################################");
		Mode mode_null = null;
		for(int i = 1; i < times; i++) {
			ModeSwitcher.log("___________");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log(">    "+i+"   <");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log("|          |");
			ModeSwitcher.log("___________");
			
			ModeSwitcher.switch2Mode(mode_null);
			startRandomModeOrder();
		}
	}
	
	public static void startGenerateSystemConfiguration(int times) {
		ModeSwitcher.log("Starting scenario to generate the system configuration "+times+" times");
		ModeSwitcher.log("############################################################################");
		for(int i = 1; i < times; i++) {
			ModeSwitcher.log(">    "+i+"   <");
			ModeSwitcher.generateSystemConfigurationCreatorFileFromMdsl();
		}
	}
	
	public static void startUpdateVulnerabilitiesAndPatches(int times) {
		ModeSwitcher.log("Starting scenario to update vulnerabilities and patches "+times+" times");
		ModeSwitcher.log("############################################################################");
		for(int i = 1; i < times; i++) {
			ModeSwitcher.log(">    "+i+"   <");
			ModeSwitcher.refreshVulnerabilitiesAndPatches(true);
		}
	}
}
