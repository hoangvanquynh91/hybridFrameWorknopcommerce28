package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.user.MyProductReviewPageUI;
import commons.BasePage;

public class UserMyProductReviewPageObject extends BasePage{
	WebDriver driver;

	public UserMyProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
