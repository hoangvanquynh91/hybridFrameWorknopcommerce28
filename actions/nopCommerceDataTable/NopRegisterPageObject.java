package nopCommerceDataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerceDataTableUI.NopRegisterUI;

public class NopRegisterPageObject extends BasePage {
	WebDriver driver;

	public NopRegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void createAccount(String firstName, String lastName, String emailAddress, String password) {
		waitForElementVisble(driver, NopRegisterUI.LOCATOR_TEXTBOX,"firstname");
		sendkeyToElement(driver, NopRegisterUI.LOCATOR_TEXTBOX, firstName, "firstname");
		
		waitForElementVisble(driver, NopRegisterUI.LOCATOR_TEXTBOX,"lastname");
		sendkeyToElement(driver, NopRegisterUI.LOCATOR_TEXTBOX, lastName, "lastname");
		
		waitForElementVisble(driver, NopRegisterUI.LOCATOR_TEXTBOX,"email_address");
		sendkeyToElement(driver, NopRegisterUI.LOCATOR_TEXTBOX, emailAddress, "email_address");
		
		waitForElementVisble(driver, NopRegisterUI.LOCATOR_TEXTBOX,"password");
		sendkeyToElement(driver, NopRegisterUI.LOCATOR_TEXTBOX, password, "password");
		
		waitForElementVisble(driver, NopRegisterUI.LOCATOR_TEXTBOX,"Confirm Password");
		sendkeyToElement(driver, NopRegisterUI.LOCATOR_TEXTBOX, password, "Confirm Password");
		
		waitToElementClickable(driver, NopRegisterUI.REGISTER_BUTTON);
		clickToElement(driver, NopRegisterUI.REGISTER_BUTTON);
		
	}

	public void openAdminPage() {
		openPageUrl(driver, NopRegisterUI.ADMIN_URL);
	}
	

}
