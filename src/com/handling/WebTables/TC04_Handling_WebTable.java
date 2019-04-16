package com.handling.WebTables;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TC04_Handling_WebTable
{
	public static void main(String[] args)
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
		driver.get("file:///C:/Users/Manohar/Desktop/stu_table.html");
		
		//COUNT ROWS
		int rows=driver.findElements(By.xpath("/html/body/table/tbody/tr")).size();
		System.out.println("NUMBER OF ROWS ARE "+rows);
		
		//COUNT ROWS
	     int cols=driver.findElements(By.xpath("/html/body/table/tbody/tr[1]/th")).size();
	     System.out.println("NUMBER OF ROWS COLUMNS "+cols);
	     
	     //READ ENTIRE TABLE DATA
	     for(int row=2; row<=rows;row++)
	     {
	    	 for(int col=0; col<=cols;col++)
	    	 {
	    		 System.out.print(driver.findElement(By.xpath("/html/body/table/tbody[1]/tr["+row+"]/td["+col+"]")).getText()+"  ");
	    	 }
	    	 System.out.println();
	     }
				
		driver.close();		
	}

}
