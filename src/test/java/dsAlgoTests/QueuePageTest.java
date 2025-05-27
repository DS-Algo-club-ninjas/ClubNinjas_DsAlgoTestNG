package dsAlgoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import BaseClass.BaseClass;
import DataProvider.DataProviders;
import PageObject.QueuePageObject;
import Utilities.CommonUtil;


public class QueuePageTest extends BaseClass {

	QueuePageObject queuePageObj;
	
	@BeforeMethod
	public void userInHomePage() {
		queuePageObj = new QueuePageObject();
		CommonUtil.validLogin();
	}
	
	@Test(priority=1)
	public void userInGetStartedQueuePage() {
		queuePageObj.click_queueGetStarted_btn();
		String expPageTitle = "Queue";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
	}
	
	@Test(priority=2)
	public void userInDropDownQueuePage() {
		queuePageObj.click_dataStructutrDropDown();
		queuePageObj.click_queueDropDown();
	    String expPageTitle = "Queue";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
	}
	
	@Test(priority=3)
	public void userInImplOfQueue() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implOfQueue_link();
		String expPageTitle = "Implementation of Queue in Python";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=4)
	public void userInTryEditorImplOfQueue() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implOfQueue_link();
		queuePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=5)
	public void inValidCodeTryEditorImplOfQueue(String code, String error) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implOfQueue_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String alertMsg = queuePageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=6)
	public void validCodeTryEditorImplOfQueue(String code, String output) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implOfQueue_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String actOutput = queuePageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=7)
	public void practiseQtnsImplOfQueue() {
		queuePageObj.click_queueGetStarted_btn();
		queuePageObj.click_implOfQueue_link();
		queuePageObj.click_practiceQns_link();
		boolean page = queuePageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}
	
	@Test(priority=8)
	public void userInImplUsingCollections() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingCollections_link();
		String expPageTitle = "Implementation using collections.deque";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=9)
	public void userInTryEditorImplUsingCollections() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingCollections_link();
		queuePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=10)
	public void inValidCodeTryEditorImplUsingCollections(String code, String error) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingCollections_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String alertMsg = queuePageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=11)
	public void validCodeTryEditorImplUsingCollections(String code, String output) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingCollections_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String actOutput = queuePageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=12)
	public void practiseQtnsImplUsingCollections() {
		queuePageObj.click_queueGetStarted_btn();
		queuePageObj.click_implUsingCollections_link();
		queuePageObj.click_practiceQns_link();
		boolean page = queuePageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}

	@Test(priority=13)
	public void userInImplUsingArray() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingArray_link();
		String expPageTitle = "Implementation using array";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=14)
	public void userInTryEditorImplUsingArray() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingArray_link();
		queuePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=15)
	public void inValidCodeTryEditorImplUsingArray(String code, String error) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingArray_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String alertMsg = queuePageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=16)
	public void validCodeTryEditorImplUsingArray(String code, String output) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_implUsingArray_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String actOutput = queuePageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=17)
	public void practiseQtnsImplUsingArray() {
		queuePageObj.click_queueGetStarted_btn();
		queuePageObj.click_implUsingArray_link();
		queuePageObj.click_practiceQns_link();
		boolean page = queuePageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}

	@Test(priority=18)
	public void userInQueueOperation() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_queueOperation_link();
		String expPageTitle = "Queue Operations";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=19)
	public void userInTryEditorQueueOperation() {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_queueOperation_link();
		queuePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = queuePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=20)
	public void inValidCodeTryEditorQueueOperation(String code, String error) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_queueOperation_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String alertMsg = queuePageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class, priority=21)
	public void validCodeTryEditorQueueOperation(String code, String output) {
		queuePageObj.click_queueGetStarted_btn();
	    queuePageObj.click_queueOperation_link();
		queuePageObj.click_tryHere_btn();
		queuePageObj.enterCodeTryEditor(code);
	    queuePageObj.click_tryHereRun_btn();
	    String actOutput = queuePageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=22)
	public void practiseQtnsQueueOperation() {
		queuePageObj.click_queueGetStarted_btn();
		queuePageObj.click_queueOperation_link();
		queuePageObj.click_practiceQns_link();
		boolean page = queuePageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}

}
