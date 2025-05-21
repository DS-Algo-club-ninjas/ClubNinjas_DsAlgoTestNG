package dsAlgoTests;
import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.DataProviders;
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
		public void userInDsAlgoPage() {
			registerPageObj = new RegistrationPageObject();
			homePageObj = new HomePageObject();
			loginPageObj = new LoginPageObject();
				
			homePageObj.clickGetStartedBtn();
			Assert.assertEquals(homePageObj.dataStructuresDrpDwnDisplayed(), true);
		}
			
		
		@Test(groups = { "login" },dataProvider = "DataStructureOptionsWithoutSignIn", dataProviderClass = DataProviders.class)
		public void VerifyWarningMsgOnDrpdwnClick(String dataStructures) {
			
			homePageObj.dataStructuresDrpDwnClick();
			
			switch(dataStructures){
				case "Arrays":
				homePageObj.arrayDrpDwnClick();	
					break;
				case "Linked List":
					homePageObj.linkedListDrpDwnClick();
					break;
				case "Stack":
					homePageObj.stackDrpDwnClick();
					break;
				case "Queue":
					homePageObj.queueDrpDwnClick();
					break;
				case "Tree":
					homePageObj.treeDrpDwnClick();
					break;
				case "Graph":
					homePageObj.graphDrpDwnClick();
					 break;
		        default:
		            Assert.fail("Unexpected dropdown option: " + dataStructures);
			}
				
			 String homeText = homePageObj.getHomeLogInMsg();
			    assertEquals("You are not logged in", homeText);
		}
		@Test(groups = { "login" },dataProvider = "DataStructureOptionsWithoutSignIn", dataProviderClass = DataProviders.class)
		public void VerifyWarningMsgOnGetStartedBtnClick(String dataStructures) {
			
			homePageObj.dataStructuresDrpDwnClick();
			
			switch(dataStructures){
			case "Data Structures-Introduction":
				homePageObj.dataStructuresGetStartedBtnClick();	
					break;
				case "Arrays":
				homePageObj.arrayGetStartedBtnClick();	
					break;
				case "Linked List":
					homePageObj.linkedListGetStartedBtnClick();
					break;
				case "Stack":
					homePageObj.stackGetStartedBtnClick();
					break;
				case "Queue":
					homePageObj.queueGetStartedBtnClick();
					break;
				case "Tree":
					homePageObj.treeGetStartedBtnClick();
					break;
				case "Graph":
					homePageObj.graphGetStartedBtnClick();
					 break;
		        default:
		            Assert.fail("Unexpected dropdown option: " + dataStructures);
			}
				
			 String homeText = homePageObj.getHomeLogInMsg();
			 assertEquals("You are not logged in", homeText);
		}
		
		 @Test()
		public void userIsInlaunchPage() {
			homePageObj.randomClickMethod();
			String currentUrl = homePageObj.launchURL();
			String expectedUrl = "https://dsportalapp.herokuapp.com/";
			Assert.assertEquals(currentUrl, expectedUrl);
		}
}
