package com.nopcommrce.user;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Multiple_Brower extends BaseTest {
	  private HomePageObject homePage;
	  private RegisterPageObject registerPage;
	  private WebDriver driver;
	  private String firstName,lastName ,emailAddress,password;
	  
  @Parameters("browser")
  @BeforeClass
  public void beforeClass(String browserName) {
	  driver = getBrowserDriver(browserName);
	  firstName = "Automation";
	  lastName = "FC";
      emailAddress = "afc" + generaterFakeNumber()+"@hotmail.vn";
      password = "123456";
      homePage = new HomePageObject(driver);
  }

  
  @Test
  public void Register_01_Empty_Data() {
	  System.out.println("Register_01 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_01 - Step 2 : Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  
	  System.out.println("Register_01 - Step 3 : Vertify error messsgage displayed");
	  Assert.assertEquals(registerPage.getErrorMesssageAtFirstName(), "First name is required.");
	  Assert.assertEquals(registerPage.getErrorMesssageAtLastName(), "Last name is required.");
	  Assert.assertEquals(registerPage.getErrorMesssageAtEmail(), "Email is required.");
	  Assert.assertEquals(registerPage.getErrorMesssageAtPassword(), "Password is required.");
	  Assert.assertEquals(registerPage.getErrorMesssageAtConfirmPassword(), "Password is required.");
	  
  }
  
  @Test
  public void Register_02_Invalid_Email() {
	  System.out.println("Register_02 - Step 1 Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_02 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox("12346#9852@$aufhsaf$$$hsa");
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(password);
	  
	  System.out.println("Register_02 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register_02 - Step 4 : Vertify error messsgage displayed");
	  Assert.assertEquals(registerPage.getErrorMesssageAtEmail(), "Wrong email");
	  
	  
  }

  @Test
  public void Register_03_Success() {
	  System.out.println("Register_03 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_03 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(emailAddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(password);
	  
	  System.out.println("Register_03 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register_03 - Step 4 : Verify success message displayed");
	  Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	  
	  System.out.println("Register_03 - Step 5 : Click to Logout Link");
	  registerPage.clickToLogoutLink();
	 
  }
  
  @Test
  public void Register_04_Existing_Email() {  
	  System.out.println("Register_04 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_04 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(emailAddress);
	  registerPage.inputToPasswordTextBox(password);
	  registerPage.inputToConfirmPasswordTextBox(password);
	 
	  System.out.println("Register_04 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMessageExitingEmail(), "The specified email already exists");
	  
	  
	  
  }
  
  @Test
  public void Register_05_Password_Less_Than_6_Chars() {
	  System.out.println("Register_05 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_05 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(emailAddress);
	  registerPage.inputToPasswordTextBox("123");
	  registerPage.inputToConfirmPasswordTextBox("123");

	  System.out.println("Register_05 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();

	  System.out.println("Register_05 - Step 4 : Vertify password Less Than 6 Chars ");
	  Assert.assertEquals(registerPage.getErrorMesssageAtPassword(), "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void Register_06_Invalid_Confirm_Password() {
	  System.out.println("Register_06 - Step 1 : Click to register link");
	  homePage.clickToRegisterLink();
	  registerPage = new RegisterPageObject(driver);
	  System.out.println("Register_06 - Step 2 Input to require filed");
	  registerPage.inputToFirstNameTextBox(firstName);
	  registerPage.inputToLastNameTextBox(lastName);
	  registerPage.inputToEmailextBox(emailAddress);
	  registerPage.inputToPasswordTextBox("123456");
	  registerPage.inputToConfirmPasswordTextBox("654321");
	  
	  System.out.println("Register_06 - Step 3 : Click to register button");
	  registerPage.clickToRegisterButton();
	  
	  Assert.assertEquals(registerPage.getErrorMesssageAtConfirmPassword(), "The password and confirmation password do not match.");
	  
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
