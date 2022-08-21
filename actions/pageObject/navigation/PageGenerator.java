package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import pageObject.admin.AdminHomePageObject;
import pageObject.admin.AdminLoginPageObject;
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
import pageObject.user.UserHomePageObject;

public class PageGenerator {

	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	public static MyDashboardPageObject getMyDashboardPage(WebDriver driver) {
		return new MyDashboardPageObject(driver);
	}
	public static AddressBookPageObject getAddressBookPage(WebDriver driver) {
		return new AddressBookPageObject(driver);
	}
	public static MyAplicationPageObject getMyAplicationPage(WebDriver driver) {
		return new MyAplicationPageObject(driver);
	}
	public static MyOrderPageObject getMyOrderPage(WebDriver driver) {
		return new MyOrderPageObject(driver);
	}
	public static MyProductReviewPageObject getMyProductReviewPage(WebDriver driver) {
		return new MyProductReviewPageObject(driver);
	}
	public static MyAccountInfoPageObject getMyAccountInfoPage(WebDriver driver) {
		return new MyAccountInfoPageObject(driver);
	}
	public static AboutUsPageObject getAboutUsPage(WebDriver driver) {
		return new AboutUsPageObject(driver);
	}
	public static ContactUsPageObject getContactUsPage(WebDriver driver) {
		return new ContactUsPageObject(driver);
	}
	public static SiteMapPageObject getSiteMapPage(WebDriver driver) {
		return new SiteMapPageObject(driver);
	}
	public static AdminLoginPageObject getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPageObject(driver);
	}
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	public static UserHomePageObject getUserHomePage(WebDriver driver) {
		return new UserHomePageObject(driver);
	}
	
	
}
