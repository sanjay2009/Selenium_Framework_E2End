package com.mystore.roughWork;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

public class ListenerClasses extends ExtentManager implements ITestListener{

	@Override
	public void onTestStart(ITestResult result) {
		eTest = eReport.createTest(result.getName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		if(result.getStatus()==ITestResult.SUCCESS) 
		{
			  eTest.log(Status.PASS, "Pass Test case is: "+result.getName());
		}
		
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		if(result.getStatus()==ITestResult.FAILURE) 
		{
			  eTest.log(Status.FAIL, MarkupHelper.createLabel(result.getName() + " - Test Case Failed", ExtentColor.RED));
			  eTest.log(Status.FAIL, MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
		   
		   String pathString=ExtentReportBase.screenShot(ExtentReportBase.driver, result.getName());
		   try 
		   {
			eTest.addScreenCaptureFromPath(pathString);
		   } 
		   catch (IOException e) 
		   {
			// TODO Auto-generated catch block
			e.printStackTrace();
		   }
		}
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
			if(result.getStatus()==ITestResult.SKIP) 
			{
			  eTest.log(Status.SKIP, "Skipped Test case is: "+result.getName());
			}
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		
	}
	
	

}
