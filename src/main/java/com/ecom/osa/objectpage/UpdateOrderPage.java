package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ecom.osa.genericUtility.WebDriverUtility;

public class UpdateOrderPage
{
 @FindBy(xpath = "//select[@name='status']")
 private WebElement statusDropdown;
 @FindBy(xpath = "//textarea[@name='remark']")
 private WebElement remark;
 @FindBy(xpath = "//input[@name='submit2']")
 private WebElement submit;
 @FindBy(xpath = "//input[@value='Close this Window ']")
 private WebElement closeWindow;
 public UpdateOrderPage(WebDriver driver)
 {
  PageFactory.initElements(driver, this);
 }
 public WebElement getStatusDropdown() {
  return statusDropdown;
 }
 public WebElement getRemark() {
  return remark;
 }
 public WebElement getSubmit() {
  return submit;
 }
 public WebElement getCloseWindow() {
  return closeWindow;
 }
 public void updateOrderToProgress() throws InterruptedException
 {
	 WebDriverUtility wlib = new WebDriverUtility();
  wlib.select("In Process", getStatusDropdown());
  getRemark().sendKeys("remark");
  getSubmit().click();
 }
 public void updateOrderToDelivered() throws InterruptedException
 {
	 WebDriverUtility wlib = new WebDriverUtility();
  wlib.select("Delivered", getStatusDropdown());
  getRemark().sendKeys("remark");
  getSubmit().click();
 }
}

