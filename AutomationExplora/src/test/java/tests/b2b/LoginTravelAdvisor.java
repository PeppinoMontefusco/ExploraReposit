package tests.b2b;

import java.awt.AWTException;
import java.util.ArrayList;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.mashape.unirest.http.exceptions.UnirestException;

import actions.b2b.AdobeHomePageB2BAction;
import actions.b2b.AdobeLoginTravelAdvisorsAction;
import actions.b2b.TouchBizSearchCruiseAction;
import actions.b2c.AdobeHomePageAction;
import globalSetup.setupDriver;
import globalSetup.startPage;
import globalSetup.startPageB2B;
import wrappers.TestListener;
import wrappers.TestManager;

//@Listeners(TestListener.class)

public class LoginTravelAdvisor extends setupDriver {

	@Test
	public static void loginTravelAdvisors() throws AWTException, InterruptedException, UnirestException {
		//test=TestManager.startTest("Form_01", "NewsLetter", "Form");
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
	    AdobeHomePageB2BAction.clickOnBookingSuiteButton();
	    AdobeHomePageB2BAction.clickOnBookNowButton();
	    Thread.sleep(6000);
	    ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
	    driver.switchTo().window(tabs2.get(0));
	    driver.close();
	    driver.switchTo().window(tabs2.get(1));
	   TouchBizSearchCruiseAction.clickOnDestinationButton();
	   TouchBizSearchCruiseAction.selectRandomDestination();
}
}