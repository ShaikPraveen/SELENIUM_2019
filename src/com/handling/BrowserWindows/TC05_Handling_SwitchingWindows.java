package com.handling.BrowserWindows;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC05_Handling_SwitchingWindows 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
	    WebDriver driver=new ChromeDriver();
	    driver.manage().window().maximize();
	    driver.manage().deleteAllCookies();
	    driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
	    driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
	    
	    driver.get("https://www.shine.com/");
	    Assert.assertEquals(driver.getTitle(), "Jobs 2019 - Search Jobs in India, Latest Job Vacancies, Recruitment - Shine.com");
	    
	   String parentwindow = driver.getWindowHandle();
	   driver.findElement(By.partialLinkText("view all")).click();
	   
	   Set<String> windows=driver.getWindowHandles();
	   
	   for(String s : windows)
	   {
		   driver.switchTo().window(s);
		   String title=driver.getTitle();
		   
		   if (title.contains("Featured Companies and Consultants - Shine.com"))
		   {
			driver.findElement(By.xpath("//input[@placeholder='Email']")).sendKeys("test123@gmail.com");
			driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("test123");
			driver.findElement(By.xpath("//input[@id='id_cell_phone']")).sendKeys("9191919191");
			driver.findElement(By.xpath("//input[@id='id_common_register']")).click();
			
			String errormsg=driver.findElement(By.xpath("//div[@class='eac-input-wrap']//label[1]")).getText();
		    Assert.assertEquals(errormsg,"Email id already exists. Login Here.");
		    driver.close();
		    break;
		   }
	   }
	   
	        driver.switchTo().window(parentwindow);
	        WebElement homegegister=driver.findElement(By.xpath("//a[@class='cls_register_signin_homepage']"));
	        Assert.assertTrue(homegegister.isDisplayed(),"HOME REGISTER LINK NOT DISPLAYED");
	        driver.quit();
	        System.out.println("SUCCESS");
	}

}
