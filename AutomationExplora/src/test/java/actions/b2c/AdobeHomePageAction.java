package actions.b2c;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import globalSetup.setupDriver;
import pages.b2c.AdobeHomePage;
import wrappers.WebWrapper;

public class AdobeHomePageAction extends setupDriver {

	public static void clickOnMyAccount() {
		
		WebWrapper.clickOn(AdobeHomePage.getMyAccountButton());
		
	}

	public static void clickOnMyAccountLogged() throws InterruptedException {
		
		WebWrapper.clickOn(AdobeHomePage.getMyAccountLoggedButton());
		
	}

	public static void clickOnBookAJourney() throws InterruptedException {
		WebWrapper.clickOn(AdobeHomePage.getBookAJourneyButton());
	}
	
	public static void clickOnQuickSearch() {
		WebWrapper.clickOn(AdobeHomePage.getQuickSearchButton());
	}
	
	public static void clickOnJoinUs() {
		WebWrapper.clickOn(AdobeHomePage.joinUsButton());
	}
	
	public static void clickOnTalkToUs() {
		WebWrapper.clickOn(AdobeHomePage.talkWithUs());
	}
	public static void clickOnDestinationQuickSearchButton() {
		WebWrapper.clickOn(AdobeHomePage.getDestinationButton());
	}	
	public static void clickOnDestinationQuickSearch() {
		Actions actions = new Actions(driver);
		 actions.moveToElement(AdobeHomePage.getDestinationSelectQuickSearch()).click().build().perform();
	}	
	public static void clickOnSelectAndCloseQuickSearch() {
		
		Actions actions = new Actions(driver);
		 actions.moveToElement(AdobeHomePage.getSelectAndCloseQuickSearch()).click().build().perform();
		
	}	
	
	public static void clickOnGuestNumberQuickSearchButton() {
		WebWrapper.clickOn(AdobeHomePage.getGuestNumberButton());
}
	
	public static void clickOnSearchAndBookGuestQuickSearch() {
		
		 WebWrapper.clickOn(AdobeHomePage.getSearchAndBookQuickSearchButton());
	}	
	public static void clickOnTravelAdvisors() {
		
		 WebWrapper.clickOn(AdobeHomePage.getTravelAdvisorsButton());
	}	
	
	
}
