package com.handling.WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC02_Handling_WebTable 
{
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("file:///C:/Users/Manohar/Desktop/New%20folder/Creating_EmpTable1.html");
	    
		//Count Rows 
		
		int rows = driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println("NUMBER OF ROWS ARE "+rows);
		
		//Count Columns
		int cols=driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
		System.out.println("NUMBER OF COLUMNS ARE "+cols);
	
		    //Read Entire Table Data
		    for(int row=2; row<=rows; row++)
		    {
		    	for (int col=1; col<=cols; col++) 
		    	{
					
		    System.out.print(driver.findElement(By.xpath("/html/body/table/tbody/tr["+row+"]/td["+col+"]")).getText()+"  ");
				}
		    	System.out.println();
		    }
		    
		 
		    System.out.println("===============");
		    
		    
		//Read Particular Value in a Table    
		String value=driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]")).getText();
		System.out.println(value);    
		    
		
		driver.close();
	}

}
