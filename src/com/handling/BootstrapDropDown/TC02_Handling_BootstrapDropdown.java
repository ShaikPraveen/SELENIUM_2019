package com.handling.BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.print.DocFlavor.STRING;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC02_Handling_BootstrapDropdown 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://demo.guru99.com/v4/");
		Assert.assertEquals(driver.getTitle(), "Guru99 Bank Home Page");
		
		driver.findElement(By.linkText("Bank Project")).click();
		List<WebElement> banking_content=driver.findElements(By.xpath("//*[@id='navbar-brand-centered']/ul/li[5]/ul/li/a"));
	    System.out.println(banking_content.size());
	    
	    for (int i = 0; i < banking_content.size(); i++)
	    {
	    	String banking_content_names=banking_content.get(i).getText();
	    	System.out.println(banking_content_names);
	    	
	    	WebElement ele=banking_content.get(i);
	    	String innerhtml=ele.getAttribute("innerHTML");
	    	
	    	if (innerhtml.contentEquals("Bank Project V2"))
	    	{
			    ele.click();
			    break;
			}	
		}
	    
	    Assert.assertEquals(driver.getCurrentUrl(), "http://demo.guru99.com/V2/index.php");
	    driver.close();    
	}
}
