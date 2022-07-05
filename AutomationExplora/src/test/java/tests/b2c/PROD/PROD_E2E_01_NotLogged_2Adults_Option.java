package tests.b2c.PROD;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageProd;
import wrappers.ApachePoiMethods;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;


@Listeners(TestListener.class)
public class PROD_E2E_01_NotLogged_2Adults_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsOptionNotLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_05", "E2E Not Logged: Scenario 2 Adults - Option Creation", "E2E");
		ApachePoiMethods.writeCell("2 Ad - Option");
		startPageProd.startPageProd();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDateOfTravelButton();
		Report.passStep("Click on Date of Travel");
		AdobeSearchCruiseAction.clickOnRamdomMonth();;
		Report.passStep("Click on Random Month 2024");
		AdobeSearchCruiseAction.clickOnSelectAndCloseDateOfTravel();;
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
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
	    WebWrapper.waitForJavascript();
		Thread.sleep(1500);
		ArrayList<String> dati=TestCasesVersonixMethods.addAdult(2);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("FREE");
		VersonixMethodsB2C.clickOnLabel("Close");
		Report.passStep("Close Confirm Option Pop Up");
		String reservationInfo=VersonixMethodsB2C.getSummaryInformation("Booking");
        String bookingNumber =reservationInfo.substring(10, 14);
        ApachePoiMethods.writeBookingNumberInExcel(bookingNumber);
		}
	}
