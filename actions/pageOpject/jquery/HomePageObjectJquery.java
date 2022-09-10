package pageOpject.jquery;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import pageUI.jquery.HomePageUIJquery;

public class HomePageObjectJquery extends BasePage{
    WebDriver driver;
    public HomePageObjectJquery(WebDriver driver) {
    	this.driver= driver;
    }
	public void inputToFemales(String headerName, String senkeyValue) {
		waitForElementVisible(driver, HomePageUIJquery.HEADER_NAME_TEXTBOX, headerName);
		senkeyToElement(driver, HomePageUIJquery.HEADER_NAME_TEXTBOX, senkeyValue, headerName);
		pressKeyToElement(driver,HomePageUIJquery.HEADER_NAME_TEXTBOX, Keys.ENTER, headerName);
	}
	public boolean isValueIsDisplayed(String females, String country, String males, String total) {
		waitForElementVisible(driver, HomePageUIJquery.ROW_VALUE, females, country, males, total);
		return isElementDisplayed(driver, HomePageUIJquery.ROW_VALUE, females, country, males, total);
	}
	public void deleteCountry(String country, String action) {
		waitForElementVisible(driver, HomePageUIJquery.ACTION_VALUE, country, action);
		clickToElement(driver, HomePageUIJquery.ACTION_VALUE, country, action);
	}
	public boolean isFileNameIsDisplayed(String fileName) {
		waitForElementVisible(driver,HomePageUIJquery.FILE_NAME_UPLOADED, fileName);
		return isElementDisplayed(driver, HomePageUIJquery.FILE_NAME_UPLOADED, fileName);
	}
	public void clickStartButton() {
		List<WebElement> startButtons = getListElement(driver, HomePageUIJquery.START_BUTTON);
		for (WebElement startButton : startButtons) {
			startButton.click();
			sleepInSecond(2);
		}
		
	}
	public boolean isFileNameUploadSuccess(String fileName) {
		waitForElementVisible(driver,HomePageUIJquery.FILE_NAME_UPLOADED_SUCCESS, fileName);
		return isElementDisplayed(driver, HomePageUIJquery.FILE_NAME_UPLOADED_SUCCESS, fileName);
	}
}
