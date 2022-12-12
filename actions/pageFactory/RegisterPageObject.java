package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject extends BasePageFactory{
private WebDriver driver;
	
	
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath = "//button[@id='register-button']")
	private WebElement registerButton;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	private WebElement firstNameTextBox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	private WebElement lastNameTextBox;
	
	@FindBy(xpath = "//input[@id='Email']")
	private WebElement emailTextBox;
	
	@FindBy(xpath = "//input[@id='Password']")
	private WebElement passwordTextBox;

	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	private WebElement confirmPasswordTextBox;

	@FindBy(xpath = "//span[@id='FirstName-error']")
	private WebElement firstNameErrorMess;

	@FindBy(xpath = "//span[@id='LastName-error']")
	private WebElement lastNameErrorMess;

	@FindBy(xpath = "//span[@id='Email-error']")
	private WebElement emailErrorMess;

	@FindBy(xpath = "//span[@id='Password-error']")
	private WebElement passwordErrorMess;

	@FindBy(xpath = "//span[@id='ConfirmPassword-error']")
	private WebElement confirmPasswordErrorMess;

	@FindBy(xpath = "//div[@class='result']")
	private WebElement registerSuccesMess;

	@FindBy(xpath = "//a[@class='ico-logout']")
	private WebElement logoutLink;

	@FindBy(xpath = "//div[contains(@class,'validation-summary-errors')]//li")
	private WebElement exitingEmailMess;



	public void inputToFirstNameTextBox(String firstName) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, firstNameTextBox);
		senkeyToElement(driver, firstNameTextBox, firstName);
	}


	public void inputToLastNameTextBox(String lastName) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, lastNameTextBox);
		senkeyToElement(driver, lastNameTextBox, lastName);
		
	}
	public void inputToEmailextBox(String emailAddress) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, emailTextBox);
		senkeyToElement(driver, emailTextBox, emailAddress);
	}


	public void inputToPasswordTextBox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, passwordTextBox);
		senkeyToElement(driver, passwordTextBox, password);
		
	}


	public void inputToConfirmPasswordTextBox(String password) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, confirmPasswordTextBox);
		senkeyToElement(driver, confirmPasswordTextBox, password);
		
	}


	public void clickToRegisterButton() {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
		
	}


	public String getRegisterSuccessMessage() {
		// TODO Auto-generated method stub
		return  getElementText(driver, registerSuccesMess);
		
	}


	public void clickToLogoutLink() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, logoutLink);
		clickToElement(driver, logoutLink);
		
	}

}
