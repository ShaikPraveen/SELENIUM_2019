package com.handling.RobotClass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;

public class TC01_Handling_RobotClass 
{
	public static void main(String[] args) throws AWTException {
		
		/*System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://spreadsheetpage.com/index.php/site/file/yearly_calender_workbook");
		Assert.assertEquals(driver.getTitle(), "Excel Downloads From John Walkenbach");
		driver.findElement(By.xpath("//a[contains(text(),'xllightbox.xls')]")).click();*/
		
		
		System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\Drivers\\geckodriver.exe");
		WebDriver driver=new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		
		driver.get("http://spreadsheetpage.com/index.php/site/file/yearly_calender_workbook");
		Assert.assertEquals(driver.getTitle(), "Excel Downloads From John Walkenbach");
		driver.findElement(By.xpath("//a[contains(text(),'xllightbox.xls')]")).click();
		
		Robot rb=new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		
		/*rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);
		rb.keyPress(KeyEvent.VK_TAB);*/
		
		rb.keyPress(KeyEvent.VK_ENTER);
	
	}

}
