package com.handling.BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC0_Handling_BootstrapDropDown 
{
	
	public static void main(String[] args)
	{   WebDriver driver;
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		//driver=new ChromeDriver();
		driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("http://www.softmindinformatics.com/");
		Assert.assertEquals(driver.getTitle(), "Softmind informatics Pvt Ltd");
		
		driver.findElement(By.linkText("Services")).click();
		
		List<WebElement> service_content=driver.findElements(By.xpath("//*[@id='bs-example-navbar-collapse-1']/ul/li[3]/ul/li/a"));
		System.out.println(service_content.size());
		
		for (int i = 0; i < service_content.size(); i++)
		{
			//System.out.println(service_content.get(i).getText());
			
			WebElement ele=service_content.get(i);
			      String innerhtml=   ele.getAttribute("innerHTML");
			      
			      if (innerhtml.contentEquals("Digital Marketing"))
			      {
					  ele.click();
					  break;
				}
		}
		Assert.assertEquals(driver.getCurrentUrl(), "http://www.softmindinformatics.com/Digital-Marketing.html");
		driver.close();
	}

}
