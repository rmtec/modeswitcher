import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Service implements Serializable{
	private static final long serialVersionUID = 8018334957457489102L;
	private String desc;
	private boolean enabled;
	private List<Action> startActions;
	private List<Action> stopActions;
	private List<Software> usedSoftware;
	
	public Service(String desc, Action startAction, Action stopAction) {
		this(desc,Arrays.asList(startAction),Arrays.asList(stopAction));
	}
	
	public Service(String desc, Software sw, Action startAction, Action stopAction) {
		this(desc,Arrays.asList(sw), Arrays.asList(startAction),Arrays.asList(stopAction));
	}
	
	public Service(String desc, List<Action> startActions, List<Action> stopActions) {
		this(desc,null, startActions,stopActions);
	}
	
	public Service(String desc, List<Software> usedSoftware, List<Action> startActions, List<Action> stopActions) {
		this.desc = "";
		this.setEnabled(true);
		this.startActions = new ArrayList<Action>();
		this.stopActions = new ArrayList<Action>();
		this.usedSoftware = new ArrayList<Software>();
		setDesc(desc);
		setStartActions(startActions);
		setStopActions(stopActions);
		setSoftware(usedSoftware);
	}

	public void start() {
		this.executeActions(startActions);
	}
	
	public void stop() {
		this.executeActions(stopActions);
	}
	
	private void executeActions(List<Action> actions) {
		for (Action action : actions) {
			action.execute();
		}
	}
	
	public int getNoOfActiveVulnerabilities() {
		return usedSoftware.stream().mapToInt(Software::getNoOfActiveVulnerabilties).sum();
	}
	
	public int getNoOfVulnerabilities() {
		int count=0;
		for (Software software : usedSoftware) {
			count += software.getNoOfVulnerabilities();
		}
		return count;
	}
	
	public double getActiveTotalScore() {
		if ( usedSoftware.isEmpty()) {
			return 0.0;
		}else {
			return usedSoftware.stream().mapToDouble(Software::getActiveScoreSum).sum();
		}
	}
	
	public double getTotalScore() {
		double total=0;
		for (Software software : usedSoftware) {
			total += software.getScoreSum();
		}
		return total;
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
		if(desc != null && desc != "") this.desc = desc;
	}

	public boolean isEnabled() {
		boolean enabled = this.enabled;
		for (Software sw : usedSoftware) {
			enabled = enabled && sw.isEnabled();
		}
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Action> getStartActions() {
		return startActions;
	}

	public void setStartActions(List<Action> startActions) {
		if(startActions != null) this.startActions = startActions;
	}

	public List<Action> getStopActions() {
		return stopActions;
	}

	public void setStopActions(List<Action> stopActions) {
		if(stopActions != null) this.stopActions = stopActions;
	}

	public List<Software> getSoftware() {
		return usedSoftware;
	}

	public void setSoftware(List<Software> software) {
		if(software != null) this.usedSoftware = software;
	}
	
	public void addSoftware(Software software) {
		this.usedSoftware.add(software);
	}
	
	public void addSoftware(List<Software> software) {
		this.usedSoftware.addAll(software);
	}

	public void disable() {
		this.setEnabled(false);
	}
	
	public String toString() {
		return desc;
	}
}
