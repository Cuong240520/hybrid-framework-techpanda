package pageObject.navigation;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageObject.user.AboutUsPageObject;
import pageObject.user.ContactUsPageObject;
import pageObject.user.SiteMapPageObject;
import pageUI.navigation.FooterPageUI;

public class FooterPageNavigation extends BasePage{
    WebDriver driver;
    public FooterPageNavigation (WebDriver driver) {
		this.driver = driver;
	}
    
    public AboutUsPageObject openAboutUsPage() {
    	waitForElementVisible(driver, FooterPageUI.ABOUT_US_LINK);
    	clickToElement(driver, FooterPageUI.ABOUT_US_LINK);
		return PageGenerator.getAboutUsPage(driver);
    	
    }
    public ContactUsPageObject openContactUsPage() {
    	waitForElementVisible(driver, FooterPageUI.CONTACT_US_LINK);
    	clickToElement(driver, FooterPageUI.CONTACT_US_LINK);
		return PageGenerator.getContactUsPage(driver);
    	
    }
    public SiteMapPageObject openSiteMapPage() {
    	waitForElementVisible(driver, FooterPageUI.ABOUT_US_LINK);
    	clickToElement(driver, FooterPageUI.ABOUT_US_LINK);
		return PageGenerator.getSiteMapPage(driver);
    	
    }
    
    
}
