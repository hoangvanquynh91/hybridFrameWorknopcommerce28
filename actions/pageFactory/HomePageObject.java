package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import PageUIs.nopCommerce.user.HomePageUI;
import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		
	}
	//Page UI
	@FindBy(how = How.XPATH, using = "//a[@class='ico-register']")
	private WebElement registerLink;
	
	@FindBy(xpath = "//div[@class='header-links']//a[@class='ico-login']")
	private WebElement loginLink;
	
	@FindBy(css= "a[class='ico-account']")
	private WebElement myAccountLink;

	public void clickToRegisterLink() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, registerLink);
		clickToElement(driver, registerLink);
		
	}

	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, loginLink);
		clickToElement(driver, loginLink);
		
	}

	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		return isElementDisplay(driver, myAccountLink);
	}
	
	//Page actions
	
	
}
