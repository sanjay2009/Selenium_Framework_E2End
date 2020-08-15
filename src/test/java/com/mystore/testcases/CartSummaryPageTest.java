package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;
import com.mystore.pageobjectmodel.SearchResultpage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryAddressPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryPage;

public class CartSummaryPageTest extends Baseclass {

	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultpage sp;
	ShoppingCartSummaryPage cartSummary;
	ShoppingCartSummaryAddressPage cartAddress;
	
//	AddToCartPage addcart;
//	
//	ShoppingCartSummaryShippingPage cartShipping;
	@Parameters("Browser")
	@BeforeMethod(groups = {"smoke", "regression"})
	
	public void signIn(String browser)
	{
		launchBrowser(browser);
		
	}
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void tesrDown()
	{
		hp.clickSignOutLink();
		driver.quit();
	}
	
	@Test(groups = "smoke")
	public void verifyCartSummaryTest()
	{
		ip= new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		cartSummary = hp.clickMyCart();
		cartSummary.validateTotalPrice();
		cartAddress = cartSummary.clickProceedToCheckoutButton();
				
	}
	
}
