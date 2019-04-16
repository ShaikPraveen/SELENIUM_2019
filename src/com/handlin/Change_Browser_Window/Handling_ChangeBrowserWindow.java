package com.handlin.Change_Browser_Window;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Handling_ChangeBrowserWindow
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("http://demo.guru99.com/V4/index.php");
		
		Dimension d = new Dimension (300,300);
		driver.manage().window().setSize(d);;
		
		 System.out.println("Window Height Is -> "+driver.manage().window().getSize().getHeight());
		 System.out.println("Window Width Is -> "+driver.manage().window().getSize().getWidth());
		
	}
}
