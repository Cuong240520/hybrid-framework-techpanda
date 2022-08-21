package pageObject.user;

import org.openqa.selenium.WebDriver;
import commons.BasePage;
import io.qameta.allure.Step;
import pageObject.navigation.PageGenerator;
import pageUIs.user.LoginPageUI;

public class LoginPageObject extends BasePage{
	WebDriver driver;
   public LoginPageObject(WebDriver driver) {
	this.driver = driver; 
    }
   @Step("Input to email textbox: {0}")
	public void inputToEmailTextBox(String email) {
		waitForElementVisible(driver, LoginPageUI.EMAIL_TEXTBOX);
		senkeyToElement(driver,LoginPageUI.EMAIL_TEXTBOX , email);
		
	}
   @Step("Input to password textbox: {0}")
	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, LoginPageUI.PASSWORD_TEXTBOX);
		senkeyToElement(driver,LoginPageUI.PASSWORD_TEXTBOX , password);
		
	}
   @Step("Click to Login button")
	public MyDashboardPageObject clickToLoginButton() {
	    waitForElementVisible(driver, LoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUI.LOGIN_BUTTON);
		return PageGenerator.getMyDashboardPage(driver);
	}
   @Step("Get email error message")
	public String getEmailErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_ERROR_EMAIL_MESSAGE);
		return getTextElement(driver,LoginPageUI.EMPTY_ERROR_EMAIL_MESSAGE);
	}
   @Step("Get password error message")
	public String getPasswordErrorMessage() {
		waitForElementVisible(driver, LoginPageUI.EMPTY_ERROR_PASSWORD_MESSAGE);
		return getTextElement(driver,LoginPageUI.EMPTY_ERROR_PASSWORD_MESSAGE);
	}
   @Step("Get invalid email error message")
	public String getInvalidEmailMessage() {
	   return getTextElement(driver, LoginPageUI.INVALID_EMAIL_MESSAGE);
	}
   @Step("Get incorrect email error message")
	public String getIncorrectEmailMessage() {
		return getTextElement(driver, LoginPageUI.INCORRECT_EMAIL_MESSAGE);
	}
   @Step("Get invalid email and password error message")
	public String getInvalidPasswordEmailMessage() {
		return getTextElement(driver, LoginPageUI.INVALID_PASSWORD_MESSAGE);
	}
   @Step("Get incorrect password error message")
	public String getIncorrectPasswordMessage() {
		return getTextElement(driver, LoginPageUI.INCORRECT_EMAIL_MESSAGE);
	}

	

}
