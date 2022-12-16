package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.user.BasePageUI;
import commons.BasePage;

public class UserCustomerInfoPageObjects extends BasePage{
	WebDriver driver;
	public UserCustomerInfoPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isCustomerInfoPageDisplayed() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.CUSTOMER_INFO_HEADER);
		return isElementDisplay(driver, BasePageUI.CUSTOMER_INFO_HEADER);
	}
}
