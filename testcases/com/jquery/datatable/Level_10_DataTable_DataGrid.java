package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjectJQuery.HomePageObject;
import pageObjectJQuery.PageGeneratorManager;

public class Level_10_DataTable_DataGrid extends BaseTest{
     WebDriver driver;
     HomePageObject homePage;
	  
  @Parameters({"browser","url"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  driver = getBrowserDriverJQueryID(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
  }
  @Test
  public void Table_01_Paging (){
	  homePage.openPageByNumber("1");
	  sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActive("1"));
	  homePage.openPageByNumber("5");
	  sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActive("5"));
	  homePage.openPageByNumber("7");
	  sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActive("7"));
	  homePage.openPageByNumber("8");
	  sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActive("8"));
	  homePage.openPageByNumber("10");
	  sleepInSecond(1);
	  Assert.assertTrue(homePage.isPageNumberActive("15"));
	  homePage.openPageByNumber("1");
	  sleepInSecond(1);
	 
  }
  @Test
  public void Table_02_Enter_Header () {  
	  homePage.refreshCurrentPage(driver);
	  homePage.enterToHeaderTextBoxByLabel("Country","AFRICA");
	  sleepInSecond(3);
	  homePage.enterToHeaderTextBoxByLabel("Females","777");
	  sleepInSecond(3);
	  homePage.enterToHeaderTextBoxByLabel("Males","407124");
	  sleepInSecond(3);
	  homePage.enterToHeaderTextBoxByLabel("Total","1504");
	  sleepInSecond(3);
  }
  
  @Test
  public void Table_03_Enter_Header () { 
	  homePage.getValueEachRowAtAllPage();
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
