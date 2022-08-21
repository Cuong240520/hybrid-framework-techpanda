package com.techpanda.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;


public class Level_16_ReportNG extends BaseTest {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;
	HomePageObject homePage; // KHỞI TẠO PAGEOPJECT
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;

	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		log.info("Login 1: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		log.info("Login 1: Step 2 - Input to Email Textbox ");
		loginPage.inputToEmailTextBox("");
		
		log.info("Login 1: Step 3 - Input to Password Textbox ");
		loginPage.inputToPasswordTextbox("");
		
		log.info("Login 1: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		//failure 1
		log.info("Login 1: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "This is a required field...");
		
		log.info("Login 1: Step 6 - Verify the error message is showing correctly");
		Assert.assertEquals(loginPage.getPasswordErrorMessage(), "This is a required field.");
		
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		log.info("Login 2: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		log.info("Login 2: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("123@456.789");
		
		log.info("Login 2: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123456");
		
		log.info("Login 2: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		
		//failure 2
		log.info("Login 2: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getInvalidEmailMessage(), "Please enter a valid email address. For example johndoe@domain.com...");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		log.info("Login 3: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		log.info("Login 3: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		
		log.info("Login 3: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123456");
		
		log.info("Login 3: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		
		log.info("Login 3: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getIncorrectEmailMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		log.info("Login 4: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
			
		log.info("Login 4: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		
		log.info("Login 4: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123");
		
		log.info("Login 4: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		
		
		log.info("Login 4: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getInvalidPasswordEmailMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		log.info("Login 5: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		log.info("Login 5: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		
		log.info("Login 5: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox(getRandomNumber() + "");
		
		log.info("Login 5: Step 4 - Click to login button ");
		loginPage.clickToLoginButton();
		
		
		//failure 3
		log.info("Login 5: Step 5 - Verify the error message is showing correctly ");
		Assert.assertEquals(loginPage.getIncorrectPasswordMessage(), "Invalid login or password...");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		log.info("Login 6: Step 1 - Click to MyAccount Link ");
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		log.info("Login 6: Step 2 - Input to Email Textbox  ");
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		
		log.info("Login 6: Step 3 - Input to Password Textbox  ");
		loginPage.inputToPasswordTextbox("123123");
		
		log.info("Login 6: Step 4 - Click to login button ");
		myDashboard = loginPage.clickToLoginButton();
		
		log.info("Login 6: Step 5 - Verify the error message is showing correctly ");
		verifyTrue(myDashboard.getEmailVerifyText());
		
		log.info("Login 6: Step 6 - Verify the error message is showing correctly ");
		verifyTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
