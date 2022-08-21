package com.techpanda.account;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.navigation.PageGenerator;
import pageObject.user.AboutUsPageObject;
import pageObject.user.AddressBookPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.HomePageObject;
import pageObject.user.LoginPageObject;
import pageObject.user.MyAccountInfoPageObject;
import pageObject.user.MyAplicationPageObject;
import pageObject.user.MyDashboardPageObject;
import pageObject.user.MyOrderPageObject;
import pageObject.user.MyProductReviewPageObject;
import pageObject.user.SiteMapPageObject;


public class Level_10_Dynamic_Locator_I extends BaseTest {
	@Parameters({"browser"})
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
	
		homePage = PageGenerator.getHomePage(driver);
	}

	@Test
	public void TC_01_LoginWithValidEmailAndPassword() {
		loginPage =  homePage.clickToMyAccountLink(); // GỌI RA SỬ DỤNG
		
		loginPage.inputToEmailTextBox("automationfc.vn@gmail.com");
		loginPage.inputToPasswordTextbox("123123");
		
		myDashboard = loginPage.clickToLoginButton();
		
		assertTrue(myDashboard.getEmailVerifyText());
	    assertTrue((myDashboard.getPasswordVerifyText()));
	}
	@Test
	public void TC_02_Navigate_Page() {
	//My Dashboard => Account Info
		myDashboard.openDynamicSideBarPage("Address Book");
		addressBookPage = PageGenerator.getAddressBookPage(driver);
		
		//Address Page > MyOrder
		addressBookPage.openDynamicSideBarPage("My Orders");
		myOrderPage = PageGenerator.getMyOrderPage(driver);
		
		//Myorder > ProductReview
		myOrderPage.openDynamicSideBarPage("My Product Reviews");
		myProductReviewPage = PageGenerator.getMyProductReviewPage(driver);
		
		//ProductReview > MyAPplication
		myProductReviewPage.openDynamicSideBarPage("My Applications");
		myApplicationPage = PageGenerator.getMyAplicationPage(driver);
		
		//MyAPplication > My order
		myApplicationPage.openDynamicSideBarPage("My Orders");
		myOrderPage = PageGenerator.getMyOrderPage(driver);
		
		
	}
	//Apply if Else 
	@Test
	public void TC_03_Navigate_Page() {
		addressBookPage = (AddressBookPageObject) myDashboard.openDynamicSideBarPageIf("Address Book");
		
		myOrderPage = (MyOrderPageObject) addressBookPage.openDynamicSideBarPageIf("My Orders");
		
		myProductReviewPage = (MyProductReviewPageObject) myOrderPage.openDynamicSideBarPageIf("My Product Reviews");
		
		myApplicationPage = (MyAplicationPageObject) myProductReviewPage.openDynamicSideBarPageIf("My Applications");
		
		myOrderPage = (MyOrderPageObject) myApplicationPage.openDynamicSideBarPageIf("My Orders");
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
	ContactUsPageObject contactPage;
	AboutUsPageObject aboutUsPage;
	SiteMapPageObject siteMapPage;
	MyAccountInfoPageObject myAccountPage;
	MyDashboardPageObject myDashboard;
	MyAplicationPageObject myApplicationPage;
	MyOrderPageObject myOrderPage;
	MyProductReviewPageObject myProductReviewPage;
	AddressBookPageObject addressBookPage;
}
