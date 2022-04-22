package tests.b2c;

import java.awt.AWTException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2c.AdobeHomePageAction;
import actions.b2c.AdobeLoginAction;
import actions.b2c.AdobeRegistrationAction;
import actions.b2c.AdobeSearchCruiseAction;
import globalSetup.b2c.API;
import globalSetup.b2c.Configuration;
import globalSetup.b2c.ExternalFunction;
import globalSetup.b2c.setupDriver;
import globalSetup.b2c.startPage;
import pages.b2c.AdobeHomePage;
import pages.b2c.AdobeLoginPage;
import wrappers.WebWrapper;

public class MYACC extends setupDriver {
	
	
	@Test
	public static void createUser() throws InterruptedException, UnirestException, AWTException{
		startPage.startPage();
		AdobeHomePageAction.clickOnDestinationQuickSearchButton();
		AdobeHomePageAction.clickOnDestinationQuickSearch();
		AdobeHomePageAction.clickOnSelectAndCloseQuickSearch();
		AdobeHomePageAction.clickOnGuestNumberQuickSearchButton();
		AdobeSearchCruiseAction.decreaseAdult();
		AdobeHomePageAction.clickOnSearchAndBookGuestQuickSearch();
		AdobeHomePageAction.clickOnQuickSearch();
		
		}
	
}
