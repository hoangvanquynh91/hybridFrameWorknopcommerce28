package com.jquery.datatable;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.jQuery.uploadFile.HomePageObject;
import pageObjects.jQuery.uploadFile.PageGeneratorManager;


public class Level_11_Upload_Files extends BaseTest{
     WebDriver driver;
     HomePageObject homePage;
     String catImage = "cat.png";
     String dogImage = "dog.png";
     String mickeyImage = "mickey.png";
     String tomatoImage = "tomato.png";
     String[] mutipleFileName = {catImage,dogImage,mickeyImage,tomatoImage};
	  
  @Parameters({"browser","url"})
  @BeforeClass
  public void beforeClass(String browserName, String appUrl) {
	  driver = getBrowserDriverJQueryID(browserName, appUrl);
	  homePage = PageGeneratorManager.getHomePage(driver);
  }
  @Test
  public void Upload_01_One_File_Per_Time (){
	  
	  
	  // Step 01 - Load Single File
	 homePage.uploadMutipleFiles(driver, catImage);
	 //Step 02 - Verify single file loaded success
	 Assert.assertTrue(homePage.isFileLoadedByName(catImage));
	 //Step 03 - Click to start button
	 homePage.clickToStartButton();
	 //Step 04 - Verify single file link uploaded success
	 Assert.assertTrue(homePage.isFileLinkUpLoadedByName(catImage));
	//Step 04 - Verify single file image uploaded success
	 Assert.assertTrue(homePage.isFileImageUpLoadedByName(catImage));
	 

  }
  @Test
  public void Upload_02_Mutiple_File () { 
	  
	  homePage.refreshCurrentPage(driver);
	  // Step 01 - Load Multiple File
		 homePage.uploadMutipleFiles(driver, mutipleFileName);
		 //Step 02 - Verify Multiple file loaded success
		 Assert.assertTrue(homePage.isFileLoadedByName(catImage));
		 Assert.assertTrue(homePage.isFileLoadedByName(dogImage));
		 Assert.assertTrue(homePage.isFileLoadedByName(mickeyImage));
		 Assert.assertTrue(homePage.isFileLoadedByName(tomatoImage));
		 //Step 03 - Click to start button
		 homePage.clickToStartButton();
		 //Step 04 - Verify Multiple file link uploaded success
		 Assert.assertTrue(homePage.isFileLinkUpLoadedByName(catImage));
		 Assert.assertTrue(homePage.isFileLinkUpLoadedByName(dogImage));
		 Assert.assertTrue(homePage.isFileLinkUpLoadedByName(mickeyImage));
		 Assert.assertTrue(homePage.isFileLinkUpLoadedByName(tomatoImage));
		 
		//Step 04 - Verify Multiple file image uploaded success
		 Assert.assertTrue(homePage.isFileImageUpLoadedByName(catImage));
		 Assert.assertTrue(homePage.isFileImageUpLoadedByName(dogImage));
		 Assert.assertTrue(homePage.isFileImageUpLoadedByName(mickeyImage));
		 Assert.assertTrue(homePage.isFileImageUpLoadedByName(tomatoImage));
	
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
