package tests.b2c.E2E_Not_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.b2c.API;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_13_NotLogged_2Adults_1Child_1Infant_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childOptionNotLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_13", "E2E Not Logged: Scenario 2 Adults 1 Child 1 Infant - Option Creation", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select and Close");
		AdobeSearchCruiseAction.clickOnGuest();
		Report.passStep("Click On Guest");
		AdobeSearchCruiseAction.increaseChild();
		Report.passStep("Set 1 Child");
		AdobeSearchCruiseAction.increaseInfant();
		Report.passStep("Set 1 Infant");
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
		ArrayList<String> datiAdult=VersonixMethodsB2C.addAdult(2);
		ArrayList<String> datiChild=VersonixMethodsB2C.addChild(1);
		ArrayList<String> datiInfant=VersonixMethodsB2C.addInfant(1);
		datiAdult.addAll(datiChild);
		datiAdult.addAll(datiInfant);
		System.out.println(datiAdult);
        VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.confirmPopup("FREE");
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Close Confirm Pop Up");
		
		String reservationInfo=VersonixMethodsB2C.getSummaryInformation("Booking");
		String invoiceInfo=VersonixMethodsB2C.getSummaryInformation("Invoice").replace(",","");
		String bookingNumber =reservationInfo.substring(10, 14);
		VersonixMethodsB2C.verifyValue(reservationInfo, API.getCabinNumber(bookingNumber), "Cabin number");
		VersonixMethodsB2C.verifyValue(reservationInfo, API.getStatusBooking(bookingNumber), "Status");
		VersonixMethodsB2C.verifyValue(invoiceInfo, API.getAmountBooking(bookingNumber, "80"), "Amount Total");
		VersonixMethodsB2C.verifyValue(invoiceInfo, API.getAmountBooking(bookingNumber, "70"), "Amount Due");
		VersonixMethodsB2C.compareArrayList(API.getAllPaxData(bookingNumber), datiAdult, "The checks of Passengers data");
		

		}

}