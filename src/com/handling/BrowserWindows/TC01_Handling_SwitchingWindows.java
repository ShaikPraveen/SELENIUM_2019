package com.handling.BrowserWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_SwitchingWindows 
{
	public static void main(String[] args)
	{
		        //IN FIREFOX
				//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe"");
				//WebDriver driver = new FirefoxDriver();
				
				//IN CHROME
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
				WebDriver driver = new ChromeDriver();
				
				driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
				driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
				
				driver.get("http://demo.automationtesting.in/Windows.html");
				Assert.assertEquals(driver.getTitle(), "Frames & windows");
		    
				driver.findElement(By.xpath("//a[@href='http://www.sakinalium.in']//button[@class='btn btn-info'][contains(text(),'click')]")).click();
				//System.out.println(driver.getTitle());
				
				Set<String> windowIds = driver.getWindowHandles();
				for(String t : windowIds)
				{
					String title = driver.switchTo().window(t).getTitle();
					System.out.println(title);
					if (title.contains("Frames & windows")) 
					{
						driver.close();	
					}
				}
				
			  //driver.quit();
	}

}
