package com.nopcommrce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObJect;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObjects;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_09_Dynamic_Locator extends BaseTest{
      private WebDriver driver;
	  private String firstName,lastName ,emailAddress,password;
	  private UserHomePageObject homePage;
	  private UserRegisterPageObject registerPage;
	  private UserLoginPageObject loginPage;
	  private UserCustomerInfoPageObjects customerInfoPage;
	  private UserAddressPageObJect addressPage;
	  private UserMyProductReviewPageObject myProductReviewPage;
	  private UserRewardPointPageObject rewardPointPage;
	  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  firstName = "Automation";
	  lastName = "FC";
      emailAddress = "afc" + generaterFakeNumber()+"@hotmail.vn";
      password = "123456";
	  homePage = PageGeneratorManager.getUserHomePage(driver);
  }
  @Test
  public void User_01_Register (){
	  registerPage = homePage.clickToRegisterLink();
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(emailAddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(password);
	  registerPage.clickToRegisterButton();
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  homePage = registerPage.clickToLoginLink();
	  
	  loginPage = homePage.openLoginPage();
	  loginPage.inputToEmailTextBox(emailAddress);
	  loginPage.inputToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
	  customerInfoPage = homePage.openMyAccountPage(driver);
	  Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
  }
  
  
  public void User_02_Switch_Page () {  
	  //Customer Info -> Address
	  addressPage = customerInfoPage.openAddressPage(driver);
	  
	  //Address -> My Product review
	  myProductReviewPage = addressPage.openMyProductReviewPage(driver);
	  
	  //My Product review -> Reward Point
	  rewardPointPage = myProductReviewPage.openRewardPoinPage(driver);
	  // Reward Point -> Address
	  addressPage = rewardPointPage.openAddressPage(driver);
	  //Address -> Reward Point
	  rewardPointPage= addressPage.openRewardPoinPage(driver);
	  //Reward Point -> My Product review
	  myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);
  }
  
  @Test
  public void User_03_Dynamic_Page () {  
	  //Customer Info -> Address
	  addressPage = (UserAddressPageObJect) customerInfoPage.openPageAtMyAccountPageByName(driver,"Addresses");
	  
	  //Address -> My Product review
	  myProductReviewPage = (UserMyProductReviewPageObject) addressPage.openPageAtMyAccountPageByName(driver,"My product reviews");
	  
	  //My Product review -> Reward Point
	  rewardPointPage = (UserRewardPointPageObject) myProductReviewPage.openPageAtMyAccountPageByName(driver,"Reward points");
	  // Reward Point -> Address
	  addressPage = (UserAddressPageObJect) rewardPointPage.openPageAtMyAccountPageByName(driver,"Addresses");
	  //Address -> Reward Point
	  rewardPointPage= (UserRewardPointPageObject) addressPage.openPageAtMyAccountPageByName(driver,"Reward points");
	  //Reward Point -> My Product review
	  myProductReviewPage = (UserMyProductReviewPageObject) rewardPointPage.openPageAtMyAccountPageByName(driver,"My product reviews");
  }
  
  @Test
  public void User_03_Dynamic_Page2 () {  
	  //My Product review -> Customer Info
	  myProductReviewPage.openPageAtMyAccountPageByName(driver, "Customer info");
	  customerInfoPage = PageGeneratorManager.getUserCustomerInfoPage(driver);
	  
	  
	  
	  //Customer Info -> Address
	  customerInfoPage.openPageAtMyAccountPageByName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getUserAddressPage(driver);
	 
	  
	  //Address -> My Product review
	  addressPage.openPageAtMyAccountPageByName(driver,"My product reviews");
	  myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
	  
	  //My Product review -> Reward Point
	  myProductReviewPage.openPageAtMyAccountPageByName(driver, "Reward points");
	  rewardPointPage = PageGeneratorManager.getUserRewardPointPage(driver);
	 
	  // Reward Point -> Address
	  rewardPointPage.openPageAtMyAccountPageByName(driver, "Addresses");
	  addressPage = PageGeneratorManager.getUserAddressPage(driver);
	  //Address -> Reward Point
	  addressPage.openPageAtMyAccountPageByName(driver, "Reward points");
	  rewardPointPage= PageGeneratorManager.getUserRewardPointPage(driver);
	  //Reward Point -> My Product review
	  rewardPointPage.openPageAtMyAccountPageByName(driver, "My product reviews");
	  myProductReviewPage = PageGeneratorManager.getUserMyProductReviewPage(driver);
  }
  
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  

}
