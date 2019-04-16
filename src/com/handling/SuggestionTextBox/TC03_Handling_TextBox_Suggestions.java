package com.handling.SuggestionTextBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;



public class TC03_Handling_TextBox_Suggestions 
{
	public static void main(String[] args)
	{
		ChromeOptions options=new ChromeOptions();
		options.setPageLoadStrategy(PageLoadStrategy.NONE);
		
		
	 	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50,TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    
	    driver.get("https://tsrtconline.in/oprs-web/");
	    Assert.assertEquals(driver.getTitle(), "TSRTC Official Website for Online Bus Ticket Booking - tsrtconline.in");
	   
	    
	     driver.findElement(By.xpath("//input[@name='fromPlaceName']")).clear();
	     driver.findElement(By.xpath("//input[@name='fromPlaceName']")).sendKeys("sri");
	     driver.findElement(By.xpath("//input[@name='fromPlaceName']")).click();
	     
	     List<WebElement> allcities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li"));
	     System.out.println("NUMBER OF CITIES ARE "+allcities.size());
	     
	     String actcity,expcity;
	     expcity="srikakulam";   
	     boolean cityexist=false;
	     
	     for(int i=0; i<allcities.size();i++)
	     {
	    	 actcity=allcities.get(i).getText();
	    	 if (actcity.toUpperCase().contains(expcity.toUpperCase())) 
	    	 {
	    		 cityexist=true;
	    		 break;
			} 
	     }
	     
	     if (cityexist)
	     {
		      System.out.println("EXPECTED CITY "+ expcity +" IS PRESENT  :: TEST PASS");	
		} else 
		{
			 System.out.println("EXPECTED CITY "+ expcity +" IS NOT PRESENT :: TEST FAIL");   
		}
	   
	     WebElement logo=driver.findElement(By.xpath("//*[@id='header']/div/div[1]"));
	     Assert.assertTrue(logo.isDisplayed());
	     
	     driver.close();
	}
}
