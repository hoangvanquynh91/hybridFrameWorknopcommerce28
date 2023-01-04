package pageObjects.jQuery.uploadFileUI;

public class HomePageUI {
	public static final String FILE_NAME_LOADED = "xpath=//p[@class='name' and text()='%s']";
	public static final String FILE_NAME_UPLOADED_LINK = "xpath=//p[@class='name']/a[text()='%s']";
	public static final String FILE_NAME_UPLOADED_IMAGE = "xpath=//a[@title='%s']/img";
	public static final String START_BUTTON = "xpath=//table//button[contains(@class,'start')]";

}
