package PageObject;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import DriverFactory.DriverFactory;

public class ArrayPageObject {	
	WebDriver driver= DriverFactory.getDriver();
	
	By arrayGetStarted_btn = By.xpath("//a[@href='array']");
	By dataStructutrDropDown = By.xpath("//div[@class='nav-item dropdown']");
	By arrayDropDown = By.xpath("//div[@class='nav-item dropdown show']//*[contains(text(),'Arrays')]");
	By arraysInPython_link = By.linkText("Arrays in Python");
	By arraysUsingList_link = By.linkText("Arrays Using List");
	By basicOperationsInLists_link = By.linkText("Basic Operations in Lists");
	By applicationsOfArray_link = By.linkText("Applications of Array");
	By tryHere_btn = By.linkText("Try here>>>");
	By run_btn = By.xpath("//button");
	By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");
	By tryHereEditor_output = By.id("output");
	By practiceQns_link = By.linkText("Practice Questions");
	By practiceQns_available = By.xpath("//div[@class='list-group']");
	By searchTheArray_link = By.linkText("Search the array");
	By maxConsOnes_link = By.linkText("Max Consecutive Ones");
	By findNumbers_link = By.linkText("Find Numbers with Even Number of Digits");
	By sqrsOfArray_link = By.linkText("Squares of a Sorted Array");
	By submit_btn = By.xpath("//input[@value='Submit']");
	By searchQtn = By.xpath("//span[@id='questionText']//*[contains(text(),'search')]");	
	By maxQtn = By.xpath("//span[@id='questionText']//*[contains(text(),'maximum')]");	
	By findQtn = By.xpath("//span[@id='questionText']//*[contains(text(),'even number')]");	
	By squaresQtn = By.xpath("//span[@id='questionText']//*[contains(text(),'the squares of each number')]");	
	
	
	//ArrayPage Methods
	public void click_arrayGetStarted_btn() {
		driver.findElement(arrayGetStarted_btn).click();
	}
	
	public void click_dataStructutrDropDown() {
		driver.findElement(dataStructutrDropDown).click();
	}
	
	public void select_arrayDropDown() {
		driver.findElement(arrayDropDown).click();
	}
	
	public void click_arraysInPython_link() {
		driver.findElement(arraysInPython_link).click();
	}
	
	public void click_arraysUsingList_link() {
		driver.findElement(arraysUsingList_link).click();
	}
	
	public void click_basicOperationsInLists_link() {
		driver.findElement(basicOperationsInLists_link).click();
	}
	
	public void click_applicationsOfArray_link() {
		driver.findElement(applicationsOfArray_link).click();
	}
	
	public void click_tryHere_btn() {
		driver.findElement(tryHere_btn).click();
	}
	
	public void click_tryHereRun_btn() {
		driver.findElement(run_btn).click();
	}

	public void click_practiceQns_link() {
		driver.findElement(practiceQns_link).click();
	}
	
	public void click_searchTheArray_link() {
		driver.findElement(searchTheArray_link).click();
	}
	
	public void click_maxConsOnes_link() {
		driver.findElement(maxConsOnes_link).click();
	}
	
	public void click_findNumbers_link() {
		driver.findElement(findNumbers_link).click();
	}
	
	public void click_sqrsOfArray_link() {
		driver.findElement(sqrsOfArray_link).click();
	}
	
	public void click_submit_btn() {
		driver.findElement(submit_btn).click();
	}
	

	public boolean check_practiecQtns_avail() {
		List<WebElement> elements = driver.findElements(practiceQns_available);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public boolean check_search_qtn() {
		List<WebElement> elements = driver.findElements(searchQtn);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public boolean check_max_qtn() {
		List<WebElement> elements = driver.findElements(maxQtn);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public boolean check_find_qtn() {
		List<WebElement> elements = driver.findElements(findQtn);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public boolean check_square_qtn() {
		List<WebElement> elements = driver.findElements(squaresQtn);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public String get_currentPageTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
	}
	
	
	public void enterCodeTryEditor(String pythonCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		for (int i = 0; i < 2; i++) {
		    try {
		    	WebElement tryHereEditor = driver.findElement(tryHereEditor_box);
		    	tryHereEditor.sendKeys(Keys.CONTROL + "a");
				tryHereEditor.sendKeys(Keys.DELETE);
				js.executeScript(
			            "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
			            pythonCode
			        );
		        break;
		    } catch (Exception e) {
		    	try {
		        wait.until(ExpectedConditions.visibilityOfElementLocated(tryHereEditor_box));
		    	}
		    	catch (Exception e1) {
		    		e1.printStackTrace();
		    	}
		    }
		}
	}
	
	public String get_tryHereEditor_output() {
		String output = "";
		try {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tryHereEditor_output));
		output = driver.findElement(tryHereEditor_output).getText();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public String acceptAlert(String errorMsg) {
		String alertMsg = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertMsg = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			e.printStackTrace();
		}
		catch (UnhandledAlertException e) {
			System.out.println("Unhandled alert exception: " + e.getMessage());
		}
		return alertMsg;
	}
	
}
