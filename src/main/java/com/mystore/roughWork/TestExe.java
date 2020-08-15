package com.mystore.roughWork;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestExe {
	
	public static void main(String[] args) {
	WebDriver driver;
	
	
	System.setProperty("webdriver.gecko.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\geckodriver.exe");
	driver = new FirefoxDriver();
	
	driver.get("http://www.automationpractice.com/index.php?");
	
	
	}
}
