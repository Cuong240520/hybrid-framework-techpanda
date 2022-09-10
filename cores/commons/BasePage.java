//CREATE HÀM 
package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObject.admin.AdminLoginPageObject;
import pageObject.navigation.FooterPageNavigation;
import pageObject.navigation.PageGenerator;
import pageObject.user.HomePageObject;
import pageObject.user.UserHomePageObject;
import pageUI.jquery.HomePageUIJquery;
import pageUIs.admin.AdminPageBaseUI;
import pageUIs.user.UserBasePageUI;

public class BasePage {
	/* Web Browser */
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);

	}
	/**
	 * Get Cookie
	 */
	public Set<Cookie> getCookies(WebDriver driver) {
		return driver.manage().getCookies();
	}
	/**
	 * Set Cookie 
	 */
	public void setCookies(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);	
		}
		sleepInSecond(2);
		refreshCurrentPage(driver);
	}
	

	/**
	 * Get current Url
	 * @param driver
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

	/* Web Element */

	// Because only use for this class so will use Private
	private By getByLocator(String locator) {
		By by = null;
		if (locator.startsWith("id=") || locator.startsWith("ID") || locator.startsWith("Id")) {
			by = By.id(locator.substring(3));
		} else if (locator.startsWith("Class=") || locator.startsWith("class=") || locator.startsWith("CLASS=")) {
			by = By.className(locator.substring(6));
		} else if (locator.startsWith("Name=") || locator.startsWith("name=") || locator.startsWith("NAME=")) {
			by = By.name(locator.substring(5));
		} else if (locator.startsWith("Xpath=") || locator.startsWith("xpath") || locator.startsWith("XPATH")) {
			by = By.xpath(locator.substring(6));
		} else if (locator.startsWith("css=") || locator.startsWith("CSS") || locator.startsWith("Css")) {
			by = By.cssSelector(locator.substring(4));
		} else {
			throw new RuntimeException("Locator is not valid");
		}
		return by;
	}

	public WebElement getWebElement(WebDriver driver, String Locator) {
		return driver.findElement(getByLocator(Locator));
	}

	// Create Dynamic method
	public String castRestParameter(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public void clickToElement(WebDriver driver, String xpathLocator) {
		getWebElement(driver, xpathLocator).click();
	}

	// Apply dynamic method
	public void clickToElement(WebDriver driver, String locator, String... dynamicLocator) {
		getWebElement(driver, castRestParameter(locator, dynamicLocator)).click();
	}

	public void senkeyToElement(WebDriver driver, String locator, String senkeyValue) {
		WebElement element = getWebElement(driver, locator);
		element.clear();
		element.sendKeys(senkeyValue);
	}

	// Apply dynamic method
	public void senkeyToElement(WebDriver driver, String locator, String senkeyValue, String dynamicLocator) {
		WebElement element = getWebElement(driver, castRestParameter(locator, dynamicLocator));
		element.clear();
		element.sendKeys(senkeyValue);
	}

	public List<WebElement> getListElement(WebDriver driver, String locator) {
		return driver.findElements(getByLocator(locator));
	}

	public void selectItemDefaultDropdow(WebDriver driver, String Locator, String itemText) {
		Select select = new Select(getWebElement(driver, Locator));
		select.selectByVisibleText(itemText);
	}
	public void selectItemDefaultDropdow(WebDriver driver, String locator, String itemText ,String... dynamicLocator ) {
		Select select = new Select(getWebElement(driver, castRestParameter(locator, dynamicLocator)));
		select.selectByVisibleText(itemText);
	}

	public String getFirstSelectTextItem(WebDriver driver, String Locator) {
		Select select = new Select(getWebElement(driver, Locator));
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String Locator) {
		Select select = new Select(getWebElement(driver, Locator));
		return select.isMultiple();
	}

	public void selectItemInCustomDropdownList(WebDriver driver, String parentLocator, String childXpathLocator, String expectedItem) {
		getWebElement(driver, parentLocator).click();
		sleepInSecond(2);
		List<WebElement> childItem = new WebDriverWait(driver, 30).until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector(childXpathLocator)));
		for (WebElement tempElement : childItem) {
			if (tempElement.getText().trim().equals(expectedItem)) {
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tempElement);
				sleepInSecond(2);
				tempElement.click();
				break;
			}
		}
	}

	public String getTextElement(WebDriver driver, String Locator) {
		return getWebElement(driver, Locator).getText();
	}
	public String getTextElement(WebDriver driver, String Locator, String...dynamicLocator) {
		return getWebElement(driver, castRestParameter(Locator, dynamicLocator)).getText();
	}

	public String getElementAttributeValue(WebDriver driver, String Locator, String attributeName) {
		return getWebElement(driver, Locator).getAttribute(attributeName);
	}

	public String getCssValue(WebDriver driver, String Locator, String propertyName) {
		return getWebElement(driver, Locator).getAttribute(propertyName);
	}

	public int getListElementSize(WebDriver driver, String Locator) {
		return getListElement(driver, Locator).size();
	}

	public void checkToCheckBoxOrRadio(WebDriver driver, String Locator) {
		WebElement element = getWebElement(driver, Locator);
		if (!element.isDisplayed()) {
			element.click();
			;
		}
	}

	public void unCheckToCheckBoxOrRadio(WebDriver driver, String Locator) {
		WebElement element = getWebElement(driver, Locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementEnable(WebDriver driver, String Locator) {
		return getWebElement(driver, Locator).isEnabled();
	}

	/*
	 * Element in DoM
	 *Invisible in DOM
	 */
	public boolean isElementDisplayed(WebDriver driver, String Locator) {
		return getWebElement(driver, Locator).isDisplayed();
	}

	
	/*
	 * Element in DoM
	 *Invisible in DOM
	 */
	public boolean isElementDisplayed(WebDriver driver, String Locator, String... dinamicLocator) {
		return getWebElement(driver, castRestParameter(Locator, dinamicLocator)).isDisplayed();
	}

	
	/*
	 * Element invisible in DOM (2.1)
	 * Element in visible not in DOM (2.2)
	 */
	public boolean isElementUnDisplayed(WebDriver driver, String Locator) {
		setImplicitTime(driver,shortTimeout);
		List<WebElement> elements = getListElement(driver, Locator);
		setImplicitTime(driver,longTimeOut);
		if (elements.size() == 0) {//(2.2)
			System.out.println("Element not in DOM");
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {//(2.1)
			System.out.println("Element in DOM but not available/displayed");
			return true;
		} else {
			System.out.println("Element in DOM and visible");
			return false;
		}
	}
	
	public void setImplicitTime(WebDriver driver, long timeInSencond) {
		driver.manage().timeouts().implicitlyWait(timeInSencond, TimeUnit.SECONDS);
	}

	public boolean isElementSelected(WebDriver driver, String Locator) {
		return getWebElement(driver, Locator).isSelected();
	}

	public void switchToIframe(WebDriver driver, String Locator) {
		driver.switchTo().frame(getWebElement(driver, Locator));

	}

	public void hoverMouseToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, Locator)).perform();

	}

	public void rightClickToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.contextClick(getWebElement(driver, Locator)).perform();

	}

	public void doubleClickToElement(WebDriver driver, String Locator) {
		Actions action = new Actions(driver);
		action.doubleClick(getWebElement(driver, Locator)).perform();

	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		Actions action = new Actions(driver);
		action.dragAndDrop(getWebElement(driver, sourceLocator), getWebElement(driver, targetLocator)).perform();
	}

	public void pressKeyToElement(WebDriver driver, String Locator, Keys key) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, Locator), key).perform();
	}

	public void pressKeyToElement(WebDriver driver, String Locator, Keys key, String dinamicLocator) {
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, castRestParameter(Locator, dinamicLocator)), key).perform();
	}

	/* JavaScript */

	public void hightlightElement(WebDriver driver, String sourceLocator, String locator) {
		WebElement element = getWebElement(driver, sourceLocator);
		String originalStyle = element.getAttribute("style");
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String sourceLocator, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", getWebElement(driver, sourceLocator));
	}

	public void scrollToElementOnTop(WebDriver driver, String sourceLocator, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, sourceLocator));
	}

	public void scrollToElementOnDown(WebDriver driver, String sourceLocator, String locator) {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);", getWebElement(driver, sourceLocator));
	}

	public void sendkeyToElementByJSWebDriver(WebDriver driver, String sourceLocator, String locator, String value) {
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('value', '" + value + "')", getWebElement(driver, sourceLocator));
	}

	public void removeAttributeInDOM(WebDriver driver, String sourceLocator, String locator, String attributeRemove) {
		((JavascriptExecutor) driver).executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, sourceLocator));
	}

	public String getElementValidationMessage(WebDriver driver, String sourceLocator, String locator) {
		return (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].validationMessage;", getWebElement(driver, sourceLocator));
	}

	public boolean isImageLoaded(WebDriver driver, String sourceLocator, String locator) {
		boolean status = (boolean) ((JavascriptExecutor) driver).executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, sourceLocator));
		if (status) {
			return true;
		}
		return false;
	}

	/* Wait */
	public void waitForElementVisible(WebDriver driver, String sourceLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(sourceLocator)));
	}

	// Apply Dynamic
	public void waitForElementVisible(WebDriver driver, String locator, String... dynamicLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(castRestParameter(locator, dynamicLocator))));
	}

	public void waitForElementInVisibleInDOM(WebDriver driver, String sourceLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(sourceLocator)));
	}
	public void waitForElementInVisibleInDOM(WebDriver driver,String locator, String... dynamicLocator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(castRestParameter(locator, dynamicLocator))));
	}
	public void waitForElementInVisibleNotInDOM(WebDriver driver, String sourceLocator) {
		setImplicitTime(driver, shortTimeout);
		new WebDriverWait(driver, shortTimeout).until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(sourceLocator)));
		setImplicitTime(driver, longTimeOut);
		}
	public void waitForElementClickable(WebDriver driver, String Locator) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(getByLocator(Locator)));
	}
	public void waitForElementClickable(WebDriver driver, String locator, String... dynamicLocato) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(getByLocator(castRestParameter(locator, dynamicLocato))));
	}

	public void waitForElementClickable(WebDriver driver, WebElement element) {
		new WebDriverWait(driver, longTimeOut).until(ExpectedConditions.elementToBeClickable(element));
	}

	// upload file
	public void uploadMultipleFile(WebDriver driver, String... fileNames) {
		String uploadFilePath = GlobalConstants.UPLOAD_FILE_PATH;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + uploadFilePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, HomePageUIJquery.UPLOAD_FILE_TYPE).sendKeys(fullFileName);

	}
	
	
	/** Common function for web component*/
	public FooterPageNavigation getFooterPage(WebDriver driver) {
		return new FooterPageNavigation(driver);
	}

	public HomePageObject clickLogoutAdminPage(WebDriver driver) {
		waitForElementClickable(driver, AdminPageBaseUI.CLICK_lOGOUT_ADMIN_PAGE);
		clickToElement(driver, AdminPageBaseUI.CLICK_lOGOUT_ADMIN_PAGE);
		return PageGenerator.getHomePage(driver);
	}

	public AdminLoginPageObject openAdminPageUrl(WebDriver driver, String adminUrl) {
		openPageUrl(driver, adminUrl);
		return PageGenerator.getAdminLoginPage(driver);
	}

	public UserHomePageObject openUserHomePage(WebDriver driver, String userUrl) {
		openPageUrl(driver, userUrl);
		return PageGenerator.getUserHomePage(driver);
	}
	
	public void clickToButtonByTitle(WebDriver driver, String textBoxID) {
		   waitForElementVisible(driver, UserBasePageUI.DYANAMIC_BUTTON_BY_TITLE,textBoxID);
		   clickToElement(driver, UserBasePageUI.DYANAMIC_BUTTON_BY_TITLE, textBoxID);
		}
	
	public void inputToTextBoxByID(WebDriver driver, String valueToInput, String textBoxID) {
	   waitForElementVisible(driver, UserBasePageUI.DYANAMIC_TEXTBOX_BY_ID, textBoxID);
	   senkeyToElement(driver, UserBasePageUI.DYANAMIC_TEXTBOX_BY_ID, valueToInput, textBoxID);
	}
	
	public String getFieldErrorMessageByID(WebDriver driver, String textBoxID) {
		waitForElementVisible(driver,UserBasePageUI.DYANAMIC_FIELD_ERROR_MESSAGE_BY_ID ,textBoxID);
		return getTextElement(driver, UserBasePageUI.DYANAMIC_FIELD_ERROR_MESSAGE_BY_ID, textBoxID);
		
	}
	
	public void selectItemDropdownByID(WebDriver driver, String dropdownID,String dropdownItem ) {
		waitForElementClickable(driver, UserBasePageUI.DYANAMIC_SELECT_DROPDOWN_ITEM, dropdownID);
		selectItemDefaultDropdow(driver, UserBasePageUI.DYANAMIC_SELECT_DROPDOWN_ITEM, dropdownItem, dropdownID);
		
	}

	private long longTimeOut = GlobalConstants.LONG_TIMEOUT;
	private long shortTimeout = GlobalConstants.SORT_TIMEOUT;
	public void sleepInSecond(long timeInSecond) {
		try {
			Thread.sleep(timeInSecond * 1000);

		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}
}
