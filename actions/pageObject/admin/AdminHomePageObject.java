package pageObject.admin;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.admin.AdminHomePageUI;

public class AdminHomePageObject extends BasePage {
	WebDriver driver;

	public AdminHomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickClosePopupHomePAge() {
		waitForElementVisible(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
		clickToElement(driver, AdminHomePageUI.CLOSE_POPUP_BUTTON);
	}

}
