package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class ShoppingCartSummaryShippingPage extends Baseclass{

	@FindBy(id="cgv")
	WebElement chekBox;
	
	@FindBy(xpath="//*[@id=\"form\"]/div/div[2]/div[1]/div/div/table/tbody/tr/td[4]/div")
	WebElement shippingPrice;
	
	@FindBy(xpath="//*[@id=\"form\"]/p/button")
	WebElement checkOutButton;
	
	public ShoppingCartSummaryShippingPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickTermsAndConditions()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		chekBox.click();
	}
	
	public void verifyShippingPrice()
	{	
		System.out.println("-----------printing shipping price------------------------");
		String sprice = shippingPrice.getText();
		System.out.println("Shipping price is: "+sprice);
		
		System.out.println("-----------completed verifying shipping price------------------------");
	}
	
	public ShoppingCartSummaryPaymentPage clickCheckOutButton()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		checkOutButton.click();
		return new ShoppingCartSummaryPaymentPage();
	}
	
}
