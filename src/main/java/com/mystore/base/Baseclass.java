package com.mystore.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.xml.DOMConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.*;
import org.w3c.dom.DOMConfiguration;

import com.mystore.actiondriver.Action;
import com.mystore.roughWork.ExtentManager;
import com.mystore.utility.Log;

import io.github.bonigarcia.wdm.WebDriverManager;



public class Baseclass {
	
	
	public static Properties prop;
	public static WebDriver driver;
	
	//declared thread local driver
	//public static ThreadLocal<RemoteWebDriver> driver = new ThreadLocal<RemoteWebDriver>();
//	public static WebDriver getiDriver()
//	{
//		return driver.get();
//	}
			
	public Baseclass()
	{	
		
				
		try{
			prop = new Properties();
		
		//System.out.println("Super constructor invoked");
		String path = System.getProperty("user.dir") +"/Configuration/config.properties";
		FileInputStream fis = new FileInputStream(path);
		prop.load(fis);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException io)
		{
			io.printStackTrace();
		}
		
	}
	
	
	public static void launchBrowser(String bname)
	{
		
		//String browser = prop.getProperty("browsername");
		if (bname.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\chromedriver.exe");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			//set browser to ThreadLocalMap
			//driver.set(new ChromeDriver());
			
			
		}
		
		else if (bname.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\geckodriver.exe");
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			//driver.set(new FirefoxDriver());
		}
		
		else if(bname.equals("ie"))
		{
			System.setProperty("webdriver.IE.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\IEDriverServer.exe");
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
			//driver.set(new InternetExplorerDriver());
		}
		
		else
		{
			System.out.println("Select valid browser");
		}
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		//Log.info("Launching browser "+prop.getProperty("browsername"));
		driver.get(prop.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(25, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		
		
	}
	
	
	 
	
	@BeforeSuite(groups = {"smoke", "regression"})
	public void beforeSuite()
	{	
		com.mystore.utility.ExtentManager.setExtent();
		DOMConfigurator.configure("log4j.xml");
		//Log.info("This is before suite method");
		
		
	}
	
	@AfterSuite(groups = {"smoke", "regression"})
	public void afterSuite()
	{
		com.mystore.utility.ExtentManager.endReport();
		DOMConfigurator.configure("log4j.xml");
		//Log.info("This is after suite method");
	}
		

}
