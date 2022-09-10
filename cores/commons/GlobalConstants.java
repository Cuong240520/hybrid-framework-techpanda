package commons;


public class GlobalConstants {
	// System Info
	public static final String PROJECT_PATH = System.getProperty("user.dir");
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String JAVA_VERSION = System.getProperty("java.version");
	// App Info User
	public static final String DEV_USER_URL = "http://dev.techpanda.org/";
	public static final String STAGING_USER_URL ="http://staging.techpanda.org/";
	public static final String LIVE_USER_URL ="http://live.techpanda.org/";

	//app info admin
	public static final String DEV_ADMIN_URL ="http://dev.techpanda.org/index.php/backendlogin";
	public static final String STAGING_ADMIN_URL ="http://staging.techpanda.org/index.php/backendlogin";
	public static final String LIVE_ADMIN_URL = "http://live.techpanda.org/index.php/backendlogin";
	
	//Account info
	public static final String ADMIN_USERNAME = "user01";
	public static final String ADMIN_PASSWORD = "guru99com";
	
	//Wait info
	public static final long SORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 15;
	
	//Download/Upload file
	public static final String UPLOAD_FILE_PATH = PROJECT_PATH  + "\\upload_File\\";
	public static final String DOWNLOAD_FILE_PATH = PROJECT_PATH + "\\downloadFile\\";
	
	//Retry Case Fail
	public static final int RETRY_NUMBER = 3;
	
	//Browser Logs / Extention
	public static final String BROWSER_LOG_PATH = PROJECT_PATH + "/browserLogs/";
	public static final String BROWSER_EXTENTION_PATH = PROJECT_PATH + "/browserExtenstions/";
	
	//hTML REPORT FOLDER
	public static final String REPORTNG_SCREENSHOT = PROJECT_PATH + "\\screenShotReportNG\\";
	public static final String REPORT_PATH = PROJECT_PATH + "/htmlReportNG/";
	public static final String EXTENT_REPORT_PATH = PROJECT_PATH + "/htmlExtent/";
	public static final String ALLURE_PATH = PROJECT_PATH + "/htmlAllure/";
	
	
	
	
}
