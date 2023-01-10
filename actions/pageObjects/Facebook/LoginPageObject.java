package pageObjects.Facebook;

import org.openqa.selenium.WebDriver;

import PageUI.Facebook.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateNewAccountButton() {
		waitToElementClickable(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
		clickToElement(driver, LoginPageUI.CREATE_NEW_ACCOUNT_BUTTON);
	}

	public boolean isEmailAddresTextboxDisplay() {
		waitForElementVisble(driver, LoginPageUI.EMAIL_ADDRESS_TEXT_BOX);
		return isElementDisplay(driver, LoginPageUI.EMAIL_ADDRESS_TEXT_BOX);
	}
	

}
