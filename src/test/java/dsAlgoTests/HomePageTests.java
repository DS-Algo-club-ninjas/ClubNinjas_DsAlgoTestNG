package dsAlgoTests;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;

import Hooks.Hooks;

import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.RegistrationPageObject;
import Utilities.ExcelReader;

public class HomePageTests extends Hooks {
	
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
		
		
		public void userShouldNavigatetoHomepage() {
		    Assert.assertEquals(homePageObj.dataStructuresDrpDwnDisplayed(), true);
		   }
		
		public void userClicksOnDataStructuresDropdown() {
		    homePageObj.dataStructuresDrpDwnClick();
		}
		public void userClicksArrayDropdownWithoutSignIn() {
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.arrayDrpDwnClick();
			 String homeText = homePageObj.getHomeLogInMsg();
			    assertEquals("You are not logged in", homeText);
		   }
		
		public void userClicksAllDropdownsWithoutSignIn() {
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.linkedListDrpDwnClick();
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.stackDrpDwnClick();
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.queueDrpDwnClick();
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.treeDrpDwnClick();
			homePageObj.dataStructuresDrpDwnClick();
			homePageObj.graphDrpDwnClick();
			homePageObj.arrayDrpDwnClick();
			 String homeText = homePageObj.getHomeLogInMsg();
			    assertEquals("You are not logged in", homeText);
		}
		
		public void userIsInHomePage() {
			homePageObj.randomClickMethod();
			String currentUrl = homePageObj.launchURL();
			String expectedUrl = "https://dsportalapp.herokuapp.com/home";
			Assert.assertEquals(currentUrl, expectedUrl);
		}
}
