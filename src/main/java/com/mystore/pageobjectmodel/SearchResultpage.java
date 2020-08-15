package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class SearchResultpage extends Baseclass{
	
	@FindBy(xpath="//a[@class='products-block-image content_img clearfix']")
	WebElement image;
	
	
	public SearchResultpage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public AddToCartPage clickImage()
	{
		image.click();
		return new AddToCartPage();
	}
	
}
