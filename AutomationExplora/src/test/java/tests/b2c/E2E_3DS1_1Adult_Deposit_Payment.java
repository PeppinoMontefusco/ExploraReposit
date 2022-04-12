package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import actions.b2c.TouchXAdyenAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
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

public class E2E_3DS1_1Adult_Deposit_Payment extends setupDriver {
	
	@Test
	public static void bookingFlow1adult3DS1() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_10", "E2E 3DS1: Scenario 1 Adult - Deposit","E2E");
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
		AdobeSearchCruiseAction.decreaseAdult();
		Report.passStep("Set 1 Adult");
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
		String FirstName ="test"+ExternalFunction.getRandomString(5);
	    VersonixMethodsB2C.searchInputAndCompile("First",FirstName);
		Report.passStep("Adult 1 - Insert First Name");
		String LastName ="test"+ExternalFunction.getRandomString(5);
		VersonixMethodsB2C.searchInputAndCompile("Last",LastName);
		Report.passStep("Adult 1 - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011990");
		Report.passStep("Adult 1 - Insert Date Of Birth");
		String Email=FirstName+"@yopmail.com";
		VersonixMethodsB2C.searchInputAndCompile("Email", Email);
		Report.passStep("Adult 1 - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.findSpanAndClick("PAY TOTAL");
		Report.passStep("Click On Pay Total");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript();
		TouchXAdyenAction.setCardNumber(new Configuration().cardNumber3DS1());
		Report.passStep("Insert Card Number");
		TouchXAdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		TouchXAdyenAction.setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		TouchXAdyenAction.clickOnPayButton();
		Report.passStep("Click On Pay");
		WebWrapper.waitForJavascript();
		TouchXAdyenAction.setUsername3DS1(new Configuration().username3DS1());
		Report.passStep("Insert Username");
		TouchXAdyenAction.setPassword3DS1(new Configuration().password3DS1());
		Report.passStep("Insert Password");
		TouchXAdyenAction.clickOnSubmitButton3DS1();
		Report.passStep("Click On Submit");
		//driver.switchTo().defaultContent();
		//WebWrapper.waitForJavascript();
		//VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		//Report.passStep("Click On Confirmation Pop Up");

		}

}


