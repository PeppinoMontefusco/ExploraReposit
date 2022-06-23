package actions.b2b;

import globalSetup.Configuration;
import globalSetup.setupDriver;
import pages.b2b.AdobeLoginTravelAdvisorsPage;
import wrappers.WebWrapper;

public class AdobeLoginTravelAdvisorsAction extends setupDriver {

	public static void insertLoginUsernameB2B() {
		WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getUsernameTravelAdvisors(),
				new Configuration().usernameB2B());

	}

	public static void insertLoginPassowrdB2B() throws InterruptedException {
		WebWrapper.typeInField(AdobeLoginTravelAdvisorsPage.getPasswordTravelAdvisors(),
				new Configuration().passwordB2B());
		//WebWrapper.clickOnElementNotClickable(AdobeLoginTravelAdvisorsPage.getPasswordTravelAdvisors());
	}

	public static void clickOnSignInButtonB2B() {
		WebWrapper.clickOn(AdobeLoginTravelAdvisorsPage.getSignInTravelAdvisors());
	}
}
