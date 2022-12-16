package commons;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import PageUIs.nopCommerce.user.BasePageUI;
import pageObjects.noCommerce.admin.AdminLoginPageObject;
import pageObjects.nopCommerce.user.UserAddressPageObJect;
import pageObjects.nopCommerce.user.UserBackInStockSubscriptonsPageObjects;
import pageObjects.nopCommerce.user.UserChangeMyPasswordPageObjects;
import pageObjects.nopCommerce.user.UserCustomerInfoPageObjects;
import pageObjects.nopCommerce.user.UserDownloadAbleProductsPageObjects;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserOrderPage;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class BasePage {
	
	public static BasePage getBasePageObject() {
		return new BasePage();
	}
	//Mở 1 URL
	//Common fuction
	public void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	public String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	public String getPageSourceCode(WebDriver driver) {
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
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	public void acceptAlert(WebDriver driver) {
		Alert alert =  waitForAlertPresence(driver);
		alert.accept();
	}
	public void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	public void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	public void switchToWindowByID(WebDriver driver,String otherID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		
		for (String id : allWindownIDs) {
			if(!id.equals(otherID)) {
				driver.switchTo().window(id);
			}
		}
	
	}
    public void switchToWindownByPageTitle(WebDriver driver,String expectedPageTitle) {
    	Set<String> allWindownTitle = driver.getWindowHandles();
    	for (String id : allWindownTitle) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(expectedPageTitle)) {
				break;
			}
			
		}
    }
    public void closeWindownWithoutParent(WebDriver driver,String parentID) {
    	Set<String> allWindownID = driver.getWindowHandles();
    	
    	for (String id : allWindownID) {
    		if(!id.equals(parentID)) {
    			driver.switchTo().window(id);
        		driver.close();
    		}
		}
    	driver.switchTo().window(parentID);
    }
//    private By getByxpath(String xpathLocator) {
//    	return By.xpath(xpathLocator);
//    }
    //locator id=/ css=/ xpath=/ name=/ class=
    private By getByLocator(String locatorType) {
    	By by = null;
    	if(locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
    		by = By.id(locatorType.substring(3));
    	} else if(locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
    		by = By.cssSelector(locatorType.substring(4));
    	} else if(locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
    		by = By.xpath(locatorType.substring(6));
    	} else if(locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
    		by = By.className(locatorType.substring(6));
    	} else if(locatorType.startsWith("name=") || locatorType.startsWith("NAME=") || locatorType.startsWith("Name=")) {
    		by = By.name(locatorType.substring(5));
    	} else {
    		throw new RuntimeException("Locator type is not support");
    	}
    	return by;
    }
    
    private WebElement getWebElement(WebDriver driver,String locator) {
    	return driver.findElement(getByLocator(locator));
    }
    private List<WebElement> getListWebElement(WebDriver driver,String locator) {
    	return driver.findElements(getByLocator(locator));
    	
    }
    public void clickToElement(WebDriver driver,String locator) {
    	getWebElement(driver,locator).click();
    }
    public void sendkeyToElement(WebDriver driver,String locator, String textValue) {
    	WebElement element = getWebElement(driver,locator);
    	element.clear();
    	element.sendKeys(textValue);
    }
    public void selectItemInDefaultDropdown(WebDriver driver,String locator, String textItem) {
    	Select select = new Select(getWebElement(driver,locator));
    	select.selectByValue(textItem);
    }
    
    public String getSelectedItemDefaultDropDown(WebDriver driver,String locator) {
    	Select select = new Select(getWebElement(driver,locator));
    	return select.getFirstSelectedOption().getText();
    }
    
    public boolean isDropdownMultiple(WebDriver driver,String locator) {
    	Select select = new Select(getWebElement(driver,locator));
    	return select.isMultiple();
    }
    public void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    public void selectItemInDropdown(WebDriver driver,String parentLocator, String childLocator, String expectedItem) {
    	getWebElement(driver,parentLocator).click();
        sleepInSecond(2);
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		
		List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childLocator)));
		for (WebElement item : allItem) {
			if (item.getText().trim().equals(expectedItem)) {
				((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				item.click();
				break;
			}
		}
		
	}
    public String getElementAttribute(WebDriver driver,String locator, String attributeName) {
    	return getWebElement(driver,locator).getAttribute(attributeName);
    }
    
    public String getElementText(WebDriver driver,String locator) {
    	return getWebElement(driver,locator).getText();
    }
	
    public String getElementCssValue(WebDriver driver,String locator,String propetyName) {
    	return getWebElement(driver,locator).getCssValue(propetyName);
    }
	public String getHexaColorFromRGBD(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver,String locator) {
		return getListWebElement(driver,locator).size();
	}
	public void checkToDefaultCheckBoxRadioButton(WebDriver driver,String locator) {
		WebElement element = getWebElement(driver, locator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToDefaultCheckBox(WebDriver driver,String locator) {
		WebElement element = getWebElement(driver, locator);
		if(element.isSelected()) {
			element.click();
		}
	}
	public boolean isElementDisplay(WebDriver driver,String locator) {
		return getWebElement(driver, locator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver,String locator) {
		return getWebElement(driver, locator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String locator) {
		return getWebElement(driver, locator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver,String locator) {
		driver.switchTo().frame(getWebElement(driver, locator));
	}
    public void switchToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver,String locator) {
    	Actions action = new Actions(driver);
    	action.moveToElement(getWebElement(driver, locator)).perform();
    }
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	public void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	public void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}
	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}
	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 20);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}
	public String getElementValidationMessage(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locator));
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	public void waitForElementVisble(WebDriver driver,String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locator)));
	}
	public void waitForAllElementVisible(WebDriver driver,String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locator)));
	}
	public void waitForElementInVisble(WebDriver driver,String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locator)));
	}
	public void waitForAllElementInVisible(WebDriver driver,String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locator)));
	}
	
	public void waitToElementClickable(WebDriver driver,String locator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locator)));
	}
	public UserMyProductReviewPageObject openMyProductReviewPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, BasePageUI.MY_PRODUCT_REVIEW_LINK);
		return new UserMyProductReviewPageObject(driver);
	}
	
	public UserRewardPointPageObject openRewardPoinPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.REWARD_POINT_LINK);
		clickToElement(driver, BasePageUI.REWARD_POINT_LINK);
		return new UserRewardPointPageObject(driver);
	}
	
	public UserAddressPageObJect openAddressPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitToElementClickable(driver, BasePageUI.ADDRESS_LINK);
		clickToElement(driver, BasePageUI.ADDRESS_LINK);
		return new UserAddressPageObJect(driver);
	}
	public UserCustomerInfoPageObjects openMyAccountPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.MY_ACCOUNT_LINK);
		clickToElement(driver, BasePageUI.MY_ACCOUNT_LINK);
		return new UserCustomerInfoPageObjects(driver);
	}
	
	public UserOrderPage openOrderPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.ORDER_LINK);
		clickToElement(driver, BasePageUI.ORDER_LINK);
		return new UserOrderPage(driver);
	}
	public UserDownloadAbleProductsPageObjects openDownloadAbleProductPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.DOWNLOAD_PRODUCT_LINK);
		clickToElement(driver, BasePageUI.DOWNLOAD_PRODUCT_LINK);
		return new UserDownloadAbleProductsPageObjects(driver);
	}
	
	public UserBackInStockSubscriptonsPageObjects openStockSubscriptonsPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.STOCK_SUBSCRIPTION_LINK);
		clickToElement(driver, BasePageUI.STOCK_SUBSCRIPTION_LINK);
		return new UserBackInStockSubscriptonsPageObjects(driver);
	}
	public UserChangeMyPasswordPageObjects openChangeMyPasswordPage(WebDriver driver) {
		// TODO Auto-generated method stub
		waitForElementVisble(driver, BasePageUI.CHANGE_MY_PASSWORD_LINK);
		clickToElement(driver, BasePageUI.CHANGE_MY_PASSWORD_LINK);
		return new UserChangeMyPasswordPageObjects(driver);
	}
	
	public UserHomePageObject clickToLogoutLinkAtUser(WebDriver driver) {
		waitForElementVisble(driver, BasePageUI.USER_LOGOUT_LINK);
		clickToElementByJS(driver, BasePageUI.USER_LOGOUT_LINK);
		return PageGeneratorManager.getUserHomePage(driver);
	}
	
	public AdminLoginPageObject clickToLogoutLinkAtAdmin(WebDriver driver) {
		waitForElementVisble(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		clickToElementByJS(driver, BasePageUI.ADMIN_LOGOUT_LINK);
		return PageGeneratorManager.getAdminLoginPage(driver);
	}
}
