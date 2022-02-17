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
		Thread.sleep(2000);
		SearchCruiseAction.clickOnCategorySuiteButton();
		
		SearchCruiseAction.clickOnSubCategorySuiteButton();
		Thread.sleep(2000);
		GuestAction.clickOnFirstName();
		Thread.sleep(2000);
		GuestAction.setFirstName();
		
		        
		
		
		
		

	}
	

}
