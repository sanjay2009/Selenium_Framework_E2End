package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.actiondriver.Action;
import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;

import junit.framework.Assert;

public class LoginPageTest extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	
	@Parameters("Browser")
	@BeforeMethod
	public void signIn(String Browser)
	{
		launchBrowser(Browser);
		
	}
	
	@Test(groups = "smoke")
	public void loginTest()
	{
	ip = new IndexPage();
	lp = ip.clickSignIn();
	System.out.println("Page title is :"+ driver.getTitle());
	//lp = new LoginPage();
	lp.enterUserName();
	lp.enterPassword();
	
	hp = lp.clicksignInButton();
	
//	String expected = "Authentication failed.";
//	Assert.assertEquals(expected, lp.printLoginMessage();
			
	
	System.out.println("After login, page ttile is: "+driver.getTitle());
	//hp = new HomePage();
	hp.clickSignOutLink();
	
	}
	
	@Test(groups = "smoke")
	public void createNewAccountTest()
	{
		ip = new IndexPage();
		lp = ip.clickSignIn();
		//lp.clickCreateNewInvalidEntry();
		//lp = new LoginPage();
		//Action.scrollByVisibilityofElement(enterEmail);
		lp.clickCreateNewAccount();
		System.out.println("Create new account, page title is: "+ driver.getTitle());
	}
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
