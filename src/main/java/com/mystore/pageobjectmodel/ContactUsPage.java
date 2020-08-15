package com.mystore.pageobjectmodel;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.mystore.base.Baseclass;

public class ContactUsPage extends Baseclass{
	
	@FindBy(name="id_contact")
	WebElement subjectHeading;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="id_order")
	WebElement order_reference_no;
	
	@FindBy(id="fileUpload")
	WebElement attachment;
	
	@FindBy(id="message")
	WebElement messageDetails;
	
	@FindBy(id="submitMessage")
	WebElement sendButton;
	
	
	@FindBy(xpath="//*[@id=\"center_column\"]/p/text()")
	WebElement confirmMessage;
	
	public ContactUsPage()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void enterDetails()
	{
		Select dp = new Select(subjectHeading);
		dp.selectByValue("Customer service");
		emailId.sendKeys(prop.getProperty("username"));
		order_reference_no.sendKeys("001");
		messageDetails.sendKeys("My first message");
		sendButton.click();
		//String expected = "Your message has been successfully sent to our team.";
		//String actual = confirmMessage.getText();
		confirmMessage.getText();
		
	}
	
}
