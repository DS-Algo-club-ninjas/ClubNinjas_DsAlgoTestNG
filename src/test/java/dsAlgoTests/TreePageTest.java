package dsAlgoTests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import DataProvider.DataProviders;
import Hooks.Hooks;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import PageObject.TreePageObject;
import Utilities.CommonUtil;
import Utilities.ExcelReader;

public class TreePageTest extends Hooks {

	TreePageObject treePageObj;
	HomePageObject homePageObj;
	LoginPageObject loginPageObj;
	ExcelReader readExcel;

	@BeforeMethod
	public void userInHomePage() {
		treePageObj = new TreePageObject();
		homePageObj = new HomePageObject();
		loginPageObj = new LoginPageObject();
		CommonUtil.validLogin();

	}


	@Test(priority=1)
	public void userInTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		String expPageTitle = "Tree";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	// Overview of Trees

	@Test(priority=2)
	public void userInOverViewOfTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_overviewOfTrees();
		String expPageTitle = "Overview of Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=3)
	public void userInTryEditorOverviewofTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_overviewOfTrees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(priority=4)
	public void userInOverviewTreesPracticeQuestionsPage() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_overviewOfTrees();
		treePageObj.click_practiceQns_link();
		boolean page = treePageObj.check_practiecQtns_avail();
		Assert.assertTrue(page, "No Practise Questions found");

	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=5, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInOverviewOfTreesPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_overviewOfTrees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=6, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorOverviewOfTreesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_overviewOfTrees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}

	// Terminologies

	@Test(priority=7)
	public void userInTerminologiesOfTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_terminologies();
		String expPageTitle = "Terminologies";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=8)
	public void userInTryEditorTerminologiesofTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_terminologies();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=9, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTerminologiesPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_terminologies();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=10, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorTerminologiesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_terminologies();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}

	// Types of Trees

	@Test(priority=11)
	public void userInTypesOfTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Trees();
		String expPageTitle = "Types of Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=12)
	public void userInTryEditorTypesOfTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=13, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTypesOfTreesOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=14, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorTypesOfTreesOnInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}

	
	// Tree Traversals
	
	
	@Test(priority=15)
	public void userInTreeTraversalssOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_tree_Traversals();
		String expPageTitle = "Tree Traversals";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=16)
	public void userInTryEditorTreeTraversalsOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_tree_Traversals();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=17, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTreeTraversalsOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=18, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorTreeTraversalsOnInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}
	
     //Traversals-Illustration
	
	
	@Test(priority=19)
	public void userInTraversalsIllustrationOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_traversals_Illustration();
		String expPageTitle = "Traversals-Illustration";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=20)
	public void userInTryEditorTraversalsIllustrationOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_traversals_Illustration();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=21, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTraversalsIllustrationOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_traversals_Illustration();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=22, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorTraversalsIllustrationOnInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_traversals_Illustration();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}
	//Binary Trees
	
	@Test(priority=23)
	public void userInBinaryTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Trees();
		String expPageTitle = "Binary Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=24)
	public void userInTryEditorBinaryTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=25, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInBinaryTreesOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=26, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorBinaryTreesOnInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
}
	
	//Types of Binary Trees
	
	
	@Test(priority=27)
	public void userInTypesofBinaryTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Binary_Trees();
		String expPageTitle = "Types of Binary Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=28)
	public void userInTryEditorTypesofBinaryTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=29, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTypesofBinaryTreesOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=30, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorTypesofBinaryTreesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_types_of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
}
	
	//Implementation in Python
	

	@Test(priority=31)
	public void userInImplementationinPythonOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_implementation_In_Python();
		String expPageTitle = "Implementation in Python";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=32)
	public void userInTryEditorImplementationinPythonOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=33, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInTmplementationinPythonOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=34, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorImplementationinPythonInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
}
	//Binary Tree Traversals
	
	@Test(priority=35)
	public void userInBinaryTreeTraversalsOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		String expPageTitle = "Binary Tree Traversals";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=36)
	public void userInTryEditorBinaryTreeTraversalsOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=37, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInBinaryTreeTraversalsOfPaython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=38, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorBinaryTreeTraversalsInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Tree_Traversals();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
}
	//Implementation of Binary Trees
	
	@Test(priority=39)
	public void userInImplementationofBinaryTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_implementation_Of_Binary_Trees();
		String expPageTitle = "Implementation of Binary Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=40)
	public void userInTryEditorImplementationofBinaryTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_implementation_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=41, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInImplementationofBinaryTreesOfPython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_implementation_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=42, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorImplementationofBinaryTreesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_implementation_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
}
	//Applications of Binary trees
	
	@Test(priority=43)
	public void userInApplicationsOfBinaryTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_applications_Of_Binary_Trees();
		String expPageTitle = "Applications of Binary trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);

	}

	@Test(priority=44)
	public void userInTryEditorApplicationsOfBinaryTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_applications_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=45, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInApplicationsOfBinaryTreesOfPython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_applications_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=46, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorApplicationsOfBinaryTreesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_applications_Of_Binary_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}
	
	//Binary Search Trees
	@Test(priority=47)
	public void userInBinarySearchTreesOnTreePage() {

		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Search_Trees();
		String expPageTitle = "Binary Search Trees";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(expPageTitle, actPageTitle);
	

	}

	@Test(priority=48)
	public void userInTryEditorBinarySearchTreesOnTrees() {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Search_Trees();
		treePageObj.click_tryHere_btn();
		String expPageTitle = "Assessment";
		String actPageTitle = treePageObj.get_currentPageTitle();
		Assert.assertEquals(actPageTitle, expPageTitle);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=49, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void runInvalidCodeInBinarySearchTreesOfPython(String code, String error) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Search_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String alertMsg = treePageObj.acceptAlert();
		Assert.assertTrue(alertMsg.contains(error));
		System.out.println("Error " + error);
	}

	@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=50, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
	public void validCodeTryEditorBinarySearchTreesInPython(String code, String output) {
		treePageObj.click_dataStructutrDropDown();
		treePageObj.click_treeDropDown_btn();
		treePageObj.click_binary_Search_Trees();
		treePageObj.click_tryHere_btn();
		treePageObj.enterCodeTryEditor(code);
		treePageObj.click_tryHereRun_btn();
		String actOutput = treePageObj.get_tryHereEditor_output();
		Assert.assertEquals(actOutput, output);
	}
		
	//Implementation Of BST
	@Test(priority=51)
		public void userInImplementationOfBSTOnTreePage() {

			treePageObj.click_dataStructutrDropDown();
			treePageObj.click_treeDropDown_btn();
			treePageObj.click_implementation_Of_BST();
			String expPageTitle = "Implementation Of BST";
			String actPageTitle = treePageObj.get_currentPageTitle();
			Assert.assertEquals(expPageTitle, actPageTitle);

		}

		@Test(priority=52)
		public void userInTryEditorImplementationOfBSTOnTrees() {
			treePageObj.click_dataStructutrDropDown();
			treePageObj.click_treeDropDown_btn();
			treePageObj.click_implementation_Of_BST();
			treePageObj.click_tryHere_btn();
			String expPageTitle = "Assessment";
			String actPageTitle = treePageObj.get_currentPageTitle();
			Assert.assertEquals(actPageTitle, expPageTitle);
		}

		@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=53, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void runInvalidCodeInImplementationOfBSTOfPython(String code, String error) {
			treePageObj.click_dataStructutrDropDown();
			treePageObj.click_treeDropDown_btn();
			treePageObj.click_implementation_Of_BST();
			treePageObj.click_tryHere_btn();
			treePageObj.enterCodeTryEditor(code);
			treePageObj.click_tryHereRun_btn();
			String alertMsg = treePageObj.acceptAlert();
			Assert.assertTrue(alertMsg.contains(error));
			System.out.println("Error " + error);
		}

		@Test(dataProvider="CodeTryEditor", dataProviderClass = DataProviders.class,  priority=54, retryAnalyzer = Listeners.dsAlgoRetryAnalyzer.class)
		public void validCodeTryEditorImplementationOfBSTInPython(String code, String output) {
			treePageObj.click_dataStructutrDropDown();
			treePageObj.click_treeDropDown_btn();
			treePageObj.click_implementation_Of_BST();
			treePageObj.click_tryHere_btn();
			treePageObj.enterCodeTryEditor(code);
			treePageObj.click_tryHereRun_btn();
			String actOutput = treePageObj.get_tryHereEditor_output();
			Assert.assertEquals(actOutput, output);
		}
		}
	
