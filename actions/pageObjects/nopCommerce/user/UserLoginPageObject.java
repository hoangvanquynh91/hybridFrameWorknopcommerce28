package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopCommerce.user.LoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserLoginPageObject extends BasePage {
	private WebDriver driver;
	private WebDriverWait explicitWait;

	public UserLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public UserLoginPageObject(WebDriver driver, WebDriverWait explicitWait) {
		this.driver = driver;
		this.explicitWait = explicitWait;
	}

	public String getErrorMessageAtEmailTextBox() {
		// TODO Auto-generated method stub
		return getElementText(driver, LoginPageUI.EMAIL_ERROR_MESSAGE);
	}

	public void inputToEmailTextBox(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, LoginPageUI.EMAIL_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.EMAIL_TEXT_BOX, emailAddress);
		
	}

	public UserHomePageObject clickToLoginButton() {
		waitToElementClickable(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getUserHomePage(driver);
	}

	public String getErrorMessageUnsuccessfull() {
		return getElementText(driver, LoginPageUI.ERROR_MESSAGE_UNSUCCESSFUL);
	}

	public void inputToPasswordTextBox(String password) {
		waitForElementVisble(driver, LoginPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, LoginPageUI.PASSWORD_TEXT_BOX, password);
		
	}
	public UserHomePageObject loginAsUser(String emailAddress, String password) {
		// TODO Auto-generated method stub
		inputToEmailTextBox(emailAddress);
		inputToPasswordTextBox(password);
		return clickToLoginButton();
		
	}
	
}
