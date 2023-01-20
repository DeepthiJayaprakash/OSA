package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class TodaysOrderPage {
//declaration
	@FindBy(tagName = "select")
	private WebElement entrydropdown;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchbox;
	
	@FindBy(xpath="//a[contains(@class,'previous')]")
	private WebElement rightnextarrow;
	
	@FindBy(xpath="//a[contains(@class,'next')]")
	private WebElement leftarrow;
	
	 public TodaysOrderPage(WebDriver driver)
	 {
	  PageFactory.initElements(driver, this);
	 }
	 
	 public WebElement getSearchText() {
		  return searchbox;
		 }
		 public WebElement getEntryNumber() {
		  return entrydropdown;
		 }
		 public WebElement getNextIcon() {
		  return leftarrow;
		 }
		 public WebElement getPreviousIcon() {
		  return rightnextarrow;
		 }
		}

