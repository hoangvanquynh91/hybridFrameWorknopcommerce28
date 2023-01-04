package NopCommerDataTable;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import nopCommerceDataTable.nopLoginPageObject;
import nopCommerceDataTable.NopAdminLoginPageObject;
import nopCommerceDataTable.NopAdminManagerCustomerPageObject;
import nopCommerceDataTable.NopHomePageObject;
import nopCommerceDataTable.NopRegisterPageObject;
import nopCommerceDataTable.PageGeneratorManager;



public class NopcommerTable extends BaseTest {
	WebDriver driver;
	NopHomePageObject nopHomePage;
	NopRegisterPageObject nopRegisterPage;
	nopLoginPageObject nopLoginPage;
	NopAdminLoginPageObject nopAdminLoginPage;
	NopAdminManagerCustomerPageObject nopAdminManagerCustomerPage;
	private String firstName = "Nguyen";
	private String lastName = "Van A";
	private String emailAddress = "Automation321@gmail.com";
	private String password = "123456";
	private String adminUserName = "user01";
	private String adminPasswrod = "guru99com";
	
	 @Parameters({"browser","url"})
	  @BeforeClass
	  public void beforeClass(String browserName, String appUrl) {
		  driver = getBrowserDriverJQueryID(browserName, appUrl);
		  nopHomePage = PageGeneratorManager.getNopHomePage(driver);
		  
	  }
	 @Test
	 public void TC01_Register() {
		 nopHomePage.clickToMyAccountLink();
		 nopLoginPage = PageGeneratorManager.getnopLoginPage(driver);
		 nopLoginPage.clickToCreateAccountButton();
		 nopRegisterPage = PageGeneratorManager.getNopRegisterPage(driver);
		 nopRegisterPage.createAccount(firstName,lastName,emailAddress,password);
	 }
	 
	 public void TC02_Verify_Created_Account() {
		 nopRegisterPage.openAdminPage();
		 nopAdminLoginPage = PageGeneratorManager.getAdminLoginPage(driver);
		 nopAdminLoginPage.loginAdminPage(adminUserName,adminPasswrod);
		 nopAdminManagerCustomerPage = PageGeneratorManager.getAdminManagerCustomerPage(driver);
		 nopAdminManagerCustomerPage.closePopup();
		 nopAdminManagerCustomerPage.searchByEmailAddress(emailAddress);
		 
		 
	 }

}
