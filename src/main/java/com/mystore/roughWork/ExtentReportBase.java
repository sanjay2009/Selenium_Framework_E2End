package com.mystore.roughWork;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReportBase {
	public static WebDriver driver;
	
	@BeforeSuite
	public void before()
	{
		ExtentManager.setExtent();
	}
	
	@AfterSuite
	public void after()
	{
		ExtentManager.endReport();
	}
	
		
	@BeforeMethod
	public void setUp()
	{
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("http://www.automationpractice.com/index.php?");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
	}
	
	@AfterMethod
	public void tearDown() throws IOException 
	{
		 	   		 
		 driver.close();
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
