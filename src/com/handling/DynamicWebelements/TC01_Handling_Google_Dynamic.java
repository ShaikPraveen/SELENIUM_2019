package com.handling.DynamicWebelements;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC01_Handling_Google_Dynamic 
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.google.com/");
	    Assert.assertEquals(driver.getTitle(), "Google");
	    
	    driver.findElement(By.xpath("//input[@title='Search']")).clear();
	    driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("java");
	    
	   List<WebElement> elements= driver.findElements(By.xpath("//ul[@role='listbox']//li/descendant::div[@class='sbl1']"));
	   System.out.println(elements.size());
	   
	   
	   for (int i = 0; i < elements.size(); i++) 
	   {
		   System.out.println(elements.get(i).getText());
		   
		   if (elements.get(i).getText().contains("javascript tutorial"))
		   {
			elements.get(i).click();
			Assert.assertEquals(driver.getTitle(), "javascript tutorial - Google Search");
			break;
		}
	}
	   
	   WebElement googleimage=driver.findElement(By.xpath("//img[@src='/images/branding/googlelogo/2x/googlelogo_color_92x30dp.png']"));
	   Assert.assertTrue(googleimage.isDisplayed(),"GOOGLE IMAGE IS NOT DISPLAED");
	   driver.close();
	}

}
