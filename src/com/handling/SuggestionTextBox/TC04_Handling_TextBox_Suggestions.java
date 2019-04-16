package com.handling.SuggestionTextBox;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC04_Handling_TextBox_Suggestions {
	public static void main(String[] args) throws IOException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.cleartrip.com/");
		Assert.assertEquals(driver.getTitle(),
				"#1 Site for Booking Flights, Hotels, Packages, Trains & Local activities.");

		String url = driver.getCurrentUrl();
		if (url.contains(".comm")) {
			System.out.println("URL IS MATCHED : TEST PASS");

		} else {
			System.out.println("URL IS NOT MATCHED : TEST FAIL");
			File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File(System.getProperty("user.dir") + "\\Screenshots\\cleartrip.png"));
		}

		driver.findElement(By.xpath("//input[@id='FromTag']")).clear();
		driver.findElement(By.xpath("//input[@id='FromTag']")).sendKeys("aus");
		driver.findElement(By.xpath("//input[@id='FromTag']")).click();

		List<WebElement> allcities = driver.findElements(By.xpath("/html[1]/body[1]/ul[1]/li"));
		System.out.println(allcities.size());

		String actcity, expcity;
		expcity = "Austin";
		boolean cityexist = false;

		for (int i = 0; i < allcities.size(); i++) {
			actcity = allcities.get(i).getText();
			if (actcity.contains(expcity)) {
				cityexist = true;
				break;

			}
		}

		if (cityexist) {
			System.out.println("EXPECTED CITY IS PRESENT : TEST PASS");

		} else {
			System.out.println("EXPECTED CITY IS NOT PRESENT : TEST FAIL");
		}

		WebElement logo = driver.findElement(By.xpath("//span[contains(text(),'Home')]"));
		Assert.assertTrue(logo.isDisplayed(), "LOGO IS NOT DISPALYED ON HOME PAGE");

		driver.close();
	}

}
