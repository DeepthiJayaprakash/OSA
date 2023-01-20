package com.ecom.osa.genericUtility;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.AdminLoginPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	 public WebDriver driver;
	 public static WebDriver dDriver;
	 public ExcelUtility elib =new ExcelUtility();
	 public DatabaseUtility dlib=new DatabaseUtility();
	 public WebDriverUtility wlib= new WebDriverUtility();
	 public FileUtility flib = new FileUtility();
	 public JavaUtility jlib= new JavaUtility();
	 public int rand = jlib.getRandomNo();
	@BeforeSuite
	 public void configbS() throws Throwable
	 {
		dlib.connectToDB();
		System.out.println("connected to db");
	 }
	
	@BeforeClass
	public void configB4c() throws Throwable
	{
	String Browser = flib.getPropertyKeyvalue("Browser");
		
	if(Browser.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
		//WebDriverManager.chromedriver().setup();
	}
	else if(Browser.equalsIgnoreCase("firefox"))
	{
		driver= new FirefoxDriver();
	}
	else
	{
		System.out.println("Invalid browser");
	}
       dDriver=driver;
	wlib.maximizeWindow(driver);
	wlib.waitForPageLoad(driver);
	String adminUrl = flib.getPropertyKeyvalue("Aurl");
	driver.get(adminUrl);
	}
	@BeforeMethod
	public void configBeforMethod() throws Throwable
	{ 
	  String adminUsername = flib.getPropertyKeyvalue("Ausername");
	  String adminPassword = flib.getPropertyKeyvalue("Apassword");
		AdminLoginPage alp= new AdminLoginPage(driver);
		alp.adminlogin(adminUsername, adminPassword);
		
	}
	@AfterMethod
	public void logoutapplication()
	{
	AdminHomePage ahp = new AdminHomePage(driver);
	ahp.getLogoutbutton();
	}
	@AfterClass
	public void closebrowser()
	{
		driver.quit();
	}
	@AfterSuite
	public void disconnectdb() throws Throwable
	
	{
		dlib.disconnectDB();
	}
	
	
}
