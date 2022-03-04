package tests.b2c;


import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import globalSetup.b2c.Configuration;
import actions.b2c.AdyenAction;
import actions.b2c.HomePageAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.ExtentManager;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_NotLogged_2Adults_Complete_Payment extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsCompletePaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_03", "E2E Not Logged: Scenario 2 Adults - Pay Total", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		
		HomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		SearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select and Close");
		SearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.passStep("Click On Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.passStep("Click On Cabin Category");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.passStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.passStep("Adult 1 - Insert First Name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.passStep("Adult 1 - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Adult 1 - Insert Date Of Birth");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.passStep("Adult 1 - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.passStep("Adult 2 - Insert First Name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.passStep("Adult 2 - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Adult 2 - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("PAY TOTAL");
		Report.passStep("Click On Pay Total");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		AdyenAction.setCardNumber(new Configuration().cardNumber());
		Report.passStep("Insert Card Number");
		AdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		AdyenAction.setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		AdyenAction.clickOnPayButton();
		Report.passStep("Click On Pay");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		Report.passStep("Click On Confirmation Pop Up");
		
		
	
		}
	}


