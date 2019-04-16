package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC05_Handling_Calender 
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
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
	   
		driver.findElement(By.xpath("//*[@id='searchWidgetCommon']/div/div[3]/div[1]/div[1]/div/input")).click();
		
		//String month_text=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		//System.out.println(month_text);
		
		String month="July 2019";
		String day="1";
		
		while(true)
		{
			String month_text=driver.findElement(By.xpath("//div[@class='DayPicker-Caption']")).getText();
		     
			if (month_text.equals(month)) 
			{
			    break;	
			} else 
			{
              driver.findElement(By.xpath("//span[@class='DayPicker-NavButton DayPicker-NavButton--next']")).click();
			}
		}
		
		List<WebElement> alldates=driver.findElements(By.xpath("//div[contains(@class,'DayPicker DayPicker--en')]//div[3]//div[3]//div//div"));
		
		for(WebElement ele : alldates)
		{
			String datenumbers=ele.getText();
			String dates[]=datenumbers.split("\n");
			
			if (dates[0].equals(day)) 
			{
			     ele.click();
			     break;
			}
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://www.goibibo.com/");
		//driver.close();
	}

}
