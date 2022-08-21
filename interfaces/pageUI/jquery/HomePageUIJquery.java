package pageUI.jquery;

public class HomePageUIJquery {
	public static final String HEADER_NAME_TEXTBOX = "xpath=//div[text()='%s']/parent::div/following-sibling::input";
	public static final String ACTION_VALUE = "xpath=//td[@data-key='country' and text()='%s']//preceding-sibling::td[@class='qgrd-actions']//button[contains(@class,%s)]";
	public static final String ROW_VALUE = "xpath=//td[@data-key='females' and text()='%s']/following-sibling::td[@data-key='country' and text()='%s']/following-sibling::td[@data-key='males' and text()='%s']/following-sibling::td[@data-key='total' and text()='%s']";

	public static final String UPLOAD_FILE_TYPE = "css=input[type='file']";
	public static final String FILE_NAME_UPLOADED = "xpath=//p[text()='%s']";
	public static final String START_BUTTON = "css=table button.start";
	public static final String FILE_NAME_UPLOADED_SUCCESS = "xpath=//a[@title='%s']";
}
