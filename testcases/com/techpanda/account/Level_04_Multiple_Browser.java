package com.techpanda.account;

import java.util.Random;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;

public class Level_04_Multiple_Browser extends BaseTest {
	//KHỞI TẠO DRIVER TỪ BASETEST
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getEmailErrorMessage(), "This is a required field.");
		assertEquals(loginPage.getPasswordErrorMessage(), "This is a required field.");

	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getInvalidEmailMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getIncorrectEmailMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getInvalidPasswordEmailMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("auto_test" + randomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(randomNumber() + "");
		loginPage.clickToLoginButton();

		assertEquals(loginPage.getIncorrectPasswordMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		homePage.clickToMyAccountLink();

		loginPage = new LoginPageObject(driver);

		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		loginPage.clickToLoginButton();

		myDashboard = new MyDashboardPageObject(driver);

		assertTrue(myDashboard.getEmailVerifyText());
		assertTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
