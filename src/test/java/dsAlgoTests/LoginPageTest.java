package dsAlgoTests;

import Utilities.ExcelReader;
import Utilities.LoggerLoad;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.*;

import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegistrationPageObject;


public class LoginPageTest  extends Hooks{
	
	RegistrationPageObject registerPageObj;
	HomePageObject homePageObj;
	LoginPageObject loginPageObj;
	ExcelReader readExcel;
		
	@BeforeMethod
	public void beforeMethod() {
		registerPageObj = new RegistrationPageObject();
		homePageObj = new HomePageObject();
		loginPageObj = new LoginPageObject();
			
		homePageObj.clickGetStartedBtn();
		loginPageObj.clickSignInLink();
	}
	
	 @Test(groups = { "login" },dataProvider = "ValidloginDetails", dataProviderClass = DataProviders.class)
		public void userShouldSignInWithValidLogin(String scenario, Map<String, String> data) {
		 LoggerLoad.info("Launch page is displayed");

       	        // Example usage:
	        String username = data.get("username");
	        String password = data.get("password");

	        // Sanity checks
	        Assert.assertNotNull(username, "Username is missing from data sheet.");
	        Assert.assertNotNull(password, "Password is missing from data sheet.");
		
		loginPageObj.enterUserNameTxtBox(username);
		loginPageObj.enterPasswordRegTxtBox(password);
		loginPageObj.LoginBtnClick();
		
		 // Validate login success
		boolean isSignOutDisplayed = loginPageObj.signOutLinkDisplayed();
		Assert.assertTrue(isSignOutDisplayed, "Sign Out link is not displayed, user may not be on Home page.");
		LoggerLoad.info("Sign Out link is displayed successfully.");
		
		}
	 
	 @Test(groups = { "login" },dataProvider = "ValidloginDetails", dataProviderClass = DataProviders.class)
		public void userClickSignOut(String scenario, Map<String, String> data) {
		 	String loggedOutMessage = "Logged out successfully";
		    String username = data.get("username");
	        String password = data.get("password");
			
			loginPageObj.enterUserNameTxtBox(username);
			loginPageObj.enterPasswordRegTxtBox(password);
			loginPageObj.LoginBtnClick();
			
		 loginPageObj.clickSignOutLink();
		 String actualMessage = loginPageObj.LoggedMessageSignOut();
		Assert.assertEquals(actualMessage, loggedOutMessage,
					"User was not redirected to home page with the correct logout message.");
		}
	 	 
	 @Test()
		public void userSignedIntoDsAlgo() {
		 LoggerLoad.info("Login button is displayed");
		 String message = "Please fill out this field.";
		 loginPageObj.LoginBtnClick();
		 String actualMessage = loginPageObj.getPopUpMessage();
			Assert.assertEquals(actualMessage, message,
					"The error message below Username and Password textbox does not match the expected one.");
		    			
		}
	 
		 @Test(dataProvider = "inValidloginDetails", dataProviderClass = DataProviders.class)
		public void userEntersInvalidLogin(String scenario, Map<String, String> data) {
			 System.out.println("Print data" +data);
		 String errorMessage = "Invalid Username and Password";
		 System.out.println("Invalid Error:" +errorMessage);
		 String username = data.get("UserName");
	     String password = data.get("Password");
			
			loginPageObj.enterUserNameTxtBox(username);
			loginPageObj.enterPasswordRegTxtBox(password);
			
			loginPageObj.LoginBtnClick();
			String actualMessage = loginPageObj.invalidUserNameAndPassword();
			Assert.assertEquals(actualMessage, errorMessage,
					"The error message displayed does not match the expected error message.");
		}

}
