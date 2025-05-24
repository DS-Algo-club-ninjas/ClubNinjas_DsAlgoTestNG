package Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverFactory;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;

public class CommonUtil {

	private static WebDriver driver = DriverFactory.getDriver();;
    private static WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

    public static WebElement waitForVisibility(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
    
	public static void validLogin() {
		HomePageObject homePageObj = new HomePageObject();
		LoginPageObject loginPageObj = new LoginPageObject();
		homePageObj.clickGetStartedBtn();
		loginPageObj.clickSignInLink();
		ExcelReader excel;
		try {
			excel = new ExcelReader("valid_Login");
			List<Object[]> data = excel.getDataByScenario("validLoginId");
			Object[] row = data.get(0);
			String username = (String) row[0];
			String password = (String) row[1];
			loginPageObj.enterUserNameTxtBox(username);
			loginPageObj.enterPasswordRegTxtBox(password);
			loginPageObj.LoginBtnClick();
		} catch (Exception e) {
			LoggerLoad.error("Exception occured in reading data from Excel");
		}
	}

	public static byte[] allureScreenshot(WebDriver driver) {
		driver = DriverFactory.getDriver();
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
	
	public static String extentScreenShot(WebDriver driver, String screenshotName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = "test-output/screenshots/" + screenshotName + ".png";
        try {
            Files.createDirectories(Paths.get("test-output/screenshots/"));
            Files.copy(src.toPath(), Paths.get(path), StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return path;
    }

}
