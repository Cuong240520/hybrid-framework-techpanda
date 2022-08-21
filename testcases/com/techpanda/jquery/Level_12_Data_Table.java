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



public class Level_12_Data_Table extends BaseTest {
	@Parameters({"browser", "Url"})
	@BeforeClass
	public void beforeClass(String browserName, String Url) {
		driver = getBrowserDriver(browserName, Url);
	   
		homePage = PageGeneratorJquery.getDataTablePage(driver);
	}

	@Test
	//1 input vaof textbox
	public void TC_01_DataTable() {
		homePage.inputToFemales("Females", "283821");
		homePage.sleepInSecond(3);
		
		//2 Verify 
		Assert.assertTrue(homePage.isValueIsDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToFemales("Country", "Algeria");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		//2 Verify 
		Assert.assertTrue(homePage.isValueIsDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshCurrentPage(driver);
		
		homePage.inputToFemales("Males", "295140");
		homePage.sleepInSecond(3);
		homePage.refreshCurrentPage(driver);
		//2 Verify 
		Assert.assertTrue(homePage.isValueIsDisplayed("283821","Algeria","295140","578961"));
		homePage.refreshCurrentPage(driver);
		

	
		
		homePage.inputToFemales("Country", "Argentina");
		homePage.sleepInSecond(3);
		//2 Verify 
		Assert.assertTrue(homePage.isValueIsDisplayed("338282","Argentina","349238","687522"));
		homePage.deleteCountry("Argentina","remove");
		homePage.sleepInSecond(3);
	}
	
	
		
		

	@AfterClass
	public void afterClass() {
		driver.quit();
	}
	WebDriver driver;
	HomePageObjectJquery homePage;
	
}
