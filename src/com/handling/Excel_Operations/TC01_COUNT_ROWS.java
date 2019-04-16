package com.handling.Excel_Operations;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC01_COUNT_ROWS 
{
	public static void main(String[] args) throws IOException 
	{
		//countRows("ABC", "Login_Data");
		
		
		FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Login_Data");
		int rc=ws.getLastRowNum();
		System.out.println("NUMBER OF ROWS ARE "+rc);
	}
	
	
	public static void countRows(String filepath, String filename) throws IOException
	{
		filepath="E:\\Praveen_Automation\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet(filename);
		int rc=ws.getLastRowNum();
		
		System.out.println("NUMBER OF ROWS ARE "+rc);
	}

}
