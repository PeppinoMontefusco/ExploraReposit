package actions.b2c;

import globalSetup.b2c.setupDriver;
import pages.b2c.HomePage;
import pages.b2c.SearchCruisePage;
import wrappers.WebWrapper;

public class SearchCruiseAction extends setupDriver {
	
	public static void clickOnSearchAndBook() {
    	WebWrapper.clickOn(SearchCruisePage.getFirstBookButton());
    }

}
