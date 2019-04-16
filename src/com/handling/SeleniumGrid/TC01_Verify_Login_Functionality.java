package com.handling.SeleniumGrid;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TC01_Verify_Login_Functionality 
{
	
	public WebDriver driver;
	public String url="http://practice.automationtesting.in/my-account/";
	
	@BeforeMethod
	public void setUP() throws MalformedURLException
	{
		String nodeurl="http://192.168.176.1:4444/wd/hub";
		DesiredCapabilities cap=DesiredCapabilities.chrome();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		
		//WebDriver driver=new ChromeDriver();
		 
	    driver=new RemoteWebDriver(new URL(nodeurl),cap);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);	
	}
	
	@Test
	public void verifyLoginTest()
	{
		driver.get(url);
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("info.praveen77@gmail.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Praveen@786");
		driver.findElement(By.xpath("//input[@value='Login']")).sendKeys(Keys.RETURN);
	
	    String text=driver.findElement(By.xpath("//div[@class='woocommerce-MyAccount-content']//p[1]")).getText();
	   
	    if (text.contains("praveen77"))
	    {
		      Assert.assertTrue(true);	
		} else 
		{
               Assert.assertTrue(false);
		}
	    
	    
	    driver.findElement(By.linkText("Sign out")).click(); 
	}
	
	
	/*@AfterMethod
	public void tearDown()
	{
		WebElement ele=driver.findElement(By.xpath("//img[contains(@title,'Automation Practice Site')]"));
		Assert.assertTrue(ele.isDisplayed());
	   driver.close();
	}*/

	
	@AfterMethod
	public void tearDown()
	{
		Assert.assertEquals(driver.getTitle(), "My Account – Automation Practice Site");
		driver.close();
	}
}
