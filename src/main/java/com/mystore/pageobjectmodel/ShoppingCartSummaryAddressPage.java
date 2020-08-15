package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.mystore.base.Baseclass;

public class ShoppingCartSummaryAddressPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[2]")
	WebElement name;
	
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[3]")
	WebElement address;
	
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[4]")
	WebElement cityDetails;
	
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[5]")
	WebElement country;
	
	@FindBy(xpath="//*[@id=\"address_delivery\"]/li[6]")
	WebElement phone;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/form/p/button")
	WebElement proceedButton;



	public ShoppingCartSummaryAddressPage()
	{
		PageFactory.initElements(driver, this);
	}

	public void verifyAddress()
	{
	
	System.out.println("------------------Verifying address details------------------------");
	String actual_name = name.getText();
	System.out.println(actual_name);
	SoftAssert sassert = new SoftAssert();
	sassert.assertEquals(actual_name, "fname lname","Name assertion should pass");
	sassert.assertAll();
	//Assert.assertEquals(actual_name, "fname lname");
	
	
	String actual_address = address.getText();
	System.out.println(actual_address);
	SoftAssert sassert1 = new SoftAssert();
	sassert1.assertEquals(actual_address, "206 2nd cross muneshwara block");
	//Assert.assertEquals(actual_address, "206 2nd cross muneshwara block");
	sassert1.assertAll();
	
	
	String actual_city = cityDetails.getText();
	System.out.println(actual_city);
	SoftAssert sassert2 = new SoftAssert();
	sassert2.assertEquals(actual_city, "bangalore, Alaska 56008","City assertion should pass");
	//Assert.assertEquals(actual_city, "bangalore, Alaska 56008");
	sassert2.assertAll();
	
	String actual_country = country.getText();
	System.out.println(actual_country);
	SoftAssert sassert3 = new SoftAssert();
	sassert3.assertEquals(actual_country, "United States","Country assertion should pass");
	sassert3.assertAll();
	//Assert.assertEquals(actual_country, "United States");
	
	String actual_phone = phone.getText();
	System.out.println(actual_phone);
	SoftAssert sassert4 = new SoftAssert();
	sassert4.assertEquals(actual_phone, "675432897", "Phone assertion should pass");
	sassert4.assertAll();
	//Assert.assertEquals(actual_phone, "United States");
	System.out.println("--------------Address details verification completed-----------------------");
					
	}
	
	public ShoppingCartSummaryShippingPage clickProceedButton()
	{	
		Actions action = new Actions(driver);
		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		proceedButton.click();
		return new ShoppingCartSummaryShippingPage();
	}
}
