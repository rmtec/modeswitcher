import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Action {
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
		if(ModeSwitcher.getExecutingFlag()) {
			try {
				// from https://www.stackabuse.com/executing-shell-commands-with-java/
				Process process = Runtime.getRuntime().exec(shellCmd + " " + String.join(",", params));
				printResults(process);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("> "+ shellCmd + " " + String.join(",", params));
		}
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
	
	private static void printResults(Process process) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	    String line = "";
	    while ((line = reader.readLine()) != null) {
	        System.out.println(line);
	    }
	}

}
