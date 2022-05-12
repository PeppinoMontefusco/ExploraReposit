package tests.b2c.E2E_Not_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.TouchXAdyenAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.b2c.API;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_10_NotLogged_2Adults_1Child_Deposit extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childDepositNotLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_10", "E2E Not Logged: Scenario 2 Adults 1 Child - Pay Deposit","E2E");
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
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.startVersonixPage();
		VersonixMethodsB2C.randomScroll();
		VersonixMethodsB2C.clickOnLabelRandom("Book");
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
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.findSpanAndClick("PAY DEPOSIT");
		Report.passStep("Click Pay Deposit");
		Thread.sleep(500);
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		Thread.sleep(500);
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript();
		TouchXAdyenAction.paymentNormalCard();  
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Click On Confirmation Pop Up");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.clickOnLabel("Cancel");
		WebWrapper.waitForJavascript();
		
		
		String reservationInfo=VersonixMethodsB2C.getSummaryInformation("Booking");
		String invoiceInfo=VersonixMethodsB2C.getSummaryInformation("Invoice").replace(",","");
		String bookingNumber =reservationInfo.substring(10, 14);
		VersonixMethodsB2C.verifyValue(reservationInfo, API.getCabinNumber(bookingNumber), "Cabin number");
		VersonixMethodsB2C.verifyValue(reservationInfo, API.getStatusBooking(bookingNumber), "Status");
		VersonixMethodsB2C.verifyValue(invoiceInfo, API.getAmountBooking(bookingNumber, "80"), "Amount Total");
		VersonixMethodsB2C.verifyValue(invoiceInfo, API.getAmountBooking(bookingNumber, "70"), "Amount Due");
		VersonixMethodsB2C.verifyValue(API.getAmountBooking(bookingNumber, "80"), ExternalFunction.getSumOfStringValue(API.getAmountSinglePaymentsBooking(bookingNumber), 
				API.getAmountBooking(bookingNumber, "70")), "Payment Amount");

		}

}

