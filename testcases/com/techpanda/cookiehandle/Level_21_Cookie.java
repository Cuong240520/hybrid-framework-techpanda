package com.LoginCookie.Techpanda;


import org.openqa.selenium.WebDriver;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;


public class Level_21_Cookie extends BaseTest {
	WebDriver driver;


	HomePageObject homePage; // KHỞI TẠO PAGEOPJECT
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGenerator.getHomePage(driver);
		
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		loginPage.setCookies(driver, Login_Cookie.loginCookie);
		
		myDashboard = PageGenerator.getMyDashboardPage(driver);
		assertTrue(myDashboard.getEmailVerifyText());
	    assertTrue((myDashboard.getPasswordVerifyText()));
	}
    @Test
	public void TC_01_Order_Products() {
		
        
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
