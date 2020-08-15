package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.AccountCreationPage;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;
import com.mystore.utility.Log;

import junit.framework.Assert;

public class AccountCreationTest extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	AccountCreationPage ac;
	HomePage hp;

@Parameters("Browser")
@BeforeMethod(groups = {"smoke", "regression"})
public void signIn(String Browser)
{
	launchBrowser(Browser);
	
}

@Test(groups = "smoke")
public void enterNewAccountDetails()
{	
	
	Log.startTestCase("enterNewAccountDetails");
	Log.info("Test Execution started");
	
	ip = new IndexPage();
	lp = ip.clickSignIn();
	ac = lp.clickCreateNewAccount();
	
	ac.createNewaccountdetails();
	ac.clickRegisterButton();
	System.out.println("after creating new account, page title: "+ driver.getTitle());
	//String Expected_name = "Santen Ramten";
	System.out.println("Name is : "+ ac.validate_name());
	//String actName = ac.validate_name();
	//String actName = ac.validate_name();
	//Assert.assertEquals(Expected_name, actName);
	hp = new HomePage();
	hp.clickSignOutLink();
	
	Log.endTestCase("enterNewAccountDetails");

}

@AfterMethod(groups = {"smoke", "regression"})
public void tearDown()
{
	driver.quit();
}
	

}
