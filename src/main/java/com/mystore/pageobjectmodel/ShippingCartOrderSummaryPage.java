package com.mystore.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.Baseclass;

public class ShippingCartOrderSummaryPage extends Baseclass{
	

	@FindBy(xpath="//*[@id=\"cart_navigation\"]/button")
	WebElement confirmOrderButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/div/h3")
	WebElement subheader;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/div")
	WebElement paymentdetails;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/p/strong")
	WebElement conifrmOrderMessage;
	
	
	public ShippingCartOrderSummaryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void clickConfimOrder()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		confirmOrderButton.click();
	}
	
	public void verifySubHeader()
	{	
		
		System.out.println("-----------------------Print Bank wire details-------------------");
		List<WebElement> list = (List<WebElement>) paymentdetails;
		for(WebElement payDetails : list )
		{
			System.out.println(payDetails);
		}
		
		//String payDetails = paymentdetails.getText();
		//System.out.println(payDetails);
		
		String actual_subHeader = subheader.getText();
		System.out.println(actual_subHeader);
		
		Assert.assertEquals(actual_subHeader, "Bank-wire payment.");
		
		System.out.println("---------------------------------------------------------------------");
	}
	
	public HomePage verifyConfirmMessage()
	{
		String cmessage =  conifrmOrderMessage.getText();
		System.out.println(cmessage);
		return new HomePage();
	}

}
