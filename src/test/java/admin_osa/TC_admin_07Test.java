package admin_osa;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class TC_admin_07Test {
	public static void main(String[] args) throws IOException, InterruptedException
	{

	Random ran = new Random();
	int rand = ran.nextInt(100);

	FileInputStream fis1 = new FileInputStream("./src/test/resources/Commondata.properties");
	Properties prop = new Properties();
	prop.load(fis1);
	String adminUrl = prop.getProperty("Aurl");
	String adminUsername = prop.getProperty("Ausername");
	String adminPassword = prop.getProperty("Apassword");
	String userUrl = prop.getProperty("Uurl");
	String userUsername = prop.getProperty("Uusername");
	String userPassword = prop.getProperty("Upassword");


	System.setProperty("webdriver", "./chromedriver.exe");
	WebDriver driver=new ChromeDriver();

	 driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	 driver.get(adminUrl);
	 driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
	 driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
	 driver.findElement(By.xpath("//button")).click();
	 
	 driver.findElement(By.xpath("//a[contains(.,'Create')]")).click();
	 driver.findElement(By.name("category")).sendKeys("categoryName"+rand);
	 driver.findElement(By.name("description")).sendKeys("categorydescription");
	 driver.findElement(By.name("submit")).click();
	 
	 driver.findElement(By.xpath("//a[contains(.,'Sub Category ')]")).click();
	 WebElement catDrop =driver.findElement(By.xpath("//select[@name='category']"));
	 Select categorydd= new Select(catDrop);
	 categorydd.selectByVisibleText("categoryName"+rand);
	 Thread.sleep(500);
	 driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("subcategoryName"+rand);
	 driver.findElement(By.xpath("//button[.='Create']")).click();
	 
	 driver.findElement(By.xpath("//a[contains(.,'Insert Product ')]")).click();
	 Thread.sleep(500);
	 WebElement catDrop1 =driver.findElement(By.xpath("//select[@name='category']"));
	 Select categorydd1 = new Select(catDrop1);
	 categorydd1.selectByVisibleText("categoryName"+rand);
	 WebElement subcatDrop =driver.findElement(By.xpath("//select[@name='subcategory']"));
	 Select subcategorydd = new Select(subcatDrop);
	 Thread.sleep(500);
	 subcategorydd.selectByVisibleText("subcategoryName"+rand);
	 driver.findElement(By.name("productName")).sendKeys("ProductName"+rand);
	 driver.findElement(By.name("productCompany")).sendKeys("productCompanyName");
	 driver.findElement(By.name("productpricebd")).sendKeys("100"+rand);
	 driver.findElement(By.name("productprice")).sendKeys("80"+rand);
	 driver.findElement(By.name("productDescription")).sendKeys("productDescription");
	 driver.findElement(By.name("productShippingcharge")).sendKeys("productShippingcharge");
	 WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
	 Select productavailabilitydd = new Select(productavailability);
	 Thread.sleep(500);
	 productavailabilitydd.selectByVisibleText("In Stock");
	 driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_Black.jfif");
	 Thread.sleep(500);
	 driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_black2.jpg");
	 Thread.sleep(500);
	 driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\images (1).jpg");
	 driver.findElement(By.xpath("//button[.='Insert']")).click();
	 driver.findElement(By.xpath("(//a[contains(.,'Logout')])[2]")).click();





	driver.get(userUrl);
	driver.findElement(By.xpath("//a[.='Login']")).click();
	driver.findElement(By.name("email")).sendKeys(userUsername);
	driver.findElement(By.name("password")).sendKeys(userPassword);
	driver.findElement(By.name("login")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//input[@name='product']")).sendKeys("ProductName"+rand);
	Thread.sleep(500);
	driver.findElement(By.xpath("//button[@name='search']")).click();
	Thread.sleep(500);
	driver.findElement(By.xpath("//a[.='ProductName"+rand+"']")).click();
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
	}

	}

