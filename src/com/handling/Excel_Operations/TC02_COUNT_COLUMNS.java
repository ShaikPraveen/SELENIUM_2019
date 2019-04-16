package com.handling.Excel_Operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC02_COUNT_COLUMNS 
{
	public static void main(String[] args) throws IOException 
	{
		//countColumns("ABC", "Login_Data", 1);
		
		
		FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Login_Data");
		int rc=ws.getLastRowNum();
		
		XSSFRow row;
		
		   for (int i = 0; i <=rc; i++)
		   {
			   row=ws.getRow(i);
			   int cc=row.getLastCellNum();
			   System.out.println("NUMBER OF COLUMNS ARE "+cc);
		}
	}
	
	
	public static void countColumns(String filepath,String filename,int rownum) throws IOException
	{
		filepath="E:\\Praveen_Automation\\TestData.xlsx";
		FileInputStream fis=new FileInputStream(filepath);
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet(filename);
		XSSFRow row;
		int rc=ws.getLastRowNum();
		
		
		
		  for(int i=0; i<=rc;i++)
		  {
			  row=ws.getRow(rownum);
			  int cc=row.getLastCellNum();
			  System.out.println("NUMBER OF COLUMNS ARE "+cc);
		  }
		  
		  
	}

}
