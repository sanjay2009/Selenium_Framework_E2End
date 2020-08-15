package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.AddToCartPage;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;
import com.mystore.pageobjectmodel.SearchResultpage;
import com.mystore.pageobjectmodel.ShippingCartOrderSummaryPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryAddressPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryPaymentPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryShippingPage;
import com.mystore.utility.Log;

public class E2ETTest extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	SearchResultpage sp;
	AddToCartPage addcart;
	ShoppingCartSummaryPage cartSummary;
	ShoppingCartSummaryAddressPage cartAddress;
	
	ShoppingCartSummaryShippingPage cartShipping;
	ShoppingCartSummaryPaymentPage cartPayment;
	ShippingCartOrderSummaryPage cartOrder;
	
	
	
	
	@Parameters("Browser")
	@BeforeMethod(groups = {"smoke", "regression"})
	public void signIn(String Browser)
	{
		launchBrowser(Browser);
		
	}
	
	
	@Test(groups = "regression")
	public void addOrderAndVerifyDetailsTest()
	{	
		Log.startTestCase("E2ETTest");
		Log.info("Launching browser");

		ip= new IndexPage();
		lp = ip.clickSignIn();
		
		Log.info("Entering username");
		lp.enterUserName();
		Log.info("Entering password");
		lp.enterPassword();
		Log.info("Clicking signIn button");
		hp = lp.clicksignInButton();
		
		Log.info("Searching for product");
		sp = hp.searchProduct();
		addcart = sp.clickImage();
		Log.info("Selecting size");
		addcart.selectSize();
		addcart.clickAddCart();
		
		Log.info("Verifying message");
		addcart.verifyMessage();
		
		cartSummary = addcart.clickCheckOut();
		cartSummary.validateTotalPrice();
		
		cartAddress = cartSummary.clickProceedToCheckoutButton();
		cartAddress.verifyAddress();
		
		cartShipping = cartAddress.clickProceedButton();
		cartShipping.verifyShippingPrice();
		cartShipping.clickTermsAndConditions();
		
		cartPayment = cartShipping.clickCheckOutButton();
		
		cartOrder = cartPayment.clickPayByBankWire();
		cartOrder.clickConfimOrder();
		
		hp = cartOrder.verifyConfirmMessage();
		hp.clickProfileName();
		
		Log.endTestCase("E2ETTest");
		Log.info("Test Completed");
		
	}
	
	
	
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void tesrDown()
	{
		hp.clickSignOutLink();
		driver.quit();
	}

}
