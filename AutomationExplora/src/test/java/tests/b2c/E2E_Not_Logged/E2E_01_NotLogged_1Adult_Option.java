package tests.b2c.E2E_Not_Logged;

import java.awt.AWTException;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.ArrayList;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
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


public class E2E_01_NotLogged_1Adult_Option extends setupDriver {
	
	@Test
	public static void bookingFlow1adultOptionNotLogged() throws InterruptedException, AWTException, UnirestException, IOException {
		test=TestManager.startTest("E2E_01", "E2E Not Logged: Scenario 1 Adult - Option Creation", "E2E");
		ApachePoiMethods.writeCell("1 Ad - Option");
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
		AdobeSearchCruiseAction.decreaseAdult();
		Report.passStep("Set 1 Adult");
		Thread.sleep(3000);
		AdobeSearchCruiseAction.clickSearchCruise();
		
		Report.passStep("Click On Search Cruise");
		WebWrapper.waitForJavascript();
		Thread.sleep(3000);
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
		ArrayList<String> dati=TestCasesVersonixMethods.addAdult(1);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		TestCasesVersonixMethods.confirmPopup("FREE");
		VersonixMethodsB2C.clickOnLabel("Close");
		Report.passStep("Close Confirm Pop Up");
		WebWrapper.waitForJavascript();
		String bookingNumber=TestCasesVersonixMethods.checkCabinStatusAmount();
		ReadResponse response =API.getReadResponse(bookingNumber);
	    WebWrapper.compareArrayList(dati, response.get1AdultData(), "The checks of Passengers data");
		ApachePoiMethods.writeBookingNumberInExcel(bookingNumber);
		}
	}
	

