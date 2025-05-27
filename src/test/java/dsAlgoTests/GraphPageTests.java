package dsAlgoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import DataProvider.DataProviders;
import PageObject.*;
import Utilities.CommonUtil;
import Utilities.ExcelReader;

public class GraphPageTests extends BaseClass {

	ExcelReader readExcel;
	GraphPageObject graphPageObj;
	HomePageObject homePageObj;
	
	@BeforeMethod
	public void userInHomePage() {
		graphPageObj = new GraphPageObject();
		homePageObj = new HomePageObject();
		CommonUtil.validLogin();
	}
	@Test(priority=1)
	public void userInGetStartedQueuePage() {
		homePageObj.graphGetStartedBtnClick();
		String expPageTitle = "Graph";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}
	@Test(priority=2)
	public void userInDropDownGraphPage() {
		homePageObj.dataStructuresDrpDwnClick();
		homePageObj.graphDrpDwnClick();
	    String expPageTitle = "Graph";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
	}
	@Test(priority=3)
	public void userInSubLinkGraphPage() {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphLink();
		String expPageTitle = "Graph";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	   }

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=4)
	public void inValidCodeTryEditorForGraphSubLink(String code, String error) {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphLink();
		graphPageObj.click_tryHere_btn();
		graphPageObj.enterCodeTryEditor(code);
		graphPageObj.click_tryHereRun_btn();
		
		String alertMsg = graphPageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		
		    
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=5)
	public void validCodeTryEditorGraphSubLink(String code, String output) {
		
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphLink();
		graphPageObj.click_tryHere_btn();
		graphPageObj.enterCodeTryEditor(code);
		graphPageObj.click_tryHereRun_btn();
	    String actOutput = graphPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
		
	@Test(priority=6)
	public void practiseQtnsGraphLink() {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphLink();
		graphPageObj.clickPracticeQuestionsLink();
		
		String expPageTitle = "Practice Questions";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=7)
	public void userInGraphRepresentationsLink() {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphRepresentationsLink();
		
		String expPageTitle = "Graph Representations";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	    }
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=8)
	public void inValidCodeTryEditorGraphRepresentationsLink(String code, String error) {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphRepresentationsLink();
		graphPageObj.click_tryHere_btn();
		graphPageObj.enterCodeTryEditor(code);
		graphPageObj.click_tryHereRun_btn();
		
		String alertMsg = graphPageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		    
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=9)
	public void validCodeTryEditorGraphRepresentationsLink(String code, String output) {
		
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphRepresentationsLink();
		graphPageObj.click_tryHere_btn();
		graphPageObj.enterCodeTryEditor(code);
		graphPageObj.click_tryHereRun_btn();
	    String actOutput = graphPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
		
	@Test(priority=10)
	public void practiseQtnsGraphRepresentationsLink() {
		homePageObj.graphGetStartedBtnClick();
		graphPageObj.clickGraphRepresentationsLink();
		graphPageObj.clickPracticeQuestionsLink();
		
		String expPageTitle = "Practice Questions";
		String actPageTitle = graphPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
}
