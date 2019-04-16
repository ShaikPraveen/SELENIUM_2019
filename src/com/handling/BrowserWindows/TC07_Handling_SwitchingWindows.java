package com.handling.BrowserWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC07_Handling_SwitchingWindows
{
	public static void main(String[] args) throws InterruptedException
	{  
		 ChromeOptions options=new ChromeOptions();
		 options.addArguments("--disable-notifications");
		 
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get("https://www.shine.com/");
		Assert.assertEquals(driver.getTitle(), "Jobs 2019 - Search Jobs in India, Latest Job Vacancies, Recruitment - Shine.com");
		
		driver.findElement(By.linkText("Browse Jobs")).click();
		Set<String> windows=driver.getWindowHandles();
		
		Iterator<String> it=windows.iterator();
		String parentwin=it.next();
		String childwind=it.next();
		while(it.hasNext())
		{
			it.next();
			driver.switchTo().window(it.next());
			driver.switchTo().window(childwind);
			driver.getTitle();
			System.out.println(driver.getTitle());
			
		}
		
		Thread.sleep(2000);
		driver.switchTo().window(parentwin);
		//   System.out.println(driver.getTitle());

		
		
		
		
		/*String parentwin=it.next();
		String childwind=it.next();
		String subchildwind=it.next();
		//String sub_sub_childwind=it.next();
		
		Thread.sleep(2000);
		
		driver.switchTo().window(childwind);
		Assert.assertEquals(driver.getTitle(), "Job Search India - Latest Career Jobs and Employment");
		System.out.println(driver.getTitle());
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("IT Jobs")).click();
		/*System.out.println(driver.getTitle());
		Assert.assertEquals(driver.getTitle(), "Apply for It - Software Industry Jobs - 33275 It - Software Industry Openings - Shine.com");
		driver.switchTo().window(subchildwind);
		
		Thread.sleep(3000);
		
		driver.findElement(By.linkText("Contact Us")).click();
		driver.switchTo().window(sub_sub_childwind);
		Assert.assertEquals(driver.getTitle(), "Shine.com - Contact Us");
		
		Thread.sleep(2000);
		driver.switchTo().window(parentwin);*/
		//driver.quit();
}

}
