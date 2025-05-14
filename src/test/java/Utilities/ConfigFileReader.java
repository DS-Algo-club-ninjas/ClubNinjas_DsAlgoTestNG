package Utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import DriverFactory.DriverFactory;

public class ConfigFileReader {
	
private static Properties properties;
	
	public ConfigFileReader()  {
		Properties properties = new Properties();
		try {
			
		FileReader reader = new FileReader("src/test/resources/ConfigFIle/config.properties");
			try {
				properties.load(reader);
			}
			catch (IOException e){
				e.printStackTrace();
			}
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		this.properties = properties;
	}
	
	public static String getDSAlgoURL() {
		String url = properties.getProperty("url");
		if (url != null) {
			return url;
		} else {
			throw new RuntimeException("URL not specified in the Configuration property file.");
		}
	}
	
	public static String getBrowser() {
		String browser = properties.getProperty("browser");
		if (browser != null) {
			return browser;
		} else {
			throw new RuntimeException("Browser not specified in the Configuration property file.");
		}
	}
	
	public static String browserfromconfigfile() throws IOException {

		properties.load(DriverFactory.class.getClassLoader().getResourceAsStream("config.properties"));
		String browserType = properties.getProperty("browser");
		System.out.println("Print Browser value from config file:" +browserType);
		return browserType;
	}


}
