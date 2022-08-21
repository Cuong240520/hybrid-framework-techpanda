package pageObject.user;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGenerator;
import pageUIs.user.HomePageUI;

public class HomePageObject extends BasePage {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public HomePageObject(WebDriver driver) {
	this.driver= driver;
}
 @Step("Click to my Account link")
 public LoginPageObject clickToMyAccountLink() {
		//GỌI MY_ACCOUNT .. TỪ CLASS PAGE_UI ĐỂ SỬ DỤNG
		clickToElement(driver, HomePageUI.MY_ACCOUNT_LINK);
		return PageGenerator.getLoginPage(driver);
	}
	

}
