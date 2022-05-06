import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Debian implements OperatingSystem {

	private static final String debianTrackerBaseUrl = "https://security-tracker.debian.org/tracker/data/json";
	private String release = null;
	private HashMap<String, String> packageList;
	private HashMap<String, Action> defaultActions;
	
	public Debian() throws Exception {
		this(null);
	}

	public Debian(String release) throws Exception {
		packageList = new HashMap<String, String>();
		defaultActions = new HashMap<String, Action>();
		updatePackageList();
		initDefaultActions();
		
		if(release == null) {
			updateRelease();
		}else {
			setRelease(release);
		}
	}
	
	private void updatePackageList() throws Exception {
		//String currentPath = new File("").getAbsolutePath().toString();
		//System.out.println("currentPath: " + currentPath);
		File f = new File("debian-package-cpe-list.csv");
		if(!f.exists()) f = new File("package-cpe-list.csv");
	    if(f.exists()) {	    	
	    	String line = "";  
	    	String splitBy = ";";  
	    	try {  
		    	//parsing a CSV file into BufferedReader class constructor  
		    	BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));  
		    	while ((line = br.readLine()) != null)   //returns a Boolean value  
		    	{  
		    		String[] currentLine = line.split(splitBy);    // use separator  
		    		//System.out.println("[package=" + currentLine[0] + ", cpe=" + currentLine[1]);
		    		packageList.put(currentLine[0],currentLine[1]);
		    	}  
		    	br.close();
	    	}   
	    	catch (IOException e)   {  
	    		e.printStackTrace();  
	    	}  
	    }else {
	    	ModeSwitcher.log("debian-package-cpe-list.csv not found");
	    }
	}

	@Override
	public String getRelease() {
		return this.release;
	}
	
	@Override
	public void setRelease(String release) {
		this.release = release;
	}

	@Override
	public String getSoftwareVersion(String software) {
		// Debian, Ubuntu, Linux Mint, Elementary OS
		// dpkg -s apache2 | grep -i version ==> Version: 2.4.38-3+deb10u4
		// dpkg -s nginx | grep -i version ==> Version: 1.14.2-2+deb10u3
		// dpkg -s php | grep -i version ==> Version: 2:7.3+69 PHP version (currently
		// 7.3).
		// apt-cache policy apache2 | grep Installed: | cut -d: -f2 => 2.4.38-3+deb10u4
		// dpkg-query -W -f='${--Version}\n' apache2 => 2.4.38-3+deb10u4
		return ShellCommand.executeAndGetResults("dpkg-query -W -f='${Version}\n' " + software);
	}

	@Override
	public LocalDate getReleaseDate() {
		LocalDate date = LocalDate.of(2000, 1, 1); // default date
		// based on https://wiki.debian.org/DebianReleases
		switch (getRelease()) {
		case "strech":
			date = LocalDate.parse("2017-06-17");
			break;
		case "buster":
			date = LocalDate.parse("2019-07-06");
			break;
		}
		return date;
	}

	@Override
	public void refreshPatches(VulnerabilityManager vm){
		// https://security-tracker.debian.org/tracker/data/json
		// apache2.CVE-2001-1534.releases.buster.status open/resolved
		// apache2.CVE-2001-1534.releases.buster.status open/resolved

		if (getRelease() == null) {
			System.out.println("Parameter debianRelease is undefined");
			return;
		}

		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date(System.currentTimeMillis());
		
		String filename = ModeSwitcher.PATCHESDIR + File.separator + "debian-security-tracker.json";
		File f = new File(filename);
		if(!f.exists()) {
			FileUtils.loadFileFromUrl(debianTrackerBaseUrl, filename);
		}
		
		if(f.exists()) {

			ObjectMapper objectMapper = new ObjectMapper();
			try {
				System.out.println("Loading Data from Debian Security Tracker");
				JsonNode jsonNode = objectMapper.readValue(f, JsonNode.class);

				for (Software s : ModeSwitcher.getSoftware().values()) {
					if (jsonNode.has(s.getPackage())) {
						System.out.println("Package " + s.getPackage() + " found");
						JsonNode packageNode = jsonNode.get(s.getPackage()); // apache2
						Iterator<Map.Entry<String, JsonNode>> iter = packageNode.fields();
						// System.out.println("CVE status");
						// String format = "%-14s %10s\n";
						while (iter.hasNext()) { // next cve
							Map.Entry<String, JsonNode> cveNode = iter.next();
							String cveId = cveNode.getKey();
							String status = cveNode.getValue().at("/releases/" + getRelease() + "/status").asText(); // open/resolved
							String urgency = cveNode.getValue().at("/releases/" + getRelease() + "/urgency").asText(); // unimportant/low/medium/high
							// System.out.format(format, cveId, status);
							if (vm.checkCVEString(cveId) && (status.equals("resolved") || urgency.equals("unimportant"))) {
								if (status.equals("open") && urgency.equals("unimportant")) {
									System.out.println("WARNING: " + cveId + " is open, but considered as unimportant");
								}
								vm.addPatch(formatter.format(date), cveId,
										"cpe:/:" + s.getVendor() + ":" + s.getProduct() + ":" + s.getVersion());
							} else {
								System.out.println(cveId + " is " + status);
							}
						}
					} else {
						System.out.println("Package " + s.getPackage() + " not found");
					}
					System.out.println("----------------------------------------------------------------------------");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void updateRelease() {
		//lsb_release --codename ==> Codename: buster
		//lsb_release --codename | cut -d ':' -f 2 | xargs => buster
	    release = ShellCommand.executeAndGetResults("lsb_release -sc"); //buster
	}

	@Override
	public String getCpeForPackage(String packageName) {
		String cpe = "";
		cpe = packageList.get(packageName);
		return cpe;
	}
	
	private void initDefaultActions(){
		defaultActions.put("startService",new Action("Start Linux Service", "/usr/bin/systemctl start"));
		defaultActions.put("stopService", new Action("Stop Linux Service", "/usr/bin/systemctl stop"));
		defaultActions.put("enableApacheMod", new Action("Enable Apache Module", "/usr/sbin/a2enmod --quiet"));
		defaultActions.put("disableApacheMod", new Action("Disable Apache Module", "/usr/sbin/a2dismod -f --quiet"));
		defaultActions.put("enableApacheConf", new Action("Enable Apache Configuration", "/usr/sbin/a2enconf --quiet"));
		defaultActions.put("disableApacheConf", new Action("Disable Apache Configuration", "/usr/sbin/a2disconf --quiet"));
	}
	
	@Override
	public HashMap<String, Action> getDefaultActions(){
		return defaultActions;
	}
}
