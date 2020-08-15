package com.mystore.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports eReport;
	public static ExtentTest eTest;
	
	
	public static void setExtent()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/Extent/myStoreReport.html");
		htmlReporter.loadXMLConfig("F:\\Selenium_projects\\9Aug2020\\MyStore\\MyStoreProject\\extent-config.xml");
		
//		htmlReporter.config().setDocumentTitle("Automation Report");
//		htmlReporter.config().setReportName("MyStore Application Test Report");
//		htmlReporter.config().setTheme(Theme.STANDARD);
		
		eReport = new ExtentReports();
		eReport.attachReporter(htmlReporter);
		eReport.setSystemInfo("Sanjay", "Test Lead");
		eReport.setSystemInfo("Team", "Testing");
		eReport.setSystemInfo("OS", "Win7.0");
		
	}
	
	
	
	
	public static void endReport()
	{
		eReport.flush();
	}
	
	
	
	
	

}
