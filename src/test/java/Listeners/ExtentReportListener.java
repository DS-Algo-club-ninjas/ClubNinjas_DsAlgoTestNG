package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.IRetryAnalyzer;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import DriverFactory.DriverFactory;
import Utilities.CommonUtil;
import Utilities.ExtentReport;

public class ExtentReportListener implements ITestListener {

	private static ExtentReports extent = ExtentReport.getReport();
	private static ThreadLocal<ExtentTest> test = new ThreadLocal<>();

	@Override
	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
			test.set(extentTest);
			test.get().pass("Test passed");
		}
	}

	@Override
	public void onTestFailure(ITestResult result) {
		ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
		test.set(extentTest);
		test.get().fail(result.getThrowable());

		// Take screenshot if WebDriver is available
		//Object currentClass = result.getInstance();
		WebDriver driver= DriverFactory.getDriver();
		if (driver != null) {
			String screenshotPath = CommonUtil.extentScreenShot(driver, result.getMethod().getMethodName());
			test.get().addScreenCaptureFromPath(screenshotPath,"Failure Screenshot");
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		IRetryAnalyzer retryAnalyzer = result.getMethod().getRetryAnalyzer(result);
		if (retryAnalyzer instanceof dsAlgoRetryAnalyzer) {
			int maxRetry = ((dsAlgoRetryAnalyzer) retryAnalyzer).getRetryCount();
			int currentTry = result.getMethod().getCurrentInvocationCount();
			if (currentTry % (maxRetry+1) != 0) {
				return;
			}
		}
		
		if (result.getStatus() == ITestResult.SKIP) {
			ExtentTest extentTest = extent.createTest(result.getMethod().getMethodName());
			test.set(extentTest);
			test.get().skip(result.getThrowable());
		}
	}

	@Override
	public void onFinish(ITestContext context) {
		extent.flush();
	}

}
