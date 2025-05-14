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

public class LinkeListPageObject {
    
	WebDriver driver= DriverFactory.getDriver();
	
	   By dataStructutrDropDown = By.xpath("//a[text()='Data Structures']");
	   By linkedlistDropDown = By.xpath("//div[@class='nav-item dropdown show']//*[contains(text(),'Linked List')]");
	   By linkdlistGetStarted_btn = By.xpath("//a[@href='linked-list']");
	  
	   By introduction     = By.linkText("Introduction");
	   By creatinglinkedlist = By.linkText("Creating Linked LIst");
	   By typslinkdlist = By.linkText("Types of Linked List"); 
	   By impmntlinkdlstpython = By.linkText("Implement Linked List in Python");
	   By traversal = By.linkText("Traversal");
	   By insertion =By.linkText("Insertion");
	   By deletion = By.linkText("Deletion");
	 
	   By Tryherebttn  = By.linkText("Try here>>>");
	   By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");
	   By tryHereEditor_output = By.id("output");
	   By runbttn =By.xpath("//button[text()='Run']");
	  
	   By practicequestns_link = By.linkText("Practice Questions");
	   By practicequestns_available = By.xpath("//div[@class='list-group']");
//	   public String get_currentPageTitle() {
//			String currentTitle = driver.getTitle();
//			return currentTitle;
//		}
//		
//		public String get_currentPageURL() {
//			String currentURL = driver.getCurrentUrl();
//			return currentURL;
//		}
		
		public void click_dataStructutrDropDown() {
			driver.findElement(dataStructutrDropDown).click();
		}
	   
		 public void click_linkedlistDropDown() {
			 
			 driver.findElement(linkedlistDropDown).click();
			 
		 }
		 
		 public void click_linkdlistGetStarted() {
			 driver.findElement(linkdlistGetStarted_btn).click();
		 }
		 
		 public void click_introduction() {
			 driver.findElement(introduction).click();
		 }
		 
		 public void click_creatinglinkedlist() {
			 driver.findElement(creatinglinkedlist).click();
		 }
		 
		 public void click_typslinkdlist() {
			 driver.findElement(typslinkdlist).click();
		 }
		 
		public void click_impmntlinkdlstpython() {
			driver.findElement(impmntlinkdlstpython).click();
		}
		public void click_traversal() {
			driver.findElement(traversal).click();
		}
		public void click_insertion() {
			driver.findElement(insertion).click();
		}
		
		public void click_Deletion() {
			driver.findElement(deletion).click();
		}
//		public void click_Tryherebttn1() {
//			driver.findElement(Tryherebttn).click();
//		}
//		public void click_tryHereEditor_box() {
//			driver.findElement(tryHereEditor_box).click();
//		}
//		public void click_tryHereEditor_output() {
//			driver.findElement(tryHereEditor_output).click();
//		}
		
		public void click_practicequestns_link() {
			driver.findElement(practicequestns_link).click();
		}
		public boolean check_practiecQtns_avail() {
			List<WebElement> elements = driver.findElements(practicequestns_available);
			if (!elements.isEmpty()) {
			    return true;
			} else {
			    return false;
			}
		}
		
		 public void click_runbttn() {
  			driver.findElement(runbttn).click();
  		}
		 
		 public String get_currentPageTitle() {
      		String currentTitle = driver.getTitle();
      		return currentTitle;
      	}
      	
      	public void click_tryHere_btn() {
      		driver.findElement(Tryherebttn).click();
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
      			//Assert.assertTrue(alertMsg.contains(errorMsg));
      		} catch (NoAlertPresentException e) {
      			//Assert.fail("No Alert found");
      			e.printStackTrace();
      		}
      		catch (UnhandledAlertException e) {
      			System.out.println("Unhandled alert exception: " + e.getMessage());
      		}
      		return alertMsg;
      	}
      	
      	
      

		
}
