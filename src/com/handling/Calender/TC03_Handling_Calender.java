package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_Calender 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("https://www.expedia.co.in/");
		Assert.assertEquals(driver.getTitle(), "Expedia Travel: Vacations, Cheap Flights, Airline Tickets & Airfares");
		
		driver.findElement(By.xpath("//input[@id='hotel-checkin-hp-hotel']")).click();
	   
		//String month_text=driver.findElement(By.xpath("//caption")).getText();
	    //System.out.println(month_text);
	    
	    String month="Jun 2019";
	    String day="1";
	    
	    while(true)
	    {
	    	String month_text=driver.findElement(By.xpath("//caption")).getText();
	    	
	    	if (month_text.equals(month))
	    	{
			   break;	
			} else 
			{
              driver.findElement(By.xpath("//*[@id='hotel-checkin-wrapper-hp-hotel']/div/div/button[2]")).click();
			}
	    }
		
	    List<WebElement> alldates=driver.findElements(By.xpath("//div[@class='datepicker-cal']//div[2]//table[1]//tbody[1]//tr//td//button[1]"));
		                  
	    for(WebElement ele : alldates)
	    { 
	    	 String datenumbers=ele.getText();
	    	 String dates[]=datenumbers.split("\n");
	    	 if (dates[1].equals(day))
	    	 {
			   ele.click();	
			   break;
			}	
	    }
	}

}
