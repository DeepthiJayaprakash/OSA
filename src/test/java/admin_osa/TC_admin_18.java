package admin_osa;

	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Iterator;
	import java.util.Properties;
	import java.util.Random;
	import java.util.Set;
	import java.util.concurrent.TimeUnit;

	import org.openqa.selenium.By;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.support.ui.Select;

	public class TC_admin_18 {

	@SuppressWarnings("deprecation")
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
	 driver.manage().window().maximize();
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
	 String expectedresult = "ProductName"+rand;
	 driver.findElement(By.name("productName")).sendKeys(expectedresult);
	 driver.findElement(By.name("productCompany")).sendKeys("productCompanyName");
	 driver.findElement(By.name("productpricebd")).sendKeys("100"+rand);
	 driver.findElement(By.name("productprice")).sendKeys("80"+rand);
	 driver.findElement(By.name("productDescription")).sendKeys("productDescription");
	 driver.findElement(By.name("productShippingcharge")).sendKeys("productShippingcharge");
	 WebElement productavailability = driver.findElement(By.xpath("//select[@name='productAvailability']"));
	 Select productavailabilitydd = new Select(productavailability);
	 Thread.sleep(500);
	 productavailabilitydd.selectByVisibleText("In Stock");
	 driver.findElement(By.name("productimage1")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img1.jpg");
	 Thread.sleep(500);
	 driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img2.png");
	 Thread.sleep(500);
	 driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\ajax2\\OneDrive\\Desktop\\img3.bmp");
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



	driver.get(adminUrl);
	driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(adminUsername);
	driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(adminPassword);
	driver.findElement(By.xpath("//button")).click();
	driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
	driver.findElement(By.xpath("//a[contains(.,'Today')]")).click();


	driver.findElement(By.xpath("//td[.='ProductName"+rand+"']/..//a")).click();
	String parenttab = driver.getWindowHandle();
	Set<String> tabs = driver.getWindowHandles();
	Iterator<String> it = tabs.iterator();
	while(it.hasNext())
	{
	String tab = it.next();
	String tabtitle = driver.switchTo().window(tab).getTitle();
	if(tabtitle.contains("updateorder"))
	{
	break;
	}

	}

	WebElement status = driver.findElement(By.xpath("//select[@name='status']"));
	Select statusdd = new Select(status);
	statusdd.selectByVisibleText("In Process");
	driver.findElement(By.xpath("//textarea[@name='remark']")).sendKeys("Remark");
	driver.findElement(By.xpath("//input[@name='submit2']")).click();
	driver.switchTo().alert().accept();
	driver.close();
	driver.switchTo().window(parenttab);
	driver.findElement(By.xpath("//a[contains(.,'Order Management')]")).click();
	driver.findElement(By.xpath("//a[contains(.,'Pending')]")).click();
	for(;;)
	{
	try
	{
	driver.findElement(By.xpath("//td[.='ProductName"+rand+"']/..//a")).click();
	break;
	}
	catch (Exception e)
	{
	driver.findElement(By.xpath("(//a[@role='button'])[2]")).click();

	}
	}



	String parenttab1 = driver.getWindowHandle();
	Set<String> tabs1 = driver.getWindowHandles();
	Iterator<String> it1 = tabs1.iterator();
	while(it1.hasNext())
	{
	String tab1 = it1.next();
	String tabtitle1 = driver.switchTo().window(tab1).getTitle();
	if(tabtitle1.contains("updateorder"))
	{
	break;
	}

	}


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
	actualresult = driver.findElement(By.xpath("//td[.='ProductName"+rand+"']")).getText();
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


	}

	}

