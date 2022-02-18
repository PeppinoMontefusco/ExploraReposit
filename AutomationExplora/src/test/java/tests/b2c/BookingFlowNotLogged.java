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
		WebWrapper.flpClipBookButton();
		
		//SearchCruiseAction.clickOnSubCategorySuiteButton();
		//WebWrapper.waitForJavascript(30000, 2000);
		Thread.sleep(6000);
		
		WebWrapper.findSpanName("First","Claudia");
		WebWrapper.findSpanName("Last","Sorrentino");
		WebWrapper.findSpanName("Date", "01011990");
		WebWrapper.findSpanName("Email", "mario@yopmail.com");
		GuestAction.clickOnContinue("14");
		
		WebWrapper.findSpanName("First","Claudia");
		WebWrapper.findSpanName("Last","Sorrentino");
		WebWrapper.findSpanName("Date", "01011990");
		GuestAction.clickOnContinue("13");
		
		/*GuestAction.clickOnFirstName("11");
		GuestAction.setFirstName();
		GuestAction.clickOnLastName("13");
		GuestAction.setLastName();
		GuestAction.clickOnGender("16");
		GuestAction.clickOnDateOfBirth("18");
		GuestAction.setDOB();
		GuestAction.clickOnEmail("20");
		GuestAction.setEmail();
	    GuestAction.clickOnContinue("14");
		
		Thread.sleep(4000);
		
		GuestAction.clickOnFirstName("10");
		GuestAction.setFirstName();
		GuestAction.clickOnLastName("12");
		GuestAction.setLastName();
		GuestAction.clickOnGender("15");
		GuestAction.clickOnDateOfBirth("17");
		GuestAction.setDOB();
		GuestAction.clickOnContinue("13");*/
		

		
		        
		
		
		
		

	}
	

}
