package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import DriverFactory.DriverFactory;

public class RegistrationPageObject {
	
		
	WebDriver driver= DriverFactory.getDriver();
         
        // Locators
        By registerLink = By.linkText("Register");
        By usernameRegTxtBox = By.id("id_username");
        By passwordRegTxtBox = By.id("id_password1");
        By passwordConfirmRegTxtBox = By.id("id_password2");
        By registerButton = By.xpath("//input[@value='Register']");
        By loginLink = By.id("registerBtn");
        By successMessage = By.xpath("//div[contains(text(), 'New Account Created')]");
        By ErrorMessage = By.xpath("//div[@class='alert alert-primary']");
        
    	public boolean registerLinkDisplayed() {
    		return driver.findElement(registerLink).isDisplayed();
    	}
    	
    	public void registerLinkClick() {
    		driver.findElement(registerLink).click();
    	}
    	
    	public boolean registerBtnDisplayed() {
    		return driver.findElement(registerLink).isDisplayed();
    	}
    	
    	public void registerBtnClick() {
    		driver.findElement(registerButton).click();
     	}

    	public void enterUserNameRegTxtBox(String username) {
    		driver.findElement(usernameRegTxtBox).clear();
    		driver.findElement(usernameRegTxtBox).sendKeys(username);
     	}

    	public boolean isUsernameEnteredCorrectly() {
      		
    		WebElement usernameField = driver.findElement(usernameRegTxtBox);
    	    String userNameTxtFieldValue = usernameField.getDomProperty("value");
    	    return userNameTxtFieldValue != null && !userNameTxtFieldValue.trim().isEmpty();

    	}
    	
    	public void enterPasswordRegTxtBox(String password) {
    		driver.findElement(passwordRegTxtBox).clear();
    		driver.findElement(passwordRegTxtBox).sendKeys(password);
     	}
    	
    	public void enterPasswordConfirmRegTxtBox(String ConfirmPassword) {
    		driver.findElement(passwordConfirmRegTxtBox).clear();
    		driver.findElement(passwordConfirmRegTxtBox).sendKeys(ConfirmPassword);
     	}
    	
    	public boolean isPasswordEnteredCorrectly() {
    	    
    		WebElement passwordfield = driver.findElement(passwordRegTxtBox);
    		String passwordfieldTxtFieldValue = passwordfield.getDomProperty("value");
    		return passwordfieldTxtFieldValue != null && !passwordfieldTxtFieldValue.trim().isEmpty();
    	}
    	

    	public String homeSuccessMessageDisplayed() {
    		return driver.findElement(successMessage).getText();
    	}
    	
    	/*
         * Checks the HTML5 validation message shown for the username and password field.
         * @return the browser-generated validation message (e.g., "Please fill out this field.")
         */
        public String getUsernameValidationMessage() {
            WebElement field = driver.findElement(usernameRegTxtBox);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript("return arguments[0].validationMessage;", field);
        }
        
        public String getPasswordValidationMessage() {
            WebElement field = driver.findElement(passwordRegTxtBox);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            return (String) js.executeScript("return arguments[0].validationMessage;", field);
        }


}


