package actions.b2c;

import pages.b2c.AdobeSearchCruisePage;
import pages.b2c.AdobeTalkWithUsPage;
import wrappers.WebWrapper;

public class AdobeTalkWithUsAction {
	
	public static void clickOnRequestBrochureButton() {
		WebWrapper.clickOn(AdobeTalkWithUsPage.getRequestABrochureButton());
		
	}
	public static void clickOnRequestQuoteButton() {
		WebWrapper.clickOn(AdobeTalkWithUsPage.getRequestAQuoteButton());
		
	}

}
