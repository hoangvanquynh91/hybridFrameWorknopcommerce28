package pageObjectJQuery;

import org.openqa.selenium.WebDriver;


public class PageGeneratorManager {
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	
	public static NopHomePageObject getNopHomePage(WebDriver driver) {
		return new NopHomePageObject(driver);
	}
	
	public static NopRegisterPageObject getNopRegisterPage(WebDriver driver) {
		return new NopRegisterPageObject(driver);
	}
	
	public static LoginPageObject getNopLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static NopAdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new NopAdminLoginPageObject(driver);
	}

}
