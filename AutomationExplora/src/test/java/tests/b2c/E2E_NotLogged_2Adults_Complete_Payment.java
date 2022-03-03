package tests.b2c;


import java.awt.AWTException;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;

import globalSetup.b2c.Configuration;
import actions.b2c.AdyenAction;
import actions.b2c.HomePageAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.ExtentManager;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class E2E_NotLogged_2Adults_Complete_Payment extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsCompletePaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_03", "Booking Flow 2 adult - Complete Payment Not Logged", "E2E");
		startPage.startPage();
		Report.passStep("Open page");
		
		HomePageAction.clickOnBookAJourney();
		Report.passStep("Click on book a journey");
		SearchCruiseAction.clickOnDestination();
		Report.passStep("Select one destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.passStep("Click on Select and Close");
		SearchCruiseAction.clickSearchCruise();
		Report.passStep("Click on Search Cruise");
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.passStep("Click on Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.passStep("Click on category cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.passStep("Click on subcategory cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.passStep("Adult 1 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.passStep("Adult 1 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Adult 1 - insert date of birth ");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.passStep("Adult 1 - insert email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		//Guest Page Second Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.passStep("Adult 2 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.passStep("Adult 2 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.passStep("Adult 2 - insert date of birth ");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.passStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.passStep("Click on confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("PAY TOTAL");
		Report.passStep("Click on pay total");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click on first privacy checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.passStep("Click on second privacy checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.passStep("Click on apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		AdyenAction.setCardNumber(new Configuration().cardNumber());
		Report.passStep("Insert card number");
		AdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.passStep("Insert expiry date");
		AdyenAction.setCVV(new Configuration().cvv());
		Report.passStep("Insert CVV");
		AdyenAction.clickOnPayButton();
		Report.passStep("Click on pay");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		Report.passStep("Click on confirmation popup");
		
		
	
		}
	}


