package actions.b2b;

import globalSetup.setupDriver;
import pages.b2b.AdobeHomePageB2BPage;
import wrappers.WebWrapper;

public class AdobeHomePageB2BAction extends setupDriver {

	
	public static void clickOnClosePopUp() {
		WebWrapper.clickOn(AdobeHomePageB2BPage.closePopupButton());
		}
	public static void clickOnBookingSuiteButton() {
		WebWrapper.clickOn(AdobeHomePageB2BPage.getBookingSuiteButton());
		}
	public static void clickOnBookNowButton() {
		WebWrapper.clickOn(AdobeHomePageB2BPage.getBookNowButton());
		}
	public static void clickOnContactUs() {
		WebWrapper.clickOn(AdobeHomePageB2BPage.getContactUsButton());
		}
	public static void clickOnLogOut() {
		WebWrapper.clickOn(AdobeHomePageB2BPage.getLogoutButton());
		}
}
