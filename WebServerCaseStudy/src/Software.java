import java.util.HashMap;

public class Software {
	private String vendor;
	private String product;
	private String version;
	private String debianPackage;
	private HashMap<String, Vulnerability> vulnerabilities;
	private boolean enabled;
	
	public Software(String vendor, String product, String version) {
		this(vendor,product,version,"");
	}
	
	public Software(String vendor, String product, String version, String link) {
		this.setVendor(vendor);
		this.setProduct(product);
		this.setVersion(version);
		this.setDebianPackage(link);
		this.vulnerabilities = new HashMap<String, Vulnerability>();
		this.setEnabled(true);
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
		return vulnerabilities.values().stream().filter(Vulnerability::isActive).mapToDouble(Vulnerability::getScore).sum();
	}
	
	public double getScoreSum() {
		double sum = 0;
		for (Vulnerability vulnerability : vulnerabilities.values()) {
			sum += vulnerability.getScore();
		}
		return sum;
	}
	
	public int getNotOfActiveVulnerabilties() {
		return (int) vulnerabilities.values().stream().filter(Vulnerability::isActive).count();
	}
	
	public int getNoOfVulnerabilities() {
		return vulnerabilities.size();
	}
	
	public double getActiveScoreAvg() {
		int noOfVulnerabilities = this.getNotOfActiveVulnerabilties();
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

	public String getDebianPackage() {
		return debianPackage;
	}

	public void setDebianPackage(String debianPackage) {
		this.debianPackage = debianPackage;
	}

	public HashMap<String, Vulnerability> getVulnerabilities() {
		return vulnerabilities;
	}

	public boolean isEnabled() {
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
