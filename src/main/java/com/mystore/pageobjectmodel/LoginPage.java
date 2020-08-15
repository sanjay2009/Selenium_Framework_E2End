package com.mystore.pageobjectmodel;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.mystore.base.Baseclass;
import com.mystore.utility.Log;

public class LoginPage extends Baseclass{

	@FindBy(id="email")
	WebElement un;
	
	@FindBy(id="passwd")
	WebElement pw;
	
	@FindBy(id="SubmitLogin")
	WebElement loginButton;
	
	@FindBy(xpath="//a[@title='Recover your forgotten password']")
	WebElement forgotPassword;
	
	@FindBy(id="email_create")
	WebElement enterEmail;
	
	@FindBy(xpath="//*[@id=\"SubmitCreate\"]")
	WebElement createAccountButton;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")
	WebElement authenticFailedMessage;
	
	@FindBy(xpath="//*[@id=\"center_column\"]/div[1]/ol/li")
	WebElement failedMessage;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
		
	}
	
	public void enterUserName()
	{	
		//Log.info("Entering username");
		un.sendKeys(prop.getProperty("username"));
	}
	
	public void enterUNDataDriver(String userN)
	{
		un.sendKeys(userN);
	}
	
	public void enterPassword()
	{	
		//Log.info("Entering password");
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		pw.sendKeys(prop.getProperty("password"));
	}
	
	public void enterPWDataDriver(String pWord)
	{
		pw.sendKeys(pWord);
	}
	
	public HomePage clicksignInButton()
	{	
//		Actions action = new Actions(driver);
//		action.sendKeys(Keys.PAGE_DOWN).build().perform();
		//Log.info("clicking Login button");
		loginButton.click();
			
		return new HomePage();
	}
	
	public AccountCreationPage clickCreateNewAccount()
	{
		enterEmail.clear();
		enterEmail.sendKeys("srsr@gmail.com");
		createAccountButton.click();
		return new AccountCreationPage();
		
	}
	
	public void clickCreateNewInvalidEntry()
	{
		enterEmail.sendKeys("ss@.com");
		createAccountButton.click();
		
		String failure = failedMessage.getText();
		System.out.println(failure);
		
	}
	
	public void printLoginMessage()
	{
		String actfailedMessage = authenticFailedMessage.getText();
		System.out.println(actfailedMessage);
	}
	
	
	
}
