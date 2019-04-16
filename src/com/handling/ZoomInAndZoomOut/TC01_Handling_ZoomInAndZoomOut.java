package com.handling.ZoomInAndZoomOut;



import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_ZoomInAndZoomOut 
{
	public static void main(String[] args) {
		  System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  
		  driver.get("https://www.acegrades.com/");
		  Assert.assertEquals(driver.getTitle(), "ACEGRADES");
		  
		try{
			
			for(int i=0;i<5;i++)
			{
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.ADD);
			}
			
			Thread.sleep(3000);
			
			for(int i=0;i<5;i++)
			{
				driver.findElement(By.cssSelector("body")).sendKeys(Keys.CONTROL,Keys.SUBTRACT);
			}
			
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}  
		  
		 
	}

}
