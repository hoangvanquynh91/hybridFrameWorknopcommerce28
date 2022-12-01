package commons;

import java.awt.Desktop.Action;
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

public class BasePage {
	
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
    
    private By getByxpath(String xpathLocator) {
    	return By.xpath(xpathLocator);
    }
    
    private WebElement getWebElement(WebDriver driver,String xpathLocator) {
    	return driver.findElement(By.xpath(xpathLocator));
    }
    private List<WebElement> getListWebElement(WebDriver driver,String xpathLocator) {
    	return driver.findElements(getByxpath(xpathLocator));
    	
    }
    
    public void clickToElement(WebDriver driver,String xpathLocator) {
    	getWebElement(driver,xpathLocator).click();
    }
    public void senkeyToElement(WebDriver driver,String xpathLocator, String textValue) {
    	WebElement element = getWebElement(driver,xpathLocator);
    	element.clear();
    	element.sendKeys(textValue);
    }
    
    
    public void selectItemInDefaultDropdown(WebDriver driver,String xpathLocator, String textItem) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
    	select.selectByValue(textItem);
    }
    
    public String getSelectedItemDefaultDropDown(WebDriver driver,String xpathLocator) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
    	return select.getFirstSelectedOption().getText();
    }
    
    public boolean isDropdownMultiple(WebDriver driver,String xpathLocator) {
    	Select select = new Select(getWebElement(driver,xpathLocator));
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
	
    
    public void selectItemInDropdown(WebDriver driver,String parentXpath, String childXpath, String expectedItem) {
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
    
    public String getElementAttribute(WebDriver driver,String xpathLocator, String attributeName) {
    	return getWebElement(driver,xpathLocator).getAttribute(attributeName);
    }
    
    public String getElementText(WebDriver driver,String xpathLocator) {
    	return getWebElement(driver,xpathLocator).getText();
    }
	
    public String getElementCssValue(WebDriver driver,String xpathLocator,String propetyName) {
    	return getWebElement(driver,xpathLocator).getCssValue(propetyName);
    }
	public String getHexaColorFromRGBD(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver,String xpathLocator) {
		return getListWebElement(driver,xpathLocator).size();
	}
	
	public void checkToDefaultCheckBoxRadioButton(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(!element.isSelected()) {
			element.click();
		}
	}
	public void uncheckToDefaultCheckBox(WebDriver driver,String xpathLocator) {
		WebElement element = getWebElement(driver, xpathLocator);
		if(element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplay(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isDisplayed();
	}
	
	public boolean isElementEnable(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isEnabled();
	}
	public boolean isElementSelected(WebDriver driver,String xpathLocator) {
		return getWebElement(driver, xpathLocator).isSelected();
	}
	
	public void switchToFrame(WebDriver driver,String xpathLocator) {
		driver.switchTo().frame(getWebElement(driver, xpathLocator));
	}
    public void switchToDefaultContent(WebDriver driver) {
    	driver.switchTo().defaultContent();
    }
    public void hoverMouseToElement(WebDriver driver,String xpathLocator) {
    	Actions action = new Actions(driver);
    	action.moveToElement(getWebElement(driver, xpathLocator)).perform();
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

	public String getElementValidationMessage(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, xpathLocator));
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
	
	public void waitForElementVisble(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathLocator)));
	}
	public void waitForAllElementVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(xpathLocator)));
	}
	public void waitForElementInVisble(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpathLocator)));
	}
	public void waitForAllElementInVisible(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver,20);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, xpathLocator)));
	}
	
	public void waitToElementClickable(WebDriver driver,String xpathLocator) {
		WebDriverWait explicitWait = new WebDriverWait(driver, 30);
		explicitWait.until(ExpectedConditions.elementToBeClickable(By.xpath(xpathLocator)));
	}
	
	
}
