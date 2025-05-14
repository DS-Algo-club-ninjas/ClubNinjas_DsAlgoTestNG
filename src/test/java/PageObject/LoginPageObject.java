package PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverFactory;

public class LoginPageObject {
	
	WebDriver driver= DriverFactory.getDriver();
      
        // Locators
        By signInLink = By.xpath("//a[text()='Sign in']");
        By userNameTxtBox = By.name("username");
        By passwordTxtBox = By.id("id_password");
        By loginBtn = By.xpath("//input[@value='Login']");
        By regLinkbelowLogin = By.xpath("//a[text() ='Register!]");
        By notLoggedInMessage = By.xpath("//div[@class = 'alert alert-primary' and contains(text(),'You are not logged in')]");
        By loggedOutMessage = By.xpath("//div[contains(text(),'Logged out successfully')]");
        By invalidMessage = By.xpath("//div[contains(text(),'Invalid')]");
        By signOutLink = By.xpath("//a[text()='Sign out']");
        
    	public boolean signInLinkDisplayed() {
    		return driver.findElement(signInLink).isDisplayed();
    	}

    	public void LoginBtnClick() {
    		driver.findElement(loginBtn).click();
    	}

    	public void clickSignInLink() {
    		driver.findElement(signInLink).click();
    	}

    	public void clickSignOutLink() {
    		driver.findElement(signOutLink).click();
    	}

    	public boolean signOutLinkDisplayed() {
    		return driver.findElement(signOutLink).isDisplayed();
    	}
    	
    	public void enterUserNameTxtBox(String username) {
    		driver.findElement(userNameTxtBox).clear();
    		driver.findElement(userNameTxtBox).sendKeys(username);
     	}
    	
    	public void enterPasswordRegTxtBox(String password) {
    		driver.findElement(passwordTxtBox).clear();
    		driver.findElement(passwordTxtBox).sendKeys(password);
     	}

    	public String getNotLoggedInMessageText() {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		
    		// wait until element is visible
    		wait.until(ExpectedConditions.visibilityOfElementLocated(notLoggedInMessage));
    		return driver.findElement(notLoggedInMessage).getText();
    		
    	}

    	public String LoggedMessageSignOut() {
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		
    		// wait until element is visible
    		wait.until(ExpectedConditions.visibilityOfElementLocated(loggedOutMessage));
    		return driver.findElement(loggedOutMessage).getText();
    		}

    	public String invalidUserNameAndPassword() {
    		
    		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    		
    		// wait until element is visible
    		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidMessage));
    		return driver.findElement(invalidMessage).getText();
    		 }
        
        public String getPopUpMessage() {
            WebElement activeElement = driver.switchTo().activeElement();
            if (activeElement != null) {
                return activeElement.getDomProperty("validationMessage").trim();
            }
            return null;
        }

}


