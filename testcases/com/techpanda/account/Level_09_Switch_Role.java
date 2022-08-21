package com.techpanda.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.admin.AdminHomePageObject;
import pageObject.admin.AdminLoginPageObject;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.UserHomePageObject;



public class Level_09_Switch_Role extends BaseTest {
	String userUrl, adminUrl; 
	@Parameters({"browser", "userUrl","adminUrl" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl, String adminUrl) {
		this.userUrl = userUrl;
		this.adminUrl = adminUrl;
		
		driver = getBrowserDriver(browserName, this.userUrl);
	
		userHomePage = PageGenerator.getUserHomePage(driver);
	}

	@Test
	public void TC_01_LoginWithValidEmailAndPassword() {
		loginPage =  userHomePage.clickToMyAccountLinkAtHome(); 
	
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		
		myDashboard = loginPage.clickToLoginButton();
		
		assertTrue(myDashboard.getEmailVerifyText());
	    assertTrue((myDashboard.getPasswordVerifyText()));
	    //UseruUrl -> Admin url 
	    
	    adminLoginPage = myDashboard.openAdminPageUrl(driver, adminUrl);
	   
	    //Login AdminPage
	    adminLoginPage.enterToUserNameTextbox("user01");
	    adminLoginPage.enterToPasswordTextbox("guru99com");
	    
	    admimHomePage= adminLoginPage.clickToLoginButton();
	    admimHomePage.clickClosePopupHomePAge();
	    
	    //Logout
	    homePage = admimHomePage.clickLogoutAdminPage(driver); 
	    
	    //Login UserPage
	    userHomePage = admimHomePage.openUserHomePage(driver, userUrl);
	    
	    loginPage = userHomePage.clickToMyAccountLinkAtHome(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
	}
	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;
	HomePageObject homePage; // KHỞI TẠO PAGEOPJECT
	LoginPageObject loginPage;
	MyDashboardPageObject myDashboard;
	AdminHomePageObject admimHomePage;
	AdminLoginPageObject adminLoginPage;
	UserHomePageObject userHomePage;
}
