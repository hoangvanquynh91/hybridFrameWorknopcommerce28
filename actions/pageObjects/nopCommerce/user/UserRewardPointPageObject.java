package pageObjects.nopCommerce.user;

import org.openqa.selenium.WebDriver;

import PageUIs.nopCommerce.user.RewardPointPageUI;
import commons.BasePage;

public class UserRewardPointPageObject extends BasePage{
	WebDriver driver;

	public UserRewardPointPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
