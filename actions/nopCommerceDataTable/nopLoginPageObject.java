package nopCommerceDataTable;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import nopCommerceDataTableUI.NopLoginPageUI;

public class nopLoginPageObject extends BasePage {
	WebDriver driver;

	public nopLoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateAccountButton() {
		waitToElementClickable(driver, NopLoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, NopLoginPageUI.CREATE_ACCOUNT_BUTTON);
		
	}
	

}
