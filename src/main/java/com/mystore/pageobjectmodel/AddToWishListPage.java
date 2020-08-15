package com.mystore.pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class AddToWishListPage extends Baseclass{
	
	@FindBy(xpath="//a[@title=\"Add to my wishlist\"]")
	WebElement addwishlist;
	
	@FindBy(id="quantity_wanted")
	WebElement quantity;
	
	@FindBy(xpath="//a[@class='fancybox-item fancybox-close']")
	WebElement popclose;
	
	@FindBy(xpath="//p[@class='fancybox-error']")
	WebElement popupMessage;
	
	public AddToWishListPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickAddToWishList()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		
		addwishlist.click();
	}
	
	
	public void quantityCheck()
	{
		String count = quantity.getAttribute("value");
		System.out.println("The quantity selected is: "+count);
		
	}
	
	public void closePopUp()
	{
//		Alert alert = driver.switchTo().alert();
//		alert.getText();
//		System.out.println("Adding wish list pop up message: "+alert.getText());
//		alert.dismiss();
		
		
		System.out.println("Adding wish list pop up message: "+popupMessage.getText());
		popclose.click();
				
	}
	
	

}
