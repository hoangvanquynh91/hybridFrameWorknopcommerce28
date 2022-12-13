package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.server.handler.GetElementLocation;

import PageUI.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage{
	private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public RegisterPageObject clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.REGISTER_LINK);
		clickToElement(driver, HomePageUI.REGISTER_LINK);
		//2
		//return new RegisterPageObject(driver);
		//3
		return PageGeneratorManager.getRegisterPage(driver);
	}

	public LoginPageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, HomePageUI.LOGIN_LINK);
		clickToElement(driver, HomePageUI.LOGIN_LINK);
		//2
		//return new LoginPageObject(driver);
		//3 
		return PageGeneratorManager.getLoginPage(driver);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, HomePageUI.MY_ACCOUNT_LINK);
		return isElementDisplay(driver, HomePageUI.MY_ACCOUNT_LINK);
	}

	

	
	

}
