package com.techpanda.account;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;

public class Account_01_Register {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	
@BeforeClass
 public void beforeClass() {
	System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
	driver = new ChromeDriver();
	
 }
	 

  @Test
  public void Login() {
	  
	  driver.get("http://live.techpanda.org/index.php/");
  }
 

  @AfterClass
  public void afterClass() {
	  driver.close();
  }

}
