import java.io.Serializable;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Mode  implements Serializable{
	private static final long serialVersionUID = -3657746991055083978L;
	private String name;
	private String desc;
	private boolean enabled;
	private List<Service> startServices;
	private List<Service> stopServices;
	private int priority;
	private int startCounter; //count the number of starts
	private int counter; //counts the number of calculated next mode
	private List<Mode> alternativeModes; //used for shuffle modes (moving target defense)
	
	public Mode(String name, String desc, int priority, Service startService, Service stopService) {
		this(name, desc,priority,Arrays.asList(startService),Arrays.asList(stopService));
	}
	
	public Mode(String name, String desc, int priority, List<Service> startServices, List<Service> stopServices) {
		this.setName(name);
		this.setDesc(desc);
		this.setPriority(priority);
		this.setStartServices(startServices);
		this.setStopServices(stopServices);
		this.setEnabled(true);
		counter = 0;
		startCounter = 0;
	}

	public void start() {
		start(startServices);
	}
	
	public void stop() {
		stop(startServices);
	}
	
	/**
	 * Partial stop: some services should remain
	 * @param stopServices
	 */
	public void stop(List<Service> stopServices) {
		for (Service service : stopServices) {
			service.stop();
		}
	}
	
	/**
	 * Partial start: some services are already running
	 * @param startServices
	 */
	public void start(List<Service> startServices) {
		for (Service service : startServices) {
			service.start();
		}
		startCounter++;
	}
	
	public int getNoOfActiveVulnerabilities() {
		return startServices.stream().mapToInt(Service::getNoOfActiveVulnerabilities).sum();
	}
	
	public int getNoOfVulnerabilities() {
		int count=0;
		for (Service service : startServices) {
			count += service.getNoOfVulnerabilities();
		}
		return count;
	}
	
	public double getActiveTotalScore() {
		if ( startServices.isEmpty()) {
			return 0.0;
		}else {
			return startServices.stream().mapToDouble(Service::getActiveTotalScore).sum();
		}
	}
	
	public double getTotalScore() {
		double total=0.0;
		for (Service service : startServices) {
			total += service.getTotalScore();
		}
		return total;
	}
	
	public double getActiveAvgScore() {
		int noOfVulnerabilities = this.getNoOfActiveVulnerabilities();
		double scoreAvg = 0.0;
		if (noOfVulnerabilities > 0) {
			scoreAvg = this.getActiveTotalScore()/noOfVulnerabilities;
		}
		return scoreAvg;
	}
	
	public double getAvgScore() {
		int noOfVulnerabilities = this.getNoOfVulnerabilities();
		double scoreAvg = 0.0;
		if (noOfVulnerabilities > 0) {
			scoreAvg = this.getTotalScore()/noOfVulnerabilities;
		}
		return scoreAvg;
	}
	
	private void setName(String name) {
		this.name = name;		
	}
	
	public String getName() {
		return name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public boolean isEnabled() {
		boolean enabled = this.enabled;
		for (Service service : startServices) {
			enabled = enabled && service.isEnabled();
		}
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	public void disable() {
		this.setEnabled(false);
	}
	
	public List<Service> getStartServices() {
		return startServices;
	}

	public void setStartServices(List<Service> startServices) {
		this.startServices = startServices;
	}

	public List<Service> getStopServices() {
		return stopServices;
	}

	public void setStopServices(List<Service> stopServices) {
		this.stopServices = stopServices;
	}
	
	public List<Mode> getAlternativeModes() {
		return alternativeModes;
	}
	
	public void setAlternativeModes(List<Mode> alternativeModes) {
		this.alternativeModes = alternativeModes;
	}
	
	public String toString() {
		return name;
	}

	public int getCounter() {
		return counter;
	}

	public int getStartCounter() {
		return startCounter;
	}

	public void increaseCounter() {
		counter++;		
	}
	
	@Override
	public boolean equals(Object o) {
	    // self check
	    if (this == o)
	        return true;
	    // null check
	    if (o == null)
	        return false;
	    // type check and cast
	    if (getClass() != o.getClass())
	        return false;
	    Mode mode = (Mode) o;
	    // field comparison
	    return Objects.equals(getName(), mode.getName());
	}


}
