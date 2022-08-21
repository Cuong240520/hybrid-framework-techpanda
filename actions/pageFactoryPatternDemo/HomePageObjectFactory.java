package pageFactoryPatternDemo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePageObjectFactory extends BasePageFactory {
	//KHỞI TẠO DRIVER TỪ BASETEST
WebDriver driver;
public HomePageObjectFactory(WebDriver driver) {
	this.driver= driver;
	PageFactory.initElements(driver,this);
}
//UI in PageFactory
@FindBy(xpath ="//div[@class='footer']//a[text()='My Account']")
WebElement myAccountLink;




	public void clickToMyAccountLink() {
		//GỌI MY_ACCOUNT .. TỪ CLASS PAGE_UI ĐỂ SỬ DỤNG
		clickToElement(driver, myAccountLink);
		
	}

}
