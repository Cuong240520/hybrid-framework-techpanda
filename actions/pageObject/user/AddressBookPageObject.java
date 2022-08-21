package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class AddressBookPageObject extends SidebarMyAccountPageObject {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public AddressBookPageObject(WebDriver driver) {
	super(driver);
	this.driver= driver;
}
	
}
