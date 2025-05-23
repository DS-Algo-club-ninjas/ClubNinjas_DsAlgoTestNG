
	
	package dsAlgoTests;

	import java.util.List;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import DataProvider.DataProviders;
	import Hooks.Hooks;
	import PageObject.HomePageObject;
	import PageObject.LoginPageObject;
	import PageObject.StackPageObject;
	import Utilities.ExcelReader;
	import Utilities.LoggerLoad;

		public class StackPageTest  extends Hooks {
			
			
			HomePageObject homePageObj;
			LoginPageObject loginPageObj;
			ExcelReader readExcel;
			StackPageObject stackpageObj; 
			
			@BeforeMethod
			public void userInHomePage() {
				stackpageObj = new StackPageObject();
				validLogin();
			}
			
			public void validLogin() {
				homePageObj = new HomePageObject();
				loginPageObj = new LoginPageObject();
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
			
			@Test(priority=1)
			public void userInGetStartedStackPage() {
				stackpageObj.click_getstartedstack();
				String expPageTitle = "Stack";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(expPageTitle,actPageTitle);
			}
			
			@Test(priority=2)
			public void userInDropDownStackPage() {
				stackpageObj.click_dropdowndatastuctr();
			    stackpageObj.click_dropdownstack();
			    String expPageTitle = "Stack";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(expPageTitle,actPageTitle);
			}
			
			@Test(priority=3)
			public void userInOperationsInStack() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_OperationsInStack();
				String expPageTitle = "Operations in Stack";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=4)
			public void userInTryEditorOperationsInStack() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_OperationsInStack();
				stackpageObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=5)
			public void inValidCodeTryEditorOperationsInStack(String code, String error) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_OperationsInStack();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_runbttn();
			    String alertMsg = stackpageObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=6)
			public void validCodeTryEditorOperationsInStack(String code, String output) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_OperationsInStack();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_runbttn();
			    String actOutput = stackpageObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=7)
			public void practiseQtnsOperationsInStack() {
				stackpageObj.click_getstartedstack();
				stackpageObj.click_OperationsInStack();
				stackpageObj.click_PracticeQuestions();
				boolean page = stackpageObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
			@Test(priority=8)
			public void userInImplementation() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_Implementation();
				String expPageTitle = "Implementation";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=9)
			public void userInTryEditorImplementation() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_Implementation();
				stackpageObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=10)
			public void inValidCodeTryEditorImplementation(String code, String error) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_Implementation();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_tryHere_btn();
			    String alertMsg = stackpageObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=11)
			public void validCodeTryEditor(String code, String output) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_Implementation();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_tryHere_btn();
			    String actOutput = stackpageObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=12)
			public void practiseQtnsImplementation() {
				stackpageObj.click_getstartedstack();
				stackpageObj.click_Implementation();
				stackpageObj.click_PracticeQuestions();
				boolean page = stackpageObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
			@Test(priority=13)
			public void userInApplications() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_applicatio();
				String expPageTitle = "Applications";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=14)
			public void userInTryEditorApplications() {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_applicatio();
				stackpageObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = stackpageObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=15)
			public void inValidCodeTryEditorApplications(String code, String error) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_applicatio();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_tryHere_btn();
			    String alertMsg = stackpageObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=16)
			public void validCodeTryEditorApplications(String code, String output) {
				stackpageObj.click_getstartedstack();
			    stackpageObj.click_applicatio();
				stackpageObj.click_tryHere_btn();
				stackpageObj.enterCodeTryEditor(code);
			    stackpageObj.click_tryHere_btn();
			    String actOutput = stackpageObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=17)
			public void practiseQtnsApplications() {
				stackpageObj.click_getstartedstack();
				stackpageObj.click_applicatio();
				stackpageObj.click_PracticeQuestions();
				boolean page = stackpageObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
		}
	

