package actions.b2c;

import pages.b2c.AdobeHomePage;
import wrappers.WebWrapper;

public class AdobeHomePageAction {

	public static void clickOnMyAccount() {
		
		WebWrapper.clickOn(AdobeHomePage.getMyAccountButton());
		
	}

	public static void clickOnMyAccountLogged() {
		
		WebWrapper.clickOn(AdobeHomePage.getMyAccountLoggedButton());
		
	}

	public static void clickOnBookAJourney() throws InterruptedException {
		WebWrapper.clickOn(AdobeHomePage.getBookAJourneyButton());
	}
	
	public static void clickOnQuickSearch() {
		WebWrapper.clickOn(AdobeHomePage.getQuickSearchButton());
	}

}