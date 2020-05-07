package utilities;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestUtility {

	public RemoteWebDriver driver;
	
	public TestUtility()
	{
		driver=null;
	}
	
	public RemoteWebDriver openBrowser(String bn)
	{
		switch(bn)
		{
		case "chrome":  WebDriverManager.chromedriver().setup();
						System.setProperty("webdriver.chrome.silentOutput", "true");
						driver = new ChromeDriver();
						break;
						
		case "firefox": WebDriverManager.firefoxdriver().setup();
						driver = new FirefoxDriver();
						break;
						
		default: System.out.println("no browser");
		}
		driver.manage().window().maximize();
		return driver;
	}
	
	
	public void launchSite(String url)
	{
		driver.get(url);		
	}
	
	public void closeSite()
	{
		driver.quit();
	}
}
