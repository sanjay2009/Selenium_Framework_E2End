package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class HomePage extends Baseclass{
	

	@FindBy(xpath="//a[@title='Log me out']")
	WebElement signout;
	
	@FindBy(xpath="//a[@title='My wishlists']")
	WebElement wishList;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement profileName;
	
	@FindBy(xpath="//a[@title='View my shopping cart']")
	WebElement myCart;
	
	@FindBy(xpath="//a[@title='Check out']")
	WebElement checkOutButton;
	
	@FindBy(xpath="//a[@title='Addresses']")
	WebElement address;
	
	@FindBy(id="search_query_top")
	WebElement search;
	
	@FindBy(xpath="//*[@id=\"searchbox\"]/button")
	WebElement searchButton;
	
	@FindBy(xpath="//a[@title='Orders']")
	WebElement orderHistory;
	
	@FindBy(xpath="//a[@title='Information']")
	WebElement MyPersonalInfo;
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public LoginPage clickSignOutLink()
	{
		signout.click();
		return new LoginPage();
	}
	
	public MyWishListsPage clickMyWishList()
	{
		wishList.click();
		return new MyWishListsPage();
		
	}
	
	public HomePage clickProfileName()
	{
		
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
		profileName.click();
		return new HomePage();
	}
	
	public ShoppingCartSummaryPage clickMyCart()
	{
//		myCart.click();
//		checkOutButton.click();
//		return new AddToCartPage();
		
		myCart.click();
		return new ShoppingCartSummaryPage();
		
	}
	
	public SearchResultpage searchProduct()
	{
		search.sendKeys("shirt");
		searchButton.click();
		return new SearchResultpage();
	}
	
	public MyAddressPage myAddress()
	{
		address.click();
		return new MyAddressPage();
	}
	

	public OrderHistoryPage clickOrderHistory()
	{
		orderHistory.click();
		return new OrderHistoryPage();
	}
	
	public MyPersonalInformationPage clickMyPersonalInfo()
	{
		MyPersonalInfo.click();
		return new MyPersonalInformationPage();
	}
	
	

}
