package com.nopcommrce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.GlobalConstants;
import commons.PageGeneratorManager;
import pageObjects.noCommerce.admin.AdminDashboardPageObjects;
import pageObjects.noCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObJect;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObjects;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;


public class Level_08_Switch_Role extends BaseTest{
      private WebDriver driver;
	  private String adminEmailAddress,adminPassword,userEmailAddress,userPassword;
	  private UserHomePageObject userHomePage;
	  private UserRegisterPageObject registerPage;
	  private UserLoginPageObject userLoginPage;
	  private UserCustomerInfoPageObjects userCustomerInfoPage;
	  private AdminLoginPageObject adminLoginPage;
	  private AdminDashboardPageObjects adminDashboardPage;
	  
	  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriverID(browserName);
	  userHomePage = PageGeneratorManager.getUserHomePage(driver);
	  adminEmailAddress = "admin@yourstore.com";
	  adminPassword = "admin";
      userEmailAddress = "hoangquynh1995@hotmail.vn";
      userPassword = "123456";
	  
  }
  @Test
  public void Role_01_User_To_Admin (){
	  userLoginPage = userHomePage.openLoginPage();
	  //Login as User role
	  userLoginPage.loginAsUser(userEmailAddress,userPassword);
	  Assert.assertTrue(userHomePage.isMyAccountLinkDisplayed());
	  
	  //Home Page -> Customer info page
	  userCustomerInfoPage = userHomePage.openMyAccountPage(driver);
	  
	  
	  //Customer info click logout -> Home Page
	  userHomePage = userCustomerInfoPage.clickToLogoutLinkAtUser(driver);
	  
	  // User HomePage -> Open Admin page -> Login Page (admin)
	  userHomePage.openPageUrl(driver, GlobalConstants.ADMIN_PAGE_URL);
	  adminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
	  
	  // Login as Admin Role
	  adminDashboardPage = adminLoginPage.loginAsAdmin(adminEmailAddress, adminPassword);
	  Assert.assertTrue(adminDashboardPage.isDashoardHeaderDisplay());
	  
	  //DashBoard -> Click v??o logout link -> Login Page  (Admin)
	  adminLoginPage = adminDashboardPage.clickToLogoutLinkAtAdmin(driver);
  }
  
  @Test
  public void User_02_Login_Admin_To_User () {
	  // Login Page (Admin) -> Open User URL
	  adminLoginPage.openPageUrl(driver, GlobalConstants.USER_PAGE_URL);
	  userHomePage= PageGeneratorManager.getUserHomePage(driver);
	  
	  // Home Page -> Login Page
  }

  @Test
  public void User_03_My_Account() {
	 
  }
  
  @Test
  public void User_04_Switch_Page () {  
	
  }
  
  @Test
  public void User_05_Switch_Role () {
	  //role User -> Role Admin
	  
	  //Role Admin -> Role User
	  
	  
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  

}
