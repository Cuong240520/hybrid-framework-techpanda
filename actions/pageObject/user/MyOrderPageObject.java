package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyOrderPageObject extends SidebarMyAccountPageObject {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public MyOrderPageObject(WebDriver driver) {
	super(driver);
	this.driver= driver;
}
	

}
