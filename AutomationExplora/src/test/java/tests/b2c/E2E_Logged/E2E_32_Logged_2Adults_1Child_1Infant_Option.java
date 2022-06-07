package tests.b2c.E2E_Logged;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import actions.b2c.TouchXLoginAction;
import globalSetup.API;
import globalSetup.ExternalFunction;
import globalSetup.ReadResponse;
import globalSetup.setupDriver;
import globalSetup.startPage;
import wrappers.ApachePoiMethods;
import wrappers.Report;
import wrappers.TestCasesVersonixMethods;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_32_Logged_2Adults_1Child_1Infant_Option extends setupDriver{
	
	@Test
	public static void bookingFlow2adults1childOptionLogged() throws InterruptedException, AWTException, UnirestException {
		test=TestManager.startTest("E2E_32", "E2E Logged: Scenario 2 Adults 1 Child 1 Infant - Option Creation", "E2E");
		ApachePoiMethods.writeCell("2 Ad - 1 Cld - 1 Inf - Option");
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
		AdobeSearchCruiseAction.increaseInfant();
		Report.passStep("Set 1 Infant");
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
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
	    WebWrapper.waitForJavascript();
		Thread.sleep(1500);
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		ArrayList <String> datiPax=TestCasesVersonixMethods.loggedPaxData();
		ArrayList<String> datiAdult=TestCasesVersonixMethods.addAdult(1);
		ArrayList<String> datiChild=TestCasesVersonixMethods.addChild(1);
		ArrayList<String> datiInfant=TestCasesVersonixMethods.addInfant(1);
		datiPax.addAll(datiAdult);
		datiPax.addAll(datiChild);
		datiPax.addAll(datiInfant);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("FREE");
		VersonixMethodsB2C.clickOnLabel("Close");
		Report.passStep("Close Confirm Pop Up");
		
		String bookingNumber=TestCasesVersonixMethods.checkCabinStatusAmount();
		ReadResponse response =API.getReadResponse(bookingNumber);

		WebWrapper.compareArrayList(datiPax, response.getAllPaxData(), "The checks of Passengers data");
		ApachePoiMethods.writeBookingNumberInExcel(bookingNumber);
		

		}

}
