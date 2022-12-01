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

public class Level_02_Apply_Base_Page_1 {
	WebDriver driver;
	String emailAddress;
	BasePage basePage;
	String projectPath = System.getProperty("user.dir");
	Actions action;
  @BeforeClass
  public void beforeClass() {
	  System.setProperty("webdriver.edge.driver",projectPath+"\\browerDrivers\\msedgedriver.exe");
	  driver = new EdgeDriver();
	  basePage = new BasePage();
	  emailAddress = "afc" + generaterFakeNumber()+"@hotmail.vn";
	  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	  driver.get("https://demo.nopcommerce.com/");
  }

  
 
  public void TC_01_Register_Empty_Data() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='FirstName-error']"), "First name is required.");
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='LastName-error']"), "Last name is required.");
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Email is required.");
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Password-error']"), "Password is required.");
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"), "Password is required.");
	  
  }
  
  
  public void TC_02_Register_Invalid_Email() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.senkeyToElement(driver, "//input[@id='Email']", "12346#9852@$aufhsaf$$$hsa");
	  basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
	  basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");

	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  

	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='Email-error']"), "Wrong email");
	  
	  
  }

  
  public void TC_03_Register_Success() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
	  basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	  
	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	  
	  basePage.waitToElementClickable(driver, "//a[@class='ico-logout']");
	  basePage.clickToElement(driver, "//a[@class='ico-logout']");
	 
  }
  
 
  public void TC_04_Register_Existing_Email() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
	  basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
	 
	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'validation-summary-errors')]"), "The specified email already exists");
	  
	  
	  
  }
  
  
  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.senkeyToElement(driver, "//input[@id='Password']", "123");
	  basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "123");

	  
	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@class='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver,"//spanơ@id='Password-error'ư"),
			  "Password must meet the following rules:\nmust have at least 6 characters");
  }
  
  @Test
  public void TC_06_Register_Invalid_Confirm_Password() {
	  basePage.waitToElementClickable(driver, "//a[@class='ico-register']");
	  basePage.clickToElement(driver, "//a[@class='ico-register']");
	  
	  basePage.senkeyToElement(driver, "//input[@id='FirstName']", "Automation");
	  basePage.senkeyToElement(driver, "//input[@id='LastName']", "FC");
	  basePage.senkeyToElement(driver, "//input[@id='Email']", emailAddress);
	  basePage.senkeyToElement(driver, "//input[@id='Password']", "123456");
	  basePage.senkeyToElement(driver, "//input[@id='ConfirmPassword']", "654321");
	  
	  basePage.waitToElementClickable(driver, "//button[@id='register-button']");
	  basePage.clickToElement(driver, "//button[@id='register-button']");
	  
	  Assert.assertEquals(basePage.getElementText(driver,"//span[@id='ConfirmPassword-error']"),
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
