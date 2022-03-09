package actions.b2c;


import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

import globalSetup.b2c.setupDriver;
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
	
	public static void decreaseAdult() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getDecreaseAdult());
			
	}
	
	
	public static void clickOnSelectAndClose() {
		WebWrapper.clickOn(AdobeSearchCruisePage.getSelectAndCloseButton());
		
	}
	

	public static void clickSearchCruise() {
    	WebWrapper.clickOn(AdobeSearchCruisePage.getSearchCruiseButton());
    }

}
