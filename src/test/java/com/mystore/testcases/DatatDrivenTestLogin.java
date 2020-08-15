package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.dataprovider.DataProviders;
import com.mystore.pageobjectmodel.HomePage;
import com.mystore.pageobjectmodel.IndexPage;
import com.mystore.pageobjectmodel.LoginPage;

public class DatatDrivenTestLogin extends Baseclass{
	
	IndexPage ip;
	LoginPage lp;
	HomePage hp;
	@Parameters("Browser")
	@BeforeMethod(groups = {"smoke", "regression"})
	public void signIn(String Browser)
	{
		launchBrowser(Browser);
		
	}
	
	@Test(dataProvider="credentials", dataProviderClass = DataProviders.class, groups = {"smoke", "regression"})
	public void loginTest(String uname, String pword)
	{
	ip = new IndexPage();
	lp = ip.clickSignIn();
	System.out.println("Page title is :"+ driver.getTitle());
	//lp = new LoginPage();
	lp.enterUNDataDriver(uname);
	lp.enterPWDataDriver(pword);
	hp = lp.clicksignInButton();
	System.out.println("After login, page ttile is: "+driver.getTitle());
	//hp = new HomePage();
	hp.clickSignOutLink();
	
	}
	
	
	@AfterMethod(groups = {"smoke", "regression"})
	public void tearDown()
	{
		driver.quit();
	}

}
