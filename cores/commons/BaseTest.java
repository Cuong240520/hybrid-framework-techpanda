
//XỬ LÝ CÁC BROWSER
package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
	// DRIVER  SẼ ĐƯỢC KHỎI TẠO TẠI BASETEST VÀ CHỈ MỘT LẦN DUY NHẤT 
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;

	protected WebDriver getBrowserDriver(String browserName) {
		BrowserList browserList = BrowserList.valueOf(browserName.toUpperCase());
		
		switch (browserList) {
		case FIREFOX: // GỌI CÁC BROWSER TỪ ENUM CLASS (BROWSERLIST)
			driver = WebDriverManager.firefoxdriver().create();
			break;
		case CHROME:
			driver =WebDriverManager.chromedriver().create();
			break;
		case EDGE:
			driver =WebDriverManager.edgedriver().create();
			break;
		default:
			throw new RuntimeException("Invalid Browser");
		}
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		expliciptWait = new WebDriverWait(driver, 15);
		driver.get("http://live.techpanda.org/");
		return driver;
		
	}
	protected int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}
}
