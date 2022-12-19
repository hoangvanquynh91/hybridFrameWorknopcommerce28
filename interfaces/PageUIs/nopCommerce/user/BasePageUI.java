package PageUIs.nopCommerce.user;

public class BasePageUI {
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//li[contains(@class,'customer-reviews')]/a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//li[contains(@class,'reward-points')]/a[text()='Reward points']";
	public static final String CUSTOMER_INFO_LINK = "xpath=//li[contains(@class,'account-navigation')]/a[text()='Customer info']";
	public static final String CUSTOMER_INFO_HEADER = "xpath=//div[@class= 'page-title']/h1[text() = 'My account - Customer info']";
	//public static final String ADDRESS_LINK = "xpath=//li[contains(@class,'customer-addresses')]//a[text()='Addresses']";
	public static final String ADDRESS_LINK = "xpath=//div[contains(@class,'account-navigation')]//a[text()='Addresses']";
	public static final String MY_ACCOUNT_LINK = "xpath=//div[@class='header-links']//a[@class='ico-account']";
	public static final String ORDER_LINK = "xpath=//li[contains(@class,'customer-orders')]/a[text()='Orders']";
	public static final String DOWNLOAD_PRODUCT_LINK = "xpath=//li[contains(@class,'downloadable-products')]/a[text()='Downloadable products']";
	public static final String STOCK_SUBSCRIPTION_LINK = "xpath=//li[contains(@class,'back-in-stock-subscriptions')]/a[text()='Back in stock subscriptions']";
	public static final String CHANGE_MY_PASSWORD_LINK = "xpath=//li[contains(@class,'change-password')]/a[text()='Change password']";
	public static final String USER_LOGOUT_LINK = "xpath=//a[@class='ico-logout']";
	public static final String ADMIN_LOGOUT_LINK = "xpath=//a[text()='Logout']";
	public static final String DYNAMIC_PAGE_AT_MY_ACCOUNT_AREA = "xpath=//div[contains(@class,'account-navigation')]//a[text()='%s']";
	
}
