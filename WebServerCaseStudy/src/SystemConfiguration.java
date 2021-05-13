import java.util.HashMap;
import java.util.List;

public class SystemConfiguration {
	private List<Mode> modes;
	private HashMap<String, Software> software;
	private String debianRelease;
	private String releaseDate;
	
	public SystemConfiguration(List<Mode> modes, HashMap<String, Software>software, String debianRelease, String releaseDate) {
		setModes(modes);
		setSoftware(software);
		setDebianRelease(debianRelease);
		setReleaseDate(releaseDate);
	}

	public List<Mode> getModes() {
		return modes;
	}

	public void setModes(List<Mode> modes) {
		this.modes = modes;
	}

	public HashMap<String, Software> getSoftware() {
		return software;
	}

	public void setSoftware(HashMap<String, Software> software) {
		this.software = software;
	}

	public String getDebianRelease() {
		return debianRelease;
	}

	public void setDebianRelease(String debianRelease) {
		this.debianRelease = debianRelease;
	}

	public String getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}
}