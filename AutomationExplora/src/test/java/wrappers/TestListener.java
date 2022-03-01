package wrappers;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.Status;

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
	    }

	    @Override
	    public void onTestSkipped(ITestResult iTestResult) {

	    }

	    @Override
	    public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
	    }


	}


