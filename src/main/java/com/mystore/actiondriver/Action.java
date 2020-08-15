package com.mystore.actiondriver;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.mystore.base.Baseclass;

public class Action extends Baseclass {
	
	public static void scrollByVisibilityofElement(WebElement ele)
	{
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", ele);
	}
	
	public static void click(WebElement locateElement)
	{
		Actions act = new Actions(driver);
		act.moveToElement(locateElement).click().build().perform();
	}
	
	public static void jsClick(WebElement el) {
	boolean flag = false;
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", el);
		flag = true;
	}
	
	public static void waitinTest()
	{
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
	}
	
	public static void scrollingDown()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
	}
	
	public static void scrollingUp()
	{
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_UP).build().perform();
	}
	
	public static String screenShot(WebDriver driver,String filename) 
	 {
	  String dateName = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
	  TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
	  File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
	  String destination = System.getProperty("user.dir")+"\\ScreenShot\\"+filename+"_"+dateName+".png";
	  File finalDestination= new File(destination);
	  try {
	   FileUtils.copyFile(source, finalDestination);
	  } catch (Exception e) {
	   // TODO Auto-generated catch block
	   e.getMessage();
	  }
	  return destination;
	 }

}
