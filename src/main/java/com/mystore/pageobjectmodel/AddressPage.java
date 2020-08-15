package com.mystore.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.mystore.base.Baseclass;

public class AddressPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/div/div/ul")
	WebElement addressDetials;
	
	
	
	public AddressPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void printmyAddress()
	{
		List<WebElement> list = (List<WebElement>) addressDetials;
		for (WebElement address : list)
		{
			System.out.println(address.getText());
		}
	}
	
	
	
	
}
