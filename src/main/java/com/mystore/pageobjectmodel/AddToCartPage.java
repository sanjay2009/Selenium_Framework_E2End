package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.Baseclass;

public class AddToCartPage extends Baseclass{
	
	@FindBy(name="group_1")
	WebElement size;
	
	@FindBy(xpath="//*[@id=\"add_to_cart\"]/button")
	WebElement addToCartButton;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[1]/h2")
	WebElement message;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[1]/span")
	WebElement tp;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[2]/span")
	WebElement shippringPrice;
	
	@FindBy(xpath="//*[@id=\"layer_cart\"]/div[1]/div[2]/div[3]/span")
	WebElement totalPrice;
	
	@FindBy(xpath="//a[@title='Proceed to checkout']")
	WebElement clickCheckOutButton;
	
	public AddToCartPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void selectSize()
	{
		Select select = new Select(size);
		select.selectByValue("2");
		//System.out.println("Size selected is :");
		
	}
	
	public void clickAddCart()
	{
		addToCartButton.click();
	}
	
	public ShoppingCartSummaryPage clickCheckOut()
	{
		
			
		clickCheckOutButton.click();
		return new ShoppingCartSummaryPage();
	}
	
	public void verifyMessage()
	{
		String messageadded = message.getText();
		System.out.println(messageadded);
		
		String total_Products = tp.getText();
		String total_Shipping = shippringPrice.getText();
		String total = totalPrice.getText();
		System.out.println(total_Products);
		System.out.println(total_Shipping);
		System.out.println(total);
	}
}
