package com.jquery.datatable;

import java.util.List;

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
     List<String> actualAllCountryValues;
     List<String> expectedAllCountryValues;
	  
  @Parameters({"browser","url"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  driver = getBrowserDriverJQueryID(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
  }

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
  

  public void Table_03_Enter_Header () { 
	  // Đọc dữ liệu của file country.txt
	  // Lưu vào list expectedAllCountryValues
	  // Thực hiện assert actualAllCountryValues với expectedAllCountryValues
	  
	  actualAllCountryValues = homePage.getValueEachRowAtAllPage();
	  Assert.assertEquals(actualAllCountryValues, expectedAllCountryValues);
  }
  
  @Test
  public void Table_04_Enter_To_Textbox_At_Any_Row () { 
	  homePage.clickToLoadDataButton();
	  
	  // Value để input data
	  // Row Number : input data tại row nào
	  // Ex : Input data vào tại dòng nào 3, 7,5...
	  // Column name
//	  homePage.enterToTextBoxByColummnNameAtRowNumberColumName("Company","2","Nittsu System");
//	  homePage.enterToTextBoxByColummnNameAtRowNumberColumName("Contact Person","4","123456789");
//	  homePage.enterToTextBoxByColummnNameAtRowNumberColumName("Order Placed","8","1");
//	  
//	  homePage.selectDropDownAtRowNumber("Country","5","Japan");
//	  homePage.selectDropDownAtRowNumber("Country","6","Malaysia");
//	  
//	  homePage.checkToCheckBoxAtRowNumber("NPO?","2");
//	  homePage.checkToCheckBoxAtRowNumber("NPO?","3");
//	  homePage.unheckToCheckBoxAtRowNumber("NPO?","4");
//	  homePage.unheckToCheckBoxAtRowNumber("NPO?","5");
	  
	  homePage.clickToIconByRowNUmber("1","Insert Row Above");
	  homePage.clickToIconByRowNUmber("3","Remove Current Row");
	  homePage.clickToIconByRowNUmber("3","Move Up");
	  homePage.clickToIconByRowNUmber("4","Move Down");
	  
	  
	  
	  
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
	  //driver.quit();
  }
  
  

}
