package tests.b2c.E2E_Logged;


import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.TouchXAdyenAction;
import globalSetup.API;
import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.ReadResponse;
import globalSetup.setupDriver;
import globalSetup.startPage;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeSearchCruiseAction;
import wrappers.ApachePoiMethods;
import wrappers.ExtentManager;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_26_Logged_2Adults_Complete_Payment extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsCompletePaymentLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_26", "E2E Logged: Scenario 2 Adults - Pay Total", "E2E");
		ApachePoiMethods.writeCell("2 Ad - Pay Total");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeLoginAction.loginBase();
		Report.passStep("Effettuo il login");
		WebWrapper.waitForJavascript();
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
		Thread.sleep(1500);
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		ArrayList <String> datiPax=TestCasesVersonixMethods.loggedPaxData();
		ArrayList<String> dati=TestCasesVersonixMethods.addAdult(1);
		datiPax.addAll(dati);
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
		ReadResponse response =API.getReadResponse(bookingNumber);

		WebWrapper.verifyValue(response.getAmountBooking("80"), response.getAmountSinglePaymentsBooking(), "Payment Amount");
		WebWrapper.compareArrayList(datiPax, response.getAllPaxData(), "The checks of Passengers data");
		ApachePoiMethods.writeBookingNumberInExcel(bookingNumber);
		
	
		}
	}


