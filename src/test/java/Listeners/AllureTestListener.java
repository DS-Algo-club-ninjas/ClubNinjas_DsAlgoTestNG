package Listeners;

import org.openqa.selenium.WebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;
import DriverFactory.DriverFactory;
import Utilities.CommonUtil;
import io.qameta.allure.Allure;

public class AllureTestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver();
        byte[] screenshot = CommonUtil.allureScreenshot(driver);
        Allure.getLifecycle().addAttachment("Screenshot on Failure", "image/png", "png", screenshot);
    }

}
