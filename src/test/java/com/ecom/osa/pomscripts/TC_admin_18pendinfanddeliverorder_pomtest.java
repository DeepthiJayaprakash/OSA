package com.ecom.osa.pomscripts;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
import com.ecom.osa.objectpage.TodaysOrderPage;
import com.ecom.osa.objectpage.UpdateOrderPage;
import com.ecom.osa.objectpage.UserHomePage;
import com.ecom.osa.objectpage.UserLoginPage;

public class TC_admin_18pendinfanddeliverorder_pomtest {

	public static void main(String[] args) throws Throwable {

		{
			ExcelUtility eLib = new ExcelUtility();
			FileUtility fLib = new FileUtility();
			JavaUtility jLib = new JavaUtility();
			WebDriverUtility wLib = new WebDriverUtility();
			String adminUrl = fLib.getPropertyKeyvalue("Aurl");
			String adminUsername = fLib.getPropertyKeyvalue("Ausername");
			String adminPassword = fLib.getPropertyKeyvalue("Apassword");
			String userUrl = fLib.getPropertyKeyvalue("Uurl");
			String userUsername = fLib.getPropertyKeyvalue("Uusername");
			String userPassword = fLib.getPropertyKeyvalue("Upassword");
			System.setProperty("webdriver", "./chromedriver.exe");
			WebDriver driver = new ChromeDriver();
			driver.get(adminUrl);
			System.out.println(adminUsername + adminPassword);
			wLib.waitForPageLoad(driver);
			wLib.maximizeWindow(driver);
			int rand = jLib.getRandomNo();
			AdminLoginPage alp = new AdminLoginPage(driver);
			alp.adminlogin(adminUsername, adminPassword);
			AdminHomePage ahp = new AdminHomePage(driver);
			ahp.getCrteCatrgylink().click();
			String categoryName = eLib.getDataFromExcel("CatTestdata", 0, 1) + rand;
			String categorydescription = eLib.getDataFromExcel("CatTestdata", 1, 1);
			CategoryPage cp = new CategoryPage(driver);
			cp.createcategory(categoryName, categorydescription);
			ahp.getSubcatagrylink().click();
			String subcategoryName = eLib.getDataFromExcel("SubTestdata", 0, 1) + rand;
			SubCategoryPage scp = new SubCategoryPage(driver);
			scp.createSubcategory(subcategoryName, categoryName);
			ahp.getInsertprdct().click();
			HashMap<String, String> productDetails = eLib.getList("ProductTestdata", 0, 1);
			InsertProductPage ip = new InsertProductPage(driver);
			String expectedresult = ip.insertProduct(driver, rand, categoryName, subcategoryName, productDetails);
			ahp.getLogout().click();
			Thread.sleep(2000);
			driver.get(userUrl);
			UserHomePage uhp = new UserHomePage(driver);
			uhp.getLogin().click();
			UserLoginPage ulp = new UserLoginPage(driver);
			ulp.loginAsUser(userUsername, userPassword);
			uhp.getSearchTextfield().sendKeys(expectedresult);
			uhp.getSearchButton().click();
			driver.findElement(By.xpath("//a[.='" + expectedresult + "']")).click();
			uhp.getAddToCart().click();
			wLib.acceptAlert(driver);
			uhp.getMyCart().click();
			MyCartPage mcp = new MyCartPage(driver);
			mcp.getProceedToCheckout().click();
			PaymentPage pp = new PaymentPage(driver);
			pp.getcODOption().click();
			pp.getSubmitButton().click();
			driver.get(adminUrl);
			alp.adminlogin(adminUsername, adminPassword);
			ahp.getTodaysOrderlink().click();
			driver.findElement(By.tagName("input")).sendKeys(expectedresult, Keys.ENTER);
			driver.findElement(By.xpath("//td[.='" + expectedresult + "']/..//a")).click();
			String parenttab = driver.getWindowHandle();
			wLib.switchToWindow(driver, "updateorder");
			UpdateOrderPage uo = new UpdateOrderPage(driver);
			uo.updateOrderToProgress();
			wLib.acceptAlert(driver);
			driver.close();
			driver.switchTo().window(parenttab);
			ahp.getPendingOrder().click();
			TodaysOrderPage top = new TodaysOrderPage(driver);
			//top.getEntryNumber();
			wLib.select("100", top.getEntryNumber());
			driver.findElement(By.tagName("input")).sendKeys(expectedresult, Keys.ENTER);
			for (;;) {
				try {
					driver.findElement(By.xpath("//td[.='" + expectedresult + "']/..//a")).click();
					break;
				} catch (Exception e) {
					top.getNextIcon().click();
				}
			}
			String parenttab1 = driver.getWindowHandle();
			wLib.switchToWindow(driver, "updateorder");
			uo.updateOrderToDelivered();
			wLib.acceptAlert(driver);
			driver.switchTo().window(parenttab1);
			ahp.getDeliveredOrder().click();
			String actualresult;
			driver.findElement(By.tagName("input")).sendKeys(expectedresult, Keys.ENTER);

			for (;;) 
			{
				try {
					actualresult = driver.findElement(By.xpath("//td[.='" + expectedresult + "']")).getText();
					break;
				} catch (Exception e) {
					driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();
				}
			}

			if (actualresult.equals(expectedresult)) {
				System.out.println(actualresult + " is delivered");
			} else {
				System.out.println("failed");
			}
			driver.quit();
		}
	}
}
