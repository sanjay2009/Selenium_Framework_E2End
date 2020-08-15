package com.mystore.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.mystore.base.Baseclass;
import com.mystore.pageobjectmodel.IndexPage;

import junit.framework.Assert;

public class IndexPageTest extends Baseclass{
	
	IndexPage ip;
	
//		public IndexPageTest()
//		{
//			super();
//		}
	@Parameters("Browser")
		@BeforeMethod
		 
		public void signIn(String Browser)
		{
			launchBrowser(Browser);
			
		}
		
		@Test
		public void validateSignInTest()
		{
			ip = new IndexPage();
			ip.clickSignIn();
			String actual = driver.getTitle();
			System.out.println("Page title is: "+ actual);
			Assert.assertEquals("Login - My Store", actual);
		}
		
		@Test
		public void validateLogoTest()
		{	
			ip = new IndexPage();
			boolean result = ip.validateLogo();
			Assert.assertTrue(result);
			
		}
	
		@Test
		public void validateSearchPageTest()
		{	
			ip = new IndexPage();
			ip.enterSearch();
			
		}
		
		
		
		
		@AfterMethod
		public void tearDown()
		{
			driver.close();
		}
		
		
	

}
