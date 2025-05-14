package Utilities;

public class CrossBrowserReader {

private static ThreadLocal<String> tLbrowser = new ThreadLocal();
	
	public static void setBrowserType(String browser) {
		tLbrowser.set(browser);
		LoggerLoad.info("Set the browser value :" +browser);
	}
	
	public static String getBrowserType() {
		LoggerLoad.info("Get the browser" +tLbrowser.get());
		return tLbrowser.get();
		}
	
	}
