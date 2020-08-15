package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class ShoppingCartSummaryPaymentPage extends Baseclass{
	
	@FindBy(xpath="//a[@title=\"Pay by bank wire\"]")
	WebElement payByBankWire;
	
	public ShoppingCartSummaryPaymentPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public ShippingCartOrderSummaryPage clickPayByBankWire()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		payByBankWire.click();
		return new ShippingCartOrderSummaryPage();
	}

}
