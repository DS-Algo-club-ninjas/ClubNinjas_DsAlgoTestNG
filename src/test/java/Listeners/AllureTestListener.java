package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import DriverFactory.DriverFactory;
import Utilities.ExcelReader;
import io.qameta.allure.Allure;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
       // Object testClass = result.getInstance();
        WebDriver driver = DriverFactory.getDriver();

        byte[] screenshot = ExcelReader.captureScreenshot(driver);
        Allure.getLifecycle().addAttachment("Screenshot on Failure", "image/png", "png", screenshot);
    }

}
