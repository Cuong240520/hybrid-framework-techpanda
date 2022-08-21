package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import commons.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;

public class Level_18_Allure_Report extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;
	HomePageObject homePage; // KHỞI TẠO PAGEOPJECT
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGenerator.getHomePage(driver);
	}
    @Description("Login with empty email and password")
    @Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("");

		loginPage.inputToPasswordTextbox("");

		loginPage.clickToLoginButton();
		// failure 1
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "This is a required field...");

		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "This is a required field.");

	}
    @Description("Login with invalid email")
    @Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC_02_LoginWithInvalidEmail(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("123@456.789");

		loginPage.inputToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		// failure 2
		Assert.assertEquals(loginPage.getInvalidEmailMessage(), "Please enter a valid email address. For example johndoe@domain.com...");
	}
    @Description("Login with incorrect email")
    @Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC_03_LoginWithIncorrectEmail(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox("123456");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getIncorrectEmailMessage(), "Invalid login or password.");
	}
    @Description("Login with invalid password")
    @Severity(SeverityLevel.CRITICAL)
	@Test
	public void TC_04_LoginWithInvalidPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox("123");

		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getInvalidPasswordEmailMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}
    @Description("Login with incorrect password")
	@Test
	public void TC_05_LoginWithIncorrectPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		loginPage.inputToPasswordTextbox(getRandomNumber() + "");

		loginPage.clickToLoginButton();

		// failure 3
		Assert.assertEquals(loginPage.getIncorrectPasswordMessage(), "Invalid login or password...");
	}
    @Description("Login with valid email and password")
	@Test
	public void TC_06_LoginWithValidEmailAndPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");

		loginPage.inputToPasswordTextbox("123123");

		myDashboard = loginPage.clickToLoginButton();

		verifyTrue(myDashboard.getEmailVerifyText());

		verifyTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
