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

public class BasePageFactory {
	
	public static BasePageFactory getBasePageObject() {
		return new BasePageFactory();
	}
	//Mở 1 URL
	//Common fuction
	protected void openPageUrl(WebDriver driver, String pageUrl) {
		driver.get(pageUrl);
	}
	
	protected String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}
	protected String getPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}
	protected String getPageSourceCode(WebDriver driver) {
		return driver.getPageSource();
	}
	
	protected void backToPage(WebDriver driver) {
		driver.navigate().back();
	}
	protected void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}
	protected void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	protected Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	protected void acceptAlert(WebDriver driver) {
		Alert alert =  waitForAlertPresence(driver);
		alert.accept();
	}
	protected void cancelAlert(WebDriver driver) {
		waitForAlertPresence(driver).dismiss();
	}
	protected String getAlertText(WebDriver driver) {
		return waitForAlertPresence(driver).getText();
	}
	protected void sendKeyToAlert(WebDriver driver, String textValue) {
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	protected void switchToWindowByID(WebDriver driver,String otherID) {
		Set<String> allWindownIDs = driver.getWindowHandles();
		
		for (String id : allWindownIDs) {
			if(!id.equals(otherID)) {
				driver.switchTo().window(id);
			}
		}
	
	}
    protected void switchToWindownByPageTitle(WebDriver driver,String expectedPageTitle) {
    	Set<String> allWindownTitle = driver.getWindowHandles();
    	for (String id : allWindownTitle) {
			driver.switchTo().window(id);
			String actualTitle = driver.getTitle();
			if(actualTitle.equals(expectedPageTitle)) {
				break;
			}
			
		}
    }
    protected void closeWindownWithoutParent(WebDriver driver,String parentID) {
    	Set<String> allWindownID = driver.getWindowHandles();
    	
    	for (String id : allWindownID) {
    		if(!id.equals(parentID)) {
    			driver.switchTo().window(id);
        		driver.close();
    		}
		}
    	driver.switchTo().window(parentID);
    }
    private By getByxpath(String xpathLocator) {
    	return By.xpath(xpathLocator);
    }
    private WebElement getWebElement(WebDriver driver,String xpathLocator) {
    	return driver.findElement(By.xpath(xpathLocator));
    }
    private List<WebElement> getListWebElement(WebDriver driver,String xpathLocator) {
    	return driver.findElements(getByxpath(xpathLocator));
    	
    }
    protected void clickToElement(WebDriver driver,String xpathLocator) {
    	getWebElement(driver,xpathLocator).click();
    }
    protected void senkeyToElement(WebDriver driver,String xpathLocator, String textValue) {
    	WebElement element = getWebElement(driver,xpathLocator);
    	element.clear();
    	element.sendKeys(textValue);
    }
    protected void selectItemInDefaultDropdown(WebDriver driver,String xpathLocator, String textItem) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
    	select.selectByValue(textItem);
    }
    
    protected String getSelectedItemDefaultDropDown(WebDriver driver,String xpathLocator) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
    	return select.getFirstSelectedOption().getText();
    }
    
    protected boolean isDropdownMultiple(WebDriver driver,String xpathLocator) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
    	return select.isMultiple();
    }
    protected void sleepInSecond (long timeSecond) {
		try {
			Thread.sleep(timeSecond * 1000);
		}catch (InterruptedException e ) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
    protected void selectItemInDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedItem) {
    	getWebElement(driver,parentXpath).click();
        sleepInSecond(2);
		WebDriverWait explicitWait = new WebDriverWait(driver,30);
		
		List<WebElement> allItem = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByxpath(childXpath)));
		for (WebElement item : allItem) {
			if (item.getText().trim().equals(expectedItem)) {
				((JavascriptExecutor) driver).executeScript("argument[0].scrollIntoView(true);", item);
				sleepInSecond(2);
				item.click();
				break;
			}
		}
		
	}
    protected String getElementAttribute(WebDriver driver,String xpathLocator, String attributeName) {
    	return getWebElement(driver,xpathLocator).getAttribute(attributeName);
    }
    
    protected String getElementText(WebDriver driver,String xpathLocator) {
    	return getWebElement(driver,xpathLocator).getText();
    }
	
    protected String getElementCssValue(WebDriver driver,String xpathLocator,String propetyName) {
    	return getWebElement(driver,xpathLocator).getCssValue(propetyName);
    }
	protected String getHexaColorFromRGBD(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	protected int getElementSize(WebDriver driver,String xpathLocator) {
		return getListWebElement(driver,xpathLocator).size();
	}
	protected void checkToDefaultCheckBoxRadioButton(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	protected void uncheckToDefaultCheckBox(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	protected boolean isElementDisplay(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	protected boolean isElementEnable(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	protected boolean isElementSelected(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	protected void switchToFrame(WebDriver driver,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
    protected void switchToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    protected void hoverMouseToElement(WebDriver driver,String xpathLocator) {
    	Actions action = new Actions(driver);
    	action.moveToElement(getWebElement(driver, xpathLocator)).perform();
    }
	protected void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	protected void highlightElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	protected void clickToElementByJS(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locator));
	}

	protected void scrollToElement(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locator));
	}
	protected void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locator));
	}
	protected boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
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
	protected String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
	}

	protected boolean isImageLoaded(WebDriver driver, String locator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth != \"undefined\" && arguments[0].naturalWidth > 0", getWebElement(driver, locator));
		if (status) {
			return true;
		} else {
			return false;
		}
	}
	protected void waitForElementVisble(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOf(element));
	}
	protected void waitForAllElementVisible(WebDriver driver,List<WebElement> listElement) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOfAllElements(listElement));
	}
	protected void waitForElementInVisble(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOf(element));
	}
	protected void waitForAllElementInVisible(WebDriver driver,List<WebElement> listElement) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(listElement));
	}
	
	protected void waitToElementClickable(WebDriver driver,WebElement element) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(element));
	}
}
