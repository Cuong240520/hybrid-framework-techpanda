package pageObject.facebook;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.facebook.HomePageUIfacebook;

public class LoginPageObject extends BasePage{
	 WebDriver driver;
	    public LoginPageObject(WebDriver driver) {
	    	this.driver= driver;
	    }
		public void clickToRegisterAccountButton() {
			waitForElementVisible(driver, HomePageUIfacebook.CREATE_ACC_BUTTON);
			clickToElement(driver, HomePageUIfacebook.CREATE_ACC_BUTTON);
		}
		public void clickToClosePopupButton() {
			waitForElementVisible(driver, HomePageUIfacebook.CLOSE_REGISTER_POPUP);
		    clickToElement(driver, HomePageUIfacebook.CLOSE_REGISTER_POPUP);
		    
		}
		public void enterEmail(String emailValue) {
			waitForElementVisible(driver, HomePageUIfacebook.EMAIL_TEXTBOX);
			senkeyToElement(driver, HomePageUIfacebook.EMAIL_TEXTBOX, emailValue);
		}
		public void enterConfirmEmail(String confirmEmailValue) {
			waitForElementVisible(driver, HomePageUIfacebook.REENTER_EMAIL);
			senkeyToElement(driver, HomePageUIfacebook.REENTER_EMAIL, confirmEmailValue);
		}
		public void waitForReEnterEmailVisible() {
			waitForElementVisible(driver, HomePageUIfacebook.REENTER_EMAIL);	
		}
		public boolean isReEnterEmailisDisplayed() {
			return isElementDisplayed(driver, HomePageUIfacebook.REENTER_EMAIL);	
		}
		public boolean isReEnterEmailisUnDisplayed() {
			return isElementUnDisplayed(driver, HomePageUIfacebook.REENTER_EMAIL);	
		}
		public void waitForReEnterInVisibleInDom() {
			waitForElementInVisibleInDOM(driver, HomePageUIfacebook.REENTER_EMAIL);	
		}
		public void waitForReEnterInVisibleNotInDom() {
			waitForElementInVisibleNotInDOM(driver, HomePageUIfacebook.REENTER_EMAIL);	
		}
}
