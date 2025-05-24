package Hooks;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import DriverFactory.DriverFactory;
import Utilities.ConfigFileReader;
//import Utilities.CrossBrowserReader;
import Utilities.LoggerLoad;


public class Hooks {
	private static WebDriver driver;
	ConfigFileReader configFileReader = new ConfigFileReader();

	@Parameters("browser")
	@BeforeMethod(alwaysRun=true)
	public void setup(String browser) {
		//String browser = ConfigFileReader.getBrowser();//Should comment this line to execute without crossbrowser 
		//String browser = CrossBrowserReader.getBrowserType();//Should Uncomment this line for Crossbrowser testing
		
		LoggerLoad.info("Print the browser in hooks:" +browser);
		if (browser != null) {
			DriverFactory.createDriver(browser);
			DriverFactory.getDriver().get(ConfigFileReader.getDSAlgoURL());
		} 
		else {
			throw new RuntimeException("Browser not defined");
		}
	}
	
	@AfterMethod(alwaysRun=true)
	public static void teardown() throws Throwable {
		driver = DriverFactory.getDriver();
					
		if (driver != null) {
			DriverFactory.quitDriver();
		}
	}

}
