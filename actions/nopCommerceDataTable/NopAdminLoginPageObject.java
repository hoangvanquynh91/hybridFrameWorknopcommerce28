package nopCommerceDataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerceDataTableUI.NopAdminPageUI;

public class NopAdminLoginPageObject extends BasePage {
	WebDriver driver;

	public NopAdminLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void loginAdminPage(String adminUserName, String adminPassword) {
		waitForElementVisble(driver, NopAdminPageUI.USER_NAME_TEXT_BOX);
		sendkeyToElement(driver, NopAdminPageUI.USER_NAME_TEXT_BOX, adminUserName);
		
		waitForElementVisble(driver, NopAdminPageUI.PASSWORD_TEXT_BOX);
		sendkeyToElement(driver, NopAdminPageUI.PASSWORD_TEXT_BOX, adminPassword);
		
		waitToElementClickable(driver, NopAdminPageUI.LOGIN_BUTTON);
		clickToElement(driver, NopAdminPageUI.LOGIN_BUTTON);
	}

}
