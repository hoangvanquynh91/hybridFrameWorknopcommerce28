package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.user.RegisterPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class UserRegisterPageObject extends BasePage{
	private WebDriver driver;
	
	
	public UserRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, RegisterPageUI.REGISTER_BUTTON);
		clickToElement(driver, RegisterPageUI.REGISTER_BUTTON);
	}

	public String getErrorMesssageAtFirstName() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.FIRST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMesssageAtLastName() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.LAST_NAME_ERROR_MESSAGE);
	}

	public String getErrorMesssageAtEmail() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.EMAIL_ERROR_MESSAGE);
	}
	public String getErrorMesssageAtPassword() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.PASSWORD_ERROR_MESSAGE);
	}

	public String getErrorMesssageAtConfirmPassword() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return getElementText(driver, RegisterPageUI.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}

	public void inputToFirstNameTextBox(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.FIRST_NAME_TEXTBOX, firstName);
		
	}

	public void inputToLastNameTextBox(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.LAST_NAME_TEXTBOX, lastName);
		
	}

	public void inputToEmailextBox(String email) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.EMAIl_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.EMAIl_TEXTBOX, email);
		
	}

	public void inputToPasswordTextBox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.PASSWORRD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.PASSWORRD_TEXTBOX, password);
		
	}

	public void inputToConfirmPasswordTextBox(String confrimPassword) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.CONFIRM_PASSWORRD_TEXTBOX);
		sendkeyToElement(driver, RegisterPageUI.CONFIRM_PASSWORRD_TEXTBOX, confrimPassword);
		
	}

	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
		return getElementText(driver, RegisterPageUI.REGISTER_SUCCESS_MESSAGE);
	}

	public UserHomePageObject clickToLogoutLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, RegisterPageUI.LOGOUT_LINK);
		clickToElement(driver, RegisterPageUI.LOGOUT_LINK);
		//2
		//return new HomePageObject(driver);
		//3
		return PageGeneratorManager.getUserHomePage(driver);
		
	}
	public UserHomePageObject clickToLoginLink() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, RegisterPageUI.LOGIN_LINK);
		clickToElement(driver, RegisterPageUI.LOGIN_LINK);
		//2
		//return new HomePageObject(driver);
		//3
		return PageGeneratorManager.getUserHomePage(driver);
		
	}

	public String getErrorMessageExitingEmail() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, RegisterPageUI.EXITING_EMAIL_MESSAGE);
		return getElementText(driver, RegisterPageUI.EXITING_EMAIL_MESSAGE);
	}

}
