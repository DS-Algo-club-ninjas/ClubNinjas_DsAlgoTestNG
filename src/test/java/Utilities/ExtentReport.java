package Utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReport {
	public static ExtentSparkReporter spark;
	public static ExtentReports extent;
	public static ExtentTest test;

	public static ExtentReports getReport(){
		
		spark = new ExtentSparkReporter("Extent/ExtentSparkReport.html");
		spark.config().setDocumentTitle("Extent Report");
		spark.config().setReportName("DSAlgo TestNG Extent Report");
		spark.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(spark);
		
		return extent;
	}
}
