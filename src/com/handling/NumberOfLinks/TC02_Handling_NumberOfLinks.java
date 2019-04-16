package com.handling.NumberOfLinks;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC02_Handling_NumberOfLinks
{
	public static void main(String[] args) 
	{
		        //IN FIREFOX
				System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
				WebDriver driver = new FirefoxDriver();
				
				//IN CHROME
				//System.setProperty("webdriver.chrome.driver", "E:\\Praveen_Automation\\Browser_Drivers\\chromedriver.exe");
				//WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				
				driver.get("https://www.acegrades.com/");
				Assert.assertEquals(driver.getTitle(), "ACEGRADES");
				
			    List<WebElement> alllinks = driver.findElements(By.tagName("a"));
			    System.out.println(alllinks.size());
			    
			    //1.USING ENHANCED FOR LOOP
			    /*for(WebElement links : alllinks)
			    {
			    	String linknames = links.getText();
			    	System.out.println(linknames);
			    }*/
			    
			    //2.USING NORMAL FOR LOOP
			    for (int i = 0; i < alllinks.size(); i++) 
			    {
			    	System.out.println(alllinks.get(i).getText());
					
				}
			    driver.close();
	}

}
