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
import com.mystore.pageobjectmodel.MyAddressPage;
import com.mystore.pageobjectmodel.MyPersonalInformationPage;
import com.mystore.pageobjectmodel.MyWishListsPage;
import com.mystore.pageobjectmodel.OrderHistoryPage;
import com.mystore.pageobjectmodel.SearchResultpage;
import com.mystore.pageobjectmodel.ShippingCartOrderSummaryPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryAddressPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryPaymentPage;
import com.mystore.pageobjectmodel.ShoppingCartSummaryShippingPage;

public class HomePageTest extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	MyWishListsPage myWL;
	SearchResultpage sp;
	AddToCartPage addcart;
	ShoppingCartSummaryPage cartSummary;
	ShoppingCartSummaryAddressPage cartAddress;
	OrderHistoryPage oh;
	ShoppingCartSummaryShippingPage cartShipping;
	ShoppingCartSummaryPaymentPage cartPayment;
	ShippingCartOrderSummaryPage cartOrder;
	MyPersonalInformationPage mi;
	MyAddressPage madd;
	
	@Parameters("Browser")
	@BeforeMethod(groups = {"smoke", "regression"})
	public void signIn(String Browser)
	{
		launchBrowser(Browser);
		
	}
	
	@Test(groups = "smoke", priority=1)
	public void HomePageClickCartTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		cartSummary = hp.clickMyCart();
		cartSummary.cartSummaryLabel();
		
		
//		hp.clickMyWishList();
//		hp.clickProfileName();
//		hp.searchProduct();
//		hp.myAddress();
//		hp.clickSignOutLink();
	}
	
	@Test(groups = "smoke", priority=2)
	public void HomePageClickMyWishListTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		myWL = hp.clickMyWishList();
		myWL.verifyname();
		
	}
	
	@Test(groups = "smoke", priority=3)
	public void HomePageClickOrderHistoryTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		oh = hp.clickOrderHistory();
		oh.orderhistoryLabel();
		oh.verifyHeader();
		oh.printOrderHistory();
		//oh.sumoOfAllTotalPrice();
		
		
	}
	
	@Test(groups = "smoke", priority=4)
	public void HomePageClickMyPersonalInfoTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		mi = hp.clickMyPersonalInfo();
		mi.verifyMyInfoLabel();
		mi.clickBack();
		
	}
	
	@Test(groups = "smoke", priority=5)
	public void HomePageClickMyAddressTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		madd = hp.myAddress();
		madd.printAddress();
		
	}
	
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void tesrDown()
	{
		hp.clickSignOutLink();
		driver.quit();
	}

	

}
