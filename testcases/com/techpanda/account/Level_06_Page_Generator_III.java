package com.techpanda.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertEquals;
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


public class Level_06_Page_Generator_III extends BaseTest {
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
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
	
		
		loginPage.inputToEmailTextBox("");
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();
		
		assertEquals(loginPage.getEmailErrorMessage(), "This is a required field.");
		assertEquals(loginPage.getPasswordErrorMessage(), "This is a required field.");
		
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("123@456.789");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		

	    assertEquals(loginPage.getInvalidEmailMessage(), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123456");
		loginPage.clickToLoginButton();
		
		assertEquals(loginPage.getIncorrectEmailMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
			
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox("123");
		loginPage.clickToLoginButton();
			
	    assertEquals(loginPage.getInvalidPasswordEmailMessage(), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("auto_test" + getRandomNumber() + "@live.com");
		loginPage.inputToPasswordTextbox(getRandomNumber() + "");
		loginPage.clickToLoginButton();
		
		assertEquals(loginPage.getIncorrectPasswordMessage(), "Invalid login or password.");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		
		myDashboard = loginPage.clickToLoginButton();
		
		assertTrue(myDashboard.getEmailVerifyText());
	    assertTrue((myDashboard.getPasswordVerifyText()));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}


}
