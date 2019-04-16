package com.handling.Excel_Operations;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TC04_WRITE_DATA 
{
	public static void main(String[] args) throws IOException {
		FileInputStream fis=new FileInputStream("E:\\Praveen_Automation\\TestData.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fis);
		XSSFSheet ws=wb.getSheet("Login_Data");
		XSSFRow row=ws.getRow(1);
		XSSFCell cell=row.createCell(2);
		cell.setCellValue("PASS");
		
		
		row=ws.getRow(2);
		cell=row.createCell(2);
		cell.setCellValue("FAIL");
		
		row=ws.getRow(3);
		cell=row.createCell(2);
		cell.setCellValue("PASS");
		
		row=ws.getRow(4);
		cell=row.createCell(2);
		cell.setCellValue("FAIL");
		
		row=ws.getRow(5);
		cell=row.createCell(2);
		cell.setCellValue("PASS");
		
		row=ws.getRow(6);
		cell=row.createCell(2);
		cell.setCellValue("FAIL");
		
		
		FileOutputStream fos=new FileOutputStream("E:\\Praveen_Automation\\TestData.xlsx");
		wb.write(fos);
		fis.close();
		fos.close();
		wb.close();
	}

}
