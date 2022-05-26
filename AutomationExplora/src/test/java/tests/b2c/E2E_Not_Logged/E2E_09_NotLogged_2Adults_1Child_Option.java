package tests.b2c.E2E_Not_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_09_NotLogged_2Adults_1Child_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childOptionNotLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_09", "E2E Not Logged: Scenario 2 Adults 1 Child - Option Creation", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndCloseDestination();
		Report.passStep("Click On Select and Close");
		AdobeSearchCruiseAction.clickOnGuest();
		Report.passStep("Click On Guest");
		AdobeSearchCruiseAction.increaseChild();
		Report.passStep("Set 1 Child");
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.startVersonixPage();
		VersonixMethodsB2C.randomScroll();
		VersonixMethodsB2C.clickOnLabelRandom("Book");
		Report.passStep("Click On Book");
	    WebWrapper.waitForJavascript();
	    VersonixMethodsB2C.clickOnLabelRandom("Select");
	    Report.passStep("Click On Cabin Category");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.randomScroll();
		VersonixMethodsB2C.clickOnLabelRandom("Book");
	    Report.passStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript();
		ArrayList<String> datiAdult=TestCasesVersonixMethods.addAdult(2);
		ArrayList<String> datiChild=TestCasesVersonixMethods.addChild(1);
		datiAdult.addAll(datiChild);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("FREE");
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Close Confirm Pop Up");
		
		String bookingNumber=TestCasesVersonixMethods.checkCabinStatusAmount();
		WebWrapper.compareArrayList(API.getAllPaxData(bookingNumber), datiAdult, "The checks of Passengers data");
		

		}

}
