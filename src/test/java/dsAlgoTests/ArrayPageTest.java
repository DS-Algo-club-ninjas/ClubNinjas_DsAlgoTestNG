package dsAlgoTests;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.ArrayPageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import Utilities.ExcelReader;
import Utilities.LoggerLoad;

public class ArrayPageTest extends Hooks {
	
	ArrayPageObject arrayPageObj;
	HomePageObject homePageObj;
	LoginPageObject loginPageObj;
	ExcelReader readExcel;
	
	@BeforeMethod
	public void userInHomePage() {
		arrayPageObj = new ArrayPageObject();
		homePageObj = new HomePageObject();
		loginPageObj = new LoginPageObject();
		validLogin();
	}
	
	public void validLogin() {
		homePageObj.clickGetStartedBtn();
		loginPageObj.clickSignInLink();
		ExcelReader excel;
		try {
			excel = new ExcelReader("valid_Login");
		System.out.println("valid login fun");
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
	
	@Test
	public void userInGetStartedArrayPage() {
		arrayPageObj.click_arrayGetStarted_btn();
		String expPageTitle = "Array";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
		System.out.println("userInArrayPage");
	}
	
	@Test
	public void userInDropDownArrayPage() {
		arrayPageObj.click_dataStructutrDropDown();
	    arrayPageObj.select_arrayDropDown();
	    String expPageTitle = "Array";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle,actPageTitle);
		System.out.println("userInArrayPage Dropdown");
	}
	
	@Test
	public void userInArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		String expPageTitle = "Arrays in Python";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test
	public void userInTryEditorArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void inValidCodeTryEditorArraysInPython(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	    System.out.println("Error " +error);
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void validCodeTryEditorArraysInPython(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    //String expOutput = "";
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test
	public void practiseQtnsArraysInPython() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}
	
	@Test
	public void searchTheArrayQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		boolean page = arrayPageObj.check_search_qtn();
		Assert.assertTrue(page, "Search the Array Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void runInvalidCodeSearchTheArray(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(output));
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void submitInvalidCodeSearchTheArray(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_searchTheArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test
	public void maxConOnesQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		boolean page = arrayPageObj.check_max_qtn();
		Assert.assertTrue(page, "Max Consecutive Ones Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void runInvalidCodeMaxConOnes(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(output));
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void submitInvalidCodeMaxConOnes(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_maxConsOnes_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test
	public void findEvenNumberQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		boolean page = arrayPageObj.check_find_qtn();
		Assert.assertTrue(page, "Find Numbers with Even Number of Digits Questions not found");
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void runInvalidCodeFindEvenNumber(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_findNumbers_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(output));
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test
	public void sqrsOfSortedArrayQtn() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		boolean page = arrayPageObj.check_square_qtn();
		Assert.assertTrue(page, "Squares of a Sorted Array not found");
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void runInvalidCodeSqrsOfSortedArrayQtn(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(output));
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void submitInvalidCodeSqrsOfSortedArrayQtn(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysInPython_link();
		arrayPageObj.click_practiceQns_link();
		arrayPageObj.click_sqrsOfArray_link();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_submit_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
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
	
	@Test
	public void userInArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		String expPageTitle = "Arrays Using List";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test
	public void userInTryEditorArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = arrayPageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle,expPageTitle);
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void inValidCodeTryEditorArraysUsingList(String code, String error) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String alertMsg = arrayPageObj.acceptAlert();
	    Assert.assertTrue(alertMsg.contains(error));
	}
	
	@Test(dataProvider="CodeTryEditorArray", dataProviderClass = DataProviders.class)
	public void validCodeTryEditorArraysUsingList(String code, String output) {
		arrayPageObj.click_arrayGetStarted_btn();
	    arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_tryHere_btn();
		arrayPageObj.enterCodeTryEditor(code);
	    arrayPageObj.click_tryHereRun_btn();
	    String actOutput = arrayPageObj.get_tryHereEditor_output();
	    Assert.assertEquals(actOutput,output);
	}
	
	@Test
	public void practiseQtnsArraysUsingList() {
		arrayPageObj.click_arrayGetStarted_btn();
		arrayPageObj.click_arraysUsingList_link();
		arrayPageObj.click_practiceQns_link();
		boolean page = arrayPageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");
	}
}