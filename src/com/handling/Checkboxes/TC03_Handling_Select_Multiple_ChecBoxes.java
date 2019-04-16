package com.handling.Checkboxes;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_Select_Multiple_ChecBoxes 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://testautomationpractice.blogspot.com/");
		Assert.assertEquals(driver.getTitle(), "Automation Testing Practice");
	
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@type='checkbox']"));
		System.out.println("NUMBER OF CHECK BOXES ARE "+checkboxes.size());
		
		for(WebElement ele : checkboxes)
		{
			ele.click();
		}
	}

}
