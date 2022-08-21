package pageOpject.jquery;

import org.openqa.selenium.WebDriver;

public class PageGeneratorJquery {
	public static HomePageObjectJquery getDataTablePage(WebDriver driver) {
		return new HomePageObjectJquery(driver);
	}
}
