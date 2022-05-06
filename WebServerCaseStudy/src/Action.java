import java.io.Serializable;

public class Action  implements Serializable{
	private static final long serialVersionUID = 5653478799191846983L;
	private String desc;
	private String shellCmd;
	private String[] params;

	public Action() {
		this("","");
	}
	
	public Action(String desc, String shellCmd) {
		this.desc = desc;
		this.shellCmd = shellCmd;
	}

	public void execute() {
		ShellCommand.executeAndPrintResults(shellCmd + " " + String.join(",", params));
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getShellCmd() {
		return shellCmd;
	}

	public void setShellCmd(String shellCmd) {
		this.shellCmd = shellCmd;
	}
	
	public String[] getParams() {
		return params;
	}

	public void setParams(String[] params) {
		this.params = params;
	}
	
	public Action withParams(String param) {
		return withParams(new String[] {param});
	}
	
	public Action withParams(String[] params) {
		Action a = new Action();
		if(params != null) {
			a.setDesc(this.getDesc());
			a.setShellCmd(this.getShellCmd());
			a.setParams(params);
		}
		return a;
	}
}
