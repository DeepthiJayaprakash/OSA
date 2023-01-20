package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CategoryPage {
      //declaration
	@FindBy(xpath="//input[@name='category']")
	private WebElement categoryTextField;
	
	@FindBy(xpath="//textarea[@name='description']")
	private WebElement descriptiontxtarea;
	
	@FindBy(name="submit")
	private WebElement createbutton;
	
	@FindBy(xpath="//label[contains(.,'entries')]")
	private WebElement entriesdropdown;
	
	@FindBy(xpath="//div[@class='dataTables_filter']//input[@type='text']")
	private WebElement searchtextarea;
	
	@FindBy(xpath="//a[contains(@class,'previous')]")
	private WebElement rightpagedirectionarrow;
	
	@FindBy(xpath="//a[contains(@class,'next')]")
	private WebElement leftpagedirectionarrow;
	
	public WebElement getcategoryname()
	{
		return categoryTextField;
	}
	public WebElement getDescription()
	{
		return descriptiontxtarea;
		
	}
	
	public WebElement getsubmitbutton()
	{
		return createbutton;
	}
	public CategoryPage(WebDriver driver)
	 {
	  PageFactory.initElements(driver, this);
	 }
	 public void createcategory(String categoryName, String categorydescription)
	 {
		 getcategoryname().sendKeys(categoryName);
		 getDescription().sendKeys(categorydescription);
		 getsubmitbutton().click();
	 }
}
