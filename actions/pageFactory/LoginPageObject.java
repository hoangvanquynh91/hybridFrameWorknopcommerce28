package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class LoginPageObject extends BasePageFactory {
	private WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//button[contains(@class,'login-button')]")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMess;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]")
	private WebElement errorMessageUnsuceesful;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;

	public void clickToLoginButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public String getErrorMessageAtEmailTextBox() {
		// TODO Auto-generated method stub
		return getElementText(driver, emailErrorMess);
	}

	public void inputToEmailTextBox(String email) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, emailTextBox);
		senkeyToElement(driver, emailTextBox, email);
		
	}

	public String getErrorMessageUnsuccessfull() {
		// TODO Auto-generated method stub
		return getElementText(driver, errorMessageUnsuceesful);
	}

	public void inputToPasswordTextBox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, passwordTextBox);
		senkeyToElement(driver, passwordTextBox, password);
	}

}
