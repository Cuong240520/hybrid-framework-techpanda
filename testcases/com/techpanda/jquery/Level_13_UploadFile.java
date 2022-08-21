package com.techpanda.jquery;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import commons.BaseTest;
import pageOpject.jquery.HomePageObjectJquery;
import pageOpject.jquery.PageGeneratorJquery;

public class Level_13_UploadFile extends BaseTest {
	@Parameters({ "browser", "Url" })
	@BeforeClass
	public void beforeClass(String browserName, String Url) {
		driver = getBrowserDriver(browserName, Url);

		homePage = PageGeneratorJquery.getDataTablePage(driver);
	}

	@Test
	// 1 input vaof textbox
	public void TC_01_Upload_One_File() {

		homePage.uploadMultipleFile(driver, phone13);

		Assert.assertTrue(homePage.isFileNameIsDisplayed(phone13));

		homePage.clickStartButton();

		Assert.assertTrue(homePage.isFileNameUploadSuccess(phone13));

	}

	@Test
	public void TC_02_Upload_Multiple_File() {
		homePage.refreshCurrentPage(driver);
		homePage.uploadMultipleFile(driver, phone10, phone4, phone5);

		Assert.assertTrue(homePage.isFileNameIsDisplayed(phone10));
		Assert.assertTrue(homePage.isFileNameIsDisplayed(phone4));
		Assert.assertTrue(homePage.isFileNameIsDisplayed(phone5));

		homePage.clickStartButton();

		Assert.assertTrue(homePage.isFileNameUploadSuccess(phone10));
		Assert.assertTrue(homePage.isFileNameUploadSuccess(phone4));
		Assert.assertTrue(homePage.isFileNameUploadSuccess(phone5));

	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	WebDriver driver;
	HomePageObjectJquery homePage;
	String phone10 = "Iphone10.jpg";
	String phone13 = "Iphone13.jpg";
	String phone4 = "Iphone4.jpg";
	String phone5 = "Iphone5.jpg";

}
