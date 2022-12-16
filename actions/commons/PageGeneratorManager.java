package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.noCommerce.admin.AdminDashboardPageObjects;
import pageObjects.noCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObJect;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptonsPageObjects;
import pageObjects.nopCommerce.user.UserChangeMyPasswordPageObjects;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObjects;
import pageObjects.nopCommerce.user.UserDownloadAbleProductsPageObjects;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrderPage;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class PageGeneratorManager {
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	public static UserLoginPageObject getUserLoginPage(WebDriver driver) {
		return new UserLoginPageObject(driver);
	}
	
	public static UserRegisterPageObject getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPageObject(driver);
	}
	
	public static UserAddressPageObJect getUserAddressPage(WebDriver driver) {
		return new UserAddressPageObJect(driver);
	}
	public static UserBackInStockSubscriptonsPageObjects getBackInStockSubscriptonsPage(WebDriver driver) {
		return new UserBackInStockSubscriptonsPageObjects(driver);
	}
	
	public static UserChangeMyPasswordPageObjects getUserChangeMyPasswordPage(WebDriver driver) {
		return new UserChangeMyPasswordPageObjects(driver);
	}
	
	public static UserCustomerInfoPageObjects getUserCustomerInfoPage(WebDriver driver) {
		return new UserCustomerInfoPageObjects(driver);
	}
	public static UserDownloadAbleProductsPageObjects getUserDownloadAbleProductsPage(WebDriver driver) {
		return new UserDownloadAbleProductsPageObjects(driver);
	}
	
	public static UserMyProductReviewPageObject getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPageObject(driver);
	}
	
	public static UserOrderPage getUserOrderPage(WebDriver driver) {
		return new UserOrderPage(driver);
	}
	
	public static UserRewardPointPageObject getUserRewardPointPage(WebDriver driver) {
		return new UserRewardPointPageObject(driver);
	}

	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	
	public static AdminDashboardPageObjects getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObjects(driver);
	}
	
	
	
	
	
}
