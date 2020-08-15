package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;
import com.mystore.utility.Log;

public class IndexPage extends Baseclass{
	
	@FindBy(xpath="//a[@class='login']")
	WebElement signInButton;
	
	@FindBy(xpath="//img[@class='logo img-responsive']")
	WebElement logo;
	
	@FindBy(xpath="//*[@id=\"header\"]/div[3]/div/div/div[3]/div/a")
	WebElement cart;
	
	@FindBy(name="search_query")
	WebElement searchBox;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@title='Contact Us']")
	WebElement contactUs;
	
	public IndexPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSignIn()
	{
		//Log.info("Clicking signIn link");
		signInButton.click();
		return new LoginPage();
	}
	
	public boolean validateLogo()
	{
		return logo.isDisplayed();
	}
	
	public AddToCartPage clickCart()
	{
		cart.click();
		return new AddToCartPage();
	}
	
	public SearchResultpage enterSearch()
	{
		searchBox.sendKeys("t shirt");
		searchButton.click();
		return new SearchResultpage();
	}
	
	public ContactUsPage clickContactUs()
	{
		contactUs.click();
		return new ContactUsPage();
	}
}
