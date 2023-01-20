package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.osa.genericUtility.WebDriverUtility;

public class SubCategoryPage {
    //declaration 
	@FindBy(xpath="//select[@name='category']")
	private WebElement categorydropdown;
	
	@FindBy(xpath="//input[@name='subcategory']")
	private WebElement subcategorytextfield;
	
	@FindBy(xpath="//button[@name='submit']")
	private WebElement createbutton;
	
	@FindBy(xpath="//label[contains(.,'entries')]")
	private WebElement entriesdropdown;
	
	@FindBy(xpath="//div[@class='dataTables_filter']//input[@type='text']")
	private WebElement searchtextfield;
	
	@FindBy(xpath="//a[contains(@class,'previous')]")
	private WebElement rightpagedirectionarrow;
	
	@FindBy(xpath="//a[contains(@class,'next')]")
	private WebElement leftpagedirectionarrow;
	
	public WebElement getSubCategory()
	{
		return categorydropdown;
	}
	public SubCategoryPage(WebDriver driver)
	 {
	  PageFactory.initElements(driver, this);
	 }
	public void createSubcategory(String subcategoryName,String categoryName)
	{
		WebDriverUtility wlib = new WebDriverUtility();
		wlib.select(categoryName, categorydropdown);
		subcategorytextfield.sendKeys(subcategoryName);
		createbutton.click();
		
	}
	
}
  
