/**
 * 
 */
package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * @author PRAJJU
 * This class consists of Homepage locators and operational methods
 */
public class HomePage {

	public RemoteWebDriver driver;
	public WebDriverWait w;
	
	// Locators
	
	@FindBy(name = "mobileNo") public WebElement mobNum; //  mobile number field object in login page
	
	
	@FindBy(xpath = "//*[@class='error']") public WebElement errorMsg; // for error messages in Login page
	
	
	@FindBy(name = "password") public WebElement password; // password field object in login page
	

	
	@FindBy(xpath = "(//button[contains(text(),'Login')])[1]") public WebElement loginButton; // login button object in login page
	
	
	
	//constructor
	
	public HomePage(RemoteWebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);			
	}
	
	//operational methods
	
	public void loginCredentials(String x, String y) 
	{
		
		try {
			mobNum.click();
			Thread.sleep(2000);
			mobNum.sendKeys(x);
			password.click();
			Thread.sleep(2000);
			password.sendKeys(y);
			Thread.sleep(2000);
		} catch (Exception e) {
			// TODO: handle exception
			e.getStackTrace();
		}
			loginButton.click();
		

		
	}
		
	
}
