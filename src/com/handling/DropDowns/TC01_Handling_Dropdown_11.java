package com.handling.DropDowns;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class TC01_Handling_Dropdown_11 {
	// SELECT VALUE FROM DROP DOWN
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.justrechargeit.com/");
		Assert.assertEquals(driver.getTitle(),
				"Online Mobile Recharge|Online Prepaid Mobile,DTH Recharge & Top Up for Airtel,Idea,Vodafone,Aircel,Tata Indicom,DOCOMO,Dish TV,Tata Sky & Videocon D2H");

		WebElement signin_link = driver.findElement(By.xpath("//a[@title='Sign in']"));
		Assert.assertTrue(signin_link.isDisplayed(), "SIGN IN LINK IS NOT PRESENT ON HOME PAGE");

		String url = driver.getCurrentUrl();
		if (url.contains("justrechargeit")) {
			System.out.println("URL IS MATCHED : TEST PASS");
		} else {
			System.out.println("URL IS NOT MATCHED : TEST FAIL");
		}

		Select sele = new Select(driver.findElement(By.xpath("//select[@id='ddlMobileServiceProvider']")));
		sele.selectByIndex(1);
		Thread.sleep(2000);
		sele.selectByVisibleText("Telenor");
	}

}
