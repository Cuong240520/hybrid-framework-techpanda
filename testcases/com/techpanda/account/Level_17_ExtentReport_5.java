package com.techpanda.account;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import commons.BaseTest;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;
import reportConfigs.ExtentManager;

public class Level_17_ExtentReport_5 extends BaseTest {
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

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword(Method method) {
		ExtentManager.startTest(method.getName(), "Login with empty email and password");
		
		ExtentManager.getTest().log(Status.INFO, "Login 1: Click to my account link");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 1: Step 2 - Input to Email Textbox ");
		loginPage.inputToEmailTextBox("");

		ExtentManager.getTest().log(Status.INFO, "Login 1: Step 3 - Input to Password Textbox ");
		loginPage.inputToPasswordTextbox("");

		ExtentManager.getTest().log(Status.INFO, "Login 1: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		// failure 1
		ExtentManager.getTest().log(Status.INFO, "Login 1: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "This is a required field...");

		ExtentManager.getTest().log(Status.INFO, "Login 1: Step 6 - Verify the error message is showing correctly");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail(Method method) {
		ExtentManager.startTest(method.getName(), "Login with invalid email");
		
		ExtentManager.getTest().log(Status.INFO, "Login 2: Step 1 - Click to MyAccount Link ");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 2: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("123@456.789");

		ExtentManager.getTest().log(Status.INFO, "Login 2: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123456");

		ExtentManager.getTest().log(Status.INFO, "Login 2: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();

		// failure 2
		ExtentManager.getTest().log(Status.INFO, "Login 2: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getInvalidEmailMessage(), "Please enter a valid email address. For example johndoe@domain.com...");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail(Method method) {
		ExtentManager.startTest(method.getName(), "Login with incorrect email");
		
		ExtentManager.getTest().log(Status.INFO, "Login 3: Step 1 - Click to MyAccount Link ");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 3: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		ExtentManager.getTest().log(Status.INFO, "Login 3: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123456");

		ExtentManager.getTest().log(Status.INFO, "Login 3: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login 3: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getIncorrectEmailMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword(Method method) {
		ExtentManager.startTest(method.getName(), "Login with invalid password");
		
		ExtentManager.getTest().log(Status.INFO, "Login 4: Step 1 - Click to MyAccount Link ");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 4: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		ExtentManager.getTest().log(Status.INFO, "Login 4: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123");

		ExtentManager.getTest().log(Status.INFO, "Login 4: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login 4: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getInvalidPasswordEmailMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword(Method method) {
		ExtentManager.startTest(method.getName(), "Login with incorrect password");
		
		ExtentManager.getTest().log(Status.INFO, "Login 5: Step 1 - Click to MyAccount Link ");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 5: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");

		ExtentManager.getTest().log(Status.INFO, "Login 5: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox(getRandomNumber() + "");

		ExtentManager.getTest().log(Status.INFO, "Login 5: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();

		// failure 3
		ExtentManager.getTest().log(Status.INFO, "Login 5: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getIncorrectPasswordMessage(), "Invalid login or password...");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword(Method method) {
		ExtentManager.startTest(method.getName(), "Login with valid email and password");
		
		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 1 - Click to MyAccount Link ");
		loginPage = homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG

		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");

		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123123");

		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 4 - Click to login button ");
		myDashboard = loginPage.clickToLoginButton();

		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 5 - Verify the error message is showing correctly ");
		verifyTrue(myDashboard.getEmailVerifyText());

		ExtentManager.getTest().log(Status.INFO, "Login 6: Step 6 - Verify the error message is showing correctly ");
		verifyTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
