package tests.b2b.PROD;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

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
import globalSetup.startPageProd;
import pages.b2b.TouchBizGuestSectionPage;
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class PROD_RegisterTravelAdvisor extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
		test=TestManager.startTest("Form_TravelAdvisor", "Register Travel Advisor", "Form");
		startPageProd.startPageProd();
		AdobeHomePageAction.clickOnTravelAdvisors();
		Report.passStep("Click On Travel Advisor");
		WebWrapper.closeAndSwitchTab();
	    AdobeLoginTravelAdvisorsAction.clickOnRegisterAsNewAdvisor();
	    Report.passStep("Click On Register as new Advisor");
	    AdobeRegistrationTravelAdvisorsAction.selectTitle();
	    Report.passStep("Set Title");
	    AdobeRegistrationTravelAdvisorsAction.setFirstName();
	    Report.passStep("Insert First Name");
	    AdobeRegistrationTravelAdvisorsAction.setLastName();
	    Report.passStep("Insert Last Name");
	    AdobeRegistrationTravelAdvisorsAction.selectCountryOfResidence();
	    Report.passStep("Set Country of Residence");
	    AdobeRegistrationTravelAdvisorsAction.selectCountryCode();
	    Report.passStep("Set Country Code");
	    AdobeRegistrationTravelAdvisorsAction.setPhone();
	    Report.passStep("Insert Phone Number");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyName();
	    Report.passStep("Insert Agency Name");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyOnLine();
	    Report.passStep("Set Agency On Line");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyAddress();
	    Report.passStep("Insert Agency Address");
	    AdobeRegistrationTravelAdvisorsAction.setZipCode();
	    Report.passStep("Insert Agency Zip Code");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyCity();
	    Report.passStep("Insert Agency City");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyAddress1();
	    Report.passStep("Insert Agency Address1");
	    String email =AdobeRegistrationTravelAdvisorsAction.setAgencyEmail();
	    Report.passStep("Insert Agency Email");
	    AdobeRegistrationTravelAdvisorsAction.setAgencyConfirmEmail();
	    Report.passStep("Insert Agency Confirm Email");
	    AdobeRegistrationTravelAdvisorsAction.clickOnMarketingFlag();
	    Report.passStep("Set Marketing Flag");
	    AdobeRegistrationTravelAdvisorsAction.clickOnProfilingFlag();
	    Report.passStep("Set Profiling Flag");
	    AdobeRegistrationTravelAdvisorsAction.clickOnSubmitButton();
	    Report.passStep("Click On Submit");
	    AdobeRegistrationTravelAdvisorsAction.clickOnPopupBackButton();
	    Report.passStep("Click On Back Popup Button");
	    empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "Form_TravelAdvisor"),ExcelName.USERS));
}
}