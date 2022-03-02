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
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

@Listeners(TestListener.class)
public class BookingFlowCompletePaymentNotLogged extends setupDriver{
	
	@Test
	public static void bookingFlowCompletePaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("Book_01", "Booking Flow Complete Payment Not Logged", "E2E");
		startPage.startPage();
		test.log(Status.INFO, "Open page"); 
		
		HomePageAction.clickOnBookAJourney();
		test.log(Status.INFO, "Click on book a journey");
		SearchCruiseAction.clickOnDestination(); 
		SearchCruiseAction.clickOnSelectAndClose();
		SearchCruiseAction.clickSearchCruise();
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
	    WebWrapper.waitForJavascript(30000, 2000);
		
		
		//Select Cabin Category
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
	
		//Select Subcategory Cabin
		
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Guest Page First Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		test.log(Status.INFO, "Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		test.log(Status.INFO, "Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		test.log(Status.INFO, "Insert Data");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		//Guest Page Second Pax Adult
		
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Confirm Button
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Create Option
		
		VersonixMethodsB2C.findSpanAndClick("PAY TOTAL");	
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Close Option Created Pop Up return in Summary
		AdyenAction.setCardNumber(new Configuration().cardNumber());
		AdyenAction.setExpiryDate(new Configuration().expireDate());
		AdyenAction.setCVV(new Configuration().cvv());
		AdyenAction.clickOnPayButton();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		
		
	
		}
	}


