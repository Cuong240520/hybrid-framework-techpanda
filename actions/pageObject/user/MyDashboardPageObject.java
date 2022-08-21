package pageObject.user;

import org.openqa.selenium.WebDriver;

import io.qameta.allure.Step;
import pageObject.navigation.PageGenerator;
import pageObject.navigation.SidebarMyAccountPageObject;
import pageUI.navigation.SidebarMyAccountPageUI;
import pageUIs.user.MyDashboardPageUI;

public class MyDashboardPageObject extends SidebarMyAccountPageObject {
	WebDriver driver;

	public MyDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	@Step("Verify that the email displayed corectly")
	public boolean getEmailVerifyText() {
		return isElementDisplayed(driver, MyDashboardPageUI.TITLE_TEXT_VERIFY);
	}
	@Step("Get password verify message")
	public boolean getPasswordVerifyText() {
		return isElementDisplayed(driver, MyDashboardPageUI.EMAIL_TEXT_VERIFY);
	}

	public MyAccountInfoPageObject openMyAccountInfoPage() {
		waitForElementVisible(driver, SidebarMyAccountPageUI.MY_ACCOUNT_INFO_LINK);
		clickToElement(driver, SidebarMyAccountPageUI.MY_ACCOUNT_INFO_LINK);
		return PageGenerator.getMyAccountInfoPage(driver);
	}

}
