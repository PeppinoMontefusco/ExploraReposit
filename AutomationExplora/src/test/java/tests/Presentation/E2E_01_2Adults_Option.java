package tests.Presentation;

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
import wrappers.ApachePoiMethods;
import wrappers.Report;
import wrappers.TestListener;
import wrappers.TestManager;
import wrappers.WebWrapper;

@Listeners(TestListener.class)

public class E2E_01_2Adults_Option extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
	   test=TestManager.startTest("E2E_01_B2B", "2 Adults - Option", "E2E B2B");
	   ApachePoiMethods.writeCell("B2B: 2 Ad - Option ");
	   startPage.startPage();
	   Report.passStep("Open Homepage");
	   AdobeHomePageAction.clickOnTravelAdvisors();
	   Report.passStep("Click On Travel Advisors");
	   WebWrapper.closeAndSwitchTab();
	   AdobeLoginTravelAdvisorsAction.insertLoginUsernameB2B();
	   Report.passStep("Insert Username");
	   AdobeLoginTravelAdvisorsAction.insertLoginPassowrdB2B();
	   Report.passStep("Insert Password");
	   AdobeLoginTravelAdvisorsAction.clickOnSignInButtonB2B();
	   Report.passStep("Click On Sign In Button");
	   AdobeHomePageB2BAction.clickOnClosePopUp();
	   Report.passStep("Click On Close Pop Up");
	   AdobeHomePageB2BAction.clickOnBookingSuiteButton();
	   Report.passStep("Click On Booking Suite Button");
	   AdobeHomePageB2BAction.clickOnBookNowButton();
	   Report.passStep("Click On Book Now");
	   Thread.sleep(8000);
	   WebWrapper.closeAndSwitchTab();
	   TouchBizSearchCruiseAction.clickOnDestinationButton();
	   Report.passStep("Click On Destination Dropdown");
	   TouchBizSearchCruiseAction.selectRandomDestination();
	   Report.passStep("Select Random Destination");
	   
	   TouchBizSearchCruiseAction.clickOnCloseDestination();
	   Report.passStep("Close Destination Dropdown");
	   TouchBizSearchCruiseAction.ClickAndFilDateTo();
	   Report.passStep("Insert Data To");
	   
	   TouchBizSearchCruiseAction.clickOnGridButton();
	   Report.passStep("Click On Grid Button");
	   TouchBizSearchCruiseAction.clickOnSearchJourney();
	   Report.passStep("Click On Search Journey");
	   Thread.sleep(4000);
	   TouchBizSearchCruiseAction.clickOnRandomCruise();
	   Report.passStep("Select Random Cruise");
	   TouchBizSearchCruiseAction.clickOnContinueButton();
	   Report.passStep("Click On Continue Button");
	   Thread.sleep(2000);
	   TouchBizCabinSelectionAction.clickOnRandomCategory();
	   Report.passStep("Select Random Category");
	   TouchBizCabinSelectionAction.clickOnRandomSubCategory();
	   Report.passStep("Select Random Subcategory");
	   TouchBizCabinSelectionAction.clickOnContinue();
	   Report.passStep("Click On Continue Button");
	   Thread.sleep(2000);
	   TouchBizChangeSuiteAction.clickOnContinue();
	   Report.passStep("Click On Continue Button");
	   Thread.sleep(2000);
	   TouchBizGuestSectionPage.getListOfGuestInfoTextBox();
	   TouchBizGuestSectionAction.setFirstName();
	   Report.passStep("Adult1: Insert First Name");
	   TouchBizGuestSectionAction.setLastName();
	   Report.passStep("Adult1: Insert Last Name");
	   TouchBizGuestSectionAction.setDateOfBirth();
	   Report.passStep("Adult1: Insert Date Of Birth");
	   TouchBizGuestSectionPage.getListOfGuestInfoSelect();
	   TouchBizGuestSectionAction.clickOnResidency();
	   Report.passStep("Click On Residency");
	   TouchBizGuestSectionAction.selectResidencyFirstPax();
	   Report.passStep("Adult1: Insert Residency");
	   TouchBizGuestSectionAction.clickOnNext();
	   Report.passStep("Click On Next");
	   //Adult2
	   TouchBizGuestSectionPage.getListOfGuestInfoTextBox();
	   TouchBizGuestSectionAction.setFirstName();
	   Report.passStep("Adult2: Insert First Name");
	   TouchBizGuestSectionAction.setLastName();
	   Report.passStep("Adult2: Insert Last Name");
	   TouchBizGuestSectionAction.setDateOfBirth();
	   Report.passStep("Adult2: Isert Date Of Birth");
	   TouchBizGuestSectionPage.getListOfGuestInfoSelect();
	   TouchBizGuestSectionAction.clickOnResidency();
	   Report.passStep("Click On Residency");
	   TouchBizGuestSectionAction.selectResidencySecondPax();
	   Report.passStep("Adult2: Insert Residency");
	   TouchBizGuestSectionAction.clickOnSaveAndContinue();
	   Report.passStep("Click On Save And Continue");
	   TouchBizSummaryAction.clickOnStoreButton();
	   Report.passStep("Click On Store");
	   TouchBizSummaryAction.clickOnYesButton();
	   Report.passStep("Click On Yes");
	  
	   
}
}