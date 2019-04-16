package com.handling.VerifyLinkPresentOrNot;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_Verify_CityText 
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://www.goindigo.in/");
		Assert.assertEquals(driver.getTitle(), "Online Flight Booking for Domestic & International Destinations | IndiGo");
		
		List<WebElement> cities=driver.findElements(By.xpath("//div[9]/div/div/div/div/div/div/div/div/div/a"));
		System.out.println(cities.size());
		
		for(int i=0; i<cities.size();i++)
		{
			String citytext=cities.get(i).getText();
			System.out.println(citytext);
			
			if (citytext.contains("Amritsar"))
			{
			    Assert.assertTrue(true);	
			} else 
			{
                Assert.assertTrue(false);
			}
		}	
	}
}
