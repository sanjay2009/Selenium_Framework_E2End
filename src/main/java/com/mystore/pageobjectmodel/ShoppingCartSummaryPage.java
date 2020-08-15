package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.mystore.base.Baseclass;

public class ShoppingCartSummaryPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"total_product\"]")
	WebElement productPrice;
	
	@FindBy(xpath="//*[@id=\"total_shipping\"]")
	WebElement shippingPrice;
	
	@FindBy(xpath="//*[@id=\"total_price_without_tax\"]")
	WebElement total_Price_WithoutTax;
	
	@FindBy(xpath="//*[@id=\"total_price\"]")
	WebElement total_Price;
	
	@FindBy(xpath="//a[@class='button btn btn-default standard-checkout button-medium']")
	WebElement checkoutButton;
	
	@FindBy(xpath="//*[@id=\"cart_title\"]")
	WebElement shppingCartLabel;
	
	public ShoppingCartSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateTotalPrice()
	{	
		System.out.println("-------------Checking Price details--------------------------");
		String pp= productPrice.getText();
		String sp = shippingPrice.getText();
		String tpwt = total_Price_WithoutTax.getText();
		String tp = total_Price.getText();
		System.out.println("Product Price: "+pp);
		System.out.println("Shipping Price: "+sp);
		System.out.println("Total Price :"+tp);
		
		System.out.println("-------------completed verifying Price details--------------------------");
	}
	
	public ShoppingCartSummaryAddressPage clickProceedToCheckoutButton()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(checkoutButton));
		Actions action1 = new Actions(driver);
		action1.moveToElement(checkoutButton);
		
		checkoutButton.click();
		return new ShoppingCartSummaryAddressPage();
	}
	
	public void cartSummaryLabel()
	{
		String label = shppingCartLabel.getText();
		System.out.println("shpping Cart Summary Page label :"+label);
	}
	
	
}
