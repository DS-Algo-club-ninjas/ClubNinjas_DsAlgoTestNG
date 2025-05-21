package Manager;

import PageObject.ArrayPageObject;
import PageObject.HomePageObject;
import PageObject.LoginPageObject;
import Utilities.ExcelReader;

public class PageObjectManager {
	private ArrayPageObject arrayPageObj;
	private HomePageObject homePageObj;
	private LoginPageObject loginPageObj;
	private ExcelReader readExcel;
	
	public ArrayPageObject getArrayPageObject(){
		return (arrayPageObj == null) ? arrayPageObj = new ArrayPageObject() : arrayPageObj;
	}
	
	public HomePageObject getHomePageObject(){
		return (homePageObj == null) ? homePageObj = new HomePageObject() : homePageObj;
	}
	
	public LoginPageObject getLoginPageObject(){
		return (loginPageObj == null) ? loginPageObj = new LoginPageObject() : loginPageObj;
	}
	
//	public ExcelReader getExcelReader(){
//		return (readExcel == null) ? readExcel = new ExcelReader() : readExcel;
//	}
}
