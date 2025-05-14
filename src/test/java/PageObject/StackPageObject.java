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
import Utilities.LoggerLoad;
public class StackPageObject {
 
             
    WebDriver driver= DriverFactory.getDriver();
                    
                    By dropdowndatastructr =By.xpath("//div[@class='nav-item dropdown']");
                    By stackdropdown =By.xpath("//div[@class='nav-item dropdown show']//*[contains(text(),'Stack')]");
                    By stackGetStarted_btn =By.xpath("//a[@href='stack']");   
                    
                    By operationsInStack = By.linkText("Operations in Stack");
                    By implementation = By.linkText("Implementation");
                    By applications = By.linkText("Applications");
                    
                   By Tryherebttn  = By.linkText("Try here>>>");
                   By tryHereEditor_box = By.xpath("//textarea[@autocorrect='off']");
                   By tryHereEditor_output = By.id("output");
                   By runbttn =By.xpath("//button[text()='Run']");
                  
                  By practicequestns_link = By.linkText("Practice Questions");
                  By practicequestns_available = By.xpath("//div[@class='list-group']");
                    public void click_dropdowndatastuctr() {
                        driver.findElement(dropdowndatastructr).click();
                    }
                    
                    public void click_dropdownstack() {
                        driver.findElement(stackdropdown).click();
                    }
                    public void click_getstartedstack() {
                        driver.findElement(stackGetStarted_btn).click();
                    }
                    
                    public void click_OperationsInStack() {
                      driver.findElement(operationsInStack).click();
                        }
                    
                   public void click_Implementation() {
                      driver.findElement(implementation).click();
                   }
               
                   public void click_applicatio() {
                         driver.findElement(applications).click();
                     }    
                   
                     public void click_PracticeQuestions() {
                       driver.findElement( practicequestns_link).click();
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
                 		} catch (NoAlertPresentException e) {
                 			e.printStackTrace();
                 		}
                 		catch (UnhandledAlertException e) {
                 			LoggerLoad.error("Unhandled alert exception: " + e.getMessage());
                 		}
                 		return alertMsg;
                 	}
             
                	public String get_currentPageTitle() {
                		String currentTitle = driver.getTitle();
                		return currentTitle;
                	}
            }