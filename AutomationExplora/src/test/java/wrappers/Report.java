package wrappers;

import com.aventstack.extentreports.Status;

import globalSetup.setupDriver;

public class Report {
	
	
	public static void passStep(String info) {
		
		setupDriver.test.log(Status.PASS, info); 
	}
	
   public static void failStep(String info) {
		
		setupDriver.test.log(Status.FAIL, info); 
	}
   
   public static void infoStep(String info) {
		
		setupDriver.test.log(Status.INFO, info); 
	}

}
