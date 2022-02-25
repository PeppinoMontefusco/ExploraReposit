package tests.b2c;

import java.awt.AWTException;
import org.testng.annotations.Test;

import actions.b2c.AdyenAction;
import actions.b2c.HomePageAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;

public class BookingFlowDepositNotLogged extends setupDriver{
	
	@Test
	public static void bookingFlowDepositNotLogged() throws InterruptedException, AWTException {
		startPage.startPage();
		
		
		HomePageAction.clickOnBookAJourney();
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
		VersonixMethodsB2C.findSpanAndCompile("Last","Automation");
		VersonixMethodsB2C.findSpanAndCompile("Date", "01011990");
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
		
		VersonixMethodsB2C.findSpanAndClick("PAY DEPOSIT");	
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		VersonixMethodsB2C.clickOnCheckBox("25", "svg");
		VersonixMethodsB2C.searchTagNotClickableAndClick("rgb(10, 34, 64)","flt-clip");
		WebWrapper.waitForJavascript(30000, 2000);
		
		//Close Option Created Pop Up return in Summary
		driver.switchTo().frame(1);
		driver.switchTo().frame(0);
		Thread.sleep(2000);
		AdyenAction.setCardNumber("4111111111111111");
		
		driver.switchTo().defaultContent(); // Ritornare al document di default
		driver.switchTo().frame(1);
		driver.switchTo().frame(1);
		AdyenAction.setExpiryDate("0330");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.switchTo().frame(2);
		AdyenAction.setCVV("737");
		
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		AdyenAction.clickOnPayButton();
		Thread.sleep(3000);
		driver.switchTo().defaultContent();
		VersonixMethodsB2C.searchTagNotClickableAndClick("width: 525.333px","flt-clip");
		

		}
	}

