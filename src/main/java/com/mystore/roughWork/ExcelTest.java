package com.mystore.roughWork;

import org.testng.annotations.Test;

public class ExcelTest {
	
	NewExcelLibrary eExcel = new NewExcelLibrary();
	
	@Test(priority=1)
	public void TC1()
	{
		int totalRows = eExcel.getRowCount("Employee");
		System.out.println(totalRows);
		
		int totalCol = eExcel.getColumnCount("Employee");
		System.out.println(totalCol);
		
		String Salary = eExcel.getCellData("Employee", "Salary", 4);
		System.out.println(Salary);
			
	}
	
	@Test(priority=2)
	public void calTotalSal()
	{	
		int totalRows = eExcel.getRowCount("Employee");
		int sum = 0;
		for (int i = 0; i < totalRows; i++)
		{	
			int sal = eExcel.getColumnCount("Employee");
			while(sal !=0 )
			{
				String salary = eExcel.getCellData("Employee", "Salary", i);
				sum = Integer.valueOf(salary) + sum;
				
			}
			
			System.out.println(sum);
			
		}
		
	}

}
