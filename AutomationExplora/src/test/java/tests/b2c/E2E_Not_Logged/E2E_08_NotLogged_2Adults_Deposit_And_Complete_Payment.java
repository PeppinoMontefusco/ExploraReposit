package tests.b2c.E2E_Not_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.TouchXAdyenAction;
import globalSetup.API;
import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class E2E_08_NotLogged_2Adults_Deposit_And_Complete_Payment extends setupDriver {
	
	@Test
	public static void bookingFlow2adultsDepositAndCompletePaymentNotLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_08", "E2E Not Logged: Scenario 2 Adult - Deposit and Pay Total","E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndCloseDestination();
		Report.passStep("Click On Select and Close");
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
		ArrayList<String> dati=TestCasesVersonixMethods.addAdult(2);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("PAY DEPOSIT");
		TouchXAdyenAction.paymentNormalCard();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Click On Confirmation Pop Up");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("PAY TOTAL");
		TouchXAdyenAction.paymentNormalCard();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 86.8px","flt-clip");
		Report.passStep("Click On Confirmation Pop Up");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.clickOnLabel("Store");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.clickOnLabel("OK");
		WebWrapper.waitForJavascript();
		
		String bookingNumber=TestCasesVersonixMethods.checkCabinStatusAmount();
		WebWrapper.verifyValue(API.getAmountBooking(bookingNumber, "80"), API.getAmountMultiplePaymentsBooking(bookingNumber), "Payment Amount");
		WebWrapper.compareArrayList(dati, API.getAllPaxData(bookingNumber), "The checks of Passengers data");
		}


}
