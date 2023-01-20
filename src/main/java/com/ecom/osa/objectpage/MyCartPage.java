package com.ecom.osa.objectpage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyCartPage
{
@FindBy(xpath = "//button[@name='ordersubmit']")
private WebElement proceedToCheckout;

@FindBy(xpath = "//input[@name='submit']")
private WebElement updateShoppingCart;

@FindBy(xpath = "//a[.='Continue Shopping']")
private WebElement continueShopping;

public MyCartPage(WebDriver driver)
{
PageFactory.initElements(driver, this);
}

public WebElement getProceedToCheckout() {
return proceedToCheckout;
}

public WebElement getUpdateShoppingCart() {
return updateShoppingCart;
}

public WebElement getContinueShopping() {
return continueShopping;
}

}



