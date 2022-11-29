package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Topic_07_Switch_Case {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	@Parameters("browser")
	
	public void TC_01(String browserName) {
		driver = getBrowserDriver(browserName);
		driver.quit();
		
	}
	
	public WebDriver getBrowserDriver(String browserName) {
		switch (browserName) {
		case "edge":
			System.setProperty("webdriver.edge.driver", projectPath+"\\browerDrivers\\msedgedriver.exe");
			driver = new EdgeDriver();
			//driver.quit();
			break;
		case "firefox" : 
			System.setProperty("webdriver.gecko.driver",projectPath+ "\\browerDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
			//driver.quit();
			break;
		case "chrome" :
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browerDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
			break;
		default:
			throw new RuntimeException("Please input correct browser name");
		}
		return driver;
		
	}
	
	@Test
	public void TC_02() {
		String[] cityName = {"A","B","C","D","E","F"};
		for (String city : cityName) {
			if(city.equals("C")) {
				System.out.println(city);
				break;
			}
			
		}
	}

}

