package com.ecom.osa.genericUtility;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
 
public class WebDriverUtility {
	
	/**
	 * This is to maximize the browser
	 * @author Deepthi
	 * @param driver
	 */
	public void maximizeWindow(WebDriver driver)
	
	{
		driver.manage().window().maximize();
	}
	/**
	 This is for implicit wait
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	/**
	 * this is for element visibility-explicit wait
	 * @param driver
	 * @param element
	 */
	public void elementToBeVisible(WebDriver driver, WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(element));
	}
	
	
	/**
	 * This method will select the data from dropdown using visible text
	 * @param element
	 * @param text
	 */
	
	public void select(String text,WebElement element)
	{
		Select sel = new Select(element);
		sel.selectByVisibleText(text);
	}
	/**
	 * This method will select data from dropdown using value
	 * @param element
	 * @param value
	 */
	
	public void select(WebElement element,String value)
	{
		Select sel = new Select(element);
		sel.selectByValue(value);
	}
	
	/**
	 * /**
	 * This method will select data from dropdown using index
	 * @param element
	 * @param value
	*/
	public void select(WebElement element, int index)
	{
		Select sel = new Select(element);
		sel.selectByIndex(index);
	}
	/**
	 * this method will perform mousehover action
	 * @param driver
	 * @param element
	 */
	
	public void mousehover(WebDriver driver, WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element);
	}
	/**
	 * This method will perform drag and drop action
	 * @param driver
	 * @param src
	 * @param dst
	 */
	
	public void dragAnddrop(WebDriver driver, WebElement src, WebElement dst)
	{
		Actions act = new Actions(driver);
		act.dragAndDrop(src, dst);
	}
	/**
	 * this  will perform double click on weebpage
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.doubleClick().perform();
	}
	
	/**
	 * this is to perform right click on webpage 
	 * @param driver
	 */
	public void rightClick(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.contextClick().perform();
	}
	
	/**
	 * this is to perform right click on element
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element)
	{
		Actions act= new Actions(driver);
		act.contextClick(element).perform();
	}
	/**
	 * This method will Press Enter Key
	 * This method will Press Enter Key
	 * @param driver
	 */
	
	public void enterKeyPress(WebDriver driver)
	{
		Actions act= new Actions(driver);
		act.sendKeys(Keys.ENTER).perform();
	}
	
	/**
	 * This method will Press Enter Key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterKey(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyPress(KeyEvent.VK_ENTER);
	}
	/**
	 * This method is used to release the key
	 * @param driver
	 * @throws Throwable
	 */
	public void enterRelease(WebDriver driver) throws Throwable
	{
		Robot rb= new Robot();
		rb.keyRelease(KeyEvent.VK_ENTER);
	}
	/**
	 * This method will switch the frame based on index
	 * @param driver
	 * @param index
	 */
	public void switchToFrame(WebDriver driver, int index)
	{
		driver.switchTo().frame(index);
	}
	/**
	 * This method will switch the frame based on nameOrID
	 * @param driver
	 * @param nameOrID
	 */
	public void switchToFrame(WebDriver driver, String nameOrID)
	{
		driver.switchTo().frame(nameOrID);
	}
	/**
	 * This method will switch the frame based on address
	 * @param driver
	 * @param address
	 */
	public void switchToFrame(WebDriver driver, WebElement address)
	{
		driver.switchTo().frame(address);
	}
	/**
	 * alert pop up accept button 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/**
	 * this method is used to handle alert pop up
	 * @param driver
	 */
	
	public void cancelAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	
	/**
	 * this method will switch between windows
	 * @param driver
	 * @param partialTitle
	 */
	public void switchToWindow(WebDriver driver, String partialTitle)
	{
	
	//step1: use getWindowHandes to capture all window id's
	Set<String> windows = driver.getWindowHandles();
	
	//step2: iterate through the windows
	Iterator<String> it = windows.iterator();
	
	//step3: check whether there is next window
	while(it.hasNext())
	{
		//step4: capture current window id
		String winId = it.next();
		
		//step5: switch to current window and capture title 
		String currentWinTitle = driver.switchTo().window(winId).getTitle();
		
		//step6: check whether current window is expected
		if(currentWinTitle.contains(partialTitle))
		{
			break;
		}
	}
}
/**
 * this is used to take screenshot
 * @param driver
 * @param screenShotName
 * @return
 * @throws Throwable
 */


public static String getScreenShot(WebDriver driver, String screenShotName) throws Throwable
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src = ts.getScreenshotAs(OutputType.FILE);
	String path = ".\\screenshot\\"+screenShotName+".png";
	File dst = new File(path);
	FileUtils.copyFile(src, dst);
	return path;
	
}


/**
 * this will perform scroll bar action
 * @param driver
 */
public void scrollBarAction(WebDriver driver)
{
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	jse.executeScript("window.scrollBy(0,800)","");
}

/**
 * this element will scroll until element is found
 * @param driver
 * @param element
 */
public void scrollAction(WebDriver driver, WebElement element)
{
	JavascriptExecutor jse = (JavascriptExecutor) driver;
	int y = element.getLocation().getY();
	jse.executeScript("window.scrollBy(0,"+y+")", element);
	//jse.executeScript("argument[0].scrollIntoView()", element);
}
	
}
