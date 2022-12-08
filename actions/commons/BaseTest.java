package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseTest {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver basetestDriver;
	protected WebDriver getBrowserDriver(String browserName) {
		//Gọi đến khởi tạo driver tương ứng với browser name
		  if(browserName.equals("edge")) {
			  System.setProperty("webdriver.edge.driver",projectPath+"\\browerDrivers\\msedgedriver.exe");
			  basetestDriver = new EdgeDriver();
		  }else if(browserName.equals("firefox")){
			  System.setProperty("webdriver.gecko.driver",projectPath+"\\browerDrivers\\geckodriver.exe");
			  basetestDriver = new FirefoxDriver();
		  }else if(browserName.equals("chrome")){
			  System.setProperty("webdriver.chrome.driver",projectPath+"\\browerDrivers\\chromedriver.exe");
			  basetestDriver = new ChromeDriver();
		  }else {
			  throw new RuntimeException("Browser Name invalid");
		  }
		  basetestDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  basetestDriver.get("https://demo.nopcommerce.com/");
		  return basetestDriver;
	}

}
