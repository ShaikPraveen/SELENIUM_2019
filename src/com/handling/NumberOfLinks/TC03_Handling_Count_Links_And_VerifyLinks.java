package com.handling.NumberOfLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;



public class TC03_Handling_Count_Links_And_VerifyLinks
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	    
	    driver.get("https://www.kapumatrimony.com/");
	    Assert.assertEquals(driver.getTitle(), "Kapu Matrimony - The No. 1 Matrimony Site for Kapus - KapuMatrimony.com");
	
	    List<WebElement> alllinks=driver.findElements(By.tagName("a"));
	    System.out.println(alllinks.size());
	    
	    for(int i=0; i<alllinks.size(); i++)
	    {
	    	System.out.println(alllinks.get(i).getText());
	    }
	    
	    WebElement logo=driver.findElement(By.xpath("//*[@id='domain_title']"));
	    Assert.assertTrue(logo.isDisplayed());
	    driver.close();
	}

}
