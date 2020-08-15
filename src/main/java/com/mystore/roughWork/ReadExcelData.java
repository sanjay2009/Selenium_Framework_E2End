package com.mystore.roughWork;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class ReadExcelData {
	
	@Test
	public void ReadExcel() throws Exception
	{
		String excelPath = "F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\src\\test\\resources\\TestData\\TestData.xlsx";
		String fileName = "TestData";
		String sheetName = "Sheet1";
		
		// create object of File class to get excel file path
		File file = new File(excelPath);
		// to read excel file we need FileInputStream class
		FileInputStream fis = new FileInputStream(file);
		
		//create an object of XSSFWorkbook class and send file as the parameter
		XSSFWorkbook wb = new XSSFWorkbook(fis);
		
		//using workbook getSheet() method, store value in sheet variable....mainly to read sheet in workbook
		XSSFSheet sheet =  wb.getSheet(sheetName);
		
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
