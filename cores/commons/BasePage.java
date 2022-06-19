//CREATE HÀM 
package commons;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
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
	
	public By getByXpath(String locator) {
		return By.xpath(locator);
	}
	
	public WebElement getWebElement(WebDriver driver, String xpathLocator) {
		return driver.findElement(getByXpath(xpathLocator));
	}
	
	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}
	
	public void senkeyToElement (WebDriver driver, String xpathLocator, String senkeyValue) {
		WebElement element = getWebElement(driver, xpathLocator);
		element.clear();
		element.sendKeys(senkeyValue);
		
	}
	
	public List<WebElement> getListElement(WebDriver driver, String xpathLocator){
		return driver.findElements(getByXpath(xpathLocator));
	}
	
	public void selectItemDefaultDropdow(WebDriver driver, String xpathLocator, String itemText) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		select.selectByVisibleText(itemText);
	}
	
	public String getFirstSelectTextItem(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.getFirstSelectedOption().getText();
	}
	
	public boolean isDropdownMultiple(WebDriver driver, String xpathLocator) {
		Select select = new Select(getWebElement(driver, xpathLocator));
		return select.isMultiple();
	}
	
	public void selectItemInCustomDropdownList(WebDriver driver,String parentLocator, String childXpathLocator, String expectedItem) {
				getWebElement(driver, parentLocator).click();
				sleepInSecond(2);
				List <WebElement> childItem = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childXpathLocator)));
				for (WebElement tempElement : childItem) {
					if (tempElement.getText().trim().equals(expectedItem)) {
						((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
						sleepInSecond(2);
						tempElement.click();
						break;
					}
				}
	}
	
	public String getTextElement (WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).getText();
	}
	
	public String getElementAttributeValue(WebDriver driver, String xpathLocator, String attributeName) {
		return getWebElement(driver, xpathLocator).getAttribute(attributeName);
	}
	
	public String getCssValue(WebDriver driver, String xpathLocator, String propertyName) {
		return getWebElement(driver, xpathLocator).getAttribute(propertyName);
	}
	
	public int getListElementSize(WebDriver driver, String xpathLocator) {
		return getListElement(driver, xpathLocator).size();
	}
	
	public void checkToCheckBoxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isDisplayed()) {
			element.click();;
		}
	}
	
	public void unCheckToCheckBoxOrRadio(WebDriver driver, String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementEnable(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	
	public boolean isElementDisplayed(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToIframe (WebDriver driver, String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	
	}
	
	public void hoverMouseToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, xpathLocator)).perform();
		
	}
	
	public void rightClickToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, xpathLocator)).perform();
		
	}
	
	public void doubleClickToElement(WebDriver driver, String xpathLocator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, xpathLocator)).perform();
		
	}
	
	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String xpathLocator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, xpathLocator), key).perform();
	}
	
	/*JavaScript*/
	
	public void hightlightElement(WebDriver driver, String sourceLocator, String locator) {
		WebElement element = getWebElement(driver, sourceLocator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver; 
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String sourceLocator,String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, sourceLocator));
	}

	public void scrollToElementOnTop(WebDriver driver, String sourceLocator,String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, sourceLocator));
	}

	public void scrollToElementOnDown(WebDriver driver, String sourceLocator,String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, sourceLocator));
	}

	public void sendkeyToElementByJSWebDriver(WebDriver driver, String sourceLocator,String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, sourceLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String sourceLocator,String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, sourceLocator));
	}

	public String getElementValidationMessage(WebDriver driver, String sourceLocator,String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, sourceLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String sourceLocator,String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0", getWebElement(driver, sourceLocator));
		if (status) {
			return true;
		}
		return false;
	}
	/*Wait*/
	public void waitForElementVisible(WebDriver driver, String sourceLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByXpath(sourceLocator)));
	}
	
	public void waitForElementInVisible(WebDriver driver, String sourceLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(sourceLocator)));
	}
	
	public void waitForElementClickable(WebDriver driver, String sourceLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(getByXpath(sourceLocator)));
	}
	
	private long longTimeOut = 30;
	public void sleepInSecond (long timeInSecond) {
		try {Thread.sleep(timeInSecond * 1000);
		
		}catch(InterruptedException e){
			e.printStackTrace();
		}
			
	}
}
