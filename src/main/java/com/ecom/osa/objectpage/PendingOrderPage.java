package com.ecom.osa.objectpage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PendingOrderPage {
	//declaration
	@FindBy(xpath="//select[contains(.,'entries')]")
	private WebElement entriesdropdown;
	
	@FindBy(xpath="//input[@type='text']")
	private WebElement searchboxtextfield;
	
	@FindBy(xpath="//a[contains(@class,'previous')]")
	private WebElement rightpagedirectionarrow;
	
	@FindBy(xpath="//a[contains(@class,'next')]")
	private WebElement leftpagedirectionarrow;
	
}
