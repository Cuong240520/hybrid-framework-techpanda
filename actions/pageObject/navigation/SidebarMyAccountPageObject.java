package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.navigation.SidebarMyAccountPageUI;

public class SidebarMyAccountPageObject extends BasePage {
	WebDriver driver;

	public SidebarMyAccountPageObject(WebDriver driver) {
		this.driver = driver;

	}
	public SidebarMyAccountPageObject openDynamicSideBarPageIf(String pageName) {
		waitForElementVisible(driver, SidebarMyAccountPageUI.DYNAMIC_LOCATOR_SIDEBAR_LINK, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_LOCATOR_SIDEBAR_LINK, pageName);

		if (pageName.equals("Account Information")) {
			return PageGenerator.getMyAccountInfoPage(driver);
		} else if (pageName.equals("Address Book")) {
			return PageGenerator.getAddressBookPage(driver);
		} else if (pageName.equals("My Orders")) {
			return PageGenerator.getMyOrderPage(driver);
		} else if (pageName.equals("My Product Reviews")) {
			return PageGenerator.getMyProductReviewPage(driver);
		} else if (pageName.equals("My Applications")) {
			return PageGenerator.getMyAplicationPage(driver);
		}
		return null;
	}
	// Không return về bất kì Pagae nào
	public void openDynamicSideBarPage(String pageName) {
		waitForElementVisible(driver, SidebarMyAccountPageUI.DYNAMIC_LOCATOR_SIDEBAR_LINK, pageName);
		clickToElement(driver, SidebarMyAccountPageUI.DYNAMIC_LOCATOR_SIDEBAR_LINK, pageName);

	}
}
