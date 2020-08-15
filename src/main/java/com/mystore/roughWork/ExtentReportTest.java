package com.mystore.roughWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ExtentReportTest extends ExtentReportBase{
	
	@Test(priority = 1)
	public void test1()
	{	
		//screenShot(driver, null);
		
		WebElement logo = driver.findElement(By.xpath("//img[@alt='My Store']"));
		Assert.assertTrue(logo.isDisplayed());
//		ScreenShot sshot = new ScreenShot();
//		sshot.elementScreenShot(logo);
	}
	
	@Test(priority = 1)
	public void test2()
	{	
		
		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
		driver.findElement(By.id("email")).sendKeys("srs@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		driver.findElement(By.id("SubmitLogin")).click();
		String acttitle = driver.getTitle();
		Assert.assertEquals(acttitle, "My account - My Store");
		System.out.println(acttitle);
	}
	
//	@Test(priority = 3)
//	public void test3()
//	{	
//		
//		driver.findElement(By.xpath("//a[@title='Log in to your customer account']")).click();
//		driver.findElement(By.id("email")).sendKeys("srs@gmail.com");
//		driver.findElement(By.id("passwd")).sendKeys("Test@123");
//		driver.findElement(By.id("SubmitLogin")).click();
//		String acttitle = driver.getTitle();
//		Assert.assertEquals(acttitle, "My Account - My Store");
//		System.out.println(acttitle);
//	}
//	

}
