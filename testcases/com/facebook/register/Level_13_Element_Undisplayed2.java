package com.facebook.register;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BaseTest;

public class Level_13_Element_Undisplayed2 extends BaseTest {
	
    
	  

 @BeforeClass
 public void beforeClass() {}
	 
 @Test
 public void TC_01_Verify_Element_Displayed (){
	 

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
	  
 }
 

}
