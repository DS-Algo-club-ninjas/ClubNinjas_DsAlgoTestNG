package DriverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilities.LoggerLoad;
import Utilities.ConfigFileReader;

public class DriverFactory {
	
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static ConfigFileReader configFileReader = new ConfigFileReader();
	
	public static void createDriver(String browser) {
		switch (browser) {	    
        case "chrome" : 
        	driver.set(new ChromeDriver());
	    	break;
        case "firefox" : 
        	driver.set(new FirefoxDriver());
    		break;
        case "edge" : 
        	driver.set(new EdgeDriver());
    		break;
        default:
            throw new RuntimeException("Unsupported webdriver: " + driver);
        }	
		LoggerLoad.info("Initializing Browser");		
		driver.get().manage().window().maximize();
		driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	public static WebDriver getDriver() {
		return driver.get();
	}

	public static void quitDriver() {
		driver.get().quit();
		driver.remove();
		LoggerLoad.info("Closing Browser");
		
	}

	}
