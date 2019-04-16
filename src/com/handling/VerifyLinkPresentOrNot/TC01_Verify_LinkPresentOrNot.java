package com.handling.VerifyLinkPresentOrNot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Verify_LinkPresentOrNot 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("SIZE OF TOTAL LINKS ARE  "+links.size());
		
		String actlink,explink;
		explink="Payment Gateway Project";
		boolean linkexist=false;
		
		for (int i = 0; i < links.size(); i++)
		{
			actlink=links.get(i).getText();	
			if (actlink.contains(explink)) 
			{
				linkexist=true;
				break;
			}
		}
		
		if (linkexist)
		{
		    System.out.println("TEST PASS : EXPECTED LINK IS PRESENT => "+explink);	
		} else
		{
			System.out.println("TEST FAIL : EXPECTED LINK IS NOT PRESENT => "+explink);
		}
		
		driver.close();
		
	}

}
