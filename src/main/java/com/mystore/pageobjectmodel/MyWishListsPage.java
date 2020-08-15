package com.mystore.pageobjectmodel;

import org.openqa.selenium.Alert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class MyWishListsPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"best-sellers_block_right\"]/div/ul/li[1]/a/img")
	WebElement image1;
	
	@FindBy(id="name")
	WebElement enterwishlistName;
	
	@FindBy(id="submitWishlist")
	WebElement saveButton;
	
	@FindBy(xpath="//a[@class='icon'][1]")
	WebElement deleteFirstWishList;
	
	@FindBy(xpath="//*[@id=\"mywishlist\"]/h1")
	WebElement wishlistLabel;
	
	
	public MyWishListsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public AddToWishListPage selectDress()
	{
		image1.click();
		return new AddToWishListPage();
	}
	
	public void addNewWishList()
	{
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		enterwishlistName.sendKeys("abcd");
		saveButton.click();
		
	}
	
	public void deleteWishList()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		deleteFirstWishList.click();
		
		
		Alert alert = ((WebDriver) driver).switchTo().alert();
		alert.getText();
		System.out.println("Alert message: "+alert.getText());
		alert.accept();
	}
	
	public void verifyname()
	{
		String label = wishlistLabel.getText();
		System.out.println("WishList Page label: "+label);
	}

}
