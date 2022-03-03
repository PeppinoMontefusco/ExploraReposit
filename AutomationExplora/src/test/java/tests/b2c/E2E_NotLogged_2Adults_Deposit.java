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
public class E2E_NotLogged_2Adults_Deposit extends setupDriver{
	
	@Test
	public static void bookingFlow2adultsDepositPaymentNotLogged() throws InterruptedException, AWTException {
		test=TestManager.startTest("E2E_02", "E2E Not Logged: Scenario 2 Adults - Only Deposit Payment", "E2E");
		startPage.startPage();
		Report.infoStep("Open Homepage");
		
		HomePageAction.clickOnBookAJourney();
		Report.infoStep("Click On Book a Journey");
		SearchCruiseAction.clickOnDestination();
		Report.infoStep("Select One Destination");
		SearchCruiseAction.clickOnSelectAndClose();
		Report.infoStep("Click On Select And Close");
		SearchCruiseAction.clickSearchCruise();
		Report.infoStep("Click On Search Cruise");
		
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.searchTagAndClick("width: 102px", "flt-clip");
		Report.infoStep("Click On Book");
	    WebWrapper.waitForJavascript(30000, 2000);
		
	    VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111px","flt-clip");
	    Report.infoStep("Click On Cabin Category");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.searchTagAndClick("width: 106.8px", "flt-clip");
		Report.infoStep("Click On Cabin Subcategory");
		WebWrapper.waitForJavascript(30000, 2000);
	
		VersonixMethodsB2C.findSpanAndCompile("First","Test");
		Report.infoStep("First Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		Report.infoStep("First Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("First Adult - Insert Date Of Birth");
		VersonixMethodsB2C.findSpanAndCompile("Email", "test@yopmail.com");
		Report.infoStep("First Adult - Insert Email");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		VersonixMethodsB2C.findSpanAndCompile("First","test");
		Report.infoStep("Second Adult - Insert First Name");
		VersonixMethodsB2C.findSpanAndCompile("Last","Automationdue");
		Report.infoStep("Second Adult - Insert Last Name");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
		Report.infoStep("Second Adult - Insert Date Of Birth");
		VersonixMethodsB2C.searchTagAndClick("height: 48px", "flt-clip");
		Report.infoStep("Click On Continue");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 111.8px","flt-clip");
		Report.infoStep("Click On Confirm");
		WebWrapper.waitForJavascript(30000, 2000);
		
		VersonixMethodsB2C.findSpanAndClick("PAY DEPOSIT");
		Report.infoStep("Select Create Option 72h");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click On First Privacy Checkbox");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		Report.infoStep("Click On Second Privacy Checkbox");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		Report.infoStep("Click On Apply");
		WebWrapper.waitForJavascript(30000, 2000);
		
		AdyenAction.setCardNumber(new Configuration().cardNumber());
		Report.infoStep("Insert Card Number");
		AdyenAction.setExpiryDate(new Configuration().expireDate());
		Report.infoStep("Insert Expiry Date");
		AdyenAction.setCVV(new Configuration().cvv());
		Report.infoStep("Insert Cvv");
		AdyenAction.clickOnPayButton();
		Report.infoStep("Pay Deposit");
		Thread.sleep(3000);
		driver.switchTo().defaultContent();   
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		Report.infoStep("Click On Confirmation Pop Up");
		
		
	
		}
	}

