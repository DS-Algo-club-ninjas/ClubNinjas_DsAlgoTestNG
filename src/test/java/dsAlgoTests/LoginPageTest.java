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

}
