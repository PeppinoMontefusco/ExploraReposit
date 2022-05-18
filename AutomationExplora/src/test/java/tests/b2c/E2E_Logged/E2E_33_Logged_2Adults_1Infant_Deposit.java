package tests.b2c.E2E_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.TouchXAdyenAction;
import actions.b2c.TouchXLoginAction;
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
public class E2E_33_Logged_2Adults_1Infant_Deposit extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childDepositLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_33", "E2E Logged: Scenario 2 Adults 1 Infant - Pay Deposit","E2E");
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
		AdobeSearchCruiseAction.increaseInfant();
		Report.passStep("Set 1 Child");
		AdobeSearchCruiseAction.clickSearchCruise();
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.startVersonixPage();
		TouchXLoginAction.loginBaseTouchX();
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.passStep("Click On Book");
	    WebWrapper.waitForJavascript();
	    VersonixMethodsB2C.clickOnLabelRandom("Select");
	    Report.passStep("Click On Cabin Category");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.randomScroll();
		VersonixMethodsB2C.clickOnLabelRandom("Book");
	    Report.passStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		ArrayList<String> datiAdult=VersonixMethodsB2C.addAdult(1);
		ArrayList<String> datiInfant=VersonixMethodsB2C.addInfant(1);
		ArrayList <String> datiPax=VersonixMethodsB2C.loggedPaxData();
		datiPax.addAll(datiAdult);
		datiPax.addAll(datiInfant);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.confirmPopup("PAY DEPOSIT");
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
		VersonixMethodsB2C.compareArrayList(datiPax, API.getAllPaxData(bookingNumber), "The checks of Passengers data");
		}

}

