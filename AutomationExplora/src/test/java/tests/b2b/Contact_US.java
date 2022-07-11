package tests.b2b;

import java.awt.AWTException;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2b.AdobeContactUsAction;
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
import wrappers.ApachePoiStyles;
import wrappers.ExcelName;
import wrappers.OutputLine;
import wrappers.TestListener;
import wrappers.TestManager;

//@Listeners(TestListener.class)

public class Contact_US extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
		test=TestManager.startTest("Contact Us", "Contact Us", "Form");
		startPage.startPage();
		AdobeHomePageAction.clickOnTravelAdvisors();
		ArrayList<String> tabs1 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs1.get(0));
	    driver.close();
	    driver.switchTo().window(tabs1.get(1));
		
	    AdobeLoginTravelAdvisorsAction.insertLoginUsernameB2B();
	    AdobeLoginTravelAdvisorsAction.insertLoginPassowrdB2B();
	    AdobeLoginTravelAdvisorsAction.clickOnSignInButtonB2B();
	    AdobeHomePageB2BAction.clickOnClosePopUp();
	    AdobeHomePageB2BAction.clickOnContactUs();
	    AdobeContactUsAction.setFirstName();
	    AdobeContactUsAction.setLastName();
	    String email =AdobeContactUsAction.setEmail();
	    AdobeContactUsAction.selectCountryCode();
	    AdobeContactUsAction.setPhone();
	    AdobeContactUsAction.setTopic();
	    AdobeContactUsAction.setMessage();
	    AdobeContactUsAction.clickOnSend();
	   
	    AdobeContactUsAction.clickOnBack();
	    empdata.add(new OutputLine ( ApachePoiStyles.RESULTS,List.of(email, "Contact Us"),ExcelName.USERS));
		
	}
}
