package com.handling.SuggestionTextBox;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC01_Handling_SuggestionTextBox
{
        public static void main(String[] args)
        {
        	ChromeOptions options = new ChromeOptions();
        	options.addArguments("--disable-notifications");
        	
        	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
    		WebDriver driver=new ChromeDriver(options);
    		driver.manage().window().maximize();
    		driver.manage().deleteAllCookies();
    		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
    		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    		
    		driver.get("https://www.cleartrip.com/flights");
    		Assert.assertEquals(driver.getTitle(), "Flight bookings, Cheap flights, Lowest Air tickets @Cleartrip");
    	
    		driver.findElement(By.id("FromTag")).clear();
    		driver.findElement(By.id("FromTag")).sendKeys("hyd");
    		driver.findElement(By.id("FromTag")).click();
    		
            List<WebElement> cities=driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li/a[1]"));
            System.out.println(cities.size());
            
            String actcity,expcity;
            expcity="Hyderabad";
            boolean cityexist=false;
            
    		for(int i=0;i<cities.size();i++)
    		{
    			System.out.println(cities.get(i).getText());
    			actcity=cities.get(i).getText();
    			if (actcity.contains(expcity))
    			{
					cityexist=true;
					break;	
				}
    		}
    		if (cityexist)
    		{
			   System.out.println("TEST PASS : CITY IS PESENT => "+expcity);	
			} else 
			{
				System.out.println("TEST FAIL : CITY IS NOT PESENT => "+expcity);
			}
    		driver.close();
		}
}
