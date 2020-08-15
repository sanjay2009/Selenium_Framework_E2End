package com.mystore.utility;

import org.apache.log4j.Logger;

public class Log {
	
	//initialize log4j
	public static Logger log = Logger.getLogger(Log.class.getName());
	public static void startTestCase(String sTestCaseName)
	{
		log.info("#################"+" "+sTestCaseName+" "+"TEST STARTED #############################");
	}
	
	
	public static void endTestCase(String sTestCaseName)
	{
		log.info("#################"+" "+sTestCaseName +" "+"TEST ENDED ###############################");
	}
	
	
	//create methods, so that they cam be called.
	
	public static void warn(String message)
	{
		log.warn(message);
	}
	
	public static void info(String message)
	{
		log.info(message);
	}
	
	
	public static void error(String message)
	{
		log.error(message);
	}
	
	public static void fatal(String message)
	{
		log.fatal(message);
	}
	
}
