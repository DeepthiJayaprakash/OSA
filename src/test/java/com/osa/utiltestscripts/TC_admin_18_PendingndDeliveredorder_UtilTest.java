package com.osa.utiltestscripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.ecom.osa.genericUtility.ExcelUtility;
import com.ecom.osa.genericUtility.FileUtility;
import com.ecom.osa.genericUtility.JavaUtility;
import com.ecom.osa.genericUtility.WebDriverUtility;

public class TC_admin_18_PendingndDeliveredorder_UtilTest {

	public static void main(String[] args) throws Throwable
	{
		//DatabaseUtility dLib = new DatabaseUtility();
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		int rand = jLib.getRandomNo();
		String adminUrl = fLib.getPropertyKeyvalue("Aurl");
		String adminUsername = fLib.getPropertyKeyvalue("Ausername");
		String adminPassword = fLib.getPropertyKeyvalue("Apassword");
		String userUrl = fLib.getPropertyKeyvalue("Uurl");
		String userUsername = fLib.getPropertyKeyvalue("Uusername");
		String userPassword = fLib.getPropertyKeyvalue("Upassword");

		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(adminUrl);
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button")).click();

		driver.findElement(By.xpath("//a[contains(.,'Create')]")).click();
		String categoryName = eLib.getDataFromExcel("CatTestdata", 0, 1)+rand;
		String categorydescription = eLib.getDataFromExcel("CatTestdata", 1, 1);
		driver.findElement(By.name("category")).sendKeys(categoryName);
		driver.findElement(By.name("description")).sendKeys(categorydescription);
		driver.findElement(By.name("submit")).click();
		driver.findElement(By.xpath("//a[contains(.,'Sub Category ')]")).click();
		WebElement catDrop =driver.findElement(By.xpath("//select[@name='category']"));
		wLib.select(categoryName, catDrop);
		Thread.sleep(500);
		String subcategoryName = eLib.getDataFromExcel("SubTestdata", 0, 1)+rand;
		driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys(subcategoryName);
		driver.findElement(By.xpath("//button[.='Create']")).click();  
		driver.findElement(By.xpath("//a[contains(.,'Insert Product ')]")).click();
		Thread.sleep(500);
		WebElement catDrop1 =driver.findElement(By.xpath("//select[@name='category']"));
		wLib.select(categoryName, catDrop1);  
		WebElement subcatDrop =driver.findElement(By.xpath("//select[@name='subcategory']"));
		wLib.select(subcategoryName, subcatDrop);
		HashMap<String, String> prodData = eLib.getList("ProductTestdata", 0, 1);
		String expectedresult="";
		for (Entry<String, String> e:prodData.entrySet())
		{
			String key = e.getKey();
			String value = e.getValue();
			driver.findElement(By.name(key)).sendKeys(value+rand);
			if(key.equals("productName"))
			{
				expectedresult = value+rand;
			}
		}

		WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
		wLib.select("In Stock", productavailability);
		driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_Black.jfif");
		driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_black2.jpg");
		driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\images (1).jpg");
		driver.findElement(By.xpath("//button[.='Insert']")).click();
		driver.findElement(By.xpath("(//a[contains(.,'Logout')])[2]")).click();

		driver.get(userUrl);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("email")).sendKeys(userUsername);
		driver.findElement(By.name("password")).sendKeys(userPassword);
		driver.findElement(By.name("login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@name='product']")).sendKeys(expectedresult);
		Thread.sleep(500);
		driver.findElement(By.xpath("//button[@name='search']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[.='"+expectedresult+"']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[.=' ADD TO CART']")).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[.='My Cart']")).click();
		driver.findElement(By.xpath("//button[@name='ordersubmit']")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//input[@value='COD']")).click();
		driver.findElement(By.xpath("//input[@value='submit']")).click();

		driver.get(adminUrl);
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();
		driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a")).click();
		String parenttab = driver.getWindowHandle();
		wLib.switchToWindow(driver, "updateorder");
		WebElement status = driver.findElement(By.xpath("//select[@name='status']"));
		wLib.select("In Process", status);
		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Remark");
		driver.findElement(By.xpath("//input[@name='submit2']")).click();
		driver.switchTo().alert().accept();
		driver.close();
		driver.switchTo().window(parenttab);
		driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Pending')]")).click();
		WebElement listcount = driver.findElement(By.xpath("//select[@size='1']"));
		wLib.select("100", listcount);
		for(;;)
		{
			try
			{
				driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a")).click();
				break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

			}
		}
		String parenttab1 = driver.getWindowHandle();
		wLib.switchToWindow(driver, "updateorder");
		WebElement status1 = driver.findElement(By.xpath("//select[@name='status']"));
		Select statusdd1 = new Select(status1);
		statusdd1.selectByVisibleText("Delivered");
		driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Remark");
		driver.findElement(By.xpath("//input[@name='submit2']")).click();
		driver.switchTo().alert().accept();
		driver.switchTo().window(parenttab1);
		driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
		driver.findElement(By.xpath("//a[contains(.,'Delivered')]")).click();
		String actualresult;
		for(;;)
		{
			try
			{
				actualresult = driver.findElement(By.xpath("//td[.='"+expectedresult+"']")).getText();
				break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

			}
		}
		if(actualresult.equals(expectedresult))
		{
			System.out.println(actualresult+" is delivered");
		}
		else
		{
			System.out.println("failed");
		}
		driver.quit();

	}

}

