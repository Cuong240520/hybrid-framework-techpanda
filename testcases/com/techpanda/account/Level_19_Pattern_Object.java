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
import pageObject.navigation.PageGenerator;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.UserHomePageObject;

public class Level_19_Pattern_Object extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;
	UserHomePageObject homePage; // KHỞI TẠO PAGEOPJECT
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;

	@Parameters({ "browser" })
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGenerator.getUserHomePage(driver);
	}
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLinkAtHome(); // GỌI RA SỬ DỤNG

		loginPage.inputToTextBoxByID(driver, "", "email");

		loginPage.inputToTextBoxByID(driver, "", "pass");

		loginPage.clickToButtonByTitle(driver,"Login");
	
		Assert.assertEquals(loginPage.getFieldErrorMessageByID(driver,"advice-required-entry-email"), "This is a required field.");

		Assert.assertEquals(loginPage.getFieldErrorMessageByID(driver,"advice-required-entry-pass"), "This is a required field.");

	}
  
	@Test
	public void TC_02_LoginWithInvalidEmail(Method method) {
		
		loginPage = homePage.clickToMyAccountLinkAtHome(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToTextBoxByID(driver, "123@456.789", "email");

		loginPage.inputToTextBoxByID(driver, "123456", "pass");

		loginPage.clickToButtonByTitle(driver,"Login");


		Assert.assertEquals(loginPage.getFieldErrorMessageByID(driver,"advice-validate-email-email"), "Please enter a valid email address. For example johndoe@domain.com.");
	}
    
	@Test
	public void TC_06_LoginWithValidEmailAndPassword(Method method) {
		
		loginPage = homePage.clickToMyAccountLinkAtHome(); // GỌI RA SỬ DỤNG

		loginPage.inputToTextBoxByID(driver, "automationfc.vn@gmail.com", "email");
		
		loginPage.inputToTextBoxByID(driver, "123123", "pass");

		loginPage.clickToButtonByTitle(driver,"Login");

		Assert.assertTrue(myDashboard.getEmailVerifyText());

		Assert.assertTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
