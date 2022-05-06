import java.io.Serializable;
import java.util.HashMap;

public class Software implements Serializable{
	private static final long serialVersionUID = -2607922701220494169L;
	private String vendor;
	private String product;
	private String version;
	private String packageName;
	private boolean enabled;
	private HashMap<String, Vulnerability> vulnerabilities;
	
	public Software(String vendor, String product, String version) {
		this(vendor,product,version,"");
	}
	
	public Software(String vendor, String product, String version, String packageName) {
		initSoftware(vendor, product, version, packageName, true);
	}

	public Software(String packageName) {
		String cpe = "";
		String vendor = "";
		String product = "";
		String version = "";
		//cpe:/a:apache:http_server
		//cpe:/:apache:http_server:2.4.38
		if(ModeSwitcher.getOS() != null) {
			cpe = ModeSwitcher.getOS().getCpeForPackage(packageName); //apache
		}
		if(cpe == null) {
			ModeSwitcher.log("No CPE for package " + packageName + " found");
		}else {
			String[] cpeArr;
			cpeArr = cpe.split(":"); // separator
			if(cpeArr.length >= 3) vendor = cpeArr[2]; //apache
			if(cpeArr.length >= 4) product = cpeArr[3]; //http_server
			if(cpeArr.length >= 5) version = cpeArr[4]; //2.4.38
			initSoftware(vendor, product, version, packageName, true);
		}
	}
	
	private void initSoftware(String vendor, String product, String version, String packageName, Boolean enabled) {
		this.setVendor(vendor);
		this.setProduct(product);
		this.setVersion(version);
		this.setPackage(packageName);
		this.setEnabled(enabled);
		this.vulnerabilities = new HashMap<String, Vulnerability>();
	}

	public void addVulnerability(String date, String cveId, double score) {
		this.addVulnerability(new Vulnerability(date, cveId, score));
	}
	
	public void addVulnerability(Vulnerability vulnerability) {
		if(vulnerability != null) {
			vulnerabilities.put(vulnerability.getCveId(),vulnerability);
		}
	}
	
	public double getActiveScoreSum() {
		if (getVulnerabilities().isEmpty()) {
			return 0.0;
		}else {
			return vulnerabilities.values().stream().filter(Vulnerability::isActive).mapToDouble(Vulnerability::getScore).sum();
		}
	}
	
	public double getScoreSum() {
		double sum = 0;
		if (getVulnerabilities() != null) {
			for (Vulnerability vulnerability : getVulnerabilities().values()) {
				sum += vulnerability.getScore();
			}
		}
		return sum;
	}
	
	public int getNoOfActiveVulnerabilties() {
		if (getVulnerabilities() == null || getVulnerabilities().isEmpty()) {
			return 0;
		}else {
			return (int) getVulnerabilities().values().stream().filter(Vulnerability::isActive).count();
		}
	}
	
	public int getNoOfVulnerabilities() {
		if(getVulnerabilities() == null || getVulnerabilities().isEmpty()) {
			return 0;
		}else {
			return getVulnerabilities().size();
		}
	}
	
	public double getActiveScoreAvg() {
		int noOfVulnerabilities = this.getNoOfActiveVulnerabilties();
		if (noOfVulnerabilities > 0) {
			return this.getActiveScoreSum()/noOfVulnerabilities;
		}
		return 0;
	}
	
	public double getScoreAvg() {
		int noOfVulnerabilities = this.getNoOfVulnerabilities();
		if (noOfVulnerabilities > 0) {
			return this.getScoreSum()/noOfVulnerabilities;
		}
		return 0;
	}

	public String getPackage() {
		return packageName;
	}

	public void setPackage(String packageName) {
		this.packageName = packageName;
	}

	public HashMap<String, Vulnerability> getVulnerabilities() {
		if(vulnerabilities == null) vulnerabilities = new HashMap<String, Vulnerability>();
		return vulnerabilities;
	}

	public boolean isEnabled() {
		if(!enabled) {
			System.out.println(getCpe() + " " + getPackage() + " is disabled");
		}
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	public void disable() {
		this.setEnabled(false);
	}
	
	public String toString() {
		return getCpe();
	}

	public String getCpe() {
		return "cpe:/:"+vendor+":"+product+":"+version;
	}

	public String getVendor() {
		return vendor;
	}

	public void setVendor(String vendor) {
		this.vendor = vendor;
	}

	public String getProduct() {
		return product;
	}

	public void setProduct(String product) {
		this.product = product;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}
	
}
