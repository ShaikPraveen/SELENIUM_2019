package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC10_Handling_Calender
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver(options);
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    driver.get("https://www.cleartrip.com/");
	    Assert.assertEquals(driver.getTitle(), "#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");
	    
	    driver.findElement(By.xpath("//input[@id='DepartDate']")).click();
	    
	    String expmonth="December 2019";
	    String day="31";
	    
	    while(true)
	    {
	    	
	      String current_month= driver.findElement(By.xpath("//div[@class='title']")).getText();
	      //System.out.println("CURRENT MONTH AND YEAR IS "+current_month);
	      
	      if (expmonth.equals(current_month)) 
	      {
	    	  break;
			
		} else 
		{
			driver.findElement(By.xpath("//div[@class='header']//a[@title='Next']")).click();
		} 
	    }
	    
	   List<WebElement> alldates= driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[1]/table[1]/tbody[1]/tr/td"));
	   System.out.println(alldates.size());
	   
	   for(WebElement ele : alldates)
	   {
		   String datenames=ele.getText();
		   String arr[]=datenames.split("\n");
		   
		   if (arr[0].equals(day)) 
		   {
			   ele.click();
			   System.out.println("SELECTED DATE IS  "+day +expmonth);
			   break;	
		}
				   
	   }
	   
	}

}
