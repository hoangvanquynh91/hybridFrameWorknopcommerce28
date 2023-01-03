package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectJQuery.LoginPageObject;
import pageObjectJQuery.NopAdminLoginPageObject;
import pageObjectJQuery.NopHomePageObject;
import pageObjectJQuery.NopRegisterPageObject;
import pageObjectJQuery.PageGeneratorManager;


public class NopcommerTable extends BaseTest {
	WebDriver driver;
	NopHomePageObject nopHomePage;
	NopRegisterPageObject nopRegisterPage;
	LoginPageObject nopLoginPage;
	NopAdminLoginPageObject nopAdminLoginPage;
	private String firstName = "Nguyen";
	private String lastName = "Van A";
	private String emailAddress = "Automation321@gmail.com";
	private String password = "123456";
	private String adminUserName = "user01";
	private String adminPasswrod = "guru99com";
	
	 @Parameters({"browser","url"})
	  @BeforeClass
	  public void beforeClass(String browserName, String appUrl) {
		  driver = getBrowserDriverJQueryID(browserName, appUrl);
		  nopHomePage = PageGeneratorManager.getNopHomePage(driver);
		  
	  }
	 @Test
	 public void TC01_Register() {
		 nopHomePage.clickToMyAccountLink();
		 nopLoginPage = PageGeneratorManager.getNopLoginPage(driver);
		 nopLoginPage.clickToCreateAccountButton();
		 nopRegisterPage = PageGeneratorManager.getNopRegisterPage(driver);
		 nopRegisterPage.createAccount(firstName,lastName,emailAddress,password);
	 }
	 
	 public void TC02_Verify_Created_Acoount() {
		 nopRegisterPage.openAdminPage();
		 nopAdminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		 nopAdminLoginPage.loginAdminPage(adminUserName,adminPasswrod);
		 
		 
	 }

}
