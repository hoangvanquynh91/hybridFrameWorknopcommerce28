package javaBasic;

public class DynamicLocatorEx {
	public static final String MY_PRODUCT_REVIEW_LINK = "xpath=//li[contains(@class,'acount-navigation')]/a[text()='My product reviews']";
	public static final String REWARD_POINT_LINK = "xpath=//li[contains(@class,'acount-navigation'')]/a[text()='Reward points']";
	public static final String ADDRESS_LINK = "xpath=//li[contains(@class,'acount-navigation'')]//a[text()='Addresses']";
	public static final String ORDER_LINK = "xpath=//li[contains(@class,'acount-navigation'')]/a[text()='Orders']";
	
	public static final String DYNAMIC_PAGE_NAME_LINK = "xpath=//li[contains(@class,'acount-navigation'')]/a[text()='%s']";
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		clickToLink(MY_PRODUCT_REVIEW_LINK);
		
		clickToDynamicLink(DYNAMIC_PAGE_NAME_LINK, "My product reviews");
		clickToDynamicLink(DYNAMIC_PAGE_NAME_LINK, "Reward points");
		clickToDynamicLink(DYNAMIC_PAGE_NAME_LINK, "Addresses");
		clickToDynamicLink(DYNAMIC_PAGE_NAME_LINK, "Orders");

	}
	private static void clickToLink(String locator) {
		
		System.out.println("Click to link " + locator);
	}
	
	private static void clickToDynamicLink(String dynamicLocator, String pageName) {
		String locator = String.format(dynamicLocator, pageName);
		System.out.println("Click to link " + locator);
	}

}
