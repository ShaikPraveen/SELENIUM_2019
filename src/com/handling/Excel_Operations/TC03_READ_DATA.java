package com.handling.Excel_Operations;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC03_READ_DATA
{
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Login_Data");
		int rc=ws.getLastRowNum();
		
		XSSFRow row;
		XSSFCell cell1,cell2;
		String username,password;
		
		     for(int i=0; i<=rc;i++)
		     {
		    	 row=ws.getRow(i);
		    	 cell1=row.getCell(0);
		    	 cell2=row.getCell(1);
		    	 
		    	 username=cell1.getStringCellValue();
		    	 password=cell2.getStringCellValue();
		    	 
		    	 System.out.println(username+" = "+password);
		    	 wb.close();
		    	 fis.close(); 
		     }	
	}

}
