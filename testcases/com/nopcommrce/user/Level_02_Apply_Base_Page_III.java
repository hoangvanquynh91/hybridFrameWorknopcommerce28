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

public class Level_02_Apply_Base_Page_III extends BasePage {
	WebDriver driver;
	String emailAddress;
	String projectPath = System.getProperty("user.dir");
	Actions action;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.edge.driver",projectPath+"\\browerDrivers\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  

	  emailAddress = "afc" + generaterFakeNumber()+"@hotmail.vn";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }

  
  @Test
  public void TC_01_Register_Empty_Data() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  waitToElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  Assert.assertEquals(getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
	  
  }
  
  @Test
  public void TC_02_Register_Invalid_Email() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  senkeyToElement(driver, "//input[@id='Email']", "12346#9852@$aufhsaf$$$hsa");
	  senkeyToElement(driver, "//input[@id='Password']", "123456");
	  senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  waitToElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  

	  Assert.assertEquals(getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
	  
	  
  }

  @Test
  public void TC_03_Register_Success() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  senkeyToElement(driver, "//input[@id='Password']", "123456");
	  senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  waitToElementClickable(driver, "//button[@id='register-button']");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(getElementText(driver,"//div[@class='result']"), "Your registration completed");
	  
	  waitToElementClickable(driver, "//a[@class='ico-logout']");
	  clickToElement(driver, "//a[@class='ico-logout']");
	 
  }
  
  @Test
  public void TC_04_Register_Existing_Email() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  senkeyToElement(driver, "//input[@id='Password']", "123456");
	  senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	 
	  waitToElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver, "//div[contains(@class,'validation-summary-errors')]"), "The specified email already exists");
	  
	  
	  
  }
  
  @Test
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  senkeyToElement(driver, "//input[@id='Password']", "123");
	  senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

	  
	  waitToElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver,"//span[@id='Password-error']"),
			  "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password() {
	  waitToElementClickable(driver, "//a[@class='ico-register']");
	  clickToElement(driver, "//a[@class='ico-register']");
	  
	  senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  senkeyToElement(driver, "//input[@id='Password']", "123456");
	  senkeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");
	  
	  waitToElementClickable(driver, "//button[@id='register-button']");
	  clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(getElementText(driver,"//span[@id='ConfirmPassword-error']"),
			  "The password and confirmation password do not match.");
	  
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
