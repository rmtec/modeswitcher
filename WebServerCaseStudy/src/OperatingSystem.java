import java.time.LocalDate;
import java.util.HashMap;

public interface OperatingSystem {
	
	public String getRelease();
	
	public void setRelease(String release);
	
	public LocalDate getReleaseDate();
	
	public String getCpeForPackage(String packageName);
	
	public String getSoftwareVersion(String software);
	
	public void refreshPatches(VulnerabilityManager vm);
	
	public HashMap<String, Action> getDefaultActions();
}
