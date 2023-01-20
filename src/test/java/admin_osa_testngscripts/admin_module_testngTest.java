package admin_osa_testngscripts;

import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import com.ecom.osa.genericUtility.BaseClass;
import com.ecom.osa.objectpage.AdminHomePage;
import com.ecom.osa.objectpage.CategoryPage;
import com.ecom.osa.objectpage.InsertProductPage;
import com.ecom.osa.objectpage.MangePrdctPage;
import com.ecom.osa.objectpage.SubCategoryPage;

public class admin_module_testngTest extends BaseClass
{
 String expectedresult;
 String Uexpectedresult;
 HashMap<String, String> productDetails;
 public int rand;
 @Test(groups = "Admin")
 public void createProduct() throws Throwable
 {
  rand=jlib.getRandomNo();
  AdminHomePage ahp = new AdminHomePage(driver);
  ahp.getCrteCatrgylink().click();
  String categoryName = elib.getDataFromExcel("CatTestdata", 0, 1)+rand;
  String categorydescription = elib.getDataFromExcel("CatTestdata", 1, 1);
  CategoryPage cp = new CategoryPage(driver);
  cp.createcategory(categoryName, categorydescription);
  ahp.getSubcatagrylink().click();
  String subcategoryName = elib.getDataFromExcel("SubTestdata", 0, 1)+rand;
  SubCategoryPage scp = new SubCategoryPage(driver);
  scp.createSubcategory(subcategoryName, categoryName);
  ahp.getInsertprdct().click();
  productDetails = elib.getList("ProductTestdata", 0, 1);
  InsertProductPage ip = new InsertProductPage(driver);
  expectedresult = ip.insertProduct(driver, rand, categoryName, subcategoryName, productDetails);
  ahp.getMangprdct().click();
  driver.findElement(By.xpath("//input")).sendKeys(expectedresult,Keys.ENTER);
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
 @Test(dependsOnMethods = "createProduct",groups = "Admin")
 public void editProduct()
 {
  AdminHomePage ahp = new AdminHomePage(driver);
  ahp.getMangprdct().click();
  MangePrdctPage mpp = new MangePrdctPage(driver);
  mpp.getSearchTextfield().sendKeys(expectedresult);
  driver.findElement(By.xpath("//td[.='"+expectedresult+"']/..//a[1]")).click();
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
  mpp.getSearchTextfield().sendKeys(Uexpectedresult);
  String ActualResult = driver.findElement(By.xpath("//td[text() ='"+Uexpectedresult+"']")).getText();
  if(ActualResult.equals(Uexpectedresult))
   {
    System.out.println("Details of "+ActualResult+" is successfully updated.");
   }
   else
   {
    System.out.println("failed");
   }
 }
 @Test(dependsOnMethods = "editProduct",groups = "User")
 public void placeOrder()
 {
  wLib.waitForPageLaod(driver);
  UserHomePage uhp = new UserHomePage(driver);
  uhp.getSearchTextfield().sendKeys(Uexpectedresult);
  uhp.getSearchButton().click();
  driver.findElement(By.xpath("//a[.='"+Uexpectedresult+"']")).click();
  uhp.getAddToCart().click();
  try
  {
  wLib.acceptAlert(driver);
  }
  catch(Exception e)
  {
   System.out.println("Alert handled");
  }
  uhp.getMyCart().click();
  MyCartPage mcp = new MyCartPage(driver);
  mcp.getProceedToCheckout().click();
  PaymentPage pp = new PaymentPage(driver);
  pp.getcODOption().click();
  pp.getSubmitButton().click();
  System.out.println("Order for "+Uexpectedresult+" has been successfully placed");
 }
 @Test(dependsOnMethods = "placeOrder",groups = "Admin")
 public void manageOrder() throws InterruptedException
 {
  wLib.waitForPageLaod(driver);
  AdminHomePage ahp = new AdminHomePage(driver);
  ahp.getTodaysOrder().click();
  TodaysOrderPage top = new TodaysOrderPage(driver);
  wLib.select("100", top.getEntryNumber());
  for(;;)
  {
   try
   {
    driver.findElement(By.xpath("//td[.='"+Uexpectedresult+"']/..//a")).click();
    break;
   }
   catch (Exception e)
   {
    top.getNextIcon().click();
   }
  }
  String parenttab = driver.getWindowHandle();
  wLib.switchToWindow(driver, "updateorder");
  UpdateOrderPage uo = new UpdateOrderPage(driver);
  uo.updateOrderToProgress();
  wLib.acceptAlert(driver);
  //driver.close();
  driver.switchTo().window(parenttab);
  ahp.getPendingOrder().click();
  top.getEntryNumber();
  wLib.select("100", top.getEntryNumber());
  for(;;)
  {
   try
   {
    driver.findElement(By.xpath("//td[.='"+Uexpectedresult+"']/..//a")).click();
    break;
   }
   catch (Exception e)
   {
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
  wLib.select("100", top.getEntryNumber());
  for(;;)
  {
   try
   {
    actualresult = driver.findElement(By.xpath("//td[.='"+Uexpectedresult+"']")).getText();
    break;
   }
   catch (Exception e)
   {
    top.getNextIcon().click();
   }
  }
  if(actualresult.equals(Uexpectedresult))
  {
  System.out.println(actualresult+" is delivered");
  }
  else
  {
   System.out.println("failed");
  }
 }
 @Test
 public void login_logInfo() throws InterruptedException, IOException
 {
  rand=jlib.getRandomNo();
  String userUrl = fLib.getPropertyValue("Uurl");
  driver.get(userUrl);
  UserHomePage uhp = new UserHomePage(driver);
  uhp.getLogin().click();
  HashMap<String, String> newuser = elib.getList("NewUser", 0, 1);
  UserLoginPage ulp = new UserLoginPage(driver);
  HashMap<String, String> credentials = ulp.createUser(driver, newuser, rand);
  String username = credentials.get("Username");
  String password = credentials.get("Password");
  wLib.acceptAlert(driver);
  uhp.getLogin().click();
  ulp.loginAsUser(username, password);
  uhp.getLogout().click();
  loginApp();
  AdminHomePage ahp = new AdminHomePage(driver);
  ahp.getUserLoginInfo().click();
  driver.findElement(By.xpath("//input")).sendKeys(username,Keys.BACK_SPACE);
  String actualResult="";
  WebElement listcount = driver.findElement(By.xpath("//select[@size='1']"));
  TodaysOrderPage top = new TodaysOrderPage(driver);
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
    top.getNextIcon().click();
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
 }
}

