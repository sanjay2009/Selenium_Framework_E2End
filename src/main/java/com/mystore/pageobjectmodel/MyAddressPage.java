package com.mystore.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class MyAddressPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/div/div/ul")
	WebElement Myaddress;
	
	public MyAddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void printAddress()
	{
		List<WebElement> list = (List<WebElement>) Myaddress;
		for(WebElement address: list)
		{
			System.out.println(address.getText());
		}
		
	}

}
