package tests.b2b.PROD;

import java.awt.AWTException;
import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2b.AdobeHomePageB2BAction;
import actions.b2b.AdobeLoginTravelAdvisorsAction;
import actions.b2b.AdobeRegistrationTravelAdvisorsAction;
import actions.b2b.TouchBizCabinSelectionAction;
import actions.b2b.TouchBizChangeSuiteAction;
import actions.b2b.TouchBizGuestSectionAction;
import actions.b2b.TouchBizSearchCruiseAction;
import actions.b2b.TouchBizSummaryAction;
import actions.b2c.AdobeHomePageAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageB2B;
import pages.b2b.TouchBizGuestSectionPage;
import wrappers.TestListener;
import wrappers.TestManager;

//@Listeners(TestListener.class)

public class PROD_RegisterTravelAdvisor extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
		//test=TestManager.startTest("Form_01", "NewsLetter", "Form");
		startPage.startPage();
		AdobeHomePageAction.clickOnTravelAdvisors();
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(0));
	    driver.close();
	    driver.switchTo().window(tabs1.get(1));
		
	    AdobeLoginTravelAdvisorsAction.clickOnRegisterAsNewAdvisor();
	    AdobeRegistrationTravelAdvisorsAction.selectTitle();
	    AdobeRegistrationTravelAdvisorsAction.setFirstName();
	    AdobeRegistrationTravelAdvisorsAction.setLastName();
	    AdobeRegistrationTravelAdvisorsAction.selectCountryOfResidence();
	    AdobeRegistrationTravelAdvisorsAction.selectCountryCode();
	    AdobeRegistrationTravelAdvisorsAction.setPhone();
	    AdobeRegistrationTravelAdvisorsAction.setAgencyName();
	    AdobeRegistrationTravelAdvisorsAction.setAgencyOnLine();
	    AdobeRegistrationTravelAdvisorsAction.setAgencyAddress();
}
}