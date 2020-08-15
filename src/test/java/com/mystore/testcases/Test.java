package com.mystore.testcases;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeClass;

public class Test {
	
	WebDriver driver;
	
	@BeforeClass
	public void setUp()
	{
		System.setProperty("webdriver.gecko.driver", "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\Drivers\\geckodriver.exe");
		driver = new FirefoxDriver();
		
		driver.get("http://www.automationpractice.com/index.php?");
		
	}
	
	
//	@org.testng.annotations.Test
//	public void clicSignIntest()
//	{
//		
//		driver.findElement(By.xpath("//a[@class='login']")).click();
//		driver.findElement(By.xpath("//a[@class='login']")).click();
//		driver.findElement(By.id("email")).sendKeys("srs@gmail.com");
//		driver.findElement(By.id("passwd")).sendKeys("Test@123");
//		driver.findElement(By.id("SubmitLogin")).click();
//		
//		driver.findElement(By.xpath("//a[@title='Addresses']")).click();
//		List<WebElement> ad = driver.findElements(By.xpath("//*[@id=\"center_column\"]/div[1]/div/div/ul"));
//		
//		for (WebElement address : ad)
//		{
//			System.out.println(address.getText());
//		}
//		
//		String actual = driver.findElement(By.xpath("//span[@class='address_name']")).getText();
//		System.out.println(actual);
//		Assert.assertEquals(actual, "fname");
//		
//		String actual1 = driver.findElement(By.xpath("//span[@class='address_address1']")).getText();
//		System.out.println(actual1);
//		Assert.assertEquals(actual1, "206 2nd cross muneshwara block");
//		
//		String actual2 = driver.findElement(By.xpath("//span[@class='address_city']")).getText();
//		System.out.println(actual2);
//		Assert.assertEquals(actual2, "bangalore,");
//		
//		
//		
//		driver.findElement(By.xpath("//a[@title='Log me out']")).click();
//		
//	}
//	
	@org.testng.annotations.Test
	public void readTable()
	{	
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.xpath("//a[@class='login']")).click();
		driver.findElement(By.id("email")).sendKeys("srs@gmail.com");
		driver.findElement(By.id("passwd")).sendKeys("Test@123");
		driver.findElement(By.id("SubmitLogin")).click();
		driver.findElement(By.xpath("//a[@title='Orders']")).click();
		
		
		int row_count = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr")).size();
		System.out.println("Total rows: "+row_count);
		int col_count = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr[1]/td")).size();
		System.out.println("Total columns: "+col_count);
		
		
		for (int i=1; i <= row_count; i++)
		{
			for (int j=1 ; j < 6; j++)
			{
				
				String table_data = driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr["+i+"]/td["+j+"]")).getText();
				System.out.print(table_data+"  ");
				
			}
			System.out.println();
									
		}
		
		
		//int rsize = driver.findElements(By.xpath("//*[@id=\"order-list\"]/tbody/tr")).size();
		List<WebElement> col_price = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr/td[3]"));
		int sum = 0;
		for(WebElement e : col_price)
		{
			sum = sum + Integer.parseInt(e.getText());
		}
		
		System.out.println("Total sum: "+sum);
		
			
		
		
//			List<WebElement> rows = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr"));
//			for (int i=1; i<=rows.size(); i++)
//			{
//				List<WebElement> cols = driver.findElements(By.xpath("//*[@id='order-list']/tbody/tr/td"));
//				
//				for (int j =1; j < 6; j++)
//				{
//					System.out.print(cols.get(j).getText()+" ");
//				}
//				
//				System.out.println();
//			}
			
		
		
		
		
		
	}

}
