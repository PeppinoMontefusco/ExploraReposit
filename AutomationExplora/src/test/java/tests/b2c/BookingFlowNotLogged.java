package tests.b2c;

import java.awt.AWTException;
import org.testng.annotations.Test;
import actions.b2c.LoginAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.WebWrapper;

public class BookingFlowNotLogged extends setupDriver{
	
	@Test
	public static void bookingFlowNotLogged() throws InterruptedException, AWTException {
		startPage.startPage();
		
		
		LoginAction.clickOnBookAJourney();
		SearchCruiseAction.clickOnDestination();
		SearchCruiseAction.clickOnSelectAndClose();
		SearchCruiseAction.clickSearchCruise();
		SearchCruiseAction.clickOnFirstBookButton();
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Select Cabin Category
		
		SearchCruiseAction.clickOnCategorySuiteButton();
		WebWrapper.waitForJavascript(30000, 2000);
	
		//Select Subcategory Cabin
		
		WebWrapper.flpClipSearchClick("width: 106.8px", "flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Guest Page First Pax Adult
		
		WebWrapper.findSpanCompile("First","Test");
		WebWrapper.findSpanCompile("Last","Automation");
		WebWrapper.findSpanCompile("Date", "01011990");
		WebWrapper.findSpanCompile("Email", "test@yopmail.com");
		WebWrapper.waitForJavascript(30000, 2000);
		WebWrapper.flpClipSearchClick("height: 48px", "flt-clip");
		
		//Guest Page Second Pax Adult
		
	    WebWrapper.flpClipSearchClick("height: 48px", "flt-clip");
		WebWrapper.findSpanCompile("First","test");
		WebWrapper.findSpanCompile("Last","Automationdue");
		WebWrapper.findSpanCompile("Date", "01011990");
		WebWrapper.flpClipSearchClick("height: 48px", "flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Confirm Button
		
		WebWrapper.flpClipSearchClickNotClickable("width: 111.8px","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Create Option
		
		WebWrapper.findSpanClick("FREE");	
		WebWrapper.clickOnCheckBox("25", "svg");
		WebWrapper.clickOnCheckBox("25", "svg");
		WebWrapper.flpClipSearchClickNotClickable("rgb(10, 34, 64)","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Close Option Created Pop Up return in Summary
		
		WebWrapper.flpClipSearchClickNotClickable("width: 86.8px","flt-clip");

		}
	}
