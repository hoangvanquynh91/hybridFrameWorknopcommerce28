package pageObjectJQuery;

import org.openqa.selenium.WebDriver;

import PageUIs.JQuery.NopHomePageUI;
import commons.BasePage;

public class NopHomePageObject extends BasePage {
	WebDriver driver;

	public NopHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToMyAccountLink() {
		waitToElementClickable(driver, NopHomePageUI.MY_ACOUNT_LINK);
		clickToElement(driver, NopHomePageUI.MY_ACOUNT_LINK);
	}

	

}
