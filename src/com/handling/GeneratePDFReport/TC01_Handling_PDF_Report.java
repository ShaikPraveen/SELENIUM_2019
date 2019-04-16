package com.handling.GeneratePDFReport;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class TC01_Handling_PDF_Report 
{
	public static void ITextPDF() throws DocumentException, FileNotFoundException
	{
		String file="E:\\Praveen_Automation\\PDF_Report";
	    Document doc=new Document();
	    PdfWriter.getInstance(doc, new FileOutputStream(file));
	    doc.open();
	    doc.add(new Paragraph("TEST CASE FAIL : 1"));
	    doc.add(new Paragraph("ERROR ID NOT FOUND"));
	    doc.close();
	} 
	
	public static void main(String[] args) throws DocumentException, FileNotFoundException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\Drivers\\chromedriver.exe");
		  WebDriver driver = new ChromeDriver();
		  driver.manage().window().maximize();
		  driver.manage().deleteAllCookies();
		  driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		  driver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		  
		  driver.get("https://acegrades.com/login.html");
		  Assert.assertEquals(driver.getTitle(), "Login");
		  
		  
		  try{
			  driver.findElement(By.id("email123456"));
			  
		  }
		  catch(Exception e)
		  {   ITextPDF();
			  System.out.println("ERROR FOUND IN BUTTON ID WRONG");
		  }
		 
	}

}
