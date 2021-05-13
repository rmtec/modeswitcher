import java.util.Arrays;
import java.util.List;

public class Mode {
	private String desc;
	private boolean enabled;
	private List<Service> startServices;
	private List<Service> stopServices;
	private int priority;
	private int startCounter; //count the number of starts
	private int counter; //counts the number of calculated next mode
	
	public Mode(String desc, int priority, Service startService, Service stopService) {
		this(desc,priority,Arrays.asList(startService),Arrays.asList(stopService));
	}
	
	public Mode(String desc, int priority, List<Service> startServices, List<Service> stopServices) {
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
		return startServices.stream().mapToDouble(Service::getActiveTotalScore).sum();
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
	
	public String toString() {
		return desc;
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

}
