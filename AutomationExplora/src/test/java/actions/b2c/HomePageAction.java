package actions.b2c;

import pages.b2c.HomePage;
import wrappers.WebWrapper;

public class HomePageAction {

	public static void clickOnMyAccount() {
		
		WebWrapper.clickOn(HomePage.getMyAccountButton());
		
	}

	public static void clickOnMyAccountLogged() {
		
		WebWrapper.clickOn(HomePage.getMyAccountLoggedButton());
		
	}

	public static void clickOnBookAJourney() throws InterruptedException {
		WebWrapper.clickOn(HomePage.getBookAJourneyButton());
	}

}
