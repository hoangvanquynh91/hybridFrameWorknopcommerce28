package nopCommerceDataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerceDataTableUI.NopAdminManagerCustomerAccountUI;

public class NopAdminManagerCustomerPageObject extends BasePage {
	WebDriver driver;

	public NopAdminManagerCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void closePopup() {
		waitToElementClickable(driver, NopAdminManagerCustomerAccountUI.CLOSE_BUTTON_ON_POPUP);
		clickToElement(driver, NopAdminManagerCustomerAccountUI.CLOSE_BUTTON_ON_POPUP);
		
	}

	public void searchByEmailAddress(String emailAddress) {
		waitForElementVisble(driver, NopAdminManagerCustomerAccountUI.EMAIL_ADDRESS_TEXT_BOX);
		sendkeyToElement(driver, NopAdminManagerCustomerAccountUI.EMAIL_ADDRESS_TEXT_BOX, emailAddress);
		
		waitToElementClickable(driver, NopAdminManagerCustomerAccountUI.SEARCH_BUTTON);
		clickToElement(driver, NopAdminManagerCustomerAccountUI.SEARCH_BUTTON);
	}
	
	public String getEmailAddressRegisterSuccess() {
		waitForElementVisble(driver, NopAdminManagerCustomerAccountUI.EMAIL_ADDRESS_REGISTER_SUCCESS);
		return getElementText(driver, NopAdminManagerCustomerAccountUI.EMAIL_ADDRESS_REGISTER_SUCCESS);
	}
	

}
