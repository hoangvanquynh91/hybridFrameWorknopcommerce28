package nopCommerceDataTable;

import org.openqa.selenium.WebDriver;

import nopCommerceDataTable.NopAdminLoginPageObject;


public class PageGeneratorManager {

	public static NopHomePageObject getNopHomePage(WebDriver driver) {
		return new NopHomePageObject(driver);
	}
	
	public static NopRegisterPageObject getNopRegisterPage(WebDriver driver) {
		return new NopRegisterPageObject(driver);
	}

	public static NopAdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new NopAdminLoginPageObject(driver);
	}
	
	public static NopAdminManagerCustomerPageObject getAdminManagerCustomerPage(WebDriver driver) {
		return new NopAdminManagerCustomerPageObject(driver);
	}
	
	public static nopLoginPageObject getnopLoginPage(WebDriver driver) {
		return new nopLoginPageObject(driver);
	}


}
