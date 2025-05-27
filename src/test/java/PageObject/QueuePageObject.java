package PageObject;

import java.util.List;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import DriverFactory.DriverFactory;
import Utilities.CommonUtil;
import Utilities.LoggerLoad;

public class QueuePageObject {
	
	WebDriver driver= DriverFactory.getDriver();
	
	By queueGetStarted_btn = By.xpath("//a[@href='queue']");
	By dataStructutrDropDown = By.xpath("//div[@class='nav-item dropdown']");
	By queueDropDown = By.xpath("//div[@class='nav-item dropdown show']//*[contains(text(),'Queue')]");
	By implOfQueue_link = By.linkText("Implementation of Queue in Python");
	By implUsingCollections_link = By.linkText("Implementation using collections.deque");
	By implUsingArray_link = By.linkText("Implementation using array");
	By queueOperation_link = By.linkText("Queue Operations");
	By practiceQns_link = By.linkText("Practice Questions");
	By practiceQns_available = By.xpath("//div[@class='list-group']");
	By tryHere_btn = By.linkText("Try here>>>");
	By run_btn = By.xpath("//button");
	By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");
	By tryHereEditor_output = By.id("output");
	
	public void click_queueGetStarted_btn() {
		driver.findElement(queueGetStarted_btn).click();
	}
	
	public void click_dataStructutrDropDown() {
		driver.findElement(dataStructutrDropDown).click();
	}
	public void click_queueDropDown() {
		driver.findElement(queueDropDown).click();
	}
	
	public void click_implOfQueue_link() {
		driver.findElement(implOfQueue_link).click();
	}
	
	public void click_implUsingCollections_link() {
		driver.findElement(implUsingCollections_link).click();
	}
	
	public void click_implUsingArray_link() {
		driver.findElement(implUsingArray_link).click();
	}
	
	public void click_queueOperation_link() {
		driver.findElement(queueOperation_link).click();
	}
	
	public String get_currentPageTitle() {
		String currentTitle = driver.getTitle();
		return currentTitle;
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
	
	public boolean check_practiecQtns_avail() {
		List<WebElement> elements = driver.findElements(practiceQns_available);
		if (!elements.isEmpty()) {
		    return true;
		} else {
		    return false;
		}
	}
	
	public void enterCodeTryEditor(String pythonCode) {
		WebElement tryHereEditor;
		JavascriptExecutor js = (JavascriptExecutor)driver;		
		for (int i = 0; i < 2; i++) {
		    try {
		    	tryHereEditor = driver.findElement(tryHereEditor_box);
		    	tryHereEditor.sendKeys(Keys.CONTROL + "a");
				tryHereEditor.sendKeys(Keys.DELETE);
				js.executeScript(
			            "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
			            pythonCode
			        );
		        break;
		    } catch (Exception e) {
		    	try {
		    		CommonUtil.waitForVisibility(tryHereEditor_box);
		    	}
		    	catch (Exception e1) {
		    		LoggerLoad.error("Exception " +e1+ " while tring to enter code in editor");
		    	}
		    }
		}
	}
	
	public String get_tryHereEditor_output() {
		String output = "";
		try {
			CommonUtil.waitForVisibility(tryHereEditor_output);
			output = driver.findElement(tryHereEditor_output).getText();
		}
		catch (Exception e) {
			LoggerLoad.error("Exception " +e+ " in TryHere Editor Output");
		}
		return output;
	}
	
	public String acceptAlert() {
		String alertMsg = "";
		try {
			Alert alert = driver.switchTo().alert();
			alertMsg = alert.getText();
			alert.accept();
		} catch (NoAlertPresentException e) {
			LoggerLoad.error("NoAlertPresentException Exception");;
		}
		catch (UnhandledAlertException e) {
			LoggerLoad.error("Unhandled alert exception: " + e.getMessage());
		}
		return alertMsg;
	}

}
