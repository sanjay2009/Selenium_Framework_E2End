package com.mystore.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class OrderHistoryPage extends Baseclass{
	
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p")
	WebElement orderHistoryTitle;
	
	@FindBy(xpath="//*[@id=\"order-list\"]/thead/tr/th")
	WebElement colHeader;
	
	@FindBy(xpath="//*[@id='order-list']/tbody/tr")
	WebElement firstRow;
	
	@FindBy(xpath="//*[@id=\"order-list\"]/tbody/tr/td[3]")
	WebElement columnPrice;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/h1")
	WebElement orderHistoryLabel;
	
	public OrderHistoryPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void orderhistoryLabel()
	{
		String label = orderHistoryLabel.getText();
		System.out.println("Order History label: "+label);
	}
		
	public void verifyHeader()
	{
		String header = orderHistoryTitle.getText();
		System.out.println("Header is :"+header);
	}
	
	public void printOrderHistory()
	{
		
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
				
	}
	
	public void sumoOfAllTotalPrice()
	{
		List<WebElement> col_price = (List<WebElement>) columnPrice;
		int sum = 0;
		for(WebElement e : col_price)
		{
			sum = sum + Integer.parseInt(e.getText());
		}
		
		System.out.println("Total sum: "+sum);
	}
		
	
	
	

}
