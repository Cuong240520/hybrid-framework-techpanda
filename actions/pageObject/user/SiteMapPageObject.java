package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterPageNavigation;

public class SiteMapPageObject extends FooterPageNavigation{
 WebDriver driver; 
	public SiteMapPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
