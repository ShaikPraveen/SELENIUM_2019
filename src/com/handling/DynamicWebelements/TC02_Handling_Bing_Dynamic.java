package com.handling.DynamicWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_Bing_Dynamic
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.bing.com/");
	    Assert.assertEquals(driver.getTitle(), "Bing");
	    
	    driver.findElement(By.xpath("//input[@id='sb_form_q']")).clear();
	    driver.findElement(By.xpath("//input[@id='sb_form_q']")).sendKeys("selenium");
	    
	    List<WebElement> elements=driver.findElements(By.xpath("//ul[@id='sa_ul']//li"));
	    System.out.println(elements.size());
	    
	    for (int i = 0; i <elements.size(); i++)
	    {
	    	System.out.println(elements.get(i).getText());
	    	
	    	
	    	if (elements.get(i).getText().contains("selenium interview questions")) 
	    	{
			    elements.get(i).click();
			    Assert.assertEquals(driver.getTitle(), "selenium interview questions - Bing");
			    break;
			}
		}
	    
	   String url= driver.getCurrentUrl();
	   
	   if (url.contains("com/search")) 
	   {
		  Assert.assertTrue(true);
	} else {
		Assert.assertTrue(false);
	}
	    
	    driver.close();
	}
}
