package com.handling.BrowserWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC04_Handling_SwitchingWindows 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.timesjobs.com/");
	    Assert.assertEquals(driver.getTitle(), "Jobs Search | Recruitment | Employment | Job Vacancies | TimesJobs");
	    
	    String parentwindow=driver.getWindowHandle();
	    
	    driver.findElement(By.linkText("Accountant Jobs")).click();
	    
	    Set<String> windows=driver.getWindowHandles();
	    
	    for(String s:windows)
	    {
	        driver.switchTo().window(s);
	        String title=driver.getTitle();
	        
	        if (title.contains("Apply Accountant"))
	        {
			    driver.findElement(By.xpath("//img[@title='TimesJobs']")).click();
			    driver.close();
			    break;
			}
	    }
	   
	    driver.switchTo().window(parentwindow);
	    Assert.assertEquals(driver.getCurrentUrl(), "https://www.timesjobs.com/");
	    driver.quit();
	}

}
