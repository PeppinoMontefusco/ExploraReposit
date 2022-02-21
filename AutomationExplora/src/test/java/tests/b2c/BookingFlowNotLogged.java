package tests.b2c;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import actions.b2c.GuestAction;
import actions.b2c.LoginAction;
import actions.b2c.SearchCruiseAction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import wrappers.WebWrapper;

public class BookingFlowNotLogged extends setupDriver{
	
	@Test
	public static void bookingFlowNotLogged() throws InterruptedException, AWTException {
		startPage.startPage();
		
		
		LoginAction.clickOnBookAJourney();
		SearchCruiseAction.clickOnDestination();
		SearchCruiseAction.clickOnSelectAndClose();
		SearchCruiseAction.clickSearchCruise();
		
		//WebWrapper.zoomOut();
		
		SearchCruiseAction.clickOnFirstBookButton();
		
		//WebWrapper.zoomOut();
		Thread.sleep(3000);
		SearchCruiseAction.clickOnCategorySuiteButton();
		Thread.sleep(3000);
		WebWrapper.flpClipSearchClick("width: 106.8px", "flt-clip");
		
		//SearchCruiseAction.clickOnSubCategorySuiteButton();
		//WebWrapper.waitForJavascript(30000, 2000);
		Thread.sleep(6000);
		
		WebWrapper.findSpanCompile("First","Test");
		WebWrapper.findSpanCompile("Last","Automation");
		WebWrapper.findSpanCompile("Date", "01011990");
		WebWrapper.findSpanCompile("Email", "test@yopmail.com");
		Thread.sleep(2000);
		//GuestAction.clickOnContinue("14");
		WebWrapper.flpClipSearchClick("height: 48px", "flt-clip");
		
		WebWrapper.findSpanCompile("First","test");
		WebWrapper.findSpanCompile("Last","Automationdue");
		WebWrapper.findSpanCompile("Date", "01011990");
		//GuestAction.clickOnContinue("13");
		WebWrapper.flpClipSearchClick("height: 48px", "flt-clip");
		Thread.sleep(3000);
		
		WebWrapper.flpClipSearchClickNotClickable("width: 111.8px","flt-clip");
		
		Thread.sleep(3000);
		
		WebWrapper.findSpanClick("FREE");	
		
		WebWrapper.clickOnCheckBox("25", "svg");
		WebWrapper.clickOnCheckBox("25", "svg");
		WebWrapper.flpClipSearchClickNotClickable("rgb(10, 34, 64)","flt-clip");
		
		WebWrapper.flpClipSearchClickNotClickable("width: 86.8px","flt-clip");

		
		        
		
		
		
		

	}
	

}
