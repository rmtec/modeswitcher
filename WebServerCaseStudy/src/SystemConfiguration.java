import java.util.HashMap;
import java.util.List;

public class SystemConfiguration {
	private List<Mode> modes;
	private HashMap<String, Software> software;
	
	public SystemConfiguration(List<Mode> modes, List<Software> swList) {
		software = new HashMap<String, Software>();
		setModes(modes);
		setSoftware(swList);
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
	
	public void setSoftware(List<Software> swList) {
		for(Software sw : swList) {
			putSoftware(sw);
		}
	}
	
	public void putSoftware(Software sw) {
		if(sw == null) {
			System.out.println("Cannot add software null");
		}else {
			software.put(sw.getCpe(), sw);
		}
	}
	
	
}