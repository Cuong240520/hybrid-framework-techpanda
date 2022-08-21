package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyProductReviewPageObject extends SidebarMyAccountPageObject {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public MyProductReviewPageObject(WebDriver driver) {
	super(driver);
	this.driver= driver;
}
	

}
