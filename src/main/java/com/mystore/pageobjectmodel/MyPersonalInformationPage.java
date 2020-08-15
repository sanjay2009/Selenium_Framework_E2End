package com.mystore.pageobjectmodel;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;

public class MyPersonalInformationPage extends Baseclass{
	
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/ul/li[1]/a")
	WebElement backButtonAccount;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div/h1")
	WebElement myPersonalInfoLabel;
	
	public MyPersonalInformationPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	
	public void verifyMyInfoLabel()
	{
		String label = myPersonalInfoLabel.getText();
		System.out.println("My PersonalInformation Label: "+label);
	}
	
	public HomePage clickBack()
	{
		backButtonAccount.click();
		return new HomePage();
	}
}
