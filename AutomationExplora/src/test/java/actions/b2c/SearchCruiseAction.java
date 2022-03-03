package actions.b2c;


import org.openqa.selenium.interactions.Actions;

import globalSetup.b2c.setupDriver;
import pages.b2c.SearchCruisePage;
import wrappers.VersonixMethodsB2C;
import wrappers.WebWrapper;


public class SearchCruiseAction extends setupDriver {
	
	
	public static void clickOnDestination() {
		WebWrapper.clickOn(SearchCruisePage.getDestinationSelect());
		
	}
	
	public static void clickOnGuest() {
		WebWrapper.clickOn(SearchCruisePage.getGuestSelection());
		
	}
	
	public static void increaseChild() {
		WebWrapper.clickOn(SearchCruisePage.getIncreaseChild());
		
	}
	
	
	public static void clickOnSelectAndClose() {
		WebWrapper.clickOn(SearchCruisePage.getSelectAndCloseButton());
		
	}
	

	public static void clickSearchCruise() {
    	WebWrapper.clickOn(SearchCruisePage.getSearchCruiseButton());
    }

}
