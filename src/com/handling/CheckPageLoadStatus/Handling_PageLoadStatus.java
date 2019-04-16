package com.handling.CheckPageLoadStatus;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Handling_PageLoadStatus
{
	//https://www.skptricks.com/2018/09/how-to-wait-for-page-to-load-ready-in-selenium-webdriver.html
   
	 public static WebDriver driver;
	 public static JavascriptExecutor js;
	
	public static void main(String[] args)
    {
    	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.skptricks.com/");
		Assert.assertEquals(driver.getTitle(), "SKPTRICKS - Programmer Hub");
		
		//checkPageIsReady();
		pageReadyStatus();
		
		
		driver.findElement(By.linkText("SELENIUM")).click();
		
		
		String url=driver.getCurrentUrl();
		if (url.contains("/selenium.html")) 
		{
			Assert.assertTrue(true);
			
		} else
		{
            Assert.assertTrue(false);
		}
		
		driver.close();
	}
	
	
	 public static void checkPageIsReady() {

		  JavascriptExecutor js = (JavascriptExecutor) driver;

		  // Initially bellow given if condition will check ready state of page.
		  if (js.executeScript("return document.readyState").toString().equals("complete"))
		  {
		   System.out.println("Page Is loaded.");
		   return;
		  }

		  // This loop will iterate for 25 times to check If page Is ready after
		  // every 1 second.
		  // If the page loaded successfully, it will terminate the for loop
		  for (int i = 0; i < 25; i++) {
		   try {
		    Thread.sleep(1000);
		   } catch (InterruptedException e)
		   {
			   
		   }

		   // To check page ready state.
		   if (js.executeScript("return document.readyState").toString().equals("complete")) {
		    break;
		   }
		  }
		 } 
	 
	 
	   public static void pageReadyStatus()
	    {
		 JavascriptExecutor js = (JavascriptExecutor)driver;
		 js.executeScript("return document.readyState").toString().equals("complete");
	 }
	 
	 
}
