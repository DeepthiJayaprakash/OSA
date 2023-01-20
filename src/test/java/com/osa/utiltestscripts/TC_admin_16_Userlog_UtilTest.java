package com.osa.utiltestscripts;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.osa.genericUtility.ExcelUtility;
import com.ecom.osa.genericUtility.FileUtility;
import com.ecom.osa.genericUtility.JavaUtility;
import com.ecom.osa.genericUtility.WebDriverUtility;

public class TC_admin_16_Userlog_UtilTest {

	public static void main(String[] args) throws Throwable
	{
		ExcelUtility eLib = new ExcelUtility();
		FileUtility fLib = new FileUtility();
		JavaUtility jLib = new JavaUtility();
		WebDriverUtility wLib = new WebDriverUtility();
		int rand = jLib.getRandomNo();
		String adminUrl = fLib.getPropertyKeyvalue("Aurl");
		String adminUsername = fLib.getPropertyKeyvalue("Ausername");
		String adminPassword = fLib.getPropertyKeyvalue("Apassword");
		String userUrl = fLib.getPropertyKeyvalue("Uurl");
		System.setProperty("webdriver", "./chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.get(userUrl);
		wLib.waitForPageLoad(driver);
		wLib.maximizeWindow(driver);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		String expectedResult="";
		String pass="";
		HashMap<String, String> newuser = eLib.getList("NewUser", 0, 1);
		for (Entry<String, String> e:newuser.entrySet())
		{
			String key = e.getKey();
			String value = e.getValue();
			if(key.equals("password"))
			{
				pass = value+rand;
				driver.findElement(By.xpath("(//input[@name='"+key+"'])[2]")).sendKeys(pass);
			}
			else
			{
				if(key.equals("emailid"))
				{
					expectedResult = value+rand+"@gmail.com";
					driver.findElement(By.name(key)).sendKeys(expectedResult);

				}
				else
				{
					driver.findElement(By.name(key)).sendKeys(value+rand);
				}
			}
		}
		driver.findElement(By.name("submit")).click();
		Thread.sleep(500);
		driver.switchTo().alert().accept();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[.='Login']")).click();
		driver.findElement(By.name("email")).sendKeys(expectedResult);
		driver.findElement(By.name("password")).sendKeys(pass);
		driver.findElement(By.name("login")).click();
		Thread.sleep(500);
		driver.findElement(By.xpath("//a[.='Logout']")).click();
		driver.get(adminUrl);
		driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
		driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
		driver.findElement(By.xpath("//button")).click();
		driver.findElement(By.xpath("//a[.='User Login Log ']")).click();
		driver.findElement(By.xpath("//input")).sendKeys(expectedResult);
		String actualResult="";
		WebElement listcount = driver.findElement(By.xpath("//select[@size='1']"));
		wLib.select("100", listcount);
		for(;;)
		{
			try
			{
				actualResult = driver.findElement(By.xpath("//td[.='"+expectedResult+"']")).getText();
				break;
			}
			catch (Exception e)
			{
				driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

			}
		}
		if(actualResult.equals(expectedResult))
		{
			System.out.println(actualResult+"'s is present");
		}
		else
		{
			System.out.println("failed");
		}
		driver.quit();
	}

}
