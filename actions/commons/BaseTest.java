package commons;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	private String projectPath = System.getProperty("user.dir");
	private WebDriver driver;
	protected WebDriver getBrowserDriver(String browserName) {
		//Gọi đến khởi tạo driver tương ứng với browser name
		  if(browserName.equals("edge")) {
			  //System.setProperty("webdriver.edge.driver",projectPath+"\\browerDrivers\\msedgedriver.exe");
			  WebDriverManager.edgedriver().setup();
			  driver = new EdgeDriver();
		  } else if(browserName.equals("firefox")){
			  //System.setProperty("webdriver.gecko.driver",projectPath+"\\browerDrivers\\geckodriver.exe");
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver();
		  } else if(browserName.equals("h_firefox")) {
			  //System.setProperty("webdriver.gecko.driver",projectPath+"\\browerDrivers\\geckodriver.exe");
			  FirefoxOptions options = new FirefoxOptions();
			  options.addArguments("--headless");
			  options.addArguments("window-size=1920x1080");
			  WebDriverManager.firefoxdriver().setup();
			  driver = new FirefoxDriver(options);
		  }
		  else if(browserName.equals("chrome")){
			  //System.setProperty("webdriver.chrome.driver",projectPath+"\\browerDrivers\\chromedriver.exe");
			  WebDriverManager.chromedriver().setup();
			  //Download version mong muốn
			  //WebDriverManager.chromedriver().driverVersion("").setup();
			  driver = new ChromeDriver();
		  }else if(browserName.equals("h_chrome")) {
			  //System.setProperty("webdriver.chrome.driver",projectPath+"\\browerDrivers\\chromedriver.exe");
			  ChromeOptions options = new ChromeOptions();
			  options.addArguments("--headless");
			  options.addArguments("window-size=1920x1080");
			  WebDriverManager.chromedriver().setup();
			  driver = new ChromeDriver(options);
		  }
		  else {
			  throw new RuntimeException("Browser Name invalid");
		  }
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.get("https://demo.nopcommerce.com/");
		  return driver;
	}

}
