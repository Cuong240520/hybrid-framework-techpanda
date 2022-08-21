//CREATE HÀM 
package pageFactoryPatternDemo;

import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePageFactory {
	/* Web Browser */	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}

	/**
	 * Get current Url
	 * 
	 * @param driver
	 * 
	 */
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();

	}

	public String getPageSource(WebDriver driver) {
		return driver.getPageSource();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		return new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.alertIsPresent());
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}
	
	public void senkeyToAlert(WebDriver driver, String valueToSenkey) {
		driver.switchTo().alert().sendKeys(valueToSenkey);
	}
	
	public String getAlertText(WebDriver driver) {
		return driver.switchTo().alert().getText();
	}
	
	public void switchToWindownByID(WebDriver driver, String currentWindownID) {
		Set<String> allWindownID = driver.getWindowHandles();
		for (String id : allWindownID) {
			if (!id.equals(currentWindownID)) {
				driver.switchTo().window(id);
			}
		}
	}
	
	public void switchToWindownByTitle(WebDriver driver, String currentTitle) {
		Set<String> allWindownID = driver.getWindowHandles();
		for (String id : allWindownID) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if (actualTitle.equals(currentTitle)) {
				break;
			}
		}
	}
	
	public void switchToWindownByLink(WebDriver driver, String currentContainsLink) {
		Set<String> allWindownID = driver.getWindowHandles();

		for (String id : allWindownID) {
			driver.switchTo().window(id);

			String actualTitle = driver.getTitle();
			if (actualTitle.contains(currentContainsLink)) {
				break;
			}
		}
	}
	
	public boolean closeAllWindownWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindownID = driver.getWindowHandles();
		for (String runWindown : allWindownID) {
			if (!runWindown.equals(parentID)) {
				driver.switchTo().window(runWindown);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
		if (driver.getWindowHandles().size() == 1)
			return true;
		else
			return false;
	}

	/*Web Element*/
	public void clickToElement(WebDriver driver, WebElement element) {
		element.click();
		
	}
	public void senkeyToElement (WebDriver driver, WebElement element, String textValue) {
		element.clear();
		element.sendKeys(textValue);
	}
		
	
	public String getText(WebDriver driver, WebElement element) {
		
		return element.getText();
		
	}
	public void waitForElementIsDisplay(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOf(element));
	}
	public boolean isElementDisplayed(WebDriver driver, WebElement element) {
		return element.isDisplayed();
	}
	private long longTimeOut = 30;
	public void sleepInSecond (long timeInSecond) {
		try {Thread.sleep(timeInSecond * 1000);
		
		}catch(InterruptedException e){
			e.printStackTrace();
		}
			
	}
}
