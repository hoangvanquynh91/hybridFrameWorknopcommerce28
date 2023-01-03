package pageObjectJQuery;

import org.openqa.selenium.WebDriver;

import PageUIs.JQuery.NopHomePageUI;
import PageUIs.JQuery.NopLoginPageUI;
import commons.BasePage;

public class LoginPageObject extends BasePage {
	WebDriver driver;

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToCreateAccountButton() {
		waitToElementClickable(driver, NopLoginPageUI.CREATE_ACCOUNT_BUTTON);
		clickToElement(driver, NopLoginPageUI.CREATE_ACCOUNT_BUTTON);
		
	}
	

}
