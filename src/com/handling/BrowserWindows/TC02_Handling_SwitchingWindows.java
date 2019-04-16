package com.handling.BrowserWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_SwitchingWindows 
{
	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.andhrabank.in/english/home.aspx");
	    Assert.assertEquals(driver.getTitle(), "Andhra Bank | Home");
	    
	    String parentwindow=driver.getWindowHandle();
	    
	    driver.findElement(By.linkText("Apply Online")).click();
	    
	    Set<String> windows=driver.getWindowHandles();
	    for(String s:windows)
	    {
	    	driver.switchTo().window(s);
	    	String url=driver.getCurrentUrl();
	    	if (url.contains("/loan"))
	    	{
			     driver.findElement(By.xpath("//*[@id='spacerdiv']/table/tbody/tr[3]/td[2]/a/img")).click();
			     driver.close();
			     break;   
			}
	    }
	   
	    driver.switchTo().window(parentwindow);
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.andhrabank.in/english/home.aspx");
	    driver.quit();
	}

}
