package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;


@Listeners(TestListener.class)
public class E2E_NotLogged_2Adults_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsOptionNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_01", "E2E Not Logged: Scenario 2 Adults - Option Creation", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select And Close");
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.startVersonixPage();
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.passStep("Click On Book");
	    WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.passStep("Click On Cabin Category");
		WebWrapper.waitForJavascript();
	    VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.passStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript();
	    VersonixMethodsB2C.searchInputAndCompile("First","Test");
		Report.passStep("First Adult - Insert First Name");
		VersonixMethodsB2C.searchInputAndCompile("Last","Automation");
		Report.passStep("First Adult - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011990");
		Report.passStep("First Adult - Insert Date Of Birth");
		VersonixMethodsB2C.searchInputAndCompile("Email", "test@yopmail.com");
		Report.passStep("First Adult - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchInputAndCompile("First","test");
		Report.passStep("Second Adult - Insert First Name");
		VersonixMethodsB2C.searchInputAndCompile("Last","Automationdue");
		Report.passStep("Second Adult - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011990");
		Report.passStep("Second Adult - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.findSpanAndClick("FREE");
		Report.passStep("Select Create Option 72h");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Close Confirm Option Pop Up");
		

		}
	}
