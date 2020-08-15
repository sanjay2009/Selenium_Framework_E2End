package com.mystore.roughWork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ExcelReader {
	
	XSSFWorkbook wb;
	XSSFSheet sheet;
	
	public ExcelReader() throws Exception
	{
		String excelPath = "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		File file = new File(excelPath);
		FileInputStream fis = new FileInputStream(file);
		wb = new XSSFWorkbook(fis);
				
	}
	
	public String readData(String sheetName, int row, int col)
	{
		sheet = wb.getSheet(sheetName);
		String data = sheet.getRow(row).getCell(col).getStringCellValue();
		return data;
		
	}
	
	public void ReadExcel() throws Exception
	{
		
		String fileName = "TestData";
		String sheetName = "Sheet1";
				
		int totalRowCount = sheet.getLastRowNum();
		System.out.println("Total Rows: "+totalRowCount);
		
		//String data = sheet.getRow(1).getCell(0).getStringCellValue();
		//System.out.println(data);
		
		for (int i = 1; i <= totalRowCount; i++)
		{
			Row row = sheet.getRow(i);
			for (int j = 0; j < row.getLastCellNum(); j++)
			{
				String colData = sheet.getRow(i).getCell(j).getStringCellValue();
				System.out.print(colData+"  ");
			}
			System.out.println();
		}
		
		wb.close();
	}

}
