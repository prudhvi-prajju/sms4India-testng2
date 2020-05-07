package pages;

import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.*;

public class SendSMSPage {

	public RemoteWebDriver driver;
	
	//Locators
	
	@FindBy(name = "toMobile") public WebElement toMobile; // other persons mobile number
	
	@FindBy(name = "messageEng") public WebElement msgBody; // Message Body
	
	@FindBy(xpath = "//*[contains(text(), 'Send SMS in 10 languages')]") public WebElement display;
	
	@FindBy(xpath = "//*[text()='Send Sms']") public WebElement sendButton; // send SMS button
	
	@FindBy(xpath = "//*[text()='Invalid Mobile Number']") public WebElement toInvalidMobError; // this error msg occurs for 1 to 5 series
	
	@FindBy(xpath = "//*[text()='Enter Valid Mobile Number.']") public WebElement toMobBlankError; // this error msg occurs when entering blank mobile number
	
	@FindBy(xpath = "//*[contains(text(),'Please enter a message')]") public WebElement msgBlankError; // this error msg occurs when message body is blank
	
	@FindBy(xpath = "//*[@class='logout']") public WebElement logout; // for logout;
	
	//constructor
	
	public SendSMSPage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);	

	}
	
	public void fillToMobile(String x)
	{
		toMobile.sendKeys(x);
	}
	
	public void fillMsgBody(String x)
	{
		msgBody.sendKeys(x);
	}
	
	public void clickLogout()
	{
		logout.click();
	}
}
