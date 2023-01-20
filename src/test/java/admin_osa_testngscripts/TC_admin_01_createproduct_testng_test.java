package admin_osa_testngscripts;

import static org.testng.Assert.fail;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.ecom.osa.genericUtility.BaseClass;
import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.CategoryPage;
import com.ecom.osa.objectpage.InsertProductPage;
import com.ecom.osa.objectpage.SubCategoryPage;
@Listeners(com.ecom.osa.genericUtility.ListenerImplementationCIass.class)
public class TC_admin_01_createproduct_testng_test extends BaseClass
{
	@Test(groups = {"smoke","regression"})
		 public void createProduct() throws Throwable
		 {
			 
		  AdminHomePage ahp = new AdminHomePage(driver);
		  ahp.getCrteCatrgylink().click();
		  String categoryName = elib.getDataFromExcel("CatTestdata", 0, 1)+rand;
		  String categorydescription = elib.getDataFromExcel("CatTestdata", 1, 1);
		  CategoryPage cp = new CategoryPage(driver);
		  cp.createcategory(categoryName, categorydescription);
		  fail();
		  ahp.getSubcatagrylink().click();
		  String subcategoryName = elib.getDataFromExcel("SubTestdata", 0, 1)+rand;
		  SubCategoryPage scp = new SubCategoryPage(driver);
		  scp.createSubcategory(subcategoryName, categoryName);
		  ahp.getInsertprdct().click();
		  HashMap<String, String> productDetails = elib.getList("ProductTestdata", 0, 1);
		  InsertProductPage ip = new InsertProductPage(driver);
		  String expectedresult = ip.insertProduct(driver, rand, categoryName, subcategoryName, productDetails);
		  ahp.getMangprdct().click();
		  driver.findElement(By.xpath("//input")).sendKeys(expectedresult);
		  String ActualResult = driver.findElement(By.xpath("//td[text() ='"+expectedresult+"']")).getText();
		  if(ActualResult.equals(expectedresult))
		  {
		   System.out.println(ActualResult+" is successfully created.");
		  }
		  else
		  {
		   System.out.println("failed");
		  }
		 }
		}
