package com.handling.DropDowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.Assert;

public class TC01_Handling_Dropdown {
	// This Script to select the Values from Drop down
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		driver.get("https://www.goibibo.com/");
		Assert.assertEquals(driver.getTitle(), "Online flight booking, Hotels, Bus &amp; Holiday Packages at Goibibo");

		Select sele = new Select(driver.findElement(By.xpath("//select[@id='gi_class']")));
		sele.selectByIndex(1);
		Thread.sleep(2000);
		sele.selectByVisibleText("First class");
		Thread.sleep(2000);
		// sele.selectByValue("2");
		sele.selectByVisibleText("Premium Economy");

		driver.close();
	}
}
