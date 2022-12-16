package com.nopcommrce.user;

import java.util.Random;

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

public class Level_07_Switch_Page extends BaseTest{
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
	  homePage = registerPage.clickToLogoutLink();
  }
  
  @Test
  public void User_02_Login () {
	  loginPage = homePage.openLoginPage();
	  loginPage.inputToEmailTextBox(emailAddress);
	  loginPage.inputToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  homePage = PageGeneratorManager.getUserHomePage(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
  }

  @Test
  public void User_03_My_Account() {
	  customerInfoPage = homePage.openMyAccountPage(driver);
	  Assert.assertTrue(customerInfoPage.isCustomerInfoPageDisplayed());
  }
  
  @Test
  public void User_04_Switch_Page () {  
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
  public void User_05_Switch_Role () {
	  //role User -> Role Admin
	  
	  //Role Admin -> Role User
	  
	  
  }
  
  @Test
  public void Login_06_Success() {
	  
	  
	  
	  
  }
  
  @AfterClass
  public void afterClass() {
	  //driver.quit();
  }
  
  

}
