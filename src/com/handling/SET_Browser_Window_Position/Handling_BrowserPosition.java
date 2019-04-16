package com.handling.SET_Browser_Window_Position;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_BrowserPosition 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.guru99.com/V4/index.php");
		
		Point p=new Point(100, 200);
		driver.manage().window().setPosition(p);
		
		 System.out.println("Window position X coordinates Is -> "+driver.manage().window().getPosition().getX());
		 System.out.println("Window position Y coordinates Is -> "+driver.manage().window().getPosition().getY());
		
	}
}
