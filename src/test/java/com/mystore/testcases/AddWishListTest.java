package com.mystore.testcases;

import java.util.logging.Logger;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.AddToWishListPage;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;
import com.mystore.pageobjectmodel.MyWishListsPage;

public class AddWishListTest extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	MyWishListsPage wp;
	AddToWishListPage awlp;
	
	@BeforeMethod(groups = {"smoke", "regression"})
	public void signIn(String browser)
	{
		launchBrowser(browser);
		
	}
	
	@Test(groups = "smoke",priority=1)
	public void addProductToWishList()
	{
		System.out.println("Adding prodcut to wishlist");
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		wp = hp.clickMyWishList();
		awlp = wp.selectDress();
		awlp.quantityCheck();
		//System.out.println("Quantity selected: "+awlp.quantityCheck());
		awlp.clickAddToWishList();
		awlp.closePopUp();
		hp.clickProfileName();
		
				
	}
	
	@Test(groups = "smoke", priority=2)
	public void AddWishListName()
	{	
		System.out.println("Adding a new WishList name");
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		wp = hp.clickMyWishList();
		wp.addNewWishList();
		
	}
	
	@Test(groups = "smoke", priority=3)
	public void deleteWishList()
	{	
		System.out.println("Deleting a WishList from the list");
		ip = new IndexPage();
		lp = ip.clickSignIn();
		lp.enterUserName();
		lp.enterPassword();
		hp = lp.clicksignInButton();
		wp = hp.clickMyWishList();
		wp.deleteWishList();
		
	}
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void tesrDown()
	{
		hp.clickSignOutLink();
		driver.quit();
	}

}
