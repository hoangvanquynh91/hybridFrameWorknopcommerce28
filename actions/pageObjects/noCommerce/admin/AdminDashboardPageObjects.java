package pageObjects.noCommerce.admin;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.admin.AdminDashboardPageUI;
import commons.BasePage;

public class AdminDashboardPageObjects extends BasePage {
	WebDriver driver;

	public AdminDashboardPageObjects(WebDriver driver) {
		this.driver = driver;
	}
	public boolean isDashoardHeaderDisplay() {
		waitForElementVisble(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
		return isElementDisplay(driver, AdminDashboardPageUI.DASHBOARD_HEADER);
	}

}
