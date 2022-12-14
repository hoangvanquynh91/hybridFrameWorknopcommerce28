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

public class Level_01_Register_DRY {
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
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#FirstName-error")).getText(), "First name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#LastName-error")).getText(), "Last name is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Email is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(), "Password is required.");
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(), "Password is required.");
	  
  }
  

  public void TC_02_Register_Invalid_Email() {
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys("12346#9852@$aufhsaf$$$hsa");
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Email-error")).getText(), "Wrong email");
  }

  public void TC_03_Register_Success() {
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.result")).getText(), "Your registration completed");
	  
	  driver.findElement(By.cssSelector("a.ico-logout")).click();
  }
  

  public void TC_04_Register_Existing_Email() {
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123456");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("div.validation-summary-errors  li")).getText(), "The specified email already exists"); 
  }
  

  public void TC_05_Register_Password_Less_Than_6_Chars() {
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("123");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#Password-error")).getText(),
			  "Password must meet the following rules:\nmust have at least 6 characters");
  }
  

  public void TC_06_Register_Invalid_Confirm_Password() {
	  driver.findElement(By.xpath("//a[@class=\"ico-register\"]")).click();
	  driver.findElement(By.cssSelector("input#FirstName")).sendKeys("Automation");
	  driver.findElement(By.cssSelector("input#LastName")).sendKeys("FC");
	  driver.findElement(By.cssSelector("input#Email")).sendKeys(emailAddress);
	  driver.findElement(By.cssSelector("input#Password")).sendKeys("123456");
	  driver.findElement(By.cssSelector("input#ConfirmPassword")).sendKeys("656432");
	  driver.findElement(By.cssSelector("button#register-button")).click();
	  
	  Assert.assertEquals(driver.findElement(By.cssSelector("span#ConfirmPassword-error")).getText(),
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
