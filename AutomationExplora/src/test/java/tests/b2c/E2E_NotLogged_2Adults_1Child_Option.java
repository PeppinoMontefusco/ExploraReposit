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
		test=TestManager.startTest("E2E_04", "Booking Flow 2 adult 1 child - Create Option Not Logged", "E2E");
		startPage.startPage();
		Report.infoStep("Open page");
		
		HomePageAction.clickOnBookAJourney();
		Report.infoStep("Click on book a journey");
		SearchCruiseAction.clickOnDestination();
		Report.infoStep("Select one destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.infoStep("Click on Select and Close");
		SearchCruiseAction.clickOnGuest();
		Report.infoStep("Click on Guest");
		SearchCruiseAction.increaseChild();
		Report.infoStep("Set 1 child");
		SearchCruiseAction.clickSearchCruise();
		Report.infoStep("Click on Search Cruise");
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.infoStep("Click on Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.infoStep("Click on category cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.infoStep("Click on subcategory cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.infoStep("Adult 1 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.infoStep("Adult 1 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("Adult 1 - insert date of birth ");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.infoStep("Adult 1 - insert email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		//Guest Page Second Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.infoStep("Adult 2 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.infoStep("Adult 2 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("Adult 2 - insert date of birth ");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndCompile("First","testchild");
		Report.infoStep("Child 1 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationtre");
		Report.infoStep("Child 1 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01012015");
		Report.infoStep("Child 1 - insert date of birth ");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.infoStep("Click on confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("FREE");
		Report.infoStep("Click on option 72h");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click on first privacy checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click on second privacy checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.infoStep("Click on apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.infoStep("Close confirm popup");
		

		}

}
