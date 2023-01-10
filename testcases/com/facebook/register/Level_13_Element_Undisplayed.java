package com.facebook.register;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.Facebook.LoginPageObject;
import pageObjects.Facebook.PageGeneratorManager;

public class Level_13_Element_Undisplayed extends BaseTest {
	WebDriver driver;
    LoginPageObject loginPage;
    
	  
 @Parameters({"browser","url"})
 @BeforeClass
 public void beforeClass(String browserName, String appUrl) {
	  driver = getBrowserDriverJQueryID(browserName, appUrl);
	  loginPage = PageGeneratorManager.getLoginPage(driver);
 }
 @Test
 public void TC_01_Verify_Element_Displayed (){
	  loginPage.clickToCreateNewAccountButton();
	  verifyTrue(loginPage.isEmailAddresTextboxDisplay());

 }
 @Test
 public void TC_02_Verify_Element_Undisplayed_In_DOM () { 
	  
	
 }
 
 @Test
 public void TC_03_Verify_Element_Undisplayed_Not_In_DOM () { 
	  
	
 }
 
 
 public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
 
 @AfterClass
 public void afterClass() {
	  driver.quit();
 }
 

}
