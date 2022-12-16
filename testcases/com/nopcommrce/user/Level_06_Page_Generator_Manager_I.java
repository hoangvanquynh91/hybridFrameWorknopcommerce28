package com.nopcommrce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_06_Page_Generator_Manager_I extends BaseTest{
      private WebDriver driver;
	  private String firstName,lastName ,exitingEmail,invalidEmail,notFoundEmail,password,incorrectPassword;
	  private UserHomePageObject homePage;
	  private UserRegisterPageObject registerPage;
	  private UserLoginPageObject loginPage;
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  
	  firstName = "Automation";
	  lastName = "FC";
	  invalidEmail = "abc@abc.com@emf.vnvnvn";
	  notFoundEmail = "afc" + generaterFakeNumber()+"@hotmail.vn";
      exitingEmail = "afc" + generaterFakeNumber()+"@hotmail.vn";
      password = "123456";
      incorrectPassword = "987654";
	  
	  homePage = new UserHomePageObject(driver);
	  System.out.println("Register_03 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new UserRegisterPageObject(driver);
	  System.out.println("Register_03 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(exitingEmail);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(password);
	  
	  System.out.println("Register_03 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register_03 - Step 4 : Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Register_03 - Step 5 : Click to Logout Link");
	  registerPage.clickToLogoutLink();
	  
	  homePage = new UserHomePageObject(driver);
  }

  
  @Test
  public void Login_01_Empty_Data (){
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	  
  }
  
  @Test
  public void Login_02_Invalid_Email () {
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.inputToEmailTextBox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
  }

  @Test
  public void Login_03_Email_Not_Found () {
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.inputToEmailTextBox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	 
  }
  
  @Test
  public void Login_04_Exiting_Email_Empty_Password () {  
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
	  
  }
  
  @Test
  public void Login_05_Exiting_Email_Incorrect_Passwor () {
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.inputToPasswordTextBox(incorrectPassword);
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  
  @Test
  public void Login_06_Success() {
	  homePage.openLoginPage();
	  
	  loginPage = new UserLoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.inputToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  
	  homePage = new UserHomePageObject(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  

}
