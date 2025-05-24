package dsAlgoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.ArrayPageObject;
import Utilities.CommonUtil;

public class ArrayPageTest extends Hooks {
	
	ArrayPageObject arrayPageObj;
	
	@BeforeMethod(groups="Array")
	public void userInHomePage() {
		arrayPageObj = new ArrayPageObject();
		CommonUtil.validLogin();
	}
	
	@Test(priority=1)
	public void userInGetStartedArrayPage() {
		arrayPageObj.click_arrayGetStarted_btn();
		String expPageTitle = "Array";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
	}
	
	@Test(priority=2)
	public void userInDropDownArrayPage() {
		arrayPageObj.click_dataStructutrDropDown();
	    arrayPageObj.select_arrayDropDown();
	    String expPageTitle = "Array";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
	}
	
	@Test(priority=3)
	public void userInArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		String expPageTitle = "Arrays in Python";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=4)
	public void userInTryEditorArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=5, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void inValidCodeTryEditorsInPython(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, priority=6, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorsInPython(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=7)
	public void practiseQtnsArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("practiseQtns");
		Assert.assertTrue(page, "No Practise Questions found");
	}
	
	@Test(priority=8)
	public void searchTheArrayQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("searchTheArray");
		Assert.assertTrue(page, "Search the Array Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=9)
	public void runInvalidCodeSearchTheArray(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=10)
	public void runValidCodeSearchTheArray(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);	
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=11)
	public void submitInvalidCodeSearchTheArray(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,error);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=12)
	public void submitValidCodeSearchTheArray(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=13)
	public void maxConOnesQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("maxConOnes");
		Assert.assertTrue(page, "Max Consecutive Ones Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=14)
	public void runInvalidCodeMaxConOnes(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=15)
	public void runValidCodeMaxConOnes(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);	
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=16)
	public void submitInvalidCodeMaxConOnes(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,error);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=17)
	public void submitValidCodeMaxConOnes(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=18)
	public void findEvenNumberQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("findEvenNumber");
		Assert.assertTrue(page, "Find Numbers with Even Number of Digits Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=19)
	public void runInvalidCodeFindEvenNumber(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=20)
	public void runValidFindEvenNumber(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);	
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=21)
	public void submitInvalidCodeFindEvenNumber(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=22)
	public void submitValidCodeFindEvenNumber(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=23)
	public void sqrsOfSortedArrayQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("sqrsOfSortedArray");
		Assert.assertTrue(page, "Squares of a Sorted Array not found");
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=24)
	public void runInvalidCodeSqrsOfSortedArrayQtn(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=25)
	public void runValidSqrsOfSortedArrayQtn(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);	
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=26)
	public void submitInvalidCodeSqrsOfSortedArrayQtn(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    System.out.println("code " +code);
	    System.out.println("output " +output);
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=27)
	public void submitValidCodeSqrsOfSortedArrayQtn(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=28)
	public void userInArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		String expPageTitle = "Arrays Using List";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=29)
	public void userInTryEditorArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=30)
	public void inValidCodeTryEditorsUsingList(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=31)
	public void validCodeTryEditorsUsingList(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=32)
	public void practiseQtnsArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("practiseQtns");
		Assert.assertTrue(page, "No Practise Questions found");
	}
	
	@Test(priority=33)
	public void userInBasicOprtnsInList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_basicOperationsInLists_link();
		String expPageTitle = "Basic Operations in Lists";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=34)
	public void userInTryEditorBasicOprtnsInList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_basicOperationsInLists_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=35)
	public void inValidCodeTryEditorBasicOprtnsInList(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_basicOperationsInLists_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=36)
	public void validCodeTryEditorBasicOprtnsInList(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_basicOperationsInLists_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=37)
	public void practiseQtnsBasicOprtnsInList() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_basicOperationsInLists_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("practiseQtns");
		Assert.assertTrue(page, "No Practise Questions found");
	}
	
	@Test(priority=37)
	public void userInApplicationsOfArray() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_applicationsOfArray_link();
		String expPageTitle = "Applications of Array";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(priority=38)
	public void userInTryEditorApplicationsOfArray() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_applicationsOfArray_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=39)
	public void inValidCodeTryEditorApplicationsOfArray(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_applicationsOfArray_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class,  priority=40)
	public void validCodeTryEditorApplicationsOfArray(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_applicationsOfArray_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(priority=41)
	public void practiseQtnsApplicationsOfArray() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_applicationsOfArray_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail("practiseQtns");
		Assert.assertTrue(page, "No Practise Questions found");
	}
}