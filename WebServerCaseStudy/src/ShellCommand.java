import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ShellCommand {
	
	public static void executeAndPrintResults(String shellCmd){
		execute(shellCmd, true);
	}
	
	public static String executeAndGetResults(String shellCmd){
		return execute(shellCmd, false);
	}
	
	public static String execute(String shellCmd, boolean print) {
		String results = "";
		if(print) {
			System.out.println("> "+ shellCmd);
		}
		if(ModeSwitcher.getExecutingFlag()) {
			try {
				// from https://www.stackabuse.com/executing-shell-commands-with-java/
				Process process = Runtime.getRuntime().exec(shellCmd);
				results = printResults(process, print);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			results = "> "+ shellCmd;
		}
		return results;
	}
	
	private static String printResults(Process process, boolean print) throws IOException {
	    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
	    String line = "";
	    String text = "";
	    while ((line = reader.readLine()) != null) {
	        if(print) {
	        	System.out.println(line);
	        }else {
	        	text = text + line;
	        }
	    }
		return text;
	}
}
