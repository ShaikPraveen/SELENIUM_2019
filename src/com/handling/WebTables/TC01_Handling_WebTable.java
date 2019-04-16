package com.handling.WebTables;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class TC01_Handling_WebTable
{
	public static void main(String[] args) 
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://money.rediff.com/tools/forex");
		Assert.assertEquals(driver.getCurrentUrl(), "https://money.rediff.com/tools/forex");
		
		//Count Number of Rows in Table
		int rows=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[2]/table[1]/tbody[1]/tr")).size();
		System.out.println("NUMBER OF ROWS ARE "+rows);
		
		//Count Number of Columns in Table
		int cols=driver.findElements(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[2]/table[1]/thead[1]/tr[1]/th")).size();
		System.out.println("NUMBER OF COLUMNS ARE "+cols);
		
		//Read Entire Data From Table
		for (int row=2; row<=rows; row++)
		{
		     for (int col = 1; col<=cols; col++) 
		     {
			   System.out.print(driver.findElement(By.xpath("/html[1]/body[1]/div[1]/div[5]/div[2]/div[2]/table[1]/tbody[1]/tr["+row+"]/td["+col+"]")).getText()+"  ");	
			}
		     System.out.println();
		}
		
		
		Assert.assertEquals(driver.getTitle(), "Forex and Currency Converter : BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks");
		driver.close();	
	}
}
