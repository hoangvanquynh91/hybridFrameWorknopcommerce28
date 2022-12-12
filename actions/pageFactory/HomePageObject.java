package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import commons.BasePageFactory;

public class HomePageObject extends BasePageFactory {
private WebDriver driver;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
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
		
	}

	public void clickToLoginLink() {
		// TODO Auto-generated method stub
		
	}

	public boolean isMyAccountLinkDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	
	//Page actions
	
	
}
