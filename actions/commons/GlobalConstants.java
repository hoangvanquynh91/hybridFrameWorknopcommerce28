package commons;

import java.io.File;

public class GlobalConstants {
	public static final String USER_PAGE_URL = "https://demo.nopcommerce.com/";
	public static final String ADMIN_PAGE_URL = "https://admin-demo.nopcommerce.com/login?ReturnUrl=/admin/";
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	//Window / mac / linux
	public static final String UPLOAD_FILE_FOLDER = PROJECT_PATH + File.separator +"uploadFiles"+ File.separator;
	public static final String DOWNLOAD_FILE = PROJECT_PATH + File.separator +"downloadFiles";
	public static final String BROWSER_LOG = PROJECT_PATH + File.separator +"browserLogs";
	public static final String DRAG_DROP_HTML5 = PROJECT_PATH + File.separator +"dragDropHTML5";
	public static final String AUTO_IT_SCRIPT = PROJECT_PATH + File.separator +"dragDropHTML5";
	
	// Database Account / user/ Pass/ 
	public static final String DB_DEV_URL = "192.196.0.1";
	public static final String DB_DEV_USER = "AutomationFC";
	public static final String DB_DEV_PASS = "123456";
	
	public static final String DB_TEST_URL = "192.196.0.1";
	public static final String DB_TEST_USER = "AutomationFC";
	public static final String DB_TEST_PASS = "123456";
	
	public static final long SHORT_TIME = 5;
	public static final long LONG_TIME = 20;
	public static final long RETRY_TEST_FAIL = 3;
	
	
	
	
}
