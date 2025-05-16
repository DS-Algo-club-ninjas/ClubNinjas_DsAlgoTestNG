package dsAlgoTests;

import Utilities.ExcelReader;
import Utilities.LoggerLoad;

import org.testng.Assert;
import org.testng.annotations.*;

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
		readExcel = new ExcelReader();
	
		homePageObj.clickGetStartedBtn();
		loginPageObj.clickSignInLink();
	}
	
	 @Test(groups = { "login" })
	public void userShouldSignInWithValidLogin() {
		LoggerLoad.info("Launch page is displayed");
		String sheetName = "valid_Login";
		int rowNumber = 1 ;
		
		String[] credentials = readExcel.excelDataRead(sheetName, rowNumber);
		loginPageObj.enterUserNameTxtBox(credentials[0]);
		loginPageObj.enterPasswordRegTxtBox(credentials[1]);
		loginPageObj.LoginBtnClick();
		boolean isSignOutDisplayed = loginPageObj.signOutLinkDisplayed();
		Assert.assertTrue(isSignOutDisplayed, "Sign Out link is not displayed, user may not be on Home page.");
		LoggerLoad.info("Sign Out link is displayed successfully.");
		
		}
	 @DataProvider (name = "LoggedOutMessage")
		public Object[][] dpMethod(){
			return new Object[][] {{"Logged out successfully"}};
		}
	  @Test (dataProvider = "LoggedOutMessage" )
		public void userClickSignOut(String loggedOutMessage) {
		  String sheetName = "valid_Login";
			int rowNumber = 1 ;
			
			String[] credentials = readExcel.excelDataRead(sheetName, rowNumber);
			loginPageObj.enterUserNameTxtBox(credentials[0]);
			loginPageObj.enterPasswordRegTxtBox(credentials[1]);
			loginPageObj.LoginBtnClick();
			
		 loginPageObj.clickSignOutLink();
		 String actualMessage = loginPageObj.LoggedMessageSignOut();
			Assert.assertEquals(actualMessage, loggedOutMessage,
					"User was not redirected to home page with the correct logout message.");
		}
	 
	  @DataProvider (name = "errorMessageForBlankField")
		public Object[][] dpMethod1(){
			return new Object[][] {{"Please fill out this field."}};
		}
	 @Test(dataProvider = "errorMessageForBlankField")
		public void userSignedIntoDsAlgo(String message) {
		 LoggerLoad.info("Login button is displayed");
		 loginPageObj.LoginBtnClick();
		 String actualMessage = loginPageObj.getPopUpMessage();
			Assert.assertEquals(actualMessage, message,
					"The error message below Username and Password textbox does not match the expected one.");
		    			
		}
	 
	 @DataProvider (name = "errorMessageForLogin")
		public Object[][] dpMethod2(){
			return new Object[][] {{"Invalid Username and Password"}};
		}
	 @Test(dataProvider = "errorMessageForLogin")
		public void userEntersInvalidLogin(String errorMessage) {
		 System.out.println("Invalid Error:" +errorMessage);
		 String sheetName = "Login";
			int rowNumber = 3 ;
		 String[] credentials = readExcel.excelDataRead(sheetName, rowNumber);
			loginPageObj.enterUserNameTxtBox(credentials[0]);
			loginPageObj.enterPasswordRegTxtBox(credentials[1]);
			loginPageObj.LoginBtnClick();
			String actualMessage = loginPageObj.invalidUserNameAndPassword();
			Assert.assertEquals(actualMessage, errorMessage,
					"The error message displayed does not match the expected error message.");
		}

}
