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
public class E2E_2AdultsCompletePaymentNotLogged extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsCompletePaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_03", "Booking Flow 2 adult - Complete Payment Not Logged", "E2E");
		startPage.startPage();
		Report.infoStep("Open page");
		
		HomePageAction.clickOnBookAJourney();
		Report.infoStep("Click on book a journey");
		SearchCruiseAction.clickOnDestination();
		Report.infoStep("Select one destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.infoStep("Click on Select and Close");
		SearchCruiseAction.clickSearchCruise();
		Report.infoStep("Click on Search Cruise");
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.infoStep("Click on Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.infoStep("Click on category cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.infoStep("Click on subcategory cabin");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.infoStep("Adult 1 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.infoStep("Adult 1 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("Adult 1 - insert date of birth ");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.infoStep("Adult 1 - insert email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		//Guest Page Second Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.infoStep("Adult 2 - insert first name ");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.infoStep("Adult 2 - insert last name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("Adult 2 - insert date of birth ");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click on continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.infoStep("Click on confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("PAY TOTAL");
		Report.infoStep("Click on pay total");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click on first privacy checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click on second privacy checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.infoStep("Click on apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		AdyenAction.setCardNumber(new Configuration().cardNumber());
		Report.infoStep("Insert card number");
		AdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.infoStep("Insert expiry date");
		AdyenAction.setCVV(new Configuration().cvv());
		Report.infoStep("Insert CVV");
		AdyenAction.clickOnPayButton();
		Report.infoStep("Click on pay");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		Report.infoStep("Click on confirmation popup");
		
		
	
		}
	}


