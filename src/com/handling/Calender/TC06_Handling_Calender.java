package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;



public class TC06_Handling_Calender {
	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);

		driver.get("https://acegrades.com");
		driver.findElement(By.linkText("LOG IN")).click();

		driver.findElement(By.xpath("//input[@type='text']")).sendKeys("demo@teacher1120.com");
		driver.findElement(By.xpath("//input[@id='password']")).sendKeys("sample@123456");
		driver.findElement(By.xpath("//button[@id='loginId']")).sendKeys(Keys.RETURN);

		if (driver.findElement(By.xpath("//a[@class='dropdown-button add-class']")).isDisplayed()) {
			System.out.println("TEST PASS");
		} else {
			System.out.println("TEST FAIL");
		}

		String month = "January 2020";
		String day = "15";

		driver.findElement(By.xpath("//a[@id='cratenew_id']")).click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//input[@placeholder='Assignment due date']")).click();

		while (true) {
			String month_text = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

			if (month_text.equals(month)) {
				break;
			} else {
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
			}
		}
		List<WebElement> dates = driver
				.findElements(By.xpath("//*[@id='ui-datepicker-div']/div[2]/table/tbody/tr/td/a"));

		for (WebElement ele : dates) {
			String datenumbers = ele.getText();
			String date[] = datenumbers.split("\n");

			if (date[0].contains(day)) {
				ele.click();
				break;
			}
		}
	}
}
