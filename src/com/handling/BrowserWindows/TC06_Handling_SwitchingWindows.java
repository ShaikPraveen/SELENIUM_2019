package com.handling.BrowserWindows;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC06_Handling_SwitchingWindows {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://about.google/intl/en_GB/products/?modal_active=none");
		Assert.assertEquals(driver.getTitle(), "Our Products | Google");

		driver.findElement(By.linkText("Learn More")).click();

		Set<String> windowids = driver.getWindowHandles();

		Iterator<String> it = windowids.iterator();
		String parentWin = it.next();
		String childWin = it.next();
		//String grandChildWin = it.next();

		driver.switchTo().window(childWin);
		System.out.println(driver.getTitle());
		driver.close();

		//driver.switchTo().window(grandChildWin);
		//System.out.println(driver.getTitle());

		driver.switchTo().window(parentWin);
		System.out.println(driver.getTitle());
		driver.quit();
	}
}
