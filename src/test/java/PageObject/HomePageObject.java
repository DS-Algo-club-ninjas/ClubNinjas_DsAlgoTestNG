package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import DriverFactory.DriverFactory;
import Utilities.ConfigFileReader;

public class HomePageObject {
	
	WebDriver driver = DriverFactory.getDriver();
	ConfigFileReader ConfigFileRdr = new ConfigFileReader();
	
	// Locators
   	By randomClick = By.xpath("//h1[text()='Preparing for the Interviews']");
    By getStartedBtn = By.xpath("//button[@class='btn']");
    By homeLogInMsg = By.xpath("//div[contains(text(),'logged in')]");
    
    //DropDownsMenu
    By dataStructuresDrpDwn= By.xpath("//a[text()='Data Structures']");
    By arrayDrpDwn= By.xpath("//a[text()='Arrays']");
    By linkedListDrpDwn= By.xpath("//a[text()='Linked List']");
    By stackDrpDwn= By.xpath("//a[text()='Stack']");
    By queueDrpDwn= By.xpath("//a[text()='Queue']");
    By treeDrpDwn= By.xpath("//a[text()='Tree']");
    By graphDrpDwn= By.xpath("//a[text()='Graph']");
    
    //Get Started Buttons on HomePage
    By dataStructuresGetStartedBtn= By.xpath("//h5[contains(text(),'Data Structures')]/parent::div/a[contains(text(),'Get Started')]");
    By arrayGetStartedBtn= By.xpath("//h5[contains(text(),'Array')]/parent::div/a[contains(text(),'Get Started')]");
    By linkedListGetStartedBtn= By.xpath("//h5[contains(text(),'Linked List')]/parent::div/a[contains(text(),'Get Started')]");
    By stackGetStartedBtn= By.xpath("//h5[contains(text(),'Stack')]/parent::div/a[contains(text(),'Get Started')]");
    By queueGetStartedBtn= By.xpath("//h5[contains(text(),'Queue')]/parent::div/a[contains(text(),'Get Started')]");
    By treeGetStartedBtn= By.xpath("//h5[contains(text(),'Tree')]/parent::div/a[contains(text(),'Get Started')]");
    By graphGetStartedBtn= By.xpath("//h5[contains(text(),'Graph')]/parent::div/a[contains(text(),'Get Started')]");
    
  
	public void clickGetStartedBtn() {
		driver.findElement(getStartedBtn).click();
	}
	
	public String getHomeLogInMsg() {
		return driver.findElement(homeLogInMsg).getText();
	}
	
	public void randomClickMethod() {
		driver.navigate().back();
		driver.findElement(randomClick).click();
	}
	public String launchURL() {
		return ConfigFileRdr.getDSAlgoURL();
	}
	
	public boolean dataStructuresDrpDwnDisplayed() {
		return driver.findElement(dataStructuresDrpDwn).isDisplayed();
	}
	
	public void dataStructuresDrpDwnClick() {
		driver.findElement(dataStructuresDrpDwn).click();
	}
	
	public void arrayDrpDwnClick() {
		driver.findElement(arrayDrpDwn).click();
	}
	
	public void linkedListDrpDwnClick() {
		driver.findElement(linkedListDrpDwn).click();
	}
	
	public void stackDrpDwnClick() {
		driver.findElement(stackDrpDwn).click();
	}
	
	public void queueDrpDwnClick() {
		driver.findElement(queueDrpDwn).click();
	}
	
	public void treeDrpDwnClick() {
		driver.findElement(treeDrpDwn).click();
	}
	
	public void graphDrpDwnClick() {
		driver.findElement(graphDrpDwn).click();
	}
	
	public void dataStructuresGetStartedBtnClick() {
		driver.findElement(dataStructuresGetStartedBtn).click();
	}
	
	public void arrayGetStartedBtnClick() {
		driver.findElement(arrayGetStartedBtn).click();
	}
	
	public void linkedListGetStartedBtnClick() {
		driver.findElement(linkedListGetStartedBtn).click();
	}
	
	public void stackGetStartedBtnClick() {
		driver.findElement(stackGetStartedBtn).click();
	}
	
	public void queueGetStartedBtnClick() {
		driver.findElement(queueGetStartedBtn).click();
	}
	
	public void treeGetStartedBtnClick() {
		driver.findElement(treeGetStartedBtn).click();
	}
	
	public void graphGetStartedBtnClick() {
		driver.findElement(graphGetStartedBtn).click();
	}

}
