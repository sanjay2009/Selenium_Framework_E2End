package com.mystore.roughWork;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EmployeeExcel {
	
	XSSFWorkbook wb;
	XSSFSheet sh;
	
	public EmployeeExcel()
	{
		String excelPath = System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(excelPath);
			wb = new XSSFWorkbook(fis);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String readData(String sheetName, int row, int col)
	{
		sh = wb.getSheet(sheetName);
		String colData = sh.getRow(row).getCell(col).getStringCellValue();
		return colData;
	}

}
