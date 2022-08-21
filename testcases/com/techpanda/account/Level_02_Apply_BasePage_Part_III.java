package com.techpanda.account;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import commons.BasePage;

public class Level_02_Apply_BasePage_Part_III extends BasePage {
	WebDriver driver;
	String projectPath = System.getProperty("user.dir");
	WebDriverWait expliciptWait;

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", projectPath + "\\browserDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	expliciptWait = new WebDriverWait(driver, 15);
	}

	
	@Test
	public void TC_01_LoginWithEmptyEmailAndPassword() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		senkeyToElement(driver,"//input[@id='email']", "");
		senkeyToElement(driver,"//input[@id='pass']", "");
		clickToElement(driver, "//button[@id='send2']");

	    assertEquals(getTextElement(driver, "//div[@id='advice-required-entry-email']"), "This is a required field.");
		assertEquals(getTextElement(driver, "//div[@id='advice-required-entry-pass']"), "This is a required field.");
	}

	@Test
	public void TC_02_LoginWithInvalidEmail() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		senkeyToElement(driver,"//input[@id='email']", "123@456.789");
		senkeyToElement(driver,"//input[@id='pass']", "123456");
		clickToElement(driver, "//button[@id='send2']");

	    assertEquals(getTextElement(driver, "//div[@id='advice-validate-email-email']"), "Please enter a valid email address. For example johndoe@domain.com.");
	}

	@Test
	public void TC_03_LoginWithIncorrectEmail() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		senkeyToElement(driver,"//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
		senkeyToElement(driver,"//input[@id='pass']", "123456");
		clickToElement(driver, "//button[@id='send2']");

		assertEquals(getTextElement(driver, "//li[@class='error-msg']//span"), "Invalid login or password.");
	}

	@Test
	public void TC_04_LoginWithInvalidPassword() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		senkeyToElement(driver,"//input[@id='email']", "auto_test" + randomNumber() + "@live.com");
		senkeyToElement(driver,"//input[@id='pass']", "123");
		clickToElement(driver, "//button[@id='send2']");

		assertEquals(getTextElement(driver, "//div[@id='advice-validate-password-pass']"), "Please enter 6 or more characters without leading or trailing spaces.");
	}

	@Test
	public void TC_05_LoginWithIncorrectPassword() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		driver.findElement(By.id("email")).sendKeys("auto_test" + randomNumber() + "@live.com");
		driver.findElement(By.id("pass")).sendKeys(randomNumber() + "");
		driver.findElement(By.id("send2")).click();
		
		assertEquals(driver.findElement(By.xpath("//li[@class='error-msg']//span")).getText(), "Invalid login or password.");
	}

	@Test
	public void TC_06_LoginWithValidEmailAndPassword() {
		openPageUrl(driver, "http://live.techpanda.org/");
		clickToElement(driver, "//div[@class='footer']//a[text()='My Account']");
		
		senkeyToElement(driver,"//input[@id='email']", "automationfc.vn@gmail.com");
		senkeyToElement(driver,"//input[@id='pass']", "123123");
		clickToElement(driver, "//button[@id='send2']");

		assertTrue(isElementDisplayed(driver, "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'Automation FC')]"));
	    assertTrue(isElementDisplayed(driver, "//h3[text()='Contact Information']/parent::div/following-sibling::div[@class='box-content']/p[contains(.,'automationfc.vn@gmail.com')]"));
		
	}

	@AfterClass
	public void afterClass() {
		driver.quit();
	}

	private int randomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

}
