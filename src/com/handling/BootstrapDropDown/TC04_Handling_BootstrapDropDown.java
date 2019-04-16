package com.handling.BootstrapDropDown;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC04_Handling_BootstrapDropDown {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("http://www.softmindinformatics.com/");
		Assert.assertEquals(driver.getTitle(), "Softmind informatics Pvt Ltd");

		driver.findElement(By.linkText("Services")).click();

		List<WebElement> allelements = driver
				.findElements(By.xpath("/html[1]/body[1]/div[2]/nav[1]/div[1]/div[2]/ul[1]/li[3]/ul[1]/li"));
		System.out.println(allelements.size());

		for (int i = 0; i < allelements.size(); i++) {
			System.out.println(allelements.get(i).getText());

			if (allelements.get(i).getText().contains("Digital Marketing")) {
				allelements.get(i).click();
				break;
			}
		}

		if (driver.getCurrentUrl().contains("Digital-Marketing.html")) {
			System.out.println("URL IS PRESENT, URL IS => " + driver.getCurrentUrl());
			Assert.assertTrue(true);
		} else {
			System.out.println("URL IS NOT PRESENT, URL IS => " + driver.getCurrentUrl());
			Assert.assertTrue(false);
		}
		driver.close();
	}
}
