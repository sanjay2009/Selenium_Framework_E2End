/**
 * 
 */
package com.mystore.dataprovider;

import org.testng.annotations.DataProvider;

import com.mystore.utility.NewExcelLibrary;

/**
 * @author Sanjay
 *
 */
public class DataProviders {
	
	NewExcelLibrary obj = new NewExcelLibrary();
	
	@DataProvider(name= "credentials")
	public Object[][] getCredentials()
	{
		int rows = obj.getRowCount("Sheet1");
		int cols = obj.getColumnCount("Sheet1");
		int actualRows = rows - 1;
		
		Object [][] data = new Object[actualRows][cols];
		for(int i = 0; i <= actualRows; i++)
		{
			for (int j = 0; j < cols; j++)
			{
				data[i][j] = obj.getCellData("Sheet1", j, i+2);
			}
			
		}
		
		return data;
	} 

}
