package com.jquery.datatable;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import PageUIs.JQuery.NopAdminPageUI;
import commons.BasePage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class demoNopadmin extends BasePage{
	
	WebDriver driver;
	

	@BeforeClass
	public void beforeClass() {
		 WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	@Test
	public void TC_01() {
		driver.get("http://live.techpanda.org/index.php/backendlogin/customer/");
		sleepInSecond(2);
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("user01");
		driver.findElement(By.xpath("//input[@id='login' and @type ='password']")).sendKeys("guru99com");
		sleepInSecond(2);
		driver.findElement(By.xpath("//input[@title='Login']")).click();
		sleepInSecond(10);
		driver.findElement(By.xpath("//div[@class='message-popup-head']")).click();
		sleepInSecond(10);
		
		
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
