package com.mystore.pageobjectmodel;

import java.util.Random;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.Baseclass;

public class AccountCreationPage extends Baseclass{
	
	@FindBy(xpath="//*[@id=\"id_gender1\"]")
	WebElement radiobutton;
	
	@FindBy(id="customer_firstname")
	WebElement fname;
	
	@FindBy(id="customer_lastname")
	WebElement lname;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="passwd")
	WebElement pwd;
	
	@FindBy(id="days")
	WebElement days;
	
	@FindBy(id="months")
	WebElement months;
	
	@FindBy(id="years")
	WebElement years;
	
	@FindBy(id="address1")
	WebElement address1;
	
	@FindBy(id="city")
	WebElement city;
	
	@FindBy(id="id_state")
	WebElement state;
	
	@FindBy(id="postcode")
	WebElement postcode;
	
	@FindBy(id="id_country")
	WebElement country;
	
	@FindBy(id="phone_mobile")
	WebElement phoneNo;
	
	@FindBy(id="submitAccount")
	WebElement registerButton;
	
	@FindBy(xpath="//a[@title='View my customer account']")
	WebElement aname;
	
	
	
	public AccountCreationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void createNewaccountdetails()
	{	
		String s = RandomStringUtils.randomAlphabetic(5);
		Random random = new Random();
		int randomint = random.nextInt(1000);
		
		radiobutton.click();
		fname.sendKeys(s);
		lname.sendKeys(s);
		emailId.clear();
		emailId.sendKeys("fname"+randomint+"@gmail.com");
		pwd.sendKeys("Password1234");
		
		Select dp1 = new Select(days) ;
		dp1.selectByValue("31");
		
		Select dp2 = new Select(months) ;
		dp2.selectByValue("3");
		
		Select dp3 = new Select(years) ;
		dp3.selectByValue("1977");
		
		address1.sendKeys("Bangalore India");
		city.sendKeys("Bangalore");
		
		Select dp4 = new Select(state);
		dp4.selectByValue("6");
		
		postcode.sendKeys("12345");
		
		Select dp5 = new Select(country);
		dp5.selectByValue("21");
		
		phoneNo.sendKeys("8769034521");
		
		
	}
	
	public HomePage clickRegisterButton()
	{
		registerButton.click();
		return new HomePage();
	}
	
	
	public String validate_name()
	{
		String actual_Name = aname.getText();
		
		return actual_Name;
	}

}
