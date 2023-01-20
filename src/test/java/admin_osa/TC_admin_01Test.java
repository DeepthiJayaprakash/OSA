
package admin_osa;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_admin_01Test {

	public static void main(String[] args) throws Throwable {
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		FileInputStream fis = new FileInputStream("./src/test/resources/Commondata.properties");
		Properties pObj = new Properties();
		pObj.load(fis);
		String adminUrl = pObj.getProperty("Aurl");
		driver.get(adminUrl);
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		
		String adminusername= pObj.getProperty("Ausername");
	    driver.findElement(By.id("inputEmail")).sendKeys(adminusername);
	    
	    String adminpassword= pObj.getProperty("Apassword");
	    driver.findElement(By.id("inputPassword")).sendKeys(adminpassword);
	    driver.findElement(By.name("submit")).click();
	    Random ran = new Random();
	    int random = ran.nextInt(400);
	    driver.findElement(By.xpath("//a[.=' Create Category ']")).click();
	    driver.findElement(By.name("category")).sendKeys("Fashion"+random);
	    driver.findElement(By.xpath("//textarea[@name='description']")).sendKeys("Description of category");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//a[.='Sub Category ']")).click();
	    WebElement Category_name = driver.findElement(By.xpath("//select[@name='category']"));
	    wait.until(ExpectedConditions.visibilityOf(Category_name));
	  
	     Select select=new Select(Category_name);
	     select.selectByVisibleText("Fashion"+random);
	     
	 driver.findElement(By.xpath("//input[@name='subcategory']")).sendKeys("Fashionsub"+random);
	    
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//a[.='Insert Product ']")).click();
	    WebElement Category_name1 = driver.findElement(By.xpath("//select[@name='category']"));
	    Select select1=new Select(Category_name1);
	    select1.selectByVisibleText("Fashion"+random);
	    WebElement subcategory1 = driver.findElement(By.xpath("//select[@id='subcategory']"));
	    Select select2 = new Select(subcategory1);
	    select2.selectByVisibleText("Fashionsub"+random);
	    WebElement PrdctName = driver.findElement(By.name("productName"));
	    PrdctName.sendKeys("Tshirt"+random);
	    
	    WebElement PrdctCpmny = driver.findElement(By.name("productCompany"));
	    PrdctCpmny.sendKeys("Nike"+random);
	    WebElement PrdctDscntprc = driver.findElement(By.name("productpricebd"));
	    PrdctDscntprc.sendKeys("15"+random);
	    WebElement PrdctPrc = driver.findElement(By.name("productprice"));
	    PrdctPrc.sendKeys("20"+random);
	    WebElement PrdctDescp = driver.findElement(By.xpath("//textarea[@name='productDescription']"));
	    PrdctDescp.sendKeys("This is an unisex T shirt");
	    WebElement Prdctshippng = driver.findElement(By.name("productShippingcharge"));
	    Prdctshippng.sendKeys("5"+random);
	    WebElement PrdctAvalibilty = driver.findElement(By.xpath("//select[@id='productAvailability']"));
	    Select select3 = new Select(PrdctAvalibilty);
	    select3.selectByVisibleText("In Stock");
	    driver.findElement(By.id("productimage1")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_Black.jfif");
	    driver.findElement(By.name("productimage2")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_black2.jpg");
	    driver.findElement(By.name("productimage3")).sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\images (1).jpg");
	    driver.findElement(By.name("submit")).click();
	    driver.findElement(By.xpath("//a[.='Manage Products ']")).click();
	    String Expectedname = "Tshirt"+random;
	    driver.findElement(By.xpath("//input[@type='text']")).sendKeys(Expectedname);
	    String Actualname = driver.findElement(By.xpath("//tbody/tr/td[2]")).getText();
	    if(Actualname.equals(Expectedname))
	    {
	    	System.out.println("Product is found ");
	    }
	    else
	    	System.out.println("product is not found");	    
	}

}
