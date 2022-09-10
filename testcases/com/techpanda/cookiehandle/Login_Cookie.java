package com.LoginCookie.Techpanda;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import java.util.Set;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import commons.BaseTest;
import pageObject.navigation.PageGenerator;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.UserHomePageObject;


public class Login_Cookie extends BaseTest {
	@Parameters({"browser"})
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGenerator.getUserHomePage(driver);
		
		loginPage = homePage.clickToMyAccountLinkAtHome();
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		myDashBoard = loginPage.clickToLoginButton();
		

		loginCookie = myDashBoard.getCookies(driver);
	}

	
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	WebDriver driver;
	UserHomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashBoard;
	static Set<Cookie> loginCookie;
	
}
