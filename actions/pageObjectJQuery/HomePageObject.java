package pageObjectJQuery;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PageUIs.JQuery.HomePageUI;
import commons.BasePage;

public class HomePageObject extends BasePage {
	WebDriver driver;

	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageByNumber(String pageNumber) {
		waitToElementClickable(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		clickToElement(driver, HomePageUI.PAGINATION_PAGE_BY_NUMBER, pageNumber);
		
	}

	public void enterToHeaderTextBoxByLabel(String headerLabel, String value) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, HomePageUI.HEARDER_TEXTBOX_BY_LABEL, headerLabel);
		sendkeyToElement(driver, HomePageUI.HEARDER_TEXTBOX_BY_LABEL, value,headerLabel);
		pressKeyToElement(driver, HomePageUI.HEARDER_TEXTBOX_BY_LABEL, Keys.ENTER, headerLabel);
	}

	public boolean isPageNumberActive(String pageNumber) {
		waitForElementVisble(driver, HomePageUI.PAGINATION_ACTIVE_BY_NUMBER,pageNumber);
		return isElementDisplay(driver, HomePageUI.PAGINATION_ACTIVE_BY_NUMBER,pageNumber);
	}

	public List<String> getValueEachRowAtAllPage() {
		int totalPage = getElementSize(driver, HomePageUI.TOTAL_PAGINATION);
		System.out.println("Total size " + totalPage);
		List<String> allRowValuesAllPage = new ArrayList<String>();
		//Duyệt qua tất cả các page
		for(int index = 0; index< totalPage; index++) {
			clickToElement(driver, HomePageUI.PAGINATION_INDEX, String.valueOf(index+1));
			sleepInSecond(2);
			// Get Text cua all row mỗi page đưa vào list
			List<WebElement> allRowEachPage = getListWebElement(driver, HomePageUI.ALL_ROW_EACH_PAGE);
			for (WebElement eachRow : allRowEachPage) {
				allRowValuesAllPage.add(eachRow.getText());
			}
		}
		
		// in ra tat ca gia tri cua row ở tất cả các page
		for(String value: allRowValuesAllPage) {
			System.out.println("");
			System.out.println(value);
		}
		
		
		return allRowValuesAllPage;
	}

	public void enterToTextBoxByColummnNameAtRowNumberColumName(String columnName, String rowNumber, String value) {
		//Column index dựa vào tên cột
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME ,columnName) + 1;
		
		//send key vào dòng
		//tbody/tr[%s]/th[%s]
		waitForElementVisble(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		sendkeyToElement(driver, HomePageUI.TEXTBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
		
		
		
		
	}

	public void selectDropDownAtRowNumber(String columnName, String rowNumber, String value) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME ,columnName) + 1;
		waitToElementClickable(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		selectItemInDefaultDropdown(driver, HomePageUI.DROPDOWN_BY_COLUMN_INDEX_AND_ROW_INDEX, value, rowNumber, String.valueOf(columnIndex));
		
	}

	public void clickToLoadDataButton() {
		waitToElementClickable(driver, HomePageUI.LOAD_DATA_BUTTON);
		clickToElement(driver, HomePageUI.LOAD_DATA_BUTTON);
		
	}

	public void checkToCheckBoxAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME ,columnName) + 1;
		waitToElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		checkToDefaultCheckBoxRadioButton(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		
	}

	public void unheckToCheckBoxAtRowNumber(String columnName, String rowNumber) {
		int columnIndex = getElementSize(driver, HomePageUI.COLUMN_INDEX_BY_NAME ,columnName) + 1;
		waitToElementClickable(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		uncheckToDefaultCheckBox(driver, HomePageUI.CHECKBOX_BY_COLUMN_INDEX_AND_ROW_INDEX, rowNumber, String.valueOf(columnIndex));
		
	}

	public void clickToIconByRowNUmber(String rowNumber, String iconName) {
		waitToElementClickable(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber,iconName);
		clickToElement(driver, HomePageUI.ICON_NAME_BY_ROW_NUMBER, rowNumber,iconName);
		
	}
	
	
	
}
