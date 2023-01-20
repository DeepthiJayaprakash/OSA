package com.ecom.osa.pomscripts;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.osa.genericUtility.ExcelUtility;
import com.ecom.osa.genericUtility.FileUtility;
import com.ecom.osa.genericUtility.JavaUtility;
import com.ecom.osa.genericUtility.WebDriverUtility;
import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.AdminLoginPage;
import com.ecom.osa.objectpage.UserHomePage;
import com.ecom.osa.objectpage.UserLoginPage;

public class TC_admin_16_login_login_log_pomTest {
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
	  UserHomePage uhp = new UserHomePage(driver);
	  uhp.getLogin().click();
	  HashMap<String, String> newuser = eLib.getList("NewUser", 0, 1);
	  UserLoginPage ulp = new UserLoginPage(driver);
	  HashMap<String, String> credentials = ulp.createUser(driver, newuser, rand);
	  String username = credentials.get("Username");
	  String password = credentials.get("Password");
	  wLib.acceptAlert(driver);
	  uhp.getLogin().click();
	  ulp.loginAsUser(username, password);
	  uhp.getLogout().click();
	  driver.get(adminUrl);
	  AdminLoginPage alp = new AdminLoginPage(driver);
	  alp.adminlogin(adminUsername, adminPassword);
	  AdminHomePage ahp = new AdminHomePage(driver);
	  ahp.getUsrlog().click();
	  driver.findElement(By.xpath("//input")).sendKeys(username);
	  String actualResult="";
	  WebElement listcount = driver.findElement(By.xpath("//select[@size='1']"));
	  wLib.select("100", listcount);
	  for(;;)
	  {
	   try
	   {
	    actualResult = driver.findElement(By.xpath("//td[.='"+username+"']")).getText();
	    break;
	   }
	   catch (Exception e)
	   {
	    driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
	   }
	  }
	  if(actualResult.equals(username))
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
