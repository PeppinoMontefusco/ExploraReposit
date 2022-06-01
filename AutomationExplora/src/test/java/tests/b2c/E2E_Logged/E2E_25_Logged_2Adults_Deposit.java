package tests.b2c.E2E_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.exceptions.UnirestException;

import globalSetup.API;
import globalSetup.Configuration;
import globalSetup.ExternalFunction;
import globalSetup.ReadResponse;
import actions.b2c.TouchXAdyenAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.ApachePoiMethods;
import wrappers.ExtentManager;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_25_Logged_2Adults_Deposit extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsDepositPaymentLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_25", "E2E Logged: Scenario 2 Adults - Only Deposit Payment", "E2E");
		ApachePoiMethods.writeCell("2 Ad - Deposit");
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
		Report.passStep("Click On Select And Close");
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
		ArrayList <String> datiPax=VersonixMethodsB2C.loggedPaxData();
	    ArrayList<String> dati=VersonixMethodsB2C.addAdult(1);
	    datiPax.addAll(dati);
		
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
		
		String bookingNumber=TestCasesVersonixMethods.checkCabinStatusAmount();
		ReadResponse response =API.getReadResponse(bookingNumber);
		VersonixMethodsB2C.verifyValue(response.getAmountBooking("80"), ExternalFunction.getSumOfStringValue(response.getAmountSinglePaymentsBooking(), 
				response.getAmountBooking("70")), "Payment Amount");
		VersonixMethodsB2C.compareArrayList(datiPax, response.getAllPaxData(), "The checks of Passengers data");
		ApachePoiMethods.writeBookingNumberInExcel(bookingNumber);
		
		
	
		}
	}

