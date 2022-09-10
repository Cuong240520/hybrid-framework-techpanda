package com.facebook;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageObject.facebook.LoginPageObject;
import pageObject.facebook.PageGeneratorFacebook;


public class Level_19_Element_Undisplayed extends BaseTest {
	WebDriver driver;

	LoginPageObject loginPage;

	@Parameters({ "browser", "Url" })
	@BeforeClass
	public void beforeClass(String browserName, String userUrl) {
		driver = getBrowserDriver(browserName, userUrl);
		loginPage = PageGeneratorFacebook.getLoginPage(driver);
	}

	@Test
	public void TC_01_Visible() {
		loginPage.clickToRegisterAccountButton();
		loginPage.enterEmail("daominhdam@gmail.com");
		loginPage.waitForReEnterEmailVisible();
		Assert.assertTrue(loginPage.isReEnterEmailisDisplayed());
	}
	
	@Test
	public void TC_02_InVisible() {
		loginPage.enterEmail("");
		loginPage.waitForReEnterInVisibleInDom();
		Assert.assertTrue(loginPage.isReEnterEmailisUnDisplayed());
	}
	
	@Test
	public void TC_03_InVisibleNotInDOM() {
		loginPage.clickToClosePopupButton();
		loginPage.sleepInSecond(3);
		loginPage.waitForReEnterInVisibleNotInDom();
		Assert.assertTrue(loginPage.isReEnterEmailisUnDisplayed());
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

}
