import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.UnknownHostException;

public class FileUtils {
	
	static void createDirectoryIfNotExits(String dirname) {
		File dir = new File(dirname);
		if(!dir.exists()) {
			dir.mkdir();
			System.out.println("Directory " + dirname + " created");
		}
	}

	static void loadFileFromUrl(String urlString, String filename) {
		InputStream input = null;
		OutputStream output = null;
		URL url = null;
		try {
			url = new URL(urlString);
			System.out.println("downloading file: " + url);
			
			HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
			httpConn.addRequestProperty("User-Agent","Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
			
			int responseCode = httpConn.getResponseCode();

			// always check HTTP response code first
			if (responseCode == HttpURLConnection.HTTP_OK) {
				//input = url.openStream();
				input = httpConn.getInputStream();
			    output = new FileOutputStream(filename);
			    byte[] buffer = new byte[1024];
			    for (int length = 0; (length = input.read(buffer)) > 0;) {
			        output.write(buffer, 0, length);
			    }
			}else {
				ModeSwitcher.log("Failure! ResponseCode " + responseCode);
			}
		} catch (UnknownHostException e) {
			ModeSwitcher.log("Failure! Unkown host");
			//e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
		    if (output != null) try { output.close(); } catch (IOException logOrIgnore) {}
		    if (input != null) try { input.close(); } catch (IOException logOrIgnore) {}
		}
	}
	
	static Object loadObjectFromFile(String filename) {
		File f = new File(filename);
		Object object = null;
		if(f.exists()) {
			try {
				 ModeSwitcher.log("Loading file " + filename);
		         FileInputStream fileIn = new FileInputStream(f.getPath());
		         ObjectInputStream in = new ObjectInputStream(fileIn);
		         object = in.readObject();
		         in.close();
		         fileIn.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      } catch (ClassNotFoundException c) {
		         c.printStackTrace();
		      }	
		}
		return object;
	}
	
	static void saveObjectToFile(Object object, String filename) {
		try {
	         FileOutputStream fileOut =
	         new FileOutputStream(filename);
	         ObjectOutputStream out = new ObjectOutputStream(fileOut);
	         out.writeObject(object);
	         out.close();
	         fileOut.close();
	         //ModeSwitcher.log("File " + filename + " serialized");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	static void appendTextToFile(String text, String filename){
		saveTextToFile(text, filename, true);
	}
	
	static void saveTextToFile(String text, String filename, boolean append) {
		try {
			FileWriter  fileOut =
	         new FileWriter(filename, append);
	         BufferedWriter bw = new BufferedWriter(fileOut);
	         bw.write(text);
	         bw.newLine();
	         bw.close();
	         fileOut.close();
	         ModeSwitcher.log("File " + filename + " saved");
	      } catch (IOException i) {
	         i.printStackTrace();
	      }
	}
	
	static String readTextFromFile(String filename) {
		File f = new File(filename);
		StringBuilder text = new StringBuilder();
		String strCurrentLine;
		if(f.exists()) {
			try {
				 ModeSwitcher.log("Loading file " + filename);
		         FileReader in = new FileReader(f.getPath());
		         BufferedReader br = new BufferedReader(in);
		         while ((strCurrentLine = br.readLine()) != null) {
		        	 text.append(strCurrentLine + "\n");
		         }
		         br.close();
		         in.close();
		      } catch (IOException i) {
		         i.printStackTrace();
		      }	
		}
		return text.toString();
	}
	
}
