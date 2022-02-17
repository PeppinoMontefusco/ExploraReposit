package actions.b2c;


import org.openqa.selenium.interactions.Actions;

import globalSetup.b2c.setupDriver;
import pages.b2c.SearchCruisePage;
import wrappers.WebWrapper;


public class SearchCruiseAction extends setupDriver {
	
	
	public static void clickOnDestination() {
		WebWrapper.clickOn(SearchCruisePage.getDestinationSelect());
		
	}
	
	public static void clickOnSelectAndClose() {
		WebWrapper.clickOn(SearchCruisePage.getSelectAndCloseButton());
		
	}
	

	public static void clickSearchCruise() {
    	WebWrapper.clickOn(SearchCruisePage.getSearchCruiseButton());
    }
	
	
	public static void clickOnFirstBookButton() throws InterruptedException {
		WebWrapper.waitForJavascript(30000, 3000);
		
		WebWrapper.clickOn(WebWrapper.getElementInShadowRoot("flt-clip", "11"));  
    }
	
	public static void clickOnCategorySuiteButton() throws InterruptedException {
		 
		WebWrapper.clickOnElementNotClickable(WebWrapper.getElementInShadowRoot("flt-clip", "12"));
	}
	
	public static void clickOnSubCategorySuiteButton() throws InterruptedException {
		
		WebWrapper.clickOnElementNotClickable(WebWrapper.getElementInShadowRoot("flt-clip", "18"));
	}

}
