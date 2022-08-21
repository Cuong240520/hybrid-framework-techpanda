package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.navigation.PageGenerator;
import pageUIs.user.HomePageUI;

public class UserHomePageObject extends BasePage {
	WebDriver driver;

	public UserHomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public LoginPageObject clickToMyAccountLinkAtHome() {
		//GỌI MY_ACCOUNT .. TỪ CLASS PAGE_UI ĐỂ SỬ DỤNG
		waitForElementClickable(driver, HomePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getLoginPage(driver);
	}
}
