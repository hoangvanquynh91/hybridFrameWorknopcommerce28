package com.nopcommrce.user;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import pageObjects.LoginPageObject;

public class Level_03_Pase_Object_02_Login {
      private WebDriver driver;
	  private String firstName,lastName ,exitingEmail,invalidEmail,notFoundEmail,password,incorrectPassword;
	  private String projectPath = System.getProperty("user.dir");
	  private HomePageObject homePage;
	  private RegisterPageObject registerPage;
	  private LoginPageObject loginPage;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.edge.driver",projectPath+"\\browerDrivers\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  
	  firstName = "Automation";
	  lastName = "FC";
	  invalidEmail = "abc@abc.com@emf.vnvnvn";
	  notFoundEmail = "afc" + generaterFakeNumber()+"@hotmail.vn";
      exitingEmail = "afc" + generaterFakeNumber()+"@hotmail.vn";
      password = "123456";
      incorrectPassword = "987654";
	  
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
	  homePage = new HomePageObject(driver);
	  System.out.println("Register_03 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
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
	  
	  homePage = new HomePageObject(driver);
  }

  
  @Test
  public void Login_01_Empty_Data (){
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Please enter your email");
	  
  }
  
  @Test
  public void Login_02_Invalid_Email () {
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToEmailTextBox(invalidEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageAtEmailTextBox(), "Wrong email");
  }

  @Test
  public void Login_03_Email_Not_Found () {
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToEmailTextBox(notFoundEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");
	 
  }
  
  @Test
  public void Login_04_Exiting_Email_Empty_Password () {  
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.clickToLoginButton();
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
	  
  }
  
  @Test
  public void Login_05_Exiting_Email_Incorrect_Passwor () {
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.inputToPasswordTextBox(incorrectPassword);
	  loginPage.clickToLoginButton();
	  
	  Assert.assertEquals(loginPage.getErrorMessageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");
	  
  }
  
  @Test
  public void Login_06_Success() {
	  homePage.clickToLoginLink();
	  
	  loginPage = new LoginPageObject(driver);
	  loginPage.inputToEmailTextBox(exitingEmail);
	  loginPage.inputToPasswordTextBox(password);
	  loginPage.clickToLoginButton();
	  
	  homePage = new HomePageObject(driver);
	  Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	  
  }
  
  public int generaterFakeNumber() {
	  Random ran = new Random();
	  return ran.nextInt(9999);
  }
  
  @AfterClass
  public void afterClass() {
	  driver.quit();
  }
  
  

}
