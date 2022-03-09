package tests.b2c;

import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import globalSetup.b2c.Configuration;
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
		test=TestManager.startTest("E2E_02", "E2E Not Logged: Scenario 2 Adults - Only Deposit Payment", "E2E");
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
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.passStep("Click On Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.passStep("Click On Cabin Category");
		WebWrapper.waitForJavascript(30000, 2000);
	    VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.passStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript(30000, 2000);
	    VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.passStep("First Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.passStep("First Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("First Adult - Insert Date Of Birth");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.passStep("First Adult - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.passStep("Second Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.passStep("Second Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Second Adult - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click On Confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.findSpanAndClick("PAY DEPOSIT");
		Report.passStep("Pay Deposit");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click On Apply");
		WebWrapper.waitForJavascript(30000, 2000);
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

