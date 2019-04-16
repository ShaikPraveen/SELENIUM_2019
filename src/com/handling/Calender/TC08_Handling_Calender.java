package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class TC08_Handling_Calender 
{
	
	public static void clickByElementByJS(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", element);
	}
	
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
	
	     String month="June 2020";
	     String day="15";
		
	    while(true)
	    {
		String text=driver.findElement(By.xpath("//div[@class='title']")).getText();
		   
		   if (text.equals(month))
		   {
			   break;
		} else
		{
          driver.findElement(By.xpath("//div[contains(@class,'header')]//a[contains(@title,'Next')]")).click();
		}   
	    }
		
	    List<WebElement> alldates=driver.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[1]/table/tbody/tr/td"));
	    System.out.println("THE SIZE OF ALL DATES ARE "+alldates.size());
	    for(WebElement ele:alldates)
	    {
	    	String datemembers=ele.getText();
	    	String days[]=datemembers.split("\n");
	    	
	    	if (days[0].equals(day))
	    	{
	          System.out.println("SELECTED DATE IS => "+day+" "+month);
			  ele.click();
			  break;
			}
	    }
		
		driver.close();
	}

}
