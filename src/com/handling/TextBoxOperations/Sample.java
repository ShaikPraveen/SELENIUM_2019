package com.handling.TextBoxOperations;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class Sample 
{
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("https://opensource-demo.orangehrmlive.com/");
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		driver.findElement(By.xpath("//input[@id='txtUsername']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@id='txtPassword']")).sendKeys("admin123");
		driver.findElement(By.xpath("//input[@name='Submit']")).click();
		Assert.assertEquals(driver.getTitle(), "OrangeHRM");
		
		WebElement ele=driver.findElement(By.xpath("//*[@id='branding']/a[1]/img"));
		Assert.assertTrue(ele.isDisplayed());
		
		String url=driver.getCurrentUrl();
		if (url.contains("index.php"))
        {
			System.out.println("TEST PASS");
        	Assert.assertTrue(true);
			
		} else
		{
			System.out.println("TEST FAIL");
			Assert.assertTrue(false);
		}
		
		
		String welecometext=driver.findElement(By.xpath("//a[@id='welcome']")).getText();
		if (welecometext.contains("Admin"))
		{
			System.out.println("TEST PASS");
        	Assert.assertTrue(true);
		} else 
		{
			System.out.println("TEST FAIL");
			File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir")+"\\Screenshots\\OrangeHRN.png"));
			Assert.assertTrue(false);
		}
		
		driver.findElement(By.xpath("//a[@id='welcome']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[contains(text(),'Logout')]")).click();
		
		if (driver.findElement(By.xpath("//input[@id='btnLogin']")).isDisplayed())
		{
			System.out.println("TEST PASS");
			
		} else 
		{
			System.out.println("TEST FAIL");
		}
		driver.close();
	}

}
