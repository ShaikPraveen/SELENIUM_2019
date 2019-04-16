package com.handling.Calender;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

public class TC12_Handling_Calender {
	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "\\Drivers\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.get("https://www.redbus.in/");
		Assert.assertEquals(driver.getTitle(),
				"Online Bus Tickets Booking, Book Volvo AC Bus Tickets, Confirmed Bus Reservation -redBus");

		driver.findElement(By.xpath("//label[contains(text(),'Onward Date')]")).click();

		String expmonth = "Jun 2021";
		String day = "1";

		while (true) {
			String current_month = driver
					.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[2]")).getText();
			if (expmonth.equals(current_month)) {
				break;
			} else {
				driver.findElement(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr[1]/td[3]/button"))
						.click();
			}
		}

		List<WebElement> dates = driver.findElements(By.xpath("//*[@id='rb-calendar_onward_cal']/table/tbody/tr/td"));
		System.out.println(dates.size());

		for (WebElement ele : dates) {
			String datesnames = ele.getText();
			String arr[] = datesnames.split("\n");

			if (arr[0].equals(day)) {
				ele.click();
				System.out.println("SELECTED DATE IS  " + day + expmonth);
				break;
			}
		}

	}

}
