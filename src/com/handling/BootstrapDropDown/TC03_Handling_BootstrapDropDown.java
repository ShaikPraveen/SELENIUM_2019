package com.handling.BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC03_Handling_BootstrapDropDown 
{
	public static void main(String[] args) 
	{
		
			System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
			WebDriver driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			
			driver.get("http://www.winnowit.in/");
			Assert.assertEquals(driver.getTitle(), "Winnow It Services");
			
			driver.findElement(By.linkText("Services")).click();
			
			List<WebElement> serices_content=driver.findElements(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/ul/li/a"));
			System.out.println(serices_content.size());
			
			for (int i = 0; i < serices_content.size(); i++) {
				System.out.println(serices_content.get(i).getText());
				
				  WebElement ele=serices_content.get(i);
				  String innerhtml=ele.getAttribute("innerHTML");
				  if (innerhtml.contentEquals("ERP Implementation"))
				  {
					 ele.click();
					 Assert.assertEquals(driver.getCurrentUrl(), "http://www.winnowit.in/ERP-implementation.html");
				     break;
				  }
			}
			
			Assert.assertEquals(driver.getCurrentUrl(), "http://www.winnowit.in/ERP-implementation.html");
			driver.close();
	}

}
