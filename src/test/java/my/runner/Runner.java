package my.runner;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import org.testng.asserts.SoftAssert;

import pages.HomePage;
import pages.SendSMSPage;
import utilities.TestUtility;

public class Runner {

	public Properties p;
	public RemoteWebDriver driver;
	public WebDriverWait w;
	public TestUtility tu;
	public HomePage hp;
	public FileInputStream fi;
	public SendSMSPage se;	
	
	
	
	@BeforeMethod
	public void method2()
	{
		try {
		String projectPath = System.getProperty("user.dir"); // get current project path
		fi = new FileInputStream(projectPath+"\\src\\test\\resources\\properties\\sms4IndiaProperties.properties");
		p=new Properties();
		p.load(fi);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		tu = new TestUtility();		
		
	}
	

	@Test(dataProvider="ExcelData", dataProviderClass=excel_reader.ExcelData.class)
	public void method1(String browser, String mobNumb, String mobCri, String pwd, String pwdCri, String result, String comments) 
	{
	
		SoftAssert sa = new SoftAssert();
		//open browser
		driver = tu.openBrowser(browser);
		hp=new HomePage(driver);
		se = new SendSMSPage(driver);
		tu.launchSite(p.getProperty("url"));
		driver.manage().timeouts().pageLoadTimeout(5, TimeUnit.SECONDS);
		w=new WebDriverWait(driver,100);
		hp.loginCredentials(mobNumb, pwd);	
		
		if(mobCri.equals("valid") && pwdCri.equals("valid"))
		{
			w.until(ExpectedConditions.elementToBeClickable(se.toMobile));
			if(se.display.isDisplayed())
			{
			se.clickLogout();
			w.until(ExpectedConditions.elementToBeClickable(hp.mobNum));	
			}
			else
			{
				Assert.fail(comments);
			}
		}
		else
		{
		w.until(ExpectedConditions.visibilityOf(hp.errorMsg));
			if(hp.errorMsg.isDisplayed())
			{
				sa.assertEquals(hp.errorMsg.getText(), result, comments);
				sa.assertAll();
			}else
			{
				Assert.fail(comments);
			}
		
		}
		
		
	  }
	
	
	@AfterMethod
	public void method6()
	{
		tu.closeSite();
	}
		

}
