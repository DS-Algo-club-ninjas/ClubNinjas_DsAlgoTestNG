package dsAlgoTests;

import java.util.Map;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegistrationPageObject;
import Utilities.ExcelReader;

public class RegisterPageTest extends Hooks{
	RegistrationPageObject registerPageObj;
	HomePageObject homePageObj;
	LoginPageObject loginPageObj;
	ExcelReader readExcel;
	
	@BeforeMethod
	public void userInDsAlgoPage() {
		registerPageObj = new RegistrationPageObject();
		homePageObj = new HomePageObject();
		loginPageObj = new LoginPageObject();
					
		homePageObj.clickGetStartedBtn();
		registerPageObj.registerLinkClick();
	}
	
	 @Test(groups = { "Register" },priority=1, dataProvider = "RegistrationDetails", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void invalidUserNameReg(String username, String password, String confirmPassword, String expected, String Actual) {
		
	       Assert.assertNotNull(username, "Username is missing for scenario: " + username);
	        
		 registerPageObj.enterUserNameRegTxtBox(username);
		 Assert.assertTrue(registerPageObj.isUsernameEnteredCorrectly(), "Username was not entered correctly :"  + username);
	 }
	 
	 @Test(groups = { "Register" }, priority=2, dataProvider = "RegistrationDetails", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void invalidUserNameRegDetails(String username, String password, String confirmPassword, String expected, String Actual) {
     
		 registerPageObj.enterUserNameRegTxtBox(username);
		 registerPageObj.enterPasswordRegTxtBox(password);
		 registerPageObj.enterPasswordConfirmRegTxtBox(confirmPassword);
		 registerPageObj.registerBtnClick();

			String validationMessage = registerPageObj.getUsernameValidationMessage();
			Assert.assertNotNull(validationMessage, "Error message for username is not displayed");
			}
	 
	 @Test(groups = { "Register" },priority=3, dataProvider = "RegistrationDetails", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void invalidPswdDetails(String username, String password, String confirmPassword, String expected, String Actual) {
				 
		 registerPageObj.enterPasswordRegTxtBox(password);
		 registerPageObj.registerBtnClick();

		 Assert.assertTrue(registerPageObj.isPasswordEnteredCorrectly(), "Password was not entered correctly");
			}
	 
	 @Test(groups = { "Register" }, priority=4, dataProvider = "RegistrationDetails", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void invalidPswdWithBlankDetails(String username, String password, String confirmPassword, String expected, String Actual) {
			      
		 registerPageObj.enterUserNameRegTxtBox(username);
		 registerPageObj.enterPasswordRegTxtBox(password);
		 registerPageObj.enterPasswordConfirmRegTxtBox(confirmPassword);
		 registerPageObj.registerBtnClick();
		 String validationMessage = registerPageObj.getPasswordValidationMessage();
			try {
			Assert.assertNotNull(validationMessage, "Error message for password is not displayed");
			
			}
			catch(NoSuchElementException e){
				//defect to raise in jira
				Assert.fail("Password fields are accpeting commenly used words");
				
			}
	 }		
	 @Test(groups = { "Register" },priority=5, dataProvider = "RegistrationDetails", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void validUserDetails(String username, String password, String confirmPassword, String expected, String Actual) {
			        
		 registerPageObj.enterUserNameRegTxtBox(username);
		 registerPageObj.enterPasswordRegTxtBox(password);
		 registerPageObj.enterPasswordConfirmRegTxtBox(confirmPassword);
		 registerPageObj.registerBtnClick();
		 
		 String actualmessage = loginPageObj.getPopUpMessage();
		 Assert.assertNotNull(actualmessage, "Error message popup is not displayed");
		 	 
}

}
