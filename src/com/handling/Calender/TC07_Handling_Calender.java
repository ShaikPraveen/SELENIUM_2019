package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC07_Handling_Calender {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.ixigo.com/flights");
		Assert.assertEquals(driver.getTitle(), "ixigo - Cheap Flights, Compare & Book Cheap Flight Tickets, Online Flight Booking India");
		
		driver.findElement(By.xpath("//input[@placeholder='Depart']")).click();
		
		String month ="December 2019";
		String day="20";
		while(true)
		{
			String text=driver.findElement(By.xpath("//div[@class='rd-month-label']")).getText();
			
			if (text.equals(month)) 
			{
			   break;	
			} else 
			{
               driver.findElement(By.xpath("//button[@class='ixi-icon-arrow rd-next']")).click();
			}
		}
		
		List<WebElement> dates_months=driver.findElements(By.xpath("/html/body/div[2]/div[2]/div[1]/table/tbody/tr/td/div"));
		
		    for(WebElement ele : dates_months)
		    {
		    	String dates=ele.getText();
		    	String  date_numbers[] = dates.split("\n");
		    	
		    	if (date_numbers[0].contains(day)) 
		    	{
				 ele.click();
				 break;
				}
		    }
	}
}
