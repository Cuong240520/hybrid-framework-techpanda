package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.SidebarMyAccountPageObject;

public class MyAplicationPageObject extends SidebarMyAccountPageObject{
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public MyAplicationPageObject(WebDriver driver) {
	super(driver);
	this.driver= driver;
}
	

}
