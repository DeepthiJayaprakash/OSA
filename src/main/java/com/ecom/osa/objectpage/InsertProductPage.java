package com.ecom.osa.objectpage;

import java.util.HashMap;
import java.util.Map.Entry;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.osa.genericUtility.WebDriverUtility;

public class InsertProductPage {
    //declaration
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	@FindBy(xpath="//select[@name='subcategory']")
	private WebElement subcategrydrpdown;

	@FindBy(xpath="//input[@name='productName']")
	private WebElement prdctnameTextField;
	
	@FindBy(xpath="//input[@name='productCompany']")
	private WebElement prdctcompnay;
	
	@FindBy(xpath="//input[@name='productpricebd']")
	private WebElement prdctb4dscntprice;
	
	@FindBy(xpath="//input[@name='productprice']")
	private WebElement prdctprice;
	
	@FindBy(xpath="//textarea[@name='productDescription']")
	private WebElement prdctdescrptiontxtarea;
	
	@FindBy(xpath="//input[@name='productShippingcharge']")
	private WebElement prdctshpngchrg;
	
	@FindBy(xpath="//select[@id='productAvailability']")
	private WebElement prdctavalbity;
	
	@FindBy(xpath="//input[@id='productimage1']")
	private WebElement prdctimageButton;
	
	@FindBy(xpath="//input[@name='productimage2']")
	private WebElement prdctimage2button;
	
	@FindBy(xpath="//input[@name='productimage3']")
	private WebElement prdctimage3button;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement insertbutton ;
	
	public InsertProductPage(WebDriver driver)
	 {
	  PageFactory.initElements(driver, this);
	 }
	
	
	public WebElement getCategoryDropdown() {
		  return categorydropdown;
		 }
		 public WebElement getSubcategoryDropdown() {
		  return subcategrydrpdown;
		 }
		 public WebElement getProductName() {
		  return prdctnameTextField;
		 }
		 public WebElement getProductCompany() {
		  return prdctcompnay;
		 }
		 public WebElement getProductpricebeforeDiscount() {
		  return prdctb4dscntprice;
		 }
		 public WebElement getProductpriceafterDiscount() {
		  return prdctprice;
		 }
		 public WebElement getProductDescription() {
		  return prdctdescrptiontxtarea;
		 }
		 public WebElement getProductShippingcharge() {
		  return prdctshpngchrg;
		 }
		 public WebElement getProductAvailabilityDropdown() {
		  return prdctavalbity;
		 }
		 public WebElement getProductimage1() {
		  return prdctimageButton;
		 }
		 public WebElement getProductimage2() {
		  return prdctimage2button;
		 }
		 public WebElement getProductimage3() {
		  return prdctimage3button;
		 }
		 public WebElement getInsertButton() {
		  return insertbutton;
		 }
		 public String insertProduct(WebDriver driver,int rand, String categoryName, String subcategoryName, HashMap<String, String> productDetails) throws InterruptedException
		 {
			 WebDriverUtility weblib = new WebDriverUtility();
		  weblib.select(categoryName, getCategoryDropdown());
		  weblib.select(subcategoryName, getSubcategoryDropdown());
		  String expectedresult="";
		   for (Entry<String, String> e:productDetails.entrySet())
		   {
		   String key = e.getKey();
		   String value = e.getValue();
		   driver.findElement(By.name(key)).sendKeys(value+rand);
		   if(key.equals("productName"))
		   {
		    expectedresult = value+rand;
		   }
		   }
		    weblib.select("In Stock", getProductAvailabilityDropdown());
		    getProductimage1().sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_Black.jfif");
		    getProductimage2().sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\Nike_black2.jpg");
		    getProductimage3().sendKeys("C:\\Users\\Sudhindra\\OneDrive\\Desktop\\images (1).jpg");
		    getInsertButton().click();
		    return expectedresult;
		 }
		}
	
	
	
	
	
