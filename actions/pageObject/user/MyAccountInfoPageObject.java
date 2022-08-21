package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyAccountInfoPageObject extends SidebarMyAccountPageObject {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public MyAccountInfoPageObject(WebDriver driver) {
	super(driver);
	this.driver= driver;
}

	
}
