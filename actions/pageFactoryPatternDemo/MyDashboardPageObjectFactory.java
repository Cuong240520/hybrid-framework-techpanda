package pageFactoryPatternDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyDashboardPageObjectFactory extends BasePageFactory {
	WebDriver driver;

	public MyDashboardPageObjectFactory(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'automationfc.vn@gmail.com')]")
	WebElement emailVerify;
	@FindBy(xpath = "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]")
	WebElement titleVerify;

	public boolean getEmailVerifyText() {
		return isElementDisplayed(driver, titleVerify);
	}

	public boolean getPasswordVerifyText() {
		return isElementDisplayed(driver, emailVerify);
	}
}
