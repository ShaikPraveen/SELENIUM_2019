package com.hanling.HashMap;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC01_Handling_HashMap {
	public static void main(String[] args) throws IOException, InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.acegrades.com");
		Assert.assertEquals(driver.getTitle(), "ACEGRADES");

		driver.findElement(By.linkText("LOG IN")).click();

		String credentials = getData().get("A");
		String arr[] = credentials.split("&");

		driver.findElement(By.xpath("//input[@id='email']")).sendKeys(arr[0]);
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys(arr[1]);
		driver.findElement(By.xpath("//button[@id='loginId']")).sendKeys(Keys.ENTER);

		Thread.sleep(3000);
		//WebElement logo = driver.findElement(By.xpath("//img[@class='left logo']"));
		//Assert.assertTrue(logo.isDisplayed());
		
		//WebDriverWait wait=new WebDriverWait(driver, 30);
		//wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header[1]/div[1]/div[1]/a[1]/span[1]")));

		WebElement ele=driver.findElement(By.xpath("//header[1]/div[1]/div[1]/a[1]/span[1]"));
		clickElement(driver, ele);
		
		
		//driver.findElement(By.xpath("//header[1]/div[1]/div[1]/a[1]/span[1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//*[@id='signout_Id']")).click();

		if (driver.findElement(By.xpath("//*[@id='gotofacebook_id']/strong")).isDisplayed()) {
			System.out.println("ELEMENT IS PRESENT : TEST PASS");

		} else {
			System.out.println("ELEMENT IS NOT PRESENT : TEST FAIL");
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\Screenshots\\acegrades.png"));
		}
	}

	public static HashMap<String, String> getData() {
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("A", "teacher@sample.com&123456");
		map.put("B", "teacher@sample.com&123456");

		return map;
	}
	
	public static void clickElement(WebDriver driver,WebElement ele)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();",ele);
	}

}
