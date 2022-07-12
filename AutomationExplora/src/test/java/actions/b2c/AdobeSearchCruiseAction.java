package actions.b2c;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import globalSetup.setupDriver;
import pages.b2c.AdobeSearchCruisePage;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;


public class AdobeSearchCruiseAction extends setupDriver {
	
	
	public static void clickOnDestination() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getDestinationSelect());
		
	}
	
	public static void clickOnGuest() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getGuestSelection());
		
	}
	
	public static void increaseChild() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getIncreaseChild());
		
	}
	
	public static void increaseInfant() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getIncreaseInfant());
		
	}
	
	public static void decreaseAdult() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getDecreaseAdult());
			
	}
	
	
	public static void clickOnSelectAndCloseDestination() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getSelectAndCloseDestinationButton());
		
	}
	public static void clickOnSelectAndCloseDateOfTravel() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getSelectAndCloseDateOfTravelButton());
		
	}

	public static void clickSearchCruise() throws InterruptedException {
    	WebWrapper.clickOn(AdobeSearchCruisePage.getSearchCruiseButton());
    }
	
	public static void clickOnDateOfTravelButton() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getDateOfTravelButton());
	}
	public static void clickOnRamdomMonth() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getMonthSelect());
	}
    
}
