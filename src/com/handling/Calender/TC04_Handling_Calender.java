package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC04_Handling_Calender
{
	public static void main(String[] args) 
	{
		ChromeOptions options=new ChromeOptions();
		options.addArguments("--disable-notifications");
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.cleartrip.com/flights");
		Assert.assertEquals(driver.getTitle(), "Flight bookings, Cheap flights, Lowest Air tickets @Cleartrip");
	   
		driver.findElement(By.xpath("//dl[@class='vertical']//input[@placeholder='Pick a date']")).click();;
		
		//String month_text=driver.findElement(By.xpath("//div[@class='title']")).getText();
		//System.out.println(month_text);
		
		String month="June 2019";
		String day="1";
		
		while(true)
		{
			String month_text=driver.findElement(By.xpath("//div[@class='title']")).getText();
			
			if (month_text.equals(month))
			{
				break;
				
			} else 
			{
               driver.findElement(By.xpath("//div[@class='header']//a[@title='Next']")).click();
			}
		}
		
		List<WebElement> alldates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
	
	     for(WebElement ele : alldates)
	     {
	    	String datenumbers= ele.getText();
	    	String  dates[] = datenumbers.split("\n");
	    	
	    	if (dates[0].equals(day)) 
	    	{
			   ele.click();
			   break;
			}
	     }
	}
}
