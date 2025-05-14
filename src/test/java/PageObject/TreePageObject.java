package PageObject;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import DriverFactory.DriverFactory;
import Utilities.LoggerLoad;

public class TreePageObject {

	WebDriver driver = DriverFactory.getDriver();

	By tree_getStarted_btn = By.xpath("//a[@href='tree']");

	By getStarted_btn = By.xpath("//button[@class='btn']");

	By signIn_btn = By.linkText("Sign in");

	By username = By.id("id_username");

	By password = By.id("id_password");

	By login_btn = By.xpath("//input[@value='Login']");

	By dataStructutrDropDown = By.xpath("//div[@class='nav-item dropdown']");

	By treeDropDown = By.xpath("//div[@class='nav-item dropdown show']//*[contains(text(),'Tree')]");

	By overviewOfTrees_btn = By.linkText("Overview of Trees");

	By terminologies_btn = By.xpath("//a[@href='terminologies']");

	By types_of_Trees = By.xpath("//a[@href='types-of-trees']");

	By tree_Traversals = By.xpath("//a[@href='tree-traversals']");

	By traversals_Illustration = By.xpath("//a[@href='traversals-illustration']");

	By binary_Trees = By.xpath("//a[@href='binary-trees']");

	By types_of_Binary_Trees = By.xpath("//a[@href='types-of-binary-trees']");

	By implementation_In_Python = By.xpath("//a[@href='implementation-in-python']");

	By binary_Tree_Traversals = By.xpath("//a[@href='binary-tree-traversals']");

	By implementation_Of_Binary_Trees = By.xpath("//a[@href='implementation-of-binary-trees']");

	By applications_Of_Binary_Trees = By.xpath("//a[@href='applications-of-binary-trees']");

	By binary_Search_Trees = By.xpath("//a[@href='binary-search-trees']");

	By implementation_Of_BST = By.xpath("//a[@href='implementation-of-bst']");

	By tryHere_btn = By.linkText("Try here>>>");

	By tryHereEditor_output = By.id("output");

	By run_btn = By.xpath("//button");

	By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");

	By practiceQns_link = By.xpath("//a[normalize-space()='Practice Questions']");

	public String get_currentPageTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}

	public void click_getStarted_btn() {
		driver.findElement(getStarted_btn).click();
	}

	public void click_tree_getStarted_btn() {
		driver.findElement(tree_getStarted_btn).click();
	}

	public void click_signIn_btn() {
		driver.findElement(signIn_btn).click();
	}

	public void enter_username() {
		driver.findElement(username).sendKeys();
	}

	public void click_tryHere_btn() {
		driver.findElement(tryHere_btn).click();
	}

	public void enter_password() {
		driver.findElement(password).sendKeys();
	}

	public void click_login_btn() {
		driver.findElement(login_btn).click();
	}

	public void click_overviewOfTrees() {
		driver.findElement(overviewOfTrees_btn).click();
	}

	public void click_treeDropDown_btn() {
		driver.findElement(treeDropDown).click();
	}

	public void click_dataStructutrDropDown() {
		driver.findElement(dataStructutrDropDown).click();
	}

	public void click_terminologies() {
		driver.findElement(terminologies_btn).click();
	}

	public void click_types_of_Trees() {
		driver.findElement(types_of_Trees).click();
	}

	public void click_tree_Traversals() {
		driver.findElement(tree_Traversals).click();
	}

	public void click_traversals_Illustration() {
		driver.findElement(traversals_Illustration).click();
	}

	public void click_binary_Trees() {
		driver.findElement(binary_Trees).click();
	}

	public void click_types_of_Binary_Trees() {
		driver.findElement(types_of_Binary_Trees).click();
	}

	public void click_implementation_In_Python() {
		driver.findElement(implementation_In_Python).click();
	}

	public void click_implementation_Of_Binary_Trees() {
		driver.findElement(implementation_Of_Binary_Trees).click();
	}

	public void click_applications_Of_Binary_Trees() {
		driver.findElement(applications_Of_Binary_Trees).click();
	}

	public void click_binary_Search_Trees() {
		driver.findElement(binary_Search_Trees).click();
	}

	public void click_implementation_Of_BST() {
		driver.findElement(implementation_Of_BST).click();
	}

	public void click_binary_Tree_Traversals() {
		driver.findElement(binary_Tree_Traversals).click();

	}

	public void click_practiceQns_link() {
		driver.findElement(practiceQns_link).click();

	}

	public void enterCodeTryEditor(String pythonCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(run_btn));
		WebElement tryHereEditor = driver.findElement(tryHereEditor_box);
		tryHereEditor.sendKeys(Keys.CONTROL + "a");
		tryHereEditor.sendKeys(Keys.DELETE);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);", pythonCode);
	}

	public String get_tryHereEditor_output() {
		String output = null;
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(tryHereEditor_output));
			output = driver.findElement(tryHereEditor_output).getText();
		} catch (TimeoutException e) {
			e.printStackTrace();
		}
		return output;
	}

	public void acceptAlert(String errorMsg) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			alert.accept();
			Assert.assertTrue(alertMsg.contains(errorMsg));
		} catch (NoAlertPresentException e) {
			Assert.fail("No Alert found");
		} catch (UnhandledAlertException e) {
			LoggerLoad.error("Unhandled alert exception: " + e.getMessage());
		}
	}

	public void click_tryHereRun_btn() {
		driver.findElement(run_btn).click();

	}

}
