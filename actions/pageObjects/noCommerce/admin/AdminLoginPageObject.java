package pageObjects.noCommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.admin.AdminLoginPageUI;
import commons.BasePage;
import commons.PageGeneratorManager;

public class AdminLoginPageObject extends BasePage{
	WebDriver driver;

	public AdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToEmailTextBox(String adminEmail) {
		waitForElementVisble(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, adminEmail);
		
	}

	public void inputToPasswordTextBox(String adminPassword) {
		waitForElementVisble(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, adminPassword);
	}

	public AdminDashboardPageObjects clickLoginButton() {
		waitToElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashboardPage(driver);
	}
	
	public AdminDashboardPageObjects loginAsAdmin(String email, String password) {
		inputToEmailTextBox(email);
		inputToPasswordTextBox(password);
		return clickLoginButton();
	}
	

}
