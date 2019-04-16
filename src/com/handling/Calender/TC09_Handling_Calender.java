package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class TC09_Handling_Calender 
{

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.get("https://www.spicejet.com/");
	    Assert.assertEquals(driver.getTitle(), "SpiceJet - Flight Booking for Domestic and International, Cheap Air Tickets");
	    
	   driver.findElement(By.xpath("//input[@name='ctl00$mainContent$view_date1']")).click();
	  
	   String month="August 2019";
	   String day="15";
	   
	   while(true)
	   {
		   String current_month= driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();
		   System.out.println(current_month);
		   if (month.equals(current_month))
		   {
			break;
		} else 
		{
            driver.findElement(By.xpath(" //span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
		}
	   }
	   
	   List<WebElement> dates=driver.findElements(By.xpath("/html[1]/body[1]/div[2]/div[1]/table[1]/tbody[1]/tr/td"));
	   System.out.println(dates.size());
	   
	   for(WebElement ele:dates)
	   {
		   String datemembers=ele.getText();
		   String days[]= datemembers.split("\n");
		   
		   if (days[0].equals(day))
		   {
			ele.click();
			System.out.println("SELECTED DATE IS => "+ day +" "+month);
			break;
		}
		   
	   }
	  
       //driver.close();
	}
}
