package com.handling.DropDowns;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC02_Handling_Dropdown 
{
	//This script to Print all values and selct the appropriate value from Drop down
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");
    
		Select sele=new Select(driver.findElement(By.xpath("//select[@id='gi_class']")));
		List<WebElement> dropdownvalues=sele.getOptions();
		System.out.println("NUMBER OF VALUES ARE "+dropdownvalues.size());
		
		for(int i=0; i<dropdownvalues.size();i++)
		{
			String names=dropdownvalues.get(i).getText();
			System.out.println(names);
			
			if (dropdownvalues.get(i).getText().contains("First class"))
			{
				dropdownvalues.get(i).click();
				break;
			} 
		}
		driver.close();
	}
}
