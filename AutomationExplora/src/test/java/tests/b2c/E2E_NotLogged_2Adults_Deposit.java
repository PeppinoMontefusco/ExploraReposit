package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import actions.b2c.TouchXAdyenAction;
import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.ExtentManager;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_NotLogged_2Adults_Deposit extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsDepositPaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_08", "E2E Not Logged: Scenario 2 Adults - Only Deposit Payment", "E2E");
		startPage.startPage();
		Report.passStep("Open Homepage");
		AdobeHomePageAction.clickOnBookAJourney();
		Report.passStep("Click On Book a Journey");
		AdobeSearchCruiseAction.clickOnDestination();
		Report.passStep("Select One Destination");
		AdobeSearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click On Select And Close");
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
		VersonixMethodsB2C.searchInputAndCompile("Date", "01011974");
		Report.passStep("Adult 1 - Insert Date Of Birth");
		String Email=FirstName+"@yopmail.com";
		VersonixMethodsB2C.searchInputAndCompile("Email", Email);
		Report.passStep("Adult 1 - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		String FirstNameAdult2 ="test"+ExternalFunction.getRandomString(5);
	    VersonixMethodsB2C.searchInputAndCompile("First",FirstNameAdult2);
		Report.passStep("Adult 2 - Insert First Name");
		String LastNameAdult2 ="test"+ExternalFunction.getRandomString(5);
		VersonixMethodsB2C.searchInputAndCompile("Last",LastNameAdult2);
		Report.passStep("Adult 2 - Insert Last Name");
		VersonixMethodsB2C.searchInputAndCompile("Date", "04061971");
		Report.passStep("Adult 2 - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript();
		VersonixMethodsB2C.findSpanAndClick("PAY DEPOSIT");
		Report.passStep("Pay Deposit");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript();
		TouchXAdyenAction.setCardNumber(new Configuration().cardNumber());
		Report.passStep("Insert Card Number");
		TouchXAdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert Expiry Date");
		TouchXAdyenAction.setCVV(new Configuration().cvv());
		Report.passStep("Insert Cvv");
		TouchXAdyenAction.clickOnPayButton();
		Report.passStep("Pay Deposit");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		Report.passStep("Click On Confirmation Pop Up");
		
		
	
		}
	}

