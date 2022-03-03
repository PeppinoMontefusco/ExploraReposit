package tests.b2c;

import java.awt.AWTException;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.b2c.HomePageAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

public class E2E_NotLogged_2Adults_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsOptionNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_01", "E2E Not Logged: Scenario 2 Adults - Option Creation", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		
		HomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		SearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select And Close");
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
		Report.passStep("First Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.passStep("First Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("First Adult - Insert Date Of Birth");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.passStep("First Adult - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		//Guest Page Second Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.passStep("Second Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.passStep("Second Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Second Adult - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("FREE");
		Report.passStep("Select Create Option 72h");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Close Option Created Pop Up return in Summary
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Close Confirm Option Pop Up");
		

		}
	}
