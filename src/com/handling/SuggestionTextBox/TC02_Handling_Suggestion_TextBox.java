package com.handling.SuggestionTextBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_Suggestion_TextBox
{
   public static void main(String[] args) {
	    System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://apsrtconline.in/oprs-web/");
		Assert.assertEquals(driver.getTitle(), "APSRTC Official Website for Online Bus Ticket Booking - APSRTConline.in");
		
		driver.findElement(By.xpath("//input[@name='source']")).clear();
		driver.findElement(By.xpath("//input[@name='source']")).sendKeys("ban");
		
		List<WebElement> cities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
		System.out.println(cities.size());
		
		String expcity,actcity;
		expcity="GUDIBANDA";
		boolean cityexist=true;
		
		for (int i = 0; i < cities.size(); i++)
		{
		    actcity=cities.get(i).getText();
		    if (actcity.contains(expcity))
		    {
			  cityexist=true;
			  break;
			}
		}
		
		if (cityexist)
		{
		   System.out.println("TEST PASS : EXPECTED CITY IS PRESENT "+expcity);	
		} else 
		{
           System.out.println("TEST FAIL : EXPECTED CITY IS NOT PRESENT "+expcity);
		}
		
		Assert.assertEquals(driver.getCurrentUrl(), "https://apsrtconline.in/oprs-web/");
		driver.close();
   }
}
