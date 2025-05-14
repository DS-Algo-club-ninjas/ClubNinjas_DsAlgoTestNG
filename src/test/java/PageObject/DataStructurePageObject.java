package PageObject;

import java.time.Duration;
import java.util.List;

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

public class DataStructurePageObject {
	

	
	WebDriver driver= DriverFactory.getDriver();

	By getStarted_btn = By.xpath("//button[@class='btn']");
	By signIn_btn = By.linkText("Sign in");
	By userNameTxtBox = By.id("id_username");
	By passwordTxtBox = By.id("id_password");
	By login_btn = By.xpath("//input[@value='Login']");
	By dataStructreTitle = By.linkText("Data Structures-Introduction");
	By dataStructuresGetStarted_btn = By.xpath("//a[@href='data-structures-introduction']");
	By timeComplexity_btn = By.xpath("//a[@href='time-complexity']");
	By practiceQns_link = By.linkText("Practice Questions");
	By tryHere_btn = By.linkText("Try here>>>");
	By run_btn = By.xpath("//button");
	By first_practiceQns_link=By.className("//div[@class='list-group']");
	By tryHereEditor_output = By.id("output");
	By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");
	
       public void click_getStarted_btn() {
	     driver.findElement(getStarted_btn).click();
}

      public void click_signIn_btn() {
	     driver.findElement(signIn_btn).click();
}

      public void enter_userNameTxtBox(String username ) {
	     driver.findElement(userNameTxtBox).sendKeys(username);
}

      public void enter_passwordTxtBox(String password) {
	     driver.findElement(passwordTxtBox).sendKeys(password);
}

      public void click_login_btn() {
	     driver.findElement(login_btn).click();
}
      
      public void click_dataStructuresGetStarted_btn() {
  		driver.findElement(dataStructuresGetStarted_btn).click();
      }
      
      
      public void click_timeComplexity_btn() {
    	  driver.findElement(timeComplexity_btn).click();
      
     }
      
      public void click_practiceQns_link() {
  		driver.findElement(practiceQns_link).click();
  	}
      public void click_first_practiceQn_link() {
  	    
  	    List<WebElement> links = driver.findElements(first_practiceQns_link);
  	    if (links.size() > 0) {
  	    	driver.findElement(first_practiceQns_link).click();
  	    System.out.println("Links found on the page: " + links.size());
  	} 
  	    else {
  	      throw new RuntimeException(" No links found on the page. Page might be blank!");

  	}

  	}
      public void click_tryHere_btn() {
  		driver.findElement(tryHere_btn).click();
  	}
  	
  	public void click_tryHereRun_btn() {
  		driver.findElement(run_btn).click();
  	}
	
	
	public String get_currentPageURL() {
		String currentURL = driver.getCurrentUrl();
		return currentURL;
	}

	public String get_currentPageTitle() {
			String currentTitle = driver.getTitle();
			return currentTitle;
  	

}
	public void enterCodeTryEditor(String pythonCode) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.visibilityOfElementLocated(run_btn));
	    WebElement tryHereEditor = driver.findElement(tryHereEditor_box);
		tryHereEditor.sendKeys(Keys.CONTROL + "a");
		tryHereEditor.sendKeys(Keys.DELETE);
		JavascriptExecutor js = (JavascriptExecutor)driver;	
		js.executeScript(
	            "document.querySelector('.CodeMirror').CodeMirror.setValue(arguments[0]);",
	            pythonCode
	        );
	}
	
	public String get_tryHereEditor_output() {
		String output = null;
		try {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(tryHereEditor_output));
		output = driver.findElement(tryHereEditor_output).getText();
		}
		catch (TimeoutException e) {
			e.printStackTrace();
		}
		return output;
	}
	
	public void acceptAlert(String errorMsg) {
		try {
			Alert alert = driver.switchTo().alert();
			String alertMsg = alert.getText();
			System.out.println("Alert Is:" + alertMsg);
			alert.accept();
			Assert.assertTrue(alertMsg.contains(errorMsg));
		} catch (NoAlertPresentException e) {
			Assert.fail("No Alert found");
		}
		catch (UnhandledAlertException e) {
			System.out.println("Unhandled alert exception: " + e.getMessage());
		}
		}
}


  	