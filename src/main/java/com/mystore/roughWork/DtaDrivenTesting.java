package com.mystore.roughWork;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.mystore.utility.NewExcelLibrary;

public class DtaDrivenTesting {
	
		WebDriver driver;
		
		@Test(dataProvider = "credentials")
		public void login(String un, String pw)
		{
		
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://www.automationpractice.com/index.php?");
		
		driver.findElement(By.id("email")).sendKeys(un);
		driver.findElement(By.id("passwd")).sendKeys(pw);
}
		
		public class DataProviders {
			
			NewExcelLibrary obj = new NewExcelLibrary();
			
			@DataProvider(name= "credentials")
			public Object[][] getCredentials()
			{
				int rows = obj.getRowCount("Sheet1");
				int cols = obj.getColumnCount("Sheet1");
				int actualRows = rows - 1;
				
				Object [][] data = new Object[actualRows][cols];
				for(int i = 0; i <= actualRows; i++)
				{
					for (int j = 0; j < cols; j++)
					{
						data[i][j] = obj.getCellData("Sheet1", j, i+2);
					}
					
				}
				
				return data;
			} 
		
}
}
