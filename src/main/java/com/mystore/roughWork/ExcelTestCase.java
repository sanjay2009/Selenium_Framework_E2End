package com.mystore.roughWork;

import org.testng.annotations.Test;

public class ExcelTestCase {
	
	@Test
	public void readExcelTest() throws Exception
	{
		ExcelReader er = new ExcelReader();
		String value = er.readData("Sheet1", 5, 1);
		System.out.println(value);
	}

}
