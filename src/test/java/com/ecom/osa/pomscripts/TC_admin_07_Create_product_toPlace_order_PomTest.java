package com.ecom.osa.pomscripts;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.ecom.osa.genericUtility.ExcelUtility;
import com.ecom.osa.genericUtility.FileUtility;
import com.ecom.osa.genericUtility.JavaUtility;
import com.ecom.osa.genericUtility.WebDriverUtility;
import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.AdminLoginPage;
import com.ecom.osa.objectpage.CategoryPage;
import com.ecom.osa.objectpage.InsertProductPage;
import com.ecom.osa.objectpage.MyCartPage;
import com.ecom.osa.objectpage.PaymentPage;
import com.ecom.osa.objectpage.SubCategoryPage;
import com.ecom.osa.objectpage.UserHomePage;
import com.ecom.osa.objectpage.UserLoginPage;

public class TC_admin_07_Create_product_toPlace_order_PomTest {
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
	  String userUsername = fLib.getPropertyKeyvalue("Uusername");
	  String userPassword = fLib.getPropertyKeyvalue("Upassword");
	  System.setProperty("webdriver", "./chromedriver.exe");
	  WebDriver driver=new ChromeDriver();
	  driver.get(adminUrl);
	  wLib.waitForPageLoad(driver);
	  wLib.maximizeWindow(driver);
	  AdminLoginPage alp = new AdminLoginPage(driver);
	  alp.adminlogin(adminUsername, adminPassword);
	  AdminHomePage ahp = new AdminHomePage(driver);
	  ahp.getCrteCatrgylink().click();
	  String categoryName = eLib.getDataFromExcel("CatTestdata", 0, 1)+rand;
	  String categorydescription = eLib.getDataFromExcel("CatTestdata", 1, 1);
	  CategoryPage cp = new CategoryPage(driver);
	  cp.createcategory(categoryName, categorydescription);
	  ahp.getSubcatagrylink().click();
	  String subcategoryName = eLib.getDataFromExcel("SubTestdata", 0, 1)+rand;
	  SubCategoryPage scp = new SubCategoryPage(driver);
	  scp.createSubcategory(subcategoryName, categoryName);
	  ahp.getInsertprdct().click();
	  HashMap<String, String> productDetails = eLib.getList("ProductTestdata", 0, 1);
	  InsertProductPage ip = new InsertProductPage(driver);
	  String expectedresult = ip.insertProduct(driver, rand, categoryName, subcategoryName, productDetails);
	  ahp.getLogout().click();
	  driver.get(userUrl);
	  UserHomePage uhp = new UserHomePage(driver);
	  uhp.getLogin().click();
	  UserLoginPage ulp = new UserLoginPage(driver);
	  ulp.loginAsUser(userUsername, userPassword);
	  uhp.getSearchTextfield().sendKeys(expectedresult);
	  uhp.getSearchButton().click();
	  driver.findElement(By.xpath("//a[.='"+expectedresult+"']")).click();
	  uhp.getAddToCart().click();
	  driver.switchTo().alert().accept();
	  uhp.getMyCart().click();
	  MyCartPage mcp = new MyCartPage(driver);
	  mcp.getProceedToCheckout().click();
	  PaymentPage pp = new PaymentPage(driver);
	  pp.getcODOption().click();
	  pp.getSubmitButton().click();
	  driver.close();
	 }
	}
