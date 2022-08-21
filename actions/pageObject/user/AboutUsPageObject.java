package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterPageNavigation;

public class AboutUsPageObject extends FooterPageNavigation{
    WebDriver driver; 
	public AboutUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver; 
	}
	
}
