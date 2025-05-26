package dsAlgoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.DataStructurePageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import Utilities.CommonUtil;

public class DataStructurePageTest extends Hooks {

	HomePageObject homePageObj;
	LoginPageObject loginPageObj;
	DataStructurePageObject dataPageObj;

	@BeforeMethod
	public void userInHomePage() {
		homePageObj = new HomePageObject();
		loginPageObj = new LoginPageObject();
		dataPageObj = new DataStructurePageObject();
		CommonUtil.validLogin();
	}

	@Test(priority=1)
	public void userInGetStartedDataStructurePage() {
		dataPageObj.click_dataStructuresGetStarted_btn();
		String expPageTitle = "Data Structures-Introduction";
		String actPageTitle = dataPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=2)
	public void userInTimeComplexityPage() {
		dataPageObj.click_dataStructuresGetStarted_btn();
		dataPageObj.click_timeComplexity_btn();
		String expPageTitle = "Time Complexity";
		String actPageTitle = dataPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=3)
	public void userInTryEditorArraysInPython() {
		dataPageObj.click_dataStructuresGetStarted_btn();
		dataPageObj.click_timeComplexity_btn();
		dataPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = dataPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(priority=4)
	public void userInPracticeQuestionsPage() {
		dataPageObj.click_dataStructuresGetStarted_btn();
		dataPageObj.click_timeComplexity_btn();
		dataPageObj.click_practiceQns_link();
		boolean page = dataPageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");

	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=5, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInPaython(String code, String error) {
		dataPageObj.click_dataStructuresGetStarted_btn();
		dataPageObj.click_timeComplexity_btn();
		dataPageObj.click_tryHere_btn();
		dataPageObj.enterCodeTryEditor(code);
		dataPageObj.click_tryHereRun_btn();
		String alertMsg = dataPageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=6, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorDataStructureInPython(String code, String output) {
		dataPageObj.click_dataStructuresGetStarted_btn();
		dataPageObj.click_timeComplexity_btn();
		dataPageObj.click_tryHere_btn();
		dataPageObj.enterCodeTryEditor(code);
		dataPageObj.click_tryHereRun_btn();
		String actOutput = dataPageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}

}
