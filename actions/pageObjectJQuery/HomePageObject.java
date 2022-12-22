package pageObjectJQuery;

import org.openqa.selenium.WebDriver;

import PageUIs.JQuery.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitToElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, HomePageUI.HEARDER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEARDER_TEXTBOX_BY_LABEL, value,headerLabel);
		
	}
	
	
	
}
