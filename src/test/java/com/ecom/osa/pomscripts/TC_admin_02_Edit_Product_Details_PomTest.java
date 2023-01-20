package com.ecom.osa.pomscripts;
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
import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.AdminLoginPage;
import com.ecom.osa.objectpage.CategoryPage;
import com.ecom.osa.objectpage.InsertProductPage;
import com.ecom.osa.objectpage.SubCategoryPage;

public class TC_admin_02_Edit_Product_Details_PomTest
{
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
  ahp.getMangprdct().click();
  driver.findElement(By.xpath("//input")).sendKeys(expectedresult);
  driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a[1]")).click();
  String Uexpectedresult = "";
  for (Entry<String, String> e1:productDetails.entrySet())
   {
   String key = e1.getKey();
   String value = e1.getValue();
   WebElement ele = driver.findElement(By.name(key));
   ele.clear();
   ele.sendKeys("updated"+value+rand);
   if(key.equals("productName"))
   {
    Uexpectedresult ="updated"+value+rand;
   }
   }
  driver.findElement(By.xpath("//button[.='Update']")).click();
  ahp.getMangprdct().click();
  driver.findElement(By.xpath("//input")).sendKeys(Uexpectedresult);
  String ActualResult = driver.findElement(By.xpath("//td[text() ='"+Uexpectedresult+"']")).getText();
  if(ActualResult.equals(Uexpectedresult))
   {
    System.out.println("Details of "+ActualResult+" is successfully updated.");
   }
   else
   {
    System.out.println("failed");
   }
  driver.quit();
 }
}