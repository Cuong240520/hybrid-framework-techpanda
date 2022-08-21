package javaBasic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class if_Else_InJava {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
   
	public void if_Else_demo(String browserName) {
		driver = new FirefoxDriver();
		
		if (browserName.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browserName.equalsIgnoreCase("firefox")){
			System.setProperty("webdriver.firefox.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
			driver = new FirefoxDriver();
 
		}
	}
	
	
	public void if_Else_II(String browserName) {
		
		//If else 1
		int age =20; 
		String checkAge = (age>10)? "Tuổi to" : " Tuổi nhỏ ";
		System.out.println(checkAge); // Nếu đúng trả về >>>Tuổi to
		 
	}
	
}
