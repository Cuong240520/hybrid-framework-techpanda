package pageObject.user;

import org.openqa.selenium.WebDriver;

import pageObject.navigation.FooterPageNavigation;

public class ContactUsPageObject extends FooterPageNavigation{
	WebDriver driver;
	public ContactUsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

}
