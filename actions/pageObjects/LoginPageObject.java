package pageObjects;

import org.openqa.selenium.WebDriver;

import PageUI.LoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getErrorMessageAtEmailTextBox() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, LoginPageUI.EMAIL_TEXT_BOX);
		senkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, emailAddress);
		
	}

	public void clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		
	}

	public String getErrorMessageUnsuccessfull() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFUL);
	}

	public void inputToPasswordTextBox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		senkeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
		
	}

	

}
