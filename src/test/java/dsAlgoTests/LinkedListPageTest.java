	
    package dsAlgoTests;

	import java.util.List;
	import org.testng.Assert;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.Test;
	import DataProvider.DataProviders;
	import Hooks.Hooks;
	import PageObject.HomePageObject;
    import PageObject.LinkeListPageObject;
    import PageObject.LoginPageObject;
	import Utilities.ExcelReader;
	import Utilities.LoggerLoad;

		public class LinkedListPageTest  extends Hooks {
			
			
			HomePageObject homePageObj;
			LoginPageObject loginPageObj;
			ExcelReader readExcel;
			LinkeListPageObject linkedlistObj; 
			
			@BeforeMethod
			public void userInHomePage() {
				linkedlistObj = new LinkeListPageObject();
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
			public void userInGetLinkedlistPage() {
				linkedlistObj.click_linkdlistGetStarted();
				String expPageTitle = "Linked List";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(expPageTitle,actPageTitle);
			}
			
			@Test(priority=2)
			public void userInDropDownLinkdLstPage() {
				linkedlistObj.click_dataStructutrDropDown();
				linkedlistObj.click_linkedlistDropDown();
			    String expPageTitle = "Linked List";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(expPageTitle,actPageTitle);
			}
			
			@Test(priority=3)
			public void userInIntroduction() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_introduction();
				String expPageTitle = "Introduction";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=4)
			public void userInTryEditorInIntroduction() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_introduction();
				linkedlistObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=5)
			public void inValidCodeTryEditorOperationsInStack(String code, String error) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_introduction();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_runbttn();
			    String alertMsg = linkedlistObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=6)
			public void validCodeTryEditorOperationsInStack(String code, String output) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_introduction();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_runbttn();
			    String actOutput = linkedlistObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=7)
			public void practiseQtnsIntroduction() {
				linkedlistObj.click_linkdlistGetStarted();
				linkedlistObj.click_introduction();
				linkedlistObj.click_practicequestns_link();
				boolean page = linkedlistObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
			@Test(priority=8)
			public void userInCreatinglinkdlst() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_creatinglinkedlist();
				String expPageTitle = "Creating Linked LIst";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=9)
			public void userInTryEditorCreatinglinkdlst() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_creatinglinkedlist();
				linkedlistObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=10)
			public void inValidCodeTryEditorImplementation(String code, String error) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_creatinglinkedlist();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_tryHere_btn();
			    String alertMsg = linkedlistObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=11)
			public void validCodeTryEditor(String code, String output) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_creatinglinkedlist();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_tryHere_btn();
			    String actOutput = linkedlistObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=12)
			public void practiseQtnsCreatinglinkdlst() {
				linkedlistObj.click_linkdlistGetStarted();
				linkedlistObj.click_creatinglinkedlist();
				linkedlistObj.click_practicequestns_link();
				boolean page = linkedlistObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
			@Test(priority=13)
			public void userInImplmntLnkdLstInPython() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_impmntlinkdlstpython();
				String expPageTitle = "Implement Linked List in Python";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(priority=14)
			public void userInTryEditorImplmntLinkdLstInPython() {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_impmntlinkdlstpython();
				linkedlistObj.click_tryHere_btn();
				String expPageTitle = "Assessment";
				String actPageTitle = linkedlistObj.get_currentPageTitle();
				Assert.assertEquals(actPageTitle,expPageTitle);
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=15)
			public void inValidCodeTryEditorImplmntLinkdLstInPython(String code, String error) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_impmntlinkdlstpython();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_tryHere_btn();
			    String alertMsg = linkedlistObj.acceptAlert();
			    Assert.assertTrue(alertMsg.contains(error));
			}
			
			@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=16)
			public void validCodeTryEditorImplmntLinkdLstInPython(String code, String output) {
				linkedlistObj.click_linkdlistGetStarted();
			    linkedlistObj.click_impmntlinkdlstpython();
				linkedlistObj.click_tryHere_btn();
				linkedlistObj.enterCodeTryEditor(code);
			    linkedlistObj.click_tryHere_btn();
			    String actOutput = linkedlistObj.get_tryHereEditor_output();
			    Assert.assertEquals(actOutput,output);
			}
			
			@Test(priority=17)
			public void practiseQtnsImplmntLinkdLstInPython() {
				linkedlistObj.click_linkdlistGetStarted();
				linkedlistObj.click_impmntlinkdlstpython();
				linkedlistObj.click_practicequestns_link();
				boolean page = linkedlistObj.check_practiecQtns_avail();
				Assert.assertTrue(page, "No Practise Questions found");
			}
			
		
			@Test(priority=18)
		public void userInInsertion() {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_insertion();
			String expPageTitle = "Insertion";
			String actPageTitle = linkedlistObj.get_currentPageTitle();
			Assert.assertEquals(actPageTitle,expPageTitle);
		}
		
		@Test(priority=19)
		public void userInTryEditorInsertion() {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_traversal();
			linkedlistObj.click_tryHere_btn();
			String expPageTitle = "Assessment";
			String actPageTitle = linkedlistObj.get_currentPageTitle();
			Assert.assertEquals(actPageTitle,expPageTitle);
		}
		
		@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=20)
		public void inValidCodeTryEditorInsertion(String code, String error) {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_insertion();
			linkedlistObj.click_tryHere_btn();
			linkedlistObj.enterCodeTryEditor(code);
		    linkedlistObj.click_tryHere_btn();
		    String alertMsg = linkedlistObj.acceptAlert();
		    Assert.assertTrue(alertMsg.contains(error));
		}
		
		@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=21)
		public void validCodeTryEditorInsertion(String code, String output) {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_insertion();
			linkedlistObj.click_tryHere_btn();
			linkedlistObj.enterCodeTryEditor(code);
		    linkedlistObj.click_tryHere_btn();
		    String actOutput = linkedlistObj.get_tryHereEditor_output();
		    Assert.assertEquals(actOutput,output);
		}
		
		@Test(priority=22)
		public void practiseQtnsInsertion() {
			linkedlistObj.click_linkdlistGetStarted();
			linkedlistObj.click_insertion();
			linkedlistObj.click_practicequestns_link();
			boolean page = linkedlistObj.check_practiecQtns_avail();
			Assert.assertTrue(page, "No Practise Questions found");
		}
		
		@Test(priority=23)
		public void userInDeletion() {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_Deletion();
			String expPageTitle = "Deletion";
			String actPageTitle = linkedlistObj.get_currentPageTitle();
			Assert.assertEquals(actPageTitle,expPageTitle);
		}
		
		@Test(priority=24)
		public void userInTryEditorDeletion() {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_Deletion();
			linkedlistObj.click_tryHere_btn();
			String expPageTitle = "Assessment";
			String actPageTitle = linkedlistObj.get_currentPageTitle();
			Assert.assertEquals(actPageTitle,expPageTitle);
		}
		
		@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=25)
		public void inValidCodeTryEditorDeletion(String code, String error) {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_Deletion();
			linkedlistObj.click_tryHere_btn();
			linkedlistObj.enterCodeTryEditor(code);
		    linkedlistObj.click_tryHere_btn();
		    String alertMsg = linkedlistObj.acceptAlert();
		    Assert.assertTrue(alertMsg.contains(error));
		}
		
		@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class, priority=26)
		public void validCodeTryEditorDeletion(String code, String output) {
			linkedlistObj.click_linkdlistGetStarted();
		    linkedlistObj.click_Deletion();
			linkedlistObj.click_tryHere_btn();
			linkedlistObj.enterCodeTryEditor(code);
		    linkedlistObj.click_tryHere_btn();
		    String actOutput = linkedlistObj.get_tryHereEditor_output();
		    Assert.assertEquals(actOutput,output);
		}
		
		@Test(priority=27)
		public void practiseQtnsTraversal() {
			linkedlistObj.click_linkdlistGetStarted();
			linkedlistObj.click_Deletion();
			linkedlistObj.click_practicequestns_link();
			boolean page = linkedlistObj.check_practiecQtns_avail();
			Assert.assertTrue(page, "No Practise Questions found");
		}
		

		}

