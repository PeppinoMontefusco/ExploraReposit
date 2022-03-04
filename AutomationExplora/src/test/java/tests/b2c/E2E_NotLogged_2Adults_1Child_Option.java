package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import actions.b2c.HomePageAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_NotLogged_2Adults_1Child_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childOptionNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_04", "E2E Not Logged: Scenario 2 Adults 1 Child - Option Creation", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		
		HomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		SearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select and Close");
		SearchCruiseAction.clickOnGuest();
		Report.passStep("Click On Guest");
		SearchCruiseAction.increaseChild();
		Report.passStep("Set 1 Child");
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
		Report.passStep("Adult 1 - Insert First Name");
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
		Report.passStep("Adult 2 - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.passStep("Adult 2 - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Adult 2 - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.findSpanAndCompile("First","testchild");
		Report.passStep("Child 1 - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationtre");
		Report.passStep("Child 1 - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01012015");
		Report.passStep("Child 1 - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("FREE");
		Report.passStep("Click On Option 72h");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Close Confirm Pop Up");
		

		}

}
