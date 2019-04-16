package com.handling.CorrespondingLinkNamesAndUrls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_CorrespondingLinkAndURLS
{

	public static void main(String[] args) throws InterruptedException 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
	
		List<WebElement> all_links=driver.findElements(By.tagName("a"));
		System.out.println(all_links.size());
		
		for (int i = 0; i <all_links.size(); i++) 
		{
		   String link_names=all_links.get(i).getText();
		   
		   all_links.get(i).click();
		   
		   Thread.sleep(2000);
		   
		  String pageurl= driver.getCurrentUrl();
		  System.out.println(link_names +"="+pageurl);
		  
		  driver.navigate().forward();
		  Thread.sleep(2000); 
		  driver.navigate().back();
		  Thread.sleep(2000); 
		  
		  all_links=driver.findElements(By.tagName("a"));
		}
	}
}
