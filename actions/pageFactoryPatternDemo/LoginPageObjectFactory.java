package pageFactoryPatternDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPageObjectFactory extends BasePageFactory{
	WebDriver driver;
   public LoginPageObjectFactory(WebDriver driver) {
	this.driver = driver; 
	PageFactory.initElements(driver, this);
    }
  @FindBy(id = "email")
  WebElement emailTextBox;
  @FindBy(id = "pass")
  WebElement passWordTextbox;
  @FindBy(id="send2")
  WebElement loginButton;
  @FindBy(xpath = "//div[@id='advice-required-entry-email']")
  WebElement emptyErrorEmailMessage;
  @FindBy(xpath = "//div[@id='advice-required-entry-pass']")
  WebElement emptyErrorPasswordMessage;
  @FindBy(xpath = "//div[@id='advice-validate-email-email']")
  WebElement invalidEmailMessage;
  @FindBy(xpath = "//li[@class='error-msg']//span")
  WebElement incorrectEmailMessage;
  @FindBy(xpath = "//div[@id='advice-validate-password-pass']")
  WebElement invalidPasswordMessage;
  
	public void inputToEmailTextBox(String email) {
		waitForElementIsDisplay(driver, emailTextBox);
		senkeyToElement(driver, emailTextBox , email);
		
	}
	public void inputToPasswordTextbox(String password) {
		waitForElementIsDisplay(driver, passWordTextbox);
		senkeyToElement(driver,passWordTextbox , password);
		
	}

	public void clickToLoginButton() {
		waitForElementIsDisplay(driver, loginButton);
		clickToElement(driver, loginButton);
		
	}

	public String getEmailErrorMessage() {
		waitForElementIsDisplay(driver, emptyErrorEmailMessage);
		return getText(driver,emptyErrorEmailMessage);
	}

	public String getPasswordErrorMessage() {
		waitForElementIsDisplay(driver, emptyErrorPasswordMessage);
		return getText(driver,emptyErrorPasswordMessage);
	}

	public String getInvalidEmailMessage() {
	   return getText(driver, invalidEmailMessage);
	}

	public String getIncorrectEmailMessage() {
		
		return getText(driver, incorrectEmailMessage);
	}

	public String getInvalidPasswordEmailMessage() {
		return getText(driver, invalidPasswordMessage);
	}

	public String getIncorrectPasswordMessage() {
		return getText(driver, invalidPasswordMessage);
	}

	

}
