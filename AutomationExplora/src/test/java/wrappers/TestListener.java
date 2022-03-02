package wrappers;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import globalSetup.b2c.setupDriver;

public class TestListener implements ITestListener {



	    @Override
	    public void onStart(ITestContext iTestContext) {
	    	

	    }

	    @Override
	    public void onFinish(ITestContext iTestContext) {
	    	TestManager.endTest();
	        ExtentManager.getReporter().flush();

	    }

	    @Override
	    public void onTestStart(ITestResult iTestResult) {

	    }

	    @Override
	    public void onTestSuccess(ITestResult iTestResult) {

	    }

	    @Override
	    public void onTestFailure(ITestResult iTestResult) {
	    	setupDriver.test.log(Status.FAIL, iTestResult.getThrowable().getMessage());
	    	try {
	    		//setupDriver.test.log(Status.FAIL, "Snapshot below: " + setupDriver.test.addScreenCaptureFromPath(GetScreenShot.capture(setupDriver.driver, "TestFailed")));
	    		
	    		setupDriver.test.addScreenCaptureFromPath(GetScreenShot.capture(setupDriver.driver, "TestFailed"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	 /*if(iTestResult.getStatus() == ITestResult.FAILURE)
	            {
	    		 String screenShotPath = null;
					try {
						
						screenShotPath = GetScreenShot.capture(setupDriver.driver, "screenShotName");
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
	                setupDriver.test.log(Status.FAIL, iTestResult.getThrowable());
	                setupDriver.test.log(Status.FAIL, "Snapshot below: " + setupDriver.test.addScreenCaptureFromPath(screenShotPath));
	            }
	            //ExtentManager.extent.endTest(setupDriver.test);*/
	        }
	         
	    	
	    	
	    

	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {

	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	    }


	}


